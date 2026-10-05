package com.itextpdf.text.pdf.codec;

import com.google.common.base.Ascii;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public class JBIG2SegmentReader {
    public static final int END_OF_FILE = 51;
    public static final int END_OF_PAGE = 49;
    public static final int END_OF_STRIPE = 50;
    public static final int EXTENSION = 62;
    public static final int IMMEDIATE_GENERIC_REFINEMENT_REGION = 42;
    public static final int IMMEDIATE_GENERIC_REGION = 38;
    public static final int IMMEDIATE_HALFTONE_REGION = 22;
    public static final int IMMEDIATE_LOSSLESS_GENERIC_REFINEMENT_REGION = 43;
    public static final int IMMEDIATE_LOSSLESS_GENERIC_REGION = 39;
    public static final int IMMEDIATE_LOSSLESS_HALFTONE_REGION = 23;
    public static final int IMMEDIATE_LOSSLESS_TEXT_REGION = 7;
    public static final int IMMEDIATE_TEXT_REGION = 6;
    public static final int INTERMEDIATE_GENERIC_REFINEMENT_REGION = 40;
    public static final int INTERMEDIATE_GENERIC_REGION = 36;
    public static final int INTERMEDIATE_HALFTONE_REGION = 20;
    public static final int INTERMEDIATE_TEXT_REGION = 4;
    public static final int PAGE_INFORMATION = 48;
    public static final int PATTERN_DICTIONARY = 16;
    public static final int PROFILES = 52;
    public static final int SYMBOL_DICTIONARY = 0;
    public static final int TABLES = 53;
    private boolean number_of_pages_known;
    private RandomAccessFileOrArray ra;
    private boolean sequential;
    private final SortedMap<Integer, JBIG2Segment> segments = new TreeMap();
    private final SortedMap<Integer, JBIG2Page> pages = new TreeMap();
    private final SortedSet<JBIG2Segment> globals = new TreeSet();
    private int number_of_pages = -1;
    private boolean read = false;

    public static class JBIG2Page {
        public final int page;
        private final JBIG2SegmentReader sr;
        private final SortedMap<Integer, JBIG2Segment> segs = new TreeMap();
        public int pageBitmapWidth = -1;
        public int pageBitmapHeight = -1;

        public JBIG2Page(int i, JBIG2SegmentReader jBIG2SegmentReader) {
            this.page = i;
            this.sr = jBIG2SegmentReader;
        }

        public void addSegment(JBIG2Segment jBIG2Segment) {
            this.segs.put(Integer.valueOf(jBIG2Segment.segmentNumber), jBIG2Segment);
        }

        public byte[] getData(boolean z) throws IOException {
            int i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterator<Integer> it = this.segs.keySet().iterator();
            while (it.hasNext()) {
                JBIG2Segment jBIG2Segment = this.segs.get(it.next());
                if (!z || ((i = jBIG2Segment.type) != 51 && i != 49)) {
                    if (z) {
                        byte[] bArrCopyByteArray = JBIG2SegmentReader.copyByteArray(jBIG2Segment.headerData);
                        if (jBIG2Segment.page_association_size) {
                            int i2 = jBIG2Segment.page_association_offset;
                            bArrCopyByteArray[i2] = 0;
                            bArrCopyByteArray[i2 + 1] = 0;
                            bArrCopyByteArray[i2 + 2] = 0;
                            bArrCopyByteArray[i2 + 3] = 1;
                        } else {
                            bArrCopyByteArray[jBIG2Segment.page_association_offset] = 1;
                        }
                        byteArrayOutputStream.write(bArrCopyByteArray);
                    } else {
                        byteArrayOutputStream.write(jBIG2Segment.headerData);
                    }
                    byteArrayOutputStream.write(jBIG2Segment.data);
                }
            }
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static class JBIG2Segment implements Comparable<JBIG2Segment> {
        public final int segmentNumber;
        public long dataLength = -1;
        public int page = -1;
        public int[] referredToSegmentNumbers = null;
        public boolean[] segmentRetentionFlags = null;
        public int type = -1;
        public boolean deferredNonRetain = false;
        public int countOfReferredToSegments = -1;
        public byte[] data = null;
        public byte[] headerData = null;
        public boolean page_association_size = false;
        public int page_association_offset = -1;

        public JBIG2Segment(int i) {
            this.segmentNumber = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(JBIG2Segment jBIG2Segment) {
            return this.segmentNumber - jBIG2Segment.segmentNumber;
        }
    }

    public JBIG2SegmentReader(RandomAccessFileOrArray randomAccessFileOrArray) {
        this.ra = randomAccessFileOrArray;
    }

    public static byte[] copyByteArray(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public byte[] getGlobal(boolean z) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (JBIG2Segment jBIG2Segment : this.globals) {
                if (!z || ((i = jBIG2Segment.type) != 51 && i != 49)) {
                    byteArrayOutputStream.write(jBIG2Segment.headerData);
                    byteArrayOutputStream.write(jBIG2Segment.data);
                }
            }
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (byteArrayOutputStream.size() <= 0) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public JBIG2Page getPage(int i) {
        return this.pages.get(Integer.valueOf(i));
    }

    public int getPageHeight(int i) {
        return this.pages.get(Integer.valueOf(i)).pageBitmapHeight;
    }

    public int getPageWidth(int i) {
        return this.pages.get(Integer.valueOf(i)).pageBitmapWidth;
    }

    public int numberOfPages() {
        return this.pages.size();
    }

    public void read() throws EOFException {
        JBIG2Segment header;
        if (this.read) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("already.attempted.a.read.on.this.jbig2.file", new Object[0]));
        }
        this.read = true;
        readFileHeader();
        if (this.sequential) {
            do {
                JBIG2Segment header2 = readHeader();
                readSegment(header2);
                this.segments.put(Integer.valueOf(header2.segmentNumber), header2);
            } while (this.ra.getFilePointer() < this.ra.length());
            return;
        }
        do {
            header = readHeader();
            this.segments.put(Integer.valueOf(header.segmentNumber), header);
        } while (header.type != 51);
        Iterator<Integer> it = this.segments.keySet().iterator();
        while (it.hasNext()) {
            readSegment(this.segments.get(it.next()));
        }
    }

    public void readFileHeader() {
        this.ra.seek(0L);
        byte[] bArr = new byte[8];
        this.ra.read(bArr);
        byte[] bArr2 = {-105, 74, 66, 50, 13, 10, Ascii.SUB, 10};
        for (int i = 0; i < 8; i++) {
            if (bArr[i] != bArr2[i]) {
                throw new IllegalStateException(MessageLocalization.getComposedMessage("file.header.idstring.not.good.at.byte.1", i));
            }
        }
        int i2 = this.ra.read();
        this.sequential = (i2 & 1) == 1;
        boolean z = (i2 & 2) == 0;
        this.number_of_pages_known = z;
        if ((i2 & 252) != 0) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("file.header.flags.bits.2.7.not.0", new Object[0]));
        }
        if (z) {
            this.number_of_pages = this.ra.readInt();
        }
    }

    public JBIG2Segment readHeader() throws EOFException {
        boolean[] zArr;
        int filePointer = (int) this.ra.getFilePointer();
        int i = this.ra.readInt();
        JBIG2Segment jBIG2Segment = new JBIG2Segment(i);
        int i2 = this.ra.read();
        jBIG2Segment.deferredNonRetain = (i2 & 128) == 128;
        boolean z = (i2 & 64) == 64;
        jBIG2Segment.type = i2 & 63;
        int i3 = this.ra.read();
        int i4 = (i3 & 224) >> 5;
        if (i4 == 7) {
            RandomAccessFileOrArray randomAccessFileOrArray = this.ra;
            randomAccessFileOrArray.seek(randomAccessFileOrArray.getFilePointer() - 1);
            int i5 = this.ra.readInt() & 536870911;
            zArr = new boolean[i5 + 1];
            int i6 = 0;
            int i7 = 0;
            do {
                int i8 = i6 % 8;
                if (i8 == 0) {
                    i7 = this.ra.read();
                }
                zArr[i6] = (((1 << i8) & i7) >> i8) == 1;
                i6++;
            } while (i6 <= i5);
            i4 = i5;
        } else if (i4 <= 4) {
            zArr = new boolean[i4 + 1];
            int i9 = i3 & 31;
            for (int i10 = 0; i10 <= i4; i10++) {
                zArr[i10] = (((1 << i10) & i9) >> i10) == 1;
            }
        } else {
            if (i4 == 5 || i4 == 6) {
                throw new IllegalStateException(MessageLocalization.getComposedMessage("count.of.referred.to.segments.had.bad.value.in.header.for.segment.1.starting.at.2", String.valueOf(i), String.valueOf(filePointer)));
            }
            zArr = null;
        }
        jBIG2Segment.segmentRetentionFlags = zArr;
        jBIG2Segment.countOfReferredToSegments = i4;
        int[] iArr = new int[i4 + 1];
        for (int i11 = 1; i11 <= i4; i11++) {
            if (i <= 256) {
                iArr[i11] = this.ra.read();
            } else if (i <= 65536) {
                iArr[i11] = this.ra.readUnsignedShort();
            } else {
                iArr[i11] = (int) this.ra.readUnsignedInt();
            }
        }
        jBIG2Segment.referredToSegmentNumbers = iArr;
        int filePointer2 = ((int) this.ra.getFilePointer()) - filePointer;
        int i12 = z ? this.ra.readInt() : this.ra.read();
        if (i12 < 0) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("page.1.invalid.for.segment.2.starting.at.3", String.valueOf(i12), String.valueOf(i), String.valueOf(filePointer)));
        }
        jBIG2Segment.page = i12;
        jBIG2Segment.page_association_size = z;
        jBIG2Segment.page_association_offset = filePointer2;
        if (i12 > 0 && !this.pages.containsKey(Integer.valueOf(i12))) {
            this.pages.put(Integer.valueOf(i12), new JBIG2Page(i12, this));
        }
        if (i12 > 0) {
            this.pages.get(Integer.valueOf(i12)).addSegment(jBIG2Segment);
        } else {
            this.globals.add(jBIG2Segment);
        }
        jBIG2Segment.dataLength = this.ra.readUnsignedInt();
        int filePointer3 = (int) this.ra.getFilePointer();
        this.ra.seek(filePointer);
        byte[] bArr = new byte[filePointer3 - filePointer];
        this.ra.read(bArr);
        jBIG2Segment.headerData = bArr;
        return jBIG2Segment;
    }

    public void readSegment(JBIG2Segment jBIG2Segment) throws EOFException {
        int filePointer = (int) this.ra.getFilePointer();
        long j = jBIG2Segment.dataLength;
        if (j == 4294967295L) {
            return;
        }
        byte[] bArr = new byte[(int) j];
        this.ra.read(bArr);
        jBIG2Segment.data = bArr;
        if (jBIG2Segment.type == 48) {
            int filePointer2 = (int) this.ra.getFilePointer();
            this.ra.seek(filePointer);
            int i = this.ra.readInt();
            int i2 = this.ra.readInt();
            this.ra.seek(filePointer2);
            JBIG2Page jBIG2Page = this.pages.get(Integer.valueOf(jBIG2Segment.page));
            if (jBIG2Page == null) {
                throw new IllegalStateException(MessageLocalization.getComposedMessage("referring.to.widht.height.of.page.we.havent.seen.yet.1", jBIG2Segment.page));
            }
            jBIG2Page.pageBitmapWidth = i;
            jBIG2Page.pageBitmapHeight = i2;
        }
    }

    public String toString() {
        if (!this.read) {
            return "Jbig2SegmentReader in indeterminate state.";
        }
        return "Jbig2SegmentReader: number of pages: " + numberOfPages();
    }
}
