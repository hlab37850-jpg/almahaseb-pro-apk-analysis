package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ToNumberPolicy implements ToNumberStrategy {
    private static final /* synthetic */ ToNumberPolicy[] $VALUES;
    public static final ToNumberPolicy BIG_DECIMAL;
    public static final ToNumberPolicy DOUBLE;
    public static final ToNumberPolicy LAZILY_PARSED_NUMBER;
    public static final ToNumberPolicy LONG_OR_DOUBLE;

    public final enum a extends ToNumberPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.ToNumberStrategy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double readNumber(JsonReader jsonReader) {
            return Double.valueOf(jsonReader.nextDouble());
        }
    }

    static {
        a aVar = new a("DOUBLE", 0);
        DOUBLE = aVar;
        ToNumberPolicy toNumberPolicy = new ToNumberPolicy("LAZILY_PARSED_NUMBER", 1) { // from class: com.google.gson.ToNumberPolicy.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.ToNumberStrategy
            public Number readNumber(JsonReader jsonReader) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
        };
        LAZILY_PARSED_NUMBER = toNumberPolicy;
        ToNumberPolicy toNumberPolicy2 = new ToNumberPolicy("LONG_OR_DOUBLE", 2) { // from class: com.google.gson.ToNumberPolicy.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.ToNumberStrategy
            public Number readNumber(JsonReader jsonReader) throws IOException {
                String strNextString = jsonReader.nextString();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strNextString));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strNextString);
                        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                            if (!jsonReader.isLenient()) {
                                throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.getPreviousPath());
                            }
                        }
                        return dValueOf;
                    }
                } catch (NumberFormatException e) {
                    throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPreviousPath(), e);
                }
            }
        };
        LONG_OR_DOUBLE = toNumberPolicy2;
        ToNumberPolicy toNumberPolicy3 = new ToNumberPolicy("BIG_DECIMAL", 3) { // from class: com.google.gson.ToNumberPolicy.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.ToNumberStrategy
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
                String strNextString = jsonReader.nextString();
                try {
                    return new BigDecimal(strNextString);
                } catch (NumberFormatException e) {
                    throw new JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPreviousPath(), e);
                }
            }
        };
        BIG_DECIMAL = toNumberPolicy3;
        $VALUES = new ToNumberPolicy[]{aVar, toNumberPolicy, toNumberPolicy2, toNumberPolicy3};
    }

    private ToNumberPolicy(String str, int i) {
        super(str, i);
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) $VALUES.clone();
    }

    public /* synthetic */ ToNumberPolicy(String str, int i, a aVar) {
        this(str, i);
    }
}
