package com.jordifierro.androidbase.presentation.view.fragment;

import android.util.Log;

import com.jordifierro.androidbase.domain.entity.MoviesEntity;
import com.jordifierro.androidbase.presentation.R;
import com.jordifierro.androidbase.presentation.presenter.BasePresenter;
import com.jordifierro.androidbase.presentation.presenter.UpcomingMoviesPresenter;
import com.jordifierro.androidbase.presentation.view.UpcomingMoviesView;

import javax.inject.Inject;

/**
 * Created by cafer on 10/16/17.
 */

public class UpcomingMoviesFragment extends BaseFragment implements UpcomingMoviesView {

    @Inject
    UpcomingMoviesPresenter upcomingMoviesFragment;

    @Override
    public void showMovies(MoviesEntity moviesEntity) {
        Log.d("upcoming", moviesEntity.getResults().get(0).getTitle());
    }

    @Override
    protected void callInjection() {
        this.getFragmentInjector().inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_upcoming_movies;
    }

    @Override
    protected BasePresenter presenter() {
        return this.upcomingMoviesFragment;
    }
}
