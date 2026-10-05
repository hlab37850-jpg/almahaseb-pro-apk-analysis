package com.zebra.sdk.printer.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zebra.sdk.printer.PrinterAlert;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.util.internal.FileReader;
import com.zebra.sdk.util.internal.JacksonObjectMapperFactory;
import com.zebra.sdk.util.internal.StringUtilities;
import com.zebra.sdk.util.internal.ZipUtil;
import defpackage.AbstractC4493zu;
import defpackage.C4412yu;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ProfileHelper {
    public static final String ALERTS_JSON_NAME = "alerts.json";
    public static final String FIRMWARE_FILE_NAME = "firmwareFile.txt";
    public static final String FIRMWARE_FILE_USER_SPECIFIED_NAME = "firmwareFileUserSpecifiedName.txt";
    public static final String PROFILE_SUPPLEMENT_NAME = "profileSupplement.txt";
    public static final String SETTINGS_JSON_NAME = "settings.json";

    public static class OurAlertsWriter implements ProfileComponentTransformer {
        private List<PrinterAlert> myAlerts;

        public OurAlertsWriter(List<PrinterAlert> list) {
            this.myAlerts = list;
        }

        @Override // com.zebra.sdk.printer.internal.ProfileHelper.ProfileComponentTransformer
        public boolean shouldTransformComponent(String str) {
            return str.equals(ProfileHelper.ALERTS_JSON_NAME);
        }

        @Override // com.zebra.sdk.printer.internal.ProfileHelper.ProfileComponentTransformer
        public byte[] transformComponent() {
            try {
                return ProfileHelper.createJson(this.myAlerts).getBytes();
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class OurComponentDeleter implements ProfileComponentTransformer {
        private String myDeleteSpecification;

        public OurComponentDeleter(String str) {
            this.myDeleteSpecification = str;
        }

        @Override // com.zebra.sdk.printer.internal.ProfileHelper.ProfileComponentTransformer
        public boolean shouldTransformComponent(String str) {
            return FilenameUtils.wildcardMatch(str, this.myDeleteSpecification);
        }

        @Override // com.zebra.sdk.printer.internal.ProfileHelper.ProfileComponentTransformer
        public byte[] transformComponent() {
            return null;
        }
    }

    public interface ProfileComponentTransformer {
        boolean shouldTransformComponent(String str);

        byte[] transformComponent();
    }

    public static void commitAlertsToProfile(String str, List<PrinterAlert> list) throws IOException {
        modifyProfile(str, new OurAlertsWriter(list));
    }

    public static String createJson(List<PrinterAlert> list) throws SettingsException {
        try {
            return JacksonObjectMapperFactory.getInstance().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(list);
        } catch (AbstractC4493zu e) {
            throw new SettingsException(e.getLocalizedMessage());
        }
    }

    public static void deleteFileFromProfile(String str, String str2) throws IOException {
        modifyProfile(str, new OurComponentDeleter(str2));
    }

    public static List<PrinterAlert> getAlertsFromJson(String str) {
        return getAlertsFromJsonData(new ZipUtil(str).getEntryContents(ALERTS_JSON_NAME));
    }

    public static List<PrinterAlert> getAlertsFromJsonData(String str) {
        try {
            return (List) JacksonObjectMapperFactory.getInstance().readValue(str, new TypeReference() { // from class: com.zebra.sdk.printer.internal.ProfileHelper.1
            });
        } catch (C4412yu | JsonMappingException | IOException unused) {
            return new ArrayList();
        }
    }

    public static Map<String, String> getSettingsFromProfile(String str) {
        return StringUtilities.convertKeyValueJsonToMap(new ZipUtil(str).getEntryContents(SETTINGS_JSON_NAME));
    }

    public static void handleSpecialCases(Map<String, String> map, RestoreType restoreType) {
        String str = map.get("internal_wired.ip.protocol");
        RestoreType restoreType2 = RestoreType.ARCHIVE;
        boolean z = false;
        if (!(restoreType == restoreType2 && str != null && str.equalsIgnoreCase("permanent"))) {
            map.remove("internal_wired.ip.addr");
        }
        String str2 = map.get("wlan.ip.protocol");
        if (!(restoreType == restoreType2 && str2 != null && str2.equalsIgnoreCase("permanent"))) {
            map.remove("ip.addr");
            map.remove("wlan.ip.addr");
        }
        String str3 = map.get("external_wired.ip.protocol");
        if (restoreType == restoreType2 && str3 != null && str3.equalsIgnoreCase("permanent")) {
            z = true;
        }
        if (z) {
            return;
        }
        map.remove("external_wired.ip.addr");
    }

    public static boolean isSpecialProfileFile(String str) {
        return str.equals(SETTINGS_JSON_NAME) || str.equals(ALERTS_JSON_NAME) || str.equals(PROFILE_SUPPLEMENT_NAME) || str.equals(FIRMWARE_FILE_NAME) || str.equals(FIRMWARE_FILE_USER_SPECIFIED_NAME);
    }

    public static void modifyProfile(String str, ProfileComponentTransformer profileComponentTransformer) throws IOException {
        byte[] byteArray = FileReader.toByteArray(str);
        File fileCreateTempFile = File.createTempFile("proftmp", null);
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile.getAbsolutePath());
        fileOutputStream.write(byteArray);
        fileOutputStream.close();
        new File(str).delete();
        String absolutePath = fileCreateTempFile.getAbsolutePath();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            ZipUtil zipUtil = new ZipUtil(absolutePath);
            for (String str2 : zipUtil.getEntryNames()) {
                byte[] bArrTransformComponent = profileComponentTransformer.shouldTransformComponent(str2) ? profileComponentTransformer.transformComponent() : zipUtil.extractEntry(str2);
                if (bArrTransformComponent != null && bArrTransformComponent.length > 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2));
                    zipOutputStream.write(bArrTransformComponent);
                    zipOutputStream.closeEntry();
                }
            }
            zipOutputStream.close();
            fileCreateTempFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
