package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayValueMap {
    private final Object destination;
    private final Map<String, a> keyMap = ArrayMap.create();
    private final Map<Field, a> fieldMap = ArrayMap.create();

    public static class a {
        public final Class a;
        public final ArrayList b = new ArrayList();

        public a(Class cls) {
            this.a = cls;
        }

        public void a(Class cls, Object obj) {
            Preconditions.checkArgument(cls == this.a);
            this.b.add(obj);
        }

        public Object b() {
            return Types.toArray(this.b, this.a);
        }
    }

    public ArrayValueMap(Object obj) {
        this.destination = obj;
    }

    public void put(Field field, Class<?> cls, Object obj) {
        a aVar = this.fieldMap.get(field);
        if (aVar == null) {
            aVar = new a(cls);
            this.fieldMap.put(field, aVar);
        }
        aVar.a(cls, obj);
    }

    public void setValues() {
        for (Map.Entry<String, a> entry : this.keyMap.entrySet()) {
            ((Map) this.destination).put(entry.getKey(), entry.getValue().b());
        }
        for (Map.Entry<Field, a> entry2 : this.fieldMap.entrySet()) {
            FieldInfo.setFieldValue(entry2.getKey(), this.destination, entry2.getValue().b());
        }
    }

    public void put(String str, Class<?> cls, Object obj) {
        a aVar = this.keyMap.get(str);
        if (aVar == null) {
            aVar = new a(cls);
            this.keyMap.put(str, aVar);
        }
        aVar.a(cls, obj);
    }
}
