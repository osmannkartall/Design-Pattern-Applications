package osman_kartal_ooad_hw1_p2;

import java.util.Observable;

/**
 * Website is the concrete class that extends Observable.
 * Concrete observer classes can be subscribed to one or more Website object.
 * It contains methods for setting new photo, text and audio contents and
 * notifying observers that contains it's reference so that observers can
 * get currently arrived contents.
 *
 * @author Osman Kartal
 *
 */
class Website extends Observable {
    /**
     * A website url
     */
    private String siteUrl;

    /**
     * String that simulates a photograph data in a text format like
     * "image.jpeg"
     */
    private String photo;

    /**
     * String that simulates a text data.
     */
    private String text;

    /**
     * String that simulates a audio data in a text format like
     * "audio.mp3"
     */
    private String audio;

    /**
     * No parameter constructor
     */
    Website() {}

    /**
     * One parameter constructor
     * @param siteUrl a website that can be subscribed to it
     */
    Website(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    /**
     * Changes new content with older one. Then, calls a method
     * to notify it's subscribers.
     *
     * @param text new text content
     * @param audio new audio content
     * @param photo new photo content
     */
    void setContents(String text, String audio, String photo) {
        this.text = text;
        this.audio = audio;
        this.photo = photo;
        arrivedNewContent();
    }

    /**
     * Notifies subscribers
     */
    private void arrivedNewContent() {
        setChanged();
        notifyObservers();
    }

    /**
     * Getter for text content
     *
     * @return current text content
     */
    String getText() {
        return text;
    }

    /**
     * Getter for audio content
     *
     * @return current audio content
     */
    String getAudio() {
        return audio;
    }

    /**
     * Getter for photo content
     *
     * @return current photo content
     */
    String getPhoto() {
        return photo;
    }

    /**
     * Getter for subscribed website url
     *
     * @return current website url
     */
    String getSiteUrl() {
        return siteUrl;
    }

    /**
     * Setter to change subscribed website url
     *
     * @param siteUrl new website url
     */
    void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
