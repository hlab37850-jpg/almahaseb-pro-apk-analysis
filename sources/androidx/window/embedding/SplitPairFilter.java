package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(ComponentName componentName, ComponentName componentName2, String str) {
        int i;
        boolean z;
        Object obj;
        AbstractC4492zt.h(componentName, "primaryActivityName");
        AbstractC4492zt.h(componentName2, "secondaryActivityName");
        this.primaryActivityName = componentName;
        this.secondaryActivityName = componentName2;
        this.secondaryActivityIntentAction = str;
        String packageName = componentName.getPackageName();
        AbstractC4492zt.g(packageName, "primaryActivityName.packageName");
        String className = componentName.getClassName();
        AbstractC4492zt.g(className, "primaryActivityName.className");
        String packageName2 = componentName2.getPackageName();
        AbstractC4492zt.g(packageName2, "secondaryActivityName.packageName");
        String className2 = componentName2.getClassName();
        AbstractC4492zt.g(className2, "secondaryActivityName.className");
        if (packageName.length() == 0 || packageName2.length() == 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        }
        if (className.length() == 0 || className2.length() == 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.");
        }
        if (AbstractC3961tS.G(packageName, "*", false, 2, null) && AbstractC3961tS.R(packageName, "*", 0, false, 6, null) != packageName.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
        if (AbstractC3961tS.G(className, "*", false, 2, null)) {
            i = 2;
            z = false;
            if (AbstractC3961tS.R(className, "*", 0, false, 6, null) != className.length() - 1) {
                throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
            }
            obj = null;
        } else {
            i = 2;
            z = false;
            obj = null;
        }
        if (AbstractC3961tS.G(packageName2, r12, z, i, obj) && AbstractC3961tS.R(packageName2, "*", 0, false, 6, null) != packageName2.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
        if (AbstractC3961tS.G(className2, "*", z, i, obj) && AbstractC3961tS.R(className2, "*", 0, false, 6, null) != className2.length() - 1) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return AbstractC4492zt.d(this.primaryActivityName, splitPairFilter.primaryActivityName) && AbstractC4492zt.d(this.secondaryActivityName, splitPairFilter.secondaryActivityName) && AbstractC4492zt.d(this.secondaryActivityIntentAction, splitPairFilter.secondaryActivityIntentAction);
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int iHashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityIntentAction;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivityIntentPair(Activity activity, Intent intent) {
        AbstractC4492zt.h(activity, "primaryActivity");
        AbstractC4492zt.h(intent, "secondaryActivityIntent");
        ComponentName componentName = activity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        return str == null || AbstractC4492zt.d(str, intent.getAction());
    }

    public final boolean matchesActivityPair(Activity activity, Activity activity2) {
        AbstractC4492zt.h(activity, "primaryActivity");
        AbstractC4492zt.h(activity2, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        boolean z = false;
        boolean z2 = matcherUtils.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) && matcherUtils.areComponentsMatching$window_release(activity2.getComponentName(), this.secondaryActivityName);
        if (activity2.getIntent() == null) {
            return z2;
        }
        if (z2) {
            Intent intent = activity2.getIntent();
            AbstractC4492zt.g(intent, "secondaryActivity.intent");
            if (matchesActivityIntentPair(activity, intent)) {
                z = true;
            }
        }
        return z;
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + ((Object) this.secondaryActivityIntentAction) + '}';
    }
}
