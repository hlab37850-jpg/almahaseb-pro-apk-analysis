package org.apache.poi.poifs.storage;

/* JADX INFO: loaded from: classes4.dex */
public interface BlockList {
    int blockCount();

    ListManagedBlock[] fetchBlocks(int i, int i2);

    ListManagedBlock remove(int i);

    void setBAT(BlockAllocationTableReader blockAllocationTableReader);

    void zap(int i);
}
