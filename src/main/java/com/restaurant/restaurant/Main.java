package com.restaurant.restaurant;

import com.alibaba.fastjson.JSON;
import com.restaurant.restaurant.Bean.Category;
import com.restaurant.restaurant.Utils.FileUtils;
import com.restaurant.restaurant.Utils.ZomatoUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String []args) {
        Map<String,String> map=new HashMap<>();
        map.put("start","2");
        map.put("count","10");
        List<Category> list= ZomatoUtils.getCategory();

//        String s="";
//        for(int i=0;i<list.size();i++) {
//            RestaurantBean restaurantBean=list.get(i);
//            GoogleUtils.getGoogle(restaurantBean,restaurantBean.getLocation().getLatitude()+","+restaurantBean.getLocation().getLongitude(),"Gangtok");
//            System.out.println(restaurantBean.toString());
//        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        FileUtils.saveFile("Rest","{\"restaurants\" : "+JSON.toJSONString(list)+"}");

    }
}
