package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.RASInputStream;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.security.CertificateInfo;
import com.itextpdf.text.pdf.security.SecurityConstants;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class PdfSignatureAppearance {
    public static final int CERTIFIED_FORM_FILLING = 2;
    public static final int CERTIFIED_FORM_FILLING_AND_ANNOTATIONS = 3;
    public static final int CERTIFIED_NO_CHANGES_ALLOWED = 1;
    private static final float MARGIN = 2.0f;
    public static final int NOT_CERTIFIED = 0;
    private static final float TOP_SECTION = 0.3f;
    public static final String questionMark = "% DSUnknown\nq\n1 G\n1 g\n0.1 0 0 0.1 9 0 cm\n0 J 0 j 4 M []0 d\n1 i \n0 g\n313 292 m\n313 404 325 453 432 529 c\n478 561 504 597 504 645 c\n504 736 440 760 391 760 c\n286 760 271 681 265 626 c\n265 625 l\n100 625 l\n100 828 253 898 381 898 c\n451 898 679 878 679 650 c\n679 555 628 499 538 435 c\n488 399 467 376 467 292 c\n313 292 l\nh\n308 214 170 -164 re\nf\n0.44 G\n1.2 w\n1 1 0.4 rg\n287 318 m\n287 430 299 479 406 555 c\n451 587 478 623 478 671 c\n478 762 414 786 365 786 c\n260 786 245 707 239 652 c\n239 651 l\n74 651 l\n74 854 227 924 355 924 c\n425 924 653 904 653 676 c\n653 581 602 525 512 461 c\n462 425 441 402 441 318 c\n287 318 l\nh\n282 240 170 -164 re\nB\nQ\n";
    private byte[] bout;
    private int boutLen;
    private String contact;
    private PdfDictionary cryptoDictionary;
    private HashMap<PdfName, PdfLiteral> exclusionLocations;
    private PdfSigLockDictionary fieldLock;
    private PdfTemplate frm;
    private Image image;
    private float imageScale;
    private Font layer2Font;
    private String layer2Text;
    private String layer4Text;
    private String location;
    private OutputStream originalout;
    private Rectangle pageRect;
    private RandomAccessFile raf;
    private long[] range;
    private String reason;
    private Rectangle rect;
    private Certificate signCertificate;
    private SignatureEvent signatureEvent;
    private ByteBuffer sigout;
    private PdfStamper stamper;
    private File tempFile;
    private PdfStamperImp writer;
    private int certificationLevel = 0;
    private String reasonCaption = "Reason: ";
    private String locationCaption = "Location: ";
    private int page = 1;
    private RenderingMode renderingMode = RenderingMode.DESCRIPTION;
    private Image signatureGraphic = null;
    private boolean acro6Layers = true;
    private PdfTemplate[] app = new PdfTemplate[5];
    private boolean reuseAppearance = false;
    private int runDirection = 1;
    private boolean preClosed = false;
    private Calendar signDate = new GregorianCalendar();
    private String fieldName = getNewSigName();
    private String signatureCreator = Version.getInstance().getVersion();

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.PdfSignatureAppearance$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$PdfSignatureAppearance$RenderingMode;

        static {
            int[] iArr = new int[RenderingMode.values().length];
            $SwitchMap$com$itextpdf$text$pdf$PdfSignatureAppearance$RenderingMode = iArr;
            try {
                iArr[RenderingMode.NAME_AND_DESCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PdfSignatureAppearance$RenderingMode[RenderingMode.GRAPHIC_AND_DESCRIPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PdfSignatureAppearance$RenderingMode[RenderingMode.GRAPHIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum RenderingMode {
        DESCRIPTION,
        NAME_AND_DESCRIPTION,
        GRAPHIC_AND_DESCRIPTION,
        GRAPHIC
    }

    public interface SignatureEvent {
        void getSignatureDictionary(PdfDictionary pdfDictionary);
    }

    public PdfSignatureAppearance(PdfStamperImp pdfStamperImp) {
        this.writer = pdfStamperImp;
    }

    private void addDocMDP(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        pdfDictionary3.put(PdfName.P, new PdfNumber(this.certificationLevel));
        pdfDictionary3.put(PdfName.V, new PdfName("1.2"));
        PdfName pdfName = PdfName.TYPE;
        PdfName pdfName2 = PdfName.TRANSFORMPARAMS;
        pdfDictionary3.put(pdfName, pdfName2);
        pdfDictionary2.put(PdfName.TRANSFORMMETHOD, PdfName.DOCMDP);
        pdfDictionary2.put(pdfName, PdfName.SIGREF);
        pdfDictionary2.put(pdfName2, pdfDictionary3);
        if (this.writer.getPdfVersion().getVersion() < '6') {
            pdfDictionary2.put(new PdfName(SecurityConstants.DigestValue), new PdfString("aa"));
            PdfArray pdfArray = new PdfArray();
            pdfArray.add(new PdfNumber(0));
            pdfArray.add(new PdfNumber(0));
            pdfDictionary2.put(new PdfName("DigestLocation"), pdfArray);
            pdfDictionary2.put(new PdfName(SecurityConstants.DigestMethod), new PdfName("MD5"));
        }
        pdfDictionary2.put(PdfName.DATA, this.writer.reader.getTrailer().get(PdfName.ROOT));
        PdfArray pdfArray2 = new PdfArray();
        pdfArray2.add(pdfDictionary2);
        pdfDictionary.put(PdfName.REFERENCE, pdfArray2);
    }

    private void addFieldMDP(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        PdfDictionary pdfDictionary4 = new PdfDictionary();
        pdfDictionary4.putAll(pdfDictionary2);
        PdfName pdfName = PdfName.TYPE;
        PdfName pdfName2 = PdfName.TRANSFORMPARAMS;
        pdfDictionary4.put(pdfName, pdfName2);
        pdfDictionary4.put(PdfName.V, new PdfName("1.2"));
        pdfDictionary3.put(PdfName.TRANSFORMMETHOD, PdfName.FIELDMDP);
        pdfDictionary3.put(pdfName, PdfName.SIGREF);
        pdfDictionary3.put(pdfName2, pdfDictionary4);
        pdfDictionary3.put(new PdfName(SecurityConstants.DigestValue), new PdfString("aa"));
        PdfArray pdfArray = new PdfArray();
        pdfArray.add(new PdfNumber(0));
        pdfArray.add(new PdfNumber(0));
        pdfDictionary3.put(new PdfName("DigestLocation"), pdfArray);
        pdfDictionary3.put(new PdfName(SecurityConstants.DigestMethod), new PdfName("MD5"));
        pdfDictionary3.put(PdfName.DATA, this.writer.reader.getTrailer().get(PdfName.ROOT));
        PdfName pdfName3 = PdfName.REFERENCE;
        PdfArray asArray = pdfDictionary.getAsArray(pdfName3);
        PdfArray pdfArray2 = asArray;
        if (asArray == null) {
            pdfArray2 = new PdfArray();
        }
        pdfArray2.add(pdfDictionary3);
        pdfDictionary.put(pdfName3, pdfArray2);
    }

    private void createBlankN0() {
        PdfTemplate[] pdfTemplateArr = this.app;
        PdfTemplate pdfTemplate = new PdfTemplate(this.writer);
        pdfTemplateArr[0] = pdfTemplate;
        pdfTemplate.setBoundingBox(new Rectangle(100.0f, 100.0f));
        this.writer.addDirectTemplateSimple(pdfTemplate, new PdfName("n0"));
        pdfTemplate.setLiteral("% DSBlank\n");
    }

    private RandomAccessSource getUnderlyingSource() {
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        RandomAccessFile randomAccessFile = this.raf;
        return randomAccessFile == null ? randomAccessSourceFactory.createSource(this.bout) : randomAccessSourceFactory.createSource(randomAccessFile);
    }

    public void addDeveloperExtension(PdfDeveloperExtension pdfDeveloperExtension) {
        this.writer.addDeveloperExtension(pdfDeveloperExtension);
    }

    public void close(PdfDictionary pdfDictionary) {
        try {
            if (!this.preClosed) {
                throw new DocumentException(MessageLocalization.getComposedMessage("preclose.must.be.called.first", new Object[0]));
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject = pdfDictionary.get(pdfName);
                PdfLiteral pdfLiteral = this.exclusionLocations.get(pdfName);
                if (pdfLiteral == null) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.key.1.didn.t.reserve.space.in.preclose", pdfName.toString()));
                }
                byteBuffer.reset();
                pdfObject.toPdf(null, byteBuffer);
                if (byteBuffer.size() > pdfLiteral.getPosLength()) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.key.1.is.too.big.is.2.reserved.3", pdfName.toString(), String.valueOf(byteBuffer.size()), String.valueOf(pdfLiteral.getPosLength())));
                }
                if (this.tempFile == null) {
                    System.arraycopy(byteBuffer.getBuffer(), 0, this.bout, (int) pdfLiteral.getPosition(), byteBuffer.size());
                } else {
                    this.raf.seek(pdfLiteral.getPosition());
                    this.raf.write(byteBuffer.getBuffer(), 0, byteBuffer.size());
                }
            }
            if (pdfDictionary.size() != this.exclusionLocations.size()) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.update.dictionary.has.less.keys.than.required", new Object[0]));
            }
            if (this.tempFile == null) {
                this.originalout.write(this.bout, 0, this.boutLen);
            } else if (this.originalout != null) {
                this.raf.seek(0L);
                long length = this.raf.length();
                byte[] bArr = new byte[8192];
                while (length > 0) {
                    int i = this.raf.read(bArr, 0, (int) Math.min(8192, length));
                    if (i < 0) {
                        throw new EOFException(MessageLocalization.getComposedMessage("unexpected.eof", new Object[0]));
                    }
                    this.originalout.write(bArr, 0, i);
                    length -= (long) i;
                }
            }
            this.writer.reader.close();
            if (this.tempFile != null) {
                try {
                    this.raf.close();
                } catch (Exception unused) {
                }
                if (this.originalout != null) {
                    try {
                        this.tempFile.delete();
                    } catch (Exception unused2) {
                    }
                }
            }
            OutputStream outputStream = this.originalout;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            this.writer.reader.close();
            if (this.tempFile != null) {
                try {
                    this.raf.close();
                } catch (Exception unused4) {
                }
                if (this.originalout != null) {
                    try {
                        this.tempFile.delete();
                    } catch (Exception unused5) {
                    }
                }
            }
            OutputStream outputStream2 = this.originalout;
            if (outputStream2 == null) {
                throw th;
            }
            try {
                outputStream2.close();
                throw th;
            } catch (Exception unused6) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x061f  */
    public PdfTemplate getAppearance() throws DocumentException {
        float f;
        char c;
        Rectangle rectangle;
        Rectangle rectangle2;
        String field;
        if (isInvisible()) {
            PdfTemplate pdfTemplate = new PdfTemplate(this.writer);
            pdfTemplate.setBoundingBox(new Rectangle(0.0f, 0.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate, null);
            return pdfTemplate;
        }
        if (this.app[0] == null && !this.reuseAppearance) {
            createBlankN0();
        }
        PdfTemplate[] pdfTemplateArr = this.app;
        if (pdfTemplateArr[1] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate2 = new PdfTemplate(this.writer);
            pdfTemplateArr[1] = pdfTemplate2;
            pdfTemplate2.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate2, new PdfName("n1"));
            pdfTemplate2.setLiteral(questionMark);
        }
        if (this.app[2] == null) {
            String string = this.layer2Text;
            if (string == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Digitally signed by ");
                CertificateInfo.X500Name subjectFields = CertificateInfo.getSubjectFields((X509Certificate) this.signCertificate);
                if (subjectFields != null) {
                    field = subjectFields.getField("CN");
                    if (field == null) {
                        field = subjectFields.getField("E");
                    }
                } else {
                    field = null;
                }
                sb.append(field == null ? "" : field);
                sb.append('\n');
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
                sb.append("Date: ");
                sb.append(simpleDateFormat.format(this.signDate.getTime()));
                if (this.reason != null) {
                    sb.append('\n');
                    sb.append(this.reasonCaption);
                    sb.append(this.reason);
                }
                if (this.location != null) {
                    sb.append('\n');
                    sb.append(this.locationCaption);
                    sb.append(this.location);
                }
                string = sb.toString();
            }
            PdfTemplate[] pdfTemplateArr2 = this.app;
            PdfTemplate pdfTemplate3 = new PdfTemplate(this.writer);
            pdfTemplateArr2[2] = pdfTemplate3;
            pdfTemplate3.setBoundingBox(this.rect);
            this.writer.addDirectTemplateSimple(pdfTemplate3, new PdfName("n2"));
            Image image = this.image;
            if (image != null) {
                float fMin = this.imageScale;
                if (fMin == 0.0f) {
                    pdfTemplate3.addImage(image, this.rect.getWidth(), 0.0f, 0.0f, this.rect.getHeight(), 0.0f, 0.0f);
                } else {
                    if (fMin < 0.0f) {
                        fMin = Math.min(this.rect.getWidth() / this.image.getWidth(), this.rect.getHeight() / this.image.getHeight());
                    }
                    float width = this.image.getWidth() * fMin;
                    float height = this.image.getHeight() * fMin;
                    pdfTemplate3.addImage(this.image, width, 0.0f, 0.0f, height, (this.rect.getWidth() - width) / 2.0f, (this.rect.getHeight() - height) / 2.0f);
                }
            }
            Font font = this.layer2Font;
            Font font2 = font == null ? new Font() : new Font(font);
            float size = font2.getSize();
            RenderingMode renderingMode = this.renderingMode;
            if (renderingMode == RenderingMode.NAME_AND_DESCRIPTION || (renderingMode == RenderingMode.GRAPHIC_AND_DESCRIPTION && this.signatureGraphic != null)) {
                rectangle = new Rectangle(2.0f, 2.0f, (this.rect.getWidth() / 2.0f) - 2.0f, this.rect.getHeight() - 2.0f);
                Rectangle rectangle3 = new Rectangle((this.rect.getWidth() / 2.0f) + 1.0f, 2.0f, this.rect.getWidth() - 1.0f, this.rect.getHeight() - 2.0f);
                if (this.rect.getHeight() > this.rect.getWidth()) {
                    rectangle = new Rectangle(2.0f, this.rect.getHeight() / 2.0f, this.rect.getWidth() - 2.0f, this.rect.getHeight());
                    rectangle2 = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, (this.rect.getHeight() / 2.0f) - 2.0f);
                } else {
                    rectangle2 = rectangle3;
                }
            } else if (renderingMode != RenderingMode.GRAPHIC) {
                rectangle2 = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, (this.rect.getHeight() * 0.7f) - 2.0f);
                rectangle = null;
            } else {
                if (this.signatureGraphic == null) {
                    throw new IllegalStateException(MessageLocalization.getComposedMessage("a.signature.image.should.be.present.when.rendering.mode.is.graphic.only", new Object[0]));
                }
                rectangle = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, this.rect.getHeight() - 2.0f);
                rectangle2 = null;
            }
            int i = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$PdfSignatureAppearance$RenderingMode[this.renderingMode.ordinal()];
            if (i == 1) {
                String field2 = CertificateInfo.getSubjectFields((X509Certificate) this.signCertificate).getField("CN");
                if (field2 == null) {
                    field2 = CertificateInfo.getSubjectFields((X509Certificate) this.signCertificate).getField("E");
                }
                String str = field2 != null ? field2 : "";
                float fFitText = ColumnText.fitText(font2, str, new Rectangle(rectangle.getWidth() - 2.0f, rectangle.getHeight() - 2.0f), -1.0f, this.runDirection);
                ColumnText columnText = new ColumnText(pdfTemplate3);
                columnText.setRunDirection(this.runDirection);
                columnText.setSimpleColumn(new Phrase(str, font2), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), fFitText, 0);
                columnText.go();
            } else if (i == 2) {
                if (this.signatureGraphic == null) {
                    throw new IllegalStateException(MessageLocalization.getComposedMessage("a.signature.image.should.be.present.when.rendering.mode.is.graphic.and.description", new Object[0]));
                }
                ColumnText columnText2 = new ColumnText(pdfTemplate3);
                columnText2.setRunDirection(this.runDirection);
                columnText2.setSimpleColumn(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), 0.0f, 2);
                Image image2 = Image.getInstance(this.signatureGraphic);
                image2.scaleToFit(rectangle.getWidth(), rectangle.getHeight());
                Paragraph paragraph = new Paragraph();
                paragraph.add((Element) new Chunk(image2, ((rectangle.getWidth() - image2.getScaledWidth()) / 2.0f) + 0.0f + ((rectangle.getWidth() - image2.getScaledWidth()) / 2.0f), ((-image2.getScaledHeight()) + 15.0f) - ((rectangle.getHeight() - image2.getScaledHeight()) / 2.0f), false));
                columnText2.addElement(paragraph);
                columnText2.go();
            } else if (i == 3) {
                ColumnText columnText3 = new ColumnText(pdfTemplate3);
                columnText3.setRunDirection(this.runDirection);
                columnText3.setSimpleColumn(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), 0.0f, 2);
                Image image3 = Image.getInstance(this.signatureGraphic);
                image3.scaleToFit(rectangle.getWidth(), rectangle.getHeight());
                Paragraph paragraph2 = new Paragraph(rectangle.getHeight());
                paragraph2.add((Element) new Chunk(image3, (rectangle.getWidth() - image3.getScaledWidth()) / 2.0f, (rectangle.getHeight() - image3.getScaledHeight()) / 2.0f, false));
                columnText3.addElement(paragraph2);
                columnText3.go();
            }
            if (this.renderingMode != RenderingMode.GRAPHIC) {
                if (size <= 0.0f) {
                    size = ColumnText.fitText(font2, string, new Rectangle(rectangle2.getWidth(), rectangle2.getHeight()), 12.0f, this.runDirection);
                }
                ColumnText columnText4 = new ColumnText(pdfTemplate3);
                columnText4.setRunDirection(this.runDirection);
                columnText4.setSimpleColumn(new Phrase(string, font2), rectangle2.getLeft(), rectangle2.getBottom(), rectangle2.getRight(), rectangle2.getTop(), size, 0);
                columnText4.go();
            }
        }
        PdfTemplate[] pdfTemplateArr3 = this.app;
        if (pdfTemplateArr3[3] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate4 = new PdfTemplate(this.writer);
            pdfTemplateArr3[3] = pdfTemplate4;
            pdfTemplate4.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate4, new PdfName("n3"));
            pdfTemplate4.setLiteral("% DSBlank\n");
        }
        PdfTemplate[] pdfTemplateArr4 = this.app;
        if (pdfTemplateArr4[4] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate5 = new PdfTemplate(this.writer);
            pdfTemplateArr4[4] = pdfTemplate5;
            pdfTemplate5.setBoundingBox(new Rectangle(0.0f, this.rect.getHeight() * 0.7f, this.rect.getRight(), this.rect.getTop()));
            this.writer.addDirectTemplateSimple(pdfTemplate5, new PdfName("n4"));
            Font font3 = this.layer2Font;
            Font font4 = font3 == null ? new Font() : new Font(font3);
            String str2 = this.layer4Text;
            if (str2 == null) {
                str2 = "Signature Not Verified";
            }
            float fFitText2 = ColumnText.fitText(font4, str2, new Rectangle(this.rect.getWidth() - 4.0f, (this.rect.getHeight() * TOP_SECTION) - 4.0f), 15.0f, this.runDirection);
            ColumnText columnText5 = new ColumnText(pdfTemplate5);
            columnText5.setRunDirection(this.runDirection);
            columnText5.setSimpleColumn(new Phrase(str2, font4), 2.0f, 0.0f, this.rect.getWidth() - 2.0f, this.rect.getHeight() - 2.0f, fFitText2, 0);
            columnText5.go();
        }
        int pageRotation = this.writer.reader.getPageRotation(this.page);
        Rectangle rectangle4 = new Rectangle(this.rect);
        for (int i2 = pageRotation; i2 > 0; i2 -= 90) {
            rectangle4 = rectangle4.rotate();
        }
        if (this.frm == null) {
            PdfTemplate pdfTemplate6 = new PdfTemplate(this.writer);
            this.frm = pdfTemplate6;
            pdfTemplate6.setBoundingBox(rectangle4);
            this.writer.addDirectTemplateSimple(this.frm, new PdfName("FRM"));
            float fMin2 = Math.min(this.rect.getWidth(), this.rect.getHeight()) * 0.9f;
            float width2 = (this.rect.getWidth() - fMin2) / 2.0f;
            float height2 = (this.rect.getHeight() - fMin2) / 2.0f;
            float f2 = fMin2 / 100.0f;
            if (pageRotation == 90) {
                this.frm.concatCTM(0.0f, 1.0f, -1.0f, 0.0f, this.rect.getHeight(), 0.0f);
            } else if (pageRotation == 180) {
                this.frm.concatCTM(-1.0f, 0.0f, 0.0f, -1.0f, this.rect.getWidth(), this.rect.getHeight());
            } else if (pageRotation == 270) {
                this.frm.concatCTM(0.0f, -1.0f, 1.0f, 0.0f, 0.0f, this.rect.getWidth());
            }
            if (this.reuseAppearance) {
                PdfIndirectReference normalAppearance = this.writer.getAcroFields().getNormalAppearance(getFieldName());
                if (normalAppearance != null) {
                    this.frm.addTemplateReference(normalAppearance, new PdfName("n0"), 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f);
                    c = 0;
                } else {
                    c = 0;
                    this.reuseAppearance = false;
                    if (this.app[0] == null) {
                        createBlankN0();
                    }
                }
            } else {
                c = 0;
            }
            if (!this.reuseAppearance) {
                this.frm.addTemplate(this.app[c], 0.0f, 0.0f);
            }
            if (!this.acro6Layers) {
                this.frm.addTemplate(this.app[1], f2, 0.0f, 0.0f, f2, width2, height2);
            }
            this.frm.addTemplate(this.app[2], 0.0f, 0.0f);
            if (this.acro6Layers) {
                f = 0.0f;
            } else {
                this.frm.addTemplate(this.app[3], f2, 0.0f, 0.0f, f2, width2, height2);
                f = 0.0f;
                this.frm.addTemplate(this.app[4], 0.0f, 0.0f);
            }
        } else {
            f = 0.0f;
        }
        PdfTemplate pdfTemplate7 = new PdfTemplate(this.writer);
        pdfTemplate7.setBoundingBox(rectangle4);
        this.writer.addDirectTemplateSimple(pdfTemplate7, null);
        pdfTemplate7.addTemplate(this.frm, f, f);
        return pdfTemplate7;
    }

    public Certificate getCertificate() {
        return this.signCertificate;
    }

    public int getCertificationLevel() {
        return this.certificationLevel;
    }

    public String getContact() {
        return this.contact;
    }

    public PdfDictionary getCryptoDictionary() {
        return this.cryptoDictionary;
    }

    public PdfSigLockDictionary getFieldLockDict() {
        return this.fieldLock;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Image getImage() {
        return this.image;
    }

    public float getImageScale() {
        return this.imageScale;
    }

    public PdfTemplate getLayer(int i) {
        if (i < 0) {
            return null;
        }
        PdfTemplate[] pdfTemplateArr = this.app;
        if (i >= pdfTemplateArr.length) {
            return null;
        }
        PdfTemplate pdfTemplate = pdfTemplateArr[i];
        if (pdfTemplate != null) {
            return pdfTemplate;
        }
        PdfTemplate pdfTemplate2 = new PdfTemplate(this.writer);
        pdfTemplateArr[i] = pdfTemplate2;
        pdfTemplate2.setBoundingBox(this.rect);
        this.writer.addDirectTemplateSimple(pdfTemplate2, new PdfName("n" + i));
        return pdfTemplate2;
    }

    public Font getLayer2Font() {
        return this.layer2Font;
    }

    public String getLayer2Text() {
        return this.layer2Text;
    }

    public String getLayer4Text() {
        return this.layer4Text;
    }

    public String getLocation() {
        return this.location;
    }

    public String getNewSigName() {
        AcroFields acroFields = this.writer.getAcroFields();
        boolean z = false;
        int i = 0;
        while (!z) {
            i++;
            String str = SecurityConstants.Signature + i;
            if (acroFields.getFieldItem(str) == null) {
                String str2 = str + ".";
                Iterator<String> it = acroFields.getFields().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    if (it.next().startsWith(str2)) {
                        z = false;
                        break;
                    }
                }
            }
        }
        return SecurityConstants.Signature + i;
    }

    public OutputStream getOriginalout() {
        return this.originalout;
    }

    public int getPage() {
        return this.page;
    }

    public Rectangle getPageRect() {
        return this.pageRect;
    }

    public InputStream getRangeStream() {
        return new RASInputStream(new RandomAccessSourceFactory().createRanged(getUnderlyingSource(), this.range));
    }

    public String getReason() {
        return this.reason;
    }

    public Rectangle getRect() {
        return this.rect;
    }

    public RenderingMode getRenderingMode() {
        return this.renderingMode;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public Calendar getSignDate() {
        return this.signDate;
    }

    public String getSignatureCreator() {
        return this.signatureCreator;
    }

    public SignatureEvent getSignatureEvent() {
        return this.signatureEvent;
    }

    public Image getSignatureGraphic() {
        return this.signatureGraphic;
    }

    public ByteBuffer getSigout() {
        return this.sigout;
    }

    public PdfStamper getStamper() {
        return this.stamper;
    }

    public File getTempFile() {
        return this.tempFile;
    }

    public PdfTemplate getTopLayer() {
        if (this.frm == null) {
            PdfTemplate pdfTemplate = new PdfTemplate(this.writer);
            this.frm = pdfTemplate;
            pdfTemplate.setBoundingBox(this.rect);
            this.writer.addDirectTemplateSimple(this.frm, new PdfName("FRM"));
        }
        return this.frm;
    }

    public boolean isAcro6Layers() {
        return this.acro6Layers;
    }

    public boolean isInvisible() {
        Rectangle rectangle = this.rect;
        return rectangle == null || rectangle.getWidth() == 0.0f || this.rect.getHeight() == 0.0f;
    }

    public boolean isPreClosed() {
        return this.preClosed;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void preClose(HashMap<PdfName, Integer> map) throws DocumentException, IOException {
        PdfSigLockDictionary pdfSigLockDictionary;
        PdfDictionary asDict;
        PdfSigLockDictionary pdfSigLockDictionary2;
        if (this.preClosed) {
            throw new DocumentException(MessageLocalization.getComposedMessage("document.already.pre.closed", new Object[0]));
        }
        this.stamper.mergeVerification();
        this.preClosed = true;
        AcroFields acroFields = this.writer.getAcroFields();
        String fieldName = getFieldName();
        boolean zDoesSignatureFieldExist = acroFields.doesSignatureFieldExist(fieldName);
        PdfIndirectReference pdfIndirectReference = this.writer.getPdfIndirectReference();
        int i = 3;
        this.writer.setSigFlags(3);
        if (zDoesSignatureFieldExist) {
            PdfDictionary widget = acroFields.getFieldItem(fieldName).getWidget(0);
            this.writer.markUsed(widget);
            PdfName pdfName = PdfName.LOCK;
            asDict = widget.getAsDict(pdfName);
            if (asDict == null && (pdfSigLockDictionary2 = this.fieldLock) != null) {
                widget.put(pdfName, this.writer.addToBody(pdfSigLockDictionary2).getIndirectReference());
                asDict = this.fieldLock;
            }
            widget.put(PdfName.P, this.writer.getPageReference(getPage()));
            widget.put(PdfName.V, pdfIndirectReference);
            PdfName pdfName2 = PdfName.F;
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(widget.get(pdfName2));
            widget.put(pdfName2, new PdfNumber(((pdfObjectRelease == null || !pdfObjectRelease.isNumber()) ? 0 : ((PdfNumber) pdfObjectRelease).intValue()) | 128));
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.N, getAppearance().getIndirectReference());
            widget.put(PdfName.AP, pdfDictionary);
        } else {
            PdfFormField pdfFormFieldCreateSignature = PdfFormField.createSignature(this.writer);
            pdfFormFieldCreateSignature.setFieldName(fieldName);
            pdfFormFieldCreateSignature.put(PdfName.V, pdfIndirectReference);
            pdfFormFieldCreateSignature.setFlags(ShapeTypes.FLOW_CHART_PROCESS);
            PdfSigLockDictionary pdfSigLockDictionary3 = this.fieldLock;
            if (pdfSigLockDictionary3 != null) {
                pdfFormFieldCreateSignature.put(PdfName.LOCK, this.writer.addToBody(pdfSigLockDictionary3).getIndirectReference());
                pdfSigLockDictionary = this.fieldLock;
            } else {
                pdfSigLockDictionary = null;
            }
            int page = getPage();
            if (isInvisible()) {
                pdfFormFieldCreateSignature.setWidget(new Rectangle(0.0f, 0.0f), null);
            } else {
                pdfFormFieldCreateSignature.setWidget(getPageRect(), null);
            }
            pdfFormFieldCreateSignature.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, getAppearance());
            pdfFormFieldCreateSignature.setPage(page);
            this.writer.addAnnotation(pdfFormFieldCreateSignature, page);
            asDict = pdfSigLockDictionary;
        }
        this.exclusionLocations = new HashMap<>();
        if (this.cryptoDictionary == null) {
            throw new DocumentException("No crypto dictionary defined.");
        }
        PdfLiteral pdfLiteral = new PdfLiteral(80);
        HashMap<PdfName, PdfLiteral> map2 = this.exclusionLocations;
        PdfName pdfName3 = PdfName.BYTERANGE;
        map2.put(pdfName3, pdfLiteral);
        this.cryptoDictionary.put(pdfName3, pdfLiteral);
        for (Map.Entry<PdfName, Integer> entry : map.entrySet()) {
            PdfName key = entry.getKey();
            PdfLiteral pdfLiteral2 = new PdfLiteral(entry.getValue().intValue());
            this.exclusionLocations.put(key, pdfLiteral2);
            this.cryptoDictionary.put(key, pdfLiteral2);
        }
        if (this.certificationLevel > 0) {
            addDocMDP(this.cryptoDictionary);
        }
        if (asDict != null) {
            addFieldMDP(this.cryptoDictionary, asDict);
        }
        SignatureEvent signatureEvent = this.signatureEvent;
        if (signatureEvent != null) {
            signatureEvent.getSignatureDictionary(this.cryptoDictionary);
        }
        this.writer.addToBody((PdfObject) this.cryptoDictionary, pdfIndirectReference, false);
        if (this.certificationLevel > 0) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(new PdfName("DocMDP"), pdfIndirectReference);
            this.writer.reader.getCatalog().put(new PdfName("Perms"), pdfDictionary2);
        }
        this.writer.close(this.stamper.getMoreInfo());
        this.range = new long[this.exclusionLocations.size() * 2];
        HashMap<PdfName, PdfLiteral> map3 = this.exclusionLocations;
        PdfName pdfName4 = PdfName.BYTERANGE;
        long position = map3.get(pdfName4).getPosition();
        this.exclusionLocations.remove(pdfName4);
        int i2 = 1;
        for (PdfLiteral pdfLiteral3 : this.exclusionLocations.values()) {
            long position2 = pdfLiteral3.getPosition();
            long[] jArr = this.range;
            int i3 = i2 + 1;
            jArr[i2] = position2;
            i2 += 2;
            jArr[i3] = ((long) pdfLiteral3.getPosLength()) + position2;
        }
        long[] jArr2 = this.range;
        Arrays.sort(jArr2, 1, jArr2.length - 1);
        while (true) {
            long[] jArr3 = this.range;
            if (i >= jArr3.length - 2) {
                break;
            }
            jArr3[i] = jArr3[i] - jArr3[i - 1];
            i += 2;
        }
        if (this.tempFile == null) {
            this.bout = this.sigout.getBuffer();
            int size = this.sigout.size();
            this.boutLen = size;
            long[] jArr4 = this.range;
            jArr4[jArr4.length - 1] = ((long) size) - jArr4[jArr4.length - 2];
            ByteBuffer byteBuffer = new ByteBuffer();
            byteBuffer.append('[');
            int i4 = 0;
            while (true) {
                long[] jArr5 = this.range;
                if (i4 >= jArr5.length) {
                    byteBuffer.append(']');
                    System.arraycopy(byteBuffer.getBuffer(), 0, this.bout, (int) position, byteBuffer.size());
                    return;
                } else {
                    byteBuffer.append(jArr5[i4]).append(' ');
                    i4++;
                }
            }
        } else {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.tempFile, "rw");
                this.raf = randomAccessFile;
                long length = randomAccessFile.length();
                long[] jArr6 = this.range;
                jArr6[jArr6.length - 1] = length - jArr6[jArr6.length - 2];
                ByteBuffer byteBuffer2 = new ByteBuffer();
                byteBuffer2.append('[');
                int i5 = 0;
                while (true) {
                    long[] jArr7 = this.range;
                    if (i5 >= jArr7.length) {
                        byteBuffer2.append(']');
                        this.raf.seek(position);
                        this.raf.write(byteBuffer2.getBuffer(), 0, byteBuffer2.size());
                        return;
                    }
                    byteBuffer2.append(jArr7[i5]).append(' ');
                    i5++;
                }
            } catch (IOException e) {
                try {
                    this.raf.close();
                } catch (Exception unused) {
                }
                try {
                    this.tempFile.delete();
                    throw e;
                } catch (Exception unused2) {
                    throw e;
                }
            }
        }
    }

    public void setAcro6Layers(boolean z) {
        this.acro6Layers = z;
    }

    public void setCertificate(Certificate certificate) {
        this.signCertificate = certificate;
    }

    public void setCertificationLevel(int i) {
        this.certificationLevel = i;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public void setCryptoDictionary(PdfDictionary pdfDictionary) {
        this.cryptoDictionary = pdfDictionary;
    }

    public void setFieldLockDict(PdfSigLockDictionary pdfSigLockDictionary) {
        this.fieldLock = pdfSigLockDictionary;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setImageScale(float f) {
        this.imageScale = f;
    }

    public void setLayer2Font(Font font) {
        this.layer2Font = font;
    }

    public void setLayer2Text(String str) {
        this.layer2Text = str;
    }

    public void setLayer4Text(String str) {
        this.layer4Text = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setLocationCaption(String str) {
        this.locationCaption = str;
    }

    public void setOriginalout(OutputStream outputStream) {
        this.originalout = outputStream;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonCaption(String str) {
        this.reasonCaption = str;
    }

    public void setRenderingMode(RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    public void setReuseAppearance(boolean z) {
        this.reuseAppearance = z;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    public void setSignatureCreator(String str) {
        this.signatureCreator = str;
    }

    public void setSignatureEvent(SignatureEvent signatureEvent) {
        this.signatureEvent = signatureEvent;
    }

    public void setSignatureGraphic(Image image) {
        this.signatureGraphic = image;
    }

    public void setSigout(ByteBuffer byteBuffer) {
        this.sigout = byteBuffer;
    }

    public void setStamper(PdfStamper pdfStamper) {
        this.stamper = pdfStamper;
    }

    public void setTempFile(File file) {
        this.tempFile = file;
    }

    public void setVisibleSignature(Rectangle rectangle, int i, String str) {
        if (str != null) {
            if (str.indexOf(46) >= 0) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("field.names.cannot.contain.a.dot", new Object[0]));
            }
            if (this.writer.getAcroFields().getFieldItem(str) != null) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.field.1.already.exists", str));
            }
            this.fieldName = str;
        }
        if (i < 1 || i > this.writer.reader.getNumberOfPages()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.page.number.1", i));
        }
        Rectangle rectangle2 = new Rectangle(rectangle);
        this.pageRect = rectangle2;
        rectangle2.normalize();
        this.rect = new Rectangle(this.pageRect.getWidth(), this.pageRect.getHeight());
        this.page = i;
    }

    public void setVisibleSignature(String str) {
        AcroFields.Item fieldItem = this.writer.getAcroFields().getFieldItem(str);
        if (fieldItem != null) {
            PdfDictionary merged = fieldItem.getMerged(0);
            if (PdfName.SIG.equals(PdfReader.getPdfObject(merged.get(PdfName.FT)))) {
                this.fieldName = str;
                PdfArray asArray = merged.getAsArray(PdfName.RECT);
                Rectangle rectangle = new Rectangle(asArray.getAsNumber(0).floatValue(), asArray.getAsNumber(1).floatValue(), asArray.getAsNumber(2).floatValue(), asArray.getAsNumber(3).floatValue());
                this.pageRect = rectangle;
                rectangle.normalize();
                int iIntValue = fieldItem.getPage(0).intValue();
                this.page = iIntValue;
                int pageRotation = this.writer.reader.getPageRotation(iIntValue);
                Rectangle pageSizeWithRotation = this.writer.reader.getPageSizeWithRotation(this.page);
                if (pageRotation == 90) {
                    this.pageRect = new Rectangle(this.pageRect.getBottom(), pageSizeWithRotation.getTop() - this.pageRect.getLeft(), this.pageRect.getTop(), pageSizeWithRotation.getTop() - this.pageRect.getRight());
                } else if (pageRotation == 180) {
                    this.pageRect = new Rectangle(pageSizeWithRotation.getRight() - this.pageRect.getLeft(), pageSizeWithRotation.getTop() - this.pageRect.getBottom(), pageSizeWithRotation.getRight() - this.pageRect.getRight(), pageSizeWithRotation.getTop() - this.pageRect.getTop());
                } else if (pageRotation == 270) {
                    this.pageRect = new Rectangle(pageSizeWithRotation.getRight() - this.pageRect.getBottom(), this.pageRect.getLeft(), pageSizeWithRotation.getRight() - this.pageRect.getTop(), this.pageRect.getRight());
                }
                if (pageRotation != 0) {
                    this.pageRect.normalize();
                }
                this.rect = new Rectangle(this.pageRect.getWidth(), this.pageRect.getHeight());
                return;
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.field.1.is.not.a.signature.field", str));
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.field.1.does.not.exist", str));
    }
}
