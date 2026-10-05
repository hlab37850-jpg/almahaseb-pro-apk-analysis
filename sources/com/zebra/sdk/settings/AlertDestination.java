package com.zebra.sdk.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zebra.sdk.device.ZebraIllegalArgumentException;

/* JADX INFO: loaded from: classes3.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.ANY)
public enum AlertDestination {
    SERIAL("SERIAL"),
    PARALLEL("PARALLEL"),
    EMAIL("E-MAIL"),
    TCP("TCP"),
    UDP("UDP"),
    SNMP("SNMP"),
    USB("USB"),
    HTTP("HTTP-POST"),
    BLUETOOTH("BLUETOOTH"),
    SDK("SDK");

    private String destination;

    public static AlertDestination createAlertDestination(String str) throws ZebraIllegalArgumentException {
        for (AlertDestination alertDestination : values()) {
            if (alertDestination.destination.equals(str)) {
                return alertDestination;
            }
        }
        throw new ZebraIllegalArgumentException("Invalid alert destination.");
    }

    @JsonIgnore
    public String getDestinationAsSGDString() {
        return this.destination.toUpperCase();
    }

    AlertDestination(String str) {
        this.destination = str;
    }
}
