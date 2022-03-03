package com.rapis.service.impl;

import com.rapis.dao.CommodityMapper;
import com.rapis.entity.Commodity;
import com.rapis.service.CommodityService;
import com.rapis.util.CodeMsg;
import com.rapis.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author siboran
 * @create 2022/3/3
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    private static final int PAGE_SIZE = 5;

    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public Result<String> insertCommodity(Commodity commodity) {
        if(commodityMapper.selcetByName(commodity.getShortName())!=null)
            return Result.result(CodeMsg.UTIL_ERROR);
        commodityMapper.insertCommodity(commodity);
        return Result.result(CodeMsg.UTIL_SUCCESS);
    }

    @Override
    public Result<List<Commodity>> getCommodityList(int page) {
        return Result.result(CodeMsg.UTIL_SUCCESS,commodityMapper.getCommodityList((page-1)*PAGE_SIZE,PAGE_SIZE));
    }

    @Override
    public Commodity selcetByName(String shortName) {
       return commodityMapper.selcetByName(shortName);
    }

    @Override
    public void updateQuantity(String shortName,int quantity) {
        commodityMapper.updateQuantity(shortName,quantity);
    }
}
