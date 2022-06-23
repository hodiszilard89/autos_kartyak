package hu.nye.progkorny.autoskartyak.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.hamcrest.MatcherAssert.assertThat;


public class KartyaTesz {

  private static final Kartya SUZUKI_KARTYA = new Kartya(1L, "SUZUKI", "ignis", Uzemanyag.BENZIN, 120, 15, 4, 80);
  private static final Kartya OPEL_KARTYA = new Kartya(2L, "SUZUKI", "ignis", Uzemanyag.BENZIN, 120, 15, 4, 80);

  @Test
  public void testEquals_Symmetric() {
    Kartya x = SUZUKI_KARTYA;
    Kartya y = OPEL_KARTYA;
    Assertions.assertTrue(x.equals(y) && y.equals(x));
    Assertions.assertTrue(x.hashCode() == y.hashCode());
  }

}
