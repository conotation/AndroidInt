package smtk.cf.tutorial07;

public class MainItem {
    private String color, text;

    MainItem(){}

    MainItem(String color, String text){
        this.color = color;
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
