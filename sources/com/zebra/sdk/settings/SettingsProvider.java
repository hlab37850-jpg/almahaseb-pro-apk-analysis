package com.zebra.sdk.settings;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface SettingsProvider {
    Map<String, String> getAllSettingValues();

    Map<String, Setting> getAllSettings();

    Set<String> getAvailableSettings();

    String getSettingRange(String str);

    String getSettingType(String str);

    String getSettingValue(String str);

    Map<String, String> getSettingsValues(List<String> list);

    boolean isSettingReadOnly(String str);

    boolean isSettingValid(String str, String str2);

    boolean isSettingWriteOnly(String str);

    Map<String, String> processSettingsViaMap(Map<String, String> map);

    void setSetting(String str, String str2);

    void setSettings(Map<String, String> map);
}
