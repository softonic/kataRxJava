package consensus;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ConsensusTest {
  @Test
  public void testPrintConsensusFinishesInLessThan4Seconds() {
    Journal journal = givenAnyJournal();
    Consensus consensus = givenAnyConsensus();

    consensus.printConsensus(journal);
    List<JournalEntry> entries = journal.getJournalEntries();

    assertNotNull(entries);
    assertEquals(4, entries.size());
    assertTrue(TimeUnit.MILLISECONDS.toSeconds(entries.get(3).getLogDate() - entries.get(0).getLogDate()) <= 3);
  }

  private Journal givenAnyJournal() {
    return new Journal();
  }

  private Consensus givenAnyConsensus() {
    return new Consensus();
  }
}