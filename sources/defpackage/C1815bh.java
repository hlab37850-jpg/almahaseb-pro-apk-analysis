package defpackage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: renamed from: bh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1815bh implements Serializable {
    public String a;
    public String b;
    public String c;
    public double d;
    public int e;
    public double f;
    public String g;

    public C1815bh(String str, String str2, String str3, double d, int i, int i2, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
        this.e = i;
        this.f = i2;
        this.g = str4;
    }

    public String a() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(this.d);
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public int f() {
        return this.e;
    }

    public String h() {
        return NumberFormat.getInstance(Locale.ENGLISH).format(this.f);
    }

    public void i(double d) {
        this.f = d;
    }
}
