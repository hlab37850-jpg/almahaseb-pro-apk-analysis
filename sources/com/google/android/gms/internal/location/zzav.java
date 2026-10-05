package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import defpackage.AbstractC3574of;
import defpackage.BinderC3283l50;
import defpackage.BinderC4339y50;
import defpackage.Gd0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzav {
    private final zzbg<zzam> zza;
    private final Context zzb;
    private boolean zzc = false;
    private final Map<ListenerHolder.ListenerKey<LocationListener>, BinderC4339y50> zzd = new HashMap();
    private final Map<ListenerHolder.ListenerKey, Object> zze = new HashMap();
    private final Map<ListenerHolder.ListenerKey<LocationCallback>, BinderC3283l50> zzf = new HashMap();

    public zzav(Context context, zzbg<zzam> zzbgVar) {
        this.zzb = context;
        this.zza = zzbgVar;
    }

    public final Location zza(String str) {
        ((Gd0) this.zza).a.checkConnected();
        return ((Gd0) this.zza).a().zzn(str);
    }

    @Deprecated
    public final Location zzb() {
        ((Gd0) this.zza).a.checkConnected();
        return ((Gd0) this.zza).a().zzm();
    }

    public final LocationAvailability zzc() {
        ((Gd0) this.zza).a.checkConnected();
        return ((Gd0) this.zza).a().zzs(this.zzb.getPackageName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzd(LocationRequest locationRequest, ListenerHolder<LocationListener> listenerHolder, zzai zzaiVar) {
        BinderC4339y50 binderC4339y50;
        BinderC4339y50 binderC4339y51;
        ((Gd0) this.zza).a.checkConnected();
        ListenerHolder.ListenerKey<LocationListener> listenerKey = listenerHolder.getListenerKey();
        if (listenerKey == null) {
            binderC4339y51 = null;
        } else {
            synchronized (this.zzd) {
                try {
                    binderC4339y50 = this.zzd.get(listenerKey);
                    if (binderC4339y50 == null) {
                        binderC4339y50 = new BinderC4339y50(listenerHolder);
                    }
                    this.zzd.put(listenerKey, binderC4339y50);
                } catch (Throwable th) {
                    throw th;
                }
            }
            binderC4339y51 = binderC4339y50;
        }
        if (binderC4339y51 == null) {
            return;
        }
        ((Gd0) this.zza).a().zzo(new zzbc(1, zzba.zza(null, locationRequest), binderC4339y51, null, null, zzaiVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zze(zzba zzbaVar, ListenerHolder<LocationCallback> listenerHolder, zzai zzaiVar) {
        BinderC3283l50 binderC3283l50;
        ((Gd0) this.zza).a.checkConnected();
        ListenerHolder.ListenerKey<LocationCallback> listenerKey = listenerHolder.getListenerKey();
        if (listenerKey == null) {
            binderC3283l50 = null;
        } else {
            synchronized (this.zzf) {
                try {
                    BinderC3283l50 binderC3283l51 = this.zzf.get(listenerKey);
                    if (binderC3283l51 == null) {
                        binderC3283l51 = new BinderC3283l50(listenerHolder);
                    }
                    binderC3283l50 = binderC3283l51;
                    this.zzf.put(listenerKey, binderC3283l50);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        BinderC3283l50 binderC3283l52 = binderC3283l50;
        if (binderC3283l52 == null) {
            return;
        }
        ((Gd0) this.zza).a().zzo(new zzbc(1, zzbaVar, null, null, binderC3283l52, zzaiVar));
    }

    public final void zzf(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) {
        ((Gd0) this.zza).a.checkConnected();
        ((Gd0) this.zza).a().zzo(zzbc.zzb(zzbaVar, pendingIntent, zzaiVar));
    }

    public final void zzg(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzaiVar) {
        ((Gd0) this.zza).a.checkConnected();
        ((Gd0) this.zza).a().zzo(zzbc.zzb(zzba.zza(null, locationRequest), pendingIntent, zzaiVar));
    }

    public final void zzh(ListenerHolder.ListenerKey<LocationListener> listenerKey, zzai zzaiVar) {
        ((Gd0) this.zza).a.checkConnected();
        Preconditions.checkNotNull(listenerKey, "Invalid null listener key");
        synchronized (this.zzd) {
            try {
                BinderC4339y50 binderC4339y50Remove = this.zzd.remove(listenerKey);
                if (binderC4339y50Remove != null) {
                    binderC4339y50Remove.zzc();
                    ((Gd0) this.zza).a().zzo(zzbc.zza(binderC4339y50Remove, zzaiVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi(ListenerHolder.ListenerKey<LocationCallback> listenerKey, zzai zzaiVar) {
        ((Gd0) this.zza).a.checkConnected();
        Preconditions.checkNotNull(listenerKey, "Invalid null listener key");
        synchronized (this.zzf) {
            try {
                BinderC3283l50 binderC3283l50Remove = this.zzf.remove(listenerKey);
                if (binderC3283l50Remove != null) {
                    binderC3283l50Remove.zzc();
                    ((Gd0) this.zza).a().zzo(zzbc.zzc(binderC3283l50Remove, zzaiVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzj(PendingIntent pendingIntent, zzai zzaiVar) {
        ((Gd0) this.zza).a.checkConnected();
        ((Gd0) this.zza).a().zzo(new zzbc(2, null, null, pendingIntent, null, zzaiVar));
    }

    public final void zzk(boolean z) {
        ((Gd0) this.zza).a.checkConnected();
        ((Gd0) this.zza).a().zzp(z);
        this.zzc = z;
    }

    public final void zzl(Location location) {
        ((Gd0) this.zza).a.checkConnected();
        ((Gd0) this.zza).a().zzq(location);
    }

    public final void zzm(zzai zzaiVar) {
        ((Gd0) this.zza).a.checkConnected();
        ((Gd0) this.zza).a().zzr(zzaiVar);
    }

    public final void zzn() {
        synchronized (this.zzd) {
            try {
                for (BinderC4339y50 binderC4339y50 : this.zzd.values()) {
                    if (binderC4339y50 != null) {
                        ((Gd0) this.zza).a().zzo(zzbc.zza(binderC4339y50, null));
                    }
                }
                this.zzd.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzf) {
            try {
                for (BinderC3283l50 binderC3283l50 : this.zzf.values()) {
                    if (binderC3283l50 != null) {
                        ((Gd0) this.zza).a().zzo(zzbc.zzc(binderC3283l50, null));
                    }
                }
                this.zzf.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (this.zze) {
            try {
                Iterator<Object> it = this.zze.values().iterator();
                while (it.hasNext()) {
                    AbstractC3574of.a(it.next());
                }
                this.zze.clear();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void zzo() {
        if (this.zzc) {
            zzk(false);
        }
    }
}
