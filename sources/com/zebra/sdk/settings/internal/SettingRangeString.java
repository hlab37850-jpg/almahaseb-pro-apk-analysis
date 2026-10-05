package com.zebra.sdk.settings.internal;

import com.zebra.sdk.util.internal.RegexUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SettingRangeString implements SettingRange {
    private int maxLength;
    private int minLength;

    public SettingRangeString(String str) {
        this.minLength = 0;
        this.maxLength = Integer.MAX_VALUE;
        List<String> matches = RegexUtil.getMatches("^(.+)-(.+)$", str);
        if (matches.size() == 3) {
            this.minLength = Integer.parseInt(matches.get(1));
            this.maxLength = Integer.parseInt(matches.get(2));
        }
    }

    @Override // com.zebra.sdk.settings.internal.SettingRange
    public boolean isInRange(String str) {
        int length = str.length();
        return length >= this.minLength && length <= this.maxLength;
    }
}
