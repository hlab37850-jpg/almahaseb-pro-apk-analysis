package defpackage;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import yuku.ambilwarna.AmbilWarnaSquare;

/* JADX INFO: loaded from: classes4.dex */
public class B2 {
    public final AlertDialog a;
    public final boolean b;
    public final h c;
    public final View d;
    public final AmbilWarnaSquare e;
    public final ImageView f;
    public final ImageView g;
    public final View h;
    public final View i;
    public final View j;
    public final ImageView k;
    public final ImageView l;
    public final ViewGroup m;
    public final float[] n;
    public int o;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 2 && motionEvent.getAction() != 0 && motionEvent.getAction() != 1) {
                return false;
            }
            float y = motionEvent.getY();
            if (y < 0.0f) {
                y = 0.0f;
            }
            if (y > B2.this.d.getMeasuredHeight()) {
                y = B2.this.d.getMeasuredHeight() - 0.001f;
            }
            float measuredHeight = 360.0f - ((360.0f / B2.this.d.getMeasuredHeight()) * y);
            B2.this.r(measuredHeight != 360.0f ? measuredHeight : 0.0f);
            B2 b2 = B2.this;
            b2.e.setHue(b2.k());
            B2.this.o();
            B2 b3 = B2.this;
            b3.i.setBackgroundColor(b3.j());
            B2.this.v();
            return true;
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 2 && motionEvent.getAction() != 0 && motionEvent.getAction() != 1) {
                return false;
            }
            float y = motionEvent.getY();
            if (y < 0.0f) {
                y = 0.0f;
            }
            if (y > B2.this.l.getMeasuredHeight()) {
                y = B2.this.l.getMeasuredHeight() - 0.001f;
            }
            int iRound = Math.round(255.0f - ((255.0f / B2.this.l.getMeasuredHeight()) * y));
            B2.this.q(iRound);
            B2.this.n();
            B2.this.i.setBackgroundColor((iRound << 24) | (B2.this.j() & ViewCompat.MEASURED_SIZE_MASK));
            return true;
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 2 && motionEvent.getAction() != 0 && motionEvent.getAction() != 1) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x < 0.0f) {
                x = 0.0f;
            }
            if (x > B2.this.e.getMeasuredWidth()) {
                x = B2.this.e.getMeasuredWidth();
            }
            if (y < 0.0f) {
                y = 0.0f;
            }
            if (y > B2.this.e.getMeasuredHeight()) {
                y = B2.this.e.getMeasuredHeight();
            }
            B2 b2 = B2.this;
            b2.s((1.0f / b2.e.getMeasuredWidth()) * x);
            B2 b3 = B2.this;
            b3.t(1.0f - ((1.0f / b3.e.getMeasuredHeight()) * y));
            B2.this.p();
            B2 b4 = B2.this;
            b4.i.setBackgroundColor(b4.j());
            return true;
        }
    }

    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            B2 b2 = B2.this;
            h hVar = b2.c;
            if (hVar != null) {
                hVar.a(b2);
            }
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            B2 b2 = B2.this;
            h hVar = b2.c;
            if (hVar != null) {
                hVar.a(b2);
            }
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            B2 b2 = B2.this;
            h hVar = b2.c;
            if (hVar != null) {
                hVar.b(b2, b2.j());
            }
        }
    }

    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;

        public g(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            B2.this.o();
            if (B2.this.b) {
                B2.this.n();
            }
            B2.this.p();
            if (B2.this.b) {
                B2.this.v();
            }
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    public interface h {
        void a(B2 b2);

        void b(B2 b2, int i);
    }

    public B2(Context context, int i, h hVar) {
        this(context, i, false, hVar);
    }

    public final float i() {
        return this.o;
    }

    public final int j() {
        int iHSVToColor = Color.HSVToColor(this.n);
        return (iHSVToColor & ViewCompat.MEASURED_SIZE_MASK) | (this.o << 24);
    }

    public final float k() {
        return this.n[0];
    }

    public final float l() {
        return this.n[1];
    }

    public final float m() {
        return this.n[2];
    }

    public void n() {
        float measuredHeight = this.l.getMeasuredHeight();
        float fI = measuredHeight - ((i() * measuredHeight) / 255.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.leftMargin = (int) ((((double) this.l.getLeft()) - Math.floor(this.g.getMeasuredWidth() / 2)) - ((double) this.m.getPaddingLeft()));
        layoutParams.topMargin = (int) ((((double) (this.l.getTop() + fI)) - Math.floor(this.g.getMeasuredHeight() / 2)) - ((double) this.m.getPaddingTop()));
        this.g.setLayoutParams(layoutParams);
    }

    public void o() {
        float measuredHeight = this.d.getMeasuredHeight() - ((k() * this.d.getMeasuredHeight()) / 360.0f);
        if (measuredHeight == this.d.getMeasuredHeight()) {
            measuredHeight = 0.0f;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.leftMargin = (int) ((((double) this.d.getLeft()) - Math.floor(this.f.getMeasuredWidth() / 2)) - ((double) this.m.getPaddingLeft()));
        layoutParams.topMargin = (int) ((((double) (this.d.getTop() + measuredHeight)) - Math.floor(this.f.getMeasuredHeight() / 2)) - ((double) this.m.getPaddingTop()));
        this.f.setLayoutParams(layoutParams);
    }

    public void p() {
        float fL = l() * this.e.getMeasuredWidth();
        float fM = (1.0f - m()) * this.e.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.leftMargin = (int) ((((double) (this.e.getLeft() + fL)) - Math.floor(this.k.getMeasuredWidth() / 2)) - ((double) this.m.getPaddingLeft()));
        layoutParams.topMargin = (int) ((((double) (this.e.getTop() + fM)) - Math.floor(this.k.getMeasuredHeight() / 2)) - ((double) this.m.getPaddingTop()));
        this.k.setLayoutParams(layoutParams);
    }

    public final void q(int i) {
        this.o = i;
    }

    public final void r(float f2) {
        this.n[0] = f2;
    }

    public final void s(float f2) {
        this.n[1] = f2;
    }

    public final void t(float f2) {
        this.n[2] = f2;
    }

    public void u() {
        this.a.show();
    }

    public final void v() {
        this.j.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.HSVToColor(this.n), 0}));
    }

    public B2(Context context, int i, boolean z, h hVar) {
        float[] fArr = new float[3];
        this.n = fArr;
        this.b = z;
        this.c = hVar;
        i = z ? i : i | ViewCompat.MEASURED_STATE_MASK;
        Color.colorToHSV(i, fArr);
        this.o = Color.alpha(i);
        View viewInflate = LayoutInflater.from(context).inflate(AbstractC2350hJ.ambilwarna_dialog, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(AbstractC2268gJ.ambilwarna_viewHue);
        this.d = viewFindViewById;
        AmbilWarnaSquare ambilWarnaSquare = (AmbilWarnaSquare) viewInflate.findViewById(AbstractC2268gJ.ambilwarna_viewSatBri);
        this.e = ambilWarnaSquare;
        this.f = (ImageView) viewInflate.findViewById(AbstractC2268gJ.ambilwarna_cursor);
        View viewFindViewById2 = viewInflate.findViewById(AbstractC2268gJ.ambilwarna_oldColor);
        this.h = viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(AbstractC2268gJ.ambilwarna_newColor);
        this.i = viewFindViewById3;
        this.k = (ImageView) viewInflate.findViewById(AbstractC2268gJ.ambilwarna_target);
        this.m = (ViewGroup) viewInflate.findViewById(AbstractC2268gJ.ambilwarna_viewContainer);
        View viewFindViewById4 = viewInflate.findViewById(AbstractC2268gJ.ambilwarna_overlay);
        this.j = viewFindViewById4;
        ImageView imageView = (ImageView) viewInflate.findViewById(AbstractC2268gJ.ambilwarna_alphaCursor);
        this.g = imageView;
        ImageView imageView2 = (ImageView) viewInflate.findViewById(AbstractC2268gJ.ambilwarna_alphaCheckered);
        this.l = imageView2;
        viewFindViewById4.setVisibility(z ? 0 : 8);
        imageView.setVisibility(z ? 0 : 8);
        imageView2.setVisibility(z ? 0 : 8);
        ambilWarnaSquare.setHue(k());
        viewFindViewById2.setBackgroundColor(i);
        viewFindViewById3.setBackgroundColor(i);
        viewFindViewById.setOnTouchListener(new a());
        if (z) {
            imageView2.setOnTouchListener(new b());
        }
        ambilWarnaSquare.setOnTouchListener(new c());
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setPositiveButton(R.string.ok, new f()).setNegativeButton(R.string.cancel, new e()).setOnCancelListener(new d()).create();
        this.a = alertDialogCreate;
        alertDialogCreate.setView(viewInflate, 0, 0, 0, 0);
        viewInflate.getViewTreeObserver().addOnGlobalLayoutListener(new g(viewInflate));
    }
}
