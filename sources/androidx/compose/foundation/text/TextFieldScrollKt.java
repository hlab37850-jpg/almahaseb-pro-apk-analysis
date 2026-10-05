package androidx.compose.foundation.text;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldScrollKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z, MutableInteractionSource mutableInteractionSource) {
            super(3);
            this.$scrollerPosition = textFieldScrollerPosition;
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(805428266);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(805428266, i, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:66)");
            }
            boolean z = this.$scrollerPosition.getOrientation() == Orientation.Vertical || !(composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl);
            TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(textFieldScrollerPosition);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1(textFieldScrollerPosition);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            final ScrollableState scrollableStateRememberScrollableState = ScrollableStateKt.rememberScrollableState((InterfaceC3750qp) objRememberedValue, composer, 0);
            final TextFieldScrollerPosition textFieldScrollerPosition2 = this.$scrollerPosition;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(scrollableStateRememberScrollableState) | composer.changed(textFieldScrollerPosition2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new ScrollableState(textFieldScrollerPosition2) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1
                    private final State canScrollBackward$delegate;
                    private final State canScrollForward$delegate;

                    {
                        this.canScrollForward$delegate = SnapshotStateKt.derivedStateOf(new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollForward$2(textFieldScrollerPosition2));
                        this.canScrollBackward$delegate = SnapshotStateKt.derivedStateOf(new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollBackward$2(textFieldScrollerPosition2));
                    }

                    @Override // androidx.compose.foundation.gestures.ScrollableState
                    public float dispatchRawDelta(float f) {
                        return this.$$delegate_0.dispatchRawDelta(f);
                    }

                    @Override // androidx.compose.foundation.gestures.ScrollableState
                    public boolean getCanScrollBackward() {
                        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
                    }

                    @Override // androidx.compose.foundation.gestures.ScrollableState
                    public boolean getCanScrollForward() {
                        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
                    }

                    @Override // androidx.compose.foundation.gestures.ScrollableState
                    public boolean isScrollInProgress() {
                        return this.$$delegate_0.isScrollInProgress();
                    }

                    @Override // androidx.compose.foundation.gestures.ScrollableState
                    public Object scroll(MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
                        return this.$$delegate_0.scroll(mutatePriority, interfaceC0526Fp, interfaceC0793Of);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier modifierScrollable = ScrollableKt.scrollable(Modifier.Companion, (TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) objRememberedValue2, this.$scrollerPosition.getOrientation(), (16 & 4) != 0 ? true : this.$enabled && this.$scrollerPosition.getMaximum() != 0.0f, (16 & 8) != 0 ? false : z, (16 & 16) != 0 ? null : null, (16 & 32) != 0 ? null : this.$interactionSource);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierScrollable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, int i, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z, int i2) {
        Rect zero;
        if (textLayoutResult == null || (zero = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(i))) == null) {
            zero = Rect.Companion.getZero();
        }
        Rect rect = zero;
        int iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        return Rect.copy$default(rect, z ? (i2 - rect.getLeft()) - iMo327roundToPx0680j_4 : rect.getLeft(), 0.0f, z ? i2 - rect.getLeft() : rect.getLeft() + iMo327roundToPx0680j_4, 0.0f, 10, null);
    }

    public static final Modifier textFieldScroll(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, InterfaceC3588op interfaceC3588op) {
        Modifier verticalScrollLayoutModifier;
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(textFieldScrollerPosition, "scrollerPosition");
        AbstractC4492zt.h(textFieldValue, "textFieldValue");
        AbstractC4492zt.h(visualTransformation, "visualTransformation");
        AbstractC4492zt.h(interfaceC3588op, "textLayoutResultProvider");
        Orientation orientation = textFieldScrollerPosition.getOrientation();
        int iM830getOffsetToFollow5zctL8 = textFieldScrollerPosition.m830getOffsetToFollow5zctL8(textFieldValue.m4922getSelectiond9O1mEE());
        textFieldScrollerPosition.m832setPreviousSelection5zctL8(textFieldValue.m4922getSelectiond9O1mEE());
        TransformedText transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getAnnotatedString());
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(textFieldScrollerPosition, iM830getOffsetToFollow5zctL8, transformedTextFilterWithValidation, interfaceC3588op);
        } else {
            if (i != 2) {
                throw new AD();
            }
            verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(textFieldScrollerPosition, iM830getOffsetToFollow5zctL8, transformedTextFilterWithValidation, interfaceC3588op);
        }
        return ClipKt.clipToBounds(modifier).then(verticalScrollLayoutModifier);
    }

    public static final Modifier textFieldScrollable(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(textFieldScrollerPosition, "scrollerPosition");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1(textFieldScrollerPosition, mutableInteractionSource, z) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(textFieldScrollerPosition, z, mutableInteractionSource));
    }

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z);
    }
}
