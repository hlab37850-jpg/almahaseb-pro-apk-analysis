package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import defpackage.InterfaceC2417i7;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use GraphBuilder to create a real instance")
@Beta
public interface Graph<N> extends InterfaceC2417i7 {
    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    int degree(N n);

    Set<EndpointPair<N>> edges();

    boolean equals(Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    ElementOrder<N> incidentEdgeOrder();

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n);

    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n);
}
