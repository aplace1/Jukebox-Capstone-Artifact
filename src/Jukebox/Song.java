package Jukebox;

public class Song {

    /**
     * The Title of the slide as a String
     */
    private static String title = Config.defaultSlideTitle;

    /**
     * The Description of a slide as a String
     */
    private static String description = Config.defaultSlideDescription;


    /**
     * The name and extension of an image
     * Ex: "cats.jpg"
     */
    private static  String coverArtResource = Config.IMG_DEFAULT;

    /**
     * Constructs a new PlaylistEntry object.
     */
    Song() {
        title = Config.defaultSlideTitle;
        description = Config.defaultSlideDescription;
    }

    /**
     * Constructs a new instance.
     *
     * @param title       The title
     * @param description The description of the slide
     * @param imageSource The name of the image file to be displayed.
     */
    public Song(String title, String description, String imageSource)  {
        Song.title = title;
        Song.description = description;
        coverArtResource = imageSource;
    }

    /**
     * Constructor -- title and description
     * @param title        Title of the song
     * @param description  Description of song
     */
    public Song(String title, String description){
        Song.title = title;
        Song.description = description;
    }

    /**
     * Gets the title.
     *
     * @return Title for the slide.
     */
    public static String getTitle() {
        return Song.title;
    }

    /**
     * Sets the title of a slide.
     *
     * @param title The slide title
     */
    public void setTitle(String title) {
        if (title != null) {
            Song.title = title;
        }
    }

    /**
     * Gets the description.
     *
     * @return Description for the slide.
     */
    static public String getDescription() {
        return Song.description;
    }

    /**
     * Sets the description.
     *
     * @param description The description
     */
    static public void setDescription(String description) {
        if (description != null) {
            Song.description = description;
        }
    }

    /**
     * Gets the preview.
     *
     * @return The image name and extension
     */
    public static String getPreview() {
        return coverArtResource;
    }

    /**
     * Sets the image name.
     *
     * @param res The image name
     */
    public static void setCoverArtResource(String res) {
        switch (res.trim()) {
            case "Pop" -> Song.coverArtResource = ("Pop.png");
            case "Acoustic" -> Song.coverArtResource = ("DrumBase.png");
            case "Blues" -> Song.coverArtResource = ("Blues.png");
            case "Latin" -> Song.coverArtResource = ("Latin.png");
            case "Techno" -> Song.coverArtResource = ("Techno.png");
            case "Rock" -> Song.coverArtResource = ("Rock.png");
            case "House" -> Song.coverArtResource = ("House.png");
            case "Baroque" -> Song.coverArtResource = ("Baroque.png");
            default -> Song.coverArtResource = ("etc.png");
        }
    }
}