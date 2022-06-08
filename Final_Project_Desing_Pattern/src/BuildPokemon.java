import java.io.BufferedReader;
import java.io.IOException;

public class BuildPokemon {
    public BuildPokemon() {
    }

    public static Pokemon build(String string, BufferedReader br, PokemonFactory pokemonFactory) {
        PokemonFactory.PokemonType type = PokemonFactory.PokemonType.valueOf(string);
        Pokemon pokemon = pokemonFactory.returnPokemon(type);

        for(int j = 1; j <= 3; ++j) {
            String magicToken = null;

            try {
                magicToken = br.readLine();
            } catch (IOException var8) {
                var8.printStackTrace();
            }

            assert magicToken != null;

            EnhancedPokemon.enhance(pokemon, magicToken);
        }

        return pokemon;
    }
}
