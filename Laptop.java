package Java_Seminar6.Java_Sem6_HT;

public class Laptop {
    private String model;
    private int SN;
    private int screenDiag;
    private int RAM;
    private int ROM;
    private String OS;
    private String color;

    public Laptop(String model, int SN){
        this.model = model;
        this.SN = SN;
    }

    public String GetModel(){
        return model;
    }

    public void GetParameters(){
        System.out.println(SN + screenDiag + RAM + ROM + OS + color);
    }

    public int getROM() {
        return ROM;
    }

    public int getRAM() {
        return RAM;
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return color;
    }

    public void SetParameters(int screenDiag, int RAM, int ROM, String OS, String color){
        this.screenDiag = screenDiag;
        this.RAM = RAM;
        this.ROM = ROM;
        this.OS = OS;
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString (){
        return "Model: " + this.model + " s/n: " + this.SN;
    }
}
