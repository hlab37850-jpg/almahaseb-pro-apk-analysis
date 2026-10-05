package androidx.paging;

import androidx.annotation.VisibleForTesting;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class GenerationalViewportHint {
    private final int generationId;
    private final ViewportHint hint;

    public GenerationalViewportHint(int i, ViewportHint viewportHint) {
        AbstractC4492zt.h(viewportHint, "hint");
        this.generationId = i;
        this.hint = viewportHint;
    }

    public static /* synthetic */ GenerationalViewportHint copy$default(GenerationalViewportHint generationalViewportHint, int i, ViewportHint viewportHint, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = generationalViewportHint.generationId;
        }
        if ((i2 & 2) != 0) {
            viewportHint = generationalViewportHint.hint;
        }
        return generationalViewportHint.copy(i, viewportHint);
    }

    public final int component1() {
        return this.generationId;
    }

    public final ViewportHint component2() {
        return this.hint;
    }

    public final GenerationalViewportHint copy(int i, ViewportHint viewportHint) {
        AbstractC4492zt.h(viewportHint, "hint");
        return new GenerationalViewportHint(i, viewportHint);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenerationalViewportHint)) {
            return false;
        }
        GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) obj;
        return this.generationId == generationalViewportHint.generationId && AbstractC4492zt.d(this.hint, generationalViewportHint.hint);
    }

    public final int getGenerationId() {
        return this.generationId;
    }

    public final ViewportHint getHint() {
        return this.hint;
    }

    public int hashCode() {
        return (this.generationId * 31) + this.hint.hashCode();
    }

    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.generationId + ", hint=" + this.hint + ')';
    }
}
