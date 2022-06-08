import java.util.logging.Logger;

public class HelpBattle1 {
    public HelpBattle1() {
    }

    static void abilityVsAttack(Pokemon attackPokemon, Pokemon abilityPokemon, Ability ability, Logger logger, int abilityIndex, int attackIndex, int abilityIndexForStun) {
        String var10001;
        if (CoachesBattle.stun[attackIndex] == 1) {
            logger.info("Pokemon " + attackPokemon.getName() + " is stunned!");
            if (CoachesBattle.stun[abilityIndexForStun] == 0) {
                var10001 = abilityPokemon.getName();
                logger.info("Pokemon " + var10001 + " uses ability " + abilityIndex + "!");
                attackPokemon.setHP(attackPokemon.getHP() - ability.getDamage());
                if (!ability.getStun()) {
                    CoachesBattle.stun[attackIndex] = 0;
                }
            } else {
                logger.info("Pokemon " + abilityPokemon.getName() + " is stunned!");
                CoachesBattle.stun[abilityIndexForStun] = 0;
                CoachesBattle.stun[attackIndex] = 0;
            }
        } else {
            logger.info("Pokemon " + attackPokemon.getName() + " attacks!");
            if (CoachesBattle.stun[abilityIndexForStun] == 1) {
                logger.info("Pokemon " + abilityPokemon.getName() + " is stunned!");
                HelpBattle2.attackPokemon(abilityPokemon, attackPokemon);
            } else {
                var10001 = abilityPokemon.getName();
                logger.info("Pokemon " + var10001 + " uses ability " + abilityIndex + "!");
                if (!ability.getDodge()) {
                    HelpBattle2.attackPokemon(abilityPokemon, attackPokemon);
                } else {
                    logger.info("Pokemon " + abilityPokemon.getName() + " dodges the attack!");
                }

                attackPokemon.setHP(attackPokemon.getHP() - ability.getDamage());
                if (ability.getStun()) {
                    CoachesBattle.stun[attackIndex] = 1;
                }
            }
        }

    }
}