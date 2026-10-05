package androidx.compose.ui.text.android;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class HorizontalPositionCache {
    private int cachedKey;
    private float cachedValue;
    private final TextLayout layout;

    public HorizontalPositionCache(TextLayout textLayout) {
        AbstractC4492zt.h(textLayout, "layout");
        this.layout = textLayout;
        this.cachedKey = -1;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    private final float get(int i, boolean z, boolean z2, boolean z3) {
        boolean z4;
        int i2 = 1;
        if (z) {
            int lineForOffset = LayoutCompatKt.getLineForOffset(this.layout.getLayout(), i, z);
            int lineStart = this.layout.getLineStart(lineForOffset);
            int lineEnd = this.layout.getLineEnd(lineForOffset);
            if (i == lineStart || i == lineEnd) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        int i3 = i * 4;
        if (!z3) {
            i2 = z4 ? 2 : 3;
        } else if (z4) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if (this.cachedKey == i4) {
            return this.cachedValue;
        }
        float primaryHorizontal = z3 ? this.layout.getPrimaryHorizontal(i, z) : this.layout.getSecondaryHorizontal(i, z);
        if (z2) {
            this.cachedKey = i4;
            this.cachedValue = primaryHorizontal;
        }
        return primaryHorizontal;
    }

    public final TextLayout getLayout() {
        return this.layout;
    }

    public final float getPrimaryDownstream(int i) {
        return get(i, false, false, true);
    }

    public final float getPrimaryUpstream(int i) {
        return get(i, true, true, true);
    }

    public final float getSecondaryDownstream(int i) {
        return get(i, false, false, false);
    }

    public final float getSecondaryUpstream(int i) {
        return get(i, true, true, false);
    }
}
