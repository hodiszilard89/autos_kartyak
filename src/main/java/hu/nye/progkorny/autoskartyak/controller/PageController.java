package hu.nye.progkorny.autoskartyak.controller;

import hu.nye.progkorny.autoskartyak.model.Kartya;
import hu.nye.progkorny.autoskartyak.model.Uzemanyag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
//
private Kartya kartya=new Kartya(1L,"opel","astra", Uzemanyag.DIZEL,70,25,4,120);
////    private Kartya kartya= new Kartya();
    @RequestMapping("/")
    public String menu(){

        return "menu";
    }

    @RequestMapping("/hozzaad")
    public String hozzad(Model model){
        model.addAttribute("kartya",new Kartya());


        return "hozzaad";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Kartya kartya){
        return "redirect:/hozzaad";
    }
//
    @RequestMapping("/list")
    public String list(){

        return "list";
       }
//    @RequestMapping("/kartyaszerk")
//    public String kartyaszerk(){
//
//        return "kartyaszerk";
//    }


}
