package info.aalmoghalis.inventory.zatca;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public String a;
    public String b;
    public String c;
    public BigDecimal d;
    public BigDecimal e;
    public BigDecimal f;
    public BigDecimal g;
    public BigDecimal h;
    public BigDecimal i;

    public b(String str, String str2, String str3, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, BigDecimal bigDecimal5, BigDecimal bigDecimal6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bigDecimal;
        this.e = bigDecimal2;
        this.f = bigDecimal3;
        this.g = bigDecimal4;
        this.h = bigDecimal5;
        this.i = bigDecimal6;
    }

    public d.h a() {
        d.h hVar = new d.h();
        hVar.a = this.b;
        BigDecimal bigDecimal = this.d;
        hVar.b = bigDecimal == null ? 0.0d : bigDecimal.doubleValue();
        hVar.c = this.c;
        BigDecimal bigDecimal2 = this.f;
        hVar.d = bigDecimal2 == null ? 0.0d : bigDecimal2.doubleValue();
        BigDecimal bigDecimal3 = this.i;
        hVar.e = bigDecimal3 == null ? 0.0d : bigDecimal3.doubleValue();
        BigDecimal bigDecimal4 = this.g;
        hVar.f = bigDecimal4 == null ? 0.0d : bigDecimal4.doubleValue();
        BigDecimal bigDecimal5 = this.h;
        hVar.g = bigDecimal5 != null ? bigDecimal5.doubleValue() : 0.0d;
        return hVar;
    }
}
