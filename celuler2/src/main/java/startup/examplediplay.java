package startup;

import infostruct1.cellmap.viewC;
import vizials.bordpanele;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class examplediplay {
    public static void main(String[] args) {
        bordpanele bp = new bordpanele();
        List<viewC> viewCList=new ArrayList<>();
        for (int i=0;i<80;i++){
            if(i%2==0){
                viewCList.add(new viewC(i,i, (byte) 100, (byte) 100, (byte) 100));

            }
        }
        bp.loadcells(viewCList);
        JFrame frame = new JFrame("Cell RGB Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(bp);
        frame.pack();
        frame.setVisible(true);

    }
}

