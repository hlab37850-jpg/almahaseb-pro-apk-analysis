package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC0351As;
import defpackage.AbstractC0827Pn;
import defpackage.AbstractC0888Rn;
import defpackage.AbstractC0996Vn;
import defpackage.C4365yR;
import defpackage.InterfaceC2417i7;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class Graphs {

    public enum a {
        PENDING,
        COMPLETE
    }

    public static class b extends AbstractC0827Pn {
        public final Graph a;

        public class a extends AbstractC0351As {

            /* JADX INFO: renamed from: com.google.common.graph.Graphs$b$a$a, reason: collision with other inner class name */
            public class C0246a implements Function {
                public C0246a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public EndpointPair apply(EndpointPair endpointPair) {
                    return EndpointPair.of((Graph<?>) b.this.delegate(), endpointPair.nodeV(), endpointPair.nodeU());
                }
            }

            public a(InterfaceC2417i7 interfaceC2417i7, Object obj) {
                super(interfaceC2417i7, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Iterators.transform(b.this.delegate().incidentEdges(this.a).iterator(), new C0246a());
            }
        }

        public b(Graph graph) {
            this.a = graph;
        }

        @Override // defpackage.AbstractC0827Pn
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Graph delegate() {
            return this.a;
        }

        @Override // defpackage.AbstractC0827Pn, com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public boolean hasEdgeConnecting(Object obj, Object obj2) {
            return delegate().hasEdgeConnecting(obj2, obj);
        }

        @Override // defpackage.AbstractC0827Pn, com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public int inDegree(Object obj) {
            return delegate().outDegree(obj);
        }

        @Override // defpackage.AbstractC0827Pn, com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public Set incidentEdges(Object obj) {
            return new a(this, obj);
        }

        @Override // defpackage.AbstractC0827Pn, com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public int outDegree(Object obj) {
            return delegate().inDegree(obj);
        }

        @Override // defpackage.AbstractC0827Pn, com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public boolean hasEdgeConnecting(EndpointPair endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // defpackage.AbstractC0827Pn, com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set predecessors(Object obj) {
            return delegate().successors(obj);
        }

        @Override // defpackage.AbstractC0827Pn, com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set successors(Object obj) {
            return delegate().predecessors(obj);
        }
    }

    public static class c extends AbstractC0888Rn {
        public final Network a;

        public c(Network network) {
            this.a = network;
        }

        @Override // defpackage.AbstractC0888Rn
        public Network a() {
            return this.a;
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Object edgeConnectingOrNull(Object obj, Object obj2) {
            return a().edgeConnectingOrNull(obj2, obj);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set edgesConnecting(Object obj, Object obj2) {
            return a().edgesConnecting(obj2, obj);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(Object obj, Object obj2) {
            return a().hasEdgeConnecting(obj2, obj);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(Object obj) {
            return a().outDegree(obj);
        }

        @Override // com.google.common.graph.Network
        public Set inEdges(Object obj) {
            return a().outEdges(obj);
        }

        @Override // com.google.common.graph.Network
        public EndpointPair incidentNodes(Object obj) {
            EndpointPair endpointPairIncidentNodes = a().incidentNodes(obj);
            return EndpointPair.of((Network<?, ?>) this.a, endpointPairIncidentNodes.nodeV(), endpointPairIncidentNodes.nodeU());
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(Object obj) {
            return a().inDegree(obj);
        }

        @Override // com.google.common.graph.Network
        public Set outEdges(Object obj) {
            return a().inEdges(obj);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Object edgeConnectingOrNull(EndpointPair endpointPair) {
            return a().edgeConnectingOrNull(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set edgesConnecting(EndpointPair endpointPair) {
            return a().edgesConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair endpointPair) {
            return a().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set predecessors(Object obj) {
            return a().successors(obj);
        }

        @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set successors(Object obj) {
            return a().predecessors(obj);
        }
    }

    public static class d extends AbstractC0996Vn {
        public final ValueGraph a;

        public d(ValueGraph valueGraph) {
            this.a = valueGraph;
        }

        @Override // defpackage.AbstractC0996Vn
        public ValueGraph a() {
            return this.a;
        }

        @Override // com.google.common.graph.ValueGraph
        public Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
            return a().edgeValueOrDefault(obj2, obj, obj3);
        }

        @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public boolean hasEdgeConnecting(Object obj, Object obj2) {
            return a().hasEdgeConnecting(obj2, obj);
        }

        @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public int inDegree(Object obj) {
            return a().outDegree(obj);
        }

        @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public int outDegree(Object obj) {
            return a().inDegree(obj);
        }

        @Override // com.google.common.graph.ValueGraph
        public Object edgeValueOrDefault(EndpointPair endpointPair, Object obj) {
            return a().edgeValueOrDefault(Graphs.transpose(endpointPair), obj);
        }

        @Override // com.google.common.graph.AbstractValueGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public boolean hasEdgeConnecting(EndpointPair endpointPair) {
            return a().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set predecessors(Object obj) {
            return a().successors(obj);
        }

        @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set successors(Object obj) {
            return a().predecessors(obj);
        }
    }

    private Graphs() {
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> graph, Object obj, Object obj2) {
        return graph.isDirected() || !Objects.equal(obj2, obj);
    }

    @CanIgnoreReturnValue
    public static int checkNonNegative(int i) {
        Preconditions.checkArgument(i >= 0, "Not true that %s is non-negative.", i);
        return i;
    }

    @CanIgnoreReturnValue
    public static int checkPositive(int i) {
        Preconditions.checkArgument(i > 0, "Not true that %s is positive.", i);
        return i;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> mutableGraph = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            mutableGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap mapNewHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        Iterator<N> it = graph.nodes().iterator();
        while (it.hasNext()) {
            if (subgraphHasCycle(graph, mapNewHashMapWithExpectedSize, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        C4365yR c4365yR = iterable instanceof Collection ? (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()).build() : (MutableGraph<N>) GraphBuilder.from(graph).build();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            c4365yR.addNode(it.next());
        }
        for (N n : c4365yR.nodes()) {
            for (N n2 : graph.successors((Object) n)) {
                if (c4365yR.nodes().contains(n2)) {
                    c4365yR.putEdge(n, n2);
                }
            }
        }
        return c4365yR;
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N n) {
        Preconditions.checkArgument(graph.nodes().contains(n), "Node %s is not an element of this graph.", n);
        return ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst(n));
    }

    private static <N> boolean subgraphHasCycle(Graph<N> graph, Map<Object, a> map, N n, N n2) {
        a aVar = map.get(n);
        if (aVar == a.COMPLETE) {
            return false;
        }
        a aVar2 = a.PENDING;
        if (aVar == aVar2) {
            return true;
        }
        map.put(n, aVar2);
        for (N n3 : graph.successors((Object) n)) {
            if (canTraverseWithoutReusingEdge(graph, n3, n2) && subgraphHasCycle(graph, map, n3, n)) {
                return true;
            }
        }
        map.put(n, a.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        C4365yR c4365yRBuild = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n : graph.nodes()) {
                Iterator it = reachableNodes(graph, n).iterator();
                while (it.hasNext()) {
                    c4365yRBuild.putEdge(n, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n2 : graph.nodes()) {
                if (!hashSet.contains(n2)) {
                    Set setReachableNodes = reachableNodes(graph, n2);
                    hashSet.addAll(setReachableNodes);
                    int i = 1;
                    for (Object obj : setReachableNodes) {
                        int i2 = i + 1;
                        Iterator it2 = Iterables.limit(setReachableNodes, i).iterator();
                        while (it2.hasNext()) {
                            c4365yRBuild.putEdge(obj, it2.next());
                        }
                        i = i2;
                    }
                }
            }
        }
        return c4365yRBuild;
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        if (graph.isDirected()) {
            return graph instanceof b ? ((b) graph).a : new b(graph);
        }
        return graph;
    }

    @CanIgnoreReturnValue
    public static long checkNonNegative(long j) {
        Preconditions.checkArgument(j >= 0, "Not true that %s is non-negative.", j);
        return j;
    }

    @CanIgnoreReturnValue
    public static long checkPositive(long j) {
        Preconditions.checkArgument(j > 0, "Not true that %s is positive.", j);
        return j;
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.isDirected()) {
            return valueGraph;
        }
        if (valueGraph instanceof d) {
            return ((d) valueGraph).a;
        }
        return new d(valueGraph);
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> mutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        Iterator<N> it = valueGraph.nodes().iterator();
        while (it.hasNext()) {
            mutableValueGraph.addNode(it.next());
        }
        for (EndpointPair<N> endpointPair : valueGraph.edges()) {
            N nNodeU = endpointPair.nodeU();
            N nNodeV = endpointPair.nodeV();
            V vEdgeValueOrDefault = valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            java.util.Objects.requireNonNull(vEdgeValueOrDefault);
            mutableValueGraph.putEdgeValue(nNodeU, nNodeV, vEdgeValueOrDefault);
        }
        return mutableValueGraph;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof c) {
            return ((c) network).a;
        }
        return new c(network);
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        com.google.common.graph.d dVar;
        if (iterable instanceof Collection) {
            dVar = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            dVar = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).build();
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            dVar.addNode(it.next());
        }
        for (N n : dVar.nodes()) {
            for (N n2 : valueGraph.successors((Object) n)) {
                if (dVar.nodes().contains(n2)) {
                    V vEdgeValueOrDefault = valueGraph.edgeValueOrDefault(n, n2, null);
                    java.util.Objects.requireNonNull(vEdgeValueOrDefault);
                    dVar.putEdgeValue(n, n2, vEdgeValueOrDefault);
                }
            }
        }
        return dVar;
    }

    public static <N> EndpointPair<N> transpose(EndpointPair<N> endpointPair) {
        return endpointPair.isOrdered() ? EndpointPair.ordered(endpointPair.target(), endpointPair.source()) : endpointPair;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> mutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        Iterator<N> it = network.nodes().iterator();
        while (it.hasNext()) {
            mutableNetwork.addNode(it.next());
        }
        for (E e : network.edges()) {
            EndpointPair<N> endpointPairIncidentNodes = network.incidentNodes(e);
            mutableNetwork.addEdge(endpointPairIncidentNodes.nodeU(), endpointPairIncidentNodes.nodeV(), e);
        }
        return mutableNetwork;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        com.google.common.graph.c cVar;
        if (iterable instanceof Collection) {
            cVar = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            cVar = (MutableNetwork<N, E>) NetworkBuilder.from(network).build();
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            cVar.addNode(it.next());
        }
        for (E e : cVar.nodes()) {
            for (E e2 : network.outEdges(e)) {
                N nAdjacentNode = network.incidentNodes(e2).adjacentNode(e);
                if (cVar.nodes().contains(nAdjacentNode)) {
                    cVar.addEdge(e, nAdjacentNode, e2);
                }
            }
        }
        return cVar;
    }
}
