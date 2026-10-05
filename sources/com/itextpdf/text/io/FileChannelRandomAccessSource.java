package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class FileChannelRandomAccessSource implements RandomAccessSource {
    private final FileChannel channel;
    private final MappedChannelRandomAccessSource source;

    public FileChannelRandomAccessSource(FileChannel fileChannel) throws IOException {
        this.channel = fileChannel;
        if (fileChannel.size() == 0) {
            throw new IOException("File size is 0 bytes");
        }
        MappedChannelRandomAccessSource mappedChannelRandomAccessSource = new MappedChannelRandomAccessSource(fileChannel, 0L, fileChannel.size());
        this.source = mappedChannelRandomAccessSource;
        mappedChannelRandomAccessSource.open();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() throws IOException {
        this.source.close();
        this.channel.close();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        return this.source.get(j);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.source.length();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) {
        return this.source.get(j, bArr, i, i2);
    }
}
