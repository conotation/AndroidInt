package smtk.cf.tutorial07;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {
    private ArrayList<MainItem> al;

    MainAdapter(){
        al = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public MainItem getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_main, parent, false);
        }

        LinearLayout ll = convertView.findViewById(R.id.content_color);
        TextView tv = convertView.findViewById(R.id.content_text);

        MainItem mi = getItem(position);

        ll.setBackgroundColor(Color.rgb(0, 0, 255)); // TODO mi.getColor()
        tv.setText(mi.getText());

        // TODO ADD EVENT

        return convertView;
    }

    public void addItem(String color, String text){
        MainItem mi = new MainItem();
        mi.setColor(color);
        mi.setText(text);
        al.add(mi);
    }
}
