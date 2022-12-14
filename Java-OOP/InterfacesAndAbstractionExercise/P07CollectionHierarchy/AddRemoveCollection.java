package InterfacesAndAbstractionExercise.P07CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public int add(String element) {
        items.add(0,element);
        return 0;
    }

    @Override
    public String remove() {
        return items.remove(items.size() - 1);
    }
}
