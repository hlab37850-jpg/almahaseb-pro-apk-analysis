package defpackage;

import com.google.zxing.common.BitMatrix;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: yh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EnumC4388yh {
    public static final EnumC4388yh a;
    public static final EnumC4388yh b;
    public static final EnumC4388yh c;
    public static final EnumC4388yh d;
    public static final EnumC4388yh e;
    public static final EnumC4388yh f;
    public static final EnumC4388yh g;
    public static final EnumC4388yh h;
    public static final /* synthetic */ EnumC4388yh[] i;

    /* JADX INFO: renamed from: yh$a */
    public static enum a extends EnumC4388yh {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.EnumC4388yh
        public boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        a = aVar;
        EnumC4388yh enumC4388yh = new EnumC4388yh("DATA_MASK_001", 1) { // from class: yh.b
            {
                a aVar2 = null;
            }

            @Override // defpackage.EnumC4388yh
            public boolean a(int i2, int i3) {
                return (i2 & 1) == 0;
            }
        };
        b = enumC4388yh;
        EnumC4388yh enumC4388yh2 = new EnumC4388yh("DATA_MASK_010", 2) { // from class: yh.c
            {
                a aVar2 = null;
            }

            @Override // defpackage.EnumC4388yh
            public boolean a(int i2, int i3) {
                return i3 % 3 == 0;
            }
        };
        c = enumC4388yh2;
        EnumC4388yh enumC4388yh3 = new EnumC4388yh("DATA_MASK_011", 3) { // from class: yh.d
            {
                a aVar2 = null;
            }

            @Override // defpackage.EnumC4388yh
            public boolean a(int i2, int i3) {
                return (i2 + i3) % 3 == 0;
            }
        };
        d = enumC4388yh3;
        EnumC4388yh enumC4388yh4 = new EnumC4388yh("DATA_MASK_100", 4) { // from class: yh.e
            {
                a aVar2 = null;
            }

            @Override // defpackage.EnumC4388yh
            public boolean a(int i2, int i3) {
                return (((i2 / 2) + (i3 / 3)) & 1) == 0;
            }
        };
        e = enumC4388yh4;
        EnumC4388yh enumC4388yh5 = new EnumC4388yh("DATA_MASK_101", 5) { // from class: yh.f
            {
                a aVar2 = null;
            }

            @Override // defpackage.EnumC4388yh
            public boolean a(int i2, int i3) {
                return (i2 * i3) % 6 == 0;
            }
        };
        f = enumC4388yh5;
        EnumC4388yh enumC4388yh6 = new EnumC4388yh("DATA_MASK_110", 6) { // from class: yh.g
            {
                a aVar2 = null;
            }

            @Override // defpackage.EnumC4388yh
            public boolean a(int i2, int i3) {
                return (i2 * i3) % 6 < 3;
            }
        };
        g = enumC4388yh6;
        EnumC4388yh enumC4388yh7 = new EnumC4388yh("DATA_MASK_111", 7) { // from class: yh.h
            {
                a aVar2 = null;
            }

            @Override // defpackage.EnumC4388yh
            public boolean a(int i2, int i3) {
                return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
            }
        };
        h = enumC4388yh7;
        i = new EnumC4388yh[]{aVar, enumC4388yh, enumC4388yh2, enumC4388yh3, enumC4388yh4, enumC4388yh5, enumC4388yh6, enumC4388yh7};
    }

    public EnumC4388yh(String str, int i2) {
        super(str, i2);
    }

    public static EnumC4388yh valueOf(String str) {
        return (EnumC4388yh) Enum.valueOf(EnumC4388yh.class, str);
    }

    public static EnumC4388yh[] values() {
        return (EnumC4388yh[]) i.clone();
    }

    public abstract boolean a(int i2, int i3);

    public final void b(BitMatrix bitMatrix, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    bitMatrix.flip(i4, i3);
                }
            }
        }
    }

    public /* synthetic */ EnumC4388yh(String str, int i2, a aVar) {
        this(str, i2);
    }
}
