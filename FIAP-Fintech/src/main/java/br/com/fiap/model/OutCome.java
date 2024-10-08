package br.com.fiap.model;

public class OutCome extends Transactions{
    private int frequency; // Número de dias


    public OutCome(int frequency) {
        this.frequency = frequency;
    }

    public OutCome(Integer type, Double value, String date, String description, int frequency) {
        super(type, value, date, description);
        this.frequency = frequency;
    }
// Getter and Setter
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
