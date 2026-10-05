package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class XJ extends RecyclerView.Adapter {
    public Context a;
    public ArrayList b;
    public Z00 c;
    public FE d;

    public class a implements View.OnClickListener {
        public final /* synthetic */ C2054dh a;

        public a(C2054dh c2054dh) {
            this.a = c2054dh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            XJ.this.d.g(1, this.a);
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ C2054dh a;

        public b(C2054dh c2054dh) {
            this.a = c2054dh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            XJ.this.d.g(2, this.a);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ C2054dh a;

        public c(C2054dh c2054dh) {
            this.a = c2054dh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            XJ.this.d.g(3, this.a);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ C2054dh a;

        public d(C2054dh c2054dh) {
            this.a = c2054dh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            XJ.this.d.g(4, this.a);
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ C2054dh a;

        public e(C2054dh c2054dh) {
            this.a = c2054dh;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            XJ.this.d.g(5, this.a);
        }
    }

    public class f extends RecyclerView.ViewHolder {
        public ImageView a;
        public ImageView b;
        public ImageView c;
        public ImageView d;
        public ImageView e;
        public TextView f;
        public TextView g;
        public TextView h;

        public f(View view) {
            super(view);
            this.f = (TextView) view.findViewById(R.id.cus_name);
            this.h = (TextView) view.findViewById(R.id.date_);
            this.g = (TextView) view.findViewById(R.id.remarks);
            this.a = (ImageView) view.findViewById(R.id.img_whats);
            this.b = (ImageView) view.findViewById(R.id.img_edit);
            this.c = (ImageView) view.findViewById(R.id.img_delete);
            this.d = (ImageView) view.findViewById(R.id.img_sms);
            this.e = (ImageView) view.findViewById(R.id.img_call);
        }
    }

    public XJ(Context context, ArrayList arrayList, Z00 z00, FE fe) {
        this.a = context;
        this.b = arrayList;
        this.c = z00;
        this.d = fe;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f fVar, int i) {
        C2054dh c2054dh = (C2054dh) this.b.get(i);
        fVar.f.setText(c2054dh.e());
        fVar.h.setText("" + c2054dh.b() + " " + c2054dh.h);
        TextView textView = fVar.g;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(c2054dh.e);
        textView.setText(sb.toString());
        fVar.a.setTag(c2054dh.d + "");
        if (this.c.ja("prefOthers_whats_bus", false)) {
            fVar.a.setImageDrawable(ContextCompat.getDrawable(this.a, R.drawable.whatsapp_bus));
        } else if (this.c.ja("prefOthers_whats", false)) {
            fVar.a.setImageDrawable(ContextCompat.getDrawable(this.a, R.drawable.whatsapp2));
        }
        if (c2054dh.f == 2) {
            fVar.f.setPaintFlags(fVar.f.getPaintFlags() | 8);
        }
        fVar.b.setOnClickListener(new a(c2054dh));
        fVar.c.setOnClickListener(new b(c2054dh));
        fVar.a.setOnClickListener(new c(c2054dh));
        fVar.d.setOnClickListener(new d(c2054dh));
        fVar.e.setOnClickListener(new e(c2054dh));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }
}
