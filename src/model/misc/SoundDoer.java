package model.misc;

import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundDoer {
	
	private ArrayList<Clip>loadedClips;
	private float gain=0.0f;
	
	public SoundDoer(){
		loadedClips = new ArrayList<Clip>();
	}
	

	public void loadClip(String path){
		try{
			
				AudioInputStream in = AudioSystem.getAudioInputStream(getClass().getResource(path));
				Clip audioClip = AudioSystem.getClip();
				audioClip.open(in);
				loadedClips.add(audioClip);
			}
		catch(Exception e){
			e.printStackTrace();
		
			
		}
	}
	
	public void playLoadedClip(int index){
		loadedClips.get(index).setFramePosition(0);
		loadedClips.get(index).start();
		
	}

	
	public void stopAllSoundAndReleaseResources(){
		for(int i=0; i<loadedClips.size();i++){
			loadedClips.get(i).stop();
			loadedClips.get(i).flush();
			loadedClips.get(i).close();
		}
		
		loadedClips.clear();
		
	
	
	}
	
	public void setClipVolume(int index,float amt){
		FloatControl fc = (FloatControl) loadedClips.get(index).getControl(FloatControl.Type.MASTER_GAIN);
		fc.setValue(amt);
	}
	
	
	/**
	 * returns true if the fade has completed, false otherwise.  Only fade out 1 clip at a time! (or change this method)
	 * @param index
	 * @return
	 */
	public boolean fadeOutFast(int index){
		FloatControl fc = (FloatControl) loadedClips.get(index).getControl(FloatControl.Type.MASTER_GAIN);
		if(gain>-70){
			gain-=10;
			fc.setValue(gain);
		}else{
			stopClip(index);
			gain=0.0f;
			return true;
		}
		return false;
	}
	
	
	/*
	public boolean fadeOutSlow(int index){
		FloatControl fc = (FloatControl) loadedClips.get(index).getControl(FloatControl.Type.MASTER_GAIN);
		
		Thread t = new Thread(new Runnable() {
			private long lastTime;
			private long now;
			@Override
			public void run() {
				while(gain>-70){
					fc.setValue(gain);
					gain-=.00001;
					
					lastTime=System.nanoTime();
					lastTime=now;
					while(now-lastTime<1000){
						now=System.nanoTime();
					}
					
				}
				gain=0.0f;
				stopClip(index);
				
			}
		});
		
		t.start();
		return true;
		
	}
	*/
	public void stopClip(int index){
		loadedClips.get(index).stop();
	    loadedClips.get(index).flush();
		
	}
	
	public boolean isDone(int index){
		return !loadedClips.get(index).isActive();
	}

	
	

}