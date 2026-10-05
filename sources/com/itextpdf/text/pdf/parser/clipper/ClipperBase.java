package com.itextpdf.text.pdf.parser.clipper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ClipperBase implements Clipper {
    private static final long HI_RANGE = 4611686018427387903L;
    private static final Logger LOGGER = Logger.getLogger(Clipper.class.getName());
    private static final long LOW_RANGE = 1073741823;
    protected final boolean preserveCollinear;
    protected boolean useFullRange;
    protected LocalMinima minimaList = null;
    protected LocalMinima currentLM = null;
    protected boolean hasOpenPaths = false;
    private final List<List<Edge>> edges = new ArrayList();

    public class LocalMinima {
        Edge leftBound;
        LocalMinima next;
        Edge rightBound;
        long y;

        public LocalMinima() {
        }
    }

    public class Scanbeam {
        Scanbeam next;
        long y;

        public Scanbeam() {
        }
    }

    public ClipperBase(boolean z) {
        this.preserveCollinear = z;
    }

    private void disposeLocalMinimaList() {
        while (true) {
            LocalMinima localMinima = this.minimaList;
            if (localMinima == null) {
                this.currentLM = null;
                return;
            }
            this.minimaList = localMinima.next;
        }
    }

    private static void initEdge(Edge edge, Edge edge2, Edge edge3, Point.LongPoint longPoint) {
        edge.next = edge2;
        edge.prev = edge3;
        edge.setCurrent(new Point.LongPoint(longPoint));
        edge.outIdx = -1;
    }

    private static void initEdge2(Edge edge, Clipper.PolyType polyType) {
        if (edge.getCurrent().getY() >= edge.next.getCurrent().getY()) {
            edge.setBot(new Point.LongPoint(edge.getCurrent()));
            edge.setTop(new Point.LongPoint(edge.next.getCurrent()));
        } else {
            edge.setTop(new Point.LongPoint(edge.getCurrent()));
            edge.setBot(new Point.LongPoint(edge.next.getCurrent()));
        }
        edge.updateDeltaX();
        edge.polyTyp = polyType;
    }

    private void insertLocalMinima(LocalMinima localMinima) {
        LocalMinima localMinima2;
        LocalMinima localMinima3 = this.minimaList;
        if (localMinima3 == null) {
            this.minimaList = localMinima;
            return;
        }
        if (localMinima.y >= localMinima3.y) {
            localMinima.next = localMinima3;
            this.minimaList = localMinima;
            return;
        }
        while (true) {
            localMinima2 = localMinima3.next;
            if (localMinima2 == null || localMinima.y >= localMinima2.y) {
                break;
            } else {
                localMinima3 = localMinima2;
            }
        }
        localMinima.next = localMinima2;
        localMinima3.next = localMinima;
    }

    public static Path.OutRec parseFirstLeft(Path.OutRec outRec) {
        while (outRec != null && outRec.getPoints() == null) {
            outRec = outRec.firstLeft;
        }
        return outRec;
    }

    private Edge processBound(Edge edge, boolean z) {
        Edge edge2;
        Edge edge3;
        if (edge.outIdx == -2) {
            Edge edge4 = edge;
            if (z) {
                while (edge4.getTop().getY() == edge4.next.getBot().getY()) {
                    edge4 = edge4.next;
                }
                while (edge4 != edge && edge4.deltaX == -3.4E38d) {
                    edge4 = edge4.prev;
                }
            } else {
                while (edge4.getTop().getY() == edge4.prev.getBot().getY()) {
                    edge4 = edge4.prev;
                }
                while (edge4 != edge && edge4.deltaX == -3.4E38d) {
                    edge4 = edge4.next;
                }
            }
            if (edge4 == edge) {
                return z ? edge4.next : edge4.prev;
            }
            Edge edge5 = z ? edge.next : edge.prev;
            LocalMinima localMinima = new LocalMinima();
            localMinima.next = null;
            localMinima.y = edge5.getBot().getY();
            localMinima.leftBound = null;
            localMinima.rightBound = edge5;
            edge5.windDelta = 0;
            Edge edgeProcessBound = processBound(edge5, z);
            insertLocalMinima(localMinima);
            return edgeProcessBound;
        }
        if (edge.deltaX == -3.4E38d) {
            Edge edge6 = z ? edge.prev : edge.next;
            if (edge6.deltaX == -3.4E38d) {
                if (edge6.getBot().getX() != edge.getBot().getX() && edge6.getTop().getX() != edge.getBot().getX()) {
                    edge.reverseHorizontal();
                }
            } else if (edge6.getBot().getX() != edge.getBot().getX()) {
                edge.reverseHorizontal();
            }
        }
        if (z) {
            Edge edge7 = edge;
            while (edge7.getTop().getY() == edge7.next.getBot().getY()) {
                Edge edge8 = edge7.next;
                if (edge8.outIdx == -2) {
                    break;
                }
                edge7 = edge8;
            }
            if (edge7.deltaX == -3.4E38d && edge7.next.outIdx != -2) {
                Edge edge9 = edge7;
                while (true) {
                    edge3 = edge9.prev;
                    if (edge3.deltaX != -3.4E38d) {
                        break;
                    }
                    edge9 = edge3;
                }
                if (edge3.getTop().getX() > edge7.next.getTop().getX()) {
                    edge7 = edge9.prev;
                }
            }
            Edge edge10 = edge;
            while (edge10 != edge7) {
                edge10.nextInLML = edge10.next;
                if (edge10.deltaX == -3.4E38d && edge10 != edge && edge10.getBot().getX() != edge10.prev.getTop().getX()) {
                    edge10.reverseHorizontal();
                }
                edge10 = edge10.next;
            }
            if (edge10.deltaX == -3.4E38d && edge10 != edge && edge10.getBot().getX() != edge10.prev.getTop().getX()) {
                edge10.reverseHorizontal();
            }
            return edge7.next;
        }
        Edge edge11 = edge;
        while (edge11.getTop().getY() == edge11.prev.getBot().getY()) {
            Edge edge12 = edge11.prev;
            if (edge12.outIdx == -2) {
                break;
            }
            edge11 = edge12;
        }
        if (edge11.deltaX == -3.4E38d && edge11.prev.outIdx != -2) {
            Edge edge13 = edge11;
            while (true) {
                edge2 = edge13.next;
                if (edge2.deltaX != -3.4E38d) {
                    break;
                }
                edge13 = edge2;
            }
            if (edge2.getTop().getX() == edge11.prev.getTop().getX() || edge13.next.getTop().getX() > edge11.prev.getTop().getX()) {
                edge11 = edge13.next;
            }
        }
        Edge edge14 = edge;
        while (edge14 != edge11) {
            edge14.nextInLML = edge14.prev;
            if (edge14.deltaX == -3.4E38d && edge14 != edge && edge14.getBot().getX() != edge14.next.getTop().getX()) {
                edge14.reverseHorizontal();
            }
            edge14 = edge14.prev;
        }
        if (edge14.deltaX == -3.4E38d && edge14 != edge && edge14.getBot().getX() != edge14.next.getTop().getX()) {
            edge14.reverseHorizontal();
        }
        return edge11.prev;
    }

    private static boolean rangeTest(Point.LongPoint longPoint, boolean z) {
        if (z) {
            if (longPoint.getX() > HI_RANGE || longPoint.getY() > HI_RANGE || (-longPoint.getX()) > HI_RANGE || (-longPoint.getY()) > HI_RANGE) {
                throw new IllegalStateException("Coordinate outside allowed range");
            }
        } else if (longPoint.getX() > LOW_RANGE || longPoint.getY() > LOW_RANGE || (-longPoint.getX()) > LOW_RANGE || (-longPoint.getY()) > LOW_RANGE) {
            return rangeTest(longPoint, true);
        }
        return z;
    }

    private static Edge removeEdge(Edge edge) {
        Edge edge2 = edge.prev;
        edge2.next = edge.next;
        Edge edge3 = edge.next;
        edge3.prev = edge2;
        edge.prev = null;
        return edge3;
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.Clipper
    public boolean addPath(Path path, Clipper.PolyType polyType, boolean z) {
        boolean z2;
        if (!z && polyType == Clipper.PolyType.CLIP) {
            throw new IllegalStateException("AddPath: Open paths must be subject.");
        }
        int size = path.size() - 1;
        if (z) {
            while (size > 0 && path.get(size).equals(path.get(0))) {
                size--;
            }
        }
        while (size > 0 && path.get(size).equals(path.get(size - 1))) {
            size--;
        }
        if ((z && size < 2) || (!z && size < 1)) {
            return false;
        }
        ArrayList arrayList = new ArrayList(size + 1);
        for (int i = 0; i <= size; i++) {
            arrayList.add(new Edge());
        }
        ((Edge) arrayList.get(1)).setCurrent(new Point.LongPoint(path.get(1)));
        this.useFullRange = rangeTest(path.get(0), this.useFullRange);
        this.useFullRange = rangeTest(path.get(size), this.useFullRange);
        initEdge((Edge) arrayList.get(0), (Edge) arrayList.get(1), (Edge) arrayList.get(size), path.get(0));
        int i2 = size - 1;
        initEdge((Edge) arrayList.get(size), (Edge) arrayList.get(0), (Edge) arrayList.get(i2), path.get(size));
        while (i2 >= 1) {
            this.useFullRange = rangeTest(path.get(i2), this.useFullRange);
            initEdge((Edge) arrayList.get(i2), (Edge) arrayList.get(i2 + 1), (Edge) arrayList.get(i2 - 1), path.get(i2));
            i2--;
        }
        Edge edge = (Edge) arrayList.get(0);
        Edge edge2 = edge;
        Edge edgeRemoveEdge = edge2;
        while (true) {
            if (!edge.getCurrent().equals(edge.next.getCurrent()) || (!z && edge.next.equals(edge2))) {
                Edge edge3 = edge.prev;
                if (edge3 == edge.next) {
                    break;
                }
                if (!z || !Point.slopesEqual(edge3.getCurrent(), edge.getCurrent(), edge.next.getCurrent(), this.useFullRange) || (isPreserveCollinear() && Point.isPt2BetweenPt1AndPt3(edge.prev.getCurrent(), edge.getCurrent(), edge.next.getCurrent()))) {
                    edge = edge.next;
                    if (edge == edgeRemoveEdge || (!z && edge.next == edge2)) {
                        break;
                    }
                } else {
                    if (edge == edge2) {
                        edge2 = edge.next;
                    }
                    edgeRemoveEdge = removeEdge(edge).prev;
                    edge = edgeRemoveEdge;
                }
            } else {
                Edge edge4 = edge.next;
                if (edge == edge4) {
                    break;
                }
                if (edge == edge2) {
                    edge2 = edge4;
                }
                edgeRemoveEdge = removeEdge(edge);
                edge = edgeRemoveEdge;
            }
        }
        if ((!z && edge == edge.next) || (z && edge.prev == edge.next)) {
            return false;
        }
        if (!z) {
            this.hasOpenPaths = true;
            edge2.prev.outIdx = -2;
        }
        Edge edgeProcessBound = edge2;
        boolean z3 = true;
        do {
            initEdge2(edgeProcessBound, polyType);
            edgeProcessBound = edgeProcessBound.next;
            if (z3 && edgeProcessBound.getCurrent().getY() != edge2.getCurrent().getY()) {
                z3 = false;
            }
        } while (edgeProcessBound != edge2);
        if (!z3) {
            this.edges.add(arrayList);
            if (edgeProcessBound.prev.getBot().equals(edgeProcessBound.prev.getTop())) {
                edgeProcessBound = edgeProcessBound.next;
            }
            Edge edge5 = null;
            while (true) {
                Edge edgeFindNextLocMin = edgeProcessBound.findNextLocMin();
                if (edgeFindNextLocMin == edge5) {
                    return true;
                }
                if (edge5 == null) {
                    edge5 = edgeFindNextLocMin;
                }
                LocalMinima localMinima = new LocalMinima();
                localMinima.next = null;
                localMinima.y = edgeFindNextLocMin.getBot().getY();
                double d = edgeFindNextLocMin.deltaX;
                Edge edge6 = edgeFindNextLocMin.prev;
                if (d < edge6.deltaX) {
                    localMinima.leftBound = edge6;
                    localMinima.rightBound = edgeFindNextLocMin;
                    z2 = false;
                } else {
                    localMinima.leftBound = edgeFindNextLocMin;
                    localMinima.rightBound = edge6;
                    z2 = true;
                }
                Edge edge7 = localMinima.leftBound;
                edge7.side = Edge.Side.LEFT;
                Edge edge8 = localMinima.rightBound;
                edge8.side = Edge.Side.RIGHT;
                if (!z) {
                    edge7.windDelta = 0;
                } else if (edge7.next == edge8) {
                    edge7.windDelta = -1;
                } else {
                    edge7.windDelta = 1;
                }
                edge8.windDelta = -edge7.windDelta;
                edgeProcessBound = processBound(edge7, z2);
                if (edgeProcessBound.outIdx == -2) {
                    edgeProcessBound = processBound(edgeProcessBound, z2);
                }
                Edge edgeProcessBound2 = processBound(localMinima.rightBound, !z2);
                if (edgeProcessBound2.outIdx == -2) {
                    edgeProcessBound2 = processBound(edgeProcessBound2, !z2);
                }
                if (localMinima.leftBound.outIdx == -2) {
                    localMinima.leftBound = null;
                } else if (localMinima.rightBound.outIdx == -2) {
                    localMinima.rightBound = null;
                }
                insertLocalMinima(localMinima);
                if (!z2) {
                    edgeProcessBound = edgeProcessBound2;
                }
            }
        } else {
            if (z) {
                return false;
            }
            edgeProcessBound.prev.outIdx = -2;
            LocalMinima localMinima2 = new LocalMinima();
            localMinima2.next = null;
            localMinima2.y = edgeProcessBound.getBot().getY();
            localMinima2.leftBound = null;
            localMinima2.rightBound = edgeProcessBound;
            edgeProcessBound.side = Edge.Side.RIGHT;
            edgeProcessBound.windDelta = 0;
            while (true) {
                if (edgeProcessBound.getBot().getX() != edgeProcessBound.prev.getTop().getX()) {
                    edgeProcessBound.reverseHorizontal();
                }
                Edge edge9 = edgeProcessBound.next;
                if (edge9.outIdx == -2) {
                    insertLocalMinima(localMinima2);
                    this.edges.add(arrayList);
                    return true;
                }
                edgeProcessBound.nextInLML = edge9;
                edgeProcessBound = edge9;
            }
        }
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.Clipper
    public boolean addPaths(Paths paths, Clipper.PolyType polyType, boolean z) {
        boolean z2 = false;
        for (int i = 0; i < paths.size(); i++) {
            if (addPath(paths.get(i), polyType, z)) {
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.itextpdf.text.pdf.parser.clipper.Clipper
    public void clear() {
        disposeLocalMinimaList();
        this.edges.clear();
        this.useFullRange = false;
        this.hasOpenPaths = false;
    }

    public boolean isPreserveCollinear() {
        return this.preserveCollinear;
    }

    public void popLocalMinima() {
        LOGGER.entering(ClipperBase.class.getName(), "popLocalMinima");
        LocalMinima localMinima = this.currentLM;
        if (localMinima == null) {
            return;
        }
        this.currentLM = localMinima.next;
    }

    public void reset() {
        LocalMinima localMinima = this.minimaList;
        this.currentLM = localMinima;
        if (localMinima == null) {
            return;
        }
        while (localMinima != null) {
            Edge edge = localMinima.leftBound;
            if (edge != null) {
                edge.setCurrent(new Point.LongPoint(edge.getBot()));
                edge.side = Edge.Side.LEFT;
                edge.outIdx = -1;
            }
            Edge edge2 = localMinima.rightBound;
            if (edge2 != null) {
                edge2.setCurrent(new Point.LongPoint(edge2.getBot()));
                edge2.side = Edge.Side.RIGHT;
                edge2.outIdx = -1;
            }
            localMinima = localMinima.next;
        }
    }
}
