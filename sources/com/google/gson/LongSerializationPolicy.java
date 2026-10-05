package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LongSerializationPolicy {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES;
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    public final enum a extends LongSerializationPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return l == null ? JsonNull.INSTANCE : new JsonPrimitive(l);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        DEFAULT = aVar;
        LongSerializationPolicy longSerializationPolicy = new LongSerializationPolicy("STRING", 1) { // from class: com.google.gson.LongSerializationPolicy.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.LongSerializationPolicy
            public JsonElement serialize(Long l) {
                return l == null ? JsonNull.INSTANCE : new JsonPrimitive(l.toString());
            }
        };
        STRING = longSerializationPolicy;
        $VALUES = new LongSerializationPolicy[]{aVar, longSerializationPolicy};
    }

    private LongSerializationPolicy(String str, int i) {
        super(str, i);
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    public abstract JsonElement serialize(Long l);

    public /* synthetic */ LongSerializationPolicy(String str, int i, a aVar) {
        this(str, i);
    }
}
