package androidx.compose.ui.graphics;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidPath_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Path Path() {
        return new AndroidPath(null, 1, 0 == true ? 1 : 0);
    }

    public static final android.graphics.Path asAndroidPath(Path path) {
        AbstractC4492zt.h(path, "<this>");
        if (path instanceof AndroidPath) {
            return ((AndroidPath) path).getInternalPath();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public static final Path asComposePath(android.graphics.Path path) {
        AbstractC4492zt.h(path, "<this>");
        return new AndroidPath(path);
    }
}
