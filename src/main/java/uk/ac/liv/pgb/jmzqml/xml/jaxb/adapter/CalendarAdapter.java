
package uk.ac.liv.pgb.jmzqml.xml.jaxb.adapter;

import java.util.Calendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Da
 */
public class CalendarAdapter extends XmlAdapter<String, Calendar> {

    @Override
    public Calendar unmarshal(final String value)
            throws Exception {
        return javax.xml.bind.DatatypeConverter.parseDateTime(value);
    }

    @Override
    public String marshal(final Calendar value)
            throws Exception {
        if (value == null) {
            return null;
        }
        return javax.xml.bind.DatatypeConverter.printDateTime(value);
    }

}
