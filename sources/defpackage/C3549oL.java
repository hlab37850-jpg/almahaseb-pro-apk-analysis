package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: renamed from: oL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3549oL implements Serializable {
    public ArrayList a = new ArrayList();
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    public C3549oL(String str, String str2, String str3, String str4, String str5, String str6) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
    }

    public String a() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.e));
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.i;
    }

    public ArrayList e() {
        return this.a;
    }

    public String f() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.f));
    }

    public String h() {
        return this.f;
    }

    public String i() {
        return this.d;
    }

    public String j() {
        return this.b;
    }

    public String k() {
        return this.c;
    }

    public String l() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.g));
    }

    public String m() {
        return this.g;
    }

    public void n(ArrayList arrayList) {
        this.a = arrayList;
    }

    public C3549oL(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.i = str7;
    }

    public C3549oL(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.i = str7;
        this.h = str8;
    }
}
