package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: Jf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0620Jf implements ViewBinding {
    public final LinearLayout a;
    public final TableLayout b;
    public final TableLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public C0620Jf(LinearLayout linearLayout, TableLayout tableLayout, TableLayout tableLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.a = linearLayout;
        this.b = tableLayout;
        this.c = tableLayout2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static C0620Jf a(View view) {
        int i = R.id.bill_add_item_hdr;
        TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view, R.id.bill_add_item_hdr);
        if (tableLayout != null) {
            i = R.id.bill_hdr;
            TableLayout tableLayout2 = (TableLayout) ViewBindings.findChildViewById(view, R.id.bill_hdr);
            if (tableLayout2 != null) {
                i = R.id.f_date;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f_date);
                if (textView != null) {
                    i = R.id.item_type;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.item_type);
                    if (textView2 != null) {
                        i = R.id.t_date;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.t_date);
                        if (textView3 != null) {
                            return new C0620Jf((LinearLayout) view, tableLayout, tableLayout2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C0620Jf c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0620Jf d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.content_report_input_item_type, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
