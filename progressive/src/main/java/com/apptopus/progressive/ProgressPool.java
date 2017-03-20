package com.apptopus.progressive;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by Ercan on 12/16/2015.
 * The singleton class that manages a pool of {@link Progress} objects
 */
class ProgressPool {// package access only

    private static ProgressPool instance = null;

    private ArrayList<Progress> pool = new ArrayList<>();


    private ProgressPool() {// singleton access only
    }


    public static ProgressPool getInstance() {
        if (instance == null) {
            instance = new ProgressPool();
        }
        return instance;
    }


    /**
     * Finds a {@link Progress} object related to view if exist. Creates a new one if does not exist. calls its {@link Progress#showProgress()} method
     *
     * @param view
     */
    public void showProgress(View view) {

        Progress p = new Progress(view);
        if (pool.contains(p)) {
            p = pool.get(pool.indexOf(p));
            p.showProgress();
        } else {
            pool.add(p);
            p.showProgress();
        }

    }

    /**
     * Finds a {@link Progress} object related to view if exist. Creates a new one if does not exist. {@link Progress#showProgress()} method
     *
     * @param view
     * @param customProgressView
     */
    public void showProgress(View view, View customProgressView) {

        Progress p = new Progress(view, customProgressView);
        if (pool.contains(p)) {
            p = pool.get(pool.indexOf(p));
            p.showProgress();
        } else {
            pool.add(p);
            p.showProgress();
        }

    }

    /**
     * Finds a {@link Progress} object related to view if exist and calls its {@link Progress#hideProgress()} method, then removes it from pool.
     *
     * @param view
     */
    public void hideProgress(View view) {
        Progress p = new Progress(view);
        if (pool.contains(p)) {
            p = pool.get(pool.indexOf(p));
            p.hideProgress();
            pool.remove(p);
        } else {
            p = null;// same as doing nothing.
        }
    }

    /**
     * Clears all Progress objects from pool
     */
    public void clearPool() {
        for (Progress progress : pool) {
            if (progress.isEncapsulated()) {
                progress.hideProgress();
            }
        }
        pool.clear();
    }


}
