package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: renamed from: uh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4064uh implements Serializable {
    public static NumberFormat z = NumberFormat.getInstance(Locale.ENGLISH);
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String n;
    public String p;
    public String q;
    public String t = "";
    public String u = "";
    public String v = "";
    public String w = "";
    public String x = "";
    public String y = "";

    public C4064uh(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = i;
        this.g = str5;
        this.e = str6;
    }

    public void A(String str) {
        this.h = str;
    }

    public String a() {
        return this.l;
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.v;
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.g;
    }

    public String h() {
        return this.n;
    }

    public String i() {
        return this.p;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.q;
    }

    public String l() {
        return this.u;
    }

    public String m() {
        return this.t;
    }

    public String n() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.c));
    }

    public String o() {
        return this.e;
    }

    public String p() {
        try {
            Locale locale = Locale.ENGLISH;
            return new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(this.b).getTime()));
        } catch (Exception unused) {
            return this.b;
        }
    }

    public String q() {
        return this.a;
    }

    public String r() {
        return this.d;
    }

    public String s() {
        return this.h;
    }

    public int t() {
        return this.f;
    }

    public void u(String str) {
        this.v = str;
    }

    public void v(String str) {
        this.i = str;
    }

    public void w(String str) {
        this.g = z.format(Double.parseDouble(str));
    }

    public void x(double d) {
        this.g = z.format(d);
    }

    public void y(String str) {
        this.u = str;
    }

    public void z(String str) {
        this.t = str;
    }

    public C4064uh(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = i;
        this.g = str5;
        this.e = str6;
        this.k = str7;
    }

    public C4064uh(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = i;
        this.g = str5;
        this.e = str6;
        this.k = str7;
        this.l = str8;
        this.n = str9;
    }

    public C4064uh(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = i;
        this.g = str5;
        this.e = str6;
        this.k = str7;
        this.l = str8;
        this.n = str9;
        this.q = str10;
        this.p = str11;
    }

    public C4064uh(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = i;
        this.g = str5;
        this.e = str6;
        this.k = str7;
        this.l = str8;
        this.n = str9;
        this.q = str10;
        this.p = str11;
        this.i = str12;
        this.j = str13;
        this.h = str14;
    }
}
