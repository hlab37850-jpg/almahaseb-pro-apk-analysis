package defpackage;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3842s0 implements InterfaceC3459nD {
    public final Map a;

    public AbstractC3842s0(Map map) {
        this.a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // defpackage.InterfaceC3459nD
    public Set b() {
        return a();
    }

    @Override // defpackage.InterfaceC3459nD
    public Set c() {
        return a();
    }

    @Override // defpackage.InterfaceC3459nD
    public Object d(Object obj, boolean z) {
        if (z) {
            return null;
        }
        return h(obj);
    }

    @Override // defpackage.InterfaceC3459nD
    public Set e() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // defpackage.InterfaceC3459nD
    public Object f(Object obj) {
        Object obj2 = this.a.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }

    @Override // defpackage.InterfaceC3459nD
    public Set g() {
        return e();
    }

    @Override // defpackage.InterfaceC3459nD
    public Object h(Object obj) {
        Object objRemove = this.a.remove(obj);
        Objects.requireNonNull(objRemove);
        return objRemove;
    }

    @Override // defpackage.InterfaceC3459nD
    public Set i() {
        return e();
    }

    @Override // defpackage.InterfaceC3459nD
    public void j(Object obj, Object obj2) {
        Preconditions.checkState(this.a.put(obj, obj2) == null);
    }

    @Override // defpackage.InterfaceC3459nD
    public void l(Object obj, Object obj2, boolean z) {
        if (z) {
            return;
        }
        j(obj, obj2);
    }
}
