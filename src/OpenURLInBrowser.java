
//  Created by Ozan Bağıran

import java.awt.Desktop;
import java.net.URI;

public class OpenURLInBrowser {
    public static void main(String[] args) {
        // Specify the URL you want to open
        String url = "https://www.x.com";

        // Open the URL in the default web browser
        openURL(url);
    }

    public static void openURL(String url) {
        try {
            // Create a URI object from the given URL string
            URI uri = new URI(url);

            // Check if the Desktop is supported on the current platform
            if (Desktop.isDesktopSupported()) {
                // Get the Desktop instance
                Desktop desktop = Desktop.getDesktop();

                // Open the default web browser with the specified URL
                desktop.browse(uri);
            } else {
                // Desktop is not supported, handle accordingly
                System.out.println("Desktop not supported, opening URL in the console: " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
