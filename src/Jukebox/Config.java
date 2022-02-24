package Jukebox;

/**
 * Configurations and resources for the JFrame.
 */
public final class Config {


    public static final String dbConnectionString =
            "mongodb://" +                   // MongoDB's connection string
                    "user:user" +            // username and password (Yes, hardcoded and default read)
                    "@localhost:27017/?" +   // host and port number
                    "authSource=music" +     // database source
                    "&appname=JukeBoxUser";  // change the application name


    // MongoDB's database, and collection targets. ex: "music.playlists"
    public static final String dbString = "music";
    public static final String dbCollection = "playlists";
    public static final int MAX_PLAYLIST_SIZE = 12;

    public static final int DUMMY_RECORD_TOTAL = 9000; // Used during random Number calculation

    // Frame Title
    public static final String jFrameTitle = "*Silent* Audio Player -- Prototype";

    // Frame width and height
    public static final int jFrameWidth = 500;
    public static final int jFrameHeight = 600;


    // Button Text
    public static final String nextButtonText = "Next";
    public static final String backButtonText = "Previous Song";
    public static final String shuffleButtonText = "Shuffle";

    // Resource folder containing images
    public static final String RES_PATH = "/res/";
    public static final String IMG_DEFAULT = "default.jpg";

    // Default Slide text
    public static final String defaultSlideTitle = "Default Artist Name";
    public static final String defaultSlideDescription = "Default Song Name";

    // Pre-Formatted string for
    public static final String LocationSlideText = "<html><font>%s" + "</font><br>%s</html>";

    // This is the image tag, it's broken into three separate strings
    public static final String IMG_START =
            "<html><body style='body{margin:0;}'><img width='100%' height='100%' src='";
    public static final String IMG_RES = "%s%s";  // {image} {.jpg}
    public static final String IMG_STOP = "'/></body></html>";

    // Simplified for the default image.
    public static final String HTML_DEFAULT_IMAGE = (IMG_START + IMG_DEFAULT + IMG_STOP);

}
