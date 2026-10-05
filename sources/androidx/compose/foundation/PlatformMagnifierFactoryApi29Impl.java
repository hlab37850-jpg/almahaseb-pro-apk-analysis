package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    @StabilityInferred(parameters = 0)
    @RequiresApi(29)
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformMagnifierImpl(Magnifier magnifier) {
            super(magnifier);
            AbstractC4492zt.h(magnifier, "magnifier");
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public void mo253updateWko1d7g(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                getMagnifier().setZoom(f);
            }
            if (OffsetKt.m2817isSpecifiedk4lQ0M(j2)) {
                getMagnifier().show(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2));
            } else {
                getMagnifier().show(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
            }
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public PlatformMagnifierImpl create(MagnifierStyle magnifierStyle, View view, Density density, float f) {
        AbstractC4492zt.h(magnifierStyle, "style");
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(density, "density");
        if (AbstractC4492zt.d(magnifierStyle, MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long jMo334toSizeXkaWNTQ = density.mo334toSizeXkaWNTQ(magnifierStyle.m231getSizeMYxV2XQ$foundation_release());
        float fMo333toPx0680j_4 = density.mo333toPx0680j_4(magnifierStyle.m229getCornerRadiusD9Ej5fM$foundation_release());
        float fMo333toPx0680j_5 = density.mo333toPx0680j_4(magnifierStyle.m230getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (jMo334toSizeXkaWNTQ != Size.Companion.m2875getUnspecifiedNHjbRc()) {
            builder.setSize(AbstractC1210aB.c(Size.m2867getWidthimpl(jMo334toSizeXkaWNTQ)), AbstractC1210aB.c(Size.m2864getHeightimpl(jMo334toSizeXkaWNTQ)));
        }
        if (!Float.isNaN(fMo333toPx0680j_4)) {
            builder.setCornerRadius(fMo333toPx0680j_4);
        }
        if (!Float.isNaN(fMo333toPx0680j_5)) {
            builder.setElevation(fMo333toPx0680j_5);
        }
        if (!Float.isNaN(f)) {
            builder.setInitialZoom(f);
        }
        builder.setClippingEnabled(magnifierStyle.getClippingEnabled$foundation_release());
        Magnifier magnifierBuild = builder.build();
        AbstractC4492zt.g(magnifierBuild, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(magnifierBuild);
    }
}
