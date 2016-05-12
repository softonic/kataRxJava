package randumFamily;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RandomFamilyGeneratorTest {
  @Test
  public void shouldReturnWellComposedRandomFamilyWhenRequestingNoKids() {
    RandomFamilyGenerator randomFamilyGenerator = givenARandomFamilyGenerator();

    FamilyEntity familyEntity = randomFamilyGenerator.createFamily(0, 0);

    assertFatherAndMotherAreValid(familyEntity);
    assertTrue(familyEntity.getSons().isEmpty());
    assertTrue(familyEntity.getDaughters().isEmpty());
  }

  @Test
  public void shouldReturnWellComposedRandomFamilyWhenRequestingTwoSonsAndNoDaughters() {
    RandomFamilyGenerator randomFamilyGenerator = givenARandomFamilyGenerator();

    FamilyEntity familyEntity = randomFamilyGenerator.createFamily(2, 0);

    assertFatherAndMotherAreValid(familyEntity);
    assertEquals(2, familyEntity.getSons().size());
    assertLastNameIsValid(familyEntity.getFather(), familyEntity.getSons());
    assertTrue(familyEntity.getDaughters().isEmpty());
  }

  private void assertFatherAndMotherAreValid(FamilyEntity familyEntity) {
    assertNotNull(familyEntity);
    assertNotNull(familyEntity.getFather());
    assertNotNull(familyEntity.getMother());
    assertEquals("male", familyEntity.getFather().getGender());
    assertEquals("female", familyEntity.getMother().getGender());
    assertLastNameIsValid(familyEntity.getFather(), familyEntity.getMother());
  }

  private void assertLastNameIsValid(UserEntity father, UserEntity... relatives) {
    for (UserEntity relative : relatives) {
      assertEquals(father.getName().getLast(), relative.getName().getLast());
    }
  }

  private void assertLastNameIsValid(UserEntity father, List<UserEntity> relatives) {
    assertLastNameIsValid(father, relatives.toArray(new UserEntity[relatives.size()]));
  }

  private RandomFamilyGenerator givenARandomFamilyGenerator() {
    return new RandomFamilyGenerator(RandomUserApiProvider.get());
  }
}