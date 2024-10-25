package com.drl.tools;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Link {

    public static void openLink(String link) {
        try {
            URI uri = new URI(link);

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(uri);
            } else {
                System.out.println("Desktop API không được hỗ trợ trên hệ thống này.");
            }
        } catch (IOException e) {
            System.err.println("Lỗi IO: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.err.println("Liên kết không hợp lệ: " + e.getMessage());
        }
    }

}
