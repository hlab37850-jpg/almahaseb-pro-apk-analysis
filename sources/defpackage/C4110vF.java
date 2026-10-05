package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: vF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4110vF {
    public int[] a;
    public Map b;
    public AbstractC2428iF c;
    public int d;

    public C4110vF(String str, BF bf) {
        if (bf.t() == 4) {
            if (str.equals("Type0")) {
                this.d = 1;
                this.c = AbstractC2428iF.b(bf.s());
                return;
            } else {
                this.d = 0;
                this.b = new HashMap();
                this.a = a(bf.s());
                return;
            }
        }
        String strS = bf.j("Type").s();
        if (strS.equals("Encoding")) {
            this.d = 0;
            e(bf);
        } else if (strS.equals("CMap")) {
            this.d = 1;
            this.c = AbstractC2428iF.a(bf);
        } else {
            throw new IllegalArgumentException("Uknown encoding type: " + this.d);
        }
    }

    public final int[] a(String str) {
        if (str.equals("MacRomanEncoding")) {
            return AbstractC0424Dn.f;
        }
        if (str.equals("MacExpertEncoding")) {
            return AbstractC0424Dn.c;
        }
        if (str.equals("WinAnsiEncoding")) {
            return AbstractC0424Dn.h;
        }
        throw new IllegalArgumentException("Unknown encoding: " + str);
    }

    public final C4272xF b(AbstractC3948tF abstractC3948tF, char c) {
        int iC = this.c.c(c);
        char cD = this.c.d(c);
        if (abstractC3948tF instanceof IV) {
            abstractC3948tF = ((IV) abstractC3948tF).k(iC);
        }
        return abstractC3948tF.b(cD, null);
    }

    public final C4272xF c(AbstractC3948tF abstractC3948tF, char c) {
        String strB;
        char c2 = (char) (c & 255);
        if (this.b.containsKey(new Character(c2))) {
            strB = (String) this.b.get(new Character(c2));
        } else {
            int[] iArr = this.a;
            strB = iArr != null ? AbstractC0424Dn.b(iArr[c2]) : null;
        }
        return abstractC3948tF.b(c2, strB);
    }

    public List d(AbstractC3948tF abstractC3948tF, String str) {
        ArrayList arrayList = new ArrayList(str.length());
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            int i2 = this.d;
            if (i2 == 0) {
                arrayList.add(c(abstractC3948tF, charArray[i]));
            } else if (i2 == 1) {
                char c = (char) ((charArray[i] & 255) << 8);
                if (i < charArray.length - 1) {
                    i++;
                    c = (char) (c | ((char) (charArray[i] & 255)));
                }
                arrayList.add(b(abstractC3948tF, c));
            }
            i++;
        }
        return arrayList;
    }

    public void e(BF bf) {
        this.b = new HashMap();
        BF bfJ = bf.j("BaseEncoding");
        if (bfJ != null) {
            this.a = a(bfJ.s());
        }
        BF bfJ2 = bf.j("Differences");
        if (bfJ2 != null) {
            BF[] bfArrD = bfJ2.d();
            int iN = -1;
            for (int i = 0; i < bfArrD.length; i++) {
                if (bfArrD[i].t() == 2) {
                    iN = bfArrD[i].n();
                } else {
                    if (bfArrD[i].t() != 4) {
                        throw new IllegalArgumentException("Unexpected type in diff array: " + bfArrD[i]);
                    }
                    this.b.put(new Character((char) iN), bfArrD[i].s());
                    iN++;
                }
            }
        }
    }
}
