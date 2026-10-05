package com.zebra.sdk.settings.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.util.internal.JacksonObjectMapperFactory;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC4493zu;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class JsonHelper {
    public static byte[] buildQuery(List<String> list) {
        StringBuilder sb = new StringBuilder("{}{");
        for (String str : list) {
            sb.append("\"");
            sb.append(str);
            sb.append("\":null,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString().getBytes();
    }

    public static byte[] buildSetCommand(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("{}");
        try {
            sb.append(JacksonObjectMapperFactory.getInstance().writeValueAsString(map));
        } catch (AbstractC4493zu e) {
            e.printStackTrace();
        }
        return sb.toString().getBytes();
    }

    public static boolean isValidJson(String str) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(objectMapper.getFactory().v(str));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Map<String, String> parseGetResponse(byte[] bArr) throws ZebraIllegalArgumentException {
        try {
            return StringUtilities.convertKeyValueJsonToMap(bArr);
        } catch (Exception unused) {
            throw new ZebraIllegalArgumentException("Error processing response from device: [" + new String(bArr) + "]");
        }
    }

    public static boolean isValidJson(byte[] bArr) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonParser jsonParserW = objectMapper.getFactory().w(bArr);
            objectMapper.readTree(bArr);
            return jsonParserW.H() != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
