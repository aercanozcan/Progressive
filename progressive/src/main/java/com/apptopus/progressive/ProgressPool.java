package com.apptopus.progressive;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by Ercan on 12/16/2015.
 */
public class ProgressPool {

    private static ProgressPool instance = null;

    private ArrayList<Progress> pool = new ArrayList<>();


    private   ProgressPool(){
    }


    public static ProgressPool getInstance(){
        if(instance==null){
          instance = new ProgressPool();
        }
        return instance;
    }





    public void showProgress(View view){

        Progress p = new Progress(view);
        if(pool.contains(p)){
            p = pool.get(pool.indexOf(p));
            p.showProgress();
        }
        else{
            pool.add(p);
            p.showProgress();
        }

    }


    public void showProgress(View view,int resourceId){

        Progress p = new Progress(view,resourceId);
        if(pool.contains(p)){
            p = pool.get(pool.indexOf(p));
            p.showProgress();
        }
        else{
            pool.add(p);
            p.showProgress();
        }

    }

    public void hideProgress(View view){
        Progress p = new Progress(view);
        if(pool.contains(p)){
            p = pool.get(pool.indexOf(p));
            p.hideProgress();
            pool.remove(p);
        }
        else{
            p = null;
        }
    }

    public void clearPool(){
        for(Progress progress : pool){
            if(progress.isEncapsulated()){
                progress.hideProgress();
            }
        }
        pool.clear();
    }


}
