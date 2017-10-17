package com.jordifierro.androidbase.data.net;

import com.jordifierro.androidbase.data.net.wrapper.UserWrapper;
import com.jordifierro.androidbase.domain.entity.MessageEntity;
import com.jordifierro.androidbase.domain.entity.MoviesEntity;
import com.jordifierro.androidbase.domain.entity.NoteEntity;
import com.jordifierro.androidbase.domain.entity.UserEntity;
import com.jordifierro.androidbase.domain.entity.VersionEntity;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import io.reactivex.Observable;
import retrofit2.http.Query;

public interface RestApi {

    //String URL_BASE = "http://10.0.99.174:3000";
    //int API_VERSION = 1;
    //String VERSION_HEADER = "application/vnd.railsapibase.v" + API_VERSION;

    String URL_BASE = "https://api.themoviedb.org/";

    @POST("/users")
    Observable<Response<UserEntity>> createUser(@Body UserWrapper userWrapper);

    @DELETE("/users/0")
    Observable<Response<Void>> deleteUser(@Header("Authorization") String token);

    @POST("/users/reset_password")
    Observable<Response<MessageEntity>> resetPassword(@Header("Authorization") String token,
                                                      @Body UserWrapper userWrapper);

    @POST("/users/login")
    Observable<Response<UserEntity>> doLogin(@Body UserWrapper userWrapper);

    @DELETE("/users/logout")
    Observable<Response<Void>> doLogout(@Header("Authorization") String token);

    @GET("/versions/state")
    Observable<Response<VersionEntity>> checkVersionExpiration(
            @Header("Authorization") String token);

    @POST("/notes")
    Observable<Response<NoteEntity>> createNote(@Header("Authorization") String token,
                                                @Body NoteEntity note);

    @GET("/notes/{id}")
    Observable<Response<NoteEntity>> getNote(@Header("Authorization") String token,
                                             @Path("id") int noteId);

    @GET("/notes")
    Observable<Response<List<NoteEntity>>> getNotes(@Header("Authorization") String token);

    @PUT("/notes/{id}")
    Observable<Response<NoteEntity>> updateNote(@Header("Authorization") String token,
                                                @Path("id") int noteId, @Body NoteEntity note);

    @DELETE("/notes/{id}")
    Observable<Response<Void>> deleteNote(@Header("Authorization") String token,
                                          @Path("id") int noteId);

    @GET("/3/movie/upcoming")
    Observable<Response<MoviesEntity>> getUpcomingMovies(@Query("api_key") String api_key,
                                                         @Query("language") String language,
                                                         @Query("page") String page);
}
