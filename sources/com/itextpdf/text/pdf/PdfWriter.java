package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgJBIG2;
import com.itextpdf.text.ImgWMF;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.TempFileCache;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.events.PdfPageEventForwarder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.PdfAnnotations;
import com.itextpdf.text.pdf.interfaces.PdfDocumentActions;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfIsoConformance;
import com.itextpdf.text.pdf.interfaces.PdfPageActions;
import com.itextpdf.text.pdf.interfaces.PdfRunDirection;
import com.itextpdf.text.pdf.interfaces.PdfVersion;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.interfaces.PdfXConformance;
import com.itextpdf.text.pdf.internal.PdfVersionImp;
import com.itextpdf.text.pdf.internal.PdfXConformanceImp;
import com.itextpdf.text.xml.xmp.PdfProperties;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.options.PropertyOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public class PdfWriter extends DocWriter implements PdfViewerPreferences, PdfEncryptionSettings, PdfVersion, PdfDocumentActions, PdfPageActions, PdfRunDirection, PdfAnnotations {
    public static final int ALLOW_ASSEMBLY = 1024;
    public static final int ALLOW_COPY = 16;
    public static final int ALLOW_DEGRADED_PRINTING = 4;
    public static final int ALLOW_FILL_IN = 256;
    public static final int ALLOW_MODIFY_ANNOTATIONS = 32;
    public static final int ALLOW_MODIFY_CONTENTS = 8;
    public static final int ALLOW_PRINTING = 2052;
    public static final int ALLOW_SCREENREADERS = 512;

    @Deprecated
    public static final int AllowAssembly = 1024;

    @Deprecated
    public static final int AllowCopy = 16;

    @Deprecated
    public static final int AllowDegradedPrinting = 4;

    @Deprecated
    public static final int AllowFillIn = 256;

    @Deprecated
    public static final int AllowModifyAnnotations = 32;

    @Deprecated
    public static final int AllowModifyContents = 8;

    @Deprecated
    public static final int AllowPrinting = 2052;

    @Deprecated
    public static final int AllowScreenReaders = 512;
    public static final int CenterWindow = 65536;
    public static final PdfName DID_PRINT;
    public static final int DO_NOT_ENCRYPT_METADATA = 8;
    public static final int DirectionL2R = 4194304;
    public static final int DirectionR2L = 8388608;
    public static final int DisplayDocTitle = 131072;
    public static final int EMBEDDED_FILES_ONLY = 24;
    public static final int ENCRYPTION_AES_128 = 2;
    public static final int ENCRYPTION_AES_256 = 3;
    static final int ENCRYPTION_MASK = 7;
    public static final int FitWindow = 32768;
    public static final int GENERATION_MAX = 65535;
    public static final int HideMenubar = 8192;
    public static final int HideToolbar = 4096;
    public static final int HideWindowUI = 16384;
    public static final float NO_SPACE_CHAR_RATIO = 1.0E7f;
    public static final int NonFullScreenPageModeUseNone = 262144;
    public static final int NonFullScreenPageModeUseOC = 2097152;
    public static final int NonFullScreenPageModeUseOutlines = 524288;
    public static final int NonFullScreenPageModeUseThumbs = 1048576;
    public static final PdfName PAGE_CLOSE;
    public static final PdfName PAGE_OPEN;
    public static final int PDFX1A2001 = 1;
    public static final int PDFX32002 = 2;
    public static final int PDFXNONE = 0;
    public static final int PageLayoutOneColumn = 2;
    public static final int PageLayoutSinglePage = 1;
    public static final int PageLayoutTwoColumnLeft = 4;
    public static final int PageLayoutTwoColumnRight = 8;
    public static final int PageLayoutTwoPageLeft = 16;
    public static final int PageLayoutTwoPageRight = 32;
    public static final int PageModeFullScreen = 512;
    public static final int PageModeUseAttachments = 2048;
    public static final int PageModeUseNone = 64;
    public static final int PageModeUseOC = 1024;
    public static final int PageModeUseOutlines = 128;
    public static final int PageModeUseThumbs = 256;
    public static final int PrintScalingNone = 16777216;
    public static final int RUN_DIRECTION_DEFAULT = 0;
    public static final int RUN_DIRECTION_LTR = 2;
    public static final int RUN_DIRECTION_NO_BIDI = 1;
    public static final int RUN_DIRECTION_RTL = 3;
    public static final int SIGNATURE_APPEND_ONLY = 2;
    public static final int SIGNATURE_EXISTS = 1;
    public static final float SPACE_CHAR_RATIO_DEFAULT = 2.5f;
    public static final int STANDARD_ENCRYPTION_128 = 1;
    public static final int STANDARD_ENCRYPTION_40 = 0;

    @Deprecated
    public static final boolean STRENGTH128BITS = true;

    @Deprecated
    public static final boolean STRENGTH40BITS = false;
    public static final char VERSION_1_2 = '2';
    public static final char VERSION_1_3 = '3';
    public static final char VERSION_1_4 = '4';
    public static final char VERSION_1_5 = '5';
    public static final char VERSION_1_6 = '6';
    public static final char VERSION_1_7 = '7';
    public static final PdfName WILL_PRINT;
    public static final int markAll = 0;
    public static final int markInlineElementsOnly = 1;
    private static final List<PdfName> standardStructElems_1_4;
    private static final List<PdfName> standardStructElems_1_7;
    protected HashMap<PdfStream, PdfIndirectReference> JBIG2Globals;
    protected PdfArray OCGLocked;
    protected PdfArray OCGRadioGroup;
    protected PdfOCProperties OCProperties;
    protected PdfBody body;
    protected int colorNumber;
    protected ICC_Profile colorProfile;
    protected int compressionLevel;
    protected PdfEncryption crypto;
    protected int currentPageNumber;
    protected PdfReaderInstance currentPdfReaderInstance;
    protected PdfDictionary defaultColorspace;
    protected PdfContentByte directContent;
    protected PdfContentByte directContentUnder;
    protected HashMap<ICachedColorSpace, ColorDetails> documentColors;
    protected HashMap<PdfDictionary, PdfObject[]> documentExtGState;
    protected LinkedHashMap<BaseFont, FontDetails> documentFonts;
    protected LinkedHashSet<PdfOCG> documentOCG;
    protected ArrayList<PdfOCG> documentOCGorder;
    protected HashMap<PdfPatternPainter, PdfName> documentPatterns;
    protected HashMap<Object, PdfObject[]> documentProperties;
    protected HashSet<PdfShadingPattern> documentShadingPatterns;
    protected HashSet<PdfShading> documentShadings;
    protected HashMap<ColorDetails, ColorDetails> documentSpotPatterns;
    protected PdfDictionary extraCatalog;
    protected int fontNumber;
    protected HashMap<PdfIndirectReference, Object[]> formXObjects;
    protected int formXObjectsCounter;
    protected boolean fullCompression;
    protected PdfDictionary group;
    protected PdfDictionary imageDictionary;
    private final HashMap<Long, PdfName> images;
    protected List<HashMap<String, Object>> newBookmarks;
    protected byte[] originalFileID;
    protected PdfDictionary pageDictEntries;
    private PdfPageEvent pageEvent;
    protected ArrayList<PdfIndirectReference> pageReferences;
    protected ColorDetails patternColorspaceCMYK;
    protected ColorDetails patternColorspaceGRAY;
    protected ColorDetails patternColorspaceRGB;
    protected int patternNumber;
    protected PdfDocument pdf;
    protected PdfIsoConformance pdfIsoConformance;
    protected PdfVersionImp pdf_version;
    protected long prevxref;
    protected HashMap<PdfReader, PdfReaderInstance> readerInstances;
    private boolean rgbTransparencyBlending;
    protected PdfPages root;
    protected int runDirection;
    private float spaceCharRatio;
    protected PdfStructureTreeRoot structureTreeRoot;
    protected PdfName tabs;
    protected boolean tagged;
    protected int taggingMode;
    protected TtfUnicodeWriter ttfUnicodeWriter;
    private boolean userProperties;
    protected byte[] xmpMetadata;
    protected XmpWriter xmpWriter;
    protected static Counter COUNTER = CounterFactory.getCounter(PdfWriter.class);
    public static final PdfName PDF_VERSION_1_2 = new PdfName("1.2");
    public static final PdfName PDF_VERSION_1_3 = new PdfName("1.3");
    public static final PdfName PDF_VERSION_1_4 = new PdfName("1.4");
    public static final PdfName PDF_VERSION_1_5 = new PdfName("1.5");
    public static final PdfName PDF_VERSION_1_6 = new PdfName("1.6");
    public static final PdfName PDF_VERSION_1_7 = new PdfName("1.7");
    public static final PdfName DOCUMENT_CLOSE = PdfName.WC;
    public static final PdfName WILL_SAVE = PdfName.WS;
    public static final PdfName DID_SAVE = PdfName.DS;

    public static class PdfBody {
        private static final int OBJSINSTREAM = 200;
        protected int currentObjNum;
        protected ByteBuffer index;
        protected int numObj = 0;
        protected long position;
        protected int refnum;
        protected ByteBuffer streamObjects;
        protected final PdfWriter writer;
        protected final TreeSet<PdfCrossReference> xrefs;

        public static class PdfCrossReference implements Comparable<PdfCrossReference> {
            private final int generation;
            private final long offset;
            private final int refnum;
            private final int type;

            public PdfCrossReference(int i, long j, int i2) {
                this.type = 0;
                this.offset = j;
                this.refnum = i;
                this.generation = i2;
            }

            public boolean equals(Object obj) {
                return (obj instanceof PdfCrossReference) && this.refnum == ((PdfCrossReference) obj).refnum;
            }

            public int getRefnum() {
                return this.refnum;
            }

            public int hashCode() {
                return this.refnum;
            }

            public void toPdf(OutputStream outputStream) throws IOException {
                StringBuffer stringBuffer = new StringBuffer("0000000000");
                stringBuffer.append(this.offset);
                stringBuffer.delete(0, stringBuffer.length() - 10);
                StringBuffer stringBuffer2 = new StringBuffer("00000");
                stringBuffer2.append(this.generation);
                stringBuffer2.delete(0, stringBuffer2.length() - 5);
                stringBuffer.append(' ');
                stringBuffer.append(stringBuffer2);
                stringBuffer.append(this.generation == 65535 ? " f \n" : " n \n");
                outputStream.write(DocWriter.getISOBytes(stringBuffer.toString()));
            }

            @Override // java.lang.Comparable
            public int compareTo(PdfCrossReference pdfCrossReference) {
                int i = this.refnum;
                int i2 = pdfCrossReference.refnum;
                if (i < i2) {
                    return -1;
                }
                return i == i2 ? 0 : 1;
            }

            public PdfCrossReference(int i, long j) {
                this.type = 1;
                this.offset = j;
                this.refnum = i;
                this.generation = 0;
            }

            public void toPdf(int i, OutputStream outputStream) throws IOException {
                outputStream.write((byte) this.type);
                while (true) {
                    i--;
                    if (i >= 0) {
                        outputStream.write((byte) ((this.offset >>> (i * 8)) & 255));
                    } else {
                        outputStream.write((byte) ((this.generation >>> 8) & 255));
                        outputStream.write((byte) (this.generation & 255));
                        return;
                    }
                }
            }

            public PdfCrossReference(int i, int i2, long j, int i3) {
                this.type = i;
                this.offset = j;
                this.refnum = i2;
                this.generation = i3;
            }
        }

        public PdfBody(PdfWriter pdfWriter) {
            TreeSet<PdfCrossReference> treeSet = new TreeSet<>();
            this.xrefs = treeSet;
            treeSet.add(new PdfCrossReference(0, 0L, 65535));
            this.position = pdfWriter.getOs().getCounter();
            this.refnum = 1;
            this.writer = pdfWriter;
        }

        public PdfIndirectObject add(PdfObject pdfObject) {
            return add(pdfObject, getIndirectReferenceNumber());
        }

        public PdfCrossReference addToObjStm(PdfObject pdfObject, int i) throws IOException {
            if (this.numObj >= 200) {
                flushObjStm();
            }
            if (this.index == null) {
                this.index = new ByteBuffer();
                this.streamObjects = new ByteBuffer();
                this.currentObjNum = getIndirectReferenceNumber();
                this.numObj = 0;
            }
            int size = this.streamObjects.size();
            int i2 = this.numObj;
            this.numObj = i2 + 1;
            PdfWriter pdfWriter = this.writer;
            PdfEncryption pdfEncryption = pdfWriter.crypto;
            pdfWriter.crypto = null;
            pdfObject.toPdf(pdfWriter, this.streamObjects);
            this.writer.crypto = pdfEncryption;
            this.streamObjects.append(' ');
            this.index.append(i).append(' ').append(size).append(' ');
            return new PdfCrossReference(2, i, this.currentObjNum, i2);
        }

        public void flushObjStm() {
            if (this.numObj == 0) {
                return;
            }
            int size = this.index.size();
            this.index.append(this.streamObjects);
            PdfStream pdfStream = new PdfStream(this.index.toByteArray());
            pdfStream.flateCompress(this.writer.getCompressionLevel());
            pdfStream.put(PdfName.TYPE, PdfName.OBJSTM);
            pdfStream.put(PdfName.N, new PdfNumber(this.numObj));
            pdfStream.put(PdfName.FIRST, new PdfNumber(size));
            add(pdfStream, this.currentObjNum);
            this.index = null;
            this.streamObjects = null;
            this.numObj = 0;
        }

        public int getIndirectReferenceNumber() {
            int i = this.refnum;
            this.refnum = i + 1;
            this.xrefs.add(new PdfCrossReference(i, 0L, 65535));
            return i;
        }

        public PdfIndirectReference getPdfIndirectReference() {
            return new PdfIndirectReference(0, getIndirectReferenceNumber());
        }

        public long offset() {
            return this.position;
        }

        public void setRefnum(int i) {
            this.refnum = i;
        }

        public int size() {
            return Math.max(this.xrefs.last().getRefnum() + 1, this.refnum);
        }

        public void write(PdfIndirectObject pdfIndirectObject, int i) {
            PdfCrossReference pdfCrossReference = new PdfCrossReference(i, this.position);
            if (!this.xrefs.add(pdfCrossReference)) {
                this.xrefs.remove(pdfCrossReference);
                this.xrefs.add(pdfCrossReference);
            }
            pdfIndirectObject.writeTo(this.writer.getOs());
            this.position = this.writer.getOs().getCounter();
        }

        public void writeCrossReferenceTable(OutputStream outputStream, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, long j) throws IOException {
            int indirectReferenceNumber;
            int i;
            if (this.writer.isFullCompression()) {
                flushObjStm();
                indirectReferenceNumber = getIndirectReferenceNumber();
                this.xrefs.add(new PdfCrossReference(indirectReferenceNumber, this.position));
            } else {
                indirectReferenceNumber = 0;
            }
            int refnum = this.xrefs.first().getRefnum();
            ArrayList arrayList = new ArrayList();
            Iterator<PdfCrossReference> it = this.xrefs.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PdfCrossReference next = it.next();
                if (refnum + i2 == next.getRefnum()) {
                    i2++;
                } else {
                    arrayList.add(Integer.valueOf(refnum));
                    arrayList.add(Integer.valueOf(i2));
                    refnum = next.getRefnum();
                    i2 = 1;
                }
            }
            arrayList.add(Integer.valueOf(refnum));
            arrayList.add(Integer.valueOf(i2));
            if (!this.writer.isFullCompression()) {
                outputStream.write(DocWriter.getISOBytes("xref\n"));
                Iterator<PdfCrossReference> it2 = this.xrefs.iterator();
                for (int i3 = 0; i3 < arrayList.size(); i3 += 2) {
                    int iIntValue = ((Integer) arrayList.get(i3)).intValue();
                    int iIntValue2 = ((Integer) arrayList.get(i3 + 1)).intValue();
                    outputStream.write(DocWriter.getISOBytes(String.valueOf(iIntValue)));
                    outputStream.write(DocWriter.getISOBytes(" "));
                    outputStream.write(DocWriter.getISOBytes(String.valueOf(iIntValue2)));
                    outputStream.write(10);
                    while (true) {
                        int i4 = iIntValue2 - 1;
                        if (iIntValue2 > 0) {
                            it2.next().toPdf(outputStream);
                            iIntValue2 = i4;
                        }
                    }
                }
                return;
            }
            int i5 = 5;
            long j2 = 1095216660480L;
            for (i = 1; i5 > i && (this.position & j2) == 0; i = 1) {
                j2 >>>= 8;
                i5--;
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            Iterator<PdfCrossReference> it3 = this.xrefs.iterator();
            while (it3.hasNext()) {
                it3.next().toPdf(i5, byteBuffer);
            }
            PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
            pdfStream.flateCompress(this.writer.getCompressionLevel());
            pdfStream.put(PdfName.SIZE, new PdfNumber(size()));
            pdfStream.put(PdfName.ROOT, pdfIndirectReference);
            if (pdfIndirectReference2 != null) {
                pdfStream.put(PdfName.INFO, pdfIndirectReference2);
            }
            if (pdfIndirectReference3 != null) {
                pdfStream.put(PdfName.ENCRYPT, pdfIndirectReference3);
            }
            if (pdfObject != null) {
                pdfStream.put(PdfName.ID, pdfObject);
            }
            pdfStream.put(PdfName.W, new PdfArray(new int[]{1, i5, 2}));
            pdfStream.put(PdfName.TYPE, PdfName.XREF);
            PdfArray pdfArray = new PdfArray();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                pdfArray.add(new PdfNumber(((Integer) arrayList.get(i6)).intValue()));
            }
            pdfStream.put(PdfName.INDEX, pdfArray);
            if (j > 0) {
                pdfStream.put(PdfName.PREV, new PdfNumber(j));
            }
            PdfWriter pdfWriter = this.writer;
            PdfEncryption pdfEncryption = pdfWriter.crypto;
            pdfWriter.crypto = null;
            new PdfIndirectObject(indirectReferenceNumber, pdfStream, this.writer).writeTo(this.writer.getOs());
            this.writer.crypto = pdfEncryption;
        }

        public PdfIndirectObject add(PdfObject pdfObject, boolean z) {
            return add(pdfObject, getIndirectReferenceNumber(), 0, z);
        }

        public PdfIndirectObject add(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) {
            return add(pdfObject, pdfIndirectReference, true);
        }

        public PdfIndirectObject add(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) {
            return add(pdfObject, pdfIndirectReference.getNumber(), pdfIndirectReference.getGeneration(), z);
        }

        public PdfIndirectObject add(PdfObject pdfObject, int i) {
            return add(pdfObject, i, 0, true);
        }

        public PdfIndirectObject add(PdfObject pdfObject, int i, int i2, boolean z) throws IOException {
            if (z && pdfObject.canBeInObjStm() && this.writer.isFullCompression()) {
                PdfCrossReference pdfCrossReferenceAddToObjStm = addToObjStm(pdfObject, i);
                PdfIndirectObject pdfIndirectObject = new PdfIndirectObject(i, pdfObject, this.writer);
                if (!this.xrefs.add(pdfCrossReferenceAddToObjStm)) {
                    this.xrefs.remove(pdfCrossReferenceAddToObjStm);
                    this.xrefs.add(pdfCrossReferenceAddToObjStm);
                }
                return pdfIndirectObject;
            }
            if (this.writer.isFullCompression()) {
                PdfIndirectObject pdfIndirectObject2 = new PdfIndirectObject(i, pdfObject, this.writer);
                write(pdfIndirectObject2, i);
                return pdfIndirectObject2;
            }
            PdfIndirectObject pdfIndirectObject3 = new PdfIndirectObject(i, i2, pdfObject, this.writer);
            write(pdfIndirectObject3, i, i2);
            return pdfIndirectObject3;
        }

        public void write(PdfIndirectObject pdfIndirectObject, int i, int i2) {
            PdfCrossReference pdfCrossReference = new PdfCrossReference(i, this.position, i2);
            if (!this.xrefs.add(pdfCrossReference)) {
                this.xrefs.remove(pdfCrossReference);
                this.xrefs.add(pdfCrossReference);
            }
            pdfIndirectObject.writeTo(this.writer.getOs());
            this.position = this.writer.getOs().getCounter();
        }
    }

    public static class PdfTrailer extends PdfDictionary {
        long offset;

        public PdfTrailer(int i, long j, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, long j2) {
            this.offset = j;
            put(PdfName.SIZE, new PdfNumber(i));
            put(PdfName.ROOT, pdfIndirectReference);
            if (pdfIndirectReference2 != null) {
                put(PdfName.INFO, pdfIndirectReference2);
            }
            if (pdfIndirectReference3 != null) {
                put(PdfName.ENCRYPT, pdfIndirectReference3);
            }
            if (pdfObject != null) {
                put(PdfName.ID, pdfObject);
            }
            if (j2 > 0) {
                put(PdfName.PREV, new PdfNumber(j2));
            }
        }

        @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
        public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
            PdfWriter.checkPdfIsoConformance(pdfWriter, 8, this);
            outputStream.write(DocWriter.getISOBytes("trailer\n"));
            super.toPdf(null, outputStream);
            outputStream.write(10);
            PdfWriter.writeKeyInfo(outputStream);
            outputStream.write(DocWriter.getISOBytes("startxref\n"));
            outputStream.write(DocWriter.getISOBytes(String.valueOf(this.offset)));
            outputStream.write(DocWriter.getISOBytes("\n%%EOF\n"));
        }
    }

    static {
        PdfName pdfName = PdfName.WP;
        WILL_PRINT = pdfName;
        DID_PRINT = PdfName.DP;
        PAGE_OPEN = PdfName.O;
        PAGE_CLOSE = PdfName.C;
        PdfName pdfName2 = PdfName.DOCUMENT;
        PdfName pdfName3 = PdfName.PART;
        PdfName pdfName4 = PdfName.ART;
        PdfName pdfName5 = PdfName.SECT;
        PdfName pdfName6 = PdfName.DIV;
        PdfName pdfName7 = PdfName.BLOCKQUOTE;
        PdfName pdfName8 = PdfName.CAPTION;
        PdfName pdfName9 = PdfName.TOC;
        PdfName pdfName10 = PdfName.TOCI;
        PdfName pdfName11 = PdfName.INDEX;
        PdfName pdfName12 = PdfName.NONSTRUCT;
        PdfName pdfName13 = PdfName.PRIVATE;
        PdfName pdfName14 = PdfName.P;
        PdfName pdfName15 = PdfName.H;
        PdfName pdfName16 = PdfName.H1;
        PdfName pdfName17 = PdfName.H2;
        PdfName pdfName18 = PdfName.H3;
        PdfName pdfName19 = PdfName.H4;
        PdfName pdfName20 = PdfName.H5;
        PdfName pdfName21 = PdfName.H6;
        PdfName pdfName22 = PdfName.L;
        PdfName pdfName23 = PdfName.LBL;
        PdfName pdfName24 = PdfName.LI;
        PdfName pdfName25 = PdfName.LBODY;
        PdfName pdfName26 = PdfName.TABLE;
        PdfName pdfName27 = PdfName.TR;
        PdfName pdfName28 = PdfName.TH;
        PdfName pdfName29 = PdfName.TD;
        PdfName pdfName30 = PdfName.SPAN;
        PdfName pdfName31 = PdfName.QUOTE;
        PdfName pdfName32 = PdfName.NOTE;
        PdfName pdfName33 = PdfName.REFERENCE;
        PdfName pdfName34 = PdfName.BIBENTRY;
        PdfName pdfName35 = PdfName.CODE;
        PdfName pdfName36 = PdfName.LINK;
        PdfName pdfName37 = PdfName.FIGURE;
        PdfName pdfName38 = PdfName.FORMULA;
        PdfName pdfName39 = PdfName.FORM;
        standardStructElems_1_4 = Arrays.asList(pdfName2, pdfName3, pdfName4, pdfName5, pdfName6, pdfName7, pdfName8, pdfName9, pdfName10, pdfName11, pdfName12, pdfName13, pdfName14, pdfName15, pdfName16, pdfName17, pdfName18, pdfName19, pdfName20, pdfName21, pdfName22, pdfName23, pdfName24, pdfName25, pdfName26, pdfName27, pdfName28, pdfName29, pdfName30, pdfName31, pdfName32, pdfName33, pdfName34, pdfName35, pdfName36, pdfName37, pdfName38, pdfName39);
        standardStructElems_1_7 = Arrays.asList(pdfName2, pdfName3, pdfName4, pdfName5, pdfName6, pdfName7, pdfName8, pdfName9, pdfName10, pdfName11, pdfName12, pdfName13, pdfName14, pdfName15, pdfName16, pdfName17, pdfName18, pdfName19, pdfName20, pdfName21, pdfName22, pdfName23, pdfName24, pdfName25, pdfName26, pdfName27, pdfName28, pdfName29, PdfName.THEAD, PdfName.TBODY, PdfName.TFOOT, pdfName30, pdfName31, pdfName32, pdfName33, pdfName34, pdfName35, pdfName36, PdfName.ANNOT, PdfName.RUBY, PdfName.RB, PdfName.RT, PdfName.RP, PdfName.WARICHU, PdfName.WT, pdfName, pdfName37, pdfName38, pdfName39);
    }

    public PdfWriter() {
        this.root = new PdfPages(this);
        this.pageReferences = new ArrayList<>();
        this.currentPageNumber = 1;
        this.tabs = null;
        this.pageDictEntries = new PdfDictionary();
        this.prevxref = 0L;
        this.originalFileID = null;
        this.pdf_version = new PdfVersionImp();
        this.xmpMetadata = null;
        this.xmpWriter = null;
        this.pdfIsoConformance = initPdfIsoConformance();
        this.fullCompression = false;
        this.compressionLevel = -1;
        this.documentFonts = new LinkedHashMap<>();
        this.fontNumber = 1;
        this.formXObjects = new HashMap<>();
        this.formXObjectsCounter = 1;
        this.readerInstances = new HashMap<>();
        this.documentColors = new HashMap<>();
        this.colorNumber = 1;
        this.documentPatterns = new HashMap<>();
        this.patternNumber = 1;
        this.documentShadingPatterns = new HashSet<>();
        this.documentShadings = new HashSet<>();
        this.documentExtGState = new HashMap<>();
        this.documentProperties = new HashMap<>();
        this.tagged = false;
        this.taggingMode = 1;
        this.documentOCG = new LinkedHashSet<>();
        this.documentOCGorder = new ArrayList<>();
        this.OCGRadioGroup = new PdfArray();
        this.OCGLocked = new PdfArray();
        this.spaceCharRatio = 2.5f;
        this.runDirection = 1;
        this.defaultColorspace = new PdfDictionary();
        this.documentSpotPatterns = new HashMap<>();
        this.imageDictionary = new PdfDictionary();
        this.images = new HashMap<>();
        this.JBIG2Globals = new HashMap<>();
        this.ttfUnicodeWriter = null;
    }

    private void addASEvent(PdfName pdfName, PdfName pdfName2) {
        PdfArray pdfArray = new PdfArray();
        Iterator<PdfOCG> it = this.documentOCG.iterator();
        while (it.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it.next();
            PdfDictionary asDict = pdfLayer.getAsDict(PdfName.USAGE);
            if (asDict != null && asDict.get(pdfName2) != null) {
                pdfArray.add(pdfLayer.getRef());
            }
        }
        if (pdfArray.size() == 0) {
            return;
        }
        PdfDictionary asDict2 = this.OCProperties.getAsDict(PdfName.D);
        PdfName pdfName3 = PdfName.AS;
        PdfArray asArray = asDict2.getAsArray(pdfName3);
        if (asArray == null) {
            asArray = new PdfArray();
            asDict2.put(pdfName3, asArray);
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.EVENT, pdfName);
        pdfDictionary.put(PdfName.CATEGORY, new PdfArray(pdfName2));
        pdfDictionary.put(PdfName.OCGS, pdfArray);
        asArray.add(pdfDictionary);
    }

    public static void checkPdfIsoConformance(PdfWriter pdfWriter, int i, Object obj) {
        if (pdfWriter != null) {
            pdfWriter.checkPdfIsoConformance(i, obj);
        }
    }

    private void completeExtraCatalog(PdfDictionary pdfDictionary) {
        if (isPdfX()) {
            PdfName pdfName = PdfName.OUTPUTINTENTS;
            if (pdfDictionary.get(pdfName) == null) {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.OUTPUTINTENT);
                pdfDictionary2.put(PdfName.OUTPUTCONDITION, new PdfString("SWOP CGATS TR 001-1995"));
                pdfDictionary2.put(PdfName.OUTPUTCONDITIONIDENTIFIER, new PdfString("CGATS TR 001"));
                pdfDictionary2.put(PdfName.REGISTRYNAME, new PdfString("http://www.color.org"));
                pdfDictionary2.put(PdfName.INFO, new PdfString(""));
                pdfDictionary2.put(PdfName.S, PdfName.GTS_PDFX);
                pdfDictionary.put(pdfName, new PdfArray(pdfDictionary2));
            }
        }
    }

    private void completeInfoDictionary(PdfDictionary pdfDictionary) {
        if (isPdfX()) {
            PdfName pdfName = PdfName.GTS_PDFXVERSION;
            if (pdfDictionary.get(pdfName) == null) {
                if (((PdfXConformanceImp) this.pdfIsoConformance).isPdfX1A2001()) {
                    pdfDictionary.put(pdfName, new PdfString("PDF/X-1:2001"));
                    pdfDictionary.put(new PdfName("GTS_PDFXConformance"), new PdfString("PDF/X-1a:2001"));
                } else if (((PdfXConformanceImp) this.pdfIsoConformance).isPdfX32002()) {
                    pdfDictionary.put(pdfName, new PdfString("PDF/X-3:2002"));
                }
            }
            PdfName pdfName2 = PdfName.TITLE;
            if (pdfDictionary.get(pdfName2) == null) {
                pdfDictionary.put(pdfName2, new PdfString("Pdf document"));
            }
            PdfName pdfName3 = PdfName.CREATOR;
            if (pdfDictionary.get(pdfName3) == null) {
                pdfDictionary.put(pdfName3, new PdfString("Unknown"));
            }
            PdfName pdfName4 = PdfName.TRAPPED;
            if (pdfDictionary.get(pdfName4) == null) {
                pdfDictionary.put(pdfName4, new PdfName(XMPConst.FALSESTR));
            }
        }
    }

    public static PdfWriter getInstance(Document document, OutputStream outputStream) {
        PdfDocument pdfDocument = new PdfDocument();
        document.addDocListener(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.addWriter(pdfWriter);
        return pdfWriter;
    }

    public static String getNameString(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName));
        if (pdfObject == null || !pdfObject.isString()) {
            return null;
        }
        return ((PdfString) pdfObject).toUnicodeString();
    }

    private static void getOCGOrder(PdfArray pdfArray, PdfLayer pdfLayer) {
        if (pdfLayer.isOnPanel()) {
            if (pdfLayer.getTitle() == null) {
                pdfArray.add(pdfLayer.getRef());
            }
            ArrayList<PdfLayer> children = pdfLayer.getChildren();
            if (children == null) {
                return;
            }
            PdfArray pdfArray2 = new PdfArray();
            if (pdfLayer.getTitle() != null) {
                pdfArray2.add(new PdfString(pdfLayer.getTitle(), PdfObject.TEXT_UNICODE));
            }
            for (int i = 0; i < children.size(); i++) {
                getOCGOrder(pdfArray2, children.get(i));
            }
            if (pdfArray2.size() > 0) {
                pdfArray.add(pdfArray2);
            }
        }
    }

    public static void writeKeyInfo(OutputStream outputStream) throws IOException {
        Version version = Version.getInstance();
        String key = version.getKey();
        if (key == null) {
            key = "iText";
        }
        outputStream.write(DocWriter.getISOBytes(String.format("%%%s-%s\n", key, version.getRelease())));
    }

    public PdfIndirectReference add(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        if (!this.open) {
            throw new PdfException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
        }
        try {
            pdfPage.add(addToBody(pdfContents).getIndirectReference());
            PdfObject pdfObject = this.group;
            if (pdfObject != null) {
                pdfPage.put(PdfName.GROUP, pdfObject);
                this.group = null;
            } else if (this.rgbTransparencyBlending) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                PdfName pdfName = PdfName.TYPE;
                PdfName pdfName2 = PdfName.GROUP;
                pdfDictionary.put(pdfName, pdfName2);
                pdfDictionary.put(PdfName.S, PdfName.TRANSPARENCY);
                pdfDictionary.put(PdfName.CS, PdfName.DEVICERGB);
                pdfPage.put(pdfName2, pdfDictionary);
            }
            this.root.addPage(pdfPage);
            this.currentPageNumber++;
            return null;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.pdf.addAnnotation(pdfAnnotation);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.pdf.addCalculationOrder(pdfFormField);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void addDeveloperExtension(PdfDeveloperExtension pdfDeveloperExtension) {
        this.pdf_version.addDeveloperExtension(pdfDeveloperExtension);
    }

    public PdfName addDirectImageSimple(Image image) {
        return addDirectImageSimple(image, null);
    }

    public PdfName addDirectTemplateSimple(PdfTemplate pdfTemplate, PdfName pdfName) {
        PdfIndirectReference indirectReference = pdfTemplate.getIndirectReference();
        Object[] objArr = this.formXObjects.get(indirectReference);
        try {
            if (objArr != null) {
                return (PdfName) objArr[0];
            }
            if (pdfName == null) {
                pdfName = new PdfName("Xf" + this.formXObjectsCounter);
                this.formXObjectsCounter = this.formXObjectsCounter + 1;
            }
            if (pdfTemplate.getType() == 2) {
                PdfImportedPage pdfImportedPage = (PdfImportedPage) pdfTemplate;
                PdfReader reader = pdfImportedPage.getPdfReaderInstance().getReader();
                if (!this.readerInstances.containsKey(reader)) {
                    this.readerInstances.put(reader, pdfImportedPage.getPdfReaderInstance());
                }
                pdfTemplate = null;
            }
            this.formXObjects.put(indirectReference, new Object[]{pdfName, pdfTemplate});
            return pdfName;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void addFileAttachment(String str, byte[] bArr, String str2, String str3) {
        addFileAttachment(str, PdfFileSpecification.fileEmbedded(this, str2, str3, bArr));
    }

    public void addJavaScript(PdfAction pdfAction) {
        this.pdf.addJavaScript(pdfAction);
    }

    public void addLocalDestinations(TreeMap<String, PdfDocument.Destination> treeMap) {
        for (Map.Entry<String, PdfDocument.Destination> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            PdfDocument.Destination value = entry.getValue();
            PdfDestination pdfDestination = value.destination;
            if (value.reference == null) {
                value.reference = getPdfIndirectReference();
            }
            if (pdfDestination == null) {
                addToBody(new PdfString("invalid_" + key), value.reference);
            } else {
                addToBody(pdfDestination, value.reference);
            }
        }
    }

    public void addNamedDestination(String str, int i, PdfDestination pdfDestination) {
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.addPage(getPageReference(i));
        this.pdf.localDestination(str, pdfDestination2);
    }

    public void addNamedDestinations(Map<String, String> map, int i) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            int i2 = Integer.parseInt(value.substring(0, value.indexOf(" ")));
            addNamedDestination(entry.getKey(), i2 + i, new PdfDestination(value.substring(value.indexOf(" ") + 1)));
        }
    }

    public void addOCGRadioGroup(ArrayList<PdfLayer> arrayList) {
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < arrayList.size(); i++) {
            PdfLayer pdfLayer = arrayList.get(i);
            if (pdfLayer.getTitle() == null) {
                pdfArray.add(pdfLayer.getRef());
            }
        }
        if (pdfArray.size() == 0) {
            return;
        }
        this.OCGRadioGroup.add(pdfArray);
    }

    public void addPageDictEntry(PdfName pdfName, PdfObject pdfObject) {
        this.pageDictEntries.put(pdfName, pdfObject);
    }

    public void addSharedObjectsToBody() {
        Iterator<FontDetails> it = this.documentFonts.values().iterator();
        while (it.hasNext()) {
            it.next().writeFont(this);
        }
        addXFormsToBody();
        for (PdfReaderInstance pdfReaderInstance : this.readerInstances.values()) {
            this.currentPdfReaderInstance = pdfReaderInstance;
            pdfReaderInstance.writeAllPages();
        }
        this.currentPdfReaderInstance = null;
        for (ColorDetails colorDetails : this.documentColors.values()) {
            addToBody(colorDetails.getPdfObject(this), colorDetails.getIndirectReference());
        }
        for (PdfPatternPainter pdfPatternPainter : this.documentPatterns.keySet()) {
            addToBody(pdfPatternPainter.getPattern(this.compressionLevel), pdfPatternPainter.getIndirectReference());
        }
        Iterator<PdfShadingPattern> it2 = this.documentShadingPatterns.iterator();
        while (it2.hasNext()) {
            it2.next().addToBody();
        }
        Iterator<PdfShading> it3 = this.documentShadings.iterator();
        while (it3.hasNext()) {
            it3.next().addToBody();
        }
        for (Map.Entry<PdfDictionary, PdfObject[]> entry : this.documentExtGState.entrySet()) {
            addToBody(entry.getKey(), (PdfIndirectReference) entry.getValue()[1]);
        }
        for (Map.Entry<Object, PdfObject[]> entry2 : this.documentProperties.entrySet()) {
            Object key = entry2.getKey();
            PdfObject[] value = entry2.getValue();
            if (key instanceof PdfLayerMembership) {
                PdfLayerMembership pdfLayerMembership = (PdfLayerMembership) key;
                addToBody(pdfLayerMembership.getPdfObject(), pdfLayerMembership.getRef());
            } else if ((key instanceof PdfDictionary) && !(key instanceof PdfLayer)) {
                addToBody((PdfDictionary) key, (PdfIndirectReference) value[1]);
            }
        }
    }

    public FontDetails addSimple(BaseFont baseFont) {
        FontDetails fontDetails = this.documentFonts.get(baseFont);
        if (fontDetails == null) {
            checkPdfIsoConformance(this, 4, baseFont);
            if (baseFont.getFontType() == 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("F");
                int i = this.fontNumber;
                this.fontNumber = i + 1;
                sb.append(i);
                fontDetails = new FontDetails(new PdfName(sb.toString()), ((DocumentFont) baseFont).getIndirectReference(), baseFont);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("F");
                int i2 = this.fontNumber;
                this.fontNumber = i2 + 1;
                sb2.append(i2);
                fontDetails = new FontDetails(new PdfName(sb2.toString()), this.body.getPdfIndirectReference(), baseFont);
            }
            this.documentFonts.put(baseFont, fontDetails);
        }
        return fontDetails;
    }

    public PdfObject[] addSimpleExtGState(PdfDictionary pdfDictionary) {
        if (!this.documentExtGState.containsKey(pdfDictionary)) {
            this.documentExtGState.put(pdfDictionary, new PdfObject[]{new PdfName("GS" + (this.documentExtGState.size() + 1)), getPdfIndirectReference()});
        }
        return this.documentExtGState.get(pdfDictionary);
    }

    public PdfName addSimplePattern(PdfPatternPainter pdfPatternPainter) {
        PdfName pdfName = this.documentPatterns.get(pdfPatternPainter);
        if (pdfName != null) {
            return pdfName;
        }
        try {
            PdfName pdfName2 = new PdfName("P" + this.patternNumber);
            this.patternNumber = this.patternNumber + 1;
            this.documentPatterns.put(pdfPatternPainter, pdfName2);
            return pdfName2;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public ColorDetails addSimplePatternColorspace(BaseColor baseColor) {
        int type = ExtendedColor.getType(baseColor);
        if (type == 4 || type == 5) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.tile.pattern.can.not.have.another.pattern.or.shading.as.color", new Object[0]));
        }
        try {
            if (type == 0) {
                if (this.patternColorspaceRGB == null) {
                    this.patternColorspaceRGB = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
                    PdfArray pdfArray = new PdfArray(PdfName.PATTERN);
                    pdfArray.add(PdfName.DEVICERGB);
                    addToBody(pdfArray, this.patternColorspaceRGB.getIndirectReference());
                }
                return this.patternColorspaceRGB;
            }
            if (type == 1) {
                if (this.patternColorspaceGRAY == null) {
                    this.patternColorspaceGRAY = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
                    PdfArray pdfArray2 = new PdfArray(PdfName.PATTERN);
                    pdfArray2.add(PdfName.DEVICEGRAY);
                    addToBody(pdfArray2, this.patternColorspaceGRAY.getIndirectReference());
                }
                return this.patternColorspaceGRAY;
            }
            if (type == 2) {
                if (this.patternColorspaceCMYK == null) {
                    this.patternColorspaceCMYK = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
                    PdfArray pdfArray3 = new PdfArray(PdfName.PATTERN);
                    pdfArray3.add(PdfName.DEVICECMYK);
                    addToBody(pdfArray3, this.patternColorspaceCMYK.getIndirectReference());
                }
                return this.patternColorspaceCMYK;
            }
            if (type != 3) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.color.type", new Object[0]));
            }
            ColorDetails colorDetailsAddSimple = addSimple(((SpotColor) baseColor).getPdfSpotColor());
            ColorDetails colorDetails = this.documentSpotPatterns.get(colorDetailsAddSimple);
            if (colorDetails != null) {
                return colorDetails;
            }
            ColorDetails colorDetails2 = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
            PdfArray pdfArray4 = new PdfArray(PdfName.PATTERN);
            pdfArray4.add(colorDetailsAddSimple.getIndirectReference());
            addToBody(pdfArray4, colorDetails2.getIndirectReference());
            this.documentSpotPatterns.put(colorDetailsAddSimple, colorDetails2);
            return colorDetails2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PdfObject[] addSimpleProperty(Object obj, PdfIndirectReference pdfIndirectReference) {
        if (!this.documentProperties.containsKey(obj)) {
            if (obj instanceof PdfOCG) {
                checkPdfIsoConformance(this, 7, obj);
            }
            this.documentProperties.put(obj, new PdfObject[]{new PdfName("Pr" + (this.documentProperties.size() + 1)), pdfIndirectReference});
        }
        return this.documentProperties.get(obj);
    }

    public void addSimpleShading(PdfShading pdfShading) {
        if (this.documentShadings.contains(pdfShading)) {
            return;
        }
        this.documentShadings.add(pdfShading);
        pdfShading.setName(this.documentShadings.size());
    }

    public void addSimpleShadingPattern(PdfShadingPattern pdfShadingPattern) {
        if (this.documentShadingPatterns.contains(pdfShadingPattern)) {
            return;
        }
        pdfShadingPattern.setName(this.patternNumber);
        this.patternNumber++;
        this.documentShadingPatterns.add(pdfShadingPattern);
        addSimpleShading(pdfShadingPattern.getShading());
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject) {
        PdfIndirectObject pdfIndirectObjectAdd = this.body.add(pdfObject);
        cacheObject(pdfIndirectObjectAdd);
        return pdfIndirectObjectAdd;
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.pdf.addViewerPreference(pdfName, pdfObject);
    }

    public void addXFormsToBody() {
        Iterator<Object[]> it = this.formXObjects.values().iterator();
        while (it.hasNext()) {
            PdfTemplate pdfTemplate = (PdfTemplate) it.next()[1];
            if (pdfTemplate == null || !(pdfTemplate.getIndirectReference() instanceof PRIndirectReference)) {
                if (pdfTemplate != null && pdfTemplate.getType() == 1) {
                    addToBody(pdfTemplate.getFormXObject(this.compressionLevel), pdfTemplate.getIndirectReference());
                }
            }
        }
    }

    public void buildStructTreeRootForTagged(PdfDictionary pdfDictionary) {
        if (this.tagged) {
            try {
                getStructureTreeRoot().buildTree();
                Iterator<AccessibleElementId> it = this.pdf.getStructElements().iterator();
                while (it.hasNext()) {
                    PdfStructureElement structElement = this.pdf.getStructElement(it.next(), false);
                    addToBody(structElement, structElement.getReference());
                }
                pdfDictionary.put(PdfName.STRUCTTREEROOT, this.structureTreeRoot.getReference());
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                PdfName pdfName = PdfName.MARKED;
                PdfBoolean pdfBoolean = PdfBoolean.PDFTRUE;
                pdfDictionary2.put(pdfName, pdfBoolean);
                if (this.userProperties) {
                    pdfDictionary2.put(PdfName.USERPROPERTIES, pdfBoolean);
                }
                pdfDictionary.put(PdfName.MARKINFO, pdfDictionary2);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public void cacheObject(PdfIndirectObject pdfIndirectObject) {
    }

    public void checkElementRole(IAccessibleElement iAccessibleElement, IAccessibleElement iAccessibleElement2) {
        if (iAccessibleElement2 != null && (iAccessibleElement2.getRole() == null || PdfName.ARTIFACT.equals(iAccessibleElement2.getRole()))) {
            iAccessibleElement.setRole(null);
            return;
        }
        if ((this.taggingMode & 1) != 0 && iAccessibleElement.isInline() && iAccessibleElement.getRole() == null) {
            if (iAccessibleElement2 == null || !iAccessibleElement2.isInline()) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("inline.elements.with.role.null.are.not.allowed", new Object[0]));
            }
        }
    }

    public void clearTextWrap() {
        this.pdf.clearTextWrap();
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
    @Override // com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void close() {
        PdfObject pdfObjectCreateInfoId;
        if (this.open) {
            boolean z = true;
            if (this.currentPageNumber - 1 != this.pageReferences.size()) {
                throw new RuntimeException("The page " + this.pageReferences.size() + " was requested but the document has only " + (this.currentPageNumber - 1) + " pages.");
            }
            this.pdf.close();
            try {
                try {
                    addSharedObjectsToBody();
                    for (PdfOCG pdfOCG : this.documentOCG) {
                        addToBody(pdfOCG.getPdfObject(), pdfOCG.getRef());
                    }
                    PdfDictionary catalog = getCatalog(this.root.writePageTree());
                    if (!this.documentOCG.isEmpty()) {
                        checkPdfIsoConformance(this, 7, this.OCProperties);
                    }
                    PdfIndirectReference indirectReference = null;
                    if (this.xmpMetadata == null && this.xmpWriter != null) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            this.xmpWriter.serialize(byteArrayOutputStream);
                            this.xmpWriter.close();
                            this.xmpMetadata = byteArrayOutputStream.toByteArray();
                        } catch (XMPException unused) {
                            this.xmpWriter = null;
                        } catch (IOException unused2) {
                            this.xmpWriter = null;
                        }
                    }
                    if (this.xmpMetadata != null) {
                        PdfStream pdfStream = new PdfStream(this.xmpMetadata);
                        PdfName pdfName = PdfName.TYPE;
                        PdfName pdfName2 = PdfName.METADATA;
                        pdfStream.put(pdfName, pdfName2);
                        pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
                        PdfEncryption pdfEncryption = this.crypto;
                        if (pdfEncryption != null && !pdfEncryption.isMetadataEncrypted()) {
                            PdfArray pdfArray = new PdfArray();
                            pdfArray.add(PdfName.CRYPT);
                            pdfStream.put(PdfName.FILTER, pdfArray);
                        }
                        catalog.put(pdfName2, this.body.add(pdfStream).getIndirectReference());
                    }
                    if (isPdfX()) {
                        completeInfoDictionary(getInfo());
                        completeExtraCatalog(getExtraCatalog());
                    }
                    PdfDictionary pdfDictionary = this.extraCatalog;
                    if (pdfDictionary != null) {
                        catalog.mergeDifferent(pdfDictionary);
                    }
                    writeOutlines(catalog, false);
                    PdfIndirectObject pdfIndirectObjectAddToBody = addToBody((PdfObject) catalog, false);
                    PdfIndirectObject pdfIndirectObjectAddToBody2 = addToBody((PdfObject) getInfo(), false);
                    this.body.flushObjStm();
                    byte[] bArrCreateDocumentId = this.originalFileID;
                    if (bArrCreateDocumentId == null) {
                        z = false;
                    }
                    PdfEncryption pdfEncryption2 = this.crypto;
                    if (pdfEncryption2 != null) {
                        indirectReference = addToBody((PdfObject) pdfEncryption2.getEncryptionDictionary(), false).getIndirectReference();
                        pdfObjectCreateInfoId = this.crypto.getFileID(z);
                    } else {
                        if (!z) {
                            bArrCreateDocumentId = PdfEncryption.createDocumentId();
                        }
                        pdfObjectCreateInfoId = PdfEncryption.createInfoId(bArrCreateDocumentId, z);
                    }
                    this.body.writeCrossReferenceTable(this.os, pdfIndirectObjectAddToBody.getIndirectReference(), pdfIndirectObjectAddToBody2.getIndirectReference(), indirectReference, pdfObjectCreateInfoId, this.prevxref);
                    if (this.fullCompression) {
                        writeKeyInfo(this.os);
                        this.os.write(DocWriter.getISOBytes("startxref\n"));
                        this.os.write(DocWriter.getISOBytes(String.valueOf(this.body.offset())));
                        this.os.write(DocWriter.getISOBytes("\n%%EOF\n"));
                    } else {
                        new PdfTrailer(this.body.size(), this.body.offset(), pdfIndirectObjectAddToBody.getIndirectReference(), pdfIndirectObjectAddToBody2.getIndirectReference(), indirectReference, pdfObjectCreateInfoId, this.prevxref).toPdf(this, this.os);
                    }
                    super.close();
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            } catch (Throwable th) {
                super.close();
                throw th;
            }
        }
        getCounter().written(this.os.getCounter());
    }

    public PdfAnnotation createAnnotation(Rectangle rectangle, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, rectangle);
        if (pdfName != null) {
            pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        }
        return pdfAnnotation;
    }

    public void createXmpMetadata() {
        try {
            this.xmpWriter = createXmpWriter((ByteArrayOutputStream) null, this.pdf.getInfo());
            if (isTagged()) {
                try {
                    this.xmpWriter.getXmpMeta().setPropertyInteger(XMPConst.NS_PDFUA_ID, PdfProperties.PART, 1, new PropertyOptions(1073741824));
                } catch (XMPException e) {
                    throw new ExceptionConverter(e);
                }
            }
            this.xmpMetadata = null;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public XmpWriter createXmpWriter(ByteArrayOutputStream byteArrayOutputStream, PdfDictionary pdfDictionary) {
        return new XmpWriter(byteArrayOutputStream, pdfDictionary);
    }

    public void eliminateFontSubset(PdfDictionary pdfDictionary) {
        for (FontDetails fontDetails : this.documentFonts.values()) {
            if (pdfDictionary.get(fontDetails.getFontName()) != null) {
                fontDetails.setSubset(false);
            }
        }
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
    public void fillOCProperties(boolean z) {
        if (this.OCProperties == null) {
            this.OCProperties = new PdfOCProperties();
        }
        if (z) {
            this.OCProperties.remove(PdfName.OCGS);
            this.OCProperties.remove(PdfName.D);
        }
        if (this.OCProperties.get(PdfName.OCGS) == null) {
            PdfArray pdfArray = new PdfArray();
            Iterator<PdfOCG> it = this.documentOCG.iterator();
            while (it.hasNext()) {
                pdfArray.add(((PdfLayer) it.next()).getRef());
            }
            this.OCProperties.put(PdfName.OCGS, pdfArray);
        }
        if (this.OCProperties.get(PdfName.D) != null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.documentOCGorder);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((PdfLayer) it2.next()).getParent() != null) {
                it2.remove();
            }
        }
        PdfArray pdfArray2 = new PdfArray();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            getOCGOrder(pdfArray2, (PdfLayer) it3.next());
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        this.OCProperties.put(PdfName.D, pdfDictionary);
        pdfDictionary.put(PdfName.ORDER, pdfArray2);
        if (arrayList.size() > 0 && (arrayList.get(0) instanceof PdfLayer)) {
            PdfLayer pdfLayer = (PdfLayer) arrayList.get(0);
            PdfName pdfName = PdfName.NAME;
            PdfString asString = pdfLayer.getAsString(pdfName);
            if (asString != null) {
                pdfDictionary.put(pdfName, asString);
            }
        }
        PdfArray pdfArray3 = new PdfArray();
        Iterator<PdfOCG> it4 = this.documentOCG.iterator();
        while (it4.hasNext()) {
            PdfLayer pdfLayer2 = (PdfLayer) it4.next();
            if (!pdfLayer2.isOn()) {
                pdfArray3.add(pdfLayer2.getRef());
            }
        }
        if (pdfArray3.size() > 0) {
            pdfDictionary.put(PdfName.OFF, pdfArray3);
        }
        if (this.OCGRadioGroup.size() > 0) {
            pdfDictionary.put(PdfName.RBGROUPS, this.OCGRadioGroup);
        }
        if (this.OCGLocked.size() > 0) {
            pdfDictionary.put(PdfName.LOCKED, this.OCGLocked);
        }
        PdfName pdfName2 = PdfName.VIEW;
        addASEvent(pdfName2, PdfName.ZOOM);
        addASEvent(pdfName2, pdfName2);
        PdfName pdfName3 = PdfName.PRINT;
        addASEvent(pdfName3, pdfName3);
        PdfName pdfName4 = PdfName.EXPORT;
        addASEvent(pdfName4, pdfName4);
        pdfDictionary.put(PdfName.LISTMODE, PdfName.VISIBLEPAGES);
    }

    public void flushAcroFields() {
    }

    public void flushTaggedObjects() {
    }

    public void freeReader(PdfReader pdfReader) {
        PdfReaderInstance pdfReaderInstance = this.readerInstances.get(pdfReader);
        this.currentPdfReaderInstance = pdfReaderInstance;
        if (pdfReaderInstance == null) {
            return;
        }
        pdfReaderInstance.writeAllPages();
        this.currentPdfReaderInstance = null;
        this.readerInstances.remove(pdfReader);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public PdfAcroForm getAcroForm() {
        return this.pdf.getAcroForm();
    }

    public Rectangle getBoxSize(String str) {
        return this.pdf.getBoxSize(str);
    }

    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
        buildStructTreeRootForTagged(catalog);
        if (!this.documentOCG.isEmpty()) {
            fillOCProperties(false);
            catalog.put(PdfName.OCPROPERTIES, this.OCProperties);
        }
        return catalog;
    }

    public ICC_Profile getColorProfile() {
        return this.colorProfile;
    }

    public PdfName getColorspaceName() {
        StringBuilder sb = new StringBuilder();
        sb.append("CS");
        int i = this.colorNumber;
        this.colorNumber = i + 1;
        sb.append(i);
        return new PdfName(sb.toString());
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public Counter getCounter() {
        return COUNTER;
    }

    public long getCurrentDocumentSize() {
        return this.body.offset() + ((long) (this.body.size() * 20)) + 72;
    }

    public PdfIndirectReference getCurrentPage() {
        return getPageReference(this.currentPageNumber);
    }

    public int getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public PdfDictionary getDefaultColorspace() {
        return this.defaultColorspace;
    }

    public PdfContentByte getDirectContent() {
        if (this.open) {
            return this.directContent;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
    }

    public PdfContentByte getDirectContentUnder() {
        if (this.open) {
            return this.directContentUnder;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
    }

    public PdfEncryption getEncryption() {
        return this.crypto;
    }

    public PdfDictionary getExtraCatalog() {
        if (this.extraCatalog == null) {
            this.extraCatalog = new PdfDictionary();
        }
        return this.extraCatalog;
    }

    public PdfDictionary getGroup() {
        return this.group;
    }

    public PdfIndirectReference getImageReference(PdfName pdfName) {
        return (PdfIndirectReference) this.imageDictionary.get(pdfName);
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        return getPdfReaderInstance(pdfReader).getImportedPage(i);
    }

    public int getIndirectReferenceNumber() {
        return this.body.getIndirectReferenceNumber();
    }

    public PdfDictionary getInfo() {
        return this.pdf.getInfo();
    }

    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
        if (pdfReaderInstance == null || pdfReaderInstance.getReader() != pdfReader) {
            this.currentPdfReaderInstance = getPdfReaderInstance(pdfReader);
        }
        return this.currentPdfReaderInstance.getNewObjectNumber(i, i2);
    }

    public PdfOCProperties getOCProperties() {
        fillOCProperties(true);
        return this.OCProperties;
    }

    public OutputStreamCounter getOs() {
        return this.os;
    }

    public int getPDFXConformance() {
        PdfIsoConformance pdfIsoConformance = this.pdfIsoConformance;
        if (pdfIsoConformance instanceof PdfXConformanceImp) {
            return ((PdfXConformance) pdfIsoConformance).getPDFXConformance();
        }
        return 0;
    }

    public PdfDictionary getPageDictEntries() {
        return this.pageDictEntries;
    }

    public PdfPageEvent getPageEvent() {
        return this.pageEvent;
    }

    public int getPageNumber() {
        return this.pdf.getPageNumber();
    }

    public PdfIndirectReference getPageReference(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.getComposedMessage("the.page.number.must.be.gt.eq.1", new Object[0]));
        }
        if (i2 < this.pageReferences.size()) {
            PdfIndirectReference pdfIndirectReference = this.pageReferences.get(i2);
            if (pdfIndirectReference != null) {
                return pdfIndirectReference;
            }
            PdfIndirectReference pdfIndirectReference2 = this.body.getPdfIndirectReference();
            this.pageReferences.set(i2, pdfIndirectReference2);
            return pdfIndirectReference2;
        }
        int size = i2 - this.pageReferences.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.pageReferences.add(null);
        }
        PdfIndirectReference pdfIndirectReference3 = this.body.getPdfIndirectReference();
        this.pageReferences.add(pdfIndirectReference3);
        return pdfIndirectReference3;
    }

    public Rectangle getPageSize() {
        return this.pdf.getPageSize();
    }

    public PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public PdfIndirectReference getPdfIndirectReference() {
        return this.body.getPdfIndirectReference();
    }

    public PdfReaderInstance getPdfReaderInstance(PdfReader pdfReader) {
        PdfReaderInstance pdfReaderInstance = this.readerInstances.get(pdfReader);
        if (pdfReaderInstance != null) {
            return pdfReaderInstance;
        }
        PdfReaderInstance pdfReaderInstance2 = pdfReader.getPdfReaderInstance(this);
        this.readerInstances.put(pdfReader, pdfReaderInstance2);
        return pdfReaderInstance2;
    }

    public PdfVersionImp getPdfVersion() {
        return this.pdf_version;
    }

    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        return this.currentPdfReaderInstance.getReaderFile();
    }

    public PdfIndirectReference getReferenceJBIG2Globals(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (PdfStream pdfStream : this.JBIG2Globals.keySet()) {
            if (Arrays.equals(bArr, pdfStream.getBytes())) {
                return this.JBIG2Globals.get(pdfStream);
            }
        }
        PdfStream pdfStream2 = new PdfStream(bArr);
        try {
            PdfIndirectObject pdfIndirectObjectAddToBody = addToBody(pdfStream2);
            this.JBIG2Globals.put(pdfStream2, pdfIndirectObjectAddToBody.getIndirectReference());
            return pdfIndirectObjectAddToBody.getIndirectReference();
        } catch (IOException unused) {
            return null;
        }
    }

    public PdfOutline getRootOutline() {
        return this.directContent.getRootOutline();
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfRunDirection
    public int getRunDirection() {
        return this.runDirection;
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public List<PdfName> getStandardStructElems() {
        return this.pdf_version.getVersion() < '7' ? standardStructElems_1_4 : standardStructElems_1_7;
    }

    public PdfStructureTreeRoot getStructureTreeRoot() {
        if (this.tagged && this.structureTreeRoot == null) {
            this.structureTreeRoot = new PdfStructureTreeRoot(this);
        }
        return this.structureTreeRoot;
    }

    public PdfName getTabs() {
        return this.tabs;
    }

    public TtfUnicodeWriter getTtfUnicodeWriter() {
        if (this.ttfUnicodeWriter == null) {
            this.ttfUnicodeWriter = new TtfUnicodeWriter(this);
        }
        return this.ttfUnicodeWriter;
    }

    public float getVerticalPosition(boolean z) {
        return this.pdf.getVerticalPosition(z);
    }

    public XmpWriter getXmpWriter() {
        return this.xmpWriter;
    }

    public PdfIsoConformance initPdfIsoConformance() {
        return new PdfXConformanceImp(this);
    }

    public boolean isFullCompression() {
        return this.fullCompression;
    }

    public boolean isPageEmpty() {
        return this.pdf.isPageEmpty();
    }

    public boolean isPdfIso() {
        return this.pdfIsoConformance.isPdfIso();
    }

    public boolean isPdfX() {
        PdfIsoConformance pdfIsoConformance = this.pdfIsoConformance;
        if (pdfIsoConformance instanceof PdfXConformanceImp) {
            return ((PdfXConformance) pdfIsoConformance).isPdfX();
        }
        return false;
    }

    public boolean isRgbTransparencyBlending() {
        return this.rgbTransparencyBlending;
    }

    public boolean isStrictImageSequence() {
        return this.pdf.isStrictImageSequence();
    }

    public boolean isTagged() {
        return this.tagged;
    }

    public boolean isUserProperties() {
        return this.userProperties;
    }

    public void lockLayer(PdfLayer pdfLayer) {
        this.OCGLocked.add(pdfLayer.getRef());
    }

    public boolean needToBeMarkedInContent(IAccessibleElement iAccessibleElement) {
        return (this.taggingMode & 1) == 0 || iAccessibleElement.isInline() || PdfName.ARTIFACT.equals(iAccessibleElement.getRole());
    }

    @Override // com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void open() {
        super.open();
        try {
            this.pdf_version.writeHeader(this.os);
            this.body = new PdfBody(this);
            if (isPdfX() && ((PdfXConformanceImp) this.pdfIsoConformance).isPdfX32002()) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.GAMMA, new PdfArray(new float[]{2.2f, 2.2f, 2.2f}));
                pdfDictionary.put(PdfName.MATRIX, new PdfArray(new float[]{0.4124f, 0.2126f, 0.0193f, 0.3576f, 0.7152f, 0.1192f, 0.1805f, 0.0722f, 0.9505f}));
                pdfDictionary.put(PdfName.WHITEPOINT, new PdfArray(new float[]{0.9505f, 1.0f, 1.089f}));
                PdfArray pdfArray = new PdfArray(PdfName.CALRGB);
                pdfArray.add(pdfDictionary);
                setDefaultColorspace(PdfName.DEFAULTRGB, addToBody(pdfArray).getIndirectReference());
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean propertyExists(Object obj) {
        return this.documentProperties.containsKey(obj);
    }

    public void registerLayer(PdfOCG pdfOCG) {
        checkPdfIsoConformance(this, 7, pdfOCG);
        if (!(pdfOCG instanceof PdfLayer)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("only.pdflayer.is.accepted", new Object[0]));
        }
        if (((PdfLayer) pdfOCG).getTitle() != null) {
            this.documentOCGorder.add(pdfOCG);
        } else {
            if (this.documentOCG.contains(pdfOCG)) {
                return;
            }
            this.documentOCG.add(pdfOCG);
            this.documentOCGorder.add(pdfOCG);
        }
    }

    public void releaseTemplate(PdfTemplate pdfTemplate) {
        Object obj;
        Object[] objArr = this.formXObjects.get(pdfTemplate.getIndirectReference());
        if (objArr == null || (obj = objArr[1]) == null) {
            return;
        }
        PdfTemplate pdfTemplate2 = (PdfTemplate) obj;
        if (!(pdfTemplate2.getIndirectReference() instanceof PRIndirectReference) && pdfTemplate2.getType() == 1) {
            addToBody(pdfTemplate2.getFormXObject(this.compressionLevel), pdfTemplate2.getIndirectReference());
            objArr[1] = null;
        }
    }

    public int reorderPages(int[] iArr) {
        return this.root.reorderPages(iArr);
    }

    public void resetContent() {
        this.directContent.reset();
        this.directContentUnder.reset();
    }

    public void resetPageDictEntries() {
        this.pageDictEntries = new PdfDictionary();
    }

    public void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (!pdfName.equals(DOCUMENT_CLOSE) && !pdfName.equals(WILL_SAVE) && !pdfName.equals(DID_SAVE) && !pdfName.equals(WILL_PRINT) && !pdfName.equals(DID_PRINT)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("invalid.additional.action.type.1", pdfName.toString()));
        }
        this.pdf.addAdditionalAction(pdfName, pdfAction);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setAtLeastPdfVersion(char c) {
        this.pdf_version.setAtLeastPdfVersion(c);
    }

    public void setBoxSize(String str, Rectangle rectangle) {
        this.pdf.setBoxSize(str, rectangle);
    }

    public void setCollection(PdfCollection pdfCollection) {
        setAtLeastPdfVersion(VERSION_1_7);
        this.pdf.setCollection(pdfCollection);
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }

    public void setCropBoxSize(Rectangle rectangle) {
        this.pdf.setCropBoxSize(rectangle);
    }

    public void setDefaultColorspace(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            this.defaultColorspace.remove(pdfName);
        }
        this.defaultColorspace.put(pdfName, pdfObject);
    }

    public void setDuration(int i) {
        this.pdf.setDuration(i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        if (this.pdf.isOpen()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("encryption.can.only.be.added.before.opening.the.document", new Object[0]));
        }
        PdfEncryption pdfEncryption = new PdfEncryption();
        this.crypto = pdfEncryption;
        pdfEncryption.setCryptoMode(i2, 0);
        this.crypto.setupAllKeys(bArr, bArr2, i);
    }

    public void setFullCompression() throws DocumentException {
        if (this.open) {
            throw new DocumentException(MessageLocalization.getComposedMessage("you.can.t.set.the.full.compression.if.the.document.is.already.open", new Object[0]));
        }
        this.fullCompression = true;
        setAtLeastPdfVersion(VERSION_1_5);
    }

    public void setGroup(PdfDictionary pdfDictionary) {
        this.group = pdfDictionary;
    }

    public void setInitialLeading(float f) throws DocumentException {
        if (this.open) {
            throw new DocumentException(MessageLocalization.getComposedMessage("you.can.t.set.the.initial.leading.if.the.document.is.already.open", new Object[0]));
        }
        this.pdf.setLeading(f);
    }

    public void setLanguage(String str) {
        this.pdf.setLanguage(str);
    }

    public void setLinearPageMode() {
        this.root.setLinearMode(null);
    }

    public void setOpenAction(String str) {
        this.pdf.setOpenAction(str);
    }

    public void setOutlines(List<HashMap<String, Object>> list) {
        this.newBookmarks = list;
    }

    public void setOutputIntents(String str, String str2, String str3, String str4, ICC_Profile iCC_Profile) {
        checkPdfIsoConformance(this, 19, iCC_Profile);
        getExtraCatalog();
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.OUTPUTINTENT);
        if (str2 != null) {
            pdfDictionary.put(PdfName.OUTPUTCONDITION, new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        if (str != null) {
            pdfDictionary.put(PdfName.OUTPUTCONDITIONIDENTIFIER, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (str3 != null) {
            pdfDictionary.put(PdfName.REGISTRYNAME, new PdfString(str3, PdfObject.TEXT_UNICODE));
        }
        if (str4 != null) {
            pdfDictionary.put(PdfName.INFO, new PdfString(str4, PdfObject.TEXT_UNICODE));
        }
        if (iCC_Profile != null) {
            pdfDictionary.put(PdfName.DESTOUTPUTPROFILE, addToBody(new PdfICCBased(iCC_Profile, this.compressionLevel)).getIndirectReference());
        }
        pdfDictionary.put(PdfName.S, PdfName.GTS_PDFX);
        this.extraCatalog.put(PdfName.OUTPUTINTENTS, new PdfArray(pdfDictionary));
        this.colorProfile = iCC_Profile;
    }

    public void setPDFXConformance(int i) {
        PdfIsoConformance pdfIsoConformance = this.pdfIsoConformance;
        if ((pdfIsoConformance instanceof PdfXConformanceImp) && ((PdfXConformance) pdfIsoConformance).getPDFXConformance() != i) {
            if (this.pdf.isOpen()) {
                throw new PdfXConformanceException(MessageLocalization.getComposedMessage("pdfx.conformance.can.only.be.set.before.opening.the.document", new Object[0]));
            }
            if (this.crypto != null) {
                throw new PdfXConformanceException(MessageLocalization.getComposedMessage("a.pdfx.conforming.document.cannot.be.encrypted", new Object[0]));
            }
            if (i != 0) {
                setPdfVersion(VERSION_1_3);
            }
            ((PdfXConformance) this.pdfIsoConformance).setPDFXConformance(i);
        }
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (!pdfName.equals(PAGE_OPEN) && !pdfName.equals(PAGE_CLOSE)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("invalid.page.additional.action.type.1", pdfName.toString()));
        }
        this.pdf.setPageAction(pdfName, pdfAction);
    }

    public void setPageEmpty(boolean z) {
        if (z) {
            return;
        }
        this.pdf.setPageEmpty(z);
    }

    public void setPageEvent(PdfPageEvent pdfPageEvent) {
        if (pdfPageEvent == null) {
            this.pageEvent = null;
            return;
        }
        PdfPageEvent pdfPageEvent2 = this.pageEvent;
        if (pdfPageEvent2 == null) {
            this.pageEvent = pdfPageEvent;
            return;
        }
        if (pdfPageEvent2 instanceof PdfPageEventForwarder) {
            ((PdfPageEventForwarder) pdfPageEvent2).addPageEvent(pdfPageEvent);
            return;
        }
        PdfPageEventForwarder pdfPageEventForwarder = new PdfPageEventForwarder();
        pdfPageEventForwarder.addPageEvent(this.pageEvent);
        pdfPageEventForwarder.addPageEvent(pdfPageEvent);
        this.pageEvent = pdfPageEventForwarder;
    }

    public void setPageLabels(PdfPageLabels pdfPageLabels) {
        this.pdf.setPageLabels(pdfPageLabels);
    }

    public void setPageViewport(PdfArray pdfArray) {
        addPageDictEntry(PdfName.VP, pdfArray);
    }

    public void setPageXmpMetadata(byte[] bArr) {
        this.pdf.setXmpMetadata(bArr);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setPdfVersion(char c) {
        this.pdf_version.setPdfVersion(c);
    }

    public void setRgbTransparencyBlending(boolean z) {
        this.rgbTransparencyBlending = z;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfRunDirection
    public void setRunDirection(int i) {
        if (i < 1 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public void setSigFlags(int i) {
        this.pdf.setSigFlags(i);
    }

    public void setSpaceCharRatio(float f) {
        if (f < 0.001f) {
            this.spaceCharRatio = 0.001f;
        } else {
            this.spaceCharRatio = f;
        }
    }

    public void setStrictImageSequence(boolean z) {
        this.pdf.setStrictImageSequence(z);
    }

    public void setTabs(PdfName pdfName) {
        this.tabs = pdfName;
    }

    public void setTagged() {
        setTagged(1);
    }

    public void setThumbnail(Image image) {
        this.pdf.setThumbnail(image);
    }

    public void setTransition(PdfTransition pdfTransition) {
        this.pdf.setTransition(pdfTransition);
    }

    public void setUserProperties(boolean z) {
        this.userProperties = z;
    }

    public void setUserunit(float f) throws DocumentException {
        if (f < 1.0f || f > 75000.0f) {
            throw new DocumentException(MessageLocalization.getComposedMessage("userunit.should.be.a.value.between.1.and.75000", new Object[0]));
        }
        addPageDictEntry(PdfName.USERUNIT, new PdfNumber(f));
        setAtLeastPdfVersion(VERSION_1_6);
    }

    public void setViewerPreferences(int i) {
        this.pdf.setViewerPreferences(i);
    }

    public void setXmpMetadata(byte[] bArr) {
        this.xmpMetadata = bArr;
    }

    public void useExternalCacheForTagStructure(TempFileCache tempFileCache) {
        this.pdf.useExternalCache(tempFileCache);
    }

    public void writeOutlines(PdfDictionary pdfDictionary, boolean z) {
        List<HashMap<String, Object>> list = this.newBookmarks;
        if (list == null || list.isEmpty()) {
            return;
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        PdfIndirectReference pdfIndirectReference = getPdfIndirectReference();
        Object[] objArrIterateOutlines = SimpleBookmark.iterateOutlines(this, pdfIndirectReference, this.newBookmarks, z);
        pdfDictionary2.put(PdfName.FIRST, (PdfIndirectReference) objArrIterateOutlines[0]);
        pdfDictionary2.put(PdfName.LAST, (PdfIndirectReference) objArrIterateOutlines[1]);
        pdfDictionary2.put(PdfName.COUNT, new PdfNumber(((Integer) objArrIterateOutlines[2]).intValue()));
        addToBody(pdfDictionary2, pdfIndirectReference);
        pdfDictionary.put(PdfName.OUTLINES, pdfIndirectReference);
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        addAnnotation(pdfAnnotation);
    }

    public PdfName addDirectImageSimple(Image image, PdfIndirectReference pdfIndirectReference) throws DocumentException {
        PdfName pdfNameName;
        byte[] globalBytes;
        if (this.images.containsKey(image.getMySerialId())) {
            return this.images.get(image.getMySerialId());
        }
        if (image.isImgTemplate()) {
            pdfNameName = new PdfName("img" + this.images.size());
            if (image instanceof ImgWMF) {
                try {
                    ((ImgWMF) image).readWMF(PdfTemplate.createTemplate(this, 0.0f, 0.0f));
                } catch (Exception e) {
                    throw new DocumentException(e);
                }
            }
        } else {
            PdfIndirectReference directReference = image.getDirectReference();
            if (directReference != null) {
                PdfName pdfName = new PdfName("img" + this.images.size());
                this.images.put(image.getMySerialId(), pdfName);
                this.imageDictionary.put(pdfName, directReference);
                return pdfName;
            }
            Image imageMask = image.getImageMask();
            PdfImage pdfImage = new PdfImage(image, "img" + this.images.size(), imageMask != null ? getImageReference(this.images.get(imageMask.getMySerialId())) : null);
            if ((image instanceof ImgJBIG2) && (globalBytes = ((ImgJBIG2) image).getGlobalBytes()) != null) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.JBIG2GLOBALS, getReferenceJBIG2Globals(globalBytes));
                pdfImage.put(PdfName.DECODEPARMS, pdfDictionary);
            }
            if (image.hasICCProfile()) {
                PdfIndirectReference pdfIndirectReferenceAdd = add(new PdfICCBased(image.getICCProfile(), image.getCompressionLevel()));
                PdfArray pdfArray = new PdfArray();
                pdfArray.add(PdfName.ICCBASED);
                pdfArray.add(pdfIndirectReferenceAdd);
                PdfName pdfName2 = PdfName.COLORSPACE;
                PdfArray asArray = pdfImage.getAsArray(pdfName2);
                if (asArray == null || asArray.size() <= 1 || !PdfName.INDEXED.equals(asArray.getPdfObject(0))) {
                    pdfImage.put(pdfName2, pdfArray);
                } else {
                    asArray.set(1, pdfArray);
                }
            }
            add(pdfImage, pdfIndirectReference);
            pdfNameName = pdfImage.name();
        }
        this.images.put(image.getMySerialId(), pdfNameName);
        return pdfNameName;
    }

    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) {
        this.pdf.addFileAttachment(str, pdfFileSpecification);
    }

    public void addJavaScript(String str, boolean z) {
        addJavaScript(PdfAction.javaScript(str, this, z));
    }

    public void checkPdfIsoConformance(int i, Object obj) {
        this.pdfIsoConformance.checkPdfIsoConformance(i, obj);
    }

    public XmpWriter createXmpWriter(ByteArrayOutputStream byteArrayOutputStream, HashMap<String, String> map) {
        return new XmpWriter(byteArrayOutputStream, map);
    }

    public Rectangle getBoxSize(String str, Rectangle rectangle) {
        Rectangle boxSize = this.pdf.getBoxSize(str);
        if (boxSize == null || rectangle == null) {
            return null;
        }
        com.itextpdf.awt.geom.Rectangle rectangleIntersection = new com.itextpdf.awt.geom.Rectangle(boxSize).intersection(new com.itextpdf.awt.geom.Rectangle(rectangle));
        if (rectangleIntersection.isEmpty()) {
            return null;
        }
        Rectangle rectangle2 = new Rectangle((float) rectangleIntersection.getX(), (float) rectangleIntersection.getY(), (float) (rectangleIntersection.getX() + rectangleIntersection.getWidth()), (float) (rectangleIntersection.getY() + rectangleIntersection.getHeight()));
        rectangle2.normalize();
        return rectangle2;
    }

    public void setOpenAction(PdfAction pdfAction) {
        this.pdf.setOpenAction(pdfAction);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setPdfVersion(PdfName pdfName) {
        this.pdf_version.setPdfVersion(pdfName);
    }

    public void setTagged(int i) {
        if (this.open) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("tagging.must.be.set.before.opening.the.document", new Object[0]));
        }
        this.tagged = true;
        this.taggingMode = i;
    }

    public void addFileAttachment(PdfFileSpecification pdfFileSpecification) {
        addFileAttachment(null, pdfFileSpecification);
    }

    public void addJavaScript(String str) {
        addJavaScript(str, false);
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, boolean z) {
        PdfIndirectObject pdfIndirectObjectAdd = this.body.add(pdfObject, z);
        cacheObject(pdfIndirectObjectAdd);
        return pdfIndirectObjectAdd;
    }

    public PdfAnnotation createAnnotation(float f, float f2, float f3, float f4, PdfString pdfString, PdfString pdfString2, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, f, f2, f3, f4, pdfString, pdfString2);
        if (pdfName != null) {
            pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        }
        return pdfAnnotation;
    }

    public void addJavaScript(String str, PdfAction pdfAction) {
        this.pdf.addJavaScript(str, pdfAction);
    }

    public static PdfWriter getInstance(Document document, OutputStream outputStream, DocListener docListener) {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.addDocListener(docListener);
        document.addDocListener(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.addWriter(pdfWriter);
        return pdfWriter;
    }

    public void addJavaScript(String str, String str2, boolean z) {
        addJavaScript(str, PdfAction.javaScript(str2, this, z));
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) {
        PdfIndirectObject pdfIndirectObjectAdd = this.body.add(pdfObject, pdfIndirectReference);
        cacheObject(pdfIndirectObjectAdd);
        return pdfIndirectObjectAdd;
    }

    public PdfAnnotation createAnnotation(float f, float f2, float f3, float f4, PdfAction pdfAction, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, f, f2, f3, f4, pdfAction);
        if (pdfName != null) {
            pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        }
        return pdfAnnotation;
    }

    public void addJavaScript(String str, String str2) {
        addJavaScript(str, str2, false);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        if (!this.pdf.isOpen()) {
            this.crypto = new PdfEncryption();
            if (certificateArr != null) {
                for (int i2 = 0; i2 < certificateArr.length; i2++) {
                    this.crypto.addRecipient(certificateArr[i2], iArr[i2]);
                }
            }
            this.crypto.setCryptoMode(i, 0);
            this.crypto.getEncryptionDictionary();
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("encryption.can.only.be.added.before.opening.the.document", new Object[0]));
    }

    public ColorDetails addSimple(ICachedColorSpace iCachedColorSpace) {
        ColorDetails colorDetails = this.documentColors.get(iCachedColorSpace);
        if (colorDetails == null) {
            colorDetails = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), iCachedColorSpace);
            if (iCachedColorSpace instanceof IPdfSpecialColorSpace) {
                ((IPdfSpecialColorSpace) iCachedColorSpace).getColorantDetails(this);
            }
            this.documentColors.put(iCachedColorSpace, colorDetails);
        }
        return colorDetails;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) {
        PdfIndirectObject pdfIndirectObjectAdd = this.body.add(pdfObject, pdfIndirectReference, z);
        cacheObject(pdfIndirectObjectAdd);
        return pdfIndirectObjectAdd;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, int i) {
        PdfIndirectObject pdfIndirectObjectAdd = this.body.add(pdfObject, i);
        cacheObject(pdfIndirectObjectAdd);
        return pdfIndirectObjectAdd;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, int i, boolean z) throws IOException {
        PdfIndirectObject pdfIndirectObjectAdd = this.body.add(pdfObject, i, 0, z);
        cacheObject(pdfIndirectObjectAdd);
        return pdfIndirectObjectAdd;
    }

    @Deprecated
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    @Deprecated
    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z ? 1 : 0);
    }

    public void setOutputIntents(String str, String str2, String str3, String str4, byte[] bArr) {
        setOutputIntents(str, str2, str3, str4, bArr == null ? null : ICC_Profile.getInstance(bArr));
    }

    @Deprecated
    public void setEncryption(int i, String str, String str2, int i2) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i2, i);
    }

    public boolean setOutputIntents(PdfReader pdfReader, boolean z) {
        PdfArray asArray = pdfReader.getCatalog().getAsArray(PdfName.OUTPUTINTENTS);
        boolean z2 = false;
        if (asArray == null || asArray.isEmpty()) {
            return false;
        }
        PdfDictionary asDict = asArray.getAsDict(0);
        PdfObject pdfObject = PdfReader.getPdfObject(asDict.get(PdfName.S));
        if (pdfObject != null && PdfName.GTS_PDFX.equals(pdfObject)) {
            z2 = true;
            if (z) {
                return true;
            }
            PRStream pRStream = (PRStream) PdfReader.getPdfObject(asDict.get(PdfName.DESTOUTPUTPROFILE));
            setOutputIntents(getNameString(asDict, PdfName.OUTPUTCONDITIONIDENTIFIER), getNameString(asDict, PdfName.OUTPUTCONDITION), getNameString(asDict, PdfName.REGISTRYNAME), getNameString(asDict, PdfName.INFO), pRStream != null ? PdfReader.getStreamBytes(pRStream) : null);
        }
        return z2;
    }

    public PdfIndirectReference add(PdfImage pdfImage, PdfIndirectReference pdfIndirectReference) {
        if (!this.imageDictionary.contains(pdfImage.name())) {
            checkPdfIsoConformance(this, 5, pdfImage);
            if (pdfIndirectReference instanceof PRIndirectReference) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfIndirectReference;
                pdfIndirectReference = new PdfIndirectReference(0, getNewObjectNumber(pRIndirectReference.getReader(), pRIndirectReference.getNumber(), pRIndirectReference.getGeneration()));
            }
            try {
                if (pdfIndirectReference == null) {
                    pdfIndirectReference = addToBody(pdfImage).getIndirectReference();
                } else {
                    addToBody(pdfImage, pdfIndirectReference);
                }
                this.imageDictionary.put(pdfImage.name(), pdfIndirectReference);
                return pdfIndirectReference;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        return (PdfIndirectReference) this.imageDictionary.get(pdfImage.name());
    }

    public PdfIndirectReference add(PdfICCBased pdfICCBased) {
        try {
            return addToBody(pdfICCBased).getIndirectReference();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfWriter(PdfDocument pdfDocument, OutputStream outputStream) {
        super(pdfDocument, outputStream);
        this.root = new PdfPages(this);
        this.pageReferences = new ArrayList<>();
        this.currentPageNumber = 1;
        this.tabs = null;
        this.pageDictEntries = new PdfDictionary();
        this.prevxref = 0L;
        this.originalFileID = null;
        this.pdf_version = new PdfVersionImp();
        this.xmpMetadata = null;
        this.xmpWriter = null;
        this.pdfIsoConformance = initPdfIsoConformance();
        this.fullCompression = false;
        this.compressionLevel = -1;
        this.documentFonts = new LinkedHashMap<>();
        this.fontNumber = 1;
        this.formXObjects = new HashMap<>();
        this.formXObjectsCounter = 1;
        this.readerInstances = new HashMap<>();
        this.documentColors = new HashMap<>();
        this.colorNumber = 1;
        this.documentPatterns = new HashMap<>();
        this.patternNumber = 1;
        this.documentShadingPatterns = new HashSet<>();
        this.documentShadings = new HashSet<>();
        this.documentExtGState = new HashMap<>();
        this.documentProperties = new HashMap<>();
        this.tagged = false;
        this.taggingMode = 1;
        this.documentOCG = new LinkedHashSet<>();
        this.documentOCGorder = new ArrayList<>();
        this.OCGRadioGroup = new PdfArray();
        this.OCGLocked = new PdfArray();
        this.spaceCharRatio = 2.5f;
        this.runDirection = 1;
        this.defaultColorspace = new PdfDictionary();
        this.documentSpotPatterns = new HashMap<>();
        this.imageDictionary = new PdfDictionary();
        this.images = new HashMap<>();
        this.JBIG2Globals = new HashMap<>();
        this.ttfUnicodeWriter = null;
        this.pdf = pdfDocument;
        PdfContentByte pdfContentByte = new PdfContentByte(this);
        this.directContentUnder = pdfContentByte;
        this.directContent = pdfContentByte.getDuplicate();
    }
}
