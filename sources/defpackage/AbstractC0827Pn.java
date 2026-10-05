package defpackage;

import com.google.common.graph.AbstractGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import java.util.Set;

/* JADX INFO: renamed from: Pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0827Pn extends AbstractGraph {
    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set adjacentNodes(Object obj) {
        return delegate().adjacentNodes(obj);
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public int degree(Object obj) {
        return delegate().degree(obj);
    }

    public abstract InterfaceC2417i7 delegate();

    @Override // defpackage.AbstractC4084v
    public long edgeCount() {
        return delegate().edges().size();
    }

    @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(Object obj, Object obj2) {
        return delegate().hasEdgeConnecting(obj, obj2);
    }

    @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public int inDegree(Object obj) {
        return delegate().inDegree(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public ElementOrder incidentEdgeOrder() {
        return delegate().incidentEdgeOrder();
    }

    @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set incidentEdges(Object obj) {
        return delegate().incidentEdges(obj);
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public ElementOrder nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public int outDegree(Object obj) {
        return delegate().outDegree(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return delegate().predecessors(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return delegate().successors(obj);
    }
}
