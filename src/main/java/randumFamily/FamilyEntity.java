package randumFamily;

import java.util.List;

public class FamilyEntity {
  private final UserEntity father;
  private final UserEntity mother;
  private final List<UserEntity> sons;
  private final List<UserEntity> daughters;

  public FamilyEntity(UserEntity father, UserEntity mother, List<UserEntity> sons, List<UserEntity> daughters) {
    this.father = father;
    this.mother = mother;
    this.sons = sons;
    this.daughters = daughters;
  }

  public UserEntity getFather() {
    return father;
  }

  public UserEntity getMother() {
    return mother;
  }

  public List<UserEntity> getSons() {
    return sons;
  }

  public List<UserEntity> getDaughters() {
    return daughters;
  }
}
