package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.comm.internal.PrinterCommandImpl;
import com.zebra.sdk.printer.FieldDescriptionData;
import com.zebra.sdk.util.internal.StringUtilities;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FormatUtilZpl extends FormatUtilA {
    public FormatUtilZpl(Connection connection) {
        super(connection);
    }

    public static String extractDFName(String str) {
        int iIndexOf;
        String strSubstring = "^";
        int i = 0;
        while (i > -1) {
            CommandType commandType = CommandType.dfCommand;
            IndexAndCommandType indexAndCommandTypeFindNextCommand = findNextCommand(strSubstring, i, str, commandType);
            int index = indexAndCommandTypeFindNextCommand.getIndex();
            CommandType command = indexAndCommandTypeFindNextCommand.getCommand();
            if (index > -1) {
                int i2 = index + 3;
                if (command == CommandType.ccCommand) {
                    strSubstring = str.substring(i2, index + 4);
                } else if (command == commandType && (iIndexOf = StringUtilities.indexOf(str, new String[]{strSubstring, ZPLUtilities.ZPL_INTERNAL_FORMAT_PREFIX}, i2)) > -1) {
                    return str.substring(i2, iIndexOf);
                }
                i = i2;
            } else {
                i = index;
            }
        }
        return null;
    }

    private static IndexAndCommandType findNext(String str, String str2, int i, String str3, CommandType commandType) {
        String str4 = str + commandType.getId();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        CommandType commandType2 = CommandType.ccCommand;
        sb.append(commandType2.getId());
        return findSpecifiedCommand(i, str3, new String[]{str4, sb.toString(), str2 + commandType2.getId(), str + CommandType.xgCommand.getId() + str4});
    }

    private static IndexAndCommandType findNextCommand(String str, int i, String str2, CommandType commandType) {
        IndexAndCommandType indexAndCommandTypeFindNext = findNext(str, "~", i, str2, commandType);
        return indexAndCommandTypeFindNext.getIndex() == -1 ? findNext(ZPLUtilities.ZPL_INTERNAL_FORMAT_PREFIX, ZPLUtilities.ZPL_INTERNAL_COMMAND_PREFIX, i, str2, commandType) : indexAndCommandTypeFindNext;
    }

    private static int findOccurance(List<FieldDescriptionData> list, FieldDescriptionData fieldDescriptionData) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).fieldNumber == fieldDescriptionData.fieldNumber) {
                return i;
            }
        }
        return -1;
    }

    private static IndexAndCommandType findSpecifiedCommand(int i, String str, String[] strArr) {
        int iIndexOf = StringUtilities.indexOf(str.toLowerCase(), strArr, i);
        return new IndexAndCommandType(iIndexOf, iIndexOf > -1 ? CommandType.getCommand(str.substring(iIndexOf + 1, iIndexOf + 3)) : CommandType.unknownCommand);
    }

    public static String generateStoredFormat(String str, Map<Integer, String> map) {
        return generateStoredFormat(str, map, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c A[Catch: MalformedFormatException -> 0x0050, PHI: r3 r7
      0x004c: PHI (r3v9 com.zebra.sdk.printer.FieldDescriptionData) = 
      (r3v8 com.zebra.sdk.printer.FieldDescriptionData)
      (r3v8 com.zebra.sdk.printer.FieldDescriptionData)
      (r3v14 com.zebra.sdk.printer.FieldDescriptionData)
      (r3v14 com.zebra.sdk.printer.FieldDescriptionData)
     binds: [B:28:0x0074, B:31:0x007a, B:15:0x0043, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r7v2 int) = (r7v1 int), (r7v1 int), (r7v0 int), (r7v0 int) binds: [B:28:0x0074, B:31:0x007a, B:15:0x0043, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {MalformedFormatException -> 0x0050, blocks: (B:14:0x003b, B:16:0x0045, B:18:0x0049, B:19:0x004c, B:27:0x006c, B:29:0x0076, B:31:0x007a), top: B:37:0x003b }] */
    public static FieldDescriptionData[] getVariableFieldsS(String str) {
        FieldDescriptionData fnCommand;
        ArrayList arrayList = new ArrayList();
        String strSubstring = "^";
        int i = 0;
        while (i > -1) {
            CommandType commandType = CommandType.fnCommand;
            IndexAndCommandType indexAndCommandTypeFindNextCommand = findNextCommand(strSubstring, i, str, commandType);
            int index = indexAndCommandTypeFindNextCommand.getIndex();
            CommandType command = indexAndCommandTypeFindNextCommand.getCommand();
            if (index > -1) {
                int i2 = index + 3;
                if (command == CommandType.ccCommand) {
                    strSubstring = str.substring(i2, index + 4);
                } else if (command == commandType) {
                    int iIndexOf = StringUtilities.indexOf(str, new String[]{strSubstring, ZPLUtilities.ZPL_INTERNAL_FORMAT_PREFIX}, i2);
                    if (iIndexOf > -1) {
                        try {
                            fnCommand = parseFnCommand(str.substring(i2, iIndexOf));
                            int iFindOccurance = findOccurance(arrayList, fnCommand);
                            if (iFindOccurance == -1) {
                                arrayList.add(fnCommand);
                            } else if (fnCommand.fieldName != null) {
                                arrayList.remove(iFindOccurance);
                                arrayList.add(fnCommand);
                            }
                        } catch (MalformedFormatException unused) {
                        }
                    }
                } else if (command == CommandType.xgCommand) {
                    i2 = index + 6;
                    int i3 = index + 6;
                    int iIndexOf2 = StringUtilities.indexOf(str, new String[]{",", ZPLUtilities.ZPL_INTERNAL_DELIMITER}, i3);
                    if (iIndexOf2 > -1) {
                        fnCommand = parseFnCommand(str.substring(i3, iIndexOf2));
                        int iFindOccurance2 = findOccurance(arrayList, fnCommand);
                        if (iFindOccurance2 == -1) {
                            arrayList.add(fnCommand);
                        } else if (fnCommand.fieldName != null) {
                            arrayList.remove(iFindOccurance2);
                            arrayList.add(fnCommand);
                        }
                    }
                }
                i = i2;
            } else {
                i = index;
            }
        }
        return (FieldDescriptionData[]) arrayList.toArray(new FieldDescriptionData[0]);
    }

    private boolean isOnlySettingsChannelOpen(MultichannelConnection multichannelConnection) {
        return multichannelConnection.getStatusChannel().isConnected() && !multichannelConnection.getPrintingChannel().isConnected();
    }

    private static FieldDescriptionData parseFnCommand(String str) throws MalformedFormatException {
        int iIndexOf = str.indexOf(34, 0);
        if (iIndexOf == -1) {
            try {
                int i = Integer.parseInt(str.trim());
                if (i < 1 || i > 9999) {
                    throw new MalformedFormatException("'^FN' integer must be between 1 and 9999");
                }
                return new FieldDescriptionData(i, null);
            } catch (NumberFormatException unused) {
                throw new MalformedFormatException("'^FN' must be followed by an integer");
            }
        }
        if (iIndexOf + 1 >= str.length()) {
            return null;
        }
        try {
            String strStripQuotes = StringUtilities.stripQuotes(str.substring(iIndexOf).trim());
            int i2 = Integer.parseInt(str.substring(0, iIndexOf).trim());
            if (i2 < 1 || i2 > 9999) {
                throw new MalformedFormatException("'^FN' integer must be between 1 and 9999");
            }
            return new FieldDescriptionData(i2, strStripQuotes);
        } catch (NumberFormatException unused2) {
            throw new MalformedFormatException("'^FN' must be followed by an integer");
        }
    }

    private void throwExceptionStatusOnly() throws ConnectionException {
        Connection connection = this.printerConnection;
        if (connection instanceof MultichannelConnection) {
            if (isOnlySettingsChannelOpen((MultichannelConnection) connection)) {
                throw new ConnectionException("Operation cannot be performed with only the status channel open");
            }
        } else if (connection instanceof StatusConnection) {
            throw new ConnectionException("Operation cannot be performed over the status channel");
        }
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public FieldDescriptionData[] getVariableFields(String str) {
        return getVariableFieldsS(str);
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map) throws ConnectionException {
        try {
            printStoredFormat(str, map, System.getProperty("file.encoding"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void retrieveFormatFromPrinter(OutputStream outputStream, String str) {
        if (str == null || str.equals("")) {
            return;
        }
        new PrinterCommandImpl(ZPLUtilities.decorateWithFormatPrefix("^XA^HF" + str + "^XZ")).sendAndWaitForResponse(outputStream, this.printerConnection);
    }

    public static String generateStoredFormat(String str, Map<Integer, String> map, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("^XA\r\n");
        stringBuffer.append("^XF");
        stringBuffer.append(str);
        stringBuffer.append("^FS\r\n");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            stringBuffer.append("^FN");
            stringBuffer.append(entry.getKey());
            stringBuffer.append("^FD");
            stringBuffer.append(entry.getValue());
            stringBuffer.append("^FS\r\n");
        }
        if (str2 != null && !str2.equals("")) {
            stringBuffer.append("^PQ" + str2 + StringUtilities.CRLF);
        }
        stringBuffer.append("^XZ");
        return ZPLUtilities.decorateWithFormatPrefix(stringBuffer.toString());
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public void printStoredFormat(String str, Map<Integer, String> map, String str2) throws ConnectionException {
        throwExceptionStatusOnly();
        this.printerConnection.write(generateStoredFormat(str, map).getBytes(str2));
    }

    @Override // com.zebra.sdk.printer.FormatUtil
    public byte[] retrieveFormatFromPrinter(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return new PrinterCommandImpl(ZPLUtilities.decorateWithFormatPrefix("^XA^HF" + str + "^XZ")).sendAndWaitForResponse(this.printerConnection);
    }
}
