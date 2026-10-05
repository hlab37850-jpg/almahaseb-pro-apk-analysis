package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.poifs.common.POIFSBigBlockSize;

/* JADX INFO: loaded from: classes4.dex */
abstract class BigBlock implements BlockWritable {
    protected POIFSBigBlockSize bigBlockSize;

    public BigBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        this.bigBlockSize = pOIFSBigBlockSize;
    }

    public void doWriteData(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) {
        writeData(outputStream);
    }

    public abstract void writeData(OutputStream outputStream);
}
