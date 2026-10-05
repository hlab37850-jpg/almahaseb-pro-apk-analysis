package com.zebra.sdk.device.internal;

import com.zebra.sdk.printer.internal.ProfileHelper;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ProfileDisassembler {
    public void disassemble(InputStream inputStream, ProfileComponentHandler profileComponentHandler) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                bufferedInputStream.close();
                return;
            }
            String name = nextEntry.getName();
            if (name.equals(ProfileHelper.SETTINGS_JSON_NAME)) {
                profileComponentHandler.settingsHandler(zipInputStream);
            } else if (name.equals(ProfileHelper.ALERTS_JSON_NAME)) {
                profileComponentHandler.alertsHandler(zipInputStream);
            } else if (name.equals(ProfileHelper.PROFILE_SUPPLEMENT_NAME)) {
                profileComponentHandler.supplementHandler(zipInputStream);
            } else if (name.equals(ProfileHelper.FIRMWARE_FILE_NAME)) {
                profileComponentHandler.firmwareHandler(zipInputStream);
            } else if (name.equals(ProfileHelper.FIRMWARE_FILE_USER_SPECIFIED_NAME)) {
                profileComponentHandler.firmwareDisplayNameHandler(zipInputStream);
            } else {
                profileComponentHandler.fileHandler(name, zipInputStream);
            }
        }
    }
}
