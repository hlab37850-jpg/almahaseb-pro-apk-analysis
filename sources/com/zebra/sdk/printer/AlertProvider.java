package com.zebra.sdk.printer;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AlertProvider {
    void configureAlert(PrinterAlert printerAlert);

    void configureAlerts(List<PrinterAlert> list);

    List<PrinterAlert> getConfiguredAlerts();

    void removeAlert(PrinterAlert printerAlert);

    void removeAllAlerts();
}
