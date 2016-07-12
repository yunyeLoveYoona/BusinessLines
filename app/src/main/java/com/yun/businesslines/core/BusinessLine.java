package com.yun.businesslines.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yunye on 2016/7/12
 * 业务线
 * 通过业务线将向用户提供某种服务或内容
 * 业务线由业务员来操作从而销售产品.
 */
public class BusinessLine {
    /**
     * 这条业务线上的业务员
     **/
    private List<SalesMan> salesMen;

    /**
     * 业务线中的公用资源
     */

    private HashMap<Integer, Resource> resourceHashMap;

    public BusinessLine() {
        salesMen = new ArrayList<SalesMan>();
        resourceHashMap = new HashMap<Integer, Resource>();
    }


    /**
     * 加入业务线
     *
     * @param salesMan
     */
    public void join(SalesMan salesMan) {
        if (!salesMen.contains(salesMan)) {
            salesMen.add(salesMan);
        }
    }

    /**
     * 离开业务线
     *
     * @param salesMan
     */
    public void leave(SalesMan salesMan) {
        salesMen.remove(salesMan);
    }

    /**
     * 解散业务线
     */
    public void disband() {
        resourceHashMap.clear();
        salesMen.clear();
    }


    /**
     * 添加资源
     *
     * @param resource
     */
    public void addResource(Resource resource) {
        resourceHashMap.put(resource.getResourceId(), resource);
    }

    /**
     * 去除资源
     *
     * @param resource
     */
    public void removeResource(Resource resource) {
        resourceHashMap.remove(resource);
    }

    /**
     * 清空资源
     */
    public void clearResource() {
        resourceHashMap.clear();
    }


    /**
     * 获取资源
     *
     * @param resourceId
     * @return
     */
    public Resource getResource(int resourceId) {
        return resourceHashMap.get(resourceId);
    }

    /**
     * 获取业务线上的业务员
     *
     * @return
     */
    public List<SalesMan> getSalesMen() {
        return salesMen;
    }

}
