package org.apache.poi.util;

/* JADX INFO: loaded from: classes4.dex */
public interface DelayableLittleEndianOutput extends LittleEndianOutput {
    LittleEndianOutput createDelayedOutput(int i);
}
