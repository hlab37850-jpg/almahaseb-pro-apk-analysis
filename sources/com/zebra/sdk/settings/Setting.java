package com.zebra.sdk.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zebra.sdk.settings.internal.SettingRange;
import com.zebra.sdk.settings.internal.SettingRangeChoices;
import com.zebra.sdk.settings.internal.SettingRangeFloat;
import com.zebra.sdk.settings.internal.SettingRangeInteger;
import com.zebra.sdk.settings.internal.SettingRangeIpV4Address;
import com.zebra.sdk.settings.internal.SettingRangeString;
import com.zebra.sdk.settings.internal.SettingType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class Setting implements Serializable {
    private static final long serialVersionUID = -7840487209755339898L;
    private String access;
    private boolean archive;
    private boolean clone;
    private String range;
    private String type;
    private String value;

    /* JADX INFO: renamed from: com.zebra.sdk.settings.Setting$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$zebra$sdk$settings$internal$SettingType;

        static {
            int[] iArr = new int[SettingType.values().length];
            $SwitchMap$com$zebra$sdk$settings$internal$SettingType = iArr;
            try {
                iArr[SettingType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zebra$sdk$settings$internal$SettingType[SettingType.INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zebra$sdk$settings$internal$SettingType[SettingType.ENUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zebra$sdk$settings$internal$SettingType[SettingType.BOOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zebra$sdk$settings$internal$SettingType[SettingType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$zebra$sdk$settings$internal$SettingType[SettingType.IPV4ADDRESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String getAccess() {
        return this.access;
    }

    public boolean getArchive() {
        return this.archive;
    }

    public boolean getClone() {
        return this.clone;
    }

    public String getRange() {
        return this.range;
    }

    public String getType() {
        SettingType settingTypeFromString = SettingType.fromString(this.type);
        return settingTypeFromString == null ? this.type : settingTypeFromString.toString();
    }

    public String getValue() {
        return this.value;
    }

    @JsonIgnore
    public boolean isReadOnly() {
        return !this.access.contains("W");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003c  */
    @JsonIgnore
    public boolean isValid(String str) {
        SettingRange settingRangeFloat;
        SettingType settingTypeFromString = SettingType.fromString(this.type);
        if (settingTypeFromString != null) {
            switch (AnonymousClass1.$SwitchMap$com$zebra$sdk$settings$internal$SettingType[settingTypeFromString.ordinal()]) {
                case 1:
                    settingRangeFloat = new SettingRangeFloat(this.range);
                    break;
                case 2:
                    settingRangeFloat = new SettingRangeInteger(this.range);
                    break;
                case 3:
                case 4:
                    settingRangeFloat = new SettingRangeChoices(this.range);
                    break;
                case 5:
                    settingRangeFloat = new SettingRangeString(this.range);
                    break;
                case 6:
                    settingRangeFloat = new SettingRangeIpV4Address(this.range);
                    break;
                default:
                    settingRangeFloat = null;
                    break;
            }
        } else {
            settingRangeFloat = null;
        }
        return settingRangeFloat == null || settingRangeFloat.isInRange(str);
    }

    @JsonIgnore
    public boolean isWriteOnly() {
        return !this.access.contains("R");
    }

    public void setAccess(String str) {
        this.access = str;
    }

    public void setArchive(boolean z) {
        this.archive = z;
    }

    public void setClone(boolean z) {
        this.clone = z;
    }

    public void setRange(String str) {
        this.range = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "Setting [settingData=value= " + this.value + " type= " + this.type + " range= " + this.range + "]";
    }
}
