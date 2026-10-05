package defpackage;

import com.google.common.collect.MapMaker;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BG {
    public static Object[] a(Object[] objArr, int i, int i2, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i, i2, objArr2.getClass());
    }

    public static Object[] b(Object[] objArr, int i) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
    }

    public static Map c(int i) {
        return C0739Md.z(i);
    }

    public static Set d(int i) {
        return C0765Nd.j(i);
    }

    public static Map e(int i) {
        return C0817Pd.d0(i);
    }

    public static Set f(int i) {
        return C0852Qd.E(i);
    }

    public static Set g() {
        return C0765Nd.h();
    }

    public static Map h() {
        return C0739Md.u();
    }

    public static MapMaker i(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
