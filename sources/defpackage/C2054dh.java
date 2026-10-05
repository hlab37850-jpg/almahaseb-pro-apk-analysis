package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: renamed from: dh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2054dh implements Serializable {
    public ArrayList a = new ArrayList();
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;

    public C2054dh(String str, String str2, String str3, String str4, int i, String str5) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i;
        this.g = str5;
    }

    public String a() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.e));
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public int f() {
        return this.f;
    }

    public void h(String str) {
        this.e = str;
    }

    public void i(String str) {
        this.g = str;
    }

    public void j(String str) {
        this.d = str;
    }

    public void k(String str) {
        this.b = str;
    }

    public void l(String str) {
        this.c = str;
    }

    public void m(int i) {
        this.f = i;
    }

    public C2054dh(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i;
        this.g = str5;
        this.h = str6;
    }
}
