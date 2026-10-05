package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: renamed from: Oh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0795Oh implements Serializable {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String n;
    public String p;
    public String q;
    public String t;
    public String u;
    public String v;

    public C0795Oh(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.p = "";
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = str5;
        this.n = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
    }

    public String a() {
        return this.n;
    }

    public String b() {
        return this.q;
    }

    public String c() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.v));
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.k;
    }

    public String h() {
        return this.l;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.t;
    }

    public String k() {
        return this.u;
    }

    public String l() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(Double.parseDouble(this.c));
    }

    public String m() {
        return this.p;
    }

    public String n() {
        try {
            Locale locale = Locale.ENGLISH;
            return new SimpleDateFormat("dd-MM-yyyy", locale).format(Long.valueOf(new SimpleDateFormat("dd-MM-yyyy", locale).parse(this.b).getTime()));
        } catch (Exception unused) {
            return this.b;
        }
    }

    public String o() {
        return this.a;
    }

    public String p() {
        return this.f;
    }

    public String q() {
        return this.d;
    }

    public int r() {
        return this.e;
    }

    public C0795Oh(long j, String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.p = "";
        this.a = String.valueOf(j);
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i;
        this.f = str4;
        this.n = str5;
        this.q = str6;
        this.p = str7;
        this.k = str8;
        this.l = str9;
    }

    public C0795Oh(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = str5;
        this.n = str6;
        this.q = str7;
        this.p = str8;
        this.t = str9;
        this.u = str10;
        this.v = str11;
    }
}
