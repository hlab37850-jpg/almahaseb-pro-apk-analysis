package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class VE extends RU {
    public final UE b;

    public VE(UE ue) {
        super(2);
        if (ue == null) {
            throw new IllegalArgumentException("Operator is unknown for token.");
        }
        this.b = ue;
    }

    public UE b() {
        return this.b;
    }
}
