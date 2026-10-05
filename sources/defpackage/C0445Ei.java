package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: renamed from: Ei, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0445Ei implements InterfaceC4481zi {
    public Collection a;
    public Map b;
    public String c;
    public int d;

    public C0445Ei() {
    }

    @Override // defpackage.InterfaceC4481zi
    public C4390yi a(Map map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map map2 = this.b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.a;
        if (collection != null) {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        }
        String str = this.c;
        if (str != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, str);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(enumMap);
        int i = this.d;
        if (i == 0) {
            return new C4390yi(multiFormatReader);
        }
        if (i != 1) {
            return i != 2 ? new C4390yi(multiFormatReader) : new XB(multiFormatReader);
        }
        return new C0456Et(multiFormatReader);
    }

    public C0445Ei(Collection collection, Map map, String str, int i) {
        this.a = collection;
        this.b = map;
        this.c = str;
        this.d = i;
    }
}
