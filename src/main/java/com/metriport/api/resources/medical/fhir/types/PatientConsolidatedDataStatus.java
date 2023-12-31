/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.fhir.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PatientConsolidatedDataStatus {
    PROCESSING("processing"),

    COMPLETED("completed"),

    FAILED("failed");

    private final String value;

    PatientConsolidatedDataStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
