package com.jordifierro.androidbase.presentation.view;

import com.jordifierro.androidbase.domain.entity.MoviesEntity;

/**
 * Created by cafer on 10/16/17.
 */

public interface UpcomingMoviesView extends BaseView {

    void showMovies(MoviesEntity moviesEntity);
}
