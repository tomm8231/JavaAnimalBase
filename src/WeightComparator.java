import java.util.Comparator;

public class WeightComparator implements Comparator<Animal> {

  SortDirection sortDirection;

  public WeightComparator(SortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }

  @Override
  public int compare(Animal o1, Animal o2) {

    if (sortDirection.equals(SortDirection.ASC)) {
      return (int) (o1.getWeight() - o2.getWeight());

    } else if (sortDirection.equals(SortDirection.DESC)) {
      return (int) (o2.getWeight() - o1.getWeight());

    } else return 0;
  }
}

