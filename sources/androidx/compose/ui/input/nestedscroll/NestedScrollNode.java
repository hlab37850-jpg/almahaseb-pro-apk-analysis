package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1777bC;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.HV;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements ModifierLocalModifierNode, NestedScrollConnection, DelegatableNode {
    private NestedScrollConnection connection;
    private final ModifierLocalMap providedValues;
    private NestedScrollDispatcher resolvedDispatcher;

    /* JADX INFO: renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final InterfaceC2052dg invoke() {
            return NestedScrollNode.this.getNestedCoroutineScope();
        }
    }

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        AbstractC4492zt.h(nestedScrollConnection, "connection");
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(HV.a(NestedScrollNodeKt.getModifierLocalNestedScroll(), this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC2052dg getNestedCoroutineScope() {
        InterfaceC2052dg scope$ui_release;
        NestedScrollNode parentModifierLocal = getParentModifierLocal();
        if ((parentModifierLocal == null || (scope$ui_release = parentModifierLocal.getNestedCoroutineScope()) == null) && (scope$ui_release = this.resolvedDispatcher.getScope$ui_release()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return scope$ui_release;
    }

    private final NestedScrollConnection getParentConnection() {
        if (isAttached()) {
            return (NestedScrollConnection) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    private final NestedScrollNode getParentModifierLocal() {
        if (isAttached()) {
            return (NestedScrollNode) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getModifierLocalNode$ui_release() == this) {
            this.resolvedDispatcher.setModifierLocalNode$ui_release(null);
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher nestedScrollDispatcher) {
        resetDispatcherFields();
        if (nestedScrollDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!AbstractC4492zt.d(nestedScrollDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = nestedScrollDispatcher;
        }
        if (isAttached()) {
            updateDispatcherFields();
        }
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setModifierLocalNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new AnonymousClass1());
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return AbstractC1777bC.a(this, modifierLocal);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetDispatcherFields();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        long j3;
        long j4;
        NestedScrollNode nestedScrollNode;
        long j5;
        long jM5396getZero9UxMQ8M;
        long j6;
        if (interfaceC0793Of instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) interfaceC0793Of;
            int i = nestedScrollNode$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, interfaceC0793Of);
            }
        } else {
            nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, interfaceC0793Of);
        }
        Object objMo340onPostFlingRZ2iAVY = nestedScrollNode$onPostFling$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = nestedScrollNode$onPostFling$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                long j7 = nestedScrollNode$onPostFling$1.J$1;
                long j8 = nestedScrollNode$onPostFling$1.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$1.L$0;
                LL.b(objMo340onPostFlingRZ2iAVY);
                j4 = j7;
                j3 = j8;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j6 = nestedScrollNode$onPostFling$1.J$0;
                LL.b(objMo340onPostFlingRZ2iAVY);
            }
            jM5396getZero9UxMQ8M = ((Velocity) objMo340onPostFlingRZ2iAVY).m5394unboximpl();
            j5 = j6;
            return Velocity.m5376boximpl(Velocity.m5389plusAH228Gc(j5, jM5396getZero9UxMQ8M));
        }
        LL.b(objMo340onPostFlingRZ2iAVY);
        NestedScrollConnection nestedScrollConnection = this.connection;
        nestedScrollNode$onPostFling$1.L$0 = this;
        j3 = j;
        nestedScrollNode$onPostFling$1.J$0 = j3;
        j4 = j2;
        nestedScrollNode$onPostFling$1.J$1 = j4;
        nestedScrollNode$onPostFling$1.label = 1;
        objMo340onPostFlingRZ2iAVY = nestedScrollConnection.mo340onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$1);
        if (objMo340onPostFlingRZ2iAVY == objD) {
            return objD;
        }
        nestedScrollNode = this;
        long jM5394unboximpl = ((Velocity) objMo340onPostFlingRZ2iAVY).m5394unboximpl();
        NestedScrollConnection parentConnection = nestedScrollNode.getParentConnection();
        if (parentConnection != null) {
            long jM5389plusAH228Gc = Velocity.m5389plusAH228Gc(j3, jM5394unboximpl);
            long jM5388minusAH228Gc = Velocity.m5388minusAH228Gc(j4, jM5394unboximpl);
            nestedScrollNode$onPostFling$1.L$0 = null;
            nestedScrollNode$onPostFling$1.J$0 = jM5394unboximpl;
            nestedScrollNode$onPostFling$1.label = 2;
            objMo340onPostFlingRZ2iAVY = parentConnection.mo340onPostFlingRZ2iAVY(jM5389plusAH228Gc, jM5388minusAH228Gc, nestedScrollNode$onPostFling$1);
            if (objMo340onPostFlingRZ2iAVY == objD) {
                return objD;
            }
            j6 = jM5394unboximpl;
            jM5396getZero9UxMQ8M = ((Velocity) objMo340onPostFlingRZ2iAVY).m5394unboximpl();
            j5 = j6;
        } else {
            j5 = jM5394unboximpl;
            jM5396getZero9UxMQ8M = Velocity.Companion.m5396getZero9UxMQ8M();
        }
        return Velocity.m5376boximpl(Velocity.m5389plusAH228Gc(j5, jM5396getZero9UxMQ8M));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
        long jMo341onPostScrollDzOQY0M = this.connection.mo341onPostScrollDzOQY0M(j, j2, i);
        NestedScrollConnection parentConnection = getParentConnection();
        return Offset.m2803plusMKHz9U(jMo341onPostScrollDzOQY0M, parentConnection != null ? parentConnection.mo341onPostScrollDzOQY0M(Offset.m2803plusMKHz9U(j, jMo341onPostScrollDzOQY0M), Offset.m2802minusMKHz9U(j2, jMo341onPostScrollDzOQY0M), i) : Offset.Companion.m2814getZeroF1C5BW0());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        long jM5396getZero9UxMQ8M;
        NestedScrollNode nestedScrollNode;
        long j2;
        if (interfaceC0793Of instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) interfaceC0793Of;
            int i = nestedScrollNode$onPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, interfaceC0793Of);
            }
        } else {
            nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, interfaceC0793Of);
        }
        Object objMo342onPreFlingQWom1Mo = nestedScrollNode$onPreFling$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = nestedScrollNode$onPreFling$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                j = nestedScrollNode$onPreFling$1.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPreFling$1.L$0;
                LL.b(objMo342onPreFlingQWom1Mo);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = nestedScrollNode$onPreFling$1.J$0;
                LL.b(objMo342onPreFlingQWom1Mo);
            }
            return Velocity.m5376boximpl(Velocity.m5389plusAH228Gc(j2, ((Velocity) objMo342onPreFlingQWom1Mo).m5394unboximpl()));
        }
        LL.b(objMo342onPreFlingQWom1Mo);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            nestedScrollNode$onPreFling$1.L$0 = this;
            nestedScrollNode$onPreFling$1.J$0 = j;
            nestedScrollNode$onPreFling$1.label = 1;
            objMo342onPreFlingQWom1Mo = parentConnection.mo342onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
            if (objMo342onPreFlingQWom1Mo == objD) {
                return objD;
            }
            nestedScrollNode = this;
        } else {
            jM5396getZero9UxMQ8M = Velocity.Companion.m5396getZero9UxMQ8M();
            nestedScrollNode = this;
        }
        long j3 = j;
        j2 = jM5396getZero9UxMQ8M;
        NestedScrollConnection nestedScrollConnection = nestedScrollNode.connection;
        long jM5388minusAH228Gc = Velocity.m5388minusAH228Gc(j3, j2);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = j2;
        nestedScrollNode$onPreFling$1.label = 2;
        objMo342onPreFlingQWom1Mo = nestedScrollConnection.mo342onPreFlingQWom1Mo(jM5388minusAH228Gc, nestedScrollNode$onPreFling$1);
        if (objMo342onPreFlingQWom1Mo == objD) {
            return objD;
        }
        return Velocity.m5376boximpl(Velocity.m5389plusAH228Gc(j2, ((Velocity) objMo342onPreFlingQWom1Mo).m5394unboximpl()));
        jM5396getZero9UxMQ8M = ((Velocity) objMo342onPreFlingQWom1Mo).m5394unboximpl();
        long j4 = j;
        j2 = jM5396getZero9UxMQ8M;
        NestedScrollConnection nestedScrollConnection2 = nestedScrollNode.connection;
        long jM5388minusAH228Gc2 = Velocity.m5388minusAH228Gc(j4, j2);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = j2;
        nestedScrollNode$onPreFling$1.label = 2;
        objMo342onPreFlingQWom1Mo = nestedScrollConnection2.mo342onPreFlingQWom1Mo(jM5388minusAH228Gc2, nestedScrollNode$onPreFling$1);
        if (objMo342onPreFlingQWom1Mo == objD) {
            return objD;
        }
        return Velocity.m5376boximpl(Velocity.m5389plusAH228Gc(j2, ((Velocity) objMo342onPreFlingQWom1Mo).m5394unboximpl()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo343onPreScrollOzD1aCk(long j, int i) {
        NestedScrollConnection parentConnection = getParentConnection();
        long jMo343onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo343onPreScrollOzD1aCk(j, i) : Offset.Companion.m2814getZeroF1C5BW0();
        return Offset.m2803plusMKHz9U(jMo343onPreScrollOzD1aCk, this.connection.mo343onPreScrollOzD1aCk(Offset.m2802minusMKHz9U(j, jMo343onPreScrollOzD1aCk), i));
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        AbstractC1777bC.c(this, modifierLocal, obj);
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        AbstractC4492zt.h(nestedScrollConnection, "<set-?>");
        this.connection = nestedScrollConnection;
    }

    public final void updateNode$ui_release(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        AbstractC4492zt.h(nestedScrollConnection, "connection");
        this.connection = nestedScrollConnection;
        updateDispatcher(nestedScrollDispatcher);
    }
}
