package defpackage;

import com.google.zxing.datamatrix.encoder.SymbolInfo;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: zh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4479zh extends SymbolInfo {
    public C4479zh() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? ShapeTypes.FLOW_CHART_MAGNETIC_DRUM : ShapeTypes.FLOW_CHART_MAGNETIC_DISK;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }
}
