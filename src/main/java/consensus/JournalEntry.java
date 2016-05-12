package consensus;

class JournalEntry {
  private final long logDate;
  private final String message;

  JournalEntry(long logDate, String message) {
    this.logDate = logDate;
    this.message = message;
  }

  long getLogDate() {
    return logDate;
  }

  String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "JournalEntry{" +
        "logDate=" + logDate +
        ", message='" + message + '\'' +
        '}';
  }
}
