/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.resources.medical.fhir.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResourcesSearchableByPatient {
    ACCOUNT("Account"),

    ALLERGY_INTOLERANCE("AllergyIntolerance"),

    APPOINTMENT("Appointment"),

    APPOINTMENT_RESPONSE("AppointmentResponse"),

    AUDIT_EVENT("AuditEvent"),

    BASIC("Basic"),

    BODY_STRUCTURE("BodyStructure"),

    CARE_PLAN("CarePlan"),

    CARE_TEAM("CareTeam"),

    CHARGE_ITEM("ChargeItem"),

    CLAIM("Claim"),

    CLAIM_RESPONSE("ClaimResponse"),

    CLINICAL_IMPRESSION("ClinicalImpression"),

    COMMUNICATION("Communication"),

    COMMUNICATION_REQUEST("CommunicationRequest"),

    COMPOSITION("Composition"),

    CONDITION("Condition"),

    CONSENT("Consent"),

    CONTRACT("Contract"),

    COVERAGE("Coverage"),

    COVERAGE_ELIGIBILITY_REQUEST("CoverageEligibilityRequest"),

    COVERAGE_ELIGIBILITY_RESPONSE("CoverageEligibilityResponse"),

    DETECTED_ISSUE("DetectedIssue"),

    DEVICE("Device"),

    DEVICE_REQUEST("DeviceRequest"),

    DEVICE_USE_STATEMENT("DeviceUseStatement"),

    DIAGNOSTIC_REPORT("DiagnosticReport"),

    DOCUMENT_MANIFEST("DocumentManifest"),

    DOCUMENT_REFERENCE("DocumentReference"),

    ENCOUNTER("Encounter"),

    ENROLLMENT_REQUEST("EnrollmentRequest"),

    EPISODE_OF_CARE("EpisodeOfCare"),

    EXPLANATION_OF_BENEFIT("ExplanationOfBenefit"),

    FAMILY_MEMBER_HISTORY("FamilyMemberHistory"),

    FLAG("Flag"),

    GOAL("Goal"),

    GUIDANCE_RESPONSE("GuidanceResponse"),

    IMAGING_STUDY("ImagingStudy"),

    IMMUNIZATION("Immunization"),

    IMMUNIZATION_EVALUATION("ImmunizationEvaluation"),

    IMMUNIZATION_RECOMMENDATION("ImmunizationRecommendation"),

    INVOICE("Invoice"),

    LIST("List"),

    MEASURE_REPORT("MeasureReport"),

    MEDIA("Media"),

    MEDICATION_ADMINISTRATION("MedicationAdministration"),

    MEDICATION_DISPENSE("MedicationDispense"),

    MEDICATION_REQUEST("MedicationRequest"),

    MEDICATION_STATEMENT("MedicationStatement"),

    MOLECULAR_SEQUENCE("MolecularSequence"),

    NUTRITION_ORDER("NutritionOrder"),

    OBSERVATION("Observation"),

    PERSON("Person"),

    PROCEDURE("Procedure"),

    PROVENANCE("Provenance"),

    QUESTIONNAIRE_RESPONSE("QuestionnaireResponse"),

    RELATED_PERSON("RelatedPerson"),

    REQUEST_GROUP("RequestGroup"),

    RESEARCH_SUBJECT("ResearchSubject"),

    RISK_ASSESSMENT("RiskAssessment"),

    SERVICE_REQUEST("ServiceRequest"),

    SPECIMEN("Specimen");

    private final String value;

    ResourcesSearchableByPatient(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
