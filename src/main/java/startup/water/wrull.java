package startup.water;

import infostruct1.cellmap.applyer;
import infostruct1.cellmap.cell;

import java.util.Random;

public class wrull extends applyer {
    boolean push=false;
    Random random =new Random();
    @Override
    public void apply(cell c) {

        if(c.cem.checklock(c.x,c.y-1)){
            c.y--;
            c.cem.addcell(c);

        }else {
            Boolean b =random.nextBoolean() ;
            check(b,c,0);
        }}

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
            side(b,c,0);
        }
    }

    private void side(boolean b,cell c, int i){
        if(i<2) {
            if (!c.cem.checkpast(c.x + 1, c.y + 1) || !c.cem.checkpast(c.x - 1, c.y + 1) || !c.cem.checkpast(c.x, c.y + 1)||push) {
                if (b)
                    if (c.cem.checkpast(c.x + 1, c.y)&&c.cem.checklock(c.x+1,c.y)) {
                        c.x++;
                        push=false;
                        c.cem.addcell(c);
                    } else {
                        side(!b, c, i + 1);
                    }
                else if (c.cem.checkpast(c.x - 1, c.y)&&c.cem.checklock(c.x-1,c.y)) {
                    c.x--;
                    push=false;
                    c.cem.addcell(c);
                } else {

                    side(!b, c, i + 1);
                }

            }else {
                c.cem.addcell(c);
                return;
            }

        }else {
            if(c.cem.getcell(c.x-1,c.y)!=null){
                if(c.cem.getcell(c.x-1,c.y) instanceof watercell){
                    ((wrull)((watercell)c.cem.getcell(c.x-1,c.y)).apllers.get(0)).push=true;
                }
            }
            if(c.cem.getcell(c.x+1,c.y)!=null){
                if(c.cem.getcell(c.x+1,c.y) instanceof watercell){
                    ((wrull)((watercell)c.cem.getcell(c.x+1,c.y)).apllers.get(0)).push=true;
                }
            }
            c.cem.addcell(c);
            return;
        }
        push=false;
    }
}
