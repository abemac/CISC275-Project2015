package misc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundDoer {
	
	private ArrayList<Clip> clips;
	private  AudioInputStream in;
	private Clip audioClip;
	private ArrayList<Clip>loadedClips;
	
	public SoundDoer(){
		clips = new ArrayList<Clip>();
		loadedClips = new ArrayList<Clip>();
	}
	
	
	
	
	
	
	public void loadClip(String path){
		try{
			
				in = AudioSystem.getAudioInputStream(getClass().getResource(path));
				Clip audioClip = AudioSystem.getClip();
				audioClip.open(in);
				loadedClips.add(audioClip);
			}
		catch(Exception e){
			e.printStackTrace();
		
			
		}
	}
	
	public void playLoadedSound(int index){
		loadedClips.get(index).setFramePosition(0);
		loadedClips.get(index).start();
		
	}

	
	public void playSound(String path){
		try{
			
			
			if(clips.size()<4){
				in = AudioSystem.getAudioInputStream(getClass().getResource(path));
				audioClip = AudioSystem.getClip();
				audioClip.open(in);
				audioClip.start();
				clips.add(audioClip);
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}
	}
	
	public void stopSound(){
		if(clips.size()>0){
			audioClip.stop();
			audioClip.flush();
			audioClip.close();
			try {
				in.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		for(int i=0; i<clips.size();i++){
			clips.get(i).stop();
			clips.get(i).flush();
			clips.get(i).close();
		}
		
		clips.clear();
		
	
	
	}
	
	public void stopSound(int index){
		
		
		
			clips.get(index).stop();
			clips.get(index).flush();
			clips.get(index).close();
		
		
			clips.set(index, null);
		
		try {
			in.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	
	}

	
	
}