package com.dehao.mygrouppurchase.data.repository;

import com.dehao.mygrouppurchase.base.BaseNewsEntity;
import com.dehao.mygrouppurchase.base.BaseRepo;
import com.dehao.mygrouppurchase.data.models.NewsEntity;
import com.dehao.mygrouppurchase.data.retrofit.RetrofitClient;
import com.dehao.mygrouppurchase.utils.MLog;

import java.util.List;

import rx.Observable;

/**
 * Created by marno on 2016/7/21/21:06.
 * 游戏数据仓库
 */
public class NewsRepo extends BaseRepo {

    private static volatile NewsRepo instance;

    private NewsRepo() {
    }

    public static NewsRepo getIns() {
        if (instance == null) {
            synchronized (NewsRepo.class) {
                if (instance == null) {
                    instance = new NewsRepo();
                }
            }
        }
        return instance;
    }

    /**
     * 获取游戏列表
     *
     * @param cateId 栏目分类ID
     * @param page   分页
     * @return
     */
    public Observable<BaseNewsEntity<List<NewsEntity>>> getNewsList(int cateId, int page) {
        MLog.i("开始获取数据");
        return transform(RetrofitClient.getNewsIns().NEWS().newsList(cateId, page));
    }
}
