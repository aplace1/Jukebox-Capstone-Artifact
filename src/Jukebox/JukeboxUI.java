package Jukebox;

import javax.swing.*;
import java.awt.*;

import static Jukebox.Config.*;

public class JukeboxUI extends JFrame {
    private final JLabel titleText = new JLabel();
    private final JPanel buttonControlFlow = new JPanel();
    private final JButton previousSongButton = new JButton();
    private final JButton nextSongButton = new JButton();
    private final JButton shuffleButton = new JButton();
    private static JPanel slideshowPanel;
    private static JPanel textPanel;
    private static CardLayout cardLayout;
    private static CardLayout cardTextLayout;
    final Container root = getContentPane();

    /**
     * Default Constructor
     */
    public JukeboxUI() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(jFrameWidth, jFrameHeight);
        setTitle(Config.jFrameTitle);
        initComponent();
    }

    /**
     * Gets the title.
     *
     * @param i The index
     * @return The title.
     */
    private String getTitle(int i) {
        return Song.getTitle();
    }

    /**
     * Gets the description.
     *
     * @return The description.
     */
    private String getDescription() {
        return Song.getDescription();
    }

    /**
     * Retrieves the previous card in the list.
     */
    static private void previousCard() {
        cardLayout.previous(slideshowPanel);
        cardTextLayout.previous(textPanel);
    }

    /**
     * Initializes JFrame Window Components
     */
    private void initComponent() {
        cardLayout = new CardLayout();
        cardTextLayout = new CardLayout();

        textPanel = new JPanel();
        textPanel.setBounds(5, 465, getWidth(), 50); //465x600 5px padding
        textPanel.setVisible(true);

        buttonControlFlow.setBackground(Color.darkGray);
        buttonControlFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonControlFlow.add(titleText);
        root.setLayout(new BorderLayout(10, 50));

        // Setting the layouts for the panels
        slideshowPanel = new JPanel();
        slideshowPanel.setLayout(cardLayout);
        textPanel.setLayout(cardTextLayout);
        initializePlaylistComponents();


        // Previous Button settings
        previousSongButton.setText(Config.backButtonText);
        previousSongButton.addActionListener(e -> previousCard());

        // Next Button config
        nextSongButton.setText(Config.nextButtonText);
        nextSongButton.addActionListener(e -> getNextSong());
        shuffleButton.setText(Config.shuffleButtonText);
        shuffleButton.addActionListener(e -> {
            PlaylistManager.nextPlaylist();
            textPanel.removeAll();
            slideshowPanel.removeAll();
            initializePlaylistComponents();
        });

        buttonControlFlow.add(previousSongButton);
        buttonControlFlow.add(nextSongButton);
        buttonControlFlow.add(shuffleButton);

        // set header text
        titleText.setForeground(Color.WHITE);
        root.add(slideshowPanel, BorderLayout.CENTER);
        root.add(textPanel, BorderLayout.SOUTH);
        root.add(buttonControlFlow, BorderLayout.SOUTH);
        root.revalidate();
    }

    /**
     * Initializes playlist components.
     *
     * Called when "shuffle" button is pressed.
     */
    private void initializePlaylistComponents() {
        for (int i = 0; i < MAX_PLAYLIST_SIZE; i++) {
            PlaylistManager.getSongFromDB(); // add the next song
            var boxArt = new JLabel(); // append a new label component (cover-art)
            var songDataLabel = new JLabel(); // append a new label component (song)
            songDataLabel.setText(setSongTextLabels(i));
            boxArt.setText(setCoverArt());

            textPanel.add(songDataLabel, "cardText" + getDescription());
            slideshowPanel.add(boxArt, "card" + getTitle(i));
        }
    }

    /**
     * Next Button Functionality
     */
    private void getNextSong() {
        cardLayout.next(slideshowPanel);
        cardTextLayout.next(textPanel);
    }

    /**
     * Sets the label text.
     *
     * @param i The card index
     * @return HTML output for the slide
     */
    private String setSongTextLabels(int i) {
        return Config.LocationSlideText.formatted(getTitle(i), getDescription());
    }


    /**
     * Sets the image size.
     *
     * @return HTML for the image
     */
    private String setCoverArt() {
        var res = getClass().getResource(IMG_RES.formatted(Config.RES_PATH, Song.getPreview()));
        return (res != null) ? (IMG_START + res + IMG_STOP) : (HTML_DEFAULT_IMAGE);
    }
}
