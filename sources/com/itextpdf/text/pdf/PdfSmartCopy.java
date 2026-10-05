package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PdfSmartCopy extends PdfCopy {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) PdfSmartCopy.class);
    protected Counter COUNTER;
    private final HashMap<RefKey, Integer> serialized;
    private HashMap<ByteStore, PdfIndirectReference> streamMap;

    public PdfSmartCopy(Document document, OutputStream outputStream) {
        super(document, outputStream);
        this.streamMap = null;
        this.serialized = new HashMap<>();
        this.COUNTER = CounterFactory.getCounter(PdfSmartCopy.class);
        this.streamMap = new HashMap<>();
    }

    @Override // com.itextpdf.text.pdf.PdfCopy
    public void addPage(PdfImportedPage pdfImportedPage) {
        if (this.currentPdfReaderInstance.getReader() != this.reader) {
            this.serialized.clear();
        }
        super.addPage(pdfImportedPage);
    }

    @Override // com.itextpdf.text.pdf.PdfCopy
    public PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference) {
        ByteStore byteStore;
        PdfIndirectReference ref;
        PdfObject pdfObjectRelease;
        PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pRIndirectReference);
        boolean z = true;
        if (pdfObjectRelease2.isStream()) {
            byteStore = new ByteStore((PRStream) pdfObjectRelease2, this.serialized);
            PdfIndirectReference pdfIndirectReference = this.streamMap.get(byteStore);
            if (pdfIndirectReference != null) {
                return pdfIndirectReference;
            }
        } else if (pdfObjectRelease2.isDictionary()) {
            byteStore = new ByteStore((PdfDictionary) pdfObjectRelease2, this.serialized);
            PdfIndirectReference pdfIndirectReference2 = this.streamMap.get(byteStore);
            if (pdfIndirectReference2 != null) {
                return pdfIndirectReference2;
            }
        } else {
            byteStore = null;
            z = false;
        }
        RefKey refKey = new RefKey(pRIndirectReference);
        PdfCopy.IndirectReferences indirectReferences = this.indirects.get(refKey);
        if (indirectReferences != null) {
            ref = indirectReferences.getRef();
            if (indirectReferences.getCopied()) {
                return ref;
            }
        } else {
            PdfIndirectReference pdfIndirectReference3 = this.body.getPdfIndirectReference();
            PdfCopy.IndirectReferences indirectReferences2 = new PdfCopy.IndirectReferences(pdfIndirectReference3);
            this.indirects.put(refKey, indirectReferences2);
            ref = pdfIndirectReference3;
            indirectReferences = indirectReferences2;
        }
        if (pdfObjectRelease2.isDictionary() && (pdfObjectRelease = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease2).get(PdfName.TYPE))) != null) {
            if (PdfName.PAGE.equals(pdfObjectRelease)) {
                return ref;
            }
            if (PdfName.CATALOG.equals(pdfObjectRelease)) {
                LOGGER.warn(MessageLocalization.getComposedMessage("make.copy.of.catalog.dictionary.is.forbidden", new Object[0]));
                return null;
            }
        }
        indirectReferences.setCopied();
        if (z) {
            this.streamMap.put(byteStore, ref);
        }
        addToBody(copyObject(pdfObjectRelease2), ref);
        return ref;
    }

    @Override // com.itextpdf.text.pdf.PdfCopy, com.itextpdf.text.pdf.PdfWriter
    public void freeReader(PdfReader pdfReader) {
        this.serialized.clear();
        super.freeReader(pdfReader);
    }

    @Override // com.itextpdf.text.pdf.PdfCopy, com.itextpdf.text.pdf.PdfWriter
    public Counter getCounter() {
        return this.COUNTER;
    }

    public static class ByteStore {
        private final byte[] b;
        private final int hash;
        private MessageDigest md5;

        public ByteStore(PRStream pRStream, HashMap<RefKey, Integer> map) {
            try {
                this.md5 = MessageDigest.getInstance("MD5");
                ByteBuffer byteBuffer = new ByteBuffer();
                serObject(pRStream, 100, byteBuffer, map);
                byte[] byteArray = byteBuffer.toByteArray();
                this.b = byteArray;
                this.hash = calculateHash(byteArray);
                this.md5 = null;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        private static int calculateHash(byte[] bArr) {
            int i = 0;
            for (byte b : bArr) {
                i = (i * 31) + (b & UnsignedBytes.MAX_VALUE);
            }
            return i;
        }

        private void serArray(PdfArray pdfArray, int i, ByteBuffer byteBuffer, HashMap<RefKey, Integer> map) {
            byteBuffer.append("$A");
            if (i <= 0) {
                return;
            }
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                serObject(pdfArray.getPdfObject(i2), i, byteBuffer, map);
            }
        }

        private void serDic(PdfDictionary pdfDictionary, int i, ByteBuffer byteBuffer, HashMap<RefKey, Integer> map) {
            byteBuffer.append("$D");
            if (i <= 0) {
                return;
            }
            Object[] array = pdfDictionary.getKeys().toArray();
            Arrays.sort(array);
            for (int i2 = 0; i2 < array.length; i2++) {
                if (!array[i2].equals(PdfName.P) || (!pdfDictionary.get((PdfName) array[i2]).isIndirect() && !pdfDictionary.get((PdfName) array[i2]).isDictionary())) {
                    serObject((PdfObject) array[i2], i, byteBuffer, map);
                    serObject(pdfDictionary.get((PdfName) array[i2]), i, byteBuffer, map);
                }
            }
        }

        private void serObject(PdfObject pdfObject, int i, ByteBuffer byteBuffer, HashMap<RefKey, Integer> map) {
            ByteBuffer byteBuffer2;
            PdfIndirectReference pdfIndirectReference;
            if (i <= 0) {
                return;
            }
            if (pdfObject == null) {
                byteBuffer.append("$Lnull");
                return;
            }
            if (pdfObject.isIndirect()) {
                PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) pdfObject;
                RefKey refKey = new RefKey(pdfIndirectReference2);
                if (map.containsKey(refKey)) {
                    byteBuffer.append(map.get(refKey).intValue());
                    return;
                } else {
                    byteBuffer2 = byteBuffer;
                    byteBuffer = new ByteBuffer();
                    pdfIndirectReference = pdfIndirectReference2;
                }
            } else {
                byteBuffer2 = null;
                pdfIndirectReference = null;
            }
            PdfObject pdfObject2 = PdfReader.getPdfObject(pdfObject);
            if (pdfObject2.isStream()) {
                byteBuffer.append("$B");
                serDic((PdfDictionary) pdfObject2, i - 1, byteBuffer, map);
                if (i > 0) {
                    this.md5.reset();
                    byteBuffer.append(this.md5.digest(PdfReader.getStreamBytesRaw((PRStream) pdfObject2)));
                }
            } else if (pdfObject2.isDictionary()) {
                serDic((PdfDictionary) pdfObject2, i - 1, byteBuffer, map);
            } else if (pdfObject2.isArray()) {
                serArray((PdfArray) pdfObject2, i - 1, byteBuffer, map);
            } else if (pdfObject2.isString()) {
                byteBuffer.append("$S").append(pdfObject2.toString());
            } else if (pdfObject2.isName()) {
                byteBuffer.append("$N").append(pdfObject2.toString());
            } else {
                byteBuffer.append("$L").append(pdfObject2.toString());
            }
            if (byteBuffer2 != null) {
                RefKey refKey2 = new RefKey(pdfIndirectReference);
                if (!map.containsKey(refKey2)) {
                    map.put(refKey2, Integer.valueOf(calculateHash(byteBuffer.getBuffer())));
                }
                byteBuffer2.append(byteBuffer);
            }
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ByteStore) && hashCode() == obj.hashCode()) {
                return Arrays.equals(this.b, ((ByteStore) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return this.hash;
        }

        public ByteStore(PdfDictionary pdfDictionary, HashMap<RefKey, Integer> map) {
            try {
                this.md5 = MessageDigest.getInstance("MD5");
                ByteBuffer byteBuffer = new ByteBuffer();
                serObject(pdfDictionary, 100, byteBuffer, map);
                byte[] byteArray = byteBuffer.toByteArray();
                this.b = byteArray;
                this.hash = calculateHash(byteArray);
                this.md5 = null;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }
}
