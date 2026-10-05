package defpackage;

import com.google.common.collect.Ordering;
import java.io.Serializable;

/* JADX INFO: renamed from: fX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2200fX extends Ordering implements Serializable {
    public static final C2200fX a = new C2200fX();

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}
