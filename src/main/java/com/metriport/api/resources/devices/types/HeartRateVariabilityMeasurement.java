/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.devices.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.metriport.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = HeartRateVariabilityMeasurement.Builder.class)
public final class HeartRateVariabilityMeasurement {
    private final Optional<Integer> avgMillis;

    private final Optional<List<Sample>> samplesMillis;

    private HeartRateVariabilityMeasurement(Optional<Integer> avgMillis, Optional<List<Sample>> samplesMillis) {
        this.avgMillis = avgMillis;
        this.samplesMillis = samplesMillis;
    }

    @JsonProperty("avg_millis")
    public Optional<Integer> getAvgMillis() {
        return avgMillis;
    }

    @JsonProperty("samples_millis")
    public Optional<List<Sample>> getSamplesMillis() {
        return samplesMillis;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof HeartRateVariabilityMeasurement && equalTo((HeartRateVariabilityMeasurement) other);
    }

    private boolean equalTo(HeartRateVariabilityMeasurement other) {
        return avgMillis.equals(other.avgMillis) && samplesMillis.equals(other.samplesMillis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.avgMillis, this.samplesMillis);
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
        private Optional<Integer> avgMillis = Optional.empty();

        private Optional<List<Sample>> samplesMillis = Optional.empty();

        private Builder() {}

        public Builder from(HeartRateVariabilityMeasurement other) {
            avgMillis(other.getAvgMillis());
            samplesMillis(other.getSamplesMillis());
            return this;
        }

        @JsonSetter(value = "avg_millis", nulls = Nulls.SKIP)
        public Builder avgMillis(Optional<Integer> avgMillis) {
            this.avgMillis = avgMillis;
            return this;
        }

        public Builder avgMillis(Integer avgMillis) {
            this.avgMillis = Optional.of(avgMillis);
            return this;
        }

        @JsonSetter(value = "samples_millis", nulls = Nulls.SKIP)
        public Builder samplesMillis(Optional<List<Sample>> samplesMillis) {
            this.samplesMillis = samplesMillis;
            return this;
        }

        public Builder samplesMillis(List<Sample> samplesMillis) {
            this.samplesMillis = Optional.of(samplesMillis);
            return this;
        }

        public HeartRateVariabilityMeasurement build() {
            return new HeartRateVariabilityMeasurement(avgMillis, samplesMillis);
        }
    }
}
