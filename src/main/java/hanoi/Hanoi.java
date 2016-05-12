package hanoi;

import rx.Observable;

import java.util.List;

public class Hanoi {
  private Observable<Move> rxSolve(int disks, Pole source, Pole auxiliary, Pole destination) {
    if (disks == 1) {
      return Observable.just(new Move(source.getLabel(), destination.getLabel()));
    } else if (disks > 1) {
      return Observable.merge(
          rxSolve(disks - 1, source, destination, auxiliary),
          Observable.just(new Move(source.getLabel(), destination.getLabel())),
          rxSolve(disks - 1, auxiliary, source, destination)
      );
    }
    return Observable.empty();
  }

  public List<Move> solve(int disks, Pole source, Pole auxiliary, Pole destination) {
    return rxSolve(disks, source, auxiliary, destination).toList().toBlocking().first();
  }

  public static void main(String[] args) {
    Pole poleA = new Pole("A");
    Pole poleB = new Pole("B");
    Pole poleC = new Pole("C");
    Hanoi hanoi = new Hanoi();

    List<Move> moves = hanoi.solve(5, poleA, poleB, poleC);

    for (Move move : moves) {
      System.out.println("From " + move.getFromPole() + " to " + move.getToPole());
    }
  }
}
