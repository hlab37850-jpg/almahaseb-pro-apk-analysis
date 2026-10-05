package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.XS;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, null);

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Alignment $alignment;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ long $offset;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ PopupProperties $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Alignment alignment, long j, InterfaceC3588op interfaceC3588op, PopupProperties popupProperties, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$alignment = alignment;
            this.$offset = j;
            this.$onDismissRequest = interfaceC3588op;
            this.$properties = popupProperties;
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            AndroidPopup_androidKt.m5407PopupK5zGePQ(this.$alignment, this.$offset, this.$onDismissRequest, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ PopupProperties $properties;
        final /* synthetic */ String $testTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PopupLayout popupLayout, InterfaceC3588op interfaceC3588op, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
            super(1);
            this.$popupLayout = popupLayout;
            this.$onDismissRequest = interfaceC3588op;
            this.$properties = popupProperties;
            this.$testTag = str;
            this.$layoutDirection = layoutDirection;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            this.$popupLayout.show();
            this.$popupLayout.updateParameters(this.$onDismissRequest, this.$properties, this.$testTag, this.$layoutDirection);
            final PopupLayout popupLayout = this.$popupLayout;
            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    popupLayout.disposeComposition();
                    popupLayout.dismiss();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ PopupProperties $properties;
        final /* synthetic */ String $testTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(PopupLayout popupLayout, InterfaceC3588op interfaceC3588op, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
            super(0);
            this.$popupLayout = popupLayout;
            this.$onDismissRequest = interfaceC3588op;
            this.$properties = popupProperties;
            this.$testTag = str;
            this.$layoutDirection = layoutDirection;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5408invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5408invoke() {
            this.$popupLayout.updateParameters(this.$onDismissRequest, this.$properties, this.$testTag, this.$layoutDirection);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ PopupPositionProvider $popupPositionProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(PopupLayout popupLayout, PopupPositionProvider popupPositionProvider) {
            super(1);
            this.$popupLayout = popupLayout;
            this.$popupPositionProvider = popupPositionProvider;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            this.$popupLayout.setPositionProvider(this.$popupPositionProvider);
            this.$popupLayout.updatePosition();
            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5", f = "AndroidPopup.android.kt", l = {301}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ PopupLayout $popupLayout;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            public final void invoke(long j) {
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(PopupLayout popupLayout, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$popupLayout = popupLayout;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$popupLayout, interfaceC0793Of);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass5) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0029  */
        /* JADX WARN: Code duplicated, block: B:13:0x0035 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0033 -> B:14:0x0036). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r3.L$0
                dg r1 = (defpackage.InterfaceC2052dg) r1
                defpackage.LL.b(r4)
                goto L36
            L13:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L1b:
                defpackage.LL.b(r4)
                java.lang.Object r4 = r3.L$0
                dg r4 = (defpackage.InterfaceC2052dg) r4
                r1 = r4
            L23:
                boolean r4 = defpackage.AbstractC2133eg.e(r1)
                if (r4 == 0) goto L3c
                androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1 r4 = androidx.compose.ui.window.AndroidPopup_androidKt.AnonymousClass5.AnonymousClass1.INSTANCE
                r3.L$0 = r1
                r3.label = r2
                java.lang.Object r4 = androidx.compose.ui.platform.InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r4, r3)
                if (r4 != r0) goto L36
                return r0
            L36:
                androidx.compose.ui.window.PopupLayout r4 = r3.$popupLayout
                r4.pollForLocationOnScreenChange()
                goto L23
            L3c:
                FW r4 = defpackage.FW.a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ PopupLayout $popupLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(PopupLayout popupLayout) {
            super(1);
            this.$popupLayout = popupLayout;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutCoordinates) obj);
            return FW.a;
        }

        public final void invoke(LayoutCoordinates layoutCoordinates) {
            AbstractC4492zt.h(layoutCoordinates, "childCoordinates");
            LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
            AbstractC4492zt.e(parentLayoutCoordinates);
            this.$popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9, reason: invalid class name */
    public static final class AnonymousClass9 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ PopupPositionProvider $popupPositionProvider;
        final /* synthetic */ PopupProperties $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(PopupPositionProvider popupPositionProvider, InterfaceC3588op interfaceC3588op, PopupProperties popupProperties, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$popupPositionProvider = popupPositionProvider;
            this.$onDismissRequest = interfaceC3588op;
            this.$properties = popupProperties;
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            AndroidPopup_androidKt.Popup(this.$popupPositionProvider, this.$onDismissRequest, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$PopupTestTag$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16721 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ String $tag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16721(String str, InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$tag = str;
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            AndroidPopup_androidKt.PopupTestTag(this.$tag, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16731 implements MeasurePolicy {
        public static final C16731 INSTANCE = new C16731();

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
            int i;
            int i2;
            AbstractC4492zt.h(measureScope, "$this$Layout");
            AbstractC4492zt.h(list, "measurables");
            int size = list.size();
            if (size == 0) {
                return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$SimpleStack$1$measure$1.INSTANCE, 4, null);
            }
            int i3 = 0;
            if (size == 1) {
                Placeable placeableMo4159measureBRTryo0 = list.get(0).mo4159measureBRTryo0(j);
                return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new AndroidPopup_androidKt$SimpleStack$1$measure$2(placeableMo4159measureBRTryo0), 4, null);
            }
            ArrayList arrayList = new ArrayList(list.size());
            int size2 = list.size();
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList.add(list.get(i4).mo4159measureBRTryo0(j));
            }
            int iO = AbstractC1886cc.o(arrayList);
            if (iO >= 0) {
                int iMax = 0;
                int iMax2 = 0;
                while (true) {
                    Placeable placeable = (Placeable) arrayList.get(i3);
                    iMax = Math.max(iMax, placeable.getWidth());
                    iMax2 = Math.max(iMax2, placeable.getHeight());
                    if (i3 == iO) {
                        break;
                    }
                    i3++;
                }
                i = iMax;
                i2 = iMax2;
            } else {
                i = 0;
                i2 = 0;
            }
            return MeasureScope.CC.q(measureScope, i, i2, null, new AndroidPopup_androidKt$SimpleStack$1$measure$3(arrayList), 4, null);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:64:0x0126  */
    /* JADX WARN: Code duplicated, block: B:65:0x016a  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:71:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:75:0x0208  */
    /* JADX WARN: Code duplicated, block: B:77:0x0216  */
    /* JADX WARN: Code duplicated, block: B:80:0x0248  */
    /* JADX WARN: Code duplicated, block: B:85:0x0256  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Popup(PopupPositionProvider popupPositionProvider, InterfaceC3588op interfaceC3588op, PopupProperties popupProperties, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        InterfaceC3588op interfaceC3588op2;
        int i4;
        PopupProperties popupProperties2;
        int i5;
        int i6;
        int i7;
        InterfaceC3588op interfaceC3588op3;
        PopupProperties popupProperties3;
        View view;
        Density density;
        String str;
        LayoutDirection layoutDirection;
        CompositionContext compositionContextRememberCompositionContext;
        State stateRememberUpdatedState;
        UUID uuid;
        Object objRememberedValue;
        LayoutDirection layoutDirection2;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        InterfaceC3588op interfaceC3588op4;
        PopupProperties popupProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(popupPositionProvider, "popupPositionProvider");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-830247068);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                interfaceC3588op2 = interfaceC3588op;
                i3 |= composerStartRestartGroup.changedInstance(interfaceC3588op2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                i7 = i3;
                if ((i7 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    if (i8 != 0) {
                        interfaceC3588op3 = null;
                    } else {
                        interfaceC3588op3 = interfaceC3588op2;
                    }
                    if (i4 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
                    }
                    view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    str = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i7 >> 9) & 14);
                    uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        AbstractC4492zt.g(uuid, "popupId");
                        layoutDirection2 = layoutDirection;
                        PopupLayout popupLayout = new PopupLayout(interfaceC3588op3, popupProperties3, str, view, density, popupPositionProvider, uuid, null, 128, null);
                        popupLayout.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout, stateRememberUpdatedState)));
                        composerStartRestartGroup.updateRememberedValue(popupLayout);
                        objRememberedValue = popupLayout;
                    } else {
                        layoutDirection2 = layoutDirection;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final PopupLayout popupLayout2 = (PopupLayout) objRememberedValue;
                    InterfaceC3588op interfaceC3588op5 = interfaceC3588op3;
                    PopupProperties popupProperties5 = popupProperties3;
                    LayoutDirection layoutDirection3 = layoutDirection2;
                    EffectsKt.DisposableEffect(popupLayout2, new AnonymousClass2(popupLayout2, interfaceC3588op5, popupProperties5, str, layoutDirection3), composerStartRestartGroup, 8);
                    EffectsKt.SideEffect(new AnonymousClass3(popupLayout2, interfaceC3588op5, popupProperties5, str, layoutDirection3), composerStartRestartGroup, 0);
                    EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass4(popupLayout2, popupPositionProvider), composerStartRestartGroup, i7 & 14);
                    EffectsKt.LaunchedEffect(popupLayout2, new AnonymousClass5(popupLayout2, 0), composerStartRestartGroup, 72);
                    Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass7(popupLayout2));
                    final LayoutDirection layoutDirection4 = layoutDirection2;
                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.8
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            AbstractC4492zt.h(measureScope, "$this$Layout");
                            AbstractC4492zt.h(list, "<anonymous parameter 0>");
                            popupLayout2.setParentLayoutDirection(layoutDirection4);
                            return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$Popup$8$measure$1.INSTANCE, 4, null);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                            return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                        }
                    };
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                    constructor = companion.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3588op4 = interfaceC3588op3;
                    popupProperties4 = popupProperties3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    interfaceC3588op4 = interfaceC3588op2;
                    popupProperties4 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider, interfaceC3588op4, popupProperties4, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            popupProperties2 = popupProperties;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    interfaceC3588op3 = null;
                } else {
                    interfaceC3588op3 = interfaceC3588op2;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
                }
                view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                str = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    AbstractC4492zt.g(uuid, "popupId");
                    layoutDirection2 = layoutDirection;
                    PopupLayout popupLayout3 = new PopupLayout(interfaceC3588op3, popupProperties3, str, view, density, popupPositionProvider, uuid, null, 128, null);
                    popupLayout3.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout3, stateRememberUpdatedState)));
                    composerStartRestartGroup.updateRememberedValue(popupLayout3);
                    objRememberedValue = popupLayout3;
                } else {
                    layoutDirection2 = layoutDirection;
                }
                composerStartRestartGroup.endReplaceableGroup();
                final PopupLayout popupLayout4 = (PopupLayout) objRememberedValue;
                InterfaceC3588op interfaceC3588op6 = interfaceC3588op3;
                PopupProperties popupProperties6 = popupProperties3;
                LayoutDirection layoutDirection5 = layoutDirection2;
                EffectsKt.DisposableEffect(popupLayout4, new AnonymousClass2(popupLayout4, interfaceC3588op6, popupProperties6, str, layoutDirection5), composerStartRestartGroup, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout4, interfaceC3588op6, popupProperties6, str, layoutDirection5), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass4(popupLayout4, popupPositionProvider), composerStartRestartGroup, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout4, new AnonymousClass5(popupLayout4, 0), composerStartRestartGroup, 72);
                Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass7(popupLayout4));
                final LayoutDirection layoutDirection6 = layoutDirection2;
                MeasurePolicy measurePolicy2 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.8
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "<anonymous parameter 0>");
                        popupLayout4.setParentLayoutDirection(layoutDirection6);
                        return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$Popup$8$measure$1.INSTANCE, 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                constructor = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned2);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op4 = interfaceC3588op3;
                popupProperties4 = popupProperties3;
            } else {
                if (i8 != 0) {
                    interfaceC3588op3 = null;
                } else {
                    interfaceC3588op3 = interfaceC3588op2;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
                }
                view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                str = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    AbstractC4492zt.g(uuid, "popupId");
                    layoutDirection2 = layoutDirection;
                    PopupLayout popupLayout5 = new PopupLayout(interfaceC3588op3, popupProperties3, str, view, density, popupPositionProvider, uuid, null, 128, null);
                    popupLayout5.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout5, stateRememberUpdatedState)));
                    composerStartRestartGroup.updateRememberedValue(popupLayout5);
                    objRememberedValue = popupLayout5;
                } else {
                    layoutDirection2 = layoutDirection;
                }
                composerStartRestartGroup.endReplaceableGroup();
                final PopupLayout popupLayout6 = (PopupLayout) objRememberedValue;
                InterfaceC3588op interfaceC3588op7 = interfaceC3588op3;
                PopupProperties popupProperties7 = popupProperties3;
                LayoutDirection layoutDirection7 = layoutDirection2;
                EffectsKt.DisposableEffect(popupLayout6, new AnonymousClass2(popupLayout6, interfaceC3588op7, popupProperties7, str, layoutDirection7), composerStartRestartGroup, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout6, interfaceC3588op7, popupProperties7, str, layoutDirection7), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass4(popupLayout6, popupPositionProvider), composerStartRestartGroup, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout6, new AnonymousClass5(popupLayout6, 0), composerStartRestartGroup, 72);
                Modifier modifierOnGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass7(popupLayout6));
                final LayoutDirection layoutDirection8 = layoutDirection2;
                MeasurePolicy measurePolicy3 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.8
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "<anonymous parameter 0>");
                        popupLayout6.setParentLayoutDirection(layoutDirection8);
                        return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$Popup$8$measure$1.INSTANCE, 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                constructor = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy3, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op4 = interfaceC3588op3;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider, interfaceC3588op4, popupProperties4, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        interfaceC3588op2 = interfaceC3588op;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    interfaceC3588op3 = null;
                } else {
                    interfaceC3588op3 = interfaceC3588op2;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
                }
                view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                str = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    AbstractC4492zt.g(uuid, "popupId");
                    layoutDirection2 = layoutDirection;
                    PopupLayout popupLayout7 = new PopupLayout(interfaceC3588op3, popupProperties3, str, view, density, popupPositionProvider, uuid, null, 128, null);
                    popupLayout7.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout7, stateRememberUpdatedState)));
                    composerStartRestartGroup.updateRememberedValue(popupLayout7);
                    objRememberedValue = popupLayout7;
                } else {
                    layoutDirection2 = layoutDirection;
                }
                composerStartRestartGroup.endReplaceableGroup();
                final PopupLayout popupLayout8 = (PopupLayout) objRememberedValue;
                InterfaceC3588op interfaceC3588op8 = interfaceC3588op3;
                PopupProperties popupProperties8 = popupProperties3;
                LayoutDirection layoutDirection9 = layoutDirection2;
                EffectsKt.DisposableEffect(popupLayout8, new AnonymousClass2(popupLayout8, interfaceC3588op8, popupProperties8, str, layoutDirection9), composerStartRestartGroup, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout8, interfaceC3588op8, popupProperties8, str, layoutDirection9), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass4(popupLayout8, popupPositionProvider), composerStartRestartGroup, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout8, new AnonymousClass5(popupLayout8, 0), composerStartRestartGroup, 72);
                Modifier modifierOnGloballyPositioned4 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass7(popupLayout8));
                final LayoutDirection layoutDirection10 = layoutDirection2;
                MeasurePolicy measurePolicy4 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.8
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "<anonymous parameter 0>");
                        popupLayout8.setParentLayoutDirection(layoutDirection10);
                        return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$Popup$8$measure$1.INSTANCE, 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                constructor = companion4.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned4);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy4, companion4.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op4 = interfaceC3588op3;
                popupProperties4 = popupProperties3;
            } else {
                if (i8 != 0) {
                    interfaceC3588op3 = null;
                } else {
                    interfaceC3588op3 = interfaceC3588op2;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
                }
                view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                str = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    AbstractC4492zt.g(uuid, "popupId");
                    layoutDirection2 = layoutDirection;
                    PopupLayout popupLayout9 = new PopupLayout(interfaceC3588op3, popupProperties3, str, view, density, popupPositionProvider, uuid, null, 128, null);
                    popupLayout9.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout9, stateRememberUpdatedState)));
                    composerStartRestartGroup.updateRememberedValue(popupLayout9);
                    objRememberedValue = popupLayout9;
                } else {
                    layoutDirection2 = layoutDirection;
                }
                composerStartRestartGroup.endReplaceableGroup();
                final PopupLayout popupLayout10 = (PopupLayout) objRememberedValue;
                InterfaceC3588op interfaceC3588op9 = interfaceC3588op3;
                PopupProperties popupProperties9 = popupProperties3;
                LayoutDirection layoutDirection11 = layoutDirection2;
                EffectsKt.DisposableEffect(popupLayout10, new AnonymousClass2(popupLayout10, interfaceC3588op9, popupProperties9, str, layoutDirection11), composerStartRestartGroup, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout10, interfaceC3588op9, popupProperties9, str, layoutDirection11), composerStartRestartGroup, 0);
                EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass4(popupLayout10, popupPositionProvider), composerStartRestartGroup, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout10, new AnonymousClass5(popupLayout10, 0), composerStartRestartGroup, 72);
                Modifier modifierOnGloballyPositioned5 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass7(popupLayout10));
                final LayoutDirection layoutDirection12 = layoutDirection2;
                MeasurePolicy measurePolicy5 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.8
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$Layout");
                        AbstractC4492zt.h(list, "<anonymous parameter 0>");
                        popupLayout10.setParentLayoutDirection(layoutDirection12);
                        return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$Popup$8$measure$1.INSTANCE, 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                        return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                    }
                };
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                constructor = companion5.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned5);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy5, companion5.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op4 = interfaceC3588op3;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider, interfaceC3588op4, popupProperties4, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        popupProperties2 = popupProperties;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        i7 = i3;
        if ((i7 & 5851) == 1170) {
            if (i8 != 0) {
                interfaceC3588op3 = null;
            } else {
                interfaceC3588op3 = interfaceC3588op2;
            }
            if (i4 != 0) {
                popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
            }
            view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            str = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i7 >> 9) & 14);
            uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                AbstractC4492zt.g(uuid, "popupId");
                layoutDirection2 = layoutDirection;
                PopupLayout popupLayout11 = new PopupLayout(interfaceC3588op3, popupProperties3, str, view, density, popupPositionProvider, uuid, null, 128, null);
                popupLayout11.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout11, stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(popupLayout11);
                objRememberedValue = popupLayout11;
            } else {
                layoutDirection2 = layoutDirection;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final PopupLayout popupLayout12 = (PopupLayout) objRememberedValue;
            InterfaceC3588op interfaceC3588op10 = interfaceC3588op3;
            PopupProperties popupProperties10 = popupProperties3;
            LayoutDirection layoutDirection13 = layoutDirection2;
            EffectsKt.DisposableEffect(popupLayout12, new AnonymousClass2(popupLayout12, interfaceC3588op10, popupProperties10, str, layoutDirection13), composerStartRestartGroup, 8);
            EffectsKt.SideEffect(new AnonymousClass3(popupLayout12, interfaceC3588op10, popupProperties10, str, layoutDirection13), composerStartRestartGroup, 0);
            EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass4(popupLayout12, popupPositionProvider), composerStartRestartGroup, i7 & 14);
            EffectsKt.LaunchedEffect(popupLayout12, new AnonymousClass5(popupLayout12, 0), composerStartRestartGroup, 72);
            Modifier modifierOnGloballyPositioned6 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass7(popupLayout12));
            final LayoutDirection layoutDirection14 = layoutDirection2;
            MeasurePolicy measurePolicy6 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.8
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "<anonymous parameter 0>");
                    popupLayout12.setParentLayoutDirection(layoutDirection14);
                    return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$Popup$8$measure$1.INSTANCE, 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion6 = ComposeUiNode.Companion;
            constructor = companion6.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned6);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy6, companion6.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion6.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC3588op4 = interfaceC3588op3;
            popupProperties4 = popupProperties3;
        } else {
            if (i8 != 0) {
                interfaceC3588op3 = null;
            } else {
                interfaceC3588op3 = interfaceC3588op2;
            }
            if (i4 != 0) {
                popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:221)");
            }
            view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            str = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i7 >> 9) & 14);
            uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                AbstractC4492zt.g(uuid, "popupId");
                layoutDirection2 = layoutDirection;
                PopupLayout popupLayout13 = new PopupLayout(interfaceC3588op3, popupProperties3, str, view, density, popupPositionProvider, uuid, null, 128, null);
                popupLayout13.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout13, stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(popupLayout13);
                objRememberedValue = popupLayout13;
            } else {
                layoutDirection2 = layoutDirection;
            }
            composerStartRestartGroup.endReplaceableGroup();
            final PopupLayout popupLayout14 = (PopupLayout) objRememberedValue;
            InterfaceC3588op interfaceC3588op11 = interfaceC3588op3;
            PopupProperties popupProperties11 = popupProperties3;
            LayoutDirection layoutDirection15 = layoutDirection2;
            EffectsKt.DisposableEffect(popupLayout14, new AnonymousClass2(popupLayout14, interfaceC3588op11, popupProperties11, str, layoutDirection15), composerStartRestartGroup, 8);
            EffectsKt.SideEffect(new AnonymousClass3(popupLayout14, interfaceC3588op11, popupProperties11, str, layoutDirection15), composerStartRestartGroup, 0);
            EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass4(popupLayout14, popupPositionProvider), composerStartRestartGroup, i7 & 14);
            EffectsKt.LaunchedEffect(popupLayout14, new AnonymousClass5(popupLayout14, 0), composerStartRestartGroup, 72);
            Modifier modifierOnGloballyPositioned7 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass7(popupLayout14));
            final LayoutDirection layoutDirection16 = layoutDirection2;
            MeasurePolicy measurePolicy7 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.8
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "<anonymous parameter 0>");
                    popupLayout14.setParentLayoutDirection(layoutDirection16);
                    return MeasureScope.CC.q(measureScope, 0, 0, null, AndroidPopup_androidKt$Popup$8$measure$1.INSTANCE, 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i9);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i9) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i9);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
            constructor = companion7.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned7);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy7, companion7.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion7.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC3588op4 = interfaceC3588op3;
            popupProperties4 = popupProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider, interfaceC3588op4, popupProperties4, interfaceC0526Fp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0526Fp Popup$lambda$1(State<? extends InterfaceC0526Fp> state) {
        return state.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:77:0x0107  */
    /* JADX WARN: Code duplicated, block: B:79:0x010f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0133  */
    /* JADX WARN: Code duplicated, block: B:87:0x0141  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Popup-K5zGePQ, reason: not valid java name */
    public static final void m5407PopupK5zGePQ(Alignment alignment, long j, InterfaceC3588op interfaceC3588op, PopupProperties popupProperties, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        Alignment alignment2;
        int i3;
        long jIntOffset;
        int i4;
        InterfaceC3588op interfaceC3588op2;
        int i5;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        int i8;
        Alignment topStart;
        boolean zChanged;
        Object objRememberedValue;
        InterfaceC3588op interfaceC3588op3;
        PopupProperties popupProperties3;
        Alignment alignment3;
        long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(295309329);
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            alignment2 = alignment;
        } else if ((i & 14) == 0) {
            alignment2 = alignment;
            i3 = (composerStartRestartGroup.changed(alignment2) ? 4 : 2) | i;
        } else {
            alignment2 = alignment;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 112) == 0) {
                jIntOffset = j;
                i3 |= composerStartRestartGroup.changed(jIntOffset) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    interfaceC3588op2 = interfaceC3588op;
                    if (composerStartRestartGroup.changedInstance(interfaceC3588op2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        popupProperties2 = popupProperties;
                        if (composerStartRestartGroup.changed(popupProperties2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i2 & 16) != 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        if (i9 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        }
                        if (i4 != 0) {
                            interfaceC3588op2 = null;
                        }
                        if (i6 != 0) {
                            popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                        }
                        IntOffset intOffsetM5269boximpl = IntOffset.m5269boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        long j3 = jIntOffset;
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3588op3 = interfaceC3588op2;
                        popupProperties3 = popupProperties2;
                        alignment3 = topStart;
                        j2 = j3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        alignment3 = alignment2;
                        j2 = jIntOffset;
                        interfaceC3588op3 = interfaceC3588op2;
                        popupProperties3 = popupProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
                }
                i3 |= 3072;
                popupProperties2 = popupProperties;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    }
                    if (i4 != 0) {
                        interfaceC3588op2 = null;
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                    }
                    IntOffset intOffsetM5269boximpl2 = IntOffset.m5269boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl2) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    long j4 = jIntOffset;
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    popupProperties3 = popupProperties2;
                    alignment3 = topStart;
                    j2 = j4;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    }
                    if (i4 != 0) {
                        interfaceC3588op2 = null;
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                    }
                    IntOffset intOffsetM5269boximpl3 = IntOffset.m5269boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl3) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    long j5 = jIntOffset;
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    popupProperties3 = popupProperties2;
                    alignment3 = topStart;
                    j2 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            interfaceC3588op2 = interfaceC3588op;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    }
                    if (i4 != 0) {
                        interfaceC3588op2 = null;
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                    }
                    IntOffset intOffsetM5269boximpl4 = IntOffset.m5269boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl4) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    long j6 = jIntOffset;
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    popupProperties3 = popupProperties2;
                    alignment3 = topStart;
                    j2 = j6;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    }
                    if (i4 != 0) {
                        interfaceC3588op2 = null;
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                    }
                    IntOffset intOffsetM5269boximpl5 = IntOffset.m5269boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl5) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    long j7 = jIntOffset;
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    popupProperties3 = popupProperties2;
                    alignment3 = topStart;
                    j2 = j7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            popupProperties2 = popupProperties;
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((46811 & i3) == 9362) {
                if (i9 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                }
                if (i4 != 0) {
                    interfaceC3588op2 = null;
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                }
                IntOffset intOffsetM5269boximpl6 = IntOffset.m5269boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl6) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                long j8 = jIntOffset;
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op3 = interfaceC3588op2;
                popupProperties3 = popupProperties2;
                alignment3 = topStart;
                j2 = j8;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                }
                if (i4 != 0) {
                    interfaceC3588op2 = null;
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                }
                IntOffset intOffsetM5269boximpl7 = IntOffset.m5269boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl7) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                long j9 = jIntOffset;
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op3 = interfaceC3588op2;
                popupProperties3 = popupProperties2;
                alignment3 = topStart;
                j2 = j9;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        jIntOffset = j;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC3588op2 = interfaceC3588op;
                if (composerStartRestartGroup.changedInstance(interfaceC3588op2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    }
                    if (i4 != 0) {
                        interfaceC3588op2 = null;
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                    }
                    IntOffset intOffsetM5269boximpl8 = IntOffset.m5269boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl8) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    long j10 = jIntOffset;
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    popupProperties3 = popupProperties2;
                    alignment3 = topStart;
                    j2 = j10;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    }
                    if (i4 != 0) {
                        interfaceC3588op2 = null;
                    }
                    if (i6 != 0) {
                        popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                    }
                    IntOffset intOffsetM5269boximpl9 = IntOffset.m5269boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl9) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    long j11 = jIntOffset;
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3588op3 = interfaceC3588op2;
                    popupProperties3 = popupProperties2;
                    alignment3 = topStart;
                    j2 = j11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            popupProperties2 = popupProperties;
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((46811 & i3) == 9362) {
                if (i9 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                }
                if (i4 != 0) {
                    interfaceC3588op2 = null;
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                }
                IntOffset intOffsetM5269boximpl10 = IntOffset.m5269boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl10) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                long j12 = jIntOffset;
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op3 = interfaceC3588op2;
                popupProperties3 = popupProperties2;
                alignment3 = topStart;
                j2 = j12;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                }
                if (i4 != 0) {
                    interfaceC3588op2 = null;
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                }
                IntOffset intOffsetM5269boximpl11 = IntOffset.m5269boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl11) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                long j13 = jIntOffset;
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op3 = interfaceC3588op2;
                popupProperties3 = popupProperties2;
                alignment3 = topStart;
                j2 = j13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        interfaceC3588op2 = interfaceC3588op;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((46811 & i3) == 9362) {
                if (i9 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                }
                if (i4 != 0) {
                    interfaceC3588op2 = null;
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                }
                IntOffset intOffsetM5269boximpl12 = IntOffset.m5269boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl12) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                long j14 = jIntOffset;
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op3 = interfaceC3588op2;
                popupProperties3 = popupProperties2;
                alignment3 = topStart;
                j2 = j14;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                }
                if (i4 != 0) {
                    interfaceC3588op2 = null;
                }
                if (i6 != 0) {
                    popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
                }
                IntOffset intOffsetM5269boximpl13 = IntOffset.m5269boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl13) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                long j15 = jIntOffset;
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3588op3 = interfaceC3588op2;
                popupProperties3 = popupProperties2;
                alignment3 = topStart;
                j2 = j15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
        }
        i3 |= 3072;
        popupProperties2 = popupProperties;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        if ((46811 & i3) == 9362) {
            if (i9 != 0) {
                topStart = Alignment.Companion.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i10 != 0) {
                jIntOffset = IntOffsetKt.IntOffset(0, 0);
            }
            if (i4 != 0) {
                interfaceC3588op2 = null;
            }
            if (i6 != 0) {
                popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
            }
            IntOffset intOffsetM5269boximpl14 = IntOffset.m5269boximpl(jIntOffset);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl14) | composerStartRestartGroup.changed(topStart);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            long j16 = jIntOffset;
            Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC3588op3 = interfaceC3588op2;
            popupProperties3 = popupProperties2;
            alignment3 = topStart;
            j2 = j16;
        } else {
            if (i9 != 0) {
                topStart = Alignment.Companion.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i10 != 0) {
                jIntOffset = IntOffsetKt.IntOffset(0, 0);
            }
            if (i4 != 0) {
                interfaceC3588op2 = null;
            }
            if (i6 != 0) {
                popupProperties2 = new PopupProperties(false, false, false, null, false, false, 63, null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:186)");
            }
            IntOffset intOffsetM5269boximpl15 = IntOffset.m5269boximpl(jIntOffset);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(intOffsetM5269boximpl15) | composerStartRestartGroup.changed(topStart);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            long j17 = jIntOffset;
            Popup((AlignmentOffsetPositionProvider) objRememberedValue, interfaceC3588op2, popupProperties2, interfaceC0526Fp, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC3588op3 = interfaceC3588op2;
            popupProperties3 = popupProperties2;
            alignment3 = topStart;
            j2 = j17;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(alignment3, j2, interfaceC3588op3, popupProperties3, interfaceC0526Fp, i, i2));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void PopupTestTag(String str, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(str, "tag");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-498879600);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:331)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalPopupTestTag.provides(str)}, interfaceC0526Fp, composerStartRestartGroup, (i2 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C16721(str, interfaceC0526Fp, i));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    private static final void SimpleStack(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        composer.startReplaceableGroup(1406149896);
        C16731 c16731 = C16731.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int i2 = (((((i << 3) & 112) | ((i >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
        Updater.m2668setimpl(composerM2661constructorimpl, c16731, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final boolean isFlagSecureEnabled(View view) {
        AbstractC4492zt.h(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    public static final boolean isPopupLayout(View view, String str) {
        AbstractC4492zt.h(view, "view");
        return (view instanceof PopupLayout) && (str == null || AbstractC4492zt.d(str, ((PopupLayout) view).getTestTag()));
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
