package com.zebra.sdk.util.internal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import defpackage.AbstractC4493zu;

/* JADX INFO: loaded from: classes3.dex */
public class CertificateSigningRequestInfo {
    private String commonName;
    private String companyCity;
    private String companyCountry;
    private String companyEmailAddress;
    private String companyPhoneNumber;
    private String companyPostalCode;
    private String companyState;
    private String companyStreetAddress;
    private String csr;
    private String organizationName;
    private String organizationUnitName;
    private String uid;

    public String getCommonName() {
        return this.commonName;
    }

    public String getCompanyCity() {
        return this.companyCity;
    }

    public String getCompanyCountry() {
        return this.companyCountry;
    }

    public String getCompanyEmailAddress() {
        return this.companyEmailAddress;
    }

    public String getCompanyPhoneNumber() {
        return this.companyPhoneNumber;
    }

    public String getCompanyPostalCode() {
        return this.companyPostalCode;
    }

    public String getCompanyState() {
        return this.companyState;
    }

    public String getCompanyStreetAddress() {
        return this.companyStreetAddress;
    }

    public String getCsr() {
        return this.csr;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public String getOrganizationUnitName() {
        return this.organizationUnitName;
    }

    public String getUid() {
        return this.uid;
    }

    public void setCommonName(String str) {
        this.commonName = str;
    }

    public void setCompanyCity(String str) {
        this.companyCity = str;
    }

    public void setCompanyCountry(String str) {
        this.companyCountry = str;
    }

    public void setCompanyEmailAddress(String str) {
        this.companyEmailAddress = str;
    }

    public void setCompanyPhoneNumber(String str) {
        this.companyPhoneNumber = str;
    }

    public void setCompanyPostalCode(String str) {
        this.companyPostalCode = str;
    }

    public void setCompanyState(String str) {
        this.companyState = str;
    }

    public void setCompanyStreetAddress(String str) {
        this.companyStreetAddress = str;
    }

    public void setCsr(String str) {
        this.csr = str;
    }

    public void setOrganizationName(String str) {
        this.organizationName = str;
    }

    public void setOrganizationUnitName(String str) {
        this.organizationUnitName = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE).withSetterVisibility(JsonAutoDetect.Visibility.NONE).withCreatorVisibility(JsonAutoDetect.Visibility.NONE).withIsGetterVisibility(JsonAutoDetect.Visibility.NONE));
        try {
            return objectMapper.writerWithType(getClass()).writeValueAsString(this);
        } catch (NullPointerException | AbstractC4493zu unused) {
            return null;
        }
    }
}
