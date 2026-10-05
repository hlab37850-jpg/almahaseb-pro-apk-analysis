package androidx.paging;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC3588op;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingData<T> {
    private final InterfaceC3588op cachedPageEvent;
    private final InterfaceC0939Tm flow;
    private final HintReceiver hintReceiver;
    private final UiReceiver uiReceiver;
    public static final Companion Companion = new Companion(null);
    private static final UiReceiver NOOP_UI_RECEIVER = new UiReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_UI_RECEIVER$1
        @Override // androidx.paging.UiReceiver
        public void refresh() {
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
        }
    };
    private static final HintReceiver NOOP_HINT_RECEIVER = new HintReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_HINT_RECEIVER$1
        @Override // androidx.paging.HintReceiver
        public void accessHint(ViewportHint viewportHint) {
            AbstractC4492zt.h(viewportHint, "viewportHint");
        }
    };

    /* JADX INFO: renamed from: androidx.paging.PagingData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final Void invoke() {
            return null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ PagingData empty$default(Companion companion, LoadStates loadStates, LoadStates loadStates2, int i, Object obj) {
            if ((i & 2) != 0) {
                loadStates2 = null;
            }
            return companion.empty(loadStates, loadStates2);
        }

        public static /* synthetic */ PagingData from$default(Companion companion, List list, LoadStates loadStates, LoadStates loadStates2, int i, Object obj) {
            if ((i & 4) != 0) {
                loadStates2 = null;
            }
            return companion.from(list, loadStates, loadStates2);
        }

        public final <T> PagingData<T> empty(LoadStates loadStates) {
            AbstractC4492zt.h(loadStates, "sourceLoadStates");
            return empty$default(this, loadStates, null, 2, null);
        }

        public final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates) {
            AbstractC4492zt.h(list, "data");
            AbstractC4492zt.h(loadStates, "sourceLoadStates");
            return from$default(this, list, loadStates, null, 4, null);
        }

        public final HintReceiver getNOOP_HINT_RECEIVER$paging_common() {
            return PagingData.NOOP_HINT_RECEIVER;
        }

        public final UiReceiver getNOOP_UI_RECEIVER$paging_common() {
            return PagingData.NOOP_UI_RECEIVER;
        }

        private Companion() {
        }

        public final <T> PagingData<T> empty() {
            return new PagingData<>(AbstractC1047Xm.t(new PageEvent.StaticList(AbstractC1886cc.m(), null, null)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), null, 8, null);
        }

        public final <T> PagingData<T> from(List<? extends T> list) {
            AbstractC4492zt.h(list, "data");
            return new PagingData<>(AbstractC1047Xm.t(new PageEvent.StaticList(list, null, null)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), new PagingData$Companion$from$1(list));
        }

        public final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates, LoadStates loadStates2) {
            AbstractC4492zt.h(list, "data");
            AbstractC4492zt.h(loadStates, "sourceLoadStates");
            return new PagingData<>(AbstractC1047Xm.t(new PageEvent.StaticList(list, loadStates, loadStates2)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), new PagingData$Companion$from$2(list, loadStates, loadStates2));
        }

        public final <T> PagingData<T> empty(LoadStates loadStates, LoadStates loadStates2) {
            AbstractC4492zt.h(loadStates, "sourceLoadStates");
            return new PagingData<>(AbstractC1047Xm.t(new PageEvent.StaticList(AbstractC1886cc.m(), loadStates, loadStates2)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), null, 8, null);
        }
    }

    public PagingData(InterfaceC0939Tm interfaceC0939Tm, UiReceiver uiReceiver, HintReceiver hintReceiver, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC0939Tm, "flow");
        AbstractC4492zt.h(uiReceiver, "uiReceiver");
        AbstractC4492zt.h(hintReceiver, "hintReceiver");
        AbstractC4492zt.h(interfaceC3588op, "cachedPageEvent");
        this.flow = interfaceC0939Tm;
        this.uiReceiver = uiReceiver;
        this.hintReceiver = hintReceiver;
        this.cachedPageEvent = interfaceC3588op;
    }

    public static final <T> PagingData<T> empty() {
        return Companion.empty();
    }

    public static final <T> PagingData<T> from(List<? extends T> list) {
        return Companion.from(list);
    }

    public final PageEvent.Insert<T> cachedEvent$paging_common() {
        return (PageEvent.Insert) this.cachedPageEvent.invoke();
    }

    public final InterfaceC0939Tm getFlow$paging_common() {
        return this.flow;
    }

    public final HintReceiver getHintReceiver$paging_common() {
        return this.hintReceiver;
    }

    public final UiReceiver getUiReceiver$paging_common() {
        return this.uiReceiver;
    }

    public static final <T> PagingData<T> empty(LoadStates loadStates) {
        return Companion.empty(loadStates);
    }

    public static final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates) {
        return Companion.from(list, loadStates);
    }

    public static final <T> PagingData<T> empty(LoadStates loadStates, LoadStates loadStates2) {
        return Companion.empty(loadStates, loadStates2);
    }

    public static final <T> PagingData<T> from(List<? extends T> list, LoadStates loadStates, LoadStates loadStates2) {
        return Companion.from(list, loadStates, loadStates2);
    }

    public /* synthetic */ PagingData(InterfaceC0939Tm interfaceC0939Tm, UiReceiver uiReceiver, HintReceiver hintReceiver, InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this(interfaceC0939Tm, uiReceiver, hintReceiver, (i & 8) != 0 ? AnonymousClass1.INSTANCE : interfaceC3588op);
    }
}
