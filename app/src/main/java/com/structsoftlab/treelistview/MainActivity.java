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
  
import android.os.Bundle;  
import android.app.Activity;  
import android.content.Context;  
import android.view.LayoutInflater;  
import android.view.Menu;  
import android.widget.ListView;  
import com.structsoftlab.treelistview.TreeItem;
import android.view.*;

public class MainActivity extends Activity { 
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
          
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        init();  
          
        ListView treeview = (ListView) findViewById(R.id.treeview);  
        TreeViewAdapter treeViewAdapter = new TreeViewAdapter(inflater);  
        TreeViewItemClickListener treeViewItemClickListener = new TreeViewItemClickListener(treeViewAdapter);  
        treeview.setAdapter(treeViewAdapter);  
        treeview.setOnItemClickListener(treeViewItemClickListener);  
    }  
    
    private void init() {  
        TreeItem e1 = new TreeItem("Ayeyar Waddy Division");
        TreeItem e2 = new TreeItem("Myaung Mya Town");
        TreeItem e3 = new TreeItem("U Ba Cho Street");
        TreeItem e4 = new TreeItem("Pan Swel Daw");
        e1.setChild(e2);
		e2.setChild(e3);
		e3.setChild(e4);
		
        TreeItem e5 = new TreeItem("Wakhema Town");
        TreeItem e6 = new TreeItem("Saryaekone");
        TreeItem e7 = new TreeItem("Myue Yone Street"); 
        e1.setChild(e5);
		e5.setChild(e6);
		e6.setChild(e7);
        TreeItem e8 = new TreeItem("Labutta Town"); 
        e1.setChild(e8);
        //Add outermost nodes  
        TreeItem e9 = new TreeItem("Shan State"); 
        TreeItem e10 = new TreeItem("Taunggyi City"); 
        TreeItem e11 = new TreeItem("Yeaye Kwin Quarter"); 
        TreeItem e12 = new TreeItem("Sangyi Aung Street"); 
        TreeItem e13 = new TreeItem("No. 6/12"); 
        e9.setChild(e10);
		e10.setChild(e11);
		e11.setChild(e12);
		e12.setChild(e13);
		TreeItem f1 = new TreeItem("Yangon");
		TreeItem f2 = new TreeItem("Hlaing");
		TreeItem f3 = new TreeItem("Kamaryut");
		TreeItem f4 = new TreeItem("Aye Yeik Mon");
		TreeItem f5 = new TreeItem("Block6/002");
		TreeItem f6 = new TreeItem("Hanthar Yeik Mon");
		TreeItem f7 = new TreeItem("B/001");
		TreeItem f8 = new TreeItem("C/002");
		TreeItem f9 = new TreeItem("Block6/001");
		f1.setChild(f2);
		f1.setChild(f3);
		f2.setChild(f4);
		f4.setChild(f5);
		f4.setChild(f9);
		f3.setChild(f6);
		f6.setChild(f7);
		f6.setChild(f8);
    }  
  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.activity_main, menu);  
        return true;  
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        int id = item.getItemId();
		if (id == R.id.menu_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}  
