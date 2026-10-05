package androidx.compose.ui.geometry;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class MutableRectKt {
    public static final Rect toRect(MutableRect mutableRect) {
        AbstractC4492zt.h(mutableRect, "<this>");
        return new Rect(mutableRect.getLeft(), mutableRect.getTop(), mutableRect.getRight(), mutableRect.getBottom());
    }
}
