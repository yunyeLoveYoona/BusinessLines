package com.yun.businesslines.core;

/**
 * Created by yunye on 2016/7/12.
 */
public interface Product {

    /**
     * 获取产品id
     *
     * @return
     */
    public int getProductId();

    /**
     * 设置产品属于哪条业务线
     **/
    public void setBusinessLine(BusinessLine businessLine);

    /**
     * 生产产品
     *
     * @param resources
     */
    public void production(Resource resources);


    /**
     * 产品发生改变
     */
    public void change();
}
