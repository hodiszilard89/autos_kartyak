package hu.nye.progkorny.autoskartyak.service.imp;

import hu.nye.progkorny.autoskartyak.model.Kartya;
import hu.nye.progkorny.autoskartyak.model.Uzemanyag;
import hu.nye.progkorny.autoskartyak.service.KartyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class KartyaServciceImp implements KartyaService {

    private final List<Kartya> inM_Db = new ArrayList<>();

    @Autowired
    public KartyaServciceImp() {
        inM_Db.add(new Kartya(1L, "olep", "astra", Uzemanyag.BENZIN,95,12,4,150));
        inM_Db.add(new Kartya(2L, "macska", "cirmi",Uzemanyag.TEJ,1,1,1,1));
    }

    @Override
    public List<Kartya> getAllKartya() {
        return Collections.unmodifiableList(inM_Db);
    }

    @Override
    public Kartya getKartya(Long id) {
        //return inM_Db.stream();
        return null;

    }

    @Override
    public Kartya createKartya(Kartya kartya) {
        return null;
    }

    @Override
    public Kartya updateKartya(Long id, Kartya modKartya) {
        return null;
    }

    @Override
    public void deleteKartya(Kartya kartya) {

    }
}
