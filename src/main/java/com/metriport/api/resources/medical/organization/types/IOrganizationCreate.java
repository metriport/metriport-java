/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.organization.types;

import com.metriport.api.resources.commons.types.Address;

public interface IOrganizationCreate {
    String getName();

    OrgType getType();

    Address getLocation();
}