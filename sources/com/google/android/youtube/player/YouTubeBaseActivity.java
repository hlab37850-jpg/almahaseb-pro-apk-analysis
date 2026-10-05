package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class YouTubeBaseActivity extends Activity {
    private a a;
    private YouTubePlayerView b;
    private int c;
    private Bundle d;

    public final class a implements YouTubePlayerView.d {
        public a() {
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.d
        public final void a(YouTubePlayerView youTubePlayerView) {
            if (YouTubeBaseActivity.this.b != null && YouTubeBaseActivity.this.b != youTubePlayerView) {
                YouTubeBaseActivity.this.b.c(true);
            }
            YouTubeBaseActivity.this.b = youTubePlayerView;
            if (YouTubeBaseActivity.this.c > 0) {
                youTubePlayerView.a();
            }
            if (YouTubeBaseActivity.this.c >= 2) {
                youTubePlayerView.b();
            }
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.d
        public final void b(YouTubePlayerView youTubePlayerView, String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
            YouTubeBaseActivity youTubeBaseActivity = YouTubeBaseActivity.this;
            youTubePlayerView.a(youTubeBaseActivity, youTubePlayerView, str, onInitializedListener, youTubeBaseActivity.d);
            YouTubeBaseActivity.b(YouTubeBaseActivity.this);
        }

        public /* synthetic */ a(YouTubeBaseActivity youTubeBaseActivity, byte b) {
            this();
        }
    }

    public static /* synthetic */ Bundle b(YouTubeBaseActivity youTubeBaseActivity) {
        youTubeBaseActivity.d = null;
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this, (byte) 0);
        this.d = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.b(isFinishing());
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        this.c = 1;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.c();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.c = 2;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.b();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        YouTubePlayerView youTubePlayerView = this.b;
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", youTubePlayerView != null ? youTubePlayerView.e() : this.d);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.c = 1;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.a();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        this.c = 0;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.d();
        }
        super.onStop();
    }

    public final YouTubePlayerView.d a() {
        return this.a;
    }
}
