package com.itextpdf.awt.geom.misc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class RenderingHints implements Map<Object, Object>, Cloneable {
    public static final Key KEY_ALPHA_INTERPOLATION;
    public static final Key KEY_ANTIALIASING;
    public static final Key KEY_COLOR_RENDERING;
    public static final Key KEY_DITHERING;
    public static final Key KEY_FRACTIONALMETRICS;
    public static final Key KEY_INTERPOLATION;
    public static final Key KEY_RENDERING;
    public static final Key KEY_STROKE_CONTROL;
    public static final Key KEY_TEXT_ANTIALIASING;
    public static final Object VALUE_ALPHA_INTERPOLATION_DEFAULT;
    public static final Object VALUE_ALPHA_INTERPOLATION_QUALITY;
    public static final Object VALUE_ALPHA_INTERPOLATION_SPEED;
    public static final Object VALUE_ANTIALIAS_DEFAULT;
    public static final Object VALUE_ANTIALIAS_OFF;
    public static final Object VALUE_ANTIALIAS_ON;
    public static final Object VALUE_COLOR_RENDER_DEFAULT;
    public static final Object VALUE_COLOR_RENDER_QUALITY;
    public static final Object VALUE_COLOR_RENDER_SPEED;
    public static final Object VALUE_DITHER_DEFAULT;
    public static final Object VALUE_DITHER_DISABLE;
    public static final Object VALUE_DITHER_ENABLE;
    public static final Object VALUE_FRACTIONALMETRICS_DEFAULT;
    public static final Object VALUE_FRACTIONALMETRICS_OFF;
    public static final Object VALUE_FRACTIONALMETRICS_ON;
    public static final Object VALUE_INTERPOLATION_BICUBIC;
    public static final Object VALUE_INTERPOLATION_BILINEAR;
    public static final Object VALUE_INTERPOLATION_NEAREST_NEIGHBOR;
    public static final Object VALUE_RENDER_DEFAULT;
    public static final Object VALUE_RENDER_QUALITY;
    public static final Object VALUE_RENDER_SPEED;
    public static final Object VALUE_STROKE_DEFAULT;
    public static final Object VALUE_STROKE_NORMALIZE;
    public static final Object VALUE_STROKE_PURE;
    public static final Object VALUE_TEXT_ANTIALIAS_DEFAULT;
    public static final Object VALUE_TEXT_ANTIALIAS_OFF;
    public static final Object VALUE_TEXT_ANTIALIAS_ON;
    private HashMap<Object, Object> map = new HashMap<>();

    public static abstract class Key {
        private final int key;

        public Key(int i) {
            this.key = i;
        }

        public final boolean equals(Object obj) {
            return this == obj;
        }

        public final int hashCode() {
            return System.identityHashCode(this);
        }

        public final int intKey() {
            return this.key;
        }

        public abstract boolean isCompatibleValue(Object obj);
    }

    public static class KeyImpl extends Key {
        public KeyImpl(int i) {
            super(i);
        }

        @Override // com.itextpdf.awt.geom.misc.RenderingHints.Key
        public boolean isCompatibleValue(Object obj) {
            return (obj instanceof KeyValue) && ((KeyValue) obj).key == this;
        }
    }

    public static class KeyValue {
        private final Key key;

        public KeyValue(Key key) {
            this.key = key;
        }
    }

    static {
        KeyImpl keyImpl = new KeyImpl(1);
        KEY_ALPHA_INTERPOLATION = keyImpl;
        VALUE_ALPHA_INTERPOLATION_DEFAULT = new KeyValue(keyImpl);
        VALUE_ALPHA_INTERPOLATION_SPEED = new KeyValue(keyImpl);
        VALUE_ALPHA_INTERPOLATION_QUALITY = new KeyValue(keyImpl);
        KeyImpl keyImpl2 = new KeyImpl(2);
        KEY_ANTIALIASING = keyImpl2;
        VALUE_ANTIALIAS_DEFAULT = new KeyValue(keyImpl2);
        VALUE_ANTIALIAS_ON = new KeyValue(keyImpl2);
        VALUE_ANTIALIAS_OFF = new KeyValue(keyImpl2);
        KeyImpl keyImpl3 = new KeyImpl(3);
        KEY_COLOR_RENDERING = keyImpl3;
        VALUE_COLOR_RENDER_DEFAULT = new KeyValue(keyImpl3);
        VALUE_COLOR_RENDER_SPEED = new KeyValue(keyImpl3);
        VALUE_COLOR_RENDER_QUALITY = new KeyValue(keyImpl3);
        KeyImpl keyImpl4 = new KeyImpl(4);
        KEY_DITHERING = keyImpl4;
        VALUE_DITHER_DEFAULT = new KeyValue(keyImpl4);
        VALUE_DITHER_DISABLE = new KeyValue(keyImpl4);
        VALUE_DITHER_ENABLE = new KeyValue(keyImpl4);
        KeyImpl keyImpl5 = new KeyImpl(5);
        KEY_FRACTIONALMETRICS = keyImpl5;
        VALUE_FRACTIONALMETRICS_DEFAULT = new KeyValue(keyImpl5);
        VALUE_FRACTIONALMETRICS_ON = new KeyValue(keyImpl5);
        VALUE_FRACTIONALMETRICS_OFF = new KeyValue(keyImpl5);
        KeyImpl keyImpl6 = new KeyImpl(6);
        KEY_INTERPOLATION = keyImpl6;
        VALUE_INTERPOLATION_BICUBIC = new KeyValue(keyImpl6);
        VALUE_INTERPOLATION_BILINEAR = new KeyValue(keyImpl6);
        VALUE_INTERPOLATION_NEAREST_NEIGHBOR = new KeyValue(keyImpl6);
        KeyImpl keyImpl7 = new KeyImpl(7);
        KEY_RENDERING = keyImpl7;
        VALUE_RENDER_DEFAULT = new KeyValue(keyImpl7);
        VALUE_RENDER_SPEED = new KeyValue(keyImpl7);
        VALUE_RENDER_QUALITY = new KeyValue(keyImpl7);
        KeyImpl keyImpl8 = new KeyImpl(8);
        KEY_STROKE_CONTROL = keyImpl8;
        VALUE_STROKE_DEFAULT = new KeyValue(keyImpl8);
        VALUE_STROKE_NORMALIZE = new KeyValue(keyImpl8);
        VALUE_STROKE_PURE = new KeyValue(keyImpl8);
        KeyImpl keyImpl9 = new KeyImpl(9);
        KEY_TEXT_ANTIALIASING = keyImpl9;
        VALUE_TEXT_ANTIALIAS_DEFAULT = new KeyValue(keyImpl9);
        VALUE_TEXT_ANTIALIAS_ON = new KeyValue(keyImpl9);
        VALUE_TEXT_ANTIALIAS_OFF = new KeyValue(keyImpl9);
    }

    public RenderingHints(Map<Key, ?> map) {
        if (map != null) {
            putAll(map);
        }
    }

    public void add(RenderingHints renderingHints) {
        this.map.putAll(renderingHints.map);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        RenderingHints renderingHints = new RenderingHints(null);
        renderingHints.map = (HashMap) this.map.clone();
        return renderingHints;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        obj.getClass();
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        Set<Object> setKeySet = keySet();
        if (!setKeySet.equals(map.keySet())) {
            return false;
        }
        Iterator<Object> it = setKeySet.iterator();
        while (it.hasNext()) {
            Key key = (Key) it.next();
            Object obj2 = get(key);
            Object obj3 = map.get(key);
            if (obj2 == null) {
                if (obj3 != null) {
                    return false;
                }
            } else if (!obj2.equals(obj3)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        if (((Key) obj).isCompatibleValue(obj2)) {
            return this.map.put(obj, obj2);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Object, ? extends Object> map) {
        if (map instanceof RenderingHints) {
            this.map.putAll(((RenderingHints) map).map);
            return;
        }
        Set<Map.Entry<? extends Object, ? extends Object>> setEntrySet = map.entrySet();
        if (setEntrySet != null) {
            for (Map.Entry<? extends Object, ? extends Object> entry : setEntrySet) {
                put((Key) entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    public String toString() {
        return "RenderingHints[" + this.map.toString() + "]";
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    public RenderingHints(Key key, Object obj) {
        put(key, obj);
    }
}
