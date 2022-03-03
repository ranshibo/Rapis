package com.rapis.controller;

import com.rapis.entity.Commodity;
import com.rapis.service.CommodityService;
import com.rapis.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author siboran
 * @create 2022/3/3
 */
@Controller
@CrossOrigin
@RequestMapping("/comm")
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @PostMapping("/insert")
    public ResponseEntity<Result<String>> insertCommodity(@RequestBody Commodity commodity){
        return ResponseEntity.ok(commodityService.insertCommodity(commodity));
    }

    @GetMapping("/list/{page}")
    public ResponseEntity<Result<List<Commodity>>> getCommodityList(@PathVariable int page){
        return ResponseEntity.ok(commodityService.getCommodityList(page));
    }
}
