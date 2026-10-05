package defpackage;

import com.google.android.gms.internal.play_billing.zzey;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: ud0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4057ud0 extends Sd0 {
    public C4057ud0() {
        super(null);
    }

    @Override // defpackage.Sd0
    public final void a() {
        if (!k()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry entryG = g(i);
                if (((zzey) ((C4300xd0) entryG).a()).zze()) {
                    entryG.setValue(Collections.unmodifiableList((List) entryG.getValue()));
                }
            }
            for (Map.Entry entry : d()) {
                if (((zzey) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
