package consensus;

import rx.Observable;

public class Consensus {
  public void printConsensus(Journal journal) {
    Observable<Boolean> voter1 = createVoter(1, journal);
    Observable<Boolean> voter2 = createVoter(2, journal);
    Observable<Boolean> voter3 = createVoter(3, journal);

    //TODO: Using RxJava pick up all the votes an guess which is the final resolution.
    //Final resolution should be written through Journal Instance.

  }

  private Observable<Boolean> createVoter(int number, Journal journal) {
    //TODO: Create an observable performs the bellow steps:
    // -Sleep a random amount of time.
    // -Obtains a random answer.
    // -Write the answer in the journal.
    // -Emit the random answer.
    return null;
  }

  private int getRandomSleepInMillisec() {
    return (int) ((1 + Math.random() * 2) * 1000);
  }

  private boolean getRandomAnswer() {
    return Math.random() > 0.5;
  }
}
