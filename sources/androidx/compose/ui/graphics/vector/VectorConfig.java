package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC4492zt;
import defpackage.BX;

/* JADX INFO: loaded from: classes.dex */
public interface VectorConfig {

    public static final class DefaultImpls {
        @Deprecated
        public static <T> T getOrDefault(VectorConfig vectorConfig, VectorProperty<T> vectorProperty, T t) {
            AbstractC4492zt.h(vectorProperty, "property");
            return (T) BX.a(vectorConfig, vectorProperty, t);
        }
    }

    <T> T getOrDefault(VectorProperty<T> vectorProperty, T t);
}
