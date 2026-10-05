package defpackage;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: Gn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0550Gn extends AsyncTaskLoader {
    public String a;
    public String b;
    public Z00 c;
    public int[] d;
    public double e;

    public C0550Gn(Context context, String str, String str2, Z00 z00) {
        super(context);
        this.d = new int[]{R.drawable.up, 1, R.drawable.down};
        this.e = 0.0d;
        this.a = str;
        this.b = str2;
        this.c = z00;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List loadInBackground() {
        new ArrayList();
        return !Z00.Z ? this.c.W3(this.a) : this.c.X3(this.a, this.b);
    }
}
