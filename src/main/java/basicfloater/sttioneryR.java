package basicfloater;

import infostruct1.cellmap.applyer;
import infostruct1.cellmap.cell;

public class sttioneryR extends applyer {
    @Override
    public void apply(cell c) {
        c.cem.addcell(c);
    }
}
