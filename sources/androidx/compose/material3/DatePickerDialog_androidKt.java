package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing = Dp.m5160constructorimpl(12);
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;

    static {
        float f = 8;
        DialogButtonsPadding = PaddingKt.m482PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m5160constructorimpl(6), Dp.m5160constructorimpl(f), 3, null);
        DialogButtonsMainAxisSpacing = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0133  */
    /* JADX WARN: Code duplicated, block: B:106:0x0141  */
    /* JADX WARN: Code duplicated, block: B:116:0x0163 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x0165  */
    /* JADX WARN: Code duplicated, block: B:118:0x0168  */
    /* JADX WARN: Code duplicated, block: B:120:0x016b  */
    /* JADX WARN: Code duplicated, block: B:121:0x016e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0174  */
    /* JADX WARN: Code duplicated, block: B:125:0x0181  */
    /* JADX WARN: Code duplicated, block: B:127:0x0186  */
    /* JADX WARN: Code duplicated, block: B:128:0x018f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0195  */
    /* JADX WARN: Code duplicated, block: B:132:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:134:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:139:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:142:0x0244  */
    /* JADX WARN: Code duplicated, block: B:147:0x0257  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:77:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:90:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0110  */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DatePickerDialog-GmEhDVc, reason: not valid java name */
    public static final void m1498DatePickerDialogGmEhDVc(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, Shape shape, float f, DatePickerColors datePickerColors, DialogProperties dialogProperties, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i5;
        Shape shape2;
        int i6;
        float f2;
        int i7;
        int i8;
        DialogProperties dialogProperties2;
        int i9;
        int i10;
        Modifier modifier3;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i11;
        Shape shape3;
        float fM1497getTonalElevationD9Ej5fM;
        DatePickerColors datePickerColorsM1496colors1m2CgY;
        DialogProperties dialogProperties3;
        Shape shape4;
        Modifier modifier4;
        DatePickerColors datePickerColors2;
        Composer composer2;
        Modifier modifier5;
        Shape shape5;
        DialogProperties dialogProperties4;
        InterfaceC0526Fp interfaceC0526Fp5;
        float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0526Fp, "confirmButton");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-36517340);
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
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i13 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((458752 & i) == 0) {
                        f2 = f;
                        if (composerStartRestartGroup.changed(f2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((3670016 & i) != 0) {
                        i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                        i3 |= 12582912;
                        dialogProperties2 = dialogProperties;
                    } else {
                        dialogProperties2 = dialogProperties;
                        if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(dialogProperties2)) {
                                i9 = 8388608;
                            } else {
                                i9 = 4194304;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i2 & 256) != 0) {
                        if ((234881024 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 67108864;
                            } else {
                                i10 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i4 != 0) {
                                    interfaceC0526Fp4 = null;
                                } else {
                                    interfaceC0526Fp4 = interfaceC0526Fp3;
                                }
                                if ((i2 & 16) != 0) {
                                    i11 = i3 & (-57345);
                                    shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    i11 = i3;
                                    shape3 = shape2;
                                }
                                if (i6 != 0) {
                                    fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                                } else {
                                    fM1497getTonalElevationD9Ej5fM = f2;
                                }
                                if ((i2 & 64) != 0) {
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                    i11 &= -3670017;
                                } else {
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                                if (i8 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                shape4 = shape3;
                                modifier4 = modifier3;
                                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                                i3 = i11;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                datePickerColors2 = datePickerColors;
                                dialogProperties3 = dialogProperties;
                                modifier4 = modifier2;
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                                shape4 = shape2;
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                            }
                            composer2 = composerStartRestartGroup;
                            Modifier modifier6 = modifier4;
                            AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier6;
                            shape5 = shape4;
                            dialogProperties4 = dialogProperties3;
                            interfaceC0526Fp5 = interfaceC0526Fp4;
                            f3 = fM1497getTonalElevationD9Ej5fM;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            datePickerColors2 = datePickerColors;
                            modifier5 = modifier2;
                            interfaceC0526Fp5 = interfaceC0526Fp3;
                            shape5 = shape2;
                            f3 = f2;
                            dialogProperties4 = dialogProperties2;
                            composer2 = composerStartRestartGroup;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
                    }
                    i10 = 100663296;
                    i3 |= i10;
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier7 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier7;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier8 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier8;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
                if ((3670016 & i) != 0) {
                    i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                    dialogProperties2 = dialogProperties;
                } else {
                    dialogProperties2 = dialogProperties;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties2)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier9 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier9;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier10 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier10;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier11 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier11;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier12 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier12;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            interfaceC0526Fp3 = interfaceC0526Fp2;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((3670016 & i) != 0) {
                    i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                    dialogProperties2 = dialogProperties;
                } else {
                    dialogProperties2 = dialogProperties;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties2)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier13 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier13;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier14 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier14;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier15 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier15;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier16 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier16;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            if ((3670016 & i) != 0) {
                i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
                dialogProperties2 = dialogProperties;
            } else {
                dialogProperties2 = dialogProperties;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier17 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier17;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier18 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier18;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier19 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier19;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier110 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier110;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0526Fp3 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((3670016 & i) != 0) {
                    i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                    dialogProperties2 = dialogProperties;
                } else {
                    dialogProperties2 = dialogProperties;
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties2)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier111 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier111;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                interfaceC0526Fp4 = null;
                            } else {
                                interfaceC0526Fp4 = interfaceC0526Fp3;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i3 & (-57345);
                                shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i3;
                                shape3 = shape2;
                            }
                            if (i6 != 0) {
                                fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                            } else {
                                fM1497getTonalElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                i11 &= -3670017;
                            } else {
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            shape4 = shape3;
                            modifier4 = modifier3;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            i3 = i11;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                        }
                        composer2 = composerStartRestartGroup;
                        Modifier modifier112 = modifier4;
                        AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier112;
                        shape5 = shape4;
                        dialogProperties4 = dialogProperties3;
                        interfaceC0526Fp5 = interfaceC0526Fp4;
                        f3 = fM1497getTonalElevationD9Ej5fM;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier113 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier113;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier114 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier114;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            if ((3670016 & i) != 0) {
                i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
                dialogProperties2 = dialogProperties;
            } else {
                dialogProperties2 = dialogProperties;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier115 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier115;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier116 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier116;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier117 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier117;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier118 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier118;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        interfaceC0526Fp3 = interfaceC0526Fp2;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((458752 & i) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((3670016 & i) != 0) {
                i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
                dialogProperties2 = dialogProperties;
            } else {
                dialogProperties2 = dialogProperties;
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier119 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier119;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            interfaceC0526Fp4 = null;
                        } else {
                            interfaceC0526Fp4 = interfaceC0526Fp3;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i3 & (-57345);
                            shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i3;
                            shape3 = shape2;
                        }
                        if (i6 != 0) {
                            fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                        } else {
                            fM1497getTonalElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            i11 &= -3670017;
                        } else {
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        shape4 = shape3;
                        modifier4 = modifier3;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        i3 = i11;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                    }
                    composer2 = composerStartRestartGroup;
                    Modifier modifier1110 = modifier4;
                    AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier1110;
                    shape5 = shape4;
                    dialogProperties4 = dialogProperties3;
                    interfaceC0526Fp5 = interfaceC0526Fp4;
                    f3 = fM1497getTonalElevationD9Ej5fM;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier1111 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier1111;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier1112 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier1112;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f2 = f;
        if ((3670016 & i) != 0) {
            i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 524288 : 1048576;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
            dialogProperties2 = dialogProperties;
        } else {
            dialogProperties2 = dialogProperties;
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
        }
        if ((i2 & 256) != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier1113 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier1113;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        interfaceC0526Fp4 = null;
                    } else {
                        interfaceC0526Fp4 = interfaceC0526Fp3;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i3 & (-57345);
                        shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i3;
                        shape3 = shape2;
                    }
                    if (i6 != 0) {
                        fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                    } else {
                        fM1497getTonalElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        i11 &= -3670017;
                    } else {
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    shape4 = shape3;
                    modifier4 = modifier3;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    i3 = i11;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier1114 = modifier4;
                AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier1114;
                shape5 = shape4;
                dialogProperties4 = dialogProperties3;
                interfaceC0526Fp5 = interfaceC0526Fp4;
                f3 = fM1497getTonalElevationD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
        }
        i10 = 100663296;
        i3 |= i10;
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if ((i2 & 16) != 0) {
                    i11 = i3 & (-57345);
                    shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i11 = i3;
                    shape3 = shape2;
                }
                if (i6 != 0) {
                    fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                } else {
                    fM1497getTonalElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    i11 &= -3670017;
                } else {
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
                if (i8 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                shape4 = shape3;
                modifier4 = modifier3;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                i3 = i11;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if ((i2 & 16) != 0) {
                    i11 = i3 & (-57345);
                    shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i11 = i3;
                    shape3 = shape2;
                }
                if (i6 != 0) {
                    fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                } else {
                    fM1497getTonalElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    i11 &= -3670017;
                } else {
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
                if (i8 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                shape4 = shape3;
                modifier4 = modifier3;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                i3 = i11;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
            }
            composer2 = composerStartRestartGroup;
            Modifier modifier1115 = modifier4;
            AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier1115;
            shape5 = shape4;
            dialogProperties4 = dialogProperties3;
            interfaceC0526Fp5 = interfaceC0526Fp4;
            f3 = fM1497getTonalElevationD9Ej5fM;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if ((i2 & 16) != 0) {
                    i11 = i3 & (-57345);
                    shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i11 = i3;
                    shape3 = shape2;
                }
                if (i6 != 0) {
                    fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                } else {
                    fM1497getTonalElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    i11 &= -3670017;
                } else {
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
                if (i8 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                shape4 = shape3;
                modifier4 = modifier3;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                i3 = i11;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    interfaceC0526Fp4 = null;
                } else {
                    interfaceC0526Fp4 = interfaceC0526Fp3;
                }
                if ((i2 & 16) != 0) {
                    i11 = i3 & (-57345);
                    shape3 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i11 = i3;
                    shape3 = shape2;
                }
                if (i6 != 0) {
                    fM1497getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m1497getTonalElevationD9Ej5fM();
                } else {
                    fM1497getTonalElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    i11 &= -3670017;
                } else {
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
                if (i8 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, null, false, false, 23, null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                shape4 = shape3;
                modifier4 = modifier3;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                i3 = i11;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-36517340, i3, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:64)");
            }
            composer2 = composerStartRestartGroup;
            Modifier modifier1116 = modifier4;
            AndroidAlertDialog_androidKt.AlertDialog(interfaceC3588op, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -476003174, true, new DatePickerDialog_androidKt$DatePickerDialog$1(shape4, datePickerColors2, fM1497getTonalElevationD9Ej5fM, i3, interfaceC0552Gp, interfaceC0526Fp4, interfaceC0526Fp)), composer2, (i3 & 14) | 3072 | ((i3 >> 15) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier1116;
            shape5 = shape4;
            dialogProperties4 = dialogProperties3;
            interfaceC0526Fp5 = interfaceC0526Fp4;
            f3 = fM1497getTonalElevationD9Ej5fM;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerDialog_androidKt$DatePickerDialog$2(interfaceC3588op, interfaceC0526Fp, modifier5, interfaceC0526Fp5, shape5, f3, datePickerColors2, dialogProperties4, interfaceC0552Gp, i, i2));
    }
}
