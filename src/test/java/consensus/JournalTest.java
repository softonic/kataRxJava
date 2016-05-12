package consensus;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JournalTest {

  @Test
  public void shouldReturnEmptyJournalMessageListWhenNothingInJournal() {
    Journal journal = givenAnyJournal();

    List<String> messages = journal.getJournalMessages();

    assertNotNull(messages);
    assertTrue(messages.isEmpty());
  }

  @Test
  public void shouldReturnNonEmptyJournalMessageListWhenJournalContainsMessages() {
    Journal journal = givenAnyJournal("lorem", "ipsum");

    List<String> messages = journal.getJournalMessages();

    assertNotNull(messages);
    assertEquals(2, messages.size());
  }

  private Journal givenAnyJournal(String... messages) {
    Journal journal = new Journal();
    for (String message : messages) {
      journal.write(message);
    }
    return journal;
  }
}