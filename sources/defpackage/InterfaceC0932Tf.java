package defpackage;

import java.util.List;

/* JADX INFO: renamed from: Tf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0932Tf {
    public static final a a = a.a;
    public static final InterfaceC0932Tf b = new a.C0018a();

    /* JADX INFO: renamed from: Tf$a */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: Tf$a$a, reason: collision with other inner class name */
        public static final class C0018a implements InterfaceC0932Tf {
            @Override // defpackage.InterfaceC0932Tf
            public void a(C0779Nr c0779Nr, List list) {
                AbstractC4492zt.h(c0779Nr, "url");
                AbstractC4492zt.h(list, "cookies");
            }

            @Override // defpackage.InterfaceC0932Tf
            public List b(C0779Nr c0779Nr) {
                AbstractC4492zt.h(c0779Nr, "url");
                return AbstractC1886cc.m();
            }
        }
    }

    void a(C0779Nr c0779Nr, List list);

    List b(C0779Nr c0779Nr);
}
