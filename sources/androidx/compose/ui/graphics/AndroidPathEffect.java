package androidx.compose.ui.graphics;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidPathEffect implements PathEffect {
    private final android.graphics.PathEffect nativePathEffect;

    public AndroidPathEffect(android.graphics.PathEffect pathEffect) {
        AbstractC4492zt.h(pathEffect, "nativePathEffect");
        this.nativePathEffect = pathEffect;
    }

    public final android.graphics.PathEffect getNativePathEffect() {
        return this.nativePathEffect;
    }
}
