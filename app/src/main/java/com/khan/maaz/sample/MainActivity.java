package com.khan.maaz.sample;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Spinner spn;
    Spinner spn1;
    String[] titles;
    String[] descriptions;
    String[] rating;
    int[] images = {R.drawable.burger,R.drawable.mcd,R.drawable.pp};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn=(Spinner) findViewById(R.id.spinner);
        spn1=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adp=ArrayAdapter.createFromResource(this,R.array.data,android.R.layout.simple_spinner_item);
                spn.setAdapter(adp);
        ArrayAdapter adp1=ArrayAdapter.createFromResource(this,R.array.data1,android.R.layout.simple_spinner_item);
        spn1.setAdapter(adp1);


        Resources rs = getResources();
        titles= rs.getStringArray(R.array.titles);
        descriptions= rs.getStringArray(R.array.descriptions);
        rating = rs.getStringArray(R.array.rating);


        lv = (ListView) findViewById(R.id.listview);
        khan adapter=new khan(this,titles,images,descriptions,rating);
        lv.setAdapter(adapter);

    }

}
class khan extends ArrayAdapter<String>
{
    int[] images;
    Context context;
    String[] titlearray;
    String[] descriptionarray;
    String[] star;
    khan(Context c, String[] titles, int[] imgs, String[] descriptions, String[] rating)
    {
        super(c,R.layout.single,R.id.title,titles);
        this.context=c;
        this.images=imgs;
        this.titlearray=titles;
        this.descriptionarray=descriptions;
        this.star=rating;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single,parent,false);

        ImageView img=(ImageView)row.findViewById(R.id.burger);
        TextView tt=(TextView)row.findViewById(R.id.title);
        TextView tt1=(TextView)row.findViewById(R.id.description);
        TextView tt2=(TextView)row.findViewById(R.id.rating);

        img.setImageResource(images[position]);
        tt.setText(titlearray[position]);
        tt1.setText(descriptionarray[position]);
        tt2.setText(star[position]);


        return row;
    }

}