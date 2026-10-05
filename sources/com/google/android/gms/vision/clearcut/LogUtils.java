package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.L;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LogUtils {
    public static zzfi.zzo zza(long j, int i, @Nullable String str, String str2, @Nullable List<zzfi.zzn> list, zzs zzsVar) {
        zzfi.zzi.zza zzaVarZza = zzfi.zzi.zza();
        zzfi.zzf.zzb zzbVarZzb = zzfi.zzf.zza().zza(str2).zza(j).zzb(i);
        zzbVarZzb.zza(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((zzfi.zzf) ((zzjb) zzbVarZzb.zzf()));
        return (zzfi.zzo) ((zzjb) zzfi.zzo.zza().zza((zzfi.zzi) ((zzjb) zzaVarZza.zza(arrayList).zza((zzfi.zzj) ((zzjb) zzfi.zzj.zza().zzb(zzsVar.zzb).zza(zzsVar.zza).zzc(zzsVar.zzc).zzd(zzsVar.zzd).zzf())).zzf())).zzf());
    }

    @Nullable
    private static String zzb(Context context) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            L.e(e, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }

    public static zzfi.zza zza(Context context) {
        zzfi.zza.C0182zza c0182zzaZza = zzfi.zza.zza().zza(context.getPackageName());
        String strZzb = zzb(context);
        if (strZzb != null) {
            c0182zzaZza.zzb(strZzb);
        }
        return (zzfi.zza) ((zzjb) c0182zzaZza.zzf());
    }
}
