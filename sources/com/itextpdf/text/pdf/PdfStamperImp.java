package com.itextpdf.text.pdf;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.itextpdf.awt.geom.Point;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import com.itextpdf.text.xml.xmp.PdfProperties;
import com.itextpdf.text.xml.xmp.XmpBasicProperties;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.options.SerializeOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class PdfStamperImp extends PdfWriter {
    protected Counter COUNTER;
    private double[] DEFAULT_MATRIX;
    protected AcroFields acroFields;
    protected boolean append;
    protected boolean closed;
    protected HashSet<PdfTemplate> fieldTemplates;
    protected boolean fieldsAdded;
    protected RandomAccessFileOrArray file;
    protected boolean flat;
    protected boolean flatFreeText;
    protected boolean flatannotations;
    protected int initialXrefSize;
    protected IntHashtable marked;
    IntHashtable myXref;
    protected int[] namePtr;
    protected HashMap<Object, PdfObject> namedDestinations;
    protected PdfAction openAction;
    private boolean originalLayersAreRead;
    HashMap<PdfDictionary, PageStamp> pagesToContent;
    protected HashSet<String> partialFlattening;
    PdfReader reader;
    HashMap<PdfReader, RandomAccessFileOrArray> readers2file;
    HashMap<PdfReader, IntHashtable> readers2intrefs;
    private boolean rotateContents;
    protected int sigFlags;
    protected boolean useVp;
    protected PdfViewerPreferencesImp viewerPreferences;

    public static class PageStamp {
        StampContent over;
        PdfDictionary pageN;
        StampContent under;
        int replacePoint = 0;
        PageResources pageResources = new PageResources();

        public PageStamp(PdfStamperImp pdfStamperImp, PdfReader pdfReader, PdfDictionary pdfDictionary) {
            this.pageN = pdfDictionary;
            this.pageResources.setOriginalResources(pdfDictionary.getAsDict(PdfName.RESOURCES), pdfStamperImp.namePtr);
        }
    }

    public PdfStamperImp(PdfReader pdfReader, OutputStream outputStream, char c, boolean z) throws DocumentException, IOException {
        super(new PdfDocument(), outputStream);
        this.readers2intrefs = new HashMap<>();
        this.readers2file = new HashMap<>();
        this.myXref = new IntHashtable();
        this.pagesToContent = new HashMap<>();
        this.closed = false;
        this.rotateContents = true;
        this.flat = false;
        this.flatFreeText = false;
        this.flatannotations = false;
        this.namePtr = new int[]{0};
        this.partialFlattening = new HashSet<>();
        this.useVp = false;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.fieldTemplates = new HashSet<>();
        this.fieldsAdded = false;
        this.sigFlags = 0;
        this.namedDestinations = new HashMap<>();
        this.COUNTER = CounterFactory.getCounter(PdfStamper.class);
        this.originalLayersAreRead = false;
        this.DEFAULT_MATRIX = new double[]{1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d};
        if (!pdfReader.isOpenedWithFullPermissions()) {
            throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
        }
        if (pdfReader.isTampered()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.original.document.was.reused.read.it.again.from.file", new Object[0]));
        }
        pdfReader.setTampered(true);
        this.reader = pdfReader;
        this.file = pdfReader.getSafeFile();
        this.append = z;
        if (pdfReader.isEncrypted() && (z || PdfReader.unethicalreading)) {
            this.crypto = new PdfEncryption(pdfReader.getDecrypt());
        }
        if (z) {
            if (pdfReader.isRebuilt()) {
                throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.requires.a.document.without.errors.even.if.recovery.was.possible", new Object[0]));
            }
            this.pdf_version.setAppendmode(true);
            if (c == 0) {
                this.pdf_version.setPdfVersion(pdfReader.getPdfVersion());
            } else {
                this.pdf_version.setPdfVersion(c);
            }
            byte[] bArr = new byte[8192];
            while (true) {
                int i = this.file.read(bArr);
                if (i <= 0) {
                    break;
                } else {
                    this.os.write(bArr, 0, i);
                }
            }
            this.prevxref = pdfReader.getLastXref();
            pdfReader.setAppendable(true);
        } else if (c == 0) {
            super.setPdfVersion(pdfReader.getPdfVersion());
        } else {
            super.setPdfVersion(c);
        }
        if (pdfReader.isTagged()) {
            setTagged();
        }
        super.open();
        this.pdf.addWriter(this);
        if (z) {
            this.body.setRefnum(pdfReader.getXrefSize());
            this.marked = new IntHashtable();
            if (pdfReader.isNewXrefType()) {
                this.fullCompression = true;
            }
            if (pdfReader.isHybridXref()) {
                this.fullCompression = false;
            }
        }
        this.initialXrefSize = pdfReader.getXrefSize();
        readColorProfile();
    }

    private void addOrder(PdfLayer pdfLayer, PdfArray pdfArray, Map<String, PdfLayer> map) {
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject = pdfArray.getPdfObject(i);
            if (pdfObject.isIndirect()) {
                PdfLayer pdfLayer2 = map.get(pdfObject.toString());
                if (pdfLayer2 != null) {
                    pdfLayer2.setOnPanel(true);
                    registerLayer(pdfLayer2);
                    if (pdfLayer != null) {
                        pdfLayer.addChild(pdfLayer2);
                    }
                    int i2 = i + 1;
                    if (pdfArray.size() > i2 && pdfArray.getPdfObject(i2).isArray()) {
                        addOrder(pdfLayer2, (PdfArray) pdfArray.getPdfObject(i2), map);
                        i = i2;
                    }
                }
            } else if (pdfObject.isArray()) {
                PdfArray pdfArray2 = (PdfArray) pdfObject;
                if (pdfArray2.isEmpty()) {
                    return;
                }
                PdfObject pdfObject2 = pdfArray2.getPdfObject(0);
                if (pdfObject2.isString()) {
                    PdfLayer pdfLayer3 = new PdfLayer(pdfObject2.toString());
                    pdfLayer3.setOnPanel(true);
                    registerLayer(pdfLayer3);
                    if (pdfLayer != null) {
                        pdfLayer.addChild(pdfLayer3);
                    }
                    PdfArray pdfArray3 = new PdfArray();
                    ListIterator<PdfObject> listIterator = pdfArray2.listIterator();
                    while (listIterator.hasNext()) {
                        pdfArray3.add(listIterator.next());
                    }
                    addOrder(pdfLayer3, pdfArray3, map);
                } else {
                    addOrder(pdfLayer, (PdfArray) pdfObject2, map);
                }
            } else {
                continue;
            }
            i++;
        }
    }

    public static void findAllObjects(PdfReader pdfReader, PdfObject pdfObject, IntHashtable intHashtable) {
        if (pdfObject == null) {
            return;
        }
        int iType = pdfObject.type();
        if (iType == 5) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i = 0; i < pdfArray.size(); i++) {
                findAllObjects(pdfReader, pdfArray.getPdfObject(i), intHashtable);
            }
            return;
        }
        if (iType == 6 || iType == 7) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            Iterator<PdfName> it = pdfDictionary.getKeys().iterator();
            while (it.hasNext()) {
                findAllObjects(pdfReader, pdfDictionary.get(it.next()), intHashtable);
            }
            return;
        }
        if (iType != 10) {
            return;
        }
        PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
        if (pdfReader == pRIndirectReference.getReader() && !intHashtable.containsKey(pRIndirectReference.getNumber())) {
            intHashtable.put(pRIndirectReference.getNumber(), 1);
            findAllObjects(pdfReader, PdfReader.getPdfObject(pdfObject), intHashtable);
        }
    }

    private PdfArray getLastChildInNameTree(PdfDictionary pdfDictionary) {
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.KIDS);
        return asArray != null ? getLastChildInNameTree(asArray.getAsDict(asArray.size() - 1)) : pdfDictionary.getAsArray(PdfName.NAMES);
    }

    private static void moveRectangle(PdfDictionary pdfDictionary, PdfReader pdfReader, int i, PdfName pdfName, String str) {
        Rectangle boxSize = pdfReader.getBoxSize(i, str);
        if (boxSize == null) {
            pdfDictionary.remove(pdfName);
        } else {
            pdfDictionary.put(pdfName, new PdfRectangle(boxSize));
        }
    }

    private void outlineTravel(PRIndirectReference pRIndirectReference) {
        while (pRIndirectReference != null) {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference);
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfDictionary.get(PdfName.FIRST);
            if (pRIndirectReference2 != null) {
                outlineTravel(pRIndirectReference2);
            }
            PdfReader.killIndirect(pdfDictionary.get(PdfName.DEST));
            PdfReader.killIndirect(pdfDictionary.get(PdfName.A));
            PdfReader.killIndirect(pRIndirectReference);
            pRIndirectReference = (PRIndirectReference) pdfDictionary.get(PdfName.NEXT);
        }
    }

    private Rectangle transformBBoxByMatrix(Rectangle rectangle, double[] dArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Point pointTransformPoint = transformPoint(rectangle.getLeft(), rectangle.getBottom(), dArr);
        arrayList.add(Double.valueOf(pointTransformPoint.x));
        arrayList2.add(Double.valueOf(pointTransformPoint.y));
        Point pointTransformPoint2 = transformPoint(rectangle.getRight(), rectangle.getTop(), dArr);
        arrayList.add(Double.valueOf(pointTransformPoint2.x));
        arrayList2.add(Double.valueOf(pointTransformPoint2.y));
        Point pointTransformPoint3 = transformPoint(rectangle.getLeft(), rectangle.getTop(), dArr);
        arrayList.add(Double.valueOf(pointTransformPoint3.x));
        arrayList2.add(Double.valueOf(pointTransformPoint3.y));
        Point pointTransformPoint4 = transformPoint(rectangle.getRight(), rectangle.getBottom(), dArr);
        arrayList.add(Double.valueOf(pointTransformPoint4.x));
        arrayList2.add(Double.valueOf(pointTransformPoint4.y));
        return new Rectangle(((Double) Collections.min(arrayList)).floatValue(), ((Double) Collections.min(arrayList2)).floatValue(), ((Double) Collections.max(arrayList)).floatValue(), ((Double) Collections.max(arrayList2)).floatValue());
    }

    private Point transformPoint(double d, double d2, double[] dArr) {
        Point point = new Point();
        point.x = (dArr[0] * d) + (dArr[2] * d2) + dArr[4];
        point.y = (dArr[1] * d) + (dArr[3] * d2) + dArr[5];
        return point;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        throw new RuntimeException(MessageLocalization.getComposedMessage("unsupported.in.this.context.use.pdfstamper.addannotation", new Object[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.itextpdf.text.pdf.PdfStamperImp, com.itextpdf.text.pdf.PdfWriter] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.itextpdf.text.pdf.PdfObject] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.itextpdf.text.pdf.PdfObject] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.itextpdf.text.pdf.PdfDictionary] */
    public void addComments(FdfReader fdfReader) {
        PdfDictionary asDict;
        PdfArray asArray;
        PdfObject pdfObject;
        PdfObject pdfObject2;
        if (this.readers2intrefs.containsKey(fdfReader) || (asDict = fdfReader.getCatalog().getAsDict(PdfName.FDF)) == null || (asArray = asDict.getAsArray(PdfName.ANNOTS)) == null || asArray.size() == 0) {
            return;
        }
        registerReader(fdfReader, false);
        IntHashtable intHashtable = new IntHashtable();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < asArray.size(); i++) {
            PdfObject pdfObject3 = asArray.getPdfObject(i);
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pdfObject3);
            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.PAGE);
            if (asNumber != null && asNumber.intValue() < this.reader.getNumberOfPages()) {
                findAllObjects(fdfReader, pdfObject3, intHashtable);
                arrayList.add(pdfObject3);
                if (pdfObject3.type() == 10 && (pdfObject2 = PdfReader.getPdfObject(pdfDictionary.get(PdfName.NM))) != null && pdfObject2.type() == 3) {
                    map.put(pdfObject2.toString(), pdfObject3);
                }
            }
        }
        int[] keys = intHashtable.getKeys();
        for (int i2 : keys) {
            ?? pdfObject4 = fdfReader.getPdfObject(i2);
            if (pdfObject4.type() == 6) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject4;
                PdfName pdfName = PdfName.IRT;
                PdfObject pdfObject5 = PdfReader.getPdfObject(pdfDictionary2.get(pdfName));
                if (pdfObject5 != null && pdfObject5.type() == 3 && (pdfObject = (PdfObject) map.get(pdfObject5.toString())) != null) {
                    pdfObject4 = new PdfDictionary();
                    pdfObject4.merge(pdfDictionary2);
                    pdfObject4.put(pdfName, pdfObject);
                }
            }
            addToBody(pdfObject4, getNewObjectNumber(fdfReader, i2, 0));
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PdfObject pdfObject6 = (PdfObject) arrayList.get(i3);
            PdfDictionary pageN = this.reader.getPageN(((PdfDictionary) PdfReader.getPdfObject(pdfObject6)).getAsNumber(PdfName.PAGE).intValue() + 1);
            PdfName pdfName2 = PdfName.ANNOTS;
            PdfArray pdfArray = (PdfArray) PdfReader.getPdfObject(pageN.get(pdfName2), pageN);
            if (pdfArray == null) {
                pdfArray = new PdfArray();
                pageN.put(pdfName2, pdfArray);
                markUsed(pageN);
            }
            markUsed(pdfArray);
            pdfArray.add(pdfObject6);
        }
    }

    public void addDocumentField(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary catalog = this.reader.getCatalog();
        PdfName pdfName = PdfName.ACROFORM;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(pdfName), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(pdfName, pdfDictionary);
            markUsed(catalog);
        }
        PdfName pdfName2 = PdfName.FIELDS;
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObject(pdfDictionary.get(pdfName2), pdfDictionary);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            pdfDictionary.put(pdfName2, pdfArray);
            markUsed(pdfDictionary);
        }
        PdfName pdfName3 = PdfName.DA;
        if (!pdfDictionary.contains(pdfName3)) {
            pdfDictionary.put(pdfName3, new PdfString("/Helv 0 Tf 0 g "));
            markUsed(pdfDictionary);
        }
        pdfArray.add(pdfIndirectReference);
        markUsed(pdfArray);
    }

    public void addFieldResources() {
        if (this.fieldTemplates.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        PdfName pdfName = PdfName.ACROFORM;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(pdfName), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(pdfName, pdfDictionary);
            markUsed(catalog);
        }
        PdfName pdfName2 = PdfName.DR;
        PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObject(pdfDictionary.get(pdfName2), pdfDictionary);
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary();
            pdfDictionary.put(pdfName2, pdfDictionary2);
            markUsed(pdfDictionary);
        }
        markUsed(pdfDictionary2);
        Iterator<PdfTemplate> it = this.fieldTemplates.iterator();
        while (it.hasNext()) {
            PdfFormField.mergeResources(pdfDictionary2, (PdfDictionary) it.next().getResources(), this);
        }
        PdfName pdfName3 = PdfName.FONT;
        PdfDictionary asDict = pdfDictionary2.getAsDict(pdfName3);
        if (asDict == null) {
            asDict = new PdfDictionary();
            pdfDictionary2.put(pdfName3, asDict);
        }
        PdfName pdfName4 = PdfName.HELV;
        if (!asDict.contains(pdfName4)) {
            PdfDictionary pdfDictionary3 = new PdfDictionary(pdfName3);
            pdfDictionary3.put(PdfName.BASEFONT, PdfName.HELVETICA);
            pdfDictionary3.put(PdfName.ENCODING, PdfName.WIN_ANSI_ENCODING);
            pdfDictionary3.put(PdfName.NAME, pdfName4);
            pdfDictionary3.put(PdfName.SUBTYPE, PdfName.TYPE1);
            asDict.put(pdfName4, addToBody(pdfDictionary3).getIndirectReference());
        }
        PdfName pdfName5 = PdfName.ZADB;
        if (!asDict.contains(pdfName5)) {
            PdfDictionary pdfDictionary4 = new PdfDictionary(pdfName3);
            pdfDictionary4.put(PdfName.BASEFONT, PdfName.ZAPFDINGBATS);
            pdfDictionary4.put(PdfName.NAME, pdfName5);
            pdfDictionary4.put(PdfName.SUBTYPE, PdfName.TYPE1);
            asDict.put(pdfName5, addToBody(pdfDictionary4).getIndirectReference());
        }
        PdfName pdfName6 = PdfName.DA;
        if (pdfDictionary.get(pdfName6) == null) {
            pdfDictionary.put(pdfName6, new PdfString("/Helv 0 Tf 0 g "));
            markUsed(pdfDictionary);
        }
    }

    public void addFileAttachments() {
        HashMap<String, PdfObject> documentFileAttachment = this.pdf.getDocumentFileAttachment();
        if (documentFileAttachment.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        PdfName pdfName = PdfName.NAMES;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(pdfName), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(pdfName, pdfDictionary);
            markUsed(catalog);
        }
        markUsed(pdfDictionary);
        HashMap<String, PdfObject> tree = PdfNameTree.readTree((PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.EMBEDDEDFILES)));
        for (Map.Entry<String, PdfObject> entry : documentFileAttachment.entrySet()) {
            StringBuilder sb = new StringBuilder(entry.getKey());
            int i = 0;
            while (tree.containsKey(sb.toString())) {
                i++;
                sb.append(" ");
                sb.append(i);
            }
            tree.put(sb.toString(), entry.getValue());
        }
        PdfObject pdfObjectWriteTree = PdfNameTree.writeTree(tree, this);
        PdfName pdfName2 = PdfName.EMBEDDEDFILES;
        PdfObject pdfObject = pdfDictionary.get(pdfName2);
        if (pdfObject != null) {
            PdfReader.killIndirect(pdfObject);
        }
        pdfDictionary.put(pdfName2, addToBody(pdfObjectWriteTree).getIndirectReference());
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.useVp = true;
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
    }

    public void alterContents() {
        PdfArray pdfArray;
        for (PageStamp pageStamp : this.pagesToContent.values()) {
            PdfDictionary pdfDictionary = pageStamp.pageN;
            markUsed(pdfDictionary);
            PdfName pdfName = PdfName.CONTENTS;
            PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName), pdfDictionary);
            if (pdfObject == null) {
                pdfArray = new PdfArray();
                pdfDictionary.put(pdfName, pdfArray);
            } else if (pdfObject.isArray()) {
                PdfArray pdfArray2 = new PdfArray((PdfArray) pdfObject);
                pdfDictionary.put(pdfName, pdfArray2);
                pdfArray = pdfArray2;
            } else if (pdfObject.isStream()) {
                pdfArray = new PdfArray();
                pdfArray.add(pdfDictionary.get(pdfName));
                pdfDictionary.put(pdfName, pdfArray);
            } else {
                pdfArray = new PdfArray();
                pdfDictionary.put(pdfName, pdfArray);
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            if (pageStamp.under != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(pdfDictionary, byteBuffer);
                byteBuffer.append(pageStamp.under.getInternalBuffer());
                byteBuffer.append(PdfContents.RESTORESTATE);
            }
            if (pageStamp.over != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
            }
            PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
            pdfStream.flateCompress(this.compressionLevel);
            pdfArray.addFirst(addToBody(pdfStream).getIndirectReference());
            byteBuffer.reset();
            if (pageStamp.over != null) {
                byteBuffer.append(' ');
                byte[] bArr = PdfContents.RESTORESTATE;
                byteBuffer.append(bArr);
                ByteBuffer internalBuffer = pageStamp.over.getInternalBuffer();
                byteBuffer.append(internalBuffer.getBuffer(), 0, pageStamp.replacePoint);
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(pdfDictionary, byteBuffer);
                byteBuffer.append(internalBuffer.getBuffer(), pageStamp.replacePoint, internalBuffer.size() - pageStamp.replacePoint);
                byteBuffer.append(bArr);
                PdfStream pdfStream2 = new PdfStream(byteBuffer.toByteArray());
                pdfStream2.flateCompress(this.compressionLevel);
                pdfArray.add(addToBody(pdfStream2).getIndirectReference());
            }
            alterResources(pageStamp);
        }
    }

    public void alterResources(PageStamp pageStamp) {
        pageStamp.pageN.put(PdfName.RESOURCES, pageStamp.pageResources.getResources());
    }

    public void applyRotation(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
        if (this.rotateContents) {
            Rectangle pageSizeWithRotation = this.reader.getPageSizeWithRotation(pdfDictionary);
            int rotation = pageSizeWithRotation.getRotation();
            if (rotation == 90) {
                byteBuffer.append(PdfContents.ROTATE90);
                byteBuffer.append(pageSizeWithRotation.getTop());
                byteBuffer.append(' ').append('0').append(PdfContents.ROTATEFINAL);
            } else {
                if (rotation == 180) {
                    byteBuffer.append(PdfContents.ROTATE180);
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(' ');
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                    return;
                }
                if (rotation != 270) {
                    return;
                }
                byteBuffer.append(PdfContents.ROTATE270);
                byteBuffer.append('0').append(' ');
                byteBuffer.append(pageSizeWithRotation.getRight());
                byteBuffer.append(PdfContents.ROTATEFINAL);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0155  */
    public void close(Map<String, String> map) {
        String unicodeString;
        String version;
        byte[] streamBytesRaw;
        if (this.closed) {
            return;
        }
        if (this.useVp) {
            setViewerPreferences();
        }
        if (this.flat) {
            flatFields();
        }
        if (this.flatFreeText) {
            flatFreeTextFields();
        }
        if (this.flatannotations) {
            flattenAnnotations();
        }
        addFieldResources();
        PdfDictionary catalog = this.reader.getCatalog();
        getPdfVersion().addToCatalog(catalog);
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), this.reader.getCatalog());
        AcroFields acroFields = this.acroFields;
        if (acroFields != null && acroFields.getXfa().isChanged()) {
            markUsed(pdfDictionary);
            if (!this.flat) {
                this.acroFields.getXfa().setXfa(this);
            }
        }
        int i = this.sigFlags;
        if (i != 0 && pdfDictionary != null) {
            pdfDictionary.put(PdfName.SIGFLAGS, new PdfNumber(i));
            markUsed(pdfDictionary);
            markUsed(catalog);
        }
        this.closed = true;
        addSharedObjectsToBody();
        setOutlines();
        setJavaScript();
        addFileAttachments();
        PdfDictionary pdfDictionary2 = this.extraCatalog;
        if (pdfDictionary2 != null) {
            catalog.mergeDifferent(pdfDictionary2);
        }
        PdfObject pdfObject = this.openAction;
        if (pdfObject != null) {
            catalog.put(PdfName.OPENACTION, pdfObject);
        }
        PdfPageLabels pdfPageLabels = this.pdf.pageLabels;
        if (pdfPageLabels != null) {
            catalog.put(PdfName.PAGELABELS, pdfPageLabels.getDictionary(this));
        }
        if (!this.documentOCG.isEmpty()) {
            fillOCProperties(false);
            PdfName pdfName = PdfName.OCPROPERTIES;
            PdfDictionary asDict = catalog.getAsDict(pdfName);
            if (asDict == null) {
                this.reader.getCatalog().put(pdfName, this.OCProperties);
            } else {
                PdfName pdfName2 = PdfName.OCGS;
                asDict.put(pdfName2, this.OCProperties.get(pdfName2));
                PdfName pdfName3 = PdfName.D;
                PdfDictionary asDict2 = asDict.getAsDict(pdfName3);
                if (asDict2 == null) {
                    asDict2 = new PdfDictionary();
                    asDict.put(pdfName3, asDict2);
                }
                PdfName pdfName4 = PdfName.ORDER;
                asDict2.put(pdfName4, this.OCProperties.getAsDict(pdfName3).get(pdfName4));
                PdfName pdfName5 = PdfName.RBGROUPS;
                asDict2.put(pdfName5, this.OCProperties.getAsDict(pdfName3).get(pdfName5));
                PdfName pdfName6 = PdfName.OFF;
                asDict2.put(pdfName6, this.OCProperties.getAsDict(pdfName3).get(pdfName6));
                PdfName pdfName7 = PdfName.AS;
                asDict2.put(pdfName7, this.OCProperties.getAsDict(pdfName3).get(pdfName7));
            }
            PdfWriter.checkPdfIsoConformance(this, 7, this.OCProperties);
        }
        PdfDictionary trailer = this.reader.getTrailer();
        PdfName pdfName8 = PdfName.INFO;
        PdfIndirectReference asIndirectObject = trailer.getAsIndirectObject(pdfName8);
        int number = asIndirectObject != null ? asIndirectObject.getNumber() : -1;
        PdfDictionary asDict3 = this.reader.getTrailer().getAsDict(pdfName8);
        PdfStream pdfStream = null;
        if (asDict3 != null) {
            PdfName pdfName9 = PdfName.PRODUCER;
            if (asDict3.get(pdfName9) != null) {
                unicodeString = asDict3.getAsString(pdfName9).toUnicodeString();
            } else {
                unicodeString = null;
            }
        } else {
            unicodeString = null;
        }
        Version version2 = Version.getInstance();
        if (unicodeString == null || version2.getVersion().indexOf(version2.getProduct()) == -1) {
            version = version2.getVersion();
        } else {
            int iIndexOf = unicodeString.indexOf("; modified using");
            StringBuffer stringBuffer = iIndexOf == -1 ? new StringBuffer(unicodeString) : new StringBuffer(unicodeString.substring(0, iIndexOf));
            stringBuffer.append("; modified using ");
            stringBuffer.append(version2.getVersion());
            version = stringBuffer.toString();
        }
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        if (asDict3 != null) {
            for (PdfName pdfName10 : asDict3.getKeys()) {
                pdfDictionary3.put(pdfName10, PdfReader.getPdfObject(asDict3.get(pdfName10)));
            }
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                PdfName pdfName11 = new PdfName(entry.getKey());
                String value = entry.getValue();
                if (value == null) {
                    pdfDictionary3.remove(pdfName11);
                } else {
                    pdfDictionary3.put(pdfName11, new PdfString(value, PdfObject.TEXT_UNICODE));
                }
            }
        }
        PdfDate pdfDate = new PdfDate();
        pdfDictionary3.put(PdfName.MODDATE, pdfDate);
        pdfDictionary3.put(PdfName.PRODUCER, new PdfString(version, PdfObject.TEXT_UNICODE));
        PdfIndirectReference indirectReference = (!this.append || asIndirectObject == null) ? addToBody((PdfObject) pdfDictionary3, false).getIndirectReference() : addToBody((PdfObject) pdfDictionary3, asIndirectObject.getNumber(), false).getIndirectReference();
        PdfName pdfName12 = PdfName.METADATA;
        PdfObject pdfObject2 = PdfReader.getPdfObject(catalog.get(pdfName12));
        if (pdfObject2 == null || !pdfObject2.isStream()) {
            streamBytesRaw = null;
        } else {
            streamBytesRaw = PdfReader.getStreamBytesRaw((PRStream) pdfObject2);
            PdfReader.killIndirect(catalog.get(pdfName12));
        }
        byte[] bArr = this.xmpMetadata;
        if (bArr != null) {
            streamBytesRaw = bArr;
        } else if (this.xmpWriter != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PdfProperties.setProducer(this.xmpWriter.getXmpMeta(), version);
                XmpBasicProperties.setModDate(this.xmpWriter.getXmpMeta(), pdfDate.getW3CDate());
                XmpBasicProperties.setMetaDataDate(this.xmpWriter.getXmpMeta(), pdfDate.getW3CDate());
                this.xmpWriter.serialize(byteArrayOutputStream);
                this.xmpWriter.close();
                pdfStream = new PdfStream(byteArrayOutputStream.toByteArray());
            } catch (XMPException unused) {
                this.xmpWriter = null;
            }
        }
        if (pdfStream == null && streamBytesRaw != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                if (map == null || this.xmpMetadata != null) {
                    XMPMeta fromBuffer = XMPMetaFactory.parseFromBuffer(streamBytesRaw);
                    PdfProperties.setProducer(fromBuffer, version);
                    XmpBasicProperties.setModDate(fromBuffer, pdfDate.getW3CDate());
                    XmpBasicProperties.setMetaDataDate(fromBuffer, pdfDate.getW3CDate());
                    SerializeOptions serializeOptions = new SerializeOptions();
                    serializeOptions.setPadding(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
                    XMPMetaFactory.serialize(fromBuffer, byteArrayOutputStream2, serializeOptions);
                } else {
                    createXmpWriter(byteArrayOutputStream2, pdfDictionary3).close();
                }
                pdfStream = new PdfStream(byteArrayOutputStream2.toByteArray());
            } catch (XMPException unused2) {
                pdfStream = new PdfStream(streamBytesRaw);
            } catch (IOException unused3) {
                pdfStream = new PdfStream(streamBytesRaw);
            }
        }
        if (pdfStream != null) {
            PdfName pdfName13 = PdfName.TYPE;
            PdfName pdfName14 = PdfName.METADATA;
            pdfStream.put(pdfName13, pdfName14);
            pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
            PdfEncryption pdfEncryption = this.crypto;
            if (pdfEncryption != null && !pdfEncryption.isMetadataEncrypted()) {
                PdfArray pdfArray = new PdfArray();
                pdfArray.add(PdfName.CRYPT);
                pdfStream.put(PdfName.FILTER, pdfArray);
            }
            if (!this.append || pdfObject2 == null) {
                catalog.put(pdfName14, this.body.add(pdfStream).getIndirectReference());
                markUsed(catalog);
            } else {
                this.body.add(pdfStream, pdfObject2.getIndRef());
            }
        }
        if (!this.namedDestinations.isEmpty()) {
            updateNamedDestinations();
        }
        close(indirectReference, number);
    }

    public void correctAcroFieldPages(int i) {
        if (this.acroFields != null && i <= this.reader.getNumberOfPages()) {
            for (AcroFields.Item item : this.acroFields.getFields().values()) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    int iIntValue = item.getPage(i2).intValue();
                    if (iIntValue >= i) {
                        item.forcePage(i2, iIntValue + 1);
                    }
                }
            }
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void createXmpMetadata() {
        try {
            this.xmpWriter = createXmpWriter((ByteArrayOutputStream) null, this.reader.getInfo());
            this.xmpMetadata = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteOutlines() {
        PdfDictionary catalog = this.reader.getCatalog();
        PdfName pdfName = PdfName.OUTLINES;
        PdfObject pdfObject = catalog.get(pdfName);
        if (pdfObject == null) {
            return;
        }
        if (pdfObject instanceof PRIndirectReference) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            outlineTravel(pRIndirectReference);
            PdfReader.killIndirect(pRIndirectReference);
        }
        catalog.remove(pdfName);
        markUsed(catalog);
    }

    public void eliminateAcroformObjects() {
        PdfObject pdfObject = this.reader.getCatalog().get(PdfName.ACROFORM);
        if (pdfObject == null) {
            return;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pdfObject);
        PdfReader pdfReader = this.reader;
        PdfName pdfName = PdfName.XFA;
        pdfReader.killXref(pdfDictionary.get(pdfName));
        pdfDictionary.remove(pdfName);
        PdfName pdfName2 = PdfName.FIELDS;
        PdfObject pdfObject2 = pdfDictionary.get(pdfName2);
        if (pdfObject2 != null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(PdfName.KIDS, pdfObject2);
            sweepKids(pdfDictionary2);
            PdfReader.killIndirect(pdfObject2);
            pdfDictionary.put(pdfName2, new PdfArray());
        }
        pdfDictionary.remove(PdfName.SIGFLAGS);
        pdfDictionary.remove(PdfName.NEEDAPPEARANCES);
        pdfDictionary.remove(PdfName.DR);
    }

    public void expandFields(PdfFormField pdfFormField, ArrayList<PdfAnnotation> arrayList) {
        arrayList.add(pdfFormField);
        ArrayList<PdfFormField> kids = pdfFormField.getKids();
        if (kids != null) {
            for (int i = 0; i < kids.size(); i++) {
                expandFields(kids.get(i), arrayList);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:120:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:63:0x015e  */
    public void flatFields() {
        int i;
        PdfDictionary pdfDictionary;
        PdfDictionary pageN;
        PdfArray asArray;
        int i2;
        int i3;
        PdfTemplate pdfAppearance;
        PdfName asName;
        PdfIndirectReference pdfIndirectReference;
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        int i7 = 0;
        if (this.append) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("field.flattening.is.not.supported.in.append.mode", new Object[0]));
        }
        getAcroFields();
        Map<String, AcroFields.Item> fields = this.acroFields.getFields();
        if (this.fieldsAdded && this.partialFlattening.isEmpty()) {
            Iterator<String> it = fields.keySet().iterator();
            while (it.hasNext()) {
                this.partialFlattening.add(it.next());
            }
        }
        PdfDictionary asDict = this.reader.getCatalog().getAsDict(PdfName.ACROFORM);
        PdfArray pdfArray = asDict != null ? (PdfArray) PdfReader.getPdfObject(asDict.get(PdfName.FIELDS), asDict) : null;
        for (Map.Entry<String, AcroFields.Item> entry : fields.entrySet()) {
            String key = entry.getKey();
            if (this.partialFlattening.isEmpty() || this.partialFlattening.contains(key)) {
                AcroFields.Item value = entry.getValue();
                int i8 = 0;
                while (i8 < value.size()) {
                    PdfDictionary merged = value.getMerged(i8);
                    PdfNumber asNumber = merged.getAsNumber(PdfName.F);
                    int iIntValue = asNumber != null ? asNumber.intValue() : 0;
                    int iIntValue2 = value.getPage(i8).intValue();
                    if (iIntValue2 < i6) {
                        i2 = 1;
                    } else {
                        PdfName pdfName = PdfName.AP;
                        PdfDictionary asDict2 = merged.getAsDict(pdfName);
                        if (asDict2 != null) {
                            PdfName pdfName2 = PdfName.N;
                            PdfDictionary asStream = asDict2.getAsStream(pdfName2);
                            if (asStream == null) {
                                asStream = asDict2.getAsDict(pdfName2);
                            }
                            pdfDictionary = asStream;
                        } else {
                            pdfDictionary = null;
                        }
                        if (this.acroFields.isGenerateAppearances()) {
                            if (asDict2 == null || pdfDictionary == null) {
                                try {
                                    this.acroFields.regenerateField(key);
                                    asDict2 = this.acroFields.getFieldItem(key).getMerged(i8).getAsDict(pdfName);
                                } catch (DocumentException | IOException unused) {
                                }
                            } else if (pdfDictionary.isStream()) {
                                PdfStream pdfStream = (PdfStream) pdfDictionary;
                                PdfArray asArray2 = pdfStream.getAsArray(PdfName.BBOX);
                                PdfArray asArray3 = merged.getAsArray(PdfName.RECT);
                                if (asArray2 != null && asArray3 != null) {
                                    float fFloatValue = asArray3.getAsNumber(i5).floatValue() - asArray3.getAsNumber(i7).floatValue();
                                    float fFloatValue2 = asArray2.getAsNumber(i5).floatValue() - asArray2.getAsNumber(i7).floatValue();
                                    float fFloatValue3 = asArray3.getAsNumber(i4).floatValue() - asArray3.getAsNumber(1).floatValue();
                                    float fFloatValue4 = asArray2.getAsNumber(i4).floatValue() - asArray2.getAsNumber(1).floatValue();
                                    float fAbs = Math.abs(fFloatValue2 != 0.0f ? fFloatValue / fFloatValue2 : Float.MAX_VALUE);
                                    float fAbs2 = Math.abs(fFloatValue4 != 0.0f ? fFloatValue3 / fFloatValue4 : Float.MAX_VALUE);
                                    if (fAbs != 1.0f || fAbs2 != 1.0f) {
                                        float[] fArr = new float[6];
                                        fArr[i7] = fAbs;
                                        fArr[1] = 0.0f;
                                        fArr[2] = 0.0f;
                                        fArr[i4] = fAbs2;
                                        fArr[4] = 0.0f;
                                        fArr[5] = 0.0f;
                                        pdfStream.put(PdfName.MATRIX, new NumberArray(fArr));
                                        markUsed(pdfStream);
                                    }
                                }
                            }
                        } else if (asDict2 != null && pdfDictionary != null) {
                            PdfArray asArray4 = pdfDictionary.getAsArray(PdfName.BBOX);
                            PdfArray asArray5 = merged.getAsArray(PdfName.RECT);
                            if (asArray4 != null && asArray5 != null) {
                                float fFloatValue5 = (asArray4.getAsNumber(2).floatValue() - asArray4.getAsNumber(i7).floatValue()) - (asArray5.getAsNumber(2).floatValue() - asArray5.getAsNumber(i7).floatValue());
                                float fFloatValue6 = (asArray4.getAsNumber(i4).floatValue() - asArray4.getAsNumber(1).floatValue()) - (asArray5.getAsNumber(i4).floatValue() - asArray5.getAsNumber(1).floatValue());
                                if (Math.abs(fFloatValue5) > 1.0f || Math.abs(fFloatValue6) > 1.0f) {
                                    this.acroFields.setGenerateAppearances(true);
                                    this.acroFields.regenerateField(key);
                                    this.acroFields.setGenerateAppearances(false);
                                    asDict2 = this.acroFields.getFieldItem(key).getMerged(i8).getAsDict(pdfName);
                                }
                            }
                        }
                        if (asDict2 != null && (iIntValue & 4) != 0) {
                            if ((iIntValue & 2) == 0) {
                                PdfObject pdfObject = asDict2.get(PdfName.N);
                                if (pdfObject != null) {
                                    PdfObject pdfObject2 = PdfReader.getPdfObject(pdfObject);
                                    if ((pdfObject instanceof PdfIndirectReference) && !pdfObject.isIndirect()) {
                                        pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject);
                                    } else if (pdfObject2 instanceof PdfStream) {
                                        ((PdfDictionary) pdfObject2).put(PdfName.SUBTYPE, PdfName.FORM);
                                        pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject);
                                    } else if (pdfObject2 == null || !pdfObject2.isDictionary() || (asName = merged.getAsName(PdfName.AS)) == null || (pdfIndirectReference = (PdfIndirectReference) ((PdfDictionary) pdfObject2).get(asName)) == null) {
                                        pdfAppearance = null;
                                    } else {
                                        pdfAppearance = new PdfAppearance(pdfIndirectReference);
                                        if (pdfIndirectReference.isIndirect()) {
                                            ((PdfDictionary) PdfReader.getPdfObject(pdfIndirectReference)).put(PdfName.SUBTYPE, PdfName.FORM);
                                        }
                                    }
                                } else {
                                    pdfAppearance = null;
                                }
                                if (pdfAppearance != null) {
                                    Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(merged.getAsArray(PdfName.RECT));
                                    PdfContentByte overContent = getOverContent(iIntValue2);
                                    overContent.setLiteral("Q ");
                                    overContent.addTemplate(pdfAppearance, normalizedRectangle.getLeft(), normalizedRectangle.getBottom());
                                    overContent.setLiteral("q ");
                                }
                            }
                        }
                        if (this.partialFlattening.isEmpty() || (asArray = (pageN = this.reader.getPageN(iIntValue2)).getAsArray(PdfName.ANNOTS)) == null) {
                            i2 = 1;
                        } else {
                            int i9 = 0;
                            while (i9 < asArray.size()) {
                                PdfObject pdfObject3 = asArray.getPdfObject(i9);
                                if (pdfObject3.isIndirect()) {
                                    PdfIndirectReference widgetRef = value.getWidgetRef(i8);
                                    if (widgetRef.isIndirect()) {
                                        PRIndirectReference pRIndirectReference = (PRIndirectReference) widgetRef;
                                        if (((PRIndirectReference) pdfObject3).getNumber() == pRIndirectReference.getNumber()) {
                                            int i10 = i9 - 1;
                                            asArray.remove(i9);
                                            while (true) {
                                                PRIndirectReference pRIndirectReference2 = (PRIndirectReference) ((PdfDictionary) PdfReader.getPdfObject(pRIndirectReference)).get(PdfName.PARENT);
                                                PdfReader.killIndirect(pRIndirectReference);
                                                if (pRIndirectReference2 == null) {
                                                    int i11 = 0;
                                                    while (i11 < pdfArray.size()) {
                                                        PdfObject pdfObject4 = pdfArray.getPdfObject(i11);
                                                        if (pdfObject4.isIndirect() && ((PRIndirectReference) pdfObject4).getNumber() == pRIndirectReference.getNumber()) {
                                                            pdfArray.remove(i11);
                                                            i11--;
                                                        }
                                                        i11++;
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                PdfArray asArray6 = ((PdfDictionary) PdfReader.getPdfObject(pRIndirectReference2)).getAsArray(PdfName.KIDS);
                                                int i12 = 0;
                                                while (i12 < asArray6.size()) {
                                                    PdfObject pdfObject5 = asArray6.getPdfObject(i12);
                                                    if (pdfObject5.isIndirect() && ((PRIndirectReference) pdfObject5).getNumber() == pRIndirectReference.getNumber()) {
                                                        asArray6.remove(i12);
                                                        i12--;
                                                    }
                                                    i12++;
                                                }
                                                i3 = 1;
                                                if (!asArray6.isEmpty()) {
                                                    break;
                                                } else {
                                                    pRIndirectReference = pRIndirectReference2;
                                                }
                                            }
                                            i9 = i10;
                                        } else {
                                            i3 = 1;
                                        }
                                    } else {
                                        i3 = 1;
                                    }
                                } else {
                                    i3 = 1;
                                }
                                i9 += i3;
                            }
                            i2 = 1;
                            if (asArray.isEmpty()) {
                                PdfName pdfName3 = PdfName.ANNOTS;
                                PdfReader.killIndirect(pageN.get(pdfName3));
                                pageN.remove(pdfName3);
                            }
                        }
                    }
                    i8 += i2;
                    i4 = 3;
                    i5 = 2;
                    i6 = 1;
                    i7 = 0;
                }
                i6 = 1;
            }
        }
        if (this.fieldsAdded || !this.partialFlattening.isEmpty()) {
            return;
        }
        int i13 = 1;
        while (i13 <= this.reader.getNumberOfPages()) {
            PdfDictionary pageN2 = this.reader.getPageN(i13);
            PdfArray asArray7 = pageN2.getAsArray(PdfName.ANNOTS);
            if (asArray7 == null) {
                i = 1;
            } else {
                int i14 = 0;
                while (i14 < asArray7.size()) {
                    PdfObject directObject = asArray7.getDirectObject(i14);
                    if ((!(directObject instanceof PdfIndirectReference) || directObject.isIndirect()) && (!directObject.isDictionary() || PdfName.WIDGET.equals(((PdfDictionary) directObject).get(PdfName.SUBTYPE)))) {
                        asArray7.remove(i14);
                        i14--;
                    }
                    i14++;
                }
                i = 1;
                if (asArray7.isEmpty()) {
                    PdfName pdfName4 = PdfName.ANNOTS;
                    PdfReader.killIndirect(pageN2.get(pdfName4));
                    pageN2.remove(pdfName4);
                }
            }
            i13 += i;
        }
        eliminateAcroformObjects();
    }

    public void flatFreeTextFields() {
        flattenAnnotations(true);
    }

    public void flattenAnnotations() {
        flattenAnnotations(false);
    }

    public AcroFields getAcroFields() {
        if (this.acroFields == null) {
            this.acroFields = new AcroFields(this.reader, this);
        }
        return this.acroFields;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public Counter getCounter() {
        return this.COUNTER;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfContentByte getDirectContent() {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.pdfstamper.getundercontent.or.pdfstamper.getovercontent", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfContentByte getDirectContentUnder() {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.pdfstamper.getundercontent.or.pdfstamper.getovercontent", new Object[0]));
    }

    public HashMap<Object, PdfObject> getNamedDestinations() {
        return this.namedDestinations;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        IntHashtable intHashtable = this.readers2intrefs.get(pdfReader);
        if (intHashtable != null) {
            int i3 = intHashtable.get(i);
            if (i3 != 0) {
                return i3;
            }
            int indirectReferenceNumber = getIndirectReferenceNumber();
            intHashtable.put(i, indirectReferenceNumber);
            return indirectReferenceNumber;
        }
        PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
        if (pdfReaderInstance != null) {
            return pdfReaderInstance.getNewObjectNumber(i, i2);
        }
        if (this.append && i < this.initialXrefSize) {
            return i;
        }
        int i4 = this.myXref.get(i);
        if (i4 != 0) {
            return i4;
        }
        int indirectReferenceNumber2 = getIndirectReferenceNumber();
        this.myXref.put(i, indirectReferenceNumber2);
        return indirectReferenceNumber2;
    }

    public PdfContentByte getOverContent(int i) {
        if (i < 1 || i > this.reader.getNumberOfPages()) {
            return null;
        }
        PageStamp pageStamp = getPageStamp(i);
        if (pageStamp.over == null) {
            pageStamp.over = new StampContent(this, pageStamp);
        }
        return pageStamp.over;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference getPageReference(int i) {
        PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(i);
        if (pageOrigRef != null) {
            return pageOrigRef;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.page.number.1", i));
    }

    public PageStamp getPageStamp(int i) {
        PdfDictionary pageN = this.reader.getPageN(i);
        PageStamp pageStamp = this.pagesToContent.get(pageN);
        if (pageStamp != null) {
            return pageStamp;
        }
        PageStamp pageStamp2 = new PageStamp(this, this.reader, pageN);
        this.pagesToContent.put(pageN, pageStamp2);
        return pageStamp2;
    }

    public Map<String, PdfLayer> getPdfLayers() {
        if (!this.originalLayersAreRead) {
            this.originalLayersAreRead = true;
            readOCProperties();
        }
        HashMap map = new HashMap();
        Iterator<PdfOCG> it = this.documentOCG.iterator();
        while (it.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it.next();
            String string = pdfLayer.getTitle() == null ? pdfLayer.getAsString(PdfName.NAME).toString() : pdfLayer.getTitle();
            if (map.containsKey(string)) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append("(");
                int i = 2;
                sb.append(2);
                sb.append(")");
                String string2 = sb.toString();
                while (map.containsKey(string2)) {
                    i++;
                    string2 = string + "(" + i + ")";
                }
                string = string2;
            }
            map.put(string, pdfLayer);
        }
        return map;
    }

    public PdfReader getPdfReader() {
        return this.reader;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            RandomAccessFileOrArray randomAccessFileOrArray = this.readers2file.get(pdfReader);
            return randomAccessFileOrArray != null ? randomAccessFileOrArray : pdfReader.getSafeFile();
        }
        PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
        return pdfReaderInstance == null ? this.file : pdfReaderInstance.getReaderFile();
    }

    public PdfContentByte getUnderContent(int i) {
        if (i < 1 || i > this.reader.getNumberOfPages()) {
            return null;
        }
        PageStamp pageStamp = getPageStamp(i);
        if (pageStamp.under == null) {
            pageStamp.under = new StampContent(this, pageStamp);
        }
        return pageStamp.under;
    }

    public void insertPage(int i, Rectangle rectangle) {
        PdfDictionary asDict;
        PRIndirectReference pRIndirectReference;
        Rectangle rectangle2 = new Rectangle(rectangle);
        int rotation = rectangle2.getRotation() % 360;
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.PAGE);
        pdfDictionary.put(PdfName.RESOURCES, new PdfDictionary());
        pdfDictionary.put(PdfName.ROTATE, new PdfNumber(rotation));
        pdfDictionary.put(PdfName.MEDIABOX, new PdfRectangle(rectangle2, rotation));
        PRIndirectReference pRIndirectReferenceAddPdfObject = this.reader.addPdfObject(pdfDictionary);
        if (i > this.reader.getNumberOfPages()) {
            PdfReader pdfReader = this.reader;
            pRIndirectReference = new PRIndirectReference(this.reader, ((PRIndirectReference) pdfReader.getPageNRelease(pdfReader.getNumberOfPages()).get(PdfName.PARENT)).getNumber());
            asDict = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
            PdfArray pdfArray = (PdfArray) PdfReader.getPdfObject(asDict.get(PdfName.KIDS), asDict);
            pdfArray.add(pRIndirectReferenceAddPdfObject);
            markUsed(pdfArray);
            this.reader.pageRefs.insertPage(i, pRIndirectReferenceAddPdfObject);
        } else {
            if (i < 1) {
                i = 1;
            }
            PdfDictionary pageN = this.reader.getPageN(i);
            PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(i);
            this.reader.releasePage(i);
            PRIndirectReference pRIndirectReference2 = new PRIndirectReference(this.reader, ((PRIndirectReference) pageN.get(PdfName.PARENT)).getNumber());
            asDict = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference2);
            PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObject(asDict.get(PdfName.KIDS), asDict);
            int size = pdfArray2.size();
            int number = pageOrigRef.getNumber();
            for (int i2 = 0; i2 < size; i2++) {
                if (number == ((PRIndirectReference) pdfArray2.getPdfObject(i2)).getNumber()) {
                    pdfArray2.add(i2, pRIndirectReferenceAddPdfObject);
                    break;
                }
            }
            if (size == pdfArray2.size()) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("internal.inconsistence", new Object[0]));
            }
            markUsed(pdfArray2);
            this.reader.pageRefs.insertPage(i, pRIndirectReferenceAddPdfObject);
            correctAcroFieldPages(i);
            pRIndirectReference = pRIndirectReference2;
        }
        pdfDictionary.put(PdfName.PARENT, pRIndirectReference);
        while (asDict != null) {
            markUsed(asDict);
            PdfName pdfName = PdfName.COUNT;
            asDict.put(pdfName, new PdfNumber(((PdfNumber) PdfReader.getPdfObjectRelease(asDict.get(pdfName))).intValue() + 1));
            asDict = asDict.getAsDict(PdfName.PARENT);
        }
    }

    public boolean isAppend() {
        return this.append;
    }

    public boolean isContentWritten() {
        return this.body.size() > 1;
    }

    public boolean isRotateContents() {
        return this.rotateContents;
    }

    public void makePackage(PdfCollection pdfCollection) {
        this.reader.getCatalog().put(PdfName.COLLECTION, pdfCollection);
    }

    public void markUsed(PdfObject pdfObject) {
        if (!this.append || pdfObject == null) {
            return;
        }
        PRIndirectReference indRef = pdfObject.type() == 10 ? (PRIndirectReference) pdfObject : pdfObject.getIndRef();
        if (indRef != null) {
            this.marked.put(indRef.getNumber(), 1);
        }
    }

    public boolean partialFormFlattening(String str) {
        getAcroFields();
        if (this.acroFields.getXfa().isXfaPresent()) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("partial.form.flattening.is.not.supported.with.xfa.forms", new Object[0]));
        }
        if (!this.acroFields.getFields().containsKey(str)) {
            return false;
        }
        this.partialFlattening.add(str);
        return true;
    }

    public void readColorProfile() {
        PdfDictionary asDict;
        PdfArray asArray = this.reader.getCatalog().getAsArray(PdfName.OUTPUTINTENTS);
        if (asArray == null || asArray.size() <= 0) {
            return;
        }
        PdfStream asStream = null;
        for (int i = 0; i < asArray.size() && ((asDict = asArray.getAsDict(i)) == null || (asStream = asDict.getAsStream(PdfName.DESTOUTPUTPROFILE)) == null); i++) {
        }
        if (asStream instanceof PRStream) {
            try {
                this.colorProfile = ICC_Profile.getInstance(PdfReader.getStreamBytes((PRStream) asStream));
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public void readOCProperties() {
        PdfDictionary asDict;
        if (this.documentOCG.isEmpty() && (asDict = this.reader.getCatalog().getAsDict(PdfName.OCPROPERTIES)) != null) {
            PdfArray asArray = asDict.getAsArray(PdfName.OCGS);
            HashMap map = new HashMap();
            ListIterator<PdfObject> listIterator = asArray.listIterator();
            while (listIterator.hasNext()) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) listIterator.next();
                PdfLayer pdfLayer = new PdfLayer(null);
                pdfLayer.setRef(pdfIndirectReference);
                pdfLayer.setOnPanel(false);
                pdfLayer.merge((PdfDictionary) PdfReader.getPdfObject(pdfIndirectReference));
                map.put(pdfIndirectReference.toString(), pdfLayer);
            }
            PdfDictionary asDict2 = asDict.getAsDict(PdfName.D);
            PdfArray asArray2 = asDict2.getAsArray(PdfName.OFF);
            if (asArray2 != null) {
                ListIterator<PdfObject> listIterator2 = asArray2.listIterator();
                while (listIterator2.hasNext()) {
                    ((PdfLayer) map.get(((PdfIndirectReference) listIterator2.next()).toString())).setOn(false);
                }
            }
            PdfArray asArray3 = asDict2.getAsArray(PdfName.ORDER);
            if (asArray3 != null) {
                addOrder(null, asArray3, map);
            }
            this.documentOCG.addAll(map.values());
            PdfArray asArray4 = asDict2.getAsArray(PdfName.RBGROUPS);
            this.OCGRadioGroup = asArray4;
            if (asArray4 == null) {
                this.OCGRadioGroup = new PdfArray();
            }
            PdfArray asArray5 = asDict2.getAsArray(PdfName.LOCKED);
            this.OCGLocked = asArray5;
            if (asArray5 == null) {
                this.OCGLocked = new PdfArray();
            }
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void registerLayer(PdfOCG pdfOCG) {
        if (!this.originalLayersAreRead) {
            this.originalLayersAreRead = true;
            readOCProperties();
        }
        super.registerLayer(pdfOCG);
    }

    public void registerReader(PdfReader pdfReader, boolean z) {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            return;
        }
        this.readers2intrefs.put(pdfReader, new IntHashtable());
        if (z) {
            RandomAccessFileOrArray safeFile = pdfReader.getSafeFile();
            this.readers2file.put(pdfReader, safeFile);
            safeFile.reOpen();
        }
    }

    public void replacePage(PdfReader pdfReader, int i, int i2) {
        PdfDictionary pageN = this.reader.getPageN(i2);
        if (this.pagesToContent.containsKey(pageN)) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("this.page.cannot.be.replaced.new.content.was.already.added", new Object[0]));
        }
        PdfImportedPage importedPage = getImportedPage(pdfReader, i);
        PdfDictionary pageNRelease = this.reader.getPageNRelease(i2);
        pageNRelease.remove(PdfName.RESOURCES);
        pageNRelease.remove(PdfName.CONTENTS);
        moveRectangle(pageNRelease, pdfReader, i, PdfName.MEDIABOX, "media");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.CROPBOX, "crop");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.TRIMBOX, "trim");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.ARTBOX, "art");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.BLEEDBOX, "bleed");
        pageNRelease.put(PdfName.ROTATE, new PdfNumber(pdfReader.getPageRotation(i)));
        getOverContent(i2).addTemplate((PdfTemplate) importedPage, 0.0f, 0.0f);
        PageStamp pageStamp = this.pagesToContent.get(pageN);
        pageStamp.replacePoint = pageStamp.over.getInternalBuffer().size();
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws PdfException {
        if (!pdfName.equals(PdfWriter.DOCUMENT_CLOSE) && !pdfName.equals(PdfWriter.WILL_SAVE) && !pdfName.equals(PdfWriter.DID_SAVE) && !pdfName.equals(PdfWriter.WILL_PRINT) && !pdfName.equals(PdfWriter.DID_PRINT)) {
            throw new PdfException(MessageLocalization.getComposedMessage("invalid.additional.action.type.1", pdfName.toString()));
        }
        PdfDictionary catalog = this.reader.getCatalog();
        PdfName pdfName2 = PdfName.AA;
        PdfDictionary asDict = catalog.getAsDict(pdfName2);
        if (asDict == null) {
            if (pdfAction == null) {
                return;
            }
            asDict = new PdfDictionary();
            this.reader.getCatalog().put(pdfName2, asDict);
        }
        markUsed(asDict);
        if (pdfAction == null) {
            asDict.remove(pdfName);
        } else {
            asDict.put(pdfName, pdfAction);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setDuration(int i) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    public void setFlatAnnotations(boolean z) {
        this.flatannotations = z;
    }

    public void setFormFlattening(boolean z) {
        this.flat = z;
    }

    public void setFreeTextFlattening(boolean z) {
        this.flatFreeText = z;
    }

    public void setJavaScript() {
        HashMap<String, PdfObject> documentLevelJS = this.pdf.getDocumentLevelJS();
        if (documentLevelJS.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        PdfName pdfName = PdfName.NAMES;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(pdfName), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(pdfName, pdfDictionary);
            markUsed(catalog);
        }
        markUsed(pdfDictionary);
        pdfDictionary.put(PdfName.JAVASCRIPT, addToBody(PdfNameTree.writeTree(documentLevelJS, this)).getIndirectReference());
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setOpenAction(PdfAction pdfAction) {
        this.openAction = pdfAction;
    }

    public void setOutlines() {
        if (this.newBookmarks == null) {
            return;
        }
        deleteOutlines();
        if (this.newBookmarks.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        writeOutlines(catalog, catalog.get(PdfName.DESTS) != null);
        markUsed(catalog);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setPageAction(PdfName pdfName, PdfAction pdfAction) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    public void setRotateContents(boolean z) {
        this.rotateContents = z;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void setSigFlags(int i) {
        this.sigFlags = i | this.sigFlags;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void setThumbnail(Image image) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.pdfstamper.setthumbnail", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setTransition(PdfTransition pdfTransition) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    public void setViewerPreferences() {
        this.reader.setViewerPreferences(this.viewerPreferences);
        markUsed(this.reader.getTrailer().get(PdfName.ROOT));
    }

    public void sweepKids(PdfObject pdfObject) {
        PdfArray pdfArray;
        PdfObject pdfObjectKillIndirect = PdfReader.killIndirect(pdfObject);
        if (pdfObjectKillIndirect == null || !pdfObjectKillIndirect.isDictionary() || (pdfArray = (PdfArray) PdfReader.killIndirect(((PdfDictionary) pdfObjectKillIndirect).get(PdfName.KIDS))) == null) {
            return;
        }
        for (int i = 0; i < pdfArray.size(); i++) {
            sweepKids(pdfArray.getPdfObject(i));
        }
    }

    public void unRegisterReader(PdfReader pdfReader) {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            this.readers2intrefs.remove(pdfReader);
            RandomAccessFileOrArray randomAccessFileOrArray = this.readers2file.get(pdfReader);
            if (randomAccessFileOrArray == null) {
                return;
            }
            this.readers2file.remove(pdfReader);
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
        }
    }

    public void updateNamedDestinations() {
        PdfDictionary catalog = this.reader.getCatalog();
        PdfName pdfName = PdfName.NAMES;
        PdfDictionary asDict = catalog.getAsDict(pdfName);
        if (asDict != null) {
            asDict = asDict.getAsDict(PdfName.DESTS);
        }
        if (asDict == null) {
            asDict = this.reader.getCatalog().getAsDict(PdfName.DESTS);
        }
        if (asDict == null) {
            asDict = new PdfDictionary();
            PdfDictionary pdfDictionary = new PdfDictionary();
            asDict.put(pdfName, new PdfArray());
            pdfDictionary.put(PdfName.DESTS, asDict);
            this.reader.getCatalog().put(pdfName, pdfDictionary);
        }
        PdfArray lastChildInNameTree = getLastChildInNameTree(asDict);
        for (Object obj : this.namedDestinations.keySet()) {
            lastChildInNameTree.add(new PdfString(obj.toString()));
            lastChildInNameTree.add(addToBody(this.namedDestinations.get(obj), getPdfIndirectReference()).getIndirectReference());
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088  */
    /* JADX WARN: Code duplicated, block: B:37:0x008d  */
    /* JADX WARN: Code duplicated, block: B:69:0x0116  */
    /* JADX WARN: Code duplicated, block: B:74:0x017c  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a9 A[SYNTHETIC] */
    private void flattenAnnotations(boolean z) {
        PdfNumber asNumber;
        int iIntValue;
        PdfObject pdfObject;
        PdfAppearance pdfAppearance;
        PdfName asName;
        PdfIndirectReference pdfIndirectReference;
        PdfAppearance pdfAppearance2;
        Rectangle normalizedRectangle;
        Rectangle normalizedRectangle2;
        PdfContentByte overContent;
        PdfName pdfName;
        PdfContentByte pdfContentByte;
        if (this.append) {
            if (!z) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("annotation.flattening.is.not.supported.in.append.mode", new Object[0]));
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("freetext.flattening.is.not.supported.in.append.mode", new Object[0]));
        }
        for (int i = 1; i <= this.reader.getNumberOfPages(); i++) {
            PdfDictionary pageN = this.reader.getPageN(i);
            PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
            if (asArray != null) {
                int i2 = 0;
                while (i2 < asArray.size()) {
                    PdfObject directObject = asArray.getDirectObject(i2);
                    if ((!(directObject instanceof PdfIndirectReference) || directObject.isIndirect()) && (directObject instanceof PdfDictionary)) {
                        PdfDictionary pdfDictionary = (PdfDictionary) directObject;
                        if (z) {
                            if (pdfDictionary.get(PdfName.SUBTYPE).equals(PdfName.FREETEXT)) {
                                asNumber = pdfDictionary.getAsNumber(PdfName.F);
                                if (asNumber != null) {
                                    iIntValue = asNumber.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                                if ((iIntValue & 4) == 0 && (iIntValue & 2) == 0 && (pdfObject = pdfDictionary.get(PdfName.AP)) != null) {
                                    if (pdfObject instanceof PdfIndirectReference) {
                                        pdfObject = PdfReader.getPdfObject(pdfObject);
                                    }
                                    PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject;
                                    PdfName pdfName2 = PdfName.N;
                                    PdfObject pdfObject2 = pdfDictionary2.get(pdfName2);
                                    PdfStream asStream = pdfDictionary2.getAsStream(pdfName2);
                                    PdfObject pdfObject3 = PdfReader.getPdfObject(pdfObject2);
                                    if ((pdfObject2 instanceof PdfIndirectReference) && !pdfObject2.isIndirect()) {
                                        pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject2);
                                    } else if (pdfObject3 instanceof PdfStream) {
                                        ((PdfDictionary) pdfObject3).put(PdfName.SUBTYPE, PdfName.FORM);
                                        pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject2);
                                    } else {
                                        if (!pdfObject3.isDictionary() || (asName = pdfDictionary2.getAsName(PdfName.AS)) == null || (pdfIndirectReference = (PdfIndirectReference) ((PdfDictionary) pdfObject3).get(asName)) == null) {
                                            pdfAppearance = null;
                                        } else {
                                            PdfAppearance pdfAppearance3 = new PdfAppearance(pdfIndirectReference);
                                            if (pdfIndirectReference.isIndirect()) {
                                                ((PdfDictionary) PdfReader.getPdfObject(pdfIndirectReference)).put(PdfName.SUBTYPE, PdfName.FORM);
                                            }
                                            pdfAppearance2 = pdfAppearance3;
                                        }
                                        if (pdfAppearance2 != null) {
                                            normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
                                            normalizedRectangle2 = PdfReader.getNormalizedRectangle(asStream.getAsArray(PdfName.BBOX));
                                            overContent = getOverContent(i);
                                            overContent.setLiteral("Q ");
                                            pdfName = PdfName.MATRIX;
                                            if (asStream.getAsArray(pdfName) != null || Arrays.equals(this.DEFAULT_MATRIX, asStream.getAsArray(pdfName).asDoubleArray())) {
                                                pdfContentByte = overContent;
                                                pdfContentByte.addTemplate((PdfTemplate) pdfAppearance2, normalizedRectangle.getWidth() / normalizedRectangle2.getWidth(), 0.0f, 0.0f, normalizedRectangle.getHeight() / normalizedRectangle2.getHeight(), normalizedRectangle.getLeft(), normalizedRectangle.getBottom());
                                            } else {
                                                Rectangle rectangleTransformBBoxByMatrix = transformBBoxByMatrix(normalizedRectangle2, asStream.getAsArray(pdfName).asDoubleArray());
                                                pdfContentByte = overContent;
                                                overContent.addTemplate((PdfTemplate) pdfAppearance2, normalizedRectangle.getWidth() / rectangleTransformBBoxByMatrix.getWidth(), 0.0f, 0.0f, normalizedRectangle.getHeight() / rectangleTransformBBoxByMatrix.getHeight(), normalizedRectangle.getLeft(), normalizedRectangle.getBottom());
                                            }
                                            pdfContentByte.setLiteral("q ");
                                            asArray.remove(i2);
                                            i2--;
                                        }
                                    }
                                    pdfAppearance2 = pdfAppearance;
                                    if (pdfAppearance2 != null) {
                                        normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
                                        normalizedRectangle2 = PdfReader.getNormalizedRectangle(asStream.getAsArray(PdfName.BBOX));
                                        overContent = getOverContent(i);
                                        overContent.setLiteral("Q ");
                                        pdfName = PdfName.MATRIX;
                                        if (asStream.getAsArray(pdfName) != null) {
                                            pdfContentByte = overContent;
                                            pdfContentByte.addTemplate((PdfTemplate) pdfAppearance2, normalizedRectangle.getWidth() / normalizedRectangle2.getWidth(), 0.0f, 0.0f, normalizedRectangle.getHeight() / normalizedRectangle2.getHeight(), normalizedRectangle.getLeft(), normalizedRectangle.getBottom());
                                        } else {
                                            pdfContentByte = overContent;
                                            pdfContentByte.addTemplate((PdfTemplate) pdfAppearance2, normalizedRectangle.getWidth() / normalizedRectangle2.getWidth(), 0.0f, 0.0f, normalizedRectangle.getHeight() / normalizedRectangle2.getHeight(), normalizedRectangle.getLeft(), normalizedRectangle.getBottom());
                                        }
                                        pdfContentByte.setLiteral("q ");
                                        asArray.remove(i2);
                                        i2--;
                                    }
                                }
                            }
                        } else if (!pdfDictionary.get(PdfName.SUBTYPE).equals(PdfName.WIDGET)) {
                            asNumber = pdfDictionary.getAsNumber(PdfName.F);
                            if (asNumber != null) {
                                iIntValue = asNumber.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            if ((iIntValue & 4) == 0) {
                            }
                        }
                    }
                    i2++;
                }
                if (asArray.isEmpty()) {
                    PdfName pdfName3 = PdfName.ANNOTS;
                    PdfReader.killIndirect(pageN.get(pdfName3));
                    pageN.remove(pdfName3);
                }
            }
        }
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation, PdfDictionary pdfDictionary) {
        PdfArray pdfArray;
        HashSet<PdfTemplate> templates;
        try {
            ArrayList<PdfAnnotation> arrayList = new ArrayList<>();
            if (pdfAnnotation.isForm()) {
                this.fieldsAdded = true;
                getAcroFields();
                PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
                if (pdfFormField.getParent() != null) {
                    return;
                } else {
                    expandFields(pdfFormField, arrayList);
                }
            } else {
                arrayList.add(pdfAnnotation);
            }
            for (int i = 0; i < arrayList.size(); i++) {
                PdfAnnotation pdfAnnotation2 = arrayList.get(i);
                if (pdfAnnotation2.getPlaceInPage() > 0) {
                    pdfDictionary = this.reader.getPageN(pdfAnnotation2.getPlaceInPage());
                }
                if (pdfAnnotation2.isForm()) {
                    if (!pdfAnnotation2.isUsed() && (templates = pdfAnnotation2.getTemplates()) != null) {
                        this.fieldTemplates.addAll(templates);
                    }
                    PdfFormField pdfFormField2 = (PdfFormField) pdfAnnotation2;
                    if (pdfFormField2.getParent() == null) {
                        addDocumentField(pdfFormField2.getIndirectReference());
                    }
                }
                if (pdfAnnotation2.isAnnotation()) {
                    PdfName pdfName = PdfName.ANNOTS;
                    PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName), pdfDictionary);
                    if (pdfObject == null || !pdfObject.isArray()) {
                        pdfArray = new PdfArray();
                        pdfDictionary.put(pdfName, pdfArray);
                        markUsed(pdfDictionary);
                    } else {
                        pdfArray = (PdfArray) pdfObject;
                    }
                    pdfArray.add(pdfAnnotation2.getIndirectReference());
                    markUsed(pdfArray);
                    if (!pdfAnnotation2.isUsed()) {
                        PdfName pdfName2 = PdfName.RECT;
                        PdfRectangle pdfRectangle = (PdfRectangle) pdfAnnotation2.get(pdfName2);
                        if (pdfRectangle != null && (pdfRectangle.left() != 0.0f || pdfRectangle.right() != 0.0f || pdfRectangle.top() != 0.0f || pdfRectangle.bottom() != 0.0f)) {
                            int pageRotation = this.reader.getPageRotation(pdfDictionary);
                            Rectangle pageSizeWithRotation = this.reader.getPageSizeWithRotation(pdfDictionary);
                            if (pageRotation == 90) {
                                pdfAnnotation2.put(pdfName2, new PdfRectangle(pageSizeWithRotation.getTop() - pdfRectangle.top(), pdfRectangle.right(), pageSizeWithRotation.getTop() - pdfRectangle.bottom(), pdfRectangle.left()));
                            } else if (pageRotation == 180) {
                                pdfAnnotation2.put(pdfName2, new PdfRectangle(pageSizeWithRotation.getRight() - pdfRectangle.left(), pageSizeWithRotation.getTop() - pdfRectangle.bottom(), pageSizeWithRotation.getRight() - pdfRectangle.right(), pageSizeWithRotation.getTop() - pdfRectangle.top()));
                            } else if (pageRotation == 270) {
                                pdfAnnotation2.put(pdfName2, new PdfRectangle(pdfRectangle.bottom(), pageSizeWithRotation.getRight() - pdfRectangle.left(), pdfRectangle.top(), pageSizeWithRotation.getRight() - pdfRectangle.right()));
                            }
                        }
                    }
                }
                if (!pdfAnnotation2.isUsed()) {
                    pdfAnnotation2.setUsed();
                    addToBody(pdfAnnotation2, pdfAnnotation2.getIndirectReference());
                }
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setDuration(int i, int i2) {
        PdfDictionary pageN = this.reader.getPageN(i2);
        if (i < 0) {
            pageN.remove(PdfName.DUR);
        } else {
            pageN.put(PdfName.DUR, new PdfNumber(i));
        }
        markUsed(pageN);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setOpenAction(String str) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("open.actions.by.name.are.not.supported", new Object[0]));
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction, int i) {
        if (!pdfName.equals(PdfWriter.PAGE_OPEN) && !pdfName.equals(PdfWriter.PAGE_CLOSE)) {
            throw new PdfException(MessageLocalization.getComposedMessage("invalid.page.additional.action.type.1", pdfName.toString()));
        }
        PdfDictionary pageN = this.reader.getPageN(i);
        PdfName pdfName2 = PdfName.AA;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pageN.get(pdfName2), pageN);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            pageN.put(pdfName2, pdfDictionary);
            markUsed(pageN);
        }
        pdfDictionary.put(pdfName, pdfAction);
        markUsed(pdfDictionary);
    }

    public void setThumbnail(Image image, int i) {
        PdfIndirectReference imageReference = getImageReference(addDirectImageSimple(image));
        this.reader.resetReleasePage();
        this.reader.getPageN(i).put(PdfName.THUMB, imageReference);
        this.reader.resetReleasePage();
    }

    public void setTransition(PdfTransition pdfTransition, int i) {
        PdfDictionary pageN = this.reader.getPageN(i);
        if (pdfTransition == null) {
            pageN.remove(PdfName.TRANS);
        } else {
            pageN.put(PdfName.TRANS, pdfTransition.getTransitionDictionary());
        }
        markUsed(pageN);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.useVp = true;
        this.viewerPreferences.setViewerPreferences(i);
    }

    public void markUsed(int i) {
        if (this.append) {
            this.marked.put(i, 1);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        if (pdfAnnotation.isAnnotation()) {
            pdfAnnotation.setPage(i);
        }
        addAnnotation(pdfAnnotation, this.reader.getPageN(i));
    }

    public void close(PdfIndirectReference pdfIndirectReference, int i) throws IOException {
        PdfIndirectReference pdfIndirectReference2;
        PdfObject pdfObjectCreateInfoId;
        PdfIndirectReference indirectReference;
        alterContents();
        int number = ((PRIndirectReference) this.reader.trailer.get(PdfName.ROOT)).getNumber();
        if (this.append) {
            int[] keys = this.marked.getKeys();
            for (int i2 = 0; i2 < keys.length; i2++) {
                int i3 = keys[i2];
                PdfObject pdfObjectRelease = this.reader.getPdfObjectRelease(i3);
                if (pdfObjectRelease != null && i != i3 && i3 < this.initialXrefSize) {
                    addToBody(pdfObjectRelease, pdfObjectRelease.getIndRef(), i3 != number);
                }
            }
            for (int i4 = this.initialXrefSize; i4 < this.reader.getXrefSize(); i4++) {
                PdfObject pdfObject = this.reader.getPdfObject(i4);
                if (pdfObject != null) {
                    addToBody(pdfObject, getNewObjectNumber(this.reader, i4, 0));
                }
            }
        } else {
            int i5 = 1;
            while (i5 < this.reader.getXrefSize()) {
                PdfObject pdfObjectRelease2 = this.reader.getPdfObjectRelease(i5);
                if (pdfObjectRelease2 != null && i != i5) {
                    addToBody(pdfObjectRelease2, getNewObjectNumber(this.reader, i5, 0), i5 != number);
                }
                i5++;
            }
        }
        PdfEncryption pdfEncryption = this.crypto;
        if (pdfEncryption != null) {
            if (this.append) {
                indirectReference = this.reader.getCryptoRef();
            } else {
                indirectReference = addToBody((PdfObject) pdfEncryption.getEncryptionDictionary(), false).getIndirectReference();
            }
            pdfIndirectReference2 = indirectReference;
            pdfObjectCreateInfoId = this.crypto.getFileID(true);
        } else {
            PdfArray asArray = this.reader.trailer.getAsArray(PdfName.ID);
            pdfIndirectReference2 = null;
            if (asArray != null && asArray.getAsString(0) != null) {
                pdfObjectCreateInfoId = PdfEncryption.createInfoId(asArray.getAsString(0).getBytes(), true);
            } else {
                pdfObjectCreateInfoId = PdfEncryption.createInfoId(PdfEncryption.createDocumentId(), true);
            }
        }
        PdfIndirectReference pdfIndirectReference3 = new PdfIndirectReference(0, getNewObjectNumber(this.reader, ((PRIndirectReference) this.reader.trailer.get(PdfName.ROOT)).getNumber(), 0));
        this.body.writeCrossReferenceTable(this.os, pdfIndirectReference3, pdfIndirectReference, pdfIndirectReference2, pdfObjectCreateInfoId, this.prevxref);
        if (this.fullCompression) {
            PdfWriter.writeKeyInfo(this.os);
            this.os.write(DocWriter.getISOBytes("startxref\n"));
            this.os.write(DocWriter.getISOBytes(String.valueOf(this.body.offset())));
            this.os.write(DocWriter.getISOBytes("\n%%EOF\n"));
        } else {
            new PdfWriter.PdfTrailer(this.body.size(), this.body.offset(), pdfIndirectReference3, pdfIndirectReference, pdfIndirectReference2, pdfObjectCreateInfoId, this.prevxref).toPdf(this, this.os);
        }
        this.os.flush();
        if (isCloseStream()) {
            this.os.close();
        }
        getCounter().written(this.os.getCounter());
    }
}
