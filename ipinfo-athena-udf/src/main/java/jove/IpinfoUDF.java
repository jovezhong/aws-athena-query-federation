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
package jove;

import com.amazonaws.athena.connector.lambda.handlers.UserDefinedFunctionHandler;
import io.ipinfo.api.IPinfo;
import io.ipinfo.api.cache.SimpleCache;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;
import java.time.Duration;

public class IpinfoUDF extends UserDefinedFunctionHandler {

    private static final String SOURCE_TYPE = "Jove";

    private IPinfo ipInfo;

    public IpinfoUDF() {
        super(SOURCE_TYPE);
        ipInfo = new IPinfo.Builder()
            .setToken(System.getenv("IPINFO_TOKEN"))
            .setCache(new SimpleCache(Duration.ofDays(5)))
            .build();
    }

    String toJson(IPResponse response) {
        return (
            response.getBogon()
                ? "{" +
                "\"ip\":\"" +
                response.getIp() +
                '\"' +
                ", \"bogon\":\"" +
                response.getBogon() +
                '\"' +
                "}"
                : "{" +
                "\"ip\":\"" +
                response.getIp() +
                '\"' +
                ", \"hostname\":\"" +
                response.getHostname() +
                '\"' +
                ", \"anycast\":\"" +
                response.getAnycast() +
                "\", \"city\":\"" +
                response.getCity() +
                '\"' +
                ", \"region\":\"" +
                response.getRegion() +
                '\"' +
                ", \"country\":\"" +
                response.getCountryName() +
                '\"' +
                ", \"loc\":\"" +
                response.getLocation() +
                '\"' +
                ", \"org\":\"" +
                response.getOrg() +
                '\"' +
                ", \"postal\":\"" +
                response.getPostal() +
                '\"' +
                ", \"timezone\":\"" +
                response.getTimezone() +
                '\"' +
                ", \"asn\":\"" +
                response.getAsn() +
                "\", \"company\":\"" +
                response.getCompany() +
                "\", \"carrier\":\"" +
                response.getCarrier() +
                "\", \"privacy\":\"" +
                response.getPrivacy() +
                "\", \"abuse\":\"" +
                response.getAbuse() +
                "\", \"domains\":\"" +
                response.getDomains() +
                "\"}"
        );
    }

    /**
     * ipinfo
     *
     * @param input ip
     * @return the ip info
     */
    public String ip_lookup(String input) throws RateLimitedException {
        IPResponse response = ipInfo.lookupIP(input);

        return toJson(response);
    }

    public static void main(String[] args) throws RateLimitedException {
        System.out.println(new IpinfoUDF().ip_lookup("8.8.8.8"));
    }
}
