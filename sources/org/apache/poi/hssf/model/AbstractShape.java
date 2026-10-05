package org.apache.poi.hssf.model;

import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperties;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.usermodel.HSSFAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPolygon;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFTextbox;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractShape {
    public static AbstractShape createShape(HSSFShape hSSFShape, int i) {
        AbstractShape lineShape;
        AbstractShape polygonShape;
        if (hSSFShape instanceof HSSFComment) {
            polygonShape = new CommentShape((HSSFComment) hSSFShape, i);
        } else if (hSSFShape instanceof HSSFTextbox) {
            polygonShape = new TextboxShape((HSSFTextbox) hSSFShape, i);
        } else if (hSSFShape instanceof HSSFPolygon) {
            polygonShape = new PolygonShape((HSSFPolygon) hSSFShape, i);
        } else {
            if (!(hSSFShape instanceof HSSFSimpleShape)) {
                throw new IllegalArgumentException("Unknown shape type");
            }
            HSSFSimpleShape hSSFSimpleShape = (HSSFSimpleShape) hSSFShape;
            int shapeType = hSSFSimpleShape.getShapeType();
            if (shapeType == 1) {
                lineShape = new LineShape(hSSFSimpleShape, i);
            } else if (shapeType == 2 || shapeType == 3) {
                lineShape = new SimpleFilledShape(hSSFSimpleShape, i);
            } else if (shapeType == 8) {
                lineShape = new PictureShape(hSSFSimpleShape, i);
            } else {
                if (shapeType != 20) {
                    throw new IllegalArgumentException("Do not know how to handle this type of shape");
                }
                lineShape = new ComboboxShape(hSSFSimpleShape, i);
            }
            polygonShape = lineShape;
        }
        EscherSpRecord childById = polygonShape.getSpContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (hSSFShape.getParent() != null) {
            childById.setFlags(childById.getFlags() | 2);
        }
        return polygonShape;
    }

    public int addStandardOptions(HSSFShape hSSFShape, EscherOptRecord escherOptRecord) {
        int i;
        escherOptRecord.addEscherProperty(new EscherBoolProperty((short) 191, 524288));
        if (hSSFShape.isNoFill()) {
            escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.FILL__NOFILLHITTEST, 1114112));
        } else {
            escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.FILL__NOFILLHITTEST, 65536));
        }
        escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.FILL__FILLCOLOR, hSSFShape.getFillColor()));
        escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.GROUPSHAPE__PRINT, 524288));
        escherOptRecord.addEscherProperty(new EscherRGBProperty(EscherProperties.LINESTYLE__COLOR, hSSFShape.getLineStyleColor()));
        if (hSSFShape.getLineWidth() != 9525) {
            escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEWIDTH, hSSFShape.getLineWidth()));
            i = 6;
        } else {
            i = 5;
        }
        if (hSSFShape.getLineStyle() != 0) {
            escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEDASHING, hSSFShape.getLineStyle()));
            escherOptRecord.addEscherProperty(new EscherSimpleProperty(EscherProperties.LINESTYLE__LINEENDCAPSTYLE, 0));
            if (hSSFShape.getLineStyle() == -1) {
                escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524288));
            } else {
                escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherProperties.LINESTYLE__NOLINEDRAWDASH, 524296));
            }
            i += 3;
        }
        escherOptRecord.sortProperties();
        return i;
    }

    public EscherRecord createAnchor(HSSFAnchor hSSFAnchor) {
        return ConvertAnchor.createAnchor(hSSFAnchor);
    }

    public abstract ObjRecord getObjRecord();

    public abstract EscherContainerRecord getSpContainer();
}
