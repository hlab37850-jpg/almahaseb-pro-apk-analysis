package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.util.internal.Base64;
import com.zebra.sdk.util.internal.CustomGZIPInputStream;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.PrinterFilePath;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DZ_UnwrapperStream extends ZplUnwrapperStreamBase {
    private InputStream sourceStream;

    /* JADX WARN: Code duplicated, block: B:14:0x005a A[Catch: ZebraIllegalArgumentException -> 0x005e, TryCatch #0 {ZebraIllegalArgumentException -> 0x005e, blocks: (B:12:0x003c, B:14:0x005a, B:17:0x0060), top: B:24:0x003c }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0060 A[Catch: ZebraIllegalArgumentException -> 0x005e, TRY_LEAVE, TryCatch #0 {ZebraIllegalArgumentException -> 0x005e, blocks: (B:12:0x003c, B:14:0x005a, B:17:0x0060), top: B:24:0x003c }] */
    public DZ_UnwrapperStream(InputStream inputStream) throws IOException {
        InputStream customGZIPInputStream;
        PrinterFilePath driveAndExtension;
        this.sourceStream = inputStream;
        if (inputStream == null) {
            throw new IOException("input stream is null");
        }
        DZ_DataProviderStream dZ_DataProviderStream = new DZ_DataProviderStream(inputStream);
        try {
            if (dZ_DataProviderStream.getDataFormatSpecifier() != DataFormatSpecifier.MIME_UNCOMPRESSED) {
                if (dZ_DataProviderStream.getDataFormatSpecifier() == DataFormatSpecifier.MIME_COMPRESSED) {
                    customGZIPInputStream = new CustomGZIPInputStream(new Base64.InputStream(new ColonSignifiesEndStream(dZ_DataProviderStream), 0));
                } else {
                    this.dataUnwrapperStream = dZ_DataProviderStream;
                }
                driveAndExtension = FileUtilities.parseDriveAndExtension(dZ_DataProviderStream.getFilenameOnPrinter());
                this.unwrappedType = PrinterFileType.getUnwrappedType(driveAndExtension.getExtension());
                if (driveAndExtension.getFileName().length() > 8) {
                    consumeLargeDzHeader();
                } else {
                    consumeShortDzHeader();
                }
                this.fileNameOnPrinter = dZ_DataProviderStream.getFilenameOnPrinter();
                return;
            }
            customGZIPInputStream = new Base64.InputStream(new ColonSignifiesEndStream(dZ_DataProviderStream), 0);
            driveAndExtension = FileUtilities.parseDriveAndExtension(dZ_DataProviderStream.getFilenameOnPrinter());
            this.unwrappedType = PrinterFileType.getUnwrappedType(driveAndExtension.getExtension());
            if (driveAndExtension.getFileName().length() > 8) {
                consumeLargeDzHeader();
            } else {
                consumeShortDzHeader();
            }
            this.fileNameOnPrinter = dZ_DataProviderStream.getFilenameOnPrinter();
            return;
        } catch (ZebraIllegalArgumentException e) {
            throw new IOException(e);
        }
        this.dataUnwrapperStream = customGZIPInputStream;
    }

    private void consumeLargeDzHeader() throws IOException {
        for (int i = 0; i < 24; i++) {
            this.dataUnwrapperStream.read();
        }
    }

    private void consumeShortDzHeader() throws IOException {
        for (int i = 0; i < 16; i++) {
            this.dataUnwrapperStream.read();
        }
    }

    @Override // com.zebra.sdk.util.fileConversion.internal.ZplUnwrapperStreamBase
    public PrinterWrappingType getTypeToUnwrap() {
        return PrinterWrappingType.DZ;
    }

    @Override // com.zebra.sdk.util.fileConversion.internal.ZplUnwrapperStreamBase, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i == -1) {
            do {
                i = this.sourceStream.read();
            } while (i != -1);
        }
        return i;
    }
}
