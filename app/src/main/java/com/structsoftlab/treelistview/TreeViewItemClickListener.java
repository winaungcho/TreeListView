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

import android.view.View;  
import android.widget.AdapterView;  
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;  

public class TreeViewItemClickListener implements OnItemClickListener {  
    /** adapter */  
    private TreeViewAdapter treeViewAdapter;  

    public TreeViewItemClickListener(TreeViewAdapter treeViewAdapter) {  
        this.treeViewAdapter = treeViewAdapter;  
    }  

    @Override  
    public void onItemClick(AdapterView<?> parent, View view, int position,  
							long id) {  
        TreeItem tItem = (TreeItem) treeViewAdapter.getItem(position);  
        ArrayList<TreeItem> tItemList = treeViewAdapter.getTitems();  
        //TreeItem data source  
        ArrayList<TreeItem> tItemSource = treeViewAdapter.getTitemsSource();  

        //Click on item without subitem to return value  
        if (!tItem.isHasChildren()){
			Toast.makeText(parent.getContext(), "Clicked on: "+tItem.getname(), Toast.LENGTH_SHORT).show();
            return;  
        }  

        if (tItem.isExpanded()) {  
            tItem.setExpanded(false);  
            
            ArrayList<TreeItem> tItemsToDel = new ArrayList<TreeItem>();  
            for (int i = position + 1; i < tItemList.size(); i++) {  
				if (tItem.getLevel() >= tItemList.get(i).getLevel())  
                    break;  
				tItemsToDel.add(tItemList.get(i));
            }  
            tItemList.removeAll(tItemsToDel);  
            treeViewAdapter.notifyDataSetChanged();  
        } else {  
            tItem.setExpanded(true);  
            
            int i = 1;
            for (TreeItem e : tItemSource) {  
                if (e.getParent() == tItem) {  
                    e.setExpanded(false);  
					tItemList.add(position + i, e);
                    i ++;  
                }  
            }  
            treeViewAdapter.notifyDataSetChanged();  
        }  
    }  
}  
