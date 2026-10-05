package com.zebra.sdk.printer;

import com.zebra.sdk.util.internal.FontConverterHelper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class FontConverterZpl {
    private FontConverterZpl() {
    }

    public static InputStream getTteFontHeader(InputStream inputStream, String str) {
        return FontConverterHelper.getFontHeader(inputStream, str, 'E');
    }

    public static InputStream getTtfFontHeader(InputStream inputStream, String str) {
        return FontConverterHelper.getFontHeader(inputStream, str, 'T');
    }

    public static void saveAsTtePrinterFont(InputStream inputStream, OutputStream outputStream, String str) {
        FontConverterHelper.saveFontAsPrinterFont(inputStream, outputStream, str, ".TTE");
    }

    public static void saveAsTtfPrinterFont(InputStream inputStream, OutputStream outputStream, String str) {
        FontConverterHelper.saveFontAsPrinterFont(inputStream, outputStream, str, ".TTF");
    }

    public static void saveAsTtePrinterFont(String str, OutputStream outputStream, String str2) {
        try {
            FontConverterHelper.saveFontAsPrinterFont(new FileInputStream(str), outputStream, str2, ".TTE");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void saveAsTtfPrinterFont(String str, OutputStream outputStream, String str2) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                FontConverterHelper.saveFontAsPrinterFont(fileInputStream2, outputStream, str2, ".TTF");
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                throw new RuntimeException(e.getMessage());
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e3) {
                    throw new RuntimeException(e3.getMessage());
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
        }
    }
}
