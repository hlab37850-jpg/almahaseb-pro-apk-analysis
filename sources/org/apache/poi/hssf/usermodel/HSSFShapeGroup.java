package org.apache.poi.hssf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes4.dex */
public class HSSFShapeGroup extends HSSFShape implements HSSFShapeContainer {
    List<HSSFShape> shapes;
    int x1;
    int x2;
    int y1;
    int y2;

    public HSSFShapeGroup(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        this.shapes = new ArrayList();
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = IEEEDouble.EXPONENT_BIAS;
        this.y2 = 255;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public int countOfAllChildren() {
        int size = this.shapes.size();
        Iterator<HSSFShape> it = this.shapes.iterator();
        while (it.hasNext()) {
            size += it.next().countOfAllChildren();
        }
        return size;
    }

    public HSSFShapeGroup createGroup(HSSFChildAnchor hSSFChildAnchor) {
        HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(this, hSSFChildAnchor);
        hSSFShapeGroup.anchor = hSSFChildAnchor;
        this.shapes.add(hSSFShapeGroup);
        return hSSFShapeGroup;
    }

    public HSSFPicture createPicture(HSSFChildAnchor hSSFChildAnchor, int i) {
        HSSFPicture hSSFPicture = new HSSFPicture(this, hSSFChildAnchor);
        hSSFPicture.anchor = hSSFChildAnchor;
        hSSFPicture.setPictureIndex(i);
        this.shapes.add(hSSFPicture);
        return hSSFPicture;
    }

    public HSSFPolygon createPolygon(HSSFChildAnchor hSSFChildAnchor) {
        HSSFPolygon hSSFPolygon = new HSSFPolygon(this, hSSFChildAnchor);
        hSSFPolygon.anchor = hSSFChildAnchor;
        this.shapes.add(hSSFPolygon);
        return hSSFPolygon;
    }

    public HSSFSimpleShape createShape(HSSFChildAnchor hSSFChildAnchor) {
        HSSFSimpleShape hSSFSimpleShape = new HSSFSimpleShape(this, hSSFChildAnchor);
        hSSFSimpleShape.anchor = hSSFChildAnchor;
        this.shapes.add(hSSFSimpleShape);
        return hSSFSimpleShape;
    }

    public HSSFTextbox createTextbox(HSSFChildAnchor hSSFChildAnchor) {
        HSSFTextbox hSSFTextbox = new HSSFTextbox(this, hSSFChildAnchor);
        hSSFTextbox.anchor = hSSFChildAnchor;
        this.shapes.add(hSSFTextbox);
        return hSSFTextbox;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public List<HSSFShape> getChildren() {
        return this.shapes;
    }

    public int getX1() {
        return this.x1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY1() {
        return this.y1;
    }

    public int getY2() {
        return this.y2;
    }

    public void setCoordinates(int i, int i2, int i3, int i4) {
        this.x1 = i;
        this.y1 = i2;
        this.x2 = i3;
        this.y2 = i4;
    }
}
