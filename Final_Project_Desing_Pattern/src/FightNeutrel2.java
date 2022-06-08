import java.util.Random;
import java.util.logging.Logger;

public class FightNeutrel2 {
    public FightNeutrel2() {
    }

    public static Boolean fight(Pokemon pokemon, Logger logger) {
        Pokemon neutral2 = PokemonFactory.getSingletonInstance().returnPokemon(PokemonFactory.PokemonType.Neutrel2);
        logger.info("This duel is between the following two pokemons!");
        logger.info(pokemon.toString());
        logger.info(neutral2.toStringWithoutAbility());
        int[] cooldown = new int[]{0, 0};
        int stun = 0;
        Random randomAction = new Random();

        while(true) {
            while(neutral2.getHP() > 0) {
                int action = randomAction.nextInt(3);
                if (action == 0) {
                    if (pokemon.getNormalAttack() != 0) {
                        neutral2.setHP(neutral2.getHP() - (pokemon.getNormalAttack() - neutral2.getNormalDefense()));
                    } else {
                        neutral2.setHP(neutral2.getHP() - (pokemon.getSpecialAttack() - neutral2.getSpecialAttack()));
                    }

                    if (stun == 0) {
                        if (neutral2.getNormalAttack() >= pokemon.getNormalDefense()) {
                            pokemon.setHP(pokemon.getHP() - (neutral2.getNormalAttack() - pokemon.getNormalDefense()));
                        }

                        logger.info(pokemon.getName() + " attacks and Neutrel2 attacks!");
                    } else {
                        stun = 0;
                        logger.info(pokemon.getName() + " attacks and Neutrel2 is stuned!");
                    }

                    FightNeutrel1.checkCooldown(pokemon, logger, neutral2, cooldown);
                } else if (action == 1) {
                    if (cooldown[0] == 0) {
                        if (pokemon.getAbility1().getDodge() != null && !pokemon.getAbility1().getDodge()) {
                            if (neutral2.getNormalAttack() >= pokemon.getNormalDefense() && stun == 0) {
                                pokemon.setHP(pokemon.getHP() - (neutral2.getNormalAttack() - pokemon.getNormalDefense()));
                                logger.info(pokemon.getName() + " uses ability 1 and Neutrel2 attacks!");
                            } else if (stun != 0) {
                                logger.info(pokemon.getName() + " uses ability 1 and Neutrel2 is stuned!");
                            }
                        }

                        stun = FightNeutrel1.getStunAbility1(pokemon, logger, neutral2, cooldown, stun);
                    }
                } else if (cooldown[1] == 0 && pokemon.getAbility2().getDodge() != null && !pokemon.getAbility2().getDodge()) {
                    if (neutral2.getNormalAttack() >= pokemon.getNormalDefense() && stun == 0) {
                        pokemon.setHP(pokemon.getHP() - (neutral2.getNormalAttack() - pokemon.getNormalDefense()));
                        logger.info(pokemon.getName() + " uses ability 2 and Neutrel2 attacks!");
                    } else if (stun != 0) {
                        logger.info(pokemon.getName() + " uses ability 2 and Neutrel2 is stuned!");
                    }

                    stun = FightNeutrel1.getStunAbility2(pokemon, logger, neutral2, cooldown, stun);
                }
            }

            logger.info(pokemon.getName() + " wins!");
            return true;
        }
    }
}
