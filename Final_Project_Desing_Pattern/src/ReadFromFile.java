import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ReadFromFile {
    public ReadFromFile() {
    }

    public static void read(Logger logger) {
        PokemonFactory myPokemonFactory = PokemonFactory.getSingletonInstance();
        String rootFileName = "src/inputFiles/Test";

        for(int i = 1; i <= 1; ++i) {
            String fileName = rootFileName + i + ".in";
            logger.info("Duel number " + i + " has started!");

            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));

                try {
                    String coach1 = br.readLine();
                    String age1 = br.readLine();
                    logger.info("Going into the Arena is the first coach - " + coach1 + ", who is " + age1 + " years old!");
                    String pokemon = br.readLine();
                    Pokemon pokemon11 = BuildPokemon.build(pokemon, br, myPokemonFactory);
                    pokemon = br.readLine();
                    Pokemon pokemon12 = BuildPokemon.build(pokemon, br, myPokemonFactory);
                    pokemon = br.readLine();
                    Pokemon pokemon13 = BuildPokemon.build(pokemon, br, myPokemonFactory);
                    String coach2 = br.readLine();
                    String age2 = br.readLine();
                    logger.info("Going into the Arena is the second coach - " + coach2 + ", who is " + age2 + " years old!");
                    pokemon = br.readLine();
                    Pokemon pokemon21 = BuildPokemon.build(pokemon, br, myPokemonFactory);
                    pokemon = br.readLine();
                    Pokemon pokemon22 = BuildPokemon.build(pokemon, br, myPokemonFactory);
                    pokemon = br.readLine();
                    Pokemon pokemon23 = BuildPokemon.build(pokemon, br, myPokemonFactory);
                    ArrayList<Pokemon> firstCoach = new ArrayList(3);
                    firstCoach.add(pokemon11);
                    firstCoach.add(pokemon12);
                    firstCoach.add(pokemon13);
                    ArrayList<Pokemon> secondCoach = new ArrayList(3);
                    secondCoach.add(pokemon21);
                    secondCoach.add(pokemon22);
                    secondCoach.add(pokemon23);
                    Arena arena = Arena.getSingletonInstance();
                    logger.info("FIRST ADVENTURE BEGINS!");
                    arena.startDuel((Pokemon)firstCoach.get(0), (Pokemon)secondCoach.get(0), logger);
                    logger.info(((Pokemon)firstCoach.get(0)).toString());
                    logger.info(((Pokemon)secondCoach.get(0)).toString());
                    logger.info("SECOND ADVENTURE BEGINS!");
                    arena.startDuel((Pokemon)firstCoach.get(1), (Pokemon)secondCoach.get(1), logger);
                    logger.info(((Pokemon)firstCoach.get(1)).toString());
                    logger.info(((Pokemon)secondCoach.get(1)).toString());
                    logger.info("THIRD ADVENTURE BEGINS!");
                    arena.startDuel((Pokemon)firstCoach.get(2), (Pokemon)secondCoach.get(2), logger);
                    logger.info(((Pokemon)firstCoach.get(2)).toString());
                    logger.info(((Pokemon)secondCoach.get(2)).toString());
                    logger.info("FOURTH ADVENTURE BEGINS!");
                    ArrayList<Pokemon> bestTwo = ComparePokemons.bestTwoPokemons(firstCoach, secondCoach, logger);
                    arena.startDuel((Pokemon)bestTwo.get(0), (Pokemon)bestTwo.get(1), logger);
                } catch (Throwable var22) {
                    try {
                        br.close();
                    } catch (Throwable var21) {
                        var22.addSuppressed(var21);
                    }

                    throw var22;
                }

                br.close();
            } catch (CloneNotSupportedException | IOException var23) {
                var23.printStackTrace();
            }
        }

    }
}