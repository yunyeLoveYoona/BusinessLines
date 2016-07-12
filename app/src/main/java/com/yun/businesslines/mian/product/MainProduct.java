package com.yun.businesslines.mian.product;

import com.yun.businesslines.core.BusinessLine;
import com.yun.businesslines.core.Product;
import com.yun.businesslines.core.Resource;
import com.yun.businesslines.core.SalesMan;
import com.yun.businesslines.mian.recourse.MainResource;

/**
 * Created by dell on 2016/7/12.
 */
public class MainProduct implements Product, Resource {
    public static final int ID = 10001;

    private BusinessLine businessLine = null;
    public String msg;

    public int getProductId() {
        return ID;
    }

    @Override
    public void setBusinessLine(BusinessLine businessLine) {
        this.businessLine = businessLine;
    }

    @Override
    public void production(Resource resources) {
        msg = ((MainResource) resources).str;
        if (businessLine != null && businessLine.getSalesMen() != null) {
            for (SalesMan salesMan : businessLine.getSalesMen()) {
                salesMan.getProduct(this);
            }
        }
    }

    @Override
    public void change() {
        if (businessLine != null && businessLine.getSalesMen() != null) {
            for (SalesMan salesMan : businessLine.getSalesMen()) {
                salesMan.getProduct(this);
            }
        }
    }

    @Override
    public int getResourceId() {
        return ID;
    }
}
