package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0988Vf;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MotionDurationScale extends InterfaceC0988Vf.b {
    public static final Key Key = Key.$$INSTANCE;

    public static final class DefaultImpls {
        public static <R> R fold(MotionDurationScale motionDurationScale, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) InterfaceC0988Vf.b.a.a(motionDurationScale, r, interfaceC0526Fp);
        }

        public static <E extends InterfaceC0988Vf.b> E get(MotionDurationScale motionDurationScale, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            return (E) InterfaceC0988Vf.b.a.b(motionDurationScale, cVar);
        }

        public static InterfaceC0988Vf minusKey(MotionDurationScale motionDurationScale, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            return InterfaceC0988Vf.b.a.c(motionDurationScale, cVar);
        }

        public static InterfaceC0988Vf plus(MotionDurationScale motionDurationScale, InterfaceC0988Vf interfaceC0988Vf) {
            AbstractC4492zt.h(interfaceC0988Vf, "context");
            return InterfaceC0988Vf.b.a.d(motionDurationScale, interfaceC0988Vf);
        }
    }

    public static final class Key implements InterfaceC0988Vf.c {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ Object fold(Object obj, InterfaceC0526Fp interfaceC0526Fp);

    @Override // defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf.b get(InterfaceC0988Vf.c cVar);

    @Override // defpackage.InterfaceC0988Vf.b
    InterfaceC0988Vf.c getKey();

    float getScaleFactor();

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar);

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf);
}
