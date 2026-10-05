package defpackage;

import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Network;
import java.util.Set;

/* JADX INFO: renamed from: Rn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0888Rn extends AbstractNetwork {
    public abstract Network a();

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set adjacentEdges(Object obj) {
        return a().adjacentEdges(obj);
    }

    @Override // com.google.common.graph.Network
    public Set adjacentNodes(Object obj) {
        return a().adjacentNodes(obj);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return a().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return a().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(Object obj) {
        return a().degree(obj);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder edgeOrder() {
        return a().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set edges() {
        return a().edges();
    }

    @Override // com.google.common.graph.Network
    public Set incidentEdges(Object obj) {
        return a().incidentEdges(obj);
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return a().isDirected();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder nodeOrder() {
        return a().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set nodes() {
        return a().nodes();
    }
}
