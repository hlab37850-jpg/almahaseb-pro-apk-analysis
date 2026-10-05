package defpackage;

import com.google.android.gms.internal.vision.zziw;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: ng0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3495ng0 extends AbstractC3577og0 {
    public C3495ng0(int i) {
        super(i, null);
    }

    @Override // defpackage.AbstractC3577og0
    public final void e() {
        if (!j()) {
            for (int i = 0; i < k(); i++) {
                Map.Entry entryH = h(i);
                if (((zziw) entryH.getKey()).zzd()) {
                    entryH.setValue(Collections.unmodifiableList((List) entryH.getValue()));
                }
            }
            for (Map.Entry entry : n()) {
                if (((zziw) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.e();
    }
}
