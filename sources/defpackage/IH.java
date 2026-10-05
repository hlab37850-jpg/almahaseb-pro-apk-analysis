package defpackage;

import com.google.api.client.repackaged.com.google.common.base.Function;
import com.google.api.client.repackaged.com.google.common.base.Optional;
import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import com.google.api.client.repackaged.com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class IH extends Optional {
    public final Object a;

    public IH(Object obj) {
        this.a = obj;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Set asSet() {
        return Collections.singleton(this.a);
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof IH) {
            return this.a.equals(((IH) obj).a);
        }
        return false;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object get() {
        return this.a;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object or(Object obj) {
        Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.a;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object orNull() {
        return this.a;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.a + ")";
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Optional transform(Function function) {
        return new IH(Preconditions.checkNotNull(function.apply(this.a), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Optional or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.a;
    }
}
