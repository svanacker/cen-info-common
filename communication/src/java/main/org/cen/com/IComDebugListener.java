package org.cen.com;

import java.util.EventListener;

import org.cen.com.in.RawInData;

/**
 * Interface to see information which are exchanged by the server and the
 * client.
 */
public interface IComDebugListener extends EventListener {

    /**
     * Call back method raised when raw data arrives to the server.
     * 
     * @param rawData
     *            the rawData which is sent to the server.
     */
    void onRawInData(RawInData rawData);
}
