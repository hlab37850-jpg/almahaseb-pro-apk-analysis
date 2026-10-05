package info.aalmoghalis.inventory.printBT;

import com.zebra.sdk.util.internal.StringUtilities;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Format {
    public EnumC0321a a;
    public int b;

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.printBT.a$a, reason: collision with other inner class name */
    public enum EnumC0321a {
        LEFT,
        CENTER,
        RIGHT
    }

    public a(int i, EnumC0321a enumC0321a) {
        int iOrdinal = enumC0321a.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1 && iOrdinal != 2) {
            throw new IllegalArgumentException("invalid justification arg.");
        }
        this.a = enumC0321a;
        if (i < 0) {
            throw new IllegalArgumentException("maxChars must be positive.");
        }
        this.b = i;
    }

    public final void a(StringBuffer stringBuffer, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(' ');
        }
    }

    public final List b(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        int i = 0;
        while (i < str.length()) {
            arrayList.add(str.substring(i, Math.min(this.b + i, str.length())));
            i += this.b;
        }
        return arrayList;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        ListIterator listIterator = b(obj.toString()).listIterator();
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            int iOrdinal = this.a.ordinal();
            if (iOrdinal == 0) {
                stringBuffer.append(str);
                a(stringBuffer, this.b - str.length());
            } else if (iOrdinal == 1) {
                int length = this.b - str.length();
                int i = length / 2;
                a(stringBuffer, i);
                stringBuffer.append(str);
                a(stringBuffer, length - i);
            } else if (iOrdinal == 2) {
                a(stringBuffer, this.b - str.length());
                stringBuffer.append(str);
            }
            stringBuffer.append(StringUtilities.LF);
        }
        return stringBuffer;
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return str;
    }
}
