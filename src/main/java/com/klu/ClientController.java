package com.klu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @GetMapping("/greet")
    public String greet(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "greet"; // Create a JSP for this view
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/demo1")
    public String demo1(@RequestParam int age, @RequestParam String country, Model model) {
        model.addAttribute("age", age);
        model.addAttribute("country", country);
        return "demo1";
    }

    @GetMapping("/demo2/{num1}/{num2}")
    public String demo2(@PathVariable int num1, @PathVariable int num2, Model model) {
        model.addAttribute("subtraction", num1 - num2);
        model.addAttribute("division", num2 != 0 ? (double) num1 / num2 : "Division by zero error");
        return "demo2";
    }

    @GetMapping("/productform")
    public String productForm() {
        return "productform";
    }

    @GetMapping("/multiplyNumbers")
    public String multiplyNumbers(@RequestParam int num1, @RequestParam int num2, Model model) {
        model.addAttribute("result", num1 * num2);
        return "multiply";
    }

    @GetMapping("/reverse")
    public String reverse(@RequestParam String str1, @RequestParam String str2, Model model) {
        model.addAttribute("reversedStr1", new StringBuilder(str1).reverse().toString());
        model.addAttribute("reversedStr2", new StringBuilder(str2).reverse().toString());
        return "reverse";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam int num1, @RequestParam int num2, Model model) {
        model.addAttribute("addition", num1 + num2);
        model.addAttribute("subtraction", num1 - num2);
        return "calculate";
    }
}
