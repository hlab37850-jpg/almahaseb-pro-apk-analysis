package com.zebra.sdk.settings.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SettingRangeChoices implements SettingRange {
    private List<String> availableChoices = new ArrayList();

    public SettingRangeChoices(String str) {
        for (String str2 : str.split(",")) {
            this.availableChoices.add(str2.trim());
        }
    }

    @Override // com.zebra.sdk.settings.internal.SettingRange
    public boolean isInRange(String str) {
        return this.availableChoices.contains(str);
    }
}
