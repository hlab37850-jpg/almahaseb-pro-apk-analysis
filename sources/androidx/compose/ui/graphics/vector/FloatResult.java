package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class FloatResult {
    private boolean isValid;
    private float value;

    public FloatResult() {
        this(0.0f, false, 3, null);
    }

    public final float getValue() {
        return this.value;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final void setValid(boolean z) {
        this.isValid = z;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    public FloatResult(float f, boolean z) {
        this.value = f;
        this.isValid = z;
    }

    public /* synthetic */ FloatResult(float f, boolean z, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? Float.NaN : f, (i & 2) != 0 ? false : z);
    }
}
