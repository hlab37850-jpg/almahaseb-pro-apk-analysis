package defpackage;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: eG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2101eG implements Map.Entry, Comparable, Serializable {
    public static AbstractC2101eG e(Object obj, Object obj2) {
        return new C4157vs(obj, obj2);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC2101eG abstractC2101eG) {
        return new C0904Sd().g(b(), abstractC2101eG.b()).g(c(), abstractC2101eG.c()).u();
    }

    public abstract Object b();

    public abstract Object c();

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return b();
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return c();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(b());
        sb.append(',');
        sb.append(c());
        sb.append(')');
        return sb.toString();
    }
}
