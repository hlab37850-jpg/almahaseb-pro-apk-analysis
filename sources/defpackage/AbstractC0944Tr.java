package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: renamed from: Tr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0944Tr implements InterfaceC3544oG {
    public static final Logger b = Logger.getLogger(AbstractC0944Tr.class.getName());

    /* JADX INFO: renamed from: Tr$a */
    public static class a {
        public VF a;
        public List b = new ArrayList();

        public a(VF vf) {
            this.a = vf;
        }

        public void a() {
            this.a = null;
            this.b = new ArrayList();
        }

        public VF b(byte[] bArr) {
            this.b.add(bArr);
            int size = this.b.size();
            VF vf = this.a;
            if (size != vf.e) {
                return null;
            }
            List list = this.b;
            VF vfD = X7.d(vf, (byte[][]) list.toArray(new byte[list.size()][]));
            a();
            return vfD;
        }
    }

    /* JADX INFO: renamed from: Tr$c */
    public static final class c implements InterfaceC3544oG.b {
        @Override // defpackage.InterfaceC3544oG.b
        public void a(VF vf, InterfaceC3544oG.b.a aVar) {
            int i = vf.a;
            if ((i == 2 || i == 3) && AbstractC3180jr.b(vf.d)) {
                vf.a = vf.a == 2 ? 5 : 6;
            }
            if (AbstractC0944Tr.b.isLoggable(Level.FINE)) {
                AbstractC0944Tr.b.fine(String.format("encoding packet %s", vf));
            }
            int i2 = vf.a;
            if (5 == i2 || 6 == i2) {
                b(vf, aVar);
            } else {
                aVar.call(new String[]{c(vf)});
            }
        }

        public final void b(VF vf, InterfaceC3544oG.b.a aVar) {
            X7.a aVarC = X7.c(vf);
            String strC = c(aVarC.a);
            ArrayList arrayList = new ArrayList(Arrays.asList(aVarC.b));
            arrayList.add(0, strC);
            aVar.call(arrayList.toArray());
        }

        public final String c(VF vf) {
            StringBuilder sb = new StringBuilder("" + vf.a);
            int i = vf.a;
            if (5 == i || 6 == i) {
                sb.append(vf.e);
                sb.append("-");
            }
            String str = vf.c;
            if (str != null && str.length() != 0 && !"/".equals(vf.c)) {
                sb.append(vf.c);
                sb.append(",");
            }
            int i2 = vf.b;
            if (i2 >= 0) {
                sb.append(i2);
            }
            Object obj = vf.d;
            if (obj != null) {
                sb.append(obj);
            }
            if (AbstractC0944Tr.b.isLoggable(Level.FINE)) {
                AbstractC0944Tr.b.fine(String.format("encoded %s as %s", vf, sb));
            }
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: Tr$b */
    public static final class b implements InterfaceC3544oG.a {
        public a a = null;
        public InterfaceC3544oG.a.InterfaceC0327a b;

        public static VF b(String str) {
            int i;
            int i2;
            int length = str.length();
            VF vf = new VF(Character.getNumericValue(str.charAt(0)));
            int i3 = vf.a;
            if (i3 < 0 || i3 > InterfaceC3544oG.a.length - 1) {
                throw new C0393Ci("unknown packet type " + vf.a);
            }
            if (5 != i3 && 6 != i3) {
                i = 0;
            } else {
                if (!str.contains("-") || length <= 1) {
                    throw new C0393Ci("illegal attachments");
                }
                StringBuilder sb = new StringBuilder();
                i = 0;
                while (true) {
                    i++;
                    if (str.charAt(i) == '-') {
                        break;
                    }
                    sb.append(str.charAt(i));
                }
                vf.e = Integer.parseInt(sb.toString());
            }
            int i4 = i + 1;
            if (length <= i4 || '/' != str.charAt(i4)) {
                vf.c = "/";
            } else {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    i2 = i + 1;
                    char cCharAt = str.charAt(i2);
                    if (',' == cCharAt) {
                        break;
                    }
                    sb2.append(cCharAt);
                    if (i + 2 == length) {
                        break;
                    }
                    i = i2;
                }
                vf.c = sb2.toString();
                i = i2;
            }
            int i5 = i + 1;
            if (length > i5 && Character.getNumericValue(str.charAt(i5)) > -1) {
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    int i6 = i + 1;
                    char cCharAt2 = str.charAt(i6);
                    if (Character.getNumericValue(cCharAt2) < 0) {
                        break;
                    }
                    sb3.append(cCharAt2);
                    if (i + 2 == length) {
                        i = i6;
                        break;
                    }
                    i = i6;
                }
                try {
                    vf.b = Integer.parseInt(sb3.toString());
                } catch (NumberFormatException unused) {
                    throw new C0393Ci("invalid payload");
                }
            }
            int i7 = i + 1;
            if (length > i7) {
                try {
                    str.charAt(i7);
                    Object objNextValue = new JSONTokener(str.substring(i7)).nextValue();
                    vf.d = objNextValue;
                    if (!c(vf.a, objNextValue)) {
                        throw new C0393Ci("invalid payload");
                    }
                } catch (JSONException e) {
                    AbstractC0944Tr.b.log(Level.WARNING, "An error occured while retrieving data from JSONTokener", (Throwable) e);
                    throw new C0393Ci("invalid payload");
                }
            }
            if (AbstractC0944Tr.b.isLoggable(Level.FINE)) {
                AbstractC0944Tr.b.fine(String.format("decoded %s as %s", str, vf));
            }
            return vf;
        }

        public static boolean c(int i, Object obj) {
            switch (i) {
                case 0:
                case 4:
                    return obj instanceof JSONObject;
                case 1:
                    return obj == null;
                case 2:
                case 5:
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray.length() > 0 && !jSONArray.isNull(0)) {
                            return true;
                        }
                    }
                    return false;
                case 3:
                case 6:
                    return obj instanceof JSONArray;
                default:
                    return false;
            }
        }

        @Override // defpackage.InterfaceC3544oG.a
        public void a(InterfaceC3544oG.a.InterfaceC0327a interfaceC0327a) {
            this.b = interfaceC0327a;
        }

        @Override // defpackage.InterfaceC3544oG.a
        public void add(String str) {
            InterfaceC3544oG.a.InterfaceC0327a interfaceC0327a;
            VF vfB = b(str);
            int i = vfB.a;
            if (5 != i && 6 != i) {
                InterfaceC3544oG.a.InterfaceC0327a interfaceC0327a2 = this.b;
                if (interfaceC0327a2 != null) {
                    interfaceC0327a2.a(vfB);
                    return;
                }
                return;
            }
            a aVar = new a(vfB);
            this.a = aVar;
            if (aVar.a.e != 0 || (interfaceC0327a = this.b) == null) {
                return;
            }
            interfaceC0327a.a(vfB);
        }

        @Override // defpackage.InterfaceC3544oG.a
        public void destroy() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a();
            }
            this.b = null;
        }

        @Override // defpackage.InterfaceC3544oG.a
        public void add(byte[] bArr) {
            a aVar = this.a;
            if (aVar != null) {
                VF vfB = aVar.b(bArr);
                if (vfB != null) {
                    this.a = null;
                    InterfaceC3544oG.a.InterfaceC0327a interfaceC0327a = this.b;
                    if (interfaceC0327a != null) {
                        interfaceC0327a.a(vfB);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("got binary data when not reconstructing a packet");
        }
    }
}
