package pokemon;

public class WaterPokemon extends Pokemon{
    public WaterPokemon(String name, String type, int health) {
        super(name, type, health);
    }

    public WaterPokemon(String name, int health) {
        super(name, health);
    }

    @Override
    public String attack() {
        return "WATER";
    }

    @Override
    public String defend() {
        return "WATER";
    }

    @Override
    public String win() {
        return "FIRE type";
    }

    @Override
    public String lose() {
        return "GRASS type";
    }
    @Override
    public String logAll() {
        return name+" pokemon attacks with "+attack()+", defends with "+defend()+", wins against "+win()+
                " pokemons and loses from "+lose()+" pokemons.";
    }
}
