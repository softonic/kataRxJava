package hanoi;

class Move {
  private final String fromPole;
  private final String toPole;

  Move(String fromPole, String toPole) {
    this.fromPole = fromPole;
    this.toPole = toPole;
  }

  String getFromPole() {
    return fromPole;
  }

  String getToPole() {
    return toPole;
  }
}
