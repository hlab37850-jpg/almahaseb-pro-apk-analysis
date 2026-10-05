package androidx.compose.material.pullrefresh;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2262gD;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
final class PullRefreshNestedScrollConnection implements NestedScrollConnection {
    private final boolean enabled;
    private final InterfaceC3750qp onPull;
    private final InterfaceC0526Fp onRelease;

    public PullRefreshNestedScrollConnection(InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, boolean z) {
        AbstractC4492zt.h(interfaceC3750qp, "onPull");
        AbstractC4492zt.h(interfaceC0526Fp, "onRelease");
        this.onPull = interfaceC3750qp;
        this.onRelease = interfaceC0526Fp;
        this.enabled = z;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public /* synthetic */ Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) {
        return AbstractC2262gD.a(this, j, j2, interfaceC0793Of);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.enabled) {
            return (!NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3963getDragWNlRxjI()) || Offset.m2799getYimpl(j2) <= 0.0f) ? Offset.Companion.m2814getZeroF1C5BW0() : OffsetKt.Offset(0.0f, ((Number) this.onPull.invoke(Float.valueOf(Offset.m2799getYimpl(j2)))).floatValue());
        }
        return Offset.Companion.m2814getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        PullRefreshNestedScrollConnection$onPreFling$1 pullRefreshNestedScrollConnection$onPreFling$1;
        float f;
        if (interfaceC0793Of instanceof PullRefreshNestedScrollConnection$onPreFling$1) {
            pullRefreshNestedScrollConnection$onPreFling$1 = (PullRefreshNestedScrollConnection$onPreFling$1) interfaceC0793Of;
            int i = pullRefreshNestedScrollConnection$onPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                pullRefreshNestedScrollConnection$onPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                pullRefreshNestedScrollConnection$onPreFling$1 = new PullRefreshNestedScrollConnection$onPreFling$1(this, interfaceC0793Of);
            }
        } else {
            pullRefreshNestedScrollConnection$onPreFling$1 = new PullRefreshNestedScrollConnection$onPreFling$1(this, interfaceC0793Of);
        }
        Object objMo13invoke = pullRefreshNestedScrollConnection$onPreFling$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = pullRefreshNestedScrollConnection$onPreFling$1.label;
        if (i2 == 0) {
            LL.b(objMo13invoke);
            InterfaceC0526Fp interfaceC0526Fp = this.onRelease;
            Float fB = E8.b(Velocity.m5386getYimpl(j));
            pullRefreshNestedScrollConnection$onPreFling$1.F$0 = 0.0f;
            pullRefreshNestedScrollConnection$onPreFling$1.label = 1;
            objMo13invoke = interfaceC0526Fp.mo13invoke(fB, pullRefreshNestedScrollConnection$onPreFling$1);
            if (objMo13invoke == objD) {
                return objD;
            }
            f = 0.0f;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f = pullRefreshNestedScrollConnection$onPreFling$1.F$0;
            LL.b(objMo13invoke);
        }
        return Velocity.m5376boximpl(VelocityKt.Velocity(f, ((Number) objMo13invoke).floatValue()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo343onPreScrollOzD1aCk(long j, int i) {
        if (this.enabled) {
            return (!NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3963getDragWNlRxjI()) || Offset.m2799getYimpl(j) >= 0.0f) ? Offset.Companion.m2814getZeroF1C5BW0() : OffsetKt.Offset(0.0f, ((Number) this.onPull.invoke(Float.valueOf(Offset.m2799getYimpl(j)))).floatValue());
        }
        return Offset.Companion.m2814getZeroF1C5BW0();
    }
}
