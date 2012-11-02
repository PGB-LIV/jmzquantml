/*
 * Date: 21-Jun-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.resolver.AbstractReferenceResolver.java
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
package uk.ac.liv.jmzqml.xml.jaxb.resolver;

import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;

/**
 *
 * @author Da Qi @institute University of Liverpool @time 21-Jun-2012 23:35:15
 */
public abstract class AbstractReferenceResolver<T extends MzQuantMLObject> extends Unmarshaller.Listener {

    private static final Logger log = Logger.getLogger(AbstractReferenceResolver.class);
}
