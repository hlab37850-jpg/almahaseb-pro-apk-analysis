package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldCursorKt {
    private static final AnimationSpec<Float> cursorAnimationSpec = AnimationSpecKt.m96infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(TextFieldCursorKt$cursorAnimationSpec$1.INSTANCE), null, 0, 6, null);
    private static final float DefaultCursorThickness = Dp.m5160constructorimpl(2);

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Brush $cursorBrush;
        final /* synthetic */ OffsetMapping $offsetMapping;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ TextFieldValue $value;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1", f = "TextFieldCursor.kt", l = {51}, m = "invokeSuspend")
        public static final class C00541 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ Animatable<Float, AnimationVector1D> $cursorAlpha;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1$1", f = "TextFieldCursor.kt", l = {53, 55}, m = "invokeSuspend")
            public static final class C00551 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ Animatable<Float, AnimationVector1D> $cursorAlpha;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00551(Animatable<Float, AnimationVector1D> animatable, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$cursorAlpha = animatable;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C00551(this.$cursorAlpha, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00551) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            LL.b(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj);
                        }
                        return FW.a;
                    }
                    LL.b(obj);
                    Animatable<Float, AnimationVector1D> animatable = this.$cursorAlpha;
                    Float fB = E8.b(1.0f);
                    this.label = 1;
                    if (animatable.snapTo(fB, this) == objD) {
                        return objD;
                    }
                    Animatable<Float, AnimationVector1D> animatable2 = this.$cursorAlpha;
                    Float fB2 = E8.b(0.0f);
                    AnimationSpec animationSpec = TextFieldCursorKt.cursorAnimationSpec;
                    this.label = 2;
                    if (Animatable.animateTo$default(animatable2, fB2, animationSpec, null, null, this, 12, null) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00541(Animatable<Float, AnimationVector1D> animatable, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$cursorAlpha = animatable;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C00541(this.$cursorAlpha, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C00541) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    FixedMotionDurationScale fixedMotionDurationScale = FixedMotionDurationScale.INSTANCE;
                    C00551 c00551 = new C00551(this.$cursorAlpha, null);
                    this.label = 1;
                    if (M8.g(fixedMotionDurationScale, c00551, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ Animatable<Float, AnimationVector1D> $cursorAlpha;
            final /* synthetic */ Brush $cursorBrush;
            final /* synthetic */ OffsetMapping $offsetMapping;
            final /* synthetic */ TextFieldState $state;
            final /* synthetic */ TextFieldValue $value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Animatable<Float, AnimationVector1D> animatable, OffsetMapping offsetMapping, TextFieldValue textFieldValue, TextFieldState textFieldState, Brush brush) {
                super(1);
                this.$cursorAlpha = animatable;
                this.$offsetMapping = offsetMapping;
                this.$value = textFieldValue;
                this.$state = textFieldState;
                this.$cursorBrush = brush;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return FW.a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                Rect rect;
                TextLayoutResult value;
                AbstractC4492zt.h(contentDrawScope, "$this$drawWithContent");
                contentDrawScope.drawContent();
                float fK = AbstractC3871sJ.k(this.$cursorAlpha.getValue().floatValue(), 0.0f, 1.0f);
                if (fK == 0.0f) {
                    return;
                }
                int iOriginalToTransformed = this.$offsetMapping.originalToTransformed(TextRange.m4705getStartimpl(this.$value.m4922getSelectiond9O1mEE()));
                TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
                if (layoutResult == null || (value = layoutResult.getValue()) == null || (rect = value.getCursorRect(iOriginalToTransformed)) == null) {
                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                }
                float fMo333toPx0680j_4 = contentDrawScope.mo333toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                float f = fMo333toPx0680j_4 / 2;
                float f2 = AbstractC3871sJ.f(rect.getLeft() + f, Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - f);
                AbstractC3255kk.B(contentDrawScope, this.$cursorBrush, OffsetKt.Offset(f2, rect.getTop()), OffsetKt.Offset(f2, rect.getBottom()), fMo333toPx0680j_4, 0, null, fK, null, 0, 432, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Brush brush, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
            super(3);
            this.$cursorBrush = brush;
            this.$state = textFieldState;
            this.$value = textFieldValue;
            this.$offsetMapping = offsetMapping;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            Modifier modifierDrawWithContent;
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(1634330012);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1634330012, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:44)");
            }
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Animatable animatable = (Animatable) objRememberedValue;
            Brush brush = this.$cursorBrush;
            boolean z = ((brush instanceof SolidColor) && ((SolidColor) brush).m3338getValue0d7_KjU() == Color.Companion.m3068getUnspecified0d7_KjU()) ? false : true;
            if (this.$state.getHasFocus() && TextRange.m4699getCollapsedimpl(this.$value.m4922getSelectiond9O1mEE()) && z) {
                EffectsKt.LaunchedEffect(this.$value.getAnnotatedString(), TextRange.m4693boximpl(this.$value.m4922getSelectiond9O1mEE()), new C00541(animatable, null), composer, 512);
                modifierDrawWithContent = DrawModifierKt.drawWithContent(modifier, new AnonymousClass2(animatable, this.$offsetMapping, this.$value, this.$state, this.$cursorBrush));
            } else {
                modifierDrawWithContent = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierDrawWithContent;
        }
    }

    public static final Modifier cursor(Modifier modifier, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Brush brush, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(textFieldState, "state");
        AbstractC4492zt.h(textFieldValue, "value");
        AbstractC4492zt.h(offsetMapping, "offsetMapping");
        AbstractC4492zt.h(brush, "cursorBrush");
        return z ? ComposedModifierKt.composed$default(modifier, null, new AnonymousClass1(brush, textFieldState, textFieldValue, offsetMapping), 1, null) : modifier;
    }

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }
}
