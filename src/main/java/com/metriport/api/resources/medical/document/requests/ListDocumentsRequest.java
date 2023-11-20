/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.document.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.metriport.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ListDocumentsRequest.Builder.class)
public final class ListDocumentsRequest {
    private final String patientId;

    private final String facilityId;

    private final Optional<String> dateFrom;

    private final Optional<String> dateTo;

    private final Map<String, Object> additionalProperties;

    private ListDocumentsRequest(
            String patientId,
            String facilityId,
            Optional<String> dateFrom,
            Optional<String> dateTo,
            Map<String, Object> additionalProperties) {
        this.patientId = patientId;
        this.facilityId = facilityId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the Patient for which to list available Documents.
     */
    @JsonProperty("patientId")
    public String getPatientId() {
        return patientId;
    }

    /**
     * @return The ID of the Facility where the patient is receiving care.
     */
    @JsonProperty("facilityId")
    public String getFacilityId() {
        return facilityId;
    }

    /**
     * @return The start date (inclusive) for which to filter returned documents - formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided, no start date filter will be applied.
     */
    @JsonProperty("dateFrom")
    public Optional<String> getDateFrom() {
        return dateFrom;
    }

    /**
     * @return The end date (inclusive) for which to filter returned documents - formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided, no end date filter will be applied.
     */
    @JsonProperty("dateTo")
    public Optional<String> getDateTo() {
        return dateTo;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListDocumentsRequest && equalTo((ListDocumentsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListDocumentsRequest other) {
        return patientId.equals(other.patientId)
                && facilityId.equals(other.facilityId)
                && dateFrom.equals(other.dateFrom)
                && dateTo.equals(other.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.patientId, this.facilityId, this.dateFrom, this.dateTo);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PatientIdStage builder() {
        return new Builder();
    }

    public interface PatientIdStage {
        FacilityIdStage patientId(String patientId);

        Builder from(ListDocumentsRequest other);
    }

    public interface FacilityIdStage {
        _FinalStage facilityId(String facilityId);
    }

    public interface _FinalStage {
        ListDocumentsRequest build();

        _FinalStage dateFrom(Optional<String> dateFrom);

        _FinalStage dateFrom(String dateFrom);

        _FinalStage dateTo(Optional<String> dateTo);

        _FinalStage dateTo(String dateTo);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PatientIdStage, FacilityIdStage, _FinalStage {
        private String patientId;

        private String facilityId;

        private Optional<String> dateTo = Optional.empty();

        private Optional<String> dateFrom = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ListDocumentsRequest other) {
            patientId(other.getPatientId());
            facilityId(other.getFacilityId());
            dateFrom(other.getDateFrom());
            dateTo(other.getDateTo());
            return this;
        }

        /**
         * <p>The ID of the Patient for which to list available Documents.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("patientId")
        public FacilityIdStage patientId(String patientId) {
            this.patientId = patientId;
            return this;
        }

        /**
         * <p>The ID of the Facility where the patient is receiving care.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("facilityId")
        public _FinalStage facilityId(String facilityId) {
            this.facilityId = facilityId;
            return this;
        }

        /**
         * <p>The end date (inclusive) for which to filter returned documents - formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided, no end date filter will be applied.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage dateTo(String dateTo) {
            this.dateTo = Optional.of(dateTo);
            return this;
        }

        @Override
        @JsonSetter(value = "dateTo", nulls = Nulls.SKIP)
        public _FinalStage dateTo(Optional<String> dateTo) {
            this.dateTo = dateTo;
            return this;
        }

        /**
         * <p>The start date (inclusive) for which to filter returned documents - formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided, no start date filter will be applied.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage dateFrom(String dateFrom) {
            this.dateFrom = Optional.of(dateFrom);
            return this;
        }

        @Override
        @JsonSetter(value = "dateFrom", nulls = Nulls.SKIP)
        public _FinalStage dateFrom(Optional<String> dateFrom) {
            this.dateFrom = dateFrom;
            return this;
        }

        @Override
        public ListDocumentsRequest build() {
            return new ListDocumentsRequest(patientId, facilityId, dateFrom, dateTo, additionalProperties);
        }
    }
}
