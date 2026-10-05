package androidx.compose.ui.graphics;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface PathEffect {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ PathEffect dashPathEffect$default(Companion companion, float[] fArr, float f, int i, Object obj) {
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            return companion.dashPathEffect(fArr, f);
        }

        public final PathEffect chainPathEffect(PathEffect pathEffect, PathEffect pathEffect2) {
            AbstractC4492zt.h(pathEffect, "outer");
            AbstractC4492zt.h(pathEffect2, "inner");
            return AndroidPathEffect_androidKt.actualChainPathEffect(pathEffect, pathEffect2);
        }

        public final PathEffect cornerPathEffect(float f) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(f);
        }

        public final PathEffect dashPathEffect(float[] fArr, float f) {
            AbstractC4492zt.h(fArr, "intervals");
            return AndroidPathEffect_androidKt.actualDashPathEffect(fArr, f);
        }

        /* JADX INFO: renamed from: stampedPathEffect-7aD1DOk, reason: not valid java name */
        public final PathEffect m3278stampedPathEffect7aD1DOk(Path path, float f, float f2, int i) {
            AbstractC4492zt.h(path, "shape");
            return AndroidPathEffect_androidKt.m2936actualStampedPathEffect7aD1DOk(path, f, f2, i);
        }
    }
}
