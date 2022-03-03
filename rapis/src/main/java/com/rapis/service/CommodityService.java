package com.rapis.service;

import com.rapis.entity.Commodity;
import com.rapis.util.Result;

import java.util.List;

/**
 * @author siboran
 * @create 2022/3/3
 */
public interface CommodityService {
    Result<String> insertCommodity(Commodity commodity);
    Result<List<Commodity>> getCommodityList(int page);
    Commodity selcetByName(String shortName);
    void updateQuantity(String shortName,int quantity);
}
