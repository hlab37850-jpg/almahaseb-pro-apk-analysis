package org.apache.poi.poifs.common;

/* JADX INFO: loaded from: classes4.dex */
public final class POIFSBigBlockSize {
    private int bigBlockSize;
    private short headerValue;

    public POIFSBigBlockSize(int i, short s) {
        this.bigBlockSize = i;
        this.headerValue = s;
    }

    public int getBATEntriesPerBlock() {
        return this.bigBlockSize / 4;
    }

    public int getBigBlockSize() {
        return this.bigBlockSize;
    }

    public short getHeaderValue() {
        return this.headerValue;
    }

    public int getNextXBATChainOffset() {
        return getXBATEntriesPerBlock() * 4;
    }

    public int getPropertiesPerBlock() {
        return this.bigBlockSize / 128;
    }

    public int getXBATEntriesPerBlock() {
        return getBATEntriesPerBlock() - 1;
    }
}
