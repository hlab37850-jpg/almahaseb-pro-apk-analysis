package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VectorComposeKt {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final GroupComponent invoke() {
            return new GroupComponent();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ List<PathNode> $clipPathData;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ String $name;
        final /* synthetic */ float $pivotX;
        final /* synthetic */ float $pivotY;
        final /* synthetic */ float $rotation;
        final /* synthetic */ float $scaleX;
        final /* synthetic */ float $scaleY;
        final /* synthetic */ float $translationX;
        final /* synthetic */ float $translationY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$name = str;
            this.$rotation = f;
            this.$pivotX = f2;
            this.$pivotY = f3;
            this.$scaleX = f4;
            this.$scaleY = f5;
            this.$translationX = f6;
            this.$translationY = f7;
            this.$clipPathData = list;
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
            VectorComposeKt.Group(this.$name, this.$rotation, this.$pivotX, this.$pivotY, this.$scaleX, this.$scaleY, this.$translationX, this.$translationY, this.$clipPathData, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0127  */
    /* JADX WARN: Code duplicated, block: B:107:0x014c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x016f A[PHI: r2 r4 r5 r6 r7 r9 r13 r14 r15
      0x016f: PHI (r2v5 java.lang.String) = (r2v2 java.lang.String), (r2v6 java.lang.String) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r4v26 int) = (r4v22 int), (r4v27 int) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r5v5 float) = (r5v2 float), (r5v6 float) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r6v15 float) = (r6v11 float), (r6v17 float) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r7v10 float) = (r7v6 float), (r7v11 float) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r9v7 float) = (r9v3 float), (r9v2 float) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r13v9 float) = (r13v6 float), (r13v10 float) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r14v6 float) = (r14v3 float), (r14v2 float) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]
      0x016f: PHI (r15v9 float) = (r15v6 float), (r15v10 float) binds: [B:141:0x019f, B:115:0x0163] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x0172 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x0174  */
    /* JADX WARN: Code duplicated, block: B:119:0x0177  */
    /* JADX WARN: Code duplicated, block: B:122:0x017c  */
    /* JADX WARN: Code duplicated, block: B:123:0x017e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0182  */
    /* JADX WARN: Code duplicated, block: B:127:0x0185  */
    /* JADX WARN: Code duplicated, block: B:130:0x018a  */
    /* JADX WARN: Code duplicated, block: B:131:0x018d  */
    /* JADX WARN: Code duplicated, block: B:134:0x0192  */
    /* JADX WARN: Code duplicated, block: B:136:0x0196  */
    /* JADX WARN: Code duplicated, block: B:137:0x0198  */
    /* JADX WARN: Code duplicated, block: B:140:0x019d  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:145:0x01af  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:155:0x023f  */
    /* JADX WARN: Code duplicated, block: B:160:0x024f  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00db  */
    /* JADX WARN: Code duplicated, block: B:74:0x00de  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x0106  */
    /* JADX WARN: Code duplicated, block: B:91:0x010e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:96:0x0119  */
    /* JADX WARN: Code duplicated, block: B:98:0x011f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0122  */
    @VectorComposable
    @Composable
    public static final void Group(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        float f8;
        int i5;
        int i6;
        float f9;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        String str2;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        List<? extends PathNode> emptyPath;
        AnonymousClass1 anonymousClass1;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        List<? extends PathNode> list2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-213417674);
        int i18 = i2 & 1;
        if (i18 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i19 = i2 & 2;
        if (i19 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    f8 = f2;
                    if (composerStartRestartGroup.changed(f8)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        f9 = f3;
                        if (composerStartRestartGroup.changed(f9)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        i3 |= 24576;
                    } else if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f5)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f6)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= 33554432;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                                i17 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 != 256 && (1533916891 & i3) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            str2 = str;
                            f10 = f;
                            f11 = f4;
                            f16 = f5;
                            f19 = f6;
                            f15 = f7;
                            f17 = f8;
                            f18 = f9;
                            list2 = list;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i18 != 0) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                if (i19 != 0) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = f;
                                }
                                if (i4 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i6 != 0) {
                                    f9 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f11 = 1.0f;
                                } else {
                                    f11 = f4;
                                }
                                f12 = i10 == 0 ? f5 : 1.0f;
                                if (i12 != 0) {
                                    f13 = 0.0f;
                                } else {
                                    f13 = f6;
                                }
                                f14 = i14 == 0 ? f7 : 0.0f;
                                if (i16 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                                }
                                anonymousClass1 = AnonymousClass1.INSTANCE;
                                composerStartRestartGroup.startReplaceableGroup(-548224868);
                                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(anonymousClass1);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                                Updater.m2668setimpl(composerM2661constructorimpl, str2, VectorComposeKt$Group$2$1.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                                Updater.m2668setimpl(composerM2661constructorimpl, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f15 = f14;
                                f16 = f12;
                                f17 = f8;
                                f18 = f9;
                                f19 = f13;
                                list2 = emptyPath;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if (i16 != 0) {
                                    i3 &= -234881025;
                                }
                                str2 = str;
                                f10 = f;
                                f11 = f4;
                                f12 = f5;
                                f13 = f6;
                                f14 = f7;
                            }
                            emptyPath = list;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                            }
                            anonymousClass1 = AnonymousClass1.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl2, str2, VectorComposeKt$Group$2$1.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                            Updater.m2668setimpl(composerM2661constructorimpl2, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f15 = f14;
                            f16 = f12;
                            f17 = f8;
                            f18 = f9;
                            f19 = f13;
                            list2 = emptyPath;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
                    }
                    i17 = 805306368;
                    i3 |= i17;
                    if (i16 != 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl3, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl3, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl4, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl4, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
                }
                i3 |= 3072;
                f9 = f3;
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i17 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 != 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl5, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl5, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl6, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl6, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 != 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl7 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl7, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl7, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl8 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl8, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl8, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            f8 = f2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    f9 = f3;
                    if (composerStartRestartGroup.changed(f9)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i17 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 != 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl9 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl9, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl9, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl10 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl10, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl10, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 != 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl11 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl11, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl11, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl12 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl12, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl12, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            f9 = f3;
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= 33554432;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i17 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 != 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl13 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl13, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl13, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl14 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl14, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl14, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
            }
            i17 = 805306368;
            i3 |= i17;
            if (i16 != 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl15 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl15, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl15, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl16 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl16, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl16, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                f8 = f2;
                if (composerStartRestartGroup.changed(f8)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    f9 = f3;
                    if (composerStartRestartGroup.changed(f9)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f5)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= 33554432;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i17 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 != 256) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl17 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl17, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl17, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i18 != 0) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            if (i19 != 0) {
                                f10 = 0.0f;
                            } else {
                                f10 = f;
                            }
                            if (i4 != 0) {
                                f8 = 0.0f;
                            }
                            if (i6 != 0) {
                                f9 = 0.0f;
                            }
                            if (i8 != 0) {
                                f11 = 1.0f;
                            } else {
                                f11 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f13 = 0.0f;
                            } else {
                                f13 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i16 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM2661constructorimpl18 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl18, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m2668setimpl(composerM2661constructorimpl18, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f15 = f14;
                        f16 = f12;
                        f17 = f8;
                        f18 = f9;
                        f19 = f13;
                        list2 = emptyPath;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 != 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl19 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl19, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl19, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl110, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl110, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            f9 = f3;
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= 33554432;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i17 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 != 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl111, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl111, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl112, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl112, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
            }
            i17 = 805306368;
            i3 |= i17;
            if (i16 != 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl113 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl113, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl113, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl114 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl114, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl114, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        f8 = f2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                f9 = f3;
                if (composerStartRestartGroup.changed(f9)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f5)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= 33554432;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i17 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 != 256) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl115, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl115, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i18 != 0) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        if (i19 != 0) {
                            f10 = 0.0f;
                        } else {
                            f10 = f;
                        }
                        if (i4 != 0) {
                            f8 = 0.0f;
                        }
                        if (i6 != 0) {
                            f9 = 0.0f;
                        }
                        if (i8 != 0) {
                            f11 = 1.0f;
                        } else {
                            f11 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f13 = 0.0f;
                        } else {
                            f13 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i16 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM2661constructorimpl116 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl116, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m2668setimpl(composerM2661constructorimpl116, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f15 = f14;
                    f16 = f12;
                    f17 = f8;
                    f18 = f9;
                    f19 = f13;
                    list2 = emptyPath;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
            }
            i17 = 805306368;
            i3 |= i17;
            if (i16 != 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl117 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl117, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl117, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl118 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl118, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl118, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
        }
        i3 |= 3072;
        f9 = f3;
        i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(f4)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(f5)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        }
        i12 = i2 & 64;
        if (i12 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(f6)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        i14 = i2 & 128;
        if (i14 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(f7)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i3 |= i15;
        }
        i16 = i2 & 256;
        if (i16 != 0) {
            i3 |= 33554432;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i17 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i17 = 268435456;
                }
            }
            if (i16 != 256) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl119 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl119, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl119, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i18 != 0) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    if (i19 != 0) {
                        f10 = 0.0f;
                    } else {
                        f10 = f;
                    }
                    if (i4 != 0) {
                        f8 = 0.0f;
                    }
                    if (i6 != 0) {
                        f9 = 0.0f;
                    }
                    if (i8 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f13 = 0.0f;
                    } else {
                        f13 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i16 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM2661constructorimpl1110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl1110, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m2668setimpl(composerM2661constructorimpl1110, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f15 = f14;
                f16 = f12;
                f17 = f8;
                f18 = f9;
                f19 = f13;
                list2 = emptyPath;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
        }
        i17 = 805306368;
        i3 |= i17;
        if (i16 != 256) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f8 = 0.0f;
                }
                if (i6 != 0) {
                    f9 = 0.0f;
                }
                if (i8 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f8 = 0.0f;
                }
                if (i6 != 0) {
                    f9 = 0.0f;
                }
                if (i8 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
            }
            anonymousClass1 = AnonymousClass1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl1111 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl1111, str2, VectorComposeKt$Group$2$1.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1111, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f15 = f14;
            f16 = f12;
            f17 = f8;
            f18 = f9;
            f19 = f13;
            list2 = emptyPath;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f8 = 0.0f;
                }
                if (i6 != 0) {
                    f9 = 0.0f;
                }
                if (i8 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i18 != 0) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i19 != 0) {
                    f10 = 0.0f;
                } else {
                    f10 = f;
                }
                if (i4 != 0) {
                    f8 = 0.0f;
                }
                if (i6 != 0) {
                    f9 = 0.0f;
                }
                if (i8 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f13 = 0.0f;
                } else {
                    f13 = f6;
                }
                if (i14 == 0) {
                }
                if (i16 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:46)");
            }
            anonymousClass1 = AnonymousClass1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl1112 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl1112, str2, VectorComposeKt$Group$2$1.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, Float.valueOf(f10), VectorComposeKt$Group$2$2.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, Float.valueOf(f8), VectorComposeKt$Group$2$3.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, Float.valueOf(f9), VectorComposeKt$Group$2$4.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, Float.valueOf(f11), VectorComposeKt$Group$2$5.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, Float.valueOf(f12), VectorComposeKt$Group$2$6.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, Float.valueOf(f13), VectorComposeKt$Group$2$7.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, Float.valueOf(f14), VectorComposeKt$Group$2$8.INSTANCE);
            Updater.m2668setimpl(composerM2661constructorimpl1112, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f15 = f14;
            f16 = f12;
            f17 = f8;
            f18 = f9;
            f19 = f13;
            list2 = emptyPath;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f10, f17, f18, f11, f16, f19, f15, list2, interfaceC0526Fp, i, i2));
    }

    @VectorComposable
    @Composable
    /* JADX INFO: renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m3586Path9cdaXJ4(List<? extends PathNode> list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, int i4, int i5, int i6) {
        AbstractC4492zt.h(list, "pathData");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1478270750);
        int defaultFillType = (i6 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i6 & 4) != 0 ? "" : str;
        Brush brush3 = (i6 & 8) != 0 ? null : brush;
        float f8 = (i6 & 16) != 0 ? 1.0f : f;
        Brush brush4 = (i6 & 32) == 0 ? brush2 : null;
        float f9 = (i6 & 64) != 0 ? 1.0f : f2;
        float f10 = (i6 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i6 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i6 & 1024) != 0 ? 4.0f : f4;
        float f12 = (i6 & 2048) != 0 ? 0.0f : f5;
        float f13 = (i6 & 4096) != 0 ? 1.0f : f6;
        float f14 = (i6 & 8192) != 0 ? 0.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, i4, i5, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:99)");
        }
        VectorComposeKt$Path$1 vectorComposeKt$Path$1 = VectorComposeKt$Path$1.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(1886828752);
        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new VectorComposeKt$Path9cdaXJ4$$inlined$ComposeNode$1(vectorComposeKt$Path$1));
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
        Updater.m2668setimpl(composerM2661constructorimpl, str2, VectorComposeKt$Path$2$1.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, list, VectorComposeKt$Path$2$2.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, PathFillType.m3279boximpl(defaultFillType), VectorComposeKt$Path$2$3.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, brush3, VectorComposeKt$Path$2$4.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f8), VectorComposeKt$Path$2$5.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, brush4, VectorComposeKt$Path$2$6.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f9), VectorComposeKt$Path$2$7.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f10), VectorComposeKt$Path$2$8.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, StrokeJoin.m3359boximpl(defaultStrokeLineJoin), VectorComposeKt$Path$2$9.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, StrokeCap.m3349boximpl(defaultStrokeLineCap), VectorComposeKt$Path$2$10.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f11), VectorComposeKt$Path$2$11.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f12), VectorComposeKt$Path$2$12.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f13), VectorComposeKt$Path$2$13.INSTANCE);
        Updater.m2668setimpl(composerM2661constructorimpl, Float.valueOf(f14), VectorComposeKt$Path$2$14.INSTANCE);
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new VectorComposeKt$Path$3(list, defaultFillType, str2, brush3, f8, brush4, f9, f10, defaultStrokeLineCap, defaultStrokeLineJoin, f11, f12, f13, f14, i4, i5, i6));
    }
}
