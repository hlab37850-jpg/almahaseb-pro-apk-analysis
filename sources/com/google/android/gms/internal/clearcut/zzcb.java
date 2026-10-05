package com.google.android.gms.internal.clearcut;

import defpackage.AbstractC2092e80;
import defpackage.EnumC2420i80;
import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzgy' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcb {
    private static final zzcb zzgy;
    private static final zzcb zzgz;
    private static final zzcb zzha;
    private static final zzcb zzhb;
    private static final zzcb zzhc;
    private static final zzcb zzhd;
    private static final zzcb zzhe;
    private static final zzcb zzhf;
    private static final zzcb zzhg;
    public static final zzcb zzhh;
    private static final zzcb zzhi;
    private static final zzcb zzhj;
    public static final zzcb zzhk;
    private static final zzcb zzhl;
    private static final zzcb zzhm;
    private static final zzcb zzhn;
    private static final zzcb zzho;
    public static final zzcb zzhp;
    public static final zzcb zzhq;
    private static final zzcb zzhr;
    private static final zzcb zzhs;
    private static final zzcb zzht;
    private static final zzcb zzhu;
    private static final zzcb zzhv;
    private static final zzcb zzhw;
    private static final zzcb zzhx;
    private static final zzcb zzhy;
    public static final zzcb zzhz;
    private static final zzcb zzia;
    private static final zzcb zzib;
    public static final zzcb zzic;
    private static final zzcb zzid;
    private static final zzcb zzie;
    private static final zzcb zzif;
    private static final zzcb zzig;
    public static final zzcb zzih;
    private static final zzcb zzii;
    private static final zzcb zzij;
    private static final zzcb zzik;
    private static final zzcb zzil;
    private static final zzcb zzim;
    private static final zzcb zzin;
    private static final zzcb zzio;
    private static final zzcb zzip;
    public static final zzcb zziq;
    private static final zzcb zzir;
    private static final zzcb zzis;
    private static final zzcb zzit;
    public static final zzcb zziu;
    public static final zzcb zziv;
    public static final zzcb zziw;
    private static final zzcb[] zzjb;
    private static final Type[] zzjc;
    private static final /* synthetic */ zzcb[] zzjd;
    private final int id;
    private final zzcq zzix;
    private final EnumC2420i80 zziy;
    private final Class<?> zziz;
    private final boolean zzja;

    static {
        EnumC2420i80 enumC2420i80 = EnumC2420i80.SCALAR;
        zzcq zzcqVar = zzcq.zzlb;
        zzcb zzcbVar = new zzcb("DOUBLE", 0, 0, enumC2420i80, zzcqVar);
        zzgy = zzcbVar;
        zzcq zzcqVar2 = zzcq.zzla;
        zzcb zzcbVar2 = new zzcb("FLOAT", 1, 1, enumC2420i80, zzcqVar2);
        zzgz = zzcbVar2;
        zzcq zzcqVar3 = zzcq.zzkz;
        zzcb zzcbVar3 = new zzcb("INT64", 2, 2, enumC2420i80, zzcqVar3);
        zzha = zzcbVar3;
        zzcb zzcbVar4 = new zzcb("UINT64", 3, 3, enumC2420i80, zzcqVar3);
        zzhb = zzcbVar4;
        zzcq zzcqVar4 = zzcq.zzky;
        zzcb zzcbVar5 = new zzcb("INT32", 4, 4, enumC2420i80, zzcqVar4);
        zzhc = zzcbVar5;
        zzcb zzcbVar6 = new zzcb("FIXED64", 5, 5, enumC2420i80, zzcqVar3);
        zzhd = zzcbVar6;
        zzcb zzcbVar7 = new zzcb("FIXED32", 6, 6, enumC2420i80, zzcqVar4);
        zzhe = zzcbVar7;
        zzcq zzcqVar5 = zzcq.zzlc;
        zzcb zzcbVar8 = new zzcb("BOOL", 7, 7, enumC2420i80, zzcqVar5);
        zzhf = zzcbVar8;
        zzcq zzcqVar6 = zzcq.zzld;
        zzcb zzcbVar9 = new zzcb("STRING", 8, 8, enumC2420i80, zzcqVar6);
        zzhg = zzcbVar9;
        zzcq zzcqVar7 = zzcq.zzlg;
        zzcb zzcbVar10 = new zzcb("MESSAGE", 9, 9, enumC2420i80, zzcqVar7);
        zzhh = zzcbVar10;
        zzcq zzcqVar8 = zzcq.zzle;
        zzcb zzcbVar11 = new zzcb("BYTES", 10, 10, enumC2420i80, zzcqVar8);
        zzhi = zzcbVar11;
        zzcb zzcbVar12 = new zzcb("UINT32", 11, 11, enumC2420i80, zzcqVar4);
        zzhj = zzcbVar12;
        zzcq zzcqVar9 = zzcq.zzlf;
        zzcb zzcbVar13 = new zzcb("ENUM", 12, 12, enumC2420i80, zzcqVar9);
        zzhk = zzcbVar13;
        zzcb zzcbVar14 = new zzcb("SFIXED32", 13, 13, enumC2420i80, zzcqVar4);
        zzhl = zzcbVar14;
        zzcb zzcbVar15 = new zzcb("SFIXED64", 14, 14, enumC2420i80, zzcqVar3);
        zzhm = zzcbVar15;
        zzcb zzcbVar16 = new zzcb("SINT32", 15, 15, enumC2420i80, zzcqVar4);
        zzhn = zzcbVar16;
        zzcb zzcbVar17 = new zzcb("SINT64", 16, 16, enumC2420i80, zzcqVar3);
        zzho = zzcbVar17;
        zzcb zzcbVar18 = new zzcb("GROUP", 17, 17, enumC2420i80, zzcqVar7);
        zzhp = zzcbVar18;
        EnumC2420i80 enumC2420i81 = EnumC2420i80.VECTOR;
        zzcb zzcbVar19 = new zzcb("DOUBLE_LIST", 18, 18, enumC2420i81, zzcqVar);
        zzhq = zzcbVar19;
        zzcb zzcbVar20 = new zzcb("FLOAT_LIST", 19, 19, enumC2420i81, zzcqVar2);
        zzhr = zzcbVar20;
        zzcb zzcbVar21 = new zzcb("INT64_LIST", 20, 20, enumC2420i81, zzcqVar3);
        zzhs = zzcbVar21;
        zzcb zzcbVar22 = new zzcb("UINT64_LIST", 21, 21, enumC2420i81, zzcqVar3);
        zzht = zzcbVar22;
        zzcb zzcbVar23 = new zzcb("INT32_LIST", 22, 22, enumC2420i81, zzcqVar4);
        zzhu = zzcbVar23;
        zzcb zzcbVar24 = new zzcb("FIXED64_LIST", 23, 23, enumC2420i81, zzcqVar3);
        zzhv = zzcbVar24;
        zzcb zzcbVar25 = new zzcb("FIXED32_LIST", 24, 24, enumC2420i81, zzcqVar4);
        zzhw = zzcbVar25;
        zzcb zzcbVar26 = new zzcb("BOOL_LIST", 25, 25, enumC2420i81, zzcqVar5);
        zzhx = zzcbVar26;
        zzcb zzcbVar27 = new zzcb("STRING_LIST", 26, 26, enumC2420i81, zzcqVar6);
        zzhy = zzcbVar27;
        zzcb zzcbVar28 = new zzcb("MESSAGE_LIST", 27, 27, enumC2420i81, zzcqVar7);
        zzhz = zzcbVar28;
        zzcb zzcbVar29 = new zzcb("BYTES_LIST", 28, 28, enumC2420i81, zzcqVar8);
        zzia = zzcbVar29;
        zzcb zzcbVar30 = new zzcb("UINT32_LIST", 29, 29, enumC2420i81, zzcqVar4);
        zzib = zzcbVar30;
        zzcb zzcbVar31 = new zzcb("ENUM_LIST", 30, 30, enumC2420i81, zzcqVar9);
        zzic = zzcbVar31;
        zzcb zzcbVar32 = new zzcb("SFIXED32_LIST", 31, 31, enumC2420i81, zzcqVar4);
        zzid = zzcbVar32;
        zzcb zzcbVar33 = new zzcb("SFIXED64_LIST", 32, 32, enumC2420i81, zzcqVar3);
        zzie = zzcbVar33;
        zzcb zzcbVar34 = new zzcb("SINT32_LIST", 33, 33, enumC2420i81, zzcqVar4);
        zzif = zzcbVar34;
        zzcb zzcbVar35 = new zzcb("SINT64_LIST", 34, 34, enumC2420i81, zzcqVar3);
        zzig = zzcbVar35;
        EnumC2420i80 enumC2420i82 = EnumC2420i80.PACKED_VECTOR;
        zzcb zzcbVar36 = new zzcb("DOUBLE_LIST_PACKED", 35, 35, enumC2420i82, zzcqVar);
        zzih = zzcbVar36;
        zzcb zzcbVar37 = new zzcb("FLOAT_LIST_PACKED", 36, 36, enumC2420i82, zzcqVar2);
        zzii = zzcbVar37;
        zzcb zzcbVar38 = new zzcb("INT64_LIST_PACKED", 37, 37, enumC2420i82, zzcqVar3);
        zzij = zzcbVar38;
        zzcb zzcbVar39 = new zzcb("UINT64_LIST_PACKED", 38, 38, enumC2420i82, zzcqVar3);
        zzik = zzcbVar39;
        zzcb zzcbVar40 = new zzcb("INT32_LIST_PACKED", 39, 39, enumC2420i82, zzcqVar4);
        zzil = zzcbVar40;
        zzcb zzcbVar41 = new zzcb("FIXED64_LIST_PACKED", 40, 40, enumC2420i82, zzcqVar3);
        zzim = zzcbVar41;
        zzcb zzcbVar42 = new zzcb("FIXED32_LIST_PACKED", 41, 41, enumC2420i82, zzcqVar4);
        zzin = zzcbVar42;
        zzcb zzcbVar43 = new zzcb("BOOL_LIST_PACKED", 42, 42, enumC2420i82, zzcqVar5);
        zzio = zzcbVar43;
        zzcb zzcbVar44 = new zzcb("UINT32_LIST_PACKED", 43, 43, enumC2420i82, zzcqVar4);
        zzip = zzcbVar44;
        zzcb zzcbVar45 = new zzcb("ENUM_LIST_PACKED", 44, 44, enumC2420i82, zzcqVar9);
        zziq = zzcbVar45;
        zzcb zzcbVar46 = new zzcb("SFIXED32_LIST_PACKED", 45, 45, enumC2420i82, zzcqVar4);
        zzir = zzcbVar46;
        zzcb zzcbVar47 = new zzcb("SFIXED64_LIST_PACKED", 46, 46, enumC2420i82, zzcqVar3);
        zzis = zzcbVar47;
        zzcb zzcbVar48 = new zzcb("SINT32_LIST_PACKED", 47, 47, enumC2420i82, zzcqVar4);
        zzit = zzcbVar48;
        zzcb zzcbVar49 = new zzcb("SINT64_LIST_PACKED", 48, 48, enumC2420i82, zzcqVar3);
        zziu = zzcbVar49;
        zzcb zzcbVar50 = new zzcb("GROUP_LIST", 49, 49, enumC2420i81, zzcqVar7);
        zziv = zzcbVar50;
        zzcb zzcbVar51 = new zzcb("MAP", 50, 50, EnumC2420i80.MAP, zzcq.zzkx);
        zziw = zzcbVar51;
        zzjd = new zzcb[]{zzcbVar, zzcbVar2, zzcbVar3, zzcbVar4, zzcbVar5, zzcbVar6, zzcbVar7, zzcbVar8, zzcbVar9, zzcbVar10, zzcbVar11, zzcbVar12, zzcbVar13, zzcbVar14, zzcbVar15, zzcbVar16, zzcbVar17, zzcbVar18, zzcbVar19, zzcbVar20, zzcbVar21, zzcbVar22, zzcbVar23, zzcbVar24, zzcbVar25, zzcbVar26, zzcbVar27, zzcbVar28, zzcbVar29, zzcbVar30, zzcbVar31, zzcbVar32, zzcbVar33, zzcbVar34, zzcbVar35, zzcbVar36, zzcbVar37, zzcbVar38, zzcbVar39, zzcbVar40, zzcbVar41, zzcbVar42, zzcbVar43, zzcbVar44, zzcbVar45, zzcbVar46, zzcbVar47, zzcbVar48, zzcbVar49, zzcbVar50, zzcbVar51};
        zzjc = new Type[0];
        zzcb[] zzcbVarArrValues = values();
        zzjb = new zzcb[zzcbVarArrValues.length];
        for (zzcb zzcbVar52 : zzcbVarArrValues) {
            zzjb[zzcbVar52.id] = zzcbVar52;
        }
    }

    private zzcb(String str, int i, int i2, EnumC2420i80 enumC2420i80, zzcq zzcqVar) {
        int i3;
        super(str, i);
        this.id = i2;
        this.zziy = enumC2420i80;
        this.zzix = zzcqVar;
        int i4 = AbstractC2092e80.a[enumC2420i80.ordinal()];
        this.zziz = (i4 == 1 || i4 == 2) ? zzcqVar.zzbq() : null;
        this.zzja = (enumC2420i80 != EnumC2420i80.SCALAR || (i3 = AbstractC2092e80.b[zzcqVar.ordinal()]) == 1 || i3 == 2 || i3 == 3) ? false : true;
    }

    public static zzcb[] values() {
        return (zzcb[]) zzjd.clone();
    }

    public final int id() {
        return this.id;
    }
}
