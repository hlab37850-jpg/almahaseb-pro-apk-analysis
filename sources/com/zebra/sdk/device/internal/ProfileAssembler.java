package com.zebra.sdk.device.internal;

import com.zebra.sdk.printer.internal.ProfileHelper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ProfileAssembler {
    private ZipOutputStream zos = null;
    private OutputStream bos = null;

    private void addEntry(String str, InputStream inputStream) throws IOException {
        this.zos.putNextEntry(new ZipEntry(str));
        byte[] bArr = new byte[16384];
        while (inputStream.available() > 0) {
            this.zos.write(bArr, 0, inputStream.read(bArr));
        }
        this.zos.closeEntry();
    }

    public void addAlerts(InputStream inputStream) throws IOException {
        addEntry(ProfileHelper.ALERTS_JSON_NAME, inputStream);
    }

    public void addFiles(Map<String, InputStream> map) throws IOException {
        for (String str : map.keySet()) {
            addEntry(str, map.get(str));
        }
    }

    public void addFirmware(String str, InputStream inputStream) throws IOException {
        addEntry(ProfileHelper.FIRMWARE_FILE_USER_SPECIFIED_NAME, new ByteArrayInputStream(str.getBytes()));
        addEntry(ProfileHelper.FIRMWARE_FILE_NAME, inputStream);
    }

    public void addSettings(InputStream inputStream) throws IOException {
        addEntry(ProfileHelper.SETTINGS_JSON_NAME, inputStream);
    }

    public void addSupplement(InputStream inputStream) throws IOException {
        addEntry(ProfileHelper.PROFILE_SUPPLEMENT_NAME, inputStream);
    }

    public void begin(OutputStream outputStream) {
        this.bos = new BufferedOutputStream(outputStream);
        this.zos = new ZipOutputStream(this.bos);
    }

    public void end() throws IOException {
        this.zos.close();
        this.bos.close();
    }
}
