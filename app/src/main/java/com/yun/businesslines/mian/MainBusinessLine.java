package com.yun.businesslines.mian;

import com.yun.businesslines.core.BusinessLine;
import com.yun.businesslines.core.Resource;
import com.yun.businesslines.mian.product.MainProduct;
import com.yun.businesslines.mian.recourse.MainResource;

/**
 * Created by yunye on 2016/7/12.
 */
public class MainBusinessLine extends BusinessLine implements Resource {
    public static int ID = 200021;

    public void sendMeg(MainResource resource) {
        MainProduct mainProduct = new MainProduct();
        mainProduct.setBusinessLine(this);
        mainProduct.production(resource);
    }

    @Override
    public int getResourceId() {
        return ID;
    }
}
