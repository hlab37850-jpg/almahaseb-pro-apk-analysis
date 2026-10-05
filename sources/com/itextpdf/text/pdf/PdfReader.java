package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.WindowRandomAccessSource;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.pdf.security.ExternalDecryptionProcess;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.zip.InflaterInputStream;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cms.CMSEnvelopedData;
import org.spongycastle.cms.RecipientInformation;

/* JADX INFO: loaded from: classes3.dex */
public class PdfReader implements PdfViewerPreferences {
    public static boolean debugmode = false;
    public static boolean unethicalreading = false;
    protected PRAcroForm acroForm;
    protected boolean acroFormParsed;
    private boolean appendable;
    protected PdfDictionary catalog;
    protected Certificate certificate;
    protected Key certificateKey;
    protected String certificateKeyProvider;
    protected boolean consolidateNamedDestinations;
    private PRIndirectReference cryptoRef;
    protected PdfEncryption decrypt;
    protected boolean encrypted;
    private boolean encryptionError;
    protected long eofPos;
    protected ExternalDecryptionProcess externalDecryptionProcess;
    private long fileLength;
    protected int freeXref;
    private boolean hybridXref;
    protected long lastXref;
    private int lastXrefPartial;
    protected boolean newXrefType;
    private int objGen;
    private int objNum;
    protected HashMap<Integer, IntHashtable> objStmMark;
    protected LongHashtable objStmToOffset;
    private boolean ownerPasswordUsed;
    protected long pValue;
    protected PageRefs pageRefs;
    private boolean partial;
    protected byte[] password;
    protected char pdfVersion;
    protected int rValue;
    private int readDepth;
    protected boolean rebuilt;
    protected boolean remoteToLocalNamedDestinations;
    PdfDictionary rootPages;
    protected boolean sharedStreams;
    protected ArrayList<PdfString> strings;
    protected boolean tampered;
    protected PRTokeniser tokens;
    protected PdfDictionary trailer;
    private final PdfViewerPreferencesImp viewerPreferences;
    protected long[] xref;
    protected ArrayList<PdfObject> xrefObj;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) PdfReader.class);
    static final PdfName[] pageInhCandidates = {PdfName.MEDIABOX, PdfName.ROTATE, PdfName.RESOURCES, PdfName.CROPBOX};
    static final byte[] endstream = PdfEncodings.convertToBytes("endstream", (String) null);
    static final byte[] endobj = PdfEncodings.convertToBytes("endobj", (String) null);
    protected static Counter COUNTER = CounterFactory.getCounter(PdfReader.class);

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.PdfReader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType;

        static {
            int[] iArr = new int[PRTokeniser.TokenType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType = iArr;
            try {
                iArr[PRTokeniser.TokenType.START_DIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.REF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.ENDOFFILE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static class PageRefs {
        private boolean keepPages;
        private int lastPageRead;
        private ArrayList<PdfDictionary> pageInh;
        private Set<PdfObject> pagesNodes;
        private final PdfReader reader;
        private ArrayList<PRIndirectReference> refsn;
        private IntHashtable refsp;
        private int sizep;

        public /* synthetic */ PageRefs(PdfReader pdfReader, AnonymousClass1 anonymousClass1) {
            this(pdfReader);
        }

        private void iteratePages(PRIndirectReference pRIndirectReference) throws InvalidPdfException {
            if (!this.pagesNodes.add(PdfReader.getPdfObject(pRIndirectReference))) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.pages.tree", new Object[0]));
            }
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
            if (pdfDictionary == null) {
                return;
            }
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.KIDS);
            if (asArray != null) {
                pdfDictionary.put(PdfName.TYPE, PdfName.PAGES);
                pushPageAttributes(pdfDictionary);
                for (int i = 0; i < asArray.size(); i++) {
                    PdfObject pdfObject = asArray.getPdfObject(i);
                    if (!pdfObject.isIndirect()) {
                        while (i < asArray.size()) {
                            asArray.remove(i);
                        }
                        break;
                    }
                    iteratePages((PRIndirectReference) pdfObject);
                }
                popPageAttributes();
                return;
            }
            pdfDictionary.put(PdfName.TYPE, PdfName.PAGE);
            ArrayList<PdfDictionary> arrayList = this.pageInh;
            PdfDictionary pdfDictionary2 = arrayList.get(arrayList.size() - 1);
            for (PdfName pdfName : pdfDictionary2.getKeys()) {
                if (pdfDictionary.get(pdfName) == null) {
                    pdfDictionary.put(pdfName, pdfDictionary2.get(pdfName));
                }
            }
            PdfName pdfName2 = PdfName.MEDIABOX;
            if (pdfDictionary.get(pdfName2) == null) {
                Rectangle rectangle = PageSize.LETTER;
                pdfDictionary.put(pdfName2, new PdfArray(new float[]{0.0f, 0.0f, rectangle.getRight(), rectangle.getTop()}));
            }
            this.refsn.add(pRIndirectReference);
        }

        private void popPageAttributes() {
            ArrayList<PdfDictionary> arrayList = this.pageInh;
            arrayList.remove(arrayList.size() - 1);
        }

        private void pushPageAttributes(PdfDictionary pdfDictionary) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            if (!this.pageInh.isEmpty()) {
                ArrayList<PdfDictionary> arrayList = this.pageInh;
                pdfDictionary2.putAll(arrayList.get(arrayList.size() - 1));
            }
            int i = 0;
            while (true) {
                PdfName[] pdfNameArr = PdfReader.pageInhCandidates;
                if (i >= pdfNameArr.length) {
                    this.pageInh.add(pdfDictionary2);
                    return;
                }
                PdfObject pdfObject = pdfDictionary.get(pdfNameArr[i]);
                if (pdfObject != null) {
                    pdfDictionary2.put(pdfNameArr[i], pdfObject);
                }
                i++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void selectPages(List<Integer> list) {
            IntHashtable intHashtable = new IntHashtable();
            ArrayList arrayList = new ArrayList();
            int size = size();
            for (Integer num : list) {
                int iIntValue = num.intValue();
                if (iIntValue >= 1 && iIntValue <= size && intHashtable.put(iIntValue, 1) == 0) {
                    arrayList.add(num);
                }
            }
            if (this.reader.partial) {
                for (int i = 1; i <= size; i++) {
                    getPageOrigRef(i);
                    resetReleasePage();
                }
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) this.reader.catalog.get(PdfName.PAGES);
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
            ArrayList<PRIndirectReference> arrayList2 = new ArrayList<>(arrayList.size());
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int iIntValue2 = ((Integer) arrayList.get(i2)).intValue();
                PRIndirectReference pageOrigRef = getPageOrigRef(iIntValue2);
                resetReleasePage();
                pdfArray.add(pageOrigRef);
                arrayList2.add(pageOrigRef);
                getPageN(iIntValue2).put(PdfName.PARENT, pRIndirectReference);
            }
            AcroFields acroFields = this.reader.getAcroFields();
            boolean z = acroFields.getFields().size() > 0;
            for (int i3 = 1; i3 <= size; i3++) {
                if (!intHashtable.containsKey(i3)) {
                    if (z) {
                        acroFields.removeFieldsFromPage(i3);
                    }
                    int number = getPageOrigRef(i3).getNumber();
                    this.reader.xrefObj.set(number, null);
                    if (this.reader.partial) {
                        long[] jArr = this.reader.xref;
                        int i4 = number * 2;
                        jArr[i4] = -1;
                        jArr[i4 + 1] = 0;
                    }
                }
            }
            pdfDictionary.put(PdfName.COUNT, new PdfNumber(arrayList.size()));
            pdfDictionary.put(PdfName.KIDS, pdfArray);
            this.refsp = null;
            this.refsn = arrayList2;
        }

        public PdfDictionary getPageN(int i) {
            return (PdfDictionary) PdfReader.getPdfObject(getPageOrigRef(i));
        }

        public PdfDictionary getPageNRelease(int i) {
            PdfDictionary pageN = getPageN(i);
            releasePage(i);
            return pageN;
        }

        public PRIndirectReference getPageOrigRef(int i) {
            int i2 = i - 1;
            if (i2 < 0) {
                return null;
            }
            try {
                if (i2 >= size()) {
                    return null;
                }
                ArrayList<PRIndirectReference> arrayList = this.refsn;
                if (arrayList != null) {
                    return arrayList.get(i2);
                }
                int i3 = this.refsp.get(i2);
                if (i3 != 0) {
                    if (this.lastPageRead != i2) {
                        this.lastPageRead = -1;
                    }
                    if (this.keepPages) {
                        this.lastPageRead = -1;
                    }
                    return new PRIndirectReference(this.reader, i3);
                }
                PRIndirectReference singlePage = getSinglePage(i2);
                if (this.reader.lastXrefPartial == -1) {
                    this.lastPageRead = -1;
                } else {
                    this.lastPageRead = i2;
                }
                this.reader.lastXrefPartial = -1;
                this.refsp.put(i2, singlePage.getNumber());
                if (this.keepPages) {
                    this.lastPageRead = -1;
                }
                return singlePage;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        public PRIndirectReference getPageOrigRefRelease(int i) {
            PRIndirectReference pageOrigRef = getPageOrigRef(i);
            releasePage(i);
            return pageOrigRef;
        }

        public PRIndirectReference getSinglePage(int i) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfDictionary pdfDictionary2 = this.reader.rootPages;
            int i2 = 0;
            while (true) {
                int i3 = 0;
                while (true) {
                    PdfName[] pdfNameArr = PdfReader.pageInhCandidates;
                    if (i3 >= pdfNameArr.length) {
                        break;
                    }
                    PdfObject pdfObject = pdfDictionary2.get(pdfNameArr[i3]);
                    if (pdfObject != null) {
                        pdfDictionary.put(pdfNameArr[i3], pdfObject);
                    }
                    i3++;
                }
                ListIterator<PdfObject> listIterator = ((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.KIDS))).listIterator();
                while (listIterator.hasNext()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) listIterator.next();
                    PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
                    int i4 = this.reader.lastXrefPartial;
                    PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.COUNT));
                    this.reader.lastXrefPartial = i4;
                    int iIntValue = ((pdfObjectRelease == null || pdfObjectRelease.type() != 2) ? 1 : ((PdfNumber) pdfObjectRelease).intValue()) + i2;
                    if (i < iIntValue) {
                        if (pdfObjectRelease != null) {
                            this.reader.releaseLastXrefPartial();
                            pdfDictionary2 = pdfDictionary3;
                            break;
                        }
                        pdfDictionary3.mergeDifferent(pdfDictionary);
                        return pRIndirectReference;
                    }
                    this.reader.releaseLastXrefPartial();
                    i2 = iIntValue;
                }
            }
        }

        public void insertPage(int i, PRIndirectReference pRIndirectReference) {
            int i2 = i - 1;
            ArrayList<PRIndirectReference> arrayList = this.refsn;
            if (arrayList != null) {
                if (i2 >= arrayList.size()) {
                    this.refsn.add(pRIndirectReference);
                    return;
                } else {
                    this.refsn.add(i2, pRIndirectReference);
                    return;
                }
            }
            this.sizep++;
            this.lastPageRead = -1;
            if (i2 >= size()) {
                this.refsp.put(size(), pRIndirectReference.getNumber());
                return;
            }
            IntHashtable intHashtable = new IntHashtable((this.refsp.size() + 1) * 2);
            Iterator<IntHashtable.Entry> entryIterator = this.refsp.getEntryIterator();
            while (entryIterator.hasNext()) {
                IntHashtable.Entry next = entryIterator.next();
                int key = next.getKey();
                if (key >= i2) {
                    key++;
                }
                intHashtable.put(key, next.getValue());
            }
            intHashtable.put(i2, pRIndirectReference.getNumber());
            this.refsp = intHashtable;
        }

        public void keepPages() {
            IntHashtable intHashtable = this.refsp;
            if (intHashtable == null || this.keepPages) {
                return;
            }
            this.keepPages = true;
            intHashtable.clear();
        }

        public void reReadPages() throws InvalidPdfException {
            this.refsn = null;
            readPages();
        }

        public void readPages() throws InvalidPdfException {
            if (this.refsn != null) {
                return;
            }
            this.refsp = null;
            this.refsn = new ArrayList<>();
            this.pageInh = new ArrayList<>();
            iteratePages((PRIndirectReference) this.reader.catalog.get(PdfName.PAGES));
            this.pageInh = null;
            this.reader.rootPages.put(PdfName.COUNT, new PdfNumber(this.refsn.size()));
        }

        public void releasePage(int i) {
            int i2;
            if (this.refsp != null && (i2 = i - 1) >= 0 && i2 < size() && i2 == this.lastPageRead) {
                this.lastPageRead = -1;
                this.reader.lastXrefPartial = this.refsp.get(i2);
                this.reader.releaseLastXrefPartial();
                this.refsp.remove(i2);
            }
        }

        public void resetReleasePage() {
            if (this.refsp == null) {
                return;
            }
            this.lastPageRead = -1;
        }

        public int size() {
            ArrayList<PRIndirectReference> arrayList = this.refsn;
            return arrayList != null ? arrayList.size() : this.sizep;
        }

        private PageRefs(PdfReader pdfReader) throws InvalidPdfException {
            this.lastPageRead = -1;
            this.pagesNodes = new HashSet();
            this.reader = pdfReader;
            if (!pdfReader.partial) {
                readPages();
            } else {
                this.refsp = new IntHashtable();
                this.sizep = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfReader.rootPages.get(PdfName.COUNT))).intValue();
            }
        }

        public PageRefs(PageRefs pageRefs, PdfReader pdfReader) {
            this.lastPageRead = -1;
            this.pagesNodes = new HashSet();
            this.reader = pdfReader;
            this.sizep = pageRefs.sizep;
            if (pageRefs.refsn != null) {
                this.refsn = new ArrayList<>(pageRefs.refsn);
                for (int i = 0; i < this.refsn.size(); i++) {
                    ArrayList<PRIndirectReference> arrayList = this.refsn;
                    arrayList.set(i, (PRIndirectReference) PdfReader.duplicatePdfObject(arrayList.get(i), pdfReader));
                }
                return;
            }
            this.refsp = (IntHashtable) pageRefs.refsp.clone();
        }
    }

    private PdfReader(RandomAccessSource randomAccessSource, boolean z, byte[] bArr, Certificate certificate, Key key, String str, ExternalDecryptionProcess externalDecryptionProcess, boolean z2) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.externalDecryptionProcess = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.certificate = certificate;
        this.certificateKey = key;
        this.certificateKeyProvider = str;
        this.externalDecryptionProcess = externalDecryptionProcess;
        this.password = bArr;
        this.partial = z;
        try {
            this.tokens = getOffsetTokeniser(randomAccessSource);
            if (z) {
                readPdfPartial();
            } else {
                readPdf();
            }
            getCounter().read(this.fileLength);
        } catch (IOException e) {
            if (z2) {
                randomAccessSource.close();
            }
            throw e;
        }
    }

    public static byte[] ASCII85Decode(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int[] iArr = new int[5];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length && (i = bArr[i3] & UnsignedBytes.MAX_VALUE) != 126; i3++) {
            if (!PRTokeniser.isWhitespace(i)) {
                if (i == 122 && i2 == 0) {
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                } else {
                    if (i < 33 || i > 117) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("illegal.character.in.ascii85decode", new Object[0]));
                    }
                    iArr[i2] = i - 33;
                    i2++;
                    if (i2 == 5) {
                        int i4 = 0;
                        for (int i5 = 0; i5 < 5; i5++) {
                            i4 = (i4 * 85) + iArr[i5];
                        }
                        byteArrayOutputStream.write((byte) (i4 >> 24));
                        byteArrayOutputStream.write((byte) (i4 >> 16));
                        byteArrayOutputStream.write((byte) (i4 >> 8));
                        byteArrayOutputStream.write((byte) i4);
                        i2 = 0;
                    }
                }
            }
        }
        if (i2 == 2) {
            byteArrayOutputStream.write((byte) ((((iArr[0] * 52200625) + (iArr[1] * 614125)) + 621435) >> 24));
        } else if (i2 == 3) {
            int i6 = (iArr[0] * 52200625) + (iArr[1] * 614125) + (iArr[2] * 7225) + 7310;
            byteArrayOutputStream.write((byte) (i6 >> 24));
            byteArrayOutputStream.write((byte) (i6 >> 16));
        } else if (i2 == 4) {
            int i7 = (iArr[0] * 52200625) + (iArr[1] * 614125) + (iArr[2] * 7225) + (iArr[3] * 85) + 85;
            byteArrayOutputStream.write((byte) (i7 >> 24));
            byteArrayOutputStream.write((byte) (i7 >> 16));
            byteArrayOutputStream.write((byte) (i7 >> 8));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] ASCIIHexDecode(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = true;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length && (i = bArr[i3] & UnsignedBytes.MAX_VALUE) != 62; i3++) {
            if (!PRTokeniser.isWhitespace(i)) {
                int hex = PRTokeniser.getHex(i);
                if (hex == -1) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("illegal.character.in.asciihexdecode", new Object[0]));
                }
                if (z) {
                    i2 = hex;
                } else {
                    byteArrayOutputStream.write((byte) ((i2 << 4) + hex));
                }
                z = !z;
            }
        }
        if (!z) {
            byteArrayOutputStream.write((byte) (i2 << 4));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] FlateDecode(byte[] bArr) {
        byte[] bArrFlateDecode = FlateDecode(bArr, true);
        return bArrFlateDecode == null ? FlateDecode(bArr, false) : bArrFlateDecode;
    }

    public static byte[] LZWDecode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new LZWDecoder().decode(bArr, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00da A[PHI: r12
      0x00da: PHI (r12v2 long) = (r12v1 long), (r12v5 long) binds: [B:20:0x0068, B:40:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    private void checkPRStreamLength(PRStream pRStream) {
        long jIntValue;
        long j;
        long filePointer;
        long length = this.tokens.length();
        long offset = pRStream.getOffset();
        PdfObject pdfObjectRelease = getPdfObjectRelease(pRStream.get(PdfName.LENGTH));
        boolean z = true;
        if (pdfObjectRelease == null || pdfObjectRelease.type() != 2) {
            jIntValue = 0;
        } else {
            jIntValue = ((PdfNumber) pdfObjectRelease).intValue();
            long j2 = jIntValue + offset;
            if (j2 <= length - 20) {
                this.tokens.seek(j2);
                String string = this.tokens.readString(20);
                if (string.startsWith("\nendstream") || string.startsWith("\r\nendstream") || string.startsWith("\rendstream") || string.startsWith("endstream")) {
                    z = false;
                }
            }
        }
        if (z) {
            byte[] bArr = new byte[16];
            this.tokens.seek(offset);
            while (true) {
                filePointer = this.tokens.getFilePointer();
                if (!this.tokens.readLineSegment(bArr, false)) {
                    break;
                }
                if (!equalsn(bArr, endstream)) {
                    if (equalsn(bArr, endobj)) {
                        long j3 = filePointer - 16;
                        this.tokens.seek(j3);
                        int iIndexOf = this.tokens.readString(16).indexOf("endstream");
                        if (iIndexOf >= 0) {
                            filePointer = j3 + ((long) iIndexOf);
                        }
                    }
                }
                jIntValue = filePointer - offset;
                break;
            }
            this.tokens.seek(filePointer - 2);
            if (this.tokens.read() == 13) {
                jIntValue--;
            }
            this.tokens.seek(filePointer - 1);
            if (this.tokens.read() == 10) {
                jIntValue--;
            }
            j = jIntValue >= 0 ? jIntValue : 0L;
        }
        pRStream.setLength((int) j);
    }

    private boolean convertNamedDestination(PdfObject pdfObject, HashMap<Object, PdfObject> map) {
        PdfObject pdfObject2;
        PdfObject pdfObjectRelease;
        PdfObject string;
        PdfObject pdfObject3 = getPdfObject(pdfObject);
        int i = this.lastXrefPartial;
        releaseLastXrefPartial();
        if (pdfObject3 == null || !pdfObject3.isDictionary() || (pdfObject2 = getPdfObject(((PdfDictionary) pdfObject3).get(PdfName.A))) == null) {
            return false;
        }
        int i2 = this.lastXrefPartial;
        releaseLastXrefPartial();
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject2;
        PdfName pdfName = PdfName.S;
        if (!PdfName.GOTOR.equals((PdfName) getPdfObjectRelease(pdfDictionary.get(pdfName))) || (pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.D))) == null) {
            return false;
        }
        if (!pdfObjectRelease.isName()) {
            if (pdfObjectRelease.isString()) {
                string = pdfObjectRelease;
                string = pdfObjectRelease.toString();
            } else {
                string = pdfObjectRelease;
                string = null;
            }
        }
        string = pdfObjectRelease;
        if (((PdfArray) map.get(string)) == null) {
            return false;
        }
        pdfDictionary.remove(PdfName.F);
        pdfDictionary.remove(PdfName.NEWWINDOW);
        pdfDictionary.put(pdfName, PdfName.GOTO);
        setXrefPartialObject(i2, pdfObject2);
        setXrefPartialObject(i, pdfObject3);
        return true;
    }

    public static byte[] decodeBytes(byte[] bArr, PdfDictionary pdfDictionary) {
        return decodeBytes(bArr, pdfDictionary, FilterHandlers.getDefaultFilterHandlers());
    }

    public static byte[] decodePredictor(byte[] bArr, PdfObject pdfObject) {
        if (pdfObject == null || !pdfObject.isDictionary()) {
            return bArr;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        PdfObject pdfObject2 = getPdfObject(pdfDictionary.get(PdfName.PREDICTOR));
        if (pdfObject2 == null || !pdfObject2.isNumber()) {
            return bArr;
        }
        int iIntValue = ((PdfNumber) pdfObject2).intValue();
        if (iIntValue < 10 && iIntValue != 2) {
            return bArr;
        }
        PdfObject pdfObject3 = getPdfObject(pdfDictionary.get(PdfName.COLUMNS));
        int iIntValue2 = (pdfObject3 == null || !pdfObject3.isNumber()) ? 1 : ((PdfNumber) pdfObject3).intValue();
        PdfObject pdfObject4 = getPdfObject(pdfDictionary.get(PdfName.COLORS));
        int iIntValue3 = (pdfObject4 == null || !pdfObject4.isNumber()) ? 1 : ((PdfNumber) pdfObject4).intValue();
        PdfObject pdfObject5 = getPdfObject(pdfDictionary.get(PdfName.BITSPERCOMPONENT));
        int iIntValue4 = (pdfObject5 == null || !pdfObject5.isNumber()) ? 8 : ((PdfNumber) pdfObject5).intValue();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        int i = (iIntValue3 * iIntValue4) / 8;
        int i2 = (((iIntValue3 * iIntValue2) * iIntValue4) + 7) / 8;
        byte[] bArr2 = new byte[i2];
        byte[] bArr3 = new byte[i2];
        if (iIntValue == 2) {
            if (iIntValue4 == 8) {
                int length = bArr.length / i2;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = i3 * i2;
                    for (int i5 = i; i5 < i2; i5++) {
                        int i6 = i4 + i5;
                        bArr[i6] = (byte) (bArr[i6] + bArr[i6 - i]);
                    }
                }
            }
            return bArr;
        }
        while (true) {
            try {
                int i7 = dataInputStream.read();
                if (i7 < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                dataInputStream.readFully(bArr2, 0, i2);
                if (i7 != 0) {
                    if (i7 == 1) {
                        for (int i8 = i; i8 < i2; i8++) {
                            bArr2[i8] = (byte) (bArr2[i8] + bArr2[i8 - i]);
                        }
                    } else if (i7 == 2) {
                        for (int i9 = 0; i9 < i2; i9++) {
                            bArr2[i9] = (byte) (bArr2[i9] + bArr3[i9]);
                        }
                    } else if (i7 == 3) {
                        for (int i10 = 0; i10 < i; i10++) {
                            bArr2[i10] = (byte) (bArr2[i10] + (bArr3[i10] / 2));
                        }
                        for (int i11 = i; i11 < i2; i11++) {
                            bArr2[i11] = (byte) (bArr2[i11] + (((bArr2[i11 - i] & UnsignedBytes.MAX_VALUE) + (bArr3[i11] & UnsignedBytes.MAX_VALUE)) / 2));
                        }
                    } else {
                        if (i7 != 4) {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("png.filter.unknown", new Object[0]));
                        }
                        for (int i12 = 0; i12 < i; i12++) {
                            bArr2[i12] = (byte) (bArr2[i12] + bArr3[i12]);
                        }
                        for (int i13 = i; i13 < i2; i13++) {
                            int i14 = i13 - i;
                            int i15 = bArr2[i14] & UnsignedBytes.MAX_VALUE;
                            int i16 = bArr3[i13] & UnsignedBytes.MAX_VALUE;
                            int i17 = bArr3[i14] & UnsignedBytes.MAX_VALUE;
                            int i18 = (i15 + i16) - i17;
                            int iAbs = Math.abs(i18 - i15);
                            int iAbs2 = Math.abs(i18 - i16);
                            int iAbs3 = Math.abs(i18 - i17);
                            if (iAbs > iAbs2 || iAbs > iAbs3) {
                                i15 = iAbs2 <= iAbs3 ? i16 : i17;
                            }
                            bArr2[i13] = (byte) (bArr2[i13] + ((byte) i15));
                        }
                    }
                }
                try {
                    byteArrayOutputStream.write(bArr2);
                } catch (IOException unused) {
                }
                byte[] bArr4 = bArr3;
                bArr3 = bArr2;
                bArr2 = bArr4;
            } catch (Exception unused2) {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static PdfDictionary duplicatePdfDictionary(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfReader pdfReader) {
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary(pdfDictionary.size());
        }
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            pdfDictionary2.put(pdfName, duplicatePdfObject(pdfDictionary.get(pdfName), pdfReader));
        }
        return pdfDictionary2;
    }

    public static PdfObject duplicatePdfObject(PdfObject pdfObject, PdfReader pdfReader) {
        if (pdfObject == null) {
            return null;
        }
        int iType = pdfObject.type();
        if (iType == 5) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            PdfArray pdfArray2 = new PdfArray(pdfArray.size());
            ListIterator<PdfObject> listIterator = pdfArray.listIterator();
            while (listIterator.hasNext()) {
                pdfArray2.add(duplicatePdfObject(listIterator.next(), pdfReader));
            }
            return pdfArray2;
        }
        if (iType == 6) {
            return duplicatePdfDictionary((PdfDictionary) pdfObject, null, pdfReader);
        }
        if (iType != 7) {
            if (iType != 10) {
                return pdfObject;
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            return new PRIndirectReference(pdfReader, pRIndirectReference.getNumber(), pRIndirectReference.getGeneration());
        }
        PRStream pRStream = (PRStream) pdfObject;
        PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null, pdfReader);
        duplicatePdfDictionary(pRStream, pRStream2, pdfReader);
        return pRStream2;
    }

    private void ensureXrefSize(int i) {
        if (i == 0) {
            return;
        }
        long[] jArr = this.xref;
        if (jArr == null) {
            this.xref = new long[i];
        } else if (jArr.length < i) {
            long[] jArr2 = new long[i];
            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
            this.xref = jArr2;
        }
    }

    private boolean equalsArray(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsn(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean existsName(PdfDictionary pdfDictionary, PdfName pdfName, PdfName pdfName2) {
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(pdfName));
        if (pdfObjectRelease == null || !pdfObjectRelease.isName()) {
            return false;
        }
        return ((PdfName) pdfObjectRelease).equals(pdfName2);
    }

    public static String getFontName(PdfDictionary pdfDictionary) {
        PdfObject pdfObjectRelease;
        if (pdfDictionary == null || (pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.BASEFONT))) == null || !pdfObjectRelease.isName()) {
            return null;
        }
        return PdfName.decodeName(pdfObjectRelease.toString());
    }

    private static PdfArray getNameArray(PdfObject pdfObject) {
        PdfObject pdfObjectRelease;
        PdfObject pdfObjectRelease2;
        if (pdfObject == null || (pdfObjectRelease = getPdfObjectRelease(pdfObject)) == null) {
            return null;
        }
        if (pdfObjectRelease.isArray()) {
            return (PdfArray) pdfObjectRelease;
        }
        if (pdfObjectRelease.isDictionary() && (pdfObjectRelease2 = getPdfObjectRelease(((PdfDictionary) pdfObjectRelease).get(PdfName.D))) != null && pdfObjectRelease2.isArray()) {
            return (PdfArray) pdfObjectRelease2;
        }
        return null;
    }

    public static Rectangle getNormalizedRectangle(PdfArray pdfArray) {
        float fFloatValue = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(0))).floatValue();
        float fFloatValue2 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(1))).floatValue();
        float fFloatValue3 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(2))).floatValue();
        float fFloatValue4 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(3))).floatValue();
        return new Rectangle(Math.min(fFloatValue, fFloatValue3), Math.min(fFloatValue2, fFloatValue4), Math.max(fFloatValue, fFloatValue3), Math.max(fFloatValue2, fFloatValue4));
    }

    private static PRTokeniser getOffsetTokeniser(RandomAccessSource randomAccessSource) throws InvalidPdfException {
        PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(randomAccessSource));
        int headerOffset = pRTokeniser.getHeaderOffset();
        return headerOffset != 0 ? new PRTokeniser(new RandomAccessFileOrArray(new WindowRandomAccessSource(randomAccessSource, headerOffset))) : pRTokeniser;
    }

    public static PdfObject getPdfObject(PdfObject pdfObject) {
        PdfObject pdfBoolean;
        if (pdfObject == null) {
            return null;
        }
        if (!pdfObject.isIndirect()) {
            return pdfObject;
        }
        try {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            int number = pRIndirectReference.getNumber();
            boolean z = pRIndirectReference.getReader().appendable;
            PdfObject pdfObject2 = pRIndirectReference.getReader().getPdfObject(number);
            if (pdfObject2 == null) {
                return null;
            }
            if (z) {
                int iType = pdfObject2.type();
                if (iType != 1) {
                    if (iType == 4) {
                        pdfBoolean = new PdfName(pdfObject2.getBytes());
                    } else if (iType == 8) {
                        pdfObject2 = new PdfNull();
                    }
                    pdfObject2.setIndRef(pRIndirectReference);
                } else {
                    pdfBoolean = new PdfBoolean(((PdfBoolean) pdfObject2).booleanValue());
                }
                pdfObject2 = pdfBoolean;
                pdfObject2.setIndRef(pRIndirectReference);
            }
            return pdfObject2;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static PdfObject getPdfObjectRelease(PdfObject pdfObject) {
        PdfObject pdfObject2 = getPdfObject(pdfObject);
        releaseLastXrefPartial(pdfObject);
        return pdfObject2;
    }

    public static byte[] getStreamBytes(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) {
        return decodeBytes(getStreamBytesRaw(pRStream, randomAccessFileOrArray), pRStream);
    }

    public static byte[] getStreamBytesRaw(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) throws EOFException {
        PdfReader reader = pRStream.getReader();
        if (pRStream.getOffset() < 0) {
            return pRStream.getBytes();
        }
        byte[] bArr = new byte[pRStream.getLength()];
        randomAccessFileOrArray.seek(pRStream.getOffset());
        randomAccessFileOrArray.readFully(bArr);
        PdfEncryption decrypt = reader.getDecrypt();
        if (decrypt != null) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(pRStream.get(PdfName.FILTER));
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            if (pdfObjectRelease != null) {
                if (pdfObjectRelease.isName()) {
                    arrayList.add(pdfObjectRelease);
                } else if (pdfObjectRelease.isArray()) {
                    arrayList = ((PdfArray) pdfObjectRelease).getArrayList();
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                PdfObject pdfObjectRelease2 = getPdfObjectRelease(arrayList.get(i));
                if (pdfObjectRelease2 == null || !pdfObjectRelease2.toString().equals("/Crypt")) {
                }
            }
            decrypt.setHashKey(pRStream.getObjNum(), pRStream.getObjGen());
            return decrypt.decryptByteArray(bArr);
        }
        return bArr;
    }

    public static String getSubsetPrefix(PdfDictionary pdfDictionary) {
        String fontName;
        if (pdfDictionary == null || (fontName = getFontName(pdfDictionary)) == null || fontName.length() < 8 || fontName.charAt(6) != '+') {
            return null;
        }
        for (int i = 0; i < 6; i++) {
            char cCharAt = fontName.charAt(i);
            if (cCharAt < 'A' || cCharAt > 'Z') {
                return null;
            }
        }
        return fontName;
    }

    private void iterateBookmarks(PdfObject pdfObject, HashMap<Object, PdfObject> map) {
        while (pdfObject != null) {
            replaceNamedDestination(pdfObject, map);
            PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(pdfObject);
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.FIRST);
            if (pdfObject2 != null) {
                iterateBookmarks(pdfObject2, map);
            }
            pdfObject = pdfDictionary.get(PdfName.NEXT);
        }
    }

    public static PdfObject killIndirect(PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            return null;
        }
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfObject);
        if (pdfObject.isIndirect()) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader reader = pRIndirectReference.getReader();
            int number = pRIndirectReference.getNumber();
            reader.xrefObj.set(number, null);
            if (reader.partial) {
                reader.xref[number * 2] = -1;
            }
        }
        return pdfObjectRelease;
    }

    private void readDecryptedDocObj() throws InvalidPdfException, BadPasswordException {
        PdfObject pdfObject;
        byte[] iSOBytes;
        byte[] bArrDigest;
        int i;
        byte[] iSOBytes2;
        int i2;
        byte[] bArr;
        PdfArray pdfArray;
        int i3;
        int i4;
        byte[] content;
        boolean z;
        PdfObject pdfObject2;
        int i5;
        PdfDictionary asDict;
        PdfName asName;
        if (this.encrypted || (pdfObject = this.trailer.get(PdfName.ENCRYPT)) == null || pdfObject.toString().equals("null")) {
            return;
        }
        this.encryptionError = true;
        this.encrypted = true;
        PdfDictionary pdfDictionary = (PdfDictionary) getPdfObject(pdfObject);
        PdfName pdfName = PdfName.CF;
        PdfDictionary asDict2 = pdfDictionary.getAsDict(pdfName);
        if (asDict2 == null || (asDict = asDict2.getAsDict(PdfName.STDCF)) == null || (asName = asDict.getAsName(PdfName.AUTHEVENT)) == null || asName.compareTo(PdfName.EFOPEN) != 0 || this.ownerPasswordUsed) {
            PdfArray asArray = this.trailer.getAsArray(PdfName.ID);
            if (asArray != null) {
                PdfObject pdfObject3 = asArray.getPdfObject(0);
                this.strings.remove(pdfObject3);
                iSOBytes = DocWriter.getISOBytes(pdfObject3.toString());
                if (asArray.size() > 1) {
                    this.strings.remove(asArray.getPdfObject(1));
                }
            } else {
                iSOBytes = null;
            }
            if (iSOBytes == null) {
                iSOBytes = new byte[0];
            }
            PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.FILTER));
            int i6 = 2;
            if (pdfObjectRelease.equals(PdfName.STANDARD)) {
                PdfName pdfName2 = PdfName.U;
                String string = pdfDictionary.get(pdfName2).toString();
                this.strings.remove(pdfDictionary.get(pdfName2));
                byte[] iSOBytes3 = DocWriter.getISOBytes(string);
                PdfName pdfName3 = PdfName.O;
                String string2 = pdfDictionary.get(pdfName3).toString();
                this.strings.remove(pdfDictionary.get(pdfName3));
                iSOBytes2 = DocWriter.getISOBytes(string2);
                PdfName pdfName4 = PdfName.OE;
                if (pdfDictionary.contains(pdfName4)) {
                    this.strings.remove(pdfDictionary.get(pdfName4));
                }
                PdfName pdfName5 = PdfName.UE;
                if (pdfDictionary.contains(pdfName5)) {
                    this.strings.remove(pdfDictionary.get(pdfName5));
                }
                PdfName pdfName6 = PdfName.PERMS;
                if (pdfDictionary.contains(pdfName6)) {
                    this.strings.remove(pdfDictionary.get(pdfName6));
                }
                PdfObject pdfObject4 = pdfDictionary.get(PdfName.P);
                if (!pdfObject4.isNumber()) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.p.value", new Object[0]));
                }
                this.pValue = ((PdfNumber) pdfObject4).longValue();
                PdfObject pdfObject5 = pdfDictionary.get(PdfName.R);
                if (!pdfObject5.isNumber()) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.r.value", new Object[0]));
                }
                int iIntValue = ((PdfNumber) pdfObject5).intValue();
                this.rValue = iIntValue;
                if (iIntValue == 2) {
                    iSOBytes2 = iSOBytes2;
                    bArr = iSOBytes3;
                    bArrDigest = null;
                    i = 0;
                    i2 = 0;
                } else if (iIntValue == 3) {
                    PdfObject pdfObject6 = pdfDictionary.get(PdfName.LENGTH);
                    if (!pdfObject6.isNumber()) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                    }
                    int iIntValue2 = ((PdfNumber) pdfObject6).intValue();
                    if (iIntValue2 > 128 || iIntValue2 < 40 || iIntValue2 % 8 != 0) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                    }
                    i = iIntValue2;
                    iSOBytes2 = iSOBytes2;
                    bArr = iSOBytes3;
                    bArrDigest = null;
                    i2 = 1;
                } else if (iIntValue == 4) {
                    PdfDictionary pdfDictionary2 = (PdfDictionary) pdfDictionary.get(pdfName);
                    if (pdfDictionary2 == null) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("cf.not.found.encryption", new Object[0]));
                    }
                    PdfDictionary pdfDictionary3 = (PdfDictionary) pdfDictionary2.get(PdfName.STDCF);
                    if (pdfDictionary3 == null) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("stdcf.not.found.encryption", new Object[0]));
                    }
                    PdfName pdfName7 = PdfName.V2;
                    PdfName pdfName8 = PdfName.CFM;
                    if (pdfName7.equals(pdfDictionary3.get(pdfName8))) {
                        i6 = 1;
                    } else if (!PdfName.AESV2.equals(pdfDictionary3.get(pdfName8))) {
                        throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("no.compatible.encryption.found", new Object[0]));
                    }
                    PdfObject pdfObject7 = pdfDictionary.get(PdfName.ENCRYPTMETADATA);
                    i2 = (pdfObject7 == null || !pdfObject7.toString().equals(PdfBoolean.FALSE)) ? i6 : i6 | 8;
                    bArr = iSOBytes3;
                    bArrDigest = null;
                    i = 0;
                } else {
                    if (iIntValue != 5) {
                        throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("unknown.encryption.type.r.eq.1", this.rValue));
                    }
                    PdfObject pdfObject8 = pdfDictionary.get(PdfName.ENCRYPTMETADATA);
                    if (pdfObject8 == null || !pdfObject8.toString().equals(PdfBoolean.FALSE)) {
                        iSOBytes2 = iSOBytes2;
                        bArr = iSOBytes3;
                        bArrDigest = null;
                        i = 0;
                        i2 = 3;
                    } else {
                        iSOBytes2 = iSOBytes2;
                        bArr = iSOBytes3;
                        bArrDigest = null;
                        i = 0;
                        i2 = 11;
                    }
                }
            } else {
                if (pdfObjectRelease.equals(PdfName.PUBSEC)) {
                    PdfObject pdfObject9 = pdfDictionary.get(PdfName.V);
                    if (!pdfObject9.isNumber()) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.v.value", new Object[0]));
                    }
                    int iIntValue3 = ((PdfNumber) pdfObject9).intValue();
                    if (iIntValue3 == 1) {
                        pdfArray = (PdfArray) pdfDictionary.get(PdfName.RECIPIENTS);
                        i3 = 0;
                        i4 = 40;
                    } else if (iIntValue3 == 2) {
                        PdfObject pdfObject10 = pdfDictionary.get(PdfName.LENGTH);
                        if (!pdfObject10.isNumber()) {
                            throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                        }
                        int iIntValue4 = ((PdfNumber) pdfObject10).intValue();
                        if (iIntValue4 > 128 || iIntValue4 < 40 || iIntValue4 % 8 != 0) {
                            throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                        }
                        i4 = iIntValue4;
                        pdfArray = (PdfArray) pdfDictionary.get(PdfName.RECIPIENTS);
                        i3 = 1;
                    } else {
                        if (iIntValue3 != 4 && iIntValue3 != 5) {
                            throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("unknown.encryption.type.v.eq.1", iIntValue3));
                        }
                        PdfDictionary pdfDictionary4 = (PdfDictionary) pdfDictionary.get(pdfName);
                        if (pdfDictionary4 == null) {
                            throw new InvalidPdfException(MessageLocalization.getComposedMessage("cf.not.found.encryption", new Object[0]));
                        }
                        PdfDictionary pdfDictionary5 = (PdfDictionary) pdfDictionary4.get(PdfName.DEFAULTCRYPTFILTER);
                        if (pdfDictionary5 == null) {
                            throw new InvalidPdfException(MessageLocalization.getComposedMessage("defaultcryptfilter.not.found.encryption", new Object[0]));
                        }
                        PdfName pdfName9 = PdfName.V2;
                        PdfName pdfName10 = PdfName.CFM;
                        if (pdfName9.equals(pdfDictionary5.get(pdfName10))) {
                            i3 = 1;
                        } else {
                            if (PdfName.AESV2.equals(pdfDictionary5.get(pdfName10))) {
                                i3 = 2;
                            } else {
                                if (!PdfName.AESV3.equals(pdfDictionary5.get(pdfName10))) {
                                    throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("no.compatible.encryption.found", new Object[0]));
                                }
                                i3 = 3;
                                i4 = 256;
                            }
                            pdfObject2 = pdfDictionary5.get(PdfName.ENCRYPTMETADATA);
                            if (pdfObject2 != null && pdfObject2.toString().equals(PdfBoolean.FALSE)) {
                                i3 |= 8;
                            }
                            pdfArray = (PdfArray) pdfDictionary5.get(PdfName.RECIPIENTS);
                        }
                        i4 = 128;
                        pdfObject2 = pdfDictionary5.get(PdfName.ENCRYPTMETADATA);
                        if (pdfObject2 != null) {
                            i3 |= 8;
                        }
                        pdfArray = (PdfArray) pdfDictionary5.get(PdfName.RECIPIENTS);
                    }
                    try {
                        X509CertificateHolder x509CertificateHolder = new X509CertificateHolder(this.certificate.getEncoded());
                        if (this.externalDecryptionProcess == null) {
                            z = false;
                            content = null;
                            for (int i7 = 0; i7 < pdfArray.size(); i7++) {
                                PdfObject pdfObject11 = pdfArray.getPdfObject(i7);
                                this.strings.remove(pdfObject11);
                                try {
                                    for (RecipientInformation recipientInformation : new CMSEnvelopedData(pdfObject11.getBytes()).getRecipientInfos().getRecipients()) {
                                        if (recipientInformation.getRID().match(x509CertificateHolder) && !z) {
                                            content = PdfEncryptor.getContent(recipientInformation, (PrivateKey) this.certificateKey, this.certificateKeyProvider);
                                            z = true;
                                        }
                                    }
                                } catch (Exception e) {
                                    throw new ExceptionConverter(e);
                                }
                            }
                        } else {
                            boolean z2 = false;
                            content = null;
                            for (int i8 = 0; i8 < pdfArray.size(); i8++) {
                                PdfObject pdfObject12 = pdfArray.getPdfObject(i8);
                                this.strings.remove(pdfObject12);
                                try {
                                    RecipientInformation recipientInformation2 = new CMSEnvelopedData(pdfObject12.getBytes()).getRecipientInfos().get(this.externalDecryptionProcess.getCmsRecipientId());
                                    if (recipientInformation2 != null) {
                                        content = recipientInformation2.getContent(this.externalDecryptionProcess.getCmsRecipient());
                                        z2 = true;
                                    }
                                } catch (Exception e2) {
                                    throw new ExceptionConverter(e2);
                                }
                            }
                            z = z2;
                        }
                        if (!z || content == null) {
                            throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("bad.certificate.and.key", new Object[0]));
                        }
                        try {
                            MessageDigest messageDigest = (i3 & 7) == 3 ? MessageDigest.getInstance("SHA-256") : MessageDigest.getInstance(DigestAlgorithms.SHA1);
                            messageDigest.update(content, 0, 20);
                            for (int i9 = 0; i9 < pdfArray.size(); i9++) {
                                messageDigest.update(pdfArray.getPdfObject(i9).getBytes());
                            }
                            if ((i3 & 8) != 0) {
                                messageDigest.update(new byte[]{-1, -1, -1, -1});
                            }
                            bArrDigest = messageDigest.digest();
                            i2 = i3;
                            i = i4;
                            iSOBytes2 = null;
                        } catch (Exception e3) {
                            throw new ExceptionConverter(e3);
                        }
                    } catch (Exception e4) {
                        throw new ExceptionConverter(e4);
                    }
                } else {
                    bArrDigest = null;
                    i = 0;
                    iSOBytes2 = null;
                    i2 = 0;
                }
                bArr = null;
            }
            PdfEncryption pdfEncryption = new PdfEncryption();
            this.decrypt = pdfEncryption;
            pdfEncryption.setCryptoMode(i2, i);
            if (pdfObjectRelease.equals(PdfName.STANDARD)) {
                if (this.rValue == 5) {
                    this.ownerPasswordUsed = this.decrypt.readKey(pdfDictionary, this.password);
                    PdfEncryption pdfEncryption2 = this.decrypt;
                    pdfEncryption2.documentID = iSOBytes;
                    this.pValue = pdfEncryption2.getPermissions();
                } else {
                    this.decrypt.setupByOwnerPassword(iSOBytes, this.password, bArr, iSOBytes2, this.pValue);
                    byte[] bArr2 = this.decrypt.userKey;
                    int i10 = this.rValue;
                    int i11 = 16;
                    if (equalsArray(bArr, bArr2, (i10 == 3 || i10 == 4) ? 16 : 32)) {
                        i5 = 1;
                        this.ownerPasswordUsed = true;
                    } else {
                        this.decrypt.setupByUserPassword(iSOBytes, this.password, iSOBytes2, this.pValue);
                        byte[] bArr3 = this.decrypt.userKey;
                        int i12 = this.rValue;
                        if (i12 != 3 && i12 != 4) {
                            i11 = 32;
                        }
                        if (!equalsArray(bArr, bArr3, i11)) {
                            throw new BadPasswordException(MessageLocalization.getComposedMessage("bad.user.password", new Object[0]));
                        }
                    }
                }
                i5 = 1;
            } else if (pdfObjectRelease.equals(PdfName.PUBSEC)) {
                if ((i2 & 7) == 3) {
                    this.decrypt.setKey(bArrDigest);
                } else {
                    this.decrypt.setupByEncryptionKey(bArrDigest, i);
                }
                i5 = 1;
                this.ownerPasswordUsed = true;
            } else {
                i5 = 1;
            }
            for (int i13 = 0; i13 < this.strings.size(); i13 += i5) {
                this.strings.get(i13).decrypt(this);
            }
            if (pdfObject.isIndirect()) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                this.cryptoRef = pRIndirectReference;
                this.xrefObj.set(pRIndirectReference.getNumber(), null);
            }
            this.encryptionError = false;
        }
    }

    private boolean replaceNamedDestination(PdfObject pdfObject, HashMap<Object, PdfObject> map) {
        PdfObject string;
        PdfObject pdfObject2 = getPdfObject(pdfObject);
        int i = this.lastXrefPartial;
        releaseLastXrefPartial();
        if (pdfObject2 == null || !pdfObject2.isDictionary()) {
            return false;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject2;
        PdfName pdfName = PdfName.DEST;
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(pdfName));
        Object string2 = null;
        if (pdfObjectRelease != null) {
            if (!pdfObjectRelease.isName()) {
                if (pdfObjectRelease.isString()) {
                    string = pdfObjectRelease;
                    string = pdfObjectRelease.toString();
                } else {
                    string = pdfObjectRelease;
                    string = null;
                }
            }
            string = pdfObjectRelease;
            PdfArray pdfArray = (PdfArray) map.get(string);
            if (pdfArray == null) {
                return false;
            }
            pdfDictionary.put(pdfName, pdfArray);
            setXrefPartialObject(i, pdfObject2);
            return true;
        }
        PdfObject pdfObject3 = getPdfObject(pdfDictionary.get(PdfName.A));
        if (pdfObject3 == null) {
            return false;
        }
        int i2 = this.lastXrefPartial;
        releaseLastXrefPartial();
        PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject3;
        if (!PdfName.GOTO.equals((PdfName) getPdfObjectRelease(pdfDictionary2.get(PdfName.S)))) {
            return false;
        }
        PdfName pdfName2 = PdfName.D;
        PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfDictionary2.get(pdfName2));
        if (pdfObjectRelease2 != null) {
            if (pdfObjectRelease2.isName()) {
                string2 = pdfObjectRelease2;
            } else if (pdfObjectRelease2.isString()) {
                string2 = pdfObjectRelease2.toString();
            }
        }
        PdfArray pdfArray2 = (PdfArray) map.get(string2);
        if (pdfArray2 == null) {
            return false;
        }
        pdfDictionary2.put(pdfName2, pdfArray2);
        setXrefPartialObject(i2, pdfObject3);
        setXrefPartialObject(i, pdfObject2);
        return true;
    }

    private void setXrefPartialObject(int i, PdfObject pdfObject) {
        if (!this.partial || i < 0) {
            return;
        }
        this.xrefObj.set(i, pdfObject);
    }

    public PRIndirectReference addPdfObject(PdfObject pdfObject) {
        this.xrefObj.add(pdfObject);
        return new PRIndirectReference(this, this.xrefObj.size() - 1);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
        setViewerPreferences(this.viewerPreferences);
    }

    public void close() {
        try {
            this.tokens.close();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public byte[] computeUserPassword() {
        if (this.encrypted && this.ownerPasswordUsed) {
            return this.decrypt.computeUserPassword(this.password);
        }
        return null;
    }

    public void consolidateNamedDestinations() {
        if (this.consolidateNamedDestinations) {
            return;
        }
        this.consolidateNamedDestinations = true;
        HashMap<Object, PdfObject> namedDestination = getNamedDestination(true);
        if (namedDestination.isEmpty()) {
            return;
        }
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfObject pdfObject = this.pageRefs.getPageN(i).get(PdfName.ANNOTS);
            PdfArray pdfArray = (PdfArray) getPdfObject(pdfObject);
            int i2 = this.lastXrefPartial;
            releaseLastXrefPartial();
            if (pdfArray == null) {
                this.pageRefs.releasePage(i);
            } else {
                boolean z = false;
                for (int i3 = 0; i3 < pdfArray.size(); i3++) {
                    PdfObject pdfObject2 = pdfArray.getPdfObject(i3);
                    if (replaceNamedDestination(pdfObject2, namedDestination) && !pdfObject2.isIndirect()) {
                        z = true;
                    }
                }
                if (z) {
                    setXrefPartialObject(i2, pdfArray);
                }
                if (!z || pdfObject.isIndirect()) {
                    this.pageRefs.releasePage(i);
                }
            }
        }
        PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.OUTLINES));
        if (pdfDictionary == null) {
            return;
        }
        iterateBookmarks(pdfDictionary.get(PdfName.FIRST), namedDestination);
    }

    public int createFakeFontSubsets() {
        String fontName;
        int i = 0;
        for (int i2 = 1; i2 < this.xrefObj.size(); i2++) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(i2);
            if (pdfObjectRelease != null && pdfObjectRelease.isDictionary()) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObjectRelease;
                if (existsName(pdfDictionary, PdfName.TYPE, PdfName.FONT)) {
                    PdfName pdfName = PdfName.SUBTYPE;
                    if ((existsName(pdfDictionary, pdfName, PdfName.TYPE1) || existsName(pdfDictionary, pdfName, PdfName.MMTYPE1) || existsName(pdfDictionary, pdfName, PdfName.TRUETYPE)) && getSubsetPrefix(pdfDictionary) == null && (fontName = getFontName(pdfDictionary)) != null) {
                        String str = BaseFont.createSubsetPrefix() + fontName;
                        PdfName pdfName2 = PdfName.FONTDESCRIPTOR;
                        PdfDictionary pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(pdfDictionary.get(pdfName2));
                        if (pdfDictionary2 != null && (pdfDictionary2.get(PdfName.FONTFILE) != null || pdfDictionary2.get(PdfName.FONTFILE2) != null || pdfDictionary2.get(PdfName.FONTFILE3) != null)) {
                            PdfDictionary asDict = pdfDictionary.getAsDict(pdfName2);
                            PdfName pdfName3 = new PdfName(str);
                            pdfDictionary.put(PdfName.BASEFONT, pdfName3);
                            asDict.put(PdfName.FONTNAME, pdfName3);
                            setXrefPartialObject(i2, pdfDictionary);
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public double dumpPerc() {
        int i = 0;
        for (int i2 = 0; i2 < this.xrefObj.size(); i2++) {
            if (this.xrefObj.get(i2) != null) {
                i++;
            }
        }
        return (((double) i) * 100.0d) / ((double) this.xrefObj.size());
    }

    public void eliminateSharedStreams() {
        if (this.sharedStreams) {
            this.sharedStreams = false;
            if (this.pageRefs.size() == 1) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            IntHashtable intHashtable = new IntHashtable();
            for (int i = 1; i <= this.pageRefs.size(); i++) {
                PdfDictionary pageN = this.pageRefs.getPageN(i);
                if (pageN != null) {
                    PdfName pdfName = PdfName.CONTENTS;
                    PdfObject pdfObject = getPdfObject(pageN.get(pdfName));
                    if (pdfObject != null) {
                        if (pdfObject.isStream()) {
                            PRIndirectReference pRIndirectReference = (PRIndirectReference) pageN.get(pdfName);
                            if (intHashtable.containsKey(pRIndirectReference.getNumber())) {
                                arrayList.add(pRIndirectReference);
                                arrayList2.add(new PRStream((PRStream) pdfObject, (PdfDictionary) null));
                            } else {
                                intHashtable.put(pRIndirectReference.getNumber(), 1);
                            }
                        } else if (pdfObject.isArray()) {
                            PdfArray pdfArray = (PdfArray) pdfObject;
                            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                                PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfArray.getPdfObject(i2);
                                if (intHashtable.containsKey(pRIndirectReference2.getNumber())) {
                                    arrayList.add(pRIndirectReference2);
                                    arrayList2.add(new PRStream((PRStream) getPdfObject(pRIndirectReference2), (PdfDictionary) null));
                                } else {
                                    intHashtable.put(pRIndirectReference2.getNumber(), 1);
                                }
                            }
                        }
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                this.xrefObj.add((PdfObject) arrayList2.get(i3));
                ((PRIndirectReference) arrayList.get(i3)).setNumber(this.xrefObj.size() - 1, 0);
            }
        }
    }

    public AcroFields getAcroFields() {
        return new AcroFields(this, null);
    }

    public PRAcroForm getAcroForm() {
        if (!this.acroFormParsed) {
            this.acroFormParsed = true;
            PdfObject pdfObject = this.catalog.get(PdfName.ACROFORM);
            if (pdfObject != null) {
                try {
                    PRAcroForm pRAcroForm = new PRAcroForm(this);
                    this.acroForm = pRAcroForm;
                    pRAcroForm.readAcroForm((PdfDictionary) getPdfObject(pdfObject));
                } catch (Exception unused) {
                    this.acroForm = null;
                }
            }
        }
        return this.acroForm;
    }

    public Rectangle getBoxSize(int i, String str) {
        PdfArray pdfArray;
        PdfDictionary pageNRelease = this.pageRefs.getPageNRelease(i);
        if (str.equals("trim")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.TRIMBOX));
        } else if (str.equals("art")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.ARTBOX));
        } else if (str.equals("bleed")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.BLEEDBOX));
        } else if (str.equals("crop")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.CROPBOX));
        } else {
            pdfArray = str.equals("media") ? (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.MEDIABOX)) : null;
        }
        if (pdfArray == null) {
            return null;
        }
        return getNormalizedRectangle(pdfArray);
    }

    public PdfDictionary getCatalog() {
        return this.catalog;
    }

    public int getCertificationLevel() {
        PdfDictionary asDict;
        PdfArray asArray;
        PdfDictionary asDict2;
        PdfDictionary asDict3;
        PdfNumber asNumber;
        PdfDictionary asDict4 = this.catalog.getAsDict(PdfName.PERMS);
        if (asDict4 == null || (asDict = asDict4.getAsDict(PdfName.DOCMDP)) == null || (asArray = asDict.getAsArray(PdfName.REFERENCE)) == null || asArray.size() == 0 || (asDict2 = asArray.getAsDict(0)) == null || (asDict3 = asDict2.getAsDict(PdfName.TRANSFORMPARAMS)) == null || (asNumber = asDict3.getAsNumber(PdfName.P)) == null) {
            return 0;
        }
        return asNumber.intValue();
    }

    public Counter getCounter() {
        return COUNTER;
    }

    public Rectangle getCropBox(int i) {
        PdfDictionary pageNRelease = this.pageRefs.getPageNRelease(i);
        PdfArray pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.CROPBOX));
        return pdfArray == null ? getPageSize(pageNRelease) : getNormalizedRectangle(pdfArray);
    }

    public int getCryptoMode() {
        PdfEncryption pdfEncryption = this.decrypt;
        if (pdfEncryption == null) {
            return -1;
        }
        return pdfEncryption.getCryptoMode();
    }

    public PdfIndirectReference getCryptoRef() {
        PRIndirectReference pRIndirectReference = this.cryptoRef;
        if (pRIndirectReference == null) {
            return null;
        }
        return new PdfIndirectReference(0, pRIndirectReference.getNumber(), this.cryptoRef.getGeneration());
    }

    public PdfEncryption getDecrypt() {
        return this.decrypt;
    }

    public long getEofPos() {
        return this.eofPos;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public HashMap<String, String> getInfo() {
        HashMap<String, String> map = new HashMap<>();
        PdfDictionary asDict = this.trailer.getAsDict(PdfName.INFO);
        if (asDict == null) {
            return map;
        }
        for (PdfName pdfName : asDict.getKeys()) {
            PdfObject pdfObject = getPdfObject(asDict.get(pdfName));
            if (pdfObject != null) {
                String string = pdfObject.toString();
                int iType = pdfObject.type();
                if (iType == 3) {
                    string = ((PdfString) pdfObject).toUnicodeString();
                } else if (iType == 4) {
                    string = PdfName.decodeName(string);
                }
                map.put(PdfName.decodeName(pdfName.toString()), string);
            }
        }
        return map;
    }

    public String getJavaScript(RandomAccessFileOrArray randomAccessFileOrArray) {
        PdfDictionary pdfDictionary;
        PdfObject pdfObjectRelease;
        PdfDictionary pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.NAMES));
        if (pdfDictionary2 == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(pdfDictionary2.get(PdfName.JAVASCRIPT))) == null) {
            return null;
        }
        HashMap<String, PdfObject> tree = PdfNameTree.readTree(pdfDictionary);
        String[] strArr = (String[]) tree.keySet().toArray(new String[tree.size()]);
        Arrays.sort(strArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strArr) {
            PdfDictionary pdfDictionary3 = (PdfDictionary) getPdfObjectRelease(tree.get(str));
            if (pdfDictionary3 != null && (pdfObjectRelease = getPdfObjectRelease(pdfDictionary3.get(PdfName.JS))) != null) {
                if (pdfObjectRelease.isString()) {
                    stringBuffer.append(((PdfString) pdfObjectRelease).toUnicodeString());
                    stringBuffer.append('\n');
                } else if (pdfObjectRelease.isStream()) {
                    byte[] streamBytes = getStreamBytes((PRStream) pdfObjectRelease, randomAccessFileOrArray);
                    if (streamBytes.length >= 2 && streamBytes[0] == -2 && streamBytes[1] == -1) {
                        stringBuffer.append(PdfEncodings.convertToString(streamBytes, PdfObject.TEXT_UNICODE));
                    } else {
                        stringBuffer.append(PdfEncodings.convertToString(streamBytes, PdfObject.TEXT_PDFDOCENCODING));
                    }
                    stringBuffer.append('\n');
                }
            }
        }
        return stringBuffer.toString();
    }

    public long getLastXref() {
        return this.lastXref;
    }

    public ArrayList<PdfAnnotation.PdfImportedLink> getLinks(int i) {
        this.pageRefs.resetReleasePage();
        ArrayList<PdfAnnotation.PdfImportedLink> arrayList = new ArrayList<>();
        PdfDictionary pageN = this.pageRefs.getPageN(i);
        PdfName pdfName = PdfName.ANNOTS;
        if (pageN.get(pdfName) != null) {
            PdfArray asArray = pageN.getAsArray(pdfName);
            for (int i2 = 0; i2 < asArray.size(); i2++) {
                PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(asArray.getPdfObject(i2));
                if (PdfName.LINK.equals(pdfDictionary.get(PdfName.SUBTYPE))) {
                    arrayList.add(new PdfAnnotation.PdfImportedLink(pdfDictionary));
                }
            }
        }
        this.pageRefs.releasePage(i);
        this.pageRefs.resetReleasePage();
        return arrayList;
    }

    public byte[] getMetadata() {
        PdfObject pdfObject = getPdfObject(this.catalog.get(PdfName.METADATA));
        if (!(pdfObject instanceof PRStream)) {
            return null;
        }
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytes((PRStream) pdfObject, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public HashMap<Object, PdfObject> getNamedDestination() {
        return getNamedDestination(false);
    }

    public HashMap<String, PdfObject> getNamedDestinationFromNames() {
        return new HashMap<>(getNamedDestinationFromNames(false));
    }

    public HashMap<String, PdfObject> getNamedDestinationFromStrings() {
        PdfDictionary pdfDictionary;
        PdfDictionary pdfDictionary2;
        PdfDictionary pdfDictionary3 = this.catalog;
        PdfName pdfName = PdfName.NAMES;
        if (pdfDictionary3.get(pdfName) == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(pdfName))) == null || (pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(pdfDictionary.get(PdfName.DESTS))) == null) {
            return new HashMap<>();
        }
        HashMap<String, PdfObject> tree = PdfNameTree.readTree(pdfDictionary2);
        Iterator<Map.Entry<String, PdfObject>> it = tree.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, PdfObject> next = it.next();
            PdfArray nameArray = getNameArray(next.getValue());
            if (nameArray != null) {
                next.setValue(nameArray);
            } else {
                it.remove();
            }
        }
        return tree;
    }

    public int getNumberOfPages() {
        return this.pageRefs.size();
    }

    public byte[] getPageContent(int i, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfDictionary pageNRelease = getPageNRelease(i);
        if (pageNRelease == null) {
            return null;
        }
        PdfObject pdfObjectRelease = getPdfObjectRelease(pageNRelease.get(PdfName.CONTENTS));
        if (pdfObjectRelease == null) {
            return new byte[0];
        }
        if (pdfObjectRelease.isStream()) {
            return getStreamBytes((PRStream) pdfObjectRelease, randomAccessFileOrArray);
        }
        if (!pdfObjectRelease.isArray()) {
            return new byte[0];
        }
        PdfArray pdfArray = (PdfArray) pdfObjectRelease;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < pdfArray.size(); i2++) {
            PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfArray.getPdfObject(i2));
            if (pdfObjectRelease2 != null && pdfObjectRelease2.isStream()) {
                byteArrayOutputStream.write(getStreamBytes((PRStream) pdfObjectRelease2, randomAccessFileOrArray));
                if (i2 != pdfArray.size() - 1) {
                    byteArrayOutputStream.write(10);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public PdfDictionary getPageN(int i) {
        PdfDictionary pageN = this.pageRefs.getPageN(i);
        if (pageN == null) {
            return null;
        }
        if (this.appendable) {
            pageN.setIndRef(this.pageRefs.getPageOrigRef(i));
        }
        return pageN;
    }

    public PdfDictionary getPageNRelease(int i) {
        PdfDictionary pageN = getPageN(i);
        this.pageRefs.releasePage(i);
        return pageN;
    }

    public PRIndirectReference getPageOrigRef(int i) {
        return this.pageRefs.getPageOrigRef(i);
    }

    public PdfDictionary getPageResources(int i) {
        return getPageResources(getPageN(i));
    }

    public int getPageRotation(int i) {
        return getPageRotation(this.pageRefs.getPageNRelease(i));
    }

    public Rectangle getPageSize(int i) {
        return getPageSize(this.pageRefs.getPageNRelease(i));
    }

    public Rectangle getPageSizeWithRotation(int i) {
        return getPageSizeWithRotation(this.pageRefs.getPageNRelease(i));
    }

    public PdfReaderInstance getPdfReaderInstance(PdfWriter pdfWriter) {
        return new PdfReaderInstance(this, pdfWriter);
    }

    public char getPdfVersion() {
        return this.pdfVersion;
    }

    public long getPermissions() {
        return this.pValue;
    }

    public RandomAccessFileOrArray getSafeFile() {
        return this.tokens.getSafeFile();
    }

    public int getSimpleViewerPreferences() {
        return PdfViewerPreferencesImp.getViewerPreferences(this.catalog).getPageLayoutAndMode();
    }

    public PdfDictionary getTrailer() {
        return this.trailer;
    }

    public int getXrefSize() {
        return this.xrefObj.size();
    }

    public boolean hasUsageRights() {
        PdfDictionary asDict = this.catalog.getAsDict(PdfName.PERMS);
        if (asDict == null) {
            return false;
        }
        return asDict.contains(PdfName.UR) || asDict.contains(PdfName.UR3);
    }

    public boolean is128Key() {
        return this.rValue == 3;
    }

    public boolean isAppendable() {
        return this.appendable;
    }

    public boolean isEncrypted() {
        return this.encrypted;
    }

    public boolean isHybridXref() {
        return this.hybridXref;
    }

    public boolean isMetadataEncrypted() {
        PdfEncryption pdfEncryption = this.decrypt;
        if (pdfEncryption == null) {
            return false;
        }
        return pdfEncryption.isMetadataEncrypted();
    }

    public boolean isNewXrefType() {
        return this.newXrefType;
    }

    public final boolean isOpenedWithFullPermissions() {
        return !this.encrypted || this.ownerPasswordUsed || unethicalreading;
    }

    public boolean isRebuilt() {
        return this.rebuilt;
    }

    public boolean isTagged() {
        PdfDictionary asDict = this.catalog.getAsDict(PdfName.MARKINFO);
        return (asDict == null || !PdfBoolean.PDFTRUE.equals(asDict.getAsBoolean(PdfName.MARKED)) || this.catalog.getAsDict(PdfName.STRUCTTREEROOT) == null) ? false : true;
    }

    public boolean isTampered() {
        return this.tampered;
    }

    public void killXref(PdfObject pdfObject) {
        if (pdfObject == null) {
            return;
        }
        if (!(pdfObject instanceof PdfIndirectReference) || pdfObject.isIndirect()) {
            int iType = pdfObject.type();
            if (iType == 5) {
                PdfArray pdfArray = (PdfArray) pdfObject;
                for (int i = 0; i < pdfArray.size(); i++) {
                    killXref(pdfArray.getPdfObject(i));
                }
                return;
            }
            if (iType == 6 || iType == 7) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                Iterator<PdfName> it = pdfDictionary.getKeys().iterator();
                while (it.hasNext()) {
                    killXref(pdfDictionary.get(it.next()));
                }
                return;
            }
            if (iType != 10) {
                return;
            }
            int number = ((PRIndirectReference) pdfObject).getNumber();
            PdfObject pdfObject2 = this.xrefObj.get(number);
            this.xrefObj.set(number, null);
            this.freeXref = number;
            killXref(pdfObject2);
        }
    }

    public void makeRemoteNamedDestinationsLocal() {
        if (this.remoteToLocalNamedDestinations) {
            return;
        }
        this.remoteToLocalNamedDestinations = true;
        HashMap<Object, PdfObject> namedDestination = getNamedDestination(true);
        if (namedDestination.isEmpty()) {
            return;
        }
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfObject pdfObject = this.pageRefs.getPageN(i).get(PdfName.ANNOTS);
            PdfArray pdfArray = (PdfArray) getPdfObject(pdfObject);
            int i2 = this.lastXrefPartial;
            releaseLastXrefPartial();
            if (pdfArray == null) {
                this.pageRefs.releasePage(i);
            } else {
                boolean z = false;
                for (int i3 = 0; i3 < pdfArray.size(); i3++) {
                    PdfObject pdfObject2 = pdfArray.getPdfObject(i3);
                    if (convertNamedDestination(pdfObject2, namedDestination) && !pdfObject2.isIndirect()) {
                        z = true;
                    }
                }
                if (z) {
                    setXrefPartialObject(i2, pdfArray);
                }
                if (!z || pdfObject.isIndirect()) {
                    this.pageRefs.releasePage(i);
                }
            }
        }
    }

    public PdfArray readArray() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject pRObject = readPRObject();
            int i = -pRObject.type();
            if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return pdfArray;
            }
            if (i == PRTokeniser.TokenType.END_DIC.ordinal()) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
            }
            pdfArray.add(pRObject);
        }
    }

    public PdfDictionary readDictionary() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (true) {
            this.tokens.nextValidToken();
            PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
            PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.END_DIC;
            if (tokenType == tokenType2) {
                return pdfDictionary;
            }
            if (this.tokens.getTokenType() != PRTokeniser.TokenType.NAME) {
                PRTokeniser pRTokeniser = this.tokens;
                pRTokeniser.throwError(MessageLocalization.getComposedMessage("dictionary.key.1.is.not.a.name", pRTokeniser.getStringValue()));
            }
            PdfName pdfName = new PdfName(this.tokens.getStringValue(), false);
            PdfObject pRObject = readPRObject();
            int i = -pRObject.type();
            if (i == tokenType2.ordinal()) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
            }
            if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("unexpected.close.bracket", new Object[0]));
            }
            pdfDictionary.put(pdfName, pRObject);
        }
    }

    public void readDocObj() throws IOException {
        PdfObject pRObject;
        ArrayList arrayList = new ArrayList();
        int i = 2;
        ArrayList<PdfObject> arrayList2 = new ArrayList<>(this.xref.length / 2);
        this.xrefObj = arrayList2;
        arrayList2.addAll(Collections.nCopies(this.xref.length / 2, null));
        while (true) {
            long[] jArr = this.xref;
            if (i >= jArr.length) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    checkPRStreamLength((PRStream) arrayList.get(i2));
                }
                readDecryptedDocObj();
                HashMap<Integer, IntHashtable> map = this.objStmMark;
                if (map != null) {
                    for (Map.Entry<Integer, IntHashtable> entry : map.entrySet()) {
                        int iIntValue = entry.getKey().intValue();
                        readObjStm((PRStream) this.xrefObj.get(iIntValue), entry.getValue());
                        this.xrefObj.set(iIntValue, null);
                    }
                    this.objStmMark = null;
                }
                this.xref = null;
                return;
            }
            long j = jArr[i];
            if (j > 0 && jArr[i + 1] <= 0) {
                this.tokens.seek(j);
                this.tokens.nextValidToken();
                PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
                PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.NUMBER;
                if (tokenType != tokenType2) {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.object.number", new Object[0]));
                }
                this.objNum = this.tokens.intValue();
                this.tokens.nextValidToken();
                if (this.tokens.getTokenType() != tokenType2) {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.generation.number", new Object[0]));
                }
                this.objGen = this.tokens.intValue();
                this.tokens.nextValidToken();
                if (!this.tokens.getStringValue().equals("obj")) {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("token.obj.expected", new Object[0]));
                }
                try {
                    pRObject = readPRObject();
                    if (pRObject.isStream()) {
                        arrayList.add((PRStream) pRObject);
                    }
                } catch (IOException e) {
                    if (!debugmode) {
                        throw e;
                    }
                    Logger logger = LOGGER;
                    if (logger.isLogging(Level.ERROR)) {
                        logger.error(e.getMessage(), e);
                    }
                    pRObject = null;
                }
                this.xrefObj.set(i / 2, pRObject);
            }
            i += 2;
        }
    }

    public void readDocObjPartial() throws InvalidPdfException, BadPasswordException {
        ArrayList<PdfObject> arrayList = new ArrayList<>(this.xref.length / 2);
        this.xrefObj = arrayList;
        arrayList.addAll(Collections.nCopies(this.xref.length / 2, null));
        readDecryptedDocObj();
        LongHashtable longHashtable = this.objStmToOffset;
        if (longHashtable != null) {
            for (long j : longHashtable.getKeys()) {
                int i = (int) (2 * j);
                this.objStmToOffset.put(j, this.xref[i]);
                this.xref[i] = -1;
            }
        }
    }

    public void readObjStm(PRStream pRStream, IntHashtable intHashtable) {
        PdfObject pRObject;
        if (pRStream == null) {
            return;
        }
        int iIntValue = pRStream.getAsNumber(PdfName.FIRST).intValue();
        int iIntValue2 = pRStream.getAsNumber(PdfName.N).intValue();
        byte[] streamBytes = getStreamBytes(pRStream, this.tokens.getFile());
        PRTokeniser pRTokeniser = this.tokens;
        this.tokens = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(streamBytes)));
        try {
            int[] iArr = new int[iIntValue2];
            int[] iArr2 = new int[iIntValue2];
            boolean zNextToken = true;
            for (int i = 0; i < iIntValue2; i++) {
                zNextToken = this.tokens.nextToken();
                if (!zNextToken) {
                    break;
                }
                PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
                PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.NUMBER;
                if (tokenType == tokenType2) {
                    iArr2[i] = this.tokens.intValue();
                    zNextToken = this.tokens.nextToken();
                    if (!zNextToken) {
                        break;
                    } else if (this.tokens.getTokenType() == tokenType2) {
                        iArr[i] = this.tokens.intValue() + iIntValue;
                    }
                }
                zNextToken = false;
                break;
            }
            if (!zNextToken) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("error.reading.objstm", new Object[0]));
            }
            for (int i2 = 0; i2 < iIntValue2; i2++) {
                if (intHashtable.containsKey(i2)) {
                    this.tokens.seek(iArr[i2]);
                    this.tokens.nextToken();
                    if (this.tokens.getTokenType() == PRTokeniser.TokenType.NUMBER) {
                        pRObject = new PdfNumber(this.tokens.getStringValue());
                    } else {
                        this.tokens.seek(iArr[i2]);
                        pRObject = readPRObject();
                    }
                    this.xrefObj.set(iArr2[i2], pRObject);
                }
            }
            this.tokens = pRTokeniser;
        } catch (Throwable th) {
            this.tokens = pRTokeniser;
            throw th;
        }
    }

    public PdfObject readOneObjStm(PRStream pRStream, int i) {
        PdfObject pRObject;
        int iIntValue = pRStream.getAsNumber(PdfName.FIRST).intValue();
        byte[] streamBytes = getStreamBytes(pRStream, this.tokens.getFile());
        PRTokeniser pRTokeniser = this.tokens;
        this.tokens = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(streamBytes)));
        boolean zNextToken = true;
        int i2 = i + 1;
        int iIntValue2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                zNextToken = this.tokens.nextToken();
                if (!zNextToken) {
                    break;
                }
                PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
                PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.NUMBER;
                if (tokenType == tokenType2) {
                    zNextToken = this.tokens.nextToken();
                    if (!zNextToken) {
                        break;
                    }
                    if (this.tokens.getTokenType() == tokenType2) {
                        iIntValue2 = this.tokens.intValue() + iIntValue;
                    }
                }
                zNextToken = false;
                break;
            } catch (Throwable th) {
                this.tokens = pRTokeniser;
                throw th;
            }
        }
        if (!zNextToken) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("error.reading.objstm", new Object[0]));
        }
        long j = iIntValue2;
        this.tokens.seek(j);
        this.tokens.nextToken();
        if (this.tokens.getTokenType() == PRTokeniser.TokenType.NUMBER) {
            pRObject = new PdfNumber(this.tokens.getStringValue());
        } else {
            this.tokens.seek(j);
            pRObject = readPRObject();
        }
        this.tokens = pRTokeniser;
        return pRObject;
    }

    public PdfObject readPRObject() throws IOException {
        boolean zNextToken;
        this.tokens.nextValidToken();
        PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
        switch (AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[tokenType.ordinal()]) {
            case 1:
                this.readDepth++;
                PdfDictionary dictionary = readDictionary();
                this.readDepth--;
                long filePointer = this.tokens.getFilePointer();
                do {
                    zNextToken = this.tokens.nextToken();
                    if (zNextToken) {
                    }
                    if (zNextToken || !this.tokens.getStringValue().equals("stream")) {
                        this.tokens.seek(filePointer);
                        return dictionary;
                    }
                    while (true) {
                        int i = this.tokens.read();
                        if (i != 32 && i != 9 && i != 0 && i != 12) {
                            if (i != 10) {
                                i = this.tokens.read();
                            }
                            if (i != 10) {
                                this.tokens.backOnePosition(i);
                            }
                            PRStream pRStream = new PRStream(this, this.tokens.getFilePointer());
                            pRStream.putAll(dictionary);
                            pRStream.setObjNum(this.objNum, this.objGen);
                            return pRStream;
                        }
                    }
                } while (this.tokens.getTokenType() == PRTokeniser.TokenType.COMMENT);
                if (zNextToken) {
                }
                this.tokens.seek(filePointer);
                return dictionary;
            case 2:
                this.readDepth++;
                PdfArray array = readArray();
                this.readDepth--;
                return array;
            case 3:
                return new PdfNumber(this.tokens.getStringValue());
            case 4:
                PdfString hexWriting = new PdfString(this.tokens.getStringValue(), null).setHexWriting(this.tokens.isHexString());
                hexWriting.setObjNum(this.objNum, this.objGen);
                ArrayList<PdfString> arrayList = this.strings;
                if (arrayList != null) {
                    arrayList.add(hexWriting);
                }
                return hexWriting;
            case 5:
                PdfName pdfName = PdfName.staticNames.get(this.tokens.getStringValue());
                return (this.readDepth <= 0 || pdfName == null) ? new PdfName(this.tokens.getStringValue(), false) : pdfName;
            case 6:
                return new PRIndirectReference(this, this.tokens.getReference(), this.tokens.getGeneration());
            case 7:
                throw new IOException(MessageLocalization.getComposedMessage("unexpected.end.of.file", new Object[0]));
            default:
                String stringValue = this.tokens.getStringValue();
                if ("null".equals(stringValue)) {
                    return this.readDepth == 0 ? new PdfNull() : PdfNull.PDFNULL;
                }
                if (PdfBoolean.TRUE.equals(stringValue)) {
                    return this.readDepth == 0 ? new PdfBoolean(true) : PdfBoolean.PDFTRUE;
                }
                if (PdfBoolean.FALSE.equals(stringValue)) {
                    return this.readDepth == 0 ? new PdfBoolean(false) : PdfBoolean.PDFFALSE;
                }
                return new PdfLiteral(-tokenType.ordinal(), this.tokens.getStringValue());
        }
    }

    public void readPages() throws InvalidPdfException {
        PdfDictionary asDict = this.trailer.getAsDict(PdfName.ROOT);
        this.catalog = asDict;
        if (asDict == null) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("the.document.has.no.catalog.object", new Object[0]));
        }
        PdfName pdfName = PdfName.PAGES;
        PdfDictionary asDict2 = asDict.getAsDict(pdfName);
        this.rootPages = asDict2;
        if (asDict2 == null || (!pdfName.equals(asDict2.get(PdfName.TYPE)) && !pdfName.equals(this.rootPages.get(new PdfName("Types"))))) {
            if (!debugmode) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("the.document.has.no.page.root", new Object[0]));
            }
            Logger logger = LOGGER;
            if (logger.isLogging(Level.ERROR)) {
                logger.error(MessageLocalization.getComposedMessage("the.document.has.no.page.root", new Object[0]));
            }
        }
        this.pageRefs = new PageRefs(this, (AnonymousClass1) null);
    }

    public void readPdf() throws InvalidPdfException, BadPasswordException {
        this.fileLength = this.tokens.getFile().length();
        this.pdfVersion = this.tokens.checkPdfHeader();
        try {
            readXref();
        } catch (Exception e) {
            try {
                this.rebuilt = true;
                rebuildXref();
                this.lastXref = -1L;
            } catch (Exception e2) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("rebuild.failed.1.original.message.2", e2.getMessage(), e.getMessage()));
            }
        }
        try {
            readDocObj();
        } catch (Exception e3) {
            if (e3 instanceof BadPasswordException) {
                throw new BadPasswordException(e3.getMessage());
            }
            if (this.rebuilt || this.encryptionError) {
                throw new InvalidPdfException(e3.getMessage());
            }
            this.rebuilt = true;
            this.encrypted = false;
            try {
                rebuildXref();
                this.lastXref = -1L;
                readDocObj();
            } catch (Exception e4) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("rebuild.failed.1.original.message.2", e4.getMessage(), e3.getMessage()));
            }
        }
        this.strings.clear();
        readPages();
        removeUnusedObjects();
    }

    public void readPdfPartial() throws InvalidPdfException, BadPasswordException {
        this.fileLength = this.tokens.getFile().length();
        this.pdfVersion = this.tokens.checkPdfHeader();
        try {
            readXref();
        } catch (Exception e) {
            try {
                this.rebuilt = true;
                rebuildXref();
                this.lastXref = -1L;
            } catch (Exception e2) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("rebuild.failed.1.original.message.2", e2.getMessage(), e.getMessage()), e2);
            }
        }
        readDocObjPartial();
        readPages();
    }

    public PdfObject readSingleObject(int i) throws IOException {
        this.strings.clear();
        int i2 = i * 2;
        long[] jArr = this.xref;
        long j = jArr[i2];
        PdfObject oneObjStm = null;
        if (j < 0) {
            return null;
        }
        int i3 = i2 + 1;
        long j2 = jArr[i3];
        if (j2 > 0) {
            j = this.objStmToOffset.get(j2);
        }
        if (j == 0) {
            return null;
        }
        this.tokens.seek(j);
        this.tokens.nextValidToken();
        PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
        PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.NUMBER;
        if (tokenType != tokenType2) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.object.number", new Object[0]));
        }
        this.objNum = this.tokens.intValue();
        this.tokens.nextValidToken();
        if (this.tokens.getTokenType() != tokenType2) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.generation.number", new Object[0]));
        }
        this.objGen = this.tokens.intValue();
        this.tokens.nextValidToken();
        if (!this.tokens.getStringValue().equals("obj")) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("token.obj.expected", new Object[0]));
        }
        try {
            PdfObject pRObject = readPRObject();
            for (int i4 = 0; i4 < this.strings.size(); i4++) {
                this.strings.get(i4).decrypt(this);
            }
            if (pRObject.isStream()) {
                checkPRStreamLength((PRStream) pRObject);
            }
            oneObjStm = pRObject;
        } catch (IOException e) {
            if (!debugmode) {
                throw e;
            }
            Logger logger = LOGGER;
            if (logger.isLogging(Level.ERROR)) {
                logger.error(e.getMessage(), e);
            }
        }
        long[] jArr2 = this.xref;
        if (jArr2[i3] > 0) {
            oneObjStm = readOneObjStm((PRStream) oneObjStm, (int) jArr2[i2]);
        }
        this.xrefObj.set(i, oneObjStm);
        return oneObjStm;
    }

    /* JADX WARN: Code duplicated, block: B:87:0x01e0  */
    public boolean readXRefStream(long j) throws IOException {
        PdfArray pdfArray;
        long j2;
        int i;
        PdfArray pdfArray2;
        int i2;
        this.tokens.seek(j);
        char c = 0;
        if (!this.tokens.nextToken()) {
            return false;
        }
        PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
        PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.NUMBER;
        if (tokenType != tokenType2) {
            return false;
        }
        int iIntValue = this.tokens.intValue();
        if (!this.tokens.nextToken() || this.tokens.getTokenType() != tokenType2 || !this.tokens.nextToken() || !this.tokens.getStringValue().equals("obj")) {
            return false;
        }
        PdfObject pRObject = readPRObject();
        if (!pRObject.isStream()) {
            return false;
        }
        PRStream pRStream = (PRStream) pRObject;
        if (!PdfName.XREF.equals(pRStream.get(PdfName.TYPE))) {
            return false;
        }
        if (this.trailer == null) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            this.trailer = pdfDictionary;
            pdfDictionary.putAll(pRStream);
        }
        pRStream.setLength(((PdfNumber) pRStream.get(PdfName.LENGTH)).intValue());
        int iIntValue2 = ((PdfNumber) pRStream.get(PdfName.SIZE)).intValue();
        PdfObject pdfObject = pRStream.get(PdfName.INDEX);
        if (pdfObject == null) {
            pdfArray = new PdfArray();
            pdfArray.add(new int[]{0, iIntValue2});
        } else {
            pdfArray = (PdfArray) pdfObject;
        }
        PdfArray pdfArray3 = (PdfArray) pRStream.get(PdfName.W);
        PdfObject pdfObject2 = pRStream.get(PdfName.PREV);
        long jLongValue = pdfObject2 != null ? ((PdfNumber) pdfObject2).longValue() : -1L;
        ensureXrefSize(iIntValue2 * 2);
        if (this.objStmMark == null && !this.partial) {
            this.objStmMark = new HashMap<>();
        }
        if (this.objStmToOffset == null && this.partial) {
            this.objStmToOffset = new LongHashtable();
        }
        byte[] streamBytes = getStreamBytes(pRStream, this.tokens.getFile());
        int[] iArr = new int[3];
        for (int i3 = 0; i3 < 3; i3++) {
            iArr[i3] = pdfArray3.getAsNumber(i3).intValue();
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            char c2 = 1;
            if (i4 >= pdfArray.size()) {
                break;
            }
            int iIntValue3 = pdfArray.getAsNumber(i4).intValue();
            int iIntValue4 = pdfArray.getAsNumber(i4 + 1).intValue();
            ensureXrefSize((iIntValue3 + iIntValue4) * 2);
            while (true) {
                int i6 = iIntValue4 - 1;
                if (iIntValue4 > 0) {
                    if (iArr[c] > 0) {
                        int i7 = 0;
                        i = 0;
                        while (i7 < iArr[c]) {
                            i7++;
                            i = (streamBytes[i5] & UnsignedBytes.MAX_VALUE) + (i << 8);
                            i5++;
                        }
                    } else {
                        i = 1;
                    }
                    byte[] bArr = streamBytes;
                    long j3 = 0;
                    int i8 = 0;
                    while (i8 < iArr[c2]) {
                        j3 = (j3 << 8) + ((long) (bArr[i5] & UnsignedBytes.MAX_VALUE));
                        i8++;
                        i5++;
                        iIntValue3 = iIntValue3;
                        c2 = 1;
                    }
                    int i9 = iIntValue3;
                    char c3 = 2;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < iArr[c3]) {
                        int i12 = i11 << 8;
                        int i13 = i5 + 1;
                        int i14 = (bArr[i5] & UnsignedBytes.MAX_VALUE) + i12;
                        i10++;
                        c3 = 2;
                        i11 = i14;
                        i5 = i13;
                    }
                    int i15 = i9 * 2;
                    long[] jArr = this.xref;
                    if (jArr[i15] == 0) {
                        int i16 = i15 + 1;
                        if (jArr[i16] != 0) {
                            pdfArray2 = pdfArray;
                        } else if (i != 0) {
                            pdfArray2 = pdfArray;
                            if (i == 1) {
                                i2 = i5;
                                jArr[i15] = j3;
                            } else if (i == 2) {
                                i2 = i5;
                                jArr[i15] = i11;
                                jArr[i16] = j3;
                                if (this.partial) {
                                    this.objStmToOffset.put(j3, 0L);
                                } else {
                                    Integer numValueOf = Integer.valueOf((int) j3);
                                    IntHashtable intHashtable = this.objStmMark.get(numValueOf);
                                    if (intHashtable == null) {
                                        IntHashtable intHashtable2 = new IntHashtable();
                                        intHashtable2.put(i11, 1);
                                        this.objStmMark.put(numValueOf, intHashtable2);
                                    } else {
                                        intHashtable.put(i11, 1);
                                    }
                                }
                            }
                        } else {
                            pdfArray2 = pdfArray;
                            i2 = i5;
                            jArr[i15] = -1;
                        }
                        i2 = i5;
                    } else {
                        pdfArray2 = pdfArray;
                        i2 = i5;
                    }
                    iIntValue3 = i9 + 1;
                    iIntValue4 = i6;
                    i5 = i2;
                    streamBytes = bArr;
                    pdfArray = pdfArray2;
                    c = 0;
                    c2 = 1;
                }
            }
            i4 += 2;
            c = 0;
        }
        int i17 = iIntValue * 2;
        int i18 = i17 + 1;
        long[] jArr2 = this.xref;
        if (i18 < jArr2.length && jArr2[i17] == 0 && jArr2[i18] == 0) {
            j2 = -1;
            jArr2[i17] = -1;
        } else {
            j2 = -1;
        }
        if (jLongValue == j2) {
            return true;
        }
        return readXRefStream(jLongValue);
    }

    public void readXref() throws IOException {
        PdfDictionary xrefSection;
        this.hybridXref = false;
        this.newXrefType = false;
        PRTokeniser pRTokeniser = this.tokens;
        pRTokeniser.seek(pRTokeniser.getStartxref());
        this.tokens.nextToken();
        if (!this.tokens.getStringValue().equals("startxref")) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("startxref.not.found", new Object[0]));
        }
        this.tokens.nextToken();
        if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("startxref.is.not.followed.by.a.number", new Object[0]));
        }
        long jLongValue = this.tokens.longValue();
        this.lastXref = jLongValue;
        this.eofPos = this.tokens.getFilePointer();
        try {
            if (readXRefStream(jLongValue)) {
                this.newXrefType = true;
                return;
            }
            while (true) {
                PdfNumber pdfNumber = (PdfNumber) xrefSection.get(PdfName.PREV);
                if (pdfNumber == null) {
                    return;
                }
                if (pdfNumber.longValue() == jLongValue) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("trailer.prev.entry.points.to.its.own.cross.reference.section", new Object[0]));
                }
                jLongValue = pdfNumber.longValue();
                this.tokens.seek(jLongValue);
                xrefSection = readXrefSection();
            }
        } catch (Exception unused) {
        }
        this.xref = null;
        this.tokens.seek(jLongValue);
        xrefSection = readXrefSection();
        this.trailer = xrefSection;
    }

    public PdfDictionary readXrefSection() throws IOException {
        this.tokens.nextValidToken();
        if (!this.tokens.getStringValue().equals("xref")) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("xref.subsection.not.found", new Object[0]));
        }
        while (true) {
            this.tokens.nextValidToken();
            if (this.tokens.getStringValue().equals("trailer")) {
                break;
            }
            PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
            PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.NUMBER;
            if (tokenType != tokenType2) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("object.number.of.the.first.object.in.this.xref.subsection.not.found", new Object[0]));
            }
            int iIntValue = this.tokens.intValue();
            this.tokens.nextValidToken();
            if (this.tokens.getTokenType() != tokenType2) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("number.of.entries.in.this.xref.subsection.not.found", new Object[0]));
            }
            int iIntValue2 = this.tokens.intValue() + iIntValue;
            if (iIntValue == 1) {
                long filePointer = this.tokens.getFilePointer();
                this.tokens.nextValidToken();
                long jLongValue = this.tokens.longValue();
                this.tokens.nextValidToken();
                int iIntValue3 = this.tokens.intValue();
                if (jLongValue == 0 && iIntValue3 == 65535) {
                    iIntValue--;
                    iIntValue2--;
                }
                this.tokens.seek(filePointer);
            }
            ensureXrefSize(iIntValue2 * 2);
            while (iIntValue < iIntValue2) {
                this.tokens.nextValidToken();
                long jLongValue2 = this.tokens.longValue();
                this.tokens.nextValidToken();
                this.tokens.intValue();
                this.tokens.nextValidToken();
                int i = iIntValue * 2;
                if (this.tokens.getStringValue().equals("n")) {
                    long[] jArr = this.xref;
                    if (jArr[i] == 0 && jArr[i + 1] == 0) {
                        jArr[i] = jLongValue2;
                    }
                } else if (this.tokens.getStringValue().equals("f")) {
                    long[] jArr2 = this.xref;
                    if (jArr2[i] == 0 && jArr2[i + 1] == 0) {
                        jArr2[i] = -1;
                    }
                } else {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.cross.reference.entry.in.this.xref.subsection", new Object[0]));
                }
                iIntValue++;
            }
        }
        PdfDictionary pdfDictionary = (PdfDictionary) readPRObject();
        ensureXrefSize(((PdfNumber) pdfDictionary.get(PdfName.SIZE)).intValue() * 2);
        PdfObject pdfObject = pdfDictionary.get(PdfName.XREFSTM);
        if (pdfObject != null && pdfObject.isNumber()) {
            try {
                readXRefStream(((PdfNumber) pdfObject).intValue());
                this.newXrefType = true;
                this.hybridXref = true;
            } catch (IOException e) {
                this.xref = null;
                throw e;
            }
        }
        return pdfDictionary;
    }

    public void rebuildXref() throws InvalidPdfException {
        int i = 0;
        this.hybridXref = false;
        this.newXrefType = false;
        long j = 0;
        this.tokens.seek(0L);
        long[][] jArr = new long[1024][];
        String str = null;
        this.trailer = null;
        byte[] bArr = new byte[64];
        while (true) {
            long filePointer = this.tokens.getFilePointer();
            if (!this.tokens.readLineSegment(bArr, true)) {
                break;
            }
            byte b = bArr[i];
            if (b == 116) {
                if (PdfEncodings.convertToString(bArr, str).startsWith("trailer")) {
                    this.tokens.seek(filePointer);
                    this.tokens.nextToken();
                    long filePointer2 = this.tokens.getFilePointer();
                    try {
                        PdfDictionary pdfDictionary = (PdfDictionary) readPRObject();
                        if (pdfDictionary.get(PdfName.ROOT) != null) {
                            this.trailer = pdfDictionary;
                        } else {
                            this.tokens.seek(filePointer2);
                        }
                    } catch (Exception unused) {
                        this.tokens.seek(filePointer2);
                    }
                    jArr = jArr;
                    i = 0;
                    str = null;
                }
            } else if (b < 48 || b > 57) {
                jArr = jArr;
                i = 0;
                str = null;
            } else {
                long[] jArrCheckObjectStart = PRTokeniser.checkObjectStart(bArr);
                if (jArrCheckObjectStart != null) {
                    long j2 = jArrCheckObjectStart[i];
                    long j3 = jArrCheckObjectStart[1];
                    long[][] jArr2 = jArr;
                    if (j2 >= jArr.length) {
                        long[][] jArr3 = new long[(int) (2 * j2)][];
                        System.arraycopy(jArr2, 0, jArr3, 0, (int) j);
                        jArr = jArr3;
                    } else {
                        jArr = jArr2;
                    }
                    if (j2 >= j) {
                        j = 1 + j2;
                    }
                    int i2 = (int) j2;
                    long[] jArr4 = jArr[i2];
                    if (jArr4 == null || j3 >= jArr4[1]) {
                        jArrCheckObjectStart[0] = filePointer;
                        jArr[i2] = jArrCheckObjectStart;
                    }
                    i = 0;
                    str = null;
                }
            }
        }
        if (this.trailer == null) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("trailer.not.found", new Object[i]));
        }
        this.xref = new long[(int) (2 * j)];
        for (int i3 = 0; i3 < j; i3++) {
            long[] jArr5 = jArr[i3];
            if (jArr5 != null) {
                this.xref[i3 * 2] = jArr5[i];
            }
        }
    }

    public void releaseLastXrefPartial() {
        int i;
        if (!this.partial || (i = this.lastXrefPartial) == -1) {
            return;
        }
        this.xrefObj.set(i, null);
        this.lastXrefPartial = -1;
    }

    public void releasePage(int i) {
        this.pageRefs.releasePage(i);
    }

    public void removeAnnotations() {
        this.pageRefs.resetReleasePage();
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfDictionary pageN = this.pageRefs.getPageN(i);
            PdfName pdfName = PdfName.ANNOTS;
            if (pageN.get(pdfName) == null) {
                this.pageRefs.releasePage(i);
            } else {
                pageN.remove(pdfName);
            }
        }
        this.catalog.remove(PdfName.ACROFORM);
        this.pageRefs.resetReleasePage();
    }

    public void removeFields() {
        this.pageRefs.resetReleasePage();
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfDictionary pageN = this.pageRefs.getPageN(i);
            PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
            if (asArray == null) {
                this.pageRefs.releasePage(i);
            } else {
                int i2 = 0;
                while (i2 < asArray.size()) {
                    PdfObject pdfObjectRelease = getPdfObjectRelease(asArray.getPdfObject(i2));
                    if (pdfObjectRelease != null && pdfObjectRelease.isDictionary() && PdfName.WIDGET.equals(((PdfDictionary) pdfObjectRelease).get(PdfName.SUBTYPE))) {
                        asArray.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                if (asArray.isEmpty()) {
                    pageN.remove(PdfName.ANNOTS);
                } else {
                    this.pageRefs.releasePage(i);
                }
            }
        }
        this.catalog.remove(PdfName.ACROFORM);
        this.pageRefs.resetReleasePage();
    }

    public void removeUnusedNode(PdfObject pdfObject, boolean[] zArr) {
        PdfName[] pdfNameArr;
        int iIntValue;
        Object[] objArr;
        PdfDictionary pdfDictionary;
        int number;
        int number2;
        Stack stack = new Stack();
        stack.push(pdfObject);
        while (!stack.empty()) {
            Object objPop = stack.pop();
            if (objPop != null) {
                ArrayList<PdfObject> arrayList = null;
                if (objPop instanceof PdfObject) {
                    PdfObject pdfObject2 = (PdfObject) objPop;
                    int iType = pdfObject2.type();
                    if (iType == 5) {
                        pdfNameArr = null;
                        objArr = null;
                        iIntValue = 0;
                        arrayList = ((PdfArray) pdfObject2).getArrayList();
                        pdfDictionary = null;
                    } else if (iType == 6 || iType == 7) {
                        pdfDictionary = (PdfDictionary) pdfObject2;
                        pdfNameArr = new PdfName[pdfDictionary.size()];
                        pdfDictionary.getKeys().toArray(pdfNameArr);
                        objArr = null;
                        iIntValue = 0;
                    } else if (iType == 10) {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject2;
                        int number3 = pRIndirectReference.getNumber();
                        if (!zArr[number3]) {
                            zArr[number3] = true;
                            stack.push(getPdfObjectRelease(pRIndirectReference));
                        }
                    }
                } else {
                    Object[] objArr2 = (Object[]) objPop;
                    Object obj = objArr2[0];
                    if (obj instanceof ArrayList) {
                        iIntValue = ((Integer) objArr2[1]).intValue();
                        objArr = objArr2;
                        pdfDictionary = null;
                        arrayList = (ArrayList) obj;
                        pdfNameArr = null;
                    } else {
                        pdfNameArr = (PdfName[]) obj;
                        PdfDictionary pdfDictionary2 = (PdfDictionary) objArr2[1];
                        iIntValue = ((Integer) objArr2[2]).intValue();
                        objArr = objArr2;
                        pdfDictionary = pdfDictionary2;
                    }
                }
                if (arrayList != null) {
                    while (iIntValue < arrayList.size()) {
                        PdfObject pdfObject3 = arrayList.get(iIntValue);
                        if (!pdfObject3.isIndirect() || ((number = ((PRIndirectReference) pdfObject3).getNumber()) < this.xrefObj.size() && (this.partial || this.xrefObj.get(number) != null))) {
                            if (objArr == null) {
                                stack.push(new Object[]{arrayList, Integer.valueOf(iIntValue + 1)});
                            } else {
                                objArr[1] = Integer.valueOf(iIntValue + 1);
                                stack.push(objArr);
                            }
                            stack.push(pdfObject3);
                            break;
                        }
                        arrayList.set(iIntValue, PdfNull.PDFNULL);
                        iIntValue++;
                    }
                } else {
                    while (iIntValue < pdfNameArr.length) {
                        PdfName pdfName = pdfNameArr[iIntValue];
                        PdfObject pdfObject4 = pdfDictionary.get(pdfName);
                        if (!pdfObject4.isIndirect() || ((number2 = ((PRIndirectReference) pdfObject4).getNumber()) >= 0 && number2 < this.xrefObj.size() && (this.partial || this.xrefObj.get(number2) != null))) {
                            if (objArr == null) {
                                stack.push(new Object[]{pdfNameArr, pdfDictionary, Integer.valueOf(iIntValue + 1)});
                            } else {
                                objArr[2] = Integer.valueOf(iIntValue + 1);
                                stack.push(objArr);
                            }
                            stack.push(pdfObject4);
                            break;
                        }
                        pdfDictionary.put(pdfName, PdfNull.PDFNULL);
                        iIntValue++;
                    }
                }
            }
        }
    }

    public int removeUnusedObjects() {
        int size = this.xrefObj.size();
        boolean[] zArr = new boolean[size];
        removeUnusedNode(this.trailer, zArr);
        int i = 0;
        if (this.partial) {
            for (int i2 = 1; i2 < size; i2++) {
                if (!zArr[i2]) {
                    long[] jArr = this.xref;
                    int i3 = i2 * 2;
                    jArr[i3] = -1;
                    jArr[i3 + 1] = 0;
                    this.xrefObj.set(i2, null);
                    i++;
                }
            }
        } else {
            for (int i4 = 1; i4 < size; i4++) {
                if (!zArr[i4]) {
                    this.xrefObj.set(i4, null);
                    i++;
                }
            }
        }
        return i;
    }

    public void removeUsageRights() {
        PdfDictionary pdfDictionary = this.catalog;
        PdfName pdfName = PdfName.PERMS;
        PdfDictionary asDict = pdfDictionary.getAsDict(pdfName);
        if (asDict == null) {
            return;
        }
        asDict.remove(PdfName.UR);
        asDict.remove(PdfName.UR3);
        if (asDict.size() == 0) {
            this.catalog.remove(pdfName);
        }
    }

    public void resetLastXrefPartial() {
        this.lastXrefPartial = -1;
    }

    public void resetReleasePage() {
        this.pageRefs.resetReleasePage();
    }

    public void selectPages(String str) {
        selectPages(SequenceList.expand(str, getNumberOfPages()));
    }

    public void setAppendable(boolean z) {
        this.appendable = z;
        if (z) {
            getPdfObject(this.trailer.get(PdfName.ROOT));
        }
    }

    public void setPageContent(int i, byte[] bArr) {
        setPageContent(i, bArr, -1);
    }

    public void setTampered(boolean z) {
        this.tampered = z;
        this.pageRefs.keepPages();
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.viewerPreferences.setViewerPreferences(i);
        setViewerPreferences(this.viewerPreferences);
    }

    public int shuffleSubsetNames() {
        PdfDictionary asDict;
        String subsetPrefix;
        int i = 0;
        for (int i2 = 1; i2 < this.xrefObj.size(); i2++) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(i2);
            if (pdfObjectRelease != null && pdfObjectRelease.isDictionary()) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObjectRelease;
                if (existsName(pdfDictionary, PdfName.TYPE, PdfName.FONT)) {
                    PdfName pdfName = PdfName.SUBTYPE;
                    if (existsName(pdfDictionary, pdfName, PdfName.TYPE1) || existsName(pdfDictionary, pdfName, PdfName.MMTYPE1) || existsName(pdfDictionary, pdfName, PdfName.TRUETYPE)) {
                        String subsetPrefix2 = getSubsetPrefix(pdfDictionary);
                        if (subsetPrefix2 != null) {
                            PdfName pdfName2 = new PdfName(BaseFont.createSubsetPrefix() + subsetPrefix2.substring(7));
                            pdfDictionary.put(PdfName.BASEFONT, pdfName2);
                            setXrefPartialObject(i2, pdfDictionary);
                            i++;
                            PdfDictionary asDict2 = pdfDictionary.getAsDict(PdfName.FONTDESCRIPTOR);
                            if (asDict2 != null) {
                                asDict2.put(PdfName.FONTNAME, pdfName2);
                            }
                        }
                    } else if (existsName(pdfDictionary, pdfName, PdfName.TYPE0)) {
                        String subsetPrefix3 = getSubsetPrefix(pdfDictionary);
                        PdfArray asArray = pdfDictionary.getAsArray(PdfName.DESCENDANTFONTS);
                        if (asArray != null && !asArray.isEmpty() && (subsetPrefix = getSubsetPrefix((asDict = asArray.getAsDict(0)))) != null) {
                            String strCreateSubsetPrefix = BaseFont.createSubsetPrefix();
                            if (subsetPrefix3 != null) {
                                pdfDictionary.put(PdfName.BASEFONT, new PdfName(strCreateSubsetPrefix + subsetPrefix3.substring(7)));
                            }
                            setXrefPartialObject(i2, pdfDictionary);
                            PdfName pdfName3 = new PdfName(strCreateSubsetPrefix + subsetPrefix.substring(7));
                            asDict.put(PdfName.BASEFONT, pdfName3);
                            i++;
                            PdfDictionary asDict3 = asDict.getAsDict(PdfName.FONTDESCRIPTOR);
                            if (asDict3 != null) {
                                asDict3.put(PdfName.FONTNAME, pdfName3);
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    public static byte[] decodeBytes(byte[] bArr, PdfDictionary pdfDictionary, Map<PdfName, FilterHandlers.FilterHandler> map) throws UnsupportedPdfException {
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.FILTER));
        ArrayList<PdfObject> arrayList = new ArrayList<>();
        if (pdfObjectRelease != null) {
            if (pdfObjectRelease.isName()) {
                arrayList.add(pdfObjectRelease);
            } else if (pdfObjectRelease.isArray()) {
                arrayList = ((PdfArray) pdfObjectRelease).getArrayList();
            }
        }
        ArrayList<PdfObject> arrayList2 = new ArrayList<>();
        PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfDictionary.get(PdfName.DECODEPARMS));
        if (pdfObjectRelease2 == null || (!pdfObjectRelease2.isDictionary() && !pdfObjectRelease2.isArray())) {
            pdfObjectRelease2 = getPdfObjectRelease(pdfDictionary.get(PdfName.DP));
        }
        if (pdfObjectRelease2 != null) {
            if (pdfObjectRelease2.isDictionary()) {
                arrayList2.add(pdfObjectRelease2);
            } else if (pdfObjectRelease2.isArray()) {
                arrayList2 = ((PdfArray) pdfObjectRelease2).getArrayList();
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            PdfName pdfName = (PdfName) arrayList.get(i);
            FilterHandlers.FilterHandler filterHandler = map.get(pdfName);
            if (filterHandler == null) {
                throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("the.filter.1.is.not.supported", pdfName));
            }
            PdfDictionary pdfDictionary2 = null;
            if (i < arrayList2.size()) {
                PdfObject pdfObject = getPdfObject(arrayList2.get(i));
                if (pdfObject instanceof PdfDictionary) {
                    pdfDictionary2 = (PdfDictionary) pdfObject;
                } else if (pdfObject != null && !(pdfObject instanceof PdfNull) && (!(pdfObject instanceof PdfLiteral) || !Arrays.equals("null".getBytes(), ((PdfLiteral) pdfObject).getBytes()))) {
                    throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("the.decode.parameter.type.1.is.not.supported", pdfObject.getClass().toString()));
                }
            }
            bArr = filterHandler.decode(bArr, pdfName, pdfDictionary2, pdfDictionary);
        }
        return bArr;
    }

    public HashMap<Object, PdfObject> getNamedDestination(boolean z) {
        HashMap<Object, PdfObject> namedDestinationFromNames = getNamedDestinationFromNames(z);
        namedDestinationFromNames.putAll(getNamedDestinationFromStrings());
        return namedDestinationFromNames;
    }

    public HashMap<Object, PdfObject> getNamedDestinationFromNames(boolean z) {
        PdfDictionary pdfDictionary;
        HashMap<Object, PdfObject> map = new HashMap<>();
        PdfDictionary pdfDictionary2 = this.catalog;
        PdfName pdfName = PdfName.DESTS;
        if (pdfDictionary2.get(pdfName) == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(pdfName))) == null) {
            return map;
        }
        for (PdfName pdfName2 : pdfDictionary.getKeys()) {
            PdfArray nameArray = getNameArray(pdfDictionary.get(pdfName2));
            if (nameArray != null) {
                if (z) {
                    map.put(pdfName2, nameArray);
                } else {
                    map.put(PdfName.decodeName(pdfName2.toString()), nameArray);
                }
            }
        }
        return map;
    }

    public PdfDictionary getPageResources(PdfDictionary pdfDictionary) {
        return pdfDictionary.getAsDict(PdfName.RESOURCES);
    }

    public int getPageRotation(PdfDictionary pdfDictionary) {
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.ROTATE);
        if (asNumber == null) {
            return 0;
        }
        int iIntValue = asNumber.intValue() % 360;
        return iIntValue < 0 ? iIntValue + 360 : iIntValue;
    }

    public Rectangle getPageSize(PdfDictionary pdfDictionary) {
        return getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.MEDIABOX));
    }

    public Rectangle getPageSizeWithRotation(PdfDictionary pdfDictionary) {
        Rectangle pageSize = getPageSize(pdfDictionary);
        for (int pageRotation = getPageRotation(pdfDictionary); pageRotation > 0; pageRotation -= 90) {
            pageSize = pageSize.rotate();
        }
        return pageSize;
    }

    public void selectPages(List<Integer> list) {
        selectPages(list, true);
    }

    public void setPageContent(int i, byte[] bArr, int i2) {
        setPageContent(i, bArr, i2, false);
    }

    public static byte[] FlateDecode(byte[] bArr, boolean z) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[z ? 4092 : 1];
        while (true) {
            try {
                int i = inflaterInputStream.read(bArr2);
                if (i >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                } else {
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Exception unused) {
                if (z) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static PdfObject getPdfObjectRelease(PdfObject pdfObject, PdfObject pdfObject2) {
        PdfObject pdfObject3 = getPdfObject(pdfObject, pdfObject2);
        releaseLastXrefPartial(pdfObject);
        return pdfObject3;
    }

    public static byte[] getStreamBytes(PRStream pRStream) {
        RandomAccessFileOrArray safeFile = pRStream.getReader().getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytes(pRStream, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public void selectPages(List<Integer> list, boolean z) {
        this.pageRefs.selectPages(list);
        if (z) {
            removeUnusedObjects();
        }
    }

    public void setPageContent(int i, byte[] bArr, int i2, boolean z) {
        PdfDictionary pageN = getPageN(i);
        if (pageN == null) {
            return;
        }
        PdfName pdfName = PdfName.CONTENTS;
        PdfObject pdfObject = pageN.get(pdfName);
        this.freeXref = -1;
        if (z) {
            killXref(pdfObject);
        }
        if (this.freeXref == -1) {
            this.xrefObj.add(null);
            this.freeXref = this.xrefObj.size() - 1;
        }
        pageN.put(pdfName, new PRIndirectReference(this, this.freeXref));
        this.xrefObj.set(this.freeXref, new PRStream(this, bArr, i2));
    }

    public void setViewerPreferences(PdfViewerPreferencesImp pdfViewerPreferencesImp) {
        pdfViewerPreferencesImp.addToCatalog(this.catalog);
    }

    public static void releaseLastXrefPartial(PdfObject pdfObject) {
        int i;
        if (pdfObject != null && pdfObject.isIndirect() && (pdfObject instanceof PRIndirectReference)) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader reader = pRIndirectReference.getReader();
            if (reader.partial && (i = reader.lastXrefPartial) != -1 && i == pRIndirectReference.getNumber()) {
                reader.xrefObj.set(reader.lastXrefPartial, null);
            }
            reader.lastXrefPartial = -1;
        }
    }

    public PdfObject getPdfObjectRelease(int i) {
        PdfObject pdfObject = getPdfObject(i);
        releaseLastXrefPartial();
        return pdfObject;
    }

    public static PdfObject getPdfObject(PdfObject pdfObject, PdfObject pdfObject2) {
        PRIndirectReference indRef;
        PdfObject pdfBoolean;
        if (pdfObject == null) {
            return null;
        }
        if (pdfObject.isIndirect()) {
            return getPdfObject(pdfObject);
        }
        if (pdfObject2 != null && (indRef = pdfObject2.getIndRef()) != null && indRef.getReader().isAppendable()) {
            int iType = pdfObject.type();
            if (iType == 1) {
                pdfBoolean = new PdfBoolean(((PdfBoolean) pdfObject).booleanValue());
            } else {
                if (iType == 4) {
                    pdfBoolean = new PdfName(pdfObject.getBytes());
                } else if (iType == 8) {
                    pdfObject = new PdfNull();
                }
                pdfObject.setIndRef(indRef);
            }
            pdfObject = pdfBoolean;
            pdfObject.setIndRef(indRef);
        }
        return pdfObject;
    }

    public static byte[] getPageContent(PdfDictionary pdfDictionary) {
        RandomAccessFileOrArray safeFile = null;
        if (pdfDictionary == null) {
            return null;
        }
        try {
            PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.CONTENTS));
            if (pdfObjectRelease == null) {
                return new byte[0];
            }
            if (pdfObjectRelease.isStream()) {
                RandomAccessFileOrArray safeFile2 = ((PRStream) pdfObjectRelease).getReader().getSafeFile();
                safeFile2.reOpen();
                byte[] streamBytes = getStreamBytes((PRStream) pdfObjectRelease, safeFile2);
                try {
                    safeFile2.close();
                } catch (Exception unused) {
                }
                return streamBytes;
            }
            if (pdfObjectRelease.isArray()) {
                PdfArray pdfArray = (PdfArray) pdfObjectRelease;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i = 0; i < pdfArray.size(); i++) {
                    PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfArray.getPdfObject(i));
                    if (pdfObjectRelease2 != null && pdfObjectRelease2.isStream()) {
                        if (safeFile == null) {
                            safeFile = ((PRStream) pdfObjectRelease2).getReader().getSafeFile();
                            safeFile.reOpen();
                        }
                        byteArrayOutputStream.write(getStreamBytes((PRStream) pdfObjectRelease2, safeFile));
                        if (i != pdfArray.size() - 1) {
                            byteArrayOutputStream.write(10);
                        }
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (safeFile != null) {
                    try {
                        safeFile.close();
                    } catch (Exception unused2) {
                    }
                }
                return byteArray;
            }
            return new byte[0];
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    safeFile.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    public static byte[] getStreamBytesRaw(PRStream pRStream) {
        RandomAccessFileOrArray safeFile = pRStream.getReader().getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytesRaw(pRStream, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public String getJavaScript() {
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getJavaScript(safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public PdfObject getPdfObject(int i) {
        try {
            this.lastXrefPartial = -1;
            if (i >= 0 && i < this.xrefObj.size()) {
                PdfObject pdfObject = this.xrefObj.get(i);
                if (this.partial && pdfObject == null) {
                    if (i * 2 >= this.xref.length) {
                        return null;
                    }
                    PdfObject singleObject = readSingleObject(i);
                    this.lastXrefPartial = -1;
                    if (singleObject != null) {
                        this.lastXrefPartial = i;
                    }
                    return singleObject;
                }
                return pdfObject;
            }
            return null;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfReader(String str) {
        this(str, (byte[]) null);
    }

    public PdfReader(String str, byte[] bArr) {
        this(str, bArr, false);
    }

    public PdfReader(String str, byte[] bArr, boolean z) {
        this(new RandomAccessSourceFactory().setForceRead(false).setUsePlainRandomAccess(Document.plainRandomAccess).createBestSource(str), z, bArr, null, null, null, null, true);
    }

    public PdfReader(byte[] bArr) {
        this(bArr, (byte[]) null);
    }

    public PdfReader(byte[] bArr, byte[] bArr2) {
        this(new RandomAccessSourceFactory().createSource(bArr), false, bArr2, null, null, null, null, true);
    }

    public PdfReader(String str, Certificate certificate, Key key, String str2) {
        this(new RandomAccessSourceFactory().setForceRead(false).setUsePlainRandomAccess(Document.plainRandomAccess).createBestSource(str), false, null, certificate, key, str2, null, true);
    }

    public byte[] getPageContent(int i) {
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getPageContent(i, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public PdfReader(String str, Certificate certificate, ExternalDecryptionProcess externalDecryptionProcess) {
        this(new RandomAccessSourceFactory().setForceRead(false).setUsePlainRandomAccess(Document.plainRandomAccess).createBestSource(str), false, null, certificate, null, null, externalDecryptionProcess, true);
    }

    public PdfReader(byte[] bArr, Certificate certificate, ExternalDecryptionProcess externalDecryptionProcess) {
        this(new RandomAccessSourceFactory().setForceRead(false).setUsePlainRandomAccess(Document.plainRandomAccess).createSource(bArr), false, null, certificate, null, null, externalDecryptionProcess, true);
    }

    public PdfReader(InputStream inputStream, Certificate certificate, ExternalDecryptionProcess externalDecryptionProcess) {
        this(new RandomAccessSourceFactory().setForceRead(false).setUsePlainRandomAccess(Document.plainRandomAccess).createSource(inputStream), false, null, certificate, null, null, externalDecryptionProcess, true);
    }

    public PdfReader(URL url) {
        this(url, (byte[]) null);
    }

    public PdfReader(URL url, byte[] bArr) {
        this(new RandomAccessSourceFactory().createSource(url), false, bArr, null, null, null, null, true);
    }

    public PdfReader(InputStream inputStream, byte[] bArr) {
        this(new RandomAccessSourceFactory().createSource(inputStream), false, bArr, null, null, null, null, false);
    }

    public PdfReader(InputStream inputStream) {
        this(inputStream, (byte[]) null);
    }

    public PdfReader(RandomAccessFileOrArray randomAccessFileOrArray, byte[] bArr) {
        this(randomAccessFileOrArray, bArr, true);
    }

    public PdfReader(RandomAccessFileOrArray randomAccessFileOrArray, byte[] bArr, boolean z) {
        this(randomAccessFileOrArray.getByteSource(), z, bArr, null, null, null, null, false);
    }

    public PdfReader(PdfReader pdfReader) {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.externalDecryptionProcess = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.appendable = pdfReader.appendable;
        this.consolidateNamedDestinations = pdfReader.consolidateNamedDestinations;
        this.encrypted = pdfReader.encrypted;
        this.rebuilt = pdfReader.rebuilt;
        this.sharedStreams = pdfReader.sharedStreams;
        this.tampered = pdfReader.tampered;
        this.password = pdfReader.password;
        this.pdfVersion = pdfReader.pdfVersion;
        this.eofPos = pdfReader.eofPos;
        this.freeXref = pdfReader.freeXref;
        this.lastXref = pdfReader.lastXref;
        this.newXrefType = pdfReader.newXrefType;
        this.tokens = new PRTokeniser(pdfReader.tokens.getSafeFile());
        if (pdfReader.decrypt != null) {
            this.decrypt = new PdfEncryption(pdfReader.decrypt);
        }
        this.pValue = pdfReader.pValue;
        this.rValue = pdfReader.rValue;
        this.xrefObj = new ArrayList<>(pdfReader.xrefObj);
        for (int i = 0; i < pdfReader.xrefObj.size(); i++) {
            this.xrefObj.set(i, duplicatePdfObject(pdfReader.xrefObj.get(i), this));
        }
        this.pageRefs = new PageRefs(pdfReader.pageRefs, this);
        PdfDictionary pdfDictionary = (PdfDictionary) duplicatePdfObject(pdfReader.trailer, this);
        this.trailer = pdfDictionary;
        PdfDictionary asDict = pdfDictionary.getAsDict(PdfName.ROOT);
        this.catalog = asDict;
        this.rootPages = asDict.getAsDict(PdfName.PAGES);
        this.fileLength = pdfReader.fileLength;
        this.partial = pdfReader.partial;
        this.hybridXref = pdfReader.hybridXref;
        this.objStmToOffset = pdfReader.objStmToOffset;
        this.xref = pdfReader.xref;
        this.cryptoRef = (PRIndirectReference) duplicatePdfObject(pdfReader.cryptoRef, this);
        this.ownerPasswordUsed = pdfReader.ownerPasswordUsed;
    }
}
