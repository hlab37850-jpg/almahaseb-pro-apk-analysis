package defpackage;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NH {
    public static final String a = "NH";

    public class a implements Comparator {
        public final /* synthetic */ NQ a;

        public a(NQ nq) {
            this.a = nq;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(NQ nq, NQ nq2) {
            return Float.compare(NH.this.c(nq2, this.a), NH.this.c(nq, this.a));
        }
    }

    public List a(List list, NQ nq) {
        if (nq == null) {
            return list;
        }
        Collections.sort(list, new a(nq));
        return list;
    }

    public NQ b(List list, NQ nq) {
        List listA = a(list, nq);
        String str = a;
        Log.i(str, "Viewfinder size: " + nq);
        Log.i(str, "Preview in order of preference: " + listA);
        return (NQ) listA.get(0);
    }

    public abstract float c(NQ nq, NQ nq2);

    public abstract Rect d(NQ nq, NQ nq2);
}
