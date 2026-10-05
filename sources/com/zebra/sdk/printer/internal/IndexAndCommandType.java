package com.zebra.sdk.printer.internal;

/* JADX INFO: loaded from: classes3.dex */
class IndexAndCommandType {
    private CommandType command;
    private int index;

    public IndexAndCommandType(int i, CommandType commandType) {
        this.index = i;
        this.command = commandType;
    }

    public CommandType getCommand() {
        return this.command;
    }

    public int getIndex() {
        return this.index;
    }
}
