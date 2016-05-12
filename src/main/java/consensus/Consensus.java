package consensus;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Consensus {
  public void printConsensus(final Journal journal) {
    Observable<Boolean> voter1 = createVoter(1, journal);
    Observable<Boolean> voter2 = createVoter(2, journal);
    Observable<Boolean> voter3 = createVoter(3, journal);

    Observable
        .merge(voter1, voter2, voter3)
        .filter(new Func1<Boolean, Boolean>() {
          @Override
          public Boolean call(Boolean aBoolean) {
            return aBoolean;
          }
        })
        .count()
        .all(new Func1<Integer, Boolean>() {
          @Override
          public Boolean call(Integer integer) {
            return integer >= 2;
          }
        })
        .doOnNext(new Action1<Boolean>() {
          @Override
          public void call(Boolean aBoolean) {
            journal.write("Resolution: " + aBoolean);
          }
        })

        .toBlocking()
        .first();
  }

  private Observable<Boolean> createVoter(final int number, final Journal journal) {
    return Observable
        .just(getRandomAnswer())
        .delay(getRandomSleepInMillis(), TimeUnit.MILLISECONDS)
        .doOnNext(new Action1<Boolean>() {
          @Override
          public void call(Boolean aBoolean) {
            journal.write("Voter " + number + " answers " + aBoolean);
          }
        });
  }

  private int getRandomSleepInMillis() {
    return (int) ((1 + Math.random() * 2) * 1000);
  }

  private boolean getRandomAnswer() {
    return Math.random() > 0.5;
  }
}
