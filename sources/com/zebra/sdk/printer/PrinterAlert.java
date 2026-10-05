package com.zebra.sdk.printer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zebra.sdk.settings.AlertCondition;
import com.zebra.sdk.settings.AlertDestination;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class PrinterAlert implements Serializable {
    private static final long serialVersionUID = 5077333859329743115L;
    protected String alertText;
    private AlertCondition condition;
    protected AlertDestination destination;
    protected String destinationAddress;
    private boolean onClear;
    private boolean onSet;
    protected int port;
    protected boolean quelling;
    private String sgdName;

    private PrinterAlert() {
    }

    public String getAlertText() {
        return this.alertText;
    }

    public AlertCondition getCondition() {
        return this.condition;
    }

    public AlertDestination getDestination() {
        return this.destination;
    }

    public String getDestinationAddress() {
        return this.destinationAddress;
    }

    @JsonIgnore
    public String getDestinationAsSgdString() {
        return this.destination.getDestinationAsSGDString();
    }

    public int getPort() {
        return this.port;
    }

    public boolean getQuelling() {
        return this.quelling;
    }

    public String getSgdName() {
        return this.sgdName;
    }

    public boolean isOnClear() {
        return this.onClear;
    }

    public boolean isOnSet() {
        return this.onSet;
    }

    public PrinterAlert(AlertCondition alertCondition, AlertDestination alertDestination, String str, boolean z, boolean z2, String str2, int i, boolean z3) {
        this(alertCondition, alertDestination, str, z, z2, str2, i, z3, "");
    }

    public PrinterAlert(AlertCondition alertCondition, AlertDestination alertDestination, String str, boolean z, boolean z2, String str2, int i, boolean z3, String str3) {
        this.condition = alertCondition;
        this.destination = alertDestination;
        this.sgdName = str;
        this.onSet = z;
        this.onClear = z2;
        this.destinationAddress = str2;
        this.port = i;
        this.quelling = z3;
        this.alertText = str3;
    }

    public PrinterAlert(AlertCondition alertCondition, AlertDestination alertDestination, boolean z, boolean z2, String str, int i, boolean z3) {
        this(alertCondition, alertDestination, "", z, z2, str, i, z3, "");
    }

    public PrinterAlert(AlertCondition alertCondition, AlertDestination alertDestination, boolean z, boolean z2, String str, int i, boolean z3, String str2) {
        this(alertCondition, alertDestination, "", z, z2, str, i, z3, str2);
    }
}
