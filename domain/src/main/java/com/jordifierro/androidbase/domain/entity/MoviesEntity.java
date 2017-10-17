package com.jordifierro.androidbase.domain.entity;

import java.util.List;

/**
 * Created by cafer on 10/16/17.
 */

public class MoviesEntity {

    private int page;
    private int total_results;
    private int total_pages;
    private DatesEntity datesEntity;
    private List<MovieEntity> results;

    public MoviesEntity() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public DatesEntity getDatesEntity() {
        return datesEntity;
    }

    public void setDatesEntity(DatesEntity datesEntity) {
        this.datesEntity = datesEntity;
    }

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }
}
