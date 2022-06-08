import java.util.ArrayList;
import java.util.logging.Logger;

public class ComparePokemons {
    public ComparePokemons() {
    }

    public static ArrayList<Pokemon> bestTwoPokemons(ArrayList<Pokemon> first, ArrayList<Pokemon> second, Logger logger) {
        ArrayList<Pokemon> bestTwo = new ArrayList(2);
        int scoreCoach1P1 = pokemonScore((Pokemon)first.get(0));
        int scoreCoach1P2 = pokemonScore((Pokemon)first.get(1));
        int scoreCoach1P3 = pokemonScore((Pokemon)first.get(2));
        Pokemon maxPokemon = (Pokemon)first.get(0);
        maxPokemon = getMaxPokemon(first, scoreCoach1P1, maxPokemon, scoreCoach1P2, scoreCoach1P3);
        bestTwo.add(0, maxPokemon);
        logger.info("The best pokemon from the first coach is " + maxPokemon.getName() + "!");
        int scoreCoach2P1 = pokemonScore((Pokemon)second.get(0));
        int scoreCoach2P2 = pokemonScore((Pokemon)second.get(1));
        int scoreCoach2P3 = pokemonScore((Pokemon)second.get(2));
        maxPokemon = (Pokemon)second.get(0);
        maxPokemon = getMaxPokemon(second, scoreCoach2P1, maxPokemon, scoreCoach2P2, scoreCoach2P3);
        bestTwo.add(1, maxPokemon);
        logger.info("The best pokemon from the second coach is " + maxPokemon.getName() + "!");
        return bestTwo;
    }

    private static Pokemon getMaxPokemon(ArrayList<Pokemon> pokemonList, int maxScore, Pokemon maxPokemon, int scoreP2, int scoreP3) {
        if (scoreP2 >= maxScore) {
            if (scoreP2 == maxScore) {
                if (((Pokemon)pokemonList.get(1)).getName().compareToIgnoreCase(maxPokemon.getName()) < 0) {
                    maxPokemon = (Pokemon)pokemonList.get(1);
                }
            } else {
                maxScore = scoreP2;
                maxPokemon = (Pokemon)pokemonList.get(1);
            }
        }

        if (scoreP3 >= maxScore) {
            if (scoreP3 == maxScore) {
                if (((Pokemon)pokemonList.get(2)).getName().compareToIgnoreCase(maxPokemon.getName()) < 0) {
                    maxPokemon = (Pokemon)pokemonList.get(2);
                }
            } else {
                maxPokemon = (Pokemon)pokemonList.get(2);
            }
        }

        return maxPokemon;
    }

    private static int pokemonScore(Pokemon pokemon) {
        return pokemon.getHP() + pokemon.getNormalAttack() + pokemon.getSpecialAttack() + pokemon.getNormalDefense() + pokemon.getSpecialDefense();
    }
}

