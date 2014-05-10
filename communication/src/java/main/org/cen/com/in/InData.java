package org.cen.com.in;

import org.cen.com.AbstractComData;

/**
 * Objects which represents the data which comes from the micro-controllers and
 * which must be decrypted.
 * 
 * @author svanacker
 * @version 22/02/2007
 */
public abstract class InData extends AbstractComData {

    public InData() {
        super();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
