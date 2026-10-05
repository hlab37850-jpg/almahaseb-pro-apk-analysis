package defpackage;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4084v implements InterfaceC2417i7 {

    /* JADX INFO: renamed from: v$a */
    public class a extends AbstractSet {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return AbstractC3502nl.b(AbstractC4084v.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair<?> endpointPair = (EndpointPair) obj;
            return AbstractC4084v.this.isOrderingCompatible(endpointPair) && AbstractC4084v.this.nodes().contains(endpointPair.nodeU()) && AbstractC4084v.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Ints.saturatedCast(AbstractC4084v.this.edgeCount());
        }
    }

    /* JADX INFO: renamed from: v$b */
    public class b extends AbstractC0351As {
        public b(AbstractC4084v abstractC4084v, InterfaceC2417i7 interfaceC2417i7, Object obj) {
            super(interfaceC2417i7, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return this.b.isDirected() ? Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.b.predecessors(this.a).iterator(), new Function() { // from class: w
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return this.a.e(obj);
                }
            }), Iterators.transform(Sets.difference(this.b.successors(this.a), ImmutableSet.of(this.a)).iterator(), new Function() { // from class: x
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return this.a.f(obj);
                }
            }))) : Iterators.unmodifiableIterator(Iterators.transform(this.b.adjacentNodes(this.a).iterator(), new Function() { // from class: y
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return this.a.g(obj);
                }
            }));
        }

        public final /* synthetic */ EndpointPair e(Object obj) {
            return EndpointPair.ordered(obj, this.a);
        }

        public final /* synthetic */ EndpointPair f(Object obj) {
            return EndpointPair.ordered(this.a, obj);
        }

        public final /* synthetic */ EndpointPair g(Object obj) {
            return EndpointPair.unordered(this.a, obj);
        }
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public int degree(Object obj) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors(obj).size(), successors(obj).size());
        }
        Set setAdjacentNodes = adjacentNodes(obj);
        return IntMath.saturatedAdd(setAdjacentNodes.size(), (allowsSelfLoops() && setAdjacentNodes.contains(obj)) ? 1 : 0);
    }

    public long edgeCount() {
        Iterator it = nodes().iterator();
        long jDegree = 0;
        while (it.hasNext()) {
            jDegree += (long) degree(it.next());
        }
        Preconditions.checkState((1 & jDegree) == 0);
        return jDegree >>> 1;
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set edges() {
        return new a();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        return nodes().contains(obj) && successors(obj).contains(obj2);
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public int inDegree(Object obj) {
        return isDirected() ? predecessors(obj).size() : degree(obj);
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public ElementOrder incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public Set incidentEdges(Object obj) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkArgument(nodes().contains(obj), "Node %s is not an element of this graph.", obj);
        return new b(this, this, obj);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public int outDegree(Object obj) {
        return isDirected() ? successors(obj).size() : degree(obj);
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        Object objNodeU = endpointPair.nodeU();
        return nodes().contains(objNodeU) && successors(objNodeU).contains(endpointPair.nodeV());
    }
}
