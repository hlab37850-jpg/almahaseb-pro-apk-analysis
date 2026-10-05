package defpackage;

import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: renamed from: sx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3919sx extends C3838rx {
    public volatile transient a c;
    public volatile transient a d;

    /* JADX INFO: renamed from: sx$a */
    public static final class a {
        public final Object a;
        public final Object b;

        public a(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }
    }

    public C3919sx(Map map) {
        super(map);
    }

    @Override // defpackage.C3838rx
    public void c() {
        super.c();
        this.c = null;
        this.d = null;
    }

    @Override // defpackage.C3838rx
    public Object e(Object obj) {
        Preconditions.checkNotNull(obj);
        Object objF = f(obj);
        if (objF != null) {
            return objF;
        }
        Object objG = g(obj);
        if (objG != null) {
            l(obj, objG);
        }
        return objG;
    }

    @Override // defpackage.C3838rx
    public Object f(Object obj) {
        Object objF = super.f(obj);
        if (objF != null) {
            return objF;
        }
        a aVar = this.c;
        if (aVar != null && aVar.a == obj) {
            return aVar.b;
        }
        a aVar2 = this.d;
        if (aVar2 == null || aVar2.a != obj) {
            return null;
        }
        k(aVar2);
        return aVar2.b;
    }

    public final void k(a aVar) {
        this.d = this.c;
        this.c = aVar;
    }

    public final void l(Object obj, Object obj2) {
        k(new a(obj, obj2));
    }
}
