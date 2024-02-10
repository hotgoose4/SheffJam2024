import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener{
    boolean left;

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                left = true;
                break;

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                left = false;
                break;
                
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}
