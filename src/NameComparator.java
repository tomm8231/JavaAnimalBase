import java.util.Comparator;

public class NameComparator implements Comparator<Animal> {

  SortDirection sortDirection;

  public NameComparator(SortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }

  @Override
  public int compare(Animal o1, Animal o2) {

    if (sortDirection.equals(SortDirection.ASC)) {
      return o1.getName().compareTo(o2.getName());
    } else if (sortDirection.equals(SortDirection.DESC)) {
      return o2.getName().compareTo(o1.getName());
    } else return 0;
  }
}
