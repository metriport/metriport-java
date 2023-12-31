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
import com.metriport.api.resources.medical.document.types.ConversionType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetDocumentUrlRequest.Builder.class)
public final class GetDocumentUrlRequest {
    private final String fileName;

    private final Optional<ConversionType> conversionType;

    private final Map<String, Object> additionalProperties;

    private GetDocumentUrlRequest(
            String fileName, Optional<ConversionType> conversionType, Map<String, Object> additionalProperties) {
        this.fileName = fileName;
        this.conversionType = conversionType;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The file name of the document
     */
    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    /**
     * @return The doc type to convert to. Either <code>html</code> or <code>pdf</code>.
     * This parameter should only be used for converting XML/CDA files.
     */
    @JsonProperty("conversionType")
    public Optional<ConversionType> getConversionType() {
        return conversionType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetDocumentUrlRequest && equalTo((GetDocumentUrlRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetDocumentUrlRequest other) {
        return fileName.equals(other.fileName) && conversionType.equals(other.conversionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileName, this.conversionType);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FileNameStage builder() {
        return new Builder();
    }

    public interface FileNameStage {
        _FinalStage fileName(String fileName);

        Builder from(GetDocumentUrlRequest other);
    }

    public interface _FinalStage {
        GetDocumentUrlRequest build();

        _FinalStage conversionType(Optional<ConversionType> conversionType);

        _FinalStage conversionType(ConversionType conversionType);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FileNameStage, _FinalStage {
        private String fileName;

        private Optional<ConversionType> conversionType = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(GetDocumentUrlRequest other) {
            fileName(other.getFileName());
            conversionType(other.getConversionType());
            return this;
        }

        /**
         * <p>The file name of the document</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("fileName")
        public _FinalStage fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * <p>The doc type to convert to. Either <code>html</code> or <code>pdf</code>.
         * This parameter should only be used for converting XML/CDA files.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage conversionType(ConversionType conversionType) {
            this.conversionType = Optional.of(conversionType);
            return this;
        }

        @Override
        @JsonSetter(value = "conversionType", nulls = Nulls.SKIP)
        public _FinalStage conversionType(Optional<ConversionType> conversionType) {
            this.conversionType = conversionType;
            return this;
        }

        @Override
        public GetDocumentUrlRequest build() {
            return new GetDocumentUrlRequest(fileName, conversionType, additionalProperties);
        }
    }
}
