package org.cen.com.decoder.impl;

import java.util.HashSet;
import java.util.Set;

import org.cen.com.IllegalComDataException;
import org.cen.com.decoder.IInDataDecoder;
import org.cen.com.decoder.IInDataDecodingService;
import org.cen.com.in.InData;
import org.cen.com.in.UntypedInData;

/**
 * The service which manage all Decoders.
 */
public class InDataDecodingService implements IInDataDecodingService {

    /**
     * All decoders which are registered by the system.
     */
    private final Set<IInDataDecoder> decoders = new HashSet<IInDataDecoder>();

    @Override
    public InData decode(String data) throws IllegalComDataException {
        String header = data.substring(0, IInDataDecoder.HEADER_LENGTH);
        IInDataDecoder decoder = getDecoder(header);
        if (decoder != null) {
            InData result = decoder.decode(data);
            return result;
        } else {
            UntypedInData result = new UntypedInData(data);
            return result;
        }
    }

    @Override
    public IInDataDecoder getDecoder(String header) {
        for (IInDataDecoder inDataDecoder : decoders) {
            Set<String> handledHeaders = inDataDecoder.getHandledHeaders();
            if (handledHeaders.contains(header)) {
                return inDataDecoder;
            }
        }
        return null;
    }

    @Override
    public Set<IInDataDecoder> getDecoders() {
        return decoders;
    }

    @Override
    public void registerDecoder(IInDataDecoder decoder) {
        decoders.add(decoder);
    }
}
