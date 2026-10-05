package com.zebra.sdk.printer.internal;

/* JADX INFO: loaded from: classes3.dex */
class CommandType {
    private String id;
    public static final CommandType fnCommand = new CommandType("FN");
    public static final CommandType ccCommand = new CommandType("CC");
    public static final CommandType xgCommand = new CommandType("XG");
    public static final CommandType dfCommand = new CommandType("DF");
    public static final CommandType xaCommand = new CommandType("XA");
    public static final CommandType xzCommand = new CommandType("XZ");
    public static final CommandType unknownCommand = new CommandType("unknown");

    private CommandType(String str) {
        this.id = str;
    }

    public static CommandType getCommand(String str) {
        CommandType commandType = unknownCommand;
        CommandType commandType2 = fnCommand;
        if (!str.equalsIgnoreCase(commandType2.getId())) {
            commandType2 = ccCommand;
            if (!str.equalsIgnoreCase(commandType2.getId())) {
                commandType2 = dfCommand;
                if (!str.equalsIgnoreCase(commandType2.getId())) {
                    commandType2 = xaCommand;
                    if (!str.equalsIgnoreCase(commandType2.getId())) {
                        commandType2 = xzCommand;
                        if (!str.equalsIgnoreCase(commandType2.getId())) {
                            commandType2 = xgCommand;
                            if (!str.equalsIgnoreCase(commandType2.getId())) {
                                return commandType;
                            }
                        }
                    }
                }
            }
        }
        return commandType2;
    }

    public String getId() {
        return this.id.toLowerCase();
    }
}
