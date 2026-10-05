package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: Fb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0512Fb implements InterfaceC0635Ju, InterfaceC0412Db {
    public static final a b = new a(null);
    public static final Map c;
    public static final HashMap d;
    public static final HashMap e;
    public static final HashMap f;
    public static final Map g;
    public final Class a;

    /* JADX INFO: renamed from: Fb$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        
            if (r2 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a(java.lang.Class r7) {
            /*
                r6 = this;
                java.lang.String r0 = "jClass"
                defpackage.AbstractC4492zt.h(r7, r0)
                boolean r0 = r7.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb3
            Le:
                boolean r0 = r7.isLocalClass()
                if (r0 == 0) goto L6a
                java.lang.String r0 = r7.getSimpleName()
                java.lang.reflect.Method r2 = r7.getEnclosingMethod()
                r3 = 2
                r4 = 36
                if (r2 == 0) goto L41
                defpackage.AbstractC4492zt.e(r0)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = r2.getName()
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                java.lang.String r2 = defpackage.AbstractC3961tS.A0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L3e
                goto L41
            L3e:
                r1 = r2
                goto Lb3
            L41:
                java.lang.reflect.Constructor r7 = r7.getEnclosingConstructor()
                if (r7 == 0) goto L62
                defpackage.AbstractC4492zt.e(r0)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = r7.getName()
                r2.append(r7)
                r2.append(r4)
                java.lang.String r7 = r2.toString()
                java.lang.String r1 = defpackage.AbstractC3961tS.A0(r0, r7, r1, r3, r1)
                goto Lb3
            L62:
                defpackage.AbstractC4492zt.e(r0)
                java.lang.String r1 = defpackage.AbstractC3961tS.z0(r0, r4, r1, r3, r1)
                goto Lb3
            L6a:
                boolean r0 = r7.isArray()
                if (r0 == 0) goto L9e
                java.lang.Class r7 = r7.getComponentType()
                boolean r0 = r7.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L9b
                java.util.Map r0 = defpackage.C0512Fb.c()
                java.lang.String r7 = r7.getName()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L9b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r7)
                r0.append(r2)
                java.lang.String r1 = r0.toString()
            L9b:
                if (r1 != 0) goto Lb3
                goto L3e
            L9e:
                java.util.Map r0 = defpackage.C0512Fb.c()
                java.lang.String r1 = r7.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb3
                java.lang.String r1 = r7.getSimpleName()
            Lb3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0512Fb.a.a(java.lang.Class):java.lang.String");
        }

        public a() {
        }
    }

    static {
        int i = 0;
        List listP = AbstractC1886cc.p(InterfaceC3588op.class, InterfaceC3750qp.class, InterfaceC0526Fp.class, InterfaceC0552Gp.class, InterfaceC0578Hp.class, InterfaceC0604Ip.class, InterfaceC0630Jp.class, InterfaceC0700Kp.class, InterfaceC0726Lp.class, InterfaceC0751Mp.class, InterfaceC3669pp.class, InterfaceC3830rp.class, InterfaceC3911sp.class, InterfaceC3992tp.class, InterfaceC4073up.class, InterfaceC4154vp.class, InterfaceC4235wp.class, InterfaceC4316xp.class, InterfaceC4407yp.class, InterfaceC4488zp.class, InterfaceC0374Bp.class, InterfaceC0400Cp.class, InterfaceC0426Dp.class);
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(listP, 10));
        for (Object obj : listP) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC1886cc.w();
            }
            arrayList.add(HV.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        c = AbstractC4243wx.q(arrayList);
        HashMap map = new HashMap();
        map.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put(CSS.Value.DOUBLE, "kotlin.Double");
        d = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        e = map2;
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        AbstractC4492zt.g(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            AbstractC4492zt.e(str);
            sb.append(AbstractC3961tS.C0(str, '.', null, 2, null));
            sb.append("CompanionObject");
            C2020dG c2020dGA = HV.a(sb.toString(), str + ".Companion");
            map3.put(c2020dGA.c(), c2020dGA.e());
        }
        for (Map.Entry entry : c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC4162vx.d(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), AbstractC3961tS.C0((String) entry2.getValue(), '.', null, 2, null));
        }
        g = linkedHashMap;
    }

    public C0512Fb(Class cls) {
        AbstractC4492zt.h(cls, "jClass");
        this.a = cls;
    }

    @Override // defpackage.InterfaceC0635Ju
    public String a() {
        return b.a(b());
    }

    @Override // defpackage.InterfaceC0412Db
    public Class b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0512Fb) && AbstractC4492zt.d(AbstractC0557Gu.b(this), AbstractC0557Gu.b((InterfaceC0635Ju) obj));
    }

    public int hashCode() {
        return AbstractC0557Gu.b(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
