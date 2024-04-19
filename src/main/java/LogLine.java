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
        LogLevel searchedLogLevel = getLogLevel();
        int logLevelCode = searchedLogLevel.getLogLevelCode();
        System.out.println(logLevelCode);
        
        int firstIndex = logLine.indexOf("[");
        int lastIndex = logLine.indexOf(":");
        String rawLogLevel = logLine.substring(firstIndex, lastIndex);
        System.out.println(rawLogLevel);
        
        int spaceIndex = lastIndex + 1;
        System.out.println(spaceIndex);
        String space = logLine.substring(spaceIndex, spaceIndex + 1);
        String noSpaceString = logLine.replaceFirst(space, "");
        System.out.println(noSpaceString);

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
