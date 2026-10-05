package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import defpackage.AbstractC2306gm;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
public final class Objects extends AbstractC2306gm {
    private Objects() {
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
