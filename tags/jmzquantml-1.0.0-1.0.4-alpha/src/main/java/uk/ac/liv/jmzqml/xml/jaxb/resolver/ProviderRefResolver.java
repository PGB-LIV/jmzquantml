
package uk.ac.liv.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.Provider;
import uk.ac.liv.jmzqml.model.mzqml.Software;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 */
public class ProviderRefResolver extends AbstractReferenceResolver<Provider> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public ProviderRefResolver(MzQuantMLIndexer index,
                               MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object Provider
     */
    @Override
    public void updateObject(Provider object) {
        // add objects for the refID
        String ref = object.getSoftwareRef();
        if (ref != null) {
            Software refObject = this.unmarshal(ref, Software.class);
            object.setSoftware(refObject);
        }
    }

    /**
     * Method to perform the afterUnmarshal operation if the resolver
     * applies to the specified object.
     *
     * @param target the object to modify after unmarshalling.
     * @param parent object referencing the target. Null if target is root element.
     */
    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (Provider.class.isInstance(target) && MzQuantMLElement.Provider.isAutoRefResolving()) {
            updateObject((Provider) target);
        } // else, not business of this resolver
    }

}
