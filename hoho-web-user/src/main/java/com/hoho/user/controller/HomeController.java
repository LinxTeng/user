package com.hoho.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  @RequestMapping("/home")
  public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
    model.addAttribute("title", "欢迎光临");
    return "home";
  }

    @RequestMapping("/page/list")
    @ResponseBody
    public List<Integer> getBody() {
        List<Integer> aa = new ArrayList<>();
        aa.add(1);
        aa.add(2);
        aa.add(3);
        return aa;
    }
}
