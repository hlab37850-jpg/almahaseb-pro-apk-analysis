package com.google.zxing.client.result;

import com.google.zxing.Result;
import defpackage.L;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class EmailDoCoMoResultParser extends L {
    private static final Pattern ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public static boolean isBasicallyValidEmailAddress(String str) {
        return str != null && ATEXT_ALPHANUMERIC.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String[] strArrMatchDoCoMoPrefixedField;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("MATMSG:") || (strArrMatchDoCoMoPrefixedField = L.matchDoCoMoPrefixedField("TO:", massagedText, true)) == null) {
            return null;
        }
        for (String str : strArrMatchDoCoMoPrefixedField) {
            if (!isBasicallyValidEmailAddress(str)) {
                return null;
            }
        }
        return new EmailAddressParsedResult(strArrMatchDoCoMoPrefixedField, null, null, L.matchSingleDoCoMoPrefixedField("SUB:", massagedText, false), L.matchSingleDoCoMoPrefixedField("BODY:", massagedText, false));
    }
}
