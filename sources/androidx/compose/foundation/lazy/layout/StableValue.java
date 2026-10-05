package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class StableValue<T> {
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ StableValue(Object obj) {
        this.value = obj;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StableValue m645boximpl(Object obj) {
        return new StableValue(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m646constructorimpl(T t) {
        return t;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m647equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof StableValue) && AbstractC4492zt.d(obj, ((StableValue) obj2).m651unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m648equalsimpl0(Object obj, Object obj2) {
        return AbstractC4492zt.d(obj, obj2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m649hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m650toStringimpl(Object obj) {
        return "StableValue(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m647equalsimpl(this.value, obj);
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        return m649hashCodeimpl(this.value);
    }

    public String toString() {
        return m650toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m651unboximpl() {
        return this.value;
    }
}
