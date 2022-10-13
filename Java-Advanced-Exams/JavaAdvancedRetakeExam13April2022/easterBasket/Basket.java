package JavaAdvancedRetakeExam13April2022.easterBasket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<Egg> data;
    String material;
    int capacity;

    public Basket (String material, int capacity){
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg (Egg egg){
        if (this.data.size() < capacity){
            this.data.add(egg);
        }
    }

    public boolean removeEgg (String color){
        return this.data.removeIf(s -> s.getColor().equals(color));
    }

    public Egg getStrongestEgg (){
        int strongest = Integer.MIN_VALUE;
        Egg strongestEgg = null;
        for (Egg egg : this.data) {
            if (egg.getStrength() >= strongest){
                strongest = egg.getStrength();
                strongestEgg = egg;
            }
        }
        return strongestEgg;
    }

    public Egg getEgg (String color){
        return this.data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount () {
        return this.data.size();
    }

    public String report (){
         return this.material + " basket contains:" + System.lineSeparator() +
                this.data.stream().map(Egg::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
