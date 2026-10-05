package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class JO extends AbstractC3990tn {
    public final AbstractC3990tn b;
    public boolean c;
    public M4 d;
    public volatile boolean e;

    public JO(AbstractC3990tn abstractC3990tn) {
        this.b = abstractC3990tn;
    }

    @Override // defpackage.NS, defpackage.InterfaceC4071un
    public void a(PS ps) {
        boolean z = true;
        if (!this.e) {
            synchronized (this) {
                try {
                    if (!this.e) {
                        if (this.c) {
                            M4 m4 = this.d;
                            if (m4 == null) {
                                m4 = new M4(4);
                                this.d = m4;
                            }
                            m4.b(QD.f(ps));
                            return;
                        }
                        this.c = true;
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            ps.cancel();
        } else {
            this.b.a(ps);
            p();
        }
    }

    @Override // defpackage.NS
    public void b(Object obj) {
        if (this.e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                if (!this.c) {
                    this.c = true;
                    this.b.b(obj);
                    p();
                } else {
                    M4 m4 = this.d;
                    if (m4 == null) {
                        m4 = new M4(4);
                        this.d = m4;
                    }
                    m4.b(QD.e(obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.AbstractC3258kn
    public void n(NS ns) {
        this.b.c(ns);
    }

    @Override // defpackage.NS
    public void onComplete() {
        if (this.e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                this.e = true;
                if (!this.c) {
                    this.c = true;
                    this.b.onComplete();
                    return;
                }
                M4 m4 = this.d;
                if (m4 == null) {
                    m4 = new M4(4);
                    this.d = m4;
                }
                m4.b(QD.b());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.NS
    public void onError(Throwable th) {
        if (this.e) {
            FM.m(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.e) {
                    this.e = true;
                    if (this.c) {
                        M4 m4 = this.d;
                        if (m4 == null) {
                            m4 = new M4(4);
                            this.d = m4;
                        }
                        m4.c(QD.c(th));
                        return;
                    }
                    this.c = true;
                    z = false;
                }
                if (z) {
                    FM.m(th);
                } else {
                    this.b.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void p() {
        M4 m4;
        while (true) {
            synchronized (this) {
                try {
                    m4 = this.d;
                    if (m4 == null) {
                        this.c = false;
                        return;
                    }
                    this.d = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            m4.a(this.b);
        }
    }
}
