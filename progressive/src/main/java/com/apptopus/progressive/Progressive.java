package com.apptopus.progressive;


import android.view.View;

/**
 * Created by Ercan on 12/16/2015.
 */
public class Progressive {

    public static String DEBUG_TAG = "PROGRESSIVE";

    private static ProgressPool pool = ProgressPool.getInstance();

    private Progressive() {//static access only
    }

    /**
     * Shows default progress view in center of the target view
     *
     * @param view the target view
     */
    public static void showProgress(View view) {
        pool.showProgress(view);
    }

    /**
     * Shows custom progress view in center of the target view
     *
     * @param view the target view
     */
    public static void showProgress(View view, View customProgressView) {
        pool.showProgress(view, customProgressView);
    }

    /**
     * Hides targets the progress view if exist
     *
     * @param view the target view
     */
    public static void hideProgress(View view) {
        pool.hideProgress(view);
    }
}
