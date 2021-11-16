import java.util.Comparator;

public class SuperFlexibleComparator implements Comparator<Animal> {
    private String direction = "DESC";
    private String type;

    public SuperFlexibleComparator(String type, String direction) {
        this.type = type;
        this.direction = direction;
    }

    public void setDirection(String direction) {
        if( direction.equals("TOGGLE")) {
            if( this.direction.equals("ASC")) {
                this.direction = "DESC";
            } else {
                this.direction = "ASC";
            }
        } else {
            this.direction = direction;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        int resultat = 0;
        if( type.equals("age") ) {
            resultat = Integer.compare( o1.getAge(), o2.getAge() );
        } else if(type.equals("type")) {
            resultat =  o1.getType().compareTo( o2.getType() );
        } else if(type.equals("name")) {
            resultat = o1.getName().compareTo( o2.getName() );
        }

        if( direction.equals("DESC")) {
           resultat = resultat * -1;
        }

        return resultat;
    }
}