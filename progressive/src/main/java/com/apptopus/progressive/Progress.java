package com.apptopus.progressive;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * Created by Ercan on 12/16/2015.
 *
 */
public class Progress {

    private ViewGroup parent;
    private View view;
    private boolean encapsulated = false;
    private int originalPosition = 0;
    private View progressBar;
    private int resourceId = R.layout.generic_progress;



    public Progress(View v){
        this.view = v;
        init();

    }

    public Progress(View v , int resourceId){

        this.view = v;
        this.resourceId = resourceId;
        init();
    }

    private void init(){
        try {
            this.parent = (ViewGroup) view.getParent();
            int childCount = parent.getChildCount();
            for(int i = 0; i < childCount; i++){
                if(parent.getChildAt(i).equals(view)){
                    originalPosition = i;
                    break;
                }
            }

        }catch (ClassCastException e){
            e.printStackTrace();
            Log.e(Progressive.DEBUG_TAG,"View's parent must extend ViewGroup");
        }
    }

    private void box(){
        try {

            progressBar =  LayoutInflater.from(view.getContext()).inflate(resourceId, parent, false);
            FrameLayout.LayoutParams progresLayoutParams =new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            progresLayoutParams.gravity = Gravity.CENTER;
            progressBar.setLayoutParams(progresLayoutParams);
            parent = (ViewGroup) view.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(view.getId());// to keep RelativeLayout rules
            frameLayout.setLayoutParams(layoutParams);
            parent.removeView(view);
            FrameLayout.LayoutParams frameLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            frameLayoutParams.gravity = Gravity.CENTER;
            view.setLayoutParams(frameLayoutParams);
            frameLayout.addView(view);
            frameLayout.addView(progressBar);
            parent.addView(frameLayout,originalPosition);
            encapsulated = true;



        }catch (ClassCastException e){
            e.printStackTrace();
            Log.e(Progressive.DEBUG_TAG,"View's parent must extend ViewGroup");
        }

    }


    private void unBox(){

        FrameLayout frameLayout = (FrameLayout) view.getParent();
        ViewGroup.LayoutParams layoutParams =  frameLayout.getLayoutParams();
        frameLayout.removeView(view);
        view.setLayoutParams(layoutParams);
        parent.removeView(frameLayout);
        parent.addView(view, originalPosition, layoutParams);
        encapsulated = false;
    }


    public void showProgress(){
        if(!encapsulated){
           box();
        }
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        progressBar.setVisibility(View.GONE);
        if(encapsulated){
            unBox();
        }
    }

    @Override
    public boolean equals(Object o) {

        return ((Progress)o).getView().equals(view);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public boolean isEncapsulated() {
        return encapsulated;
    }
}
