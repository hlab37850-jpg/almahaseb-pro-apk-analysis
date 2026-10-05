package com.itextpdf.awt.geom;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class Point extends Point2D implements Serializable {
    private static final long serialVersionUID = -5276940640259749850L;
    public double x;
    public double y;

    public Point() {
        setLocation(0, 0);
    }

    @Override // com.itextpdf.awt.geom.Point2D
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y;
    }

    public Point getLocation() {
        return new Point(this.x, this.y);
    }

    @Override // com.itextpdf.awt.geom.Point2D
    public double getX() {
        return this.x;
    }

    @Override // com.itextpdf.awt.geom.Point2D
    public double getY() {
        return this.y;
    }

    public void move(int i, int i2) {
        move(i, i2);
    }

    public void setLocation(Point point) {
        setLocation(point.x, point.y);
    }

    public String toString() {
        return getClass().getName() + "[x=" + this.x + ",y=" + this.y + "]";
    }

    public void translate(int i, int i2) {
        translate(i, i2);
    }

    public void move(double d, double d2) {
        setLocation(d, d2);
    }

    public void setLocation(int i, int i2) {
        setLocation(i, i2);
    }

    public void translate(double d, double d2) {
        this.x += d;
        this.y += d2;
    }

    public Point(int i, int i2) {
        setLocation(i, i2);
    }

    @Override // com.itextpdf.awt.geom.Point2D
    public void setLocation(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public Point(double d, double d2) {
        setLocation(d, d2);
    }

    public Point(Point point) {
        setLocation(point.x, point.y);
    }
}
