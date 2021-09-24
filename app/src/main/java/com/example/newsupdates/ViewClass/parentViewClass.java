package com.example.newsupdates.ViewClass;

import com.example.newsupdates.ResponseNews;

import java.util.List;


public class parentViewClass {
    String category;
    List<ChildViewClass> Childlist;
    public parentViewClass(String category, List<ChildViewClass> list) {
         this.Childlist=list;
        this.category = category;
    }

    public List<ChildViewClass> getChildList() {
        return Childlist;
    }

    public void setChildList(List<ChildViewClass> list) {
        this.Childlist = list;
    }

    public String getCategory() {
        return category;
    }

    public void setTextView(String textView) {
        this.category= textView;
    }
}
