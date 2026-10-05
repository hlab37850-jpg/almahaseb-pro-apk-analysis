package com.google.gson;

import com.google.gson.internal.ReflectionAccessFilterHelper;

/* JADX INFO: loaded from: classes3.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new a();
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new b();
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new c();
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new d();

    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    public class a implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            return ReflectionAccessFilterHelper.isJavaType((Class<?>) cls) ? FilterResult.BLOCK_INACCESSIBLE : FilterResult.INDECISIVE;
        }
    }

    public class b implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            return ReflectionAccessFilterHelper.isJavaType((Class<?>) cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    }

    public class c implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            return ReflectionAccessFilterHelper.isAndroidType((Class<?>) cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    }

    public class d implements ReflectionAccessFilter {
        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class cls) {
            return ReflectionAccessFilterHelper.isAnyPlatformType(cls) ? FilterResult.BLOCK_ALL : FilterResult.INDECISIVE;
        }
    }

    FilterResult check(Class<?> cls);
}
