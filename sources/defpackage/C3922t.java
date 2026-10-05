package defpackage;

import com.google.api.client.repackaged.com.google.common.base.Function;
import com.google.api.client.repackaged.com.google.common.base.Optional;
import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import com.google.api.client.repackaged.com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: renamed from: t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3922t extends Optional {
    public static final C3922t a = new C3922t();

    public static Optional a() {
        return a;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Set asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public int hashCode() {
        return 1502476572;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object or(Object obj) {
        return Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object orNull() {
        return null;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Optional transform(Function function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Optional or(Optional optional) {
        return (Optional) Preconditions.checkNotNull(optional);
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.Optional
    public Object or(Supplier supplier) {
        return Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
