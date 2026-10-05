package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Image;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractImageProvider implements ImageProvider {
    private final Map<String, Image> map = new ConcurrentHashMap();

    @Override // com.itextpdf.tool.xml.pipeline.html.ImageProvider
    public void reset() {
        this.map.clear();
    }

    @Override // com.itextpdf.tool.xml.pipeline.html.ImageProvider
    public Image retrieve(String str) {
        return this.map.get(str);
    }

    @Override // com.itextpdf.tool.xml.pipeline.html.ImageProvider
    public void store(String str, Image image) {
        this.map.put(str, image);
    }
}
