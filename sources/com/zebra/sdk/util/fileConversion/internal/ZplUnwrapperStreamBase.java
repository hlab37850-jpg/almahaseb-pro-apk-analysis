package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.util.internal.PrinterFileMetadata;
import com.zebra.sdk.util.internal.ZCRC16;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZplUnwrapperStreamBase extends StreamDecoratorBase {
    InputStream dataUnwrapperStream;
    String fileNameOnPrinter;
    PrinterFileType unwrappedType;
    long unmimedFileSize = 0;
    char crc16 = 0;
    char sum = 0;

    @Override // com.zebra.sdk.util.fileConversion.internal.MetadataProvider
    public PrinterFileMetadata getPrinterFileMetadata() {
        PrinterFileMetadata printerFileMetadata = new PrinterFileMetadata(this.unmimedFileSize, String.format("%04X", Integer.valueOf(this.crc16)), String.format("%04X", Integer.valueOf((this.sum ^ 65535) + 1)), this.fileNameOnPrinter);
        printerFileMetadata.setPrinterFileType(this.unwrappedType);
        printerFileMetadata.setPrinterWrappingType(getTypeToUnwrap());
        return printerFileMetadata;
    }

    public abstract PrinterWrappingType getTypeToUnwrap();

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.dataUnwrapperStream.read();
        if (i != -1) {
            this.unmimedFileSize++;
            this.sum = (char) (this.sum + i);
            this.crc16 = ZCRC16.addCrc16Byte_cpcl(this.crc16, i);
        }
        return i;
    }
}
