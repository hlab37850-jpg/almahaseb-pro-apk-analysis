package com.zebra.sdk.settings.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.settings.SettingsException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraSettingsListFromConnection extends ZebraSettingsList {
    private Connection connection;

    public ZebraSettingsListFromConnection(Connection connection) {
        this.connection = connection;
    }

    private Map<String, String> doJsonQuery(List<String> list) {
        byte[] bArrBuildQuery = JsonHelper.buildQuery(list);
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(this.connection);
        return JsonHelper.parseGetResponse(connectionSelectConnection.sendAndWaitForValidResponse(bArrBuildQuery, connectionSelectConnection.getMaxTimeoutForRead(), connectionSelectConnection.getTimeToWaitForMoreData(), new JsonValidator()));
    }

    private byte[] storeSettingValues(Map<String, String> map) throws SettingsException {
        byte[] bArrBuildSetCommand = JsonHelper.buildSetCommand(map);
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(this.connection);
        try {
            return connectionSelectConnection.sendAndWaitForValidResponse(bArrBuildSetCommand, connectionSelectConnection.getMaxTimeoutForRead(), connectionSelectConnection.getTimeToWaitForMoreData(), new JsonValidator());
        } catch (ConnectionException e) {
            throw new SettingsException(e.getMessage());
        }
    }

    private byte[] updateSettingsWithResponse(Map<String, String> map) {
        for (String str : map.keySet()) {
            try {
                if (map.get(str) != null) {
                    updateInternalState(str, map.get(str));
                }
            } catch (SettingsException unused) {
            }
        }
        return storeSettingValues(map);
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsList
    public byte[] getUpdatedJsonData() {
        Connection connectionSelectConnection = ConnectionUtil.selectConnection(this.connection);
        return connectionSelectConnection.sendAndWaitForValidResponse("{}{\"allconfig\":null}".getBytes(), connectionSelectConnection.getMaxTimeoutForRead(), connectionSelectConnection.getTimeToWaitForMoreData(), new JsonValidator());
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsList, com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Map<String, String> getValues(List<String> list) {
        return doJsonQuery(filterOutUnreadableSettings(list));
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public Map<String, String> processSettingsViaMap(Map<String, String> map) throws SettingsException {
        try {
            return JsonHelper.parseGetResponse(updateSettingsWithResponse(map));
        } catch (ZebraIllegalArgumentException e) {
            throw new SettingsException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setAllSettings(Map<String, Setting> map) {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setSetting(String str, Setting setting) {
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setSettings(Map<String, String> map) {
        updateSettingsWithResponse(map);
    }

    @Override // com.zebra.sdk.settings.internal.ZebraSettingsList, com.zebra.sdk.settings.internal.ZebraSettingsListI
    public void setSetting(String str, String str2) throws SettingsException {
        updateInternalState(str, str2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, str2);
        storeSettingValues(linkedHashMap);
    }
}
