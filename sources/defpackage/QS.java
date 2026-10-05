package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class QS extends ZO implements CR {
    public QS(int i) {
        super(1, Integer.MAX_VALUE, I8.DROP_OLDEST);
        f(Integer.valueOf(i));
    }

    @Override // defpackage.CR
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(((Number) L()).intValue());
        }
        return numValueOf;
    }

    public final boolean Z(int i) {
        boolean zF;
        synchronized (this) {
            zF = f(Integer.valueOf(((Number) L()).intValue() + i));
        }
        return zF;
    }
}
