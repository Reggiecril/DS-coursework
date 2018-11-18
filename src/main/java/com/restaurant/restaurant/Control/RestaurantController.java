package com.restaurant.restaurant.Control;

import com.restaurant.restaurant.Service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/restaurant")
@Controller
public class RestaurantController {
    private static final String RESTAURANT_TEMPLATE = "restaurant";
    private static final String ITEM_TEMPLATE_ID = "items";
    private static final String HOMEPAGE_REDIRECT = "redirect:/resturant/";
    private static final String RESTAURANT_FORM_HEADER_ID = "formHeader";

    private Map<String,String> map=new HashMap<>();
    private RestaurantService restaurantService= new RestaurantService();
    @GetMapping("/search/{address}/{category}")
    public String displayRestaurant (Model model,@PathVariable String address,@PathVariable Integer category) {
        map.put("address",address);
        map.put("category",category.toString());
        model.addAttribute (RESTAURANT_FORM_HEADER_ID);
        model.addAttribute (ITEM_TEMPLATE_ID, restaurantService.findAll(map,"search"));
        return RESTAURANT_TEMPLATE;
    }
}
