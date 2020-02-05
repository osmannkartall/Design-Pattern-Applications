package osman_kartal_ooad_hw1_p2;

/**
 * WebsiteTester is the driver class for testing operations on classes
 * in p2 package.
 *
 * @author Osman Kartal
 */
public class WebsiteTester {
    public static void main(String[] args) {
        Website website = new Website("https://www.google.com/");

        CurrentPhotoDisplay currentPhotoDisplay = new CurrentPhotoDisplay(website);
        CurrentPhotoAndTextDisplay currentPhotoAndTextDisplay =
                new CurrentPhotoAndTextDisplay(website);
        CurrentAllDisplay currentAllDisplay = new CurrentAllDisplay(website);

        website.setContents("This is new text", "audio.mp3", "image.jpeg");
        System.out.println("--------------------------------------------------------");
        website.setContents("This is new text2", "audio2.mp3", "image2.jpeg");
        System.out.println("--------------------------------------------------------");
        website.setContents("This is new text3", "audio3.mp3", "image3.jpeg");
    }
}
