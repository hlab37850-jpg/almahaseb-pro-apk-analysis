package com.google.common.io;

import androidx.core.location.LocationRequestCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.C3320lb;
import defpackage.C3864sC;
import defpackage.C4195wJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class CharSource {

    public final class a extends ByteSource {
        public final Charset a;

        public a(Charset charset) {
            this.a = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            return charset.equals(this.a) ? CharSource.this : super.asCharSource(charset);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new C4195wJ(CharSource.this.openStream(), this.a, 8192);
        }

        public String toString() {
            String string = CharSource.this.toString();
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 15 + strValueOf.length());
            sb.append(string);
            sb.append(".asByteSource(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class b extends CharSource {
        public static final Splitter b = Splitter.onPattern("\r\n|\n|\r");
        public final CharSequence a;

        public class a extends AbstractIterator {
            public Iterator a;

            public a() {
                this.a = b.b.split(b.this.a).iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String computeNext() {
                if (this.a.hasNext()) {
                    String str = (String) this.a.next();
                    if (this.a.hasNext() || !str.isEmpty()) {
                        return str;
                    }
                }
                return (String) endOfData();
            }
        }

        public b(CharSequence charSequence) {
            this.a = (CharSequence) Preconditions.checkNotNull(charSequence);
        }

        public final Iterator b() {
            return new a();
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() {
            return this.a.length() == 0;
        }

        @Override // com.google.common.io.CharSource
        public long length() {
            return this.a.length();
        }

        @Override // com.google.common.io.CharSource
        public Optional lengthIfKnown() {
            return Optional.of(Long.valueOf(this.a.length()));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() {
            return new C3320lb(this.a);
        }

        @Override // com.google.common.io.CharSource
        public String read() {
            return this.a.toString();
        }

        @Override // com.google.common.io.CharSource
        public String readFirstLine() {
            Iterator itB = b();
            if (itB.hasNext()) {
                return (String) itB.next();
            }
            return null;
        }

        @Override // com.google.common.io.CharSource
        public ImmutableList readLines() {
            return ImmutableList.copyOf(b());
        }

        public String toString() {
            String strTruncate = Ascii.truncate(this.a, 30, "...");
            StringBuilder sb = new StringBuilder(String.valueOf(strTruncate).length() + 17);
            sb.append("CharSource.wrap(");
            sb.append(strTruncate);
            sb.append(")");
            return sb.toString();
        }

        @Override // com.google.common.io.CharSource
        public Object readLines(LineProcessor lineProcessor) {
            Iterator itB = b();
            while (itB.hasNext() && lineProcessor.processLine((String) itB.next())) {
            }
            return lineProcessor.getResult();
        }
    }

    public static final class c extends CharSource {
        public final Iterable a;

        public c(Iterable iterable) {
            this.a = (Iterable) Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                if (!((CharSource) it.next()).isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.CharSource
        public long length() {
            Iterator it = this.a.iterator();
            long length = 0;
            while (it.hasNext()) {
                length += ((CharSource) it.next()).length();
            }
            return length;
        }

        @Override // com.google.common.io.CharSource
        public Optional lengthIfKnown() {
            Iterator it = this.a.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                Optional<Long> optionalLengthIfKnown = ((CharSource) it.next()).lengthIfKnown();
                if (!optionalLengthIfKnown.isPresent()) {
                    return Optional.absent();
                }
                jLongValue += optionalLengthIfKnown.get().longValue();
            }
            return Optional.of(Long.valueOf(jLongValue));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() {
            return new C3864sC(this.a.iterator());
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
            sb.append("CharSource.concat(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class d extends e {
        public static final d c = new d();

        public d() {
            super("");
        }

        @Override // com.google.common.io.CharSource.b
        public String toString() {
            return "CharSource.empty()";
        }
    }

    public static CharSource concat(Iterable<? extends CharSource> iterable) {
        return new c(iterable);
    }

    private long countBySkipping(Reader reader) throws IOException {
        long j = 0;
        while (true) {
            long jSkip = reader.skip(LocationRequestCompat.PASSIVE_INTERVAL);
            if (jSkip == 0) {
                return j;
            }
            j += jSkip;
        }
    }

    public static CharSource empty() {
        return d.c;
    }

    public static CharSource wrap(CharSequence charSequence) {
        return charSequence instanceof String ? new e((String) charSequence) : new b(charSequence);
    }

    @Beta
    public ByteSource asByteSource(Charset charset) {
        return new a(charset);
    }

    @CanIgnoreReturnValue
    public long copyTo(Appendable appendable) {
        Preconditions.checkNotNull(appendable);
        Closer closerCreate = Closer.create();
        try {
            long jCopy = CharStreams.copy((Reader) closerCreate.register(openStream()), appendable);
            closerCreate.close();
            return jCopy;
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }

    public boolean isEmpty() {
        Optional<Long> optionalLengthIfKnown = lengthIfKnown();
        if (optionalLengthIfKnown.isPresent()) {
            return optionalLengthIfKnown.get().longValue() == 0;
        }
        Closer closerCreate = Closer.create();
        try {
            boolean z = ((Reader) closerCreate.register(openStream())).read() == -1;
            closerCreate.close();
            return z;
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }

    @Beta
    public long length() {
        Optional<Long> optionalLengthIfKnown = lengthIfKnown();
        if (optionalLengthIfKnown.isPresent()) {
            return optionalLengthIfKnown.get().longValue();
        }
        Closer closerCreate = Closer.create();
        try {
            long jCountBySkipping = countBySkipping((Reader) closerCreate.register(openStream()));
            closerCreate.close();
            return jCountBySkipping;
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }

    @Beta
    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    public BufferedReader openBufferedStream() {
        Reader readerOpenStream = openStream();
        return readerOpenStream instanceof BufferedReader ? (BufferedReader) readerOpenStream : new BufferedReader(readerOpenStream);
    }

    public abstract Reader openStream();

    public String read() {
        Closer closerCreate = Closer.create();
        try {
            String string = CharStreams.toString((Reader) closerCreate.register(openStream()));
            closerCreate.close();
            return string;
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }

    public String readFirstLine() {
        Closer closerCreate = Closer.create();
        try {
            String line = ((BufferedReader) closerCreate.register(openBufferedStream())).readLine();
            closerCreate.close();
            return line;
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }

    public ImmutableList<String> readLines() {
        Closer closerCreate = Closer.create();
        try {
            BufferedReader bufferedReader = (BufferedReader) closerCreate.register(openBufferedStream());
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf((Collection) arrayListNewArrayList);
                    closerCreate.close();
                    return immutableListCopyOf;
                }
                arrayListNewArrayList.add(line);
            }
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }

    public static class e extends b {
        public e(String str) {
            super(str);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(Appendable appendable) throws IOException {
            appendable.append(this.a);
            return this.a.length();
        }

        @Override // com.google.common.io.CharSource.b, com.google.common.io.CharSource
        public Reader openStream() {
            return new StringReader((String) this.a);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(CharSink charSink) {
            Preconditions.checkNotNull(charSink);
            Closer closerCreate = Closer.create();
            try {
                ((Writer) closerCreate.register(charSink.openStream())).write((String) this.a);
                long length = this.a.length();
                closerCreate.close();
                return length;
            } catch (Throwable th) {
                try {
                    throw closerCreate.rethrow(th);
                } catch (Throwable th2) {
                    closerCreate.close();
                    throw th2;
                }
            }
        }
    }

    public static CharSource concat(Iterator<? extends CharSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    public static CharSource concat(CharSource... charSourceArr) {
        return concat(ImmutableList.copyOf(charSourceArr));
    }

    @CanIgnoreReturnValue
    public long copyTo(CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        Closer closerCreate = Closer.create();
        try {
            long jCopy = CharStreams.copy((Reader) closerCreate.register(openStream()), (Writer) closerCreate.register(charSink.openStream()));
            closerCreate.close();
            return jCopy;
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public <T> T readLines(LineProcessor<T> lineProcessor) {
        Preconditions.checkNotNull(lineProcessor);
        Closer closerCreate = Closer.create();
        try {
            T t = (T) CharStreams.readLines((Reader) closerCreate.register(openStream()), lineProcessor);
            closerCreate.close();
            return t;
        } catch (Throwable th) {
            try {
                throw closerCreate.rethrow(th);
            } catch (Throwable th2) {
                closerCreate.close();
                throw th2;
            }
        }
    }
}
