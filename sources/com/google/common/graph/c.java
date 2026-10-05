package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import defpackage.C3663pj;
import defpackage.C3744qj;
import defpackage.C4127vW;
import defpackage.C4208wW;
import defpackage.InterfaceC3459nD;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e implements MutableNetwork {
    public c(NetworkBuilder networkBuilder) {
        super(networkBuilder);
    }

    public final InterfaceC3459nD a(Object obj) {
        InterfaceC3459nD interfaceC3459nDB = b();
        Preconditions.checkState(this.nodeConnections.h(obj, interfaceC3459nDB) == null);
        return interfaceC3459nDB;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        Preconditions.checkNotNull(obj3, "edge");
        if (containsEdge(obj3)) {
            EndpointPair endpointPairIncidentNodes = incidentNodes(obj3);
            EndpointPair endpointPairOf = EndpointPair.of(this, obj, obj2);
            Preconditions.checkArgument(endpointPairIncidentNodes.equals(endpointPairOf), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", obj3, endpointPairIncidentNodes, endpointPairOf);
            return false;
        }
        InterfaceC3459nD interfaceC3459nDA = (InterfaceC3459nD) this.nodeConnections.e(obj);
        if (!allowsParallelEdges()) {
            Preconditions.checkArgument(interfaceC3459nDA == null || !interfaceC3459nDA.b().contains(obj2), "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", obj, obj2);
        }
        boolean zEquals = obj.equals(obj2);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!zEquals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", obj);
        }
        if (interfaceC3459nDA == null) {
            interfaceC3459nDA = a(obj);
        }
        interfaceC3459nDA.j(obj3, obj2);
        InterfaceC3459nD interfaceC3459nDA2 = (InterfaceC3459nD) this.nodeConnections.e(obj2);
        if (interfaceC3459nDA2 == null) {
            interfaceC3459nDA2 = a(obj2);
        }
        interfaceC3459nDA2.l(obj3, obj, zEquals);
        this.edgeToReferenceNode.h(obj3, obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        if (containsNode(obj)) {
            return false;
        }
        a(obj);
        return true;
    }

    public final InterfaceC3459nD b() {
        if (isDirected()) {
            return allowsParallelEdges() ? C3663pj.p() : C3744qj.n();
        }
        return allowsParallelEdges() ? C4127vW.p() : C4208wW.m();
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeEdge(Object obj) {
        Preconditions.checkNotNull(obj, "edge");
        Object objE = this.edgeToReferenceNode.e(obj);
        boolean z = false;
        if (objE == null) {
            return false;
        }
        InterfaceC3459nD interfaceC3459nD = (InterfaceC3459nD) this.nodeConnections.e(objE);
        Objects.requireNonNull(interfaceC3459nD);
        InterfaceC3459nD interfaceC3459nD2 = interfaceC3459nD;
        Object objF = interfaceC3459nD2.f(obj);
        InterfaceC3459nD interfaceC3459nD3 = (InterfaceC3459nD) this.nodeConnections.e(objF);
        Objects.requireNonNull(interfaceC3459nD3);
        InterfaceC3459nD interfaceC3459nD4 = interfaceC3459nD3;
        interfaceC3459nD2.h(obj);
        if (allowsSelfLoops() && objE.equals(objF)) {
            z = true;
        }
        interfaceC3459nD4.d(obj, z);
        this.edgeToReferenceNode.i(obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        InterfaceC3459nD interfaceC3459nD = (InterfaceC3459nD) this.nodeConnections.e(obj);
        if (interfaceC3459nD == null) {
            return false;
        }
        UnmodifiableIterator it = ImmutableList.copyOf((Collection) interfaceC3459nD.e()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.i(obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }
}
