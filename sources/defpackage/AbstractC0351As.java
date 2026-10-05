package defpackage;

import com.google.common.graph.EndpointPair;
import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: renamed from: As, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0351As extends AbstractSet {
    public final Object a;
    public final InterfaceC2417i7 b;

    public AbstractC0351As(InterfaceC2417i7 interfaceC2417i7, Object obj) {
        this.b = interfaceC2417i7;
        this.a = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        if (this.b.isDirected()) {
            if (!endpointPair.isOrdered()) {
                return false;
            }
            Object objSource = endpointPair.source();
            Object objTarget = endpointPair.target();
            return (this.a.equals(objSource) && this.b.successors(this.a).contains(objTarget)) || (this.a.equals(objTarget) && this.b.predecessors(this.a).contains(objSource));
        }
        if (endpointPair.isOrdered()) {
            return false;
        }
        Set setAdjacentNodes = this.b.adjacentNodes(this.a);
        Object objNodeU = endpointPair.nodeU();
        Object objNodeV = endpointPair.nodeV();
        return (this.a.equals(objNodeV) && setAdjacentNodes.contains(objNodeU)) || (this.a.equals(objNodeU) && setAdjacentNodes.contains(objNodeV));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.b.isDirected() ? (this.b.inDegree(this.a) + this.b.outDegree(this.a)) - (this.b.successors(this.a).contains(this.a) ? 1 : 0) : this.b.adjacentNodes(this.a).size();
    }
}
