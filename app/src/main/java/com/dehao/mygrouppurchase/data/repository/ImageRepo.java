package com.dehao.mygrouppurchase.data.repository;


import com.dehao.mygrouppurchase.base.BaseRepo;
import com.dehao.mygrouppurchase.data.models.ImgListEntity;
import com.dehao.mygrouppurchase.data.retrofit.RetrofitClient;
import com.dehao.mygrouppurchase.utils.MLog;

import rx.Observable;

/**
 * Created by marno on 2016/7/21/21:06.
 * 图片
 */
public class ImageRepo extends BaseRepo {

    private static volatile ImageRepo instance;

    private ImageRepo() {
    }

    public static ImageRepo getIns() {
        if (instance == null) {
            synchronized (ImageRepo.class) {
                if (instance == null) {
                    instance = new ImageRepo();
                }
            }
        }
        return instance;
    }

    /**
     * 获取游戏列表
     *
     * @param page   分页
     * @return
     */
    public Observable<ImgListEntity> getImageList(int page) {
        MLog.i("开始获取数据");
        return transform(RetrofitClient.getImgIns().IMAGE().imgList(page));
    }
}
