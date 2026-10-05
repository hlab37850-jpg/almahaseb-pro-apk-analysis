package defpackage;

import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ValueGraph;
import java.util.Set;

/* JADX INFO: renamed from: Vn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0996Vn extends AbstractValueGraph {
    public abstract ValueGraph a();

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set adjacentNodes(Object obj) {
        return a().adjacentNodes(obj);
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return a().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public int degree(Object obj) {
        return a().degree(obj);
    }

    @Override // defpackage.AbstractC4084v
    public long edgeCount() {
        return a().edges().size();
    }

    @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public ElementOrder incidentEdgeOrder() {
        return a().incidentEdgeOrder();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean isDirected() {
        return a().isDirected();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public ElementOrder nodeOrder() {
        return a().nodeOrder();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set nodes() {
        return a().nodes();
    }
}
