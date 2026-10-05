package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: Gb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0538Gb {
    public static final String a = String.valueOf('.');
    public static final String b = String.valueOf('$');
    public static final Map c;
    public static final Map d;
    public static final Map e;
    public static final Map f;
    public static final Map g;

    static {
        HashMap map = new HashMap();
        c = map;
        Class cls = Boolean.TYPE;
        map.put(TypedValues.Custom.S_BOOLEAN, cls);
        Class cls2 = Byte.TYPE;
        map.put("byte", cls2);
        Class cls3 = Character.TYPE;
        map.put("char", cls3);
        Class cls4 = Short.TYPE;
        map.put("short", cls4);
        Class cls5 = Integer.TYPE;
        map.put("int", cls5);
        Class cls6 = Long.TYPE;
        map.put("long", cls6);
        Class cls7 = Double.TYPE;
        map.put(CSS.Value.DOUBLE, cls7);
        Class cls8 = Float.TYPE;
        map.put("float", cls8);
        Class cls9 = Void.TYPE;
        map.put("void", cls9);
        HashMap map2 = new HashMap();
        d = map2;
        map2.put(cls, Boolean.class);
        map2.put(cls2, Byte.class);
        map2.put(cls3, Character.class);
        map2.put(cls4, Short.class);
        map2.put(cls5, Integer.class);
        map2.put(cls6, Long.class);
        map2.put(cls7, Double.class);
        map2.put(cls8, Float.class);
        map2.put(cls9, cls9);
        e = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            Class cls10 = (Class) entry.getKey();
            Class cls11 = (Class) entry.getValue();
            if (!cls10.equals(cls11)) {
                e.put(cls11, cls10);
            }
        }
        HashMap map3 = new HashMap();
        map3.put("int", "I");
        map3.put(TypedValues.Custom.S_BOOLEAN, "Z");
        map3.put("float", "F");
        map3.put("long", "J");
        map3.put("short", "S");
        map3.put("byte", "B");
        map3.put(CSS.Value.DOUBLE, "D");
        map3.put("char", "C");
        HashMap map4 = new HashMap();
        for (Map.Entry entry2 : map3.entrySet()) {
            map4.put(entry2.getValue(), entry2.getKey());
        }
        f = Collections.unmodifiableMap(map3);
        g = Collections.unmodifiableMap(map4);
    }

    public static boolean a(Class cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || b(cls);
    }

    public static boolean b(Class cls) {
        return e.containsKey(cls);
    }
}
