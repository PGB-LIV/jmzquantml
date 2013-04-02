/*
 * Date: 02-Apr-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.test.xml.marshaller.MzQuantMLMarshallerTest.java
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

package uk.ac.liv.jmzqml.test.xml.marshaller;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import static org.junit.Assert.*;
import org.junit.Test;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLMarshaller;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 02-Apr-2013 15:47:27
 */
public class MzQuantMLMarshallerTest {

    @Test
    public void testIncrementalMarshalling()
            throws IOException {


        URL xmlFileURL = MzQuantMLMarshallerTest.class.getClassLoader().getResource("CPTAC-Progenesis-small-example.mzq");
        assertNotNull(xmlFileURL);
        MzQuantMLUnmarshaller unmarshaller = new MzQuantMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);

        MzQuantMLMarshaller m = new MzQuantMLMarshaller();
        assertNotNull(m);

        FileWriter writer = null;
    }

}
