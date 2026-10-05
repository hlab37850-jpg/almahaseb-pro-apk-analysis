package defpackage;

import com.google.android.gms.internal.auth.zzeo;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: ed0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2128ed0 extends AbstractC3734qd0 {
    public C2128ed0(int i) {
        super(i, null);
    }

    @Override // defpackage.AbstractC3734qd0
    public final void a() {
        if (!k()) {
            for (int i = 0; i < b(); i++) {
                Map.Entry entryG = g(i);
                if (((zzeo) entryG.getKey()).zzc()) {
                    entryG.setValue(Collections.unmodifiableList((List) entryG.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((zzeo) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
