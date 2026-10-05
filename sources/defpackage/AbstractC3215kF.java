package defpackage;

import android.graphics.RectF;

/* JADX INFO: renamed from: kF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3215kF {
    public abstract RectF a(JF jf);

    public String toString() {
        String name = getClass().getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf >= 0 ? name.substring(iLastIndexOf + 1) : name;
    }
}
