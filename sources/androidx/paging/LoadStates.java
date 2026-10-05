package androidx.paging;

import androidx.annotation.RestrictTo;
import defpackage.AD;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes2.dex */
public final class LoadStates {
    public static final Companion Companion = new Companion(null);
    private static final LoadStates IDLE;
    private final LoadState append;
    private final LoadState prepend;
    private final LoadState refresh;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final LoadStates getIDLE() {
            return LoadStates.IDLE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.APPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.Companion;
        IDLE = new LoadStates(companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common());
    }

    public LoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3) {
        AbstractC4492zt.h(loadState, "refresh");
        AbstractC4492zt.h(loadState2, "prepend");
        AbstractC4492zt.h(loadState3, "append");
        this.refresh = loadState;
        this.prepend = loadState2;
        this.append = loadState3;
    }

    public static /* synthetic */ LoadStates copy$default(LoadStates loadStates, LoadState loadState, LoadState loadState2, LoadState loadState3, int i, Object obj) {
        if ((i & 1) != 0) {
            loadState = loadStates.refresh;
        }
        if ((i & 2) != 0) {
            loadState2 = loadStates.prepend;
        }
        if ((i & 4) != 0) {
            loadState3 = loadStates.append;
        }
        return loadStates.copy(loadState, loadState2, loadState3);
    }

    public final LoadState component1() {
        return this.refresh;
    }

    public final LoadState component2() {
        return this.prepend;
    }

    public final LoadState component3() {
        return this.append;
    }

    public final LoadStates copy(LoadState loadState, LoadState loadState2, LoadState loadState3) {
        AbstractC4492zt.h(loadState, "refresh");
        AbstractC4492zt.h(loadState2, "prepend");
        AbstractC4492zt.h(loadState3, "append");
        return new LoadStates(loadState, loadState2, loadState3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadStates)) {
            return false;
        }
        LoadStates loadStates = (LoadStates) obj;
        return AbstractC4492zt.d(this.refresh, loadStates.refresh) && AbstractC4492zt.d(this.prepend, loadStates.prepend) && AbstractC4492zt.d(this.append, loadStates.append);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void forEach(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "op");
        interfaceC0526Fp.mo13invoke(LoadType.REFRESH, getRefresh());
        interfaceC0526Fp.mo13invoke(LoadType.PREPEND, getPrepend());
        interfaceC0526Fp.mo13invoke(LoadType.APPEND, getAppend());
    }

    public final LoadState get$paging_common(LoadType loadType) {
        AbstractC4492zt.h(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return this.append;
        }
        if (i == 2) {
            return this.prepend;
        }
        if (i == 3) {
            return this.refresh;
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

    public int hashCode() {
        return (((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode();
    }

    public final LoadStates modifyState$paging_common(LoadType loadType, LoadState loadState) {
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(loadState, "newState");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return copy$default(this, null, null, loadState, 3, null);
        }
        if (i == 2) {
            return copy$default(this, null, loadState, null, 5, null);
        }
        if (i == 3) {
            return copy$default(this, loadState, null, null, 6, null);
        }
        throw new AD();
    }

    public String toString() {
        return "LoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ')';
    }
}
