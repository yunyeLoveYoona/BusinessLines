package com.yun.businesslines.mian.recourse;

import com.yun.businesslines.core.Resource;

/**
 * Created by yunye on 2016/7/12.
 */
public class MainResource implements Resource {
    public String str;

    @Override
    public int getResourceId() {
        return 1000;
    }


}
