package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0988Vf;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeApi
public interface SnapshotContextElement extends InterfaceC0988Vf.b {
    public static final Key Key = Key.$$INSTANCE;

    public static final class DefaultImpls {
        public static <R> R fold(SnapshotContextElement snapshotContextElement, R r, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
            return (R) InterfaceC0988Vf.b.a.a(snapshotContextElement, r, interfaceC0526Fp);
        }

        public static <E extends InterfaceC0988Vf.b> E get(SnapshotContextElement snapshotContextElement, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            return (E) InterfaceC0988Vf.b.a.b(snapshotContextElement, cVar);
        }

        public static InterfaceC0988Vf minusKey(SnapshotContextElement snapshotContextElement, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            return InterfaceC0988Vf.b.a.c(snapshotContextElement, cVar);
        }

        public static InterfaceC0988Vf plus(SnapshotContextElement snapshotContextElement, InterfaceC0988Vf interfaceC0988Vf) {
            AbstractC4492zt.h(interfaceC0988Vf, "context");
            return InterfaceC0988Vf.b.a.d(snapshotContextElement, interfaceC0988Vf);
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
    /* synthetic */ InterfaceC0988Vf.c getKey();

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar);

    @Override // defpackage.InterfaceC0988Vf
    /* synthetic */ InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf);
}
