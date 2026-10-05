package com.itextpdf.text;

import androidx.compose.runtime.ComposerKt;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ICC_Profile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.poi.hssf.record.PaletteRecord;

/* JADX INFO: loaded from: classes3.dex */
public class Jpeg extends Image {
    public static final int M_APP0 = 224;
    public static final int M_APP2 = 226;
    public static final int M_APPD = 237;
    public static final int M_APPE = 238;
    public static final int NOPARAM_MARKER = 2;
    public static final int NOT_A_MARKER = -1;
    public static final int UNSUPPORTED_MARKER = 1;
    public static final int VALID_MARKER = 0;
    private byte[][] icc;
    public static final int[] VALID_MARKERS = {192, 193, 194};
    public static final int[] UNSUPPORTED_MARKERS = {195, 197, 198, 199, 200, 201, 202, 203, 205, ComposerKt.referenceKey, ComposerKt.reuseKey};
    public static final int[] NOPARAM_MARKERS = {208, 209, 210, 211, 212, 213, 214, 215, 216, 1};
    public static final byte[] JFIF_ID = {74, 70, 73, 70, 0};
    public static final byte[] PS_8BIM_RESO = {PaletteRecord.STANDARD_PALETTE_SIZE, 66, 73, 77, 3, -19};

    public Jpeg(Image image) {
        super(image);
    }

    private static final int getShort(InputStream inputStream) {
        return (inputStream.read() << 8) + inputStream.read();
    }

    private static final int marker(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = VALID_MARKERS;
            if (i3 >= iArr.length) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = NOPARAM_MARKERS;
                    if (i4 >= iArr2.length) {
                        while (true) {
                            int[] iArr3 = UNSUPPORTED_MARKERS;
                            if (i2 >= iArr3.length) {
                                return -1;
                            }
                            if (i == iArr3[i2]) {
                                return 1;
                            }
                            i2++;
                        }
                    } else {
                        if (i == iArr2[i4]) {
                            return 2;
                        }
                        i4++;
                    }
                }
            } else {
                if (i == iArr[i3]) {
                    return 0;
                }
                i3++;
            }
        }
    }

    private void processParameters() throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpenStream;
        String string;
        int i = 5;
        int i2 = 16;
        int i3 = 0;
        this.type = 32;
        this.originalType = 1;
        try {
            if (this.rawData == null) {
                try {
                    inputStreamOpenStream = this.url.openStream();
                    try {
                        string = this.url.toString();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
            } else {
                inputStreamOpenStream = new ByteArrayInputStream(this.rawData);
                string = "Byte array";
            }
            if (inputStreamOpenStream.read() != 255 || inputStreamOpenStream.read() != 216) {
                throw new BadElementException(MessageLocalization.getComposedMessage("1.is.not.a.valid.jpeg.file", string));
            }
            boolean z = true;
            while (true) {
                int i4 = inputStreamOpenStream.read();
                if (i4 < 0) {
                    throw new IOException(MessageLocalization.getComposedMessage("premature.eof.while.reading.jpg", new Object[0]));
                }
                if (i4 == 255) {
                    int i5 = inputStreamOpenStream.read();
                    if (z && i5 == 224) {
                        int i6 = getShort(inputStreamOpenStream);
                        if (i6 < i2) {
                            Utilities.skip(inputStreamOpenStream, i6 - 2);
                        } else {
                            int length = JFIF_ID.length;
                            byte[] bArr = new byte[length];
                            if (inputStreamOpenStream.read(bArr) != length) {
                                Object[] objArr = new Object[1];
                                objArr[i3] = string;
                                throw new BadElementException(MessageLocalization.getComposedMessage("1.corrupted.jfif.marker", objArr));
                            }
                            int i7 = 0;
                            while (true) {
                                if (i7 >= length) {
                                    Utilities.skip(inputStreamOpenStream, 2);
                                    int i8 = inputStreamOpenStream.read();
                                    int i9 = getShort(inputStreamOpenStream);
                                    int i10 = getShort(inputStreamOpenStream);
                                    if (i8 == 1) {
                                        this.dpiX = i9;
                                        this.dpiY = i10;
                                    } else if (i8 == 2) {
                                        this.dpiX = (int) ((i9 * 2.54f) + 0.5f);
                                        this.dpiY = (int) ((i10 * 2.54f) + 0.5f);
                                    }
                                    Utilities.skip(inputStreamOpenStream, ((i6 - 2) - length) - 7);
                                    break;
                                }
                                if (bArr[i7] != JFIF_ID[i7]) {
                                    Utilities.skip(inputStreamOpenStream, (i6 - 2) - length);
                                    break;
                                }
                                i7++;
                            }
                        }
                        i2 = 16;
                        z = false;
                    } else if (i5 == 238) {
                        int i11 = getShort(inputStreamOpenStream) - 2;
                        byte[] bArr2 = new byte[i11];
                        for (int i12 = 0; i12 < i11; i12++) {
                            bArr2[i12] = (byte) inputStreamOpenStream.read();
                        }
                        if (i11 >= 12 && new String(bArr2, i3, i, "ISO-8859-1").equals("Adobe")) {
                            this.invert = true;
                        }
                    } else if (i5 == 226) {
                        int i13 = getShort(inputStreamOpenStream) - 2;
                        byte[] bArr3 = new byte[i13];
                        for (int i14 = 0; i14 < i13; i14++) {
                            bArr3[i14] = (byte) inputStreamOpenStream.read();
                        }
                        if (i13 >= 14 && new String(bArr3, i3, 11, "ISO-8859-1").equals("ICC_PROFILE")) {
                            int i15 = bArr3[12] & UnsignedBytes.MAX_VALUE;
                            int i16 = bArr3[13] & 255;
                            if (i15 < 1) {
                                i15 = 1;
                            }
                            if (i16 < 1) {
                                i16 = 1;
                            }
                            if (this.icc == null) {
                                this.icc = new byte[i16][];
                            }
                            this.icc[i15 - 1] = bArr3;
                        }
                    } else {
                        if (i5 == 237) {
                            int i17 = getShort(inputStreamOpenStream) - 2;
                            byte[] bArr4 = new byte[i17];
                            for (int i18 = 0; i18 < i17; i18++) {
                                bArr4[i18] = (byte) inputStreamOpenStream.read();
                            }
                            int i19 = 0;
                            while (i19 < i17 - PS_8BIM_RESO.length) {
                                int i20 = 0;
                                while (true) {
                                    byte[] bArr5 = PS_8BIM_RESO;
                                    if (i20 >= bArr5.length) {
                                        break;
                                    } else if (bArr4[i19 + i20] != bArr5[i20]) {
                                        break;
                                    } else {
                                        i20++;
                                    }
                                }
                                i19++;
                            }
                            byte[] bArr6 = PS_8BIM_RESO;
                            int length2 = i19 + bArr6.length;
                            if (length2 < i17 - bArr6.length) {
                                byte b = (byte) (bArr4[length2] + 1);
                                if (b % 2 == 1) {
                                    b = (byte) (b + 1);
                                }
                                int i21 = length2 + b;
                                if ((bArr4[i21] << Ascii.CAN) + (bArr4[i21 + 1] << 16) + (bArr4[i21 + 2] << 8) + bArr4[i21 + 3] == 16) {
                                    int i22 = (bArr4[i21 + 4] << 8) + (bArr4[i21 + 5] & UnsignedBytes.MAX_VALUE);
                                    int i23 = (bArr4[i21 + 8] << 8) + (bArr4[i21 + 9] & UnsignedBytes.MAX_VALUE);
                                    int i24 = (bArr4[i21 + 12] << 8) + (bArr4[i21 + 13] & UnsignedBytes.MAX_VALUE);
                                    int i25 = (bArr4[i21 + 16] << 8) + (bArr4[i21 + 17] & UnsignedBytes.MAX_VALUE);
                                    if (i23 == 1 || i23 == 2) {
                                        if (i23 == 2) {
                                            i22 = (int) ((i22 * 2.54f) + 0.5f);
                                        }
                                        int i26 = this.dpiX;
                                        if (i26 == 0 || i26 == i22) {
                                            this.dpiX = i22;
                                        }
                                    }
                                    if (i25 == 1 || i25 == 2) {
                                        if (i25 == 2) {
                                            i24 = (int) ((i24 * 2.54f) + 0.5f);
                                        }
                                        int i27 = this.dpiY;
                                        if (i27 == 0 || i27 == i24) {
                                            this.dpiY = i24;
                                        }
                                    }
                                }
                            }
                        } else {
                            int iMarker = marker(i5);
                            if (iMarker == 0) {
                                Utilities.skip(inputStreamOpenStream, 2);
                                if (inputStreamOpenStream.read() != 8) {
                                    throw new BadElementException(MessageLocalization.getComposedMessage("1.must.have.8.bits.per.component", string));
                                }
                                float f = getShort(inputStreamOpenStream);
                                this.scaledHeight = f;
                                setTop(f);
                                float f2 = getShort(inputStreamOpenStream);
                                this.scaledWidth = f2;
                                setRight(f2);
                                this.colorspace = inputStreamOpenStream.read();
                                this.bpc = 8;
                                inputStreamOpenStream.close();
                                this.plainWidth = getWidth();
                                this.plainHeight = getHeight();
                                if (this.icc == null) {
                                    return;
                                }
                                int i28 = 0;
                                int length3 = 0;
                                while (true) {
                                    byte[][] bArr7 = this.icc;
                                    if (i28 >= bArr7.length) {
                                        byte[] bArr8 = new byte[length3];
                                        int length4 = 0;
                                        int i29 = 0;
                                        while (true) {
                                            byte[][] bArr9 = this.icc;
                                            if (i29 < bArr9.length) {
                                                byte[] bArr10 = bArr9[i29];
                                                System.arraycopy(bArr10, 14, bArr8, length4, bArr10.length - 14);
                                                length4 += this.icc[i29].length - 14;
                                                i29++;
                                            } else {
                                                try {
                                                    break;
                                                } catch (IllegalArgumentException unused) {
                                                }
                                            }
                                        }
                                        tagICC(ICC_Profile.getInstance(bArr8, this.colorspace));
                                        this.icc = null;
                                        return;
                                    }
                                    byte[] bArr11 = bArr7[i28];
                                    if (bArr11 == null) {
                                        this.icc = null;
                                        return;
                                    } else {
                                        length3 += bArr11.length - 14;
                                        i28++;
                                    }
                                }
                            } else {
                                if (iMarker == 1) {
                                    throw new BadElementException(MessageLocalization.getComposedMessage("1.unsupported.jpeg.marker.2", string, String.valueOf(i5)));
                                }
                                if (iMarker != 2) {
                                    Utilities.skip(inputStreamOpenStream, getShort(inputStreamOpenStream) - 2);
                                }
                                z = false;
                            }
                        }
                        i = 5;
                        i2 = 16;
                        i3 = 0;
                    }
                }
                i = 5;
                i2 = 16;
                i3 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public Jpeg(URL url) throws Throwable {
        super(url);
        processParameters();
    }

    public Jpeg(byte[] bArr) throws Throwable {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg(byte[] bArr, float f, float f2) {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }
}
