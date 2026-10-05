package androidx.customview.poolingcontainer;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(PoolingContainerListener poolingContainerListener) {
        AbstractC4492zt.h(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(poolingContainerListener);
    }

    public final void onRelease() {
        for (int iO = AbstractC1886cc.o(this.listeners); -1 < iO; iO--) {
            this.listeners.get(iO).onRelease();
        }
    }

    public final void removeListener(PoolingContainerListener poolingContainerListener) {
        AbstractC4492zt.h(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(poolingContainerListener);
    }
}
