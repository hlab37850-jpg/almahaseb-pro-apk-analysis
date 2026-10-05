package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: renamed from: ch, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1896ch implements Serializable {
    public ArrayList a = new ArrayList();
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;

    public C1896ch(String str, String str2, String str3, String str4, int i, String str5) {
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
        return this.i;
    }

    public String c() {
        return this.h;
    }

    public ArrayList e() {
        return this.a;
    }

    public String f() {
        return this.g;
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.b;
    }

    public String j() {
        return this.c;
    }

    public int k() {
        return this.f;
    }

    public void l(String str) {
        this.i = str;
    }

    public void m(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void n(String str) {
        this.g = str;
    }

    public C1896ch(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i;
        this.g = str5;
        this.h = str6;
    }
}
