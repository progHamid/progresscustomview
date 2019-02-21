package com.safarijat.homegroup.safar.ui.Custom.CustomView;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.safarijat.homegroup.safar.R;
import com.safarijat.homegroup.safar.activity.InfoData;

public class ProgressBarCustomView extends RelativeLayout {
    Context context;
    ImageView progreesbar;
    AnimatorSet animatorSet;
    public ProgressBarCustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context,attrs, defStyle);
        this.context=context;
        init(context);
    }
    public ProgressBarCustomView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.context=context;
        init(context);
    }
    public ProgressBarCustomView(Context context) {
        super(context);
        this.context=context;
        init(context);
    }
    private void init(Context context) {
        LayoutInflater.from(context).inflate( R.layout.progreesbar_custom_view, this);
        initComponents();

    }
    private void initComponents() {
        progreesbar = (ImageView) findViewById(R.id.progressLoad);
        animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.newa);
    }

    public void RunAnimations (){
        progreesbar.setVisibility(View.VISIBLE);


        animatorSet.setTarget(progreesbar);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animatorSet.start();
            }
        });
        animatorSet.start();
    }

    public void StopAimations (){
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            animatorSet.removeAllListeners();
            animatorSet.end();
            animatorSet.cancel();
        }, 1);
        progreesbar.clearAnimation();
        progreesbar.animate().cancel();
        progreesbar.setVisibility(View.GONE);
    }
}
