package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LV extends AbstractC3948tF {
    public HashMap g;
    public Map h;
    public RectF i;
    public Matrix j;
    public float[] k;
    public int l;
    public int m;

    public LV(String str, BF bf, HashMap map, C4029uF c4029uF) {
        super(str, c4029uF);
        HashMap map2 = new HashMap();
        this.g = map2;
        if (map != null) {
            map2.putAll(map);
        }
        BF bfJ = bf.j("FontMatrix");
        float[] fArr = new float[6];
        for (int i = 0; i < 6; i++) {
            fArr[i] = bfJ.e(i).m();
        }
        this.j = AbstractC4128vX.b(fArr);
        BF bfJ2 = bf.j("Resources");
        if (bfJ2 != null) {
            this.g.putAll(bfJ2.k());
        }
        this.h = bf.j("CharProcs").k();
        BF[] bfArrD = bf.j("FontBBox").d();
        float[] fArr2 = new float[4];
        for (int i2 = 0; i2 < 4; i2++) {
            fArr2[i2] = bfArrD[i2].m();
        }
        float f = fArr2[0];
        float f2 = fArr2[1];
        RectF rectF = new RectF(f, f2, fArr2[2] - f, fArr2[3] - f2);
        this.i = rectF;
        if (rectF.isEmpty()) {
            this.i = null;
        }
        BF[] bfArrD2 = bf.j("Widths").d();
        this.k = new float[bfArrD2.length];
        for (int i3 = 0; i3 < bfArrD2.length; i3++) {
            this.k[i3] = bfArrD2[i3].m();
        }
        this.l = bf.j("FirstChar").n();
        this.m = bf.j("LastChar").n();
    }

    @Override // defpackage.AbstractC3948tF
    public C4272xF e(char c, String str) {
        if (str == null) {
            throw new IllegalArgumentException("Glyph name required for Type3 font!Source character: " + ((int) c));
        }
        BF bf = (BF) this.h.get(str);
        if (bf == null) {
            return new C4272xF(c, str, new Path(), new PointF(0.0f, 0.0f));
        }
        try {
            CF cf = new CF(this.i, 0);
            cf.q(this.j);
            new FF(cf, bf.q(), this.g).d(true);
            PointF pointF = new PointF(this.k[c - this.l], 0.0f);
            float[] fArr = {pointF.x, pointF.y};
            this.j.mapPoints(fArr);
            pointF.x = fArr[0];
            pointF.y = fArr[1];
            return new C4272xF(c, str, cf, pointF);
        } catch (IOException e) {
            System.out.println("IOException in Type3 font: " + e);
            e.printStackTrace();
            return null;
        }
    }
}
