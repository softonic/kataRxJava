package randomFamily;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

interface RandomUserApi {
  @GET("/")
  Observable<RequestEntity> getUser();

  @GET("/")
  Observable<RequestEntity> getUserByGender(@Query("gender") String gender);

  @GET("/")
  Observable<RequestEntity> getUserByGender(@Query("gender") String gender, @Query("results") int results);
}
