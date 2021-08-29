package pokemon;

public class FirePokemon extends Pokemon {
    public FirePokemon(String name, String type, int health) {
        super(name, type, health);
    }

    public FirePokemon(String name, int health) {
        super(name, health);
    }


    @Override
    public String attack() {
        return "FIRE";
    }

    @Override
    public String defend() {
        return "BODY";
    }

    @Override
    public String win() {
        return "GRASS type";
    }

    @Override
    public String lose() {
        return "WATER type";
    }
    @Override
    public String logAll() {
        return name + " pokemon attacks with " + attack() + ", defends with " + defend() + ", wins against " + win() +
                " pokemons and loses from " + lose() + " pokemons.";
    }
}
