package com.jordifierro.androidbase.data.repository;

import com.jordifierro.androidbase.data.net.RestApi;
import com.jordifierro.androidbase.domain.entity.MoviesEntity;
import com.jordifierro.androidbase.domain.repository.MovieRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by cafer on 10/16/17.
 */

public class MoviesDataRepository extends RestApiRepository implements MovieRepository {

    private final String API_KEY = "35ef0461fc4557cf1d256d3335ed7545";
    private final RestApi restApi;

    @Inject
    public MoviesDataRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<MoviesEntity> getUpcomingMovies(String page) {
        return this.restApi.getUpcomingMovies(API_KEY,"en",page)
                .map(listResponse -> {
                    handleResponseError(listResponse);
                    return listResponse.body();
                });
    }
}
