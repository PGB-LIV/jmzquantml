/*
 * Date: 10-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.test.xml.unmarshaller.MzQuantMLUnmarshallerTest.java
 *
 * jmzquantml is Copyright 2012 University of Liverpool.
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
package uk.ac.liv.jmzqml.test.xml.unmarshaller;

import java.net.URL;
import static org.junit.Assert.assertNotNull;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

/**
 *
 * @author Da Qi @institute University of Liverpool @time 10-Jul-2012 11:37:50
 */
public class MzQuantMLUnmarshallerTest {

    private static MzQuantMLUnmarshaller unmarshaller;

    static {
        String fileName = "mzQuantML_example_SILAC_OpenMS-SILACAnalyzer.mzq";
        URL xmlFileURL = MzQuantMLUnmarshallerTest.class.getClassLoader().getResource(fileName);
        assertNotNull(xmlFileURL);

        //unmarshaller = new MzQuantMLUnmarshaller;
    }
}
