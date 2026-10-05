package androidx.paging;

import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.HV;
import defpackage.InterfaceC3750qp;
import defpackage.Y4;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class AccessorState<Key, Value> {
    private final BlockState[] blockStates;
    private final LoadState.Error[] errors;
    private final Y4 pendingRequests;
    private boolean refreshAllowed;

    public enum BlockState {
        UNBLOCKED,
        COMPLETED,
        REQUIRES_REFRESH
    }

    public static final class PendingRequest<Key, Value> {
        private final LoadType loadType;
        private PagingState<Key, Value> pagingState;

        public PendingRequest(LoadType loadType, PagingState<Key, Value> pagingState) {
            AbstractC4492zt.h(loadType, "loadType");
            AbstractC4492zt.h(pagingState, "pagingState");
            this.loadType = loadType;
            this.pagingState = pagingState;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final PagingState<Key, Value> getPagingState() {
            return this.pagingState;
        }

        public final void setPagingState(PagingState<Key, Value> pagingState) {
            AbstractC4492zt.h(pagingState, "<set-?>");
            this.pagingState = pagingState;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BlockState.values().length];
            try {
                iArr2[BlockState.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[BlockState.REQUIRES_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[BlockState.UNBLOCKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.AccessorState$clearPendingRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LoadType $loadType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LoadType loadType) {
            super(1);
            this.$loadType = loadType;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(PendingRequest<Key, Value> pendingRequest) {
            AbstractC4492zt.h(pendingRequest, "it");
            return Boolean.valueOf(pendingRequest.getLoadType() == this.$loadType);
        }
    }

    public AccessorState() {
        int length = LoadType.values().length;
        BlockState[] blockStateArr = new BlockState[length];
        for (int i = 0; i < length; i++) {
            blockStateArr[i] = BlockState.UNBLOCKED;
        }
        this.blockStates = blockStateArr;
        int length2 = LoadType.values().length;
        LoadState.Error[] errorArr = new LoadState.Error[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            errorArr[i2] = null;
        }
        this.errors = errorArr;
        this.pendingRequests = new Y4();
    }

    private final LoadState computeLoadTypeState(LoadType loadType) {
        BlockState blockState = this.blockStates[loadType.ordinal()];
        Y4 y4 = this.pendingRequests;
        if (!(y4 instanceof Collection) || !y4.isEmpty()) {
            Iterator<E> it = y4.iterator();
            while (it.hasNext()) {
                if (((PendingRequest) it.next()).getLoadType() == loadType) {
                    if (blockState == BlockState.REQUIRES_REFRESH) {
                        break;
                    }
                    return LoadState.Loading.INSTANCE;
                }
            }
        }
        LoadState.Error error = this.errors[loadType.ordinal()];
        if (error != null) {
            return error;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[blockState.ordinal()];
        if (i == 1) {
            return WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1 ? LoadState.NotLoading.Companion.getIncomplete$paging_common() : LoadState.NotLoading.Companion.getComplete$paging_common();
        }
        if (i == 2) {
            return LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        if (i == 3) {
            return LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        throw new AD();
    }

    public final boolean add(LoadType loadType, PagingState<Key, Value> pagingState) {
        Object next;
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(pagingState, "pagingState");
        Iterator<E> it = this.pendingRequests.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((PendingRequest) next).getLoadType() != loadType);
        PendingRequest pendingRequest = (PendingRequest) next;
        if (pendingRequest != null) {
            pendingRequest.setPagingState(pagingState);
            return false;
        }
        BlockState blockState = this.blockStates[loadType.ordinal()];
        if (blockState == BlockState.REQUIRES_REFRESH && loadType != LoadType.REFRESH) {
            this.pendingRequests.add(new PendingRequest(loadType, pagingState));
            return false;
        }
        if (blockState != BlockState.UNBLOCKED && loadType != LoadType.REFRESH) {
            return false;
        }
        LoadType loadType2 = LoadType.REFRESH;
        if (loadType == loadType2) {
            setError(loadType2, null);
        }
        if (this.errors[loadType.ordinal()] == null) {
            return this.pendingRequests.add(new PendingRequest(loadType, pagingState));
        }
        return false;
    }

    public final void clearErrors() {
        int length = this.errors.length;
        for (int i = 0; i < length; i++) {
            this.errors[i] = null;
        }
    }

    public final void clearPendingRequest(LoadType loadType) {
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC2371hc.M(this.pendingRequests, new AnonymousClass1(loadType));
    }

    public final void clearPendingRequests() {
        this.pendingRequests.clear();
    }

    public final LoadStates computeLoadStates() {
        return new LoadStates(computeLoadTypeState(LoadType.REFRESH), computeLoadTypeState(LoadType.PREPEND), computeLoadTypeState(LoadType.APPEND));
    }

    public final C2020dG getPendingBoundary() {
        Object next;
        Iterator<E> it = this.pendingRequests.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            PendingRequest pendingRequest = (PendingRequest) next;
            if (pendingRequest.getLoadType() != LoadType.REFRESH && this.blockStates[pendingRequest.getLoadType().ordinal()] == BlockState.UNBLOCKED) {
                break;
            }
        }
        PendingRequest pendingRequest2 = (PendingRequest) next;
        if (pendingRequest2 != null) {
            return HV.a(pendingRequest2.getLoadType(), pendingRequest2.getPagingState());
        }
        return null;
    }

    public final PagingState<Key, Value> getPendingRefresh() {
        Object next;
        Iterator<E> it = this.pendingRequests.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((PendingRequest) next).getLoadType() != LoadType.REFRESH);
        PendingRequest pendingRequest = (PendingRequest) next;
        if (pendingRequest != null) {
            return pendingRequest.getPagingState();
        }
        return null;
    }

    public final boolean getRefreshAllowed() {
        return this.refreshAllowed;
    }

    public final void setBlockState(LoadType loadType, BlockState blockState) {
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(blockState, "state");
        this.blockStates[loadType.ordinal()] = blockState;
    }

    public final void setError(LoadType loadType, LoadState.Error error) {
        AbstractC4492zt.h(loadType, "loadType");
        this.errors[loadType.ordinal()] = error;
    }

    public final void setRefreshAllowed(boolean z) {
        this.refreshAllowed = z;
    }
}
