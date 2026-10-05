package org.apache.poi.ss.util;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes4.dex */
public class WorkbookUtil {
    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    public static final String createSafeSheetName(String str) {
        if (str == null) {
            return "null";
        }
        if (str.length() < 1) {
            return "empty";
        }
        int iMin = Math.min(31, str.length());
        StringBuilder sb = new StringBuilder(str.substring(0, iMin));
        for (int i = 0; i < iMin; i++) {
            char cCharAt = sb.charAt(i);
            if (cCharAt != '\'') {
                if (cCharAt != '*' && cCharAt != '/' && cCharAt != '?') {
                    switch (cCharAt) {
                        case '[':
                        case '\\':
                        case ']':
                            sb.setCharAt(i, ' ');
                            break;
                    }
                } else {
                    sb.setCharAt(i, ' ');
                }
            } else if (i == 0 || i == iMin - 1) {
                sb.setCharAt(i, ' ');
            }
        }
        return sb.toString();
    }

    public static void validateSheetName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        int length = str.length();
        if (length < 1) {
            throw new IllegalArgumentException("sheetName must not be empty string");
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '*' && cCharAt != '/' && cCharAt != ':' && cCharAt != '?') {
                switch (cCharAt) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        break;
                }
            }
            throw new IllegalArgumentException("Invalid char (" + cCharAt + ") found at index (" + i + ") in sheet name '" + str + "'");
        }
        if (str.charAt(0) == '\'' || str.charAt(length - 1) == '\'') {
            throw new IllegalArgumentException("Invalid sheet name '" + str + "'. Sheet names must not begin or end with (').");
        }
    }

    public static void validateSheetState(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return;
        }
        throw new IllegalArgumentException("Ivalid sheet state : " + i + StringUtilities.LF + "Sheet state must beone of the Workbook.SHEET_STATE_* constants");
    }
}
