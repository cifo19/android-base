package com.jordifierro.androidbase.presentation.presenter;

import com.jordifierro.androidbase.domain.entity.MoviesEntity;
import com.jordifierro.androidbase.domain.interactor.movie.GetUpcomingMoviesUseCase;
import com.jordifierro.androidbase.presentation.dependency.ActivityScope;
import com.jordifierro.androidbase.presentation.view.BaseView;
import com.jordifierro.androidbase.presentation.view.UpcomingMoviesView;

import javax.inject.Inject;

/**
 * Created by cafer on 10/16/17.
 */

@ActivityScope
public class UpcomingMoviesPresenter extends BasePresenter implements Presenter {

    GetUpcomingMoviesUseCase getUpcomingMoviesUseCase;
    UpcomingMoviesView upcomingMoviesView;

    @Inject
    public UpcomingMoviesPresenter(GetUpcomingMoviesUseCase getUpcomingMoviesUseCase) {
        super(getUpcomingMoviesUseCase);
        this.getUpcomingMoviesUseCase = getUpcomingMoviesUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.upcomingMoviesView = (UpcomingMoviesView) view;
    }

    @Override
    public void resume() {
        this.showLoader();
        this.getUpcomingMoviesUseCase.execute(new UpcomingMoviesPresenter.UpcomingMoviesSubscriber());
    }

    @Override
    public void destroy() {
        super.destroy();
        this.upcomingMoviesView = null;
    }

    protected class UpcomingMoviesSubscriber extends BaseSubscriber<MoviesEntity> {
        @Override
        public void onNext(MoviesEntity moviesEntity) {
            UpcomingMoviesPresenter.this.hideLoader();
            UpcomingMoviesPresenter.this.upcomingMoviesView.showMovies(moviesEntity);
        }
    }
}
