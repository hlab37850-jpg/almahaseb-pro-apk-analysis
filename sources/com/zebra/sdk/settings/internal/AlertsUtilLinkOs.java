package com.zebra.sdk.settings.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.printer.PrinterAlert;
import com.zebra.sdk.printer.ZebraPrinterLinkOs;
import com.zebra.sdk.settings.AlertCondition;
import com.zebra.sdk.settings.AlertDestination;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AlertsUtilLinkOs {
    private Connection connection;

    public AlertsUtilLinkOs(Connection connection) {
        this.connection = connection;
    }

    private String getAlertSgdValue(PrinterAlert printerAlert) {
        return printerAlert.getCondition() + "," + printerAlert.getDestinationAsSgdString() + "," + (printerAlert.isOnSet() ? "Y" : "N") + "," + (printerAlert.isOnClear() ? "Y" : "N") + "," + printerAlert.getDestinationAddress() + "," + printerAlert.getPort() + ",N," + printerAlert.getSgdName();
    }

    private ArrayList<PrinterAlert> getConfiguredAlerts() throws ZebraIllegalArgumentException {
        ArrayList<PrinterAlert> arrayList = new ArrayList<>();
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(this.connection);
        String str = JsonHelper.parseGetResponse(connectionSelectConnection.sendAndWaitForValidResponse("{}{\"alerts.configured\":null}".getBytes(), connectionSelectConnection.getMaxTimeoutForRead(), connectionSelectConnection.getTimeToWaitForMoreData(), new JsonValidator())).get("alerts.configured");
        if (!str.trim().equals("")) {
            for (String str2 : str.split("\\|")) {
                String[] strArrSplit = str2.split(",");
                if (strArrSplit.length != 7 && strArrSplit.length != 8) {
                    throw new ZebraIllegalArgumentException("Invalid alert [" + str2 + "] from printer.");
                }
                AlertCondition alertConditionCreateAlertCondition = AlertCondition.createAlertCondition(strArrSplit[0]);
                AlertDestination alertDestinationCreateAlertDestination = AlertDestination.createAlertDestination(strArrSplit[1]);
                boolean zEquals = strArrSplit[2].equals("Y");
                boolean zEquals2 = strArrSplit[3].equals("Y");
                String str3 = strArrSplit[4];
                String str4 = strArrSplit[5];
                boolean zEquals3 = strArrSplit[6].equals("Y");
                String str5 = strArrSplit.length > 7 ? strArrSplit[7] : "";
                try {
                    arrayList.add(new PrinterAlert(alertConditionCreateAlertCondition, alertDestinationCreateAlertDestination, str5, zEquals, zEquals2, str3, Integer.parseInt(str4), zEquals3));
                } catch (NumberFormatException unused) {
                    arrayList.add(new PrinterAlert(alertConditionCreateAlertCondition, alertDestinationCreateAlertDestination, str5, zEquals, zEquals2, str3, 0, zEquals3));
                }
            }
        }
        return arrayList;
    }

    private void sendAlertsViaSgd(List<PrinterAlert> list) {
        for (PrinterAlert printerAlert : list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("alerts.add", getAlertSgdValue(printerAlert));
            byte[] bArrBuildSetCommand = JsonHelper.buildSetCommand(linkedHashMap);
            Connection connectionSelectConnection = ConnectionUtil.selectConnection(this.connection);
            this.connection = connectionSelectConnection;
            connectionSelectConnection.sendAndWaitForValidResponse(bArrBuildSetCommand, connectionSelectConnection.getMaxTimeoutForRead(), this.connection.getTimeToWaitForMoreData(), new JsonValidator());
        }
    }

    public List<PrinterAlert> getAlerts() {
        return getConfiguredAlerts();
    }

    public void removeAllAlerts() {
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(this.connection);
        this.connection = connectionSelectConnection;
        connectionSelectConnection.sendAndWaitForValidResponse("{}{\"alerts.configured\":\"\"}".getBytes(), this.connection.getMaxTimeoutForRead(), this.connection.getTimeToWaitForMoreData(), new JsonValidator());
    }

    public void setAlerts(List<PrinterAlert> list) {
        sendAlertsViaSgd(list);
    }

    public AlertsUtilLinkOs(ZebraPrinterLinkOs zebraPrinterLinkOs) {
        this.connection = zebraPrinterLinkOs.getConnection();
    }

    public static void setAlerts(List<PrinterAlert> list, Connection connection) {
        new AlertsUtilLinkOs(connection).sendAlertsViaSgd(list);
    }
}
