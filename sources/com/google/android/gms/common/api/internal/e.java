package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import defpackage.F10;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends F10 {
    public final ArrayList b;
    public final /* synthetic */ zaaw c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zaaw zaawVar, ArrayList arrayList) {
        super(zaawVar, null);
        this.c = zaawVar;
        this.b = arrayList;
    }

    @Override // defpackage.F10
    public final void a() {
        zaaw zaawVar = this.c;
        zaawVar.zaa.zag.zad = zaaw.zao(zaawVar);
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Api.Client client = (Api.Client) arrayList.get(i);
            zaaw zaawVar2 = this.c;
            client.getRemoteService(zaawVar2.zao, zaawVar2.zaa.zag.zad);
        }
    }
}
