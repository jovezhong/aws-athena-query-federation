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


public class ASN {
    private final String asn;
    private final String name;
    private final String domain;
    private final String route;
    private final String type;

    public ASN(
            String asn,
            String name,
            String domain,
            String route,
            String type
    ) {
        this.asn = asn;
        this.name = name;
        this.domain = domain;
        this.route = route;
        this.type = type;
    }

    public String getAsn() {
        return asn;
    }

    public String getName() {

        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getRoute() {
        return route;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ASN{" +
                "asn='" + asn + '\'' +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", route='" + route + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
