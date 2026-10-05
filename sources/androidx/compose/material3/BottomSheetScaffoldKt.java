package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.QO;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt {

    /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$rememberStandardBottomSheetState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14711 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14711 INSTANCE = new C14711();

        public C14711() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(SheetValue sheetValue) {
            AbstractC4492zt.h(sheetValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0138  */
    /* JADX WARN: Code duplicated, block: B:103:0x013e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0141  */
    /* JADX WARN: Code duplicated, block: B:108:0x0149  */
    /* JADX WARN: Code duplicated, block: B:109:0x014e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0154  */
    /* JADX WARN: Code duplicated, block: B:113:0x015a  */
    /* JADX WARN: Code duplicated, block: B:114:0x015d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0162  */
    /* JADX WARN: Code duplicated, block: B:119:0x0168  */
    /* JADX WARN: Code duplicated, block: B:121:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0175  */
    /* JADX WARN: Code duplicated, block: B:125:0x017b  */
    /* JADX WARN: Code duplicated, block: B:126:0x017e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0187  */
    /* JADX WARN: Code duplicated, block: B:132:0x018c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0190  */
    /* JADX WARN: Code duplicated, block: B:136:0x0198  */
    /* JADX WARN: Code duplicated, block: B:137:0x019b  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:148:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:153:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:156:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:161:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:163:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:165:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:167:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:168:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:171:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:177:0x022d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0234  */
    /* JADX WARN: Code duplicated, block: B:201:0x028a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:202:0x028c  */
    /* JADX WARN: Code duplicated, block: B:203:0x028f  */
    /* JADX WARN: Code duplicated, block: B:206:0x0296  */
    /* JADX WARN: Code duplicated, block: B:207:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:209:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:210:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:213:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:214:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:217:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:218:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:221:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:222:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:224:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:225:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:227:0x0301  */
    /* JADX WARN: Code duplicated, block: B:228:0x0308  */
    /* JADX WARN: Code duplicated, block: B:230:0x030c  */
    /* JADX WARN: Code duplicated, block: B:231:0x0313  */
    /* JADX WARN: Code duplicated, block: B:233:0x0317  */
    /* JADX WARN: Code duplicated, block: B:234:0x0319  */
    /* JADX WARN: Code duplicated, block: B:236:0x031d  */
    /* JADX WARN: Code duplicated, block: B:237:0x0320  */
    /* JADX WARN: Code duplicated, block: B:239:0x0324  */
    /* JADX WARN: Code duplicated, block: B:240:0x032b  */
    /* JADX WARN: Code duplicated, block: B:243:0x0331  */
    /* JADX WARN: Code duplicated, block: B:244:0x0342  */
    /* JADX WARN: Code duplicated, block: B:247:0x034b  */
    /* JADX WARN: Code duplicated, block: B:248:0x036b  */
    /* JADX WARN: Code duplicated, block: B:251:0x0387  */
    /* JADX WARN: Code duplicated, block: B:254:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:256:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:259:0x0433  */
    /* JADX WARN: Code duplicated, block: B:264:0x044a  */
    /* JADX WARN: Code duplicated, block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0086  */
    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:48:0x0098  */
    /* JADX WARN: Code duplicated, block: B:50:0x009e  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00df  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:84:0x0102  */
    /* JADX WARN: Code duplicated, block: B:88:0x0109  */
    /* JADX WARN: Code duplicated, block: B:89:0x0110  */
    /* JADX WARN: Code duplicated, block: B:91:0x0118  */
    /* JADX WARN: Code duplicated, block: B:93:0x011e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0121  */
    /* JADX WARN: Code duplicated, block: B:98:0x0129  */
    /* JADX WARN: Code duplicated, block: B:99:0x0130  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomSheetScaffold-6cEcpDs, reason: not valid java name */
    public static final void m1349BottomSheetScaffold6cEcpDs(InterfaceC0552Gp interfaceC0552Gp, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, Shape shape, long j, long j2, float f2, float f3, InterfaceC0526Fp interfaceC0526Fp, boolean z, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0552Gp interfaceC0552Gp2, long j3, long j4, InterfaceC0552Gp interfaceC0552Gp3, Composer composer, int i, int i2, int i3) {
        int i4;
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
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        Modifier modifier2;
        BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
        float fM1348getSheetPeekHeightD9Ej5fM;
        int i24;
        Shape expandedShape;
        float f4;
        long containerColor;
        long jM1449contentColorForek8zF_U;
        float fM1347getElevationD9Ej5fM;
        float fM1347getElevationD9Ej5fM2;
        InterfaceC0526Fp interfaceC0526FpM1467getLambda1$material3_release;
        boolean z2;
        InterfaceC0526Fp interfaceC0526Fp3;
        InterfaceC0552Gp interfaceC0552GpM1468getLambda2$material3_release;
        int i25;
        long jM1413getSurface0d7_KjU;
        InterfaceC0526Fp interfaceC0526Fp4;
        Modifier modifier3;
        long j5;
        int i26;
        long j6;
        int i27;
        float f5;
        InterfaceC0526Fp interfaceC0526Fp5;
        boolean z3;
        InterfaceC0552Gp interfaceC0552Gp4;
        Shape shape2;
        float f6;
        BottomSheetScaffoldState bottomSheetScaffoldState2;
        boolean zChanged;
        Object objRememberedValue;
        Shape shape3;
        float f7;
        BottomSheetScaffoldState bottomSheetScaffoldState3;
        float f8;
        InterfaceC0526Fp interfaceC0526Fp6;
        boolean z4;
        InterfaceC0552Gp interfaceC0552Gp5;
        float f9;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i28;
        int i29;
        int i30;
        AbstractC4492zt.h(interfaceC0552Gp, "sheetContent");
        AbstractC4492zt.h(interfaceC0552Gp3, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(144898711);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i31 = i3 & 2;
        if (i31 == 0) {
            if ((i & 112) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                i4 |= ((i3 & 4) == 0 || !composerStartRestartGroup.changed(bottomSheetScaffoldState)) ? 128 : 256;
            }
            i5 = i3 & 8;
            i6 = 1024;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i4 |= i7;
                }
                i8 = 8192;
                if ((i & 57344) != 0) {
                    if ((i3 & 16) == 0 || !composerStartRestartGroup.changed(shape)) {
                        i30 = 8192;
                    } else {
                        i30 = 16384;
                    }
                    i4 |= i30;
                }
                if ((i & 458752) != 0) {
                    if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(j)) {
                        i29 = 65536;
                    } else {
                        i29 = 131072;
                    }
                    i4 |= i29;
                }
                if ((i & 3670016) != 0) {
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i28 = 524288;
                    } else {
                        i28 = 1048576;
                    }
                    i4 |= i28;
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i14 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                i18 = i3 & 2048;
                if (i18 != 0) {
                    i16 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i19 = 32;
                    } else {
                        i19 = 16;
                    }
                    i16 |= i19;
                }
                i20 = i16;
                i21 = i3 & 4096;
                if (i21 != 0) {
                    if ((i2 & 896) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                            i22 = 256;
                        } else {
                            i22 = 128;
                        }
                        i20 |= i22;
                    }
                    if ((i2 & 7168) != 0) {
                        if ((i3 & 8192) == 0 && composerStartRestartGroup.changed(j3)) {
                            i6 = 2048;
                        }
                        i20 |= i6;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(j4)) {
                            i8 = 16384;
                        }
                        i20 |= i8;
                    }
                    if ((i3 & 32768) != 0) {
                        if ((i2 & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                                i23 = 131072;
                            } else {
                                i23 = 65536;
                            }
                        }
                        if ((i4 & 1533916891) != 306783378 && (374491 & i20) == 74898 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier;
                            bottomSheetScaffoldState3 = bottomSheetScaffoldState;
                            f8 = f;
                            shape3 = shape;
                            containerColor = j;
                            jM1449contentColorForek8zF_U = j2;
                            f9 = f2;
                            f7 = f3;
                            interfaceC0526Fp6 = interfaceC0526Fp;
                            z4 = z;
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                            interfaceC0552Gp5 = interfaceC0552Gp2;
                            j6 = j3;
                            j5 = j4;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i31 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if ((i3 & 4) != 0) {
                                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                    i4 &= -897;
                                } else {
                                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                                }
                                if (i5 != 0) {
                                    fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                                } else {
                                    fM1348getSheetPeekHeightD9Ej5fM = f;
                                }
                                if ((i3 & 16) != 0) {
                                    i24 = 6;
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                    i4 &= -57345;
                                } else {
                                    i24 = 6;
                                    expandedShape = shape;
                                }
                                f4 = fM1348getSheetPeekHeightD9Ej5fM;
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 64) != 0) {
                                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                    i4 &= -3670017;
                                } else {
                                    jM1449contentColorForek8zF_U = j2;
                                }
                                if (i9 != 0) {
                                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                                } else {
                                    fM1347getElevationD9Ej5fM = f2;
                                }
                                if (i11 != 0) {
                                    fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                                } else {
                                    fM1347getElevationD9Ej5fM2 = f3;
                                }
                                if (i13 != 0) {
                                    interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                                } else {
                                    interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                                }
                                if (i15 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if (i18 != 0) {
                                    interfaceC0526Fp3 = null;
                                } else {
                                    interfaceC0526Fp3 = interfaceC0526Fp2;
                                }
                                if (i21 != 0) {
                                    interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                                } else {
                                    interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                                }
                                if ((i3 & 8192) != 0) {
                                    i25 = i20 & (-7169);
                                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                                } else {
                                    i25 = i20;
                                    jM1413getSurface0d7_KjU = j3;
                                }
                                interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                                if ((i3 & 16384) != 0) {
                                    long jM1449contentColorForek8zF_U2 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                    i27 = (-57345) & i25;
                                    i26 = i4;
                                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                    j5 = jM1449contentColorForek8zF_U2;
                                    modifier3 = modifier2;
                                    f5 = f4;
                                    f6 = fM1347getElevationD9Ej5fM2;
                                    j6 = jM1413getSurface0d7_KjU;
                                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                    interfaceC0526Fp5 = interfaceC0526Fp4;
                                    z3 = z2;
                                    shape2 = expandedShape;
                                } else {
                                    modifier3 = modifier2;
                                    j5 = j4;
                                    i26 = i4;
                                    j6 = jM1413getSurface0d7_KjU;
                                    i27 = i25;
                                    f5 = f4;
                                    interfaceC0526Fp5 = interfaceC0526Fp4;
                                    z3 = z2;
                                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                    shape2 = expandedShape;
                                    f6 = fM1347getElevationD9Ej5fM2;
                                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 8192) != 0) {
                                    i20 &= -7169;
                                }
                                if ((i3 & 16384) != 0) {
                                    i20 &= -57345;
                                }
                                modifier3 = modifier;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                                shape2 = shape;
                                containerColor = j;
                                jM1449contentColorForek8zF_U = j2;
                                fM1347getElevationD9Ej5fM = f2;
                                f6 = f3;
                                interfaceC0526Fp5 = interfaceC0526Fp;
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                                interfaceC0552Gp4 = interfaceC0552Gp2;
                                j6 = j3;
                                j5 = j4;
                                i26 = i4;
                                i27 = i20;
                                f5 = f;
                                z3 = z;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                            }
                            SheetState bottomSheetState = bottomSheetScaffoldState2.getBottomSheetState();
                            Shape shape4 = shape2;
                            float f10 = f6;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                            float f11 = fM1347getElevationD9Ej5fM;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldState2;
                            int i32 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                            int i33 = i27 << 15;
                            m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda, composableLambda2, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState, j6, j5, composerStartRestartGroup, i32 | (234881024 & i33) | (i33 & 1879048192));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape3 = shape4;
                            f7 = f10;
                            bottomSheetScaffoldState3 = bottomSheetScaffoldState4;
                            f8 = f5;
                            interfaceC0526Fp6 = interfaceC0526Fp5;
                            z4 = z3;
                            interfaceC0552Gp5 = interfaceC0552Gp4;
                            f9 = f11;
                            modifier4 = modifier3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
                    }
                    i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i20 |= i23;
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U3 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U3;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U4 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U4;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState2 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape5 = shape2;
                        float f12 = f6;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f13 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState5 = bottomSheetScaffoldState2;
                        int i34 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i35 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda3, composableLambda4, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState2, j6, j5, composerStartRestartGroup, i34 | (234881024 & i35) | (i35 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape5;
                        f7 = f12;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState5;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f13;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U5 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U5;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U6 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U6;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState3 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape6 = shape2;
                        float f14 = f6;
                        ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f15 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldState2;
                        int i36 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i37 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda5, composableLambda6, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState3, j6, j5, composerStartRestartGroup, i36 | (234881024 & i37) | (i37 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape6;
                        f7 = f14;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState6;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f15;
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
                }
                i20 |= 384;
                if ((i2 & 7168) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i20 |= i6;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i20 |= i8;
                }
                if ((i3 & 32768) != 0) {
                    if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                            i23 = 131072;
                        } else {
                            i23 = 65536;
                        }
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U7 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U7;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U8 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U8;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState4 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape7 = shape2;
                        float f16 = f6;
                        ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f17 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState7 = bottomSheetScaffoldState2;
                        int i38 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i39 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda7, composableLambda8, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState4, j6, j5, composerStartRestartGroup, i38 | (234881024 & i39) | (i39 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape7;
                        f7 = f16;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState7;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f17;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U9 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U9;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U10 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U10;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState5 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape8 = shape2;
                        float f18 = f6;
                        ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f19 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState8 = bottomSheetScaffoldState2;
                        int i310 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i311 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda9, composableLambda10, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState5, j6, j5, composerStartRestartGroup, i310 | (234881024 & i311) | (i311 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape8;
                        f7 = f18;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState8;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f19;
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
                }
                i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i20 |= i23;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U11 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U11;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U12 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U12;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState6 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape9 = shape2;
                    float f110 = f6;
                    ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f111 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState9 = bottomSheetScaffoldState2;
                    int i312 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i313 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda11, composableLambda12, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState6, j6, j5, composerStartRestartGroup, i312 | (234881024 & i313) | (i313 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape9;
                    f7 = f110;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState9;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f111;
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U13 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U13;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U14 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U14;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState7 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape10 = shape2;
                    float f112 = f6;
                    ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f113 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState10 = bottomSheetScaffoldState2;
                    int i314 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i315 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda13, composableLambda14, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState7, j6, j5, composerStartRestartGroup, i314 | (234881024 & i315) | (i315 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape10;
                    f7 = f112;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState10;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f113;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
            }
            i4 |= 3072;
            i8 = 8192;
            if ((i & 57344) != 0) {
                if ((i3 & 16) == 0) {
                    i30 = 8192;
                } else {
                    i30 = 8192;
                }
                i4 |= i30;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i29 = 65536;
                } else {
                    i29 = 65536;
                }
                i4 |= i29;
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i28 = 524288;
                } else {
                    i28 = 524288;
                }
                i4 |= i28;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            i18 = i3 & 2048;
            if (i18 != 0) {
                i16 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i19 = 32;
                } else {
                    i19 = 16;
                }
                i16 |= i19;
            }
            i20 = i16;
            i21 = i3 & 4096;
            if (i21 != 0) {
                if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i22 = 256;
                    } else {
                        i22 = 128;
                    }
                    i20 |= i22;
                }
                if ((i2 & 7168) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i20 |= i6;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i20 |= i8;
                }
                if ((i3 & 32768) != 0) {
                    if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                            i23 = 131072;
                        } else {
                            i23 = 65536;
                        }
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U15 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U15;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U16 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U16;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState8 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape11 = shape2;
                        float f114 = f6;
                        ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f115 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda16 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState11 = bottomSheetScaffoldState2;
                        int i316 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i317 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda15, composableLambda16, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState8, j6, j5, composerStartRestartGroup, i316 | (234881024 & i317) | (i317 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape11;
                        f7 = f114;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState11;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f115;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U17 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U17;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U18 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U18;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState9 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape12 = shape2;
                        float f116 = f6;
                        ComposableLambda composableLambda17 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f117 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda18 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState12 = bottomSheetScaffoldState2;
                        int i318 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i319 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda17, composableLambda18, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState9, j6, j5, composerStartRestartGroup, i318 | (234881024 & i319) | (i319 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape12;
                        f7 = f116;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState12;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f117;
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
                }
                i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i20 |= i23;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U19 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U19;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U110 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U110;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState10 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape13 = shape2;
                    float f118 = f6;
                    ComposableLambda composableLambda19 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f119 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState13 = bottomSheetScaffoldState2;
                    int i3110 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i3111 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda19, composableLambda110, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState10, j6, j5, composerStartRestartGroup, i3110 | (234881024 & i3111) | (i3111 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape13;
                    f7 = f118;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState13;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f119;
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U111 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U111;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U112 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U112;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState11 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape14 = shape2;
                    float f1110 = f6;
                    ComposableLambda composableLambda111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f1111 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState14 = bottomSheetScaffoldState2;
                    int i3112 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i3113 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda111, composableLambda112, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState11, j6, j5, composerStartRestartGroup, i3112 | (234881024 & i3113) | (i3113 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape14;
                    f7 = f1110;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState14;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f1111;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
            }
            i20 |= 384;
            if ((i2 & 7168) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i20 |= i6;
            }
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i8 = 16384;
                }
                i20 |= i8;
            }
            if ((i3 & 32768) != 0) {
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U113 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U113;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U114 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U114;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState12 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape15 = shape2;
                    float f1112 = f6;
                    ComposableLambda composableLambda113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f1113 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda114 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState15 = bottomSheetScaffoldState2;
                    int i3114 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i3115 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda113, composableLambda114, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState12, j6, j5, composerStartRestartGroup, i3114 | (234881024 & i3115) | (i3115 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape15;
                    f7 = f1112;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState15;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f1113;
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U115 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U115;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U116 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U116;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState13 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape16 = shape2;
                    float f1114 = f6;
                    ComposableLambda composableLambda115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f1115 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda116 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState16 = bottomSheetScaffoldState2;
                    int i3116 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i3117 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda115, composableLambda116, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState13, j6, j5, composerStartRestartGroup, i3116 | (234881024 & i3117) | (i3117 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape16;
                    f7 = f1114;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState16;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f1115;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
            }
            i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i20 |= i23;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U117 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U117;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U118 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U118;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState14 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape17 = shape2;
                float f1116 = f6;
                ComposableLambda composableLambda117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f1117 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda118 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState17 = bottomSheetScaffoldState2;
                int i3118 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i3119 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda117, composableLambda118, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState14, j6, j5, composerStartRestartGroup, i3118 | (234881024 & i3119) | (i3119 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape17;
                f7 = f1116;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState17;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f1117;
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U119 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U119;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U1110 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U1110;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState15 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape18 = shape2;
                float f1118 = f6;
                ComposableLambda composableLambda119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f1119 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda1110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState18 = bottomSheetScaffoldState2;
                int i31110 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i31111 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda119, composableLambda1110, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState15, j6, j5, composerStartRestartGroup, i31110 | (234881024 & i31111) | (i31111 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape18;
                f7 = f1118;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState18;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f1119;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
        }
        i4 |= 48;
        if ((i & 896) != 0) {
            i4 |= ((i3 & 4) == 0 || !composerStartRestartGroup.changed(bottomSheetScaffoldState)) ? 128 : 256;
        }
        i5 = i3 & 8;
        i6 = 1024;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i4 |= i7;
            }
            i8 = 8192;
            if ((i & 57344) != 0) {
                if ((i3 & 16) == 0) {
                    i30 = 8192;
                } else {
                    i30 = 8192;
                }
                i4 |= i30;
            }
            if ((i & 458752) != 0) {
                if ((i3 & 32) == 0) {
                    i29 = 65536;
                } else {
                    i29 = 65536;
                }
                i4 |= i29;
            }
            if ((i & 3670016) != 0) {
                if ((i3 & 64) == 0) {
                    i28 = 524288;
                } else {
                    i28 = 524288;
                }
                i4 |= i28;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i14 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            i18 = i3 & 2048;
            if (i18 != 0) {
                i16 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i19 = 32;
                } else {
                    i19 = 16;
                }
                i16 |= i19;
            }
            i20 = i16;
            i21 = i3 & 4096;
            if (i21 != 0) {
                if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                        i22 = 256;
                    } else {
                        i22 = 128;
                    }
                    i20 |= i22;
                }
                if ((i2 & 7168) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i20 |= i6;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i8 = 16384;
                    }
                    i20 |= i8;
                }
                if ((i3 & 32768) != 0) {
                    if ((i2 & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                            i23 = 131072;
                        } else {
                            i23 = 65536;
                        }
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U1111 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U1111;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U1112 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U1112;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState16 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape19 = shape2;
                        float f11110 = f6;
                        ComposableLambda composableLambda1111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f11111 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda1112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState19 = bottomSheetScaffoldState2;
                        int i31112 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i31113 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda1111, composableLambda1112, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState16, j6, j5, composerStartRestartGroup, i31112 | (234881024 & i31113) | (i31113 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape19;
                        f7 = f11110;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState19;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f11111;
                        modifier4 = modifier3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U1113 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U1113;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        } else {
                            if (i31 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                            }
                            if (i5 != 0) {
                                fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                            } else {
                                fM1348getSheetPeekHeightD9Ej5fM = f;
                            }
                            if ((i3 & 16) != 0) {
                                i24 = 6;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                i24 = 6;
                                expandedShape = shape;
                            }
                            f4 = fM1348getSheetPeekHeightD9Ej5fM;
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 64) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                                i4 &= -3670017;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i9 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if (i11 != 0) {
                                fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM2 = f3;
                            }
                            if (i13 != 0) {
                                interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                            } else {
                                interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if (i18 != 0) {
                                interfaceC0526Fp3 = null;
                            } else {
                                interfaceC0526Fp3 = interfaceC0526Fp2;
                            }
                            if (i21 != 0) {
                                interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                            } else {
                                interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                            }
                            if ((i3 & 8192) != 0) {
                                i25 = i20 & (-7169);
                                jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                            } else {
                                i25 = i20;
                                jM1413getSurface0d7_KjU = j3;
                            }
                            interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                            if ((i3 & 16384) != 0) {
                                long jM1449contentColorForek8zF_U1114 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                                i27 = (-57345) & i25;
                                i26 = i4;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                j5 = jM1449contentColorForek8zF_U1114;
                                modifier3 = modifier2;
                                f5 = f4;
                                f6 = fM1347getElevationD9Ej5fM2;
                                j6 = jM1413getSurface0d7_KjU;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                shape2 = expandedShape;
                            } else {
                                modifier3 = modifier2;
                                j5 = j4;
                                i26 = i4;
                                j6 = jM1413getSurface0d7_KjU;
                                i27 = i25;
                                f5 = f4;
                                interfaceC0526Fp5 = interfaceC0526Fp4;
                                z3 = z2;
                                interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                                shape2 = expandedShape;
                                f6 = fM1347getElevationD9Ej5fM2;
                                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                        }
                        SheetState bottomSheetState17 = bottomSheetScaffoldState2.getBottomSheetState();
                        Shape shape110 = shape2;
                        float f11112 = f6;
                        ComposableLambda composableLambda1113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                        float f11113 = fM1347getElevationD9Ej5fM;
                        ComposableLambda composableLambda1114 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BottomSheetScaffoldState bottomSheetScaffoldState110 = bottomSheetScaffoldState2;
                        int i31114 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                        int i31115 = i27 << 15;
                        m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda1113, composableLambda1114, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState17, j6, j5, composerStartRestartGroup, i31114 | (234881024 & i31115) | (i31115 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape110;
                        f7 = f11112;
                        bottomSheetScaffoldState3 = bottomSheetScaffoldState110;
                        f8 = f5;
                        interfaceC0526Fp6 = interfaceC0526Fp5;
                        z4 = z3;
                        interfaceC0552Gp5 = interfaceC0552Gp4;
                        f9 = f11113;
                        modifier4 = modifier3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
                }
                i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i20 |= i23;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U1115 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U1115;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U1116 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U1116;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState18 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape111 = shape2;
                    float f11114 = f6;
                    ComposableLambda composableLambda1115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f11115 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda1116 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState111 = bottomSheetScaffoldState2;
                    int i31116 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i31117 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda1115, composableLambda1116, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState18, j6, j5, composerStartRestartGroup, i31116 | (234881024 & i31117) | (i31117 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape111;
                    f7 = f11114;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState111;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f11115;
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U1117 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U1117;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U1118 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U1118;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState19 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape112 = shape2;
                    float f11116 = f6;
                    ComposableLambda composableLambda1117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f11117 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda1118 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState112 = bottomSheetScaffoldState2;
                    int i31118 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i31119 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda1117, composableLambda1118, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState19, j6, j5, composerStartRestartGroup, i31118 | (234881024 & i31119) | (i31119 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape112;
                    f7 = f11116;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState112;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f11117;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
            }
            i20 |= 384;
            if ((i2 & 7168) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i20 |= i6;
            }
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i8 = 16384;
                }
                i20 |= i8;
            }
            if ((i3 & 32768) != 0) {
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U1119 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U1119;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U11110 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U11110;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState110 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape113 = shape2;
                    float f11118 = f6;
                    ComposableLambda composableLambda1119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f11119 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda11110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState113 = bottomSheetScaffoldState2;
                    int i311110 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i311111 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda1119, composableLambda11110, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState110, j6, j5, composerStartRestartGroup, i311110 | (234881024 & i311111) | (i311111 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape113;
                    f7 = f11118;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState113;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f11119;
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U11111 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U11111;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U11112 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U11112;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState111 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape114 = shape2;
                    float f111110 = f6;
                    ComposableLambda composableLambda11111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f111111 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda11112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState114 = bottomSheetScaffoldState2;
                    int i311112 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i311113 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda11111, composableLambda11112, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState111, j6, j5, composerStartRestartGroup, i311112 | (234881024 & i311113) | (i311113 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape114;
                    f7 = f111110;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState114;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f111111;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
            }
            i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i20 |= i23;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U11113 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U11113;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U11114 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U11114;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState112 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape115 = shape2;
                float f111112 = f6;
                ComposableLambda composableLambda11113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f111113 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda11114 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState115 = bottomSheetScaffoldState2;
                int i311114 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i311115 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda11113, composableLambda11114, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState112, j6, j5, composerStartRestartGroup, i311114 | (234881024 & i311115) | (i311115 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape115;
                f7 = f111112;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState115;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f111113;
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U11115 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U11115;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U11116 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U11116;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState113 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape116 = shape2;
                float f111114 = f6;
                ComposableLambda composableLambda11115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f111115 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda11116 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState116 = bottomSheetScaffoldState2;
                int i311116 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i311117 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda11115, composableLambda11116, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState113, j6, j5, composerStartRestartGroup, i311116 | (234881024 & i311117) | (i311117 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape116;
                f7 = f111114;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState116;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f111115;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
        }
        i4 |= 3072;
        i8 = 8192;
        if ((i & 57344) != 0) {
            if ((i3 & 16) == 0) {
                i30 = 8192;
            } else {
                i30 = 8192;
            }
            i4 |= i30;
        }
        if ((i & 458752) != 0) {
            if ((i3 & 32) == 0) {
                i29 = 65536;
            } else {
                i29 = 65536;
            }
            i4 |= i29;
        }
        if ((i & 3670016) != 0) {
            if ((i3 & 64) == 0) {
                i28 = 524288;
            } else {
                i28 = 524288;
            }
            i4 |= i28;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i4 |= i10;
        }
        i11 = i3 & 256;
        if (i11 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(f3)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i4 |= i12;
        }
        i13 = i3 & 512;
        if (i13 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i14 = PropertyOptions.DELETE_EXISTING;
            } else {
                i14 = 268435456;
            }
            i4 |= i14;
        }
        i15 = i3 & 1024;
        if (i15 != 0) {
            i16 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i16 = i2 | i17;
        } else {
            i16 = i2;
        }
        i18 = i3 & 2048;
        if (i18 != 0) {
            i16 |= 48;
        } else if ((i2 & 112) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i16 |= i19;
        }
        i20 = i16;
        i21 = i3 & 4096;
        if (i21 != 0) {
            if ((i2 & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp2)) {
                    i22 = 256;
                } else {
                    i22 = 128;
                }
                i20 |= i22;
            }
            if ((i2 & 7168) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i20 |= i6;
            }
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i8 = 16384;
                }
                i20 |= i8;
            }
            if ((i3 & 32768) != 0) {
                if ((i2 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                        i23 = 131072;
                    } else {
                        i23 = 65536;
                    }
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U11117 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U11117;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U11118 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U11118;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState114 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape117 = shape2;
                    float f111116 = f6;
                    ComposableLambda composableLambda11117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f111117 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda11118 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState117 = bottomSheetScaffoldState2;
                    int i311118 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i311119 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda11117, composableLambda11118, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState114, j6, j5, composerStartRestartGroup, i311118 | (234881024 & i311119) | (i311119 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape117;
                    f7 = f111116;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState117;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f111117;
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U11119 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U11119;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    } else {
                        if (i31 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                        }
                        if (i5 != 0) {
                            fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                        } else {
                            fM1348getSheetPeekHeightD9Ej5fM = f;
                        }
                        if ((i3 & 16) != 0) {
                            i24 = 6;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            i24 = 6;
                            expandedShape = shape;
                        }
                        f4 = fM1348getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 64) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                            i4 &= -3670017;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i9 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if (i11 != 0) {
                            fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM2 = f3;
                        }
                        if (i13 != 0) {
                            interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                        } else {
                            interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (i18 != 0) {
                            interfaceC0526Fp3 = null;
                        } else {
                            interfaceC0526Fp3 = interfaceC0526Fp2;
                        }
                        if (i21 != 0) {
                            interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                        } else {
                            interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                        }
                        if ((i3 & 8192) != 0) {
                            i25 = i20 & (-7169);
                            jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                        } else {
                            i25 = i20;
                            jM1413getSurface0d7_KjU = j3;
                        }
                        interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                        if ((i3 & 16384) != 0) {
                            long jM1449contentColorForek8zF_U111110 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                            i27 = (-57345) & i25;
                            i26 = i4;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            j5 = jM1449contentColorForek8zF_U111110;
                            modifier3 = modifier2;
                            f5 = f4;
                            f6 = fM1347getElevationD9Ej5fM2;
                            j6 = jM1413getSurface0d7_KjU;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            shape2 = expandedShape;
                        } else {
                            modifier3 = modifier2;
                            j5 = j4;
                            i26 = i4;
                            j6 = jM1413getSurface0d7_KjU;
                            i27 = i25;
                            f5 = f4;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            z3 = z2;
                            interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                            shape2 = expandedShape;
                            f6 = fM1347getElevationD9Ej5fM2;
                            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                    }
                    SheetState bottomSheetState115 = bottomSheetScaffoldState2.getBottomSheetState();
                    Shape shape118 = shape2;
                    float f111118 = f6;
                    ComposableLambda composableLambda11119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                    float f111119 = fM1347getElevationD9Ej5fM;
                    ComposableLambda composableLambda111110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BottomSheetScaffoldState bottomSheetScaffoldState118 = bottomSheetScaffoldState2;
                    int i3111110 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                    int i3111111 = i27 << 15;
                    m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda11119, composableLambda111110, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState115, j6, j5, composerStartRestartGroup, i3111110 | (234881024 & i3111111) | (i3111111 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape118;
                    f7 = f111118;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState118;
                    f8 = f5;
                    interfaceC0526Fp6 = interfaceC0526Fp5;
                    z4 = z3;
                    interfaceC0552Gp5 = interfaceC0552Gp4;
                    f9 = f111119;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
            }
            i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i20 |= i23;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111111 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111111;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111112 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111112;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState116 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape119 = shape2;
                float f1111110 = f6;
                ComposableLambda composableLambda111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f1111111 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda111112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState119 = bottomSheetScaffoldState2;
                int i3111112 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i3111113 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda111111, composableLambda111112, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState116, j6, j5, composerStartRestartGroup, i3111112 | (234881024 & i3111113) | (i3111113 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape119;
                f7 = f1111110;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState119;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f1111111;
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111113 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111113;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111114 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111114;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState117 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape1110 = shape2;
                float f1111112 = f6;
                ComposableLambda composableLambda111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f1111113 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda111114 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState1110 = bottomSheetScaffoldState2;
                int i3111114 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i3111115 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda111113, composableLambda111114, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState117, j6, j5, composerStartRestartGroup, i3111114 | (234881024 & i3111115) | (i3111115 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape1110;
                f7 = f1111112;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState1110;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f1111113;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
        }
        i20 |= 384;
        if ((i2 & 7168) != 0) {
            if ((i3 & 8192) == 0) {
                i6 = 2048;
            }
            i20 |= i6;
        }
        if ((i2 & 57344) != 0) {
            if ((i3 & 16384) == 0) {
                i8 = 16384;
            }
            i20 |= i8;
        }
        if ((i3 & 32768) != 0) {
            if ((i2 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp3)) {
                    i23 = 131072;
                } else {
                    i23 = 65536;
                }
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111115 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111115;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111116 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111116;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState118 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape1111 = shape2;
                float f1111114 = f6;
                ComposableLambda composableLambda111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f1111115 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda111116 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState1111 = bottomSheetScaffoldState2;
                int i3111116 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i3111117 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda111115, composableLambda111116, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState118, j6, j5, composerStartRestartGroup, i3111116 | (234881024 & i3111117) | (i3111117 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape1111;
                f7 = f1111114;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState1111;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f1111115;
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111117 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111117;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                } else {
                    if (i31 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    }
                    if (i5 != 0) {
                        fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                    } else {
                        fM1348getSheetPeekHeightD9Ej5fM = f;
                    }
                    if ((i3 & 16) != 0) {
                        i24 = 6;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        i24 = 6;
                        expandedShape = shape;
                    }
                    f4 = fM1348getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 64) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                        i4 &= -3670017;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i9 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if (i11 != 0) {
                        fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM2 = f3;
                    }
                    if (i13 != 0) {
                        interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (i18 != 0) {
                        interfaceC0526Fp3 = null;
                    } else {
                        interfaceC0526Fp3 = interfaceC0526Fp2;
                    }
                    if (i21 != 0) {
                        interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                    } else {
                        interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                    }
                    if ((i3 & 8192) != 0) {
                        i25 = i20 & (-7169);
                        jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                    } else {
                        i25 = i20;
                        jM1413getSurface0d7_KjU = j3;
                    }
                    interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                    if ((i3 & 16384) != 0) {
                        long jM1449contentColorForek8zF_U111118 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                        i27 = (-57345) & i25;
                        i26 = i4;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        j5 = jM1449contentColorForek8zF_U111118;
                        modifier3 = modifier2;
                        f5 = f4;
                        f6 = fM1347getElevationD9Ej5fM2;
                        j6 = jM1413getSurface0d7_KjU;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        shape2 = expandedShape;
                    } else {
                        modifier3 = modifier2;
                        j5 = j4;
                        i26 = i4;
                        j6 = jM1413getSurface0d7_KjU;
                        i27 = i25;
                        f5 = f4;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        z3 = z2;
                        interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                        shape2 = expandedShape;
                        f6 = fM1347getElevationD9Ej5fM2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
                }
                SheetState bottomSheetState119 = bottomSheetScaffoldState2.getBottomSheetState();
                Shape shape1112 = shape2;
                float f1111116 = f6;
                ComposableLambda composableLambda111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
                float f1111117 = fM1347getElevationD9Ej5fM;
                ComposableLambda composableLambda111118 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BottomSheetScaffoldState bottomSheetScaffoldState1112 = bottomSheetScaffoldState2;
                int i3111118 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
                int i3111119 = i27 << 15;
                m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda111117, composableLambda111118, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState119, j6, j5, composerStartRestartGroup, i3111118 | (234881024 & i3111119) | (i3111119 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape1112;
                f7 = f1111116;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState1112;
                f8 = f5;
                interfaceC0526Fp6 = interfaceC0526Fp5;
                z4 = z3;
                interfaceC0552Gp5 = interfaceC0552Gp4;
                f9 = f1111117;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
        }
        i23 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i20 |= i23;
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i31 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                }
                if (i5 != 0) {
                    fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                } else {
                    fM1348getSheetPeekHeightD9Ej5fM = f;
                }
                if ((i3 & 16) != 0) {
                    i24 = 6;
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    i24 = 6;
                    expandedShape = shape;
                }
                f4 = fM1348getSheetPeekHeightD9Ej5fM;
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                } else {
                    containerColor = j;
                }
                if ((i3 & 64) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 &= -3670017;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM2 = f3;
                }
                if (i13 != 0) {
                    interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                }
                if (i15 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i18 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i21 != 0) {
                    interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                } else {
                    interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                }
                if ((i3 & 8192) != 0) {
                    i25 = i20 & (-7169);
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                } else {
                    i25 = i20;
                    jM1413getSurface0d7_KjU = j3;
                }
                interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                if ((i3 & 16384) != 0) {
                    long jM1449contentColorForek8zF_U111119 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                    i27 = (-57345) & i25;
                    i26 = i4;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    j5 = jM1449contentColorForek8zF_U111119;
                    modifier3 = modifier2;
                    f5 = f4;
                    f6 = fM1347getElevationD9Ej5fM2;
                    j6 = jM1413getSurface0d7_KjU;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    shape2 = expandedShape;
                } else {
                    modifier3 = modifier2;
                    j5 = j4;
                    i26 = i4;
                    j6 = jM1413getSurface0d7_KjU;
                    i27 = i25;
                    f5 = f4;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    shape2 = expandedShape;
                    f6 = fM1347getElevationD9Ej5fM2;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                }
            } else {
                if (i31 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                }
                if (i5 != 0) {
                    fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                } else {
                    fM1348getSheetPeekHeightD9Ej5fM = f;
                }
                if ((i3 & 16) != 0) {
                    i24 = 6;
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    i24 = 6;
                    expandedShape = shape;
                }
                f4 = fM1348getSheetPeekHeightD9Ej5fM;
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                } else {
                    containerColor = j;
                }
                if ((i3 & 64) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 &= -3670017;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM2 = f3;
                }
                if (i13 != 0) {
                    interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                }
                if (i15 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i18 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i21 != 0) {
                    interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                } else {
                    interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                }
                if ((i3 & 8192) != 0) {
                    i25 = i20 & (-7169);
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                } else {
                    i25 = i20;
                    jM1413getSurface0d7_KjU = j3;
                }
                interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                if ((i3 & 16384) != 0) {
                    long jM1449contentColorForek8zF_U1111110 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                    i27 = (-57345) & i25;
                    i26 = i4;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    j5 = jM1449contentColorForek8zF_U1111110;
                    modifier3 = modifier2;
                    f5 = f4;
                    f6 = fM1347getElevationD9Ej5fM2;
                    j6 = jM1413getSurface0d7_KjU;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    shape2 = expandedShape;
                } else {
                    modifier3 = modifier2;
                    j5 = j4;
                    i26 = i4;
                    j6 = jM1413getSurface0d7_KjU;
                    i27 = i25;
                    f5 = f4;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    shape2 = expandedShape;
                    f6 = fM1347getElevationD9Ej5fM2;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
            }
            SheetState bottomSheetState1110 = bottomSheetScaffoldState2.getBottomSheetState();
            Shape shape1113 = shape2;
            float f1111118 = f6;
            ComposableLambda composableLambda111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
            float f1111119 = fM1347getElevationD9Ej5fM;
            ComposableLambda composableLambda1111110 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            BottomSheetScaffoldState bottomSheetScaffoldState1113 = bottomSheetScaffoldState2;
            int i31111110 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
            int i31111111 = i27 << 15;
            m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda111119, composableLambda1111110, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState1110, j6, j5, composerStartRestartGroup, i31111110 | (234881024 & i31111111) | (i31111111 & 1879048192));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape1113;
            f7 = f1111118;
            bottomSheetScaffoldState3 = bottomSheetScaffoldState1113;
            f8 = f5;
            interfaceC0526Fp6 = interfaceC0526Fp5;
            z4 = z3;
            interfaceC0552Gp5 = interfaceC0552Gp4;
            f9 = f1111119;
            modifier4 = modifier3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i31 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                }
                if (i5 != 0) {
                    fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                } else {
                    fM1348getSheetPeekHeightD9Ej5fM = f;
                }
                if ((i3 & 16) != 0) {
                    i24 = 6;
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    i24 = 6;
                    expandedShape = shape;
                }
                f4 = fM1348getSheetPeekHeightD9Ej5fM;
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                } else {
                    containerColor = j;
                }
                if ((i3 & 64) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 &= -3670017;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM2 = f3;
                }
                if (i13 != 0) {
                    interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                }
                if (i15 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i18 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i21 != 0) {
                    interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                } else {
                    interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                }
                if ((i3 & 8192) != 0) {
                    i25 = i20 & (-7169);
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                } else {
                    i25 = i20;
                    jM1413getSurface0d7_KjU = j3;
                }
                interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                if ((i3 & 16384) != 0) {
                    long jM1449contentColorForek8zF_U1111111 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                    i27 = (-57345) & i25;
                    i26 = i4;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    j5 = jM1449contentColorForek8zF_U1111111;
                    modifier3 = modifier2;
                    f5 = f4;
                    f6 = fM1347getElevationD9Ej5fM2;
                    j6 = jM1413getSurface0d7_KjU;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    shape2 = expandedShape;
                } else {
                    modifier3 = modifier2;
                    j5 = j4;
                    i26 = i4;
                    j6 = jM1413getSurface0d7_KjU;
                    i27 = i25;
                    f5 = f4;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    shape2 = expandedShape;
                    f6 = fM1347getElevationD9Ej5fM2;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                }
            } else {
                if (i31 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i3 & 4) != 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                }
                if (i5 != 0) {
                    fM1348getSheetPeekHeightD9Ej5fM = BottomSheetDefaults.INSTANCE.m1348getSheetPeekHeightD9Ej5fM();
                } else {
                    fM1348getSheetPeekHeightD9Ej5fM = f;
                }
                if ((i3 & 16) != 0) {
                    i24 = 6;
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    i24 = 6;
                    expandedShape = shape;
                }
                f4 = fM1348getSheetPeekHeightD9Ej5fM;
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, i24);
                } else {
                    containerColor = j;
                }
                if ((i3 & 64) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 15) & 14);
                    i4 &= -3670017;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i9 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if (i11 != 0) {
                    fM1347getElevationD9Ej5fM2 = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM2 = f3;
                }
                if (i13 != 0) {
                    interfaceC0526FpM1467getLambda1$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1467getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1467getLambda1$material3_release = interfaceC0526Fp;
                }
                if (i15 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (i18 != 0) {
                    interfaceC0526Fp3 = null;
                } else {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                }
                if (i21 != 0) {
                    interfaceC0552GpM1468getLambda2$material3_release = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1468getLambda2$material3_release();
                } else {
                    interfaceC0552GpM1468getLambda2$material3_release = interfaceC0552Gp2;
                }
                if ((i3 & 8192) != 0) {
                    i25 = i20 & (-7169);
                    jM1413getSurface0d7_KjU = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1413getSurface0d7_KjU();
                } else {
                    i25 = i20;
                    jM1413getSurface0d7_KjU = j3;
                }
                interfaceC0526Fp4 = interfaceC0526FpM1467getLambda1$material3_release;
                if ((i3 & 16384) != 0) {
                    long jM1449contentColorForek8zF_U1111112 = ColorSchemeKt.m1449contentColorForek8zF_U(jM1413getSurface0d7_KjU, composerStartRestartGroup, (i25 >> 9) & 14);
                    i27 = (-57345) & i25;
                    i26 = i4;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    j5 = jM1449contentColorForek8zF_U1111112;
                    modifier3 = modifier2;
                    f5 = f4;
                    f6 = fM1347getElevationD9Ej5fM2;
                    j6 = jM1413getSurface0d7_KjU;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    shape2 = expandedShape;
                } else {
                    modifier3 = modifier2;
                    j5 = j4;
                    i26 = i4;
                    j6 = jM1413getSurface0d7_KjU;
                    i27 = i25;
                    f5 = f4;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    z3 = z2;
                    interfaceC0552Gp4 = interfaceC0552GpM1468getLambda2$material3_release;
                    shape2 = expandedShape;
                    f6 = fM1347getElevationD9Ej5fM2;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(144898711, i26, i27, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:96)");
            }
            SheetState bottomSheetState1111 = bottomSheetScaffoldState2.getBottomSheetState();
            Shape shape1114 = shape2;
            float f11111110 = f6;
            ComposableLambda composableLambda1111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 106433656, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1(bottomSheetScaffoldState2, f5, z3, shape2, containerColor, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, f6, interfaceC0526Fp5, interfaceC0552Gp, i26, i27));
            float f11111111 = fM1347getElevationD9Ej5fM;
            ComposableLambda composableLambda1111112 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1629779374, true, new BottomSheetScaffoldKt$BottomSheetScaffold$2(interfaceC0552Gp4, bottomSheetScaffoldState2, i27));
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(bottomSheetScaffoldState2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$3$1(bottomSheetScaffoldState2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            BottomSheetScaffoldState bottomSheetScaffoldState1114 = bottomSheetScaffoldState2;
            int i31111112 = ((i27 >> 9) & 896) | ((i26 >> 3) & 14) | 27648 | (i27 & 112) | ((i26 << 6) & 458752);
            int i31111113 = i27 << 15;
            m1350BottomSheetScaffoldLayoutPxNyym8(modifier3, interfaceC0526Fp3, interfaceC0552Gp3, composableLambda1111111, composableLambda1111112, f5, (InterfaceC3588op) objRememberedValue, bottomSheetState1111, j6, j5, composerStartRestartGroup, i31111112 | (234881024 & i31111113) | (i31111113 & 1879048192));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape1114;
            f7 = f11111110;
            bottomSheetScaffoldState3 = bottomSheetScaffoldState1114;
            f8 = f5;
            interfaceC0526Fp6 = interfaceC0526Fp5;
            z4 = z3;
            interfaceC0552Gp5 = interfaceC0552Gp4;
            f9 = f11111111;
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffold$4(interfaceC0552Gp, modifier4, bottomSheetScaffoldState3, f8, shape3, containerColor, jM1449contentColorForek8zF_U, f9, f7, interfaceC0526Fp6, z4, interfaceC0526Fp3, interfaceC0552Gp5, j6, j5, interfaceC0552Gp3, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalMaterial3Api
    public static final AnchorChangeHandler<SheetValue> BottomSheetScaffoldAnchorChangeHandler(final SheetState sheetState, final InterfaceC0526Fp interfaceC0526Fp, final InterfaceC3750qp interfaceC3750qp) {
        return new AnchorChangeHandler<SheetValue>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt.BottomSheetScaffoldAnchorChangeHandler.1

            /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldAnchorChangeHandler$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material3.AnchorChangeHandler
            public final void onAnchorsChanged(SheetValue sheetValue, Map<SheetValue, Float> map, Map<SheetValue, Float> map2) {
                SheetValue sheetValue2;
                AbstractC4492zt.h(sheetValue, "previousTarget");
                AbstractC4492zt.h(map, "previousAnchors");
                AbstractC4492zt.h(map2, "newAnchors");
                Float f = map.get(sheetValue);
                int i = WhenMappings.$EnumSwitchMapping$0[sheetValue.ordinal()];
                if (i == 1 || i == 2) {
                    sheetValue2 = SheetValue.PartiallyExpanded;
                } else {
                    if (i != 3) {
                        throw new AD();
                    }
                    sheetValue2 = SheetValue.Expanded;
                    if (!map2.containsKey(sheetValue2)) {
                        sheetValue2 = SheetValue.PartiallyExpanded;
                    }
                }
                if (AbstractC4492zt.a(((Number) AbstractC4243wx.h(map2, sheetValue2)).floatValue(), f)) {
                    return;
                }
                if (sheetState.getSwipeableState$material3_release().isAnimationRunning()) {
                    interfaceC0526Fp.mo13invoke(sheetValue2, Float.valueOf(sheetState.getSwipeableState$material3_release().getLastVelocity()));
                } else {
                    interfaceC3750qp.invoke(sheetValue2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][_]]")
    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-PxNyym8, reason: not valid java name */
    public static final void m1350BottomSheetScaffoldLayoutPxNyym8(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, InterfaceC0526Fp interfaceC0526Fp2, float f, InterfaceC3588op interfaceC3588op, SheetState sheetState, long j, long j2, Composer composer, int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1120561936);
        int i2 = (i & 14) == 0 ? (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((i & 3670016) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 1048576 : 524288;
        }
        if ((i & 29360128) == 0) {
            i2 |= composerStartRestartGroup.changed(sheetState) ? 8388608 : 4194304;
        }
        if ((i & 234881024) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        if ((i2 & 1533916891) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120561936, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:316)");
            }
            int i3 = i2;
            Object[] objArr = {interfaceC0552Gp2, interfaceC3588op, interfaceC0526Fp, modifier, Color.m3022boximpl(j), Color.m3022boximpl(j2), interfaceC0552Gp, Dp.m5158boximpl(f), interfaceC0526Fp2, sheetState};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i4 = 0; i4 < 10; i4++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i4]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                composer2 = composerStartRestartGroup;
                BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(interfaceC3588op, interfaceC0526Fp, interfaceC0526Fp2, sheetState, interfaceC0552Gp2, i3, modifier, j, j2, interfaceC0552Gp, f);
                composer2.updateRememberedValue(bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1);
                objRememberedValue = bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1;
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (InterfaceC0526Fp) objRememberedValue, composer2, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(modifier, interfaceC0526Fp, interfaceC0552Gp, interfaceC0552Gp2, interfaceC0526Fp2, f, interfaceC3588op, sheetState, j, j2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: StandardBottomSheet-8oydGBM, reason: not valid java name */
    public static final void m1351StandardBottomSheet8oydGBM(SheetState sheetState, float f, boolean z, float f2, Shape shape, long j, long j2, float f3, float f4, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-763942484);
        if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(sheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
        }
        if ((i & 234881024) == 0) {
            i3 |= composerStartRestartGroup.changed(f4) ? 67108864 : 33554432;
        }
        if ((i & 1879048192) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        if ((i2 & 14) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 1533916891) == 306783378 && (i4 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-763942484, i3, i4, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:196)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            float fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(f);
            int i5 = i3;
            Orientation orientation = Orientation.Vertical;
            int i6 = i4;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(sheetState) | composerStartRestartGroup.changed(coroutineScope);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = BottomSheetScaffoldAnchorChangeHandler(sheetState, new BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$1(coroutineScope, sheetState), new BottomSheetScaffoldKt$StandardBottomSheet$anchorChangeHandler$1$2(coroutineScope, sheetState));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AnchorChangeHandler anchorChangeHandler = (AnchorChangeHandler) objRememberedValue2;
            Modifier modifierM523requiredHeightInVpY3zN4$default = SizeKt.m523requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m539widthInVpY3zN4$default(Modifier.Companion, 0.0f, SheetDefaultsKt.getBottomSheetMaxWidth(), 1, null), 0.0f, 1, null), f, 0.0f, 2, null);
            SwipeableV2State<SheetValue> swipeableState$material3_release = sheetState.getSwipeableState$material3_release();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(swipeableState$material3_release);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState, orientation, new BottomSheetScaffoldKt$StandardBottomSheet$1$1(coroutineScope, sheetState));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierSwipeableV2$default = SwipeableV2Kt.swipeableV2$default(NestedScrollModifierKt.nestedScroll$default(modifierM523requiredHeightInVpY3zN4$default, (NestedScrollConnection) objRememberedValue3, null, 2, null), sheetState.getSwipeableState$material3_release(), orientation, z, false, null, 24, null);
            SwipeableV2State<SheetValue> swipeableState$material3_release2 = sheetState.getSwipeableState$material3_release();
            Set setH = QO.h(SheetValue.Hidden, SheetValue.PartiallyExpanded, SheetValue.Expanded);
            Float fValueOf = Float.valueOf(f2);
            Float fValueOf2 = Float.valueOf(fMo333toPx0680j_4);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            boolean zChanged3 = composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(sheetState) | composerStartRestartGroup.changed(fValueOf2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new BottomSheetScaffoldKt$StandardBottomSheet$2$1(sheetState, f2, fMo333toPx0680j_4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i7 = i5 >> 9;
            SurfaceKt.m1850SurfaceT9BRK9s(SwipeableV2Kt.swipeAnchors(modifierSwipeableV2$default, swipeableState$material3_release2, setH, anchorChangeHandler, (InterfaceC0526Fp) objRememberedValue4), shape, j, j2, f3, f4, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1381492089, true, new BottomSheetScaffoldKt$StandardBottomSheet$3(interfaceC0526Fp, interfaceC0552Gp, i6, sheetState, z, coroutineScope, i5)), composerStartRestartGroup, (i7 & 112) | 12582912 | (i7 & 896) | (i7 & 7168) | (i7 & 57344) | (i7 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$StandardBottomSheet$4(sheetState, f, z, f2, shape, j, j2, f3, f4, interfaceC0526Fp, interfaceC0552Gp, i, i2));
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1474606134);
        if ((i2 & 1) != 0) {
            sheetState = rememberStandardBottomSheetState(null, null, false, composer, 0, 7);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:166)");
        }
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(sheetState) | composer.changed(snackbarHostState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, InterfaceC3750qp interfaceC3750qp, boolean z, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(678511581);
        if ((i2 & 1) != 0) {
            sheetValue = SheetValue.PartiallyExpanded;
        }
        SheetValue sheetValue2 = sheetValue;
        if ((i2 & 2) != 0) {
            interfaceC3750qp = C14711.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:188)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(false, interfaceC3750qp2, sheetValue2, z2, composer, (i & 112) | 6 | ((i << 6) & 896) | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sheetStateRememberSheetState;
    }
}
