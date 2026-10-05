package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.Q5;
import defpackage.R5;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public ComposableMethod(Method method, ComposableInfo composableInfo) {
        AbstractC4492zt.h(method, "method");
        AbstractC4492zt.h(composableInfo, "composableInfo");
        this.method = method;
        this.composableInfo = composableInfo;
    }

    public final Method asMethod() {
        return this.method;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ComposableMethod) {
            return AbstractC4492zt.d(this.method, ((ComposableMethod) obj).method);
        }
        return false;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Class<?>[] getParameterTypes() {
        Class<?>[] parameterTypes = this.method.getParameterTypes();
        AbstractC4492zt.g(parameterTypes, "method.parameterTypes");
        return (Class[]) Q5.o(parameterTypes, 0, this.composableInfo.getRealParamsCount());
    }

    public final Parameter[] getParameters() {
        Parameter[] parameters = this.method.getParameters();
        AbstractC4492zt.g(parameters, "method.parameters");
        return (Parameter[]) Q5.o(parameters, 0, this.composableInfo.getRealParamsCount());
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public final Object invoke(Composer composer, Object obj, Object... objArr) {
        Object defaultValue;
        AbstractC4492zt.h(composer, "composer");
        AbstractC4492zt.h(objArr, "args");
        ComposableInfo composableInfo = this.composableInfo;
        int iComponent2 = composableInfo.component2();
        int iComponent3 = composableInfo.component3();
        int iComponent4 = composableInfo.component4();
        int length = this.method.getParameterTypes().length;
        int i = iComponent2 + 1;
        int i2 = iComponent3 + i;
        Object[] objArr2 = new Integer[iComponent4];
        for (int i3 = 0; i3 < iComponent4; i3++) {
            int i4 = i3 * 31;
            C1001Vs c1001VsS = AbstractC3871sJ.s(i4, Math.min(i4 + 31, iComponent2));
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(c1001VsS, 10));
            Iterator it = c1001VsS.iterator();
            while (it.hasNext()) {
                int iNextInt = ((AbstractC0919Ss) it).nextInt();
                arrayList.add(Integer.valueOf((iNextInt >= objArr.length || objArr[iNextInt] == null) ? 1 : 0));
            }
            int iIntValue = 0;
            int i5 = 0;
            for (Object obj2 : arrayList) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    AbstractC1886cc.w();
                }
                iIntValue |= ((Number) obj2).intValue() << i5;
                i5 = i6;
            }
            objArr2[i3] = Integer.valueOf(iIntValue);
        }
        Object[] objArr3 = new Object[length];
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 < 0 || i7 >= iComponent2) {
                if (i7 == iComponent2) {
                    defaultValue = composer;
                } else if (i7 == i || (iComponent2 + 2 <= i7 && i7 < i2)) {
                    defaultValue = 0;
                } else {
                    if (i2 > i7 || i7 >= length) {
                        throw new IllegalStateException("Unexpected index");
                    }
                    defaultValue = objArr2[i7 - i2];
                }
            } else if (i7 < 0 || i7 > R5.O(objArr)) {
                Class<?> cls = this.method.getParameterTypes()[i7];
                AbstractC4492zt.g(cls, "method.parameterTypes[idx]");
                defaultValue = ComposableMethodKt.getDefaultValue(cls);
            } else {
                defaultValue = objArr[i7];
            }
            objArr3[i7] = defaultValue;
        }
        return this.method.invoke(obj, Arrays.copyOf(objArr3, length));
    }
}
