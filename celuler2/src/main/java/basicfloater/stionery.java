package basicfloater;

import infostruct1.cellmap.cell;

public class stionery extends cell {
    public stionery(int x,int y){
        super(x,y, (byte) 100, (byte) 100, (byte) 100);
        apllers.add(new sttioneryR());
    }
}
