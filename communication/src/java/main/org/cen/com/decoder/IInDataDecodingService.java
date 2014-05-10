package org.cen.com.decoder;

import java.util.Set;

import org.cen.com.IllegalComDataException;
import org.cen.com.in.InData;

/**
 * The service which manage all Decoders.
 */
public interface IInDataDecodingService {

    /**
     * Return the right decoder which must be used to handle the message with
     * the header given in paramters.
     * 
     * @param header
     *            the header for which we must determine the right decoder to
     *            handle in data
     * @return
     */
    IInDataDecoder getDecoder(String header);

    /**
     * Returns the registered decoders.
     * 
     * @return the registered decoders
     */
    Set<IInDataDecoder> getDecoders();

    /**
     * Register a decoder which can handle many message.
     * 
     * @param decoder
     *            the decoder that we want to register in the system.
     */
    void registerDecoder(IInDataDecoder decoder);

    /**
     * Build the decoder corresponding to the system.
     * 
     * @param data
     *            the data from the serial interface
     * @return an object encapsulating the message.
     * @throws IllegalComDataException
     */
    InData decode(String data) throws IllegalComDataException;
}
