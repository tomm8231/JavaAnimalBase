import java.util.ArrayList;
import java.util.Collections;

public class AnimalBase {

    private ArrayList<Animal> animals;

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() {
        UserInterface ui = new UserInterface(this);

        // TEST - REMOVE LATER!
        createNewAnimal("Bertil", "sleepy", "bull", 2);
        createNewAnimal("Abelone", "large", "elephant", 14);
        createNewAnimal("Crystal", "shiny", "turtle", 6);

        ui.start();
    }

    public static void main(String[] args) {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }

    private SuperFlexibleComparator comparator = new SuperFlexibleComparator("name", "ASC");

    public void sortBy(String sort, String direction) {
        // Implemented better sorting with SuperFlexibleComparator!
        System.out.println("Sorting the list of animals by name.");
        comparator.setType(sort);
        comparator.setDirection(direction);
        Collections.sort(animals, comparator);
    }

    public void createNewAnimal(String name, String description, String type, int age) {
        Animal animal = new Animal(name,description,type,age);
        animals.add(animal);
    }

    public void deleteAnimal(String name) throws NonExistingAnimalException {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if(animal == null) {
            throw new NonExistingAnimalException();
        } else {
            animals.remove(animal);
        }
    }

    private Animal findAnimalByName(String name) {
        for(Animal animal : animals) {
            if(animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }


    public void loadDatabase() {
        System.err.println("LOAD not yet implemented!");
    }

    public void saveDatabase() {
        System.err.println("SAVE not yet implemented!");
    }

}
