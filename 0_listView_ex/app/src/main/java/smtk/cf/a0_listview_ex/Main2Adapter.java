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

public class Main2Adapter extends BaseAdapter {
    ArrayList<Content> al;

    Main2Adapter(){
        al = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Content getItem(int position) {
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
            convertView = inflater.inflate(R.layout.content_main2, parent,
                    false);
        }

        TextView tv = convertView.findViewById(R.id.content_name);
        TextView tv2 = convertView.findViewById(R.id.content_num);
        TextView tv3 = convertView.findViewById(R.id.content_birth);
        TextView tv4 = convertView.findViewById(R.id.content_key);

        Content it = getItem(position);

        tv.setText(it.getName());
        tv2.setText(it.getNum());
        tv3.setText(it.getBirth());
        tv4.setText("" + it.getKey());

        return convertView;
    }

    public void addContent(String n, String n2, String b, int k){
        Content content = new Content();

        content.setName(n);
        content.setNum(n2);
        content.setBirth(b);
        content.setKey(k);

        al.add(content);
    }
}
