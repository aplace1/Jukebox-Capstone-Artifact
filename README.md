# Jukebox

## Capstone Project

### About the project

This project was created as an enhancement for two separate projects combined.

One of the projects was a text based jukebox, and the other was a Slideshow using Java.AWT and Swing.

### Notes:

The user cannot actually create a playlist, simply queue pseudo-randomly selected songs.

The data-structure used is a `circular doubly linked list`.

## Enhancement list:

- Program utilizes an external data-source for information about playlists
- Ability to traverse forwards and backwards between songs.
- Ability to Change playlists while a the current playlist hasn't finished.
- Ability to view artwork based on the genre of the song.

## Requirements:
- **MongoDB**
- Java


### Database:

Most of the project functionality can be changed through the `Config.java` file.
Here you will find Strings for JLabels and JButtons, along with the MongoDB
connection string.


## The configuration:


MongoDB Scheme:

Note: 'genre' determines the cover art for a song.
```json
{
   "id"     : 0,
   "artist" : "name of the artist",
   "song"   : "title of song",
   "genre"  : "Rock"
}
```


Within the `config.java` file:

```java
// The username and password are hard-coded, However, the user is limited to
// predefined buttons.
public static final String dbConnectionString =
  "mongodb://" +          // MongoDB's connection string
  "user:user" +           // username and password
  "@localhost:27017/?" +  // host and port number
  "authSource=music" +    // database source
  "&appname=JukeBoxUser"; // change the application name


// MongoDB's database, and collection targets.
// ex: "music.playlists"
public static final String
  dbString = "music",
  dbCollection = "playlists";

// configure the max size of a playlist.
public static final int MAX_PLAYLIST_SIZE = 12;


// Playlists are randomly generated by querying by random ID's
// This is where the count of records should be.
public static final int DUMMY_RECORD_TOTAL = 1000;
```


Within the `database.java` file:

```java
public static final String
    DB_ID_FIELD = "id",
    ARTIST_FIELD = "artist",
    SONG_FIELD = "song",
    GENRE_FIELD = "genre";
```
