package defpackage;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.a;
import com.google.common.graph.d;

/* JADX INFO: renamed from: yR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4365yR extends AbstractC0827Pn implements MutableGraph {
    public final MutableValueGraph a;

    public C4365yR(a aVar) {
        this.a = new d(aVar);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(Object obj) {
        return this.a.addNode(obj);
    }

    @Override // defpackage.AbstractC0827Pn
    public InterfaceC2417i7 delegate() {
        return this.a;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(Object obj, Object obj2) {
        return this.a.putEdgeValue(obj, obj2, EnumC0804Oq.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(Object obj, Object obj2) {
        return this.a.removeEdge(obj, obj2) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(Object obj) {
        return this.a.removeNode(obj);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
