public class EnhancedPokemon {
    public EnhancedPokemon() {
    }

    public static Pokemon enhance(Pokemon pokemon, String magicToken) {
        byte var3 = -1;
        switch(magicToken.hashCode()) {
            case -775828915:
                if (magicToken.equals("Sabiuta")) {
                    var3 = 2;
                }
                break;
            case 2571535:
                if (magicToken.equals("Scut")) {
                    var3 = 0;
                }
                break;
            case 82545905:
                if (magicToken.equals("Vesta")) {
                    var3 = 1;
                }
                break;
            case 323189112:
                if (magicToken.equals("Pelerina")) {
                    var3 = 6;
                }
                break;
            case 1110927426:
                if (magicToken.equals("Bagheta Magica")) {
                    var3 = 3;
                }
                break;
            case 1159374655:
                if (magicToken.equals("Brad de Craciun")) {
                    var3 = 5;
                }
                break;
            case 1670354131:
                if (magicToken.equals("Vitamine")) {
                    var3 = 4;
                }
        }

        switch(var3) {
            case 0:
                pokemon.setNormalDefense(pokemon.getNormalDefense() + 2);
                pokemon.setSpecialDefense(pokemon.getSpecialDefense() + 2);
                break;
            case 1:
                pokemon.setHP(pokemon.getHP() + 10);
                break;
            case 2:
                if (pokemon.getNormalAttack() != 0) {
                    pokemon.setNormalAttack(pokemon.getNormalAttack() + 3);
                }
                break;
            case 3:
                if (pokemon.getSpecialAttack() != 0) {
                    pokemon.setSpecialAttack(pokemon.getSpecialAttack() + 3);
                }
                break;
            case 4:
                pokemon.setHP(pokemon.getHP() + 2);
                if (pokemon.getNormalAttack() != 0) {
                    pokemon.setNormalAttack(pokemon.getNormalAttack() + 2);
                } else if (pokemon.getSpecialAttack() != 0) {
                    pokemon.setSpecialAttack(pokemon.getSpecialAttack() + 2);
                }
                break;
            case 5:
                if (pokemon.getNormalAttack() != 0) {
                    pokemon.setNormalAttack(pokemon.getNormalAttack() + 3);
                }

                pokemon.setNormalDefense(pokemon.getNormalDefense() + 1);
                break;
            case 6:
                pokemon.setSpecialDefense(pokemon.getSpecialDefense() + 3);
        }

        return pokemon;
    }
}