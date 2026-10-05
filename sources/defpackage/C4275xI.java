package defpackage;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.proto.a;

/* JADX INFO: renamed from: xI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4275xI implements ValueEncoderContext {
    public boolean a = false;
    public boolean b = false;
    public FieldDescriptor c;
    public final a d;

    public C4275xI(a aVar) {
        this.d = aVar;
    }

    public final void a() {
        if (this.a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.a = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(String str) {
        a();
        this.d.d(this.c, str, this.b);
        return this;
    }

    public void b(FieldDescriptor fieldDescriptor, boolean z) {
        this.a = false;
        this.c = fieldDescriptor;
        this.b = z;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(float f) {
        a();
        this.d.c(this.c, f, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(double d) {
        a();
        this.d.b(this.c, d, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(int i) {
        a();
        this.d.f(this.c, i, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(long j) {
        a();
        this.d.h(this.c, j, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(boolean z) {
        a();
        this.d.j(this.c, z, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public ValueEncoderContext add(byte[] bArr) {
        a();
        this.d.d(this.c, bArr, this.b);
        return this;
    }
}
