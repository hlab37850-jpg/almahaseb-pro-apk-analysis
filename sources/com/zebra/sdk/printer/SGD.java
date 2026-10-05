package com.zebra.sdk.printer;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.settings.internal.ConnectionUtil;
import com.zebra.sdk.settings.internal.JsonHelper;
import com.zebra.sdk.settings.internal.JsonValidator;
import com.zebra.sdk.settings.internal.SgdValidator;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class SGD {
    private SGD() {
    }

    public static String DO(String str, String str2, Connection connection) {
        return DO(str, str2, connection, connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData());
    }

    public static String GET(String str, Connection connection) {
        return GET(str, connection, connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData());
    }

    public static void SET(String str, int i, Connection connection) {
        SET(str, String.valueOf(i), connection);
    }

    public static String DO(String str, String str2, Connection connection, int i, int i2) {
        String str3;
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(connection);
        if (connectionSelectConnection instanceof StatusConnection) {
            HashMap map = new HashMap();
            map.put(str, str2);
            try {
                str3 = JsonHelper.parseGetResponse(connectionSelectConnection.sendAndWaitForValidResponse(JsonHelper.buildSetCommand(map), i, i2, new JsonValidator())).get(str);
            } catch (ZebraIllegalArgumentException unused) {
                str3 = "";
            }
            return str3 == null ? "" : str3;
        }
        return StringUtilities.stripQuotes(new String(connectionSelectConnection.sendAndWaitForValidResponse(("! U1 do \"" + str + "\" \"" + str2 + "\"" + StringUtilities.CRLF).getBytes(), i, i2, new SgdValidator())));
    }

    public static String GET(String str, Connection connection, int i, int i2) {
        String str2;
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(connection);
        if (connectionSelectConnection instanceof StatusConnection) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            try {
                str2 = JsonHelper.parseGetResponse(connectionSelectConnection.sendAndWaitForValidResponse(JsonHelper.buildQuery(linkedList), i, i2, new JsonValidator())).get(str);
            } catch (ZebraIllegalArgumentException unused) {
                str2 = "";
            }
            return str2 == null ? "" : str2;
        }
        return StringUtilities.stripQuotes(new String(connectionSelectConnection.sendAndWaitForValidResponse(("! U1 getvar \"" + str + "\"" + StringUtilities.CRLF).getBytes(), i, i2, new SgdValidator())));
    }

    public static void SET(String str, String str2, Connection connection) {
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(connection);
        if (connectionSelectConnection instanceof StatusConnection) {
            HashMap map = new HashMap();
            map.put(str, str2);
            connectionSelectConnection.sendAndWaitForValidResponse(JsonHelper.buildSetCommand(map), connectionSelectConnection.getMaxTimeoutForRead(), connectionSelectConnection.getTimeToWaitForMoreData(), new JsonValidator());
            return;
        }
        connectionSelectConnection.write(("! U1 setvar \"" + str + "\" \"" + str2 + "\"" + StringUtilities.CRLF).getBytes());
    }

    public static void DO(OutputStream outputStream, String str, String str2, Connection connection) throws ConnectionException {
        DO(outputStream, str, str2, connection, connection.getMaxTimeoutForRead(), connection.getTimeToWaitForMoreData());
    }

    public static void DO(OutputStream outputStream, String str, String str2, Connection connection, int i, int i2) throws ConnectionException {
        String str3;
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(connection);
        if (connectionSelectConnection instanceof StatusConnection) {
            HashMap map = new HashMap();
            map.put(str, str2);
            try {
                str3 = JsonHelper.parseGetResponse(connectionSelectConnection.sendAndWaitForValidResponse(JsonHelper.buildSetCommand(map), i, i2, new JsonValidator())).get(str);
            } catch (ZebraIllegalArgumentException unused) {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            try {
                outputStream.write(str3.getBytes());
                return;
            } catch (Exception e) {
                throw new ConnectionException(e.getLocalizedMessage());
            }
        }
        connectionSelectConnection.sendAndWaitForValidResponse(new QuoteRemovingOutputStream(outputStream), new ByteArrayInputStream(("! U1 do \"" + str + "\" \"" + str2 + "\"" + StringUtilities.CRLF).getBytes()), i, i2, new SgdValidator());
    }
}
