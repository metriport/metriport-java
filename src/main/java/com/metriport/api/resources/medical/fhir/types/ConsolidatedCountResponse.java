/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.fhir.types;

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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ConsolidatedCountResponse.Builder.class)
public final class ConsolidatedCountResponse {
    private final int total;

    private final Map<String, Integer> resources;

    private final Filter filter;

    private final Map<String, Object> additionalProperties;

    private ConsolidatedCountResponse(
            int total, Map<String, Integer> resources, Filter filter, Map<String, Object> additionalProperties) {
        this.total = total;
        this.resources = resources;
        this.filter = filter;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The sum of all resource type count.
     */
    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    /**
     * @return Object containing resource types as properties and the amount of entries for
     * the resource as the value (integer). Only resource types with amount
     * of entries higher than one are included.
     */
    @JsonProperty("resources")
    public Map<String, Integer> getResources() {
        return resources;
    }

    /**
     * @return The filters used to perform this operation.
     */
    @JsonProperty("filter")
    public Filter getFilter() {
        return filter;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ConsolidatedCountResponse && equalTo((ConsolidatedCountResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ConsolidatedCountResponse other) {
        return total == other.total && resources.equals(other.resources) && filter.equals(other.filter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.total, this.resources, this.filter);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TotalStage builder() {
        return new Builder();
    }

    public interface TotalStage {
        FilterStage total(int total);

        Builder from(ConsolidatedCountResponse other);
    }

    public interface FilterStage {
        _FinalStage filter(Filter filter);
    }

    public interface _FinalStage {
        ConsolidatedCountResponse build();

        _FinalStage resources(Map<String, Integer> resources);

        _FinalStage putAllResources(Map<String, Integer> resources);

        _FinalStage resources(String key, Integer value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TotalStage, FilterStage, _FinalStage {
        private int total;

        private Filter filter;

        private Map<String, Integer> resources = new LinkedHashMap<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ConsolidatedCountResponse other) {
            total(other.getTotal());
            resources(other.getResources());
            filter(other.getFilter());
            return this;
        }

        /**
         * <p>The sum of all resource type count.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total")
        public FilterStage total(int total) {
            this.total = total;
            return this;
        }

        /**
         * <p>The filters used to perform this operation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("filter")
        public _FinalStage filter(Filter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * <p>Object containing resource types as properties and the amount of entries for
         * the resource as the value (integer). Only resource types with amount
         * of entries higher than one are included.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage resources(String key, Integer value) {
            this.resources.put(key, value);
            return this;
        }

        /**
         * <p>Object containing resource types as properties and the amount of entries for
         * the resource as the value (integer). Only resource types with amount
         * of entries higher than one are included.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllResources(Map<String, Integer> resources) {
            this.resources.putAll(resources);
            return this;
        }

        @Override
        @JsonSetter(value = "resources", nulls = Nulls.SKIP)
        public _FinalStage resources(Map<String, Integer> resources) {
            this.resources.clear();
            this.resources.putAll(resources);
            return this;
        }

        @Override
        public ConsolidatedCountResponse build() {
            return new ConsolidatedCountResponse(total, resources, filter, additionalProperties);
        }
    }
}
