package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import defpackage.C3838rx;
import defpackage.C3919sx;
import defpackage.InterfaceC3459nD;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends AbstractNetwork {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<Object> edgeOrder;
    final C3838rx edgeToReferenceNode;
    private final boolean isDirected;
    final C3838rx nodeConnections;
    private final ElementOrder<Object> nodeOrder;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public e(NetworkBuilder networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(networkBuilder.expectedNodeCount.or(10).intValue()), networkBuilder.edgeOrder.createMap(networkBuilder.expectedEdgeCount.or(20).intValue()));
    }

    @Override // com.google.common.graph.Network
    public Set adjacentNodes(Object obj) {
        return checkedConnections(obj).a();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final InterfaceC3459nD checkedConnections(Object obj) {
        InterfaceC3459nD interfaceC3459nD = (InterfaceC3459nD) this.nodeConnections.e(obj);
        if (interfaceC3459nD != null) {
            return interfaceC3459nD;
        }
        Preconditions.checkNotNull(obj);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", obj));
    }

    public final Object checkedReferenceNode(Object obj) {
        Object objE = this.edgeToReferenceNode.e(obj);
        if (objE != null) {
            return objE;
        }
        Preconditions.checkNotNull(obj);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", obj));
    }

    public final boolean containsEdge(Object obj) {
        return this.edgeToReferenceNode.d(obj);
    }

    public final boolean containsNode(Object obj) {
        return this.nodeConnections.d(obj);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set edges() {
        return this.edgeToReferenceNode.j();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set edgesConnecting(Object obj, Object obj2) {
        InterfaceC3459nD interfaceC3459nDCheckedConnections = checkedConnections(obj);
        if (!this.allowsSelfLoops && obj == obj2) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(obj2), "Node %s is not an element of this graph.", obj2);
        return interfaceC3459nDCheckedConnections.k(obj2);
    }

    @Override // com.google.common.graph.Network
    public Set inEdges(Object obj) {
        return checkedConnections(obj).g();
    }

    @Override // com.google.common.graph.Network
    public Set incidentEdges(Object obj) {
        return checkedConnections(obj).e();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair incidentNodes(Object obj) {
        Object objCheckedReferenceNode = checkedReferenceNode(obj);
        InterfaceC3459nD interfaceC3459nD = (InterfaceC3459nD) this.nodeConnections.e(objCheckedReferenceNode);
        Objects.requireNonNull(interfaceC3459nD);
        return EndpointPair.of(this, objCheckedReferenceNode, interfaceC3459nD.f(obj));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set nodes() {
        return this.nodeConnections.j();
    }

    @Override // com.google.common.graph.Network
    public Set outEdges(Object obj) {
        return checkedConnections(obj).i();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return checkedConnections(obj).c();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return checkedConnections(obj).b();
    }

    public e(NetworkBuilder networkBuilder, Map map, Map map2) {
        C3838rx c3838rx;
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = networkBuilder.nodeOrder.cast();
        this.edgeOrder = networkBuilder.edgeOrder.cast();
        if (map instanceof TreeMap) {
            c3838rx = new C3919sx(map);
        } else {
            c3838rx = new C3838rx(map);
        }
        this.nodeConnections = c3838rx;
        this.edgeToReferenceNode = new C3838rx(map2);
    }
}
