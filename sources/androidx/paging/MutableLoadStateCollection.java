package androidx.paging;

import defpackage.AD;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableLoadStateCollection {
    private LoadState append;
    private LoadState prepend;
    private LoadState refresh;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MutableLoadStateCollection() {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.Companion;
        this.refresh = companion.getIncomplete$paging_common();
        this.prepend = companion.getIncomplete$paging_common();
        this.append = companion.getIncomplete$paging_common();
    }

    public final LoadState get(LoadType loadType) {
        AbstractC4492zt.h(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return this.refresh;
        }
        if (i == 2) {
            return this.append;
        }
        if (i == 3) {
            return this.prepend;
        }
        throw new AD();
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final void set(LoadType loadType, LoadState loadState) {
        AbstractC4492zt.h(loadType, "type");
        AbstractC4492zt.h(loadState, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            this.refresh = loadState;
        } else if (i == 2) {
            this.append = loadState;
        } else {
            if (i != 3) {
                throw new AD();
            }
            this.prepend = loadState;
        }
    }

    public final void setAppend(LoadState loadState) {
        AbstractC4492zt.h(loadState, "<set-?>");
        this.append = loadState;
    }

    public final void setPrepend(LoadState loadState) {
        AbstractC4492zt.h(loadState, "<set-?>");
        this.prepend = loadState;
    }

    public final void setRefresh(LoadState loadState) {
        AbstractC4492zt.h(loadState, "<set-?>");
        this.refresh = loadState;
    }

    public final LoadStates snapshot() {
        return new LoadStates(this.refresh, this.prepend, this.append);
    }

    public final void set(LoadStates loadStates) {
        AbstractC4492zt.h(loadStates, "states");
        this.refresh = loadStates.getRefresh();
        this.append = loadStates.getAppend();
        this.prepend = loadStates.getPrepend();
    }
}
