package com.google.common.graph;

import com.google.common.base.Preconditions;
import defpackage.AbstractC0351As;
import defpackage.C3838rx;
import defpackage.C3919sx;
import defpackage.InterfaceC0778Nq;
import defpackage.InterfaceC2417i7;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class f extends AbstractValueGraph {
    private final boolean allowsSelfLoops;
    long edgeCount;
    private final boolean isDirected;
    final C3838rx nodeConnections;
    private final ElementOrder<Object> nodeOrder;

    public class a extends AbstractC0351As {
        public final /* synthetic */ InterfaceC0778Nq c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, InterfaceC2417i7 interfaceC2417i7, Object obj, InterfaceC0778Nq interfaceC0778Nq) {
            super(interfaceC2417i7, obj);
            this.c = interfaceC0778Nq;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return this.c.g(this.a);
        }
    }

    public f(com.google.common.graph.a aVar) {
        this(aVar, aVar.nodeOrder.createMap(aVar.expectedNodeCount.or(10).intValue()), 0L);
    }

    public final InterfaceC0778Nq a(Object obj) {
        InterfaceC0778Nq interfaceC0778Nq = (InterfaceC0778Nq) this.nodeConnections.e(obj);
        if (interfaceC0778Nq != null) {
            return interfaceC0778Nq;
        }
        Preconditions.checkNotNull(obj);
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
        sb.append("Node ");
        sb.append(strValueOf);
        sb.append(" is not an element of this graph.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set adjacentNodes(Object obj) {
        return a(obj).a();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final Object b(Object obj, Object obj2, Object obj3) {
        InterfaceC0778Nq interfaceC0778Nq = (InterfaceC0778Nq) this.nodeConnections.e(obj);
        Object objE = interfaceC0778Nq == null ? null : interfaceC0778Nq.e(obj2);
        return objE == null ? obj3 : objE;
    }

    public final boolean c(Object obj, Object obj2) {
        InterfaceC0778Nq interfaceC0778Nq = (InterfaceC0778Nq) this.nodeConnections.e(obj);
        return interfaceC0778Nq != null && interfaceC0778Nq.b().contains(obj2);
    }

    public final boolean containsNode(Object obj) {
        return this.nodeConnections.d(obj);
    }

    @Override // defpackage.AbstractC4084v
    public long edgeCount() {
        return this.edgeCount;
    }

    public Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
        return b(Preconditions.checkNotNull(obj), Preconditions.checkNotNull(obj2), obj3);
    }

    @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(Object obj, Object obj2) {
        return c(Preconditions.checkNotNull(obj), Preconditions.checkNotNull(obj2));
    }

    @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set incidentEdges(Object obj) {
        return new a(this, this, obj, a(obj));
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public ElementOrder nodeOrder() {
        return this.nodeOrder;
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set nodes() {
        return this.nodeConnections.j();
    }

    public Object edgeValueOrDefault(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return b(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && c(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return a(obj).c();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return a(obj).b();
    }

    public f(com.google.common.graph.a aVar, Map map, long j) {
        C3838rx c3838rx;
        this.isDirected = aVar.directed;
        this.allowsSelfLoops = aVar.allowsSelfLoops;
        this.nodeOrder = aVar.nodeOrder.cast();
        if (map instanceof TreeMap) {
            c3838rx = new C3919sx(map);
        } else {
            c3838rx = new C3838rx(map);
        }
        this.nodeConnections = c3838rx;
        this.edgeCount = Graphs.checkNonNegative(j);
    }
}
