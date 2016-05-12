package randomFamily;

import com.google.gson.annotations.SerializedName;

public class UserEntity {
  public static final String GENDER_MALE = "male";
  public static final String GENDER_FEMALE = "female";

  @SerializedName("gender")
  private String gender;

  @SerializedName("name")
  private NameEntity name;

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public NameEntity getName() {
    return name;
  }

  public void setName(NameEntity name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
        "gender=" + gender +
        ", name='" + name + '\'' +
        '}';
  }
}
