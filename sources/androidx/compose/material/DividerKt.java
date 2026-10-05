package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x006a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:78:0x0115  */
    /* JADX WARN: Code duplicated, block: B:79:0x012b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0155  */
    /* JADX WARN: Code duplicated, block: B:86:0x0161  */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Divider-oMI9zvI, reason: not valid java name */
    public static final void m1086DivideroMI9zvI(Modifier modifier, long j, float f, float f2, Composer composer, int i, int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        float fM5160constructorimpl;
        int i4;
        float fM5160constructorimpl2;
        int i5;
        Modifier modifier3;
        long jM3031copywmQWz5c$default;
        Modifier modifierM489paddingqDBjuR0$default;
        float fM5160constructorimpl3;
        float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249392198);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            j2 = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(j2)) ? 32 : 16;
        } else {
            j2 = j;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 896) == 0) {
                fM5160constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM5160constructorimpl) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    fM5160constructorimpl2 = f2;
                    if (composerStartRestartGroup.changed(fM5160constructorimpl2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jM3031copywmQWz5c$default = j2;
                        }
                        if (i7 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(1);
                        }
                        if (i4 != 0) {
                            fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        jM3031copywmQWz5c$default = j2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
                    }
                    if (fM5160constructorimpl2 == 0.0f) {
                        modifierM489paddingqDBjuR0$default = Modifier.Companion;
                    } else {
                        modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    composerStartRestartGroup.startReplaceableGroup(1228914189);
                    if (Dp.m5165equalsimpl0(fM5160constructorimpl, Dp.Companion.m5178getHairlineD9Ej5fM())) {
                        fM5160constructorimpl3 = Dp.m5160constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
                    } else {
                        fM5160constructorimpl3 = fM5160constructorimpl;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.m518height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM489paddingqDBjuR0$default), 0.0f, 1, null), fM5160constructorimpl3), jM3031copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    jM3031copywmQWz5c$default = j2;
                }
                f3 = fM5160constructorimpl2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DividerKt$Divider$1(modifier3, jM3031copywmQWz5c$default, fM5160constructorimpl, f3, i, i2));
            }
            i3 |= 3072;
            fM5160constructorimpl2 = f2;
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
                }
                if (fM5160constructorimpl2 == 0.0f) {
                    modifierM489paddingqDBjuR0$default = Modifier.Companion;
                } else {
                    modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                if (Dp.m5165equalsimpl0(fM5160constructorimpl, Dp.Companion.m5178getHairlineD9Ej5fM())) {
                    fM5160constructorimpl3 = Dp.m5160constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
                } else {
                    fM5160constructorimpl3 = fM5160constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.m518height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM489paddingqDBjuR0$default), 0.0f, 1, null), fM5160constructorimpl3), jM3031copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
                }
                if (fM5160constructorimpl2 == 0.0f) {
                    modifierM489paddingqDBjuR0$default = Modifier.Companion;
                } else {
                    modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                if (Dp.m5165equalsimpl0(fM5160constructorimpl, Dp.Companion.m5178getHairlineD9Ej5fM())) {
                    fM5160constructorimpl3 = Dp.m5160constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
                } else {
                    fM5160constructorimpl3 = fM5160constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.m518height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM489paddingqDBjuR0$default), 0.0f, 1, null), fM5160constructorimpl3), jM3031copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f3 = fM5160constructorimpl2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DividerKt$Divider$1(modifier3, jM3031copywmQWz5c$default, fM5160constructorimpl, f3, i, i2));
        }
        i3 |= 384;
        fM5160constructorimpl = f;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                fM5160constructorimpl2 = f2;
                if (composerStartRestartGroup.changed(fM5160constructorimpl2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 5851) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
                }
                if (fM5160constructorimpl2 == 0.0f) {
                    modifierM489paddingqDBjuR0$default = Modifier.Companion;
                } else {
                    modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                if (Dp.m5165equalsimpl0(fM5160constructorimpl, Dp.Companion.m5178getHairlineD9Ej5fM())) {
                    fM5160constructorimpl3 = Dp.m5160constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
                } else {
                    fM5160constructorimpl3 = fM5160constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.m518height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM489paddingqDBjuR0$default), 0.0f, 1, null), fM5160constructorimpl3), jM3031copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                } else {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jM3031copywmQWz5c$default = j2;
                    }
                    if (i7 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(1);
                    }
                    if (i4 != 0) {
                        fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
                }
                if (fM5160constructorimpl2 == 0.0f) {
                    modifierM489paddingqDBjuR0$default = Modifier.Companion;
                } else {
                    modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
                }
                composerStartRestartGroup.startReplaceableGroup(1228914189);
                if (Dp.m5165equalsimpl0(fM5160constructorimpl, Dp.Companion.m5178getHairlineD9Ej5fM())) {
                    fM5160constructorimpl3 = Dp.m5160constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
                } else {
                    fM5160constructorimpl3 = fM5160constructorimpl;
                }
                composerStartRestartGroup.endReplaceableGroup();
                BoxKt.Box(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.m518height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM489paddingqDBjuR0$default), 0.0f, 1, null), fM5160constructorimpl3), jM3031copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f3 = fM5160constructorimpl2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DividerKt$Divider$1(modifier3, jM3031copywmQWz5c$default, fM5160constructorimpl, f3, i, i2));
        }
        i3 |= 3072;
        fM5160constructorimpl2 = f2;
        if ((i3 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(1);
                }
                if (i4 != 0) {
                    fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(1);
                }
                if (i4 != 0) {
                    fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
            }
            if (fM5160constructorimpl2 == 0.0f) {
                modifierM489paddingqDBjuR0$default = Modifier.Companion;
            } else {
                modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
            }
            composerStartRestartGroup.startReplaceableGroup(1228914189);
            if (Dp.m5165equalsimpl0(fM5160constructorimpl, Dp.Companion.m5178getHairlineD9Ej5fM())) {
                fM5160constructorimpl3 = Dp.m5160constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
            } else {
                fM5160constructorimpl3 = fM5160constructorimpl;
            }
            composerStartRestartGroup.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.m518height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM489paddingqDBjuR0$default), 0.0f, 1, null), fM5160constructorimpl3), jM3031copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(1);
                }
                if (i4 != 0) {
                    fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM3031copywmQWz5c$default = j2;
                }
                if (i7 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(1);
                }
                if (i4 != 0) {
                    fM5160constructorimpl2 = Dp.m5160constructorimpl(0);
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249392198, i, -1, "androidx.compose.material.Divider (Divider.kt:43)");
            }
            if (fM5160constructorimpl2 == 0.0f) {
                modifierM489paddingqDBjuR0$default = Modifier.Companion;
            } else {
                modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, fM5160constructorimpl2, 0.0f, 0.0f, 0.0f, 14, null);
            }
            composerStartRestartGroup.startReplaceableGroup(1228914189);
            if (Dp.m5165equalsimpl0(fM5160constructorimpl, Dp.Companion.m5178getHairlineD9Ej5fM())) {
                fM5160constructorimpl3 = Dp.m5160constructorimpl(1.0f / ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
            } else {
                fM5160constructorimpl3 = fM5160constructorimpl;
            }
            composerStartRestartGroup.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.m518height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(modifierM489paddingqDBjuR0$default), 0.0f, 1, null), fM5160constructorimpl3), jM3031copywmQWz5c$default, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        f3 = fM5160constructorimpl2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new DividerKt$Divider$1(modifier3, jM3031copywmQWz5c$default, fM5160constructorimpl, f3, i, i2));
    }
}
