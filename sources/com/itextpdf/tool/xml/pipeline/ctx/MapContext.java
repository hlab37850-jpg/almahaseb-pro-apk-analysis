package com.itextpdf.tool.xml.pipeline.ctx;

import com.itextpdf.tool.xml.CustomContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MapContext implements CustomContext {
    private final Map<String, Object> map = new ConcurrentHashMap();

    public Object get(String str) {
        return this.map.get(str);
    }

    public void put(String str, Object obj) {
        this.map.put(str, obj);
    }
}
