package androidx.paging;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1224aP;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.CC;
import defpackage.FW;
import defpackage.I8;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0939Tm;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class HintHandler {
    private final State state = new State();

    public final class HintFlow {
        private final CC _flow = AbstractC1224aP.b(1, 0, I8.DROP_OLDEST, 2, null);
        private ViewportHint value;

        public HintFlow() {
        }

        public final InterfaceC0939Tm getFlow() {
            return this._flow;
        }

        public final ViewportHint getValue() {
            return this.value;
        }

        public final void setValue(ViewportHint viewportHint) {
            this.value = viewportHint;
            if (viewportHint != null) {
                this._flow.f(viewportHint);
            }
        }
    }

    public final class State {
        private final HintFlow append;
        private ViewportHint.Access lastAccessHint;
        private final ReentrantLock lock = new ReentrantLock();
        private final HintFlow prepend;

        public State() {
            this.prepend = HintHandler.this.new HintFlow();
            this.append = HintHandler.this.new HintFlow();
        }

        public final InterfaceC0939Tm getAppendFlow() {
            return this.append.getFlow();
        }

        public final ViewportHint.Access getLastAccessHint() {
            return this.lastAccessHint;
        }

        public final InterfaceC0939Tm getPrependFlow() {
            return this.prepend.getFlow();
        }

        public final void modify(ViewportHint.Access access, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            if (access != null) {
                try {
                    this.lastAccessHint = access;
                } finally {
                    reentrantLock.unlock();
                }
            }
            interfaceC0526Fp.mo13invoke(this.prepend, this.append);
            FW fw = FW.a;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.HintHandler$forceSetHint$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ LoadType $loadType;
        final /* synthetic */ ViewportHint $viewportHint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LoadType loadType, ViewportHint viewportHint) {
            super(2);
            this.$loadType = loadType;
            this.$viewportHint = viewportHint;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((HintFlow) obj, (HintFlow) obj2);
            return FW.a;
        }

        public final void invoke(HintFlow hintFlow, HintFlow hintFlow2) {
            AbstractC4492zt.h(hintFlow, "prependHint");
            AbstractC4492zt.h(hintFlow2, "appendHint");
            if (this.$loadType == LoadType.PREPEND) {
                hintFlow.setValue(this.$viewportHint);
            } else {
                hintFlow2.setValue(this.$viewportHint);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.HintHandler$processHint$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ ViewportHint $viewportHint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewportHint viewportHint) {
            super(2);
            this.$viewportHint = viewportHint;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((HintFlow) obj, (HintFlow) obj2);
            return FW.a;
        }

        public final void invoke(HintFlow hintFlow, HintFlow hintFlow2) {
            AbstractC4492zt.h(hintFlow, "prependHint");
            AbstractC4492zt.h(hintFlow2, "appendHint");
            if (HintHandlerKt.shouldPrioritizeOver(this.$viewportHint, hintFlow.getValue(), LoadType.PREPEND)) {
                hintFlow.setValue(this.$viewportHint);
            }
            if (HintHandlerKt.shouldPrioritizeOver(this.$viewportHint, hintFlow2.getValue(), LoadType.APPEND)) {
                hintFlow2.setValue(this.$viewportHint);
            }
        }
    }

    public final void forceSetHint(LoadType loadType, ViewportHint viewportHint) {
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(viewportHint, "viewportHint");
        if (loadType == LoadType.PREPEND || loadType == LoadType.APPEND) {
            this.state.modify(null, new AnonymousClass2(loadType, viewportHint));
            return;
        }
        throw new IllegalArgumentException(("invalid load type for reset: " + loadType).toString());
    }

    public final ViewportHint.Access getLastAccessHint() {
        return this.state.getLastAccessHint();
    }

    public final InterfaceC0939Tm hintFor(LoadType loadType) {
        AbstractC4492zt.h(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return this.state.getPrependFlow();
        }
        if (i == 2) {
            return this.state.getAppendFlow();
        }
        throw new IllegalArgumentException("invalid load type for hints");
    }

    public final void processHint(ViewportHint viewportHint) {
        AbstractC4492zt.h(viewportHint, "viewportHint");
        this.state.modify(viewportHint instanceof ViewportHint.Access ? (ViewportHint.Access) viewportHint : null, new AnonymousClass1(viewportHint));
    }
}
