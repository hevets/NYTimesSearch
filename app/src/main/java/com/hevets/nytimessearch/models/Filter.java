package com.hevets.nytimessearch.models;

import java.io.Serializable;

/**
 * Created by hevets on 3/24/17.
 */

public class Filter implements Serializable {

    String sortby;

    public String getSortby() {
        return sortby;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby;
    }
}
