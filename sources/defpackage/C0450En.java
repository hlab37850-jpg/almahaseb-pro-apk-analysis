package defpackage;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: En, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0450En extends AsyncTaskLoader {
    public String a;
    public String b;
    public String c;
    public Z00 d;
    public int[] e;
    public double f;

    public C0450En(Context context, String str, String str2, String str3, Z00 z00) {
        super(context);
        this.e = new int[]{R.drawable.up, 1, R.drawable.down};
        this.f = 0.0d;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z00;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List loadInBackground() {
        new ArrayList();
        return this.d.g4(this.a, this.b, this.c);
    }
}
