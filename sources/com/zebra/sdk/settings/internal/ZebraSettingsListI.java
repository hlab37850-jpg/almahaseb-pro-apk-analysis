package com.zebra.sdk.settings.internal;

import com.zebra.sdk.settings.Setting;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface ZebraSettingsListI {
    Set<String> getAllSettingIds();

    Map<String, String> getAllSettingValues();

    Map<String, Setting> getAllSettings();

    Setting getSetting(String str);

    String getSettingRange(String str);

    String getSettingType(String str);

    String getValue(String str);

    Map<String, String> getValues(List<String> list);

    boolean isSettingArchivable(String str);

    boolean isSettingClonable(String str);

    boolean isSettingReadOnly(String str);

    boolean isSettingValid(String str, String str2);

    boolean isSettingWriteOnly(String str);

    Map<String, String> processSettingsViaMap(Map<String, String> map);

    void setAllSettings(Map<String, Setting> map);

    void setSetting(String str, Setting setting);

    void setSetting(String str, String str2);

    void setSettings(Map<String, String> map);
}
