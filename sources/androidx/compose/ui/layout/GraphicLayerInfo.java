package androidx.compose.ui.layout;

import defpackage.AbstractC0830Pq;

/* JADX INFO: loaded from: classes.dex */
public interface GraphicLayerInfo {

    public static final class DefaultImpls {
        @Deprecated
        public static long getOwnerViewId(GraphicLayerInfo graphicLayerInfo) {
            return AbstractC0830Pq.a(graphicLayerInfo);
        }
    }

    long getLayerId();

    long getOwnerViewId();
}
