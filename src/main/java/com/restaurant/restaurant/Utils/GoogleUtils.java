package com.restaurant.restaurant.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.restaurant.restaurant.Bean.RestaurantBean;

import java.util.ArrayList;

public class GoogleUtils {
    /**
     * convert json from google api and add distance and duration to RestaurantBean
     * @param restaurantBean
     * @param address1
     * @param address2
     */
    public static void getGoogle(RestaurantBean restaurantBean,String address1,String address2){
        //get google json
        String jsonString = HttpUtils.getGoogleJsonContent(address1,address2);
        //parse json
        JSONObject jsonObject = JSON.parseObject(jsonString);
        //get routes array
        JSONArray jsonArray=jsonObject.getJSONArray("routes");
        //initalize a arraylist
        ArrayList<RestaurantBean> list = new ArrayList<>();
        if(jsonArray.size()!=0){
            //Because this array just have one array,so just get first object
            JSONObject routes=jsonArray.getJSONObject(0);
            //get legs array from routes
            JSONArray legs=routes.getJSONArray("legs");
            //get distance and duration
            String distance=(String)legs.getJSONObject(0).getJSONObject("distance").get("text");
            String duration=(String)legs.getJSONObject(0).getJSONObject("duration").get("text");
            //add them
            restaurantBean.setDistance(distance);
            restaurantBean.setDuration(duration);

        }
    }
}
