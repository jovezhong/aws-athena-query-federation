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

public class CountryFlag {
    private final String emoji;
    private final String unicode;

    public CountryFlag(
            String emoji,
            String unicode
    ) {
        this.emoji = emoji;
        this.unicode = unicode;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getUnicode() {
        return unicode;
    }

    @Override
    public String toString() {
        return "CountryFlag{" +
                "emoji='" + emoji + '\'' +
                ",unicode='" + unicode + '\'' +
                '}';
    }
}
