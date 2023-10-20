package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Game.GamePanel;
import Game.Paddle;

public class MouseInput implements MouseListener, MouseMotionListener {

	public int x;
	private GamePanel gamePanel;
	public boolean isMouseMoved;
	
	public MouseInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	public int getXCord(int width) {
		if(x <= width / 2)
			return 0;
		if(x >= gamePanel.width - width / 2)
			return (gamePanel.width - width);
		return x - width / 2;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		isMouseMoved = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicled");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

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
