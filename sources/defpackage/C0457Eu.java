package defpackage;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: Eu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0457Eu implements ObjectEncoderContext, ValueEncoderContext {
    public C0457Eu a = null;
    public boolean b = true;
    public final JsonWriter c;
    public final Map d;
    public final Map e;
    public final ObjectEncoder f;
    public final boolean g;

    public C0457Eu(Writer writer, Map map, Map map2, ObjectEncoder objectEncoder, boolean z) {
        this.c = new JsonWriter(writer);
        this.d = map;
        this.e = map2;
        this.f = objectEncoder;
        this.g = z;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(double d) throws IOException {
        s();
        this.c.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(float f) throws IOException {
        s();
        this.c.value(f);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(int i) throws IOException {
        s();
        this.c.value(i);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(long j) throws IOException {
        s();
        this.c.value(j);
        return this;
    }

    public C0457Eu e(Object obj, boolean z) throws IOException {
        int i = 0;
        if (z && n(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    e(it.next(), false);
                }
                this.c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        add((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.c.endObject();
                return this;
            }
            ObjectEncoder objectEncoder = (ObjectEncoder) this.d.get(obj.getClass());
            if (objectEncoder != null) {
                return p(objectEncoder, obj, z);
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return p(this.f, obj, z);
            }
            add(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return add((byte[]) obj);
        }
        this.c.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i < length) {
                this.c.value(iArr[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                add(jArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.c.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.c.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                e(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                e(obj2, false);
            }
        }
        this.c.endArray();
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(String str) throws IOException {
        s();
        this.c.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(String str, double d) throws IOException {
        s();
        this.c.name(str);
        return add(d);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(String str, int i) throws IOException {
        s();
        this.c.name(str);
        return add(i);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(String str, long j) throws IOException {
        s();
        this.c.name(str);
        return add(j);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext inline(Object obj) {
        return e(obj, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(String str, Object obj) {
        return this.g ? r(str, obj) : q(str, obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(String str, boolean z) throws IOException {
        s();
        this.c.name(str);
        return add(z);
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(boolean z) throws IOException {
        s();
        this.c.value(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0457Eu add(byte[] bArr) throws IOException {
        s();
        if (bArr == null) {
            this.c.nullValue();
        } else {
            this.c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final boolean n(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(String str) throws IOException {
        s();
        this.a = new C0457Eu(this);
        this.c.name(str);
        this.c.beginObject();
        return this.a;
    }

    public void o() throws IOException {
        s();
        this.c.flush();
    }

    public C0457Eu p(ObjectEncoder objectEncoder, Object obj, boolean z) throws IOException {
        if (!z) {
            this.c.beginObject();
        }
        objectEncoder.encode(obj, this);
        if (!z) {
            this.c.endObject();
        }
        return this;
    }

    public final C0457Eu q(String str, Object obj) throws IOException {
        s();
        this.c.name(str);
        if (obj != null) {
            return e(obj, false);
        }
        this.c.nullValue();
        return this;
    }

    public final C0457Eu r(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        s();
        this.c.name(str);
        return e(obj, false);
    }

    public final void s() throws IOException {
        if (!this.b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        C0457Eu c0457Eu = this.a;
        if (c0457Eu != null) {
            c0457Eu.s();
            this.a.b = false;
            this.a = null;
            this.c.endObject();
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        return nested(fieldDescriptor.getName());
    }

    public C0457Eu(C0457Eu c0457Eu) {
        this.c = c0457Eu.c;
        this.d = c0457Eu.d;
        this.e = c0457Eu.e;
        this.f = c0457Eu.f;
        this.g = c0457Eu.g;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return add(fieldDescriptor.getName(), obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) {
        return add(fieldDescriptor.getName(), f);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) {
        return add(fieldDescriptor.getName(), d);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) {
        return add(fieldDescriptor.getName(), i);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) {
        return add(fieldDescriptor.getName(), j);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) {
        return add(fieldDescriptor.getName(), z);
    }
}
