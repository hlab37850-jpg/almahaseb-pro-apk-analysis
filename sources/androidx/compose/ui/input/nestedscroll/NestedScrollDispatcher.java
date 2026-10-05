package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    private InterfaceC3588op calculateNestedScrollScope = new NestedScrollDispatcher$calculateNestedScrollScope$1(this);
    private ModifierLocalModifierNode modifierLocalNode;
    private InterfaceC2052dg scope;

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    public final Object m3951dispatchPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        long jM5396getZero9UxMQ8M;
        if (interfaceC0793Of instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) interfaceC0793Of;
            int i = nestedScrollDispatcher$dispatchPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, interfaceC0793Of);
            }
        } else {
            nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, interfaceC0793Of);
        }
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$2 = nestedScrollDispatcher$dispatchPostFling$1;
        Object objMo340onPostFlingRZ2iAVY = nestedScrollDispatcher$dispatchPostFling$2.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = nestedScrollDispatcher$dispatchPostFling$2.label;
        if (i2 == 0) {
            LL.b(objMo340onPostFlingRZ2iAVY);
            NestedScrollConnection parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                nestedScrollDispatcher$dispatchPostFling$2.label = 1;
                objMo340onPostFlingRZ2iAVY = parent$ui_release.mo340onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$2);
                if (objMo340onPostFlingRZ2iAVY == objD) {
                    return objD;
                }
            } else {
                jM5396getZero9UxMQ8M = Velocity.Companion.m5396getZero9UxMQ8M();
            }
            return Velocity.m5376boximpl(jM5396getZero9UxMQ8M);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LL.b(objMo340onPostFlingRZ2iAVY);
        jM5396getZero9UxMQ8M = ((Velocity) objMo340onPostFlingRZ2iAVY).m5394unboximpl();
        return Velocity.m5376boximpl(jM5396getZero9UxMQ8M);
    }

    /* JADX INFO: renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m3952dispatchPostScrollDzOQY0M(long j, long j2, int i) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo341onPostScrollDzOQY0M(j, j2, i) : Offset.Companion.m2814getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    public final Object m3953dispatchPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long jM5396getZero9UxMQ8M;
        if (interfaceC0793Of instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) interfaceC0793Of;
            int i = nestedScrollDispatcher$dispatchPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, interfaceC0793Of);
            }
        } else {
            nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, interfaceC0793Of);
        }
        Object objMo342onPreFlingQWom1Mo = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i2 == 0) {
            LL.b(objMo342onPreFlingQWom1Mo);
            NestedScrollConnection parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                objMo342onPreFlingQWom1Mo = parent$ui_release.mo342onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
                if (objMo342onPreFlingQWom1Mo == objD) {
                    return objD;
                }
            } else {
                jM5396getZero9UxMQ8M = Velocity.Companion.m5396getZero9UxMQ8M();
            }
            return Velocity.m5376boximpl(jM5396getZero9UxMQ8M);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LL.b(objMo342onPreFlingQWom1Mo);
        jM5396getZero9UxMQ8M = ((Velocity) objMo342onPreFlingQWom1Mo).m5394unboximpl();
        return Velocity.m5376boximpl(jM5396getZero9UxMQ8M);
    }

    /* JADX INFO: renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m3954dispatchPreScrollOzD1aCk(long j, int i) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo343onPreScrollOzD1aCk(j, i) : Offset.Companion.m2814getZeroF1C5BW0();
    }

    public final InterfaceC3588op getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    public final InterfaceC2052dg getCoroutineScope() {
        InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.calculateNestedScrollScope.invoke();
        if (interfaceC2052dg != null) {
            return interfaceC2052dg;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final ModifierLocalModifierNode getModifierLocalNode$ui_release() {
        return this.modifierLocalNode;
    }

    public final NestedScrollConnection getParent$ui_release() {
        ModifierLocalModifierNode modifierLocalModifierNode = this.modifierLocalNode;
        if (modifierLocalModifierNode != null) {
            return (NestedScrollNode) modifierLocalModifierNode.getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    public final InterfaceC2052dg getScope$ui_release() {
        return this.scope;
    }

    public final void setCalculateNestedScrollScope$ui_release(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "<set-?>");
        this.calculateNestedScrollScope = interfaceC3588op;
    }

    public final void setModifierLocalNode$ui_release(ModifierLocalModifierNode modifierLocalModifierNode) {
        this.modifierLocalNode = modifierLocalModifierNode;
    }

    public final void setScope$ui_release(InterfaceC2052dg interfaceC2052dg) {
        this.scope = interfaceC2052dg;
    }
}
