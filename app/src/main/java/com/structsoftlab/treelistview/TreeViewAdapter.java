package com.structsoftlab.treelistview;  

/*
 Simple project for the Tree List View.
 It is free to use this file and associated files
 for the educational use only as long as this block exist
 unchanged. For the commercial use, 
 contact with auther/developer of this project.
 Developer: Win Aung Cho, winaungcho@gmail.com
 StructSoftLab.com
 30-Nov, 2019
 LICENSE:  https://github.com/winaungcho/TreeListView/blob/master/LICENSE
 */
 
import java.util.ArrayList;
  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.BaseAdapter;  
import android.widget.ImageView;  
import android.widget.TextView;
import android.util.*;  

public class TreeViewAdapter extends BaseAdapter {  
    private ArrayList<TreeItem> tItemsList;  
    private LayoutInflater inflater;
    private int indentSize;  
      
    public TreeViewAdapter(LayoutInflater inflater) {  
        this.tItemsList = TreeItem.rootList();  
        this.inflater = inflater;  
        indentSize = 12;  
    }
      
    public ArrayList<TreeItem> getTitems() {  
        return tItemsList;  
    }  
      
    public ArrayList<TreeItem> getTitemsSource() {  
        return TreeItem.getCollection();  
    }  
      
    @Override  
    public int getCount() {  
        return tItemsList.size();  
    }  
  
    @Override  
    public Object getItem(int position) {  
        return tItemsList.get(position);  
    }  
  
    @Override  
    public long getItemId(int position) {  
        return position;  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {
		
        ViewHolder holder = null;
		TreeItem tItem = tItemsList.get(position);  
        int level = tItem.getLevel();
        if (convertView == null) {  
            holder = new ViewHolder();  
            convertView = inflater.inflate(R.layout.treeview_item, null);  
            holder.disclosureImg = (ImageView) convertView.findViewById(R.id.disclosureImg);  
            holder.contentText = (TextView) convertView.findViewById(R.id.contentText);  
            convertView.setTag(holder);  
        } else {  
            holder = (ViewHolder) convertView.getTag();  
        }  
        
		DisplayMetrics dm = convertView.getResources().getDisplayMetrics();
		if (dm != null){
			float indB = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, indentSize, dm);
			holder.disclosureImg.setPadding(  
				Math.round(indB * (level + 1)),   
                holder.disclosureImg.getPaddingTop(),   
                holder.disclosureImg.getPaddingRight(),   
                holder.disclosureImg.getPaddingBottom());
		}
        holder.contentText.setText(tItem.getname());  
        if (tItem.isHasChildren() && !tItem.isExpanded()) {  
            holder.disclosureImg.setImageResource(R.drawable.open);  
            //Actively set icon visibility here, because convertView may be a reuse of "set invisible" view, the same below.  
            holder.disclosureImg.setVisibility(View.VISIBLE);  
        } else if (tItem.isHasChildren() && tItem.isExpanded()) {  
            holder.disclosureImg.setImageResource(R.drawable.close);  
            holder.disclosureImg.setVisibility(View.VISIBLE);  
        } else if (!tItem.isHasChildren()) {  
            holder.disclosureImg.setImageResource(R.drawable.open);  
            holder.disclosureImg.setVisibility(View.INVISIBLE);  
        }  
        return convertView;  
    }  
      
    static class ViewHolder{  
        ImageView disclosureImg;  
        TextView contentText;  
    }  
}  
