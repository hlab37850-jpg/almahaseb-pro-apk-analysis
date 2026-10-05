package com.zebra.sdk.device;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.internal.FTP;
import com.zebra.sdk.comm.internal.FtpFileHolder;
import com.zebra.sdk.printer.PrinterAlert;
import com.zebra.sdk.printer.internal.ProfileHelper;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.settings.internal.AlertsUtilLinkOs;
import com.zebra.sdk.settings.internal.JsonHelper;
import com.zebra.sdk.settings.internal.PrinterlessConnection;
import com.zebra.sdk.util.internal.ZipUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ProfileToMirrorServer {
    private String password;
    private final String pathToProfile;
    private String server;
    private String user;

    public ProfileToMirrorServer(String str) {
        this.pathToProfile = str;
    }

    private void loadAlertsFromProfile(String str) throws ConnectionException {
        List<PrinterAlert> alertsFromJson = ProfileHelper.getAlertsFromJson(str);
        PrinterlessConnection printerlessConnection = new PrinterlessConnection();
        AlertsUtilLinkOs.setAlerts(alertsFromJson, printerlessConnection);
        storeFileViaFtp("commands", printerlessConnection.getStuffWrittenOnConnection().getBytes(), "alerts.txt");
    }

    private void loadFilesFromProfile(String str) throws ConnectionException {
        ArrayList arrayList = new ArrayList();
        ZipUtil zipUtil = new ZipUtil(str);
        for (String str2 : zipUtil.getEntryNames()) {
            if (!ProfileHelper.isSpecialProfileFile(str2)) {
                arrayList.add(new FtpFileHolder("commands", str2, new ByteArrayInputStream(zipUtil.extractEntry(str2))));
            }
        }
        storeFilesViaFtp(arrayList);
    }

    private void loadFirmwareFromProfile(Profile profile) throws IOException, ConnectionException {
        ZipUtil zipUtil;
        InputStream inputStreamToEntry;
        String str = new String(new ZipUtil(this.pathToProfile).extractEntry(ProfileHelper.FIRMWARE_FILE_USER_SPECIFIED_NAME));
        if (str.isEmpty() || (inputStreamToEntry = (zipUtil = new ZipUtil(this.pathToProfile)).getInputStreamToEntry(ProfileHelper.FIRMWARE_FILE_NAME)) == null) {
            return;
        }
        storeFileViaFtp("appl", str, inputStreamToEntry);
        zipUtil.closeStreams();
    }

    public void deleteAllFilesOnMirrorServer() throws ConnectionException {
        new FTP(this.server, this.user, this.password).deleteAllFilesAndSubDirectories(Arrays.asList("appl", "commands", "files"));
    }

    public List<String> sendToMirrorServer(String str, String str2, String str3) throws IOException, ConnectionException {
        this.server = str;
        this.user = str2;
        this.password = str3;
        ArrayList arrayList = new ArrayList();
        deleteAllFilesOnMirrorServer();
        try {
            Profile profile = new Profile(this.pathToProfile);
            loadFirmwareFromProfile(profile);
            storeFileViaFtp("commands", JsonHelper.buildSetCommand(profile.getClonableSettingValues()), "settings.txt");
        } catch (SettingsException unused) {
        }
        try {
            loadAlertsFromProfile(this.pathToProfile);
        } catch (SettingsException | UnsupportedEncodingException unused2) {
        }
        loadFilesFromProfile(this.pathToProfile);
        return arrayList;
    }

    public void storeFileViaFtp(String str, String str2, InputStream inputStream) throws ConnectionException {
        new FTP(this.server, this.user, this.password).putFile(str, str2, inputStream);
    }

    public void storeFilesViaFtp(List<FtpFileHolder> list) throws ConnectionException {
        new FTP(this.server, this.user, this.password).putFiles(list);
    }

    public void storeFileViaFtp(String str, byte[] bArr, String str2) throws ConnectionException {
        new FTP(this.server, this.user, this.password).putFile(str, str2, bArr);
    }
}
