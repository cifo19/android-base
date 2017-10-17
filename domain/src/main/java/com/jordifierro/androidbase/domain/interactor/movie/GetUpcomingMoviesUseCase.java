package com.jordifierro.androidbase.domain.interactor.movie;

import com.jordifierro.androidbase.domain.entity.MoviesEntity;
import com.jordifierro.androidbase.domain.executor.PostExecutionThread;
import com.jordifierro.androidbase.domain.executor.ThreadExecutor;
import com.jordifierro.androidbase.domain.interactor.UseCase;
import com.jordifierro.androidbase.domain.repository.MovieRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by cafer on 10/16/17.
 */

public class GetUpcomingMoviesUseCase extends UseCase<MoviesEntity> {

    private MovieRepository movieRepository;

    @Inject
    public GetUpcomingMoviesUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                    MovieRepository movieRepository) {
        super(threadExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }

    @Override
    protected Observable<MoviesEntity> buildUseCaseObservable() {
        return this.movieRepository.getUpcomingMovies("1");
    }
}
