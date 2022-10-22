package api;
import java.util.HashMap;

import retrofit2.Call;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
 @FormUrlEncoded
 @POST("alert")
 Call<ResponseBody>store(
         @Field("userRef") String userRef,
         @Field("typeAlert") String typeAlert,
         @Field("longg") String longg,
         @Field("lat") String lat

 );


}
