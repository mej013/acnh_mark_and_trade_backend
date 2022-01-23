package acnh_backend.duomaoj.type;

import java.time.Month;

public class MonthArr {
    private int[] northern;
    private int[] southern;

    public MonthArr (int[] northern, int[] southern) {
        this.northern = northern;
        this.southern = southern;
    }

    public void setNorthern(int[] northern) {
        this.northern = northern;
    }

    public int[] getNorthern() {
        return northern;
    }

    public void setSouthern(int[] southern) {
        this.southern = southern;
    }

    public int[] getSouthern() {
        return southern;
    }
}
