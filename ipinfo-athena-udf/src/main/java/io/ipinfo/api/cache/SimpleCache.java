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
package io.ipinfo.api.cache;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

public class SimpleCache implements Cache {
    private final Duration duration;
    private final Map<String, Payload> cache = new HashMap<>();

    public SimpleCache(Duration duration) {
        this.duration = duration;
    }

    @Override
    public Object get(String key) {
        Payload payload = cache.get(key);
        if (payload == null || payload.hasExpired()) {
            return null;
        }

        return payload.data;
    }

    @Override
    public boolean set(String key, Object val) {
        cache.put(key, new Payload(val, duration));
        return true;
    }

    @Override
    public boolean clear() {
        cache.clear();
        return true;
    }

    private static class Payload {
        final Object data;
        final Instant creation;
        final Duration expiration;

        Payload(Object data, Duration duration) {
            this.data = data;
            creation = Instant.now();
            this.expiration = duration;
        }

        public boolean hasExpired() {
            long time = expiration
                    .addTo(creation)
                    .getLong(ChronoField.INSTANT_SECONDS);
            long now = System.currentTimeMillis();
            return now <= time;
        }

        public Object getData() {
            return data;
        }
    }
}
