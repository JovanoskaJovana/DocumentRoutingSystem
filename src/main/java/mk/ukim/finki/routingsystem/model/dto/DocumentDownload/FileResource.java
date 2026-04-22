package mk.ukim.finki.routingsystem.model.dto.DocumentDownload;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

/**
 * DTO representing a file resource prepared for download.
 *
 * @param resource  the file resource to be streamed
 * @param filename  the name of the PDF file
 * @param mediaType the media type of the file
 * @param length    the size of the file in bytes
 */
public record FileResource(
        Resource resource,
        String filename,
        MediaType mediaType,
        int length
) {
}
