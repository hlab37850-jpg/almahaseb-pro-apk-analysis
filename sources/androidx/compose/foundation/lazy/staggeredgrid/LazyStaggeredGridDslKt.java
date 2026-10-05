package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$10, reason: invalid class name */
    public static final class AnonymousClass10 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0578Hp $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass10(InterfaceC0578Hp interfaceC0578Hp, T[] tArr) {
            super(4);
            this.$itemContent = interfaceC0578Hp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyStaggeredGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyStaggeredGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2101296000, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:414)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(InterfaceC3750qp interfaceC3750qp, List<? extends T> list) {
            super(1);
            this.$contentType = interfaceC3750qp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$contentType.invoke(this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0578Hp $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(InterfaceC0578Hp interfaceC0578Hp, List<? extends T> list) {
            super(4);
            this.$itemContent = interfaceC0578Hp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyStaggeredGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyStaggeredGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-886456479, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.items.<anonymous> (LazyStaggeredGridDsl.kt:336)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$8, reason: invalid class name */
    public static final class AnonymousClass8 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(InterfaceC3750qp interfaceC3750qp, T[] tArr) {
            super(1);
            this.$contentType = interfaceC3750qp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$contentType.invoke(this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13811 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C13811 INSTANCE = new C13811();

        public C13811() {
            super(2);
        }

        public final Void invoke(int i, Object obj) {
            return null;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), obj2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    public static final class C138210 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0604Ip $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C138210(InterfaceC0604Ip interfaceC0604Ip, T[] tArr) {
            super(4);
            this.$itemContent = interfaceC0604Ip;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyStaggeredGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyStaggeredGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-804487775, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:453)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13833 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13833(InterfaceC0526Fp interfaceC0526Fp, List<? extends T> list) {
            super(1);
            this.$contentType = interfaceC0526Fp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$contentType.mo13invoke(Integer.valueOf(i), this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    public static final class C13845 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0604Ip $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13845(InterfaceC0604Ip interfaceC0604Ip, List<? extends T> list) {
            super(4);
            this.$itemContent = interfaceC0604Ip;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyStaggeredGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyStaggeredGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyStaggeredGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(284833944, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:375)");
            }
            this.$itemContent.invoke(lazyStaggeredGridItemScope, Integer.valueOf(i), this.$items.get(i), composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$6, reason: invalid class name and case insensitive filesystem */
    public static final class C13856 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C13856 INSTANCE = new C13856();

        public C13856() {
            super(2);
        }

        public final Void invoke(int i, Object obj) {
            return null;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), obj2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    public static final class C13868 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13868(InterfaceC0526Fp interfaceC0526Fp, T[] tArr) {
            super(1);
            this.$contentType = interfaceC0526Fp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$contentType.mo13invoke(Integer.valueOf(i), this.$items[i]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0122  */
    /* JADX WARN: Code duplicated, block: B:102:0x0127  */
    /* JADX WARN: Code duplicated, block: B:108:0x014a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0154  */
    /* JADX WARN: Code duplicated, block: B:120:0x0175 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x0177  */
    /* JADX WARN: Code duplicated, block: B:124:0x017d  */
    /* JADX WARN: Code duplicated, block: B:125:0x0185  */
    /* JADX WARN: Code duplicated, block: B:127:0x0189  */
    /* JADX WARN: Code duplicated, block: B:128:0x0193  */
    /* JADX WARN: Code duplicated, block: B:130:0x0196  */
    /* JADX WARN: Code duplicated, block: B:132:0x0199  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:140:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:150:0x024c  */
    /* JADX WARN: Code duplicated, block: B:155:0x0265  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0104  */
    /* JADX WARN: Code duplicated, block: B:88:0x0107  */
    /* JADX WARN: Code duplicated, block: B:92:0x010f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x0119  */
    /* JADX WARN: Code duplicated, block: B:99:0x011f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LazyHorizontalStaggeredGrid-cJHQLPU, reason: not valid java name */
    public static final void m653LazyHorizontalStaggeredGridcJHQLPU(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        int i7;
        boolean z3;
        int i8;
        int i9;
        Arrangement.Vertical verticalM399spacedBy0680j_4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        float fM5160constructorimpl;
        FlingBehavior flingBehavior2;
        boolean z4;
        PaddingValues paddingValues3;
        Modifier modifier3;
        LazyStaggeredGridState lazyStaggeredGridState2;
        Arrangement.Vertical vertical2;
        boolean z5;
        PaddingValues paddingValues4;
        float f2;
        FlingBehavior flingBehavior3;
        boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(staggeredGridCells, "rows");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-8666074);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                i7 = i2 & 16;
                if (i7 != 0) {
                    if ((i & 57344) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    i9 = i2 & 32;
                    if (i9 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        verticalM399spacedBy0680j_4 = vertical;
                    } else {
                        verticalM399spacedBy0680j_4 = vertical;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                    }
                    i11 = i2 & 64;
                    if (i11 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                    }
                    i13 = i2 & 256;
                    if (i13 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i3 |= i14;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i15 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i15 = 268435456;
                            }
                        }
                        if (i4 != 4 && (1533916891 & i3) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            lazyStaggeredGridState2 = lazyStaggeredGridState;
                            f2 = f;
                            flingBehavior3 = flingBehavior;
                            modifier3 = modifier2;
                            paddingValues4 = paddingValues2;
                            vertical2 = verticalM399spacedBy0680j_4;
                            z5 = z3;
                            z6 = z2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                                }
                                if (i5 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i7 != 0) {
                                    z3 = false;
                                }
                                if (i9 != 0) {
                                    verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                                }
                                if (i11 != 0) {
                                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                                } else {
                                    fM5160constructorimpl = f;
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i13 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = z2;
                                }
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if (i4 != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                                fM5160constructorimpl = f;
                                flingBehavior2 = flingBehavior;
                                z4 = z2;
                                modifier2 = modifier2;
                                z3 = z3;
                                paddingValues3 = paddingValues2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                            }
                            int i17 = i3 >> 3;
                            int i18 = i3 << 6;
                            int i19 = i3 << 3;
                            Arrangement.Vertical vertical3 = verticalM399spacedBy0680j_4;
                            PaddingValues paddingValues5 = paddingValues3;
                            LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i17 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i17 & 29360128) | (i18 & 7168) | 56 | (57344 & i19) | (i19 & 458752) | (i17 & 3670016) | (i18 & 234881024), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                            vertical2 = vertical3;
                            z5 = z3;
                            paddingValues4 = paddingValues5;
                            f2 = fM5160constructorimpl;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                    }
                    i15 = 805306368;
                    i3 |= i15;
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i110 = i3 >> 3;
                        int i111 = i3 << 6;
                        int i112 = i3 << 3;
                        Arrangement.Vertical vertical4 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues6 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i110 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i110 & 29360128) | (i111 & 7168) | 56 | (57344 & i112) | (i112 & 458752) | (i110 & 3670016) | (i111 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical4;
                        z5 = z3;
                        paddingValues4 = paddingValues6;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i113 = i3 >> 3;
                        int i114 = i3 << 6;
                        int i115 = i3 << 3;
                        Arrangement.Vertical vertical5 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues7 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i113 & 29360128) | (i114 & 7168) | 56 | (57344 & i115) | (i115 & 458752) | (i113 & 3670016) | (i114 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical5;
                        z5 = z3;
                        paddingValues4 = paddingValues7;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i3 |= 24576;
                z3 = z;
                i9 = i2 & 32;
                if (i9 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    verticalM399spacedBy0680j_4 = vertical;
                } else {
                    verticalM399spacedBy0680j_4 = vertical;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                i11 = i2 & 64;
                if (i11 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                    }
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i116 = i3 >> 3;
                        int i117 = i3 << 6;
                        int i118 = i3 << 3;
                        Arrangement.Vertical vertical6 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues8 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i116 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i116 & 29360128) | (i117 & 7168) | 56 | (57344 & i118) | (i118 & 458752) | (i116 & 3670016) | (i117 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical6;
                        z5 = z3;
                        paddingValues4 = paddingValues8;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i119 = i3 >> 3;
                        int i1110 = i3 << 6;
                        int i1111 = i3 << 3;
                        Arrangement.Vertical vertical7 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues9 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i119 & 29360128) | (i1110 & 7168) | 56 | (57344 & i1111) | (i1111 & 458752) | (i119 & 3670016) | (i1110 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical7;
                        z5 = z3;
                        paddingValues4 = paddingValues9;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i15 = 805306368;
                i3 |= i15;
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i1112 = i3 >> 3;
                    int i1113 = i3 << 6;
                    int i1114 = i3 << 3;
                    Arrangement.Vertical vertical8 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues10 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1112 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1112 & 29360128) | (i1113 & 7168) | 56 | (57344 & i1114) | (i1114 & 458752) | (i1112 & 3670016) | (i1113 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical8;
                    z5 = z3;
                    paddingValues4 = paddingValues10;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i1115 = i3 >> 3;
                    int i1116 = i3 << 6;
                    int i1117 = i3 << 3;
                    Arrangement.Vertical vertical9 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues11 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1115 & 29360128) | (i1116 & 7168) | 56 | (57344 & i1117) | (i1117 & 458752) | (i1115 & 3670016) | (i1116 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical9;
                    z5 = z3;
                    paddingValues4 = paddingValues11;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                i9 = i2 & 32;
                if (i9 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    verticalM399spacedBy0680j_4 = vertical;
                } else {
                    verticalM399spacedBy0680j_4 = vertical;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                i11 = i2 & 64;
                if (i11 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                    }
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i1118 = i3 >> 3;
                        int i1119 = i3 << 6;
                        int i11110 = i3 << 3;
                        Arrangement.Vertical vertical10 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues12 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1118 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1118 & 29360128) | (i1119 & 7168) | 56 | (57344 & i11110) | (i11110 & 458752) | (i1118 & 3670016) | (i1119 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical10;
                        z5 = z3;
                        paddingValues4 = paddingValues12;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i11111 = i3 >> 3;
                        int i11112 = i3 << 6;
                        int i11113 = i3 << 3;
                        Arrangement.Vertical vertical11 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues13 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11111 & 29360128) | (i11112 & 7168) | 56 | (57344 & i11113) | (i11113 & 458752) | (i11111 & 3670016) | (i11112 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical11;
                        z5 = z3;
                        paddingValues4 = paddingValues13;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i15 = 805306368;
                i3 |= i15;
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i11114 = i3 >> 3;
                    int i11115 = i3 << 6;
                    int i11116 = i3 << 3;
                    Arrangement.Vertical vertical12 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues14 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11114 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11114 & 29360128) | (i11115 & 7168) | 56 | (57344 & i11116) | (i11116 & 458752) | (i11114 & 3670016) | (i11115 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical12;
                    z5 = z3;
                    paddingValues4 = paddingValues14;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i11117 = i3 >> 3;
                    int i11118 = i3 << 6;
                    int i11119 = i3 << 3;
                    Arrangement.Vertical vertical13 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues15 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11117 & 29360128) | (i11118 & 7168) | 56 | (57344 & i11119) | (i11119 & 458752) | (i11117 & 3670016) | (i11118 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical13;
                    z5 = z3;
                    paddingValues4 = paddingValues15;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            i9 = i2 & 32;
            if (i9 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                verticalM399spacedBy0680j_4 = vertical;
            } else {
                verticalM399spacedBy0680j_4 = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            i11 = i2 & 64;
            if (i11 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i13 = i2 & 256;
            if (i13 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i111110 = i3 >> 3;
                    int i111111 = i3 << 6;
                    int i111112 = i3 << 3;
                    Arrangement.Vertical vertical14 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues16 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111110 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111110 & 29360128) | (i111111 & 7168) | 56 | (57344 & i111112) | (i111112 & 458752) | (i111110 & 3670016) | (i111111 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical14;
                    z5 = z3;
                    paddingValues4 = paddingValues16;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i111113 = i3 >> 3;
                    int i111114 = i3 << 6;
                    int i111115 = i3 << 3;
                    Arrangement.Vertical vertical15 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues17 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111113 & 29360128) | (i111114 & 7168) | 56 | (57344 & i111115) | (i111115 & 458752) | (i111113 & 3670016) | (i111114 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical15;
                    z5 = z3;
                    paddingValues4 = paddingValues17;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i15 = 805306368;
            i3 |= i15;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i111116 = i3 >> 3;
                int i111117 = i3 << 6;
                int i111118 = i3 << 3;
                Arrangement.Vertical vertical16 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues18 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111116 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111116 & 29360128) | (i111117 & 7168) | 56 | (57344 & i111118) | (i111118 & 458752) | (i111116 & 3670016) | (i111117 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical16;
                z5 = z3;
                paddingValues4 = paddingValues18;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i111119 = i3 >> 3;
                int i1111110 = i3 << 6;
                int i1111111 = i3 << 3;
                Arrangement.Vertical vertical17 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues19 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111119 & 29360128) | (i1111110 & 7168) | 56 | (57344 & i1111111) | (i1111111 & 458752) | (i111119 & 3670016) | (i1111110 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical17;
                z5 = z3;
                paddingValues4 = paddingValues19;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 128;
        }
        i5 = i2 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                i9 = i2 & 32;
                if (i9 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    verticalM399spacedBy0680j_4 = vertical;
                } else {
                    verticalM399spacedBy0680j_4 = vertical;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                i11 = i2 & 64;
                if (i11 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                    }
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i1111112 = i3 >> 3;
                        int i1111113 = i3 << 6;
                        int i1111114 = i3 << 3;
                        Arrangement.Vertical vertical18 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues110 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1111112 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1111112 & 29360128) | (i1111113 & 7168) | 56 | (57344 & i1111114) | (i1111114 & 458752) | (i1111112 & 3670016) | (i1111113 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical18;
                        z5 = z3;
                        paddingValues4 = paddingValues110;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                            }
                            if (i11 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                        }
                        int i1111115 = i3 >> 3;
                        int i1111116 = i3 << 6;
                        int i1111117 = i3 << 3;
                        Arrangement.Vertical vertical19 = verticalM399spacedBy0680j_4;
                        PaddingValues paddingValues111 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1111115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1111115 & 29360128) | (i1111116 & 7168) | 56 | (57344 & i1111117) | (i1111117 & 458752) | (i1111115 & 3670016) | (i1111116 & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        vertical2 = vertical19;
                        z5 = z3;
                        paddingValues4 = paddingValues111;
                        f2 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i15 = 805306368;
                i3 |= i15;
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i1111118 = i3 >> 3;
                    int i1111119 = i3 << 6;
                    int i11111110 = i3 << 3;
                    Arrangement.Vertical vertical110 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues112 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1111118 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1111118 & 29360128) | (i1111119 & 7168) | 56 | (57344 & i11111110) | (i11111110 & 458752) | (i1111118 & 3670016) | (i1111119 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical110;
                    z5 = z3;
                    paddingValues4 = paddingValues112;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i11111111 = i3 >> 3;
                    int i11111112 = i3 << 6;
                    int i11111113 = i3 << 3;
                    Arrangement.Vertical vertical111 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues113 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11111111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11111111 & 29360128) | (i11111112 & 7168) | 56 | (57344 & i11111113) | (i11111113 & 458752) | (i11111111 & 3670016) | (i11111112 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical111;
                    z5 = z3;
                    paddingValues4 = paddingValues113;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            i9 = i2 & 32;
            if (i9 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                verticalM399spacedBy0680j_4 = vertical;
            } else {
                verticalM399spacedBy0680j_4 = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            i11 = i2 & 64;
            if (i11 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i13 = i2 & 256;
            if (i13 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i11111114 = i3 >> 3;
                    int i11111115 = i3 << 6;
                    int i11111116 = i3 << 3;
                    Arrangement.Vertical vertical112 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues114 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11111114 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11111114 & 29360128) | (i11111115 & 7168) | 56 | (57344 & i11111116) | (i11111116 & 458752) | (i11111114 & 3670016) | (i11111115 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical112;
                    z5 = z3;
                    paddingValues4 = paddingValues114;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i11111117 = i3 >> 3;
                    int i11111118 = i3 << 6;
                    int i11111119 = i3 << 3;
                    Arrangement.Vertical vertical113 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues115 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11111117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11111117 & 29360128) | (i11111118 & 7168) | 56 | (57344 & i11111119) | (i11111119 & 458752) | (i11111117 & 3670016) | (i11111118 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical113;
                    z5 = z3;
                    paddingValues4 = paddingValues115;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i15 = 805306368;
            i3 |= i15;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i111111110 = i3 >> 3;
                int i111111111 = i3 << 6;
                int i111111112 = i3 << 3;
                Arrangement.Vertical vertical114 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues116 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111111110 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111111110 & 29360128) | (i111111111 & 7168) | 56 | (57344 & i111111112) | (i111111112 & 458752) | (i111111110 & 3670016) | (i111111111 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical114;
                z5 = z3;
                paddingValues4 = paddingValues116;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i111111113 = i3 >> 3;
                int i111111114 = i3 << 6;
                int i111111115 = i3 << 3;
                Arrangement.Vertical vertical115 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues117 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111111113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111111113 & 29360128) | (i111111114 & 7168) | 56 | (57344 & i111111115) | (i111111115 & 458752) | (i111111113 & 3670016) | (i111111114 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical115;
                z5 = z3;
                paddingValues4 = paddingValues117;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i7 = i2 & 16;
        if (i7 != 0) {
            if ((i & 57344) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            i9 = i2 & 32;
            if (i9 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                verticalM399spacedBy0680j_4 = vertical;
            } else {
                verticalM399spacedBy0680j_4 = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            i11 = i2 & 64;
            if (i11 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i13 = i2 & 256;
            if (i13 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i111111116 = i3 >> 3;
                    int i111111117 = i3 << 6;
                    int i111111118 = i3 << 3;
                    Arrangement.Vertical vertical116 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues118 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111111116 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111111116 & 29360128) | (i111111117 & 7168) | 56 | (57344 & i111111118) | (i111111118 & 458752) | (i111111116 & 3670016) | (i111111117 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical116;
                    z5 = z3;
                    paddingValues4 = paddingValues118;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                        }
                        if (i11 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                    }
                    int i111111119 = i3 >> 3;
                    int i1111111110 = i3 << 6;
                    int i1111111111 = i3 << 3;
                    Arrangement.Vertical vertical117 = verticalM399spacedBy0680j_4;
                    PaddingValues paddingValues119 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i111111119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i111111119 & 29360128) | (i1111111110 & 7168) | 56 | (57344 & i1111111111) | (i1111111111 & 458752) | (i111111119 & 3670016) | (i1111111110 & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    vertical2 = vertical117;
                    z5 = z3;
                    paddingValues4 = paddingValues119;
                    f2 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i15 = 805306368;
            i3 |= i15;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i1111111112 = i3 >> 3;
                int i1111111113 = i3 << 6;
                int i1111111114 = i3 << 3;
                Arrangement.Vertical vertical118 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues1110 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1111111112 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1111111112 & 29360128) | (i1111111113 & 7168) | 56 | (57344 & i1111111114) | (i1111111114 & 458752) | (i1111111112 & 3670016) | (i1111111113 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical118;
                z5 = z3;
                paddingValues4 = paddingValues1110;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i1111111115 = i3 >> 3;
                int i1111111116 = i3 << 6;
                int i1111111117 = i3 << 3;
                Arrangement.Vertical vertical119 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues1111 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1111111115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1111111115 & 29360128) | (i1111111116 & 7168) | 56 | (57344 & i1111111117) | (i1111111117 & 458752) | (i1111111115 & 3670016) | (i1111111116 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical119;
                z5 = z3;
                paddingValues4 = paddingValues1111;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i3 |= 24576;
        z3 = z;
        i9 = i2 & 32;
        if (i9 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            verticalM399spacedBy0680j_4 = vertical;
        } else {
            verticalM399spacedBy0680j_4 = vertical;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(verticalM399spacedBy0680j_4)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
        }
        i11 = i2 & 64;
        if (i11 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i12 = 1048576;
            } else {
                i12 = 524288;
            }
            i3 |= i12;
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
        }
        i13 = i2 & 256;
        if (i13 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i14 = 67108864;
            } else {
                i14 = 33554432;
            }
            i3 |= i14;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
            }
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i1111111118 = i3 >> 3;
                int i1111111119 = i3 << 6;
                int i11111111110 = i3 << 3;
                Arrangement.Vertical vertical1110 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues1112 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i1111111118 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i1111111118 & 29360128) | (i1111111119 & 7168) | 56 | (57344 & i11111111110) | (i11111111110 & 458752) | (i1111111118 & 3670016) | (i1111111119 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical1110;
                z5 = z3;
                paddingValues4 = paddingValues1112;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                    }
                    if (i11 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
                }
                int i11111111111 = i3 >> 3;
                int i11111111112 = i3 << 6;
                int i11111111113 = i3 << 3;
                Arrangement.Vertical vertical1111 = verticalM399spacedBy0680j_4;
                PaddingValues paddingValues1113 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11111111111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11111111111 & 29360128) | (i11111111112 & 7168) | 56 | (57344 & i11111111113) | (i11111111113 & 458752) | (i11111111111 & 3670016) | (i11111111112 & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                vertical2 = vertical1111;
                z5 = z3;
                paddingValues4 = paddingValues1113;
                f2 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i15 = 805306368;
        i3 |= i15;
        if (i4 != 4) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
            }
            int i11111111114 = i3 >> 3;
            int i11111111115 = i3 << 6;
            int i11111111116 = i3 << 3;
            Arrangement.Vertical vertical1112 = verticalM399spacedBy0680j_4;
            PaddingValues paddingValues1114 = paddingValues3;
            LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11111111114 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11111111114 & 29360128) | (i11111111115 & 7168) | 56 | (57344 & i11111111116) | (i11111111116 & 458752) | (i11111111114 & 3670016) | (i11111111115 & 234881024), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
            vertical2 = vertical1112;
            z5 = z3;
            paddingValues4 = paddingValues1114;
            f2 = fM5160constructorimpl;
            flingBehavior3 = flingBehavior2;
            z6 = z4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    verticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    verticalM399spacedBy0680j_4 = verticalM399spacedBy0680j_4;
                }
                if (i11 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-8666074, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:151)");
            }
            int i11111111117 = i3 >> 3;
            int i11111111118 = i3 << 6;
            int i11111111119 = i3 << 3;
            Arrangement.Vertical vertical1113 = verticalM399spacedBy0680j_4;
            PaddingValues paddingValues1115 = paddingValues3;
            LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Horizontal, rememberRowSlots(staggeredGridCells, verticalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 12) & 112) | (i11111111117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, verticalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, (i11111111117 & 29360128) | (i11111111118 & 7168) | 56 | (57344 & i11111111119) | (i11111111119 & 458752) | (i11111111117 & 3670016) | (i11111111118 & 234881024), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
            vertical2 = vertical1113;
            z5 = z3;
            paddingValues4 = paddingValues1115;
            f2 = fM5160constructorimpl;
            flingBehavior3 = flingBehavior2;
            z6 = z4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, vertical2, f2, flingBehavior3, z6, interfaceC3750qp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0122  */
    /* JADX WARN: Code duplicated, block: B:102:0x0127  */
    /* JADX WARN: Code duplicated, block: B:108:0x014a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0154  */
    /* JADX WARN: Code duplicated, block: B:120:0x0177 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x0179  */
    /* JADX WARN: Code duplicated, block: B:124:0x017f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0187  */
    /* JADX WARN: Code duplicated, block: B:127:0x018b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0195  */
    /* JADX WARN: Code duplicated, block: B:130:0x0198  */
    /* JADX WARN: Code duplicated, block: B:132:0x019b  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:150:0x0250  */
    /* JADX WARN: Code duplicated, block: B:155:0x0269  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x0104  */
    /* JADX WARN: Code duplicated, block: B:88:0x0107  */
    /* JADX WARN: Code duplicated, block: B:92:0x010f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x0119  */
    /* JADX WARN: Code duplicated, block: B:99:0x011f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LazyVerticalStaggeredGrid-zadm560, reason: not valid java name */
    public static final void m654LazyVerticalStaggeredGridzadm560(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        int i7;
        boolean z3;
        int i8;
        int i9;
        float f2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        LazyStaggeredGridState lazyStaggeredGridStateRememberLazyStaggeredGridState;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        float fM5160constructorimpl;
        Arrangement.Horizontal horizontalM399spacedBy0680j_4;
        FlingBehavior flingBehavior2;
        boolean z4;
        PaddingValues paddingValues3;
        Modifier modifier3;
        LazyStaggeredGridState lazyStaggeredGridState2;
        Arrangement.Horizontal horizontal2;
        boolean z5;
        PaddingValues paddingValues4;
        float f3;
        FlingBehavior flingBehavior3;
        boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(staggeredGridCells, "columns");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1695323794);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                i7 = i2 & 16;
                if (i7 != 0) {
                    if ((i & 57344) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    i9 = i2 & 32;
                    if (i9 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        f2 = f;
                    } else {
                        f2 = f;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changed(f2)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                    }
                    i11 = i2 & 64;
                    if (i11 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i3 |= i12;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                    }
                    i13 = i2 & 256;
                    if (i13 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i3 |= i14;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i15 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i15 = 268435456;
                            }
                        }
                        if (i4 != 4 && (1533916891 & i3) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            lazyStaggeredGridState2 = lazyStaggeredGridState;
                            horizontal2 = horizontal;
                            flingBehavior3 = flingBehavior;
                            modifier3 = modifier2;
                            paddingValues4 = paddingValues2;
                            f3 = f2;
                            z5 = z3;
                            z6 = z2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                                }
                                if (i5 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                                }
                                if (i7 != 0) {
                                    z3 = false;
                                }
                                if (i9 != 0) {
                                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                                } else {
                                    fM5160constructorimpl = f2;
                                }
                                if (i11 != 0) {
                                    horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    horizontalM399spacedBy0680j_4 = horizontal;
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i13 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = z2;
                                }
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if (i4 != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                                flingBehavior2 = flingBehavior;
                                z4 = z2;
                                modifier2 = modifier2;
                                fM5160constructorimpl = f2;
                                z3 = z3;
                                horizontalM399spacedBy0680j_4 = horizontal;
                                paddingValues3 = paddingValues2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                            }
                            int i17 = i3 >> 3;
                            int i18 = i3 << 3;
                            Arrangement.Horizontal horizontal3 = horizontalM399spacedBy0680j_4;
                            PaddingValues paddingValues5 = paddingValues3;
                            LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i17 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i18) | (i18 & 458752) | (i17 & 3670016) | (i17 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                            horizontal2 = horizontal3;
                            z5 = z3;
                            paddingValues4 = paddingValues5;
                            f3 = fM5160constructorimpl;
                            flingBehavior3 = flingBehavior2;
                            z6 = z4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                    }
                    i15 = 805306368;
                    i3 |= i15;
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i19 = i3 >> 3;
                        int i110 = i3 << 3;
                        Arrangement.Horizontal horizontal4 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues6 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i19 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i110) | (i110 & 458752) | (i19 & 3670016) | (i19 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal4;
                        z5 = z3;
                        paddingValues4 = paddingValues6;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i111 = i3 >> 3;
                        int i112 = i3 << 3;
                        Arrangement.Horizontal horizontal5 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues7 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i112) | (i112 & 458752) | (i111 & 3670016) | (i111 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal5;
                        z5 = z3;
                        paddingValues4 = paddingValues7;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i3 |= 24576;
                z3 = z;
                i9 = i2 & 32;
                if (i9 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                i11 = i2 & 64;
                if (i11 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                    }
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i113 = i3 >> 3;
                        int i114 = i3 << 3;
                        Arrangement.Horizontal horizontal6 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues8 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i114) | (i114 & 458752) | (i113 & 3670016) | (i113 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal6;
                        z5 = z3;
                        paddingValues4 = paddingValues8;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i115 = i3 >> 3;
                        int i116 = i3 << 3;
                        Arrangement.Horizontal horizontal7 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues9 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i116) | (i116 & 458752) | (i115 & 3670016) | (i115 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal7;
                        z5 = z3;
                        paddingValues4 = paddingValues9;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i15 = 805306368;
                i3 |= i15;
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i117 = i3 >> 3;
                    int i118 = i3 << 3;
                    Arrangement.Horizontal horizontal8 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues10 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i118) | (i118 & 458752) | (i117 & 3670016) | (i117 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal8;
                    z5 = z3;
                    paddingValues4 = paddingValues10;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i119 = i3 >> 3;
                    int i1110 = i3 << 3;
                    Arrangement.Horizontal horizontal9 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues11 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1110) | (i1110 & 458752) | (i119 & 3670016) | (i119 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal9;
                    z5 = z3;
                    paddingValues4 = paddingValues11;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                i9 = i2 & 32;
                if (i9 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                i11 = i2 & 64;
                if (i11 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                    }
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i1111 = i3 >> 3;
                        int i1112 = i3 << 3;
                        Arrangement.Horizontal horizontal10 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues12 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1112) | (i1112 & 458752) | (i1111 & 3670016) | (i1111 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal10;
                        z5 = z3;
                        paddingValues4 = paddingValues12;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i1113 = i3 >> 3;
                        int i1114 = i3 << 3;
                        Arrangement.Horizontal horizontal11 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues13 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1114) | (i1114 & 458752) | (i1113 & 3670016) | (i1113 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal11;
                        z5 = z3;
                        paddingValues4 = paddingValues13;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i15 = 805306368;
                i3 |= i15;
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i1115 = i3 >> 3;
                    int i1116 = i3 << 3;
                    Arrangement.Horizontal horizontal12 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues14 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1116) | (i1116 & 458752) | (i1115 & 3670016) | (i1115 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal12;
                    z5 = z3;
                    paddingValues4 = paddingValues14;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i1117 = i3 >> 3;
                    int i1118 = i3 << 3;
                    Arrangement.Horizontal horizontal13 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues15 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1118) | (i1118 & 458752) | (i1117 & 3670016) | (i1117 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal13;
                    z5 = z3;
                    paddingValues4 = paddingValues15;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            i9 = i2 & 32;
            if (i9 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            i11 = i2 & 64;
            if (i11 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i13 = i2 & 256;
            if (i13 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i1119 = i3 >> 3;
                    int i11110 = i3 << 3;
                    Arrangement.Horizontal horizontal14 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues16 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11110) | (i11110 & 458752) | (i1119 & 3670016) | (i1119 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal14;
                    z5 = z3;
                    paddingValues4 = paddingValues16;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i11111 = i3 >> 3;
                    int i11112 = i3 << 3;
                    Arrangement.Horizontal horizontal15 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues17 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11112) | (i11112 & 458752) | (i11111 & 3670016) | (i11111 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal15;
                    z5 = z3;
                    paddingValues4 = paddingValues17;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i15 = 805306368;
            i3 |= i15;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i11113 = i3 >> 3;
                int i11114 = i3 << 3;
                Arrangement.Horizontal horizontal16 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues18 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11114) | (i11114 & 458752) | (i11113 & 3670016) | (i11113 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal16;
                z5 = z3;
                paddingValues4 = paddingValues18;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i11115 = i3 >> 3;
                int i11116 = i3 << 3;
                Arrangement.Horizontal horizontal17 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues19 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11116) | (i11116 & 458752) | (i11115 & 3670016) | (i11115 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal17;
                z5 = z3;
                paddingValues4 = paddingValues19;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 128;
        }
        i5 = i2 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                i9 = i2 & 32;
                if (i9 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                }
                i11 = i2 & 64;
                if (i11 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i13 = i2 & 256;
                if (i13 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                    }
                    if (i4 != 4) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i11117 = i3 >> 3;
                        int i11118 = i3 << 3;
                        Arrangement.Horizontal horizontal18 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues110 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11118) | (i11118 & 458752) | (i11117 & 3670016) | (i11117 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal18;
                        z5 = z3;
                        paddingValues4 = paddingValues110;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                            }
                            if (i5 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i7 != 0) {
                                z3 = false;
                            }
                            if (i9 != 0) {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            } else {
                                fM5160constructorimpl = f2;
                            }
                            if (i11 != 0) {
                                horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                horizontalM399spacedBy0680j_4 = horizontal;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i13 != 0) {
                                z4 = true;
                            } else {
                                z4 = z2;
                            }
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                        }
                        int i11119 = i3 >> 3;
                        int i111110 = i3 << 3;
                        Arrangement.Horizontal horizontal19 = horizontalM399spacedBy0680j_4;
                        PaddingValues paddingValues111 = paddingValues3;
                        LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i111110) | (i111110 & 458752) | (i11119 & 3670016) | (i11119 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                        horizontal2 = horizontal19;
                        z5 = z3;
                        paddingValues4 = paddingValues111;
                        f3 = fM5160constructorimpl;
                        flingBehavior3 = flingBehavior2;
                        z6 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
                }
                i15 = 805306368;
                i3 |= i15;
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i111111 = i3 >> 3;
                    int i111112 = i3 << 3;
                    Arrangement.Horizontal horizontal110 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues112 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i111112) | (i111112 & 458752) | (i111111 & 3670016) | (i111111 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal110;
                    z5 = z3;
                    paddingValues4 = paddingValues112;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i111113 = i3 >> 3;
                    int i111114 = i3 << 3;
                    Arrangement.Horizontal horizontal111 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues113 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i111114) | (i111114 & 458752) | (i111113 & 3670016) | (i111113 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal111;
                    z5 = z3;
                    paddingValues4 = paddingValues113;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            i9 = i2 & 32;
            if (i9 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            i11 = i2 & 64;
            if (i11 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i13 = i2 & 256;
            if (i13 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i111115 = i3 >> 3;
                    int i111116 = i3 << 3;
                    Arrangement.Horizontal horizontal112 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues114 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i111116) | (i111116 & 458752) | (i111115 & 3670016) | (i111115 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal112;
                    z5 = z3;
                    paddingValues4 = paddingValues114;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i111117 = i3 >> 3;
                    int i111118 = i3 << 3;
                    Arrangement.Horizontal horizontal113 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues115 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i111118) | (i111118 & 458752) | (i111117 & 3670016) | (i111117 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal113;
                    z5 = z3;
                    paddingValues4 = paddingValues115;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i15 = 805306368;
            i3 |= i15;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i111119 = i3 >> 3;
                int i1111110 = i3 << 3;
                Arrangement.Horizontal horizontal114 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues116 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1111110) | (i1111110 & 458752) | (i111119 & 3670016) | (i111119 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal114;
                z5 = z3;
                paddingValues4 = paddingValues116;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i1111111 = i3 >> 3;
                int i1111112 = i3 << 3;
                Arrangement.Horizontal horizontal115 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues117 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1111112) | (i1111112 & 458752) | (i1111111 & 3670016) | (i1111111 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal115;
                z5 = z3;
                paddingValues4 = paddingValues117;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i7 = i2 & 16;
        if (i7 != 0) {
            if ((i & 57344) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            i9 = i2 & 32;
            if (i9 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
            }
            i11 = i2 & 64;
            if (i11 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i13 = i2 & 256;
            if (i13 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i1111113 = i3 >> 3;
                    int i1111114 = i3 << 3;
                    Arrangement.Horizontal horizontal116 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues118 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1111114) | (i1111114 & 458752) | (i1111113 & 3670016) | (i1111113 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal116;
                    z5 = z3;
                    paddingValues4 = paddingValues118;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i4 != 0) {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                        }
                        if (i5 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i7 != 0) {
                            z3 = false;
                        }
                        if (i9 != 0) {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        } else {
                            fM5160constructorimpl = f2;
                        }
                        if (i11 != 0) {
                            horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            horizontalM399spacedBy0680j_4 = horizontal;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i13 != 0) {
                            z4 = true;
                        } else {
                            z4 = z2;
                        }
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                    }
                    int i1111115 = i3 >> 3;
                    int i1111116 = i3 << 3;
                    Arrangement.Horizontal horizontal117 = horizontalM399spacedBy0680j_4;
                    PaddingValues paddingValues119 = paddingValues3;
                    LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1111116) | (i1111116 & 458752) | (i1111115 & 3670016) | (i1111115 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                    horizontal2 = horizontal117;
                    z5 = z3;
                    paddingValues4 = paddingValues119;
                    f3 = fM5160constructorimpl;
                    flingBehavior3 = flingBehavior2;
                    z6 = z4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
            }
            i15 = 805306368;
            i3 |= i15;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i1111117 = i3 >> 3;
                int i1111118 = i3 << 3;
                Arrangement.Horizontal horizontal118 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues1110 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i1111118) | (i1111118 & 458752) | (i1111117 & 3670016) | (i1111117 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal118;
                z5 = z3;
                paddingValues4 = paddingValues1110;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i1111119 = i3 >> 3;
                int i11111110 = i3 << 3;
                Arrangement.Horizontal horizontal119 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues1111 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111119 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11111110) | (i11111110 & 458752) | (i1111119 & 3670016) | (i1111119 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal119;
                z5 = z3;
                paddingValues4 = paddingValues1111;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i3 |= 24576;
        z3 = z;
        i9 = i2 & 32;
        if (i9 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
        }
        i11 = i2 & 64;
        if (i11 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(horizontal)) {
                i12 = 1048576;
            } else {
                i12 = 524288;
            }
            i3 |= i12;
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
        }
        i13 = i2 & 256;
        if (i13 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i14 = 67108864;
            } else {
                i14 = 33554432;
            }
            i3 |= i14;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
            }
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i11111111 = i3 >> 3;
                int i11111112 = i3 << 3;
                Arrangement.Horizontal horizontal1110 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues1112 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11111112) | (i11111112 & 458752) | (i11111111 & 3670016) | (i11111111 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal1110;
                z5 = z3;
                paddingValues4 = paddingValues1112;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                    }
                    if (i5 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i7 != 0) {
                        z3 = false;
                    }
                    if (i9 != 0) {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    } else {
                        fM5160constructorimpl = f2;
                    }
                    if (i11 != 0) {
                        horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        horizontalM399spacedBy0680j_4 = horizontal;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i13 != 0) {
                        z4 = true;
                    } else {
                        z4 = z2;
                    }
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
                }
                int i11111113 = i3 >> 3;
                int i11111114 = i3 << 3;
                Arrangement.Horizontal horizontal1111 = horizontalM399spacedBy0680j_4;
                PaddingValues paddingValues1113 = paddingValues3;
                LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111113 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11111114) | (i11111114 & 458752) | (i11111113 & 3670016) | (i11111113 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
                horizontal2 = horizontal1111;
                z5 = z3;
                paddingValues4 = paddingValues1113;
                f3 = fM5160constructorimpl;
                flingBehavior3 = flingBehavior2;
                z6 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
        }
        i15 = 805306368;
        i3 |= i15;
        if (i4 != 4) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f2;
                }
                if (i11 != 0) {
                    horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    horizontalM399spacedBy0680j_4 = horizontal;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f2;
                }
                if (i11 != 0) {
                    horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    horizontalM399spacedBy0680j_4 = horizontal;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
            }
            int i11111115 = i3 >> 3;
            int i11111116 = i3 << 3;
            Arrangement.Horizontal horizontal1112 = horizontalM399spacedBy0680j_4;
            PaddingValues paddingValues1114 = paddingValues3;
            LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111115 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11111116) | (i11111116 & 458752) | (i11111115 & 3670016) | (i11111115 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
            horizontal2 = horizontal1112;
            z5 = z3;
            paddingValues4 = paddingValues1114;
            f3 = fM5160constructorimpl;
            flingBehavior3 = flingBehavior2;
            z6 = z4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f2;
                }
                if (i11 != 0) {
                    horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    horizontalM399spacedBy0680j_4 = horizontal;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i4 != 0) {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyStaggeredGridStateRememberLazyStaggeredGridState = lazyStaggeredGridState;
                }
                if (i5 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i7 != 0) {
                    z3 = false;
                }
                if (i9 != 0) {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                } else {
                    fM5160constructorimpl = f2;
                }
                if (i11 != 0) {
                    horizontalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    horizontalM399spacedBy0680j_4 = horizontal;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i13 != 0) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1695323794, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:61)");
            }
            int i11111117 = i3 >> 3;
            int i11111118 = i3 << 3;
            Arrangement.Horizontal horizontal1113 = horizontalM399spacedBy0680j_4;
            PaddingValues paddingValues1115 = paddingValues3;
            LazyStaggeredGridKt.m659LazyStaggeredGridLJWHXA8(lazyStaggeredGridStateRememberLazyStaggeredGridState, Orientation.Vertical, rememberColumnSlots(staggeredGridCells, horizontalM399spacedBy0680j_4, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111117 & 896)), modifier2, paddingValues3, z3, flingBehavior2, z4, fM5160constructorimpl, horizontalM399spacedBy0680j_4.mo405getSpacingD9Ej5fM(), interfaceC3750qp, composerStartRestartGroup, ((i3 << 6) & 7168) | 56 | (57344 & i11111118) | (i11111118 & 458752) | (i11111117 & 3670016) | (i11111117 & 29360128) | ((i3 << 9) & 234881024), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            lazyStaggeredGridState2 = lazyStaggeredGridStateRememberLazyStaggeredGridState;
            horizontal2 = horizontal1113;
            z5 = z3;
            paddingValues4 = paddingValues1115;
            f3 = fM5160constructorimpl;
            flingBehavior3 = flingBehavior2;
            z6 = z4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(staggeredGridCells, modifier3, lazyStaggeredGridState2, paddingValues4, z5, f3, horizontal2, flingBehavior3, z6, interfaceC3750qp, i, i2));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyStaggeredGridScope.items(list.size(), interfaceC3750qp != null ? new LazyStaggeredGridDslKt$items$2$1(interfaceC3750qp, list) : null, new AnonymousClass3(interfaceC3750qp2, list), interfaceC3750qp3 != null ? new LazyStaggeredGridDslKt$items$4$1(interfaceC3750qp3, list) : null, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new AnonymousClass5(interfaceC0578Hp, list)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 4) != 0) {
            interfaceC3750qp2 = AnonymousClass1.INSTANCE;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp3 = null;
        }
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyStaggeredGridScope.items(list.size(), interfaceC3750qp != null ? new LazyStaggeredGridDslKt$items$2$1(interfaceC3750qp, list) : null, new AnonymousClass3(interfaceC3750qp2, list), interfaceC3750qp3 != null ? new LazyStaggeredGridDslKt$items$4$1(interfaceC3750qp3, list) : null, ComposableLambdaKt.composableLambdaInstance(-886456479, true, new AnonymousClass5(interfaceC0578Hp, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyStaggeredGridScope.items(list.size(), interfaceC0526Fp != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(interfaceC0526Fp, list) : null, new C13833(interfaceC0526Fp2, list), interfaceC0526Fp3 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(interfaceC0526Fp3, list) : null, ComposableLambdaKt.composableLambdaInstance(284833944, true, new C13845(interfaceC0604Ip, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0526Fp2 = C13811.INSTANCE;
        }
        if ((i & 8) != 0) {
            interfaceC0526Fp3 = null;
        }
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyStaggeredGridScope.items(list.size(), interfaceC0526Fp != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(interfaceC0526Fp, list) : null, new C13833(interfaceC0526Fp2, list), interfaceC0526Fp3 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(interfaceC0526Fp3, list) : null, ComposableLambdaKt.composableLambdaInstance(284833944, true, new C13845(interfaceC0604Ip, list)));
    }

    @Composable
    private static final InterfaceC0526Fp rememberColumnSlots(StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1038659655);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1038659655, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:90)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(staggeredGridCells) | composer.changed(horizontal) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$rememberColumnSlots$1$1(paddingValues, staggeredGridCells, horizontal));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC0526Fp interfaceC0526Fp = (InterfaceC0526Fp) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC0526Fp;
    }

    @Composable
    private static final InterfaceC0526Fp rememberRowSlots(StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-675899235);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-675899235, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:180)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(staggeredGridCells) | composer.changed(vertical) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$rememberRowSlots$1$1(paddingValues, staggeredGridCells, vertical));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC0526Fp interfaceC0526Fp = (InterfaceC0526Fp) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC0526Fp;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyStaggeredGridScope.items(tArr.length, interfaceC3750qp != null ? new LazyStaggeredGridDslKt$items$7$1(interfaceC3750qp, tArr) : null, new AnonymousClass8(interfaceC3750qp2, tArr), interfaceC3750qp3 != null ? new LazyStaggeredGridDslKt$items$9$1(interfaceC3750qp3, tArr) : null, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new AnonymousClass10(interfaceC0578Hp, tArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyStaggeredGridScope.items(tArr.length, interfaceC0526Fp != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(interfaceC0526Fp, tArr) : null, new C13868(interfaceC0526Fp2, tArr), interfaceC0526Fp3 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(interfaceC0526Fp3, tArr) : null, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new C138210(interfaceC0604Ip, tArr)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 4) != 0) {
            interfaceC3750qp2 = AnonymousClass6.INSTANCE;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp3 = null;
        }
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyStaggeredGridScope.items(objArr.length, interfaceC3750qp != null ? new LazyStaggeredGridDslKt$items$7$1(interfaceC3750qp, objArr) : null, new AnonymousClass8(interfaceC3750qp2, objArr), interfaceC3750qp3 != null ? new LazyStaggeredGridDslKt$items$9$1(interfaceC3750qp3, objArr) : null, ComposableLambdaKt.composableLambdaInstance(2101296000, true, new AnonymousClass10(interfaceC0578Hp, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0526Fp2 = C13856.INSTANCE;
        }
        if ((i & 8) != 0) {
            interfaceC0526Fp3 = null;
        }
        AbstractC4492zt.h(lazyStaggeredGridScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyStaggeredGridScope.items(objArr.length, interfaceC0526Fp != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(interfaceC0526Fp, objArr) : null, new C13868(interfaceC0526Fp2, objArr), interfaceC0526Fp3 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(interfaceC0526Fp3, objArr) : null, ComposableLambdaKt.composableLambdaInstance(-804487775, true, new C138210(interfaceC0604Ip, objArr)));
    }
}
