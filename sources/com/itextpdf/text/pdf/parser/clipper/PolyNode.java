package com.itextpdf.text.pdf.parser.clipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PolyNode {
    private Clipper.EndType endType;
    private int index;
    private boolean isOpen;
    private Clipper.JoinType joinType;
    private PolyNode parent;
    private final Path polygon = new Path();
    protected final List<PolyNode> childs = new ArrayList();

    public enum NodeType {
        ANY,
        OPEN,
        CLOSED
    }

    private PolyNode getNextSiblingUp() {
        PolyNode polyNode = this.parent;
        if (polyNode == null) {
            return null;
        }
        return this.index == polyNode.childs.size() + (-1) ? this.parent.getNextSiblingUp() : this.parent.childs.get(this.index + 1);
    }

    private boolean isHoleNode() {
        boolean z = true;
        for (PolyNode polyNode = this.parent; polyNode != null; polyNode = polyNode.parent) {
            z = !z;
        }
        return z;
    }

    public void addChild(PolyNode polyNode) {
        int size = this.childs.size();
        this.childs.add(polyNode);
        polyNode.parent = this;
        polyNode.index = size;
    }

    public int getChildCount() {
        return this.childs.size();
    }

    public List<PolyNode> getChilds() {
        return Collections.unmodifiableList(this.childs);
    }

    public List<Point.LongPoint> getContour() {
        return this.polygon;
    }

    public Clipper.EndType getEndType() {
        return this.endType;
    }

    public Clipper.JoinType getJoinType() {
        return this.joinType;
    }

    public PolyNode getNext() {
        return !this.childs.isEmpty() ? this.childs.get(0) : getNextSiblingUp();
    }

    public PolyNode getParent() {
        return this.parent;
    }

    public Path getPolygon() {
        return this.polygon;
    }

    public boolean isHole() {
        return isHoleNode();
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setEndType(Clipper.EndType endType) {
        this.endType = endType;
    }

    public void setJoinType(Clipper.JoinType joinType) {
        this.joinType = joinType;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public void setParent(PolyNode polyNode) {
        this.parent = polyNode;
    }
}
