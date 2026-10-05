package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class UA implements Function {
    public final /* synthetic */ MaterialDynamicColors a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.a.highestSurface((DynamicScheme) obj);
    }
}
