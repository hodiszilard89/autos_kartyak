package hu.nye.progkorny.autoskartyak.controller;

import hu.nye.progkorny.autoskartyak.model.Kartya;
import hu.nye.progkorny.autoskartyak.model.Uzemanyag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    //private Kartya kartya=new Kartya(1L,"opel","astra", Uzemanyag.DIZEL,70,25,4,120);
    private Kartya kartya= new Kartya();
    @RequestMapping("/")
    public String menu(Model model){
        model.addAttribute("pageTitle","Lista oldal");
        model.addAttribute("kartya",kartya);
        return "menu";
    }
}
