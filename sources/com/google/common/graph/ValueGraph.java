package com.google.common.graph;

import com.google.common.annotations.Beta;
import defpackage.InterfaceC2417i7;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface ValueGraph<N, V> extends InterfaceC2417i7 {
    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    Set<N> adjacentNodes(N n);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    boolean allowsSelfLoops();

    Graph<N> asGraph();

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    int degree(N n);

    V edgeValueOrDefault(EndpointPair<N> endpointPair, V v);

    V edgeValueOrDefault(N n, N n2, V v);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    Set<EndpointPair<N>> edges();

    boolean equals(Object obj);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    int inDegree(N n);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    ElementOrder<N> incidentEdgeOrder();

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    Set<EndpointPair<N>> incidentEdges(N n);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    boolean isDirected();

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    ElementOrder<N> nodeOrder();

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    Set<N> nodes();

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    int outDegree(N n);

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n);
}
