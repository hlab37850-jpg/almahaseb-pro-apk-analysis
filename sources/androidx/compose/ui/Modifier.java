package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC3347lu;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.YB;
import defpackage.ZB;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface Modifier {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // androidx.compose.ui.Modifier
        public boolean all(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return true;
        }

        @Override // androidx.compose.ui.Modifier
        public boolean any(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return false;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldIn(R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return r;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldOut(R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return r;
        }

        @Override // androidx.compose.ui.Modifier
        public Modifier then(Modifier modifier) {
            AbstractC4492zt.h(modifier, "other");
            return modifier;
        }

        public String toString() {
            return "Modifier";
        }
    }

    public static final class DefaultImpls {
        @Deprecated
        public static Modifier then(Modifier modifier, Modifier modifier2) {
            AbstractC4492zt.h(modifier2, "other");
            return YB.a(modifier, modifier2);
        }
    }

    public interface Element extends Modifier {

        public static final class DefaultImpls {
            @Deprecated
            public static boolean all(Element element, InterfaceC3750qp interfaceC3750qp) {
                AbstractC4492zt.h(interfaceC3750qp, "predicate");
                return ZB.a(element, interfaceC3750qp);
            }

            @Deprecated
            public static boolean any(Element element, InterfaceC3750qp interfaceC3750qp) {
                AbstractC4492zt.h(interfaceC3750qp, "predicate");
                return ZB.b(element, interfaceC3750qp);
            }

            @Deprecated
            public static <R> R foldIn(Element element, R r, InterfaceC0526Fp interfaceC0526Fp) {
                AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
                return (R) ZB.c(element, r, interfaceC0526Fp);
            }

            @Deprecated
            public static <R> R foldOut(Element element, R r, InterfaceC0526Fp interfaceC0526Fp) {
                AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
                return (R) ZB.d(element, r, interfaceC0526Fp);
            }

            @Deprecated
            public static Modifier then(Element element, Modifier modifier) {
                AbstractC4492zt.h(modifier, "other");
                return YB.a(element, modifier);
            }
        }

        @Override // androidx.compose.ui.Modifier
        boolean all(InterfaceC3750qp interfaceC3750qp);

        @Override // androidx.compose.ui.Modifier
        boolean any(InterfaceC3750qp interfaceC3750qp);

        @Override // androidx.compose.ui.Modifier
        <R> R foldIn(R r, InterfaceC0526Fp interfaceC0526Fp);

        @Override // androidx.compose.ui.Modifier
        <R> R foldOut(R r, InterfaceC0526Fp interfaceC0526Fp);
    }

    @StabilityInferred(parameters = 0)
    public static abstract class Node implements DelegatableNode {
        public static final int $stable = 8;
        private Node child;
        private NodeCoordinator coordinator;
        private boolean insertedNodeAwaitingAttachForInvalidation;
        private boolean isAttached;
        private int kindSet;
        private boolean onAttachRunExpected;
        private boolean onDetachRunExpected;
        private ObserverNodeOwnerScope ownerScope;
        private Node parent;
        private InterfaceC2052dg scope;
        private boolean updatedNodeAwaitingAttachForInvalidation;
        private Node node = this;
        private int aggregateChildKindSet = -1;

        public static /* synthetic */ void getNode$annotations() {
        }

        public static /* synthetic */ void getShouldAutoInvalidate$annotations() {
        }

        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        public final Node getChild$ui_release() {
            return this.child;
        }

        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final InterfaceC2052dg getCoroutineScope() {
            InterfaceC2052dg interfaceC2052dg = this.scope;
            if (interfaceC2052dg != null) {
                return interfaceC2052dg;
            }
            InterfaceC2052dg interfaceC2052dgA = AbstractC2133eg.a(DelegatableNodeKt.requireOwner(this).getCoroutineContext().plus(AbstractC3347lu.a((InterfaceC1830bu) DelegatableNodeKt.requireOwner(this).getCoroutineContext().get(InterfaceC1830bu.s))));
            this.scope = interfaceC2052dgA;
            return interfaceC2052dgA;
        }

        public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.insertedNodeAwaitingAttachForInvalidation;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final Node getNode() {
            return this.node;
        }

        public final ObserverNodeOwnerScope getOwnerScope$ui_release() {
            return this.ownerScope;
        }

        public final Node getParent$ui_release() {
            return this.parent;
        }

        public boolean getShouldAutoInvalidate() {
            return true;
        }

        public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.updatedNodeAwaitingAttachForInvalidation;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        /* JADX INFO: renamed from: isKind-H91voCI$ui_release, reason: not valid java name */
        public final boolean m2685isKindH91voCI$ui_release(int i) {
            return (i & getKindSet$ui_release()) != 0;
        }

        public void markAsAttached$ui_release() {
            if (this.isAttached) {
                throw new IllegalStateException("node attached multiple times");
            }
            if (this.coordinator == null) {
                throw new IllegalStateException("attach invoked on a node without a coordinator");
            }
            this.isAttached = true;
            this.onAttachRunExpected = true;
        }

        public void markAsDetached$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Cannot detach a node that is not attached");
            }
            if (this.onAttachRunExpected) {
                throw new IllegalStateException("Must run runAttachLifecycle() before markAsDetached()");
            }
            if (this.onDetachRunExpected) {
                throw new IllegalStateException("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.isAttached = false;
            InterfaceC2052dg interfaceC2052dg = this.scope;
            if (interfaceC2052dg != null) {
                AbstractC2133eg.c(interfaceC2052dg, new ModifierNodeDetachedCancellationException());
                this.scope = null;
            }
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public void onReset() {
        }

        public void reset$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Check failed.");
            }
            onReset();
        }

        public void runAttachLifecycle$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("Must run markAsAttached() prior to runAttachLifecycle");
            }
            if (!this.onAttachRunExpected) {
                throw new IllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.onAttachRunExpected = false;
            onAttach();
            this.onDetachRunExpected = true;
        }

        public void runDetachLifecycle$ui_release() {
            if (!this.isAttached) {
                throw new IllegalStateException("node detached multiple times");
            }
            if (this.coordinator == null) {
                throw new IllegalStateException("detach invoked on a node without a coordinator");
            }
            if (!this.onDetachRunExpected) {
                throw new IllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.onDetachRunExpected = false;
            onDetach();
        }

        public final void setAggregateChildKindSet$ui_release(int i) {
            this.aggregateChildKindSet = i;
        }

        public final void setAsDelegateTo$ui_release(Node node) {
            AbstractC4492zt.h(node, "owner");
            this.node = node;
        }

        public final void setChild$ui_release(Node node) {
            this.child = node;
        }

        public final void setInsertedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
            this.insertedNodeAwaitingAttachForInvalidation = z;
        }

        public final void setKindSet$ui_release(int i) {
            this.kindSet = i;
        }

        public final void setOwnerScope$ui_release(ObserverNodeOwnerScope observerNodeOwnerScope) {
            this.ownerScope = observerNodeOwnerScope;
        }

        public final void setParent$ui_release(Node node) {
            this.parent = node;
        }

        public final void setUpdatedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
            this.updatedNodeAwaitingAttachForInvalidation = z;
        }

        @ExperimentalComposeUiApi
        public final void sideEffect(InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(interfaceC3588op, "effect");
            DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(interfaceC3588op);
        }

        public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }
    }

    boolean all(InterfaceC3750qp interfaceC3750qp);

    boolean any(InterfaceC3750qp interfaceC3750qp);

    <R> R foldIn(R r, InterfaceC0526Fp interfaceC0526Fp);

    <R> R foldOut(R r, InterfaceC0526Fp interfaceC0526Fp);

    Modifier then(Modifier modifier);
}
