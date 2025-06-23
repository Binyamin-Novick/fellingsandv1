package basicsand;

import infostruct1.cellmap.applyer;
import infostruct1.cellmap.cell;

import java.util.Random;

public class Sap extends applyer {
    int i=0;
    Random random=new Random();
    public void apply(cell c) { if(i<3000){
        i++;
        if(c.cem.checklock(c.x,c.y-1)){
            c.y--;
            c.cem.addcell(c);

        }else {
           Boolean b =random.nextBoolean() ;
           check(b,c,0);
        }}
    }
    private void check(boolean b,cell c,int i){
        if(i<2){
            if(b){
               if(c.cem.checklock(c.x-1,c.y-1)){
                   c.x--;c.y--;
                   c.cem.addcell(c);
               }else {
                   check(!b,c,i+1);
               }
            }else {
                if(c.cem.checklock(c.x+1,c.y-1)){
                    c.x++;c.y--;
                    c.cem.addcell(c);
                }else {
                    check(!b,c,i+1);
                }
            }
        }
        else {
            c.cem.addcell(c);
        }
    }
}
