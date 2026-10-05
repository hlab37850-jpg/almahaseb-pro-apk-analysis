package defpackage;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: Ww, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1031Ww {
    public static final Supplier a;

    /* JADX INFO: renamed from: Ww$a */
    public class a implements Supplier {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC1005Vw get() {
            return new C1184Zw();
        }
    }

    /* JADX INFO: renamed from: Ww$b */
    public class b implements Supplier {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC1005Vw get() {
            return new c(null);
        }
    }

    /* JADX INFO: renamed from: Ww$c */
    public static final class c extends AtomicLong implements InterfaceC1005Vw {
        public c() {
        }

        @Override // defpackage.InterfaceC1005Vw
        public void a() {
            getAndIncrement();
        }

        @Override // defpackage.InterfaceC1005Vw
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // defpackage.InterfaceC1005Vw
        public long b() {
            return get();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        Supplier bVar;
        try {
            new C1184Zw();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        a = bVar;
    }

    public static InterfaceC1005Vw a() {
        return (InterfaceC1005Vw) a.get();
    }
}
