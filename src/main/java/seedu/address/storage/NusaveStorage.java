package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyNusave;

public interface NusaveStorage {

    Path getNusaveFilePath();

    Optional<ReadOnlyNusave> readNusave() throws DataConversionException, IOException;

    /**
     * @see #getNusaveFilePath()
     */
    Optional<ReadOnlyNusave> readNusave(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyNusave} to the storage.
     * @param nusave cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveNusave(ReadOnlyNusave nusave) throws IOException;

    void saveNusave(ReadOnlyNusave nusave, Path filePath) throws IOException;
}
