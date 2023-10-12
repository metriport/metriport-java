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
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NutritionFacts.Builder.class)
public final class NutritionFacts {
    private final Optional<Macros> macros;

    private final Optional<Micros> micros;

    private final Optional<Aminos> aminos;

    private NutritionFacts(Optional<Macros> macros, Optional<Micros> micros, Optional<Aminos> aminos) {
        this.macros = macros;
        this.micros = micros;
        this.aminos = aminos;
    }

    @JsonProperty("macros")
    public Optional<Macros> getMacros() {
        return macros;
    }

    @JsonProperty("micros")
    public Optional<Micros> getMicros() {
        return micros;
    }

    @JsonProperty("aminos")
    public Optional<Aminos> getAminos() {
        return aminos;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NutritionFacts && equalTo((NutritionFacts) other);
    }

    private boolean equalTo(NutritionFacts other) {
        return macros.equals(other.macros) && micros.equals(other.micros) && aminos.equals(other.aminos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.macros, this.micros, this.aminos);
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
        private Optional<Macros> macros = Optional.empty();

        private Optional<Micros> micros = Optional.empty();

        private Optional<Aminos> aminos = Optional.empty();

        private Builder() {}

        public Builder from(NutritionFacts other) {
            macros(other.getMacros());
            micros(other.getMicros());
            aminos(other.getAminos());
            return this;
        }

        @JsonSetter(value = "macros", nulls = Nulls.SKIP)
        public Builder macros(Optional<Macros> macros) {
            this.macros = macros;
            return this;
        }

        public Builder macros(Macros macros) {
            this.macros = Optional.of(macros);
            return this;
        }

        @JsonSetter(value = "micros", nulls = Nulls.SKIP)
        public Builder micros(Optional<Micros> micros) {
            this.micros = micros;
            return this;
        }

        public Builder micros(Micros micros) {
            this.micros = Optional.of(micros);
            return this;
        }

        @JsonSetter(value = "aminos", nulls = Nulls.SKIP)
        public Builder aminos(Optional<Aminos> aminos) {
            this.aminos = aminos;
            return this;
        }

        public Builder aminos(Aminos aminos) {
            this.aminos = Optional.of(aminos);
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(macros, micros, aminos);
        }
    }
}
