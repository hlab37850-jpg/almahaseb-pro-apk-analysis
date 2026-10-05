package org.apache.poi.hssf.usermodel;

/* JADX INFO: loaded from: classes4.dex */
public class HSSFPolygon extends HSSFShape {
    int drawAreaHeight;
    int drawAreaWidth;
    int[] xPoints;
    int[] yPoints;

    public HSSFPolygon(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        this.drawAreaWidth = 100;
        this.drawAreaHeight = 100;
    }

    private int[] cloneArray(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = iArr[i];
        }
        return iArr2;
    }

    public int getDrawAreaHeight() {
        return this.drawAreaHeight;
    }

    public int getDrawAreaWidth() {
        return this.drawAreaWidth;
    }

    public int[] getXPoints() {
        return this.xPoints;
    }

    public int[] getYPoints() {
        return this.yPoints;
    }

    public void setPoints(int[] iArr, int[] iArr2) {
        this.xPoints = cloneArray(iArr);
        this.yPoints = cloneArray(iArr2);
    }

    public void setPolygonDrawArea(int i, int i2) {
        this.drawAreaWidth = i;
        this.drawAreaHeight = i2;
    }
}
