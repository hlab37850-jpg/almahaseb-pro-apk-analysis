package com.google.zxing.client.result;

import com.google.zxing.Result;
import defpackage.L;

/* JADX INFO: loaded from: classes3.dex */
public final class AddressBookDoCoMoResultParser extends L {
    private static String parseName(String str) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return str;
        }
        return str.substring(iIndexOf + 1) + ' ' + str.substring(0, iIndexOf);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String[] strArrMatchDoCoMoPrefixedField;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("MECARD:") || (strArrMatchDoCoMoPrefixedField = L.matchDoCoMoPrefixedField("N:", massagedText, true)) == null) {
            return null;
        }
        String name = parseName(strArrMatchDoCoMoPrefixedField[0]);
        String strMatchSingleDoCoMoPrefixedField = L.matchSingleDoCoMoPrefixedField("SOUND:", massagedText, true);
        String[] strArrMatchDoCoMoPrefixedField2 = L.matchDoCoMoPrefixedField("TEL:", massagedText, true);
        String[] strArrMatchDoCoMoPrefixedField3 = L.matchDoCoMoPrefixedField("EMAIL:", massagedText, true);
        String strMatchSingleDoCoMoPrefixedField2 = L.matchSingleDoCoMoPrefixedField("NOTE:", massagedText, false);
        String[] strArrMatchDoCoMoPrefixedField4 = L.matchDoCoMoPrefixedField("ADR:", massagedText, true);
        String strMatchSingleDoCoMoPrefixedField3 = L.matchSingleDoCoMoPrefixedField("BDAY:", massagedText, true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(name), null, strMatchSingleDoCoMoPrefixedField, strArrMatchDoCoMoPrefixedField2, null, strArrMatchDoCoMoPrefixedField3, null, null, strMatchSingleDoCoMoPrefixedField2, strArrMatchDoCoMoPrefixedField4, null, L.matchSingleDoCoMoPrefixedField("ORG:", massagedText, true), !ResultParser.isStringOfDigits(strMatchSingleDoCoMoPrefixedField3, 8) ? null : strMatchSingleDoCoMoPrefixedField3, null, L.matchDoCoMoPrefixedField("URL:", massagedText, true), null);
    }
}
