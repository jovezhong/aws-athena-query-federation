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

public class Abuse {
    private final String address;
    private final String country;
    private final String email;
    private final String name;
    private final String network;
    private final String phone;

    public Abuse(
            String address,
            String country,
            String email,
            String name,
            String network,
            String phone
    ) {
        this.address = address;
        this.country = country;
        this.email = email;
        this.name = name;
        this.network = network;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNetwork() {
        return network;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Abuse{" +
                "address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", network='" + network + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
