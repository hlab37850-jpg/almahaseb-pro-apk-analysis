package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzc;
import defpackage.AbstractC4021u80;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public int a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: com.android.billingclient.api.a$a, reason: collision with other inner class name */
    public static class C0167a {
        public int a;
        public int b = 0;
        public String c = "";

        public /* synthetic */ C0167a(AbstractC4021u80 abstractC4021u80) {
        }

        public a a() {
            a aVar = new a();
            aVar.a = this.a;
            aVar.b = this.b;
            aVar.c = this.c;
            return aVar;
        }

        public C0167a b(String str) {
            this.c = str;
            return this;
        }

        public C0167a c(int i) {
            this.b = i;
            return this;
        }

        public C0167a d(int i) {
            this.a = i;
            return this;
        }
    }

    public static C0167a d() {
        return new C0167a(null);
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public String toString() {
        return "Response Code: " + zzc.zzk(this.a) + ", Debug Message: " + this.c;
    }
}
