package defpackage;

import com.google.android.gms.internal.vision.zzjm;

/* JADX INFO: renamed from: ef0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC2132ef0 {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[zzjm.values().length];
        b = iArr;
        try {
            iArr[zzjm.zzh.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[zzjm.zzj.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[zzjm.zzg.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[EnumC1893cf0.values().length];
        a = iArr2;
        try {
            iArr2[EnumC1893cf0.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[EnumC1893cf0.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[EnumC1893cf0.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
