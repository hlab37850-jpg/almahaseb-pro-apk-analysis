package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import defpackage.AbstractC4084v;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public abstract class AbstractValueGraph<N, V> extends AbstractC4084v implements ValueGraph<N, V> {

    public class a extends AbstractGraph {
        public a() {
        }

        @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public Set adjacentNodes(Object obj) {
            return AbstractValueGraph.this.adjacentNodes(obj);
        }

        @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return AbstractValueGraph.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public int degree(Object obj) {
            return AbstractValueGraph.this.degree(obj);
        }

        @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public Set edges() {
            return AbstractValueGraph.this.edges();
        }

        @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public int inDegree(Object obj) {
            return AbstractValueGraph.this.inDegree(obj);
        }

        @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public ElementOrder incidentEdgeOrder() {
            return AbstractValueGraph.this.incidentEdgeOrder();
        }

        @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public boolean isDirected() {
            return AbstractValueGraph.this.isDirected();
        }

        @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public ElementOrder nodeOrder() {
            return AbstractValueGraph.this.nodeOrder();
        }

        @Override // defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public Set nodes() {
            return AbstractValueGraph.this.nodes();
        }

        @Override // com.google.common.graph.AbstractGraph, defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
        public int outDegree(Object obj) {
            return AbstractValueGraph.this.outDegree(obj);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set predecessors(Object obj) {
            return AbstractValueGraph.this.predecessors(obj);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set successors(Object obj) {
            return AbstractValueGraph.this.successors(obj);
        }
    }

    public class b implements Function {
        public final /* synthetic */ ValueGraph a;

        public b(ValueGraph valueGraph) {
            this.a = valueGraph;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(EndpointPair endpointPair) {
            Object objEdgeValueOrDefault = this.a.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            Objects.requireNonNull(objEdgeValueOrDefault);
            return objEdgeValueOrDefault;
        }
    }

    private static <N, V> Map<EndpointPair<N>, V> edgeValueMap(ValueGraph<N, V> valueGraph) {
        return Maps.asMap(valueGraph.edges(), new b(valueGraph));
    }

    @Override // com.google.common.graph.ValueGraph
    public Graph<N> asGraph() {
        return new a();
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    @Override // com.google.common.graph.ValueGraph
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        return isDirected() == valueGraph.isDirected() && nodes().equals(valueGraph.nodes()) && edgeValueMap(this).equals(edgeValueMap(valueGraph));
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.ValueGraph
    public final int hashCode() {
        return edgeValueMap(this).hashCode();
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ ElementOrder incidentEdgeOrder() {
        return super.incidentEdgeOrder();
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors(obj);
    }

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors(obj);
    }

    public String toString() {
        boolean zIsDirected = isDirected();
        boolean zAllowsSelfLoops = allowsSelfLoops();
        String strValueOf = String.valueOf(nodes());
        String strValueOf2 = String.valueOf(edgeValueMap(this));
        StringBuilder sb = new StringBuilder(strValueOf.length() + 59 + strValueOf2.length());
        sb.append("isDirected: ");
        sb.append(zIsDirected);
        sb.append(", allowsSelfLoops: ");
        sb.append(zAllowsSelfLoops);
        sb.append(", nodes: ");
        sb.append(strValueOf);
        sb.append(", edges: ");
        sb.append(strValueOf2);
        return sb.toString();
    }

    @Override // defpackage.AbstractC4084v, defpackage.InterfaceC2417i7, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }
}
