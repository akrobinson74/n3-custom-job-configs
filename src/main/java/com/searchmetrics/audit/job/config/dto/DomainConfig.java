package com.searchmetrics.audit.job.config.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.EnumUtils.isValidEnum;
@Table(value = "domainConfigs")
public class DomainConfig {
    public enum ProxyType {NONE, DE, US}
    public enum UserAgentType {
        SEARCHMETRICSBOT,
        GOOGLEBOT
    }
    @PrimaryKeyColumn(
        name = "domain",
        ordinal = 0,
        type = PrimaryKeyType.PARTITIONED)
    private String domain;
    @Column
    private Boolean exactMatch = true;
    @Column
    private Boolean calculateBaseURL = false;
    @Column
    private List<String> customHeaders;
    @Column
    private Boolean noCanonical = false;
    @Column
    private Boolean noCookies = false;
    @Column
    private String proxyType = ProxyType.NONE.name();
    @Column
    private Integer readTimeout = 20;
    @Column
    private String userAgent = UserAgentType.SEARCHMETRICSBOT.name();
    @Column
    private List<String> notes;

    @JsonCreator
    public DomainConfig(
        @JsonProperty("domain") final String domain,
        @JsonProperty("exactMatch") final Boolean exactMatch,
        @JsonProperty("calculateBaseURL") final Boolean calculateBaseURL,
        @JsonProperty("customHeaders") final List<String> customHeaders,
        @JsonProperty("noCanonical") final Boolean noCanonical,
        @JsonProperty("noCookies") final Boolean noCookies,
        @JsonProperty("notes") final List<String> notes,
        @JsonProperty("proxyType") final String proxyType,
        @JsonProperty("readTimeout") final Integer readTimeout,
        @JsonProperty("userAgent") final String userAgent) {
        checkNotNull(domain);
        this.domain = domain;

        if (null != exactMatch)
            this.exactMatch = exactMatch;

        if (null != calculateBaseURL)
            this.calculateBaseURL = calculateBaseURL;

        if (null != customHeaders)
            this.customHeaders = customHeaders;

        if (null != noCanonical)
            this.noCanonical = noCanonical;

        if (null != noCookies)
            this.noCookies = noCookies;

        if (null != proxyType && isValidEnum(ProxyType.class, proxyType)) {
            this.proxyType = proxyType;
        }
        if (null != readTimeout)
            this.readTimeout = readTimeout;

        if (null != userAgent && isValidEnum(UserAgentType.class, userAgent)) {
            this.userAgent = userAgent;
        }

        if (null != notes)
            this.notes = notes;
    }
    @JsonProperty
    public String getDomain() {
        return domain;
    }
    @JsonProperty
    public Boolean getExactMatch() {
        return exactMatch;
    }
    @JsonProperty
    public Boolean getCalculateBaseURL() {
        return calculateBaseURL;
    }
    @JsonProperty
    public List<String> getCustomHeaders() {
        return customHeaders;
    }
    @JsonProperty
    public Boolean getNoCanonical() {
        return noCanonical;
    }
    @JsonProperty
    public Boolean getNoCookies() {
        return noCookies;
    }
    @JsonProperty
    public String getProxyType() {
        return proxyType;
    }
    @JsonProperty
    public Integer getReadTimeout() {
        return readTimeout;
    }
    @JsonProperty
    public String getUserAgent() {
        return userAgent;
    }
    @JsonProperty
    public List<String> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        DomainConfig that = (DomainConfig) o;

        if (! domain.equals(that.domain))
            return false;
        if (! exactMatch.equals(that.exactMatch))
            return false;
        if (! calculateBaseURL.equals(that.calculateBaseURL))
            return false;
        if (customHeaders != null ? ! customHeaders.equals(that.customHeaders) : that.customHeaders != null)
            return false;
        if (! noCanonical.equals(that.noCanonical))
            return false;
        if (! noCookies.equals(that.noCookies))
            return false;
        if (! proxyType.equals(that.proxyType))
            return false;
        if (! readTimeout.equals(that.readTimeout))
            return false;
        if (! userAgent.equals(that.userAgent))
            return false;
        return notes != null ? notes.equals(that.notes) : that.notes == null;
    }

    @Override
    public int hashCode() {
        int result = domain.hashCode();
        result = 31 * result + exactMatch.hashCode();
        result = 31 * result + calculateBaseURL.hashCode();
        result = 31 * result + (customHeaders != null ? customHeaders.hashCode() : 0);
        result = 31 * result + noCanonical.hashCode();
        result = 31 * result + noCookies.hashCode();
        result = 31 * result + proxyType.hashCode();
        result = 31 * result + readTimeout.hashCode();
        result = 31 * result + userAgent.hashCode();
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DomainConfig{" +
                "domain='" + domain + '\'' +
                ", exactMatch=" + exactMatch +
                ", calculateBaseURL=" + calculateBaseURL +
                ", customHeaders=" + customHeaders +
                ", noCanonical=" + noCanonical +
                ", noCookies=" + noCookies +
                ", proxyType='" + proxyType + '\'' +
                ", readTimeout=" + readTimeout +
                ", userAgent='" + userAgent + '\'' +
                ", notes=" + notes +
                '}';
    }
}