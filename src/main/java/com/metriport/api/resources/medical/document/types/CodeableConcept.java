/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.document.types;

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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CodeableConcept.Builder.class)
public final class CodeableConcept {
    private final Optional<List<Coding>> coding;

    private final Optional<String> text;

    private final Map<String, Object> additionalProperties;

    private CodeableConcept(
            Optional<List<Coding>> coding, Optional<String> text, Map<String, Object> additionalProperties) {
        this.coding = coding;
        this.text = text;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Array containing the coding defined by a terminology system.
     */
    @JsonProperty("coding")
    public Optional<List<Coding>> getCoding() {
        return coding;
    }

    /**
     * @return Plain text representation of the concept.
     */
    @JsonProperty("text")
    public Optional<String> getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CodeableConcept && equalTo((CodeableConcept) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CodeableConcept other) {
        return coding.equals(other.coding) && text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.coding, this.text);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<Coding>> coding = Optional.empty();

        private Optional<String> text = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CodeableConcept other) {
            coding(other.getCoding());
            text(other.getText());
            return this;
        }

        @JsonSetter(value = "coding", nulls = Nulls.SKIP)
        public Builder coding(Optional<List<Coding>> coding) {
            this.coding = coding;
            return this;
        }

        public Builder coding(List<Coding> coding) {
            this.coding = Optional.of(coding);
            return this;
        }

        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<String> text) {
            this.text = text;
            return this;
        }

        public Builder text(String text) {
            this.text = Optional.of(text);
            return this;
        }

        public CodeableConcept build() {
            return new CodeableConcept(coding, text, additionalProperties);
        }
    }
}
