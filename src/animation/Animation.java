package animation;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import misc.Renderable;
import misc.Tickable;

public abstract class Animation implements Tickable,Renderable,Serializable,MouseListener,KeyListener,MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3771099594735929962L;
	private boolean sendSignal=false;
	private boolean isDone;
	
	
	public boolean isDone(){
		return isDone;
	}
	
	public void setIsDone(boolean b){
		isDone=b;
	}
	public void sendStopSignal(){
		sendSignal=true;
	}
	
	public boolean sentStopSignal(){
		return sendSignal;
	}
	
	
}
