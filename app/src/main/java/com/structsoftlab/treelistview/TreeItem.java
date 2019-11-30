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
import java.util.*;  

public class TreeItem {
    private String name;
    private boolean isExpanded;
    private int id;
	TreeItem parent;
    private boolean hasChildren;

    public static final int TOP_LEVEL = 0;  
    private static int AUTOID = 0;
	private static ArrayList<TreeItem> elementsData=new ArrayList<TreeItem>();
	
	public TreeItem(String name){
		this.name = name;  
        this.id = AUTOID++;
		this.parent = null;
        this.hasChildren = false;  
        this.isExpanded = false;
		elementsData.add(this);
	}
    
	public static ArrayList<TreeItem> getCollection(){
		return elementsData;
	}
	public static ArrayList<TreeItem> rootList(){
		ArrayList<TreeItem> root = new ArrayList<TreeItem>();
		for (TreeItem item : elementsData){
			if (item.getParent() == null)
				root.add(item);
		}
		return root;
	}
	public TreeItem setChild(TreeItem child){
		child.parent = this;
		setHasChildren(true);
		return child;
	}
	public TreeItem setParent(TreeItem p){
		this.parent = p;
		p.setHasChildren(true);
		return p;
	}
	public TreeItem getParent(){
		return this.parent;
	}
    public boolean isExpanded() {  
        return isExpanded;  
    }  
  
    public void setExpanded(boolean isExpanded) {  
        this.isExpanded = isExpanded;  
    }  
  
    public String getname() {  
        return name;  
    }  
  
    public void setname(String name) {  
        this.name = name;  
    }  
  
    public int getLevel() {
		if (parent == null)
			return TOP_LEVEL;
		return parent.getLevel()+1;
    }  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
 
    public boolean isHasChildren() {  
        return hasChildren;  
    }  
  
    public void setHasChildren(boolean hasChildren) {  
        this.hasChildren = hasChildren;  
    }  
}  
