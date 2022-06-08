import java.util.logging.Logger;

public class HelpBattle2 {
    public HelpBattle2() {
    }

    static void checkCooldown(Logger logger, Pokemon pokemon, int[] cooldownPokemon) {
        int var10002;
        if (cooldownPokemon[0] != 0) {
            var10002 = cooldownPokemon[0]--;
        }

        String var10001;
        if (cooldownPokemon[0] >= 0) {
            var10001 = pokemon.getName();
            logger.info("Cooldown ability 1 for " + var10001 + " is " + cooldownPokemon[0]);
        }

        if (cooldownPokemon[1] != 0) {
            var10002 = cooldownPokemon[1]--;
            var10001 = pokemon.getName();
            logger.info("Cooldown ability 2 for " + var10001 + " is " + cooldownPokemon[1]);
        }

    }

    static void pokemonsAttack(Logger logger, int[] stun, Pokemon pokemon1, Pokemon pokemon2) {
        if (stun[0] == 0) {
            attackPokemon(pokemon2, pokemon1);
            logger.info("Pokemon " + pokemon1.getName() + " attacks!");
        } else {
            stun[0] = 0;
            logger.info("Pokemon " + pokemon1.getName() + " is stunned!");
        }

        if (stun[1] == 0) {
            attackPokemon(pokemon1, pokemon2);
            logger.info("Pokemon " + pokemon2.getName() + " attacks!");
        } else {
            stun[1] = 0;
            logger.info("Pokemon " + pokemon2.getName() + " is stunned!");
        }

    }

    static void attackPokemon(Pokemon attackedPokemon, Pokemon attackerPokemon) {
        if (attackerPokemon.getNormalAttack() != 0) {
            if (attackerPokemon.getNormalAttack() > attackedPokemon.getNormalDefense()) {
                attackedPokemon.setHP(attackedPokemon.getHP() - (attackerPokemon.getNormalAttack() - attackedPokemon.getNormalDefense()));
            } else {
                attackedPokemon.setNormalDefense(attackedPokemon.getNormalDefense() - 1);
            }
        } else if (attackerPokemon.getSpecialAttack() > attackedPokemon.getSpecialDefense()) {
            attackedPokemon.setHP(attackedPokemon.getHP() - (attackerPokemon.getSpecialAttack() - attackedPokemon.getSpecialDefense()));
        } else {
            attackedPokemon.setSpecialDefense(attackedPokemon.getSpecialDefense() - 1);
        }

    }
}
