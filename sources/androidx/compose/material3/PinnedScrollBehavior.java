package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2262gD;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final class PinnedScrollBehavior implements TopAppBarScrollBehavior {
    private final InterfaceC3588op canScroll;
    private final DecayAnimationSpec<Float> flingAnimationSpec;
    private final boolean isPinned;
    private NestedScrollConnection nestedScrollConnection;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final TopAppBarState state;

    /* JADX INFO: renamed from: androidx.compose.material3.PinnedScrollBehavior$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public PinnedScrollBehavior(TopAppBarState topAppBarState, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(topAppBarState, "state");
        AbstractC4492zt.h(interfaceC3588op, "canScroll");
        this.state = topAppBarState;
        this.canScroll = interfaceC3588op;
        this.isPinned = true;
        this.nestedScrollConnection = new NestedScrollConnection() { // from class: androidx.compose.material3.PinnedScrollBehavior$nestedScrollConnection$1
            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
            public /* synthetic */ Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) {
                return AbstractC2262gD.a(this, j, j2, interfaceC0793Of);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
            public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
                if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue()) {
                    return Offset.Companion.m2814getZeroF1C5BW0();
                }
                if (Offset.m2799getYimpl(j) != 0.0f || Offset.m2799getYimpl(j2) <= 0.0f) {
                    TopAppBarState state = this.this$0.getState();
                    state.setContentOffset(state.getContentOffset() + Offset.m2799getYimpl(j));
                } else {
                    this.this$0.getState().setContentOffset(0.0f);
                }
                return Offset.Companion.m2814getZeroF1C5BW0();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreFling-QWom1Mo */
            public /* synthetic */ Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
                return AbstractC2262gD.c(this, j, interfaceC0793Of);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
            public /* synthetic */ long mo343onPreScrollOzD1aCk(long j, int i) {
                return AbstractC2262gD.d(this, j, i);
            }
        };
    }

    public final InterfaceC3588op getCanScroll() {
        return this.canScroll;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public DecayAnimationSpec<Float> getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public TopAppBarState getState() {
        return this.state;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public boolean isPinned() {
        return this.isPinned;
    }

    public void setNestedScrollConnection(NestedScrollConnection nestedScrollConnection) {
        AbstractC4492zt.h(nestedScrollConnection, "<set-?>");
        this.nestedScrollConnection = nestedScrollConnection;
    }

    public /* synthetic */ PinnedScrollBehavior(TopAppBarState topAppBarState, InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this(topAppBarState, (i & 2) != 0 ? AnonymousClass1.INSTANCE : interfaceC3588op);
    }
}
