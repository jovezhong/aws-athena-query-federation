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

public class MapResponse {
    private final String reportUrl;
    private final String status;

    public MapResponse(
            String reportUrl,
            String status
    ) {
        this.reportUrl = reportUrl;
        this.status = status;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "MapResponse{" +
                "reportUrl='" + reportUrl + '\'' +
                ", status=" + status +
                '}';
    }
}
