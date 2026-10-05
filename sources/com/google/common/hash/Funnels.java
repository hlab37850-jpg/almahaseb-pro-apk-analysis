package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class Funnels {

    public enum a implements Funnel {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void funnel(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.putBytes(bArr);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    public enum b implements Funnel {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void funnel(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.putInt(num.intValue());
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    public enum c implements Funnel {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void funnel(Long l, PrimitiveSink primitiveSink) {
            primitiveSink.putLong(l.longValue());
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    public static class d implements Funnel, Serializable {
        public final Funnel a;

        public d(Funnel funnel) {
            this.a = (Funnel) Preconditions.checkNotNull(funnel);
        }

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void funnel(Iterable iterable, PrimitiveSink primitiveSink) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                this.a.funnel(it.next(), primitiveSink);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return d.class.hashCode() ^ this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 26);
            sb.append("Funnels.sequentialFunnel(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class e extends OutputStream {
        public final PrimitiveSink a;

        public e(PrimitiveSink primitiveSink) {
            this.a = (PrimitiveSink) Preconditions.checkNotNull(primitiveSink);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("Funnels.asOutputStream(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.a.putByte((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.a.putBytes(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.a.putBytes(bArr, i, i2);
        }
    }

    public static class f implements Funnel, Serializable {
        public final Charset a;

        public f(Charset charset) {
            this.a = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putString(charSequence, this.a);
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.a.equals(((f) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return f.class.hashCode() ^ this.a.hashCode();
        }

        public String toString() {
            String strName = this.a.name();
            StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 22);
            sb.append("Funnels.stringFunnel(");
            sb.append(strName);
            sb.append(")");
            return sb.toString();
        }
    }

    public enum g implements Funnel {
        INSTANCE;

        @Override // com.google.common.hash.Funnel
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putUnencodedChars(charSequence);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    private Funnels() {
    }

    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        return new e(primitiveSink);
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return a.INSTANCE;
    }

    public static Funnel<Integer> integerFunnel() {
        return b.INSTANCE;
    }

    public static Funnel<Long> longFunnel() {
        return c.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> funnel) {
        return new d(funnel);
    }

    public static Funnel<CharSequence> stringFunnel(Charset charset) {
        return new f(charset);
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return g.INSTANCE;
    }
}
