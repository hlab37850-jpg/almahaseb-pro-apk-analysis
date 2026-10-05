package com.itextpdf.awt.geom;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RectangularShape implements Shape, Cloneable {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    @Override // com.itextpdf.awt.geom.Shape
    public Rectangle getBounds() {
        int iFloor = (int) Math.floor(getMinX());
        int iFloor2 = (int) Math.floor(getMinY());
        return new Rectangle(iFloor, iFloor2, ((int) Math.ceil(getMaxX())) - iFloor, ((int) Math.ceil(getMaxY())) - iFloor2);
    }

    public double getCenterX() {
        return getX() + (getWidth() / 2.0d);
    }

    public double getCenterY() {
        return getY() + (getHeight() / 2.0d);
    }

    public Rectangle2D getFrame() {
        return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
    }

    public abstract double getHeight();

    public double getMaxX() {
        return getX() + getWidth();
    }

    public double getMaxY() {
        return getY() + getHeight();
    }

    public double getMinX() {
        return getX();
    }

    public double getMinY() {
        return getY();
    }

    @Override // com.itextpdf.awt.geom.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    public abstract double getWidth();

    public abstract double getX();

    public abstract double getY();

    @Override // com.itextpdf.awt.geom.Shape
    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public abstract boolean isEmpty();

    public abstract void setFrame(double d, double d2, double d3, double d4);

    public void setFrame(Point2D point2D, Dimension2D dimension2D) {
        setFrame(point2D.getX(), point2D.getY(), dimension2D.getWidth(), dimension2D.getHeight());
    }

    public void setFrameFromCenter(double d, double d2, double d3, double d4) {
        double dAbs = Math.abs(d3 - d);
        double dAbs2 = Math.abs(d4 - d2);
        setFrame(d - dAbs, d2 - dAbs2, dAbs * 2.0d, dAbs2 * 2.0d);
    }

    public void setFrameFromDiagonal(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d < d3) {
            d5 = d3 - d;
            d6 = d;
        } else {
            d5 = d - d3;
            d6 = d3;
        }
        double d9 = d5;
        if (d2 < d4) {
            d7 = d4 - d2;
            d8 = d2;
        } else {
            d7 = d2 - d4;
            d8 = d4;
        }
        setFrame(d6, d8, d9, d7);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public void setFrame(Rectangle2D rectangle2D) {
        setFrame(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public void setFrameFromDiagonal(Point2D point2D, Point2D point2D2) {
        setFrameFromDiagonal(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }

    public void setFrameFromCenter(Point2D point2D, Point2D point2D2) {
        setFrameFromCenter(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }
}
