public class LogLine {

    private String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {

        String rawLogLevel = logLine.substring(logLine.indexOf("[") + 1, logLine.indexOf("]"));

        LogLevel finalLogLevel = getLogLevelEnum(rawLogLevel);
        return finalLogLevel;
    }

    public String getOutputForShortLog() {
        LogLevel searchedLogLevel = getLogLevel();
        int logLevelCode = searchedLogLevel.getLogLevelCode();
        
        String rawLogLevel = logLine.substring(logLine.indexOf("["), logLine.indexOf(":"));
        
        int spaceIndex = logLine.indexOf(":") + 1;
        String space = logLine.substring(spaceIndex, spaceIndex + 1);
        String noSpaceString = logLine.replaceFirst(space, "");

        String newString = noSpaceString.replace(rawLogLevel, Integer.toString(logLevelCode));
        return newString;
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
