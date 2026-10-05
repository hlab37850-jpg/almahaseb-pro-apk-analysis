package defpackage;

/* JADX INFO: renamed from: Tn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0940Tn implements InterfaceC3309lR {
    public final InterfaceC3309lR a;

    public AbstractC0940Tn(InterfaceC3309lR interfaceC3309lR) {
        AbstractC4492zt.h(interfaceC3309lR, "delegate");
        this.a = interfaceC3309lR;
    }

    @Override // defpackage.InterfaceC3309lR
    public JU b() {
        return this.a.b();
    }

    public final InterfaceC3309lR c() {
        return this.a;
    }

    @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.a + ')';
    }
}
