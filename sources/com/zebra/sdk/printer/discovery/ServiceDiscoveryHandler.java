package com.zebra.sdk.printer.discovery;

import com.zebra.sdk.comm.ConnectionChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface ServiceDiscoveryHandler {
    void discoveryFinished();

    void foundService(ConnectionChannel connectionChannel);
}
