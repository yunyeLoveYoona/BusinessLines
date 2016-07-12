package com.yun.businesslines;

import com.yun.businesslines.core.BusinessLine;

/**
 * 业务总线
 * Created by yunye on 2016/7/12.
 */
public class BusinessBus extends BusinessLine {
    private static BusinessLine _this;

    public static BusinessLine getBus() {
        if (_this == null) {
            _this = new BusinessLine();
        }
        return _this;
    }


}
