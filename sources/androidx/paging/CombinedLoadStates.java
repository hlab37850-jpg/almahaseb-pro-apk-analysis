package androidx.paging;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes2.dex */
public final class CombinedLoadStates {
    private final LoadState append;
    private final LoadStates mediator;
    private final LoadState prepend;
    private final LoadState refresh;
    private final LoadStates source;

    public CombinedLoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadStates loadStates, LoadStates loadStates2) {
        AbstractC4492zt.h(loadState, "refresh");
        AbstractC4492zt.h(loadState2, "prepend");
        AbstractC4492zt.h(loadState3, "append");
        AbstractC4492zt.h(loadStates, DublinCoreProperties.SOURCE);
        this.refresh = loadState;
        this.prepend = loadState2;
        this.append = loadState3;
        this.source = loadStates;
        this.mediator = loadStates2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC4492zt.d(CombinedLoadStates.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) obj;
        return AbstractC4492zt.d(this.refresh, combinedLoadStates.refresh) && AbstractC4492zt.d(this.prepend, combinedLoadStates.prepend) && AbstractC4492zt.d(this.append, combinedLoadStates.append) && AbstractC4492zt.d(this.source, combinedLoadStates.source) && AbstractC4492zt.d(this.mediator, combinedLoadStates.mediator);
    }

    public final void forEach$paging_common(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "op");
        LoadStates loadStates = this.source;
        LoadType loadType = LoadType.REFRESH;
        LoadState refresh = loadStates.getRefresh();
        Boolean bool = Boolean.FALSE;
        interfaceC0552Gp.invoke(loadType, bool, refresh);
        LoadType loadType2 = LoadType.PREPEND;
        interfaceC0552Gp.invoke(loadType2, bool, loadStates.getPrepend());
        LoadType loadType3 = LoadType.APPEND;
        interfaceC0552Gp.invoke(loadType3, bool, loadStates.getAppend());
        LoadStates loadStates2 = this.mediator;
        if (loadStates2 != null) {
            LoadState refresh2 = loadStates2.getRefresh();
            Boolean bool2 = Boolean.TRUE;
            interfaceC0552Gp.invoke(loadType, bool2, refresh2);
            interfaceC0552Gp.invoke(loadType2, bool2, loadStates2.getPrepend());
            interfaceC0552Gp.invoke(loadType3, bool2, loadStates2.getAppend());
        }
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadStates getMediator() {
        return this.mediator;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final LoadStates getSource() {
        return this.source;
    }

    public int hashCode() {
        int iHashCode = ((((((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode()) * 31) + this.source.hashCode()) * 31;
        LoadStates loadStates = this.mediator;
        return iHashCode + (loadStates != null ? loadStates.hashCode() : 0);
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ", source=" + this.source + ", mediator=" + this.mediator + ')';
    }

    public /* synthetic */ CombinedLoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadStates loadStates, LoadStates loadStates2, int i, AbstractC0419Di abstractC0419Di) {
        this(loadState, loadState2, loadState3, loadStates, (i & 16) != 0 ? null : loadStates2);
    }
}
