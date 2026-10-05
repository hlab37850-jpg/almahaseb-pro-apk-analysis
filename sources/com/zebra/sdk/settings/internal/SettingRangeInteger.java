package com.zebra.sdk.settings.internal;

import androidx.core.location.LocationRequestCompat;
import com.zebra.sdk.util.internal.RegexUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SettingRangeInteger implements SettingRange {
    private long max;
    private long min;

    public SettingRangeInteger(String str) {
        this.min = Long.MIN_VALUE;
        this.max = LocationRequestCompat.PASSIVE_INTERVAL;
        List<String> matches = RegexUtil.getMatches("^(.+)-(.+)$", str);
        if (matches.size() == 3) {
            this.min = Long.parseLong(matches.get(1));
            this.max = Long.parseLong(matches.get(2));
        }
    }

    @Override // com.zebra.sdk.settings.internal.SettingRange
    public boolean isInRange(String str) {
        try {
            long j = Long.parseLong(str);
            return j >= this.min && j <= this.max;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
