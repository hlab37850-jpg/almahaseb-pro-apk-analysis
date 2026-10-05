package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import defpackage.AbstractC3880sS;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String str, String str2) {
        if (!AbstractC3961tS.G(str2, "*", false, 2, null)) {
            return false;
        }
        if (AbstractC4492zt.d(str2, "*")) {
            return true;
        }
        if (AbstractC3961tS.R(str2, "*", 0, false, 6, null) != AbstractC3961tS.X(str2, "*", 0, false, 6, null) || !AbstractC3880sS.p(str2, "*", false, 2, null)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return AbstractC3880sS.B(str, strSubstring, false, 2, null);
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity activity, ComponentName componentName) {
        ComponentName component;
        AbstractC4492zt.h(activity, "activity");
        AbstractC4492zt.h(componentName, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), componentName)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, componentName);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0086  */
    public final boolean areComponentsMatching$window_release(ComponentName componentName, ComponentName componentName2) {
        boolean z;
        boolean z2;
        AbstractC4492zt.h(componentName2, "ruleComponent");
        if (componentName == null) {
            return AbstractC4492zt.d(componentName2.getPackageName(), "*") && AbstractC4492zt.d(componentName2.getClassName(), "*");
        }
        String string = componentName.toString();
        AbstractC4492zt.g(string, "activityComponent.toString()");
        if (AbstractC3961tS.G(string, "*", false, 2, null)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.");
        }
        if (AbstractC4492zt.d(componentName.getPackageName(), componentName2.getPackageName())) {
            z = true;
        } else {
            String packageName = componentName.getPackageName();
            AbstractC4492zt.g(packageName, "activityComponent.packageName");
            String packageName2 = componentName2.getPackageName();
            AbstractC4492zt.g(packageName2, "ruleComponent.packageName");
            if (wildcardMatch(packageName, packageName2)) {
                z = true;
            } else {
                z = false;
            }
        }
        if (AbstractC4492zt.d(componentName.getClassName(), componentName2.getClassName())) {
            z2 = true;
        } else {
            String className = componentName.getClassName();
            AbstractC4492zt.g(className, "activityComponent.className");
            String className2 = componentName2.getClassName();
            AbstractC4492zt.g(className2, "ruleComponent.className");
            if (wildcardMatch(className, className2)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z && z2;
    }
}
