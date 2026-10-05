package com.zebra.sdk.settings.internal;

/* JADX INFO: loaded from: classes3.dex */
public class SettingRangeNull implements SettingRange {
    private final boolean alwaysReturnTrueToAvoidFailingIfRangeIsNotProvided = true;

    @Override // com.zebra.sdk.settings.internal.SettingRange
    public boolean isInRange(String str) {
        return true;
    }

    public String toString() {
        return "";
    }
}
