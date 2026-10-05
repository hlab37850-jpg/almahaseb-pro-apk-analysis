package com.zebra.sdk.settings.internal;

import com.zebra.sdk.util.internal.RegexUtil;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SettingRangeFloat implements SettingRange {
    private String max;
    private String min;

    public SettingRangeFloat(String str) {
        this.min = String.valueOf(Double.MIN_VALUE);
        this.max = String.valueOf(Double.MAX_VALUE);
        List<String> matches = RegexUtil.getMatches("^(.+)-(.+)$", str);
        if (matches.size() == 3) {
            this.min = matches.get(1);
            this.max = matches.get(2);
        }
    }

    @Override // com.zebra.sdk.settings.internal.SettingRange
    public boolean isInRange(String str) {
        boolean z = false;
        new BigDecimal(0);
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            try {
                BigDecimal bigDecimal2 = new BigDecimal(this.min);
                BigDecimal bigDecimal3 = new BigDecimal(this.max);
                if (bigDecimal.compareTo(bigDecimal2) >= 0 && bigDecimal.compareTo(bigDecimal3) <= 0) {
                    z = true;
                }
                return z;
            } catch (NumberFormatException unused) {
                return true;
            }
        } catch (NumberFormatException unused2) {
            return false;
        }
    }
}
