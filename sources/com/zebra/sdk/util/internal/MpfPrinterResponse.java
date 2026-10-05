package com.zebra.sdk.util.internal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* JADX INFO: loaded from: classes3.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class MpfPrinterResponse {
    private long crc32;
    private String filename;
    private long size;

    public long getCrc32() {
        return this.crc32;
    }

    public String getFilename() {
        return this.filename;
    }

    public long getSize() {
        return this.size;
    }

    public void setCrc32(long j) {
        this.crc32 = j;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
