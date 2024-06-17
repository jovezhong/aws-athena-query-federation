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
package io.ipinfo.api.request;

import io.ipinfo.api.errors.ErrorResponseException;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.ASNResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ASNRequest extends BaseRequest<ASNResponse> {
    private final static String URL_FORMAT = "https://ipinfo.io/%s";
    private final String asn;

    public ASNRequest(OkHttpClient client, String token, String asn) {
        super(client, token);
        this.asn = asn;
    }

    @Override
    public ASNResponse handle() throws RateLimitedException {
        String url = String.format(URL_FORMAT, asn);
        Request.Builder request = new Request.Builder().url(url).get();

        try (Response response = handleRequest(request)) {
            if (response == null || response.body() == null) {
                return null;
            }

            try {
                return gson.fromJson(response.body().string(), ASNResponse.class);
            } catch (Exception ex) {
                throw new ErrorResponseException(ex);
            }
        }
    }
}
