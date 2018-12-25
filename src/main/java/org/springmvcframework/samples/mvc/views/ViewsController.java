package org.springmvcframework.samples.mvc.views;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/views/*")
public class ViewsController {

    @GetMapping("html")
    public String prepare(Model model){
        model.addAttribute("foo","bar");
        model.addAttribute("fruit","apple");
        return "views/html";
    }

    @GetMapping("/viewName")
    public void usingRequestToViewNameTranslator(Model model){
        model.addAttribute("foo","bar");
        model.addAttribute("fruit","apple");
    }

    @GetMapping("pathVariables/{foo}/{fruit}")
    public String pathVars(@PathVariable String foo, @PathVariable String fruit){
        return "views/html";
    }

    @GetMapping("dataBinding/{foo}/{fruit}")
    public String dataBinding(@Valid JavaBean javaBean, Model model) {
        return "views/dataBinding";
    }

}
