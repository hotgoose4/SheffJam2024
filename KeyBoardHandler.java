import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardHandler implements KeyListener {
    boolean w, a, s, d, space;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                w = true;
                break;
            case KeyEvent.VK_A:
                a = true;
                break;
            case KeyEvent.VK_S:
                s = true;
                break;
            case KeyEvent.VK_D:
                d = true;
                break;
            case KeyEvent.VK_SPACE:
                space = !space;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                w = false;
                break;
            case KeyEvent.VK_A:
                a = false;
                break;
            case KeyEvent.VK_S:
                s = false;
                break;
            case KeyEvent.VK_D:
                d = false;
                break;
        }

    }
    
}
