package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class Permission extends GenericJson {

    @Key
    private Boolean allowFileDiscovery;

    @Key
    private String displayName;

    @Key
    private String domain;

    @Key
    private String emailAddress;

    @Key
    private DateTime expirationTime;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private String photoLink;

    @Key
    private String role;

    @Key
    private String type;

    public Boolean getAllowFileDiscovery() {
        return this.allowFileDiscovery;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public DateTime getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getPhotoLink() {
        return this.photoLink;
    }

    public String getRole() {
        return this.role;
    }

    public String getType() {
        return this.type;
    }

    public Permission setAllowFileDiscovery(Boolean bool) {
        this.allowFileDiscovery = bool;
        return this;
    }

    public Permission setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public Permission setDomain(String str) {
        this.domain = str;
        return this;
    }

    public Permission setEmailAddress(String str) {
        this.emailAddress = str;
        return this;
    }

    public Permission setExpirationTime(DateTime dateTime) {
        this.expirationTime = dateTime;
        return this;
    }

    public Permission setId(String str) {
        this.id = str;
        return this;
    }

    public Permission setKind(String str) {
        this.kind = str;
        return this;
    }

    public Permission setPhotoLink(String str) {
        this.photoLink = str;
        return this;
    }

    public Permission setRole(String str) {
        this.role = str;
        return this;
    }

    public Permission setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Permission set(String str, Object obj) {
        return (Permission) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Permission clone() {
        return (Permission) super.clone();
    }
}
