import java.util.Comparator;

public class TypeComparator implements Comparator<Animal> {

  SortDirection sortDirection;

  public TypeComparator(SortDirection sortDirection) {
    this.sortDirection = sortDirection;
  }

  @Override
  public int compare(Animal o1, Animal o2) {

    if (sortDirection.equals(SortDirection.ASC)) {
      return o1.getType().compareTo(o2.getType());
    } else if (sortDirection.equals(SortDirection.DESC)) {
      return o2.getType().compareTo(o1.getType());
    } else return 0;
  }
}
