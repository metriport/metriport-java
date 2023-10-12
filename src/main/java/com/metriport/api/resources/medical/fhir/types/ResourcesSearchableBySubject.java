/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.fhir.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResourcesSearchableBySubject {
    ADVERSE_EVENT("AdverseEvent"),

    TASK("Task");

    private final String value;

    ResourcesSearchableBySubject(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
