package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    private static final float Elevation = SheetBottomTokens.INSTANCE.m2498getDockedModalContainerElevationD9Ej5fM();
    private static final float SheetPeekHeight = Dp.m5160constructorimpl(56);

    private BottomSheetDefaults() {
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00df  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x012a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0155  */
    /* JADX WARN: Code duplicated, block: B:96:0x015d  */
    /* JADX WARN: Code duplicated, block: B:99:0x019d  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    public final void m1346DragHandlelgZ2HuY(Modifier modifier, float f, float f2, Shape shape, long j, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        float fM2497getDockedDragHandleWidthD9Ej5fM;
        int i4;
        float fM2496getDockedDragHandleHeightD9Ej5fM;
        int i5;
        Shape extraLarge;
        long jM3031copywmQWz5c$default;
        Modifier modifier3;
        int i6;
        String strM1841getStringNWtq28;
        boolean zChanged;
        Object objRememberedValue;
        Shape shape2;
        float f3;
        float f4;
        long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1364277227);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                fM2497getDockedDragHandleWidthD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM2497getDockedDragHandleWidthD9Ej5fM) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    fM2496getDockedDragHandleHeightD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM2496getDockedDragHandleHeightD9Ej5fM)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        extraLarge = shape;
                        int i9 = composerStartRestartGroup.changed(extraLarge) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        extraLarge = shape;
                    }
                    i3 |= i9;
                } else {
                    extraLarge = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        jM3031copywmQWz5c$default = j;
                        int i10 = composerStartRestartGroup.changed(jM3031copywmQWz5c$default) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        jM3031copywmQWz5c$default = j;
                    }
                    i3 |= i10;
                } else {
                    jM3031copywmQWz5c$default = j;
                }
                if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i8 != 0) {
                            fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                        }
                        if (i4 != 0) {
                            fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                        }
                        if ((i2 & 16) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -57345;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        modifier3 = modifier2;
                    }
                    i6 = i3;
                    float f5 = fM2496getDockedDragHandleHeightD9Ej5fM;
                    Shape shape3 = extraLarge;
                    long j3 = jM3031copywmQWz5c$default;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1364277227, i6, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1779getBottomSheetDragHandleDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11 = i6 >> 6;
                    SurfaceKt.m1850SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM487paddingVpY3zN4$default, false, (InterfaceC3750qp) objRememberedValue, 1, null), shape3, j3, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1039573072, true, new BottomSheetDefaults$DragHandle$2(fM2497getDockedDragHandleWidthD9Ej5fM, f5)), composerStartRestartGroup, (i11 & 112) | 12582912 | (i11 & 896), 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape3;
                    f3 = f5;
                    f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
                    j2 = j3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
                    f3 = fM2496getDockedDragHandleHeightD9Ej5fM;
                    shape2 = extraLarge;
                    j2 = jM3031copywmQWz5c$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetDefaults$DragHandle$3(this, modifier3, f4, f3, shape2, j2, i, i2));
            }
            i3 |= 384;
            fM2496getDockedDragHandleHeightD9Ej5fM = f2;
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    extraLarge = shape;
                    if (composerStartRestartGroup.changed(extraLarge)) {
                    }
                    i3 |= i9;
                } else {
                    extraLarge = shape;
                }
                i3 |= i9;
            } else {
                extraLarge = shape;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    jM3031copywmQWz5c$default = j;
                    if (composerStartRestartGroup.changed(jM3031copywmQWz5c$default)) {
                    }
                    i3 |= i10;
                } else {
                    jM3031copywmQWz5c$default = j;
                }
                i3 |= i10;
            } else {
                jM3031copywmQWz5c$default = j;
            }
            if ((46811 & i3) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                }
                i6 = i3;
                float f6 = fM2496getDockedDragHandleHeightD9Ej5fM;
                Shape shape4 = extraLarge;
                long j4 = jM3031copywmQWz5c$default;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1364277227, i6, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1779getBottomSheetDragHandleDescriptionadMyvUU(), composerStartRestartGroup, 6);
                Modifier modifierM487paddingVpY3zN4$default2 = PaddingKt.m487paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i12 = i6 >> 6;
                SurfaceKt.m1850SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM487paddingVpY3zN4$default2, false, (InterfaceC3750qp) objRememberedValue, 1, null), shape4, j4, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1039573072, true, new BottomSheetDefaults$DragHandle$2(fM2497getDockedDragHandleWidthD9Ej5fM, f6)), composerStartRestartGroup, (i12 & 112) | 12582912 | (i12 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape4;
                f3 = f6;
                f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
                j2 = j4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                }
                i6 = i3;
                float f7 = fM2496getDockedDragHandleHeightD9Ej5fM;
                Shape shape5 = extraLarge;
                long j5 = jM3031copywmQWz5c$default;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1364277227, i6, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1779getBottomSheetDragHandleDescriptionadMyvUU(), composerStartRestartGroup, 6);
                Modifier modifierM487paddingVpY3zN4$default3 = PaddingKt.m487paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i13 = i6 >> 6;
                SurfaceKt.m1850SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM487paddingVpY3zN4$default3, false, (InterfaceC3750qp) objRememberedValue, 1, null), shape5, j5, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1039573072, true, new BottomSheetDefaults$DragHandle$2(fM2497getDockedDragHandleWidthD9Ej5fM, f7)), composerStartRestartGroup, (i13 & 112) | 12582912 | (i13 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape5;
                f3 = f7;
                f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
                j2 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetDefaults$DragHandle$3(this, modifier3, f4, f3, shape2, j2, i, i2));
        }
        i3 |= 48;
        fM2497getDockedDragHandleWidthD9Ej5fM = f;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                fM2496getDockedDragHandleHeightD9Ej5fM = f2;
                if (composerStartRestartGroup.changed(fM2496getDockedDragHandleHeightD9Ej5fM)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    extraLarge = shape;
                    if (composerStartRestartGroup.changed(extraLarge)) {
                    }
                    i3 |= i9;
                } else {
                    extraLarge = shape;
                }
                i3 |= i9;
            } else {
                extraLarge = shape;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    jM3031copywmQWz5c$default = j;
                    if (composerStartRestartGroup.changed(jM3031copywmQWz5c$default)) {
                    }
                    i3 |= i10;
                } else {
                    jM3031copywmQWz5c$default = j;
                }
                i3 |= i10;
            } else {
                jM3031copywmQWz5c$default = j;
            }
            if ((46811 & i3) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                }
                i6 = i3;
                float f8 = fM2496getDockedDragHandleHeightD9Ej5fM;
                Shape shape6 = extraLarge;
                long j6 = jM3031copywmQWz5c$default;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1364277227, i6, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1779getBottomSheetDragHandleDescriptionadMyvUU(), composerStartRestartGroup, 6);
                Modifier modifierM487paddingVpY3zN4$default4 = PaddingKt.m487paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i14 = i6 >> 6;
                SurfaceKt.m1850SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM487paddingVpY3zN4$default4, false, (InterfaceC3750qp) objRememberedValue, 1, null), shape6, j6, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1039573072, true, new BottomSheetDefaults$DragHandle$2(fM2497getDockedDragHandleWidthD9Ej5fM, f8)), composerStartRestartGroup, (i14 & 112) | 12582912 | (i14 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape6;
                f3 = f8;
                f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
                j2 = j6;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i8 != 0) {
                        fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                    }
                    if (i4 != 0) {
                        fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                    }
                    if ((i2 & 16) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -57345;
                    }
                }
                i6 = i3;
                float f9 = fM2496getDockedDragHandleHeightD9Ej5fM;
                Shape shape7 = extraLarge;
                long j7 = jM3031copywmQWz5c$default;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1364277227, i6, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1779getBottomSheetDragHandleDescriptionadMyvUU(), composerStartRestartGroup, 6);
                Modifier modifierM487paddingVpY3zN4$default5 = PaddingKt.m487paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i15 = i6 >> 6;
                SurfaceKt.m1850SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM487paddingVpY3zN4$default5, false, (InterfaceC3750qp) objRememberedValue, 1, null), shape7, j7, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1039573072, true, new BottomSheetDefaults$DragHandle$2(fM2497getDockedDragHandleWidthD9Ej5fM, f9)), composerStartRestartGroup, (i15 & 112) | 12582912 | (i15 & 896), 120);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape7;
                f3 = f9;
                f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
                j2 = j7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetDefaults$DragHandle$3(this, modifier3, f4, f3, shape2, j2, i, i2));
        }
        i3 |= 384;
        fM2496getDockedDragHandleHeightD9Ej5fM = f2;
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                extraLarge = shape;
                if (composerStartRestartGroup.changed(extraLarge)) {
                }
                i3 |= i9;
            } else {
                extraLarge = shape;
            }
            i3 |= i9;
        } else {
            extraLarge = shape;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                jM3031copywmQWz5c$default = j;
                if (composerStartRestartGroup.changed(jM3031copywmQWz5c$default)) {
                }
                i3 |= i10;
            } else {
                jM3031copywmQWz5c$default = j;
            }
            i3 |= i10;
        } else {
            jM3031copywmQWz5c$default = j;
        }
        if ((46811 & i3) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                }
                if (i4 != 0) {
                    fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -57345;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                }
                if (i4 != 0) {
                    fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -57345;
                }
            }
            i6 = i3;
            float f10 = fM2496getDockedDragHandleHeightD9Ej5fM;
            Shape shape8 = extraLarge;
            long j8 = jM3031copywmQWz5c$default;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364277227, i6, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
            }
            strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1779getBottomSheetDragHandleDescriptionadMyvUU(), composerStartRestartGroup, 6);
            Modifier modifierM487paddingVpY3zN4$default6 = PaddingKt.m487paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i16 = i6 >> 6;
            SurfaceKt.m1850SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM487paddingVpY3zN4$default6, false, (InterfaceC3750qp) objRememberedValue, 1, null), shape8, j8, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1039573072, true, new BottomSheetDefaults$DragHandle$2(fM2497getDockedDragHandleWidthD9Ej5fM, f10)), composerStartRestartGroup, (i16 & 112) | 12582912 | (i16 & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape2 = shape8;
            f3 = f10;
            f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
            j2 = j8;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                }
                if (i4 != 0) {
                    fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -57345;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i8 != 0) {
                    fM2497getDockedDragHandleWidthD9Ej5fM = SheetBottomTokens.INSTANCE.m2497getDockedDragHandleWidthD9Ej5fM();
                }
                if (i4 != 0) {
                    fM2496getDockedDragHandleHeightD9Ej5fM = SheetBottomTokens.INSTANCE.m2496getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    extraLarge = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getExtraLarge();
                }
                if ((i2 & 16) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), composerStartRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                    i3 &= -57345;
                }
            }
            i6 = i3;
            float f11 = fM2496getDockedDragHandleHeightD9Ej5fM;
            Shape shape9 = extraLarge;
            long j9 = jM3031copywmQWz5c$default;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364277227, i6, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
            }
            strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1779getBottomSheetDragHandleDescriptionadMyvUU(), composerStartRestartGroup, 6);
            Modifier modifierM487paddingVpY3zN4$default7 = PaddingKt.m487paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1, null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new BottomSheetDefaults$DragHandle$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i17 = i6 >> 6;
            SurfaceKt.m1850SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(modifierM487paddingVpY3zN4$default7, false, (InterfaceC3750qp) objRememberedValue, 1, null), shape9, j9, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1039573072, true, new BottomSheetDefaults$DragHandle$2(fM2497getDockedDragHandleWidthD9Ej5fM, f11)), composerStartRestartGroup, (i17 & 112) | 12582912 | (i17 & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape2 = shape9;
            f3 = f11;
            f4 = fM2497getDockedDragHandleWidthD9Ej5fM;
            j2 = j9;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetDefaults$DragHandle$3(this, modifier3, f4, f3, shape2, j2, i, i2));
    }

    @Composable
    public final long getContainerColor(Composer composer, int i) {
        composer.startReplaceableGroup(433375448);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(433375448, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:298)");
        }
        long color = ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m1347getElevationD9Ej5fM() {
        return Elevation;
    }

    @Composable
    public final Shape getExpandedShape(Composer composer, int i) {
        composer.startReplaceableGroup(1683783414);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1683783414, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:293)");
        }
        Shape shape = ShapesKt.toShape(SheetBottomTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    public final Shape getHiddenShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1971658024);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1971658024, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:288)");
        }
        Shape shape = ShapesKt.toShape(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    public final long getScrimColor(Composer composer, int i) {
        composer.startReplaceableGroup(-2040719176);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2040719176, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:306)");
        }
        long jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM3031copywmQWz5c$default;
    }

    /* JADX INFO: renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m1348getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    @Composable
    public final WindowInsets getWindowInsets(Composer composer, int i) {
        composer.startReplaceableGroup(-511309409);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511309409, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:319)");
        }
        WindowInsets windowInsetsM558onlybOOhFvg = WindowInsetsKt.m558onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 8), WindowInsetsSides.Companion.m583getVerticalJoeWqyM());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return windowInsetsM558onlybOOhFvg;
    }
}
