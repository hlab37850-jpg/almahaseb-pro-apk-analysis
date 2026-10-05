package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentKt {

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
            AbstractC4492zt.h(animatedContentTransitionScope, "$this$null");
            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m47scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final S invoke(S s) {
            return s;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0578Hp $content;
        final /* synthetic */ Alignment $contentAlignment;
        final /* synthetic */ InterfaceC3750qp $contentKey;
        final /* synthetic */ String $label;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ S $targetState;
        final /* synthetic */ InterfaceC3750qp $transitionSpec;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(S s, Modifier modifier, InterfaceC3750qp interfaceC3750qp, Alignment alignment, String str, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, int i, int i2) {
            super(2);
            this.$targetState = s;
            this.$modifier = modifier;
            this.$transitionSpec = interfaceC3750qp;
            this.$contentAlignment = alignment;
            this.$label = str;
            this.$contentKey = interfaceC3750qp2;
            this.$content = interfaceC0578Hp;
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
            AnimatedContentKt.AnimatedContent(this.$targetState, this.$modifier, this.$transitionSpec, this.$contentAlignment, this.$label, this.$contentKey, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
            AbstractC4492zt.h(animatedContentTransitionScope, "$this$null");
            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m47scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final S invoke(S s) {
            return s;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$9, reason: invalid class name */
    public static final class AnonymousClass9 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0578Hp $content;
        final /* synthetic */ Alignment $contentAlignment;
        final /* synthetic */ InterfaceC3750qp $contentKey;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Transition<S> $this_AnimatedContent;
        final /* synthetic */ InterfaceC3750qp $transitionSpec;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(Transition<S> transition, Modifier modifier, InterfaceC3750qp interfaceC3750qp, Alignment alignment, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, int i, int i2) {
            super(2);
            this.$this_AnimatedContent = transition;
            this.$modifier = modifier;
            this.$transitionSpec = interfaceC3750qp;
            this.$contentAlignment = alignment;
            this.$contentKey = interfaceC3750qp2;
            this.$content = interfaceC0578Hp;
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
            AnimatedContentKt.AnimatedContent(this.$this_AnimatedContent, this.$modifier, this.$transitionSpec, this.$contentAlignment, this.$contentKey, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$SizeTransform$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12631 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C12631 INSTANCE = new C12631();

        public C12631() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return m16invokeTemP2vQ(((IntSize) obj).m5324unboximpl(), ((IntSize) obj2).m5324unboximpl());
        }

        /* JADX INFO: renamed from: invoke-TemP2vQ, reason: not valid java name */
        public final SpringSpec<IntSize> m16invokeTemP2vQ(long j, long j2) {
            return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0156  */
    /* JADX WARN: Code duplicated, block: B:107:0x0167  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0110  */
    /* JADX WARN: Code duplicated, block: B:95:0x0115  */
    /* JADX WARN: Code duplicated, block: B:96:0x0119  */
    /* JADX WARN: Code duplicated, block: B:99:0x0120  */
    @Composable
    public static final <S> void AnimatedContent(S s, Modifier modifier, InterfaceC3750qp interfaceC3750qp, Alignment alignment, String str, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        InterfaceC3750qp interfaceC3750qp3;
        int i5;
        int i6;
        Alignment alignment2;
        int i7;
        int i8;
        String str2;
        int i9;
        int i10;
        InterfaceC3750qp interfaceC3750qp4;
        int i11;
        int i12;
        Modifier modifier2;
        InterfaceC3750qp interfaceC3750qp5;
        Alignment topStart;
        InterfaceC3750qp interfaceC3750qp6;
        Modifier modifier3;
        String str3;
        InterfaceC3750qp interfaceC3750qp7;
        InterfaceC3750qp interfaceC3750qp8;
        Alignment alignment3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0578Hp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(2132720749);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(s) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    interfaceC3750qp3 = interfaceC3750qp;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        alignment2 = alignment;
                        if (composerStartRestartGroup.changed(alignment2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 57344) == 0) {
                            str2 = str;
                            if (composerStartRestartGroup.changed(str2)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            interfaceC3750qp4 = interfaceC3750qp2;
                        } else {
                            interfaceC3750qp4 = interfaceC3750qp2;
                            if ((i & 458752) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                                    i11 = 131072;
                                } else {
                                    i11 = 65536;
                                }
                                i3 |= i11;
                            }
                        }
                        if ((i2 & 64) != 0) {
                            if ((i & 3670016) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                                    i12 = 1048576;
                                } else {
                                    i12 = 524288;
                                }
                            }
                            if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                                } else {
                                    interfaceC3750qp5 = interfaceC3750qp3;
                                }
                                if (i6 != 0) {
                                    topStart = Alignment.Companion.getTopStart();
                                } else {
                                    topStart = alignment2;
                                }
                                if (i8 != 0) {
                                    str2 = "AnimatedContent";
                                }
                                if (i10 != 0) {
                                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp6 = interfaceC3750qp4;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                                }
                                Transition transitionUpdateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                                int i14 = i3 & 8176;
                                int i15 = i3 >> 3;
                                AnimatedContent(transitionUpdateTransition, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i14 | (57344 & i15) | (i15 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                str3 = str2;
                                interfaceC3750qp7 = interfaceC3750qp6;
                                interfaceC3750qp8 = interfaceC3750qp5;
                                alignment3 = topStart;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                interfaceC3750qp8 = interfaceC3750qp3;
                                alignment3 = alignment2;
                                interfaceC3750qp7 = interfaceC3750qp4;
                                str3 = str2;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                        }
                        i12 = 1572864;
                        i3 |= i12;
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition2 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i16 = i3 & 8176;
                            int i17 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition2, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i16 | (57344 & i17) | (i17 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition3 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i18 = i3 & 8176;
                            int i19 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition3, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i18 | (57344 & i19) | (i19 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                    }
                    i3 |= 24576;
                    str2 = str;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interfaceC3750qp4 = interfaceC3750qp2;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition4 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i110 = i3 & 8176;
                            int i111 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition4, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i110 | (57344 & i111) | (i111 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition5 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i112 = i3 & 8176;
                            int i113 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition5, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i112 | (57344 & i113) | (i113 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                    }
                    i12 = 1572864;
                    i3 |= i12;
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition6 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i114 = i3 & 8176;
                        int i115 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition6, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i114 | (57344 & i115) | (i115 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition7 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i116 = i3 & 8176;
                        int i117 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition7, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i116 | (57344 & i117) | (i117 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i3 |= 3072;
                alignment2 = alignment;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interfaceC3750qp4 = interfaceC3750qp2;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition8 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i118 = i3 & 8176;
                            int i119 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition8, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i118 | (57344 & i119) | (i119 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition9 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i1110 = i3 & 8176;
                            int i1111 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition9, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1110 | (57344 & i1111) | (i1111 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                    }
                    i12 = 1572864;
                    i3 |= i12;
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition10 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1112 = i3 & 8176;
                        int i1113 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition10, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1112 | (57344 & i1113) | (i1113 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition11 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1114 = i3 & 8176;
                        int i1115 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition11, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1114 | (57344 & i1115) | (i1115 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i3 |= 24576;
                str2 = str;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition12 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1116 = i3 & 8176;
                        int i1117 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition12, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1116 | (57344 & i1117) | (i1117 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition13 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1118 = i3 & 8176;
                        int i1119 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition13, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1118 | (57344 & i1119) | (i1119 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i12 = 1572864;
                i3 |= i12;
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition14 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i11110 = i3 & 8176;
                    int i11111 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition14, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11110 | (57344 & i11111) | (i11111 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition15 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i11112 = i3 & 8176;
                    int i11113 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition15, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11112 | (57344 & i11113) | (i11113 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 384;
            interfaceC3750qp3 = interfaceC3750qp;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    alignment2 = alignment;
                    if (composerStartRestartGroup.changed(alignment2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interfaceC3750qp4 = interfaceC3750qp2;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition16 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i11114 = i3 & 8176;
                            int i11115 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition16, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11114 | (57344 & i11115) | (i11115 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition17 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i11116 = i3 & 8176;
                            int i11117 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition17, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11116 | (57344 & i11117) | (i11117 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                    }
                    i12 = 1572864;
                    i3 |= i12;
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition18 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i11118 = i3 & 8176;
                        int i11119 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition18, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11118 | (57344 & i11119) | (i11119 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition19 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111110 = i3 & 8176;
                        int i111111 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition19, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111110 | (57344 & i111111) | (i111111 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i3 |= 24576;
                str2 = str;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition110 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111112 = i3 & 8176;
                        int i111113 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition110, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111112 | (57344 & i111113) | (i111113 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition111 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111114 = i3 & 8176;
                        int i111115 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition111, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111114 | (57344 & i111115) | (i111115 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i12 = 1572864;
                i3 |= i12;
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition112 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i111116 = i3 & 8176;
                    int i111117 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition112, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111116 | (57344 & i111117) | (i111117 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition113 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i111118 = i3 & 8176;
                    int i111119 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition113, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111118 | (57344 & i111119) | (i111119 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 3072;
            alignment2 = alignment;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition114 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1111110 = i3 & 8176;
                        int i1111111 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition114, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111110 | (57344 & i1111111) | (i1111111 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition115 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1111112 = i3 & 8176;
                        int i1111113 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition115, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111112 | (57344 & i1111113) | (i1111113 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i12 = 1572864;
                i3 |= i12;
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition116 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111114 = i3 & 8176;
                    int i1111115 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition116, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111114 | (57344 & i1111115) | (i1111115 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition117 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111116 = i3 & 8176;
                    int i1111117 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition117, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111116 | (57344 & i1111117) | (i1111117 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 24576;
            str2 = str;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC3750qp4 = interfaceC3750qp2;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition118 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111118 = i3 & 8176;
                    int i1111119 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition118, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111118 | (57344 & i1111119) | (i1111119 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition119 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i11111110 = i3 & 8176;
                    int i11111111 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition119, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111110 | (57344 & i11111111) | (i11111111 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i12 = 1572864;
            i3 |= i12;
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition1110 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i11111112 = i3 & 8176;
                int i11111113 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition1110, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111112 | (57344 & i11111113) | (i11111113 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition1111 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i11111114 = i3 & 8176;
                int i11111115 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition1111, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111114 | (57344 & i11111115) | (i11111115 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC3750qp3 = interfaceC3750qp;
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    alignment2 = alignment;
                    if (composerStartRestartGroup.changed(alignment2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interfaceC3750qp4 = interfaceC3750qp2;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i2 & 64) != 0) {
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                        }
                        if ((i3 & 2995931) == 599186) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition1112 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i11111116 = i3 & 8176;
                            int i11111117 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition1112, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111116 | (57344 & i11111117) | (i11111117 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp5 = interfaceC3750qp3;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i8 != 0) {
                                str2 = "AnimatedContent";
                            }
                            if (i10 != 0) {
                                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp6 = interfaceC3750qp4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                            }
                            Transition transitionUpdateTransition1113 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            int i11111118 = i3 & 8176;
                            int i11111119 = i3 >> 3;
                            AnimatedContent(transitionUpdateTransition1113, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111118 | (57344 & i11111119) | (i11111119 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            str3 = str2;
                            interfaceC3750qp7 = interfaceC3750qp6;
                            interfaceC3750qp8 = interfaceC3750qp5;
                            alignment3 = topStart;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                    }
                    i12 = 1572864;
                    i3 |= i12;
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition1114 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111111110 = i3 & 8176;
                        int i111111111 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition1114, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111110 | (57344 & i111111111) | (i111111111 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition1115 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111111112 = i3 & 8176;
                        int i111111113 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition1115, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111112 | (57344 & i111111113) | (i111111113 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i3 |= 24576;
                str2 = str;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition1116 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111111114 = i3 & 8176;
                        int i111111115 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition1116, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111114 | (57344 & i111111115) | (i111111115 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition1117 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111111116 = i3 & 8176;
                        int i111111117 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition1117, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111116 | (57344 & i111111117) | (i111111117 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i12 = 1572864;
                i3 |= i12;
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition1118 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i111111118 = i3 & 8176;
                    int i111111119 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition1118, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111118 | (57344 & i111111119) | (i111111119 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition1119 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111111110 = i3 & 8176;
                    int i1111111111 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition1119, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111110 | (57344 & i1111111111) | (i1111111111 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 3072;
            alignment2 = alignment;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition11110 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1111111112 = i3 & 8176;
                        int i1111111113 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition11110, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111112 | (57344 & i1111111113) | (i1111111113 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition11111 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i1111111114 = i3 & 8176;
                        int i1111111115 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition11111, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111114 | (57344 & i1111111115) | (i1111111115 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i12 = 1572864;
                i3 |= i12;
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition11112 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111111116 = i3 & 8176;
                    int i1111111117 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition11112, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111116 | (57344 & i1111111117) | (i1111111117 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition11113 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111111118 = i3 & 8176;
                    int i1111111119 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition11113, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111118 | (57344 & i1111111119) | (i1111111119 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 24576;
            str2 = str;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC3750qp4 = interfaceC3750qp2;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition11114 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i11111111110 = i3 & 8176;
                    int i11111111111 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition11114, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111110 | (57344 & i11111111111) | (i11111111111 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition11115 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i11111111112 = i3 & 8176;
                    int i11111111113 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition11115, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111112 | (57344 & i11111111113) | (i11111111113 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i12 = 1572864;
            i3 |= i12;
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition11116 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i11111111114 = i3 & 8176;
                int i11111111115 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition11116, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111114 | (57344 & i11111111115) | (i11111111115 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition11117 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i11111111116 = i3 & 8176;
                int i11111111117 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition11117, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111116 | (57344 & i11111111117) | (i11111111117 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i3 |= 384;
        interfaceC3750qp3 = interfaceC3750qp;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                alignment2 = alignment;
                if (composerStartRestartGroup.changed(alignment2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i2 & 64) != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition11118 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i11111111118 = i3 & 8176;
                        int i11111111119 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition11118, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111118 | (57344 & i11111111119) | (i11111111119 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp5 = interfaceC3750qp3;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i8 != 0) {
                            str2 = "AnimatedContent";
                        }
                        if (i10 != 0) {
                            interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp6 = interfaceC3750qp4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                        }
                        Transition transitionUpdateTransition11119 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        int i111111111110 = i3 & 8176;
                        int i111111111111 = i3 >> 3;
                        AnimatedContent(transitionUpdateTransition11119, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111111110 | (57344 & i111111111111) | (i111111111111 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        str3 = str2;
                        interfaceC3750qp7 = interfaceC3750qp6;
                        interfaceC3750qp8 = interfaceC3750qp5;
                        alignment3 = topStart;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i12 = 1572864;
                i3 |= i12;
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition111110 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i111111111112 = i3 & 8176;
                    int i111111111113 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition111110, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111111112 | (57344 & i111111111113) | (i111111111113 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition111111 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i111111111114 = i3 & 8176;
                    int i111111111115 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition111111, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111111114 | (57344 & i111111111115) | (i111111111115 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 24576;
            str2 = str;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC3750qp4 = interfaceC3750qp2;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition111112 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i111111111116 = i3 & 8176;
                    int i111111111117 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition111112, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111111116 | (57344 & i111111111117) | (i111111111117 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition111113 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i111111111118 = i3 & 8176;
                    int i111111111119 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition111113, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i111111111118 | (57344 & i111111111119) | (i111111111119 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i12 = 1572864;
            i3 |= i12;
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition111114 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i1111111111110 = i3 & 8176;
                int i1111111111111 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition111114, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111111110 | (57344 & i1111111111111) | (i1111111111111 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition111115 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i1111111111112 = i3 & 8176;
                int i1111111111113 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition111115, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111111112 | (57344 & i1111111111113) | (i1111111111113 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i3 |= 3072;
        alignment2 = alignment;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 57344) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC3750qp4 = interfaceC3750qp2;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i2 & 64) != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                }
                if ((i3 & 2995931) == 599186) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition111116 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111111111114 = i3 & 8176;
                    int i1111111111115 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition111116, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111111114 | (57344 & i1111111111115) | (i1111111111115 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp5 = interfaceC3750qp3;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i8 != 0) {
                        str2 = "AnimatedContent";
                    }
                    if (i10 != 0) {
                        interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp6 = interfaceC3750qp4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                    }
                    Transition transitionUpdateTransition111117 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    int i1111111111116 = i3 & 8176;
                    int i1111111111117 = i3 >> 3;
                    AnimatedContent(transitionUpdateTransition111117, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111111116 | (57344 & i1111111111117) | (i1111111111117 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    interfaceC3750qp7 = interfaceC3750qp6;
                    interfaceC3750qp8 = interfaceC3750qp5;
                    alignment3 = topStart;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i12 = 1572864;
            i3 |= i12;
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition111118 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i1111111111118 = i3 & 8176;
                int i1111111111119 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition111118, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i1111111111118 | (57344 & i1111111111119) | (i1111111111119 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition111119 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i11111111111110 = i3 & 8176;
                int i11111111111111 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition111119, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111111110 | (57344 & i11111111111111) | (i11111111111111 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i3 |= 24576;
        str2 = str;
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC3750qp4 = interfaceC3750qp2;
        } else {
            interfaceC3750qp4 = interfaceC3750qp2;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
        }
        if ((i2 & 64) != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
            }
            if ((i3 & 2995931) == 599186) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition1111110 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i11111111111112 = i3 & 8176;
                int i11111111111113 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition1111110, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111111112 | (57344 & i11111111111113) | (i11111111111113 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC3750qp5 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp5 = interfaceC3750qp3;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i8 != 0) {
                    str2 = "AnimatedContent";
                }
                if (i10 != 0) {
                    interfaceC3750qp6 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp6 = interfaceC3750qp4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
                }
                Transition transitionUpdateTransition1111111 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                int i11111111111114 = i3 & 8176;
                int i11111111111115 = i3 >> 3;
                AnimatedContent(transitionUpdateTransition1111111, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111111114 | (57344 & i11111111111115) | (i11111111111115 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                str3 = str2;
                interfaceC3750qp7 = interfaceC3750qp6;
                interfaceC3750qp8 = interfaceC3750qp5;
                alignment3 = topStart;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i12 = 1572864;
        i3 |= i12;
        if ((i3 & 2995931) == 599186) {
            if (i13 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i4 != 0) {
                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
            } else {
                interfaceC3750qp5 = interfaceC3750qp3;
            }
            if (i6 != 0) {
                topStart = Alignment.Companion.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i8 != 0) {
                str2 = "AnimatedContent";
            }
            if (i10 != 0) {
                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
            } else {
                interfaceC3750qp6 = interfaceC3750qp4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
            }
            Transition transitionUpdateTransition1111112 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
            int i11111111111116 = i3 & 8176;
            int i11111111111117 = i3 >> 3;
            AnimatedContent(transitionUpdateTransition1111112, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111111116 | (57344 & i11111111111117) | (i11111111111117 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            str3 = str2;
            interfaceC3750qp7 = interfaceC3750qp6;
            interfaceC3750qp8 = interfaceC3750qp5;
            alignment3 = topStart;
        } else {
            if (i13 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i4 != 0) {
                interfaceC3750qp5 = AnonymousClass1.INSTANCE;
            } else {
                interfaceC3750qp5 = interfaceC3750qp3;
            }
            if (i6 != 0) {
                topStart = Alignment.Companion.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i8 != 0) {
                str2 = "AnimatedContent";
            }
            if (i10 != 0) {
                interfaceC3750qp6 = AnonymousClass2.INSTANCE;
            } else {
                interfaceC3750qp6 = interfaceC3750qp4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2132720749, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:127)");
            }
            Transition transitionUpdateTransition1111113 = androidx.compose.animation.core.TransitionKt.updateTransition(s, str2, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
            int i11111111111118 = i3 & 8176;
            int i11111111111119 = i3 >> 3;
            AnimatedContent(transitionUpdateTransition1111113, modifier2, interfaceC3750qp5, topStart, interfaceC3750qp6, interfaceC0578Hp, composerStartRestartGroup, i11111111111118 | (57344 & i11111111111119) | (i11111111111119 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            str3 = str2;
            interfaceC3750qp7 = interfaceC3750qp6;
            interfaceC3750qp8 = interfaceC3750qp5;
            alignment3 = topStart;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(s, modifier3, interfaceC3750qp8, alignment3, str3, interfaceC3750qp7, interfaceC0578Hp, i, i2));
    }

    public static final SizeTransform SizeTransform(boolean z, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "sizeAnimationSpec");
        return new SizeTransformImpl(z, interfaceC0526Fp);
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            interfaceC0526Fp = C12631.INSTANCE;
        }
        return SizeTransform(z, interfaceC0526Fp);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exitTransition) {
        AbstractC4492zt.h(enterTransition, "<this>");
        AbstractC4492zt.h(exitTransition, "exit");
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    @ExperimentalAnimationApi
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exitTransition) {
        AbstractC4492zt.h(enterTransition, "<this>");
        AbstractC4492zt.h(exitTransition, "exit");
        return new ContentTransform(enterTransition, exitTransition, 0.0f, null, 12, null);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0188  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:109:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:114:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:118:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:123:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:126:0x0215 A[LOOP:0: B:121:0x01f7->B:126:0x0215, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:129:0x021d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0225  */
    /* JADX WARN: Code duplicated, block: B:133:0x0236  */
    /* JADX WARN: Code duplicated, block: B:137:0x0246  */
    /* JADX WARN: Code duplicated, block: B:139:0x0250 A[LOOP:2: B:138:0x024e->B:139:0x0250, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:142:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:144:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:150:0x0307  */
    /* JADX WARN: Code duplicated, block: B:153:0x0313  */
    /* JADX WARN: Code duplicated, block: B:154:0x0317  */
    /* JADX WARN: Code duplicated, block: B:157:0x0336  */
    /* JADX WARN: Code duplicated, block: B:159:0x0344  */
    /* JADX WARN: Code duplicated, block: B:163:0x0378  */
    /* JADX WARN: Code duplicated, block: B:166:0x0390  */
    /* JADX WARN: Code duplicated, block: B:170:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:175:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:177:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0397 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x007a  */
    /* JADX WARN: Code duplicated, block: B:43:0x0082  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00db  */
    /* JADX WARN: Code duplicated, block: B:75:0x00df  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:87:0x0119  */
    /* JADX WARN: Code duplicated, block: B:89:0x0121  */
    /* JADX WARN: Code duplicated, block: B:92:0x013c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0144  */
    /* JADX WARN: Code duplicated, block: B:97:0x0168  */
    /* JADX WARN: Code duplicated, block: B:99:0x0170  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final <S> void AnimatedContent(Transition<S> transition, Modifier modifier, InterfaceC3750qp interfaceC3750qp, Alignment alignment, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        InterfaceC3750qp interfaceC3750qp3;
        int i5;
        int i6;
        Alignment topStart;
        int i7;
        int i8;
        InterfaceC3750qp interfaceC3750qp4;
        int i9;
        int i10;
        Modifier modifier3;
        LayoutDirection layoutDirection;
        boolean zChanged;
        Object objRememberedValue;
        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl;
        boolean zChanged2;
        Object objRememberedValue2;
        SnapshotStateList snapshotStateList;
        boolean zChanged3;
        Object objRememberedValue3;
        Map map;
        int size;
        int i11;
        Map map2;
        InterfaceC3750qp interfaceC3750qp5;
        boolean zChanged4;
        Object objRememberedValue4;
        Object objRememberedValue5;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        InterfaceC3750qp interfaceC3750qp6;
        InterfaceC3750qp interfaceC3750qp7;
        Modifier modifier4;
        InterfaceC0526Fp interfaceC0526Fp;
        Iterator<T> it;
        int i12;
        int i13;
        Alignment alignment2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0578Hp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-114689412);
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 1;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 2;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    interfaceC3750qp3 = interfaceC3750qp;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 4;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        topStart = alignment;
                        if (composerStartRestartGroup.changed(topStart)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 8;
                    if (i8 != 0) {
                        i3 |= 24576;
                        interfaceC3750qp4 = interfaceC3750qp2;
                    } else {
                        interfaceC3750qp4 = interfaceC3750qp2;
                        if ((i & 57344) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i2 & 16) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        if ((374491 & i3) != 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            interfaceC3750qp6 = interfaceC3750qp3;
                            interfaceC3750qp7 = interfaceC3750qp4;
                        } else {
                            if (i14 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                            }
                            if (i6 != 0) {
                                topStart = Alignment.Companion.getTopStart();
                            }
                            if (i8 != 0) {
                                interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                            }
                            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged = composerStartRestartGroup.changed(transition);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged2 = composerStartRestartGroup.changed(transition);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            snapshotStateList = (SnapshotStateList) objRememberedValue2;
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged3 = composerStartRestartGroup.changed(transition);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                objRememberedValue3 = new LinkedHashMap();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            map = (Map) objRememberedValue3;
                            if (!snapshotStateList.contains(transition.getCurrentState())) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                                if (snapshotStateList.size() == 1 || !AbstractC4492zt.d(snapshotStateList.get(0), transition.getCurrentState())) {
                                    snapshotStateList.clear();
                                    snapshotStateList.add(transition.getCurrentState());
                                }
                                if (map.size() == 1 || map.containsKey(transition.getCurrentState())) {
                                    map.clear();
                                }
                                animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                                animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                            }
                            if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState()) && !snapshotStateList.contains(transition.getTargetState())) {
                                it = snapshotStateList.iterator();
                                i12 = 0;
                                while (true) {
                                    if (!it.hasNext()) {
                                        i13 = -1;
                                        i12 = -1;
                                        break;
                                    } else {
                                        if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                            i13 = -1;
                                            break;
                                        }
                                        i12++;
                                    }
                                }
                                if (i12 == i13) {
                                    snapshotStateList.add(transition.getTargetState());
                                } else {
                                    snapshotStateList.set(i12, transition.getTargetState());
                                }
                            }
                            if (map.containsKey(transition.getTargetState()) || !map.containsKey(transition.getCurrentState())) {
                                map.clear();
                                size = snapshotStateList.size();
                                i11 = 0;
                                while (i11 < size) {
                                    Object obj = snapshotStateList.get(i11);
                                    Map map3 = map;
                                    map3.put(obj, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                    i11++;
                                    map = map3;
                                    interfaceC3750qp3 = interfaceC3750qp3;
                                    size = size;
                                    i3 = i3;
                                }
                            }
                            map2 = map;
                            interfaceC3750qp5 = interfaceC3750qp3;
                            Transition.Segment<S> segment = transition.getSegment();
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged4 = composerStartRestartGroup.changed(segment) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifierThen = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                                objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) objRememberedValue5;
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                            constructor = companion.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierThen);
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
                            Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion.getSetCompositeKeyHash();
                            if (!composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            composerStartRestartGroup.startReplaceableGroup(-441507761);
                            for (Object obj2 : snapshotStateList) {
                                composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                                interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                                if (interfaceC0526Fp != null) {
                                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                                }
                                composerStartRestartGroup.endMovableGroup();
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC3750qp6 = interfaceC3750qp5;
                            interfaceC3750qp7 = interfaceC3750qp4;
                            modifier4 = modifier3;
                        }
                        alignment2 = topStart;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    if ((374491 & i3) != 74898) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj3 = snapshotStateList.get(i11);
                                Map map4 = map;
                                map4.put(obj3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj3, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map4;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj4 = snapshotStateList.get(i11);
                                Map map5 = map;
                                map5.put(obj4, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj4, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map5;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment2 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment2) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen2 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy2 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        constructor = companion2.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierThen2);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy2, companion2.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj5 = snapshotStateList.get(i11);
                                Map map6 = map;
                                map6.put(obj5, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj5, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map6;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj6 = snapshotStateList.get(i11);
                                Map map7 = map;
                                map7.put(obj6, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj6, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map7;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment3 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment3) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen3 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy3 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                        constructor = companion3.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierThen3);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy3, companion3.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    }
                    alignment2 = topStart;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i3 |= 3072;
                topStart = alignment;
                i8 = i2 & 8;
                if (i8 != 0) {
                    i3 |= 24576;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                }
                if ((i2 & 16) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) != 74898) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj7 = snapshotStateList.get(i11);
                                Map map8 = map;
                                map8.put(obj7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj7, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map8;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj8 = snapshotStateList.get(i11);
                                Map map9 = map;
                                map9.put(obj8, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj8, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map9;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment4 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment4) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen4 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy4 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                        constructor = companion4.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierThen4);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy4, companion4.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj9 = snapshotStateList.get(i11);
                                Map map10 = map;
                                map10.put(obj9, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj9, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map10;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj10 = snapshotStateList.get(i11);
                                Map map11 = map;
                                map11.put(obj10, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj10, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map11;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment5 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment5) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen5 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy5 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                        constructor = companion5.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierThen5);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy5, companion5.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    }
                    alignment2 = topStart;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) != 74898) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj11 = snapshotStateList.get(i11);
                            Map map12 = map;
                            map12.put(obj11, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map12;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj12 = snapshotStateList.get(i11);
                            Map map13 = map;
                            map13.put(obj12, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj12, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map13;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment6 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment6) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen6 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy6 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion6 = ComposeUiNode.Companion;
                    constructor = companion6.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierThen6);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy6, companion6.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion6.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj13 = snapshotStateList.get(i11);
                            Map map14 = map;
                            map14.put(obj13, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj13, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map14;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj14 = snapshotStateList.get(i11);
                            Map map15 = map;
                            map15.put(obj14, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj14, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map15;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment7 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment7) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen7 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy7 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                    constructor = companion7.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierThen7);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy7, companion7.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion7.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                }
                alignment2 = topStart;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 384;
            interfaceC3750qp3 = interfaceC3750qp;
            i6 = i2 & 4;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    topStart = alignment;
                    if (composerStartRestartGroup.changed(topStart)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 8;
                if (i8 != 0) {
                    i3 |= 24576;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                }
                if ((i2 & 16) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) != 74898) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj15 = snapshotStateList.get(i11);
                                Map map16 = map;
                                map16.put(obj15, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj15, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map16;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj16 = snapshotStateList.get(i11);
                                Map map17 = map;
                                map17.put(obj16, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj16, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map17;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment8 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment8) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen8 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy8 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion8 = ComposeUiNode.Companion;
                        constructor = companion8.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(modifierThen8);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy8, companion8.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap8, companion8.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj17 = snapshotStateList.get(i11);
                                Map map18 = map;
                                map18.put(obj17, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj17, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map18;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj18 = snapshotStateList.get(i11);
                                Map map19 = map;
                                map19.put(obj18, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj18, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map19;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment9 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment9) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen9 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy9 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion9 = ComposeUiNode.Companion;
                        constructor = companion9.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(modifierThen9);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy9, companion9.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    }
                    alignment2 = topStart;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) != 74898) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj19 = snapshotStateList.get(i11);
                            Map map110 = map;
                            map110.put(obj19, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj19, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map110;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj110 = snapshotStateList.get(i11);
                            Map map111 = map;
                            map111.put(obj110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj110, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map111;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment10 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment10) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen10 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy10 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion10 = ComposeUiNode.Companion;
                    constructor = companion10.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(modifierThen10);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy10, companion10.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap10, companion10.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion10.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj111 = snapshotStateList.get(i11);
                            Map map112 = map;
                            map112.put(obj111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map112;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj112 = snapshotStateList.get(i11);
                            Map map113 = map;
                            map113.put(obj112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj112, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map113;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment11 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment11) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen11 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy11 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion11 = ComposeUiNode.Companion;
                    constructor = companion11.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(modifierThen11);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy11, companion11.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11, companion11.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion11.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                }
                alignment2 = topStart;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 3072;
            topStart = alignment;
            i8 = i2 & 8;
            if (i8 != 0) {
                i3 |= 24576;
                interfaceC3750qp4 = interfaceC3750qp2;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
            }
            if ((i2 & 16) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                if ((374491 & i3) != 74898) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj113 = snapshotStateList.get(i11);
                            Map map114 = map;
                            map114.put(obj113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj113, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map114;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj114 = snapshotStateList.get(i11);
                            Map map115 = map;
                            map115.put(obj114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj114, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map115;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment12 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment12) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen12 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy12 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion12 = ComposeUiNode.Companion;
                    constructor = companion12.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(modifierThen12);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy12, companion12.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap12, companion12.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion12.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj115 = snapshotStateList.get(i11);
                            Map map116 = map;
                            map116.put(obj115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj115, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map116;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj116 = snapshotStateList.get(i11);
                            Map map117 = map;
                            map117.put(obj116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj116, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map117;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment13 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment13) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen13 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy13 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion13 = ComposeUiNode.Companion;
                    constructor = companion13.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(modifierThen13);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy13, companion13.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap13, companion13.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion13.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                }
                alignment2 = topStart;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            if ((374491 & i3) != 74898) {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj117 = snapshotStateList.get(i11);
                        Map map118 = map;
                        map118.put(obj117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj117, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map118;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj118 = snapshotStateList.get(i11);
                        Map map119 = map;
                        map119.put(obj118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj118, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map119;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment14 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment14) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen14 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy14 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion14 = ComposeUiNode.Companion;
                constructor = companion14.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(modifierThen14);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy14, companion14.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap14, companion14.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion14.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj119 = snapshotStateList.get(i11);
                        Map map1110 = map;
                        map1110.put(obj119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj119, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map1110;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj1110 = snapshotStateList.get(i11);
                        Map map1111 = map;
                        map1111.put(obj1110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1110, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map1111;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment15 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment15) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen15 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy15 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion15 = ComposeUiNode.Companion;
                constructor = companion15.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(modifierThen15);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy15, companion15.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap15, companion15.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion15.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            }
            alignment2 = topStart;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 2;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                interfaceC3750qp3 = interfaceC3750qp;
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp3)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 4;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    topStart = alignment;
                    if (composerStartRestartGroup.changed(topStart)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 8;
                if (i8 != 0) {
                    i3 |= 24576;
                    interfaceC3750qp4 = interfaceC3750qp2;
                } else {
                    interfaceC3750qp4 = interfaceC3750qp2;
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                }
                if ((i2 & 16) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    if ((374491 & i3) != 74898) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj1111 = snapshotStateList.get(i11);
                                Map map1112 = map;
                                map1112.put(obj1111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1111, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map1112;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj1112 = snapshotStateList.get(i11);
                                Map map1113 = map;
                                map1113.put(obj1112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1112, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map1113;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment16 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment16) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen16 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy16 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion16 = ComposeUiNode.Companion;
                        constructor = companion16.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf16 = LayoutKt.modifierMaterializerOf(modifierThen16);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy16, companion16.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap16, companion16.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion16.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf16.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                        }
                        if (i6 != 0) {
                            topStart = Alignment.Companion.getTopStart();
                        }
                        if (i8 != 0) {
                            interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                        }
                        layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(transition);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged2 = composerStartRestartGroup.changed(transition);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged3 = composerStartRestartGroup.changed(transition);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new LinkedHashMap();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        map = (Map) objRememberedValue3;
                        if (!snapshotStateList.contains(transition.getCurrentState())) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            if (snapshotStateList.size() == 1) {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            } else {
                                snapshotStateList.clear();
                                snapshotStateList.add(transition.getCurrentState());
                            }
                            if (map.size() == 1) {
                                map.clear();
                            } else {
                                map.clear();
                            }
                            animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                            animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                        }
                        if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                            it = snapshotStateList.iterator();
                            i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i13 = -1;
                                    i12 = -1;
                                    break;
                                } else {
                                    if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                        i13 = -1;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (i12 == i13) {
                                snapshotStateList.add(transition.getTargetState());
                            } else {
                                snapshotStateList.set(i12, transition.getTargetState());
                            }
                        }
                        if (map.containsKey(transition.getTargetState())) {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj1113 = snapshotStateList.get(i11);
                                Map map1114 = map;
                                map1114.put(obj1113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1113, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map1114;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        } else {
                            map.clear();
                            size = snapshotStateList.size();
                            i11 = 0;
                            while (i11 < size) {
                                Object obj1114 = snapshotStateList.get(i11);
                                Map map1115 = map;
                                map1115.put(obj1114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1114, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                                i11++;
                                map = map1115;
                                interfaceC3750qp3 = interfaceC3750qp3;
                                size = size;
                                i3 = i3;
                            }
                        }
                        map2 = map;
                        interfaceC3750qp5 = interfaceC3750qp3;
                        Transition.Segment<S> segment17 = transition.getSegment();
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged4 = composerStartRestartGroup.changed(segment17) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierThen17 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy17 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion17 = ComposeUiNode.Companion;
                        constructor = companion17.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(modifierThen17);
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
                        Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy17, companion17.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap17, companion17.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion17.getSetCompositeKeyHash();
                        if (!composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf17.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        composerStartRestartGroup.startReplaceableGroup(-441507761);
                        while (r0.hasNext()) {
                            composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                            interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                            if (interfaceC0526Fp != null) {
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC3750qp6 = interfaceC3750qp5;
                        interfaceC3750qp7 = interfaceC3750qp4;
                        modifier4 = modifier3;
                    }
                    alignment2 = topStart;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                if ((374491 & i3) != 74898) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj1115 = snapshotStateList.get(i11);
                            Map map1116 = map;
                            map1116.put(obj1115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1115, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map1116;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj1116 = snapshotStateList.get(i11);
                            Map map1117 = map;
                            map1117.put(obj1116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1116, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map1117;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment18 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment18) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen18 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy18 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion18 = ComposeUiNode.Companion;
                    constructor = companion18.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf18 = LayoutKt.modifierMaterializerOf(modifierThen18);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy18, companion18.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap18, companion18.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion18.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf18.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj1117 = snapshotStateList.get(i11);
                            Map map1118 = map;
                            map1118.put(obj1117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1117, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map1118;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj1118 = snapshotStateList.get(i11);
                            Map map1119 = map;
                            map1119.put(obj1118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1118, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map1119;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment19 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment19) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen19 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy19 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion19 = ComposeUiNode.Companion;
                    constructor = companion19.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf19 = LayoutKt.modifierMaterializerOf(modifierThen19);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy19, companion19.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap19, companion19.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion19.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf19.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                }
                alignment2 = topStart;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i3 |= 3072;
            topStart = alignment;
            i8 = i2 & 8;
            if (i8 != 0) {
                i3 |= 24576;
                interfaceC3750qp4 = interfaceC3750qp2;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
            }
            if ((i2 & 16) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                if ((374491 & i3) != 74898) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj1119 = snapshotStateList.get(i11);
                            Map map11110 = map;
                            map11110.put(obj1119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1119, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map11110;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj11110 = snapshotStateList.get(i11);
                            Map map11111 = map;
                            map11111.put(obj11110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11110, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map11111;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment110 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment110) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen110 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy110 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion110 = ComposeUiNode.Companion;
                    constructor = companion110.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf110 = LayoutKt.modifierMaterializerOf(modifierThen110);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy110, companion110.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap110, companion110.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion110.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj11111 = snapshotStateList.get(i11);
                            Map map11112 = map;
                            map11112.put(obj11111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11111, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map11112;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj11112 = snapshotStateList.get(i11);
                            Map map11113 = map;
                            map11113.put(obj11112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11112, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map11113;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment111 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment111) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen111 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy111 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion111 = ComposeUiNode.Companion;
                    constructor = companion111.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111 = LayoutKt.modifierMaterializerOf(modifierThen111);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy111, companion111.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111, companion111.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion111.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                }
                alignment2 = topStart;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            if ((374491 & i3) != 74898) {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj11113 = snapshotStateList.get(i11);
                        Map map11114 = map;
                        map11114.put(obj11113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11113, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map11114;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj11114 = snapshotStateList.get(i11);
                        Map map11115 = map;
                        map11115.put(obj11114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11114, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map11115;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment112 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment112) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen112 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy112 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion112 = ComposeUiNode.Companion;
                constructor = companion112.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf112 = LayoutKt.modifierMaterializerOf(modifierThen112);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy112, companion112.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap112, companion112.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion112.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj11115 = snapshotStateList.get(i11);
                        Map map11116 = map;
                        map11116.put(obj11115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11115, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map11116;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj11116 = snapshotStateList.get(i11);
                        Map map11117 = map;
                        map11117.put(obj11116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11116, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map11117;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment113 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment113) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen113 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy113 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion113 = ComposeUiNode.Companion;
                constructor = companion113.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf113 = LayoutKt.modifierMaterializerOf(modifierThen113);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy113, companion113.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap113, companion113.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion113.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            }
            alignment2 = topStart;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i3 |= 384;
        interfaceC3750qp3 = interfaceC3750qp;
        i6 = i2 & 4;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                topStart = alignment;
                if (composerStartRestartGroup.changed(topStart)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 8;
            if (i8 != 0) {
                i3 |= 24576;
                interfaceC3750qp4 = interfaceC3750qp2;
            } else {
                interfaceC3750qp4 = interfaceC3750qp2;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
            }
            if ((i2 & 16) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                if ((374491 & i3) != 74898) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj11117 = snapshotStateList.get(i11);
                            Map map11118 = map;
                            map11118.put(obj11117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11117, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map11118;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj11118 = snapshotStateList.get(i11);
                            Map map11119 = map;
                            map11119.put(obj11118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11118, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map11119;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment114 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment114) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen114 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy114 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion114 = ComposeUiNode.Companion;
                    constructor = companion114.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf114 = LayoutKt.modifierMaterializerOf(modifierThen114);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy114, companion114.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap114, companion114.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion114.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                    }
                    if (i6 != 0) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    if (i8 != 0) {
                        interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                    }
                    layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(transition);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged2 = composerStartRestartGroup.changed(transition);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged3 = composerStartRestartGroup.changed(transition);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new LinkedHashMap();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    map = (Map) objRememberedValue3;
                    if (!snapshotStateList.contains(transition.getCurrentState())) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        if (snapshotStateList.size() == 1) {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        } else {
                            snapshotStateList.clear();
                            snapshotStateList.add(transition.getCurrentState());
                        }
                        if (map.size() == 1) {
                            map.clear();
                        } else {
                            map.clear();
                        }
                        animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                        animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                    }
                    if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                        it = snapshotStateList.iterator();
                        i12 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i13 = -1;
                                i12 = -1;
                                break;
                            } else {
                                if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                    i13 = -1;
                                    break;
                                }
                                i12++;
                            }
                        }
                        if (i12 == i13) {
                            snapshotStateList.add(transition.getTargetState());
                        } else {
                            snapshotStateList.set(i12, transition.getTargetState());
                        }
                    }
                    if (map.containsKey(transition.getTargetState())) {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj11119 = snapshotStateList.get(i11);
                            Map map111110 = map;
                            map111110.put(obj11119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj11119, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map111110;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    } else {
                        map.clear();
                        size = snapshotStateList.size();
                        i11 = 0;
                        while (i11 < size) {
                            Object obj111110 = snapshotStateList.get(i11);
                            Map map111111 = map;
                            map111111.put(obj111110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111110, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                            i11++;
                            map = map111111;
                            interfaceC3750qp3 = interfaceC3750qp3;
                            size = size;
                            i3 = i3;
                        }
                    }
                    map2 = map;
                    interfaceC3750qp5 = interfaceC3750qp3;
                    Transition.Segment<S> segment115 = transition.getSegment();
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged4 = composerStartRestartGroup.changed(segment115) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen115 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    AnimatedContentMeasurePolicy animatedContentMeasurePolicy115 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion115 = ComposeUiNode.Companion;
                    constructor = companion115.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf115 = LayoutKt.modifierMaterializerOf(modifierThen115);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy115, companion115.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap115, companion115.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion115.getSetCompositeKeyHash();
                    if (!composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    composerStartRestartGroup.startReplaceableGroup(-441507761);
                    while (r0.hasNext()) {
                        composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                        interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                        if (interfaceC0526Fp != null) {
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC3750qp6 = interfaceC3750qp5;
                    interfaceC3750qp7 = interfaceC3750qp4;
                    modifier4 = modifier3;
                }
                alignment2 = topStart;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            if ((374491 & i3) != 74898) {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111111 = snapshotStateList.get(i11);
                        Map map111112 = map;
                        map111112.put(obj111111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111111, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111112;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111112 = snapshotStateList.get(i11);
                        Map map111113 = map;
                        map111113.put(obj111112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111112, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111113;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment116 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment116) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen116 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy116 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion116 = ComposeUiNode.Companion;
                constructor = companion116.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf116 = LayoutKt.modifierMaterializerOf(modifierThen116);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy116, companion116.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap116, companion116.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion116.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111113 = snapshotStateList.get(i11);
                        Map map111114 = map;
                        map111114.put(obj111113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111113, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111114;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111114 = snapshotStateList.get(i11);
                        Map map111115 = map;
                        map111115.put(obj111114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111114, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111115;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment117 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment117) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen117 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy117 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion117 = ComposeUiNode.Companion;
                constructor = companion117.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf117 = LayoutKt.modifierMaterializerOf(modifierThen117);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy117, companion117.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap117, companion117.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion117.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            }
            alignment2 = topStart;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i3 |= 3072;
        topStart = alignment;
        i8 = i2 & 8;
        if (i8 != 0) {
            i3 |= 24576;
            interfaceC3750qp4 = interfaceC3750qp2;
        } else {
            interfaceC3750qp4 = interfaceC3750qp2;
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
        }
        if ((i2 & 16) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0578Hp)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
            }
            if ((374491 & i3) != 74898) {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111115 = snapshotStateList.get(i11);
                        Map map111116 = map;
                        map111116.put(obj111115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111115, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111116;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111116 = snapshotStateList.get(i11);
                        Map map111117 = map;
                        map111117.put(obj111116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111116, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111117;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment118 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment118) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen118 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy118 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion118 = ComposeUiNode.Companion;
                constructor = companion118.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf118 = LayoutKt.modifierMaterializerOf(modifierThen118);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy118, companion118.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap118, companion118.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion118.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC3750qp3 = AnonymousClass4.INSTANCE;
                }
                if (i6 != 0) {
                    topStart = Alignment.Companion.getTopStart();
                }
                if (i8 != 0) {
                    interfaceC3750qp4 = AnonymousClass5.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
                }
                layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(transition);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged2 = composerStartRestartGroup.changed(transition);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged3 = composerStartRestartGroup.changed(transition);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new LinkedHashMap();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                map = (Map) objRememberedValue3;
                if (!snapshotStateList.contains(transition.getCurrentState())) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    if (snapshotStateList.size() == 1) {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    } else {
                        snapshotStateList.clear();
                        snapshotStateList.add(transition.getCurrentState());
                    }
                    if (map.size() == 1) {
                        map.clear();
                    } else {
                        map.clear();
                    }
                    animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
                }
                if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                    it = snapshotStateList.iterator();
                    i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i13 = -1;
                            i12 = -1;
                            break;
                        } else {
                            if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                                i13 = -1;
                                break;
                            }
                            i12++;
                        }
                    }
                    if (i12 == i13) {
                        snapshotStateList.add(transition.getTargetState());
                    } else {
                        snapshotStateList.set(i12, transition.getTargetState());
                    }
                }
                if (map.containsKey(transition.getTargetState())) {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111117 = snapshotStateList.get(i11);
                        Map map111118 = map;
                        map111118.put(obj111117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111117, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111118;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                } else {
                    map.clear();
                    size = snapshotStateList.size();
                    i11 = 0;
                    while (i11 < size) {
                        Object obj111118 = snapshotStateList.get(i11);
                        Map map111119 = map;
                        map111119.put(obj111118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111118, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                        i11++;
                        map = map111119;
                        interfaceC3750qp3 = interfaceC3750qp3;
                        size = size;
                        i3 = i3;
                    }
                }
                map2 = map;
                interfaceC3750qp5 = interfaceC3750qp3;
                Transition.Segment<S> segment119 = transition.getSegment();
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged4 = composerStartRestartGroup.changed(segment119) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen119 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy119 = (AnimatedContentMeasurePolicy) objRememberedValue5;
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion119 = ComposeUiNode.Companion;
                constructor = companion119.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf119 = LayoutKt.modifierMaterializerOf(modifierThen119);
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
                Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy119, companion119.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap119, companion119.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion119.getSetCompositeKeyHash();
                if (!composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                composerStartRestartGroup.startReplaceableGroup(-441507761);
                while (r0.hasNext()) {
                    composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                    interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC3750qp6 = interfaceC3750qp5;
                interfaceC3750qp7 = interfaceC3750qp4;
                modifier4 = modifier3;
            }
            alignment2 = topStart;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
        }
        i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i10;
        if ((374491 & i3) != 74898) {
            if (i14 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                interfaceC3750qp3 = AnonymousClass4.INSTANCE;
            }
            if (i6 != 0) {
                topStart = Alignment.Companion.getTopStart();
            }
            if (i8 != 0) {
                interfaceC3750qp4 = AnonymousClass5.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
            }
            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(transition);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged2 = composerStartRestartGroup.changed(transition);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            snapshotStateList = (SnapshotStateList) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged3 = composerStartRestartGroup.changed(transition);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue3 = new LinkedHashMap();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new LinkedHashMap();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            map = (Map) objRememberedValue3;
            if (!snapshotStateList.contains(transition.getCurrentState())) {
                snapshotStateList.clear();
                snapshotStateList.add(transition.getCurrentState());
            }
            if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                if (snapshotStateList.size() == 1) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                } else {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (map.size() == 1) {
                    map.clear();
                } else {
                    map.clear();
                }
                animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
            }
            if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                it = snapshotStateList.iterator();
                i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i13 = -1;
                        i12 = -1;
                        break;
                    } else {
                        if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                            i13 = -1;
                            break;
                        }
                        i12++;
                    }
                }
                if (i12 == i13) {
                    snapshotStateList.add(transition.getTargetState());
                } else {
                    snapshotStateList.set(i12, transition.getTargetState());
                }
            }
            if (map.containsKey(transition.getTargetState())) {
                map.clear();
                size = snapshotStateList.size();
                i11 = 0;
                while (i11 < size) {
                    Object obj111119 = snapshotStateList.get(i11);
                    Map map1111110 = map;
                    map1111110.put(obj111119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj111119, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                    i11++;
                    map = map1111110;
                    interfaceC3750qp3 = interfaceC3750qp3;
                    size = size;
                    i3 = i3;
                }
            } else {
                map.clear();
                size = snapshotStateList.size();
                i11 = 0;
                while (i11 < size) {
                    Object obj1111110 = snapshotStateList.get(i11);
                    Map map1111111 = map;
                    map1111111.put(obj1111110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1111110, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                    i11++;
                    map = map1111111;
                    interfaceC3750qp3 = interfaceC3750qp3;
                    size = size;
                    i3 = i3;
                }
            }
            map2 = map;
            interfaceC3750qp5 = interfaceC3750qp3;
            Transition.Segment<S> segment1110 = transition.getSegment();
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged4 = composerStartRestartGroup.changed(segment1110) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen1110 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy1110 = (AnimatedContentMeasurePolicy) objRememberedValue5;
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion1110 = ComposeUiNode.Companion;
            constructor = companion1110.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1110 = LayoutKt.modifierMaterializerOf(modifierThen1110);
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
            Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy1110, companion1110.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1110, companion1110.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion1110.getSetCompositeKeyHash();
            if (!composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf1110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-441507761);
            while (r0.hasNext()) {
                composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                if (interfaceC0526Fp != null) {
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC3750qp6 = interfaceC3750qp5;
            interfaceC3750qp7 = interfaceC3750qp4;
            modifier4 = modifier3;
        } else {
            if (i14 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                interfaceC3750qp3 = AnonymousClass4.INSTANCE;
            }
            if (i6 != 0) {
                topStart = Alignment.Companion.getTopStart();
            }
            if (i8 != 0) {
                interfaceC3750qp4 = AnonymousClass5.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-114689412, i3, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:681)");
            }
            layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(transition);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AnimatedContentTransitionScopeImpl(transition, topStart, layoutDirection);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged2 = composerStartRestartGroup.changed(transition);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            snapshotStateList = (SnapshotStateList) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged3 = composerStartRestartGroup.changed(transition);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue3 = new LinkedHashMap();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new LinkedHashMap();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            map = (Map) objRememberedValue3;
            if (!snapshotStateList.contains(transition.getCurrentState())) {
                snapshotStateList.clear();
                snapshotStateList.add(transition.getCurrentState());
            }
            if (AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                if (snapshotStateList.size() == 1) {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                } else {
                    snapshotStateList.clear();
                    snapshotStateList.add(transition.getCurrentState());
                }
                if (map.size() == 1) {
                    map.clear();
                } else {
                    map.clear();
                }
                animatedContentTransitionScopeImpl.setContentAlignment$animation_release(topStart);
                animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(layoutDirection);
            }
            if (!AbstractC4492zt.d(transition.getCurrentState(), transition.getTargetState())) {
                it = snapshotStateList.iterator();
                i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i13 = -1;
                        i12 = -1;
                        break;
                    } else {
                        if (AbstractC4492zt.d(interfaceC3750qp4.invoke(it.next()), interfaceC3750qp4.invoke(transition.getTargetState()))) {
                            i13 = -1;
                            break;
                        }
                        i12++;
                    }
                }
                if (i12 == i13) {
                    snapshotStateList.add(transition.getTargetState());
                } else {
                    snapshotStateList.set(i12, transition.getTargetState());
                }
            }
            if (map.containsKey(transition.getTargetState())) {
                map.clear();
                size = snapshotStateList.size();
                i11 = 0;
                while (i11 < size) {
                    Object obj1111111 = snapshotStateList.get(i11);
                    Map map1111112 = map;
                    map1111112.put(obj1111111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1111111, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                    i11++;
                    map = map1111112;
                    interfaceC3750qp3 = interfaceC3750qp3;
                    size = size;
                    i3 = i3;
                }
            } else {
                map.clear();
                size = snapshotStateList.size();
                i11 = 0;
                while (i11 < size) {
                    Object obj1111112 = snapshotStateList.get(i11);
                    Map map1111113 = map;
                    map1111113.put(obj1111112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 885640742, true, new AnimatedContentKt$AnimatedContent$6$1(transition, obj1111112, i3, interfaceC3750qp3, animatedContentTransitionScopeImpl, snapshotStateList, interfaceC0578Hp)));
                    i11++;
                    map = map1111113;
                    interfaceC3750qp3 = interfaceC3750qp3;
                    size = size;
                    i3 = i3;
                }
            }
            map2 = map;
            interfaceC3750qp5 = interfaceC3750qp3;
            Transition.Segment<S> segment1111 = transition.getSegment();
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged4 = composerStartRestartGroup.changed(segment1111) | composerStartRestartGroup.changed(animatedContentTransitionScopeImpl);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (ContentTransform) interfaceC3750qp5.invoke(animatedContentTransitionScopeImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen1111 = modifier3.then(animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform) objRememberedValue4, composerStartRestartGroup, 72));
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy1111 = (AnimatedContentMeasurePolicy) objRememberedValue5;
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion1111 = ComposeUiNode.Companion;
            constructor = companion1111.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1111 = LayoutKt.modifierMaterializerOf(modifierThen1111);
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
            Updater.m2668setimpl(composerM2661constructorimpl, animatedContentMeasurePolicy1111, companion1111.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1111, companion1111.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion1111.getSetCompositeKeyHash();
            if (!composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf1111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-441507761);
            while (r0.hasNext()) {
                composerStartRestartGroup.startMovableGroup(-1739559893, interfaceC3750qp4.invoke(obj2));
                interfaceC0526Fp = (InterfaceC0526Fp) map2.get(obj2);
                if (interfaceC0526Fp != null) {
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC3750qp6 = interfaceC3750qp5;
            interfaceC3750qp7 = interfaceC3750qp4;
            modifier4 = modifier3;
        }
        alignment2 = topStart;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(transition, modifier4, interfaceC3750qp6, alignment2, interfaceC3750qp7, interfaceC0578Hp, i, i2));
    }
}
