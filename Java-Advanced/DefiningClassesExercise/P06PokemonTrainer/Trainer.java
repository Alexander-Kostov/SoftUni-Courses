package JavaAdvance.DefiningClassesExercise.P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    String name;
    int badges = 0;
    List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public boolean hasPokemon (String element){
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public void addBadge (){
        this.badges++;
    }

    public void getDamage (){
        for (int i = 0; i < pokemons.size(); i++) {
           if (pokemons.get(i).isDead()){
               pokemons.remove(pokemons.get(i));

           }else {
               this.pokemons.get(i).setHealth(pokemons.get(i).getHealth() - 10);
               if (pokemons.get(i).isDead()){
                   pokemons.remove(pokemons.get(i));
               }
           }
        }
    }

}
