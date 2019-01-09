package smtk.cf.a0_retrofit_ex;

public class Item {
    String id;
    String ip_address;

    @Override
    public String toString() {
        return id + "(" + ip_address + ")";
    }
}
