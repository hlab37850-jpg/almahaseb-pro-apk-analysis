package defpackage;

import com.fasterxml.jackson.core.a;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: renamed from: Qt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0868Qt extends JsonGenerator {
    public final a a;
    public final JacksonFactory b;

    public C0868Qt(JacksonFactory jacksonFactory, a aVar) {
        this.b = jacksonFactory;
        this.a = aVar;
    }

    @Override // com.google.api.client.json.JsonGenerator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JacksonFactory getFactory() {
        return this.b;
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void close() {
        this.a.close();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void enablePrettyPrint() {
        this.a.g();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void flush() {
        this.a.flush();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeBoolean(boolean z) {
        this.a.i(z);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndArray() {
        this.a.r();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeEndObject() {
        this.a.t();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeFieldName(String str) {
        this.a.u(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNull() {
        this.a.v();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(int i) {
        this.a.A(i);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartArray() {
        this.a.M();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeStartObject() {
        this.a.N();
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeString(String str) {
        this.a.O(str);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(long j) {
        this.a.C(j);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigInteger bigInteger) {
        this.a.H(bigInteger);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(double d) {
        this.a.x(d);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(float f) {
        this.a.z(f);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) {
        this.a.G(bigDecimal);
    }

    @Override // com.google.api.client.json.JsonGenerator
    public void writeNumber(String str) {
        this.a.F(str);
    }
}
