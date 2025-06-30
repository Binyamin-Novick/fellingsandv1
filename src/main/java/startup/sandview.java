package startup;

import basicfloater.stionery;
import basicsand.sandc;
import infostruct1.cellmap.cellmap;
import infostruct1.cellmap.viewC;
import startup.water.watercell;
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
        bp.SCALE=10;
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
                    x = (bp.getWidth()-e.getX()) / bp.SCALE; // if using scale like 10 pixels per cell
                    y = (bp.getHeight()- e.getY()) / bp.SCALE;
                    mousedown=1;


                }
                if(SwingUtilities.isRightMouseButton(e)){
                    x = (bp.getWidth()-e.getX()) / bp.SCALE; // if using scale like 10 pixels per cell
                    y = (bp.getHeight()- e.getY()) / bp.SCALE;
                    mousedown=2;
                }
            }
        });
    Boolean b=true;
    int i=0;
    Timer t = new Timer(16,(e -> {bp.loadcells(cm.View());
        bp.repaint();}));
        t.start();
        while (true){
            sleep(20);


            if(x!=null)
                if(y!=null){
                    if(mousedown==1)
                        cm.addcell(new watercell(x,y));
                    if(mousedown==2){
                        cm.addcell(new stionery(x,y));
                    }
                }
            i++;
            if(i%7==6){

                cm.addcell(new sandc((40)*(10/ bp.SCALE),(40)*(10/ bp.SCALE)));
                i=0;

            }
            cm.tryNextStep();
            cm.resolve();

        }
    }
}
