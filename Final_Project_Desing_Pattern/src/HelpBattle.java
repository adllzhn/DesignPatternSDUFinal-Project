import java.util.logging.Logger;

public class HelpBattle {
    public HelpBattle() {
    }

    static void abilityVsAbility(Pokemon pokemonA, Pokemon pokemonB, Ability abilityA, Ability abilityB, Logger logger, int indexAbilityA, int indexAbilityB) {
        String var10001;
        if (CoachesBattle.stun[0] == 1) {
            logger.info("Pokemon " + pokemonA.getName() + " is stunned!");
            if (CoachesBattle.stun[1] == 0) {
                var10001 = pokemonB.getName();
                logger.info("Pokemon " + var10001 + " uses ability " + indexAbilityB + "!");
                pokemonA.setHP(pokemonA.getHP() - abilityB.getDamage());
                if (!abilityB.getStun()) {
                    CoachesBattle.stun[0] = 0;
                }
            } else {
                logger.info("Pokemon " + pokemonB.getName() + " is stunned!");
                CoachesBattle.stun[0] = 0;
                CoachesBattle.stun[1] = 0;
            }
        } else {
            var10001 = pokemonA.getName();
            logger.info("Pokemon " + var10001 + " uses ability " + indexAbilityA + "!");
            if (CoachesBattle.stun[1] == 1) {
                logger.info("Pokemon " + pokemonB.getName() + " is stunned!");
                pokemonB.setHP(pokemonB.getHP() - abilityA.getDamage());
                if (!abilityA.getStun()) {
                    CoachesBattle.stun[1] = 0;
                }
            } else {
                var10001 = pokemonB.getName();
                logger.info("Pokemon " + var10001 + " uses ability " + indexAbilityB + "!");
                if (!abilityA.getDodge()) {
                    pokemonA.setHP(pokemonA.getHP() - abilityB.getDamage());
                }

                if (!abilityB.getDodge()) {
                    pokemonB.setHP(pokemonB.getHP() - abilityA.getDamage());
                }

                if (abilityA.getStun()) {
                    CoachesBattle.stun[1] = 1;
                }

                if (abilityB.getStun()) {
                    CoachesBattle.stun[0] = 1;
                }
            }
        }

    }
}