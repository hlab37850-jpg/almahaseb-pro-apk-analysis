package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.misc.HashCode;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Point2D implements Cloneable {

    public static class Double extends Point2D {
        public double x;
        public double y;

        public Double() {
        }

        @Override // com.itextpdf.awt.geom.Point2D
        public double getX() {
            return this.x;
        }

        @Override // com.itextpdf.awt.geom.Point2D
        public double getY() {
            return this.y;
        }

        @Override // com.itextpdf.awt.geom.Point2D
        public void setLocation(double d, double d2) {
            this.x = d;
            this.y = d2;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.x + ",y=" + this.y + "]";
        }

        public Double(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }

    public static class Float extends Point2D {
        public float x;
        public float y;

        public Float() {
        }

        @Override // com.itextpdf.awt.geom.Point2D
        public double getX() {
            return this.x;
        }

        @Override // com.itextpdf.awt.geom.Point2D
        public double getY() {
            return this.y;
        }

        public void setLocation(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        public String toString() {
            return getClass().getName() + "[x=" + this.x + ",y=" + this.y + "]";
        }

        public Float(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        @Override // com.itextpdf.awt.geom.Point2D
        public void setLocation(double d, double d2) {
            this.x = (float) d;
            this.y = (float) d2;
        }
    }

    public static double distance(double d, double d2, double d3, double d4) {
        return Math.sqrt(distanceSq(d, d2, d3, d4));
    }

    public static double distanceSq(double d, double d2, double d3, double d4) {
        double d5 = d3 - d;
        double d6 = d4 - d2;
        return (d5 * d5) + (d6 * d6);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point2D)) {
            return false;
        }
        Point2D point2D = (Point2D) obj;
        return getX() == point2D.getX() && getY() == point2D.getY();
    }

    public abstract double getX();

    public abstract double getY();

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.append(getX());
        hashCode.append(getY());
        return hashCode.hashCode();
    }

    public abstract void setLocation(double d, double d2);

    public void setLocation(Point2D point2D) {
        setLocation(point2D.getX(), point2D.getY());
    }

    public double distance(double d, double d2) {
        return Math.sqrt(distanceSq(d, d2));
    }

    public double distanceSq(double d, double d2) {
        return distanceSq(getX(), getY(), d, d2);
    }

    public double distance(Point2D point2D) {
        return Math.sqrt(distanceSq(point2D));
    }

    public double distanceSq(Point2D point2D) {
        return distanceSq(getX(), getY(), point2D.getX(), point2D.getY());
    }
}
