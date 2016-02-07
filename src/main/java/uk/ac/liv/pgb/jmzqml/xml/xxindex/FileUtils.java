
package uk.ac.liv.pgb.jmzqml.xml.xxindex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import org.apache.log4j.Logger;

/**
 *
 * @author Da Qi
 */
public class FileUtils {

    private static Logger logger = Logger.getLogger(FileUtils.class);

    /**
     * A method to get File from URL
     *
     * @param url a URL
     *
     * @return a File object
     */
    public static File getFileFromURL(URL url) {

        File tempFile;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {

            String tempDir = System.getProperty("java.io.tmpdir", ".");

            // Create temp file.
            tempFile = File.createTempFile("xxindex", ".tmp", new File(tempDir));

            // Delete temp file when program exits.
            tempFile.deleteOnExit();

            // copy content of URL to local file
            InputStream is = url.openStream();
            in = new BufferedInputStream(is);

            OutputStream fos = new FileOutputStream(tempFile);
            out = new BufferedOutputStream(fos);

            byte[] b = new byte[1];
            while (in.read(b) >= 0) {
                out.write(b);
            }

            logger.debug(url + " written to local file " + tempFile.getAbsolutePath());

        }
        catch (IOException e) {
            throw new IllegalStateException("Could not create local file for URL: " + url, e);
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException e) {
                /*
                 * ignore
                 */
            }

        }

        return tempFile;
    }

}
