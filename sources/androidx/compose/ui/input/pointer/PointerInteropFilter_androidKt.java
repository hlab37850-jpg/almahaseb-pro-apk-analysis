package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.JL;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInteropFilter_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1", f = "PointerInteropFilter.android.kt", l = {342}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3750qp $watcher;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$motionEventSpy$1$1", f = "PointerInteropFilter.android.kt", l = {344}, m = "invokeSuspend")
        public static final class C01351 extends JL implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC3750qp $watcher;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01351(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$watcher = interfaceC3750qp;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C01351 c01351 = new C01351(this.$watcher, interfaceC0793Of);
                c01351.L$0 = obj;
                return c01351;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                return ((C01351) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x002f A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:14:0x0038  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:12:0x0030). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // defpackage.AbstractC2171f7
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                    int r1 = r4.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r1 = r4.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    defpackage.LL.b(r5)
                    goto L30
                L13:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L1b:
                    defpackage.LL.b(r5)
                    java.lang.Object r5 = r4.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                    r1 = r5
                L23:
                    androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    r4.L$0 = r1
                    r4.label = r2
                    java.lang.Object r5 = r1.awaitPointerEvent(r5, r4)
                    if (r5 != r0) goto L30
                    return r0
                L30:
                    androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                    android.view.MotionEvent r5 = r5.getMotionEvent$ui_release()
                    if (r5 == 0) goto L23
                    qp r3 = r4.$watcher
                    r3.invoke(r5)
                    goto L23
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt.AnonymousClass1.C01351.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$watcher = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$watcher, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                pointerInputScope.setInterceptOutOfBoundsChildEvents(true);
                C01351 c01351 = new C01351(this.$watcher, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(c01351, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC3750qp $onTouchEvent;
        final /* synthetic */ RequestDisallowInterceptTouchEvent $requestDisallowInterceptTouchEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent) {
            super(3);
            this.$onTouchEvent = interfaceC3750qp;
            this.$requestDisallowInterceptTouchEvent = requestDisallowInterceptTouchEvent;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(374375707);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(374375707, i, -1, "androidx.compose.ui.input.pointer.pointerInteropFilter.<anonymous> (PointerInteropFilter.android.kt:77)");
            }
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new PointerInteropFilter();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) objRememberedValue;
            pointerInteropFilter.setOnTouchEvent(this.$onTouchEvent);
            pointerInteropFilter.setRequestDisallowInterceptTouchEvent(this.$requestDisallowInterceptTouchEvent);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return pointerInteropFilter;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ AndroidViewHolder $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AndroidViewHolder androidViewHolder) {
            super(1);
            this.$view = androidViewHolder;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(MotionEvent motionEvent) {
            boolean zDispatchTouchEvent;
            AbstractC4492zt.h(motionEvent, "motionEvent");
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    zDispatchTouchEvent = this.$view.dispatchTouchEvent(motionEvent);
                    break;
                default:
                    zDispatchTouchEvent = this.$view.dispatchGenericMotionEvent(motionEvent);
                    break;
            }
            return Boolean.valueOf(zDispatchTouchEvent);
        }
    }

    public static final Modifier motionEventSpy(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "watcher");
        return SuspendingPointerInputFilterKt.pointerInput(modifier, interfaceC3750qp, new AnonymousClass1(interfaceC3750qp, null));
    }

    @ExperimentalComposeUiApi
    public static final Modifier pointerInteropFilter(Modifier modifier, AndroidViewHolder androidViewHolder) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(androidViewHolder, "view");
        PointerInteropFilter pointerInteropFilter = new PointerInteropFilter();
        pointerInteropFilter.setOnTouchEvent(new AnonymousClass3(androidViewHolder));
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = new RequestDisallowInterceptTouchEvent();
        pointerInteropFilter.setRequestDisallowInterceptTouchEvent(requestDisallowInterceptTouchEvent);
        androidViewHolder.setOnRequestDisallowInterceptTouchEvent$ui_release(requestDisallowInterceptTouchEvent);
        return modifier.then(pointerInteropFilter);
    }

    public static /* synthetic */ Modifier pointerInteropFilter$default(Modifier modifier, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            requestDisallowInterceptTouchEvent = null;
        }
        return pointerInteropFilter(modifier, requestDisallowInterceptTouchEvent, interfaceC3750qp);
    }

    @ExperimentalComposeUiApi
    public static final Modifier pointerInteropFilter(Modifier modifier, RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onTouchEvent");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PointerInteropFilter_androidKt$pointerInteropFilter$$inlined$debugInspectorInfo$1(requestDisallowInterceptTouchEvent, interfaceC3750qp) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(interfaceC3750qp, requestDisallowInterceptTouchEvent));
    }
}
