package com.geniusvjr.passwordassistant.mvp.ui.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geniusvjr.passwordassistant.R;

/**
 * Created by dream on 16/5/21.
 */
public abstract class Base extends AppCompatActivity{

    private boolean isAnim;

    public enum TransitionMode{
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        SCALE,
        FADE
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        if(intent != null){
            isAnim = intent.getBooleanExtra("anim", false);
        }
        if(isAnim){
            startAnime();
        }
        super.onCreate(savedInstanceState);
    }

    private void startAnime() {
        if(toggleOverridePendingTransition()){
            switch (getOverridePendingTransitionMode()){
                case LEFT:
                    overridePendingTransition(R.anim.left_in,R.anim.left_out);
                    break;
                case RIGHT:
                    overridePendingTransition(R.anim.right_in,R.anim.right_out);
                    break;
                case TOP:
                    overridePendingTransition(R.anim.top_in,R.anim.top_out);
                    break;
                case BOTTOM:
                    overridePendingTransition(R.anim.bottom_in,R.anim.bottom_out);
                    break;
                case SCALE:
                    overridePendingTransition(R.anim.scale_in,R.anim.scale_out);
                    break;
                case FADE:
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
            }
        }
    }


    protected abstract TransitionMode getOverridePendingTransitionMode();

    protected abstract boolean toggleOverridePendingTransition();
}
