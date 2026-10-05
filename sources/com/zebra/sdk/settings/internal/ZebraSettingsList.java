package com.zebra.sdk.settings.internal;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.SettingsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZebraSettingsList implements ZebraSettingsListI {
    protected Map<String, Setting> allSettings = new LinkedHashMap();

    public List<String> filterOutUnreadableSettings(List<String> list) throws SettingsException {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (getAllSettings().containsKey(str) && !getSettingById(str).isWriteOnly()) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            throw new SettingsException("Found no valid settings to retrieve.");
        }
        return arrayList;
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Set<String> getAllSettingIds() {
        return getAllSettings().keySet();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Map<String, String> getAllSettingValues() throws SettingsException {
        refresh();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : getAllSettings().keySet()) {
            linkedHashMap.put(str, getAllSettings().get(str).getValue());
        }
        return linkedHashMap;
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Map<String, Setting> getAllSettings() throws SettingsException {
        Map<String, Setting> map = this.allSettings;
        if (map == null || map.isEmpty()) {
            refresh();
        }
        return this.allSettings;
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Setting getSetting(String str) {
        return getSettingById(str);
    }

    public Setting getSettingById(String str) throws SettingsException {
        Setting setting = getAllSettings().get(str);
        if (setting != null) {
            return setting;
        }
        throw new SettingsException("Setting [" + str + "] not found.");
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public String getSettingRange(String str) {
        return getSettingById(str).getRange();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public String getSettingType(String str) {
        return getSettingById(str).getType().toString();
    }

    public abstract byte[] getUpdatedJsonData();

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public String getValue(String str) throws SettingsException {
        if (getSettingById(str).isWriteOnly()) {
            throw new SettingsException("Setting [" + str + "] is write only");
        }
        Map<String, String> values = getValues(new ArrayList(Arrays.asList(str)));
        if (values != null && values.containsKey(str)) {
            return values.get(str);
        }
        throw new SettingsException("Setting " + str + " not availble from device");
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public abstract Map<String, String> getValues(List<String> list);

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public boolean isSettingArchivable(String str) {
        return getSettingById(str).getArchive();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public boolean isSettingClonable(String str) {
        return getSettingById(str).getClone();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public boolean isSettingReadOnly(String str) {
        return getSettingById(str).isReadOnly();
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public boolean isSettingValid(String str, String str2) {
        return getSettingById(str).isValid(str2);
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public boolean isSettingWriteOnly(String str) {
        return getSettingById(str).isWriteOnly();
    }

    public void refresh() throws SettingsException {
        try {
            byte[] updatedJsonData = getUpdatedJsonData();
            if (updatedJsonData.length > 0) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                new SettingsBuilder(linkedHashMap).parse(updatedJsonData);
                this.allSettings = linkedHashMap;
            }
        } catch (ConnectionException e) {
            throw new SettingsException(e.getLocalizedMessage());
        } catch (Exception unused) {
            throw new SettingsException("Malformed settings data");
        }
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public abstract void setSetting(String str, String str2);

    public void updateInternalState(String str, String str2) throws SettingsException {
        Setting settingById = getSettingById(str);
        if (settingById != null) {
            if (settingById.isReadOnly()) {
                throw new SettingsException("Setting [" + str + "] is read only.");
            }
            try {
                if (!settingById.isValid(str2)) {
                    throw new SettingsException("Setting [" + str + "] is not in range [" + settingById.getRange() + "]");
                }
                if (settingById.getValue() == null || !settingById.getValue().equals(str2) || settingById.isWriteOnly()) {
                    settingById.setValue(str2);
                    Map<String, Setting> allSettings = getAllSettings();
                    if (allSettings != null) {
                        allSettings.remove(str);
                        allSettings.put(str, settingById);
                    }
                }
            } catch (NumberFormatException unused) {
                throw new SettingsException("Error in range check for [" + str + "] with value [" + str2 + "]");
            }
        }
    }
}
