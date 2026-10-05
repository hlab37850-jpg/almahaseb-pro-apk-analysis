package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: renamed from: vg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4143vg implements Serializable {
    public String a;
    public String b;
    public String c;
    public double d;
    public int e;
    public String f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k = "";

    public C4143vg(String str, String str2, String str3, double d, int i, int i2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
        this.e = i;
        this.g = i2;
    }

    public String a() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(this.d);
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.i;
    }

    public int e() {
        return this.g;
    }

    public String f() {
        return this.h;
    }

    public String h() {
        return this.c;
    }

    public String i() {
        return this.a;
    }

    public String j() {
        return this.b;
    }

    public int k() {
        return this.e;
    }

    public String l() {
        return this.f;
    }

    public void m(String str) {
        this.j = str;
    }

    public void n(String str) {
        this.h = str;
    }

    public void o(String str) {
        this.c = str;
    }

    public void p(String str) {
        this.a = str;
    }

    public void q(String str) {
        this.b = str;
    }

    public void r(String str) {
        this.f = str;
    }

    public C4143vg(String str, String str2, String str3, double d, int i, int i2, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
        this.e = i;
        this.g = i2;
        this.h = str4;
    }

    public C4143vg(String str, String str2, String str3, double d, int i, int i2, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
        this.e = i;
        this.g = i2;
        this.h = str4;
        this.j = str5;
    }

    public C4143vg(String str, String str2, String str3, double d, int i, int i2, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
        this.e = i;
        this.g = i2;
        this.h = str4;
        this.j = str5;
        this.f = str6;
    }

    public C4143vg(String str, String str2, String str3, double d, int i, int i2, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
        this.e = i;
        this.g = i2;
        this.h = str4;
        this.j = str5;
        this.f = str6;
        this.i = str7;
    }
}
