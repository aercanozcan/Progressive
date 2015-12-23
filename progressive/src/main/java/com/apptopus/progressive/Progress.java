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
 class Progress {// package access only

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

    /**
     * shared initializer for constructors
     */
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

    /**
     * Wraps the view with a frame layout and puts a progress indicator in it
     */
    private void box(){
        try {

            progressBar =  LayoutInflater.from(view.getContext()).inflate(resourceId, parent, false); //inflate the resource

            FrameLayout.LayoutParams progressLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);//create layout params for progress indicator
            progressLayoutParams.gravity = Gravity.CENTER;//set gravity as center for align in center of view
            progressBar.setLayoutParams(progressLayoutParams);

            parent = (ViewGroup) view.getParent();//retrieve parent view as a ViewGroup
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();//move the exact layout parameter in order to keep position size ect.
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(view.getId());// to keep RelativeLayout rules we give the same id to frame layout
            frameLayout.setLayoutParams(layoutParams);//passing the previous layout params to frame layout

            parent.removeView(view); //removing the view from its former parent

            FrameLayout.LayoutParams frameLayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);//creatin layout params for original view
            frameLayoutParams.gravity = Gravity.CENTER;//in the center of frame layout
            view.setLayoutParams(frameLayoutParams);

            frameLayout.addView(view);//put original vie in frame layout
            frameLayout.addView(progressBar);//then overlay progressbar on original view
            parent.addView(frameLayout,originalPosition);// then replace the original view with new frame layout
            encapsulated = true;//set flag as encapsulated



        }catch (ClassCastException e){
            e.printStackTrace();
            Log.e(Progressive.DEBUG_TAG,"View's parent must extend ViewGroup");
        }

    }

    /**
     * unwraps the view from frame layout and removes progress view
     */
    private void unBox(){

        FrameLayout frameLayout = (FrameLayout) view.getParent();//we know that the parent of original view is a frame layout
        ViewGroup.LayoutParams layoutParams =  frameLayout.getLayoutParams();//recovers the former layout params
        frameLayout.removeView(view);//removes the original view from frame layout
        view.setLayoutParams(layoutParams);
        parent.removeView(frameLayout);//removes the frame layout from parent
        frameLayout.removeView(progressBar);
        progressBar = null;
        parent.addView(view, originalPosition, layoutParams);//adds back the original view to its original position
        encapsulated = false;//sets the flag as un-boxed
    }

    /**
     * Shows the progress bar if it is boxed else box it by calling {@link #box()} then set visibility as {@link View#VISIBLE}
     */
    public void showProgress(){
        if(!encapsulated){
           box();
        }
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * Shows the progress bar if it is boxed else un-box it by calling {@link #unBox()} then set visibility as {@link View#GONE}
     */
    public void hideProgress(){
        progressBar.setVisibility(View.GONE);
        if(encapsulated){
            unBox();
        }
    }


    /**
     * To use {@link java.util.Collection} methods
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {

        return ((Progress)o).getView().equals(view);
    }

    /**
     * to retreve original view related to this {@link Progress} object
     * @return
     */
    public View getView() {
        return view;
    }

    /**
     * To check if this Progress is ready to be shown
     * @return
     */
    public boolean isEncapsulated() {
        return encapsulated;
    }
}
