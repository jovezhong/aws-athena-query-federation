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

import com.google.gson.Gson;
import io.ipinfo.api.errors.ErrorResponseException;
import io.ipinfo.api.errors.RateLimitedException;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class BaseRequest<T> {
    protected final static Gson gson = new Gson();
    private final OkHttpClient client;
    private final String token;

    protected BaseRequest(OkHttpClient client, String token) {
        this.client = client;
        this.token = token;
    }

    public abstract T handle() throws RateLimitedException;

    public Response handleRequest(Request.Builder request) throws RateLimitedException {
        request
                .addHeader("Authorization", Credentials.basic(token, ""))
                .addHeader("user-agent", "IPinfoClient/Java/3.0.0")
                .addHeader("Content-Type", "application/json");

        Response response;

        try {
            response = client.newCall(request.build()).execute();
        } catch (Exception e) {
            throw new ErrorResponseException(e);
        }

        // Sanity check
        if (response == null) {
            return null;
        }

        if (response.code() == 429) {
            throw new RateLimitedException();
        }

        return response;
    }
}

