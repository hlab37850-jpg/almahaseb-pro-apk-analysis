package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: renamed from: dX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2037dX extends RecyclerView.Adapter {
    public Context a;
    public ArrayList b;
    public Z00 c;
    public FE d = null;
    public C0736Ma e;

    /* JADX INFO: renamed from: dX$a */
    public class a implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ C4145vh b;
        public final /* synthetic */ int c;

        public a(f fVar, C4145vh c4145vh, int i) {
            this.a = fVar;
            this.b = c4145vh;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsChecked = this.a.a.b.isChecked();
            Z00 z00 = C2037dX.this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("update user_priv set new=");
            sb.append(zIsChecked ? "1" : "0");
            sb.append(" where user_id>0 and id=");
            sb.append(this.b.v());
            String strK = z00.K(sb.toString());
            if (strK == null || !strK.equals("1")) {
                Context context = C2037dX.this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strK != null && strK.length() > 20) {
                    strK = strK.substring(0, 20);
                }
                sb2.append(strK);
                Toast.makeText(context, sb2.toString(), 0).show();
            }
            C2037dX.this.d(this.c, this.b, 1);
        }
    }

    /* JADX INFO: renamed from: dX$b */
    public class b implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ C4145vh b;
        public final /* synthetic */ int c;

        public b(f fVar, C4145vh c4145vh, int i) {
            this.a = fVar;
            this.b = c4145vh;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsChecked = this.a.a.e.isChecked();
            Z00 z00 = C2037dX.this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("update user_priv set edit=");
            sb.append(zIsChecked ? "1" : "0");
            sb.append(" where user_id>0 and id=");
            sb.append(this.b.v());
            String strK = z00.K(sb.toString());
            if (strK == null || !strK.equals("1")) {
                Context context = C2037dX.this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strK != null && strK.length() > 20) {
                    strK = strK.substring(0, 20);
                }
                sb2.append(strK);
                Toast.makeText(context, sb2.toString(), 0).show();
            }
            C2037dX.this.d(this.c, this.b, 2);
        }
    }

    /* JADX INFO: renamed from: dX$c */
    public class c implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ C4145vh b;
        public final /* synthetic */ int c;

        public c(f fVar, C4145vh c4145vh, int i) {
            this.a = fVar;
            this.b = c4145vh;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsChecked = this.a.a.d.isChecked();
            Z00 z00 = C2037dX.this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("update user_priv set del=");
            sb.append(zIsChecked ? "1" : "0");
            sb.append(" where user_id>0 and id=");
            sb.append(this.b.v());
            String strK = z00.K(sb.toString());
            if (strK == null || !strK.equals("1")) {
                Context context = C2037dX.this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strK != null && strK.length() > 20) {
                    strK = strK.substring(0, 20);
                }
                sb2.append(strK);
                Toast.makeText(context, sb2.toString(), 0).show();
            }
            C2037dX.this.d(this.c, this.b, 4);
        }
    }

    /* JADX INFO: renamed from: dX$d */
    public class d implements View.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ C4145vh b;
        public final /* synthetic */ int c;

        public d(f fVar, C4145vh c4145vh, int i) {
            this.a = fVar;
            this.b = c4145vh;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsChecked = this.a.a.i.isChecked();
            Z00 z00 = C2037dX.this.c;
            StringBuilder sb = new StringBuilder();
            sb.append("update user_priv set view=");
            sb.append(zIsChecked ? "1" : "0");
            sb.append(" where user_id>0 and id=");
            sb.append(this.b.v());
            String strK = z00.K(sb.toString());
            if (strK == null || !strK.equals("1")) {
                Context context = C2037dX.this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error:");
                if (strK != null && strK.length() > 20) {
                    strK = strK.substring(0, 20);
                }
                sb2.append(strK);
                Toast.makeText(context, sb2.toString(), 0).show();
            }
            C2037dX.this.d(this.c, this.b, 3);
        }
    }

    /* JADX INFO: renamed from: dX$e */
    public class e implements Runnable {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2037dX.this.notifyItemChanged(this.a);
        }
    }

    /* JADX INFO: renamed from: dX$f */
    public class f extends RecyclerView.ViewHolder {
        public C0736Ma a;

        public f(C0736Ma c0736Ma) {
            super(c0736Ma.getRoot());
            this.a = c0736Ma;
        }
    }

    public C2037dX(Context context, ArrayList arrayList, Z00 z00) {
        this.a = context;
        this.b = arrayList;
        this.c = z00;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f fVar, int i) {
        C4145vh c4145vh = (C4145vh) this.b.get(i);
        fVar.a.h.setText(c4145vh.a());
        fVar.a.b.setChecked(c4145vh.n().equals("1"));
        fVar.a.e.setChecked(c4145vh.o().equals("1"));
        fVar.a.i.setChecked(c4145vh.p().equals("1"));
        fVar.a.d.setChecked(c4145vh.q().equals("1"));
        fVar.a.b.setEnabled(!c4145vh.n().equals("-1"));
        fVar.a.e.setEnabled(!c4145vh.o().equals("-1"));
        fVar.a.i.setEnabled(!c4145vh.p().equals("-1"));
        fVar.a.d.setEnabled(!c4145vh.q().equals("-1"));
        C0372Bn.e.a(this.a, fVar.a.h);
        fVar.a.b.setOnClickListener(new a(fVar, c4145vh, i));
        fVar.a.e.setOnClickListener(new b(fVar, c4145vh, i));
        fVar.a.d.setOnClickListener(new c(fVar, c4145vh, i));
        fVar.a.i.setOnClickListener(new d(fVar, c4145vh, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.e = C0736Ma.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new f(this.e);
    }

    public void d(int i, C4145vh c4145vh, int i2) {
        String strX4 = this.c.X4("select new as _id from user_priv where id=" + c4145vh.v());
        String strX5 = this.c.X4("select edit as _id from user_priv where id=" + c4145vh.v());
        String strX6 = this.c.X4("select view as _id from user_priv where id=" + c4145vh.v());
        String strX7 = this.c.X4("select del as _id from user_priv where id=" + c4145vh.v());
        ((C4145vh) this.b.get(i)).y(strX4);
        ((C4145vh) this.b.get(i)).z(strX5);
        ((C4145vh) this.b.get(i)).A(strX6);
        ((C4145vh) this.b.get(i)).B(strX7);
        new Handler(Looper.getMainLooper()).post(new e(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }
}
