
package com.iluwatar.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Date: 12/6/15 - 11:01 PM
 *
 * @author Jeroen Meulemeester
 */
public class HeroTest {

  /**
   * Test if we get the expected exception when trying to create a hero without a profession
   */
  @Test
  public void testMissingProfession() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Hero.Builder(null, "Sir without a job"));
  }

  /**
   * Test if we get the expected exception when trying to create a hero without a name
   */
  @Test
  public void testMissingName() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Hero.Builder(Profession.THIEF, null));
  }

  /**
   * Test if the hero build by the builder has the correct attributes, as requested
   */
  @Test
  public void testBuildHero() throws Exception {
    final String heroName = "Sir Lancelot";

    final Hero hero = new Hero.Builder(Profession.WARRIOR, heroName)
        .withArmor(Armor.CHAIN_MAIL)
        .withWeapon(Weapon.SWORD)
        .withHairType(HairType.LONG_CURLY)
        .withHairColor(HairColor.BLOND)
        .build();

    assertNotNull(hero);
    assertNotNull(hero.toString());
    assertEquals(Profession.WARRIOR, hero.getProfession());
    assertEquals(heroName, hero.getName());
    assertEquals(Armor.CHAIN_MAIL, hero.getArmor());
    assertEquals(Weapon.SWORD, hero.getWeapon());
    assertEquals(HairType.LONG_CURLY, hero.getHairType());
    assertEquals(HairColor.BLOND, hero.getHairColor());

  }

}