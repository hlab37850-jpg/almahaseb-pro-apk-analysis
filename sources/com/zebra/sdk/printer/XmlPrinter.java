package com.zebra.sdk.printer;

import com.zebra.sdk.printer.internal.VerbosePrinter;
import com.zebra.sdk.printer.internal.XmlToCsvConverter;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class XmlPrinter {
    private XmlPrinter() {
    }

    public static void print(InputStream inputStream, String str, String str2, OutputStream outputStream) throws Throwable {
        print(null, inputStream, str, str2, outputStream, false);
    }

    public static void print(InputStream inputStream, String str, String str2, OutputStream outputStream, boolean z) throws Throwable {
        print(null, inputStream, str, str2, outputStream, z);
    }

    public static void print(String str, InputStream inputStream, String str2, String str3, OutputStream outputStream) throws Throwable {
        print(str, inputStream, str2, str3, outputStream, false);
    }

    public static void print(String str, InputStream inputStream, String str2, String str3, OutputStream outputStream, boolean z) throws Throwable {
        try {
            VerbosePrinter verbosePrinter = new VerbosePrinter(z);
            verbosePrinter.println("Starting XML print...");
            verbosePrinter.print("Converting XML data to CSV...");
            InputStream inputStreamConvert = XmlToCsvConverter.convert(inputStream);
            verbosePrinter.println("done.");
            CsvPrinter.print(str, inputStreamConvert, str2, str3, outputStream, z);
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage().replace("org.xml.sax.SAXParseException", "Error parsing xml"));
        }
    }
}
