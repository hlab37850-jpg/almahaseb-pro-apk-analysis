package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC0630Jp;

/* JADX INFO: loaded from: classes.dex */
public final class MovableContentKt {
    public static final int movableContentKey = 126665345;

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ MovableContent<FW> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MovableContent<FW> movableContent) {
            super(2);
            this.$movableContent = movableContent;
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
                ComposerKt.traceEventStart(-642339857, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:38)");
            }
            composer.insertMovableContent(this.$movableContent, FW.a);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ MovableContent<P> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MovableContent<P> movableContent) {
            super(3);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(P p, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(p) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434707029, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:63)");
            }
            composer.insertMovableContent(this.$movableContent, p);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ MovableContent<C2020dG> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(MovableContent<C2020dG> movableContent) {
            super(4);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(P1 p1, P2 p2, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(p1) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p2) ? 32 : 16;
            }
            if ((i2 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1200019734, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:88)");
            }
            composer.insertMovableContent(this.$movableContent, HV.a(p1, p2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0604Ip {
        final /* synthetic */ MovableContent<C2020dG> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(MovableContent<C2020dG> movableContent) {
            super(5);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0604Ip
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            invoke(obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(P1 p1, P2 p2, P3 p3, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(p1) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p3) ? 256 : 128;
            }
            if ((i2 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1083870185, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:117)");
            }
            composer.insertMovableContent(this.$movableContent, HV.a(HV.a(p1, p2), p3));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0630Jp {
        final /* synthetic */ MovableContent<C2020dG> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(MovableContent<C2020dG> movableContent) {
            super(6);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0630Jp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            invoke(obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(P1 p1, P2 p2, P3 p3, P4 p4, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(p1) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p3) ? 256 : 128;
            }
            if ((i & 7168) == 0) {
                i2 |= composer.changed(p4) ? 2048 : 1024;
            }
            if ((i2 & 46811) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1741877681, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:146)");
            }
            composer.insertMovableContent(this.$movableContent, HV.a(HV.a(p1, p2), HV.a(p3, p4)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16291 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ MovableContent<R> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16291(MovableContent<R> movableContent) {
            super(3);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(R r, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(r) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(506997506, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:171)");
            }
            composer.insertMovableContent(this.$movableContent, r);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16302 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ MovableContent<C2020dG> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16302(MovableContent<C2020dG> movableContent) {
            super(4);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(R r, P p, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(r) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p) ? 32 : 16;
            }
            if ((i2 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(627354118, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:198)");
            }
            composer.insertMovableContent(this.$movableContent, HV.a(r, p));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$3, reason: invalid class name and case insensitive filesystem */
    public static final class C16313 extends AbstractC2233fv implements InterfaceC0604Ip {
        final /* synthetic */ MovableContent<C2020dG> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16313(MovableContent<C2020dG> movableContent) {
            super(5);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0604Ip
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            invoke(obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(R r, P1 p1, P2 p2, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(r) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p1) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p2) ? 256 : 128;
            }
            if ((i2 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(583402949, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:227)");
            }
            composer.insertMovableContent(this.$movableContent, HV.a(HV.a(r, p1), p2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$4, reason: invalid class name and case insensitive filesystem */
    public static final class C16324 extends AbstractC2233fv implements InterfaceC0630Jp {
        final /* synthetic */ MovableContent<C2020dG> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16324(MovableContent<C2020dG> movableContent) {
            super(6);
            this.$movableContent = movableContent;
        }

        @Override // defpackage.InterfaceC0630Jp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            invoke(obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(R r, P1 p1, P2 p2, P3 p3, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(r) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p1) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p2) ? 256 : 128;
            }
            if ((i & 7168) == 0) {
                i2 |= composer.changed(p3) ? 2048 : 1024;
            }
            if ((i2 & 46811) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1468683306, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:256)");
            }
            composer.insertMovableContent(this.$movableContent, HV.a(HV.a(r, p1), HV.a(p2, p3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final InterfaceC0526Fp movableContentOf(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(-642339857, true, new AnonymousClass1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1079330685, true, new MovableContentKt$movableContentOf$movableContent$1(interfaceC0526Fp)))));
    }

    @ComposableInferredTarget(scheme = "[0[0]:[_]]")
    public static final <R> InterfaceC0552Gp movableContentWithReceiverOf(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(506997506, true, new C16291(new MovableContent(ComposableLambdaKt.composableLambdaInstance(250838178, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$1(interfaceC0552Gp)))));
    }

    public static final <P> InterfaceC0552Gp movableContentOf(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(-434707029, true, new AnonymousClass2(new MovableContent(interfaceC0552Gp)));
    }

    public static final <R, P> InterfaceC0578Hp movableContentWithReceiverOf(InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(interfaceC0578Hp, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(627354118, true, new C16302(new MovableContent(ComposableLambdaKt.composableLambdaInstance(812082854, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$2(interfaceC0578Hp)))));
    }

    public static final <P1, P2> InterfaceC0578Hp movableContentOf(InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(interfaceC0578Hp, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(-1200019734, true, new AnonymousClass3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1849814513, true, new MovableContentKt$movableContentOf$movableContent$2(interfaceC0578Hp)))));
    }

    public static final <R, P1, P2> InterfaceC0604Ip movableContentWithReceiverOf(InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(interfaceC0604Ip, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(583402949, true, new C16313(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1322148760, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$3(interfaceC0604Ip)))));
    }

    public static final <P1, P2, P3> InterfaceC0604Ip movableContentOf(InterfaceC0604Ip interfaceC0604Ip) {
        AbstractC4492zt.h(interfaceC0604Ip, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(-1083870185, true, new AnonymousClass4(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-284417101, true, new MovableContentKt$movableContentOf$movableContent$3(interfaceC0604Ip)))));
    }

    public static final <R, P1, P2, P3> InterfaceC0630Jp movableContentWithReceiverOf(InterfaceC0630Jp interfaceC0630Jp) {
        AbstractC4492zt.h(interfaceC0630Jp, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(1468683306, true, new C16324(new MovableContent(ComposableLambdaKt.composableLambdaInstance(838586922, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$4(interfaceC0630Jp)))));
    }

    public static final <P1, P2, P3, P4> InterfaceC0630Jp movableContentOf(InterfaceC0630Jp interfaceC0630Jp) {
        AbstractC4492zt.h(interfaceC0630Jp, Annotation.CONTENT);
        return ComposableLambdaKt.composableLambdaInstance(-1741877681, true, new AnonymousClass5(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1876318581, true, new MovableContentKt$movableContentOf$movableContent$4(interfaceC0630Jp)))));
    }
}
