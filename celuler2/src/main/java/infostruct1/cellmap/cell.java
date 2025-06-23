package infostruct1.cellmap;

import java.util.ArrayList;
import java.util.List;

public class cell {
     public int x,y;
     byte r,g,b;
    public cell(int x,int y,byte r,byte g,byte b){
        this.y=y;
        this.x=x;
        this.r=r;
        this.g=g;
        this.b=b;
    }
    public cellmap cem;
    public List<applyer>apllers=new ArrayList<applyer>();
    public void setw(cellmap cellmap){
        cem=cellmap;
    }

    public void apply(){
        for (applyer ap :apllers)ap.apply(this);
    }

    public viewC view(){
        return new viewC(x,y,r,g,b);
    }
}
