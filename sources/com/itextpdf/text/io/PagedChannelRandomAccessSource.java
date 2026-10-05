package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
class PagedChannelRandomAccessSource extends GroupedRandomAccessSource implements RandomAccessSource {
    public static final int DEFAULT_MAX_OPEN_BUFFERS = 16;
    public static final int DEFAULT_TOTAL_BUFSIZE = 67108864;
    private final int bufferSize;
    private final FileChannel channel;
    private final MRU<RandomAccessSource> mru;

    public static class MRU<E> {
        private final int limit;
        private LinkedList<E> queue = new LinkedList<>();

        public MRU(int i) {
            this.limit = i;
        }

        public E enqueue(E e) {
            if (this.queue.size() > 0 && this.queue.getFirst() == e) {
                return null;
            }
            Iterator<E> it = this.queue.iterator();
            while (it.hasNext()) {
                if (e == it.next()) {
                    it.remove();
                    this.queue.addFirst(e);
                    return null;
                }
            }
            this.queue.addFirst(e);
            if (this.queue.size() > this.limit) {
                return this.queue.removeLast();
            }
            return null;
        }
    }

    public PagedChannelRandomAccessSource(FileChannel fileChannel) {
        this(fileChannel, 67108864, 16);
    }

    private static RandomAccessSource[] buildSources(FileChannel fileChannel, int i) throws IOException {
        long size = fileChannel.size();
        if (size <= 0) {
            throw new IOException("File size must be greater than zero");
        }
        long j = i;
        int i2 = ((int) (size / j)) + (size % j == 0 ? 0 : 1);
        MappedChannelRandomAccessSource[] mappedChannelRandomAccessSourceArr = new MappedChannelRandomAccessSource[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((long) i3) * j;
            mappedChannelRandomAccessSourceArr[i3] = new MappedChannelRandomAccessSource(fileChannel, j2, Math.min(size - j2, j));
        }
        return mappedChannelRandomAccessSourceArr;
    }

    @Override // com.itextpdf.text.io.GroupedRandomAccessSource, com.itextpdf.text.io.RandomAccessSource
    public void close() throws IOException {
        super.close();
        this.channel.close();
    }

    @Override // com.itextpdf.text.io.GroupedRandomAccessSource
    public int getStartingSourceIndex(long j) {
        return (int) (j / ((long) this.bufferSize));
    }

    @Override // com.itextpdf.text.io.GroupedRandomAccessSource
    public void sourceInUse(RandomAccessSource randomAccessSource) throws IOException {
        ((MappedChannelRandomAccessSource) randomAccessSource).open();
    }

    @Override // com.itextpdf.text.io.GroupedRandomAccessSource
    public void sourceReleased(RandomAccessSource randomAccessSource) {
        RandomAccessSource randomAccessSourceEnqueue = this.mru.enqueue(randomAccessSource);
        if (randomAccessSourceEnqueue != null) {
            randomAccessSourceEnqueue.close();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PagedChannelRandomAccessSource(FileChannel fileChannel, int i, int i2) {
        int i3 = i / i2;
        super(buildSources(fileChannel, i3));
        this.channel = fileChannel;
        this.bufferSize = i3;
        this.mru = new MRU<>(i2);
    }
}
