package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FocusableKt {
    private static final FocusableKt$FocusableInNonTouchModeElement$1 FocusableInNonTouchModeElement;
    private static final InspectableModifier focusGroupInspectorInfo;

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusGroup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusProperties) obj);
            return FW.a;
        }

        public final void invoke(FocusProperties focusProperties) {
            AbstractC4492zt.h(focusProperties, "$this$focusProperties");
            focusProperties.setCanFocus(false);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableKt$focusableInNonTouchMode$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13051 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13051(boolean z, MutableInteractionSource mutableInteractionSource) {
            super(1);
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$inspectable");
            inspectorInfo.setName("focusableInNonTouchMode");
            inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.$enabled));
            inspectorInfo.getProperties().set("interactionSource", this.$interactionSource);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1] */
    static {
        focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusableKt$special$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo());
        FocusableInNonTouchModeElement = new ModifierNodeElement<FocusableInNonTouchMode>() { // from class: androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public boolean equals(Object obj) {
                return this == obj;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return System.identityHashCode(this);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo inspectorInfo) {
                AbstractC4492zt.h(inspectorInfo, "<this>");
                inspectorInfo.setName("focusableInNonTouchMode");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(FocusableInNonTouchMode focusableInNonTouchMode) {
                AbstractC4492zt.h(focusableInNonTouchMode, "node");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public FocusableInNonTouchMode create() {
                return new FocusableInNonTouchMode();
            }
        };
    }

    @ExperimentalFoundationApi
    public static final Modifier focusGroup(Modifier modifier) {
        AbstractC4492zt.h(modifier, "<this>");
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties(modifier.then(focusGroupInspectorInfo), AnonymousClass1.INSTANCE));
    }

    public static final Modifier focusable(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(modifier, "<this>");
        return modifier.then(z ? FocusModifierKt.focusTarget(new FocusableElement(mutableInteractionSource)) : Modifier.Companion);
    }

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z, mutableInteractionSource);
    }

    public static final Modifier focusableInNonTouchMode(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(modifier, "<this>");
        return InspectableValueKt.inspectableWrapper(modifier, new C13051(z, mutableInteractionSource), focusable(Modifier.Companion.then(FocusableInNonTouchModeElement), z, mutableInteractionSource));
    }
}
