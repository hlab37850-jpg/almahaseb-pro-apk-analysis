package com.google.common.graph;

import com.google.common.base.Optional;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    final boolean directed;
    boolean allowsSelfLoops = false;
    ElementOrder<Object> nodeOrder = ElementOrder.insertion();
    ElementOrder<Object> incidentEdgeOrder = ElementOrder.unordered();
    Optional<Integer> expectedNodeCount = Optional.absent();

    public a(boolean z) {
        this.directed = z;
    }
}
