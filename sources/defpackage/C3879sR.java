package defpackage;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: renamed from: sR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3879sR extends TypeAdapter {
    public static final TypeAdapterFactory b = new a();
    public final TypeAdapter a;

    /* JADX INFO: renamed from: sR$a */
    public class a implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() == Timestamp.class) {
                return new C3879sR(gson.getAdapter(Date.class), aVar);
            }
            return null;
        }
    }

    public /* synthetic */ C3879sR(TypeAdapter typeAdapter, a aVar) {
        this(typeAdapter);
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Timestamp read(JsonReader jsonReader) {
        Date date = (Date) this.a.read(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Timestamp timestamp) {
        this.a.write(jsonWriter, timestamp);
    }

    public C3879sR(TypeAdapter typeAdapter) {
        this.a = typeAdapter;
    }
}
