/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.organization.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.metriport.api.core.ObjectMappers;
import com.metriport.api.resources.commons.types.Address;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Organization.Builder.class)
public final class Organization implements IBaseOrganization {
    private final String name;

    private final OrgType type;

    private final Address location;

    private final String id;

    private final Optional<String> eTag;

    private Organization(String name, OrgType type, Address location, String id, Optional<String> eTag) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.id = id;
        this.eTag = eTag;
    }

    /**
     * @return The name of your organization.
     * This is usually your legal corporate entity name -
     * for example <code>Metriport Inc.</code>.
     */
    @JsonProperty("name")
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return The type of your organization.
     */
    @JsonProperty("type")
    @Override
    public OrgType getType() {
        return type;
    }

    @JsonProperty("location")
    @Override
    public Address getLocation() {
        return location;
    }

    /**
     * @return The ID assigned to your organization.
     * This ID will be used to uniquely identify your organization in medical documents.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("eTag")
    public Optional<String> getETag() {
        return eTag;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Organization && equalTo((Organization) other);
    }

    private boolean equalTo(Organization other) {
        return name.equals(other.name)
                && type.equals(other.type)
                && location.equals(other.location)
                && id.equals(other.id)
                && eTag.equals(other.eTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.type, this.location, this.id, this.eTag);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        TypeStage name(String name);

        Builder from(Organization other);
    }

    public interface TypeStage {
        LocationStage type(OrgType type);
    }

    public interface LocationStage {
        IdStage location(Address location);
    }

    public interface IdStage {
        _FinalStage id(String id);
    }

    public interface _FinalStage {
        Organization build();

        _FinalStage eTag(Optional<String> eTag);

        _FinalStage eTag(String eTag);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, TypeStage, LocationStage, IdStage, _FinalStage {
        private String name;

        private OrgType type;

        private Address location;

        private String id;

        private Optional<String> eTag = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Organization other) {
            name(other.getName());
            type(other.getType());
            location(other.getLocation());
            id(other.getId());
            eTag(other.getETag());
            return this;
        }

        /**
         * <p>The name of your organization.
         * This is usually your legal corporate entity name -
         * for example <code>Metriport Inc.</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public TypeStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The type of your organization.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("type")
        public LocationStage type(OrgType type) {
            this.type = type;
            return this;
        }

        @Override
        @JsonSetter("location")
        public IdStage location(Address location) {
            this.location = location;
            return this;
        }

        /**
         * <p>The ID assigned to your organization.
         * This ID will be used to uniquely identify your organization in medical documents.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("id")
        public _FinalStage id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public _FinalStage eTag(String eTag) {
            this.eTag = Optional.of(eTag);
            return this;
        }

        @Override
        @JsonSetter(value = "eTag", nulls = Nulls.SKIP)
        public _FinalStage eTag(Optional<String> eTag) {
            this.eTag = eTag;
            return this;
        }

        @Override
        public Organization build() {
            return new Organization(name, type, location, id, eTag);
        }
    }
}
