package pl.marczyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcin on 14.11.15.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping
    public String index(Model model) {
        return "index";
    }
}
