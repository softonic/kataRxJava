package randomFamily;

import java.util.ArrayList;
import java.util.List;
import rx.functions.Func1;

public class RandomFamilyGenerator {
  private final RandomUserApi randomUserApi;

  public RandomFamilyGenerator(RandomUserApi randomUserApi) {
    this.randomUserApi = randomUserApi;
  }

  public FamilyEntity createFamily(int sons, int daughters) {

    final UserEntity father = randomUserApi.getUserByGender(UserEntity.GENDER_MALE)
        .map(new Func1<RequestEntity, UserEntity>() {
          @Override public UserEntity call(RequestEntity requestEntity) {
            return requestEntity.getResults().get(0);
          }
        })
        .toBlocking()
        .first();

    UserEntity mother =
        createNonFatherFamilyMember(UserEntity.GENDER_FEMALE, father.getName().getLast());

    List<UserEntity> sonList = new ArrayList<>();
    if (sons > 0) {
      for (int i = 0; i < sons; i++) {
        sonList.add(
            createNonFatherFamilyMember(UserEntity.GENDER_MALE, father.getName().getLast()));
      }
    }
    List<UserEntity> daughterList = new ArrayList<>();
    if (daughters > 0) {
      daughterList.add(
          createNonFatherFamilyMember(UserEntity.GENDER_FEMALE, father.getName().getLast()));
    }
    return new FamilyEntity(father, mother, sonList, daughterList);
  }

  private UserEntity createNonFatherFamilyMember(String gender, final String familyName) {
    return randomUserApi.getUserByGender(gender).map(new Func1<RequestEntity, UserEntity>() {
      @Override public UserEntity call(RequestEntity requestEntity) {
        UserEntity userEntity = requestEntity.getResults().get(0);
        userEntity.getName().setLast(familyName);
        return userEntity;
      }
    }).toBlocking().first();
  }
}
