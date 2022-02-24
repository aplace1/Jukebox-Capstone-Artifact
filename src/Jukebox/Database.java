package Jukebox;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.LinkedList;
import java.util.Random;


/**
 * Call to Handle retrieving dbSongs from a MongoDB database.
 *
 * @implNote See 'Config.java' for string resources
 */
public class Database {

    private final Random random = new Random();
    private static boolean connected = false;


    /**
     * Container for dbSongs within the database
     */
    final LinkedList<Document> dbSongs = new LinkedList<>();

    /**
     * Fields used in the MongoDB database
     */
    public static final String DB_ID_FIELD = "id", ARTIST_FIELD = "artist", SONG_FIELD = "song", GENRE_FIELD = "genre";

    /**
     * Create a new client connection through the connection string
     */
    private MongoClient client;


    /**
     * Create a new Database Object and then connect the client
     */
    private static MongoDatabase db;


    /**
     * Retrieve the collection from the database in MonoDB
     *
     * @implNote See 'Config.java' for string resources
     */
    protected static MongoCollection<Document> collection;


    /**
     * Default Constructor, Connect using the default strings
     */
    Database() {
        if (connected) return;
        Database.connected = true;

        client = MongoClients.create(Config.dbConnectionString);
        db = client.getDatabase(Config.dbString);
        collection = db.getCollection(Config.dbCollection);
    }

    /**
     * Overloaded constructor - Connect using a connection string and database string.
     *
     * @param connectionString  MongoDB client connection specifier.
     * @param databaseString    MongoDB database specifier.
     */
    @SuppressWarnings("unused")
    Database(String connectionString, String databaseString, String collectionString) {
        if (connected) return;
        if (connectionString == null || databaseString == null || collectionString == null) {
            throw new IllegalArgumentException("At least of DB connection string is null.");
        }

        client = MongoClients.create(connectionString);
        db = client.getDatabase(databaseString);
        collection = db.getCollection(collectionString);
        Database.connected = true;
    }

    /**
     * Retrieves a document from a database containing 9,000 dummy records. (pun)
     *
     * @return The random document from MongoDB
     * @implNote See 'Config.java' for string resources
     */
    public Document getRandomDocument() {
        var randomDocument = collection.find(new Document(DB_ID_FIELD, random.nextInt(Config.DUMMY_RECORD_TOTAL))).first();
        dbSongs.add(randomDocument);
        return (randomDocument);
    }
}
