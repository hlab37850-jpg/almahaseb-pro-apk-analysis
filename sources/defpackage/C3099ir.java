package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3099ir {
    public static boolean b = false;
    public static ArrayList c = new ArrayList();
    public Object a;

    public C3099ir(Object obj) {
        this.a = obj;
        c.add(this);
    }

    public static void b() {
        ArrayList arrayList = c;
        c = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C3099ir) it.next()).a();
        }
        arrayList.clear();
    }

    public void a() {
        this.a = null;
    }

    public Object c() {
        return this.a;
    }
}
