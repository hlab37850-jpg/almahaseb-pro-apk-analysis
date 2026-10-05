package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.MJ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AlertDialogKt {
    private static final PaddingValues DialogPadding;
    private static final PaddingValues IconPadding;
    private static final PaddingValues TextPadding;
    private static final PaddingValues TitlePadding;
    private static final float DialogMinWidth = Dp.m5160constructorimpl(TIFFConstants.TIFFTAG_MINSAMPLEVALUE);
    private static final float DialogMaxWidth = Dp.m5160constructorimpl(560);

    static {
        float f = 24;
        DialogPadding = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(f));
        float f2 = 16;
        IconPadding = PaddingKt.m482PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5160constructorimpl(f2), 7, null);
        TitlePadding = PaddingKt.m482PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5160constructorimpl(f2), 7, null);
        TextPadding = PaddingKt.m482PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m5160constructorimpl(f), 7, null);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0136  */
    /* JADX WARN: Code duplicated, block: B:105:0x013c  */
    /* JADX WARN: Code duplicated, block: B:106:0x013f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0148  */
    /* JADX WARN: Code duplicated, block: B:111:0x014d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0153  */
    /* JADX WARN: Code duplicated, block: B:115:0x0159  */
    /* JADX WARN: Code duplicated, block: B:116:0x015c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0161  */
    /* JADX WARN: Code duplicated, block: B:121:0x0167  */
    /* JADX WARN: Code duplicated, block: B:122:0x016c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0172  */
    /* JADX WARN: Code duplicated, block: B:126:0x0178  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0188  */
    /* JADX WARN: Code duplicated, block: B:137:0x019c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x019e  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:145:0x0203  */
    /* JADX WARN: Code duplicated, block: B:150:0x020f  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00da  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:89:0x0107  */
    /* JADX WARN: Code duplicated, block: B:90:0x010e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0115  */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:95:0x011e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0126  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    public static final void m1325AlertDialogContent4hvqGtA(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, Shape shape, long j, float f, long j2, long j3, long j4, long j5, Composer composer, int i, int i2, int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
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
        int i18;
        Modifier modifier3;
        Composer composer2;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, "buttons");
        AbstractC4492zt.h(shape, "shape");
        Composer composerStartRestartGroup = composer.startRestartGroup(1522575799);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i19 = i3 & 2;
        if (i19 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 4) != 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i4 |= i5;
            }
            if ((i3 & 8) != 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i3 & 16) != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i4 |= i7;
                }
                if ((i3 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(shape)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    if ((i3 & 64) != 0) {
                        i10 = i4 | 1572864;
                    } else {
                        i9 = i4;
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(j)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i10 = i9 | i11;
                        } else {
                            i10 = i9;
                        }
                    }
                    if ((i3 & 128) != 0) {
                        if ((29360128 & i) == 0) {
                            if (composerStartRestartGroup.changed(f)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i10 |= i12;
                        }
                        if ((i3 & 256) != 0) {
                            i10 |= 100663296;
                        } else if ((234881024 & i) == 0) {
                            if (composerStartRestartGroup.changed(j2)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i10 |= i13;
                        }
                        if ((i3 & 512) != 0) {
                            i10 |= 805306368;
                        } else if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changed(j3)) {
                                i14 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i14 = 268435456;
                            }
                            i10 |= i14;
                        }
                        i15 = i10;
                        if ((i3 & 1024) != 0) {
                            i16 = i2 | 6;
                        } else if ((i2 & 14) == 0) {
                            if (composerStartRestartGroup.changed(j4)) {
                                i17 = 4;
                            } else {
                                i17 = 2;
                            }
                            i16 = i2 | i17;
                        } else {
                            i16 = i2;
                        }
                        if ((i3 & 2048) != 0) {
                            i16 |= 48;
                        } else if ((i2 & 112) == 0) {
                            if (composerStartRestartGroup.changed(j5)) {
                                i18 = 32;
                            } else {
                                i18 = 16;
                            }
                            i16 |= i18;
                        }
                        if ((1533916891 & i15) != 306783378 && (i16 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            composer2 = composerStartRestartGroup;
                        } else {
                            if (i19 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                            }
                            composer2 = composerStartRestartGroup;
                            int i20 = i15 >> 12;
                            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i20 & 112) | (i20 & 896) | ((i15 >> 9) & 57344), 104);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
                    }
                    i10 |= 12582912;
                    if ((i3 & 256) != 0) {
                        i10 |= 100663296;
                    } else if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i3 & 512) != 0) {
                        i10 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i14 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i14 = 268435456;
                        }
                        i10 |= i14;
                    }
                    i15 = i10;
                    if ((i3 & 1024) != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(j4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i3 & 2048) != 0) {
                        i16 |= 48;
                    } else if ((i2 & 112) == 0) {
                        if (composerStartRestartGroup.changed(j5)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i16 |= i18;
                    }
                    if ((1533916891 & i15) != 306783378) {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i21 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i21 & 112) | (i21 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    } else {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i22 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i22 & 112) | (i22 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i4 |= i8;
                if ((i3 & 64) != 0) {
                    i10 = i4 | 1572864;
                } else {
                    i9 = i4;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(j)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i10 = i9 | i11;
                    } else {
                        i10 = i9;
                    }
                }
                if ((i3 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i10 |= i12;
                    }
                    if ((i3 & 256) != 0) {
                        i10 |= 100663296;
                    } else if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i3 & 512) != 0) {
                        i10 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i14 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i14 = 268435456;
                        }
                        i10 |= i14;
                    }
                    i15 = i10;
                    if ((i3 & 1024) != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(j4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i3 & 2048) != 0) {
                        i16 |= 48;
                    } else if ((i2 & 112) == 0) {
                        if (composerStartRestartGroup.changed(j5)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i16 |= i18;
                    }
                    if ((1533916891 & i15) != 306783378) {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i23 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i23 & 112) | (i23 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    } else {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i24 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i24 & 112) | (i24 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
                }
                i10 |= 12582912;
                if ((i3 & 256) != 0) {
                    i10 |= 100663296;
                } else if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i3 & 512) != 0) {
                    i10 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i10 |= i14;
                }
                i15 = i10;
                if ((i3 & 1024) != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(j4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i16 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(j5)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i16 |= i18;
                }
                if ((1533916891 & i15) != 306783378) {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i25 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i25 & 112) | (i25 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i26 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i26 & 112) | (i26 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
            }
            i4 |= 24576;
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(shape)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                if ((i3 & 64) != 0) {
                    i10 = i4 | 1572864;
                } else {
                    i9 = i4;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(j)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i10 = i9 | i11;
                    } else {
                        i10 = i9;
                    }
                }
                if ((i3 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i10 |= i12;
                    }
                    if ((i3 & 256) != 0) {
                        i10 |= 100663296;
                    } else if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i3 & 512) != 0) {
                        i10 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i14 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i14 = 268435456;
                        }
                        i10 |= i14;
                    }
                    i15 = i10;
                    if ((i3 & 1024) != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(j4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i3 & 2048) != 0) {
                        i16 |= 48;
                    } else if ((i2 & 112) == 0) {
                        if (composerStartRestartGroup.changed(j5)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i16 |= i18;
                    }
                    if ((1533916891 & i15) != 306783378) {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i27 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i27 & 112) | (i27 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    } else {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i28 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i28 & 112) | (i28 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
                }
                i10 |= 12582912;
                if ((i3 & 256) != 0) {
                    i10 |= 100663296;
                } else if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i3 & 512) != 0) {
                    i10 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i10 |= i14;
                }
                i15 = i10;
                if ((i3 & 1024) != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(j4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i16 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(j5)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i16 |= i18;
                }
                if ((1533916891 & i15) != 306783378) {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i29 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i29 & 112) | (i29 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i210 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i210 & 112) | (i210 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i8;
            if ((i3 & 64) != 0) {
                i10 = i4 | 1572864;
            } else {
                i9 = i4;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(j)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i10 = i9 | i11;
                } else {
                    i10 = i9;
                }
            }
            if ((i3 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i10 |= i12;
                }
                if ((i3 & 256) != 0) {
                    i10 |= 100663296;
                } else if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i3 & 512) != 0) {
                    i10 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i10 |= i14;
                }
                i15 = i10;
                if ((i3 & 1024) != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(j4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i16 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(j5)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i16 |= i18;
                }
                if ((1533916891 & i15) != 306783378) {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i211 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i211 & 112) | (i211 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i212 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i212 & 112) | (i212 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
            }
            i10 |= 12582912;
            if ((i3 & 256) != 0) {
                i10 |= 100663296;
            } else if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i10 |= i13;
            }
            if ((i3 & 512) != 0) {
                i10 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i10 |= i14;
            }
            i15 = i10;
            if ((i3 & 1024) != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(j4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i3 & 2048) != 0) {
                i16 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(j5)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i16 |= i18;
            }
            if ((1533916891 & i15) != 306783378) {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i213 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i213 & 112) | (i213 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i214 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i214 & 112) | (i214 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i4 |= i5;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i4 |= i6;
        }
        if ((i3 & 16) != 0) {
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i4 |= i7;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(shape)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                if ((i3 & 64) != 0) {
                    i10 = i4 | 1572864;
                } else {
                    i9 = i4;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(j)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i10 = i9 | i11;
                    } else {
                        i10 = i9;
                    }
                }
                if ((i3 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i10 |= i12;
                    }
                    if ((i3 & 256) != 0) {
                        i10 |= 100663296;
                    } else if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i3 & 512) != 0) {
                        i10 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changed(j3)) {
                            i14 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i14 = 268435456;
                        }
                        i10 |= i14;
                    }
                    i15 = i10;
                    if ((i3 & 1024) != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changed(j4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i3 & 2048) != 0) {
                        i16 |= 48;
                    } else if ((i2 & 112) == 0) {
                        if (composerStartRestartGroup.changed(j5)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i16 |= i18;
                    }
                    if ((1533916891 & i15) != 306783378) {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i215 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i215 & 112) | (i215 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    } else {
                        if (i19 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                        }
                        composer2 = composerStartRestartGroup;
                        int i216 = i15 >> 12;
                        SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i216 & 112) | (i216 & 896) | ((i15 >> 9) & 57344), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
                }
                i10 |= 12582912;
                if ((i3 & 256) != 0) {
                    i10 |= 100663296;
                } else if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i3 & 512) != 0) {
                    i10 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i10 |= i14;
                }
                i15 = i10;
                if ((i3 & 1024) != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(j4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i16 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(j5)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i16 |= i18;
                }
                if ((1533916891 & i15) != 306783378) {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i217 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i217 & 112) | (i217 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i218 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i218 & 112) | (i218 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i8;
            if ((i3 & 64) != 0) {
                i10 = i4 | 1572864;
            } else {
                i9 = i4;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(j)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i10 = i9 | i11;
                } else {
                    i10 = i9;
                }
            }
            if ((i3 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i10 |= i12;
                }
                if ((i3 & 256) != 0) {
                    i10 |= 100663296;
                } else if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i3 & 512) != 0) {
                    i10 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i10 |= i14;
                }
                i15 = i10;
                if ((i3 & 1024) != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(j4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i16 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(j5)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i16 |= i18;
                }
                if ((1533916891 & i15) != 306783378) {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i219 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i219 & 112) | (i219 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i2110 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2110 & 112) | (i2110 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
            }
            i10 |= 12582912;
            if ((i3 & 256) != 0) {
                i10 |= 100663296;
            } else if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i10 |= i13;
            }
            if ((i3 & 512) != 0) {
                i10 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i10 |= i14;
            }
            i15 = i10;
            if ((i3 & 1024) != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(j4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i3 & 2048) != 0) {
                i16 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(j5)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i16 |= i18;
            }
            if ((1533916891 & i15) != 306783378) {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i2111 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2111 & 112) | (i2111 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i2112 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2112 & 112) | (i2112 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
        }
        i4 |= 24576;
        if ((i3 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(shape)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
            }
            if ((i3 & 64) != 0) {
                i10 = i4 | 1572864;
            } else {
                i9 = i4;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(j)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i10 = i9 | i11;
                } else {
                    i10 = i9;
                }
            }
            if ((i3 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i10 |= i12;
                }
                if ((i3 & 256) != 0) {
                    i10 |= 100663296;
                } else if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i3 & 512) != 0) {
                    i10 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changed(j3)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i10 |= i14;
                }
                i15 = i10;
                if ((i3 & 1024) != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(j4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i3 & 2048) != 0) {
                    i16 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changed(j5)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i16 |= i18;
                }
                if ((1533916891 & i15) != 306783378) {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i2113 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2113 & 112) | (i2113 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    if (i19 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                    }
                    composer2 = composerStartRestartGroup;
                    int i2114 = i15 >> 12;
                    SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2114 & 112) | (i2114 & 896) | ((i15 >> 9) & 57344), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
            }
            i10 |= 12582912;
            if ((i3 & 256) != 0) {
                i10 |= 100663296;
            } else if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i10 |= i13;
            }
            if ((i3 & 512) != 0) {
                i10 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i10 |= i14;
            }
            i15 = i10;
            if ((i3 & 1024) != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(j4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i3 & 2048) != 0) {
                i16 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(j5)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i16 |= i18;
            }
            if ((1533916891 & i15) != 306783378) {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i2115 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2115 & 112) | (i2115 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i2116 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2116 & 112) | (i2116 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
        }
        i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i4 |= i8;
        if ((i3 & 64) != 0) {
            i10 = i4 | 1572864;
        } else {
            i9 = i4;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i10 = i9 | i11;
            } else {
                i10 = i9;
            }
        }
        if ((i3 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i10 |= i12;
            }
            if ((i3 & 256) != 0) {
                i10 |= 100663296;
            } else if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i10 |= i13;
            }
            if ((i3 & 512) != 0) {
                i10 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changed(j3)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i10 |= i14;
            }
            i15 = i10;
            if ((i3 & 1024) != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(j4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i3 & 2048) != 0) {
                i16 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changed(j5)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i16 |= i18;
            }
            if ((1533916891 & i15) != 306783378) {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i2117 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2117 & 112) | (i2117 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                if (i19 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
                }
                composer2 = composerStartRestartGroup;
                int i2118 = i15 >> 12;
                SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2118 & 112) | (i2118 & 896) | ((i15 >> 9) & 57344), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
        }
        i10 |= 12582912;
        if ((i3 & 256) != 0) {
            i10 |= 100663296;
        } else if ((234881024 & i) == 0) {
            if (composerStartRestartGroup.changed(j2)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i10 |= i13;
        }
        if ((i3 & 512) != 0) {
            i10 |= 805306368;
        } else if ((1879048192 & i) == 0) {
            if (composerStartRestartGroup.changed(j3)) {
                i14 = PropertyOptions.DELETE_EXISTING;
            } else {
                i14 = 268435456;
            }
            i10 |= i14;
        }
        i15 = i10;
        if ((i3 & 1024) != 0) {
            i16 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changed(j4)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i16 = i2 | i17;
        } else {
            i16 = i2;
        }
        if ((i3 & 2048) != 0) {
            i16 |= 48;
        } else if ((i2 & 112) == 0) {
            if (composerStartRestartGroup.changed(j5)) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i16 |= i18;
        }
        if ((1533916891 & i15) != 306783378) {
            if (i19 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
            }
            composer2 = composerStartRestartGroup;
            int i2119 = i15 >> 12;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i2119 & 112) | (i2119 & 896) | ((i15 >> 9) & 57344), 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i19 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522575799, i15, i16, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:37)");
            }
            composer2 = composerStartRestartGroup;
            int i21110 = i15 >> 12;
            SurfaceKt.m1850SurfaceT9BRK9s(modifier3, shape, j, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -2126308228, true, new AlertDialogKt$AlertDialogContent$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, j3, i15, j4, j5, j2, interfaceC0526Fp)), composer2, ((i15 >> 3) & 14) | 12582912 | (i21110 & 112) | (i21110 & 896) | ((i15 >> 9) & 57344), 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogContent$2(interfaceC0526Fp, modifier4, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, shape, j, f, j2, j3, j4, j5, i, i2, i3));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1326AlertDialogFlowRowixp7dh8(final float f, final float f2, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(586821353);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i2, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:124)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1
                private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, MJ mj, MeasureScope measureScope, float f3, long j, Placeable placeable) {
                    return list.isEmpty() || (mj.a + measureScope.mo327roundToPx0680j_4(f3)) + placeable.getWidth() <= Constraints.m5128getMaxWidthimpl(j);
                }

                private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, MJ mj, MeasureScope measureScope, float f3, List<Placeable> list2, List<Integer> list3, MJ mj2, List<Integer> list4, MJ mj3, MJ mj4) {
                    List<List<Placeable>> list5 = list;
                    if (!list5.isEmpty()) {
                        mj.a += measureScope.mo327roundToPx0680j_4(f3);
                    }
                    list5.add(AbstractC3240kc.C0(list2));
                    list3.add(Integer.valueOf(mj2.a));
                    list4.add(Integer.valueOf(mj.a));
                    mj.a += mj2.a;
                    mj3.a = Math.max(mj3.a, mj4.a);
                    list2.clear();
                    mj4.a = 0;
                    mj2.a = 0;
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    MJ mj;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    MJ mj2 = new MJ();
                    MJ mj3 = new MJ();
                    ArrayList arrayList4 = new ArrayList();
                    MJ mj4 = new MJ();
                    MJ mj5 = new MJ();
                    Iterator<? extends Measurable> it = list.iterator();
                    while (it.hasNext()) {
                        Placeable placeableMo4159measureBRTryo0 = it.next().mo4159measureBRTryo0(j);
                        MJ mj6 = mj5;
                        if (measure_3p2s80s$canAddToCurrentSequence(arrayList4, mj4, measureScope, f, j, placeableMo4159measureBRTryo0)) {
                            mj = mj4;
                        } else {
                            mj = mj4;
                            measure_3p2s80s$startNewSequence(arrayList, mj3, measureScope, f2, arrayList4, arrayList2, mj6, arrayList3, mj2, mj);
                        }
                        MJ mj7 = mj;
                        if (!arrayList4.isEmpty()) {
                            mj7.a += measureScope.mo327roundToPx0680j_4(f);
                        }
                        ArrayList arrayList5 = arrayList4;
                        arrayList5.add(placeableMo4159measureBRTryo0);
                        mj7.a += placeableMo4159measureBRTryo0.getWidth();
                        mj5 = mj6;
                        mj5.a = Math.max(mj5.a, placeableMo4159measureBRTryo0.getHeight());
                        arrayList4 = arrayList5;
                        mj4 = mj7;
                        mj3 = mj3;
                    }
                    ArrayList arrayList6 = arrayList4;
                    MJ mj8 = mj3;
                    MJ mj9 = mj4;
                    if (!arrayList6.isEmpty()) {
                        measure_3p2s80s$startNewSequence(arrayList, mj8, measureScope, f2, arrayList6, arrayList2, mj5, arrayList3, mj2, mj9);
                    }
                    int iMax = Math.max(mj2.a, Constraints.m5130getMinWidthimpl(j));
                    return MeasureScope.CC.q(measureScope, iMax, Math.max(mj8.a, Constraints.m5129getMinHeightimpl(j)), null, new AlertDialogKt$AlertDialogFlowRow$1$measure$1(arrayList, measureScope, f, iMax, arrayList3), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i3);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
            int i3 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f, f2, interfaceC0526Fp, i));
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }
}
