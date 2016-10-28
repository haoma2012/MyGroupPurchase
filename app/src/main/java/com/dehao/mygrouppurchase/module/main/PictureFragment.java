package com.dehao.mygrouppurchase.module.main;

import android.os.Bundle;
import android.view.View;

import com.dehao.mygrouppurchase.R;
import com.dehao.mygrouppurchase.base.BaseFragment;

/**
 * Created by Administrator on 2016/10/27.
 */

public class PictureFragment extends BaseFragment{

    public static PictureFragment newInstance() {
        return new PictureFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.item_image;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected View getToolBarView() {
        return null;
    }
}
