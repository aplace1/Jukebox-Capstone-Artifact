package Jukebox;

import java.util.LinkedList;

import static Jukebox.Config.MAX_PLAYLIST_SIZE;
import static Jukebox.Song.setCoverArtResource;
import static Jukebox.Song.setDescription;

public class PlaylistManager {

    /**
     * The database which queries our songs for each playlist
     */
    private static final Database db = new Database();


    /**
     * The playlist that contains our slides or songs.
     */
    private static final LinkedList<Song> playlist = new LinkedList<>();


    /**
     * Return the playlist of songs
     *
     * @return The playlist.
     */
    private static LinkedList<Song> getPlaylist() {
        return playlist;
    }


    /**
     * Clear this playlist, clear the db.dbSongs
     */
    public static void nextPlaylist() {
        playlist.clear();
        db.dbSongs.clear();
        for (var i = 0; i <= MAX_PLAYLIST_SIZE; i++) {
            db.getRandomDocument();
            getSongFromDB();
        }
    }

    
    /**
     * Assign the corresponding database values and image based on
     * the artist, the song, and the genre.
     */
    public static void getSongFromDB() {
        var songData = db.getRandomDocument();
        var nextSong = new Song();
        nextSong.setTitle(songData.getString(Database.ARTIST_FIELD.trim()));
        setDescription(songData.getString(Database.SONG_FIELD.trim()));
        setCoverArtResource(songData.getString(Database.GENRE_FIELD.trim()));
        playlist.add(nextSong);
    }
}