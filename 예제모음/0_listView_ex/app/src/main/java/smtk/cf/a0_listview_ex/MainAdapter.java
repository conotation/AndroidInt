package smtk.cf.a0_listview_ex;

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
    ArrayList<Item> al;

    public MainAdapter() {
        al = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Item getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_main, parent,
                    false);
        }

        LinearLayout ll = convertView.findViewById(R.id.content_color);
        TextView tv = convertView.findViewById(R.id.content_text);

        Item it = getItem(position);
        ll.setBackgroundColor(Color.parseColor(it.getColor()));
        tv.setText(it.getText());

        return convertView;
    }

    public void addItem(String color, String text) {
        Item it = new Item();
        it.setColor(color);
        it.setText(text);

        al.add(it);
    }
}
