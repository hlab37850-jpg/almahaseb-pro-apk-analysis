package defpackage;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: renamed from: d6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2006d6 implements ObjectParser {
    public static final C2006d6 a = new C2006d6();

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(InputStream inputStream, Charset charset, Class cls) {
        return parseAndClose((Reader) new InputStreamReader(inputStream, charset), cls);
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(InputStream inputStream, Charset charset, Type type) {
        throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(Reader reader, Class cls) throws IOException {
        Object objValueOf;
        try {
            ClassInfo classInfoOf = ClassInfo.of(cls);
            Object objNewInstance = Types.newInstance(cls);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return objNewInstance;
                }
                int iIndexOf = line.indexOf(61);
                String strSubstring = line.substring(0, iIndexOf);
                String strSubstring2 = line.substring(iIndexOf + 1);
                Field field = classInfoOf.getField(strSubstring);
                if (field != null) {
                    Class<?> type = field.getType();
                    if (type == Boolean.TYPE) {
                        objValueOf = Boolean.valueOf(strSubstring2);
                    } else if (type == Boolean.class) {
                        objValueOf = strSubstring2;
                        objValueOf = Boolean.valueOf(strSubstring2);
                    }
                    objValueOf = strSubstring2;
                    FieldInfo.setFieldValue(field, objNewInstance, objValueOf);
                } else if (GenericData.class.isAssignableFrom(cls)) {
                    ((GenericData) objNewInstance).set(strSubstring, strSubstring2);
                } else if (Map.class.isAssignableFrom(cls)) {
                    ((Map) objNewInstance).put(strSubstring, strSubstring2);
                }
            }
        } finally {
            reader.close();
        }
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(Reader reader, Type type) {
        throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
    }
}
