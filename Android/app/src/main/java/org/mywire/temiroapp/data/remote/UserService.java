package org.mywire.temiroapp.data.remote;

import org.mywire.temiroapp.model.User;
import org.mywire.temiroapp.ui.user.UserRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/webapi/login/")
    Call<UserRequest> loginUser(@Body User loginRequest);


    @POST("/webapi/registro/")
    Call<UserRequest> registroUser(@Body User user);

}
