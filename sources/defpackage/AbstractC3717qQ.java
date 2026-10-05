package defpackage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: renamed from: qQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3717qQ {
    public static RU[] a(String str, Map map, Map map2, Set set) {
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        TU tu = new TU(str, map, map2, set);
        while (tu.c()) {
            RU ruJ = tu.j();
            switch (ruJ.a()) {
                case 1:
                case 6:
                    arrayList.add(ruJ);
                    break;
                case 2:
                    while (!stack.empty() && ((RU) stack.peek()).a() == 2) {
                        VE ve = (VE) ruJ;
                        VE ve2 = (VE) stack.peek();
                        if ((ve.b().b() == 1 && ve2.b().b() == 2) || ((!ve.b().e() || ve.b().c() > ve2.b().c()) && ve.b().c() >= ve2.b().c())) {
                            stack.push(ruJ);
                        } else {
                            arrayList.add(stack.pop());
                        }
                        break;
                    }
                    stack.push(ruJ);
                    break;
                case 3:
                    stack.add(ruJ);
                    break;
                case 4:
                    stack.push(ruJ);
                    break;
                case 5:
                    while (((RU) stack.peek()).a() != 4) {
                        arrayList.add(stack.pop());
                    }
                    stack.pop();
                    if (!stack.isEmpty() && ((RU) stack.peek()).a() == 3) {
                        arrayList.add(stack.pop());
                    }
                    break;
                case 7:
                    while (!stack.empty() && ((RU) stack.peek()).a() != 4) {
                        arrayList.add(stack.pop());
                    }
                    if (stack.empty() || ((RU) stack.peek()).a() != 4) {
                        throw new IllegalArgumentException("Misplaced function separator ',' or mismatched parentheses");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown Token type encountered. This should not happen");
            }
        }
        while (!stack.empty()) {
            RU ru2 = (RU) stack.pop();
            if (ru2.a() == 5 || ru2.a() == 4) {
                throw new IllegalArgumentException("Mismatched parentheses detected. Please check the expression");
            }
            arrayList.add(ru2);
        }
        return (RU[]) arrayList.toArray(new RU[arrayList.size()]);
    }
}
