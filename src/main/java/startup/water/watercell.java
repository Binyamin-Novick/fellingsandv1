package startup.water;

import infostruct1.cellmap.cell;

public class watercell extends cell {
    public watercell(int x, int y) {
        super(x, y, (byte) 22, (byte) 44, (byte) 252);
        super.apllers.add(new wrull());
    }
}
