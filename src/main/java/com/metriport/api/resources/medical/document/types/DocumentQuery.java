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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DocumentQuery.Builder.class)
public final class DocumentQuery {
    private final Optional<Progress> download;

    private final Optional<Progress> convert;

    private final Map<String, Object> additionalProperties;

    private DocumentQuery(
            Optional<Progress> download, Optional<Progress> convert, Map<String, Object> additionalProperties) {
        this.download = download;
        this.convert = convert;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("download")
    public Optional<Progress> getDownload() {
        return download;
    }

    @JsonProperty("convert")
    public Optional<Progress> getConvert() {
        return convert;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DocumentQuery && equalTo((DocumentQuery) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DocumentQuery other) {
        return download.equals(other.download) && convert.equals(other.convert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.download, this.convert);
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
        private Optional<Progress> download = Optional.empty();

        private Optional<Progress> convert = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(DocumentQuery other) {
            download(other.getDownload());
            convert(other.getConvert());
            return this;
        }

        @JsonSetter(value = "download", nulls = Nulls.SKIP)
        public Builder download(Optional<Progress> download) {
            this.download = download;
            return this;
        }

        public Builder download(Progress download) {
            this.download = Optional.of(download);
            return this;
        }

        @JsonSetter(value = "convert", nulls = Nulls.SKIP)
        public Builder convert(Optional<Progress> convert) {
            this.convert = convert;
            return this;
        }

        public Builder convert(Progress convert) {
            this.convert = Optional.of(convert);
            return this;
        }

        public DocumentQuery build() {
            return new DocumentQuery(download, convert, additionalProperties);
        }
    }
}
