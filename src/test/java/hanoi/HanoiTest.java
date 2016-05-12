package hanoi;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class HanoiTest {

  @Test
  public void shouldReturnEmptyMovementsListWhenNoDiskOnThePoles() throws InterruptedException {
    Pole poleA = givenAPole("A");
    Pole poleB = givenAPole("B");
    Pole poleC = givenAPole("C");
    Hanoi hanoi = new Hanoi();

    List<Move> result = hanoi.solve(0, poleA, poleB, poleC);

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  public void shouldReturnMoveFromSourceToDestinationWhenOnlyOneDiskOnSourcePole() throws InterruptedException {
    Pole poleA = givenAPole("A");
    Pole poleB = givenAPole("B");
    Pole poleC = givenAPole("C");
    Hanoi hanoi = new Hanoi();

    List<Move> result = hanoi.solve(1, poleA, poleB, poleC);

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals("A", result.get(0).getFromPole());
    assertEquals("C", result.get(0).getToPole());
  }

  @Test
  public void shouldReturnThreeKnownMovementsWhenOnlyTwoDiskOnSourcePole() throws InterruptedException {
    Pole poleA = givenAPole("A");
    Pole poleB = givenAPole("B");
    Pole poleC = givenAPole("C");
    Hanoi hanoi = new Hanoi();

    List<Move> result = hanoi.solve(2, poleA, poleB, poleC);

    assertNotNull(result);
    assertEquals(3, result.size());
    assertEquals("A", result.get(0).getFromPole());
    assertEquals("B", result.get(0).getToPole());
    assertEquals("A", result.get(1).getFromPole());
    assertEquals("C", result.get(1).getToPole());
    assertEquals("B", result.get(2).getFromPole());
    assertEquals("C", result.get(2).getToPole());
  }

  private Pole givenAPole(String label) {
    return new Pole(label);
  }
}