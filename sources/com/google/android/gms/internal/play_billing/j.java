package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends h {
    public /* synthetic */ j(zzco zzcoVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final f a(m mVar, f fVar) {
        f fVar2;
        synchronized (mVar) {
            try {
                fVar2 = mVar.listenersField;
                if (fVar2 != fVar) {
                    mVar.listenersField = fVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final l b(m mVar, l lVar) {
        l lVar2;
        synchronized (mVar) {
            try {
                lVar2 = mVar.waitersField;
                if (lVar2 != lVar) {
                    mVar.waitersField = lVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final void c(l lVar, l lVar2) {
        lVar.b = lVar2;
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final void d(l lVar, Thread thread) {
        lVar.a = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean e(m mVar, f fVar, f fVar2) {
        synchronized (mVar) {
            try {
                if (mVar.listenersField != fVar) {
                    return false;
                }
                mVar.listenersField = fVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean f(m mVar, Object obj, Object obj2) {
        synchronized (mVar) {
            try {
                if (mVar.valueField != obj) {
                    return false;
                }
                mVar.valueField = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean g(m mVar, l lVar, l lVar2) {
        synchronized (mVar) {
            try {
                if (mVar.waitersField != lVar) {
                    return false;
                }
                mVar.waitersField = lVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
