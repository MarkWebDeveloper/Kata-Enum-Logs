public class LogLine {

    private String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {

        int firstIndex = logLine.indexOf("[") + 1;
        int lastIndex = logLine.indexOf("]");
        String rawLogLevel = logLine.substring(firstIndex, lastIndex);

        LogLevel finalLogLevel = getLogLevelEnum(rawLogLevel);
        return finalLogLevel;
    }

    public String getOutputForShortLog() {
        return logLine;
    }

    public LogLevel getLogLevelEnum(String rawString) {
        switch (rawString) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

}
