/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.document;

import com.metriport.api.core.ApiError;
import com.metriport.api.core.ClientOptions;
import com.metriport.api.core.ObjectMappers;
import com.metriport.api.core.RequestOptions;
import com.metriport.api.resources.medical.document.requests.GetDocumentQueryStatusRequest;
import com.metriport.api.resources.medical.document.requests.GetDocumentUrlRequest;
import com.metriport.api.resources.medical.document.requests.ListDocumentsRequest;
import com.metriport.api.resources.medical.document.requests.StartDocumentQueryRequest;
import com.metriport.api.resources.medical.document.types.DocumentQuery;
import com.metriport.api.resources.medical.document.types.DocumentUrl;
import com.metriport.api.resources.medical.document.types.ListDocumentsResponse;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DocumentClient {
    protected final ClientOptions clientOptions;

    public DocumentClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Triggers a document query for the specified patient across HIEs.
     * <p>When executed, this endpoint triggers an asynchronous document query across HIEs.
     * This is a two step process where the documents will first be downloaded from
     * the respective HIE and, if they are C-CDA/XML, then converted to FHIR.</p>
     * <p>Each process (download, conversion) will contain its own <code>total</code> and <code>status</code>
     * as well as the count for <code>successful</code> operations and <code>errors</code>.</p>
     * <p>When the asynchronous document query finishes, it stores new/updated document
     * references for future requests and updates the status of download to <code>completed</code>.
     * Meanwhile, in the background, files will be converted and the convert count will be
     * incremented. Once all documents have been converted it too will be marked as <code>completed</code>.</p>
     * <p>If there's no document to be converted, the total will be set to zero and
     * the status to <code>completed</code>.</p>
     */
    public DocumentQuery startQuery(StartDocumentQueryRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("medical/v1/document")
                .addPathSegments("query");
        httpUrl.addQueryParameter("patientId", request.getPatientId());
        httpUrl.addQueryParameter("facilityId", request.getFacilityId());
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), DocumentQuery.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Triggers a document query for the specified patient across HIEs.
     * <p>When executed, this endpoint triggers an asynchronous document query across HIEs.
     * This is a two step process where the documents will first be downloaded from
     * the respective HIE and, if they are C-CDA/XML, then converted to FHIR.</p>
     * <p>Each process (download, conversion) will contain its own <code>total</code> and <code>status</code>
     * as well as the count for <code>successful</code> operations and <code>errors</code>.</p>
     * <p>When the asynchronous document query finishes, it stores new/updated document
     * references for future requests and updates the status of download to <code>completed</code>.
     * Meanwhile, in the background, files will be converted and the convert count will be
     * incremented. Once all documents have been converted it too will be marked as <code>completed</code>.</p>
     * <p>If there's no document to be converted, the total will be set to zero and
     * the status to <code>completed</code>.</p>
     */
    public DocumentQuery startQuery(StartDocumentQueryRequest request) {
        return startQuery(request, null);
    }

    /**
     * Returns the document query status for the specified patient.
     * Can be used in to check the progress when the final status
     * of the document query is taking longer than expected.
     * See more on <a href="/medical-api/api-reference/document/start-document-query">Start Document Query</a>.
     */
    public DocumentQuery getQueryStatus(GetDocumentQueryStatusRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("medical/v1/document")
                .addPathSegments("query");
        httpUrl.addQueryParameter("patientId", request.getPatientId());
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), DocumentQuery.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the document query status for the specified patient.
     * Can be used in to check the progress when the final status
     * of the document query is taking longer than expected.
     * See more on <a href="/medical-api/api-reference/document/start-document-query">Start Document Query</a>.
     */
    public DocumentQuery getQueryStatus(GetDocumentQueryStatusRequest request) {
        return getQueryStatus(request, null);
    }

    /**
     * Lists all Documents that can be retrieved for a Patient.
     * This endpoint returns the document references available
     * at Metriport which are associated with the given Patient.
     * <p>To start a new document query, see the <a href="/api-reference/medical/document/start-query">Start Document Query endpoint</a>.</p>
     */
    public ListDocumentsResponse list(ListDocumentsRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("medical/v1/document");
        httpUrl.addQueryParameter("patientId", request.getPatientId());
        httpUrl.addQueryParameter("facilityId", request.getFacilityId());
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), ListDocumentsResponse.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Lists all Documents that can be retrieved for a Patient.
     * This endpoint returns the document references available
     * at Metriport which are associated with the given Patient.
     * <p>To start a new document query, see the <a href="/api-reference/medical/document/start-query">Start Document Query endpoint</a>.</p>
     */
    public ListDocumentsResponse list(ListDocumentsRequest request) {
        return list(request, null);
    }

    /**
     * Gets a presigned URL for downloading the specified document.
     * This endpoint returns a URL which you can use to download
     * the specified document and/or convert using the file name
     * provided from the <a href="/api-reference/medical/document/list">List Documents</a> endpoint.
     */
    public DocumentUrl getUrl(GetDocumentUrlRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("medical/v1/document")
                .addPathSegments("downloadUrl");
        httpUrl.addQueryParameter("fileName", request.getFileName());
        if (request.getConversionType().isPresent()) {
            httpUrl.addQueryParameter(
                    "conversionType", request.getConversionType().get().toString());
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), DocumentUrl.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a presigned URL for downloading the specified document.
     * This endpoint returns a URL which you can use to download
     * the specified document and/or convert using the file name
     * provided from the <a href="/api-reference/medical/document/list">List Documents</a> endpoint.
     */
    public DocumentUrl getUrl(GetDocumentUrlRequest request) {
        return getUrl(request, null);
    }
}
