public class Pokemon implements Cloneable {
    private String name;
    private int HP;
    private int normalAttack;
    private int specialAttack;
    private int normalDefense;
    private int specialDefense;
    private Ability ability1;
    private Ability ability2;

    public Pokemon clone() throws CloneNotSupportedException {
        return (Pokemon)super.clone();
    }

    protected Pokemon() {
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getNormalAttack() {
        return this.normalAttack;
    }

    public void setNormalAttack(int normalAttack) {
        this.normalAttack = normalAttack;
    }

    public int getSpecialAttack() {
        return this.specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getNormalDefense() {
        return this.normalDefense;
    }

    public void setNormalDefense(int normalDefense) {
        this.normalDefense = normalDefense;
    }

    public int getSpecialDefense() {
        return this.specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public Ability getAbility1() {
        return this.ability1;
    }

    public Ability getAbility2() {
        return this.ability2;
    }

    public String toString() {
        String var10000 = this.name;
        return "Pokemon{name='" + var10000 + "', HP=" + this.HP + ", normalAttack=" + this.normalAttack + ", specialAttack=" + this.specialAttack + ", normalDefense=" + this.normalDefense + ", specialDefense=" + this.specialDefense + ", ability1=" + this.ability1.toString() + ", ability2=" + this.ability2.toString() + "}";
    }

    public String toStringWithoutAbility() {
        return "Pokemon{name='" + this.name + "', HP=" + this.HP + ", normalAttack=" + this.normalAttack + ", specialAttack=" + this.specialAttack + ", normalDefense=" + this.normalDefense + ", specialDefense=" + this.specialDefense + "}";
    }

    public static class PokemonBuilder {
        private final String name;
        private int HP;
        private int normalAttack;
        private int specialAttack;
        private int normalDefense;
        private int specialDefense;
        private Ability ability1;
        private Ability ability2;

        public PokemonBuilder(String name) {
            this.name = name;
        }

        public Pokemon.PokemonBuilder withHP(int HP) {
            this.HP = HP;
            return this;
        }

        public Pokemon.PokemonBuilder withNormalAttack(int normalAttack) {
            this.normalAttack = normalAttack;
            return this;
        }

        public Pokemon.PokemonBuilder withSpecialAttack(int specialAttack) {
            this.specialAttack = specialAttack;
            return this;
        }

        public Pokemon.PokemonBuilder withNormalDefense(int normalDefense) {
            this.normalDefense = normalDefense;
            return this;
        }

        public Pokemon.PokemonBuilder withSpecialDefense(int specialDefense) {
            this.specialDefense = specialDefense;
            return this;
        }

        public Pokemon.PokemonBuilder withAbility1(Ability ability1) {
            this.ability1 = ability1;
            return this;
        }

        public Pokemon.PokemonBuilder withAbility2(Ability ability2) {
            this.ability2 = ability2;
            return this;
        }

        public Pokemon build() {
            Pokemon pokemon = new Pokemon();
            pokemon.name = this.name;
            pokemon.HP = this.HP;
            pokemon.normalAttack = this.normalAttack;
            pokemon.specialAttack = this.specialAttack;
            pokemon.normalDefense = this.normalDefense;
            pokemon.specialDefense = this.specialDefense;
            pokemon.ability1 = this.ability1;
            pokemon.ability2 = this.ability2;
            return pokemon;
        }
    }
}
