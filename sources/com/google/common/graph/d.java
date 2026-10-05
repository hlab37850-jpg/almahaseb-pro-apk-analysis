package com.google.common.graph;

import com.google.common.base.Preconditions;
import defpackage.InterfaceC0778Nq;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f implements MutableValueGraph {
    public final ElementOrder a;

    public d(a aVar) {
        super(aVar);
        this.a = aVar.incidentEdgeOrder.cast();
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean addNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        if (containsNode(obj)) {
            return false;
        }
        d(obj);
        return true;
    }

    public final InterfaceC0778Nq d(Object obj) {
        InterfaceC0778Nq interfaceC0778NqE = e();
        Preconditions.checkState(this.nodeConnections.h(obj, interfaceC0778NqE) == null);
        return interfaceC0778NqE;
    }

    public final InterfaceC0778Nq e() {
        return isDirected() ? b.x(this.a) : g.l(this.a);
    }

    @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public ElementOrder incidentEdgeOrder() {
        return this.a;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object putEdgeValue(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        Preconditions.checkNotNull(obj3, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!obj.equals(obj2), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", obj);
        }
        InterfaceC0778Nq interfaceC0778NqD = (InterfaceC0778Nq) this.nodeConnections.e(obj);
        if (interfaceC0778NqD == null) {
            interfaceC0778NqD = d(obj);
        }
        Object objH = interfaceC0778NqD.h(obj2, obj3);
        InterfaceC0778Nq interfaceC0778NqD2 = (InterfaceC0778Nq) this.nodeConnections.e(obj2);
        if (interfaceC0778NqD2 == null) {
            interfaceC0778NqD2 = d(obj2);
        }
        interfaceC0778NqD2.i(obj, obj3);
        if (objH == null) {
            long j = this.edgeCount + 1;
            this.edgeCount = j;
            Graphs.checkPositive(j);
        }
        return objH;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object removeEdge(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        InterfaceC0778Nq interfaceC0778Nq = (InterfaceC0778Nq) this.nodeConnections.e(obj);
        InterfaceC0778Nq interfaceC0778Nq2 = (InterfaceC0778Nq) this.nodeConnections.e(obj2);
        if (interfaceC0778Nq == null || interfaceC0778Nq2 == null) {
            return null;
        }
        Object objD = interfaceC0778Nq.d(obj2);
        if (objD != null) {
            interfaceC0778Nq2.f(obj);
            long j = this.edgeCount - 1;
            this.edgeCount = j;
            Graphs.checkNonNegative(j);
        }
        return objD;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean removeNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        InterfaceC0778Nq interfaceC0778Nq = (InterfaceC0778Nq) this.nodeConnections.e(obj);
        if (interfaceC0778Nq == null) {
            return false;
        }
        if (allowsSelfLoops() && interfaceC0778Nq.d(obj) != null) {
            interfaceC0778Nq.f(obj);
            this.edgeCount--;
        }
        Iterator it = interfaceC0778Nq.b().iterator();
        while (it.hasNext()) {
            InterfaceC0778Nq interfaceC0778Nq2 = (InterfaceC0778Nq) this.nodeConnections.g(it.next());
            Objects.requireNonNull(interfaceC0778Nq2);
            interfaceC0778Nq2.f(obj);
            this.edgeCount--;
        }
        if (isDirected()) {
            Iterator it2 = interfaceC0778Nq.c().iterator();
            while (it2.hasNext()) {
                InterfaceC0778Nq interfaceC0778Nq3 = (InterfaceC0778Nq) this.nodeConnections.g(it2.next());
                Objects.requireNonNull(interfaceC0778Nq3);
                Preconditions.checkState(interfaceC0778Nq3.d(obj) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.i(obj);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object removeEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object putEdgeValue(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }
}
