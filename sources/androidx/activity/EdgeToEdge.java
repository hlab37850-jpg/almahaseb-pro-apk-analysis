package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.VisibleForTesting;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeToEdge {
    private static EdgeToEdgeImpl Impl;
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    public static final void enable(ComponentActivity componentActivity) {
        AbstractC4492zt.h(componentActivity, "<this>");
        enable$default(componentActivity, null, null, 3, null);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
        }
        if ((i & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle) {
        AbstractC4492zt.h(componentActivity, "<this>");
        AbstractC4492zt.h(systemBarStyle, "statusBarStyle");
        enable$default(componentActivity, systemBarStyle, null, 2, null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2) {
        AbstractC4492zt.h(componentActivity, "<this>");
        AbstractC4492zt.h(systemBarStyle, "statusBarStyle");
        AbstractC4492zt.h(systemBarStyle2, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        AbstractC4492zt.g(decorView, "window.decorView");
        InterfaceC3750qp detectDarkMode$activity_release = systemBarStyle.getDetectDarkMode$activity_release();
        Resources resources = decorView.getResources();
        AbstractC4492zt.g(resources, "view.resources");
        boolean zBooleanValue = ((Boolean) detectDarkMode$activity_release.invoke(resources)).booleanValue();
        InterfaceC3750qp detectDarkMode$activity_release2 = systemBarStyle2.getDetectDarkMode$activity_release();
        Resources resources2 = decorView.getResources();
        AbstractC4492zt.g(resources2, "view.resources");
        boolean zBooleanValue2 = ((Boolean) detectDarkMode$activity_release2.invoke(resources2)).booleanValue();
        EdgeToEdgeImpl edgeToEdgeApi21 = Impl;
        if (edgeToEdgeApi21 == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                edgeToEdgeApi21 = new EdgeToEdgeApi30();
            } else if (i >= 29) {
                edgeToEdgeApi21 = new EdgeToEdgeApi29();
            } else if (i >= 28) {
                edgeToEdgeApi21 = new EdgeToEdgeApi28();
            } else if (i >= 26) {
                edgeToEdgeApi21 = new EdgeToEdgeApi26();
            } else if (i >= 23) {
                edgeToEdgeApi21 = new EdgeToEdgeApi23();
            } else {
                edgeToEdgeApi21 = new EdgeToEdgeApi21();
                Impl = edgeToEdgeApi21;
            }
        }
        Window window = componentActivity.getWindow();
        AbstractC4492zt.g(window, "window");
        edgeToEdgeApi21.setUp(systemBarStyle, systemBarStyle2, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = componentActivity.getWindow();
        AbstractC4492zt.g(window2, "window");
        edgeToEdgeApi21.adjustLayoutInDisplayCutoutMode(window2);
    }
}
