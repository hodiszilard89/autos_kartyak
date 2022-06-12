package hu.nye.progkorny.autoskartyak.service.imp;

import hu.nye.progkorny.autoskartyak.model.Kartya;
import hu.nye.progkorny.autoskartyak.model.Uzemanyag;
import hu.nye.progkorny.autoskartyak.model.exception.NotFoundException;
import hu.nye.progkorny.autoskartyak.service.KartyaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KartyaServiceImpTest {

  private static final Kartya SUZUKI_KARTYA = new Kartya(1L, "SUZUKI", "ignis", Uzemanyag.BENZIN, 120, 15, 4, 80);
  private static final Kartya MERCEDES_KARTYA = new Kartya(2L, "MERCEDES", "S CALASS", Uzemanyag.DIZEL, 300, 7, 8, 350);
  private static final List<Kartya> KARTYAK = List.of(
          SUZUKI_KARTYA,
          MERCEDES_KARTYA
  );

  public static final long NEMLETEZO_ID = -1L;
  public static final String OPEL = "OPEL";

  private KartyaService underTest;

  @BeforeEach
  void setUp() {
    underTest = new KartyaServiceImp(KARTYAK);
  }


  @Test
  void createCardShouldReturnCardWhenDelegateIt() {
    // given
    final Kartya hoszzaadott = new Kartya(null, OPEL, "MOKKA", Uzemanyag.BENZIN, 120, 15, 4, 80);
    final Kartya letezo = new Kartya(3L, OPEL, "MOKKA", Uzemanyag.BENZIN, 120, 15, 4, 80);
    // when
    final Kartya actual = underTest.createKartya(hoszzaadott);
    // then
    assertThat(actual).isEqualTo(letezo);
  }


  @Test
  void getCardShouldThrowNotFoundExceptionWhenGivenIdOfNotExistingCard() {
    // when then
    assertThrows(NotFoundException.class, () -> underTest.getKartya(NEMLETEZO_ID));
  }


  @Test
  void getCardShouldReturnCardWhenGivenIdOfExistingCard() {

    // when
    final Kartya actual = underTest.getKartya(SUZUKI_KARTYA.getId());
    // then
    assertThat(actual).isEqualTo(SUZUKI_KARTYA);
  }

  @Test
  void getAllCardsShouldReturnAllCards() {
    // when
    final List<Kartya> actual = underTest.getAllKartya();
    // then
    assertThat(actual).isEqualTo(KARTYAK);
  }

  @Test
  void updateCardShouldReturnUpdatedCardWhenGivenIdOfExistingCard() {
    // given
    final Kartya opelKartya = new Kartya(null, OPEL, "astra", Uzemanyag.BENZIN, 120, 15, 4, 80);
    final Kartya expected = new Kartya(SUZUKI_KARTYA.getId(), OPEL, "astra", Uzemanyag.BENZIN, 120, 15, 4, 80);
    // when
    final Kartya actual = underTest.updateKartya(SUZUKI_KARTYA.getId(), opelKartya);
    // then
    System.out.println(actual.getId() + "   " + expected.getId());
    assertThat(actual).isEqualTo(expected);
  }


  @Test
  void updateCardShouldThrowNotFoundExceptionWhenGivenIdOfNotExistingCard() {
    // given
    final Kartya opelKartya = new Kartya(null, OPEL, "ignis", Uzemanyag.BENZIN, 120, 15, 4, 80);
    // when then
    assertThrows(NotFoundException.class, () -> underTest.updateKartya(NEMLETEZO_ID, opelKartya));
  }

  @Test
  void deleteCardShouldDeleteCardWhenGivenIdOfCard() {
    // given
    final List<Kartya> expected = List.of(MERCEDES_KARTYA);
    // when
    underTest.deleteKartya(SUZUKI_KARTYA.getId());
    final List<Kartya> actual = underTest.getAllKartya();
    // then
    assertThat(actual).isEqualTo(expected);
  }

}
