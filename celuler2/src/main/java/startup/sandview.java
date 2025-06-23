package startup;

import basicfloater.stionery;
import basicsand.sandc;
import infostruct1.cellmap.cellmap;
import infostruct1.cellmap.viewC;
import vizials.bordpanele;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class sandview {
    public static Boolean b=true;
    public static int mousedown=0;
    public static Integer x;
    public static Integer y;
    public static  void main(String[] args) throws InterruptedException {
        cellmap cm=new cellmap();
        bordpanele bp = new bordpanele();
        List<viewC> viewCList=new ArrayList<>();

        bp.loadcells(viewCList);
        JFrame frame = new JFrame("Cell RGB Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        bp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mousedown = 0;

                // Handle release logic
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    x = (bp.getWidth()-e.getX()) / 4; // if using scale like 10 pixels per cell
                    y = (bp.getHeight()- e.getY()) / 4;
                    mousedown=1;


                }
                if(SwingUtilities.isRightMouseButton(e)){
                    x = (bp.getWidth()-e.getX()) / 4; // if using scale like 10 pixels per cell
                    y = (bp.getHeight()- e.getY()) / 4;
                    mousedown=2;
                }
            }
        });
    Boolean b=true;
    int i=0;
        while (true){
            sleep(16);
            if(x!=null)
                if(y!=null){
                    if(mousedown==1)
                        cm.addcell(new sandc(x,y));
                    if(mousedown==2){
                        cm.addcell(new stionery(x,y));
                    }
                }
            i++;
            if(i%4==3){
                cm.addcell(new sandc(100,100));
                i=0;

            }
            cm.tryNextStep();
            cm.resolve();
            bp.loadcells(cm.View());
            bp.repaint();
        }
    }
}
