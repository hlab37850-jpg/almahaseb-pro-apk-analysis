package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.n;
import com.google.android.youtube.player.internal.s;
import com.google.android.youtube.player.internal.t;
import com.google.android.youtube.player.internal.w;
import com.google.android.youtube.player.internal.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class YouTubePlayerView extends ViewGroup implements YouTubePlayer.Provider {
    private final c a;
    private final Set<View> b;
    private final d c;
    private com.google.android.youtube.player.internal.b d;
    private s e;
    private View f;
    private n g;
    private YouTubePlayer.Provider h;
    private Bundle i;
    private YouTubePlayer.OnInitializedListener j;
    private boolean k;
    private boolean l;

    public class a implements t.a {
        public final /* synthetic */ Activity a;

        public a(Activity activity) {
            this.a = activity;
        }

        @Override // com.google.android.youtube.player.internal.t.a
        public final void a() {
            if (YouTubePlayerView.this.d != null) {
                YouTubePlayerView.a(YouTubePlayerView.this, this.a);
            }
            YouTubePlayerView.b(YouTubePlayerView.this);
        }

        @Override // com.google.android.youtube.player.internal.t.a
        public final void b() {
            if (!YouTubePlayerView.this.l && YouTubePlayerView.this.e != null) {
                YouTubePlayerView.this.e.f();
            }
            YouTubePlayerView.this.g.a();
            YouTubePlayerView youTubePlayerView = YouTubePlayerView.this;
            if (youTubePlayerView.indexOfChild(youTubePlayerView.g) < 0) {
                YouTubePlayerView youTubePlayerView2 = YouTubePlayerView.this;
                youTubePlayerView2.addView(youTubePlayerView2.g);
                YouTubePlayerView youTubePlayerView3 = YouTubePlayerView.this;
                youTubePlayerView3.removeView(youTubePlayerView3.f);
            }
            YouTubePlayerView.g(YouTubePlayerView.this);
            YouTubePlayerView.h(YouTubePlayerView.this);
            YouTubePlayerView.b(YouTubePlayerView.this);
        }
    }

    public class b implements t.b {
        public b() {
        }

        @Override // com.google.android.youtube.player.internal.t.b
        public final void a(YouTubeInitializationResult youTubeInitializationResult) {
            YouTubePlayerView.this.a(youTubeInitializationResult);
            YouTubePlayerView.b(YouTubePlayerView.this);
        }
    }

    public final class c implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View view, View view2) {
            if (YouTubePlayerView.this.e == null || !YouTubePlayerView.this.b.contains(view2) || YouTubePlayerView.this.b.contains(view)) {
                return;
            }
            YouTubePlayerView.this.e.g();
        }

        public /* synthetic */ c(YouTubePlayerView youTubePlayerView, byte b) {
            this();
        }
    }

    public interface d {
        void a(YouTubePlayerView youTubePlayerView);

        void b(YouTubePlayerView youTubePlayerView, String str, YouTubePlayer.OnInitializedListener onInitializedListener);
    }

    public YouTubePlayerView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ com.google.android.youtube.player.internal.b b(YouTubePlayerView youTubePlayerView) {
        youTubePlayerView.d = null;
        return null;
    }

    public static /* synthetic */ View g(YouTubePlayerView youTubePlayerView) {
        youTubePlayerView.f = null;
        return null;
    }

    public static /* synthetic */ s h(YouTubePlayerView youTubePlayerView) {
        youTubePlayerView.e = null;
        return null;
    }

    @Override // android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        super.addFocusables(arrayList2, i);
        arrayList.addAll(arrayList2);
        this.b.clear();
        this.b.addAll(arrayList2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        a(view);
        super.addView(view);
    }

    public final void c() {
        s sVar = this.e;
        if (sVar != null) {
            sVar.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void clearChildFocus(View view) {
        if (hasFocusable()) {
            requestFocus();
        } else {
            super.clearChildFocus(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.e != null) {
            if (keyEvent.getAction() == 0) {
                return this.e.a(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 1) {
                return this.e.b(keyEvent.getKeyCode(), keyEvent) || super.dispatchKeyEvent(keyEvent);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final Bundle e() {
        s sVar = this.e;
        return sVar == null ? this.i : sVar.h();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void focusableViewAvailable(View view) {
        super.focusableViewAvailable(view);
        this.b.add(view);
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.Provider
    public final void initialize(String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
        ab.a(str, (Object) "Developer key cannot be null or empty");
        this.c.b(this, str, onInitializedListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.a);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        s sVar = this.e;
        if (sVar != null) {
            sVar.a(configuration);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (getChildCount() <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        View childAt = getChildAt(0);
        childAt.measure(i, i2);
        setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.b.add(view2);
    }

    @Override // android.view.ViewGroup
    public final void setClipToPadding(boolean z) {
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        s sVar = this.e;
        if (sVar != null) {
            sVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ArrayList<View> arrayList2 = new ArrayList<>();
        super.addFocusables(arrayList2, i, i2);
        arrayList.addAll(arrayList2);
        this.b.clear();
        this.b.addAll(arrayList2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        a(view);
        super.addView(view, i);
    }

    public final void b() {
        s sVar = this.e;
        if (sVar != null) {
            sVar.c();
        }
    }

    public final void c(boolean z) {
        this.l = true;
        s sVar = this.e;
        if (sVar != null) {
            sVar.a(z);
        }
    }

    public final void d() {
        s sVar = this.e;
        if (sVar != null) {
            sVar.e();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, ((YouTubeBaseActivity) context).a());
        if (!(context instanceof YouTubeBaseActivity)) {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
        }
    }

    public final void a(Activity activity, YouTubePlayer.Provider provider, String str, YouTubePlayer.OnInitializedListener onInitializedListener, Bundle bundle) {
        if (this.e == null && this.j == null) {
            ab.a(activity, "activity cannot be null");
            this.h = (YouTubePlayer.Provider) ab.a(provider, "provider cannot be null");
            this.j = (YouTubePlayer.OnInitializedListener) ab.a(onInitializedListener, "listener cannot be null");
            this.i = bundle;
            this.g.b();
            com.google.android.youtube.player.internal.b bVarA = aa.a().a(getContext(), str, new a(activity), new b());
            this.d = bVarA;
            bVarA.e();
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        a(view);
        super.addView(view, i, i2);
    }

    public final void b(boolean z) {
        s sVar = this.e;
        if (sVar != null) {
            sVar.b(z);
            c(z);
        }
    }

    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i, d dVar) {
        super((Context) ab.a(context, "context cannot be null"), attributeSet, i);
        this.c = (d) ab.a(dVar, "listener cannot be null");
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        setClipToPadding(false);
        n nVar = new n(context);
        this.g = nVar;
        requestTransparentRegion(nVar);
        addView(this.g);
        this.b = new HashSet();
        this.a = new c(this, (byte) 0);
    }

    private void a(View view) {
        if (view != this.g) {
            if (this.e == null || view != this.f) {
                throw new UnsupportedOperationException("No views can be added on top of the player");
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, i, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YouTubeInitializationResult youTubeInitializationResult) {
        this.e = null;
        this.g.c();
        YouTubePlayer.OnInitializedListener onInitializedListener = this.j;
        if (onInitializedListener != null) {
            onInitializedListener.onInitializationFailure(this.h, youTubeInitializationResult);
            this.j = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
        super.addView(view, layoutParams);
    }

    public static /* synthetic */ void a(YouTubePlayerView youTubePlayerView, Activity activity) {
        boolean zA;
        try {
            s sVar = new s(youTubePlayerView.d, aa.a().a(activity, youTubePlayerView.d, youTubePlayerView.k));
            youTubePlayerView.e = sVar;
            View viewA = sVar.a();
            youTubePlayerView.f = viewA;
            youTubePlayerView.addView(viewA);
            youTubePlayerView.removeView(youTubePlayerView.g);
            youTubePlayerView.c.a(youTubePlayerView);
            if (youTubePlayerView.j != null) {
                Bundle bundle = youTubePlayerView.i;
                if (bundle != null) {
                    zA = youTubePlayerView.e.a(bundle);
                    youTubePlayerView.i = null;
                } else {
                    zA = false;
                }
                youTubePlayerView.j.onInitializationSuccess(youTubePlayerView.h, youTubePlayerView.e, zA);
                youTubePlayerView.j = null;
            }
        } catch (w.a e) {
            y.a("Error creating YouTubePlayerView", e);
            youTubePlayerView.a(YouTubeInitializationResult.INTERNAL_ERROR);
        }
    }

    public final void a(boolean z) {
        this.k = z;
    }
}
