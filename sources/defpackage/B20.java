package defpackage;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.base.zak;

/* JADX INFO: loaded from: classes2.dex */
public final class B20 extends Drawable.ConstantState {
    public int a;
    public int b;

    public B20(B20 b20) {
        if (b20 != null) {
            this.a = b20.a;
            this.b = b20.b;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zak(this);
    }
}
