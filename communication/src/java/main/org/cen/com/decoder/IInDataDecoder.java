package org.cen.com.decoder;

import java.util.Set;

import org.cen.com.IllegalComDataException;
import org.cen.com.in.InData;

/**
 * Interface of the decoder class that decodes incomming serial data.
 * 
 * @author Emmanuel ZURMELY
 */
public interface IInDataDecoder {

    int HEADER_LENGTH = 1;

    /**
     * Returns the set of handled data headers.
     * 
     * @return the set of handled data headers
     */
    Set<String> getHandledHeaders();

    /**
     * Decode the incomming data string.
     * 
     * @param data
     *            the incomming data string (contains header)
     * @return the data object associated to the incomming data string
     * @throws IllegalComDataException
     *             if the data string could not be decoded
     */
    InData decode(String data) throws IllegalComDataException;

    /**
     * Returns the length of the data associated to the specified header string.
     * The returned value does not take into account the size of the header. If
     * the header is not followed by any data, or if the header is not handled
     * by this decoder, the value returned is 0.
     * 
     * @param header
     *            the header string
     * @return the length of the data following the header
     */
    int getDataLength(String header);
}
