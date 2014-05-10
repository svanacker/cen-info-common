package org.cen.com;

import org.cen.com.in.InData;
import org.cen.com.in.InDataListener;
import org.cen.com.out.OutData;
import org.cen.com.out.OutDataListener;

public interface IComServiceListener {

    /**
     * Add listeners to be inform when raw data arrives in the serialPort.
     * 
     * @param listener
     *            the listener which must be notify
     */
    void addDebugListener(IComDebugListener listener);

    /**
     * Add listeners to be notify when InData Object comes from the client.
     * 
     * @param listener
     *            the listener which must be notify
     */
    void addInDataListener(InDataListener listener);

    /**
     * Add listeners to be inform when a instruction is sent to the serialPort.
     * 
     * @param listener
     *            the listener which must be notify
     */
    void addOutDataListener(OutDataListener listener);

    /**
     * Notify all debug observers.
     */
    void fireDebugListener(String data);

    /**
     * Notify all observers that requires to be notify off data which arrives in
     * the serial Port
     */
    void fireInDataListener(InData data);

    /**
     * Notify all observers that requires to be notify when data are sent to the
     * serial Port
     */
    void fireOutDataListener(OutData outData);
}
