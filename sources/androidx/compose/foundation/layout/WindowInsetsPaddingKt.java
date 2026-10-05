package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsPaddingKt {
    private static final ProvidableModifierLocal<WindowInsets> ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf(WindowInsetsPaddingKt$ModifierLocalConsumedWindowInsets$1.INSTANCE);

    @Stable
    public static final Modifier consumeWindowInsets(Modifier modifier, WindowInsets windowInsets) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(windowInsets, "insets");
        return modifier.then(new UnionInsetsConsumingModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @ExperimentalLayoutApi
    public static final Modifier consumedWindowInsets(Modifier modifier, WindowInsets windowInsets) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(windowInsets, "insets");
        return consumeWindowInsets(modifier, windowInsets);
    }

    public static final ProvidableModifierLocal<WindowInsets> getModifierLocalConsumedWindowInsets() {
        return ModifierLocalConsumedWindowInsets;
    }

    @Stable
    public static final Modifier onConsumedWindowInsetsChanged(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        return modifier.then(new ConsumedInsetsModifier(interfaceC3750qp, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1(interfaceC3750qp) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    public static final Modifier windowInsetsPadding(Modifier modifier, WindowInsets windowInsets) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(windowInsets, "insets");
        return modifier.then(new InsetsPaddingModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @ExperimentalLayoutApi
    public static final Modifier withConsumedWindowInsets(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        return onConsumedWindowInsetsChanged(modifier, interfaceC3750qp);
    }

    @Stable
    @ExperimentalLayoutApi
    public static final Modifier consumedWindowInsets(Modifier modifier, PaddingValues paddingValues) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(paddingValues, "paddingValues");
        return consumeWindowInsets(modifier, paddingValues);
    }

    @Stable
    @ExperimentalLayoutApi
    public static final Modifier consumeWindowInsets(Modifier modifier, PaddingValues paddingValues) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesConsumingModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$2(paddingValues) : InspectableValueKt.getNoInspectorInfo()));
    }
}
