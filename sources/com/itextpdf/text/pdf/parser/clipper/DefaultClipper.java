package com.itextpdf.text.pdf.parser.clipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultClipper extends ClipperBase {
    private static final Logger LOGGER = Logger.getLogger(DefaultClipper.class.getName());
    private Edge activeEdges;
    private Clipper.PolyFillType clipFillType;
    private Clipper.ClipType clipType;
    private final List<Path.Join> ghostJoins;
    private final List<IntersectNode> intersectList;
    private final Comparator<IntersectNode> intersectNodeComparer;
    private final List<Path.Join> joins;
    private Path.Maxima maxima;
    protected final List<Path.OutRec> polyOuts;
    private final boolean reverseSolution;
    private ClipperBase.Scanbeam scanbeam;
    private Edge sortedEdges;
    private final boolean strictlySimple;
    private Clipper.PolyFillType subjFillType;
    private boolean usingPolyTree;
    public Clipper.ZFillCallback zFillFunction;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.parser.clipper.DefaultClipper$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType;
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType;

        static {
            int[] iArr = new int[Clipper.ClipType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType = iArr;
            try {
                iArr[Clipper.ClipType.INTERSECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[Clipper.ClipType.UNION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[Clipper.ClipType.DIFFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[Clipper.ClipType.XOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Clipper.PolyFillType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType = iArr2;
            try {
                iArr2[Clipper.PolyFillType.POSITIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType[Clipper.PolyFillType.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class IntersectNode {
        Edge Edge2;
        Edge edge1;
        private Point.LongPoint pt;

        private IntersectNode() {
        }

        public Point.LongPoint getPt() {
            return this.pt;
        }

        public void setPt(Point.LongPoint longPoint) {
            this.pt = longPoint;
        }
    }

    public DefaultClipper() {
        this(0);
    }

    private boolean EdgesAdjacent(IntersectNode intersectNode) {
        Edge edge = intersectNode.edge1;
        Edge edge2 = edge.nextInSEL;
        Edge edge3 = intersectNode.Edge2;
        return edge2 == edge3 || edge.prevInSEL == edge3;
    }

    private Path.OutPt GetLastOutPt(Edge edge) {
        Path.OutRec outRec = this.polyOuts.get(edge.outIdx);
        return edge.side == Edge.Side.LEFT ? outRec.pts : outRec.pts.prev;
    }

    private void InsertMaxima(long j) {
        Path.Maxima maxima;
        Path.Maxima maxima2 = new Path.Maxima();
        maxima2.X = j;
        Path.Maxima maxima3 = this.maxima;
        if (maxima3 == null) {
            this.maxima = maxima2;
            maxima2.Next = null;
            maxima2.Prev = null;
            return;
        }
        if (j < maxima3.X) {
            maxima2.Next = maxima3;
            maxima2.Prev = null;
            this.maxima = maxima2;
            return;
        }
        while (true) {
            maxima = maxima3.Next;
            if (maxima == null || j < maxima.X) {
                break;
            } else {
                maxima3 = maxima;
            }
        }
        if (j == maxima3.X) {
            return;
        }
        maxima2.Next = maxima;
        maxima2.Prev = maxima3;
        Path.Maxima maxima4 = maxima3.Next;
        if (maxima4 != null) {
            maxima4.Prev = maxima2;
        }
        maxima3.Next = maxima2;
    }

    private void addEdgeToSEL(Edge edge) {
        LOGGER.entering(DefaultClipper.class.getName(), "addEdgeToSEL");
        Edge edge2 = this.sortedEdges;
        if (edge2 == null) {
            this.sortedEdges = edge;
            edge.prevInSEL = null;
            edge.nextInSEL = null;
        } else {
            edge.nextInSEL = edge2;
            edge.prevInSEL = null;
            edge2.prevInSEL = edge;
            this.sortedEdges = edge;
        }
    }

    private void addGhostJoin(Path.OutPt outPt, Point.LongPoint longPoint) {
        Path.Join join = new Path.Join();
        join.outPt1 = outPt;
        join.setOffPt(longPoint);
        this.ghostJoins.add(join);
    }

    private void addJoin(Path.OutPt outPt, Path.OutPt outPt2, Point.LongPoint longPoint) {
        LOGGER.entering(DefaultClipper.class.getName(), "addJoin");
        Path.Join join = new Path.Join();
        join.outPt1 = outPt;
        join.outPt2 = outPt2;
        join.setOffPt(longPoint);
        this.joins.add(join);
    }

    private void addLocalMaxPoly(Edge edge, Edge edge2, Point.LongPoint longPoint) {
        addOutPt(edge, longPoint);
        if (edge2.windDelta == 0) {
            addOutPt(edge2, longPoint);
        }
        int i = edge.outIdx;
        int i2 = edge2.outIdx;
        if (i == i2) {
            edge.outIdx = -1;
            edge2.outIdx = -1;
        } else if (i < i2) {
            appendPolygon(edge, edge2);
        } else {
            appendPolygon(edge2, edge);
        }
    }

    private Path.OutPt addLocalMinPoly(Edge edge, Edge edge2, Point.LongPoint longPoint) {
        Path.OutPt outPtAddOutPt;
        Edge edge3;
        LOGGER.entering(DefaultClipper.class.getName(), "addLocalMinPoly");
        if (edge2.isHorizontal() || edge.deltaX > edge2.deltaX) {
            outPtAddOutPt = addOutPt(edge, longPoint);
            edge2.outIdx = edge.outIdx;
            edge.side = Edge.Side.LEFT;
            edge2.side = Edge.Side.RIGHT;
            edge3 = edge.prevInAEL;
            if (edge3 == edge2) {
                edge3 = edge2.prevInAEL;
            }
        } else {
            outPtAddOutPt = addOutPt(edge2, longPoint);
            edge.outIdx = edge2.outIdx;
            edge.side = Edge.Side.RIGHT;
            edge2.side = Edge.Side.LEFT;
            edge3 = edge2.prevInAEL;
            if (edge3 == edge) {
                edge3 = edge.prevInAEL;
            }
            edge = edge2;
        }
        if (edge3 != null && edge3.outIdx >= 0 && Edge.topX(edge3, longPoint.getY()) == Edge.topX(edge, longPoint.getY()) && Edge.slopesEqual(edge, edge3, this.useFullRange) && edge.windDelta != 0 && edge3.windDelta != 0) {
            addJoin(outPtAddOutPt, addOutPt(edge3, longPoint), edge.getTop());
        }
        return outPtAddOutPt;
    }

    private Path.OutPt addOutPt(Edge edge, Point.LongPoint longPoint) {
        Logger logger = LOGGER;
        logger.entering(DefaultClipper.class.getName(), "addOutPt");
        int i = edge.outIdx;
        if (i < 0) {
            Path.OutRec outRecCreateOutRec = createOutRec();
            outRecCreateOutRec.isOpen = edge.windDelta == 0;
            Path.OutPt outPt = new Path.OutPt();
            outRecCreateOutRec.pts = outPt;
            outPt.idx = outRecCreateOutRec.Idx;
            outPt.pt = longPoint;
            outPt.next = outPt;
            outPt.prev = outPt;
            if (!outRecCreateOutRec.isOpen) {
                setHoleState(edge, outRecCreateOutRec);
            }
            edge.outIdx = outRecCreateOutRec.Idx;
            return outPt;
        }
        Path.OutRec outRec = this.polyOuts.get(i);
        Path.OutPt points = outRec.getPoints();
        boolean z = edge.side == Edge.Side.LEFT;
        logger.finest("op=" + points.getPointCount());
        logger.finest(z + " " + longPoint + " " + points.getPt());
        if (z && longPoint.equals(points.getPt())) {
            return points;
        }
        if (!z && longPoint.equals(points.prev.getPt())) {
            return points.prev;
        }
        Path.OutPt outPt2 = new Path.OutPt();
        outPt2.idx = outRec.Idx;
        outPt2.setPt(new Point.LongPoint(longPoint));
        outPt2.next = points;
        Path.OutPt outPt3 = points.prev;
        outPt2.prev = outPt3;
        outPt3.next = outPt2;
        points.prev = outPt2;
        if (z) {
            outRec.setPoints(outPt2);
        }
        return outPt2;
    }

    private void appendPolygon(Edge edge, Edge edge2) {
        Logger logger = LOGGER;
        logger.entering(DefaultClipper.class.getName(), "appendPolygon");
        Path.OutRec outRec = this.polyOuts.get(edge.outIdx);
        Path.OutRec outRec2 = this.polyOuts.get(edge2.outIdx);
        logger.finest("" + edge.outIdx);
        logger.finest("" + edge2.outIdx);
        Path.OutRec lowerMostRec = isParam1RightOfParam2(outRec, outRec2) ? outRec2 : isParam1RightOfParam2(outRec2, outRec) ? outRec : Path.OutPt.getLowerMostRec(outRec, outRec2);
        Path.OutPt points = outRec.getPoints();
        Path.OutPt outPt = points.prev;
        Path.OutPt points2 = outRec2.getPoints();
        Path.OutPt outPt2 = points2.prev;
        logger.finest("p1_lft.getPointCount() = " + points.getPointCount());
        logger.finest("p1_rt.getPointCount() = " + outPt.getPointCount());
        logger.finest("p2_lft.getPointCount() = " + points2.getPointCount());
        logger.finest("p2_rt.getPointCount() = " + outPt2.getPointCount());
        Edge.Side side = edge.side;
        Edge.Side side2 = Edge.Side.LEFT;
        if (side != side2) {
            Edge.Side side3 = edge2.side;
            side2 = Edge.Side.RIGHT;
            if (side3 == side2) {
                points2.reversePolyPtLinks();
                outPt.next = outPt2;
                outPt2.prev = outPt;
                points2.next = points;
                points.prev = points2;
            } else {
                outPt.next = points2;
                points2.prev = outPt;
                points.prev = outPt2;
                outPt2.next = points;
            }
        } else if (edge2.side == side2) {
            points2.reversePolyPtLinks();
            points2.next = points;
            points.prev = points2;
            outPt.next = outPt2;
            outPt2.prev = outPt;
            outRec.setPoints(outPt2);
        } else {
            outPt2.next = points;
            points.prev = outPt2;
            points2.prev = outPt;
            outPt.next = points2;
            outRec.setPoints(points2);
        }
        outRec.bottomPt = null;
        if (lowerMostRec.equals(outRec2)) {
            Path.OutRec outRec3 = outRec2.firstLeft;
            if (outRec3 != outRec) {
                outRec.firstLeft = outRec3;
            }
            outRec.isHole = outRec2.isHole;
        }
        outRec2.setPoints(null);
        outRec2.bottomPt = null;
        outRec2.firstLeft = outRec;
        int i = edge.outIdx;
        int i2 = edge2.outIdx;
        edge.outIdx = -1;
        edge2.outIdx = -1;
        for (Edge edge3 = this.activeEdges; edge3 != null; edge3 = edge3.nextInAEL) {
            if (edge3.outIdx == i2) {
                edge3.outIdx = i;
                edge3.side = side2;
                break;
            }
        }
        outRec2.Idx = outRec.Idx;
    }

    private void buildIntersectList(long j) {
        Edge edge;
        Edge edge2 = this.activeEdges;
        if (edge2 == null) {
            return;
        }
        this.sortedEdges = edge2;
        while (edge2 != null) {
            edge2.prevInSEL = edge2.prevInAEL;
            edge2.nextInSEL = edge2.nextInAEL;
            edge2.getCurrent().setX(Long.valueOf(Edge.topX(edge2, j)));
            edge2 = edge2.nextInAEL;
        }
        boolean z = true;
        while (true) {
            if (z && (edge = this.sortedEdges) != null) {
                boolean z2 = false;
                while (true) {
                    Edge edge3 = edge.nextInSEL;
                    if (edge3 == null) {
                        break;
                    }
                    Point.LongPoint[] longPointArr = new Point.LongPoint[1];
                    if (edge.getCurrent().getX() > edge3.getCurrent().getX()) {
                        intersectPoint(edge, edge3, longPointArr);
                        IntersectNode intersectNode = new IntersectNode();
                        intersectNode.edge1 = edge;
                        intersectNode.Edge2 = edge3;
                        intersectNode.setPt(longPointArr[0]);
                        this.intersectList.add(intersectNode);
                        swapPositionsInSEL(edge, edge3);
                        z2 = true;
                    } else {
                        edge = edge3;
                    }
                }
                Edge edge4 = edge.prevInSEL;
                if (edge4 == null) {
                    break;
                }
                edge4.nextInSEL = null;
                z = z2;
            } else {
                break;
            }
        }
        this.sortedEdges = null;
    }

    private void buildResult(Paths paths) {
        paths.clear();
        for (int i = 0; i < this.polyOuts.size(); i++) {
            Path.OutRec outRec = this.polyOuts.get(i);
            if (outRec.getPoints() != null) {
                Path.OutPt outPt = outRec.getPoints().prev;
                int pointCount = outPt.getPointCount();
                LOGGER.finest("cnt = " + pointCount);
                if (pointCount >= 2) {
                    Path path = new Path(pointCount);
                    for (int i2 = 0; i2 < pointCount; i2++) {
                        path.add(outPt.getPt());
                        outPt = outPt.prev;
                    }
                    paths.add(path);
                }
            }
        }
    }

    private void buildResult2(PolyTree polyTree) {
        PolyNode polyNode;
        polyTree.Clear();
        for (int i = 0; i < this.polyOuts.size(); i++) {
            Path.OutRec outRec = this.polyOuts.get(i);
            int pointCount = outRec.getPoints() != null ? outRec.getPoints().getPointCount() : 0;
            boolean z = outRec.isOpen;
            if ((!z || pointCount >= 2) && (z || pointCount >= 3)) {
                outRec.fixHoleLinkage();
                PolyNode polyNode2 = new PolyNode();
                polyTree.getAllPolys().add(polyNode2);
                outRec.polyNode = polyNode2;
                Path.OutPt outPt = outRec.getPoints().prev;
                for (int i2 = 0; i2 < pointCount; i2++) {
                    polyNode2.getPolygon().add(outPt.getPt());
                    outPt = outPt.prev;
                }
            }
        }
        for (int i3 = 0; i3 < this.polyOuts.size(); i3++) {
            Path.OutRec outRec2 = this.polyOuts.get(i3);
            PolyNode polyNode3 = outRec2.polyNode;
            if (polyNode3 != null) {
                if (outRec2.isOpen) {
                    polyNode3.setOpen(true);
                    polyTree.addChild(outRec2.polyNode);
                } else {
                    Path.OutRec outRec3 = outRec2.firstLeft;
                    if (outRec3 == null || (polyNode = outRec3.polyNode) == null) {
                        polyTree.addChild(polyNode3);
                    } else {
                        polyNode.addChild(polyNode3);
                    }
                }
            }
        }
    }

    private void copyAELToSEL() {
        Edge edge = this.activeEdges;
        this.sortedEdges = edge;
        while (edge != null) {
            edge.prevInSEL = edge.prevInAEL;
            Edge edge2 = edge.nextInAEL;
            edge.nextInSEL = edge2;
            edge = edge2;
        }
    }

    private Path.OutRec createOutRec() {
        Path.OutRec outRec = new Path.OutRec();
        outRec.Idx = -1;
        outRec.isHole = false;
        outRec.isOpen = false;
        outRec.firstLeft = null;
        outRec.setPoints(null);
        outRec.bottomPt = null;
        outRec.polyNode = null;
        this.polyOuts.add(outRec);
        outRec.Idx = this.polyOuts.size() - 1;
        return outRec;
    }

    private void deleteFromAEL(Edge edge) {
        Logger logger = LOGGER;
        logger.entering(DefaultClipper.class.getName(), "deleteFromAEL");
        Edge edge2 = edge.prevInAEL;
        Edge edge3 = edge.nextInAEL;
        if (edge2 == null && edge3 == null && edge != this.activeEdges) {
            return;
        }
        if (edge2 != null) {
            edge2.nextInAEL = edge3;
        } else {
            this.activeEdges = edge3;
        }
        if (edge3 != null) {
            edge3.prevInAEL = edge2;
        }
        edge.nextInAEL = null;
        edge.prevInAEL = null;
        logger.exiting(DefaultClipper.class.getName(), "deleteFromAEL");
    }

    private void deleteFromSEL(Edge edge) {
        LOGGER.entering(DefaultClipper.class.getName(), "deleteFromSEL");
        Edge edge2 = edge.prevInSEL;
        Edge edge3 = edge.nextInSEL;
        if (edge2 == null && edge3 == null && !edge.equals(this.sortedEdges)) {
            return;
        }
        if (edge2 != null) {
            edge2.nextInSEL = edge3;
        } else {
            this.sortedEdges = edge3;
        }
        if (edge3 != null) {
            edge3.prevInSEL = edge2;
        }
        edge.nextInSEL = null;
        edge.prevInSEL = null;
    }

    private boolean doHorzSegmentsOverlap(long j, long j2, long j3, long j4) {
        if (j > j2) {
            j = j2;
            j2 = j;
        }
        if (j3 <= j4) {
            j3 = j4;
            j4 = j3;
        }
        return j < j3 && j4 < j2;
    }

    private void doMaxima(Edge edge) {
        Edge maximaPair = edge.getMaximaPair();
        if (maximaPair == null) {
            if (edge.outIdx >= 0) {
                addOutPt(edge, edge.getTop());
            }
            deleteFromAEL(edge);
            return;
        }
        Edge edge2 = edge.nextInAEL;
        while (edge2 != null && edge2 != maximaPair) {
            Point.LongPoint longPoint = new Point.LongPoint(edge.getTop());
            intersectEdges(edge, edge2, longPoint);
            edge.setTop(longPoint);
            swapPositionsInAEL(edge, edge2);
            edge2 = edge.nextInAEL;
        }
        int i = edge.outIdx;
        if (i == -1 && maximaPair.outIdx == -1) {
            deleteFromAEL(edge);
            deleteFromAEL(maximaPair);
            return;
        }
        if (i >= 0 && maximaPair.outIdx >= 0) {
            if (i >= 0) {
                addLocalMaxPoly(edge, maximaPair, edge.getTop());
            }
            deleteFromAEL(edge);
            deleteFromAEL(maximaPair);
            return;
        }
        if (edge.windDelta != 0) {
            throw new IllegalStateException("DoMaxima error");
        }
        if (i >= 0) {
            addOutPt(edge, edge.getTop());
            edge.outIdx = -1;
        }
        deleteFromAEL(edge);
        if (maximaPair.outIdx >= 0) {
            addOutPt(maximaPair, edge.getTop());
            maximaPair.outIdx = -1;
        }
        deleteFromAEL(maximaPair);
    }

    private void doSimplePolygons() {
        int i = 0;
        while (i < this.polyOuts.size()) {
            int i2 = i + 1;
            Path.OutRec outRec = this.polyOuts.get(i);
            Path.OutPt points = outRec.getPoints();
            if (points != null && !outRec.isOpen) {
                do {
                    Path.OutPt outPt = points.next;
                    while (outPt != outRec.getPoints()) {
                        if (points.getPt().equals(outPt.getPt()) && !outPt.next.equals(points) && !outPt.prev.equals(points)) {
                            Path.OutPt outPt2 = points.prev;
                            Path.OutPt outPt3 = outPt.prev;
                            points.prev = outPt3;
                            outPt3.next = points;
                            outPt.prev = outPt2;
                            outPt2.next = outPt;
                            outRec.setPoints(points);
                            Path.OutRec outRecCreateOutRec = createOutRec();
                            outRecCreateOutRec.setPoints(outPt);
                            updateOutPtIdxs(outRecCreateOutRec);
                            if (poly2ContainsPoly1(outRecCreateOutRec.getPoints(), outRec.getPoints())) {
                                outRecCreateOutRec.isHole = !outRec.isHole;
                                outRecCreateOutRec.firstLeft = outRec;
                                if (this.usingPolyTree) {
                                    fixupFirstLefts2(outRecCreateOutRec, outRec);
                                }
                            } else if (poly2ContainsPoly1(outRec.getPoints(), outRecCreateOutRec.getPoints())) {
                                boolean z = outRec.isHole;
                                outRecCreateOutRec.isHole = z;
                                outRec.isHole = !z;
                                outRecCreateOutRec.firstLeft = outRec.firstLeft;
                                outRec.firstLeft = outRecCreateOutRec;
                                if (this.usingPolyTree) {
                                    fixupFirstLefts2(outRec, outRecCreateOutRec);
                                }
                            } else {
                                outRecCreateOutRec.isHole = outRec.isHole;
                                outRecCreateOutRec.firstLeft = outRec.firstLeft;
                                if (this.usingPolyTree) {
                                    fixupFirstLefts1(outRec, outRecCreateOutRec);
                                }
                            }
                            outPt = points;
                        }
                        outPt = outPt.next;
                    }
                    points = points.next;
                } while (points != outRec.getPoints());
            }
            i = i2;
        }
    }

    private boolean executeInternal() {
        try {
            reset();
            if (this.currentLM != null) {
                long jPopScanbeam = popScanbeam();
                while (true) {
                    insertLocalMinimaIntoAEL(jPopScanbeam);
                    processHorizontals();
                    this.ghostJoins.clear();
                    if (this.scanbeam == null) {
                        break;
                    }
                    jPopScanbeam = popScanbeam();
                    if (processIntersections(jPopScanbeam)) {
                        processEdgesAtTopOfScanbeam(jPopScanbeam);
                        if (this.scanbeam == null && this.currentLM == null) {
                            break;
                        }
                    }
                }
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i >= this.polyOuts.size()) {
                        break;
                    }
                    Path.OutRec outRec = this.polyOuts.get(i);
                    if (outRec.pts != null && !outRec.isOpen) {
                        boolean z2 = outRec.isHole ^ this.reverseSolution;
                        if (outRec.area() <= 0.0d) {
                            z = false;
                        }
                        if (z2 == z) {
                            outRec.getPoints().reversePolyPtLinks();
                        }
                    }
                    i++;
                }
                joinCommonEdges();
                for (int i2 = 0; i2 < this.polyOuts.size(); i2++) {
                    Path.OutRec outRec2 = this.polyOuts.get(i2);
                    if (outRec2.getPoints() != null) {
                        if (outRec2.isOpen) {
                            fixupOutPolyline(outRec2);
                        } else {
                            fixupOutPolygon(outRec2);
                        }
                    }
                }
                if (this.strictlySimple) {
                    doSimplePolygons();
                }
                return true;
            }
            return false;
        } finally {
            this.joins.clear();
            this.ghostJoins.clear();
        }
    }

    private void fixupFirstLefts1(Path.OutRec outRec, Path.OutRec outRec2) {
        Path.OutRec outRec3;
        for (int i = 0; i < this.polyOuts.size(); i++) {
            Path.OutRec outRec4 = this.polyOuts.get(i);
            if (outRec4.getPoints() != null && (outRec3 = outRec4.firstLeft) != null && ClipperBase.parseFirstLeft(outRec3).equals(outRec) && poly2ContainsPoly1(outRec4.getPoints(), outRec2.getPoints())) {
                outRec4.firstLeft = outRec2;
            }
        }
    }

    private void fixupFirstLefts2(Path.OutRec outRec, Path.OutRec outRec2) {
        for (Path.OutRec outRec3 : this.polyOuts) {
            if (outRec3.firstLeft == outRec) {
                outRec3.firstLeft = outRec2;
            }
        }
    }

    private boolean fixupIntersectionOrder() {
        Collections.sort(this.intersectList, this.intersectNodeComparer);
        copyAELToSEL();
        int size = this.intersectList.size();
        for (int i = 0; i < size; i++) {
            if (!EdgesAdjacent(this.intersectList.get(i))) {
                int i2 = i + 1;
                while (i2 < size && !EdgesAdjacent(this.intersectList.get(i2))) {
                    i2++;
                }
                if (i2 == size) {
                    return false;
                }
                IntersectNode intersectNode = this.intersectList.get(i);
                List<IntersectNode> list = this.intersectList;
                list.set(i, list.get(i2));
                this.intersectList.set(i2, intersectNode);
            }
            swapPositionsInSEL(this.intersectList.get(i).edge1, this.intersectList.get(i).Edge2);
        }
        return true;
    }

    private void fixupOutPolygon(Path.OutRec outRec) {
        outRec.bottomPt = null;
        Path.OutPt points = outRec.getPoints();
        boolean z = this.preserveCollinear || this.strictlySimple;
        loop0: while (true) {
            Path.OutPt outPt = null;
            while (true) {
                Path.OutPt outPt2 = points.prev;
                if (outPt2 == points || outPt2 == points.next) {
                    break loop0;
                }
                if (points.getPt().equals(points.next.getPt()) || points.getPt().equals(points.prev.getPt()) || (Point.slopesEqual(points.prev.getPt(), points.getPt(), points.next.getPt(), this.useFullRange) && !(z && Point.isPt2BetweenPt1AndPt3(points.prev.getPt(), points.getPt(), points.next.getPt())))) {
                    Path.OutPt outPt3 = points.prev;
                    outPt3.next = points.next;
                    points.next.prev = outPt3;
                    points = points.prev;
                } else if (points == outPt) {
                    outRec.setPoints(points);
                    return;
                } else {
                    if (outPt == null) {
                        outPt = points;
                    }
                    points = points.next;
                }
            }
        }
        outRec.setPoints(null);
    }

    private void fixupOutPolyline(Path.OutRec outRec) {
        Path.OutPt outPt = outRec.pts;
        Path.OutPt outPt2 = outPt.prev;
        while (outPt != outPt2) {
            outPt = outPt.next;
            if (outPt.pt.equals(outPt.prev.pt)) {
                if (outPt == outPt2) {
                    outPt2 = outPt.prev;
                }
                Path.OutPt outPt3 = outPt.prev;
                outPt3.next = outPt.next;
                outPt.next.prev = outPt3;
                outPt = outPt3;
            }
        }
        if (outPt == outPt.prev) {
            outRec.pts = null;
        }
    }

    private static void getHorzDirection(Edge edge, Clipper.Direction[] directionArr, long[] jArr, long[] jArr2) {
        if (edge.getBot().getX() < edge.getTop().getX()) {
            jArr[0] = edge.getBot().getX();
            jArr2[0] = edge.getTop().getX();
            directionArr[0] = Clipper.Direction.LEFT_TO_RIGHT;
        } else {
            jArr[0] = edge.getTop().getX();
            jArr2[0] = edge.getBot().getX();
            directionArr[0] = Clipper.Direction.RIGHT_TO_LEFT;
        }
    }

    private Path.OutRec getOutRec(int i) {
        Path.OutRec outRec = this.polyOuts.get(i);
        while (true) {
            Path.OutRec outRec2 = outRec;
            if (outRec2 == this.polyOuts.get(outRec2.Idx)) {
                return outRec2;
            }
            outRec = this.polyOuts.get(outRec2.Idx);
        }
    }

    private static boolean getOverlap(long j, long j2, long j3, long j4, long[] jArr, long[] jArr2) {
        if (j < j2) {
            if (j3 < j4) {
                jArr[0] = Math.max(j, j3);
                jArr2[0] = Math.min(j2, j4);
            } else {
                jArr[0] = Math.max(j, j4);
                jArr2[0] = Math.min(j2, j3);
            }
        } else if (j3 < j4) {
            jArr[0] = Math.max(j2, j3);
            jArr2[0] = Math.min(j, j4);
        } else {
            jArr[0] = Math.max(j2, j4);
            jArr2[0] = Math.min(j, j3);
        }
        return jArr[0] < jArr2[0];
    }

    private void insertEdgeIntoAEL(Edge edge, Edge edge2) {
        Logger logger = LOGGER;
        logger.entering(DefaultClipper.class.getName(), "insertEdgeIntoAEL");
        Edge edge3 = this.activeEdges;
        if (edge3 == null) {
            edge.prevInAEL = null;
            edge.nextInAEL = null;
            logger.finest("Edge " + edge.outIdx + " -> " + ((Object) null));
            this.activeEdges = edge;
            return;
        }
        if (edge2 == null && Edge.doesE2InsertBeforeE1(edge3, edge)) {
            edge.prevInAEL = null;
            edge.nextInAEL = this.activeEdges;
            logger.finest("Edge " + edge.outIdx + " -> " + edge.nextInAEL.outIdx);
            this.activeEdges.prevInAEL = edge;
            this.activeEdges = edge;
            return;
        }
        logger.finest("activeEdges unchanged");
        if (edge2 == null) {
            edge2 = this.activeEdges;
        }
        while (true) {
            Edge edge4 = edge2.nextInAEL;
            if (edge4 == null || Edge.doesE2InsertBeforeE1(edge4, edge)) {
                break;
            } else {
                edge2 = edge2.nextInAEL;
            }
        }
        edge.nextInAEL = edge2.nextInAEL;
        Edge edge5 = edge2.nextInAEL;
        if (edge5 != null) {
            edge5.prevInAEL = edge;
        }
        edge.prevInAEL = edge2;
        edge2.nextInAEL = edge;
    }

    private void insertLocalMinimaIntoAEL(long j) {
        Edge edge;
        LOGGER.entering(DefaultClipper.class.getName(), "insertLocalMinimaIntoAEL");
        while (true) {
            ClipperBase.LocalMinima localMinima = this.currentLM;
            if (localMinima == null || localMinima.y != j) {
                return;
            }
            Edge edge2 = localMinima.leftBound;
            Edge edge3 = localMinima.rightBound;
            popLocalMinima();
            Path.OutPt outPtAddLocalMinPoly = null;
            if (edge2 == null) {
                insertEdgeIntoAEL(edge3, null);
                updateWindingCount(edge3);
                if (edge3.isContributing(this.clipFillType, this.subjFillType, this.clipType)) {
                    outPtAddLocalMinPoly = addOutPt(edge3, edge3.getBot());
                }
            } else if (edge3 == null) {
                insertEdgeIntoAEL(edge2, null);
                updateWindingCount(edge2);
                outPtAddLocalMinPoly = edge2.isContributing(this.clipFillType, this.subjFillType, this.clipType) ? addOutPt(edge2, edge2.getBot()) : null;
                insertScanbeam(edge2.getTop().getY());
            } else {
                insertEdgeIntoAEL(edge2, null);
                insertEdgeIntoAEL(edge3, edge2);
                updateWindingCount(edge2);
                edge3.windCnt = edge2.windCnt;
                edge3.windCnt2 = edge2.windCnt2;
                outPtAddLocalMinPoly = edge2.isContributing(this.clipFillType, this.subjFillType, this.clipType) ? addLocalMinPoly(edge2, edge3, edge2.getBot()) : null;
                insertScanbeam(edge2.getTop().getY());
            }
            Path.OutPt outPt = outPtAddLocalMinPoly;
            if (edge3 != null) {
                if (edge3.isHorizontal()) {
                    addEdgeToSEL(edge3);
                } else {
                    insertScanbeam(edge3.getTop().getY());
                }
            }
            if (edge2 != null && edge3 != null) {
                if (outPt != null && edge3.isHorizontal() && this.ghostJoins.size() > 0 && edge3.windDelta != 0) {
                    for (int i = 0; i < this.ghostJoins.size(); i++) {
                        Path.Join join = this.ghostJoins.get(i);
                        if (doHorzSegmentsOverlap(join.outPt1.getPt().getX(), join.getOffPt().getX(), edge3.getBot().getX(), edge3.getTop().getX())) {
                            addJoin(join.outPt1, outPt, join.getOffPt());
                        }
                    }
                }
                if (edge2.outIdx >= 0 && (edge = edge2.prevInAEL) != null && edge.getCurrent().getX() == edge2.getBot().getX()) {
                    Edge edge4 = edge2.prevInAEL;
                    if (edge4.outIdx >= 0 && Edge.slopesEqual(edge4, edge2, this.useFullRange) && edge2.windDelta != 0) {
                        Edge edge5 = edge2.prevInAEL;
                        if (edge5.windDelta != 0) {
                            addJoin(outPt, addOutPt(edge5, edge2.getBot()), edge2.getTop());
                        }
                    }
                }
                if (edge2.nextInAEL != edge3) {
                    if (edge3.outIdx >= 0) {
                        Edge edge6 = edge3.prevInAEL;
                        if (edge6.outIdx >= 0 && Edge.slopesEqual(edge6, edge3, this.useFullRange) && edge3.windDelta != 0) {
                            Edge edge7 = edge3.prevInAEL;
                            if (edge7.windDelta != 0) {
                                addJoin(outPt, addOutPt(edge7, edge3.getBot()), edge3.getTop());
                            }
                        }
                    }
                    Edge edge8 = edge2.nextInAEL;
                    if (edge8 != null) {
                        while (edge8 != edge3) {
                            intersectEdges(edge3, edge8, edge2.getCurrent());
                            edge8 = edge8.nextInAEL;
                        }
                    }
                }
            }
        }
    }

    private void insertScanbeam(long j) {
        ClipperBase.Scanbeam scanbeam = this.scanbeam;
        if (scanbeam == null) {
            ClipperBase.Scanbeam scanbeam2 = new ClipperBase.Scanbeam();
            this.scanbeam = scanbeam2;
            scanbeam2.next = null;
            scanbeam2.y = j;
            return;
        }
        if (j > scanbeam.y) {
            ClipperBase.Scanbeam scanbeam3 = new ClipperBase.Scanbeam();
            scanbeam3.y = j;
            scanbeam3.next = this.scanbeam;
            this.scanbeam = scanbeam3;
            return;
        }
        while (true) {
            ClipperBase.Scanbeam scanbeam4 = scanbeam.next;
            if (scanbeam4 == null || j > scanbeam4.y) {
                break;
            } else {
                scanbeam = scanbeam4;
            }
        }
        if (j == scanbeam.y) {
            return;
        }
        ClipperBase.Scanbeam scanbeam5 = new ClipperBase.Scanbeam();
        scanbeam5.y = j;
        scanbeam5.next = scanbeam.next;
        scanbeam.next = scanbeam5;
    }

    private void intersectEdges(Edge edge, Edge edge2, Point.LongPoint longPoint) {
        Clipper.PolyFillType polyFillType;
        Clipper.PolyFillType polyFillType2;
        Clipper.PolyFillType polyFillType3;
        Clipper.PolyFillType polyFillType4;
        int iAbs;
        int iAbs2;
        int iAbs3;
        int iAbs4;
        LOGGER.entering(DefaultClipper.class.getName(), "insersectEdges");
        boolean z = edge.outIdx >= 0;
        boolean z2 = edge2.outIdx >= 0;
        setZ(longPoint, edge, edge2);
        int i = edge.windDelta;
        if (i == 0 || edge2.windDelta == 0) {
            if (i == 0 && edge2.windDelta == 0) {
                return;
            }
            Clipper.PolyType polyType = edge.polyTyp;
            Clipper.PolyType polyType2 = edge2.polyTyp;
            if (polyType == polyType2 && i != edge2.windDelta && this.clipType == Clipper.ClipType.UNION) {
                if (i == 0) {
                    if (z2) {
                        addOutPt(edge, longPoint);
                        if (z) {
                            edge.outIdx = -1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (z) {
                    addOutPt(edge2, longPoint);
                    if (z2) {
                        edge2.outIdx = -1;
                        return;
                    }
                    return;
                }
                return;
            }
            if (polyType != polyType2) {
                if (i == 0 && Math.abs(edge2.windCnt) == 1 && (this.clipType != Clipper.ClipType.UNION || edge2.windCnt2 == 0)) {
                    addOutPt(edge, longPoint);
                    if (z) {
                        edge.outIdx = -1;
                        return;
                    }
                    return;
                }
                if (edge2.windDelta == 0 && Math.abs(edge.windCnt) == 1) {
                    if (this.clipType != Clipper.ClipType.UNION || edge.windCnt2 == 0) {
                        addOutPt(edge2, longPoint);
                        if (z2) {
                            edge2.outIdx = -1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (edge.polyTyp != edge2.polyTyp) {
            if (edge2.isEvenOddFillType(this.clipFillType, this.subjFillType)) {
                edge.windCnt2 = edge.windCnt2 == 0 ? 1 : 0;
            } else {
                edge.windCnt2 += edge2.windDelta;
            }
            if (edge.isEvenOddFillType(this.clipFillType, this.subjFillType)) {
                edge2.windCnt2 = edge2.windCnt2 == 0 ? 1 : 0;
            } else {
                edge2.windCnt2 -= edge.windDelta;
            }
        } else if (edge.isEvenOddFillType(this.clipFillType, this.subjFillType)) {
            int i2 = edge.windCnt;
            edge.windCnt = edge2.windCnt;
            edge2.windCnt = i2;
        } else {
            int i3 = edge.windCnt;
            int i4 = edge2.windDelta;
            if (i3 + i4 == 0) {
                edge.windCnt = -i3;
            } else {
                edge.windCnt = i3 + i4;
            }
            int i5 = edge2.windCnt;
            int i6 = edge.windDelta;
            if (i5 - i6 == 0) {
                edge2.windCnt = -i5;
            } else {
                edge2.windCnt = i5 - i6;
            }
        }
        Clipper.PolyType polyType3 = edge.polyTyp;
        Clipper.PolyType polyType4 = Clipper.PolyType.SUBJECT;
        if (polyType3 == polyType4) {
            polyFillType = this.subjFillType;
            polyFillType2 = this.clipFillType;
        } else {
            polyFillType = this.clipFillType;
            polyFillType2 = this.subjFillType;
        }
        if (edge2.polyTyp == polyType4) {
            polyFillType3 = this.subjFillType;
            polyFillType4 = this.clipFillType;
        } else {
            polyFillType3 = this.clipFillType;
            polyFillType4 = this.subjFillType;
        }
        int[] iArr = AnonymousClass2.$SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType;
        int i7 = iArr[polyFillType.ordinal()];
        if (i7 != 1) {
            iAbs = i7 != 2 ? Math.abs(edge.windCnt) : -edge.windCnt;
        } else {
            iAbs = edge.windCnt;
        }
        int i8 = iArr[polyFillType3.ordinal()];
        if (i8 != 1) {
            iAbs2 = i8 != 2 ? Math.abs(edge2.windCnt) : -edge2.windCnt;
        } else {
            iAbs2 = edge2.windCnt;
        }
        if (z && z2) {
            if ((iAbs != 0 && iAbs != 1) || ((iAbs2 != 0 && iAbs2 != 1) || (edge.polyTyp != edge2.polyTyp && this.clipType != Clipper.ClipType.XOR))) {
                addLocalMaxPoly(edge, edge2, longPoint);
                return;
            }
            addOutPt(edge, longPoint);
            addOutPt(edge2, longPoint);
            Edge.swapSides(edge, edge2);
            Edge.swapPolyIndexes(edge, edge2);
            return;
        }
        if (z) {
            if (iAbs2 == 0 || iAbs2 == 1) {
                addOutPt(edge, longPoint);
                Edge.swapSides(edge, edge2);
                Edge.swapPolyIndexes(edge, edge2);
                return;
            }
            return;
        }
        if (z2) {
            if (iAbs == 0 || iAbs == 1) {
                addOutPt(edge2, longPoint);
                Edge.swapSides(edge, edge2);
                Edge.swapPolyIndexes(edge, edge2);
                return;
            }
            return;
        }
        if (iAbs == 0 || iAbs == 1) {
            if (iAbs2 == 0 || iAbs2 == 1) {
                int i9 = iArr[polyFillType2.ordinal()];
                if (i9 != 1) {
                    iAbs3 = i9 != 2 ? Math.abs(edge.windCnt2) : -edge.windCnt2;
                } else {
                    iAbs3 = edge.windCnt2;
                }
                int i10 = iArr[polyFillType4.ordinal()];
                if (i10 != 1) {
                    iAbs4 = i10 != 2 ? Math.abs(edge2.windCnt2) : -edge2.windCnt2;
                } else {
                    iAbs4 = edge2.windCnt2;
                }
                if (edge.polyTyp != edge2.polyTyp) {
                    addLocalMinPoly(edge, edge2, longPoint);
                    return;
                }
                if (iAbs != 1 || iAbs2 != 1) {
                    Edge.swapSides(edge, edge2);
                    return;
                }
                int i11 = AnonymousClass2.$SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[this.clipType.ordinal()];
                if (i11 == 1) {
                    if (iAbs3 <= 0 || iAbs4 <= 0) {
                        return;
                    }
                    addLocalMinPoly(edge, edge2, longPoint);
                    return;
                }
                if (i11 == 2) {
                    if (iAbs3 > 0 || iAbs4 > 0) {
                        return;
                    }
                    addLocalMinPoly(edge, edge2, longPoint);
                    return;
                }
                if (i11 != 3) {
                    if (i11 != 4) {
                        return;
                    }
                    addLocalMinPoly(edge, edge2, longPoint);
                    return;
                }
                Clipper.PolyType polyType5 = edge.polyTyp;
                if ((polyType5 != Clipper.PolyType.CLIP || iAbs3 <= 0 || iAbs4 <= 0) && (polyType5 != polyType4 || iAbs3 > 0 || iAbs4 > 0)) {
                    return;
                }
                addLocalMinPoly(edge, edge2, longPoint);
            }
        }
    }

    private void intersectPoint(Edge edge, Edge edge2, Point.LongPoint[] longPointArr) {
        Point.LongPoint longPoint = new Point.LongPoint();
        longPointArr[0] = longPoint;
        if (edge.deltaX == edge2.deltaX) {
            longPoint.setY(Long.valueOf(edge.getCurrent().getY()));
            longPoint.setX(Long.valueOf(Edge.topX(edge, longPoint.getY())));
            return;
        }
        if (edge.getDelta().getX() == 0) {
            longPoint.setX(Long.valueOf(edge.getBot().getX()));
            if (edge2.isHorizontal()) {
                longPoint.setY(Long.valueOf(edge2.getBot().getY()));
            } else {
                longPoint.setY(Long.valueOf(Math.round((longPoint.getX() / edge2.deltaX) + (edge2.getBot().getY() - (edge2.getBot().getX() / edge2.deltaX)))));
            }
        } else if (edge2.getDelta().getX() == 0) {
            longPoint.setX(Long.valueOf(edge2.getBot().getX()));
            if (edge.isHorizontal()) {
                longPoint.setY(Long.valueOf(edge.getBot().getY()));
            } else {
                longPoint.setY(Long.valueOf(Math.round((longPoint.getX() / edge.deltaX) + (edge.getBot().getY() - (edge.getBot().getX() / edge.deltaX)))));
            }
        } else {
            double x = edge.getBot().getX() - (edge.getBot().getY() * edge.deltaX);
            double x2 = edge2.getBot().getX();
            double y = edge2.getBot().getY();
            double d = edge2.deltaX;
            double d2 = x2 - (y * d);
            double d3 = (d2 - x) / (edge.deltaX - d);
            longPoint.setY(Long.valueOf(Math.round(d3)));
            if (Math.abs(edge.deltaX) < Math.abs(edge2.deltaX)) {
                longPoint.setX(Long.valueOf(Math.round((edge.deltaX * d3) + x)));
            } else {
                longPoint.setX(Long.valueOf(Math.round((edge2.deltaX * d3) + d2)));
            }
        }
        if (longPoint.getY() < edge.getTop().getY() || longPoint.getY() < edge2.getTop().getY()) {
            if (edge.getTop().getY() > edge2.getTop().getY()) {
                longPoint.setY(Long.valueOf(edge.getTop().getY()));
            } else {
                longPoint.setY(Long.valueOf(edge2.getTop().getY()));
            }
            if (Math.abs(edge.deltaX) < Math.abs(edge2.deltaX)) {
                longPoint.setX(Long.valueOf(Edge.topX(edge, longPoint.getY())));
            } else {
                longPoint.setX(Long.valueOf(Edge.topX(edge2, longPoint.getY())));
            }
        }
        if (longPoint.getY() > edge.getCurrent().getY()) {
            longPoint.setY(Long.valueOf(edge.getCurrent().getY()));
            if (Math.abs(edge.deltaX) > Math.abs(edge2.deltaX)) {
                longPoint.setX(Long.valueOf(Edge.topX(edge2, longPoint.getY())));
            } else {
                longPoint.setX(Long.valueOf(Edge.topX(edge, longPoint.getY())));
            }
        }
    }

    private static boolean isParam1RightOfParam2(Path.OutRec outRec, Path.OutRec outRec2) {
        do {
            outRec = outRec.firstLeft;
            if (outRec == outRec2) {
                return true;
            }
        } while (outRec != null);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00c4 A[PHI: r15 r21
      0x00c4: PHI (r15v5 com.itextpdf.text.pdf.parser.clipper.Path$OutPt) = (r15v4 com.itextpdf.text.pdf.parser.clipper.Path$OutPt), (r15v6 com.itextpdf.text.pdf.parser.clipper.Path$OutPt) binds: [B:59:0x00c2, B:43:0x0091] A[DONT_GENERATE, DONT_INLINE]
      0x00c4: PHI (r21v4 long) = (r21v3 long), (r21v5 long) binds: [B:59:0x00c2, B:43:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ce A[LOOP:0: B:3:0x001b->B:64:0x00ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x00cd A[SYNTHETIC] */
    private static int isPointInPolygon(Point.LongPoint longPoint, Path.OutPt outPt) {
        long j;
        Path.OutPt outPt2;
        Path.OutPt outPt3;
        long x = longPoint.getX();
        long y = longPoint.getY();
        long x2 = outPt.getPt().getX();
        long y2 = outPt.getPt().getY();
        Path.OutPt outPt4 = outPt;
        int i = 0;
        while (true) {
            Path.OutPt outPt5 = outPt4.next;
            long x3 = outPt5.getPt().getX();
            long y3 = outPt5.getPt().getY();
            if (y3 == y) {
                if (x3 == x) {
                    return -1;
                }
                if (y2 == y) {
                    if ((x3 > x) == (x2 < x)) {
                        return -1;
                    }
                }
            }
            if ((y2 < y) != (y3 < y)) {
                if (x2 < x) {
                    j = x;
                    outPt2 = outPt5;
                    if (x3 > j) {
                        double d = ((x2 - j) * (y3 - y)) - ((x3 - j) * (y2 - y));
                        if (d == 0.0d) {
                            return -1;
                        }
                        if ((d > 0.0d) == (y3 > y2)) {
                            i = 1 - i;
                        }
                    }
                } else if (x3 > x) {
                    i = 1 - i;
                    j = x;
                    outPt3 = outPt5;
                } else {
                    outPt2 = outPt5;
                    j = x;
                    double d2 = ((x2 - x) * (y3 - y)) - ((x3 - x) * (y2 - y));
                    if (d2 == 0.0d) {
                        return -1;
                    }
                    if ((d2 > 0.0d) == (y3 > y2)) {
                        i = 1 - i;
                    }
                }
                if (outPt == outPt3) {
                    return i;
                }
                outPt4 = outPt3;
                x2 = x3;
                y2 = y3;
                x = j;
            } else {
                j = x;
                outPt2 = outPt5;
            }
            outPt3 = outPt2;
            if (outPt == outPt3) {
                return i;
            }
            outPt4 = outPt3;
            x2 = x3;
            y2 = y3;
            x = j;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    private void joinCommonEdges() {
        Path.OutRec lowerMostRec;
        for (int i = 0; i < this.joins.size(); i++) {
            Path.Join join = this.joins.get(i);
            Path.OutRec outRec = getOutRec(join.outPt1.idx);
            Path.OutRec outRec2 = getOutRec(join.outPt2.idx);
            if (outRec.getPoints() != null && outRec2.getPoints() != null && !outRec.isOpen && !outRec2.isOpen) {
                if (outRec == outRec2) {
                    lowerMostRec = outRec;
                } else if (isParam1RightOfParam2(outRec, outRec2)) {
                    lowerMostRec = outRec2;
                } else if (isParam1RightOfParam2(outRec2, outRec)) {
                    lowerMostRec = outRec;
                } else {
                    lowerMostRec = Path.OutPt.getLowerMostRec(outRec, outRec2);
                }
                if (joinPoints(join, outRec, outRec2)) {
                    if (outRec == outRec2) {
                        outRec.setPoints(join.outPt1);
                        outRec.bottomPt = null;
                        Path.OutRec outRecCreateOutRec = createOutRec();
                        outRecCreateOutRec.setPoints(join.outPt2);
                        updateOutPtIdxs(outRecCreateOutRec);
                        if (this.usingPolyTree) {
                            for (int i2 = 0; i2 < this.polyOuts.size() - 1; i2++) {
                                Path.OutRec outRec3 = this.polyOuts.get(i2);
                                if (outRec3.getPoints() != null && ClipperBase.parseFirstLeft(outRec3.firstLeft) == outRec && outRec3.isHole != outRec.isHole && poly2ContainsPoly1(outRec3.getPoints(), join.outPt2)) {
                                    outRec3.firstLeft = outRecCreateOutRec;
                                }
                            }
                        }
                        if (poly2ContainsPoly1(outRecCreateOutRec.getPoints(), outRec.getPoints())) {
                            outRecCreateOutRec.isHole = !outRec.isHole;
                            outRecCreateOutRec.firstLeft = outRec;
                            if (this.usingPolyTree) {
                                fixupFirstLefts2(outRecCreateOutRec, outRec);
                            }
                            if ((outRecCreateOutRec.isHole ^ this.reverseSolution) == (outRecCreateOutRec.area() > 0.0d)) {
                                outRecCreateOutRec.getPoints().reversePolyPtLinks();
                            }
                        } else if (poly2ContainsPoly1(outRec.getPoints(), outRecCreateOutRec.getPoints())) {
                            boolean z = outRec.isHole;
                            outRecCreateOutRec.isHole = z;
                            outRec.isHole = !z;
                            outRecCreateOutRec.firstLeft = outRec.firstLeft;
                            outRec.firstLeft = outRecCreateOutRec;
                            if (this.usingPolyTree) {
                                fixupFirstLefts2(outRec, outRecCreateOutRec);
                            }
                            if ((outRec.isHole ^ this.reverseSolution) == (outRec.area() > 0.0d)) {
                                outRec.getPoints().reversePolyPtLinks();
                            }
                        } else {
                            outRecCreateOutRec.isHole = outRec.isHole;
                            outRecCreateOutRec.firstLeft = outRec.firstLeft;
                            if (this.usingPolyTree) {
                                fixupFirstLefts1(outRec, outRecCreateOutRec);
                            }
                        }
                    } else {
                        outRec2.setPoints(null);
                        outRec2.bottomPt = null;
                        outRec2.Idx = outRec.Idx;
                        outRec.isHole = lowerMostRec.isHole;
                        if (lowerMostRec == outRec2) {
                            outRec.firstLeft = outRec2.firstLeft;
                        }
                        outRec2.firstLeft = outRec;
                        if (this.usingPolyTree) {
                            fixupFirstLefts2(outRec2, outRec);
                        }
                    }
                }
            }
        }
    }

    private static boolean joinHorz(Path.OutPt outPt, Path.OutPt outPt2, Path.OutPt outPt3, Path.OutPt outPt4, Point.LongPoint longPoint, boolean z) {
        Path.OutPt outPtDuplicate;
        Path.OutPt outPtDuplicate2;
        Path.OutPt outPtDuplicate3;
        Path.OutPt outPtDuplicate4;
        Clipper.Direction direction = outPt.getPt().getX() > outPt2.getPt().getX() ? Clipper.Direction.RIGHT_TO_LEFT : Clipper.Direction.LEFT_TO_RIGHT;
        Clipper.Direction direction2 = outPt3.getPt().getX() > outPt4.getPt().getX() ? Clipper.Direction.RIGHT_TO_LEFT : Clipper.Direction.LEFT_TO_RIGHT;
        if (direction == direction2) {
            return false;
        }
        if (direction == Clipper.Direction.LEFT_TO_RIGHT) {
            while (outPt.next.getPt().getX() <= longPoint.getX() && outPt.next.getPt().getX() >= outPt.getPt().getX() && outPt.next.getPt().getY() == longPoint.getY()) {
                outPt = outPt.next;
            }
            if (z && outPt.getPt().getX() != longPoint.getX()) {
                outPt = outPt.next;
            }
            outPtDuplicate = outPt.duplicate(!z);
            if (!outPtDuplicate.getPt().equals(longPoint)) {
                outPtDuplicate.setPt(longPoint);
                outPtDuplicate2 = outPtDuplicate.duplicate(!z);
                Path.OutPt outPt5 = outPtDuplicate;
                outPtDuplicate = outPtDuplicate2;
                outPt = outPt5;
            }
        } else {
            while (outPt.next.getPt().getX() >= longPoint.getX() && outPt.next.getPt().getX() <= outPt.getPt().getX() && outPt.next.getPt().getY() == longPoint.getY()) {
                outPt = outPt.next;
            }
            if (!z && outPt.getPt().getX() != longPoint.getX()) {
                outPt = outPt.next;
            }
            outPtDuplicate = outPt.duplicate(z);
            if (!outPtDuplicate.getPt().equals(longPoint)) {
                outPtDuplicate.setPt(longPoint);
                outPtDuplicate2 = outPtDuplicate.duplicate(z);
                Path.OutPt outPt6 = outPtDuplicate;
                outPtDuplicate = outPtDuplicate2;
                outPt = outPt6;
            }
        }
        if (direction2 == Clipper.Direction.LEFT_TO_RIGHT) {
            while (outPt3.next.getPt().getX() <= longPoint.getX() && outPt3.next.getPt().getX() >= outPt3.getPt().getX() && outPt3.next.getPt().getY() == longPoint.getY()) {
                outPt3 = outPt3.next;
            }
            if (z && outPt3.getPt().getX() != longPoint.getX()) {
                outPt3 = outPt3.next;
            }
            outPtDuplicate3 = outPt3.duplicate(!z);
            if (!outPtDuplicate3.getPt().equals(longPoint)) {
                outPtDuplicate3.setPt(longPoint);
                outPtDuplicate4 = outPtDuplicate3.duplicate(!z);
                Path.OutPt outPt7 = outPtDuplicate3;
                outPtDuplicate3 = outPtDuplicate4;
                outPt3 = outPt7;
            }
        } else {
            while (outPt3.next.getPt().getX() >= longPoint.getX() && outPt3.next.getPt().getX() <= outPt3.getPt().getX() && outPt3.next.getPt().getY() == longPoint.getY()) {
                outPt3 = outPt3.next;
            }
            if (!z && outPt3.getPt().getX() != longPoint.getX()) {
                outPt3 = outPt3.next;
            }
            outPtDuplicate3 = outPt3.duplicate(z);
            if (!outPtDuplicate3.getPt().equals(longPoint)) {
                outPtDuplicate3.setPt(longPoint);
                outPtDuplicate4 = outPtDuplicate3.duplicate(z);
                Path.OutPt outPt8 = outPtDuplicate3;
                outPtDuplicate3 = outPtDuplicate4;
                outPt3 = outPt8;
            }
        }
        if ((direction == Clipper.Direction.LEFT_TO_RIGHT) == z) {
            outPt.prev = outPt3;
            outPt3.next = outPt;
            outPtDuplicate.next = outPtDuplicate3;
            outPtDuplicate3.prev = outPtDuplicate;
        } else {
            outPt.next = outPt3;
            outPt3.prev = outPt;
            outPtDuplicate.prev = outPtDuplicate3;
            outPtDuplicate3.next = outPtDuplicate;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x01ca A[PHI: r3
      0x01ca: PHI (r3v24 com.itextpdf.text.pdf.parser.clipper.Point$LongPoint) = 
      (r3v20 com.itextpdf.text.pdf.parser.clipper.Point$LongPoint)
      (r3v21 com.itextpdf.text.pdf.parser.clipper.Point$LongPoint)
      (r3v22 com.itextpdf.text.pdf.parser.clipper.Point$LongPoint)
      (r3v25 com.itextpdf.text.pdf.parser.clipper.Point$LongPoint)
     binds: [B:100:0x0257, B:97:0x0239, B:90:0x0203, B:81:0x01c7] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean joinPoints(Path.Join join, Path.OutRec outRec, Path.OutRec outRec2) {
        Path.OutPt outPt;
        Path.OutPt outPt2;
        Point.LongPoint longPoint;
        Path.OutPt outPt3;
        Path.OutPt outPt4;
        Path.OutPt outPt5 = join.outPt1;
        Path.OutPt outPt6 = join.outPt2;
        boolean z = true;
        boolean z2 = outPt5.getPt().getY() == join.getOffPt().getY();
        if (z2 && join.getOffPt().equals(join.outPt1.getPt()) && join.getOffPt().equals(join.outPt2.getPt())) {
            if (outRec != outRec2) {
                return false;
            }
            Path.OutPt outPt7 = join.outPt1.next;
            while (outPt7 != outPt5 && outPt7.getPt().equals(join.getOffPt())) {
                outPt7 = outPt7.next;
            }
            boolean z3 = outPt7.getPt().getY() > join.getOffPt().getY();
            Path.OutPt outPt8 = join.outPt2.next;
            while (outPt8 != outPt6 && outPt8.getPt().equals(join.getOffPt())) {
                outPt8 = outPt8.next;
            }
            if (z3 == (outPt8.getPt().getY() > join.getOffPt().getY())) {
                return false;
            }
            if (z3) {
                Path.OutPt outPtDuplicate = outPt5.duplicate(false);
                Path.OutPt outPtDuplicate2 = outPt6.duplicate(true);
                outPt5.prev = outPt6;
                outPt6.next = outPt5;
                outPtDuplicate.next = outPtDuplicate2;
                outPtDuplicate2.prev = outPtDuplicate;
                join.outPt1 = outPt5;
                join.outPt2 = outPtDuplicate;
                return true;
            }
            Path.OutPt outPtDuplicate3 = outPt5.duplicate(true);
            Path.OutPt outPtDuplicate4 = outPt6.duplicate(false);
            outPt5.next = outPt6;
            outPt6.prev = outPt5;
            outPtDuplicate3.prev = outPtDuplicate4;
            outPtDuplicate4.next = outPtDuplicate3;
            join.outPt1 = outPt5;
            join.outPt2 = outPtDuplicate3;
            return true;
        }
        if (!z2) {
            Path.OutPt outPt9 = outPt5.next;
            while (outPt9.getPt().equals(outPt5.getPt()) && outPt9 != outPt5) {
                outPt9 = outPt9.next;
            }
            boolean z4 = outPt9.getPt().getY() > outPt5.getPt().getY() || !Point.slopesEqual(outPt5.getPt(), outPt9.getPt(), join.getOffPt(), this.useFullRange);
            if (z4) {
                outPt9 = outPt5.prev;
                while (outPt9.getPt().equals(outPt5.getPt()) && outPt9 != outPt5) {
                    outPt9 = outPt9.prev;
                }
                if (outPt9.getPt().getY() > outPt5.getPt().getY() || !Point.slopesEqual(outPt5.getPt(), outPt9.getPt(), join.getOffPt(), this.useFullRange)) {
                    return false;
                }
            }
            Path.OutPt outPt10 = outPt6.next;
            while (outPt10.getPt().equals(outPt6.getPt()) && outPt10 != outPt6) {
                outPt10 = outPt10.next;
            }
            boolean z5 = outPt10.getPt().getY() > outPt6.getPt().getY() || !Point.slopesEqual(outPt6.getPt(), outPt10.getPt(), join.getOffPt(), this.useFullRange);
            if (z5) {
                outPt10 = outPt6.prev;
                while (outPt10.getPt().equals(outPt6.getPt()) && outPt10 != outPt6) {
                    outPt10 = outPt10.prev;
                }
                if (outPt10.getPt().getY() > outPt6.getPt().getY() || !Point.slopesEqual(outPt6.getPt(), outPt10.getPt(), join.getOffPt(), this.useFullRange)) {
                    return false;
                }
            }
            if (outPt9 == outPt5 || outPt10 == outPt6 || outPt9 == outPt10 || (outRec == outRec2 && z4 == z5)) {
                return false;
            }
            if (z4) {
                Path.OutPt outPtDuplicate5 = outPt5.duplicate(false);
                Path.OutPt outPtDuplicate6 = outPt6.duplicate(true);
                outPt5.prev = outPt6;
                outPt6.next = outPt5;
                outPtDuplicate5.next = outPtDuplicate6;
                outPtDuplicate6.prev = outPtDuplicate5;
                join.outPt1 = outPt5;
                join.outPt2 = outPtDuplicate5;
                return true;
            }
            Path.OutPt outPtDuplicate7 = outPt5.duplicate(true);
            Path.OutPt outPtDuplicate8 = outPt6.duplicate(false);
            outPt5.next = outPt6;
            outPt6.prev = outPt5;
            outPtDuplicate7.prev = outPtDuplicate8;
            outPtDuplicate8.next = outPtDuplicate7;
            join.outPt1 = outPt5;
            join.outPt2 = outPtDuplicate7;
            return true;
        }
        Path.OutPt outPt11 = outPt5;
        while (outPt11.prev.getPt().getY() == outPt11.getPt().getY() && (outPt4 = outPt11.prev) != outPt5 && outPt4 != outPt6) {
            outPt11 = outPt4;
        }
        do {
            outPt = outPt5;
            if (outPt.next.getPt().getY() != outPt.getPt().getY() || (outPt5 = outPt.next) == outPt11) {
                break;
            }
        } while (outPt5 != outPt6);
        Path.OutPt outPt12 = outPt.next;
        if (outPt12 != outPt11 && outPt12 != outPt6) {
            Path.OutPt outPt13 = outPt6;
            while (outPt13.prev.getPt().getY() == outPt13.getPt().getY() && (outPt3 = outPt13.prev) != outPt6 && outPt3 != outPt) {
                outPt13 = outPt3;
            }
            do {
                outPt2 = outPt6;
                if (outPt2.next.getPt().getY() != outPt2.getPt().getY() || (outPt6 = outPt2.next) == outPt13) {
                    break;
                }
            } while (outPt6 != outPt11);
            Path.OutPt outPt14 = outPt2.next;
            if (outPt14 != outPt13 && outPt14 != outPt11) {
                long[] jArr = new long[1];
                long[] jArr2 = new long[1];
                if (!getOverlap(outPt11.getPt().getX(), outPt.getPt().getX(), outPt13.getPt().getX(), outPt2.getPt().getX(), jArr, jArr2)) {
                    return false;
                }
                long j = jArr[0];
                long j2 = jArr2[0];
                if (outPt11.getPt().getX() >= j && outPt11.getPt().getX() <= j2) {
                    longPoint = new Point.LongPoint(outPt11.getPt());
                    if (outPt11.getPt().getX() <= outPt.getPt().getX()) {
                        z = false;
                    }
                } else if (outPt13.getPt().getX() >= j && outPt13.getPt().getX() <= j2) {
                    longPoint = new Point.LongPoint(outPt13.getPt());
                    if (outPt13.getPt().getX() <= outPt2.getPt().getX()) {
                        z = false;
                    }
                } else if (outPt.getPt().getX() < j || outPt.getPt().getX() > j2) {
                    longPoint = new Point.LongPoint(outPt2.getPt());
                    if (outPt2.getPt().getX() <= outPt13.getPt().getX()) {
                        z = false;
                    }
                } else {
                    longPoint = new Point.LongPoint(outPt.getPt());
                    if (outPt.getPt().getX() <= outPt11.getPt().getX()) {
                        z = false;
                    }
                }
                Point.LongPoint longPoint2 = longPoint;
                boolean z6 = z;
                join.outPt1 = outPt11;
                join.outPt2 = outPt13;
                return joinHorz(outPt11, outPt, outPt13, outPt2, longPoint2, z6);
            }
        }
        return false;
    }

    private static Paths minkowski(Path path, Path path2, boolean z, boolean z2) {
        int size = path.size();
        int size2 = path2.size();
        Paths paths = new Paths(size2);
        if (z) {
            for (int i = 0; i < size2; i++) {
                Path path3 = new Path(size);
                for (Point.LongPoint longPoint : path) {
                    path3.add(new Point.LongPoint(path2.get(i).getX() + longPoint.getX(), path2.get(i).getY() + longPoint.getY(), 0L));
                }
                paths.add(path3);
            }
        } else {
            for (int i2 = 0; i2 < size2; i2++) {
                Path path4 = new Path(size);
                for (Point.LongPoint longPoint2 : path) {
                    path4.add(new Point.LongPoint(path2.get(i2).getX() - longPoint2.getX(), path2.get(i2).getY() - longPoint2.getY(), 0L));
                }
                paths.add(path4);
            }
        }
        Paths paths2 = new Paths((size2 + (z2 ? 1 : 0)) * (size + 1));
        for (int i3 = 0; i3 < (size2 - 1) + (z2 ? 1 : 0); i3++) {
            int i4 = 0;
            while (i4 < size) {
                Path path5 = new Path(4);
                int i5 = i3 % size2;
                int i6 = i4 % size;
                path5.add(paths.get(i5).get(i6));
                int i7 = (i3 + 1) % size2;
                path5.add(paths.get(i7).get(i6));
                i4++;
                int i8 = i4 % size;
                path5.add(paths.get(i7).get(i8));
                path5.add(paths.get(i5).get(i8));
                if (!path5.orientation()) {
                    Collections.reverse(path5);
                }
                paths2.add(path5);
            }
        }
        return paths2;
    }

    public static Paths minkowskiDiff(Path path, Path path2) {
        Paths pathsMinkowski = minkowski(path, path2, false, true);
        DefaultClipper defaultClipper = new DefaultClipper();
        defaultClipper.addPaths(pathsMinkowski, Clipper.PolyType.SUBJECT, true);
        Clipper.ClipType clipType = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType = Clipper.PolyFillType.NON_ZERO;
        defaultClipper.execute(clipType, pathsMinkowski, polyFillType, polyFillType);
        return pathsMinkowski;
    }

    public static Paths minkowskiSum(Path path, Path path2, boolean z) {
        Paths pathsMinkowski = minkowski(path, path2, true, z);
        DefaultClipper defaultClipper = new DefaultClipper();
        defaultClipper.addPaths(pathsMinkowski, Clipper.PolyType.SUBJECT, true);
        Clipper.ClipType clipType = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType = Clipper.PolyFillType.NON_ZERO;
        defaultClipper.execute(clipType, pathsMinkowski, polyFillType, polyFillType);
        return pathsMinkowski;
    }

    private static boolean poly2ContainsPoly1(Path.OutPt outPt, Path.OutPt outPt2) {
        Path.OutPt outPt3 = outPt;
        do {
            int iIsPointInPolygon = isPointInPolygon(outPt3.getPt(), outPt2);
            if (iIsPointInPolygon >= 0) {
                return iIsPointInPolygon > 0;
            }
            outPt3 = outPt3.next;
        } while (outPt3 != outPt);
        return true;
    }

    private long popScanbeam() {
        LOGGER.entering(DefaultClipper.class.getName(), "popBeam");
        ClipperBase.Scanbeam scanbeam = this.scanbeam;
        long j = scanbeam.y;
        this.scanbeam = scanbeam.next;
        return j;
    }

    private void processEdgesAtTopOfScanbeam(long j) {
        LOGGER.entering(DefaultClipper.class.getName(), "processEdgesAtTopOfScanbeam");
        Edge edge = this.activeEdges;
        while (edge != null) {
            double d = j;
            boolean zIsMaxima = edge.isMaxima(d);
            if (zIsMaxima) {
                Edge maximaPair = edge.getMaximaPair();
                zIsMaxima = maximaPair == null || !maximaPair.isHorizontal();
            }
            if (zIsMaxima) {
                if (this.strictlySimple) {
                    InsertMaxima(edge.getTop().getX());
                }
                Edge edge2 = edge.prevInAEL;
                doMaxima(edge);
                edge = edge2 == null ? this.activeEdges : edge2.nextInAEL;
            } else {
                if (edge.isIntermediate(d) && edge.nextInLML.isHorizontal()) {
                    Edge[] edgeArr = {edge};
                    updateEdgeIntoAEL(edgeArr);
                    edge = edgeArr[0];
                    if (edge.outIdx >= 0) {
                        addOutPt(edge, edge.getBot());
                    }
                    addEdgeToSEL(edge);
                } else {
                    edge.getCurrent().setX(Long.valueOf(Edge.topX(edge, j)));
                    edge.getCurrent().setY(Long.valueOf(j));
                }
                if (this.strictlySimple) {
                    Edge edge3 = edge.prevInAEL;
                    if (edge.outIdx >= 0 && edge.windDelta != 0 && edge3 != null && edge3.outIdx >= 0 && edge3.getCurrent().getX() == edge.getCurrent().getX() && edge3.windDelta != 0) {
                        Point.LongPoint longPoint = new Point.LongPoint(edge.getCurrent());
                        setZ(longPoint, edge3, edge);
                        addJoin(addOutPt(edge3, longPoint), addOutPt(edge, longPoint), longPoint);
                    }
                }
                edge = edge.nextInAEL;
            }
        }
        processHorizontals();
        this.maxima = null;
        Edge edge4 = this.activeEdges;
        while (edge4 != null) {
            if (edge4.isIntermediate(j)) {
                Path.OutPt outPtAddOutPt = edge4.outIdx >= 0 ? addOutPt(edge4, edge4.getTop()) : null;
                Edge[] edgeArr2 = {edge4};
                updateEdgeIntoAEL(edgeArr2);
                edge4 = edgeArr2[0];
                Edge edge5 = edge4.prevInAEL;
                Edge edge6 = edge4.nextInAEL;
                if (edge5 != null && edge5.getCurrent().getX() == edge4.getBot().getX() && edge5.getCurrent().getY() == edge4.getBot().getY() && outPtAddOutPt != null && edge5.outIdx >= 0 && edge5.getCurrent().getY() > edge5.getTop().getY() && Edge.slopesEqual(edge4, edge5, this.useFullRange) && edge4.windDelta != 0 && edge5.windDelta != 0) {
                    addJoin(outPtAddOutPt, addOutPt(edge5, edge4.getBot()), edge4.getTop());
                } else if (edge6 != null && edge6.getCurrent().getX() == edge4.getBot().getX() && edge6.getCurrent().getY() == edge4.getBot().getY() && outPtAddOutPt != null && edge6.outIdx >= 0 && edge6.getCurrent().getY() > edge6.getTop().getY() && Edge.slopesEqual(edge4, edge6, this.useFullRange) && edge4.windDelta != 0 && edge6.windDelta != 0) {
                    addJoin(outPtAddOutPt, addOutPt(edge6, edge4.getBot()), edge4.getTop());
                }
            }
            edge4 = edge4.nextInAEL;
        }
        LOGGER.exiting(DefaultClipper.class.getName(), "processEdgesAtTopOfScanbeam");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    private void processHorizontal(Edge edge) {
        Clipper.Direction[] directionArr;
        char c;
        Edge edge2;
        Edge edge3;
        Path.Maxima maxima;
        boolean z;
        Edge edge4;
        Edge edge5;
        Edge edge6;
        Edge edge7;
        Edge edge8;
        Path.Maxima maxima2;
        boolean z2;
        Edge edge9;
        Edge edge10;
        Edge edge11;
        LOGGER.entering(DefaultClipper.class.getName(), "isHorizontal");
        Clipper.Direction[] directionArr2 = new Clipper.Direction[1];
        long[] jArr = new long[1];
        long[] jArr2 = new long[1];
        int i = edge.outIdx;
        char c2 = 0;
        boolean z3 = i >= 0 && this.polyOuts.get(i).isOpen;
        getHorzDirection(edge, directionArr2, jArr, jArr2);
        Edge edge12 = edge;
        while (true) {
            Edge edge13 = edge12.nextInLML;
            if (edge13 == null || !edge13.isHorizontal()) {
                break;
            } else {
                edge12 = edge12.nextInLML;
            }
        }
        Path.OutPt outPt = null;
        Edge maximaPair = edge12.nextInLML == null ? edge12.getMaximaPair() : null;
        Path.Maxima maxima3 = this.maxima;
        if (maxima3 != null) {
            if (directionArr2[0] == Clipper.Direction.LEFT_TO_RIGHT) {
                while (maxima3 != null && maxima3.X <= edge.getBot().getX()) {
                    maxima3 = maxima3.Next;
                }
                if (maxima3 != null && maxima3.X >= edge12.getBot().getX()) {
                    maxima3 = null;
                }
            } else {
                while (true) {
                    Path.Maxima maxima4 = maxima3.Next;
                    if (maxima4 == null || maxima4.X >= edge.getBot().getX()) {
                        break;
                    } else {
                        maxima3 = maxima3.Next;
                    }
                }
                if (maxima3.X <= edge12.getTop().getX()) {
                    maxima3 = null;
                }
            }
        }
        Edge edge14 = edge;
        while (true) {
            boolean z4 = edge14 == edge12;
            Edge nextInAEL = edge14.getNextInAEL(directionArr2[c2]);
            while (true) {
                if (nextInAEL == null) {
                    directionArr = directionArr2;
                    c = 0;
                    break;
                }
                if (maxima3 == null) {
                    directionArr = directionArr2;
                } else if (directionArr2[c2] == Clipper.Direction.LEFT_TO_RIGHT) {
                    while (maxima3 != null && maxima3.X < nextInAEL.getCurrent().getX()) {
                        if (edge14.outIdx >= 0 && !z3) {
                            addOutPt(edge14, new Point.LongPoint(maxima3.X, edge14.getBot().getY()));
                        }
                        maxima3 = maxima3.Next;
                        directionArr2 = directionArr2;
                    }
                    directionArr = directionArr2;
                } else {
                    directionArr = directionArr2;
                    while (maxima3 != null && maxima3.X > nextInAEL.getCurrent().getX()) {
                        if (edge14.outIdx >= 0 && !z3) {
                            addOutPt(edge14, new Point.LongPoint(maxima3.X, edge14.getBot().getY()));
                        }
                        maxima3 = maxima3.Prev;
                    }
                }
                Path.Maxima maxima5 = maxima3;
                if ((directionArr[c2] == Clipper.Direction.LEFT_TO_RIGHT && nextInAEL.getCurrent().getX() > jArr2[c2]) || ((directionArr[c2] == Clipper.Direction.RIGHT_TO_LEFT && nextInAEL.getCurrent().getX() < jArr[c2]) || (nextInAEL.getCurrent().getX() == edge14.getTop().getX() && (edge11 = edge14.nextInLML) != null && nextInAEL.deltaX < edge11.deltaX))) {
                    maxima3 = maxima5;
                    c = 0;
                    break;
                }
                if (edge14.outIdx < 0 || z3) {
                    edge2 = edge14;
                    edge3 = edge12;
                    maxima = maxima5;
                    z = z3;
                    edge4 = nextInAEL;
                    edge5 = maximaPair;
                } else {
                    Path.OutPt outPtAddOutPt = addOutPt(edge14, nextInAEL.getCurrent());
                    Edge edge15 = this.sortedEdges;
                    while (edge15 != null) {
                        if (edge15.outIdx >= 0) {
                            edge6 = edge15;
                            edge7 = edge14;
                            maxima2 = maxima5;
                            edge9 = nextInAEL;
                            edge8 = edge12;
                            z2 = z3;
                            edge10 = maximaPair;
                            if (doHorzSegmentsOverlap(edge14.getBot().getX(), edge14.getTop().getX(), edge15.getBot().getX(), edge15.getTop().getX())) {
                                addJoin(GetLastOutPt(edge6), outPtAddOutPt, edge6.getTop());
                            }
                        } else {
                            edge6 = edge15;
                            edge7 = edge14;
                            edge8 = edge12;
                            maxima2 = maxima5;
                            z2 = z3;
                            edge9 = nextInAEL;
                            edge10 = maximaPair;
                        }
                        edge15 = edge6.nextInSEL;
                        edge14 = edge7;
                        nextInAEL = edge9;
                        maximaPair = edge10;
                        maxima5 = maxima2;
                        edge12 = edge8;
                        z3 = z2;
                    }
                    edge2 = edge14;
                    edge3 = edge12;
                    maxima = maxima5;
                    z = z3;
                    edge4 = nextInAEL;
                    edge5 = maximaPair;
                    addGhostJoin(outPtAddOutPt, edge2.getBot());
                    outPt = outPtAddOutPt;
                }
                if (edge4 == edge5 && z4) {
                    Edge edge16 = edge2;
                    if (edge16.outIdx >= 0) {
                        addLocalMaxPoly(edge16, edge5, edge16.getTop());
                    }
                    deleteFromAEL(edge16);
                    deleteFromAEL(edge5);
                    return;
                }
                Edge edge17 = edge2;
                if (directionArr[0] == Clipper.Direction.LEFT_TO_RIGHT) {
                    intersectEdges(edge17, edge4, new Point.LongPoint(edge4.getCurrent().getX(), edge17.getCurrent().getY()));
                } else {
                    intersectEdges(edge4, edge17, new Point.LongPoint(edge4.getCurrent().getX(), edge17.getCurrent().getY()));
                }
                nextInAEL = edge4.getNextInAEL(directionArr[0]);
                swapPositionsInAEL(edge17, edge4);
                edge14 = edge17;
                maximaPair = edge5;
                directionArr2 = directionArr;
                maxima3 = maxima;
                edge12 = edge3;
                z3 = z;
                c2 = 0;
            }
            Edge edge18 = maximaPair;
            Edge edge19 = edge14.nextInLML;
            if (edge19 == null || !edge19.isHorizontal()) {
                if (edge14.outIdx >= 0 && outPt == null) {
                    Path.OutPt outPtGetLastOutPt = GetLastOutPt(edge14);
                    for (Edge edge20 = this.sortedEdges; edge20 != null; edge20 = edge20.nextInSEL) {
                        if (edge20.outIdx >= 0 && doHorzSegmentsOverlap(edge14.getBot().getX(), edge14.getTop().getX(), edge20.getBot().getX(), edge20.getTop().getX())) {
                            addJoin(GetLastOutPt(edge20), outPtGetLastOutPt, edge20.getTop());
                        }
                    }
                    addGhostJoin(outPtGetLastOutPt, edge14.getTop());
                }
                if (edge14.nextInLML == null) {
                    if (edge14.outIdx >= 0) {
                        addOutPt(edge14, edge14.getTop());
                    }
                    deleteFromAEL(edge14);
                    return;
                }
                if (edge14.outIdx < 0) {
                    updateEdgeIntoAEL(new Edge[]{edge14});
                    return;
                }
                Path.OutPt outPtAddOutPt2 = addOutPt(edge14, edge14.getTop());
                Edge[] edgeArr = {edge14};
                updateEdgeIntoAEL(edgeArr);
                Edge edge21 = edgeArr[0];
                if (edge21.windDelta == 0) {
                    return;
                }
                Edge edge22 = edge21.prevInAEL;
                Edge edge23 = edge21.nextInAEL;
                if (edge22 != null && edge22.getCurrent().getX() == edge21.getBot().getX() && edge22.getCurrent().getY() == edge21.getBot().getY() && edge22.windDelta != 0 && edge22.outIdx >= 0 && edge22.getCurrent().getY() > edge22.getTop().getY() && Edge.slopesEqual(edge21, edge22, this.useFullRange)) {
                    addJoin(outPtAddOutPt2, addOutPt(edge22, edge21.getBot()), edge21.getTop());
                    return;
                }
                if (edge23 == null || edge23.getCurrent().getX() != edge21.getBot().getX() || edge23.getCurrent().getY() != edge21.getBot().getY() || edge23.windDelta == 0 || edge23.outIdx < 0 || edge23.getCurrent().getY() <= edge23.getTop().getY() || !Edge.slopesEqual(edge21, edge23, this.useFullRange)) {
                    return;
                }
                addJoin(outPtAddOutPt2, addOutPt(edge23, edge21.getBot()), edge21.getTop());
                return;
            }
            Edge[] edgeArr2 = new Edge[1];
            edgeArr2[c] = edge14;
            updateEdgeIntoAEL(edgeArr2);
            edge14 = edgeArr2[c];
            if (edge14.outIdx >= 0) {
                addOutPt(edge14, edge14.getBot());
            }
            Clipper.Direction[] directionArr3 = directionArr;
            getHorzDirection(edge14, directionArr3, jArr, jArr2);
            directionArr2 = directionArr3;
            maximaPair = edge18;
            edge12 = edge12;
            z3 = z3;
            c2 = 0;
        }
    }

    private void processHorizontals() {
        LOGGER.entering(DefaultClipper.class.getName(), "processHorizontals");
        Edge edge = this.sortedEdges;
        while (edge != null) {
            deleteFromSEL(edge);
            processHorizontal(edge);
            edge = this.sortedEdges;
        }
    }

    private void processIntersectList() {
        for (int i = 0; i < this.intersectList.size(); i++) {
            IntersectNode intersectNode = this.intersectList.get(i);
            intersectEdges(intersectNode.edge1, intersectNode.Edge2, intersectNode.getPt());
            swapPositionsInAEL(intersectNode.edge1, intersectNode.Edge2);
        }
        this.intersectList.clear();
    }

    private boolean processIntersections(long j) {
        LOGGER.entering(DefaultClipper.class.getName(), "processIntersections");
        if (this.activeEdges == null) {
            return true;
        }
        try {
            buildIntersectList(j);
            if (this.intersectList.size() == 0) {
                return true;
            }
            if (this.intersectList.size() != 1 && !fixupIntersectionOrder()) {
                return false;
            }
            processIntersectList();
            this.sortedEdges = null;
            return true;
        } catch (Exception e) {
            this.sortedEdges = null;
            this.intersectList.clear();
            throw new IllegalStateException("ProcessIntersections error", e);
        }
    }

    private void setHoleState(Edge edge, Path.OutRec outRec) {
        boolean z = false;
        for (Edge edge2 = edge.prevInAEL; edge2 != null; edge2 = edge2.prevInAEL) {
            int i = edge2.outIdx;
            if (i >= 0 && edge2.windDelta != 0) {
                z = !z;
                if (outRec.firstLeft == null) {
                    outRec.firstLeft = this.polyOuts.get(i);
                }
            }
        }
        if (z) {
            outRec.isHole = true;
        }
    }

    private void setZ(Point.LongPoint longPoint, Edge edge, Edge edge2) {
        if (longPoint.getZ() != 0 || this.zFillFunction == null) {
            return;
        }
        if (longPoint.equals(edge.getBot())) {
            longPoint.setZ(Long.valueOf(edge.getBot().getZ()));
            return;
        }
        if (longPoint.equals(edge.getTop())) {
            longPoint.setZ(Long.valueOf(edge.getTop().getZ()));
            return;
        }
        if (longPoint.equals(edge2.getBot())) {
            longPoint.setZ(Long.valueOf(edge2.getBot().getZ()));
        } else if (longPoint.equals(edge2.getTop())) {
            longPoint.setZ(Long.valueOf(edge2.getTop().getZ()));
        } else {
            this.zFillFunction.zFill(edge.getBot(), edge.getTop(), edge2.getBot(), edge2.getTop(), longPoint);
        }
    }

    public static Paths simplifyPolygon(Path path) {
        return simplifyPolygon(path, Clipper.PolyFillType.EVEN_ODD);
    }

    public static Paths simplifyPolygons(Paths paths) {
        return simplifyPolygons(paths, Clipper.PolyFillType.EVEN_ODD);
    }

    private void swapPositionsInAEL(Edge edge, Edge edge2) {
        Edge edge3;
        Logger logger = LOGGER;
        logger.entering(DefaultClipper.class.getName(), "swapPositionsInAEL");
        Edge edge4 = edge.nextInAEL;
        Edge edge5 = edge.prevInAEL;
        if (edge4 == edge5 || (edge3 = edge2.nextInAEL) == edge2.prevInAEL) {
            return;
        }
        if (edge4 == edge2) {
            if (edge3 != null) {
                edge3.prevInAEL = edge;
            }
            Edge edge6 = edge.prevInAEL;
            if (edge6 != null) {
                edge6.nextInAEL = edge2;
            }
            edge2.prevInAEL = edge6;
            edge2.nextInAEL = edge;
            edge.prevInAEL = edge2;
            edge.nextInAEL = edge3;
        } else if (edge3 == edge) {
            if (edge4 != null) {
                edge4.prevInAEL = edge2;
            }
            Edge edge7 = edge2.prevInAEL;
            if (edge7 != null) {
                edge7.nextInAEL = edge;
            }
            edge.prevInAEL = edge7;
            edge.nextInAEL = edge2;
            edge2.prevInAEL = edge;
            edge2.nextInAEL = edge4;
        } else {
            edge.nextInAEL = edge3;
            if (edge3 != null) {
                edge3.prevInAEL = edge;
            }
            Edge edge8 = edge2.prevInAEL;
            edge.prevInAEL = edge8;
            if (edge8 != null) {
                edge8.nextInAEL = edge;
            }
            edge2.nextInAEL = edge4;
            if (edge4 != null) {
                edge4.prevInAEL = edge2;
            }
            edge2.prevInAEL = edge5;
            if (edge5 != null) {
                edge5.nextInAEL = edge2;
            }
        }
        if (edge.prevInAEL == null) {
            this.activeEdges = edge;
        } else if (edge2.prevInAEL == null) {
            this.activeEdges = edge2;
        }
        logger.exiting(DefaultClipper.class.getName(), "swapPositionsInAEL");
    }

    private void swapPositionsInSEL(Edge edge, Edge edge2) {
        Edge edge3 = edge.nextInSEL;
        if (edge3 == null && edge.prevInSEL == null) {
            return;
        }
        Edge edge4 = edge2.nextInSEL;
        if (edge4 == null && edge2.prevInSEL == null) {
            return;
        }
        if (edge3 == edge2) {
            if (edge4 != null) {
                edge4.prevInSEL = edge;
            }
            Edge edge5 = edge.prevInSEL;
            if (edge5 != null) {
                edge5.nextInSEL = edge2;
            }
            edge2.prevInSEL = edge5;
            edge2.nextInSEL = edge;
            edge.prevInSEL = edge2;
            edge.nextInSEL = edge4;
        } else if (edge4 == edge) {
            if (edge3 != null) {
                edge3.prevInSEL = edge2;
            }
            Edge edge6 = edge2.prevInSEL;
            if (edge6 != null) {
                edge6.nextInSEL = edge;
            }
            edge.prevInSEL = edge6;
            edge.nextInSEL = edge2;
            edge2.prevInSEL = edge;
            edge2.nextInSEL = edge3;
        } else {
            Edge edge7 = edge.prevInSEL;
            edge.nextInSEL = edge4;
            if (edge4 != null) {
                edge4.prevInSEL = edge;
            }
            Edge edge8 = edge2.prevInSEL;
            edge.prevInSEL = edge8;
            if (edge8 != null) {
                edge8.nextInSEL = edge;
            }
            edge2.nextInSEL = edge3;
            if (edge3 != null) {
                edge3.prevInSEL = edge2;
            }
            edge2.prevInSEL = edge7;
            if (edge7 != null) {
                edge7.nextInSEL = edge2;
            }
        }
        if (edge.prevInSEL == null) {
            this.sortedEdges = edge;
        } else if (edge2.prevInSEL == null) {
            this.sortedEdges = edge2;
        }
    }

    private void updateEdgeIntoAEL(Edge[] edgeArr) {
        Edge edge = edgeArr[0];
        Edge edge2 = edge.nextInLML;
        if (edge2 == null) {
            throw new IllegalStateException("UpdateEdgeIntoAEL: invalid call");
        }
        Edge edge3 = edge.prevInAEL;
        Edge edge4 = edge.nextInAEL;
        edge2.outIdx = edge.outIdx;
        if (edge3 != null) {
            edge3.nextInAEL = edge2;
        } else {
            this.activeEdges = edge2;
        }
        if (edge4 != null) {
            edge4.prevInAEL = edge2;
        }
        edge2.side = edge.side;
        edge2.windDelta = edge.windDelta;
        edge2.windCnt = edge.windCnt;
        edge2.windCnt2 = edge.windCnt2;
        edgeArr[0] = edge2;
        edge2.setCurrent(edge2.getBot());
        edge2.prevInAEL = edge3;
        edge2.nextInAEL = edge4;
        if (edge2.isHorizontal()) {
            return;
        }
        insertScanbeam(edge2.getTop().getY());
    }

    private void updateOutPtIdxs(Path.OutRec outRec) {
        Path.OutPt points = outRec.getPoints();
        do {
            points.idx = outRec.Idx;
            points = points.prev;
        } while (points != outRec.getPoints());
    }

    private void updateWindingCount(Edge edge) {
        Edge edge2;
        LOGGER.entering(DefaultClipper.class.getName(), "updateWindingCount");
        Edge edge3 = edge.prevInAEL;
        while (edge3 != null && (edge3.polyTyp != edge.polyTyp || edge3.windDelta == 0)) {
            edge3 = edge3.prevInAEL;
        }
        if (edge3 == null) {
            int i = edge.windDelta;
            if (i == 0) {
                i = 1;
            }
            edge.windCnt = i;
            edge.windCnt2 = 0;
            edge2 = this.activeEdges;
        } else if (edge.windDelta == 0 && this.clipType != Clipper.ClipType.UNION) {
            edge.windCnt = 1;
            edge.windCnt2 = edge3.windCnt2;
            edge2 = edge3.nextInAEL;
        } else if (edge.isEvenOddFillType(this.clipFillType, this.subjFillType)) {
            int i2 = edge.windDelta;
            if (i2 == 0) {
                int i3 = 1;
                for (Edge edge4 = edge3.prevInAEL; edge4 != null; edge4 = edge4.prevInAEL) {
                    if (edge4.polyTyp == edge3.polyTyp && edge4.windDelta != 0) {
                        i3 ^= 1;
                    }
                }
                edge.windCnt = i3 ^ 1;
            } else {
                edge.windCnt = i2;
            }
            edge.windCnt2 = edge3.windCnt2;
            edge2 = edge3.nextInAEL;
        } else {
            int i4 = edge3.windCnt;
            int i5 = edge3.windDelta;
            if (i4 * i5 >= 0) {
                int i6 = edge.windDelta;
                if (i6 == 0) {
                    edge.windCnt = i4 < 0 ? i4 - 1 : i4 + 1;
                } else if (i5 * i6 < 0) {
                    edge.windCnt = i4;
                } else {
                    edge.windCnt = i4 + i6;
                }
            } else if (Math.abs(i4) > 1) {
                int i7 = edge3.windDelta;
                int i8 = edge.windDelta;
                if (i7 * i8 < 0) {
                    edge.windCnt = edge3.windCnt;
                } else {
                    edge.windCnt = edge3.windCnt + i8;
                }
            } else {
                int i9 = edge.windDelta;
                if (i9 == 0) {
                    i9 = 1;
                }
                edge.windCnt = i9;
            }
            edge.windCnt2 = edge3.windCnt2;
            edge2 = edge3.nextInAEL;
        }
        if (!edge.isEvenOddAltFillType(this.clipFillType, this.subjFillType)) {
            while (edge2 != edge) {
                edge.windCnt2 += edge2.windDelta;
                edge2 = edge2.nextInAEL;
            }
        } else {
            while (edge2 != edge) {
                if (edge2.windDelta != 0) {
                    edge.windCnt2 = edge.windCnt2 == 0 ? 1 : 0;
                }
                edge2 = edge2.nextInAEL;
            }
        }
    }

    public boolean execute(Clipper.ClipType clipType, Paths paths, Clipper.PolyFillType polyFillType) {
        return execute(clipType, paths, polyFillType, polyFillType);
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.ClipperBase
    public void reset() {
        super.reset();
        this.scanbeam = null;
        this.maxima = null;
        this.activeEdges = null;
        this.sortedEdges = null;
        for (ClipperBase.LocalMinima localMinima = this.minimaList; localMinima != null; localMinima = localMinima.next) {
            insertScanbeam(localMinima.y);
        }
    }

    public DefaultClipper(int i) {
        super((i & 4) != 0);
        this.scanbeam = null;
        this.maxima = null;
        this.activeEdges = null;
        this.sortedEdges = null;
        this.intersectList = new ArrayList();
        this.intersectNodeComparer = new Comparator<IntersectNode>() { // from class: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.1
            @Override // java.util.Comparator
            public int compare(IntersectNode intersectNode, IntersectNode intersectNode2) {
                long y = intersectNode2.getPt().getY() - intersectNode.getPt().getY();
                if (y > 0) {
                    return 1;
                }
                return y < 0 ? -1 : 0;
            }
        };
        this.usingPolyTree = false;
        this.polyOuts = new ArrayList();
        this.joins = new ArrayList();
        this.ghostJoins = new ArrayList();
        this.reverseSolution = (i & 1) != 0;
        this.strictlySimple = (i & 2) != 0;
        this.zFillFunction = null;
    }

    public static Paths simplifyPolygon(Path path, Clipper.PolyFillType polyFillType) {
        Paths paths = new Paths();
        DefaultClipper defaultClipper = new DefaultClipper(2);
        defaultClipper.addPath(path, Clipper.PolyType.SUBJECT, true);
        defaultClipper.execute(Clipper.ClipType.UNION, paths, polyFillType, polyFillType);
        return paths;
    }

    public static Paths simplifyPolygons(Paths paths, Clipper.PolyFillType polyFillType) {
        Paths paths2 = new Paths();
        DefaultClipper defaultClipper = new DefaultClipper(2);
        defaultClipper.addPaths(paths, Clipper.PolyType.SUBJECT, true);
        defaultClipper.execute(Clipper.ClipType.UNION, paths2, polyFillType, polyFillType);
        return paths2;
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.Clipper
    public boolean execute(Clipper.ClipType clipType, PolyTree polyTree) {
        return execute(clipType, polyTree, Clipper.PolyFillType.EVEN_ODD);
    }

    public boolean execute(Clipper.ClipType clipType, PolyTree polyTree, Clipper.PolyFillType polyFillType) {
        return execute(clipType, polyTree, polyFillType, polyFillType);
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.Clipper
    public boolean execute(Clipper.ClipType clipType, Paths paths) {
        return execute(clipType, paths, Clipper.PolyFillType.EVEN_ODD);
    }

    public static Paths minkowskiSum(Path path, Paths paths, boolean z) {
        Paths paths2 = new Paths();
        DefaultClipper defaultClipper = new DefaultClipper();
        for (int i = 0; i < paths.size(); i++) {
            defaultClipper.addPaths(minkowski(path, paths.get(i), true, z), Clipper.PolyType.SUBJECT, true);
            if (z) {
                defaultClipper.addPath(paths.get(i).TranslatePath(path.get(0)), Clipper.PolyType.CLIP, true);
            }
        }
        Clipper.ClipType clipType = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType = Clipper.PolyFillType.NON_ZERO;
        defaultClipper.execute(clipType, paths2, polyFillType, polyFillType);
        return paths2;
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.Clipper
    public boolean execute(Clipper.ClipType clipType, Paths paths, Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        boolean zExecuteInternal;
        synchronized (this) {
            try {
                if (!this.hasOpenPaths) {
                    paths.clear();
                    this.subjFillType = polyFillType;
                    this.clipFillType = polyFillType2;
                    this.clipType = clipType;
                    this.usingPolyTree = false;
                    try {
                        zExecuteInternal = executeInternal();
                        if (zExecuteInternal) {
                            buildResult(paths);
                        }
                        this.polyOuts.clear();
                    } catch (Throwable th) {
                        this.polyOuts.clear();
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("Error: PolyTree struct is needed for open path clipping.");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zExecuteInternal;
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.Clipper
    public boolean execute(Clipper.ClipType clipType, PolyTree polyTree, Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        boolean zExecuteInternal;
        synchronized (this) {
            try {
                this.subjFillType = polyFillType;
                this.clipFillType = polyFillType2;
                this.clipType = clipType;
                this.usingPolyTree = true;
                try {
                    zExecuteInternal = executeInternal();
                    if (zExecuteInternal) {
                        buildResult2(polyTree);
                    }
                    this.polyOuts.clear();
                } catch (Throwable th) {
                    this.polyOuts.clear();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zExecuteInternal;
    }
}
