package androidx.compose.material3;

import androidx.compose.runtime.Immutable;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class FabPlacement {
    private final int height;
    private final int left;
    private final int width;

    public FabPlacement(int i, int i2, int i3) {
        this.left = i;
        this.width = i2;
        this.height = i3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getWidth() {
        return this.width;
    }
}
