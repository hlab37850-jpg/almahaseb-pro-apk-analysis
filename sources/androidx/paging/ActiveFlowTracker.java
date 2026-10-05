package androidx.paging;

import androidx.annotation.VisibleForTesting;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public interface ActiveFlowTracker {

    public enum FlowType {
        PAGED_DATA_FLOW,
        PAGE_EVENT_FLOW
    }

    Object onComplete(FlowType flowType, InterfaceC0793Of interfaceC0793Of);

    void onNewCachedEventFlow(CachedPageEventFlow<?> cachedPageEventFlow);

    Object onStart(FlowType flowType, InterfaceC0793Of interfaceC0793Of);
}
