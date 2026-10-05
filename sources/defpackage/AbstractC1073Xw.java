package defpackage;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: Xw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1073Xw {
    public static final Supplier a;

    /* JADX INFO: renamed from: Xw$a */
    public class a implements Supplier {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC0979Uw get() {
            return new C1099Yw();
        }
    }

    /* JADX INFO: renamed from: Xw$b */
    public class b implements Supplier {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC0979Uw get() {
            return new c(null);
        }
    }

    /* JADX INFO: renamed from: Xw$c */
    public static final class c extends AtomicLong implements InterfaceC0979Uw {
        public c() {
        }

        @Override // defpackage.InterfaceC0979Uw
        public void a() {
            getAndIncrement();
        }

        @Override // defpackage.InterfaceC0979Uw
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // defpackage.InterfaceC0979Uw
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
            new C1099Yw();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        a = bVar;
    }

    public static InterfaceC0979Uw a() {
        return (InterfaceC0979Uw) a.get();
    }
}
