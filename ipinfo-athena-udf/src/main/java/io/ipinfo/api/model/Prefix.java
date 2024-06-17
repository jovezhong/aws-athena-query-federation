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

public class Prefix {
    private final String netblock;
    private final String id;
    private final String name;
    private final String country;
    private final String size;
    private final String status;
    private final String domain;

    public Prefix(
            String netblock,
            String id,
            String name,
            String country,
            String size,
            String status,
            String domain
    ) {
        this.netblock = netblock;
        this.id = id;
        this.name = name;
        this.country = country;
        this.size = size;
        this.status = status;
        this.domain = domain;
    }

    public String getNetblock() {
        return netblock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getSize() {
        return size;
    }

    public String getStatus() {
        return status;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return "Prefix{" +
                "netblock='" + netblock + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", size='" + size + '\'' +
                ", status='" + status + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
