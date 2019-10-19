package com.linx.test.mode.IteratorPattern;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator{
    ArrayList<MenuItem> items;
    int position=0;

    public PancakeHouseIterator(ArrayList<MenuItem> items){
        this.items=items;
    }

    @Override
    public boolean hasNext() {
        if(position>items.size()-1 || items.get(position)==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem item=items.get(position);
        position=position+1;
        return item;
    }
}
