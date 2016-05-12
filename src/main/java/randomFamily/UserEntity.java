package randomFamily;

import com.google.gson.annotations.SerializedName;

public class UserEntity {
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
}
