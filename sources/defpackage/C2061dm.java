package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: renamed from: dm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2061dm {
    public final RU[] a;
    public final Map b = new HashMap(4);
    public final Set c;

    public C2061dm(RU[] ruArr, Set set) {
        this.a = ruArr;
        this.c = set;
    }

    public double a() {
        Stack stack = new Stack();
        int i = 0;
        while (true) {
            RU[] ruArr = this.a;
            if (i >= ruArr.length) {
                if (stack.size() <= 1) {
                    return ((Double) stack.pop()).doubleValue();
                }
                throw new IllegalArgumentException("Invalid number of items on the output queue. Might be caused by an invalid number of arguments for a function.");
            }
            RU ru2 = ruArr[i];
            if (ru2.a() == 1) {
                stack.push(Double.valueOf(((C2099eE) ru2).b()));
            } else if (ru2.a() == 6) {
                String strB = ((AX) ru2).b();
                Double d = (Double) this.b.get(strB);
                if (d == null) {
                    throw new IllegalArgumentException("No value has been set for the setVariable '" + strB + "'.");
                }
                stack.push(d);
            } else if (ru2.a() == 2) {
                VE ve = (VE) ru2;
                if (stack.size() < ve.b().b()) {
                    throw new IllegalArgumentException("Invalid number of operands available");
                }
                if (ve.b().b() == 2) {
                    stack.push(Double.valueOf(ve.b().a(((Double) stack.pop()).doubleValue(), ((Double) stack.pop()).doubleValue())));
                } else if (ve.b().b() == 1) {
                    stack.push(Double.valueOf(ve.b().a(((Double) stack.pop()).doubleValue())));
                }
            } else if (ru2.a() == 3) {
                C0942Tp c0942Tp = (C0942Tp) ru2;
                if (stack.size() < c0942Tp.b().b()) {
                    throw new IllegalArgumentException("Invalid number of arguments available");
                }
                double[] dArr = new double[c0942Tp.b().b()];
                for (int i2 = 0; i2 < c0942Tp.b().b(); i2++) {
                    dArr[i2] = ((Double) stack.pop()).doubleValue();
                }
                stack.push(Double.valueOf(c0942Tp.b().a(b(dArr))));
            } else {
                continue;
            }
            i++;
        }
    }

    public final double[] b(double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length / 2; i++) {
            double d = dArr[i];
            int i2 = (length - i) - 1;
            dArr[i] = dArr[i2];
            dArr[i2] = d;
        }
        return dArr;
    }
}
