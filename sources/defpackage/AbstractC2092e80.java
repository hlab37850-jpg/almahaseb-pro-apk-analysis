package defpackage;

import com.google.android.gms.internal.clearcut.zzcq;

/* JADX INFO: renamed from: e80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC2092e80 {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[zzcq.values().length];
        b = iArr;
        try {
            iArr[zzcq.zzle.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[zzcq.zzlg.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[zzcq.zzld.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[EnumC2420i80.values().length];
        a = iArr2;
        try {
            iArr2[EnumC2420i80.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[EnumC2420i80.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[EnumC2420i80.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
