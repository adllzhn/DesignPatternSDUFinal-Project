public class Ability {
    private int damage;
    private Boolean stun;
    private Boolean dodge;
    private int coolDown;

    private Ability() {
    }

    public int getDamage() {
        return this.damage;
    }

    public Boolean getStun() {
        return this.stun;
    }

    public Boolean getDodge() {
        return this.dodge;
    }

    public int getCoolDown() {
        return this.coolDown;
    }

    public String toString() {
        return "{damage=" + this.damage + ", stun=" + this.stun + ", dodge=" + this.dodge + ", coolDown=" + this.coolDown + "}";
    }

    public static class AbilityBuilder {
        private final int damage;
        private Boolean stun;
        private Boolean dodge;
        private int coolDown;

        public AbilityBuilder(int damage) {
            this.damage = damage;
        }

        public Ability.AbilityBuilder withStun(Boolean stun) {
            this.stun = stun;
            return this;
        }

        public Ability.AbilityBuilder withDodge(Boolean dodge) {
            this.dodge = dodge;
            return this;
        }

        public Ability.AbilityBuilder withCoolDown(int coolDown) {
            this.coolDown = coolDown;
            return this;
        }

        public Ability build() {
            Ability ability = new Ability();
            ability.damage = this.damage;
            ability.stun = this.stun;
            ability.dodge = this.dodge;
            ability.coolDown = this.coolDown;
            return ability;
        }
    }
}