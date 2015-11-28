package misc;

import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundDoer {
	
	private ArrayList<Clip>loadedClips;
	
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
	
//	public void decreaseClipVolume(int index){
//		FloatControl fc = (FloatControl) loadedClips.get(index).getControl(FloatControl.Type.MASTER_GAIN);
//		for(int i=0;i<20;i++){
//			fc.setValue(-i);
//		}
//	}
	
	public void stopClip(int index){
		loadedClips.get(index).stop();
	    loadedClips.get(index).flush();
		
		
	
	}
	
	public boolean isDone(int index){
		return !loadedClips.get(index).isActive();
	}

	
	

}