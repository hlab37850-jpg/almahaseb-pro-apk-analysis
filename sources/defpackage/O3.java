package defpackage;

import android.util.JsonReader;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import com.itextpdf.text.pdf.PdfBoolean;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class O3 extends JsonParser {
    public final JsonReader a;
    public final AndroidJsonFactory b;
    public List c = new ArrayList();
    public JsonToken d;
    public String e;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[android.util.JsonToken.values().length];
            b = iArr;
            try {
                iArr[android.util.JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[android.util.JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[android.util.JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[android.util.JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[android.util.JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[android.util.JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[android.util.JsonToken.STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[android.util.JsonToken.NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[android.util.JsonToken.NAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[JsonToken.values().length];
            a = iArr2;
            try {
                iArr2[JsonToken.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[JsonToken.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public O3(AndroidJsonFactory androidJsonFactory, JsonReader jsonReader) {
        this.b = androidJsonFactory;
        this.a = jsonReader;
        jsonReader.setLenient(true);
    }

    public final void a() {
        JsonToken jsonToken = this.d;
        Preconditions.checkArgument(jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT);
    }

    @Override // com.google.api.client.json.JsonParser
    public void close() throws IOException {
        this.a.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger getBigIntegerValue() {
        a();
        return new BigInteger(this.e);
    }

    @Override // com.google.api.client.json.JsonParser
    public byte getByteValue() {
        a();
        return Byte.valueOf(this.e).byteValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getCurrentName() {
        if (this.c.isEmpty()) {
            return null;
        }
        List list = this.c;
        return (String) list.get(list.size() - 1);
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken getCurrentToken() {
        return this.d;
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal getDecimalValue() {
        a();
        return new BigDecimal(this.e);
    }

    @Override // com.google.api.client.json.JsonParser
    public double getDoubleValue() {
        a();
        return Double.valueOf(this.e).doubleValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonFactory getFactory() {
        return this.b;
    }

    @Override // com.google.api.client.json.JsonParser
    public float getFloatValue() {
        a();
        return Float.valueOf(this.e).floatValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public int getIntValue() {
        a();
        return Integer.valueOf(this.e).intValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public long getLongValue() {
        a();
        return Long.valueOf(this.e).longValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public short getShortValue() {
        a();
        return Short.valueOf(this.e).shortValue();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getText() {
        return this.e;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken nextToken() throws IOException {
        android.util.JsonToken jsonTokenPeek;
        JsonToken jsonToken = this.d;
        if (jsonToken != null) {
            int i = a.a[jsonToken.ordinal()];
            if (i == 1) {
                this.a.beginArray();
                this.c.add(null);
            } else if (i == 2) {
                this.a.beginObject();
                this.c.add(null);
            }
        }
        try {
            jsonTokenPeek = this.a.peek();
        } catch (EOFException unused) {
            jsonTokenPeek = android.util.JsonToken.END_DOCUMENT;
        }
        switch (a.b[jsonTokenPeek.ordinal()]) {
            case 1:
                this.e = "[";
                this.d = JsonToken.START_ARRAY;
                break;
            case 2:
                this.e = "]";
                this.d = JsonToken.END_ARRAY;
                List list = this.c;
                list.remove(list.size() - 1);
                this.a.endArray();
                break;
            case 3:
                this.e = "{";
                this.d = JsonToken.START_OBJECT;
                break;
            case 4:
                this.e = "}";
                this.d = JsonToken.END_OBJECT;
                List list2 = this.c;
                list2.remove(list2.size() - 1);
                this.a.endObject();
                break;
            case 5:
                if (!this.a.nextBoolean()) {
                    this.e = PdfBoolean.FALSE;
                    this.d = JsonToken.VALUE_FALSE;
                } else {
                    this.e = PdfBoolean.TRUE;
                    this.d = JsonToken.VALUE_TRUE;
                }
                break;
            case 6:
                this.e = "null";
                this.d = JsonToken.VALUE_NULL;
                this.a.nextNull();
                break;
            case 7:
                this.e = this.a.nextString();
                this.d = JsonToken.VALUE_STRING;
                break;
            case 8:
                String strNextString = this.a.nextString();
                this.e = strNextString;
                this.d = strNextString.indexOf(46) == -1 ? JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_NUMBER_FLOAT;
                break;
            case 9:
                this.e = this.a.nextName();
                this.d = JsonToken.FIELD_NAME;
                List list3 = this.c;
                list3.set(list3.size() - 1, this.e);
                break;
            default:
                this.e = null;
                this.d = null;
                break;
        }
        return this.d;
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser skipChildren() throws IOException {
        JsonToken jsonToken = this.d;
        if (jsonToken != null) {
            int i = a.a[jsonToken.ordinal()];
            if (i == 1) {
                this.a.skipValue();
                this.e = "]";
                this.d = JsonToken.END_ARRAY;
            } else if (i == 2) {
                this.a.skipValue();
                this.e = "}";
                this.d = JsonToken.END_OBJECT;
            }
        }
        return this;
    }
}
