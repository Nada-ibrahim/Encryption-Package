package GroupOperations;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataModel {
    private final SimpleIntegerProperty number;
    private final SimpleIntegerProperty inverse;


    public DataModel(Integer number, Integer inverse) {
        this.number = new SimpleIntegerProperty(number);
        this.inverse = new SimpleIntegerProperty(inverse);
    }

    public int getNumber() {
        return number.get();
    }


    public int getInverse() {
        return inverse.get();
    }

}
