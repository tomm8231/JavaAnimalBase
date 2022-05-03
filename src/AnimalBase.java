import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class AnimalBase {

    private ArrayList<Animal> animals;

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() {
        UserInterface ui = new UserInterface(this);
        ui.start();
    }

    public static void main(String[] args) {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void sortBy(String sortBy, SortDirection sortDirection) {
        // TODO: Implement sorting!

        Comparator comparator = null;

        if (sortBy.equals("age")) {
            comparator = new AgeComparator(sortDirection);
            Collections.sort(animals, comparator);
        } else if (sortBy.equals("name")) {
            comparator = new NameComparator(sortDirection);
            Collections.sort(animals, comparator);
        } else if (sortBy.equals("type")) {
            comparator = new TypeComparator(sortDirection);
            Collections.sort(animals, comparator);
        } else if (sortBy.equals("weight")) {
            comparator = new WeightComparator(sortDirection);
            Collections.sort(animals, comparator);
        }

        System.out.println("TODO: Sort the list of animals by: " + sortBy);
    }

    public void createNewAnimal(String name, String description, String type, int age, double weight) {
        Animal animal = new Animal(name,description,type,age,weight);
        animals.add(animal);
    }

    public boolean deleteAnimal(String name) {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if(animal == null) {
            return false;
        } else {
            animals.remove(animal);
            return true;
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

    public void loadDatabase()  {

        FileHandler fileHandler = new FileHandler();
        animals.addAll(fileHandler.loadAnimalsFromFile());
        //Eller:
        //animals = fileHandler.loadDatabase();
    }

    public void saveDatabase() {

        try {
            FileHandler fileHandler = new FileHandler();
            fileHandler.saveAnimalsToFile(animals);
        } catch (FileNotFoundException exception) {
            System.err.println("Could not save file");
        }

    }



    }
