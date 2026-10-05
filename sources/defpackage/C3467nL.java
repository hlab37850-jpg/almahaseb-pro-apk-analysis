package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: renamed from: nL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3467nL implements Serializable {
    public ArrayList a = new ArrayList();
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public C3467nL(String str, String str2, String str3, String str4, String str5, String str6) {
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
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.f));
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.d;
    }

    public String h() {
        return this.b;
    }

    public String i() {
        return this.c;
    }

    public String j() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.g));
    }

    public String k() {
        return this.g;
    }

    public C3467nL(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.i = str7;
    }

    public C3467nL(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
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
