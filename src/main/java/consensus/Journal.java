package consensus;

import rx.Observable;
import rx.functions.Func1;

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
    return Observable
        .from(journalEntries)
        .map(new Func1<JournalEntry, String>() {
          @Override
          public String call(JournalEntry journalEntry) {
            return journalEntry.getMessage();
          }
        })
        .toList()
        .toBlocking()
        .first();
  }
}