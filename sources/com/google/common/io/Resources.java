package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class Resources {

    public class a implements LineProcessor {
        public final List a = Lists.newArrayList();

        @Override // com.google.common.io.LineProcessor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List getResult() {
            return this.a;
        }

        @Override // com.google.common.io.LineProcessor
        public boolean processLine(String str) {
            this.a.add(str);
            return true;
        }
    }

    public static final class b extends ByteSource {
        public final URL a;

        public /* synthetic */ b(URL url, a aVar) {
            this(url);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return this.a.openStream();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("Resources.asByteSource(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }

        public b(URL url) {
            this.a = (URL) Preconditions.checkNotNull(url);
        }
    }

    private Resources() {
    }

    public static ByteSource asByteSource(URL url) {
        return new b(url, null);
    }

    public static CharSource asCharSource(URL url, Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }

    public static void copy(URL url, OutputStream outputStream) {
        asByteSource(url).copyTo(outputStream);
    }

    @CanIgnoreReturnValue
    public static URL getResource(String str) {
        URL resource = ((ClassLoader) MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s not found.", str);
        return resource;
    }

    @CanIgnoreReturnValue
    public static <T> T readLines(URL url, Charset charset, LineProcessor<T> lineProcessor) {
        return (T) asCharSource(url, charset).readLines(lineProcessor);
    }

    public static byte[] toByteArray(URL url) {
        return asByteSource(url).read();
    }

    public static String toString(URL url, Charset charset) {
        return asCharSource(url, charset).read();
    }

    public static List<String> readLines(URL url, Charset charset) {
        return (List) readLines(url, charset, new a());
    }

    @CanIgnoreReturnValue
    public static URL getResource(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }
}
