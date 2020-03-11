import java.util.HashMap;
public class Tracklist {
	
	HashMap<String, Song> Songs = new HashMap<String, Song>();
	
	public Tracklist() {
		testSongs();
	}

	public void addSong(String title, String lyrics, int duration){
		Song newSong = new Song(title, lyrics, duration);
		Songs.put(title,newSong);
	}
	public void searchSong(String title) {
		System.out.println("Buscando cancion :"+title);
		Song newSong = Songs.get(title);
		showSong(newSong);
	}
	private void showSong(Song song) {
		System.out.println("Titulo de la cancion : "+ song.getTitle());
		System.out.println("Letra de la cancion : \n"+ song.getLyrics());
		System.out.println("Duracion de la cancion : "+ song.getDuration()+ "s");
	}
	private void testSongs() {
		addSong("La mejicana","La marihuana me deja los ojos rojos lorea po loco.\r\n" + 
				"La marihuana me deja los ojos rojos lorea po loco.\r\n" + 
				"La marihuana me deja los ojos rojos lorea po loco.\r\n" + 
				"La marihuana me deja los ojos terrible loco po loco.\r\n" + 
				"\r\n" + 
				"La marihuana me deja los ojos rojos lorea po loco.\r\n" + 
				"La marihuana me deja los ojos rojos lorea po loco.\r\n" + 
				"La marihuana me deja los ojos rojos lorea po loco.\r\n" + 
				"La marihuana me deja los ojos terrible loco po loco.\r\n" + 
				"\r\n" + 
				"Que sarpa conchatumare\r\n" + 
				"soy flaite y la conchatumare\r\n" + 
				"que sarpa conchatumare\r\n" + 
				"soy flaite y la conchatumare",185); 
		addSong("Terrible loco", "A la loca la dejé terrible loca\r\n" + 
				"A la loca la dejé terrible loca\r\n" + 
				"A la loka la deje\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Terrible loca\r\n" + 
				"A la loca la dejé terrible loca\r\n" + 
				"A la loca la dejé terrible loca\r\n" + 
				"A la loca la dejé\r\n" + 
				"Terrible loca\r\n" + 
				"Terrible lokaaa", 231);
		
		addSong("24K Magic","Tonight\r\n" + 
				"I just want to take you higher\r\n" + 
				"Throw your hands up in the sky\r\n" + 
				"Let's set this party off right\r\n" + 
				"Players, put yo' pinky rings up to the moon\r\n" + 
				"Girls, what y'all trying to do?\r\n" + 
				"Twenty four karat magic in the air\r\n" + 
				"Head to toe so player\r\n" + 
				"Look out uh",189);
		
		addSong("Versace on the floor","Let's take our time tonight, girl\r\n" + 
				"Above us all the stars are watchin'\r\n" + 
				"There's no place I'd rather be in this world\r\n" + 
				"Your eyes are where I'm lost in\r\n" + 
				"Underneath the chandelier\r\n" + 
				"We're dancin' all alone\r\n" + 
				"There's no reason to hide\r\n" + 
				"What we're feelin' inside\r\n" + 
				"Right now\r\n" + 
				"So baby let's just turn down the lights\r\n" + 
				"And close the door\r\n" + 
				"Ooh I love that dress\r\n" + 
				"But you won't need it anymore\r\n" + 
				"No you won't need it no more\r\n" + 
				"Let's just kiss 'til we're naked, baby",230);
	}
}