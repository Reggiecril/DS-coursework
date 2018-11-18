package com.restaurant.restaurant.Service;

import com.alibaba.fastjson.JSON;
import com.restaurant.restaurant.Bean.RestaurantBean;
import com.restaurant.restaurant.Utils.FileUtils;
import com.restaurant.restaurant.Utils.ZomatoUtils;

import java.util.List;
import java.util.Map;

public class RestaurantService {

    public List<RestaurantBean> findAll(Map<String,String> map, String attribute){
        List<RestaurantBean> list= ZomatoUtils.getObject(map,attribute);
        FileUtils.saveFile("Rest","{\"restaurants\" : "+ JSON.toJSONString(list)+"}");
        return list;
    }
}
