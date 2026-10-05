package com.itextpdf.text.pdf.codec;

import androidx.fragment.app.FragmentTransaction;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfString;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class GifImage {
    protected static final int MaxStackSize = 4096;
    protected int bgColor;
    protected int bgIndex;
    protected byte[] block;
    protected int blockSize;
    protected int delay;
    protected int dispose;
    protected ArrayList<GifFrame> frames;
    protected byte[] fromData;
    protected URL fromUrl;
    protected boolean gctFlag;
    protected int height;
    protected int ih;
    protected DataInputStream in;
    protected boolean interlace;
    protected int iw;
    protected int ix;
    protected int iy;
    protected boolean lctFlag;
    protected int lctSize;
    protected int m_bpc;
    protected byte[] m_curr_table;
    protected int m_gbpc;
    protected byte[] m_global_table;
    protected int m_line_stride;
    protected byte[] m_local_table;
    protected byte[] m_out;
    protected int pixelAspect;
    protected byte[] pixelStack;
    protected byte[] pixels;
    protected short[] prefix;
    protected byte[] suffix;
    protected int transIndex;
    protected boolean transparency;
    protected int width;

    public static class GifFrame {
        Image image;
        int ix;
        int iy;
    }

    public GifImage(URL url) throws Throwable {
        InputStream inputStreamOpenStream;
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.frames = new ArrayList<>();
        this.fromUrl = url;
        try {
            inputStreamOpenStream = url.openStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenStream.read(bArr);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        inputStreamOpenStream.close();
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.flush();
                            byteArrayOutputStream.close();
                            process(byteArrayInputStream);
                            byteArrayInputStream.close();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            inputStreamOpenStream = byteArrayInputStream;
                        }
                    }
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenStream = null;
        }
    }

    public static int newBpc(int i) {
        if (i != 1 && i != 2) {
            if (i == 3) {
                return 4;
            }
            if (i != 4) {
                return 8;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v23, types: [short] */
    /* JADX WARN: Type inference failed for: r1v25 */
    public boolean decodeImageData() throws IOException {
        int i;
        int i2;
        int i3;
        short s;
        int i4 = this.iw;
        int i5 = this.ih;
        int i6 = i4 * i5;
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int i7 = ((i4 * this.m_bpc) + 7) / 8;
        this.m_line_stride = i7;
        this.m_out = new byte[i7 * i5];
        boolean z = true;
        int i8 = this.interlace ? 8 : 1;
        int i9 = this.in.read();
        int i10 = 1 << i9;
        int i11 = i10 + 1;
        int i12 = i10 + 2;
        int i13 = i9 + 1;
        int i14 = (1 << i13) - 1;
        for (int i15 = 0; i15 < i10; i15++) {
            this.prefix[i15] = 0;
            this.suffix[i15] = (byte) i15;
        }
        int i16 = i13;
        int i17 = i12;
        int i18 = i14;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int block = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        int i27 = 0;
        int i28 = 0;
        while (i20 < i6) {
            if (i21 != 0) {
                int i29 = i25;
                i6 = i6;
                i = i29;
            } else if (i22 < i16) {
                if (block == 0) {
                    block = readBlock();
                    if (block <= 0) {
                        return z;
                    }
                    i24 = 0;
                }
                i23 += (this.block[i24] & UnsignedBytes.MAX_VALUE) << i22;
                i22 += 8;
                i24++;
                block--;
            } else {
                int i30 = i23 & i18;
                i23 >>= i16;
                i22 -= i16;
                if (i30 > i17 || i30 == i11) {
                    break;
                }
                if (i30 == i10) {
                    i16 = i13;
                    i17 = i12;
                    i18 = i14;
                    z = true;
                    i19 = -1;
                } else if (i19 == -1) {
                    this.pixelStack[i21] = this.suffix[i30];
                    i19 = i30;
                    i25 = i19;
                    i21++;
                    i13 = i13;
                    z = true;
                } else {
                    if (i30 == i17) {
                        i3 = i30;
                        this.pixelStack[i21] = (byte) i25;
                        s = i19;
                        i21++;
                    } else {
                        i3 = i30;
                        s = i3;
                    }
                    while (s > i10) {
                        this.pixelStack[i21] = this.suffix[s];
                        s = this.prefix[s];
                        i21++;
                        i6 = i6;
                    }
                    i6 = i6;
                    byte[] bArr = this.suffix;
                    i = bArr[s] & UnsignedBytes.MAX_VALUE;
                    if (i17 >= 4096) {
                        break;
                    }
                    int i31 = i21 + 1;
                    byte b = (byte) i;
                    this.pixelStack[i21] = b;
                    this.prefix[i17] = (short) i19;
                    bArr[i17] = b;
                    i17++;
                    if ((i17 & i18) == 0 && i17 < 4096) {
                        i16++;
                        i18 += i17;
                    }
                    i21 = i31;
                    i19 = i3;
                }
            }
            i21--;
            i20++;
            int i32 = i27;
            int i33 = i28;
            setPixel(i33, i32, this.pixelStack[i21]);
            int i34 = i33 + 1;
            if (i34 >= this.iw) {
                int i35 = i32 + i8;
                int i36 = this.ih;
                if (i35 >= i36) {
                    if (this.interlace) {
                        do {
                            int i37 = i26 + 1;
                            i2 = 4;
                            if (i37 != 2) {
                                if (i37 == 3) {
                                    i8 = 4;
                                    i2 = 2;
                                } else if (i37 != 4) {
                                    i2 = this.ih - 1;
                                    i8 = 0;
                                } else {
                                    i8 = 2;
                                    i2 = 1;
                                }
                            }
                            i26 = i37;
                        } while (i2 >= this.ih);
                        i27 = i2;
                    } else {
                        i27 = i36 - 1;
                        z = true;
                        i8 = 0;
                    }
                    i28 = 0;
                } else {
                    i27 = i35;
                }
                z = true;
                i28 = 0;
            } else {
                i28 = i34;
                i27 = i32;
                i6 = i6;
                i10 = i10;
                z = true;
            }
            i25 = i;
            i13 = i13;
        }
        return false;
    }

    public int getFrameCount() {
        return this.frames.size();
    }

    public int[] getFramePosition(int i) {
        GifFrame gifFrame = this.frames.get(i - 1);
        return new int[]{gifFrame.ix, gifFrame.iy};
    }

    public Image getImage(int i) {
        return this.frames.get(i - 1).image;
    }

    public int[] getLogicalScreen() {
        return new int[]{this.width, this.height};
    }

    public void process(InputStream inputStream) throws IOException {
        this.in = new DataInputStream(new BufferedInputStream(inputStream));
        readHeader();
        readContents();
        if (this.frames.isEmpty()) {
            throw new IOException(MessageLocalization.getComposedMessage("the.file.does.not.contain.any.valid.image", new Object[0]));
        }
    }

    public int readBlock() throws IOException {
        int i = this.in.read();
        this.blockSize = i;
        if (i <= 0) {
            this.blockSize = 0;
            return 0;
        }
        int i2 = this.in.read(this.block, 0, i);
        this.blockSize = i2;
        return i2;
    }

    public byte[] readColorTable(int i) throws IOException {
        int i2 = (1 << i) * 3;
        byte[] bArr = new byte[(1 << newBpc(i)) * 3];
        this.in.readFully(bArr, 0, i2);
        return bArr;
    }

    public void readContents() throws IOException {
        boolean z = false;
        while (!z) {
            int i = this.in.read();
            if (i == 33) {
                int i2 = this.in.read();
                if (i2 == 249) {
                    readGraphicControlExt();
                } else if (i2 != 255) {
                    skip();
                } else {
                    readBlock();
                    skip();
                }
            } else if (i != 44) {
                z = true;
            } else {
                readImage();
            }
        }
    }

    public void readGraphicControlExt() throws IOException {
        this.in.read();
        int i = this.in.read();
        int i2 = (i & 28) >> 2;
        this.dispose = i2;
        if (i2 == 0) {
            this.dispose = 1;
        }
        this.transparency = (i & 1) != 0;
        this.delay = readShort() * 10;
        this.transIndex = this.in.read();
        this.in.read();
    }

    public void readHeader() throws IOException {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 6; i++) {
            sb.append((char) this.in.read());
        }
        if (!sb.toString().startsWith("GIF8")) {
            throw new IOException(MessageLocalization.getComposedMessage("gif.signature.nor.found", new Object[0]));
        }
        readLSD();
        if (this.gctFlag) {
            this.m_global_table = readColorTable(this.m_gbpc);
        }
    }

    public void readImage() throws IOException {
        this.ix = readShort();
        this.iy = readShort();
        this.iw = readShort();
        this.ih = readShort();
        int i = this.in.read();
        this.lctFlag = (i & 128) != 0;
        this.interlace = (i & 64) != 0;
        int i2 = i & 7;
        this.lctSize = 2 << i2;
        this.m_bpc = newBpc(this.m_gbpc);
        if (this.lctFlag) {
            int i3 = i2 + 1;
            this.m_curr_table = readColorTable(i3);
            this.m_bpc = newBpc(i3);
        } else {
            this.m_curr_table = this.m_global_table;
        }
        if (this.transparency && this.transIndex >= this.m_curr_table.length / 3) {
            this.transparency = false;
        }
        if (this.transparency && this.m_bpc == 1) {
            byte[] bArr = new byte[12];
            System.arraycopy(this.m_curr_table, 0, bArr, 0, 6);
            this.m_curr_table = bArr;
            this.m_bpc = 2;
        }
        if (!decodeImageData()) {
            skip();
        }
        try {
            ImgRaw imgRaw = new ImgRaw(this.iw, this.ih, 1, this.m_bpc, this.m_out);
            PdfArray pdfArray = new PdfArray();
            pdfArray.add(PdfName.INDEXED);
            pdfArray.add(PdfName.DEVICERGB);
            pdfArray.add(new PdfNumber((this.m_curr_table.length / 3) - 1));
            pdfArray.add(new PdfString(this.m_curr_table));
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
            imgRaw.setAdditional(pdfDictionary);
            if (this.transparency) {
                int i4 = this.transIndex;
                imgRaw.setTransparency(new int[]{i4, i4});
            }
            imgRaw.setOriginalType(3);
            imgRaw.setOriginalData(this.fromData);
            imgRaw.setUrl(this.fromUrl);
            GifFrame gifFrame = new GifFrame();
            gifFrame.image = imgRaw;
            gifFrame.ix = this.ix;
            gifFrame.iy = this.iy;
            this.frames.add(gifFrame);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void readLSD() throws IOException {
        this.width = readShort();
        this.height = readShort();
        int i = this.in.read();
        this.gctFlag = (i & 128) != 0;
        this.m_gbpc = (i & 7) + 1;
        this.bgIndex = this.in.read();
        this.pixelAspect = this.in.read();
    }

    public int readShort() {
        return this.in.read() | (this.in.read() << 8);
    }

    public void resetFrame() {
    }

    public void setPixel(int i, int i2, int i3) {
        int i4 = this.m_bpc;
        if (i4 == 8) {
            this.m_out[i + (this.iw * i2)] = (byte) i3;
        } else {
            int i5 = (this.m_line_stride * i2) + (i / (8 / i4));
            byte[] bArr = this.m_out;
            bArr[i5] = (byte) ((i3 << ((8 - ((i % (8 / i4)) * i4)) - i4)) | bArr[i5]);
        }
    }

    public void skip() throws IOException {
        do {
            readBlock();
        } while (this.blockSize > 0);
    }

    public GifImage(String str) {
        this(Utilities.toURL(str));
    }

    public GifImage(byte[] bArr) throws Throwable {
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.frames = new ArrayList<>();
        this.fromData = bArr;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                process(byteArrayInputStream2);
                byteArrayInputStream2.close();
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream = byteArrayInputStream2;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public GifImage(InputStream inputStream) throws IOException {
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.frames = new ArrayList<>();
        process(inputStream);
    }
}
