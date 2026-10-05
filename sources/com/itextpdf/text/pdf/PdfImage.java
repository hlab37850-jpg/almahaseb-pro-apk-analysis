package com.itextpdf.text.pdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PdfImage extends PdfStream {
    static final int TRANSFERSIZE = 4096;
    protected Image image;
    protected PdfName name;

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public PdfImage(Image image, String str, PdfIndirectReference pdfIndirectReference) {
        InputStream byteArrayInputStream;
        String string;
        InputStream inputStream = null;
        this.name = null;
        this.image = image;
        if (str == null) {
            generateImgResName(image);
        } else {
            this.name = new PdfName(str);
        }
        put(PdfName.TYPE, PdfName.XOBJECT);
        put(PdfName.SUBTYPE, PdfName.IMAGE);
        put(PdfName.WIDTH, new PdfNumber(image.getWidth()));
        put(PdfName.HEIGHT, new PdfNumber(image.getHeight()));
        if (image.getLayer() != null) {
            put(PdfName.OC, image.getLayer().getRef());
        }
        if (image.isMask() && (image.getBpc() == 1 || image.getBpc() > 255)) {
            put(PdfName.IMAGEMASK, PdfBoolean.PDFTRUE);
        }
        if (pdfIndirectReference != null) {
            if (image.isSmask()) {
                put(PdfName.SMASK, pdfIndirectReference);
            } else {
                put(PdfName.MASK, pdfIndirectReference);
            }
        }
        if (image.isMask() && image.isInverted()) {
            put(PdfName.DECODE, new PdfLiteral("[1 0]"));
        }
        if (image.isInterpolation()) {
            put(PdfName.INTERPOLATE, PdfBoolean.PDFTRUE);
        }
        try {
            try {
                int[] transparency = image.getTransparency();
                if (transparency != null && !image.isMask() && pdfIndirectReference == null) {
                    StringBuilder sb = new StringBuilder("[");
                    for (int i : transparency) {
                        sb.append(i);
                        sb.append(" ");
                    }
                    sb.append("]");
                    put(PdfName.MASK, new PdfLiteral(sb.toString()));
                }
                if (image.isImgRaw()) {
                    int colorspace = image.getColorspace();
                    byte[] rawData = image.getRawData();
                    this.bytes = rawData;
                    put(PdfName.LENGTH, new PdfNumber(rawData.length));
                    int bpc = image.getBpc();
                    if (bpc > 255) {
                        if (!image.isMask()) {
                            put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                        }
                        put(PdfName.BITSPERCOMPONENT, new PdfNumber(1));
                        put(PdfName.FILTER, PdfName.CCITTFAXDECODE);
                        int i2 = bpc - 257;
                        PdfDictionary pdfDictionary = new PdfDictionary();
                        if (i2 != 0) {
                            pdfDictionary.put(PdfName.K, new PdfNumber(i2));
                        }
                        if ((colorspace & 1) != 0) {
                            pdfDictionary.put(PdfName.BLACKIS1, PdfBoolean.PDFTRUE);
                        }
                        if ((colorspace & 2) != 0) {
                            pdfDictionary.put(PdfName.ENCODEDBYTEALIGN, PdfBoolean.PDFTRUE);
                        }
                        if ((colorspace & 4) != 0) {
                            pdfDictionary.put(PdfName.ENDOFLINE, PdfBoolean.PDFTRUE);
                        }
                        if ((colorspace & 8) != 0) {
                            pdfDictionary.put(PdfName.ENDOFBLOCK, PdfBoolean.PDFFALSE);
                        }
                        pdfDictionary.put(PdfName.COLUMNS, new PdfNumber(image.getWidth()));
                        pdfDictionary.put(PdfName.ROWS, new PdfNumber(image.getHeight()));
                        put(PdfName.DECODEPARMS, pdfDictionary);
                        return;
                    }
                    if (colorspace == 1) {
                        put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                        if (image.isInverted()) {
                            put(PdfName.DECODE, new PdfLiteral("[1 0]"));
                        }
                    } else if (colorspace != 3) {
                        put(PdfName.COLORSPACE, PdfName.DEVICECMYK);
                        if (image.isInverted()) {
                            put(PdfName.DECODE, new PdfLiteral("[1 0 1 0 1 0 1 0]"));
                        }
                    } else {
                        put(PdfName.COLORSPACE, PdfName.DEVICERGB);
                        if (image.isInverted()) {
                            put(PdfName.DECODE, new PdfLiteral("[1 0 1 0 1 0]"));
                        }
                    }
                    PdfDictionary additional = image.getAdditional();
                    if (additional != null) {
                        putAll(additional);
                    }
                    if (image.isMask() && (image.getBpc() == 1 || image.getBpc() > 8)) {
                        remove(PdfName.COLORSPACE);
                    }
                    put(PdfName.BITSPERCOMPONENT, new PdfNumber(image.getBpc()));
                    if (image.isDeflated()) {
                        put(PdfName.FILTER, PdfName.FLATEDECODE);
                        return;
                    } else {
                        flateCompress(image.getCompressionLevel());
                        return;
                    }
                }
                if (image.getRawData() == null) {
                    byteArrayInputStream = image.getUrl().openStream();
                    string = image.getUrl().toString();
                } else {
                    byteArrayInputStream = new ByteArrayInputStream(image.getRawData());
                    string = "Byte array";
                }
                int iType = image.type();
                if (iType == 32) {
                    put(PdfName.FILTER, PdfName.DCTDECODE);
                    if (image.getColorTransform() == 0) {
                        PdfDictionary pdfDictionary2 = new PdfDictionary();
                        pdfDictionary2.put(PdfName.COLORTRANSFORM, new PdfNumber(0));
                        put(PdfName.DECODEPARMS, pdfDictionary2);
                    }
                    int colorspace2 = image.getColorspace();
                    if (colorspace2 == 1) {
                        put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                    } else if (colorspace2 != 3) {
                        put(PdfName.COLORSPACE, PdfName.DEVICECMYK);
                        if (image.isInverted()) {
                            put(PdfName.DECODE, new PdfLiteral("[1 0 1 0 1 0 1 0]"));
                        }
                    } else {
                        put(PdfName.COLORSPACE, PdfName.DEVICERGB);
                    }
                    put(PdfName.BITSPERCOMPONENT, new PdfNumber(8));
                    if (image.getRawData() != null) {
                        byte[] rawData2 = image.getRawData();
                        this.bytes = rawData2;
                        put(PdfName.LENGTH, new PdfNumber(rawData2.length));
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        }
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.streamBytes = byteArrayOutputStream;
                    transferBytes(byteArrayInputStream, byteArrayOutputStream, -1);
                } else if (iType == 33) {
                    put(PdfName.FILTER, PdfName.JPXDECODE);
                    if (image.getColorspace() > 0) {
                        int colorspace3 = image.getColorspace();
                        if (colorspace3 == 1) {
                            put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                        } else if (colorspace3 != 3) {
                            put(PdfName.COLORSPACE, PdfName.DEVICECMYK);
                        } else {
                            put(PdfName.COLORSPACE, PdfName.DEVICERGB);
                        }
                        put(PdfName.BITSPERCOMPONENT, new PdfNumber(image.getBpc()));
                    }
                    if (image.getRawData() != null) {
                        byte[] rawData3 = image.getRawData();
                        this.bytes = rawData3;
                        put(PdfName.LENGTH, new PdfNumber(rawData3.length));
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                                return;
                            } catch (Exception unused2) {
                                return;
                            }
                        }
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    this.streamBytes = byteArrayOutputStream2;
                    transferBytes(byteArrayInputStream, byteArrayOutputStream2, -1);
                } else {
                    if (iType != 36) {
                        throw new BadPdfFormatException(MessageLocalization.getComposedMessage("1.is.an.unknown.image.format", string));
                    }
                    put(PdfName.FILTER, PdfName.JBIG2DECODE);
                    put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                    put(PdfName.BITSPERCOMPONENT, new PdfNumber(1));
                    if (image.getRawData() != null) {
                        byte[] rawData4 = image.getRawData();
                        this.bytes = rawData4;
                        put(PdfName.LENGTH, new PdfNumber(rawData4.length));
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                                return;
                            } catch (Exception unused3) {
                                return;
                            }
                        }
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    this.streamBytes = byteArrayOutputStream3;
                    transferBytes(byteArrayInputStream, byteArrayOutputStream3, -1);
                }
                if (image.getCompressionLevel() > 0) {
                    flateCompress(image.getCompressionLevel());
                }
                put(PdfName.LENGTH, new PdfNumber(this.streamBytes.size()));
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            } catch (IOException e) {
                throw new BadPdfFormatException(e.getMessage());
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    private void generateImgResName(Image image) {
        this.name = new PdfName("img" + Long.toHexString(image.getMySerialId().longValue()));
    }

    public static void transferBytes(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[4096];
        if (i < 0) {
            i = 2147418112;
        }
        while (i != 0) {
            int i2 = inputStream.read(bArr, 0, Math.min(i, 4096));
            if (i2 < 0) {
                return;
            }
            outputStream.write(bArr, 0, i2);
            i -= i2;
        }
    }

    public Image getImage() {
        return this.image;
    }

    public void importAll(PdfImage pdfImage) {
        this.name = pdfImage.name;
        this.compressed = pdfImage.compressed;
        this.compressionLevel = pdfImage.compressionLevel;
        this.streamBytes = pdfImage.streamBytes;
        this.bytes = pdfImage.bytes;
        this.hashMap = pdfImage.hashMap;
    }

    public PdfName name() {
        return this.name;
    }
}
