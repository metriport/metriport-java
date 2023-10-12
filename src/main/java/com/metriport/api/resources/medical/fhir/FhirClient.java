/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.fhir;

import com.metriport.api.core.ApiError;
import com.metriport.api.core.ClientOptions;
import com.metriport.api.core.ObjectMappers;
import com.metriport.api.core.RequestOptions;
import com.metriport.api.resources.medical.fhir.requests.CountPatientConsolidateData;
import com.metriport.api.resources.medical.fhir.requests.GetPatientConsolidatedData;
import com.metriport.api.resources.medical.fhir.types.ConsolidatedCountResponse;
import com.metriport.api.resources.medical.fhir.types.GetConsolidatedQueryStatusResponse;
import com.metriport.api.resources.medical.fhir.types.StartConsolidatedQueryResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FhirClient {
    protected final ClientOptions clientOptions;

    public FhirClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Trigger a consolidated data query for the given patient
     */
    public StartConsolidatedQueryResponse startConsolidatedQuery(String id) {
        return startConsolidatedQuery(id, GetPatientConsolidatedData.builder().build());
    }

    /**
     * Trigger a consolidated data query for the given patient
     */
    public StartConsolidatedQueryResponse startConsolidatedQuery(
            String id, GetPatientConsolidatedData request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("patient")
                .addPathSegment(id)
                .addPathSegments("consolidated/query");
        if (request.getResources().isPresent()) {
            httpUrl.addQueryParameter("resources", request.getResources().get());
        }
        if (request.getDateFrom().isPresent()) {
            httpUrl.addQueryParameter("dateFrom", request.getDateFrom().get());
        }
        if (request.getDateTo().isPresent()) {
            httpUrl.addQueryParameter("dateTo", request.getDateTo().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), StartConsolidatedQueryResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Trigger a consolidated data query for the given patient
     */
    public StartConsolidatedQueryResponse startConsolidatedQuery(String id, GetPatientConsolidatedData request) {
        return startConsolidatedQuery(id, request, null);
    }

    /**
     * Get the status of querying for patient's consolidated data.
     */
    public GetConsolidatedQueryStatusResponse getConsolidatedQueryStatus(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("patient")
                .addPathSegment(id)
                .addPathSegments("consolidated/query")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), GetConsolidatedQueryStatusResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the status of querying for patient's consolidated data.
     */
    public GetConsolidatedQueryStatusResponse getConsolidatedQueryStatus(String id) {
        return getConsolidatedQueryStatus(id, null);
    }

    /**
     * Get a count of a Patient's data per resource.
     */
    public ConsolidatedCountResponse countPatientData(String id) {
        return countPatientData(id, CountPatientConsolidateData.builder().build());
    }

    /**
     * Get a count of a Patient's data per resource.
     */
    public ConsolidatedCountResponse countPatientData(
            String id, CountPatientConsolidateData request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("patient")
                .addPathSegment(id)
                .addPathSegments("consolidated/count");
        if (request.getResources().isPresent()) {
            httpUrl.addQueryParameter("resources", request.getResources().get());
        }
        if (request.getDateFrom().isPresent()) {
            httpUrl.addQueryParameter("dateFrom", request.getDateFrom().get());
        }
        if (request.getDateTo().isPresent()) {
            httpUrl.addQueryParameter("dateTo", request.getDateTo().get());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ConsolidatedCountResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get a count of a Patient's data per resource.
     */
    public ConsolidatedCountResponse countPatientData(String id, CountPatientConsolidateData request) {
        return countPatientData(id, request, null);
    }
}
