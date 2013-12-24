package org.newdawn.spaceinvaders;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameExtension extends Game implements MouseListener {

	private static final long serialVersionUID = 8394451133447924243L;
	
	/** True if the left mouse key is currently pressed */
	private boolean leftMousePressed = false;
	/** True if the right mouse key is currently pressed */
	private boolean rightMousePressed = false;
	
	public GameExtension() {
		System.out.println("Extension loaded");
		addMouseListener(this);
		setFiringInterval(100);
	}

	public void tryToFire() {
		// check that we have waiting long enough to fire
		if (System.currentTimeMillis() - getLastFire() < getFiringInterval()) {
			return;
		}
		
		// if we waited long enough, create the shot entity, and record the time.
		setLastFire(System.currentTimeMillis());
		ShotEntity shot = new ShotEntity(this,"sprites/shot.gif",getShip().getX()+10,getShip().getY()-30);
		getEntities().add(shot);
		setFirePressed(false);
	}

	@Override
    public void mouseClicked(MouseEvent e) {
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
    	if(e.getButton() == MouseEvent.BUTTON1)
    		setFirePressed(true);
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {
		setFirePressed(false);
    }
}
