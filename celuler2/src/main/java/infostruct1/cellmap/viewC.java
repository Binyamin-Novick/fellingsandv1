package infostruct1.cellmap;

import java.awt.*;

public class viewC {
    byte r;
    byte b;
    byte g;
    public int x;
   public int y;

    public viewC(int x,int y,byte r,byte g,byte b){
        this.x=x;
        this.y=y;
        this.r=r;
        this.b=b;
        this.g=g;
    }
    public Color getColor(){
        return new Color(Byte.toUnsignedInt(r),Byte.toUnsignedInt(g),Byte.toUnsignedInt(b));
    }
}
