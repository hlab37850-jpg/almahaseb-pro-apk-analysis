package com.zebra.sdk.settings.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.settings.Setting;
import com.zebra.sdk.util.internal.JacksonObjectMapperFactory;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsBuilder {
    private Map<String, Setting> mySettingsMap;

    public SettingsBuilder(Map<String, Setting> map) {
        this.mySettingsMap = map;
    }

    private String escapeControlCharacters(String str) {
        return str != null ? str.replace("\\b", "\\\\b").replace("\\f", "\\\\f").replace("\\n", "\\\\n").replace("\\r", "\\\\r").replace("\\t", "\\\\t") : str;
    }

    private void parseJsonToMap(String str) {
        TypeReference typeReference = new TypeReference() { // from class: com.zebra.sdk.settings.internal.SettingsBuilder.1
        };
        this.mySettingsMap.putAll((Map) ((Map) JacksonObjectMapperFactory.getInstance().readValue(escapeControlCharacters(str), typeReference)).get("allconfig"));
    }

    private String removeExtraEscaping(String str) {
        return str != null ? str.replace("\\\\b", "\\b").replace("\\\\f", "\\f").replace("\\\\n", "\\n").replace("\\\\r", "\\r").replace("\\\\t", "\\t") : str;
    }

    public Charset getDefaultCharset() {
        return Charset.defaultCharset();
    }

    public void parse(byte[] bArr) throws ZebraIllegalArgumentException {
        try {
            try {
                parseJsonToMap(new String(bArr, getDefaultCharset()));
            } catch (Exception unused) {
                parseJsonToMap(new String(bArr, XmpWriter.UTF8));
            }
        } catch (Exception e) {
            throw new ZebraIllegalArgumentException(e.getLocalizedMessage());
        }
    }

    public String toAllconfigJson() {
        return "{ \"allconfig\":\n" + removeExtraEscaping(JacksonObjectMapperFactory.getInstance().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(this.mySettingsMap)) + "}";
    }
}
