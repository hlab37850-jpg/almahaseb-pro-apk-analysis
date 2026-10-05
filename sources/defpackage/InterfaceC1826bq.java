package defpackage;

/* JADX INFO: renamed from: bq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC1826bq extends InterfaceC0939Tm {

    /* JADX INFO: renamed from: bq$a */
    public static final class a {
        public static /* synthetic */ InterfaceC0939Tm a(InterfaceC1826bq interfaceC1826bq, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i2 & 1) != 0) {
                interfaceC0988Vf = C1172Zk.a;
            }
            if ((i2 & 2) != 0) {
                i = -3;
            }
            if ((i2 & 4) != 0) {
                i8 = I8.SUSPEND;
            }
            return interfaceC1826bq.a(interfaceC0988Vf, i, i8);
        }
    }

    InterfaceC0939Tm a(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8);
}
