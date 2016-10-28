package com.dehao.mygrouppurchase.data.retrofit;


import com.dehao.mygrouppurchase.base.BaseNewsEntity;
import com.dehao.mygrouppurchase.data.models.NewsEntity;
import com.dehao.mygrouppurchase.utils.C;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by marno on 2016/7/21/20:55.
 */
public interface NewsService {

    @FormUrlEncoded
    @POST("toutiao/get_list")
    Observable<BaseNewsEntity<List<NewsEntity>>> newsList(
            @Field(C.CATE_ID) int cateId,
            @Field(C.MAX) int page);
}
