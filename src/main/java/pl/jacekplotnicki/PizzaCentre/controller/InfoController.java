package pl.jacekplotnicki.PizzaCentre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class InfoController {
    @RequestMapping(
            value = {"/info"}
    )
    public String getinfo() {
        return "info";
    }
}
