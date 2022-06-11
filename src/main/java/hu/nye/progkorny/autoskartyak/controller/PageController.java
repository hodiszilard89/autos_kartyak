package hu.nye.progkorny.autoskartyak.controller;

import hu.nye.progkorny.autoskartyak.model.Kartya;
import hu.nye.progkorny.autoskartyak.service.KartyaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller

public class PageController {

    private final KartyaService kartyaService;

    public PageController(KartyaService kartyaService) {
        this.kartyaService = kartyaService;
    }

    @RequestMapping("/")
    public String index(){

        return "menu";
    }
    @PostMapping("/hozzaad")
        public String hozzaad(Model model){
            return "hozzaad";
        }

    @GetMapping("/menu")
    public String menu(Model model){
        model.addAttribute("kartya",new Kartya());
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

    @RequestMapping("/list")
    public String list(final Model model){
        final List<Kartya> kartyak = kartyaService.getAllKartya();
        System.out.println(kartyak.size());
        model.addAttribute("kartyak", kartyak);
        return "list";
       }
//    @RequestMapping("/kartyaszerk")
//    public String kartyaszerk(){
//
//        return "kartyaszerk";
//    }


}
