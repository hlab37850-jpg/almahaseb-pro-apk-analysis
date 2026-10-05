package com.google.zxing.client.result;

import com.google.zxing.Result;
import defpackage.L;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class BizcardResultParser extends L {
    private static String buildName(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }

    private static String[] buildPhoneNumbers(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        String strBuildName = buildName(L.matchSingleDoCoMoPrefixedField("N:", massagedText, true), L.matchSingleDoCoMoPrefixedField("X:", massagedText, true));
        String strMatchSingleDoCoMoPrefixedField = L.matchSingleDoCoMoPrefixedField("T:", massagedText, true);
        String strMatchSingleDoCoMoPrefixedField2 = L.matchSingleDoCoMoPrefixedField("C:", massagedText, true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(strBuildName), null, null, buildPhoneNumbers(L.matchSingleDoCoMoPrefixedField("B:", massagedText, true), L.matchSingleDoCoMoPrefixedField("M:", massagedText, true), L.matchSingleDoCoMoPrefixedField("F:", massagedText, true)), null, ResultParser.maybeWrap(L.matchSingleDoCoMoPrefixedField("E:", massagedText, true)), null, null, null, L.matchDoCoMoPrefixedField("A:", massagedText, true), null, strMatchSingleDoCoMoPrefixedField2, null, strMatchSingleDoCoMoPrefixedField, null, null);
    }
}
