package mk.ukim.finki.routingsystem.model.dto.DocumentDownload;

/**
 * DTO representing the information needed for a document download.
 *
 * @param file     the document that will be downloaded
 * @param filename the filename of the version of the document that will be downloaded
 */
public record PreparedDocumentDownload(
        FileResource file,
        String filename
) {
}
