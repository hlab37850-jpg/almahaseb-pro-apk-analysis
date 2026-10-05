package defpackage;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: renamed from: Rt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0894Rt extends JsonParser {
    public final com.fasterxml.jackson.core.JsonParser a;
    public final JacksonFactory b;

    public C0894Rt(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonParser jsonParser) {
        this.b = jacksonFactory;
        this.a = jsonParser;
    }

    @Override // com.google.api.client.json.JsonParser
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JacksonFactory getFactory() {
        return this.b;
    }

    @Override // com.google.api.client.json.JsonParser
    public void close() {
        this.a.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger getBigIntegerValue() {
        return this.a.d();
    }

    @Override // com.google.api.client.json.JsonParser
    public byte getByteValue() {
        return this.a.g();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getCurrentName() {
        return this.a.r();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken getCurrentToken() {
        return JacksonFactory.convert(this.a.t());
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal getDecimalValue() {
        return this.a.u();
    }

    @Override // com.google.api.client.json.JsonParser
    public double getDoubleValue() {
        return this.a.v();
    }

    @Override // com.google.api.client.json.JsonParser
    public float getFloatValue() {
        return this.a.x();
    }

    @Override // com.google.api.client.json.JsonParser
    public int getIntValue() {
        return this.a.z();
    }

    @Override // com.google.api.client.json.JsonParser
    public long getLongValue() {
        return this.a.A();
    }

    @Override // com.google.api.client.json.JsonParser
    public short getShortValue() {
        return this.a.C();
    }

    @Override // com.google.api.client.json.JsonParser
    public String getText() {
        return this.a.F();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken nextToken() {
        return JacksonFactory.convert(this.a.H());
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser skipChildren() {
        this.a.I();
        return this;
    }
}
