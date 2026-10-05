package defpackage;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: renamed from: qR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3718qR extends TypeAdapter {
    public static final TypeAdapterFactory b = new a();
    public final DateFormat a;

    /* JADX INFO: renamed from: qR$a */
    public class a implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() == Date.class) {
                return new C3718qR(aVar);
            }
            return null;
        }
    }

    public /* synthetic */ C3718qR(a aVar) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(JsonReader jsonReader) throws IOException {
        java.util.Date date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        try {
            synchronized (this) {
                date = this.a.parse(strNextString);
            }
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException("Failed parsing '" + strNextString + "' as SQL Date; at path " + jsonReader.getPreviousPath(), e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String str;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            str = this.a.format((java.util.Date) date);
        }
        jsonWriter.value(str);
    }

    public C3718qR() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }
}
