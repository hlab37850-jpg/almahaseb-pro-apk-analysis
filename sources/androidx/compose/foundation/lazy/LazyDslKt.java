package androidx.compose.foundation.lazy;

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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LazyDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$verticalArrangement = vertical;
            this.$horizontalAlignment = horizontal;
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
            LazyDslKt.LazyColumn(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$verticalArrangement, this.$horizontalAlignment, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, InterfaceC3750qp interfaceC3750qp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$verticalArrangement = vertical;
            this.$horizontalAlignment = horizontal;
            this.$flingBehavior = flingBehavior;
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
            LazyDslKt.LazyColumn(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$verticalArrangement, this.$horizontalAlignment, this.$flingBehavior, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13541 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Alignment.Vertical $verticalAlignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13541(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$horizontalArrangement = horizontal;
            this.$verticalAlignment = vertical;
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
            LazyDslKt.LazyRow(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$horizontalArrangement, this.$verticalAlignment, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13552 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC3750qp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ Alignment.Vertical $verticalAlignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13552(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, InterfaceC3750qp interfaceC3750qp, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z;
            this.$horizontalArrangement = horizontal;
            this.$verticalAlignment = vertical;
            this.$flingBehavior = flingBehavior;
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
            LazyDslKt.LazyRow(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$horizontalArrangement, this.$verticalAlignment, this.$flingBehavior, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13561 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13561 INSTANCE = new C13561();

        public C13561() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13572 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ InterfaceC3750qp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13572(InterfaceC3750qp interfaceC3750qp, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$3, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0578Hp $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(InterfaceC0578Hp interfaceC0578Hp, List<? extends T> list) {
            super(4);
            this.$itemContent = interfaceC0578Hp;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:144)");
            }
            this.$itemContent.invoke(lazyItemScope, this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ T[] $items;
        final /* synthetic */ InterfaceC3750qp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(InterfaceC3750qp interfaceC3750qp, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(InterfaceC3750qp interfaceC3750qp, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$8, reason: invalid class name */
    public static final class AnonymousClass8 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0578Hp $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(InterfaceC0578Hp interfaceC0578Hp, T[] tArr) {
            super(4);
            this.$itemContent = interfaceC0578Hp;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(-1043393750, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:214)");
            }
            this.$itemContent.invoke(lazyItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13581 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C13581 INSTANCE = new C13581();

        public C13581() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13592 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ InterfaceC0526Fp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13592(InterfaceC0526Fp interfaceC0526Fp, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13603 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13603(InterfaceC0526Fp interfaceC0526Fp, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    public static final class C13614 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0604Ip $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C13614(InterfaceC0604Ip interfaceC0604Ip, List<? extends T> list) {
            super(4);
            this.$itemContent = interfaceC0604Ip;
            this.$items = list;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:179)");
            }
            this.$itemContent.invoke(lazyItemScope, Integer.valueOf(i), this.$items.get(i), composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    public static final class C13625 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C13625 INSTANCE = new C13625();

        public C13625() {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$6, reason: invalid class name and case insensitive filesystem */
    public static final class C13636 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ T[] $items;
        final /* synthetic */ InterfaceC0526Fp $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13636(InterfaceC0526Fp interfaceC0526Fp, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    public static final class C13647 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13647(InterfaceC0526Fp interfaceC0526Fp, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    public static final class C13658 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ InterfaceC0604Ip $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13658(InterfaceC0604Ip interfaceC0604Ip, T[] tArr) {
            super(4);
            this.$itemContent = interfaceC0604Ip;
            this.$items = tArr;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
            int i3;
            AbstractC4492zt.h(lazyItemScope, "$this$items");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                ComposerKt.traceEventStart(1600639390, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:249)");
            }
            this.$itemContent.invoke(lazyItemScope, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i3 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:105:0x0146  */
    /* JADX WARN: Code duplicated, block: B:118:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0175  */
    /* JADX WARN: Code duplicated, block: B:120:0x0178  */
    /* JADX WARN: Code duplicated, block: B:123:0x017f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0187  */
    /* JADX WARN: Code duplicated, block: B:126:0x018b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0195  */
    /* JADX WARN: Code duplicated, block: B:130:0x0199  */
    /* JADX WARN: Code duplicated, block: B:133:0x019e  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:147:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:148:0x01df  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:154:0x024c  */
    /* JADX WARN: Code duplicated, block: B:159:0x0266  */
    /* JADX WARN: Code duplicated, block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x0102  */
    /* JADX WARN: Code duplicated, block: B:91:0x0106  */
    /* JADX WARN: Code duplicated, block: B:93:0x010a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0110  */
    /* JADX WARN: Code duplicated, block: B:96:0x0113  */
    /* JADX WARN: Code duplicated, block: B:99:0x011f  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        PaddingValues paddingValues2;
        int i4;
        boolean z3;
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        Alignment.Horizontal horizontal2;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier modifier2;
        LazyListState lazyListStateRememberLazyListState;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        boolean z4;
        Arrangement.Vertical bottom;
        Alignment.Horizontal start;
        FlingBehavior flingBehavior2;
        boolean z5;
        Modifier modifier3;
        LazyListState lazyListState2;
        boolean z6;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical3;
        Alignment.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        Arrangement arrangement;
        Composer composer2;
        Modifier modifier4;
        LazyListState lazyListState3;
        PaddingValues paddingValues4;
        boolean z7;
        Arrangement.Vertical vertical4;
        Alignment.Horizontal horizontal4;
        FlingBehavior flingBehavior4;
        boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-740714857);
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(lazyListState)) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
            if ((i & 896) == 0) {
                paddingValues2 = paddingValues;
                i3 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        vertical2 = vertical;
                        int i14 = composerStartRestartGroup.changed(vertical2) ? 16384 : 8192;
                        i3 |= i14;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior)) {
                        i11 = 524288;
                    } else {
                        i11 = 1048576;
                    }
                    i3 |= i11;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            z4 = i4 == 0 ? z3 : false;
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getBottom();
                                } else {
                                    bottom = arrangement.getTop();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.Companion.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i8 != 0) {
                                modifier3 = modifier2;
                                lazyListState2 = lazyListStateRememberLazyListState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                modifier3 = modifier2;
                                lazyListState2 = lazyListStateRememberLazyListState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            modifier3 = modifier;
                            lazyListState2 = lazyListState;
                            flingBehavior3 = flingBehavior;
                            z5 = z2;
                            paddingValues3 = paddingValues2;
                            z6 = z3;
                            vertical3 = vertical2;
                            horizontal3 = horizontal2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                        }
                        int i15 = i3 >> 3;
                        composer2 = composerStartRestartGroup;
                        LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i15) | (i15 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        lazyListState3 = lazyListState2;
                        paddingValues4 = paddingValues3;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        lazyListState3 = lazyListState;
                        flingBehavior4 = flingBehavior;
                        paddingValues4 = paddingValues2;
                        composer2 = composerStartRestartGroup;
                        z7 = z3;
                        vertical4 = vertical2;
                        horizontal4 = horizontal2;
                        z8 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                    }
                    int i16 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i16) | (i16 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                    }
                    int i17 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i17) | (i17 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            z3 = z;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i14;
            } else {
                vertical2 = vertical;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                    }
                    int i18 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i18) | (i18 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                    }
                    int i19 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i19) | (i19 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                }
                int i110 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i110) | (i110 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                }
                int i111 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i111) | (i111 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 384;
        paddingValues2 = paddingValues;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i14;
            } else {
                vertical2 = vertical;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                    }
                    int i112 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i112) | (i112 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                    }
                    int i113 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i113) | (i113 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                }
                int i114 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i114) | (i114 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                }
                int i115 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i115) | (i115 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        z3 = z;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i3 |= i14;
            } else {
                vertical2 = vertical;
            }
            i3 |= i14;
        } else {
            vertical2 = vertical;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            horizontal2 = horizontal;
        } else {
            horizontal2 = horizontal;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i2 & 256) != 0) {
            if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                }
                int i116 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i116) | (i116 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
                }
                int i117 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i117) | (i117 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i10 = 100663296;
        i3 |= i10;
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
            }
            int i118 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i118) | (i118 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues4 = paddingValues3;
            z7 = z6;
            vertical4 = vertical3;
            horizontal4 = horizontal3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740714857, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)");
            }
            int i119 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, true, flingBehavior3, z5, 0, horizontal3, vertical3, null, null, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i119) | (i119 & 3670016) | ((i3 << 9) & 234881024) | ((i3 << 15) & 1879048192), (i3 >> 18) & 896, 3200);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues4 = paddingValues3;
            z7 = z6;
            vertical4 = vertical3;
            horizontal4 = horizontal3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(modifier4, lazyListState3, paddingValues4, z7, vertical4, horizontal4, flingBehavior4, z8, interfaceC3750qp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0138  */
    /* JADX WARN: Code duplicated, block: B:105:0x0145  */
    /* JADX WARN: Code duplicated, block: B:118:0x0172 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0174  */
    /* JADX WARN: Code duplicated, block: B:120:0x0177  */
    /* JADX WARN: Code duplicated, block: B:123:0x017e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0186  */
    /* JADX WARN: Code duplicated, block: B:126:0x018a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0194  */
    /* JADX WARN: Code duplicated, block: B:130:0x0198  */
    /* JADX WARN: Code duplicated, block: B:133:0x019d  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:148:0x01de  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:154:0x024b  */
    /* JADX WARN: Code duplicated, block: B:159:0x0265  */
    /* JADX WARN: Code duplicated, block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:91:0x0104  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:95:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0112  */
    /* JADX WARN: Code duplicated, block: B:99:0x011e  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        PaddingValues paddingValues2;
        int i4;
        boolean z3;
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        Alignment.Vertical vertical2;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier modifier2;
        LazyListState lazyListStateRememberLazyListState;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        boolean z4;
        Arrangement.Horizontal end;
        Alignment.Vertical top;
        FlingBehavior flingBehavior2;
        boolean z5;
        Modifier modifier3;
        LazyListState lazyListState2;
        boolean z6;
        PaddingValues paddingValues3;
        Arrangement.Horizontal horizontal3;
        Alignment.Vertical vertical3;
        FlingBehavior flingBehavior3;
        Arrangement arrangement;
        Composer composer2;
        Modifier modifier4;
        LazyListState lazyListState3;
        PaddingValues paddingValues4;
        boolean z7;
        Arrangement.Horizontal horizontal4;
        Alignment.Vertical vertical4;
        FlingBehavior flingBehavior4;
        boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1724297413);
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(lazyListState)) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
            if ((i & 896) == 0) {
                paddingValues2 = paddingValues;
                i3 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        horizontal2 = horizontal;
                        int i14 = composerStartRestartGroup.changed(horizontal2) ? 16384 : 8192;
                        i3 |= i14;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    vertical2 = vertical;
                } else {
                    vertical2 = vertical;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior)) {
                        i11 = 524288;
                    } else {
                        i11 = 1048576;
                    }
                    i3 |= i11;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                            } else {
                                paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                            }
                            z4 = i4 == 0 ? z3 : false;
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getEnd();
                                } else {
                                    end = arrangement.getStart();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.Companion.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i8 != 0) {
                                modifier3 = modifier2;
                                lazyListState2 = lazyListStateRememberLazyListState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                                z5 = true;
                            } else {
                                z5 = z2;
                                modifier3 = modifier2;
                                lazyListState2 = lazyListStateRememberLazyListState;
                                z6 = z4;
                                paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            modifier3 = modifier;
                            lazyListState2 = lazyListState;
                            flingBehavior3 = flingBehavior;
                            z5 = z2;
                            paddingValues3 = paddingValues2;
                            z6 = z3;
                            horizontal3 = horizontal2;
                            vertical3 = vertical2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                        }
                        int i15 = i3 >> 3;
                        composer2 = composerStartRestartGroup;
                        LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i15) | (i15 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        lazyListState3 = lazyListState2;
                        paddingValues4 = paddingValues3;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior4 = flingBehavior3;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        lazyListState3 = lazyListState;
                        flingBehavior4 = flingBehavior;
                        paddingValues4 = paddingValues2;
                        z7 = z3;
                        horizontal4 = horizontal2;
                        composer2 = composerStartRestartGroup;
                        vertical4 = vertical2;
                        z8 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                    }
                    int i16 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i16) | (i16 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                    }
                    int i17 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i17) | (i17 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            z3 = z;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i14;
            } else {
                horizontal2 = horizontal;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                    }
                    int i18 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i18) | (i18 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                    }
                    int i19 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i19) | (i19 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                }
                int i110 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i110) | (i110 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                }
                int i111 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i111) | (i111 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 384;
        paddingValues2 = paddingValues;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i14;
            } else {
                horizontal2 = horizontal;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                    }
                    int i112 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i112) | (i112 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        } else {
                            paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                            z5 = true;
                        } else {
                            z5 = z2;
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                            z6 = z4;
                            paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                    }
                    int i113 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i113) | (i113 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues4 = paddingValues3;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                }
                int i114 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i114) | (i114 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                }
                int i115 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i115) | (i115 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        z3 = z;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                }
                i3 |= i14;
            } else {
                horizontal2 = horizontal;
            }
            i3 |= i14;
        } else {
            horizontal2 = horizontal;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            vertical2 = vertical;
        } else {
            vertical2 = vertical;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i2 & 256) != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                }
                int i116 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i116) | (i116 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    } else {
                        paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i8 != 0) {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                        z5 = true;
                    } else {
                        z5 = z2;
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        z6 = z4;
                        paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
                }
                int i117 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i117) | (i117 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues4 = paddingValues3;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
        }
        i10 = 100663296;
        i3 |= i10;
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
            }
            int i118 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i118) | (i118 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues4 = paddingValues3;
            z7 = z6;
            horizontal4 = horizontal3;
            vertical4 = vertical3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                } else {
                    paddingValuesM478PaddingValues0680j_4 = paddingValues2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i8 != 0) {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                    z5 = true;
                } else {
                    z5 = z2;
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    z6 = z4;
                    paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1724297413, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:289)");
            }
            int i119 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            LazyListKt.LazyList(modifier3, lazyListState2, paddingValues3, z6, false, flingBehavior3, z5, 0, null, null, vertical3, horizontal3, interfaceC3750qp, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i119) | (i119 & 3670016), ((i3 >> 15) & 14) | ((i3 >> 9) & 112) | ((i3 >> 18) & 896), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues4 = paddingValues3;
            z7 = z6;
            horizontal4 = horizontal3;
            vertical4 = vertical3;
            flingBehavior4 = flingBehavior3;
            z8 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13541(modifier4, lazyListState3, paddingValues4, z7, horizontal4, vertical4, flingBehavior4, z8, interfaceC3750qp, i, i2));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(LazyListScope lazyListScope, List<? extends T> list, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(list.size(), interfaceC3750qp != null ? new C13572(interfaceC3750qp, list) : null, new AnonymousClass3(interfaceC3750qp2, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(interfaceC0578Hp, list)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 4) != 0) {
            interfaceC3750qp2 = C13561.INSTANCE;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(list.size(), interfaceC3750qp != null ? new C13572(interfaceC3750qp, list) : null, new AnonymousClass3(interfaceC3750qp2, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(interfaceC0578Hp, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(list.size(), interfaceC0526Fp != null ? new C13592(interfaceC0526Fp, list) : null, new C13603(interfaceC0526Fp2, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C13614(interfaceC0604Ip, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0526Fp2 = C13581.INSTANCE;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(list.size(), interfaceC0526Fp != null ? new C13592(interfaceC0526Fp, list) : null, new C13603(interfaceC0526Fp2, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C13614(interfaceC0604Ip, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void items(LazyListScope lazyListScope, T[] tArr, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(tArr.length, interfaceC3750qp != null ? new AnonymousClass6(interfaceC3750qp, tArr) : null, new AnonymousClass7(interfaceC3750qp2, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(interfaceC0578Hp, tArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(tArr.length, interfaceC0526Fp != null ? new C13636(interfaceC0526Fp, tArr) : null, new C13647(interfaceC0526Fp2, tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C13658(interfaceC0604Ip, tArr)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List list, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(list.size(), interfaceC3750qp != null ? new C13572(interfaceC3750qp, list) : null, new AnonymousClass3(C13561.INSTANCE, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(interfaceC0578Hp, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(list.size(), interfaceC0526Fp != null ? new C13592(interfaceC0526Fp, list) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C13614(interfaceC0604Ip, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, List<? extends T> list, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(list.size(), interfaceC3750qp != null ? new C13572(interfaceC3750qp, list) : null, new AnonymousClass3(C13561.INSTANCE, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(interfaceC0578Hp, list)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(list, "items");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(list.size(), interfaceC0526Fp != null ? new C13592(interfaceC0526Fp, list) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C13614(interfaceC0604Ip, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        if ((i & 4) != 0) {
            interfaceC0526Fp2 = C13625.INSTANCE;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC0526Fp2, "contentType");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(objArr.length, interfaceC0526Fp != null ? new C13636(interfaceC0526Fp, objArr) : null, new C13647(interfaceC0526Fp2, objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C13658(interfaceC0604Ip, objArr)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 4) != 0) {
            interfaceC3750qp2 = AnonymousClass5.INSTANCE;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC3750qp2, "contentType");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(objArr.length, interfaceC3750qp != null ? new AnonymousClass6(interfaceC3750qp, objArr) : null, new AnonymousClass7(interfaceC3750qp2, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(interfaceC0578Hp, objArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, T[] tArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(tArr.length, interfaceC0526Fp != null ? new C13636(interfaceC0526Fp, tArr) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C13658(interfaceC0604Ip, tArr)));
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, T[] tArr, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(tArr, "items");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(tArr.length, interfaceC3750qp != null ? new AnonymousClass6(interfaceC3750qp, tArr) : null, new AnonymousClass7(AnonymousClass5.INSTANCE, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(interfaceC0578Hp, tArr)));
    }

    /* JADX WARN: Code duplicated, block: B:109:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0150  */
    /* JADX WARN: Code duplicated, block: B:111:0x0153  */
    /* JADX WARN: Code duplicated, block: B:114:0x015c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0163  */
    /* JADX WARN: Code duplicated, block: B:117:0x0166  */
    /* JADX WARN: Code duplicated, block: B:119:0x0172  */
    /* JADX WARN: Code duplicated, block: B:122:0x0177  */
    /* JADX WARN: Code duplicated, block: B:124:0x017b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0180  */
    /* JADX WARN: Code duplicated, block: B:128:0x0189  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:144:0x020e  */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:93:0x0115  */
    /* JADX WARN: Code duplicated, block: B:95:0x0123  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        LazyListState lazyListState2;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        int i4;
        boolean z2;
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        Alignment.Horizontal start;
        int i7;
        int i8;
        Modifier modifier2;
        Modifier modifier3;
        LazyListState lazyListStateRememberLazyListState;
        FlingBehavior flingBehavior2;
        LazyListState lazyListState3;
        Arrangement arrangement;
        Arrangement.Vertical bottom;
        Modifier modifier4;
        LazyListState lazyListState4;
        PaddingValues paddingValues2;
        boolean z3;
        Arrangement.Vertical vertical3;
        Alignment.Horizontal horizontal2;
        FlingBehavior flingBehavior3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-563353797);
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                int i11 = composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
                i3 |= i11;
            } else {
                lazyListState2 = lazyListState;
            }
            i3 |= i11;
        } else {
            lazyListState2 = lazyListState;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 896) == 0) {
                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                i3 |= composerStartRestartGroup.changed(paddingValuesM478PaddingValues0680j_4) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        vertical2 = vertical;
                        int i13 = composerStartRestartGroup.changed(vertical2) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i13;
                } else {
                    vertical2 = vertical;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    start = horizontal;
                } else {
                    start = horizontal;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(start)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior)) {
                        i9 = 524288;
                    } else {
                        i9 = 1048576;
                    }
                    i3 |= i9;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((23967451 & i3) != 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    flingBehavior3 = flingBehavior;
                    lazyListState4 = lazyListState2;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    z3 = z2;
                    horizontal2 = start;
                    vertical3 = vertical2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        modifier3 = modifier2;
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState2;
                        }
                        if (i12 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        }
                        if (i4 != 0) {
                            z2 = false;
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z2) {
                                bottom = arrangement.getBottom();
                            } else {
                                bottom = arrangement.getTop();
                            }
                            i3 &= -57345;
                            vertical2 = bottom;
                        }
                        if (i6 != 0) {
                            start = Alignment.Companion.getStart();
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        lazyListState3 = lazyListStateRememberLazyListState;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        modifier3 = modifier;
                        flingBehavior2 = flingBehavior;
                        lazyListState3 = lazyListState2;
                    }
                    PaddingValues paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    boolean z4 = z2;
                    Alignment.Horizontal horizontal3 = start;
                    Arrangement.Vertical vertical4 = vertical2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-563353797, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
                    }
                    LazyColumn(modifier3, lazyListState3, paddingValues3, z4, vertical4, horizontal3, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState4 = lazyListState3;
                    paddingValues2 = paddingValues3;
                    z3 = z4;
                    vertical3 = vertical4;
                    horizontal2 = horizontal3;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier4, lazyListState4, paddingValues2, z3, vertical3, horizontal2, flingBehavior3, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i13;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i13;
            } else {
                vertical2 = vertical;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                start = horizontal;
            } else {
                start = horizontal;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(start)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) != 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues4 = paddingValuesM478PaddingValues0680j_4;
                boolean z5 = z2;
                Alignment.Horizontal horizontal4 = start;
                Arrangement.Vertical vertical5 = vertical2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-563353797, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
                }
                LazyColumn(modifier3, lazyListState3, paddingValues4, z5, vertical5, horizontal4, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues4;
                z3 = z5;
                vertical3 = vertical5;
                horizontal2 = horizontal4;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues5 = paddingValuesM478PaddingValues0680j_4;
                boolean z6 = z2;
                Alignment.Horizontal horizontal5 = start;
                Arrangement.Vertical vertical6 = vertical2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-563353797, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
                }
                LazyColumn(modifier3, lazyListState3, paddingValues5, z6, vertical6, horizontal5, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues5;
                z3 = z6;
                vertical3 = vertical6;
                horizontal2 = horizontal5;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier4, lazyListState4, paddingValues2, z3, vertical3, horizontal2, flingBehavior3, interfaceC3750qp, i, i2));
        }
        i3 |= 384;
        paddingValuesM478PaddingValues0680j_4 = paddingValues;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i13;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i13;
            } else {
                vertical2 = vertical;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                start = horizontal;
            } else {
                start = horizontal;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(start)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) != 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues6 = paddingValuesM478PaddingValues0680j_4;
                boolean z7 = z2;
                Alignment.Horizontal horizontal6 = start;
                Arrangement.Vertical vertical7 = vertical2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-563353797, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
                }
                LazyColumn(modifier3, lazyListState3, paddingValues6, z7, vertical7, horizontal6, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues6;
                z3 = z7;
                vertical3 = vertical7;
                horizontal2 = horizontal6;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.Companion.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues7 = paddingValuesM478PaddingValues0680j_4;
                boolean z8 = z2;
                Alignment.Horizontal horizontal7 = start;
                Arrangement.Vertical vertical8 = vertical2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-563353797, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
                }
                LazyColumn(modifier3, lazyListState3, paddingValues7, z8, vertical8, horizontal7, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues7;
                z3 = z8;
                vertical3 = vertical8;
                horizontal2 = horizontal7;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier4, lazyListState4, paddingValues2, z3, vertical3, horizontal2, flingBehavior3, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i3 |= i13;
            } else {
                vertical2 = vertical;
            }
            i3 |= i13;
        } else {
            vertical2 = vertical;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            start = horizontal;
        } else {
            start = horizontal;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(start)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i9 = 524288;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((29360128 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        }
        if ((23967451 & i3) != 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            }
            PaddingValues paddingValues8 = paddingValuesM478PaddingValues0680j_4;
            boolean z9 = z2;
            Alignment.Horizontal horizontal8 = start;
            Arrangement.Vertical vertical9 = vertical2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-563353797, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
            }
            LazyColumn(modifier3, lazyListState3, paddingValues8, z9, vertical9, horizontal8, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState4 = lazyListState3;
            paddingValues2 = paddingValues8;
            z3 = z9;
            vertical3 = vertical9;
            horizontal2 = horizontal8;
            flingBehavior3 = flingBehavior2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.Companion.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            }
            PaddingValues paddingValues9 = paddingValuesM478PaddingValues0680j_4;
            boolean z10 = z2;
            Alignment.Horizontal horizontal9 = start;
            Arrangement.Vertical vertical10 = vertical2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-563353797, i3, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:373)");
            }
            LazyColumn(modifier3, lazyListState3, paddingValues9, z10, vertical10, horizontal9, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState4 = lazyListState3;
            paddingValues2 = paddingValues9;
            z3 = z10;
            vertical3 = vertical10;
            horizontal2 = horizontal9;
            flingBehavior3 = flingBehavior2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier4, lazyListState4, paddingValues2, z3, vertical3, horizontal2, flingBehavior3, interfaceC3750qp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:109:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x0150  */
    /* JADX WARN: Code duplicated, block: B:111:0x0153  */
    /* JADX WARN: Code duplicated, block: B:114:0x015c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0163  */
    /* JADX WARN: Code duplicated, block: B:117:0x0166  */
    /* JADX WARN: Code duplicated, block: B:119:0x0172  */
    /* JADX WARN: Code duplicated, block: B:122:0x0177  */
    /* JADX WARN: Code duplicated, block: B:124:0x017b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0180  */
    /* JADX WARN: Code duplicated, block: B:128:0x0189  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:136:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:144:0x020e  */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:93:0x0115  */
    /* JADX WARN: Code duplicated, block: B:95:0x0123  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        int i3;
        LazyListState lazyListState2;
        PaddingValues paddingValuesM478PaddingValues0680j_4;
        int i4;
        boolean z2;
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        Alignment.Vertical top;
        int i7;
        int i8;
        Modifier modifier2;
        Modifier modifier3;
        LazyListState lazyListStateRememberLazyListState;
        FlingBehavior flingBehavior2;
        LazyListState lazyListState3;
        Arrangement arrangement;
        Arrangement.Horizontal end;
        Modifier modifier4;
        LazyListState lazyListState4;
        PaddingValues paddingValues2;
        boolean z3;
        Arrangement.Horizontal horizontal3;
        Alignment.Vertical vertical2;
        FlingBehavior flingBehavior3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(407929823);
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                lazyListState2 = lazyListState;
                int i11 = composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
                i3 |= i11;
            } else {
                lazyListState2 = lazyListState;
            }
            i3 |= i11;
        } else {
            lazyListState2 = lazyListState;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 896) == 0) {
                paddingValuesM478PaddingValues0680j_4 = paddingValues;
                i3 |= composerStartRestartGroup.changed(paddingValuesM478PaddingValues0680j_4) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        horizontal2 = horizontal;
                        int i13 = composerStartRestartGroup.changed(horizontal2) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i13;
                } else {
                    horizontal2 = horizontal;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    top = vertical;
                } else {
                    top = vertical;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(top)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior)) {
                        i9 = 524288;
                    } else {
                        i9 = 1048576;
                    }
                    i3 |= i9;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((23967451 & i3) != 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    flingBehavior3 = flingBehavior;
                    lazyListState4 = lazyListState2;
                    paddingValues2 = paddingValuesM478PaddingValues0680j_4;
                    z3 = z2;
                    vertical2 = top;
                    horizontal3 = horizontal2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        modifier3 = modifier2;
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState2;
                        }
                        if (i12 != 0) {
                            paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                        }
                        if (i4 != 0) {
                            z2 = false;
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z2) {
                                end = arrangement.getEnd();
                            } else {
                                end = arrangement.getStart();
                            }
                            i3 &= -57345;
                            horizontal2 = end;
                        }
                        if (i6 != 0) {
                            top = Alignment.Companion.getTop();
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        lazyListState3 = lazyListStateRememberLazyListState;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        modifier3 = modifier;
                        flingBehavior2 = flingBehavior;
                        lazyListState3 = lazyListState2;
                    }
                    PaddingValues paddingValues3 = paddingValuesM478PaddingValues0680j_4;
                    boolean z4 = z2;
                    Alignment.Vertical vertical3 = top;
                    Arrangement.Horizontal horizontal4 = horizontal2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(407929823, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
                    }
                    LazyRow(modifier3, lazyListState3, paddingValues3, z4, horizontal4, vertical3, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    lazyListState4 = lazyListState3;
                    paddingValues2 = paddingValues3;
                    z3 = z4;
                    horizontal3 = horizontal4;
                    vertical2 = vertical3;
                    flingBehavior3 = flingBehavior2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C13552(modifier4, lazyListState4, paddingValues2, z3, horizontal3, vertical2, flingBehavior3, interfaceC3750qp, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i13;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i13;
            } else {
                horizontal2 = horizontal;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                top = vertical;
            } else {
                top = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(top)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) != 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues4 = paddingValuesM478PaddingValues0680j_4;
                boolean z5 = z2;
                Alignment.Vertical vertical4 = top;
                Arrangement.Horizontal horizontal5 = horizontal2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(407929823, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
                }
                LazyRow(modifier3, lazyListState3, paddingValues4, z5, horizontal5, vertical4, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues4;
                z3 = z5;
                horizontal3 = horizontal5;
                vertical2 = vertical4;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues5 = paddingValuesM478PaddingValues0680j_4;
                boolean z6 = z2;
                Alignment.Vertical vertical5 = top;
                Arrangement.Horizontal horizontal6 = horizontal2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(407929823, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
                }
                LazyRow(modifier3, lazyListState3, paddingValues5, z6, horizontal6, vertical5, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues5;
                z3 = z6;
                horizontal3 = horizontal6;
                vertical2 = vertical5;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13552(modifier4, lazyListState4, paddingValues2, z3, horizontal3, vertical2, flingBehavior3, interfaceC3750qp, i, i2));
        }
        i3 |= 384;
        paddingValuesM478PaddingValues0680j_4 = paddingValues;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i13;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i13;
            } else {
                horizontal2 = horizontal;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                top = vertical;
            } else {
                top = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(top)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) != 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues6 = paddingValuesM478PaddingValues0680j_4;
                boolean z7 = z2;
                Alignment.Vertical vertical6 = top;
                Arrangement.Horizontal horizontal7 = horizontal2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(407929823, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
                }
                LazyRow(modifier3, lazyListState3, paddingValues6, z7, horizontal7, vertical6, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues6;
                z3 = z7;
                horizontal3 = horizontal7;
                vertical2 = vertical6;
                flingBehavior3 = flingBehavior2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    modifier3 = modifier2;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState2;
                    }
                    if (i12 != 0) {
                        paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.Companion.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    lazyListState3 = lazyListStateRememberLazyListState;
                }
                PaddingValues paddingValues7 = paddingValuesM478PaddingValues0680j_4;
                boolean z8 = z2;
                Alignment.Vertical vertical7 = top;
                Arrangement.Horizontal horizontal8 = horizontal2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(407929823, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
                }
                LazyRow(modifier3, lazyListState3, paddingValues7, z8, horizontal8, vertical7, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                lazyListState4 = lazyListState3;
                paddingValues2 = paddingValues7;
                z3 = z8;
                horizontal3 = horizontal8;
                vertical2 = vertical7;
                flingBehavior3 = flingBehavior2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C13552(modifier4, lazyListState4, paddingValues2, z3, horizontal3, vertical2, flingBehavior3, interfaceC3750qp, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                }
                i3 |= i13;
            } else {
                horizontal2 = horizontal;
            }
            i3 |= i13;
        } else {
            horizontal2 = horizontal;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            top = vertical;
        } else {
            top = vertical;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(top)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i9 = 524288;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((29360128 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3750qp)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        }
        if ((23967451 & i3) != 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            }
            PaddingValues paddingValues8 = paddingValuesM478PaddingValues0680j_4;
            boolean z9 = z2;
            Alignment.Vertical vertical8 = top;
            Arrangement.Horizontal horizontal9 = horizontal2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407929823, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
            }
            LazyRow(modifier3, lazyListState3, paddingValues8, z9, horizontal9, vertical8, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState4 = lazyListState3;
            paddingValues2 = paddingValues8;
            z3 = z9;
            horizontal3 = horizontal9;
            vertical2 = vertical8;
            flingBehavior3 = flingBehavior2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                modifier3 = modifier2;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState2;
                }
                if (i12 != 0) {
                    paddingValuesM478PaddingValues0680j_4 = PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.Companion.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                } else {
                    flingBehavior2 = flingBehavior;
                }
                lazyListState3 = lazyListStateRememberLazyListState;
            }
            PaddingValues paddingValues9 = paddingValuesM478PaddingValues0680j_4;
            boolean z10 = z2;
            Alignment.Vertical vertical9 = top;
            Arrangement.Horizontal horizontal10 = horizontal2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407929823, i3, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:399)");
            }
            LazyRow(modifier3, lazyListState3, paddingValues9, z10, horizontal10, vertical9, flingBehavior2, true, interfaceC3750qp, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            lazyListState4 = lazyListState3;
            paddingValues2 = paddingValues9;
            z3 = z10;
            horizontal3 = horizontal10;
            vertical2 = vertical9;
            flingBehavior3 = flingBehavior2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13552(modifier4, lazyListState4, paddingValues2, z3, horizontal3, vertical2, flingBehavior3, interfaceC3750qp, i, i2));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] objArr, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0604Ip interfaceC0604Ip, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC0526Fp = null;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC0604Ip, "itemContent");
        lazyListScope.items(objArr.length, interfaceC0526Fp != null ? new C13636(interfaceC0526Fp, objArr) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(objArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C13658(interfaceC0604Ip, objArr)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] objArr, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        AbstractC4492zt.h(lazyListScope, "<this>");
        AbstractC4492zt.h(objArr, "items");
        AbstractC4492zt.h(interfaceC0578Hp, "itemContent");
        lazyListScope.items(objArr.length, interfaceC3750qp != null ? new AnonymousClass6(interfaceC3750qp, objArr) : null, new AnonymousClass7(AnonymousClass5.INSTANCE, objArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(interfaceC0578Hp, objArr)));
    }
}
