package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CE {

    public static class a implements b {
        public final /* synthetic */ AbstractC0963Uk a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbstractC0963Uk.a c;

        public a(AbstractC0963Uk abstractC0963Uk, String str, AbstractC0963Uk.a aVar) {
            this.a = abstractC0963Uk;
            this.b = str;
            this.c = aVar;
        }

        @Override // CE.b
        public void destroy() {
            this.a.d(this.b, this.c);
        }
    }

    public interface b {
        void destroy();
    }

    public static b a(AbstractC0963Uk abstractC0963Uk, String str, AbstractC0963Uk.a aVar) {
        abstractC0963Uk.e(str, aVar);
        return new a(abstractC0963Uk, str, aVar);
    }
}
