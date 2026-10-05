package com.zebra.sdk.settings.internal;

import com.zebra.sdk.printer.internal.SgdFromProfileResult;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.SettingsException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ProfileSavedSettingsToSgd {
    public static String convert(Setting setting, String str) throws SettingsException {
        throw new SettingsException("Implement conversion to mirror server command");
    }

    public static SgdFromProfileResult convertAllSettingsToSgds(Map<String, Setting> map, Map<String, String> map2) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str : map2.keySet()) {
            try {
                sb.append(convert(map.get(str), map2.get(str)));
            } catch (SettingsException unused) {
                arrayList.add("Setting " + str + " cannot be set ");
            }
        }
        return new SgdFromProfileResult(sb.toString(), arrayList);
    }
}
