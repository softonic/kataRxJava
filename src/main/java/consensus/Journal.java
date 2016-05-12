package consensus;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Journal {
  private final List<JournalEntry> journalEntries = new LinkedList<>();

  void write(String message) {
    journalEntries.add(new JournalEntry(System.currentTimeMillis(), message));
    System.out.println(message);
  }

  List<JournalEntry> getJournalEntries() {
    return Collections.unmodifiableList(journalEntries);
  }

  List<String> getJournalMessages() {
    //TODO: Use RxJava to create a right implementation for this method.
    return null;
  }
}