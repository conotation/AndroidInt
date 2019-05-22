package smtk.cf.a0_listview_ex;

public class Content {
    private String name;
    private String num;
    private String birth;
    private int key;

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getKey() {
        return key;
    }

    public String getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }
}
