package com.generally2.practice1;


import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



class LabAdapter extends ArrayAdapter<String>{

    String[] names;
    int[] images;
    Context mContext;
    View customView;


    public LabAdapter(Context context, String[] topics, int[] icons) {
        super(context, R.layout.custom_row,topics);
        this.names = topics;
        this.images = icons;
        this.mContext = context;

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

         if (convertView == null) {
             LayoutInflater labInflater = LayoutInflater.from(getContext());
             customView = labInflater.inflate(R.layout.custom_row, parent, false);

             String singleTopic = getItem(position);
             mViewHolder.labText = (TextView) customView.findViewById(R.id.textList);
             mViewHolder.labImage = (ImageView) customView.findViewById(R.id.listImage);
             customView.setTag(mViewHolder);
         }
         else{
            mViewHolder = (ViewHolder)customView.getTag();
         }
            //labText.setText(singleTopic);
            mViewHolder.labText.setText(names[position]);
            mViewHolder.labImage.setImageResource(images[position]);

        return customView;
    }
    static class ViewHolder{
        ImageView labImage;
        TextView labText;
    }

}
