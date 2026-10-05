package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: ms, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3427ms extends Y implements Serializable {
    public final Object a;
    public final Object b;

    public C3427ms(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    @Override // defpackage.Y, java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // defpackage.Y, java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // defpackage.Y, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
