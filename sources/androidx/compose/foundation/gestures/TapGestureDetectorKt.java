package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2133eg;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.JL;
import defpackage.LL;
import defpackage.O8;
import defpackage.OJ;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class TapGestureDetectorKt {
    private static final InterfaceC0552Gp NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", l = {TIFFConstants.TIFFTAG_STRIPBYTECOUNTS}, m = "awaitFirstDown")
    public static final class AnonymousClass2 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", l = {212}, m = "invokeSuspend")
    public static final class C13312 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13312(PointerInputChange pointerInputChange, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$firstUp = pointerInputChange;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13312 c13312 = new C13312(this.$firstUp, interfaceC0793Of);
            c13312.L$0 = obj;
            return c13312;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13312) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0046 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0051 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0044 -> B:12:0x0047). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                int r1 = r11.label
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                long r3 = r11.J$0
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                defpackage.LL.b(r12)
                goto L47
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1d:
                defpackage.LL.b(r12)
                java.lang.Object r12 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                androidx.compose.ui.input.pointer.PointerInputChange r1 = r11.$firstUp
                long r3 = r1.getUptimeMillis()
                androidx.compose.ui.platform.ViewConfiguration r1 = r12.getViewConfiguration()
                long r5 = r1.getDoubleTapMinTimeMillis()
                long r3 = r3 + r5
                r1 = r12
            L34:
                r11.L$0 = r1
                r11.J$0 = r3
                r11.label = r2
                r6 = 0
                r7 = 0
                r9 = 3
                r10 = 0
                r5 = r1
                r8 = r11
                java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L47
                return r0
            L47:
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                long r5 = r12.getUptimeMillis()
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 < 0) goto L34
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.C13312.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", l = {195}, m = "consumeUntilUp")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", l = {232}, m = "invokeSuspend")
    public static final class C13322 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0552Gp $onPress;
        final /* synthetic */ InterfaceC3750qp $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputScope $this_detectTapAndPress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", l = {Jpeg.M_APPD, 245}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends JL implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC2052dg $$this$coroutineScope;
            final /* synthetic */ InterfaceC0552Gp $onPress;
            final /* synthetic */ InterfaceC3750qp $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", f = "TapGestureDetector.kt", l = {234}, m = "invokeSuspend")
            public static final class C00361 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00361(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C00361(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00361) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        this.label = 1;
                        if (pressGestureScopeImpl.reset(this) == objD) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", f = "TapGestureDetector.kt", l = {241}, m = "invokeSuspend")
            public static final class C00372 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ InterfaceC0552Gp $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00372(InterfaceC0552Gp interfaceC0552Gp, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$onPress = interfaceC0552Gp;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C00372(this.$onPress, this.$pressScope, this.$down, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00372) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        InterfaceC0552Gp interfaceC0552Gp = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM2787boximpl = Offset.m2787boximpl(this.$down.m4054getPositionF1C5BW0());
                        this.label = 1;
                        if (interfaceC0552Gp.invoke(pressGestureScopeImpl, offsetM2787boximpl, this) == objD) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass3(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass3) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$pressScope.cancel();
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$4, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$4", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass4 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass4(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass4) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$pressScope.release();
                    return FW.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC2052dg interfaceC2052dg, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp, PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$$this$coroutineScope = interfaceC2052dg;
                this.$onPress = interfaceC0552Gp;
                this.$onTap = interfaceC3750qp;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, interfaceC0793Of);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:21:0x0081  */
            /* JADX WARN: Code duplicated, block: B:22:0x0093  */
            /* JADX WARN: Code duplicated, block: B:24:0x00b2  */
            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                AwaitPointerEventScope awaitPointerEventScope;
                Object objAwaitFirstDown$default;
                Object objWaitForUpOrCancellation$default;
                PointerInputChange pointerInputChange;
                InterfaceC3750qp interfaceC3750qp;
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        awaitPointerEventScope = awaitPointerEventScope2;
                        objAwaitFirstDown$default = obj;
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                        objWaitForUpOrCancellation$default = obj;
                    }
                    pointerInputChange = (PointerInputChange) objWaitForUpOrCancellation$default;
                    if (pointerInputChange == null) {
                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass3(this.$pressScope, null), 3, null);
                    } else {
                        pointerInputChange.consume();
                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                        interfaceC3750qp = this.$onTap;
                        if (interfaceC3750qp != null) {
                            interfaceC3750qp.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                        }
                    }
                    return FW.a;
                }
                LL.b(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                O8.d(this.$$this$coroutineScope, null, null, new C00361(this.$pressScope, null), 3, null);
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 3, null);
                if (objAwaitFirstDown$default == objD) {
                    return objD;
                }
                PointerInputChange pointerInputChange2 = (PointerInputChange) objAwaitFirstDown$default;
                pointerInputChange2.consume();
                if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                    O8.d(this.$$this$coroutineScope, null, null, new C00372(this.$onPress, this.$pressScope, pointerInputChange2, null), 3, null);
                }
                this.L$0 = null;
                this.label = 2;
                objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                if (objWaitForUpOrCancellation$default == objD) {
                    return objD;
                }
                pointerInputChange = (PointerInputChange) objWaitForUpOrCancellation$default;
                if (pointerInputChange == null) {
                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass3(this.$pressScope, null), 3, null);
                } else {
                    pointerInputChange.consume();
                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                    interfaceC3750qp = this.$onTap;
                    if (interfaceC3750qp != null) {
                        interfaceC3750qp.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                    }
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13322(PointerInputScope pointerInputScope, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp, PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_detectTapAndPress = pointerInputScope;
            this.$onPress = interfaceC0552Gp;
            this.$onTap = interfaceC3750qp;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13322 c13322 = new C13322(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, interfaceC0793Of);
            c13322.L$0 = obj;
            return c13322;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C13322) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                PointerInputScope pointerInputScope = this.$this_detectTapAndPress;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC2052dg, this.$onPress, this.$onTap, this.$pressScope, null);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", l = {99}, m = "invokeSuspend")
    public static final class C13332 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3750qp $onDoubleTap;
        final /* synthetic */ InterfaceC3750qp $onLongPress;
        final /* synthetic */ InterfaceC0552Gp $onPress;
        final /* synthetic */ InterfaceC3750qp $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", l = {100, 114, 129, ShapeTypes.FLOW_CHART_MANUAL_INPUT, ShapeTypes.FLOW_CHART_MAGNETIC_DRUM, ShapeTypes.MATH_MULTIPLY}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends JL implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC2052dg $$this$coroutineScope;
            final /* synthetic */ InterfaceC3750qp $onDoubleTap;
            final /* synthetic */ InterfaceC3750qp $onLongPress;
            final /* synthetic */ InterfaceC0552Gp $onPress;
            final /* synthetic */ InterfaceC3750qp $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            long J$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", l = {103}, m = "invokeSuspend")
            public static final class C00381 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00381(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C00381(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00381) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        this.label = 1;
                        if (pressGestureScopeImpl.reset(this) == objD) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass10 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass10(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass10(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass10) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$pressScope.release();
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", l = {106}, m = "invokeSuspend")
            public static final class C00392 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ InterfaceC0552Gp $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00392(InterfaceC0552Gp interfaceC0552Gp, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$onPress = interfaceC0552Gp;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$down = pointerInputChange;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C00392(this.$onPress, this.$pressScope, this.$down, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00392) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        InterfaceC0552Gp interfaceC0552Gp = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM2787boximpl = Offset.m2787boximpl(this.$down.m4054getPositionF1C5BW0());
                        this.label = 1;
                        if (interfaceC0552Gp.invoke(pressGestureScopeImpl, offsetM2787boximpl, this) == objD) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", l = {115}, m = "invokeSuspend")
            public static final class AnonymousClass3 extends JL implements InterfaceC0526Fp {
                private /* synthetic */ Object L$0;
                int label;

                public AnonymousClass3(InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(interfaceC0793Of);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass3) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        this.label = 1;
                        obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                        if (obj == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                    return obj;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass4 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass4(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass4) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$pressScope.cancel();
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass5 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass5(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass5(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass5) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$pressScope.release();
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass6 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass6(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass6(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass6) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$pressScope.release();
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", l = {148}, m = "invokeSuspend")
            public static final class AnonymousClass7 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass7(this.$pressScope, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass7) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        this.label = 1;
                        if (pressGestureScopeImpl.reset(this) == objD) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", l = {ShapeTypes.FLOW_CHART_MERGE}, m = "invokeSuspend")
            public static final class AnonymousClass8 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ InterfaceC0552Gp $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ PointerInputChange $secondDown;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass8(InterfaceC0552Gp interfaceC0552Gp, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$onPress = interfaceC0552Gp;
                    this.$pressScope = pressGestureScopeImpl;
                    this.$secondDown = pointerInputChange;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new AnonymousClass8(this.$onPress, this.$pressScope, this.$secondDown, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass8) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        InterfaceC0552Gp interfaceC0552Gp = this.$onPress;
                        PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                        Offset offsetM2787boximpl = Offset.m2787boximpl(this.$secondDown.m4054getPositionF1C5BW0());
                        this.label = 1;
                        if (interfaceC0552Gp.invoke(pressGestureScopeImpl, offsetM2787boximpl, this) == objD) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9", f = "TapGestureDetector.kt", l = {ShapeTypes.FLOW_CHART_DISPLAY}, m = "invokeSuspend")
            public static final class AnonymousClass9 extends JL implements InterfaceC0526Fp {
                final /* synthetic */ InterfaceC2052dg $$this$coroutineScope;
                final /* synthetic */ InterfaceC3750qp $onDoubleTap;
                final /* synthetic */ InterfaceC3750qp $onTap;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ OJ $upOrCancel;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1, reason: invalid class name and collision with other inner class name */
                @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
                public static final class C00401 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00401(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$pressScope = pressGestureScopeImpl;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new C00401(this.$pressScope, interfaceC0793Of);
                    }

                    @Override // defpackage.InterfaceC0526Fp
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                        return ((C00401) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        AbstractC0378Bt.d();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                        this.$pressScope.release();
                        return FW.a;
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2, reason: invalid class name and collision with other inner class name */
                @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
                public static final class C00412 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ PressGestureScopeImpl $pressScope;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00412(PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$pressScope = pressGestureScopeImpl;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new C00412(this.$pressScope, interfaceC0793Of);
                    }

                    @Override // defpackage.InterfaceC0526Fp
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                        return ((C00412) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        AbstractC0378Bt.d();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                        this.$pressScope.cancel();
                        return FW.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass9(InterfaceC2052dg interfaceC2052dg, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, OJ oj, PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$$this$coroutineScope = interfaceC2052dg;
                    this.$onDoubleTap = interfaceC3750qp;
                    this.$onTap = interfaceC3750qp2;
                    this.$upOrCancel = oj;
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, this.$upOrCancel, this.$pressScope, interfaceC0793Of);
                    anonymousClass9.L$0 = obj;
                    return anonymousClass9;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                    return ((AnonymousClass9) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        this.label = 1;
                        obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                        if (obj == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                    PointerInputChange pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange != null) {
                        pointerInputChange.consume();
                        O8.d(this.$$this$coroutineScope, null, null, new C00401(this.$pressScope, null), 3, null);
                        this.$onDoubleTap.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                        return FW.a;
                    }
                    O8.d(this.$$this$coroutineScope, null, null, new C00412(this.$pressScope, null), 3, null);
                    InterfaceC3750qp interfaceC3750qp = this.$onTap;
                    if (interfaceC3750qp == null) {
                        return null;
                    }
                    interfaceC3750qp.invoke(Offset.m2787boximpl(((PointerInputChange) this.$upOrCancel.a).m4054getPositionF1C5BW0()));
                    return FW.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC2052dg interfaceC2052dg, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, PressGestureScopeImpl pressGestureScopeImpl, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$$this$coroutineScope = interfaceC2052dg;
                this.$onPress = interfaceC0552Gp;
                this.$onLongPress = interfaceC3750qp;
                this.$onDoubleTap = interfaceC3750qp2;
                this.$onTap = interfaceC3750qp3;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, interfaceC0793Of);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
            /* JADX WARN: Code duplicated, block: B:28:0x00ca  */
            /* JADX WARN: Code duplicated, block: B:29:0x00d3  */
            /* JADX WARN: Code duplicated, block: B:33:0x00f5 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:34:0x00f6  */
            /* JADX WARN: Code duplicated, block: B:37:0x00ff A[Catch: PointerEventTimeoutCancellationException -> 0x0110, TryCatch #4 {PointerEventTimeoutCancellationException -> 0x0110, blocks: (B:35:0x00f9, B:37:0x00ff, B:39:0x0115), top: B:93:0x00f9 }] */
            /* JADX WARN: Code duplicated, block: B:39:0x0115 A[Catch: PointerEventTimeoutCancellationException -> 0x0110, TRY_LEAVE, TryCatch #4 {PointerEventTimeoutCancellationException -> 0x0110, blocks: (B:35:0x00f9, B:37:0x00ff, B:39:0x0115), top: B:93:0x00f9 }] */
            /* JADX WARN: Code duplicated, block: B:44:0x0132  */
            /* JADX WARN: Code duplicated, block: B:47:0x0150 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:51:0x0167  */
            /* JADX WARN: Code duplicated, block: B:53:0x016b  */
            /* JADX WARN: Code duplicated, block: B:55:0x016f  */
            /* JADX WARN: Code duplicated, block: B:56:0x017e  */
            /* JADX WARN: Code duplicated, block: B:58:0x0193 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:59:0x0194  */
            /* JADX WARN: Code duplicated, block: B:62:0x0199  */
            /* JADX WARN: Code duplicated, block: B:64:0x019d  */
            /* JADX WARN: Code duplicated, block: B:65:0x01ae  */
            /* JADX WARN: Code duplicated, block: B:67:0x01c6  */
            /* JADX WARN: Code duplicated, block: B:70:0x01f7 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:74:0x0200  */
            /* JADX WARN: Code duplicated, block: B:77:0x0213  */
            /* JADX WARN: Code duplicated, block: B:80:0x022d A[RETURN] */
            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objAwaitFirstDown$default;
                AwaitPointerEventScope awaitPointerEventScope;
                PointerInputChange pointerInputChange;
                long longPressTimeoutMillis;
                OJ oj;
                Object objWithTimeout;
                AwaitPointerEventScope awaitPointerEventScope2;
                PointerInputChange pointerInputChange2;
                OJ oj2;
                AwaitPointerEventScope awaitPointerEventScope3;
                InterfaceC3750qp interfaceC3750qp;
                Object obj2;
                Object obj3;
                Object objAwaitSecondDown;
                AwaitPointerEventScope awaitPointerEventScope4;
                InterfaceC3750qp interfaceC3750qp2;
                PointerInputChange pointerInputChange3;
                PointerInputChange pointerInputChange4;
                AwaitPointerEventScope awaitPointerEventScope5;
                OJ oj3;
                AnonymousClass9 anonymousClass9;
                InterfaceC3750qp interfaceC3750qp3;
                InterfaceC3750qp interfaceC3750qp4;
                InterfaceC3750qp interfaceC3750qp5;
                Object objD = AbstractC0378Bt.d();
                switch (this.label) {
                    case 0:
                        LL.b(obj);
                        AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope6;
                        this.label = 1;
                        objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope6, false, null, this, 3, null);
                        if (objAwaitFirstDown$default == objD) {
                            return objD;
                        }
                        awaitPointerEventScope = awaitPointerEventScope6;
                        pointerInputChange = (PointerInputChange) objAwaitFirstDown$default;
                        pointerInputChange.consume();
                        O8.d(this.$$this$coroutineScope, null, null, new C00381(this.$pressScope, null), 3, null);
                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                            O8.d(this.$$this$coroutineScope, null, null, new C00392(this.$onPress, this.$pressScope, pointerInputChange, null), 3, null);
                        }
                        if (this.$onLongPress != null) {
                            longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                        } else {
                            longPressTimeoutMillis = 4611686018427387903L;
                        }
                        oj = new OJ();
                        try {
                            AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = pointerInputChange;
                            this.L$2 = oj;
                            this.L$3 = oj;
                            this.J$0 = longPressTimeoutMillis;
                            this.label = 2;
                            objWithTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, anonymousClass3, this);
                            if (objWithTimeout == objD) {
                                return objD;
                            }
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            pointerInputChange2 = pointerInputChange;
                            oj2 = oj;
                            try {
                                oj.a = objWithTimeout;
                                obj2 = oj2.a;
                                if (obj2 == null) {
                                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                                } else {
                                    ((PointerInputChange) obj2).consume();
                                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                                }
                                break;
                            } catch (PointerEventTimeoutCancellationException unused) {
                                oj = oj2;
                                pointerInputChange = pointerInputChange2;
                                awaitPointerEventScope3 = awaitPointerEventScope2;
                                interfaceC3750qp = this.$onLongPress;
                                if (interfaceC3750qp != null) {
                                    interfaceC3750qp.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                                }
                                this.L$0 = awaitPointerEventScope3;
                                this.L$1 = oj;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = longPressTimeoutMillis;
                                this.label = 3;
                                if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) == objD) {
                                    return objD;
                                }
                                O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                                oj2 = oj;
                                awaitPointerEventScope2 = awaitPointerEventScope3;
                            }
                            obj3 = oj2.a;
                            if (obj3 != null) {
                                if (this.$onDoubleTap == null) {
                                    interfaceC3750qp2 = this.$onTap;
                                    if (interfaceC3750qp2 != null) {
                                        interfaceC3750qp2.invoke(Offset.m2787boximpl(((PointerInputChange) obj3).m4054getPositionF1C5BW0()));
                                    }
                                } else {
                                    this.L$0 = awaitPointerEventScope2;
                                    this.L$1 = oj2;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.J$0 = longPressTimeoutMillis;
                                    this.label = 4;
                                    objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) obj3, this);
                                    if (objAwaitSecondDown == objD) {
                                        return objD;
                                    }
                                    awaitPointerEventScope4 = awaitPointerEventScope2;
                                    pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                    if (pointerInputChange3 == null) {
                                        interfaceC3750qp3 = this.$onTap;
                                        if (interfaceC3750qp3 != null) {
                                            interfaceC3750qp3.invoke(Offset.m2787boximpl(((PointerInputChange) oj2.a).m4054getPositionF1C5BW0()));
                                        }
                                    } else {
                                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                        }
                                        try {
                                            anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, oj2, this.$pressScope, null);
                                            this.L$0 = awaitPointerEventScope4;
                                            this.L$1 = oj2;
                                            this.L$2 = pointerInputChange3;
                                            this.label = 5;
                                            if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == objD) {
                                                return objD;
                                            }
                                        } catch (PointerEventTimeoutCancellationException unused2) {
                                            pointerInputChange4 = pointerInputChange3;
                                            awaitPointerEventScope5 = awaitPointerEventScope4;
                                            oj3 = oj2;
                                            interfaceC3750qp4 = this.$onTap;
                                            if (interfaceC3750qp4 != null) {
                                                interfaceC3750qp4.invoke(Offset.m2787boximpl(((PointerInputChange) oj3.a).m4054getPositionF1C5BW0()));
                                            }
                                            interfaceC3750qp5 = this.$onLongPress;
                                            if (interfaceC3750qp5 != null) {
                                                interfaceC3750qp5.invoke(Offset.m2787boximpl(pointerInputChange4.m4054getPositionF1C5BW0()));
                                            }
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.label = 6;
                                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, this) == objD) {
                                                return objD;
                                            }
                                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                                        }
                                    }
                                }
                            }
                            return FW.a;
                        } catch (PointerEventTimeoutCancellationException unused3) {
                            awaitPointerEventScope3 = awaitPointerEventScope;
                            interfaceC3750qp = this.$onLongPress;
                            if (interfaceC3750qp != null) {
                                interfaceC3750qp.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                            }
                            this.L$0 = awaitPointerEventScope3;
                            this.L$1 = oj;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = longPressTimeoutMillis;
                            this.label = 3;
                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) == objD) {
                                return objD;
                            }
                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                            oj2 = oj;
                            awaitPointerEventScope2 = awaitPointerEventScope3;
                            obj3 = oj2.a;
                            if (obj3 != null) {
                                if (this.$onDoubleTap == null) {
                                    interfaceC3750qp2 = this.$onTap;
                                    if (interfaceC3750qp2 != null) {
                                        interfaceC3750qp2.invoke(Offset.m2787boximpl(((PointerInputChange) obj3).m4054getPositionF1C5BW0()));
                                    }
                                } else {
                                    this.L$0 = awaitPointerEventScope2;
                                    this.L$1 = oj2;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.J$0 = longPressTimeoutMillis;
                                    this.label = 4;
                                    objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) obj3, this);
                                    if (objAwaitSecondDown == objD) {
                                        return objD;
                                    }
                                    awaitPointerEventScope4 = awaitPointerEventScope2;
                                    pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                    if (pointerInputChange3 == null) {
                                        interfaceC3750qp3 = this.$onTap;
                                        if (interfaceC3750qp3 != null) {
                                            interfaceC3750qp3.invoke(Offset.m2787boximpl(((PointerInputChange) oj2.a).m4054getPositionF1C5BW0()));
                                        }
                                    } else {
                                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                        }
                                        anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, oj2, this.$pressScope, null);
                                        this.L$0 = awaitPointerEventScope4;
                                        this.L$1 = oj2;
                                        this.L$2 = pointerInputChange3;
                                        this.label = 5;
                                        if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == objD) {
                                            return objD;
                                        }
                                    }
                                }
                            }
                            return FW.a;
                        }
                    case 1:
                        AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        awaitPointerEventScope = awaitPointerEventScope7;
                        objAwaitFirstDown$default = obj;
                        pointerInputChange = (PointerInputChange) objAwaitFirstDown$default;
                        pointerInputChange.consume();
                        O8.d(this.$$this$coroutineScope, null, null, new C00381(this.$pressScope, null), 3, null);
                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                            O8.d(this.$$this$coroutineScope, null, null, new C00392(this.$onPress, this.$pressScope, pointerInputChange, null), 3, null);
                        }
                        if (this.$onLongPress != null) {
                            longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                        } else {
                            longPressTimeoutMillis = 4611686018427387903L;
                        }
                        oj = new OJ();
                        AnonymousClass3 anonymousClass4 = new AnonymousClass3(null);
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = pointerInputChange;
                        this.L$2 = oj;
                        this.L$3 = oj;
                        this.J$0 = longPressTimeoutMillis;
                        this.label = 2;
                        objWithTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, anonymousClass4, this);
                        if (objWithTimeout == objD) {
                            return objD;
                        }
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        pointerInputChange2 = pointerInputChange;
                        oj2 = oj;
                        oj.a = objWithTimeout;
                        obj2 = oj2.a;
                        if (obj2 == null) {
                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                        } else {
                            ((PointerInputChange) obj2).consume();
                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                        }
                        obj3 = oj2.a;
                        if (obj3 != null) {
                            if (this.$onDoubleTap == null) {
                                interfaceC3750qp2 = this.$onTap;
                                if (interfaceC3750qp2 != null) {
                                    interfaceC3750qp2.invoke(Offset.m2787boximpl(((PointerInputChange) obj3).m4054getPositionF1C5BW0()));
                                }
                            } else {
                                this.L$0 = awaitPointerEventScope2;
                                this.L$1 = oj2;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = longPressTimeoutMillis;
                                this.label = 4;
                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) obj3, this);
                                if (objAwaitSecondDown == objD) {
                                    return objD;
                                }
                                awaitPointerEventScope4 = awaitPointerEventScope2;
                                pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                if (pointerInputChange3 == null) {
                                    interfaceC3750qp3 = this.$onTap;
                                    if (interfaceC3750qp3 != null) {
                                        interfaceC3750qp3.invoke(Offset.m2787boximpl(((PointerInputChange) oj2.a).m4054getPositionF1C5BW0()));
                                    }
                                } else {
                                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                    if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                    }
                                    anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, oj2, this.$pressScope, null);
                                    this.L$0 = awaitPointerEventScope4;
                                    this.L$1 = oj2;
                                    this.L$2 = pointerInputChange3;
                                    this.label = 5;
                                    if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == objD) {
                                        return objD;
                                    }
                                }
                            }
                        }
                        return FW.a;
                    case 2:
                        longPressTimeoutMillis = this.J$0;
                        oj = (OJ) this.L$3;
                        OJ oj4 = (OJ) this.L$2;
                        pointerInputChange = (PointerInputChange) this.L$1;
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        try {
                            LL.b(obj);
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            pointerInputChange2 = pointerInputChange;
                            oj2 = oj4;
                            objWithTimeout = obj;
                            oj.a = objWithTimeout;
                            obj2 = oj2.a;
                            if (obj2 == null) {
                                O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                            } else {
                                ((PointerInputChange) obj2).consume();
                                O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                            }
                            break;
                        } catch (PointerEventTimeoutCancellationException unused4) {
                            oj = oj4;
                            awaitPointerEventScope3 = awaitPointerEventScope;
                            interfaceC3750qp = this.$onLongPress;
                            if (interfaceC3750qp != null) {
                                interfaceC3750qp.invoke(Offset.m2787boximpl(pointerInputChange.m4054getPositionF1C5BW0()));
                            }
                            this.L$0 = awaitPointerEventScope3;
                            this.L$1 = oj;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = longPressTimeoutMillis;
                            this.label = 3;
                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this) == objD) {
                                return objD;
                            }
                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                            oj2 = oj;
                            awaitPointerEventScope2 = awaitPointerEventScope3;
                            obj3 = oj2.a;
                            if (obj3 != null) {
                                if (this.$onDoubleTap == null) {
                                    interfaceC3750qp2 = this.$onTap;
                                    if (interfaceC3750qp2 != null) {
                                        interfaceC3750qp2.invoke(Offset.m2787boximpl(((PointerInputChange) obj3).m4054getPositionF1C5BW0()));
                                    }
                                } else {
                                    this.L$0 = awaitPointerEventScope2;
                                    this.L$1 = oj2;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.J$0 = longPressTimeoutMillis;
                                    this.label = 4;
                                    objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) obj3, this);
                                    if (objAwaitSecondDown == objD) {
                                        return objD;
                                    }
                                    awaitPointerEventScope4 = awaitPointerEventScope2;
                                    pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                    if (pointerInputChange3 == null) {
                                        interfaceC3750qp3 = this.$onTap;
                                        if (interfaceC3750qp3 != null) {
                                            interfaceC3750qp3.invoke(Offset.m2787boximpl(((PointerInputChange) oj2.a).m4054getPositionF1C5BW0()));
                                        }
                                    } else {
                                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                        if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                        }
                                        anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, oj2, this.$pressScope, null);
                                        this.L$0 = awaitPointerEventScope4;
                                        this.L$1 = oj2;
                                        this.L$2 = pointerInputChange3;
                                        this.label = 5;
                                        if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == objD) {
                                            return objD;
                                        }
                                    }
                                }
                            }
                            return FW.a;
                        }
                        obj3 = oj2.a;
                        if (obj3 != null) {
                            if (this.$onDoubleTap == null) {
                                interfaceC3750qp2 = this.$onTap;
                                if (interfaceC3750qp2 != null) {
                                    interfaceC3750qp2.invoke(Offset.m2787boximpl(((PointerInputChange) obj3).m4054getPositionF1C5BW0()));
                                }
                            } else {
                                this.L$0 = awaitPointerEventScope2;
                                this.L$1 = oj2;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = longPressTimeoutMillis;
                                this.label = 4;
                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) obj3, this);
                                if (objAwaitSecondDown == objD) {
                                    return objD;
                                }
                                awaitPointerEventScope4 = awaitPointerEventScope2;
                                pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                if (pointerInputChange3 == null) {
                                    interfaceC3750qp3 = this.$onTap;
                                    if (interfaceC3750qp3 != null) {
                                        interfaceC3750qp3.invoke(Offset.m2787boximpl(((PointerInputChange) oj2.a).m4054getPositionF1C5BW0()));
                                    }
                                } else {
                                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                    if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                    }
                                    anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, oj2, this.$pressScope, null);
                                    this.L$0 = awaitPointerEventScope4;
                                    this.L$1 = oj2;
                                    this.L$2 = pointerInputChange3;
                                    this.label = 5;
                                    if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == objD) {
                                        return objD;
                                    }
                                }
                            }
                        }
                        return FW.a;
                    case 3:
                        longPressTimeoutMillis = this.J$0;
                        oj = (OJ) this.L$1;
                        awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                        oj2 = oj;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        obj3 = oj2.a;
                        if (obj3 != null) {
                            if (this.$onDoubleTap == null) {
                                interfaceC3750qp2 = this.$onTap;
                                if (interfaceC3750qp2 != null) {
                                    interfaceC3750qp2.invoke(Offset.m2787boximpl(((PointerInputChange) obj3).m4054getPositionF1C5BW0()));
                                }
                            } else {
                                this.L$0 = awaitPointerEventScope2;
                                this.L$1 = oj2;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = longPressTimeoutMillis;
                                this.label = 4;
                                objAwaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) obj3, this);
                                if (objAwaitSecondDown == objD) {
                                    return objD;
                                }
                                awaitPointerEventScope4 = awaitPointerEventScope2;
                                pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                                if (pointerInputChange3 == null) {
                                    interfaceC3750qp3 = this.$onTap;
                                    if (interfaceC3750qp3 != null) {
                                        interfaceC3750qp3.invoke(Offset.m2787boximpl(((PointerInputChange) oj2.a).m4054getPositionF1C5BW0()));
                                    }
                                } else {
                                    O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                    if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                    }
                                    anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, oj2, this.$pressScope, null);
                                    this.L$0 = awaitPointerEventScope4;
                                    this.L$1 = oj2;
                                    this.L$2 = pointerInputChange3;
                                    this.label = 5;
                                    if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == objD) {
                                        return objD;
                                    }
                                }
                            }
                        }
                        return FW.a;
                    case 4:
                        longPressTimeoutMillis = this.J$0;
                        OJ oj5 = (OJ) this.L$1;
                        awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                        LL.b(obj);
                        oj2 = oj5;
                        objAwaitSecondDown = obj;
                        pointerInputChange3 = (PointerInputChange) objAwaitSecondDown;
                        if (pointerInputChange3 == null) {
                            interfaceC3750qp3 = this.$onTap;
                            if (interfaceC3750qp3 != null) {
                                interfaceC3750qp3.invoke(Offset.m2787boximpl(((PointerInputChange) oj2.a).m4054getPositionF1C5BW0()));
                            }
                        } else {
                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                            if (this.$onPress != TapGestureDetectorKt.NoPressGesture) {
                                O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                            }
                            anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, oj2, this.$pressScope, null);
                            this.L$0 = awaitPointerEventScope4;
                            this.L$1 = oj2;
                            this.L$2 = pointerInputChange3;
                            this.label = 5;
                            if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == objD) {
                                return objD;
                            }
                        }
                        return FW.a;
                    case 5:
                        pointerInputChange4 = (PointerInputChange) this.L$2;
                        oj3 = (OJ) this.L$1;
                        awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                        try {
                            LL.b(obj);
                            break;
                        } catch (PointerEventTimeoutCancellationException unused5) {
                            interfaceC3750qp4 = this.$onTap;
                            if (interfaceC3750qp4 != null) {
                                interfaceC3750qp4.invoke(Offset.m2787boximpl(((PointerInputChange) oj3.a).m4054getPositionF1C5BW0()));
                            }
                            interfaceC3750qp5 = this.$onLongPress;
                            if (interfaceC3750qp5 != null) {
                                interfaceC3750qp5.invoke(Offset.m2787boximpl(pointerInputChange4.m4054getPositionF1C5BW0()));
                            }
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 6;
                            if (TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, this) == objD) {
                                return objD;
                            }
                            O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                        }
                        return FW.a;
                    case 6:
                        LL.b(obj);
                        O8.d(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                        return FW.a;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13332(PointerInputScope pointerInputScope, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_detectTapGestures = pointerInputScope;
            this.$onPress = interfaceC0552Gp;
            this.$onLongPress = interfaceC3750qp;
            this.$onDoubleTap = interfaceC3750qp2;
            this.$onTap = interfaceC3750qp3;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13332 c13332 = new C13332(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, interfaceC0793Of);
            c13332.L$0 = obj;
            return c13332;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C13332) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
                PointerInputScope pointerInputScope = this.$this_detectTapGestures;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC2052dg, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, pressGestureScopeImpl, null);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", l = {305, TIFFConstants.TIFFTAG_COLORMAP}, m = "waitForUpOrCancellation")
    public static final class C13342 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13342(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope awaitPointerEventScope, boolean z, InterfaceC0793Of interfaceC0793Of) {
        return awaitFirstDown(awaitPointerEventScope, z, PointerEventPass.Main, interfaceC0793Of);
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, InterfaceC0793Of interfaceC0793Of) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new C13312(pointerInputChange, null), interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0052 A[LOOP:0: B:19:0x0050->B:20:0x0052, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0075 A[LOOP:1: B:22:0x0066->B:26:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x0068
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, defpackage.InterfaceC0793Of r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            defpackage.LL.b(r9)
            goto L44
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            defpackage.LL.b(r9)
        L38:
            r0.L$0 = r8
            r0.label = r3
            r9 = 0
            java.lang.Object r9 = defpackage.J6.t(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L44
            return r1
        L44:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = 0
        L50:
            if (r6 >= r4) goto L5e
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.consume()
            int r6 = r6 + 1
            goto L50
        L5e:
            java.util.List r9 = r9.getChanges()
            int r2 = r9.size()
        L66:
            if (r5 >= r2) goto L78
            java.lang.Object r4 = r9.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            boolean r4 = r4.getPressed()
            if (r4 == 0) goto L75
            goto L38
        L75:
            int r5 = r5 + 1
            goto L66
        L78:
            FW r8 = defpackage.FW.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, Of):java.lang.Object");
    }

    public static final Object detectTapAndPress(PointerInputScope pointerInputScope, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new C13322(pointerInputScope, interfaceC0552Gp, interfaceC3750qp, new PressGestureScopeImpl(pointerInputScope), null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0552Gp = NoPressGesture;
        }
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        return detectTapAndPress(pointerInputScope, interfaceC0552Gp, interfaceC3750qp, interfaceC0793Of);
    }

    public static final Object detectTapGestures(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp3, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new C13332(pointerInputScope, interfaceC0552Gp, interfaceC3750qp2, interfaceC3750qp, interfaceC3750qp3, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0552Gp interfaceC0552Gp, InterfaceC3750qp interfaceC3750qp3, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        InterfaceC3750qp interfaceC3750qp4 = (i & 1) != 0 ? null : interfaceC3750qp;
        InterfaceC3750qp interfaceC3750qp5 = (i & 2) != 0 ? null : interfaceC3750qp2;
        if ((i & 4) != 0) {
            interfaceC0552Gp = NoPressGesture;
        }
        return detectTapGestures(pointerInputScope, interfaceC3750qp4, interfaceC3750qp5, interfaceC0552Gp, (i & 8) != 0 ? null : interfaceC3750qp3, interfaceC0793Of);
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0067  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074 A[LOOP:0: B:19:0x005d->B:26:0x0074, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, boolean r10, androidx.compose.ui.input.pointer.PointerEventPass r11, defpackage.InterfaceC0793Of r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r10 = (androidx.compose.ui.input.pointer.PointerEventPass) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            defpackage.LL.b(r12)
            r8 = r10
            r10 = r9
            r9 = r11
            r11 = r8
            goto L51
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            defpackage.LL.b(r12)
        L42:
            r0.L$0 = r9
            r0.L$1 = r11
            r0.Z$0 = r10
            r0.label = r3
            java.lang.Object r12 = r9.awaitPointerEvent(r11, r0)
            if (r12 != r1) goto L51
            return r1
        L51:
            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
            java.util.List r2 = r12.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = 0
        L5d:
            if (r6 >= r4) goto L77
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r10 == 0) goto L6c
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r7)
            goto L70
        L6c:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r7)
        L70:
            if (r7 != 0) goto L74
            r2 = 0
            goto L78
        L74:
            int r6 = r6 + 1
            goto L5d
        L77:
            r2 = 1
        L78:
            if (r2 == 0) goto L42
            java.util.List r9 = r12.getChanges()
            java.lang.Object r9 = r9.get(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, Of):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0095  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x00e3 A[LOOP:1: B:23:0x007c->B:45:0x00e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x008a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00b3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c0 -> B:13:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, androidx.compose.ui.input.pointer.PointerEventPass r19, defpackage.InterfaceC0793Of r20) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, Of):java.lang.Object");
    }
}
