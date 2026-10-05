package androidx.paging;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.CR;
import defpackage.DC;
import defpackage.ER;
import defpackage.InterfaceC3750qp;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableCombinedLoadStateCollection {
    private final DC _stateFlow;
    private final CopyOnWriteArrayList<InterfaceC3750qp> listeners = new CopyOnWriteArrayList<>();
    private final CR stateFlow;

    /* JADX INFO: renamed from: androidx.paging.MutableCombinedLoadStateCollection$set$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LoadStates $remoteLoadStates;
        final /* synthetic */ LoadStates $sourceLoadStates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LoadStates loadStates, LoadStates loadStates2) {
            super(1);
            this.$sourceLoadStates = loadStates;
            this.$remoteLoadStates = loadStates2;
        }

        @Override // defpackage.InterfaceC3750qp
        public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
            return MutableCombinedLoadStateCollection.this.computeNewState(combinedLoadStates, this.$sourceLoadStates, this.$remoteLoadStates);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.MutableCombinedLoadStateCollection$set$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ boolean $remote;
        final /* synthetic */ LoadState $state;
        final /* synthetic */ LoadType $type;
        final /* synthetic */ MutableCombinedLoadStateCollection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z, LoadType loadType, LoadState loadState, MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection) {
            super(1);
            this.$remote = z;
            this.$type = loadType;
            this.$state = loadState;
            this.this$0 = mutableCombinedLoadStateCollection;
        }

        @Override // defpackage.InterfaceC3750qp
        public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
            LoadStates idle;
            LoadStates idle2;
            if (combinedLoadStates == null || (idle = combinedLoadStates.getSource()) == null) {
                idle = LoadStates.Companion.getIDLE();
            }
            if (combinedLoadStates == null || (idle2 = combinedLoadStates.getMediator()) == null) {
                idle2 = LoadStates.Companion.getIDLE();
            }
            if (this.$remote) {
                idle2 = idle2.modifyState$paging_common(this.$type, this.$state);
            } else {
                idle = idle.modifyState$paging_common(this.$type, this.$state);
            }
            return this.this$0.computeNewState(combinedLoadStates, idle, idle2);
        }
    }

    public MutableCombinedLoadStateCollection() {
        DC dcA = ER.a(null);
        this._stateFlow = dcA;
        this.stateFlow = AbstractC1047Xm.b(dcA);
    }

    private final LoadState computeHelperState(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadState loadState4) {
        if (loadState4 == null) {
            return loadState3;
        }
        return (!(loadState instanceof LoadState.Loading) || ((loadState2 instanceof LoadState.NotLoading) && (loadState4 instanceof LoadState.NotLoading)) || (loadState4 instanceof LoadState.Error)) ? loadState4 : loadState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CombinedLoadStates computeNewState(CombinedLoadStates combinedLoadStates, LoadStates loadStates, LoadStates loadStates2) {
        LoadState incomplete$paging_common;
        LoadState incomplete$paging_common2;
        LoadState incomplete$paging_common3;
        if (combinedLoadStates == null || (incomplete$paging_common = combinedLoadStates.getRefresh()) == null) {
            incomplete$paging_common = LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        LoadState loadStateComputeHelperState = computeHelperState(incomplete$paging_common, loadStates.getRefresh(), loadStates.getRefresh(), loadStates2 != null ? loadStates2.getRefresh() : null);
        if (combinedLoadStates == null || (incomplete$paging_common2 = combinedLoadStates.getPrepend()) == null) {
            incomplete$paging_common2 = LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        LoadState loadStateComputeHelperState2 = computeHelperState(incomplete$paging_common2, loadStates.getRefresh(), loadStates.getPrepend(), loadStates2 != null ? loadStates2.getPrepend() : null);
        if (combinedLoadStates == null || (incomplete$paging_common3 = combinedLoadStates.getAppend()) == null) {
            incomplete$paging_common3 = LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        return new CombinedLoadStates(loadStateComputeHelperState, loadStateComputeHelperState2, computeHelperState(incomplete$paging_common3, loadStates.getRefresh(), loadStates.getAppend(), loadStates2 != null ? loadStates2.getAppend() : null), loadStates, loadStates2);
    }

    private final void dispatchNewState(InterfaceC3750qp interfaceC3750qp) {
        Object value;
        CombinedLoadStates combinedLoadStates;
        DC dc = this._stateFlow;
        do {
            value = dc.getValue();
            CombinedLoadStates combinedLoadStates2 = (CombinedLoadStates) value;
            combinedLoadStates = (CombinedLoadStates) interfaceC3750qp.invoke(combinedLoadStates2);
            if (AbstractC4492zt.d(combinedLoadStates2, combinedLoadStates)) {
                return;
            }
        } while (!dc.b(value, combinedLoadStates));
        if (combinedLoadStates != null) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((InterfaceC3750qp) it.next()).invoke(combinedLoadStates);
            }
        }
    }

    public final void addListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(interfaceC3750qp);
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) this._stateFlow.getValue();
        if (combinedLoadStates != null) {
            interfaceC3750qp.invoke(combinedLoadStates);
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0017  */
    public final LoadState get(LoadType loadType, boolean z) {
        LoadStates source;
        AbstractC4492zt.h(loadType, "type");
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) this._stateFlow.getValue();
        if (z) {
            if (combinedLoadStates != null) {
                source = combinedLoadStates.getMediator();
            } else {
                source = null;
            }
        } else if (combinedLoadStates != null) {
            source = combinedLoadStates.getSource();
        } else {
            source = null;
        }
        if (source != null) {
            return source.get$paging_common(loadType);
        }
        return null;
    }

    public final CR getStateFlow() {
        return this.stateFlow;
    }

    public final void removeListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(interfaceC3750qp);
    }

    public final void set(LoadStates loadStates, LoadStates loadStates2) {
        AbstractC4492zt.h(loadStates, "sourceLoadStates");
        dispatchNewState(new AnonymousClass1(loadStates, loadStates2));
    }

    public final void set(LoadType loadType, boolean z, LoadState loadState) {
        AbstractC4492zt.h(loadType, "type");
        AbstractC4492zt.h(loadState, "state");
        dispatchNewState(new AnonymousClass2(z, loadType, loadState, this));
    }
}
