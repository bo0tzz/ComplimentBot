package me.bo0tzz.complimentbot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by bo0tzz on 21-9-2016.
 */
public class ComplimentManager {
    private final String URL = "http://www.complimentgenerator.co.uk/";
    private static ComplimentManager instance;

    private ComplimentManager() {

    }

    public static ComplimentManager getInstance() {
        return instance != null ? instance : (instance = new ComplimentManager());
    }

    public Document getDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public String getCompliment() {
        Document doc;
        try {
            doc = getDocument(URL);
        } catch (IOException e) {
            e.printStackTrace();
            return "I couldn't get you a random compliment, because I ran into an error! :( \n However, you look great today.";
        }
        Element p = doc.body()
                .getElementById("wrapper")
                .getElementById("content")
                .getElementById("center")
                .getElementById("main")
                .child(0).child(0).child(0).child(0).child(0)
                .getElementsByTag("p")
                .get(0);

        return p.text();
    }
}
