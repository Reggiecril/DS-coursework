package com.restaurant.restaurant.Control;

import com.restaurant.restaurant.Bean.Greeting;
import com.restaurant.restaurant.Service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class SearchController {
    private static final String HOME_PAGE="/";
    private static final String INDEX="index";
    private static final String GREETING_ID="greeting";
    private static final String CATEGORY_ID="categories";
    private CategoryService categoryService=new CategoryService();
    @GetMapping("/")
    public String displayCategories (Model model) {
        model.addAttribute(CATEGORY_ID,categoryService.findAll());
        model.addAttribute (GREETING_ID, new Greeting());
        return INDEX;
    }
    @PostMapping("/")
    public String categorySubmit(Model model, @ModelAttribute Greeting greeting, BindingResult bindingResult){
        if (!bindingResult.hasErrors ()) {
            System.out.println(greeting.toString());
            return "redirect:/restaurant/search/"+greeting.getCity()+"/"+greeting.getCategory_id();
        }else{
            model.addAttribute (GREETING_ID,"Please fill all field!");
            model.addAttribute(CATEGORY_ID,categoryService.findAll());
            return INDEX;
        }

    }
}
