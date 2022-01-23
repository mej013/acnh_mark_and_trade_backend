package acnh_backend.duomaoj.type;

public class HourArr {
    private String[] northern;
    private String[] southern;

    public HourArr(String[] northern, String[] southern) {
        this.northern = northern;
        this.southern = southern;
    }

    public void setNorthern(String[] northern) {
        this.northern = northern;
    }

    public void setSouthern(String[] southern) {
        this.southern = southern;
    }

    public String[] getNorthern() {
        return northern;
    }

    public String[] getSouthern() {
        return southern;
    }
}
