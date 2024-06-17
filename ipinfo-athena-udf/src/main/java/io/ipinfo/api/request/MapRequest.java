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
import io.ipinfo.api.model.MapResponse;
import okhttp3.*;

import java.util.List;

public class MapRequest extends BaseRequest<MapResponse> {
    private final static String URL = "https://ipinfo.io/tools/map";
    private final List<String> ips;

    public MapRequest(OkHttpClient client, String token, List<String> ips) {
        super(client, token);
        this.ips = ips;
    }

    @Override
    public MapResponse handle() throws RateLimitedException {
        String jsonIpList = gson.toJson(ips);
        RequestBody requestBody = RequestBody.create(null, jsonIpList);
        Request.Builder request = new Request.Builder().url(URL).post(requestBody);

        try (Response response = handleRequest(request)) {
            if (response == null || response.body() == null) {
                return null;
            }

            try {
                return gson.fromJson(response.body().string(), MapResponse.class);
            } catch (Exception ex) {
                throw new ErrorResponseException(ex);
            }
        }
    }
}
