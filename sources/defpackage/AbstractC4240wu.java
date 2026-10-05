package defpackage;

import com.fasterxml.jackson.core.a;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: wu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC4240wu extends AbstractC2228fq {
    public static final int[] j = AbstractC3484nb.e();
    public final C0918Sr f;
    public int[] g;
    public int h;
    public IO i;

    public AbstractC4240wu(C0918Sr c0918Sr, int i, AbstractC2263gE abstractC2263gE) {
        super(i, abstractC2263gE);
        this.g = j;
        this.i = C0693Ki.f;
        this.f = c0918Sr;
        if (S(a.EnumC0168a.ESCAPE_NON_ASCII)) {
            T(ShapeTypes.VERTICAL_SCROLL);
        }
    }

    public a T(int i) {
        if (i < 0) {
            i = 0;
        }
        this.h = i;
        return this;
    }

    public a U(IO io) {
        this.i = io;
        return this;
    }
}
