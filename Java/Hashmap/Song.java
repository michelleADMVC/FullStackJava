public class Song {
	
	private String title;
	private String lyrics;
	private int duration;
	
	
	public Song(String title, String lyrics, int duration) {
		this.title = title;
		this.lyrics = lyrics;
		this.duration = duration;
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getLyrics() {
		return this.lyrics;
	}
	public int getDuration() {
		return this.duration;
	}
}
