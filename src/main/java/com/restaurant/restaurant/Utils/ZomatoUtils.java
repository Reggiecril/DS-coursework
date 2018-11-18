package com.restaurant.restaurant.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.restaurant.restaurant.Bean.Category;
import com.restaurant.restaurant.Bean.RestaurantBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ZomatoUtils {
    /**
     * convert data from two apis, and convert to an object or bean.
     *
     * @param map
     * @return
     */
    public static List<RestaurantBean> getObject(Map<String, String> map, String attribute) {
        String address=map.remove("address");
        if(!address.substring(0,3).matches("^[0-9]*$")){
            String add[]=address.split(",");
            map.put("lat", add[0]);
            map.put("lon", add[1]);
        }
        String url = "https://developers.zomato.com/api/v2.1/" + attribute;
        if (map != null) {
            int count = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (count == 0)
                    url += "?" + entry.getKey() + "=" + entry.getValue();
                else {
                    url += "&" + entry.getKey() + "=" + entry.getValue();
                }
                count++;
            }
        }
        //get Json file
        String jsonString = HttpUtils.getJsonContent(url);
        //parse the json file
        JSONObject jsonObject = JSON.parseObject(jsonString);
        //get a array which named restaurants
        JSONArray jsonArray = jsonObject.getJSONArray("restaurants");
        //initalize a arraylist
        ArrayList<RestaurantBean> list = new ArrayList<>();
        //loop this restaurants array
        for (int i = 0; i < jsonArray.size(); i++) {
            //get every restaurant
            JSONObject restaurant = jsonArray.getJSONObject(i);
            //make the JSON to Bean
            RestaurantBean restaurantBean = restaurant.getObject("restaurant", RestaurantBean.class);
            //set information from google api to this Bean
            GoogleUtils.getGoogle(restaurantBean,restaurantBean.getLocation().getLatitude()+","+restaurantBean.getLocation().getLongitude(),address);
            //add to arraylist
            list.add(restaurantBean);
        }

        return list;
    }

    public static List<Category> getCategory() {
        String url = "https://developers.zomato.com/api/v2.1/categories";
        //get Json file
        String jsonString = HttpUtils.getJsonContent(url);
        //parse the json file
        JSONObject jsonObject = JSON.parseObject(jsonString);
        //get a array which named categories
        JSONArray jsonArray = jsonObject.getJSONArray("categories");
        //initalize a arraylist
        ArrayList<Category> list = new ArrayList<>();
        //loop this categories array
        for (int i = 0; i < jsonArray.size(); i++) {
            //get every category
            JSONObject restaurant = jsonArray.getJSONObject(i);
            //make the JSON to Bean
            Category category = restaurant.getObject("categories", Category.class);
            //add to arraylist
            list.add(category);
        }
        return list;
    }
}