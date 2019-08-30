package com.example.resumeappgenerator;

//CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<Item> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_item, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.mtvName= (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.mtvWorkDpart= (TextView) convertView.findViewById(R.id.drtOfWork);
            viewHolder.mtvNationality = (TextView) convertView.findViewById(R.id.nationality);
            viewHolder.mtvEducationalBg=(TextView)convertView.findViewById(R.id.edBg);
            viewHolder.mtvPostal=(TextView)convertView.findViewById(R.id.tvpostal);
            viewHolder.mtvCountry=(TextView)convertView.findViewById(R.id.tvcountry);
            viewHolder.mtvStreet=(TextView)convertView.findViewById(R.id.tvstreet);
            viewHolder.mtvMail=(TextView)convertView.findViewById(R.id.tvmail);
            viewHolder.mtvWorkingExp=(TextView)convertView.findViewById(R.id.wExp);
            viewHolder.mtvProfile=(TextView)convertView.findViewById(R.id.profile);
            viewHolder.mtvLinks=(TextView)convertView.findViewById(R.id.links);
            viewHolder.mtvSkills=(TextView)convertView.findViewById(R.id.skills);
            viewHolder.mtvLanguages=(TextView)convertView.findViewById(R.id.languages);
            viewHolder.mtvReferees=(TextView)convertView.findViewById(R.id.referees);
            viewHolder.mtvHobbies=(TextView)convertView.findViewById(R.id.hobbies);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        Item person = data.get(position);//modify here
        viewHolder.mtvName.setText(person.getmName());//modify here
        viewHolder.mtvWorkDpart.setText(person.getmDrptWork());//modify here
        viewHolder.mtvNationality.setText(person.getmNationality());//modify here
        viewHolder.mtvEducationalBg.setText(person.getmEdBg());//modify here
        viewHolder.mtvPostal.setText(person.getmPostal());//modify here
        viewHolder.mtvCountry.setText(person.getmCountry());//modify here
        viewHolder.mtvStreet.setText(person.getmStreet());//modify here
        viewHolder.mtvMail.setText(person.getmMail());//modify here
        viewHolder.mtvWorkingExp.setText(person.getMwExp());//modify here
        viewHolder.mtvProfile.setText(person.getmProfile());//modify here
        viewHolder.mtvLinks.setText(person.getmLinks());//modify here
        viewHolder.mtvSkills.setText(person.getmSkills());//modify here
        viewHolder.mtvLanguages.setText(person.getmLanguages());//modify here
        viewHolder.mtvReferees.setText(person.getmReferees());//modify here
        viewHolder.mtvHobbies.setText(person.getmHobbies());//modify here
        return convertView;

    }
    static class ViewHolder {
        TextView mtvName;
        TextView mtvWorkDpart;
        TextView mtvNationality;
        TextView mtvEducationalBg;
        TextView mtvPostal;
        TextView mtvCountry;
        TextView mtvStreet;
        TextView mtvMail;
        TextView mtvWorkingExp;
        TextView mtvProfile;
        TextView mtvLinks;
        TextView mtvSkills;
        TextView mtvLanguages;
        TextView mtvReferees;
        TextView mtvHobbies;//These don't have to be same names as the Id's

    }

}