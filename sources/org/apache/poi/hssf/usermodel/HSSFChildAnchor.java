package org.apache.poi.hssf.usermodel;

/* JADX INFO: loaded from: classes4.dex */
public final class HSSFChildAnchor extends HSSFAnchor {
    public HSSFChildAnchor() {
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public boolean isHorizontallyFlipped() {
        return this.dx1 > this.dx2;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public boolean isVerticallyFlipped() {
        return this.dy1 > this.dy2;
    }

    public void setAnchor(int i, int i2, int i3, int i4) {
        this.dx1 = i;
        this.dy1 = i2;
        this.dx2 = i3;
        this.dy2 = i4;
    }

    public HSSFChildAnchor(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }
}
