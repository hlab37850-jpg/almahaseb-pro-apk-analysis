package com.itextpdf.awt.geom;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class Rectangle extends Rectangle2D implements Shape, Serializable {
    private static final long serialVersionUID = -4345857070255674764L;
    public double height;
    public double width;
    public double x;
    public double y;

    public Rectangle() {
        setBounds(0, 0, 0, 0);
    }

    public void add(int i, int i2) {
        add(i, i2);
    }

    public boolean contains(int i, int i2) {
        return contains(i, i2);
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D
    public Rectangle2D createIntersection(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return intersection((Rectangle) rectangle2D);
        }
        Rectangle2D.Double r0 = new Rectangle2D.Double();
        Rectangle2D.intersect(this, rectangle2D, r0);
        return r0;
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D
    public Rectangle2D createUnion(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return union((Rectangle) rectangle2D);
        }
        Rectangle2D.Double r0 = new Rectangle2D.Double();
        Rectangle2D.union(this, rectangle2D, r0);
        return r0;
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return rectangle.x == this.x && rectangle.y == this.y && rectangle.width == this.width && rectangle.height == this.height;
    }

    @Override // com.itextpdf.awt.geom.RectangularShape, com.itextpdf.awt.geom.Shape
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D, com.itextpdf.awt.geom.Shape
    public Rectangle2D getBounds2D() {
        return getBounds();
    }

    @Override // com.itextpdf.awt.geom.RectangularShape
    public double getHeight() {
        return this.height;
    }

    public Point getLocation() {
        return new Point(this.x, this.y);
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    @Override // com.itextpdf.awt.geom.RectangularShape
    public double getWidth() {
        return this.width;
    }

    @Override // com.itextpdf.awt.geom.RectangularShape
    public double getX() {
        return this.x;
    }

    @Override // com.itextpdf.awt.geom.RectangularShape
    public double getY() {
        return this.y;
    }

    public void grow(int i, int i2) {
        translate(i, i2);
    }

    public Rectangle intersection(Rectangle rectangle) {
        double dMax = Math.max(this.x, rectangle.x);
        double dMax2 = Math.max(this.y, rectangle.y);
        return new Rectangle(dMax, dMax2, Math.min(this.x + this.width, rectangle.x + rectangle.width) - dMax, Math.min(this.y + this.height, rectangle.y + rectangle.height) - dMax2);
    }

    public boolean intersects(Rectangle rectangle) {
        return !intersection(rectangle).isEmpty();
    }

    @Override // com.itextpdf.awt.geom.RectangularShape
    public boolean isEmpty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D
    public int outcode(double d, double d2) {
        int i;
        double d3 = this.width;
        if (d3 <= 0.0d) {
            i = 5;
        } else {
            double d4 = this.x;
            if (d < d4) {
                i = 1;
            } else {
                i = d > d4 + d3 ? 4 : 0;
            }
        }
        double d5 = this.height;
        if (d5 <= 0.0d) {
            return i | 10;
        }
        double d6 = this.y;
        if (d2 < d6) {
            return i | 2;
        }
        return d2 > d6 + d5 ? i | 8 : i;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        setBounds(i, i2, i3, i4);
    }

    public void setLocation(int i, int i2) {
        setLocation(i, i2);
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D
    public void setRect(double d, double d2, double d3, double d4) {
        int iFloor = (int) Math.floor(d);
        int iFloor2 = (int) Math.floor(d2);
        setBounds(iFloor, iFloor2, ((int) Math.ceil(d + d3)) - iFloor, ((int) Math.ceil(d2 + d4)) - iFloor2);
    }

    public void setSize(int i, int i2) {
        setSize(i, i2);
    }

    public String toString() {
        return getClass().getName() + "[x=" + this.x + ",y=" + this.y + ",width=" + this.width + ",height=" + this.height + "]";
    }

    public void translate(int i, int i2) {
        translate(i, i2);
    }

    public Rectangle union(Rectangle rectangle) {
        Rectangle rectangle2 = new Rectangle(this);
        rectangle2.add(rectangle);
        return rectangle2;
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D
    public void add(double d, double d2) {
        double dMin = Math.min(this.x, d);
        double dMax = Math.max(this.x + this.width, d);
        double dMin2 = Math.min(this.y, d2);
        setBounds(dMin, dMin2, dMax - dMin, Math.max(this.y + this.height, d2) - dMin2);
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D, com.itextpdf.awt.geom.Shape
    public boolean contains(double d, double d2) {
        if (isEmpty()) {
            return false;
        }
        double d3 = this.x;
        if (d < d3) {
            return false;
        }
        double d4 = this.y;
        if (d2 < d4) {
            return false;
        }
        return d - d3 < this.width && d2 - d4 < this.height;
    }

    public void grow(double d, double d2) {
        this.x -= d;
        this.y -= d2;
        this.width += d + d;
        this.height += d2 + d2;
    }

    public void setBounds(double d, double d2, double d3, double d4) {
        this.x = d;
        this.y = d2;
        this.height = d4;
        this.width = d3;
    }

    public void setLocation(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void setSize(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public void translate(double d, double d2) {
        this.x += d;
        this.y += d2;
    }

    public Rectangle(Point point) {
        setBounds(point.x, point.y, 0.0d, 0.0d);
    }

    public void setLocation(Point point) {
        setLocation(point.x, point.y);
    }

    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    public Rectangle(Point point, Dimension dimension) {
        setBounds(point.x, point.y, dimension.width, dimension.height);
    }

    public boolean contains(Point point) {
        return contains(point.x, point.y);
    }

    public boolean contains(int i, int i2, int i3, int i4) {
        return contains(i, i2) && contains((i + i3) - 1, (i2 + i4) - 1);
    }

    public void setBounds(Rectangle rectangle) {
        setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle(double d, double d2, double d3, double d4) {
        setBounds(d, d2, d3, d4);
    }

    public void add(Point point) {
        add(point.x, point.y);
    }

    @Override // com.itextpdf.awt.geom.Rectangle2D, com.itextpdf.awt.geom.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        return contains(d, d2) && contains((d + d3) - 0.01d, (d2 + d4) - 0.01d);
    }

    public void add(Rectangle rectangle) {
        double dMin = Math.min(this.x, rectangle.x);
        double dMax = Math.max(this.x + this.width, rectangle.x + rectangle.width);
        double dMin2 = Math.min(this.y, rectangle.y);
        setBounds(dMin, dMin2, dMax - dMin, Math.max(this.y + this.height, rectangle.y + rectangle.height) - dMin2);
    }

    public boolean contains(Rectangle rectangle) {
        return contains(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle(int i, int i2) {
        setBounds(0, 0, i, i2);
    }

    public Rectangle(Rectangle rectangle) {
        setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle(com.itextpdf.text.Rectangle rectangle) {
        rectangle.normalize();
        setBounds(rectangle.getLeft(), rectangle.getBottom(), rectangle.getWidth(), rectangle.getHeight());
    }

    public Rectangle(Dimension dimension) {
        setBounds(0.0d, 0.0d, dimension.width, dimension.height);
    }
}
