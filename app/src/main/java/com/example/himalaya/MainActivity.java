package com.example.himalaya;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.himalaya.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.category.Category;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> map = new HashMap<>();//调用接口
        CommonRequest.getCategories(map, new IDataCallBack<CategoryList>() {
            @Override
            public void onSuccess(@Nullable CategoryList categoryList) {
                List<Category> categories = categoryList.getCategories();
                if (categories != null) {
                    int size = categories.size();
                    Log.d(TAG, "categories.size -------<"  + size);
                    for (Category category : categories) {
                        //Log.d(TAG, "categories.size ------->" + category.getCategoryName());
                        LogUtil.d(TAG, "category ------->" + category.getCategoryName());
                    }
                }
            }

            @Override
            public void onError(int i, String s) {

               // Log.e(TAG, "error code --- " + i + "error msg ==>" +s);
                LogUtil.d(TAG, "error code --- " + i + "error msg ==>" +s);
            }
        });


    }
}
