package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import androidx.annotation.NonNull;
import defpackage.vi0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzz implements vi0 {
    private final IBinder zza;

    public zzz(@NonNull IBinder iBinder) {
        this.zza = iBinder;
    }

    @Override // android.os.IInterface
    @NonNull
    public final IBinder asBinder() {
        return this.zza;
    }

    @Override // defpackage.vi0
    public final void zza(@NonNull Message message) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        parcelObtain.writeInt(1);
        message.writeToParcel(parcelObtain, 0);
        try {
            this.zza.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
