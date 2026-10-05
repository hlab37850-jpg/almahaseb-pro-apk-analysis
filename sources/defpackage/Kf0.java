package defpackage;

import com.google.android.datatransport.Transformer;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Kf0 implements Transformer {
    public static final Transformer a = new Kf0();

    @Override // com.google.android.datatransport.Transformer
    public final Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
