package randumFamily;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

interface RandomUserApi {
  @GET()
  Observable<UserEntity> getUser();

  @GET()
  Observable<UserEntity> getUserByGender(@Query("gender") String gender);

  @GET()
  Observable<UserEntity> getUserByGender(@Query("gender") String gender, @Query("results") int results);
}
