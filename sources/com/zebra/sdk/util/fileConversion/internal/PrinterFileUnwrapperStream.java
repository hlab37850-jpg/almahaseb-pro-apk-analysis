package com.zebra.sdk.util.fileConversion.internal;

import com.zebra.sdk.util.internal.PrinterFileMetadata;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PrinterFileUnwrapperStream extends StreamDecoratorBase {
    private StreamDecoratorBase baseStream;
    private PrinterWrappingType fileType;

    /* JADX INFO: renamed from: com.zebra.sdk.util.fileConversion.internal.PrinterFileUnwrapperStream$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType;

        static {
            int[] iArr = new int[PrinterWrappingType.values().length];
            $SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType = iArr;
            try {
                iArr[PrinterWrappingType.DY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType[PrinterWrappingType.DZ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType[PrinterWrappingType.DG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType[PrinterWrappingType.CISDF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType[PrinterWrappingType.HZO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType[PrinterWrappingType.MPF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public PrinterFileUnwrapperStream(InputStream inputStream, PrinterWrappingType printerWrappingType) throws IOException {
        StreamDecoratorBase dY_UnwrapperStream;
        this.fileType = printerWrappingType;
        if (inputStream == null) {
            throw new IOException("Input stream is null");
        }
        switch (AnonymousClass1.$SwitchMap$com$zebra$sdk$util$fileConversion$internal$PrinterWrappingType[printerWrappingType.ordinal()]) {
            case 1:
                dY_UnwrapperStream = new DY_UnwrapperStream(inputStream);
                break;
            case 2:
                dY_UnwrapperStream = new DZ_UnwrapperStream(inputStream);
                break;
            case 3:
                dY_UnwrapperStream = new DY_UnwrapperStream(new DG_ToDyConverterStream(inputStream));
                break;
            case 4:
                dY_UnwrapperStream = new CisdfUnwrapperStream(inputStream);
                break;
            case 5:
                dY_UnwrapperStream = new DZ_UnwrapperStream(new HzoToDzConverterStream(inputStream));
                break;
            case 6:
                dY_UnwrapperStream = new MPF_UnwrapperStream(inputStream);
                break;
            default:
                dY_UnwrapperStream = new MetadataExtractorPassthruStream(inputStream);
                break;
        }
        this.baseStream = dY_UnwrapperStream;
    }

    @Override // com.zebra.sdk.util.fileConversion.internal.MetadataProvider
    public PrinterFileMetadata getPrinterFileMetadata() {
        PrinterFileMetadata printerFileMetadata = this.baseStream.getPrinterFileMetadata();
        printerFileMetadata.setPrinterWrappingType(this.fileType);
        return printerFileMetadata;
    }

    @Override // java.io.InputStream
    public int read() {
        return this.baseStream.read();
    }
}
