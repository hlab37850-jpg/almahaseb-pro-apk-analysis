package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Subpath {
    private boolean closed;
    private List<Shape> segments;
    private Point2D startPoint;

    public Subpath() {
        this.segments = new ArrayList();
    }

    public void addSegment(Shape shape) {
        if (this.closed) {
            return;
        }
        if (isSinglePointOpen()) {
            this.startPoint = shape.getBasePoints().get(0);
        }
        this.segments.add(shape);
    }

    public Point2D getLastPoint() {
        Point2D point2D = this.startPoint;
        if (this.segments.size() <= 0 || this.closed) {
            return point2D;
        }
        List<Shape> list = this.segments;
        Shape shape = list.get(list.size() - 1);
        return shape.getBasePoints().get(shape.getBasePoints().size() - 1);
    }

    public List<Point2D> getPiecewiseLinearApproximation() {
        List<Point2D> listSubList;
        ArrayList arrayList = new ArrayList();
        if (this.segments.size() == 0) {
            return arrayList;
        }
        if (this.segments.get(0) instanceof BezierCurve) {
            arrayList.addAll(((BezierCurve) this.segments.get(0)).getPiecewiseLinearApproximation());
        } else {
            arrayList.addAll(this.segments.get(0).getBasePoints());
        }
        for (int i = 1; i < this.segments.size(); i++) {
            if (this.segments.get(i) instanceof BezierCurve) {
                List<Point2D> piecewiseLinearApproximation = ((BezierCurve) this.segments.get(i)).getPiecewiseLinearApproximation();
                listSubList = piecewiseLinearApproximation.subList(1, piecewiseLinearApproximation.size());
            } else {
                List<Point2D> basePoints = this.segments.get(i).getBasePoints();
                listSubList = basePoints.subList(1, basePoints.size());
            }
            arrayList.addAll(listSubList);
        }
        return arrayList;
    }

    public List<Shape> getSegments() {
        return this.segments;
    }

    public Point2D getStartPoint() {
        return this.startPoint;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isDegenerate() {
        if (this.segments.size() > 0 && this.closed) {
            return false;
        }
        Iterator<Shape> it = this.segments.iterator();
        while (it.hasNext()) {
            if (new HashSet(it.next().getBasePoints()).size() != 1) {
                return false;
            }
        }
        return this.segments.size() > 0 || this.closed;
    }

    public boolean isEmpty() {
        return this.startPoint == null;
    }

    public boolean isSinglePointClosed() {
        return this.segments.size() == 0 && this.closed;
    }

    public boolean isSinglePointOpen() {
        return this.segments.size() == 0 && !this.closed;
    }

    public void setClosed(boolean z) {
        this.closed = z;
    }

    public void setStartPoint(Point2D point2D) {
        setStartPoint((float) point2D.getX(), (float) point2D.getY());
    }

    public void setStartPoint(float f, float f2) {
        this.startPoint = new Point2D.Float(f, f2);
    }

    public Subpath(Subpath subpath) {
        ArrayList arrayList = new ArrayList();
        this.segments = arrayList;
        this.startPoint = subpath.startPoint;
        arrayList.addAll(subpath.getSegments());
        this.closed = subpath.closed;
    }

    public Subpath(Point2D point2D) {
        this((float) point2D.getX(), (float) point2D.getY());
    }

    public Subpath(float f, float f2) {
        this.segments = new ArrayList();
        this.startPoint = new Point2D.Float(f, f2);
    }
}
