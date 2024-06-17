/*-
 * #%L
 * ipinfo-athena-udf
 * %%
 * Copyright (C) 2019 - 2024 Amazon Web Services
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.ipinfo.api.model;

import io.ipinfo.api.context.Context;

public class IPResponse {
    private final String ip;
    private final String hostname;
    private final boolean bogon;
    private final boolean anycast;
    private final String city;
    private final String region;
    private final String country;
    private final String loc;
    private final String org;
    private final String postal;
    private final String timezone;
    private final ASN asn;
    private final Company company;
    private final Carrier carrier;
    private final Privacy privacy;
    private final Abuse abuse;
    private final Domains domains;
    private transient Context context;

    public IPResponse(
            String ip,
            String hostname,
            boolean bogon,
            boolean anycast,
            String city,
            String region,
            String country,
            String loc,
            String org,
            String postal,
            String timezone,
            ASN asn,
            Company company,
            Carrier carrier,
            Privacy privacy,
            Abuse abuse,
            Domains domains
    ) {
        this.ip = ip;
        this.hostname = hostname;
        this.bogon = bogon;
        this.anycast = anycast;
        this.city = city;
        this.region = region;
        this.country = country;
        this.loc = loc;
        this.postal = postal;
        this.timezone = timezone;
        this.org = org;
        this.asn = asn;
        this.company = company;
        this.carrier = carrier;
        this.privacy = privacy;
        this.abuse = abuse;
        this.domains = domains;
    }

    public IPResponse(
        String ip,
        boolean bogon
    ) {
        this(ip, null, bogon, false,  null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Set by the library for extra utility functions
     *
     * @param context for country information
     */
    public void setContext(Context context) {
        this.context = context;
    }

    public String getIp() {
        return ip;
    }

    public String getHostname() {
        return hostname;
    }

    public boolean getBogon() {
        return bogon;
    }

    public boolean getAnycast() {
        return anycast;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountryCode() {
        return country;
    }

    public String getCountryName() {
        return context.getCountryName(getCountryCode());
    }

    public Boolean isEU() {
        return context.isEU(getCountryCode());
    }

    public CountryFlag getCountryFlag() {
        return context.getCountryFlag(getCountryCode());
    }

    public String getCountryFlagURL() {
        return context.getCountryFlagURL(getCountryCode());
    }

    public CountryCurrency getCountryCurrency() {
        return context.getCountryCurrency(getCountryCode());
    }

    public Continent getContinent() {
        return context.getContinent(getCountryCode());
    }

    public String getLocation() {
        return loc;
    }

    public String getLatitude() {
        try {
            return loc.split(",")[0];
        } catch (Exception ex) {
            return null;
        }
    }

    public String getLongitude() {
        try {
            return loc.split(",")[1];
        } catch (Exception ex) {
            return null;
        }
    }

    public String getOrg() {
        return org;
    }

    public String getPostal() {
        return postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public ASN getAsn() {
        return asn;
    }

    public Company getCompany() {
        return company;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public Abuse getAbuse() {
        return abuse;
    }

    public Domains getDomains() {
        return domains;
    }

    @Override
    public String toString() {
        return (bogon ?
                "IPResponse{" +
                    "ip='" + ip + '\'' +
                    ", bogon='" + bogon + '\'' +
                "}"
                :
                "IPResponse{" +
                    "ip='" + ip + '\'' +
                    ", hostname='" + hostname + '\'' +
                    ", anycast=" + anycast +
                    ", city='" + city + '\'' +
                    ", region='" + region + '\'' +
                    ", country='" + country + '\'' +
                    ", loc='" + loc + '\'' +
                    ", org='" + org + '\'' +
                    ", postal='" + postal + '\'' +
                    ", timezone='" + timezone + '\'' +
                    ", asn=" + asn +
                    ", company=" + company +
                    ", carrier=" + carrier +
                    ", privacy=" + privacy +
                    ", abuse=" + abuse +
                    ", domains=" + domains +
                '}');
    }
}
