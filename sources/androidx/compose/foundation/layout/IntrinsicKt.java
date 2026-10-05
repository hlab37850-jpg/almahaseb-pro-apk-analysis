package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import defpackage.AD;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IntrinsicSize.values().length];
            try {
                iArr[IntrinsicSize.Min.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IntrinsicSize.Max.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Stable
    public static final Modifier height(Modifier modifier, IntrinsicSize intrinsicSize) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(MinIntrinsicHeightModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(MaxIntrinsicHeightModifier.INSTANCE);
        }
        throw new AD();
    }

    @Stable
    public static final Modifier requiredHeight(Modifier modifier, IntrinsicSize intrinsicSize) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(RequiredMinIntrinsicHeightModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(RequiredMaxIntrinsicHeightModifier.INSTANCE);
        }
        throw new AD();
    }

    @Stable
    public static final Modifier requiredWidth(Modifier modifier, IntrinsicSize intrinsicSize) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(RequiredMinIntrinsicWidthModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(RequiredMaxIntrinsicWidthModifier.INSTANCE);
        }
        throw new AD();
    }

    @Stable
    public static final Modifier width(Modifier modifier, IntrinsicSize intrinsicSize) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(intrinsicSize, "intrinsicSize");
        int i = WhenMappings.$EnumSwitchMapping$0[intrinsicSize.ordinal()];
        if (i == 1) {
            return modifier.then(MinIntrinsicWidthModifier.INSTANCE);
        }
        if (i == 2) {
            return modifier.then(MaxIntrinsicWidthModifier.INSTANCE);
        }
        throw new AD();
    }
}
