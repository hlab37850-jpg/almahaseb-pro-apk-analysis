package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class PagerStateImpl extends PagerState {
    public static final Companion Companion = new Companion(null);
    private static final Saver<PagerStateImpl, ?> Saver = ListSaverKt.listSaver(PagerStateImpl$Companion$Saver$1.INSTANCE, PagerStateImpl$Companion$Saver$2.INSTANCE);
    private MutableState<InterfaceC3588op> pageCountState;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<PagerStateImpl, ?> getSaver() {
            return PagerStateImpl.Saver;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerStateImpl(int i, float f, InterfaceC3588op interfaceC3588op) {
        super(i, f);
        AbstractC4492zt.h(interfaceC3588op, "updatedPageCount");
        this.pageCountState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(interfaceC3588op, null, 2, null);
    }

    @Override // androidx.compose.foundation.pager.PagerState
    public int getPageCount() {
        return ((Number) this.pageCountState.getValue().invoke()).intValue();
    }

    public final MutableState<InterfaceC3588op> getPageCountState() {
        return this.pageCountState;
    }

    public final void setPageCountState(MutableState<InterfaceC3588op> mutableState) {
        AbstractC4492zt.h(mutableState, "<set-?>");
        this.pageCountState = mutableState;
    }
}
