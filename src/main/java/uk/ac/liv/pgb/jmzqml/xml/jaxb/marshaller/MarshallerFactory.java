/*
 * Date: 08-Mar-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.marshaller.MarshallerFactory.java
 *
 * jmzquantml is Copyright 2013 University of Liverpool.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.liv.pgb.jmzqml.xml.jaxb.marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import uk.ac.liv.pgb.jmzqml.model.utils.ModelConstants;
import uk.ac.liv.pgb.jmzqml.xml.Constants;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.marshaller.listeners.ObjectClassListener;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 08-Mar-2013 15:19:22
 */
public class MarshallerFactory {

    private static final Logger logger = Logger.getLogger(MarshallerFactory.class);
    private static MarshallerFactory instance = new MarshallerFactory();
    private JAXBContext jc = null;

    /**
     * A static method to construct an object of MarshallerFactory.
     *
     * @return an instance of MarshallerFactory.
     */
    public static MarshallerFactory getInstance() {
        return instance;
    }

    private MarshallerFactory() {
    }

    /**
     * Initialise the Marshaller with pre-defined settings.
     *
     * @return an instance of {@link javax.xml.bind.Marshaller} with initial configurations.
     */
    public synchronized Marshaller initializeMarshaller() {
        logger.debug("Initializing Marshaller for mzQuantML.");
        try {
            // Lazy caching of JAXB context.
            if (jc == null) {
                jc = JAXBContext.newInstance(ModelConstants.PACKAGE);
            }
            //create marshaller and set basic properties
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Constants.JAXB_ENCODING_PROPERTY, "UTF-8");
            marshaller.setProperty(Constants.JAXB_FORMATTING_PROPERTY, true);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            // Register a listener that calls before/afterMarshalOperation on ParamAlternative/-List objects.
            // See: ParamAlternative.beforeMarshalOperation and ParamAlternativeList.beforeMarshalOperation
            marshaller.setListener(new ObjectClassListener());

            logger.info("Marshaller initialized");

            return marshaller;

        }
        catch (JAXBException e) {
            logger.error("MarshallerFactory.initializeMarshaller", e);
            throw new IllegalStateException("Can't initialize marshaller: " + e.getMessage());
        }

    }

}
