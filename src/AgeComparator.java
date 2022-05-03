import java.util.Comparator;

public class AgeComparator implements Comparator<Animal> {

  SortDirection sortDirection;

  public AgeComparator(SortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }

  @Override
  public int compare(Animal o1, Animal o2) {

    if (sortDirection.equals(SortDirection.ASC)) {
      return o1.getAge() - o2.getAge();

    } else if (sortDirection.equals(SortDirection.DESC)) {
      return o2.getAge() - o1.getAge();

    } else return 0;
  }
}

