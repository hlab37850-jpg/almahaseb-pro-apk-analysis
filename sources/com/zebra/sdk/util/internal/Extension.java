package com.zebra.sdk.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public enum Extension {
    TXT(ObjectType.TXTobj),
    CSV(ObjectType.CSVobj),
    BAS(ObjectType.BASICobj),
    BAE(ObjectType.BAEobj),
    HTM(ObjectType.HTMobj),
    WML(ObjectType.WMLobj),
    EPL(ObjectType.EFORMATobj),
    PAC(ObjectType.PAC_FASTobj),
    NRD(ObjectType.NRD_TLSobj),
    TTE(ObjectType.TTEobj),
    TTF(ObjectType.TTFobj),
    ASC(ObjectType.ASCobj),
    IMG(ObjectType.IMGobj),
    BMP(ObjectType.BMPobj),
    PCX(ObjectType.PCXobj),
    ZPL(ObjectType.FORMATobj),
    DBC(ObjectType.DBCobj),
    PNG(ObjectType.PIMAGEobj),
    GRF(ObjectType.GIMAGEobj),
    KEY(ObjectType.KEYobj),
    FNT(ObjectType.FONTobj);

    private ObjectType type;

    Extension(ObjectType objectType) {
        this.type = objectType;
    }

    public static int getTypeValue(String str) {
        Extension extensionValueOf = valueOf(str.toUpperCase());
        return (extensionValueOf == null ? ObjectType.ANYobj : extensionValueOf.getType()).ordinal();
    }

    public ObjectType getType() {
        return this.type;
    }
}
