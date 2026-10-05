package com.google.android.gms.internal.vision;

import defpackage.E90;
import defpackage.H90;
import defpackage.K90;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdi {
    public static <T> zzdf<T> zza(zzdf<T> zzdfVar) {
        if ((zzdfVar instanceof K90) || (zzdfVar instanceof E90)) {
            return zzdfVar;
        }
        return zzdfVar instanceof Serializable ? new E90(zzdfVar) : new K90(zzdfVar);
    }

    public static <T> zzdf<T> zza(@NullableDecl T t) {
        return new H90(t);
    }
}
