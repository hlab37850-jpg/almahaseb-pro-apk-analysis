package com.zebra.sdk.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zebra.sdk.device.ZebraIllegalArgumentException;

/* JADX INFO: loaded from: classes3.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.ANY)
public enum AlertCondition {
    NONE("NONE"),
    PAPER_OUT("PAPER OUT"),
    RIBBON_OUT("RIBBON OUT"),
    HEAD_TOO_HOT("HEAD TOO HOT"),
    HEAD_COLD("HEAD COLD"),
    HEAD_OPEN("HEAD OPEN"),
    POWER_SUPPLY_OVER_TEMP("SUPPLY TOO HOT"),
    RIBBON_IN_WARNING("RIBBON IN"),
    REWIND_FULL("REWIND"),
    CUTTER_JAMMED("CUTTER JAMMED"),
    PRINTER_PAUSED("PRINTER PAUSED"),
    PQ_JOB_COMPLETED("PQ JOB COMPLETED"),
    LABEL_READY("LABEL READY"),
    HEAD_ELEMENT_BAD("HEAD ELEMENT BAD"),
    ZBI_BASIC_RUNTIME_ERROR("BASIC RUNTIME"),
    ZBI_BASIC_FORCED_ERROR("BASIC FORCED"),
    POWER_ON("POWER ON"),
    CLEAN_PRINTHEAD("CLEAN PRINTHEAD"),
    MEDIA_LOW("MEDIA LOW"),
    RIBBON_LOW("RIBBON LOW"),
    REPLACE_HEAD("REPLACE HEAD"),
    BATTERY_LOW("BATTERY LOW"),
    RFID_ERROR("RFID ERROR"),
    ALL_MESSAGES("ALL MESSAGES"),
    COLD_START("COLD START"),
    SGD_SET("SGD SET"),
    MOTOR_OVERTEMP("MOTOR OVERTEMP"),
    PRINTHEAD_SHUTDOWN("PRINTHEAD SHUTDOWN"),
    SHUTTING_DOWN("SHUTTING DOWN"),
    RESTARTING("RESTARTING"),
    NO_READER_PRESENT("NO READER PRESENT"),
    THERMISTOR_FAULT("THERMISTOR FAULT"),
    INVALID_HEAD("INVALID HEAD"),
    COUNTRY_CODE_ERROR("COUNTRY CODE ERROR"),
    MCR_RESULT_READY("MCR RESULT READY"),
    PMCU_DOWNLOAD("PMCU DOWNLOAD"),
    MEDIA_CARTRIDGE("MEDIA CARTRIDGE"),
    MEDIA_CARTRIDGE_LOAD_FAILURE("MEDIA CARTRIDGE LOAD FAILURE"),
    MEDIA_CARTRIDGE_EJECT_FAILURE("MEDIA CARTRIDGE EJECT FAILURE"),
    MEDIA_CARTRIDGE_FORCED_EJECT("MEDIA CARTRIDGE FORCED EJECT"),
    CLEANING_MODE("CLEANING MODE");

    private String conditionType;

    public static AlertCondition createAlertCondition(String str) throws ZebraIllegalArgumentException {
        for (AlertCondition alertCondition : values()) {
            if (alertCondition.conditionType.equals(str)) {
                return alertCondition;
            }
        }
        throw new ZebraIllegalArgumentException("Invalid alert condition.");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.conditionType;
    }

    AlertCondition(String str) {
        this.conditionType = str;
    }
}
