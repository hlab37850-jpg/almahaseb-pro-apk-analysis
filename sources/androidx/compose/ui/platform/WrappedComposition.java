package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.NV;
import defpackage.XS;
import java.util.Set;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
final class WrappedComposition implements Composition, LifecycleEventObserver {
    private Lifecycle addedToLifecycle;
    private boolean disposed;
    private InterfaceC0526Fp lastContent;
    private final Composition original;
    private final AndroidComposeView owner;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $content;

        /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01361 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC0526Fp $content;
            final /* synthetic */ WrappedComposition this$0;

            /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.ui.platform.WrappedComposition$setContent$1$1$1", f = "Wrapper.android.kt", l = {ShapeTypes.FLOW_CHART_MAGNETIC_DISK}, m = "invokeSuspend")
            public static final class C01371 extends XS implements InterfaceC0526Fp {
                int label;
                final /* synthetic */ WrappedComposition this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01371(WrappedComposition wrappedComposition, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.this$0 = wrappedComposition;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C01371(this.this$0, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C01371) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        AndroidComposeView owner = this.this$0.getOwner();
                        this.label = 1;
                        if (owner.boundsUpdatesEventLoop(this) == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.ui.platform.WrappedComposition$setContent$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ InterfaceC0526Fp $content;
                final /* synthetic */ WrappedComposition this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(WrappedComposition wrappedComposition, InterfaceC0526Fp interfaceC0526Fp) {
                    super(2);
                    this.this$0 = wrappedComposition;
                    this.$content = interfaceC0526Fp;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return FW.a;
                }

                @Composable
                public final void invoke(Composer composer, int i) {
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1193460702, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:156)");
                    }
                    AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(this.this$0.getOwner(), this.$content, composer, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01361(WrappedComposition wrappedComposition, InterfaceC0526Fp interfaceC0526Fp) {
                super(2);
                this.this$0 = wrappedComposition;
                this.$content = interfaceC0526Fp;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return FW.a;
            }

            @Composable
            public final void invoke(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2000640158, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:141)");
                }
                AndroidComposeView owner = this.this$0.getOwner();
                int i2 = R.id.inspection_slot_table_set;
                Object tag = owner.getTag(i2);
                Set<CompositionData> set = NV.k(tag) ? (Set) tag : null;
                if (set == null) {
                    Object parent = this.this$0.getOwner().getParent();
                    View view = parent instanceof View ? (View) parent : null;
                    Object tag2 = view != null ? view.getTag(i2) : null;
                    set = NV.k(tag2) ? (Set) tag2 : null;
                }
                if (set != null) {
                    set.add(composer.getCompositionData());
                    composer.collectParameterInformation();
                }
                EffectsKt.LaunchedEffect(this.this$0.getOwner(), new C01371(this.this$0, null), composer, 72);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InspectionTablesKt.getLocalInspectionTables().provides(set)}, ComposableLambdaKt.composableLambda(composer, -1193460702, true, new AnonymousClass2(this.this$0, this.$content)), composer, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp) {
            super(1);
            this.$content = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AndroidComposeView.ViewTreeOwners) obj);
            return FW.a;
        }

        public final void invoke(AndroidComposeView.ViewTreeOwners viewTreeOwners) {
            AbstractC4492zt.h(viewTreeOwners, "it");
            if (WrappedComposition.this.disposed) {
                return;
            }
            Lifecycle lifecycle = viewTreeOwners.getLifecycleOwner().getLifecycle();
            WrappedComposition.this.lastContent = this.$content;
            if (WrappedComposition.this.addedToLifecycle == null) {
                WrappedComposition.this.addedToLifecycle = lifecycle;
                lifecycle.addObserver(WrappedComposition.this);
            } else if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                WrappedComposition.this.getOriginal().setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, true, new C01361(WrappedComposition.this, this.$content)));
            }
        }
    }

    public WrappedComposition(AndroidComposeView androidComposeView, Composition composition) {
        AbstractC4492zt.h(androidComposeView, "owner");
        AbstractC4492zt.h(composition, "original");
        this.owner = androidComposeView;
        this.original = composition;
        this.lastContent = ComposableSingletons$Wrapper_androidKt.INSTANCE.m4474getLambda1$ui_release();
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.owner.getView().setTag(R.id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
        }
        this.original.dispose();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        return this.original.getHasInvalidations();
    }

    public final Composition getOriginal() {
        return this.original;
    }

    public final AndroidComposeView getOwner() {
        return this.owner;
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.original.isDisposed();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        AbstractC4492zt.h(lifecycleOwner, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.disposed) {
                return;
            }
            setContent(this.lastContent);
        }
    }

    @Override // androidx.compose.runtime.Composition
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void setContent(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        this.owner.setOnViewTreeOwnersAvailable(new AnonymousClass1(interfaceC0526Fp));
    }
}
