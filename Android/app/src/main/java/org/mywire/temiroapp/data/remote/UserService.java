package org.mywire.temiroapp.data.remote;

import org.mywire.temiroapp.model.User;
import org.mywire.temiroapp.util.GenericRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/webapi/login/")
    Call<String> loginUser(@Body User loginRequest);

    @POST("/webapi/registro/")
    Call<GenericRequest> registroUser(@Body User user);

}
