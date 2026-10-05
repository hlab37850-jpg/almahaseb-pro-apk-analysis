package com.zebra.sdk.settings.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;

/* JADX INFO: loaded from: classes3.dex */
public enum SettingType {
    INTEGER(TypedValues.Custom.S_INT),
    ENUM("enum"),
    STRING(TypedValues.Custom.S_STRING),
    BOOL("bool"),
    DOUBLE(CSS.Value.DOUBLE),
    IPV4ADDRESS("ipv4-address");

    private final String name;

    SettingType(String str) {
        this.name = str;
    }

    public static SettingType fromString(String str) {
        if (str == null) {
            return null;
        }
        for (SettingType settingType : values()) {
            if (str.equalsIgnoreCase(settingType.name)) {
                return settingType;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
