package defpackage;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: Fn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0524Fn extends AsyncTaskLoader {
    public String a;
    public String b;
    public String c;
    public Z00 d;
    public int[] e;
    public double f;
    public int g;
    public int h;
    public String i;

    public C0524Fn(Context context, String str, String str2, Z00 z00, int i) {
        super(context);
        this.e = new int[]{R.drawable.up, 1, R.drawable.down};
        this.f = 0.0d;
        this.h = 0;
        this.i = "";
        this.a = str;
        this.b = str2;
        this.d = z00;
        this.g = i;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List loadInBackground() {
        ArrayList arrayList = new ArrayList();
        int i = this.g;
        if (i == 0) {
            return !Z00.Z ? this.d.Z3(this.a, this.c) : this.d.b4(this.a, this.b, this.c);
        }
        if (i == 1) {
            return this.d.c4(this.b, this.h, this.i);
        }
        return i == 2 ? this.d.d4(this.b) : arrayList;
    }

    public C0524Fn(Context context, String str, String str2, String str3, Z00 z00, int i) {
        super(context);
        this.e = new int[]{R.drawable.up, 1, R.drawable.down};
        this.f = 0.0d;
        this.h = 0;
        this.i = "";
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z00;
        this.g = i;
    }
}
