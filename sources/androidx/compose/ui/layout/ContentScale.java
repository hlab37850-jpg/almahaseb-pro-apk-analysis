package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface ContentScale {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo4150computeScaleFactorH7hwNQA(long j, long j2) {
                float fM4156computeFillMaxDimensioniLBOSCw = ContentScaleKt.m4156computeFillMaxDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM4156computeFillMaxDimensioniLBOSCw, fM4156computeFillMaxDimensioniLBOSCw);
            }
        };
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo4150computeScaleFactorH7hwNQA(long j, long j2) {
                float fM4157computeFillMinDimensioniLBOSCw = ContentScaleKt.m4157computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM4157computeFillMinDimensioniLBOSCw, fM4157computeFillMinDimensioniLBOSCw);
            }
        };
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo4150computeScaleFactorH7hwNQA(long j, long j2) {
                float fM4155computeFillHeightiLBOSCw = ContentScaleKt.m4155computeFillHeightiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM4155computeFillHeightiLBOSCw, fM4155computeFillHeightiLBOSCw);
            }
        };
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo4150computeScaleFactorH7hwNQA(long j, long j2) {
                float fM4158computeFillWidthiLBOSCw = ContentScaleKt.m4158computeFillWidthiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM4158computeFillWidthiLBOSCw, fM4158computeFillWidthiLBOSCw);
            }
        };
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo4150computeScaleFactorH7hwNQA(long j, long j2) {
                if (Size.m2867getWidthimpl(j) <= Size.m2867getWidthimpl(j2) && Size.m2864getHeightimpl(j) <= Size.m2864getHeightimpl(j2)) {
                    return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
                }
                float fM4157computeFillMinDimensioniLBOSCw = ContentScaleKt.m4157computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM4157computeFillMinDimensioniLBOSCw, fM4157computeFillMinDimensioniLBOSCw);
            }
        };
        private static final FixedScale None = new FixedScale(1.0f);
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo4150computeScaleFactorH7hwNQA(long j, long j2) {
                return ScaleFactorKt.ScaleFactor(ContentScaleKt.m4158computeFillWidthiLBOSCw(j, j2), ContentScaleKt.m4155computeFillHeightiLBOSCw(j, j2));
            }
        };

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getCrop$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillBounds$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillHeight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillWidth$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFit$annotations() {
        }

        @Stable
        public static /* synthetic */ void getInside$annotations() {
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        public final ContentScale getCrop() {
            return Crop;
        }

        public final ContentScale getFillBounds() {
            return FillBounds;
        }

        public final ContentScale getFillHeight() {
            return FillHeight;
        }

        public final ContentScale getFillWidth() {
            return FillWidth;
        }

        public final ContentScale getFit() {
            return Fit;
        }

        public final ContentScale getInside() {
            return Inside;
        }

        public final FixedScale getNone() {
            return None;
        }
    }

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo4150computeScaleFactorH7hwNQA(long j, long j2);
}
