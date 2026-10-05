package com.zebra.sdk.settings.internal;

import com.zebra.sdk.util.internal.IPAddressUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SettingRangeIpV4Address implements SettingRange {
    public SettingRangeIpV4Address(String str) {
    }

    @Override // com.zebra.sdk.settings.internal.SettingRange
    public boolean isInRange(String str) {
        return IPAddressUtil.ipAddressIsValid(str);
    }
}
