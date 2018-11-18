package com.restaurant.restaurant.Service;

import com.restaurant.restaurant.Bean.Category;
import com.restaurant.restaurant.Utils.ZomatoUtils;

import java.util.List;

public class CategoryService {
    public List<Category> findAll() {
        return ZomatoUtils.getCategory();
    }
}
