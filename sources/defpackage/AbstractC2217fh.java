package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: fh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2217fh implements Comparable, Serializable {
    public final Comparable a;

    /* JADX INFO: renamed from: fh$a */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BoundType.values().length];
            a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: fh$b */
    public static final class b extends AbstractC2217fh {
        public static final b b = new b();

        public b() {
            super("");
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(AbstractC2217fh abstractC2217fh) {
            return abstractC2217fh == this ? 0 : 1;
        }

        @Override // defpackage.AbstractC2217fh
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // defpackage.AbstractC2217fh
        public void i(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // defpackage.AbstractC2217fh
        public void j(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable k() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable l(DiscreteDomain discreteDomain) {
            return discreteDomain.maxValue();
        }

        @Override // defpackage.AbstractC2217fh
        public boolean m(Comparable comparable) {
            return false;
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable n(DiscreteDomain discreteDomain) {
            throw new AssertionError();
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType o() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType p() {
            throw new IllegalStateException();
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh q(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh r(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new IllegalStateException();
        }

        public String toString() {
            return "+∞";
        }
    }

    /* JADX INFO: renamed from: fh$c */
    public static final class c extends AbstractC2217fh {
        public c(Comparable comparable) {
            super((Comparable) Preconditions.checkNotNull(comparable));
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((AbstractC2217fh) obj);
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh f(DiscreteDomain discreteDomain) {
            Comparable comparableN = n(discreteDomain);
            return comparableN != null ? AbstractC2217fh.e(comparableN) : AbstractC2217fh.a();
        }

        @Override // defpackage.AbstractC2217fh
        public int hashCode() {
            return ~this.a.hashCode();
        }

        @Override // defpackage.AbstractC2217fh
        public void i(StringBuilder sb) {
            sb.append('(');
            sb.append(this.a);
        }

        @Override // defpackage.AbstractC2217fh
        public void j(StringBuilder sb) {
            sb.append(this.a);
            sb.append(']');
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable l(DiscreteDomain discreteDomain) {
            return this.a;
        }

        @Override // defpackage.AbstractC2217fh
        public boolean m(Comparable comparable) {
            return Range.compareOrThrow(this.a, comparable) < 0;
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable n(DiscreteDomain discreteDomain) {
            return discreteDomain.next(this.a);
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType o() {
            return BoundType.OPEN;
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType p() {
            return BoundType.CLOSED;
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh q(BoundType boundType, DiscreteDomain discreteDomain) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                Comparable next = discreteDomain.next(this.a);
                return next == null ? AbstractC2217fh.c() : AbstractC2217fh.e(next);
            }
            if (i == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh r(BoundType boundType, DiscreteDomain discreteDomain) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new AssertionError();
            }
            Comparable next = discreteDomain.next(this.a);
            return next == null ? AbstractC2217fh.a() : AbstractC2217fh.e(next);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 2);
            sb.append("/");
            sb.append(strValueOf);
            sb.append("\\");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: fh$d */
    public static final class d extends AbstractC2217fh {
        public static final d b = new d();

        public d() {
            super("");
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh f(DiscreteDomain discreteDomain) {
            try {
                return AbstractC2217fh.e(discreteDomain.minValue());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h */
        public int compareTo(AbstractC2217fh abstractC2217fh) {
            return abstractC2217fh == this ? 0 : -1;
        }

        @Override // defpackage.AbstractC2217fh
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // defpackage.AbstractC2217fh
        public void i(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // defpackage.AbstractC2217fh
        public void j(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable k() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable l(DiscreteDomain discreteDomain) {
            throw new AssertionError();
        }

        @Override // defpackage.AbstractC2217fh
        public boolean m(Comparable comparable) {
            return true;
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable n(DiscreteDomain discreteDomain) {
            return discreteDomain.minValue();
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType o() {
            throw new IllegalStateException();
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType p() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh q(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh r(BoundType boundType, DiscreteDomain discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        public String toString() {
            return "-∞";
        }
    }

    /* JADX INFO: renamed from: fh$e */
    public static final class e extends AbstractC2217fh {
        public e(Comparable comparable) {
            super((Comparable) Preconditions.checkNotNull(comparable));
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((AbstractC2217fh) obj);
        }

        @Override // defpackage.AbstractC2217fh
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // defpackage.AbstractC2217fh
        public void i(StringBuilder sb) {
            sb.append('[');
            sb.append(this.a);
        }

        @Override // defpackage.AbstractC2217fh
        public void j(StringBuilder sb) {
            sb.append(this.a);
            sb.append(')');
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable l(DiscreteDomain discreteDomain) {
            return discreteDomain.previous(this.a);
        }

        @Override // defpackage.AbstractC2217fh
        public boolean m(Comparable comparable) {
            return Range.compareOrThrow(this.a, comparable) <= 0;
        }

        @Override // defpackage.AbstractC2217fh
        public Comparable n(DiscreteDomain discreteDomain) {
            return this.a;
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType o() {
            return BoundType.CLOSED;
        }

        @Override // defpackage.AbstractC2217fh
        public BoundType p() {
            return BoundType.OPEN;
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh q(BoundType boundType, DiscreteDomain discreteDomain) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i != 2) {
                throw new AssertionError();
            }
            Comparable comparablePrevious = discreteDomain.previous(this.a);
            return comparablePrevious == null ? AbstractC2217fh.c() : new c(comparablePrevious);
        }

        @Override // defpackage.AbstractC2217fh
        public AbstractC2217fh r(BoundType boundType, DiscreteDomain discreteDomain) {
            int i = a.a[boundType.ordinal()];
            if (i == 1) {
                Comparable comparablePrevious = discreteDomain.previous(this.a);
                return comparablePrevious == null ? AbstractC2217fh.a() : new c(comparablePrevious);
            }
            if (i == 2) {
                return this;
            }
            throw new AssertionError();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 2);
            sb.append("\\");
            sb.append(strValueOf);
            sb.append("/");
            return sb.toString();
        }
    }

    public AbstractC2217fh(Comparable comparable) {
        this.a = comparable;
    }

    public static AbstractC2217fh a() {
        return b.b;
    }

    public static AbstractC2217fh b(Comparable comparable) {
        return new c(comparable);
    }

    public static AbstractC2217fh c() {
        return d.b;
    }

    public static AbstractC2217fh e(Comparable comparable) {
        return new e(comparable);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractC2217fh)) {
            return false;
        }
        try {
            return compareTo((AbstractC2217fh) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: h */
    public int compareTo(AbstractC2217fh abstractC2217fh) {
        if (abstractC2217fh == c()) {
            return 1;
        }
        if (abstractC2217fh == a()) {
            return -1;
        }
        int iCompareOrThrow = Range.compareOrThrow(this.a, abstractC2217fh.a);
        return iCompareOrThrow != 0 ? iCompareOrThrow : Booleans.compare(this instanceof c, abstractC2217fh instanceof c);
    }

    public abstract int hashCode();

    public abstract void i(StringBuilder sb);

    public abstract void j(StringBuilder sb);

    public Comparable k() {
        return this.a;
    }

    public abstract Comparable l(DiscreteDomain discreteDomain);

    public abstract boolean m(Comparable comparable);

    public abstract Comparable n(DiscreteDomain discreteDomain);

    public abstract BoundType o();

    public abstract BoundType p();

    public abstract AbstractC2217fh q(BoundType boundType, DiscreteDomain discreteDomain);

    public abstract AbstractC2217fh r(BoundType boundType, DiscreteDomain discreteDomain);

    public AbstractC2217fh f(DiscreteDomain discreteDomain) {
        return this;
    }
}
