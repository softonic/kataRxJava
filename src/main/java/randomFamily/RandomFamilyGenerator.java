package randomFamily;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func4;

import java.util.Collections;
import java.util.List;

public class RandomFamilyGenerator {
  private final RandomUserApi randomUserApi;

  public RandomFamilyGenerator(RandomUserApi randomUserApi) {
    this.randomUserApi = randomUserApi;
  }

  public FamilyEntity createFamily(int sons, int daughters) {
    Observable<UserEntity> obsFather = getSingleUserByGender(UserEntity.GENDER_MALE);
    Observable<UserEntity> obsMother = getSingleUserByGender(UserEntity.GENDER_FEMALE);
    Observable<UserEntity> obsSons = getMultipleUsersByGender(UserEntity.GENDER_MALE, sons);
    Observable<UserEntity> obsDaughters = getMultipleUsersByGender(UserEntity.GENDER_FEMALE, daughters);

    FamilyEntity familyEntity = Observable
        .zip(obsFather, obsMother, obsSons.toList(), obsDaughters.toList(), new Func4<UserEntity, UserEntity, List<UserEntity>, List<UserEntity>, FamilyEntity>() {
          @Override
          public FamilyEntity call(UserEntity fatherEntity, UserEntity motherEntity, List<UserEntity> sonEntities, List<UserEntity> daughterEntities) {
            motherEntity.getName().setLast(fatherEntity.getName().getLast());
            for (UserEntity sonEntity : sonEntities) {
              sonEntity.getName().setLast(fatherEntity.getName().getLast());
            }
            for (UserEntity daughterEntity : daughterEntities) {
              daughterEntity.getName().setLast(fatherEntity.getName().getLast());
            }
            return new FamilyEntity(fatherEntity, motherEntity, sonEntities, daughterEntities);
          }
        })
        .toBlocking()
        .first();
    System.out.println(familyEntity.toString());
    return familyEntity;
  }

  private Observable<UserEntity> getSingleUserByGender(String gender) {
    return randomUserApi
        .getUserByGender(gender)
        .flatMap(new Func1<RequestEntity, Observable<UserEntity>>() {
          @Override
          public Observable<UserEntity> call(RequestEntity requestEntity) {
            return Observable.from(requestEntity.getResults());
          }
        });
  }

  private Observable<UserEntity> getMultipleUsersByGender(String gender, int results) {
    return results != 0 ?
        randomUserApi.getUserByGender(gender, results)
            .flatMap(new Func1<RequestEntity, Observable<UserEntity>>() {
              @Override
              public Observable<UserEntity> call(RequestEntity requestEntity) {
                return Observable.from(requestEntity.getResults());
              }
            }) :
        Observable.from(Collections.<UserEntity>emptyList());
  }
}
