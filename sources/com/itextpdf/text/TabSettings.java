package com.itextpdf.text;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TabSettings {
    public static final float DEFAULT_TAB_INTERVAL = 36.0f;
    private float tabInterval;
    private java.util.List<TabStop> tabStops;

    public TabSettings() {
        this.tabStops = new ArrayList();
        this.tabInterval = 36.0f;
    }

    public static TabStop getTabStopNewInstance(float f, TabSettings tabSettings) {
        return tabSettings != null ? tabSettings.getTabStopNewInstance(f) : TabStop.newInstance(f, 36.0f);
    }

    public float getTabInterval() {
        return this.tabInterval;
    }

    public java.util.List<TabStop> getTabStops() {
        return this.tabStops;
    }

    public void setTabInterval(float f) {
        this.tabInterval = f;
    }

    public void setTabStops(java.util.List<TabStop> list) {
        this.tabStops = list;
    }

    public TabStop getTabStopNewInstance(float f) {
        TabStop tabStop;
        java.util.List<TabStop> list = this.tabStops;
        if (list != null) {
            for (TabStop tabStop2 : list) {
                if (tabStop2.getPosition() - f > 0.001d) {
                    tabStop = new TabStop(tabStop2);
                }
            }
            tabStop = null;
        } else {
            tabStop = null;
        }
        return tabStop == null ? TabStop.newInstance(f, this.tabInterval) : tabStop;
    }

    public TabSettings(java.util.List<TabStop> list) {
        new ArrayList();
        this.tabInterval = 36.0f;
        this.tabStops = list;
    }

    public TabSettings(float f) {
        this.tabStops = new ArrayList();
        this.tabInterval = f;
    }

    public TabSettings(java.util.List<TabStop> list, float f) {
        new ArrayList();
        this.tabStops = list;
        this.tabInterval = f;
    }
}
