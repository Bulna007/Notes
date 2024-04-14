package com.bt.controller;

import com.bt.dto.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class ProductReviewController {

    @GetMapping("/product-review.htm")
    public String review(Model model) {
        Product product = Product.of().productName("LG Washing Machine Front Load 5.5 KG")
                .description("AI Enabled Washing Machines")
                .price(32000).rating(8)
                .features(Arrays.asList(new String[]{"AI", "Digital Keypad", "Auto-load detergent", "Wifi Smart", "App Control"})).build();
        model.addAttribute("product", product);
        return "product-review";
    }
}
