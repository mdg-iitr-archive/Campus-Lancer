package com.aka.campus_lancer.data.model;

import com.aka.campus_lancer.Persons;

import java.util.List;

/**
 * @author akshayaggarwal
 * @since 28-02-2016
 */
public class FeedsResponse {

    private String page;

    private Persons[] results;

    public String getPage() {
        return page;
    }

    public Persons[] getResults() {
        return results;
    }
}