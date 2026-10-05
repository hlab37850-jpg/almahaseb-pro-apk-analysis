package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.util.internal.Base64;
import com.zebra.sdk.util.internal.CustomGZIPInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DY_UnwrapperStream extends ZplUnwrapperStreamBase {
    DY_SourceDataType dy_SourceDataType;

    public enum DY_SourceDataType {
        UNCOMPRESSED("A"),
        BINARY("B"),
        PNG("P");

        private String formatDownloadedInDataField;

        DY_SourceDataType(String str) {
            this.formatDownloadedInDataField = str;
        }

        public static DY_SourceDataType getSourceType(String str) throws IOException {
            for (DY_SourceDataType dY_SourceDataType : values()) {
                if (dY_SourceDataType.formatDownloadedInDataField.equalsIgnoreCase(str)) {
                    return dY_SourceDataType;
                }
            }
            throw new IOException("Invalid ~DY Header  --  Missing Format Downloaded In Data Field parameter");
        }
    }

    public DY_UnwrapperStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IOException("input stream is null");
        }
        DYDataProviderStream dYDataProviderStream = new DYDataProviderStream(inputStream);
        this.unwrappedType = PrinterFileType.getUnwrappedType("~DY_" + dYDataProviderStream.getFileExtensionCode());
        this.dy_SourceDataType = DY_SourceDataType.getSourceType(dYDataProviderStream.getFormatDownloadedInDataField());
        InputStream dataDecodingStream = getDataDecodingStream(dYDataProviderStream);
        this.dataUnwrapperStream = dataDecodingStream;
        if (shouldPrependZebraImageHeader()) {
            this.dataUnwrapperStream = getImageStream(dataDecodingStream, dYDataProviderStream.getBytesPerRow(), dYDataProviderStream.getTotalBytesInData());
        }
        this.fileNameOnPrinter = dYDataProviderStream.getFilenameOnPrinter();
    }

    private InputStream getDataDecodingStream(DYDataProviderStream dYDataProviderStream) {
        InputStream asciiDecoderStream;
        if (dYDataProviderStream.getDataFormatSpecifier() == DataFormatSpecifier.MIME_UNCOMPRESSED) {
            asciiDecoderStream = new Base64.InputStream(new ColonSignifiesEndStream(dYDataProviderStream), 0);
        } else if (dYDataProviderStream.getDataFormatSpecifier() == DataFormatSpecifier.MIME_COMPRESSED) {
            asciiDecoderStream = new CustomGZIPInputStream(new Base64.InputStream(new ColonSignifiesEndStream(dYDataProviderStream), 0));
        } else {
            if (dYDataProviderStream.getDataFormatSpecifier() != DataFormatSpecifier.ASCII_HEX) {
                return dYDataProviderStream;
            }
            asciiDecoderStream = new AsciiDecoderStream(dYDataProviderStream, dYDataProviderStream.getBytesPerRow());
        }
        return asciiDecoderStream;
    }

    private InputStream getImageStream(InputStream inputStream, int i, int i2) {
        InputStream printerPngToGrfConverterStream;
        ZebraImageHeaderPrependerStream zebraImageHeaderPrependerStream = new ZebraImageHeaderPrependerStream(inputStream, i, i2);
        if (shouldConvertFromGrfToPng()) {
            printerPngToGrfConverterStream = new GrfToPrinterPngConverterStream(zebraImageHeaderPrependerStream);
        } else {
            if (!shouldConvertFromPngToGrf()) {
                return zebraImageHeaderPrependerStream;
            }
            printerPngToGrfConverterStream = new PrinterPngToGrfConverterStream(zebraImageHeaderPrependerStream);
        }
        return printerPngToGrfConverterStream;
    }

    private boolean shouldConvertFromGrfToPng() {
        return this.dy_SourceDataType == DY_SourceDataType.UNCOMPRESSED && this.unwrappedType == PrinterFileType.PRINTER_PNG;
    }

    private boolean shouldConvertFromPngToGrf() {
        return this.dy_SourceDataType == DY_SourceDataType.PNG && this.unwrappedType == PrinterFileType.PRINTER_GRF;
    }

    private boolean shouldPrependZebraImageHeader() {
        PrinterFileType printerFileType = this.unwrappedType;
        return printerFileType == PrinterFileType.PRINTER_GRF || printerFileType == PrinterFileType.PRINTER_PNG;
    }

    @Override // com.zebra.sdk.util.fileConversion.internal.ZplUnwrapperStreamBase
    public PrinterWrappingType getTypeToUnwrap() {
        return PrinterWrappingType.DY;
    }
}
