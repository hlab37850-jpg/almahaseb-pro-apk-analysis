package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:103:0x0128  */
    /* JADX WARN: Code duplicated, block: B:104:0x012b  */
    /* JADX WARN: Code duplicated, block: B:108:0x0139  */
    /* JADX WARN: Code duplicated, block: B:112:0x0155  */
    /* JADX WARN: Code duplicated, block: B:114:0x0162  */
    /* JADX WARN: Code duplicated, block: B:127:0x0191 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x0193  */
    /* JADX WARN: Code duplicated, block: B:129:0x0196  */
    /* JADX WARN: Code duplicated, block: B:132:0x019b  */
    /* JADX WARN: Code duplicated, block: B:133:0x019d  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:143:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:150:0x01de  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:154:0x0217  */
    /* JADX WARN: Code duplicated, block: B:157:0x0225  */
    /* JADX WARN: Code duplicated, block: B:160:0x027f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0299  */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:95:0x010d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0113  */
    /* JADX WARN: Code duplicated, block: B:99:0x011a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m971AlertDialog6oU6zVQ(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        InterfaceC0526Fp interfaceC0526Fp5;
        int i9;
        long jM1069contentColorForek8zF_U;
        int i10;
        int i11;
        Modifier modifier2;
        InterfaceC0526Fp interfaceC0526Fp6;
        InterfaceC0526Fp interfaceC0526Fp7;
        Shape medium;
        int i12;
        long jM1055getSurface0d7_KjU;
        DialogProperties dialogProperties2;
        long j3;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        InterfaceC0526Fp interfaceC0526Fp10;
        long j4;
        Shape shape2;
        InterfaceC0526Fp interfaceC0526Fp11;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp12;
        InterfaceC0526Fp interfaceC0526Fp13;
        Shape shape3;
        long j5;
        long j6;
        DialogProperties dialogProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        int i14;
        int i15;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0526Fp, "confirmButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-606536823);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        int i16 = i2 & 4;
        if (i16 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                    } else {
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(shape)) {
                            i15 = 524288;
                        } else {
                            i15 = 1048576;
                        }
                        i3 |= i15;
                    }
                    if ((i & 29360128) != 0) {
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) {
                            i14 = 4194304;
                        } else {
                            i14 = 8388608;
                        }
                        i3 |= i14;
                    }
                    if ((i & 234881024) == 0) {
                        jM1069contentColorForek8zF_U = j2;
                        if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(jM1069contentColorForek8zF_U)) {
                            i13 = 33554432;
                        } else {
                            i13 = 67108864;
                        }
                        i3 |= i13;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    i10 = i2 & 512;
                    if (i10 != 0) {
                        i3 |= 805306368;
                    } else if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i11 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i11 = 268435456;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 1533916891) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i6 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            InterfaceC0526Fp interfaceC0526Fp14 = i8 == 0 ? interfaceC0526Fp5 : null;
                            if ((i2 & 64) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -3670017;
                            } else {
                                medium = shape;
                            }
                            if ((i2 & 128) != 0) {
                                i12 = i3 & (-29360129);
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            } else {
                                i12 = i3;
                                jM1055getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            }
                            if (i10 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            j3 = jM1055getSurface0d7_KjU;
                            interfaceC0526Fp8 = interfaceC0526Fp14;
                            interfaceC0526Fp9 = interfaceC0526Fp6;
                            i3 = i12;
                            interfaceC0526Fp10 = interfaceC0526Fp7;
                            j4 = jM1069contentColorForek8zF_U;
                            shape2 = medium;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            modifier2 = modifier;
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                            shape2 = shape;
                            j3 = j;
                            dialogProperties2 = dialogProperties;
                            j4 = jM1069contentColorForek8zF_U;
                            interfaceC0526Fp8 = interfaceC0526Fp5;
                            interfaceC0526Fp9 = interfaceC0526Fp2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                        }
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                        int i17 = (i3 & 14) | 48 | (i3 & 896);
                        int i18 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp9;
                        m972AlertDialogwqdebIU(interfaceC3588op, composableLambda, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i17 | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (i18 & 3670016) | (i18 & 29360128) | (i18 & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp15;
                        modifier3 = modifier2;
                        interfaceC0526Fp12 = interfaceC0526Fp10;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        shape3 = shape2;
                        j5 = j3;
                        j6 = j4;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        interfaceC0526Fp11 = interfaceC0526Fp2;
                        interfaceC0526Fp12 = interfaceC0526Fp3;
                        dialogProperties3 = dialogProperties;
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                        j6 = jM1069contentColorForek8zF_U;
                        shape3 = shape;
                        j5 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
                }
                i3 |= 24576;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i15 = 524288;
                    } else {
                        i15 = 524288;
                    }
                    i3 |= i15;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i14 = 4194304;
                    } else {
                        i14 = 4194304;
                    }
                    i3 |= i14;
                }
                if ((i & 234881024) == 0) {
                    jM1069contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i13 = 33554432;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                i10 = i2 & 512;
                if (i10 != 0) {
                    i3 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i11 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i11 = 268435456;
                    }
                    i3 |= i11;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                    }
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                    int i19 = (i3 & 14) | 48 | (i3 & 896);
                    int i110 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp9;
                    m972AlertDialogwqdebIU(interfaceC3588op, composableLambda2, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i19 | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (i110 & 3670016) | (i110 & 29360128) | (i110 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp16;
                    modifier3 = modifier2;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    shape3 = shape2;
                    j5 = j3;
                    j6 = j4;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                    }
                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                    int i111 = (i3 & 14) | 48 | (i3 & 896);
                    int i112 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp9;
                    m972AlertDialogwqdebIU(interfaceC3588op, composableLambda3, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i111 | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (i112 & 3670016) | (i112 & 29360128) | (i112 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    modifier3 = modifier2;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    shape3 = shape2;
                    j5 = j3;
                    j6 = j4;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i15 = 524288;
                    } else {
                        i15 = 524288;
                    }
                    i3 |= i15;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i14 = 4194304;
                    } else {
                        i14 = 4194304;
                    }
                    i3 |= i14;
                }
                if ((i & 234881024) == 0) {
                    jM1069contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i13 = 33554432;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                i10 = i2 & 512;
                if (i10 != 0) {
                    i3 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i11 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i11 = 268435456;
                    }
                    i3 |= i11;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                    }
                    ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                    int i113 = (i3 & 14) | 48 | (i3 & 896);
                    int i114 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp9;
                    m972AlertDialogwqdebIU(interfaceC3588op, composableLambda4, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i113 | (i114 & 7168) | (57344 & i114) | (458752 & i114) | (i114 & 3670016) | (i114 & 29360128) | (i114 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp18;
                    modifier3 = modifier2;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    shape3 = shape2;
                    j5 = j3;
                    j6 = j4;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                    }
                    ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                    int i115 = (i3 & 14) | 48 | (i3 & 896);
                    int i116 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp9;
                    m972AlertDialogwqdebIU(interfaceC3588op, composableLambda5, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i115 | (i116 & 7168) | (57344 & i116) | (458752 & i116) | (i116 & 3670016) | (i116 & 29360128) | (i116 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp19;
                    modifier3 = modifier2;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    shape3 = shape2;
                    j5 = j3;
                    j6 = j4;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp5 = interfaceC0526Fp4;
            } else {
                interfaceC0526Fp5 = interfaceC0526Fp4;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i15 = 524288;
                } else {
                    i15 = 524288;
                }
                i3 |= i15;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i3 |= i14;
            }
            if ((i & 234881024) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 256) == 0) {
                    i13 = 33554432;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i10 = i2 & 512;
            if (i10 != 0) {
                i3 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i11 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i11 = 268435456;
                }
                i3 |= i11;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                }
                ComposableLambda composableLambda6 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                int i117 = (i3 & 14) | 48 | (i3 & 896);
                int i118 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp9;
                m972AlertDialogwqdebIU(interfaceC3588op, composableLambda6, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i117 | (i118 & 7168) | (57344 & i118) | (458752 & i118) | (i118 & 3670016) | (i118 & 29360128) | (i118 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp110;
                modifier3 = modifier2;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                }
                ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                int i119 = (i3 & 14) | 48 | (i3 & 896);
                int i1110 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp9;
                m972AlertDialogwqdebIU(interfaceC3588op, composableLambda7, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i119 | (i1110 & 7168) | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016) | (i1110 & 29360128) | (i1110 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp111;
                modifier3 = modifier2;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                } else {
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0) {
                        i15 = 524288;
                    } else {
                        i15 = 524288;
                    }
                    i3 |= i15;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i14 = 4194304;
                    } else {
                        i14 = 4194304;
                    }
                    i3 |= i14;
                }
                if ((i & 234881024) == 0) {
                    jM1069contentColorForek8zF_U = j2;
                    if ((i2 & 256) == 0) {
                        i13 = 33554432;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                i10 = i2 & 512;
                if (i10 != 0) {
                    i3 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i11 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i11 = 268435456;
                    }
                    i3 |= i11;
                }
                if ((i3 & 1533916891) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                    }
                    ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                    int i1111 = (i3 & 14) | 48 | (i3 & 896);
                    int i1112 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526Fp9;
                    m972AlertDialogwqdebIU(interfaceC3588op, composableLambda8, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i1111 | (i1112 & 7168) | (57344 & i1112) | (458752 & i1112) | (i1112 & 3670016) | (i1112 & 29360128) | (i1112 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp112;
                    modifier3 = modifier2;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    shape3 = shape2;
                    j5 = j3;
                    j6 = j4;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i6 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -3670017;
                        } else {
                            medium = shape;
                        }
                        if ((i2 & 128) != 0) {
                            i12 = i3 & (-29360129);
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        } else {
                            i12 = i3;
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        }
                        if (i10 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        j3 = jM1055getSurface0d7_KjU;
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        i3 = i12;
                        interfaceC0526Fp10 = interfaceC0526Fp7;
                        j4 = jM1069contentColorForek8zF_U;
                        shape2 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                    }
                    ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                    int i1113 = (i3 & 14) | 48 | (i3 & 896);
                    int i1114 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526Fp113 = interfaceC0526Fp9;
                    m972AlertDialogwqdebIU(interfaceC3588op, composableLambda9, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i1113 | (i1114 & 7168) | (57344 & i1114) | (458752 & i1114) | (i1114 & 3670016) | (i1114 & 29360128) | (i1114 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp113;
                    modifier3 = modifier2;
                    interfaceC0526Fp12 = interfaceC0526Fp10;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    shape3 = shape2;
                    j5 = j3;
                    j6 = j4;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp5 = interfaceC0526Fp4;
            } else {
                interfaceC0526Fp5 = interfaceC0526Fp4;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i15 = 524288;
                } else {
                    i15 = 524288;
                }
                i3 |= i15;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i3 |= i14;
            }
            if ((i & 234881024) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 256) == 0) {
                    i13 = 33554432;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i10 = i2 & 512;
            if (i10 != 0) {
                i3 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i11 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i11 = 268435456;
                }
                i3 |= i11;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                }
                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                int i1115 = (i3 & 14) | 48 | (i3 & 896);
                int i1116 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526Fp114 = interfaceC0526Fp9;
                m972AlertDialogwqdebIU(interfaceC3588op, composableLambda10, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i1115 | (i1116 & 7168) | (57344 & i1116) | (458752 & i1116) | (i1116 & 3670016) | (i1116 & 29360128) | (i1116 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp114;
                modifier3 = modifier2;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                }
                ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                int i1117 = (i3 & 14) | 48 | (i3 & 896);
                int i1118 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526Fp115 = interfaceC0526Fp9;
                m972AlertDialogwqdebIU(interfaceC3588op, composableLambda11, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i1117 | (i1118 & 7168) | (57344 & i1118) | (458752 & i1118) | (i1118 & 3670016) | (i1118 & 29360128) | (i1118 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp115;
                modifier3 = modifier2;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp5 = interfaceC0526Fp4;
            } else {
                interfaceC0526Fp5 = interfaceC0526Fp4;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i15 = 524288;
                } else {
                    i15 = 524288;
                }
                i3 |= i15;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i3 |= i14;
            }
            if ((i & 234881024) == 0) {
                jM1069contentColorForek8zF_U = j2;
                if ((i2 & 256) == 0) {
                    i13 = 33554432;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            } else {
                jM1069contentColorForek8zF_U = j2;
            }
            i10 = i2 & 512;
            if (i10 != 0) {
                i3 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i11 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i11 = 268435456;
                }
                i3 |= i11;
            }
            if ((i3 & 1533916891) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                }
                ComposableLambda composableLambda12 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                int i1119 = (i3 & 14) | 48 | (i3 & 896);
                int i11110 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526Fp116 = interfaceC0526Fp9;
                m972AlertDialogwqdebIU(interfaceC3588op, composableLambda12, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i1119 | (i11110 & 7168) | (57344 & i11110) | (458752 & i11110) | (i11110 & 3670016) | (i11110 & 29360128) | (i11110 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp116;
                modifier3 = modifier2;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i6 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -3670017;
                    } else {
                        medium = shape;
                    }
                    if ((i2 & 128) != 0) {
                        i12 = i3 & (-29360129);
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    } else {
                        i12 = i3;
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    }
                    if (i10 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    j3 = jM1055getSurface0d7_KjU;
                    interfaceC0526Fp8 = interfaceC0526Fp14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    i3 = i12;
                    interfaceC0526Fp10 = interfaceC0526Fp7;
                    j4 = jM1069contentColorForek8zF_U;
                    shape2 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
                }
                ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
                int i11111 = (i3 & 14) | 48 | (i3 & 896);
                int i11112 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526Fp117 = interfaceC0526Fp9;
                m972AlertDialogwqdebIU(interfaceC3588op, composableLambda13, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i11111 | (i11112 & 7168) | (57344 & i11112) | (458752 & i11112) | (i11112 & 3670016) | (i11112 & 29360128) | (i11112 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp11 = interfaceC0526Fp117;
                modifier3 = modifier2;
                interfaceC0526Fp12 = interfaceC0526Fp10;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
        }
        i3 |= 24576;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp5 = interfaceC0526Fp4;
        } else {
            interfaceC0526Fp5 = interfaceC0526Fp4;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i15 = 524288;
            } else {
                i15 = 524288;
            }
            i3 |= i15;
        }
        if ((i & 29360128) != 0) {
            if ((i2 & 128) == 0) {
                i14 = 4194304;
            } else {
                i14 = 4194304;
            }
            i3 |= i14;
        }
        if ((i & 234881024) == 0) {
            jM1069contentColorForek8zF_U = j2;
            if ((i2 & 256) == 0) {
                i13 = 33554432;
            } else {
                i13 = 33554432;
            }
            i3 |= i13;
        } else {
            jM1069contentColorForek8zF_U = j2;
        }
        i10 = i2 & 512;
        if (i10 != 0) {
            i3 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changed(dialogProperties)) {
                i11 = PropertyOptions.DELETE_EXISTING;
            } else {
                i11 = 268435456;
            }
            i3 |= i11;
        }
        if ((i3 & 1533916891) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape;
                }
                if ((i2 & 128) != 0) {
                    i12 = i3 & (-29360129);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    i12 = i3;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                    i12 &= -234881025;
                }
                if (i10 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                j3 = jM1055getSurface0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526Fp14;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                i3 = i12;
                interfaceC0526Fp10 = interfaceC0526Fp7;
                j4 = jM1069contentColorForek8zF_U;
                shape2 = medium;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape;
                }
                if ((i2 & 128) != 0) {
                    i12 = i3 & (-29360129);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    i12 = i3;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                    i12 &= -234881025;
                }
                if (i10 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                j3 = jM1055getSurface0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526Fp14;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                i3 = i12;
                interfaceC0526Fp10 = interfaceC0526Fp7;
                j4 = jM1069contentColorForek8zF_U;
                shape2 = medium;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
            }
            ComposableLambda composableLambda14 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
            int i11113 = (i3 & 14) | 48 | (i3 & 896);
            int i11114 = i3 >> 3;
            InterfaceC0526Fp interfaceC0526Fp118 = interfaceC0526Fp9;
            m972AlertDialogwqdebIU(interfaceC3588op, composableLambda14, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i11113 | (i11114 & 7168) | (57344 & i11114) | (458752 & i11114) | (i11114 & 3670016) | (i11114 & 29360128) | (i11114 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp11 = interfaceC0526Fp118;
            modifier3 = modifier2;
            interfaceC0526Fp12 = interfaceC0526Fp10;
            interfaceC0526Fp13 = interfaceC0526Fp8;
            shape3 = shape2;
            j5 = j3;
            j6 = j4;
            dialogProperties3 = dialogProperties2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape;
                }
                if ((i2 & 128) != 0) {
                    i12 = i3 & (-29360129);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    i12 = i3;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                    i12 &= -234881025;
                }
                if (i10 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                j3 = jM1055getSurface0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526Fp14;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                i3 = i12;
                interfaceC0526Fp10 = interfaceC0526Fp7;
                j4 = jM1069contentColorForek8zF_U;
                shape2 = medium;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i6 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -3670017;
                } else {
                    medium = shape;
                }
                if ((i2 & 128) != 0) {
                    i12 = i3 & (-29360129);
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                } else {
                    i12 = i3;
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                    i12 &= -234881025;
                }
                if (i10 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                j3 = jM1055getSurface0d7_KjU;
                interfaceC0526Fp8 = interfaceC0526Fp14;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                i3 = i12;
                interfaceC0526Fp10 = interfaceC0526Fp7;
                j4 = jM1069contentColorForek8zF_U;
                shape2 = medium;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606536823, i3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:63)");
            }
            ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1849673151, true, new AndroidAlertDialog_androidKt$AlertDialog$1(interfaceC0526Fp9, i3, interfaceC0526Fp));
            int i11115 = (i3 & 14) | 48 | (i3 & 896);
            int i11116 = i3 >> 3;
            InterfaceC0526Fp interfaceC0526Fp119 = interfaceC0526Fp9;
            m972AlertDialogwqdebIU(interfaceC3588op, composableLambda15, modifier2, interfaceC0526Fp10, interfaceC0526Fp8, shape2, j3, j4, dialogProperties2, composerStartRestartGroup, i11115 | (i11116 & 7168) | (57344 & i11116) | (458752 & i11116) | (i11116 & 3670016) | (i11116 & 29360128) | (i11116 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp11 = interfaceC0526Fp119;
            modifier3 = modifier2;
            interfaceC0526Fp12 = interfaceC0526Fp10;
            interfaceC0526Fp13 = interfaceC0526Fp8;
            shape3 = shape2;
            j5 = j3;
            j6 = j4;
            dialogProperties3 = dialogProperties2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$2(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp13, shape3, j5, j6, dialogProperties3, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x011b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0132  */
    /* JADX WARN: Code duplicated, block: B:108:0x0142  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x016f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0172  */
    /* JADX WARN: Code duplicated, block: B:127:0x0177  */
    /* JADX WARN: Code duplicated, block: B:130:0x017b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0181  */
    /* JADX WARN: Code duplicated, block: B:134:0x018e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0193  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:142:0x01af  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:149:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:152:0x0230  */
    /* JADX WARN: Code duplicated, block: B:157:0x0248  */
    /* JADX WARN: Code duplicated, block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00db  */
    /* JADX WARN: Code duplicated, block: B:82:0x00df  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:95:0x0102  */
    /* JADX WARN: Code duplicated, block: B:97:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x010d  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m972AlertDialogwqdebIU(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, int i, int i2) {
        int i3;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i5;
        int i6;
        InterfaceC0526Fp interfaceC0526Fp5;
        int i7;
        Shape shape2;
        long j3;
        int i8;
        int i9;
        Modifier modifier2;
        Shape medium;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        DialogProperties dialogProperties2;
        InterfaceC0526Fp interfaceC0526Fp6;
        Shape shape3;
        InterfaceC0526Fp interfaceC0526Fp7;
        long j4;
        long j5;
        int i10;
        Composer composer2;
        InterfaceC0526Fp interfaceC0526Fp8;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp9;
        Shape shape4;
        long j6;
        long j7;
        DialogProperties dialogProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0526Fp, "buttons");
        Composer composerStartRestartGroup = composer.startRestartGroup(1035523925);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        interfaceC0526Fp5 = interfaceC0526Fp3;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i12 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((3670016 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            j3 = j;
                            int i13 = composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                            i3 |= i13;
                        } else {
                            j3 = j;
                        }
                        i3 |= i13;
                    } else {
                        j3 = j;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        if ((234881024 & i) == 0) {
                            if (composerStartRestartGroup.changed(dialogProperties)) {
                                i9 = 67108864;
                            } else {
                                i9 = 33554432;
                            }
                            i3 |= i9;
                        }
                        if ((i3 & 191739611) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    interfaceC0526Fp4 = null;
                                }
                                InterfaceC0526Fp interfaceC0526Fp10 = i6 == 0 ? interfaceC0526Fp5 : null;
                                if ((i2 & 32) != 0) {
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                    i3 &= -458753;
                                } else {
                                    medium = shape2;
                                }
                                if ((i2 & 64) != 0) {
                                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                    i3 &= -3670017;
                                } else {
                                    jM1055getSurface0d7_KjU = j3;
                                }
                                if ((i2 & 128) != 0) {
                                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                    i3 &= -29360129;
                                } else {
                                    jM1069contentColorForek8zF_U = j2;
                                }
                                if (i8 != 0) {
                                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                                } else {
                                    dialogProperties2 = dialogProperties;
                                }
                                interfaceC0526Fp6 = interfaceC0526Fp10;
                                shape3 = medium;
                                interfaceC0526Fp7 = interfaceC0526Fp4;
                                j4 = jM1055getSurface0d7_KjU;
                                j5 = jM1069contentColorForek8zF_U;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                modifier2 = modifier;
                                j5 = j2;
                                dialogProperties2 = dialogProperties;
                                interfaceC0526Fp7 = interfaceC0526Fp4;
                                interfaceC0526Fp6 = interfaceC0526Fp5;
                                shape3 = shape2;
                                j4 = j3;
                            }
                            i10 = i3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                            }
                            InterfaceC0526Fp interfaceC0526Fp11 = interfaceC0526Fp7;
                            Modifier modifier4 = modifier2;
                            composer2 = composerStartRestartGroup;
                            AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp8 = interfaceC0526Fp11;
                            modifier3 = modifier4;
                            interfaceC0526Fp9 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j6 = j4;
                            j7 = j5;
                            dialogProperties3 = dialogProperties2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                            interfaceC0526Fp9 = interfaceC0526Fp5;
                            shape4 = shape2;
                            j6 = j3;
                            composer2 = composerStartRestartGroup;
                            j7 = j2;
                            dialogProperties3 = dialogProperties;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
                    }
                    i3 |= 100663296;
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp12 = interfaceC0526Fp7;
                        Modifier modifier5 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp12;
                        modifier3 = modifier5;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp13 = interfaceC0526Fp7;
                        Modifier modifier6 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp13;
                        modifier3 = modifier6;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i13;
                    } else {
                        j3 = j;
                    }
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp14 = interfaceC0526Fp7;
                        Modifier modifier7 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp14;
                        modifier3 = modifier7;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp15 = interfaceC0526Fp7;
                        Modifier modifier8 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp15;
                        modifier3 = modifier8;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
                }
                i3 |= 100663296;
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp16 = interfaceC0526Fp7;
                    Modifier modifier9 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp16;
                    modifier3 = modifier9;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp17 = interfaceC0526Fp7;
                    Modifier modifier10 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp17;
                    modifier3 = modifier10;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i13;
                    } else {
                        j3 = j;
                    }
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp18 = interfaceC0526Fp7;
                        Modifier modifier11 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp18;
                        modifier3 = modifier11;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp19 = interfaceC0526Fp7;
                        Modifier modifier12 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp19;
                        modifier3 = modifier12;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
                }
                i3 |= 100663296;
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp110 = interfaceC0526Fp7;
                    Modifier modifier13 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp110;
                    modifier3 = modifier13;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp111 = interfaceC0526Fp7;
                    Modifier modifier14 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp111;
                    modifier3 = modifier14;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                i3 |= i13;
            } else {
                j3 = j;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp112 = interfaceC0526Fp7;
                    Modifier modifier15 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp112;
                    modifier3 = modifier15;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp113 = interfaceC0526Fp7;
                    Modifier modifier16 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp113;
                    modifier3 = modifier16;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
            }
            i3 |= 100663296;
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp114 = interfaceC0526Fp7;
                Modifier modifier17 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp114;
                modifier3 = modifier17;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp115 = interfaceC0526Fp7;
                Modifier modifier18 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp115;
                modifier3 = modifier18;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0526Fp4 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    interfaceC0526Fp5 = interfaceC0526Fp3;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((3670016 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i13;
                    } else {
                        j3 = j;
                    }
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 191739611) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp116 = interfaceC0526Fp7;
                        Modifier modifier19 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp116;
                        modifier3 = modifier19;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                i3 &= -458753;
                            } else {
                                medium = shape2;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp6 = interfaceC0526Fp10;
                            shape3 = medium;
                            interfaceC0526Fp7 = interfaceC0526Fp4;
                            j4 = jM1055getSurface0d7_KjU;
                            j5 = jM1069contentColorForek8zF_U;
                        }
                        i10 = i3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                        }
                        InterfaceC0526Fp interfaceC0526Fp117 = interfaceC0526Fp7;
                        Modifier modifier110 = modifier2;
                        composer2 = composerStartRestartGroup;
                        AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp8 = interfaceC0526Fp117;
                        modifier3 = modifier110;
                        interfaceC0526Fp9 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j6 = j4;
                        j7 = j5;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
                }
                i3 |= 100663296;
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp118 = interfaceC0526Fp7;
                    Modifier modifier111 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp118;
                    modifier3 = modifier111;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp119 = interfaceC0526Fp7;
                    Modifier modifier112 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp119;
                    modifier3 = modifier112;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp5 = interfaceC0526Fp3;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                i3 |= i13;
            } else {
                j3 = j;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp1110 = interfaceC0526Fp7;
                    Modifier modifier113 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp1110;
                    modifier3 = modifier113;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp1111 = interfaceC0526Fp7;
                    Modifier modifier114 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp1111;
                    modifier3 = modifier114;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
            }
            i3 |= 100663296;
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp1112 = interfaceC0526Fp7;
                Modifier modifier115 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp1112;
                modifier3 = modifier115;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp1113 = interfaceC0526Fp7;
                Modifier modifier116 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp1113;
                modifier3 = modifier116;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
        }
        i3 |= 3072;
        interfaceC0526Fp4 = interfaceC0526Fp2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                interfaceC0526Fp5 = interfaceC0526Fp3;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((3670016 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                i3 |= i13;
            } else {
                j3 = j;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 191739611) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp1114 = interfaceC0526Fp7;
                    Modifier modifier117 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp1114;
                    modifier3 = modifier117;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            i3 &= -458753;
                        } else {
                            medium = shape2;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp6 = interfaceC0526Fp10;
                        shape3 = medium;
                        interfaceC0526Fp7 = interfaceC0526Fp4;
                        j4 = jM1055getSurface0d7_KjU;
                        j5 = jM1069contentColorForek8zF_U;
                    }
                    i10 = i3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp1115 = interfaceC0526Fp7;
                    Modifier modifier118 = modifier2;
                    composer2 = composerStartRestartGroup;
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp8 = interfaceC0526Fp1115;
                    modifier3 = modifier118;
                    interfaceC0526Fp9 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j6 = j4;
                    j7 = j5;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
            }
            i3 |= 100663296;
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp1116 = interfaceC0526Fp7;
                Modifier modifier119 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp1116;
                modifier3 = modifier119;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp1117 = interfaceC0526Fp7;
                Modifier modifier1110 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp1117;
                modifier3 = modifier1110;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
        }
        i3 |= 24576;
        interfaceC0526Fp5 = interfaceC0526Fp3;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            i3 |= i12;
        } else {
            shape2 = shape;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i13;
            } else {
                j3 = j;
            }
            i3 |= i13;
        } else {
            j3 = j;
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
        }
        i8 = i2 & 256;
        if (i8 != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((i3 & 191739611) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp1118 = interfaceC0526Fp7;
                Modifier modifier1111 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp1118;
                modifier3 = modifier1111;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        i3 &= -458753;
                    } else {
                        medium = shape2;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp6 = interfaceC0526Fp10;
                    shape3 = medium;
                    interfaceC0526Fp7 = interfaceC0526Fp4;
                    j4 = jM1055getSurface0d7_KjU;
                    j5 = jM1069contentColorForek8zF_U;
                }
                i10 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
                }
                InterfaceC0526Fp interfaceC0526Fp1119 = interfaceC0526Fp7;
                Modifier modifier1112 = modifier2;
                composer2 = composerStartRestartGroup;
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp8 = interfaceC0526Fp1119;
                modifier3 = modifier1112;
                interfaceC0526Fp9 = interfaceC0526Fp6;
                shape4 = shape3;
                j6 = j4;
                j7 = j5;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
        }
        i3 |= 100663296;
        if ((i3 & 191739611) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape2;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i8 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp6 = interfaceC0526Fp10;
                shape3 = medium;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j4 = jM1055getSurface0d7_KjU;
                j5 = jM1069contentColorForek8zF_U;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape2;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i8 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp6 = interfaceC0526Fp10;
                shape3 = medium;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j4 = jM1055getSurface0d7_KjU;
                j5 = jM1069contentColorForek8zF_U;
            }
            i10 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
            }
            InterfaceC0526Fp interfaceC0526Fp11110 = interfaceC0526Fp7;
            Modifier modifier1113 = modifier2;
            composer2 = composerStartRestartGroup;
            AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp8 = interfaceC0526Fp11110;
            modifier3 = modifier1113;
            interfaceC0526Fp9 = interfaceC0526Fp6;
            shape4 = shape3;
            j6 = j4;
            j7 = j5;
            dialogProperties3 = dialogProperties2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape2;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i8 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp6 = interfaceC0526Fp10;
                shape3 = medium;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j4 = jM1055getSurface0d7_KjU;
                j5 = jM1069contentColorForek8zF_U;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    i3 &= -458753;
                } else {
                    medium = shape2;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j3;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if (i8 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp6 = interfaceC0526Fp10;
                shape3 = medium;
                interfaceC0526Fp7 = interfaceC0526Fp4;
                j4 = jM1055getSurface0d7_KjU;
                j5 = jM1069contentColorForek8zF_U;
            }
            i10 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, i10, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:125)");
            }
            InterfaceC0526Fp interfaceC0526Fp11111 = interfaceC0526Fp7;
            Modifier modifier1114 = modifier2;
            composer2 = composerStartRestartGroup;
            AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, -1787418772, true, new AndroidAlertDialog_androidKt$AlertDialog$3(interfaceC0526Fp, modifier2, interfaceC0526Fp7, interfaceC0526Fp6, shape3, j4, j5, i10)), composer2, (i10 & 14) | 384 | ((i10 >> 21) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp8 = interfaceC0526Fp11111;
            modifier3 = modifier1114;
            interfaceC0526Fp9 = interfaceC0526Fp6;
            shape4 = shape3;
            j6 = j4;
            j7 = j5;
            dialogProperties3 = dialogProperties2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AndroidAlertDialog_androidKt$AlertDialog$4(interfaceC3588op, interfaceC0526Fp, modifier3, interfaceC0526Fp8, interfaceC0526Fp9, shape4, j6, j7, dialogProperties3, i, i2));
    }
}
