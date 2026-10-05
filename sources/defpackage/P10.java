package defpackage;

import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.api.internal.zabi;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P10 {
    public final zabf a;

    public P10(zabf zabfVar) {
        this.a = zabfVar;
    }

    public abstract void a();

    public final void b(zabi zabiVar) {
        zabiVar.zai.lock();
        try {
            if (zabiVar.zan == this.a) {
                a();
            }
        } finally {
            zabiVar.zai.unlock();
        }
    }
}
