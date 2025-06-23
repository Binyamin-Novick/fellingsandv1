package vizials;

import infostruct1.cellmap.viewC;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class bordpanele extends JPanel {
    private final int SCALE = 4;
    BufferedImage bufferidimge;
    public bordpanele(){
        setPreferredSize(new Dimension(800,600));
        bufferidimge =new BufferedImage(800,600,BufferedImage.TYPE_3BYTE_BGR);
    }
    public bordpanele(int x,int y){
        setPreferredSize(new Dimension(x,y));
        bufferidimge =new BufferedImage(x,y,BufferedImage.TYPE_3BYTE_BGR);
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if (bufferidimge != null) {
            graphics.drawImage(bufferidimge, 0, 0, null);
        }

    }
    public void loadcells(List<viewC> cells){
        Graphics2D g2d = bufferidimge.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, bufferidimge.getWidth(), bufferidimge.getHeight());
        for (viewC cell : cells) {
            if(cell==null){
                System.out.println("ssz");
            }else {
            int drawX = (super.getSize().width -cell.x * SCALE);
            int drawY = (super.getSize().height-cell.y * SCALE);
            g2d.setColor(cell.getColor());
            g2d.fillRect(drawX, drawY, SCALE, SCALE);}}

        g2d.dispose();
    }
}
