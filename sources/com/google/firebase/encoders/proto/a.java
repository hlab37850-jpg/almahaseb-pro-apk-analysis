package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.a;
import com.itextpdf.text.xml.xmp.XmpWriter;
import defpackage.C4275xI;
import defpackage.C4413yv;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ObjectEncoderContext {
    public static final Charset f = Charset.forName(XmpWriter.UTF8);
    public static final FieldDescriptor g = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();
    public static final FieldDescriptor h = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();
    public static final ObjectEncoder i = new ObjectEncoder() { // from class: vI
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void encode(Object obj, Object obj2) {
            a.r((Map.Entry) obj, (ObjectEncoderContext) obj2);
        }
    };
    public OutputStream a;
    public final Map b;
    public final Map c;
    public final ObjectEncoder d;
    public final C4275xI e = new C4275xI(this);

    /* JADX INFO: renamed from: com.google.firebase.encoders.proto.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0268a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.a = outputStream;
        this.b = map;
        this.c = map2;
        this.d = objectEncoder;
    }

    public static ByteBuffer k(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static Protobuf p(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static int q(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static /* synthetic */ void r(Map.Entry entry, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(g, entry.getKey());
        objectEncoderContext.add(h, entry.getValue());
    }

    public ObjectEncoderContext b(FieldDescriptor fieldDescriptor, double d, boolean z) {
        if (z && d == 0.0d) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 1);
        this.a.write(k(8).putDouble(d).array());
        return this;
    }

    public ObjectEncoderContext c(FieldDescriptor fieldDescriptor, float f2, boolean z) {
        if (z && f2 == 0.0f) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 5);
        this.a.write(k(4).putFloat(f2).array());
        return this;
    }

    public ObjectEncoderContext d(FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            s((q(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            s(bytes.length);
            this.a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                d(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m(i, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return b(fieldDescriptor, ((Double) obj).doubleValue(), z);
        }
        if (obj instanceof Float) {
            return c(fieldDescriptor, ((Float) obj).floatValue(), z);
        }
        if (obj instanceof Number) {
            return h(fieldDescriptor, ((Number) obj).longValue(), z);
        }
        if (obj instanceof Boolean) {
            return j(fieldDescriptor, ((Boolean) obj).booleanValue(), z);
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            s((q(fieldDescriptor) << 3) | 2);
            s(bArr.length);
            this.a.write(bArr);
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.b.get(obj.getClass());
        if (objectEncoder != null) {
            return m(objectEncoder, fieldDescriptor, obj, z);
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.c.get(obj.getClass());
        if (valueEncoder != null) {
            return n(valueEncoder, fieldDescriptor, obj, z);
        }
        if (obj instanceof ProtoEnum) {
            return add(fieldDescriptor, ((ProtoEnum) obj).getNumber());
        }
        return obj instanceof Enum ? add(fieldDescriptor, ((Enum) obj).ordinal()) : m(this.d, fieldDescriptor, obj, z);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public a add(FieldDescriptor fieldDescriptor, int i2) {
        return f(fieldDescriptor, i2, true);
    }

    public a f(FieldDescriptor fieldDescriptor, int i2, boolean z) {
        if (z && i2 == 0) {
            return this;
        }
        Protobuf protobufP = p(fieldDescriptor);
        int i3 = C0268a.a[protobufP.intEncoding().ordinal()];
        if (i3 == 1) {
            s(protobufP.tag() << 3);
            s(i2);
        } else if (i3 == 2) {
            s(protobufP.tag() << 3);
            s((i2 << 1) ^ (i2 >> 31));
        } else if (i3 == 3) {
            s((protobufP.tag() << 3) | 5);
            this.a.write(k(4).putInt(i2).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a add(FieldDescriptor fieldDescriptor, long j) {
        return h(fieldDescriptor, j, true);
    }

    public a h(FieldDescriptor fieldDescriptor, long j, boolean z) {
        if (z && j == 0) {
            return this;
        }
        Protobuf protobufP = p(fieldDescriptor);
        int i2 = C0268a.a[protobufP.intEncoding().ordinal()];
        if (i2 == 1) {
            s(protobufP.tag() << 3);
            t(j);
        } else if (i2 == 2) {
            s(protobufP.tag() << 3);
            t((j >> 63) ^ (j << 1));
        } else if (i2 == 3) {
            s((protobufP.tag() << 3) | 1);
            this.a.write(k(8).putLong(j).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public a add(FieldDescriptor fieldDescriptor, boolean z) {
        return j(fieldDescriptor, z, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext inline(Object obj) {
        return o(obj);
    }

    public a j(FieldDescriptor fieldDescriptor, boolean z, boolean z2) {
        return f(fieldDescriptor, z ? 1 : 0, z2);
    }

    public final long l(ObjectEncoder objectEncoder, Object obj) throws IOException {
        C4413yv c4413yv = new C4413yv();
        try {
            OutputStream outputStream = this.a;
            this.a = c4413yv;
            try {
                objectEncoder.encode(obj, this);
                this.a = outputStream;
                long jC = c4413yv.c();
                c4413yv.close();
                return jC;
            } catch (Throwable th) {
                this.a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                c4413yv.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final a m(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        long jL = l(objectEncoder, obj);
        if (z && jL == 0) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 2);
        t(jL);
        objectEncoder.encode(obj, this);
        return this;
    }

    public final a n(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        this.e.b(fieldDescriptor, z);
        valueEncoder.encode(obj, this.e);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(String str) {
        return nested(FieldDescriptor.of(str));
    }

    public a o(Object obj) {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    public final void s(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            this.a.write((i2 & ShapeTypes.VERTICAL_SCROLL) | 128);
            i2 >>>= 7;
        }
        this.a.write(i2 & ShapeTypes.VERTICAL_SCROLL);
    }

    public final void t(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.a.write((((int) j) & ShapeTypes.VERTICAL_SCROLL) | 128);
            j >>>= 7;
        }
        this.a.write(((int) j) & ShapeTypes.VERTICAL_SCROLL);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, Object obj) {
        return add(FieldDescriptor.of(str), obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, double d) {
        return add(FieldDescriptor.of(str), d);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, int i2) {
        return add(FieldDescriptor.of(str), i2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, long j) {
        return add(FieldDescriptor.of(str), j);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, boolean z) {
        return add(FieldDescriptor.of(str), z);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return d(fieldDescriptor, obj, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) {
        return b(fieldDescriptor, d, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f2) {
        return c(fieldDescriptor, f2, true);
    }
}
