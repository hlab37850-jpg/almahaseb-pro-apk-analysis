package defpackage;

import com.google.android.gms.internal.clearcut.zzca;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: bb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1804bb0 extends Za0 {
    public C1804bb0(int i) {
        super(i, null);
    }

    @Override // defpackage.Za0
    public final void r() {
        if (!a()) {
            for (int i = 0; i < m(); i++) {
                Map.Entry entryG = g(i);
                if (((zzca) entryG.getKey()).zzaw()) {
                    entryG.setValue(Collections.unmodifiableList((List) entryG.getValue()));
                }
            }
            for (Map.Entry entry : n()) {
                if (((zzca) entry.getKey()).zzaw()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.r();
    }
}
