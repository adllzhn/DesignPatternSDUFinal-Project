import java.util.logging.Logger;

public class PokemonHelperClassForBattle {
    public PokemonHelperClassForBattle() {
    }

    public static void checkCommand() {
        boolean ok = false;

        while(!ok) {
            ok = CoachesFight.firstCommand != 1 || CoachesBattle.cooldownPokemon1[0] == 0;
            if (CoachesFight.firstCommand == 2 && CoachesBattle.cooldownPokemon1[1] != 0) {
                ok = false;
            }

            if (CoachesFight.secondCommand == 1 && CoachesBattle.cooldownPokemon2[0] != 0) {
                ok = false;
            }

            if (CoachesFight.secondCommand == 2 && CoachesBattle.cooldownPokemon2[1] != 0) {
                ok = false;
            }

            if (!ok) {
                CoachesBattle.command = false;

                try {
                    Thread.sleep(55L);
                } catch (InterruptedException var2) {
                    var2.printStackTrace();
                }

                CoachesBattle.command = true;
            }
        }

    }

    public static void checkWinner(Pokemon pokemonFirstCoach, Pokemon pokemonSecondCoach, Logger logger) {
        if (CoachesBattle.firstHP <= 0) {
            logger.info("Pokemon " + pokemonSecondCoach.getName() + " wins!");
            logger.info("The second coach wins!");
            logger.info("The pokemon is now boosted");
            PokemonDecorator.boostPokemon(pokemonSecondCoach);
            logger.info(pokemonSecondCoach.toString());
        } else {
            logger.info("Pokemon " + pokemonFirstCoach.getName() + " wins!");
            logger.info("The first coach wins!");
            logger.info("The pokemon is now boosted");
            PokemonDecorator.boostPokemon(pokemonFirstCoach);
            logger.info(pokemonFirstCoach.toString());
        }

    }
}
