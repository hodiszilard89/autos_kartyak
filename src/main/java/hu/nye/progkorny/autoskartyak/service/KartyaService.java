package hu.nye.progkorny.autoskartyak.service;

import hu.nye.progkorny.autoskartyak.model.Kartya;

import java.util.List;

public interface KartyaService {
    List<Kartya> getAllKartya();
    Kartya getKartya(Long id);
    Kartya createKartya(Kartya kartya);
    Kartya updateKartya(Long id, Kartya modKartya);
    void deleteKartya(Kartya kartya);

}
