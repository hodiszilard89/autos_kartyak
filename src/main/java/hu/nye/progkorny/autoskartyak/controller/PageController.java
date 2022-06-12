package hu.nye.progkorny.autoskartyak.controller;

import hu.nye.progkorny.autoskartyak.model.Kartya;
import hu.nye.progkorny.autoskartyak.service.KartyaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;






import java.util.List;


@Controller

public class PageController {

  private final KartyaService kartyaService;

  public PageController(KartyaService kartyaService) {
    this.kartyaService = kartyaService;
  }

  @RequestMapping("/")
  public String index() {

    return "menu";
  }


  @GetMapping("/menu")
  public String menu(Model model) {
    model.addAttribute("kartya", new Kartya());
    return "menu";
  }

  @RequestMapping("/hozzaad")
  public String hozzad(Model model) {
    model.addAttribute("kartya", new Kartya());
    return "hozzaad";
  }

  @PostMapping("/add")
  public String add(@ModelAttribute Kartya kartya) {
    kartyaService.createKartya(kartya);
    return "redirect:/hozzaad";
  }


  @GetMapping("/list")
  public String list(final Model model) {
    final List<Kartya> kartyak = kartyaService.getAllKartya();
    model.addAttribute("kartyak", kartyak);
    return "list";
  }


  @GetMapping("/delete/{id}")
  public String delete(@PathVariable(name = "id") Long id) {
    kartyaService.deleteKartya(id);
    return "redirect:/list";
  }

  @GetMapping("/list/kartyaszerk/{id}")
  public String szerkezt(@PathVariable Long id, Model model) {
    model.addAttribute("kartya", kartyaService.getKartya(id));
    return "kartyaszerk";
  }

  @PostMapping("/list/{id}")

  public String kartyaszerk(@PathVariable Long id,
                            @ModelAttribute("kartya") Kartya ujKartya
  ) {
    kartyaService.updateKartya(id, ujKartya);

    return "redirect:/list";
  }


}
