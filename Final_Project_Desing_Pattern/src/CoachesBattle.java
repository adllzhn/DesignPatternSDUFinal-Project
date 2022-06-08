import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CoachesBattle {
    public static Boolean command = false;
    public static int firstHP;
    public static int secondHP;
    public static int[] cooldownPokemon1 = new int[]{0, 0};
    public static int[] cooldownPokemon2 = new int[]{0, 0};
    public static int[] stun = new int[]{0, 0};

    public CoachesBattle() {
    }

    public static void battle(Pokemon pokemonFirstCoach, Pokemon pokemonSecondCoach, Logger logger) throws CloneNotSupportedException {
        firstHP = pokemonFirstCoach.getHP();
        secondHP = pokemonSecondCoach.getHP();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Coach1());
        executor.execute(new Coach2());
        command = true;
        logger.info("This duel is between the following two pokemons!");
        logger.info(pokemonFirstCoach.toString());
        logger.info(pokemonSecondCoach.toString());
        Pokemon pokemon1 = pokemonFirstCoach.clone();
        Pokemon pokemon2 = pokemonSecondCoach.clone();

        while(firstHP > 0 && secondHP > 0) {
            String var10001;
            PokemonHelperClassForBattle.checkCommand();
            int firstCommand = CoachesFight.firstCommand;
            int secondCommand = CoachesFight.secondCommand;
            int var10002;
            label121:
            switch(firstCommand) {
                case 0:
                    switch(secondCommand) {
                        case 0:
                            HelpBattle2.pokemonsAttack(logger, stun, pokemon1, pokemon2);
                            HelpBattle2.checkCooldown(logger, pokemon1, cooldownPokemon1);
                            HelpBattle2.checkCooldown(logger, pokemon2, cooldownPokemon2);
                            break label121;
                        case 1:
                            if (stun[1] == 0) {
                                cooldownPokemon2[0] = pokemon2.getAbility1().getCoolDown();
                            }

                            HelpBattle1.abilityVsAttack(pokemon1, pokemon2, pokemon2.getAbility1(), logger, 1, 0, 1);
                            if (cooldownPokemon2[1] != 0) {
                                var10002 = cooldownPokemon2[1]--;
                                var10001 = pokemon2.getName();
                                logger.info("Cooldown ability 2 for " + var10001 + " is " + cooldownPokemon2[1]);
                            }

                            HelpBattle2.checkCooldown(logger, pokemon1, cooldownPokemon1);
                            break label121;
                        case 2:
                            if (stun[1] == 0) {
                                cooldownPokemon2[1] = pokemon2.getAbility2().getCoolDown();
                            }

                            HelpBattle1.abilityVsAttack(pokemon1, pokemon2, pokemon2.getAbility2(), logger, 2, 0, 1);
                            if (cooldownPokemon2[0] != 0) {
                                var10002 = cooldownPokemon2[0]--;
                                var10001 = pokemon2.getName();
                                logger.info("Cooldown ability 1 for " + var10001 + " is " + cooldownPokemon2[0]);
                            }

                            HelpBattle2.checkCooldown(logger, pokemon1, cooldownPokemon1);
                        default:
                            break label121;
                    }
                case 1:
                    switch(secondCommand) {
                        case 0:
                            if (stun[0] == 0) {
                                cooldownPokemon1[0] = pokemon1.getAbility1().getCoolDown();
                            }

                            HelpBattle1.abilityVsAttack(pokemon2, pokemon1, pokemon1.getAbility1(), logger, 1, 1, 0);
                            if (cooldownPokemon1[1] != 0) {
                                var10002 = cooldownPokemon1[1]--;
                                var10001 = pokemon1.getName();
                                logger.info("Cooldown ability 2 for " + var10001 + " is " + cooldownPokemon1[1]);
                            }

                            HelpBattle2.checkCooldown(logger, pokemon2, cooldownPokemon2);
                            break label121;
                        case 1:
                            if (stun[0] == 0) {
                                cooldownPokemon1[0] = pokemon1.getAbility1().getCoolDown();
                            }

                            if (stun[1] == 0) {
                                cooldownPokemon2[0] = pokemon2.getAbility1().getCoolDown();
                            }

                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility1(), pokemon2.getAbility1(), logger, 1, 1);
                            if (cooldownPokemon1[1] != 0) {
                                var10002 = cooldownPokemon1[1]--;
                                var10001 = pokemon1.getName();
                                logger.info("Cooldown ability 2 for " + var10001 + " is " + cooldownPokemon1[1]);
                            }

                            if (cooldownPokemon2[1] != 0) {
                                var10002 = cooldownPokemon2[1]--;
                                var10001 = pokemon2.getName();
                                logger.info("Cooldown ability 2 for " + var10001 + " is " + cooldownPokemon2[1]);
                            }
                            break label121;
                        case 2:
                            if (stun[0] == 0) {
                                cooldownPokemon1[0] = pokemon1.getAbility1().getCoolDown();
                            }

                            if (stun[1] == 0) {
                                cooldownPokemon2[1] = pokemon2.getAbility2().getCoolDown();
                            }

                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility1(), pokemon2.getAbility2(), logger, 1, 2);
                            if (cooldownPokemon1[1] != 0) {
                                var10002 = cooldownPokemon1[1]--;
                                var10001 = pokemon1.getName();
                                logger.info("Cooldown ability 2 for " + var10001 + " is " + cooldownPokemon1[1]);
                            }

                            if (cooldownPokemon2[0] != 0) {
                                var10002 = cooldownPokemon2[0]--;
                                var10001 = pokemon2.getName();
                                logger.info("Cooldown ability 1 for " + var10001 + " is " + cooldownPokemon2[0]);
                            }
                        default:
                            break label121;
                    }
                case 2:
                    switch(secondCommand) {
                        case 0:
                            if (stun[0] == 0) {
                                cooldownPokemon1[1] = pokemon1.getAbility2().getCoolDown();
                            }

                            HelpBattle1.abilityVsAttack(pokemon2, pokemon1, pokemon1.getAbility2(), logger, 2, 1, 0);
                            if (cooldownPokemon1[0] != 0) {
                                var10002 = cooldownPokemon1[0]--;
                                var10001 = pokemon1.getName();
                                logger.info("Cooldown ability 1 for " + var10001 + " is " + cooldownPokemon1[0]);
                            }

                            HelpBattle2.checkCooldown(logger, pokemon2, cooldownPokemon2);
                            break;
                        case 1:
                            if (stun[0] == 0) {
                                cooldownPokemon1[1] = pokemon1.getAbility2().getCoolDown();
                            }

                            if (stun[1] == 0) {
                                cooldownPokemon2[0] = pokemon2.getAbility1().getCoolDown();
                            }

                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility2(), pokemon2.getAbility1(), logger, 2, 1);
                            if (cooldownPokemon1[0] != 0) {
                                var10002 = cooldownPokemon1[0]--;
                                var10001 = pokemon1.getName();
                                logger.info("Cooldown ability 1 for " + var10001 + " is " + cooldownPokemon1[0]);
                            }

                            if (cooldownPokemon2[1] != 0) {
                                var10002 = cooldownPokemon2[1]--;
                                var10001 = pokemon2.getName();
                                logger.info("Cooldown ability 2 for " + var10001 + " is " + cooldownPokemon2[1]);
                            }
                            break;
                        case 2:
                            if (stun[0] == 0) {
                                cooldownPokemon1[1] = pokemon1.getAbility2().getCoolDown();
                            }

                            if (stun[1] == 0) {
                                cooldownPokemon2[1] = pokemon2.getAbility2().getCoolDown();
                            }

                            HelpBattle.abilityVsAbility(pokemon1, pokemon2, pokemon1.getAbility2(), pokemon2.getAbility2(), logger, 2, 2);
                            if (cooldownPokemon1[0] != 0) {
                                var10002 = cooldownPokemon1[0]--;
                                var10001 = pokemon1.getName();
                                logger.info("Cooldown ability 1 for " + var10001 + " is " + cooldownPokemon1[0]);
                            }

                            if (cooldownPokemon2[0] != 0) {
                                var10002 = cooldownPokemon2[0]--;
                                var10001 = pokemon2.getName();
                                logger.info("Cooldown ability 1 for " + var10001 + " is " + cooldownPokemon2[0]);
                            }
                    }
            }

            resumeThreads();
            command = true;
            firstHP = pokemon1.getHP();
            secondHP = pokemon2.getHP();
            var10001 = pokemon1.getName();
            logger.info(var10001 + " has " + firstHP + " HP!");
            var10001 = pokemon2.getName();
            logger.info(var10001 + " has " + secondHP + " HP!");
        }

        PokemonHelperClassForBattle.checkWinner(pokemonFirstCoach, pokemonSecondCoach, logger);
        executor.shutdown();
    }

    private static void resumeThreads() {
        command = false;

        try {
            Thread.sleep(1L);
        } catch (InterruptedException var1) {
            var1.printStackTrace();
        }

    }
}