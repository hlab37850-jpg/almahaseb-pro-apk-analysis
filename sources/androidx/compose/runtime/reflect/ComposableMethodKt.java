package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.C3473nR;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ComposableMethodKt {
    private static final int BITS_PER_INT = 31;

    public static final ComposableMethod asComposableMethod(Method method) {
        AbstractC4492zt.h(method, "<this>");
        ComposableInfo composableInfo = getComposableInfo(method);
        if (composableInfo.isComposable()) {
            return new ComposableMethod(method, composableInfo);
        }
        return null;
    }

    private static final int changedParamCount(int i, int i2) {
        if (i == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (i + i2)) / 10.0d);
    }

    private static final int defaultParamCount(int i) {
        return (int) Math.ceil(((double) i) / 31.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T[] dup(T t, int i) {
        C1001Vs c1001VsS = AbstractC3871sJ.s(0, i);
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(c1001VsS, 10));
        Iterator<T> it = c1001VsS.iterator();
        while (it.hasNext()) {
            ((AbstractC0919Ss) it).nextInt();
            arrayList.add(t);
        }
        AbstractC4492zt.m(0, "T?");
        return (T[]) arrayList.toArray(new Object[0]);
    }

    private static final ComposableInfo getComposableInfo(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        AbstractC4492zt.g(parameterTypes, "parameterTypes");
        int length = parameterTypes.length - 1;
        if (length < 0) {
            length = -1;
            break;
        }
        while (true) {
            int i = length - 1;
            if (AbstractC4492zt.d(parameterTypes[length], Composer.class)) {
                break;
            }
            if (i < 0) {
                length = -1;
                break;
            }
            length = i;
        }
        if (length == -1) {
            return new ComposableInfo(false, method.getParameterTypes().length, 0, 0);
        }
        int iChangedParamCount = changedParamCount(length, !Modifier.isStatic(method.getModifiers()) ? 1 : 0);
        int i2 = length + 1 + iChangedParamCount;
        int length2 = method.getParameterTypes().length;
        int iDefaultParamCount = length2 != i2 ? defaultParamCount(length) : 0;
        return new ComposableInfo(i2 + iDefaultParamCount == length2, length, iChangedParamCount, iDefaultParamCount);
    }

    public static final ComposableMethod getDeclaredComposableMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod;
        AbstractC4492zt.h(cls, "<this>");
        AbstractC4492zt.h(str, "methodName");
        AbstractC4492zt.h(clsArr, "args");
        int iChangedParamCount = changedParamCount(clsArr.length, 0);
        try {
            C3473nR c3473nR = new C3473nR(3);
            c3473nR.b(clsArr);
            c3473nR.a(Composer.class);
            Class cls2 = Integer.TYPE;
            C1001Vs c1001VsS = AbstractC3871sJ.s(0, iChangedParamCount);
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(c1001VsS, 10));
            Iterator it = c1001VsS.iterator();
            while (it.hasNext()) {
                ((AbstractC0919Ss) it).nextInt();
                arrayList.add(cls2);
            }
            c3473nR.b(arrayList.toArray(new Class[0]));
            declaredMethod = cls.getDeclaredMethod(str, (Class[]) c3473nR.d(new Class[c3473nR.c()]));
        } catch (ReflectiveOperationException unused) {
            int iDefaultParamCount = defaultParamCount(clsArr.length);
            try {
                C3473nR c3473nR2 = new C3473nR(4);
                c3473nR2.b(clsArr);
                c3473nR2.a(Composer.class);
                Class cls3 = Integer.TYPE;
                C1001Vs c1001VsS2 = AbstractC3871sJ.s(0, iChangedParamCount);
                ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(c1001VsS2, 10));
                Iterator it2 = c1001VsS2.iterator();
                while (it2.hasNext()) {
                    ((AbstractC0919Ss) it2).nextInt();
                    arrayList2.add(cls3);
                }
                c3473nR2.b(arrayList2.toArray(new Class[0]));
                Class cls4 = Integer.TYPE;
                C1001Vs c1001VsS3 = AbstractC3871sJ.s(0, iDefaultParamCount);
                ArrayList arrayList3 = new ArrayList(AbstractC2044dc.x(c1001VsS3, 10));
                Iterator it3 = c1001VsS3.iterator();
                while (it3.hasNext()) {
                    ((AbstractC0919Ss) it3).nextInt();
                    arrayList3.add(cls4);
                }
                c3473nR2.b(arrayList3.toArray(new Class[0]));
                declaredMethod = cls.getDeclaredMethod(str, (Class[]) c3473nR2.d(new Class[c3473nR2.c()]));
            } catch (ReflectiveOperationException unused2) {
                declaredMethod = null;
            }
        }
        if (declaredMethod != null) {
            ComposableMethod composableMethodAsComposableMethod = asComposableMethod(declaredMethod);
            AbstractC4492zt.e(composableMethodAsComposableMethod);
            return composableMethodAsComposableMethod;
        }
        throw new NoSuchMethodException(cls.getName() + '.' + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals(CSS.Value.DOUBLE)) {
                    return Double.valueOf(0.0d);
                }
                return null;
            case 104431:
                if (name.equals("int")) {
                    return 0;
                }
                return null;
            case 3039496:
                if (name.equals("byte")) {
                    return (byte) 0;
                }
                return null;
            case 3052374:
                if (name.equals("char")) {
                    return (char) 0;
                }
                return null;
            case 3327612:
                if (name.equals("long")) {
                    return 0L;
                }
                return null;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return Boolean.FALSE;
                }
                return null;
            case 97526364:
                if (name.equals("float")) {
                    return Float.valueOf(0.0f);
                }
                return null;
            case 109413500:
                if (name.equals("short")) {
                    return (short) 0;
                }
                return null;
            default:
                return null;
        }
    }
}
