package com.example.studyproject.design.flyweight;

import java.util.HashMap;
import java.util.Map;

public class GoodsFactory {

    private static Map<String,IGoods> pool = new HashMap<>();

    public static IGoods getGoods(String name){
        if (pool.containsKey(name)){
            return pool.get(name);
        }else{
            Goods goods = new Goods(name);
            pool.put(name, goods);
            return goods;
        }
    }

}
