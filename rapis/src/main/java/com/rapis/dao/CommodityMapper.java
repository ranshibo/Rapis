package com.rapis.dao;

import com.rapis.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author siboran
 * @create 2022/3/3
 */
@Mapper
public interface CommodityMapper {
    int insertCommodity(Commodity commodity);
    List<Commodity> getCommodityList(int offset,int limit);
    Commodity selcetByName(String shortName);
    int updateQuantity(String shortName,int quantity);
}
