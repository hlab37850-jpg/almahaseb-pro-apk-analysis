package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.BmpImage;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.codec.GifImage;
import com.itextpdf.text.pdf.codec.JBIG2Image;
import com.itextpdf.text.pdf.codec.PngImage;
import com.itextpdf.text.pdf.codec.TiffImage;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.IAlternateDescription;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Image extends Rectangle implements Indentable, Spaceable, IAccessibleElement, IAlternateDescription {
    public static final int AX = 0;
    public static final int AY = 1;
    public static final int BX = 2;
    public static final int BY = 3;
    public static final int CX = 4;
    public static final int CY = 5;
    public static final int DEFAULT = 0;
    public static final int DX = 6;
    public static final int DY = 7;
    public static final int LEFT = 0;
    public static final int MIDDLE = 1;
    public static final int ORIGINAL_BMP = 4;
    public static final int ORIGINAL_GIF = 3;
    public static final int ORIGINAL_JBIG2 = 9;
    public static final int ORIGINAL_JPEG = 1;
    public static final int ORIGINAL_JPEG2000 = 8;
    public static final int ORIGINAL_NONE = 0;
    public static final int ORIGINAL_PNG = 2;
    public static final int ORIGINAL_PS = 7;
    public static final int ORIGINAL_TIFF = 5;
    public static final int ORIGINAL_WMF = 6;
    public static final int RIGHT = 2;
    public static final int TEXTWRAP = 4;
    public static final int UNDERLYING = 8;
    static long serialId;
    private float XYRatio;
    protected float absoluteX;
    protected float absoluteY;
    protected HashMap<PdfName, PdfObject> accessibleAttributes;
    private PdfDictionary additional;
    protected int alignment;
    protected String alt;
    protected Annotation annotation;
    protected int bpc;
    protected int colorspace;
    protected int colortransform;
    protected int compressionLevel;
    protected boolean deflated;
    private PdfIndirectReference directReference;
    protected int dpiX;
    protected int dpiY;
    private AccessibleElementId id;
    protected Image imageMask;
    protected float indentationLeft;
    protected float indentationRight;
    private float initialRotation;
    protected boolean interpolation;
    protected boolean invert;
    protected PdfOCG layer;
    protected boolean mask;
    protected Long mySerialId;
    protected byte[] originalData;
    protected int originalType;
    protected float paddingTop;
    protected float plainHeight;
    protected float plainWidth;
    protected ICC_Profile profile;
    protected byte[] rawData;
    protected PdfName role;
    protected float rotationRadians;
    protected boolean scaleToFitHeight;
    protected boolean scaleToFitLineWhenOverflow;
    protected float scaledHeight;
    protected float scaledWidth;
    private boolean smask;
    protected float spacingAfter;
    protected float spacingBefore;
    protected PdfTemplate[] template;
    protected int[] transparency;
    protected int type;
    protected URL url;
    private float widthPercentage;

    public Image(URL url) {
        super(0.0f, 0.0f);
        this.bpc = 1;
        this.template = new PdfTemplate[1];
        this.absoluteX = Float.NaN;
        this.absoluteY = Float.NaN;
        this.compressionLevel = -1;
        this.mySerialId = getSerialId();
        this.role = PdfName.FIGURE;
        this.accessibleAttributes = null;
        this.id = null;
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.widthPercentage = 100.0f;
        this.scaleToFitHeight = true;
        this.annotation = null;
        this.originalType = 0;
        this.deflated = false;
        this.dpiX = 0;
        this.dpiY = 0;
        this.XYRatio = 0.0f;
        this.colorspace = -1;
        this.colortransform = 1;
        this.invert = false;
        this.profile = null;
        this.additional = null;
        this.mask = false;
        this.url = url;
        this.alignment = 0;
        this.rotationRadians = 0.0f;
    }

    public static Image getInstance(URL url) {
        return getInstance(url, false);
    }

    public static synchronized Long getSerialId() {
        long j;
        j = serialId + 1;
        serialId = j;
        return Long.valueOf(j);
    }

    public float getAbsoluteX() {
        return this.absoluteX;
    }

    public float getAbsoluteY() {
        return this.absoluteY;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfObject getAccessibleAttribute(PdfName pdfName) {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map != null) {
            return map.get(pdfName);
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public HashMap<PdfName, PdfObject> getAccessibleAttributes() {
        return this.accessibleAttributes;
    }

    public PdfDictionary getAdditional() {
        return this.additional;
    }

    public int getAlignment() {
        return this.alignment;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAlternateDescription
    public String getAlt() {
        return this.alt;
    }

    public Annotation getAnnotation() {
        return this.annotation;
    }

    public int getBpc() {
        return this.bpc;
    }

    public int getColorTransform() {
        return this.colortransform;
    }

    public int getColorspace() {
        return this.colorspace;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public PdfIndirectReference getDirectReference() {
        return this.directReference;
    }

    public int getDpiX() {
        return this.dpiX;
    }

    public int getDpiY() {
        return this.dpiY;
    }

    public ICC_Profile getICCProfile() {
        return this.profile;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        if (this.id == null) {
            this.id = new AccessibleElementId();
        }
        return this.id;
    }

    public Image getImageMask() {
        return this.imageMask;
    }

    public float getImageRotation() {
        float f = (float) (((double) (this.rotationRadians - this.initialRotation)) % 6.283185307179586d);
        return f < 0.0f ? (float) (((double) f) + 6.283185307179586d) : f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    public float getInitialRotation() {
        return this.initialRotation;
    }

    public PdfOCG getLayer() {
        return this.layer;
    }

    public Long getMySerialId() {
        return this.mySerialId;
    }

    public byte[] getOriginalData() {
        return this.originalData;
    }

    public int getOriginalType() {
        return this.originalType;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getPaddingTop() {
        return this.paddingTop;
    }

    public float getPlainHeight() {
        return this.plainHeight;
    }

    public float getPlainWidth() {
        return this.plainWidth;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public float getScaledHeight() {
        return this.scaledHeight;
    }

    public float getScaledWidth() {
        return this.scaledWidth;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    public PdfTemplate getTemplateData() {
        return this.template[0];
    }

    public int[] getTransparency() {
        return this.transparency;
    }

    public URL getUrl() {
        return this.url;
    }

    public float getWidthPercentage() {
        return this.widthPercentage;
    }

    public float getXYRatio() {
        return this.XYRatio;
    }

    public boolean hasAbsoluteX() {
        return !Float.isNaN(this.absoluteX);
    }

    public boolean hasAbsoluteY() {
        return !Float.isNaN(this.absoluteY);
    }

    public boolean hasICCProfile() {
        return this.profile != null;
    }

    public boolean isDeflated() {
        return this.deflated;
    }

    public boolean isImgRaw() {
        return this.type == 34;
    }

    public boolean isImgTemplate() {
        return this.type == 35;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return true;
    }

    public boolean isInterpolation() {
        return this.interpolation;
    }

    public boolean isInverted() {
        return this.invert;
    }

    public boolean isJpeg() {
        return this.type == 32;
    }

    public boolean isMask() {
        return this.mask;
    }

    public boolean isMaskCandidate() {
        return (this.type == 34 && this.bpc > 255) || this.colorspace == 1;
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    public boolean isScaleToFitHeight() {
        return this.scaleToFitHeight;
    }

    public boolean isScaleToFitLineWhenOverflow() {
        return this.scaleToFitLineWhenOverflow;
    }

    public boolean isSmask() {
        return this.smask;
    }

    public void makeMask() throws DocumentException {
        if (!isMaskCandidate()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("this.image.can.not.be.an.image.mask", new Object[0]));
        }
        this.mask = true;
    }

    public float[] matrix() {
        return matrix(1.0f);
    }

    public void scaleAbsolute(Rectangle rectangle) {
        scaleAbsolute(rectangle.getWidth(), rectangle.getHeight());
    }

    public void scaleAbsoluteHeight(float f) {
        this.plainHeight = f;
        float[] fArrMatrix = matrix();
        this.scaledWidth = fArrMatrix[6] - fArrMatrix[4];
        this.scaledHeight = fArrMatrix[7] - fArrMatrix[5];
        setWidthPercentage(0.0f);
    }

    public void scaleAbsoluteWidth(float f) {
        this.plainWidth = f;
        float[] fArrMatrix = matrix();
        this.scaledWidth = fArrMatrix[6] - fArrMatrix[4];
        this.scaledHeight = fArrMatrix[7] - fArrMatrix[5];
        setWidthPercentage(0.0f);
    }

    public void scalePercent(float f) {
        scalePercent(f, f);
    }

    public void scaleToFit(Rectangle rectangle) {
        scaleToFit(rectangle.getWidth(), rectangle.getHeight());
    }

    public void setAbsolutePosition(float f, float f2) {
        this.absoluteX = f;
        this.absoluteY = f2;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setAdditional(PdfDictionary pdfDictionary) {
        this.additional = pdfDictionary;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAlternateDescription
    public void setAlt(String str) {
        this.alt = str;
        setAccessibleAttribute(PdfName.ALT, new PdfString(str));
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    public void setColorTransform(int i) {
        this.colortransform = i;
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }

    public void setDeflated(boolean z) {
        this.deflated = z;
    }

    public void setDirectReference(PdfIndirectReference pdfIndirectReference) {
        this.directReference = pdfIndirectReference;
    }

    public void setDpi(int i, int i2) {
        this.dpiX = i;
        this.dpiY = i2;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    public void setImageMask(Image image) throws DocumentException {
        boolean z = false;
        if (this.mask) {
            throw new DocumentException(MessageLocalization.getComposedMessage("an.image.mask.cannot.contain.another.image.mask", new Object[0]));
        }
        if (!image.mask) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.image.mask.is.not.a.mask.did.you.do.makemask", new Object[0]));
        }
        this.imageMask = image;
        int i = image.bpc;
        if (i > 1 && i <= 8) {
            z = true;
        }
        this.smask = z;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setInitialRotation(float f) {
        float f2 = this.rotationRadians - this.initialRotation;
        this.initialRotation = f;
        setRotation(f2);
    }

    public void setInterpolation(boolean z) {
        this.interpolation = z;
    }

    public void setInverted(boolean z) {
        this.invert = z;
    }

    public void setLayer(PdfOCG pdfOCG) {
        this.layer = pdfOCG;
    }

    public void setOriginalData(byte[] bArr) {
        this.originalData = bArr;
    }

    public void setOriginalType(int i) {
        this.originalType = i;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public void setRotation(float f) {
        float f2 = (float) (((double) (f + this.initialRotation)) % 6.283185307179586d);
        this.rotationRadians = f2;
        if (f2 < 0.0f) {
            this.rotationRadians = (float) (((double) f2) + 6.283185307179586d);
        }
        float[] fArrMatrix = matrix();
        this.scaledWidth = fArrMatrix[6] - fArrMatrix[4];
        this.scaledHeight = fArrMatrix[7] - fArrMatrix[5];
    }

    public void setRotationDegrees(float f) {
        setRotation((f / 180.0f) * ((float) 3.141592653589793d));
    }

    public void setScaleToFitHeight(boolean z) {
        this.scaleToFitHeight = z;
    }

    public void setScaleToFitLineWhenOverflow(boolean z) {
        this.scaleToFitLineWhenOverflow = z;
    }

    public void setSmask(boolean z) {
        this.smask = z;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    public void setTemplateData(PdfTemplate pdfTemplate) {
        this.template[0] = pdfTemplate;
    }

    public void setTransparency(int[] iArr) {
        this.transparency = iArr;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setWidthPercentage(float f) {
        this.widthPercentage = f;
    }

    public void setXYRatio(float f) {
        this.XYRatio = f;
    }

    public void simplifyColorspace() {
        PdfName pdfName;
        PdfArray asArray;
        PdfArray asArray2;
        PdfDictionary pdfDictionary = this.additional;
        if (pdfDictionary == null || (asArray = pdfDictionary.getAsArray((pdfName = PdfName.COLORSPACE))) == null) {
            return;
        }
        PdfObject pdfObjectSimplifyColorspace = simplifyColorspace(asArray);
        if (pdfObjectSimplifyColorspace.isName()) {
            asArray = pdfObjectSimplifyColorspace;
        } else if (PdfName.INDEXED.equals(asArray.getAsName(0)) && asArray.size() >= 2 && (asArray2 = asArray.getAsArray(1)) != null) {
            asArray.set(1, simplifyColorspace(asArray2));
        }
        this.additional.put(pdfName, asArray);
    }

    public void tagICC(ICC_Profile iCC_Profile) {
        this.profile = iCC_Profile;
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public int type() {
        return this.type;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x010d A[Catch: all -> 0x0048, TRY_ENTER, TryCatch #3 {all -> 0x0048, blocks: (B:3:0x000b, B:10:0x003e, B:18:0x0054, B:25:0x0064, B:33:0x0076, B:35:0x007c, B:37:0x0082, B:39:0x0086, B:41:0x008b, B:43:0x0090, B:49:0x009d, B:54:0x00ab, B:74:0x00f5, B:86:0x010d, B:87:0x0110, B:82:0x0106, B:110:0x015d, B:114:0x0164, B:115:0x0167, B:116:0x0168, B:117:0x017c), top: B:125:0x000b }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static Image getInstance(URL url, boolean z) throws Throwable {
        InputStream inputStream;
        RandomAccessFileOrArray randomAccessFileOrArray;
        RandomAccessFileOrArray randomAccessFileOrArray2;
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        try {
            InputStream inputStreamOpenStream = url.openStream();
            try {
                int i = inputStreamOpenStream.read();
                int i2 = inputStreamOpenStream.read();
                int i3 = inputStreamOpenStream.read();
                int i4 = inputStreamOpenStream.read();
                int i5 = inputStreamOpenStream.read();
                int i6 = inputStreamOpenStream.read();
                int i7 = inputStreamOpenStream.read();
                int i8 = inputStreamOpenStream.read();
                inputStreamOpenStream.close();
                if (i == 71 && i2 == 73 && i3 == 70) {
                    return new GifImage(url).getImage(1);
                }
                if (i == 255 && i2 == 216) {
                    return new Jpeg(url);
                }
                if (i == 0 && i2 == 0 && i3 == 0 && i4 == 12) {
                    return new Jpeg2000(url);
                }
                if (i == 255 && i2 == 79 && i3 == 255 && i4 == 81) {
                    return new Jpeg2000(url);
                }
                int[] iArr = PngImage.PNGID;
                if (i == iArr[0] && i2 == iArr[1] && i3 == iArr[2] && i4 == iArr[3]) {
                    return PngImage.getImage(url);
                }
                if (i == 215 && i2 == 205) {
                    return new ImgWMF(url);
                }
                if (i == 66 && i2 == 77) {
                    return BmpImage.getImage(url);
                }
                RandomAccessFileOrArray randomAccessFileOrArray3 = 42;
                if ((i == 77 && i2 == 77 && i3 == 0 && i4 == 42) || (i == 73 && i2 == 73 && i3 == 42 && i4 == 0)) {
                    try {
                        try {
                            randomAccessFileOrArray2 = url.getProtocol().equals(Annotation.FILE) ? new RandomAccessFileOrArray(randomAccessSourceFactory.createBestSource(Utilities.unEscapeURL(url.getFile()))) : new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(url));
                            try {
                                Image tiffImage = TiffImage.getTiffImage(randomAccessFileOrArray2, 1);
                                tiffImage.url = url;
                                randomAccessFileOrArray2.close();
                                return tiffImage;
                            } catch (RuntimeException e) {
                                e = e;
                                if (!z) {
                                    throw e;
                                }
                                Image tiffImage2 = TiffImage.getTiffImage(randomAccessFileOrArray2, z, 1);
                                tiffImage2.url = url;
                                if (randomAccessFileOrArray2 != null) {
                                    randomAccessFileOrArray2.close();
                                }
                                return tiffImage2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (randomAccessFileOrArray3 != 0) {
                                randomAccessFileOrArray3.close();
                            }
                            throw th;
                        }
                    } catch (RuntimeException e2) {
                        e = e2;
                        randomAccessFileOrArray2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFileOrArray3 = 0;
                        if (randomAccessFileOrArray3 != 0) {
                            randomAccessFileOrArray3.close();
                        }
                        throw th;
                    }
                } else {
                    if (i != 151 || i2 != 74 || i3 != 66 || i4 != 50 || i5 != 13 || i6 != 10 || i7 != 26 || i8 != 10) {
                        throw new IOException(MessageLocalization.getComposedMessage("unknown.image.format", url.toString()));
                    }
                    try {
                        randomAccessFileOrArray = url.getProtocol().equals(Annotation.FILE) ? new RandomAccessFileOrArray(randomAccessSourceFactory.createBestSource(Utilities.unEscapeURL(url.getFile()))) : new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(url));
                        try {
                            Image jbig2Image = JBIG2Image.getJbig2Image(randomAccessFileOrArray, 1);
                            jbig2Image.url = url;
                            randomAccessFileOrArray.close();
                            return jbig2Image;
                        } catch (Throwable th3) {
                            th = th3;
                            if (randomAccessFileOrArray != null) {
                                randomAccessFileOrArray.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        randomAccessFileOrArray = null;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = inputStreamOpenStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }

    public float[] matrix(float f) {
        float[] fArr = new float[8];
        float fCos = (float) Math.cos(this.rotationRadians);
        float fSin = (float) Math.sin(this.rotationRadians);
        float f2 = this.plainWidth;
        float f3 = f2 * fCos * f;
        fArr[0] = f3;
        float f4 = f2 * fSin * f;
        fArr[1] = f4;
        float f5 = this.plainHeight;
        float f6 = (-f5) * fSin * f;
        fArr[2] = f6;
        float f7 = f5 * fCos * f;
        fArr[3] = f7;
        float f8 = this.rotationRadians;
        if (f8 < 1.5707963267948966d) {
            fArr[4] = f6;
            fArr[5] = 0.0f;
            fArr[6] = f3;
            fArr[7] = f4 + f7;
        } else if (f8 < 3.141592653589793d) {
            fArr[4] = f3 + f6;
            fArr[5] = f7;
            fArr[6] = 0.0f;
            fArr[7] = f4;
        } else if (f8 < 4.71238898038469d) {
            fArr[4] = f3;
            fArr[5] = f4 + f7;
            fArr[6] = f6;
            fArr[7] = 0.0f;
        } else {
            fArr[4] = 0.0f;
            fArr[5] = f4;
            fArr[6] = f3 + f6;
            fArr[7] = f7;
        }
        return fArr;
    }

    public void scaleAbsolute(float f, float f2) {
        this.plainWidth = f;
        this.plainHeight = f2;
        float[] fArrMatrix = matrix();
        this.scaledWidth = fArrMatrix[6] - fArrMatrix[4];
        this.scaledHeight = fArrMatrix[7] - fArrMatrix[5];
        setWidthPercentage(0.0f);
    }

    public void scalePercent(float f, float f2) {
        this.plainWidth = (getWidth() * f) / 100.0f;
        this.plainHeight = (getHeight() * f2) / 100.0f;
        float[] fArrMatrix = matrix();
        this.scaledWidth = fArrMatrix[6] - fArrMatrix[4];
        this.scaledHeight = fArrMatrix[7] - fArrMatrix[5];
        setWidthPercentage(0.0f);
    }

    public void scaleToFit(float f, float f2) {
        scalePercent(100.0f);
        float scaledWidth = (f * 100.0f) / getScaledWidth();
        float scaledHeight = (f2 * 100.0f) / getScaledHeight();
        if (scaledWidth >= scaledHeight) {
            scaledWidth = scaledHeight;
        }
        scalePercent(scaledWidth);
        setWidthPercentage(0.0f);
    }

    private PdfObject simplifyColorspace(PdfArray pdfArray) {
        if (pdfArray == null) {
            return pdfArray;
        }
        PdfName asName = pdfArray.getAsName(0);
        if (PdfName.CALGRAY.equals(asName)) {
            return PdfName.DEVICEGRAY;
        }
        return PdfName.CALRGB.equals(asName) ? PdfName.DEVICERGB : pdfArray;
    }

    public Image(Image image) {
        super(image);
        this.bpc = 1;
        this.template = new PdfTemplate[1];
        this.absoluteX = Float.NaN;
        this.absoluteY = Float.NaN;
        this.compressionLevel = -1;
        this.mySerialId = getSerialId();
        this.role = PdfName.FIGURE;
        this.accessibleAttributes = null;
        this.id = null;
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.widthPercentage = 100.0f;
        this.scaleToFitHeight = true;
        this.annotation = null;
        this.originalType = 0;
        this.deflated = false;
        this.dpiX = 0;
        this.dpiY = 0;
        this.XYRatio = 0.0f;
        this.colorspace = -1;
        this.colortransform = 1;
        this.invert = false;
        this.profile = null;
        this.additional = null;
        this.mask = false;
        this.type = image.type;
        this.url = image.url;
        this.rawData = image.rawData;
        this.bpc = image.bpc;
        this.template = image.template;
        this.alignment = image.alignment;
        this.alt = image.alt;
        this.absoluteX = image.absoluteX;
        this.absoluteY = image.absoluteY;
        this.plainWidth = image.plainWidth;
        this.plainHeight = image.plainHeight;
        this.scaledWidth = image.scaledWidth;
        this.scaledHeight = image.scaledHeight;
        this.mySerialId = image.mySerialId;
        this.directReference = image.directReference;
        this.rotationRadians = image.rotationRadians;
        this.initialRotation = image.initialRotation;
        this.indentationLeft = image.indentationLeft;
        this.indentationRight = image.indentationRight;
        this.spacingBefore = image.spacingBefore;
        this.spacingAfter = image.spacingAfter;
        this.widthPercentage = image.widthPercentage;
        this.scaleToFitLineWhenOverflow = image.scaleToFitLineWhenOverflow;
        this.scaleToFitHeight = image.scaleToFitHeight;
        this.annotation = image.annotation;
        this.layer = image.layer;
        this.interpolation = image.interpolation;
        this.originalType = image.originalType;
        this.originalData = image.originalData;
        this.deflated = image.deflated;
        this.dpiX = image.dpiX;
        this.dpiY = image.dpiY;
        this.XYRatio = image.XYRatio;
        this.colorspace = image.colorspace;
        this.invert = image.invert;
        this.profile = image.profile;
        this.additional = image.additional;
        this.mask = image.mask;
        this.imageMask = image.imageMask;
        this.smask = image.smask;
        this.transparency = image.transparency;
        this.role = image.role;
        if (image.accessibleAttributes != null) {
            this.accessibleAttributes = new HashMap<>(image.accessibleAttributes);
        }
        setId(image.getId());
    }

    public static Image getInstance(String str) {
        return getInstance(Utilities.toURL(str));
    }

    public static Image getInstance(String str, boolean z) {
        return getInstance(Utilities.toURL(str), z);
    }

    public static Image getInstance(byte[] bArr) {
        return getInstance(bArr, false);
    }

    public static Image getInstance(byte[] bArr, boolean z) throws Throwable {
        RandomAccessFileOrArray randomAccessFileOrArray;
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        ByteArrayInputStream byteArrayInputStream = null;
        RandomAccessFileOrArray randomAccessFileOrArray2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                int i = byteArrayInputStream2.read();
                int i2 = byteArrayInputStream2.read();
                int i3 = byteArrayInputStream2.read();
                int i4 = byteArrayInputStream2.read();
                byteArrayInputStream2.close();
                if (i == 71 && i2 == 73 && i3 == 70) {
                    return new GifImage(bArr).getImage(1);
                }
                if (i == 255 && i2 == 216) {
                    return new Jpeg(bArr);
                }
                if (i == 0 && i2 == 0 && i3 == 0 && i4 == 12) {
                    return new Jpeg2000(bArr);
                }
                if (i == 255 && i2 == 79 && i3 == 255 && i4 == 81) {
                    return new Jpeg2000(bArr);
                }
                int[] iArr = PngImage.PNGID;
                if (i == iArr[0] && i2 == iArr[1] && i3 == iArr[2] && i4 == iArr[3]) {
                    return PngImage.getImage(bArr);
                }
                if (i == 215 && i2 == 205) {
                    return new ImgWMF(bArr);
                }
                if (i == 66 && i2 == 77) {
                    return BmpImage.getImage(bArr);
                }
                if ((i == 77 && i2 == 77 && i3 == 0 && i4 == 42) || (i == 73 && i2 == 73 && i3 == 42 && i4 == 0)) {
                    try {
                        randomAccessFileOrArray = new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(bArr));
                        try {
                            try {
                                Image tiffImage = TiffImage.getTiffImage(randomAccessFileOrArray, 1);
                                if (tiffImage.getOriginalData() == null) {
                                    tiffImage.setOriginalData(bArr);
                                }
                                randomAccessFileOrArray.close();
                                return tiffImage;
                            } catch (RuntimeException e) {
                                e = e;
                                if (z) {
                                    Image tiffImage2 = TiffImage.getTiffImage(randomAccessFileOrArray, z, 1);
                                    if (tiffImage2.getOriginalData() == null) {
                                        tiffImage2.setOriginalData(bArr);
                                    }
                                    if (randomAccessFileOrArray != null) {
                                        randomAccessFileOrArray.close();
                                    }
                                    return tiffImage2;
                                }
                                throw e;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (randomAccessFileOrArray != null) {
                                randomAccessFileOrArray.close();
                            }
                            throw th;
                        }
                    } catch (RuntimeException e2) {
                        e = e2;
                        randomAccessFileOrArray = null;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFileOrArray = null;
                    }
                } else {
                    if (i == 151 && i2 == 74 && i3 == 66 && i4 == 50) {
                        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
                        try {
                            byteArrayInputStream3.skip(4L);
                            int i5 = byteArrayInputStream3.read();
                            int i6 = byteArrayInputStream3.read();
                            int i7 = byteArrayInputStream3.read();
                            int i8 = byteArrayInputStream3.read();
                            byteArrayInputStream3.close();
                            if (i5 == 13 && i6 == 10 && i7 == 26 && i8 == 10) {
                                try {
                                    RandomAccessFileOrArray randomAccessFileOrArray3 = new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(bArr));
                                    try {
                                        Image jbig2Image = JBIG2Image.getJbig2Image(randomAccessFileOrArray3, 1);
                                        if (jbig2Image.getOriginalData() == null) {
                                            jbig2Image.setOriginalData(bArr);
                                        }
                                        randomAccessFileOrArray3.close();
                                        byteArrayInputStream3.close();
                                        return jbig2Image;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        randomAccessFileOrArray2 = randomAccessFileOrArray3;
                                        if (randomAccessFileOrArray2 != null) {
                                            randomAccessFileOrArray2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            byteArrayInputStream = byteArrayInputStream3;
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            throw th;
                        }
                    }
                    throw new IOException(MessageLocalization.getComposedMessage("the.byte.array.is.not.a.recognized.imageformat", new Object[0]));
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayInputStream = byteArrayInputStream2;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static Image getInstance(int i, int i2, int i3, int i4, byte[] bArr) {
        return getInstance(i, i2, i3, i4, bArr, (int[]) null);
    }

    public static Image getInstance(int i, int i2, byte[] bArr, byte[] bArr2) {
        return new ImgJBIG2(i, i2, bArr, bArr2);
    }

    public static Image getInstance(int i, int i2, boolean z, int i3, int i4, byte[] bArr) {
        return getInstance(i, i2, z, i3, i4, bArr, null);
    }

    public static Image getInstance(int i, int i2, boolean z, int i3, int i4, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr != null && iArr.length != 2) {
            throw new BadElementException(MessageLocalization.getComposedMessage("transparency.length.must.be.equal.to.2.with.ccitt.images", new Object[0]));
        }
        ImgCCITT imgCCITT = new ImgCCITT(i, i2, z, i3, i4, bArr);
        imgCCITT.transparency = iArr;
        return imgCCITT;
    }

    public static Image getInstance(int i, int i2, int i3, int i4, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr != null && iArr.length != i3 * 2) {
            throw new BadElementException(MessageLocalization.getComposedMessage("transparency.length.must.be.equal.to.componentes.2", new Object[0]));
        }
        if (i3 == 1 && i4 == 1) {
            return getInstance(i, i2, false, 256, 1, CCITTG4Encoder.compress(bArr, i, i2), iArr);
        }
        ImgRaw imgRaw = new ImgRaw(i, i2, i3, i4, bArr);
        imgRaw.transparency = iArr;
        return imgRaw;
    }

    public static Image getInstance(PdfTemplate pdfTemplate) {
        return new ImgTemplate(pdfTemplate);
    }

    public static Image getInstance(PRIndirectReference pRIndirectReference) {
        Image image;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference);
        int iIntValue = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.WIDTH))).intValue();
        int iIntValue2 = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.HEIGHT))).intValue();
        PdfObject pdfObject = pdfDictionary.get(PdfName.SMASK);
        if (pdfObject != null && pdfObject.isIndirect()) {
            image = getInstance((PRIndirectReference) pdfObject);
        } else {
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.MASK);
            image = (pdfObject2 != null && pdfObject2.isIndirect() && (PdfReader.getPdfObjectRelease(pdfObject2) instanceof PdfDictionary)) ? getInstance((PRIndirectReference) pdfObject2) : null;
        }
        ImgRaw imgRaw = new ImgRaw(iIntValue, iIntValue2, 1, 1, null);
        imgRaw.imageMask = image;
        ((Image) imgRaw).directReference = pRIndirectReference;
        return imgRaw;
    }

    public static Image getInstance(Image image) {
        if (image == null) {
            return null;
        }
        try {
            return (Image) image.getClass().getDeclaredConstructor(Image.class).newInstance(image);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
