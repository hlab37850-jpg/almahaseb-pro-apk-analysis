package com.zebra.sdk.settings;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.settings.internal.ConnectionUtil;
import com.zebra.sdk.settings.internal.JsonHelper;
import com.zebra.sdk.settings.internal.JsonValidator;
import com.zebra.sdk.settings.internal.SgdValidator;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsValues {
    private Map<String, String> getValuesUsingJson(List<String> list, Connection connection) {
        return JsonHelper.parseGetResponse(connection.sendAndWaitForValidResponse(JsonHelper.buildQuery(list), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), new JsonValidator()));
    }

    private Map<String, String> getValuesUsingSGD(List<String> list, Connection connection) {
        HashMap map = new HashMap();
        for (String str : list) {
            String strStripQuotes = StringUtilities.stripQuotes(new String(connection.sendAndWaitForValidResponse(("! U1 getvar \"" + str + "\"" + StringUtilities.CRLF).getBytes(), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), new SgdValidator())));
            if (strStripQuotes.equals("?")) {
                strStripQuotes = null;
            }
            map.put(str, strStripQuotes);
        }
        return map;
    }

    private Map<String, String> setValuesUsingJson(Map<String, String> map, Connection connection) {
        return JsonHelper.parseGetResponse(connection.sendAndWaitForValidResponse(JsonHelper.buildSetCommand(map), connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData(), new JsonValidator()));
    }

    private Map<String, String> setValuesUsingSGD(Map<String, String> map, Connection connection) {
        for (String str : map.keySet()) {
            connection.write(("! U1 setvar \"" + str + "\" \"" + map.get(str) + "\"" + StringUtilities.CRLF).getBytes());
        }
        return getValuesUsingSGD(new ArrayList(map.keySet()), connection);
    }

    private boolean shouldUseJson(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        boolean zIsConnected;
        boolean zIsConnected2;
        if (linkOsInformation == null || linkOsInformation.getMajor() < 1) {
            return false;
        }
        boolean z = printerLanguage == PrinterLanguage.LINE_PRINT;
        if (connection instanceof MultichannelConnection) {
            MultichannelConnection multichannelConnection = (MultichannelConnection) connection;
            zIsConnected = multichannelConnection.getStatusChannel().isConnected();
            zIsConnected2 = multichannelConnection.getPrintingChannel().isConnected();
        } else {
            zIsConnected = connection instanceof StatusConnection;
            zIsConnected2 = !zIsConnected;
        }
        return zIsConnected || (zIsConnected2 && !z);
    }

    public Map<String, String> getValues(List<String> list, Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(connection);
        return shouldUseJson(connection, printerLanguage, linkOsInformation) ? getValuesUsingJson(list, connectionSelectConnection) : getValuesUsingSGD(list, connectionSelectConnection);
    }

    public Map<String, String> setValues(Map<String, String> map, Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(connection);
        return shouldUseJson(connection, printerLanguage, linkOsInformation) ? setValuesUsingJson(map, connectionSelectConnection) : setValuesUsingSGD(map, connectionSelectConnection);
    }
}
