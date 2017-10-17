package com.jordifierro.androidbase.domain.repository;

import com.jordifierro.androidbase.domain.entity.MoviesEntity;

import io.reactivex.Observable;

/**
 * Created by cafer on 10/16/17.
 */

public interface MovieRepository {

    Observable<MoviesEntity> getUpcomingMovies(String page);
}
