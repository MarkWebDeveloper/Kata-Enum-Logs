public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42),
    UNKNOWN(0);

    private final int logLevelCode;

    LogLevel(int logLevelCode) {
        this.logLevelCode = logLevelCode;
    }

    public int getLogLevelCode() {
        return this.logLevelCode;
    }
}
