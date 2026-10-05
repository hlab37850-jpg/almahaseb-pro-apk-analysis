package defpackage;

/* JADX INFO: renamed from: dc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2045dc0 extends IllegalArgumentException {
    public C2045dc0(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
