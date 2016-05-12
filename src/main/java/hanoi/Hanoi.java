package hanoi;

import java.util.List;

public class Hanoi {

  public List<Move> solve(int disks, Pole source, Pole auxiliary, Pole destination) {
    //TODO: Solve the Hanoi Towers problem using RxJava.
    return null;
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
