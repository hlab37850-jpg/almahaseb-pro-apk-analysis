package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.FieldDescriptionData;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FormatUtilCpcl extends FormatUtilA {
    public FormatUtilCpcl(Connection connection) {
        super(connection);
    }

    public int countVariableFields(String str) {
        return StringUtilities.countSubstringOccurences(str, "\\\\");
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public FieldDescriptionData[] getVariableFields(String str) {
        int iCountVariableFields = countVariableFields(str);
        FieldDescriptionData[] fieldDescriptionDataArr = new FieldDescriptionData[iCountVariableFields];
        int i = 0;
        while (i < iCountVariableFields) {
            int i2 = i + 1;
            fieldDescriptionDataArr[i] = new FieldDescriptionData(i2, null);
            i = i2;
        }
        return fieldDescriptionDataArr;
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map) {
        try {
            printStoredFormat(str, map, System.getProperty("file.encoding"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void retrieveFormatFromPrinter(OutputStream outputStream, String str) throws ConnectionException {
        SGD.DO(outputStream, "file.type", str, this.printerConnection);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("! UF ");
        stringBuffer.append(str);
        stringBuffer.append(StringUtilities.CRLF);
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            stringBuffer.append(map.get(it.next()));
            stringBuffer.append(StringUtilities.CRLF);
        }
        this.printerConnection.write(stringBuffer.toString().getBytes(str2));
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public byte[] retrieveFormatFromPrinter(String str) {
        return SGD.DO("file.type", str, this.printerConnection).getBytes();
    }
}
