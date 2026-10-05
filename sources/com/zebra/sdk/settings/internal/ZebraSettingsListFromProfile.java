package com.zebra.sdk.settings.internal;

import com.zebra.sdk.printer.internal.ProfileHelper;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.SettingsException;
import com.zebra.sdk.util.internal.ZipUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraSettingsListFromProfile extends ZebraSettingsList {
    private String pathToProfile;

    public ZebraSettingsListFromProfile(String str) {
        this.pathToProfile = str;
    }

    private void storeSettingValues() throws SettingsException {
        try {
            new ZipUtil(this.pathToProfile).addEntry(ProfileHelper.SETTINGS_JSON_NAME, new SettingsBuilder(getAllSettings()).toAllconfigJson().getBytes());
        } catch (IOException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsList
    public byte[] getUpdatedJsonData() {
        return new ZipUtil(this.pathToProfile).extractEntry(ProfileHelper.SETTINGS_JSON_NAME);
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsList, com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Map<String, String> getValues(List<String> list) throws SettingsException {
        List<String> listFilterOutUnreadableSettings = filterOutUnreadableSettings(list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : listFilterOutUnreadableSettings) {
            linkedHashMap.put(str, getSettingById(str).getValue());
        }
        return linkedHashMap;
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Map<String, String> processSettingsViaMap(Map<String, String> map) throws SettingsException {
        setSettings(map);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(map.keySet());
        return getValues(arrayList);
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setAllSettings(Map<String, Setting> map) throws SettingsException {
        Map<String, Setting> allSettings = getAllSettings();
        for (String str : map.keySet()) {
            allSettings.remove(str);
            allSettings.put(str, map.get(str));
        }
        storeSettingValues();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setSetting(String str, Setting setting) throws SettingsException {
        Map<String, Setting> allSettings = getAllSettings();
        allSettings.remove(str);
        allSettings.put(str, setting);
        storeSettingValues();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setSettings(Map<String, String> map) throws SettingsException {
        for (String str : map.keySet()) {
            try {
                updateInternalState(str, map.get(str));
            } catch (SettingsException unused) {
            }
        }
        storeSettingValues();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsList, com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setSetting(String str, String str2) throws SettingsException {
        updateInternalState(str, str2);
        storeSettingValues();
    }
}
