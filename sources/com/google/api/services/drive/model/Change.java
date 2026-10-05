package com.google.api.services.drive.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class Change extends GenericJson {

    @Key
    private File file;

    @Key
    private String fileId;

    @Key
    private String kind;

    @Key
    private Boolean removed;

    @Key
    private DateTime time;

    public File getFile() {
        return this.file;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getKind() {
        return this.kind;
    }

    public Boolean getRemoved() {
        return this.removed;
    }

    public DateTime getTime() {
        return this.time;
    }

    public Change setFile(File file) {
        this.file = file;
        return this;
    }

    public Change setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public Change setKind(String str) {
        this.kind = str;
        return this;
    }

    public Change setRemoved(Boolean bool) {
        this.removed = bool;
        return this;
    }

    public Change setTime(DateTime dateTime) {
        this.time = dateTime;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Change clone() {
        return (Change) super.clone();
    }
}
