import java.util.Random;
import java.util.logging.Logger;

public class Arena {
    private static Arena singletonInstanceArena;

    public Arena() {
    }

    public static Arena getSingletonInstance() {
        if (singletonInstanceArena == null) {
            singletonInstanceArena = new Arena();
        }

        return singletonInstanceArena;
    }

    private int randomEvent() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public void startDuel(Pokemon pokemonFromFirst, Pokemon pokemonFromSecond, Logger logger) throws CloneNotSupportedException {
        int randomEventNumber;
        while((randomEventNumber = this.randomEvent()) != 2) {
            Pokemon pokemon1;
            Pokemon pokemon2;
            if (randomEventNumber == 0) {
                pokemon1 = pokemonFromFirst.clone();
                pokemon2 = pokemonFromSecond.clone();
                if (FightNeutrel1.fight(pokemon1, logger)) {
                    logger.info("The first coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromFirst);
                    logger.info(pokemonFromFirst.toString());
                }

                if (FightNeutrel1.fight(pokemon2, logger)) {
                    logger.info("The second coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromSecond);
                    logger.info(pokemonFromSecond.toString());
                }
            } else if (randomEventNumber == 1) {
                pokemon1 = pokemonFromFirst.clone();
                pokemon2 = pokemonFromSecond.clone();
                if (FightNeutrel2.fight(pokemon1, logger)) {
                    logger.info("The first coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromFirst);
                    logger.info(pokemonFromFirst.toString());
                }

                if (FightNeutrel2.fight(pokemon2, logger)) {
                    logger.info("The second coach wins!");
                    logger.info("The pokemon is now boosted");
                    PokemonDecorator.boostPokemon(pokemonFromSecond);
                    logger.info(pokemonFromSecond.toString());
                }
            }
        }

        CoachesBattle.battle(pokemonFromFirst, pokemonFromSecond, logger);
    }
}