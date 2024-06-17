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

public class Privacy {
    private final boolean vpn;
    private final boolean proxy;
    private final boolean tor;
    private final boolean relay;
    private final boolean hosting;
    private final String service;

    public Privacy(
            boolean vpn,
            boolean proxy,
            boolean tor,
            boolean relay,
            boolean hosting,
            String service
    ) {
        this.vpn = vpn;
        this.proxy = proxy;
        this.tor = tor;
        this.relay = relay;
        this.hosting = hosting;
        this.service = service;
    }

    public boolean getVpn() {
        return vpn;
    }

    public boolean getProxy() {
        return proxy;
    }

    public boolean getTor() {
        return tor;
    }

    public boolean getRelay() {
        return relay;
    }

    public boolean getHosting() {
        return hosting;
    }

    public String getService() {
        return service;
    }

    @Override
    public String toString() {
        return "Privacy{" +
                "vpn=" + vpn +
                ", proxy=" + proxy +
                ", tor=" + tor +
                ", relay=" + relay +
                ", hosting=" + hosting +
                ", service=" + service +
                '}';
    }
}
