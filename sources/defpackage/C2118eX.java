package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport;
import info.aalmoghalis.inventory.old.UserPriv;
import java.util.ArrayList;

/* JADX INFO: renamed from: eX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2118eX extends RecyclerView.Adapter {
    public Context a;
    public ArrayList b;
    public Z00 c;
    public FE d;
    public C0711La e;

    /* JADX INFO: renamed from: eX$a */
    public class a implements View.OnClickListener {
        public final /* synthetic */ C4145vh a;

        public a(C4145vh c4145vh) {
            this.a = c4145vh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2118eX.this.d.j(1, this.a);
        }
    }

    /* JADX INFO: renamed from: eX$c */
    public class c implements View.OnClickListener {
        public final /* synthetic */ C4145vh a;

        public c(C4145vh c4145vh) {
            this.a = c4145vh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2118eX.this.e(this.a);
        }
    }

    /* JADX INFO: renamed from: eX$d */
    public class d implements View.OnClickListener {
        public final /* synthetic */ C4145vh a;

        public d(C4145vh c4145vh) {
            this.a = c4145vh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2118eX.this.e(this.a);
        }
    }

    /* JADX INFO: renamed from: eX$e */
    public class e implements View.OnClickListener {
        public final /* synthetic */ C4145vh a;

        public e(C4145vh c4145vh) {
            this.a = c4145vh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2118eX.this.d(this.a);
        }
    }

    /* JADX INFO: renamed from: eX$f */
    public class f extends RecyclerView.ViewHolder {
        public C0711La a;

        public f(C0711La c0711La) {
            super(c0711La.getRoot());
            this.a = c0711La;
        }
    }

    public C2118eX(Context context, ArrayList arrayList, Z00 z00, FE fe) {
        this.a = context;
        this.b = arrayList;
        this.c = z00;
        this.d = fe;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f fVar, int i) {
        C4145vh c4145vh = (C4145vh) this.b.get(i);
        fVar.a.f.setText(c4145vh.v());
        fVar.a.n.setText(c4145vh.a());
        fVar.a.b.setText("" + c4145vh.o());
        fVar.a.d.setText("" + c4145vh.p());
        fVar.a.j.setTag(c4145vh.v() + "");
        if (c4145vh.q().equals("0")) {
            fVar.a.n.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        fVar.a.n.setPaintFlags(fVar.a.n.getPaintFlags() | 8);
        C0372Bn.e.a(this.a, fVar.a.n);
        fVar.a.h.setOnClickListener(new a(c4145vh));
        fVar.a.g.setOnClickListener(new b());
        fVar.a.j.setOnClickListener(new c(c4145vh));
        fVar.a.c.setOnClickListener(new d(c4145vh));
        fVar.a.i.setOnClickListener(new e(c4145vh));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.e = C0711La.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new f(this.e);
    }

    public void d(C4145vh c4145vh) {
        Intent intent = new Intent(this.a, (Class<?>) FragmentStatePagerSupport.class);
        C4143vg c4143vgQ4 = this.c.q4(c4145vh.p());
        intent.putExtra("screen_no", "11");
        intent.putExtra("CUS_ID", c4143vgQ4.i());
        intent.putExtra("CUS_BAL", "0");
        intent.putExtra("CUS_GSM", c4143vgQ4.h());
        intent.putExtra("CUS_NAME", c4143vgQ4.j());
        intent.putExtra("title_", c4143vgQ4.j() + "#" + this.a.getString(R.string.cash_tran));
        intent.putExtra("CURR_NAME", this.c.l3("0"));
        intent.putExtra("adv_search", 1);
        this.c.v0("update sys_conf set value_='now' where id=2");
        String strF5 = this.c.f5(0);
        intent.putExtra("f_date", strF5);
        intent.putExtra("t_date", strF5);
        this.a.startActivity(intent);
    }

    public void e(C4145vh c4145vh) {
        Intent intent = new Intent(this.a, (Class<?>) UserPriv.class);
        intent.putExtra("TR_ID", c4145vh.v());
        intent.putExtra("TR_NAME", c4145vh.a());
        this.a.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    /* JADX INFO: renamed from: eX$b */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
