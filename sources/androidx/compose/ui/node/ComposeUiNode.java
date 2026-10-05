package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public interface ComposeUiNode {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final InterfaceC3588op Constructor = LayoutNode.Companion.getConstructor$ui_release();
        private static final InterfaceC3588op VirtualConstructor = ComposeUiNode$Companion$VirtualConstructor$1.INSTANCE;
        private static final InterfaceC0526Fp SetModifier = ComposeUiNode$Companion$SetModifier$1.INSTANCE;
        private static final InterfaceC0526Fp SetDensity = ComposeUiNode$Companion$SetDensity$1.INSTANCE;
        private static final InterfaceC0526Fp SetResolvedCompositionLocals = ComposeUiNode$Companion$SetResolvedCompositionLocals$1.INSTANCE;
        private static final InterfaceC0526Fp SetMeasurePolicy = ComposeUiNode$Companion$SetMeasurePolicy$1.INSTANCE;
        private static final InterfaceC0526Fp SetLayoutDirection = ComposeUiNode$Companion$SetLayoutDirection$1.INSTANCE;
        private static final InterfaceC0526Fp SetViewConfiguration = ComposeUiNode$Companion$SetViewConfiguration$1.INSTANCE;
        private static final InterfaceC0526Fp SetCompositeKeyHash = ComposeUiNode$Companion$SetCompositeKeyHash$1.INSTANCE;

        private Companion() {
        }

        @ExperimentalComposeUiApi
        public static /* synthetic */ void getSetCompositeKeyHash$annotations() {
        }

        public final InterfaceC3588op getConstructor() {
            return Constructor;
        }

        @ExperimentalComposeUiApi
        public final InterfaceC0526Fp getSetCompositeKeyHash() {
            return SetCompositeKeyHash;
        }

        public final InterfaceC0526Fp getSetDensity() {
            return SetDensity;
        }

        public final InterfaceC0526Fp getSetLayoutDirection() {
            return SetLayoutDirection;
        }

        public final InterfaceC0526Fp getSetMeasurePolicy() {
            return SetMeasurePolicy;
        }

        public final InterfaceC0526Fp getSetModifier() {
            return SetModifier;
        }

        public final InterfaceC0526Fp getSetResolvedCompositionLocals() {
            return SetResolvedCompositionLocals;
        }

        public final InterfaceC0526Fp getSetViewConfiguration() {
            return SetViewConfiguration;
        }

        public final InterfaceC3588op getVirtualConstructor() {
            return VirtualConstructor;
        }
    }

    int getCompositeKeyHash();

    CompositionLocalMap getCompositionLocalMap();

    Density getDensity();

    LayoutDirection getLayoutDirection();

    MeasurePolicy getMeasurePolicy();

    Modifier getModifier();

    ViewConfiguration getViewConfiguration();

    void setCompositeKeyHash(int i);

    void setCompositionLocalMap(CompositionLocalMap compositionLocalMap);

    void setDensity(Density density);

    void setLayoutDirection(LayoutDirection layoutDirection);

    void setMeasurePolicy(MeasurePolicy measurePolicy);

    void setModifier(Modifier modifier);

    void setViewConfiguration(ViewConfiguration viewConfiguration);
}
