package org.apache.poi.hssf.record.formula;

import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes4.dex */
public final class AreaNPtg extends Area2DPtgBase {
    public static final short sid = 45;

    public AreaNPtg(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }

    @Override // org.apache.poi.hssf.record.formula.Area2DPtgBase
    public byte getSid() {
        return (byte) 45;
    }
}
