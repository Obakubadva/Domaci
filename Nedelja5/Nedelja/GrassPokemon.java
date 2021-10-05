package pokemon;

public class GrassPokemon extends Pokemon {
    public GrassPokemon(String name, String type, int health) {
        super(name, type, health);
    }

    public GrassPokemon(String name, int health) {
        super(name, health);
    }

    @Override
    public String attack() {
        return "GRASS";
    }

    @Override
    public String defend() {
        return "by AVOIDING";
    }

    @Override
    public String win() {
        return "WATER type";
    }

    @Override
    public String lose() {
        return "FIRE type";
    }

    @Override
    public String logAll() {
        return name + " pokemon attacks with "+ attack() + ", defends " + defend() + ", wins against " + win( ) +
                " pokemons and loses from " + lose() + " pokemons.";
    }
}
