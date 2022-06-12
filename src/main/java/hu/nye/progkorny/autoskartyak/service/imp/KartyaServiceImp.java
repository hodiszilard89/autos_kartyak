package hu.nye.progkorny.autoskartyak.service.imp;

import hu.nye.progkorny.autoskartyak.model.exception.NotFoundException;
import hu.nye.progkorny.autoskartyak.model.Kartya;


import hu.nye.progkorny.autoskartyak.model.Uzemanyag;
import hu.nye.progkorny.autoskartyak.service.KartyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class KartyaServiceImp implements KartyaService {

  private final List<Kartya> inMdb = new ArrayList<>();

  @Autowired
  public KartyaServiceImp() {
    inMdb.add(new Kartya(1L, "olep", "astra", Uzemanyag.BENZIN, 95, 12, 4, 150));
    inMdb.add(new Kartya(2L, "macska", "cirmi", Uzemanyag.TEJ, 1, 1, 1, 1));
  }

  public KartyaServiceImp(final List<Kartya> rolePlays) {
    inMdb.addAll(rolePlays);
  }

  @Override
  public List<Kartya> getAllKartya() {
    return Collections.unmodifiableList(inMdb);
  }

  @Override
  public Kartya getKartya(final Long id) {
    return inMdb.stream()
            .filter(rolePlay -> rolePlay.getId().equals(id))
            .findFirst()
            .orElseThrow(NotFoundException::new);
  }

  @Override
  public Kartya createKartya(final Kartya kartya) {
    kartya.setId(getNextId());
    inMdb.add(kartya);
    return kartya;
  }

  @Override
  public void updateKartya(Long id, Kartya modKartya) {
    int index = inMdb.indexOf(getKartya(id));
    inMdb.set(index, modKartya);
  }

  @Override
  public void deleteKartya(final Long id) {
    final Kartya rolePlay = getKartya(id);
    inMdb.remove(rolePlay);
  }

  private long getNextId() {
    return getLastId() + 1L;
  }

  private long getLastId() {
    return inMdb.stream()
            .mapToLong(Kartya::getId)
            .max()
            .orElse(0);
  }
}
