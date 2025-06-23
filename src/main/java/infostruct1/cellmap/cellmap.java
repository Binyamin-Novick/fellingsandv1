package infostruct1.cellmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;



public class cellmap {

    List<viewC>Vcells=new ArrayList<>();
    HashMap<Integer,HashMap<Integer,cell>>curnet=new HashMap<Integer, HashMap<Integer, cell>>();
    HashMap<Integer,HashMap<Integer,cell>>futer=new HashMap<Integer, HashMap<Integer, cell>>();

    public boolean addcell(cell ce){
    if(checklock(ce.x,ce.y)){
        placeif(ce);

        return true;
    }

        return false;
    }
    public boolean tryNextStep(){
        for (Integer i:curnet.keySet()){
            curnet.get(i).values().stream().peek((x)->x.apply()).collect(Collectors.toList());
        }
        return true;
    }
    public synchronized boolean resolve(){
        curnet=futer;
        Vcells=new ArrayList<>();
        curnet.values().stream().map((x)->x.values().stream().parallel().map((f->f.view())).collect(Collectors.toList())).peek((d)-> Vcells.addAll(d)).collect(Collectors.toList());
        futer=new HashMap<Integer, HashMap<Integer, cell>>();
        return true;
    }
    public void removecell(int x, int y){
        if(!checklock(x,y)){
            if(x>=0&&y>=0){
                futer.get(y).remove(x);
            }
        }

    }
    public synchronized List<viewC>View(){
        return new ArrayList<>(Vcells);
    }
    public boolean checklock(int x,int y){
        if(x<0||y<0)
            return false;
        if(futer.get(y)!=null)if(futer.get(y).get(x)!=null)return false;
        return true;
    }
    private synchronized void placeif(cell c){
        if(futer.get(c.y)==null){
            futer.put(c.y,new HashMap<Integer, cell>());

        }
        futer.get(c.y).put(c.x,c);
        c.setw(this);
    }
    private void placepace(cell c){
        if(curnet.get(c.y)==null){
            curnet.put(c.y,new HashMap<Integer, cell>());

        }
        curnet.get(c.y).put(c.x,c);
    }





}
