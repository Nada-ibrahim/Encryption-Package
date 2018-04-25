package DiscreteLog;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class DataModel {
        private final SimpleIntegerProperty b;
        private final SimpleIntegerProperty i;
        private final SimpleLongProperty time;


        public DataModel(Integer b, Integer i, Long time) {
            this.b = new SimpleIntegerProperty(b);
            this.i = new SimpleIntegerProperty(i);
            this.time = new SimpleLongProperty(time);
        }

        public int getB() {
            return b.get();
        }


        public int getI() {
            return i.get();
        }
        public Long getTime() {
            return time.get();
        }

    }

