package randomFamily;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestEntity {
  @SerializedName("results")
  private List<UserEntity> results;

  public List<UserEntity> getResults() {
    return results;
  }
}
