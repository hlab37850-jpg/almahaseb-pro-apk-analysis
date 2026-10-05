package com.zebra.sdk.printer;

import au.com.bytecode.opencsv.CSVReader;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.MultichannelConnection;
import com.zebra.sdk.comm.StatusConnection;
import com.zebra.sdk.comm.internal.ConnectionBuilderInternal;
import com.zebra.sdk.printer.internal.CsvPrinterHelper;
import com.zebra.sdk.printer.internal.FormatUtilZpl;
import com.zebra.sdk.printer.internal.TemplateInfo;
import com.zebra.sdk.printer.internal.UnicodeReader;
import com.zebra.sdk.printer.internal.UseDefaultMappingException;
import com.zebra.sdk.printer.internal.VerbosePrinter;
import com.zebra.sdk.util.internal.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CsvPrinter {
    private CsvPrinter() {
    }

    private static Map<Integer, String> convertToKeyedByFieldNumber(String[] strArr, TemplateInfo templateInfo) {
        Map<String, String> singleLineFormat = CsvPrinterHelper.parseSingleLineFormat(strArr);
        HashMap map = new HashMap();
        for (String str : singleLineFormat.keySet()) {
            for (FieldDescriptionData fieldDescriptionData : templateInfo.variableFields) {
                if (str.equals(fieldDescriptionData.fieldName)) {
                    map.put(Integer.valueOf(fieldDescriptionData.fieldNumber), singleLineFormat.get(str));
                }
            }
        }
        return map;
    }

    private static boolean csvDataIsSingleLineWithVariables(List<String[]> list) {
        return list.size() == 1 && CsvPrinterHelper.parseSingleLineFormat(list.get(0)).size() != 0;
    }

    private static void doOutput(String str, String str2, String str3, OutputStream outputStream, TemplateInfo templateInfo, Map<Integer, String> map) throws Throwable {
        String strGenerateStoredFormat = FormatUtilZpl.generateStoredFormat(templateInfo.pathOnPrinter, map, str3);
        if (outputStream != null) {
            outputStream.write(strGenerateStoredFormat.getBytes("utf8"));
        }
        if (str != null) {
            sendStuffToPrinter(str, strGenerateStoredFormat.getBytes());
        }
    }

    private static boolean doesNotHavePrintChannel(Connection connection) {
        return connection instanceof MultichannelConnection ? !((MultichannelConnection) connection).getPrintingChannel().isConnected() : connection instanceof StatusConnection;
    }

    private static boolean hasPrintingChannel(Connection connection) {
        return connection instanceof MultichannelConnection ? ((MultichannelConnection) connection).getPrintingChannel().isConnected() : !(connection instanceof StatusConnection);
    }

    private static boolean isChannelInvalidForZpl(Connection connection, PrinterLanguage printerLanguage) {
        boolean z = hasPrintingChannel(connection) && printerLanguage == PrinterLanguage.LINE_PRINT;
        return !z ? doesNotHavePrintChannel(connection) : z;
    }

    public static void print(InputStream inputStream, String str, String str2, OutputStream outputStream) throws Throwable {
        print(null, inputStream, str, str2, outputStream, false);
    }

    private static void sendStuffToPrinter(String str, byte[] bArr) throws Throwable {
        Connection connectionBuild;
        try {
            connectionBuild = ConnectionBuilderInternal.build(str);
            try {
                connectionBuild.open();
                PrinterLanguage printerControlLanguage = PrinterLanguage.ZPL;
                ZebraPrinterLinkOs linkOsPrinter = ZebraPrinterFactory.getLinkOsPrinter(connectionBuild);
                if (linkOsPrinter != null) {
                    printerControlLanguage = linkOsPrinter.getPrinterControlLanguage();
                }
                if (isChannelInvalidForZpl(connectionBuild, printerControlLanguage)) {
                    throw new ConnectionException("Cannot send Zpl - printer is in line mode or port is status port.");
                }
                connectionBuild.write(bArr);
                connectionBuild.close();
            } catch (Throwable th) {
                th = th;
                if (connectionBuild != null) {
                    connectionBuild.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            connectionBuild = null;
        }
    }

    public static void print(InputStream inputStream, String str, String str2, OutputStream outputStream, boolean z) throws Throwable {
        print(null, inputStream, str, str2, outputStream, z);
    }

    public static void print(String str, InputStream inputStream, String str2, String str3, OutputStream outputStream) throws Throwable {
        print(str, inputStream, str2, str3, outputStream, false);
    }

    public static void print(String str, InputStream inputStream, String str2, String str3, OutputStream outputStream, boolean z) throws Throwable {
        String str4;
        VerbosePrinter verbosePrinter = new VerbosePrinter(z);
        verbosePrinter.println("Reading CSV data...");
        UnicodeReader unicodeReader = new UnicodeReader(inputStream, "utf8");
        CSVReader cSVReader = new CSVReader(unicodeReader);
        List<String[]> all = cSVReader.readAll();
        cSVReader.close();
        unicodeReader.close();
        verbosePrinter.println(String.format("CSV Data contains %d lines...", Integer.valueOf(all.size())));
        for (String[] strArr : all) {
            verbosePrinter.print(String.format("This lines contains %d items...", Integer.valueOf(strArr.length)));
            for (String str5 : strArr) {
                verbosePrinter.print(String.format("<%s>", str5));
            }
            verbosePrinter.println("");
        }
        verbosePrinter.println("...end of CSV Data");
        int[] iArr = {-1};
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.acquire(str, str2);
        verbosePrinter.println("Done acquiring template");
        int length = templateInfo.variableFields.length;
        int[] iArrExtractFdsByColumnHeading = new int[length];
        for (int i = 0; i < length; i++) {
            iArrExtractFdsByColumnHeading[i] = i;
        }
        if (templateInfo.isLocalToComputer && str != null) {
            sendStuffToPrinter(str, FileReader.toByteArray(str2));
        }
        if (csvDataIsSingleLineWithVariables(all)) {
            verbosePrinter.println("Is single line w/variables");
            Map<Integer, String> mapConvertToKeyedByFieldNumber = convertToKeyedByFieldNumber((String[]) all.get(0), templateInfo);
            verbosePrinter.println("Done convertToKeyedByFieldNumber");
            doOutput(str, str2, str3, outputStream, templateInfo, mapConvertToKeyedByFieldNumber);
            str4 = "Printed the line of CSV";
        } else {
            verbosePrinter.println("Is not single line w/variables");
            try {
                verbosePrinter.println("Getting first line of data...");
                String[] strArr2 = (String[]) all.get(0);
                verbosePrinter.println("...extracted first line of data");
                iArrExtractFdsByColumnHeading = CsvPrinterHelper.extractFdsByColumnHeading(templateInfo.variableFields, strArr2, iArr);
                verbosePrinter.println("Done extractFdsByColumnHeading");
                all.remove(0);
            } catch (UseDefaultMappingException unused) {
            }
            int[] iArr2 = iArrExtractFdsByColumnHeading;
            verbosePrinter.println("Starting CSV processing...");
            for (String[] strArr3 : all) {
                HashMap map = new HashMap();
                if (templateInfo.variableFields.length <= strArr3.length) {
                    int i2 = 0;
                    while (true) {
                        FieldDescriptionData[] fieldDescriptionDataArr = templateInfo.variableFields;
                        if (i2 >= fieldDescriptionDataArr.length) {
                            break;
                        }
                        map.put(Integer.valueOf(fieldDescriptionDataArr[i2].fieldNumber), strArr3[iArr2[i2]]);
                        i2++;
                    }
                    int i3 = iArr[0];
                    doOutput(str, str2, i3 >= 0 ? strArr3[i3] : str3, outputStream, templateInfo, map);
                    verbosePrinter.println("...printed a line of CSV");
                }
            }
            str4 = "Done processing CSV";
        }
        verbosePrinter.println(str4);
    }
}
