package defpackage;

/* JADX INFO: renamed from: Pb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0815Pb {

    /* JADX INFO: renamed from: Pb$a */
    public static final class a {
        public static boolean a(InterfaceC0815Pb interfaceC0815Pb, Comparable comparable) {
            AbstractC4492zt.h(comparable, "value");
            return comparable.compareTo(interfaceC0815Pb.getStart()) >= 0 && comparable.compareTo(interfaceC0815Pb.getEndInclusive()) <= 0;
        }

        public static boolean b(InterfaceC0815Pb interfaceC0815Pb) {
            return interfaceC0815Pb.getStart().compareTo(interfaceC0815Pb.getEndInclusive()) > 0;
        }
    }

    Comparable getEndInclusive();

    Comparable getStart();

    boolean isEmpty();
}
