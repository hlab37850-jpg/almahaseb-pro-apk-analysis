package defpackage;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: eP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2110eP {
    public static final a a = a.a;

    /* JADX INFO: renamed from: eP$a */
    public static final class a {
        public static final /* synthetic */ a a = new a();
        public static final InterfaceC2110eP b = new C4456zR();
        public static final InterfaceC2110eP c = new AR();

        public static /* synthetic */ InterfaceC2110eP b(a aVar, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            if ((i & 2) != 0) {
                j2 = LocationRequestCompat.PASSIVE_INTERVAL;
            }
            return aVar.a(j, j2);
        }

        public final InterfaceC2110eP a(long j, long j2) {
            return new BR(j, j2);
        }

        public final InterfaceC2110eP c() {
            return b;
        }

        public final InterfaceC2110eP d() {
            return c;
        }
    }

    InterfaceC0939Tm a(CR cr);
}
