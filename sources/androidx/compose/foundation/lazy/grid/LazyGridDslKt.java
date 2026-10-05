package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
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
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ GridCells $rows;
        final /* synthetic */ LazyGridState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, int i, int i2) {
            super(2);
            this.$rows = gridCells;
            this.$modifier = modifier;
            this.$state = lazyGridState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$horizontalArrangement = horizontal;
            this.$verticalArrangement = vertical;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z2;
            this.$content = interfaceC3750qp;
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
            LazyGridDslKt.LazyHorizontalGrid(this.$rows, this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$horizontalArrangement, this.$verticalArrangement, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13671 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ GridCells $columns;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyGridState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13671(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, int i, int i2) {
            super(2);
            this.$columns = gridCells;
            this.$modifier = modifier;
            this.$state = lazyGridState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$verticalArrangement = vertical;
            this.$horizontalArrangement = horizontal;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z2;
            this.$content = interfaceC3750qp;
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
            LazyGridDslKt.LazyVerticalGrid(this.$columns, this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$verticalArrangement, this.$horizontalArrangement, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13681 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13681 INSTANCE = new C13681();

        public C13681() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$10, reason: invalid class name */
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
            invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(407562193, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:520)");
            }
            this.$itemContent.invoke(lazyGridItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ InterfaceC3750qp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp, List<? extends T> list) {
            super(1);
            this.$key = interfaceC3750qp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$key.invoke(this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ InterfaceC0526Fp $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, List<? extends T> list) {
            super(2);
            this.$span = interfaceC0526Fp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return GridItemSpan.m598boximpl(m607invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m607invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            AbstractC4492zt.h(lazyGridItemSpanScope, "$this$null");
            return ((GridItemSpan) this.$span.mo13invoke(lazyGridItemSpanScope, this.$items.get(i))).m605unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(InterfaceC3750qp interfaceC3750qp, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$5, reason: invalid class name */
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
            invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(699646206, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:454)");
            }
            this.$itemContent.invoke(lazyGridItemScope, this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$6, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ T[] $items;
        final /* synthetic */ InterfaceC3750qp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(InterfaceC3750qp interfaceC3750qp, T[] tArr) {
            super(1);
            this.$key = interfaceC3750qp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$key.invoke(this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$8, reason: invalid class name */
    public static final class AnonymousClass8 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ T[] $items;
        final /* synthetic */ InterfaceC0526Fp $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(InterfaceC0526Fp interfaceC0526Fp, T[] tArr) {
            super(2);
            this.$span = interfaceC0526Fp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return GridItemSpan.m598boximpl(m608invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m608invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            AbstractC4492zt.h(lazyGridItemSpanScope, "$this$null");
            return ((GridItemSpan) this.$span.mo13invoke(lazyGridItemSpanScope, this.$items[i])).m605unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$9, reason: invalid class name */
    public static final class AnonymousClass9 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(InterfaceC3750qp interfaceC3750qp, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13691 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C13691 INSTANCE = new C13691();

        public C13691() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    public static final class C137010 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0604Ip $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C137010(InterfaceC0604Ip interfaceC0604Ip, T[] tArr) {
            super(4);
            this.$itemContent = interfaceC0604Ip;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(-911455938, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:553)");
            }
            this.$itemContent.invoke(lazyGridItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13712 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ InterfaceC0526Fp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13712(InterfaceC0526Fp interfaceC0526Fp, List<? extends T> list) {
            super(1);
            this.$key = interfaceC0526Fp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$key.mo13invoke(Integer.valueOf(i), this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13723 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ InterfaceC0552Gp $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13723(InterfaceC0552Gp interfaceC0552Gp, List<? extends T> list) {
            super(2);
            this.$span = interfaceC0552Gp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return GridItemSpan.m598boximpl(m609invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m609invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            AbstractC4492zt.h(lazyGridItemSpanScope, "$this$null");
            return ((GridItemSpan) this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), this.$items.get(i))).m605unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    public static final class C13734 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13734(InterfaceC0526Fp interfaceC0526Fp, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    public static final class C13745 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0604Ip $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13745(InterfaceC0604Ip interfaceC0604Ip, List<? extends T> list) {
            super(4);
            this.$itemContent = interfaceC0604Ip;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyGridItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(1229287273, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:487)");
            }
            this.$itemContent.invoke(lazyGridItemScope, Integer.valueOf(i), this.$items.get(i), composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$6, reason: invalid class name and case insensitive filesystem */
    public static final class C13756 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C13756 INSTANCE = new C13756();

        public C13756() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    public static final class C13767 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ T[] $items;
        final /* synthetic */ InterfaceC0526Fp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13767(InterfaceC0526Fp interfaceC0526Fp, T[] tArr) {
            super(1);
            this.$key = interfaceC0526Fp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final Object invoke(int i) {
            return this.$key.mo13invoke(Integer.valueOf(i), this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    public static final class C13778 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ T[] $items;
        final /* synthetic */ InterfaceC0552Gp $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13778(InterfaceC0552Gp interfaceC0552Gp, T[] tArr) {
            super(2);
            this.$span = interfaceC0552Gp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return GridItemSpan.m598boximpl(m610invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m610invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            AbstractC4492zt.h(lazyGridItemSpanScope, "$this$null");
            return ((GridItemSpan) this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), this.$items[i])).m605unboximpl();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$9, reason: invalid class name and case insensitive filesystem */
    public static final class C13789 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13789(InterfaceC0526Fp interfaceC0526Fp, T[] tArr) {
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

    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:103:0x0126  */
    /* JADX WARN: Code duplicated, block: B:105:0x012a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0130  */
    /* JADX WARN: Code duplicated, block: B:108:0x0133  */
    /* JADX WARN: Code duplicated, block: B:111:0x013f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0158  */
    /* JADX WARN: Code duplicated, block: B:117:0x0165  */
    /* JADX WARN: Code duplicated, block: B:130:0x0190 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x0192  */
    /* JADX WARN: Code duplicated, block: B:132:0x0195  */
    /* JADX WARN: Code duplicated, block: B:135:0x019c  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:147:0x01be  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:152:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:163:0x020c  */
    /* JADX WARN: Code duplicated, block: B:166:0x0272  */
    /* JADX WARN: Code duplicated, block: B:171:0x028b  */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x0102  */
    /* JADX WARN: Code duplicated, block: B:92:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0115  */
    /* JADX WARN: Code duplicated, block: B:97:0x0118  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LazyHorizontalGrid(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        LazyGridState lazyGridState2;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Horizontal horizontal2;
        int i8;
        Arrangement.Vertical vertical2;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier modifier2;
        LazyGridState lazyGridStateRememberLazyGridState;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        boolean z4;
        Arrangement.Horizontal end;
        Arrangement.Vertical top;
        FlingBehavior flingBehavior2;
        boolean z5;
        LazyGridState lazyGridState3;
        boolean z6;
        PaddingValues paddingValues3;
        Arrangement.Horizontal horizontal3;
        Arrangement.Vertical vertical3;
        FlingBehavior flingBehavior3;
        Arrangement arrangement;
        Modifier modifier3;
        Arrangement.Vertical vertical4;
        PaddingValues paddingValues4;
        LazyGridState lazyGridState4;
        boolean z7;
        Arrangement.Horizontal horizontal4;
        FlingBehavior flingBehavior4;
        boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(gridCells, "rows");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(2123608858);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    int i14 = composerStartRestartGroup.changed(lazyGridState2) ? 256 : 128;
                    i3 |= i14;
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i3 |= i14;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            horizontal2 = horizontal;
                            int i15 = composerStartRestartGroup.changed(horizontal2) ? 131072 : 65536;
                            i3 |= i15;
                        } else {
                            horizontal2 = horizontal;
                        }
                        i3 |= i15;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        vertical2 = vertical;
                    } else {
                        vertical2 = vertical;
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(vertical2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        if ((i & 1879048192) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i12 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i12 = 268435456;
                            }
                        }
                        if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if ((i2 & 4) != 0) {
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyGridStateRememberLazyGridState = lazyGridState2;
                                }
                                if (i4 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                                }
                                z4 = i6 == 0 ? z3 : false;
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        end = arrangement.getEnd();
                                    } else {
                                        end = arrangement.getStart();
                                    }
                                    i3 &= -458753;
                                } else {
                                    end = horizontal2;
                                }
                                if (i8 != 0) {
                                    top = Arrangement.INSTANCE.getTop();
                                } else {
                                    top = vertical2;
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i10 != 0) {
                                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                                    z6 = z4;
                                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                    horizontal3 = end;
                                    vertical3 = top;
                                    flingBehavior3 = flingBehavior2;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                                    z6 = z4;
                                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                    horizontal3 = end;
                                    vertical3 = top;
                                    flingBehavior3 = flingBehavior2;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                modifier2 = modifier;
                                flingBehavior3 = flingBehavior;
                                z5 = z2;
                                lazyGridState3 = lazyGridState2;
                                z6 = z3;
                                horizontal3 = horizontal2;
                                paddingValues3 = paddingValues2;
                                vertical3 = vertical2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                            }
                            int i16 = i3 >> 3;
                            Arrangement.Vertical vertical5 = vertical3;
                            PaddingValues paddingValues5 = paddingValues3;
                            LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i16 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i16 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i16 & 112) | (i3 & 7168) | (57344 & i3) | (i16 & 3670016) | (i16 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            vertical4 = vertical5;
                            paddingValues4 = paddingValues5;
                            lazyGridState4 = lazyGridState3;
                            z7 = z6;
                            horizontal4 = horizontal3;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z8 = z2;
                            lazyGridState4 = lazyGridState2;
                            paddingValues4 = paddingValues2;
                            vertical4 = vertical2;
                            z7 = z3;
                            horizontal4 = horizontal2;
                            flingBehavior4 = flingBehavior;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                    }
                    i12 = 805306368;
                    i3 |= i12;
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i17 = i3 >> 3;
                        Arrangement.Vertical vertical6 = vertical3;
                        PaddingValues paddingValues6 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i17 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i17 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i17 & 112) | (i3 & 7168) | (57344 & i3) | (i17 & 3670016) | (i17 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical6;
                        paddingValues4 = paddingValues6;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i18 = i3 >> 3;
                        Arrangement.Vertical vertical7 = vertical3;
                        PaddingValues paddingValues7 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i18 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i18 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i18 & 112) | (i3 & 7168) | (57344 & i3) | (i18 & 3670016) | (i18 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical7;
                        paddingValues4 = paddingValues7;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i3 |= 24576;
                z3 = z;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                        }
                        i3 |= i15;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i15;
                } else {
                    horizontal2 = horizontal;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    vertical2 = vertical;
                } else {
                    vertical2 = vertical;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i19 = i3 >> 3;
                        Arrangement.Vertical vertical8 = vertical3;
                        PaddingValues paddingValues8 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i19 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i19 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i19 & 112) | (i3 & 7168) | (57344 & i3) | (i19 & 3670016) | (i19 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical8;
                        paddingValues4 = paddingValues8;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i110 = i3 >> 3;
                        Arrangement.Vertical vertical9 = vertical3;
                        PaddingValues paddingValues9 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i110 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i110 & 112) | (i3 & 7168) | (57344 & i3) | (i110 & 3670016) | (i110 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical9;
                        paddingValues4 = paddingValues9;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i12 = 805306368;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i111 = i3 >> 3;
                    Arrangement.Vertical vertical10 = vertical3;
                    PaddingValues paddingValues10 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111 & 112) | (i3 & 7168) | (57344 & i3) | (i111 & 3670016) | (i111 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical10;
                    paddingValues4 = paddingValues10;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i112 = i3 >> 3;
                    Arrangement.Vertical vertical11 = vertical3;
                    PaddingValues paddingValues11 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i112 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i112 & 112) | (i3 & 7168) | (57344 & i3) | (i112 & 3670016) | (i112 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical11;
                    paddingValues4 = paddingValues11;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                        }
                        i3 |= i15;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i15;
                } else {
                    horizontal2 = horizontal;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    vertical2 = vertical;
                } else {
                    vertical2 = vertical;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i113 = i3 >> 3;
                        Arrangement.Vertical vertical12 = vertical3;
                        PaddingValues paddingValues12 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i113 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i113 & 112) | (i3 & 7168) | (57344 & i3) | (i113 & 3670016) | (i113 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical12;
                        paddingValues4 = paddingValues12;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i114 = i3 >> 3;
                        Arrangement.Vertical vertical13 = vertical3;
                        PaddingValues paddingValues13 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i114 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i114 & 112) | (i3 & 7168) | (57344 & i3) | (i114 & 3670016) | (i114 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical13;
                        paddingValues4 = paddingValues13;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i12 = 805306368;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i115 = i3 >> 3;
                    Arrangement.Vertical vertical14 = vertical3;
                    PaddingValues paddingValues14 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i115 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i115 & 112) | (i3 & 7168) | (57344 & i3) | (i115 & 3670016) | (i115 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical14;
                    paddingValues4 = paddingValues14;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i116 = i3 >> 3;
                    Arrangement.Vertical vertical15 = vertical3;
                    PaddingValues paddingValues15 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i116 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i116 & 112) | (i3 & 7168) | (57344 & i3) | (i116 & 3670016) | (i116 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical15;
                    paddingValues4 = paddingValues15;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i15;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i15;
            } else {
                horizontal2 = horizontal;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i117 = i3 >> 3;
                    Arrangement.Vertical vertical16 = vertical3;
                    PaddingValues paddingValues16 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i117 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i117 & 112) | (i3 & 7168) | (57344 & i3) | (i117 & 3670016) | (i117 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical16;
                    paddingValues4 = paddingValues16;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i118 = i3 >> 3;
                    Arrangement.Vertical vertical17 = vertical3;
                    PaddingValues paddingValues17 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i118 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i118 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i118 & 112) | (i3 & 7168) | (57344 & i3) | (i118 & 3670016) | (i118 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical17;
                    paddingValues4 = paddingValues17;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i119 = i3 >> 3;
                Arrangement.Vertical vertical18 = vertical3;
                PaddingValues paddingValues18 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i119 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i119 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i119 & 112) | (i3 & 7168) | (57344 & i3) | (i119 & 3670016) | (i119 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical18;
                paddingValues4 = paddingValues18;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i1110 = i3 >> 3;
                Arrangement.Vertical vertical19 = vertical3;
                PaddingValues paddingValues19 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1110 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1110 & 112) | (i3 & 7168) | (57344 & i3) | (i1110 & 3670016) | (i1110 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical19;
                paddingValues4 = paddingValues19;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 48;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                lazyGridState2 = lazyGridState;
                if (composerStartRestartGroup.changed(lazyGridState2)) {
                }
                i3 |= i14;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i3 |= i14;
        } else {
            lazyGridState2 = lazyGridState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                        }
                        i3 |= i15;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i15;
                } else {
                    horizontal2 = horizontal;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    vertical2 = vertical;
                } else {
                    vertical2 = vertical;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i1111 = i3 >> 3;
                        Arrangement.Vertical vertical110 = vertical3;
                        PaddingValues paddingValues110 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111 & 112) | (i3 & 7168) | (57344 & i3) | (i1111 & 3670016) | (i1111 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical110;
                        paddingValues4 = paddingValues110;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                        }
                        int i1112 = i3 >> 3;
                        Arrangement.Vertical vertical111 = vertical3;
                        PaddingValues paddingValues111 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1112 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1112 & 112) | (i3 & 7168) | (57344 & i3) | (i1112 & 3670016) | (i1112 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        vertical4 = vertical111;
                        paddingValues4 = paddingValues111;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i12 = 805306368;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i1113 = i3 >> 3;
                    Arrangement.Vertical vertical112 = vertical3;
                    PaddingValues paddingValues112 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1113 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1113 & 112) | (i3 & 7168) | (57344 & i3) | (i1113 & 3670016) | (i1113 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical112;
                    paddingValues4 = paddingValues112;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i1114 = i3 >> 3;
                    Arrangement.Vertical vertical113 = vertical3;
                    PaddingValues paddingValues113 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1114 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1114 & 112) | (i3 & 7168) | (57344 & i3) | (i1114 & 3670016) | (i1114 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical113;
                    paddingValues4 = paddingValues113;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i15;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i15;
            } else {
                horizontal2 = horizontal;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i1115 = i3 >> 3;
                    Arrangement.Vertical vertical114 = vertical3;
                    PaddingValues paddingValues114 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1115 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1115 & 112) | (i3 & 7168) | (57344 & i3) | (i1115 & 3670016) | (i1115 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical114;
                    paddingValues4 = paddingValues114;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i1116 = i3 >> 3;
                    Arrangement.Vertical vertical115 = vertical3;
                    PaddingValues paddingValues115 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1116 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1116 & 112) | (i3 & 7168) | (57344 & i3) | (i1116 & 3670016) | (i1116 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical115;
                    paddingValues4 = paddingValues115;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i1117 = i3 >> 3;
                Arrangement.Vertical vertical116 = vertical3;
                PaddingValues paddingValues116 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1117 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1117 & 112) | (i3 & 7168) | (57344 & i3) | (i1117 & 3670016) | (i1117 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical116;
                paddingValues4 = paddingValues116;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i1118 = i3 >> 3;
                Arrangement.Vertical vertical117 = vertical3;
                PaddingValues paddingValues117 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1118 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1118 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1118 & 112) | (i3 & 7168) | (57344 & i3) | (i1118 & 3670016) | (i1118 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical117;
                paddingValues4 = paddingValues117;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i15;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i15;
            } else {
                horizontal2 = horizontal;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i1119 = i3 >> 3;
                    Arrangement.Vertical vertical118 = vertical3;
                    PaddingValues paddingValues118 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1119 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i1119 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1119 & 112) | (i3 & 7168) | (57344 & i3) | (i1119 & 3670016) | (i1119 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical118;
                    paddingValues4 = paddingValues118;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                    }
                    int i11110 = i3 >> 3;
                    Arrangement.Vertical vertical119 = vertical3;
                    PaddingValues paddingValues119 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11110 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i11110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11110 & 112) | (i3 & 7168) | (57344 & i3) | (i11110 & 3670016) | (i11110 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    vertical4 = vertical119;
                    paddingValues4 = paddingValues119;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i11111 = i3 >> 3;
                Arrangement.Vertical vertical1110 = vertical3;
                PaddingValues paddingValues1110 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i11111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111 & 112) | (i3 & 7168) | (57344 & i3) | (i11111 & 3670016) | (i11111 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical1110;
                paddingValues4 = paddingValues1110;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i11112 = i3 >> 3;
                Arrangement.Vertical vertical1111 = vertical3;
                PaddingValues paddingValues1111 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11112 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i11112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11112 & 112) | (i3 & 7168) | (57344 & i3) | (i11112 & 3670016) | (i11112 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical1111;
                paddingValues4 = paddingValues1111;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 24576;
        z3 = z;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                }
                i3 |= i15;
            } else {
                horizontal2 = horizontal;
            }
            i3 |= i15;
        } else {
            horizontal2 = horizontal;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            vertical2 = vertical;
        } else {
            vertical2 = vertical;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i2 & 512) != 0) {
            if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i11113 = i3 >> 3;
                Arrangement.Vertical vertical1112 = vertical3;
                PaddingValues paddingValues1112 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11113 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i11113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11113 & 112) | (i3 & 7168) | (57344 & i3) | (i11113 & 3670016) | (i11113 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical1112;
                paddingValues4 = paddingValues1112;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
                }
                int i11114 = i3 >> 3;
                Arrangement.Vertical vertical1113 = vertical3;
                PaddingValues paddingValues1113 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11114 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i11114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11114 & 112) | (i3 & 7168) | (57344 & i3) | (i11114 & 3670016) | (i11114 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                vertical4 = vertical1113;
                paddingValues4 = paddingValues1113;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i12 = 805306368;
        i3 |= i12;
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
            }
            int i11115 = i3 >> 3;
            Arrangement.Vertical vertical1114 = vertical3;
            PaddingValues paddingValues1114 = paddingValues3;
            LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11115 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i11115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11115 & 112) | (i3 & 7168) | (57344 & i3) | (i11115 & 3670016) | (i11115 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            vertical4 = vertical1114;
            paddingValues4 = paddingValues1114;
            lazyGridState4 = lazyGridState3;
            z7 = z6;
            horizontal4 = horizontal3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2123608858, i3, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:114)");
            }
            int i11116 = i3 >> 3;
            Arrangement.Vertical vertical1115 = vertical3;
            PaddingValues paddingValues1115 = paddingValues3;
            LazyGridKt.LazyGrid(modifier2, lazyGridState3, rememberRowHeightSums(gridCells, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11116 & 896)), paddingValues3, z6, false, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, (i11116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11116 & 112) | (i3 & 7168) | (57344 & i3) | (i11116 & 3670016) | (i11116 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            vertical4 = vertical1115;
            paddingValues4 = paddingValues1115;
            lazyGridState4 = lazyGridState3;
            z7 = z6;
            horizontal4 = horizontal3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(gridCells, modifier3, lazyGridState4, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:103:0x0126  */
    /* JADX WARN: Code duplicated, block: B:105:0x012a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0130  */
    /* JADX WARN: Code duplicated, block: B:108:0x0133  */
    /* JADX WARN: Code duplicated, block: B:111:0x013f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0158  */
    /* JADX WARN: Code duplicated, block: B:117:0x0165  */
    /* JADX WARN: Code duplicated, block: B:130:0x0190 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x0192  */
    /* JADX WARN: Code duplicated, block: B:132:0x0195  */
    /* JADX WARN: Code duplicated, block: B:135:0x019c  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:147:0x01be  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:152:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:163:0x020c  */
    /* JADX WARN: Code duplicated, block: B:166:0x026f  */
    /* JADX WARN: Code duplicated, block: B:171:0x0288  */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x0102  */
    /* JADX WARN: Code duplicated, block: B:92:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0115  */
    /* JADX WARN: Code duplicated, block: B:97:0x0118  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LazyVerticalGrid(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        LazyGridState lazyGridState2;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Vertical vertical2;
        int i8;
        Arrangement.Horizontal horizontal2;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier modifier2;
        LazyGridState lazyGridStateRememberLazyGridState;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        boolean z4;
        Arrangement.Vertical bottom;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior2;
        boolean z5;
        LazyGridState lazyGridState3;
        boolean z6;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical3;
        Arrangement.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        Arrangement arrangement;
        Modifier modifier3;
        Arrangement.Horizontal horizontal4;
        PaddingValues paddingValues4;
        LazyGridState lazyGridState4;
        boolean z7;
        Arrangement.Vertical vertical4;
        FlingBehavior flingBehavior4;
        boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(gridCells, "columns");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1485410512);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    lazyGridState2 = lazyGridState;
                    int i14 = composerStartRestartGroup.changed(lazyGridState2) ? 256 : 128;
                    i3 |= i14;
                } else {
                    lazyGridState2 = lazyGridState;
                }
                i3 |= i14;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            vertical2 = vertical;
                            int i15 = composerStartRestartGroup.changed(vertical2) ? 131072 : 65536;
                            i3 |= i15;
                        } else {
                            vertical2 = vertical;
                        }
                        i3 |= i15;
                    } else {
                        vertical2 = vertical;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        horizontal2 = horizontal;
                    } else {
                        horizontal2 = horizontal;
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(horizontal2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        if ((i & 1879048192) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                                i12 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i12 = 268435456;
                            }
                        }
                        if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if ((i2 & 4) != 0) {
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyGridStateRememberLazyGridState = lazyGridState2;
                                }
                                if (i4 != 0) {
                                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                                } else {
                                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                                }
                                z4 = i6 == 0 ? z3 : false;
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getBottom();
                                    } else {
                                        bottom = arrangement.getTop();
                                    }
                                    i3 &= -458753;
                                } else {
                                    bottom = vertical2;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                } else {
                                    start = horizontal2;
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i10 != 0) {
                                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                                    z6 = z4;
                                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                    vertical3 = bottom;
                                    horizontal3 = start;
                                    flingBehavior3 = flingBehavior2;
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                                    z6 = z4;
                                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                    vertical3 = bottom;
                                    horizontal3 = start;
                                    flingBehavior3 = flingBehavior2;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                modifier2 = modifier;
                                flingBehavior3 = flingBehavior;
                                z5 = z2;
                                lazyGridState3 = lazyGridState2;
                                z6 = z3;
                                vertical3 = vertical2;
                                paddingValues3 = paddingValues2;
                                horizontal3 = horizontal2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                            }
                            int i16 = i3 >> 3;
                            InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i16 & 896));
                            int i17 = (i16 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i16 & 112) | (i3 & 7168) | (57344 & i3) | (i16 & 3670016) | (i16 & 29360128);
                            int i18 = i3 << 9;
                            Arrangement.Horizontal horizontal5 = horizontal3;
                            PaddingValues paddingValues5 = paddingValues3;
                            LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i17 | (i18 & 234881024) | (i18 & 1879048192), (i3 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            horizontal4 = horizontal5;
                            paddingValues4 = paddingValues5;
                            lazyGridState4 = lazyGridState3;
                            z7 = z6;
                            vertical4 = vertical3;
                            flingBehavior4 = flingBehavior3;
                            z8 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z8 = z2;
                            lazyGridState4 = lazyGridState2;
                            paddingValues4 = paddingValues2;
                            horizontal4 = horizontal2;
                            z7 = z3;
                            vertical4 = vertical2;
                            flingBehavior4 = flingBehavior;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                    }
                    i12 = 805306368;
                    i3 |= i12;
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i19 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums2 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i19 & 896));
                        int i110 = (i19 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i19 & 112) | (i3 & 7168) | (57344 & i3) | (i19 & 3670016) | (i19 & 29360128);
                        int i111 = i3 << 9;
                        Arrangement.Horizontal horizontal6 = horizontal3;
                        PaddingValues paddingValues6 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums2, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i110 | (i111 & 234881024) | (i111 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal6;
                        paddingValues4 = paddingValues6;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i112 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums3 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i112 & 896));
                        int i113 = (i112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i112 & 112) | (i3 & 7168) | (57344 & i3) | (i112 & 3670016) | (i112 & 29360128);
                        int i114 = i3 << 9;
                        Arrangement.Horizontal horizontal7 = horizontal3;
                        PaddingValues paddingValues7 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums3, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i113 | (i114 & 234881024) | (i114 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal7;
                        paddingValues4 = paddingValues7;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i3 |= 24576;
                z3 = z;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i15;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i15;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i115 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums4 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i115 & 896));
                        int i116 = (i115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i115 & 112) | (i3 & 7168) | (57344 & i3) | (i115 & 3670016) | (i115 & 29360128);
                        int i117 = i3 << 9;
                        Arrangement.Horizontal horizontal8 = horizontal3;
                        PaddingValues paddingValues8 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums4, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i116 | (i117 & 234881024) | (i117 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal8;
                        paddingValues4 = paddingValues8;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i118 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums5 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i118 & 896));
                        int i119 = (i118 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i118 & 112) | (i3 & 7168) | (57344 & i3) | (i118 & 3670016) | (i118 & 29360128);
                        int i1110 = i3 << 9;
                        Arrangement.Horizontal horizontal9 = horizontal3;
                        PaddingValues paddingValues9 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums5, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i119 | (i1110 & 234881024) | (i1110 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal9;
                        paddingValues4 = paddingValues9;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i12 = 805306368;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i1111 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums6 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111 & 896));
                    int i1112 = (i1111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111 & 112) | (i3 & 7168) | (57344 & i3) | (i1111 & 3670016) | (i1111 & 29360128);
                    int i1113 = i3 << 9;
                    Arrangement.Horizontal horizontal10 = horizontal3;
                    PaddingValues paddingValues10 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums6, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1112 | (i1113 & 234881024) | (i1113 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal10;
                    paddingValues4 = paddingValues10;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i1114 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums7 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1114 & 896));
                    int i1115 = (i1114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1114 & 112) | (i3 & 7168) | (57344 & i3) | (i1114 & 3670016) | (i1114 & 29360128);
                    int i1116 = i3 << 9;
                    Arrangement.Horizontal horizontal11 = horizontal3;
                    PaddingValues paddingValues11 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums7, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1115 | (i1116 & 234881024) | (i1116 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal11;
                    paddingValues4 = paddingValues11;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i15;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i15;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i1117 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums8 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1117 & 896));
                        int i1118 = (i1117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1117 & 112) | (i3 & 7168) | (57344 & i3) | (i1117 & 3670016) | (i1117 & 29360128);
                        int i1119 = i3 << 9;
                        Arrangement.Horizontal horizontal12 = horizontal3;
                        PaddingValues paddingValues12 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums8, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1118 | (i1119 & 234881024) | (i1119 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal12;
                        paddingValues4 = paddingValues12;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i11110 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums9 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11110 & 896));
                        int i11111 = (i11110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11110 & 112) | (i3 & 7168) | (57344 & i3) | (i11110 & 3670016) | (i11110 & 29360128);
                        int i11112 = i3 << 9;
                        Arrangement.Horizontal horizontal13 = horizontal3;
                        PaddingValues paddingValues13 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums9, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11111 | (i11112 & 234881024) | (i11112 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal13;
                        paddingValues4 = paddingValues13;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i12 = 805306368;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i11113 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums10 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11113 & 896));
                    int i11114 = (i11113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11113 & 112) | (i3 & 7168) | (57344 & i3) | (i11113 & 3670016) | (i11113 & 29360128);
                    int i11115 = i3 << 9;
                    Arrangement.Horizontal horizontal14 = horizontal3;
                    PaddingValues paddingValues14 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums10, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11114 | (i11115 & 234881024) | (i11115 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal14;
                    paddingValues4 = paddingValues14;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i11116 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums11 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11116 & 896));
                    int i11117 = (i11116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11116 & 112) | (i3 & 7168) | (57344 & i3) | (i11116 & 3670016) | (i11116 & 29360128);
                    int i11118 = i3 << 9;
                    Arrangement.Horizontal horizontal15 = horizontal3;
                    PaddingValues paddingValues15 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums11, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11117 | (i11118 & 234881024) | (i11118 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal15;
                    paddingValues4 = paddingValues15;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i15;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i15;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i11119 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums12 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11119 & 896));
                    int i111110 = (i11119 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11119 & 112) | (i3 & 7168) | (57344 & i3) | (i11119 & 3670016) | (i11119 & 29360128);
                    int i111111 = i3 << 9;
                    Arrangement.Horizontal horizontal16 = horizontal3;
                    PaddingValues paddingValues16 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums12, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111110 | (i111111 & 234881024) | (i111111 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal16;
                    paddingValues4 = paddingValues16;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i111112 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums13 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111112 & 896));
                    int i111113 = (i111112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111112 & 112) | (i3 & 7168) | (57344 & i3) | (i111112 & 3670016) | (i111112 & 29360128);
                    int i111114 = i3 << 9;
                    Arrangement.Horizontal horizontal17 = horizontal3;
                    PaddingValues paddingValues17 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums13, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111113 | (i111114 & 234881024) | (i111114 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal17;
                    paddingValues4 = paddingValues17;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i111115 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums14 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111115 & 896));
                int i111116 = (i111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111115 & 112) | (i3 & 7168) | (57344 & i3) | (i111115 & 3670016) | (i111115 & 29360128);
                int i111117 = i3 << 9;
                Arrangement.Horizontal horizontal18 = horizontal3;
                PaddingValues paddingValues18 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums14, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111116 | (i111117 & 234881024) | (i111117 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal18;
                paddingValues4 = paddingValues18;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i111118 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums15 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111118 & 896));
                int i111119 = (i111118 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111118 & 112) | (i3 & 7168) | (57344 & i3) | (i111118 & 3670016) | (i111118 & 29360128);
                int i1111110 = i3 << 9;
                Arrangement.Horizontal horizontal19 = horizontal3;
                PaddingValues paddingValues19 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums15, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111119 | (i1111110 & 234881024) | (i1111110 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal19;
                paddingValues4 = paddingValues19;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 48;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                lazyGridState2 = lazyGridState;
                if (composerStartRestartGroup.changed(lazyGridState2)) {
                }
                i3 |= i14;
            } else {
                lazyGridState2 = lazyGridState;
            }
            i3 |= i14;
        } else {
            lazyGridState2 = lazyGridState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i15;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i15;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i1111111 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums16 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111 & 896));
                        int i1111112 = (i1111111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111 & 3670016) | (i1111111 & 29360128);
                        int i1111113 = i3 << 9;
                        Arrangement.Horizontal horizontal110 = horizontal3;
                        PaddingValues paddingValues110 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums16, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1111112 | (i1111113 & 234881024) | (i1111113 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal110;
                        paddingValues4 = paddingValues110;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState2;
                            }
                            if (i4 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                lazyGridState3 = lazyGridStateRememberLazyGridState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                        }
                        int i1111114 = i3 >> 3;
                        InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums17 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111114 & 896));
                        int i1111115 = (i1111114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111114 & 112) | (i3 & 7168) | (57344 & i3) | (i1111114 & 3670016) | (i1111114 & 29360128);
                        int i1111116 = i3 << 9;
                        Arrangement.Horizontal horizontal111 = horizontal3;
                        PaddingValues paddingValues111 = paddingValues3;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums17, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1111115 | (i1111116 & 234881024) | (i1111116 & 1879048192), (i3 >> 27) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        horizontal4 = horizontal111;
                        paddingValues4 = paddingValues111;
                        lazyGridState4 = lazyGridState3;
                        z7 = z6;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i12 = 805306368;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i1111117 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums18 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111117 & 896));
                    int i1111118 = (i1111117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111117 & 112) | (i3 & 7168) | (57344 & i3) | (i1111117 & 3670016) | (i1111117 & 29360128);
                    int i1111119 = i3 << 9;
                    Arrangement.Horizontal horizontal112 = horizontal3;
                    PaddingValues paddingValues112 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums18, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1111118 | (i1111119 & 234881024) | (i1111119 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal112;
                    paddingValues4 = paddingValues112;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i11111110 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums19 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111110 & 896));
                    int i11111111 = (i11111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111110 & 112) | (i3 & 7168) | (57344 & i3) | (i11111110 & 3670016) | (i11111110 & 29360128);
                    int i11111112 = i3 << 9;
                    Arrangement.Horizontal horizontal113 = horizontal3;
                    PaddingValues paddingValues113 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums19, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11111111 | (i11111112 & 234881024) | (i11111112 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal113;
                    paddingValues4 = paddingValues113;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i15;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i15;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i11111113 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums110 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111113 & 896));
                    int i11111114 = (i11111113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111113 & 112) | (i3 & 7168) | (57344 & i3) | (i11111113 & 3670016) | (i11111113 & 29360128);
                    int i11111115 = i3 << 9;
                    Arrangement.Horizontal horizontal114 = horizontal3;
                    PaddingValues paddingValues114 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums110, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11111114 | (i11111115 & 234881024) | (i11111115 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal114;
                    paddingValues4 = paddingValues114;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i11111116 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums111 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111116 & 896));
                    int i11111117 = (i11111116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111116 & 112) | (i3 & 7168) | (57344 & i3) | (i11111116 & 3670016) | (i11111116 & 29360128);
                    int i11111118 = i3 << 9;
                    Arrangement.Horizontal horizontal115 = horizontal3;
                    PaddingValues paddingValues115 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums111, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11111117 | (i11111118 & 234881024) | (i11111118 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal115;
                    paddingValues4 = paddingValues115;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i11111119 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums112 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111119 & 896));
                int i111111110 = (i11111119 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111119 & 112) | (i3 & 7168) | (57344 & i3) | (i11111119 & 3670016) | (i11111119 & 29360128);
                int i111111111 = i3 << 9;
                Arrangement.Horizontal horizontal116 = horizontal3;
                PaddingValues paddingValues116 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums112, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111111110 | (i111111111 & 234881024) | (i111111111 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal116;
                paddingValues4 = paddingValues116;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i111111112 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums113 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111112 & 896));
                int i111111113 = (i111111112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111112 & 112) | (i3 & 7168) | (57344 & i3) | (i111111112 & 3670016) | (i111111112 & 29360128);
                int i111111114 = i3 << 9;
                Arrangement.Horizontal horizontal117 = horizontal3;
                PaddingValues paddingValues117 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums113, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111111113 | (i111111114 & 234881024) | (i111111114 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal117;
                paddingValues4 = paddingValues117;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i15;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i15;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i111111115 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums114 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111115 & 896));
                    int i111111116 = (i111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i111111115 & 3670016) | (i111111115 & 29360128);
                    int i111111117 = i3 << 9;
                    Arrangement.Horizontal horizontal118 = horizontal3;
                    PaddingValues paddingValues118 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums114, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111111116 | (i111111117 & 234881024) | (i111111117 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal118;
                    paddingValues4 = paddingValues118;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState2;
                        }
                        if (i4 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            lazyGridState3 = lazyGridStateRememberLazyGridState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                    }
                    int i111111118 = i3 >> 3;
                    InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums115 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111118 & 896));
                    int i111111119 = (i111111118 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111118 & 112) | (i3 & 7168) | (57344 & i3) | (i111111118 & 3670016) | (i111111118 & 29360128);
                    int i1111111110 = i3 << 9;
                    Arrangement.Horizontal horizontal119 = horizontal3;
                    PaddingValues paddingValues119 = paddingValues3;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums115, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i111111119 | (i1111111110 & 234881024) | (i1111111110 & 1879048192), (i3 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    horizontal4 = horizontal119;
                    paddingValues4 = paddingValues119;
                    lazyGridState4 = lazyGridState3;
                    z7 = z6;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i12 = 805306368;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i1111111111 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums116 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111 & 896));
                int i1111111112 = (i1111111111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111111 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111111 & 3670016) | (i1111111111 & 29360128);
                int i1111111113 = i3 << 9;
                Arrangement.Horizontal horizontal1110 = horizontal3;
                PaddingValues paddingValues1110 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums116, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1111111112 | (i1111111113 & 234881024) | (i1111111113 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal1110;
                paddingValues4 = paddingValues1110;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i1111111114 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums117 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111114 & 896));
                int i1111111115 = (i1111111114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111114 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111114 & 3670016) | (i1111111114 & 29360128);
                int i1111111116 = i3 << 9;
                Arrangement.Horizontal horizontal1111 = horizontal3;
                PaddingValues paddingValues1111 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums117, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1111111115 | (i1111111116 & 234881024) | (i1111111116 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal1111;
                paddingValues4 = paddingValues1111;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 24576;
        z3 = z;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i3 |= i15;
            } else {
                vertical2 = vertical;
            }
            i3 |= i15;
        } else {
            vertical2 = vertical;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            horizontal2 = horizontal;
        } else {
            horizontal2 = horizontal;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i2 & 512) != 0) {
            if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i1111111117 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums118 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111117 & 896));
                int i1111111118 = (i1111111117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111117 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111117 & 3670016) | (i1111111117 & 29360128);
                int i1111111119 = i3 << 9;
                Arrangement.Horizontal horizontal1112 = horizontal3;
                PaddingValues paddingValues1112 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums118, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i1111111118 | (i1111111119 & 234881024) | (i1111111119 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal1112;
                paddingValues4 = paddingValues1112;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState2;
                    }
                    if (i4 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        lazyGridState3 = lazyGridStateRememberLazyGridState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
                }
                int i11111111110 = i3 >> 3;
                InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums119 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111110 & 896));
                int i11111111111 = (i11111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111110 & 3670016) | (i11111111110 & 29360128);
                int i11111111112 = i3 << 9;
                Arrangement.Horizontal horizontal1113 = horizontal3;
                PaddingValues paddingValues1113 = paddingValues3;
                LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums119, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11111111111 | (i11111111112 & 234881024) | (i11111111112 & 1879048192), (i3 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                horizontal4 = horizontal1113;
                paddingValues4 = paddingValues1113;
                lazyGridState4 = lazyGridState3;
                z7 = z6;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i12 = 805306368;
        i3 |= i12;
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
            }
            int i11111111113 = i3 >> 3;
            InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums1110 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111113 & 896));
            int i11111111114 = (i11111111113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111113 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111113 & 3670016) | (i11111111113 & 29360128);
            int i11111111115 = i3 << 9;
            Arrangement.Horizontal horizontal1114 = horizontal3;
            PaddingValues paddingValues1114 = paddingValues3;
            LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums1110, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11111111114 | (i11111111115 & 234881024) | (i11111111115 & 1879048192), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            horizontal4 = horizontal1114;
            paddingValues4 = paddingValues1114;
            lazyGridState4 = lazyGridState3;
            z7 = z6;
            vertical4 = vertical3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState2;
                }
                if (i4 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    lazyGridState3 = lazyGridStateRememberLazyGridState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1485410512, i3, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:61)");
            }
            int i11111111116 = i3 >> 3;
            InterfaceC0526Fp interfaceC0526FpRememberColumnWidthSums1111 = rememberColumnWidthSums(gridCells, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111116 & 896));
            int i11111111117 = (i11111111116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111116 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111116 & 3670016) | (i11111111116 & 29360128);
            int i11111111118 = i3 << 9;
            Arrangement.Horizontal horizontal1115 = horizontal3;
            PaddingValues paddingValues1115 = paddingValues3;
            LazyGridKt.LazyGrid(modifier2, lazyGridState3, interfaceC0526FpRememberColumnWidthSums1111, paddingValues3, z6, true, flingBehavior3, z5, vertical3, horizontal3, interfaceC3750qp, composerStartRestartGroup, i11111111117 | (i11111111118 & 234881024) | (i11111111118 & 1879048192), (i3 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            horizontal4 = horizontal1115;
            paddingValues4 = paddingValues1115;
            lazyGridState4 = lazyGridState3;
            z7 = z6;
            vertical4 = vertical3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13671(gridCells, modifier3, lazyGridState4, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyGridScope.items(list.size(), interfaceC3750qp != null ? new AnonymousClass2(interfaceC3750qp, list) : null, interfaceC0526Fp != null ? new AnonymousClass3(interfaceC0526Fp, list) : null, new AnonymousClass4(interfaceC3750qp2, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new AnonymousClass5(interfaceC0578Hp, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp2 = C13681.INSTANCE;
        }
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyGridScope.items(list.size(), interfaceC3750qp != null ? new AnonymousClass2(interfaceC3750qp, list) : null, interfaceC0526Fp != null ? new AnonymousClass3(interfaceC0526Fp, list) : null, new AnonymousClass4(interfaceC3750qp2, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new AnonymousClass5(interfaceC0578Hp, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyGridScope.items(list.size(), interfaceC0526Fp != null ? new C13712(interfaceC0526Fp, list) : null, interfaceC0552Gp != null ? new C13723(interfaceC0552Gp, list) : null, new C13734(interfaceC0526Fp2, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C13745(interfaceC0604Ip, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0552Gp = null;
        }
        if ((i & 8) != 0) {
            interfaceC0526Fp2 = C13691.INSTANCE;
        }
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyGridScope.items(list.size(), interfaceC0526Fp != null ? new C13712(interfaceC0526Fp, list) : null, interfaceC0552Gp != null ? new C13723(interfaceC0552Gp, list) : null, new C13734(interfaceC0526Fp2, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C13745(interfaceC0604Ip, list)));
    }

    @Composable
    private static final InterfaceC0526Fp rememberColumnWidthSums(GridCells gridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1355301804);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355301804, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:144)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(gridCells) | composer.changed(horizontal) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new GridSlotCache(new LazyGridDslKt$rememberColumnWidthSums$1$1(paddingValues, gridCells, horizontal));
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
    private static final InterfaceC0526Fp rememberRowHeightSums(GridCells gridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(239683573);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239683573, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:177)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(gridCells) | composer.changed(vertical) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new GridSlotCache(new LazyGridDslKt$rememberRowHeightSums$1$1(paddingValues, gridCells, vertical));
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
    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyGridScope.items(tArr.length, interfaceC3750qp != null ? new AnonymousClass7(interfaceC3750qp, tArr) : null, interfaceC0526Fp != null ? new AnonymousClass8(interfaceC0526Fp, tArr) : null, new AnonymousClass9(interfaceC3750qp2, tArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new AnonymousClass10(interfaceC0578Hp, tArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyGridScope.items(tArr.length, interfaceC0526Fp != null ? new C13767(interfaceC0526Fp, tArr) : null, interfaceC0552Gp != null ? new C13778(interfaceC0552Gp, tArr) : null, new C13789(interfaceC0526Fp2, tArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C137010(interfaceC0604Ip, tArr)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp2 = AnonymousClass6.INSTANCE;
        }
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyGridScope.items(objArr.length, interfaceC3750qp != null ? new AnonymousClass7(interfaceC3750qp, objArr) : null, interfaceC0526Fp != null ? new AnonymousClass8(interfaceC0526Fp, objArr) : null, new AnonymousClass9(interfaceC3750qp2, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new AnonymousClass10(interfaceC0578Hp, objArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0552Gp = null;
        }
        if ((i & 8) != 0) {
            interfaceC0526Fp2 = C13756.INSTANCE;
        }
        AbstractC4492zt.h(lazyGridScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyGridScope.items(objArr.length, interfaceC0526Fp != null ? new C13767(interfaceC0526Fp, objArr) : null, interfaceC0552Gp != null ? new C13778(interfaceC0552Gp, objArr) : null, new C13789(interfaceC0526Fp2, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C137010(interfaceC0604Ip, objArr)));
    }
}
