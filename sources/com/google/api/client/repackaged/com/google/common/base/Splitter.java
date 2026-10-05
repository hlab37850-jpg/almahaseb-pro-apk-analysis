package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import defpackage.S;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(emulated = true)
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final g strategy;
    private final CharMatcher trimmer;

    @Beta
    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        public /* synthetic */ MapSplitter(Splitter splitter, Splitter splitter2, a aVar) {
            this(splitter, splitter2);
        }

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.outerSplitter.split(charSequence)) {
                Iterator itSplittingIterator = this.entrySplitter.splittingIterator(str);
                Preconditions.checkArgument(itSplittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                String str2 = (String) itSplittingIterator.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(itSplittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
                linkedHashMap.put(str2, (String) itSplittingIterator.next());
                Preconditions.checkArgument(!itSplittingIterator.hasNext(), INVALID_ENTRY_MESSAGE, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(splitter2);
        }
    }

    public static class a implements g {
        public final /* synthetic */ CharMatcher a;

        /* JADX INFO: renamed from: com.google.api.client.repackaged.com.google.common.base.Splitter$a$a, reason: collision with other inner class name */
        public class C0200a extends f {
            public C0200a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int e(int i) {
                return i + 1;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int f(int i) {
                return a.this.a.indexIn(this.c, i);
            }
        }

        public a(CharMatcher charMatcher) {
            this.a = charMatcher;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Splitter splitter, CharSequence charSequence) {
            return new C0200a(splitter, charSequence);
        }
    }

    public static class b implements g {
        public final /* synthetic */ String a;

        public class a extends f {
            public a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int e(int i) {
                return i + b.this.a.length();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int f(int i) {
                int length = b.this.a.length();
                int length2 = this.c.length() - length;
                while (i <= length2) {
                    for (int i2 = 0; i2 < length; i2++) {
                        if (this.c.charAt(i2 + i) != b.this.a.charAt(i2)) {
                            i++;
                        }
                    }
                    return i;
                }
                return -1;
            }
        }

        public b(String str) {
            this.a = str;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }
    }

    public static class c implements g {
        public final /* synthetic */ Pattern a;

        public class a extends f {
            public final /* synthetic */ Matcher h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Splitter splitter, CharSequence charSequence, Matcher matcher) {
                super(splitter, charSequence);
                this.h = matcher;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int e(int i) {
                return this.h.end();
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int f(int i) {
                if (this.h.find(i)) {
                    return this.h.start();
                }
                return -1;
            }
        }

        public c(Pattern pattern) {
            this.a = pattern;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence, this.a.matcher(charSequence));
        }
    }

    public static class d implements g {
        public final /* synthetic */ int a;

        public class a extends f {
            public a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int e(int i) {
                return i;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.f
            public int f(int i) {
                int i2 = i + d.this.a;
                if (i2 < this.c.length()) {
                    return i2;
                }
                return -1;
            }
        }

        public d(int i) {
            this.a = i;
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }
    }

    public class e implements Iterable {
        public final /* synthetic */ CharSequence a;

        public e(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Splitter.this.splittingIterator(this.a);
        }

        public String toString() {
            Joiner joinerOn = Joiner.on(", ");
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            StringBuilder sbAppendTo = joinerOn.appendTo(sb, (Iterable<?>) this);
            sbAppendTo.append(']');
            return sbAppendTo.toString();
        }
    }

    public static abstract class f extends S {
        public final CharSequence c;
        public final CharMatcher d;
        public final boolean e;
        public int f = 0;
        public int g;

        public f(Splitter splitter, CharSequence charSequence) {
            this.d = splitter.trimmer;
            this.e = splitter.omitEmptyStrings;
            this.g = splitter.limit;
            this.c = charSequence;
        }

        @Override // defpackage.S
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int i = this.f;
            while (true) {
                int i2 = this.f;
                if (i2 == -1) {
                    return (String) b();
                }
                int iF = f(i2);
                if (iF == -1) {
                    iF = this.c.length();
                    this.f = -1;
                } else {
                    this.f = e(iF);
                }
                int i3 = this.f;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.f = i4;
                    if (i4 >= this.c.length()) {
                        this.f = -1;
                    }
                } else {
                    while (i < iF && this.d.matches(this.c.charAt(i))) {
                        i++;
                    }
                    while (iF > i && this.d.matches(this.c.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.e || i != iF) {
                        int i5 = this.g;
                        if (i5 == 1) {
                            iF = this.c.length();
                            this.f = -1;
                            while (iF > i && this.d.matches(this.c.charAt(iF - 1))) {
                                iF--;
                            }
                        } else {
                            this.g = i5 - 1;
                        }
                        return this.c.subSequence(i, iF).toString();
                    }
                    i = this.f;
                }
            }
        }

        public abstract int e(int i);

        public abstract int f(int i);
    }

    public interface g {
        Iterator a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(g gVar) {
        this(gVar, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }

    public static Splitter fixedLength(int i) {
        Preconditions.checkArgument(i > 0, "The length may not be less than 1");
        return new Splitter(new d(i));
    }

    public static Splitter on(char c2) {
        return on(CharMatcher.is(c2));
    }

    @GwtIncompatible("java.util.regex")
    public static Splitter onPattern(String str) {
        return on(Pattern.compile(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.a(this, charSequence);
    }

    public Splitter limit(int i) {
        Preconditions.checkArgument(i > 0, "must be greater than zero: %s", Integer.valueOf(i));
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Iterable<String> split(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new e(charSequence);
    }

    @Beta
    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> itSplittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itSplittingIterator.hasNext()) {
            arrayList.add(itSplittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.WHITESPACE);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    private Splitter(g gVar, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = gVar;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i;
    }

    public static Splitter on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new a(charMatcher));
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(char c2) {
        return withKeyValueSeparator(on(c2));
    }

    @Beta
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(this, splitter, null);
    }

    public static Splitter on(String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        return new Splitter(new b(str));
    }

    @GwtIncompatible("java.util.regex")
    public static Splitter on(Pattern pattern) {
        Preconditions.checkNotNull(pattern);
        Preconditions.checkArgument(!pattern.matcher("").matches(), "The pattern may not match the empty string: %s", pattern);
        return new Splitter(new c(pattern));
    }
}
