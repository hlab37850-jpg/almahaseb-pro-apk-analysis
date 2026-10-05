package com.itextpdf.text.io;

/* JADX INFO: loaded from: classes3.dex */
class GroupedRandomAccessSource implements RandomAccessSource {
    private SourceEntry currentSourceEntry;
    private final long size;
    private final SourceEntry[] sources;

    public static class SourceEntry {
        final long firstByte;
        final int index;
        final long lastByte;
        final RandomAccessSource source;

        public SourceEntry(int i, RandomAccessSource randomAccessSource, long j) {
            this.index = i;
            this.source = randomAccessSource;
            this.firstByte = j;
            this.lastByte = (j + randomAccessSource.length()) - 1;
        }

        public long offsetN(long j) {
            return j - this.firstByte;
        }
    }

    public GroupedRandomAccessSource(RandomAccessSource[] randomAccessSourceArr) {
        this.sources = new SourceEntry[randomAccessSourceArr.length];
        long length = 0;
        for (int i = 0; i < randomAccessSourceArr.length; i++) {
            this.sources[i] = new SourceEntry(i, randomAccessSourceArr[i], length);
            length += randomAccessSourceArr[i].length();
        }
        this.size = length;
        SourceEntry sourceEntry = this.sources[randomAccessSourceArr.length - 1];
        this.currentSourceEntry = sourceEntry;
        sourceInUse(sourceEntry.source);
    }

    private SourceEntry getSourceEntryForOffset(long j) {
        if (j >= this.size) {
            return null;
        }
        SourceEntry sourceEntry = this.currentSourceEntry;
        if (j >= sourceEntry.firstByte && j <= sourceEntry.lastByte) {
            return sourceEntry;
        }
        sourceReleased(sourceEntry.source);
        int startingSourceIndex = getStartingSourceIndex(j);
        while (true) {
            SourceEntry[] sourceEntryArr = this.sources;
            if (startingSourceIndex >= sourceEntryArr.length) {
                return null;
            }
            SourceEntry sourceEntry2 = sourceEntryArr[startingSourceIndex];
            if (j >= sourceEntry2.firstByte && j <= sourceEntry2.lastByte) {
                this.currentSourceEntry = sourceEntry2;
                sourceInUse(sourceEntry2.source);
                return this.currentSourceEntry;
            }
            startingSourceIndex++;
        }
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() {
        for (SourceEntry sourceEntry : this.sources) {
            sourceEntry.source.close();
        }
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        SourceEntry sourceEntryForOffset = getSourceEntryForOffset(j);
        if (sourceEntryForOffset == null) {
            return -1;
        }
        return sourceEntryForOffset.source.get(sourceEntryForOffset.offsetN(j));
    }

    public int getStartingSourceIndex(long j) {
        SourceEntry sourceEntry = this.currentSourceEntry;
        if (j >= sourceEntry.firstByte) {
            return sourceEntry.index;
        }
        return 0;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.size;
    }

    public void sourceInUse(RandomAccessSource randomAccessSource) {
    }

    public void sourceReleased(RandomAccessSource randomAccessSource) {
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) {
        SourceEntry sourceEntryForOffset = getSourceEntryForOffset(j);
        if (sourceEntryForOffset == null) {
            return -1;
        }
        int i3 = i2;
        for (long jOffsetN = sourceEntryForOffset.offsetN(j); i3 > 0 && sourceEntryForOffset != null && jOffsetN <= sourceEntryForOffset.source.length(); jOffsetN = 0) {
            int i4 = sourceEntryForOffset.source.get(jOffsetN, bArr, i, i3);
            if (i4 == -1) {
                break;
            }
            i += i4;
            j += (long) i4;
            i3 -= i4;
            sourceEntryForOffset = getSourceEntryForOffset(j);
        }
        if (i3 == i2) {
            return -1;
        }
        return i2 - i3;
    }
}
