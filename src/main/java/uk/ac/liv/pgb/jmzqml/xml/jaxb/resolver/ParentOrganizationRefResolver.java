
package uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Organization;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 */
public class ParentOrganizationRefResolver extends AbstractReferenceResolver<ParentOrganization> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public ParentOrganizationRefResolver(MzQuantMLIndexer index,
                                         MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object ParentOrganization
     */
    @Override
    public void updateObject(ParentOrganization object) {
        // add objects for the refID
        String ref = object.getOrganizationRef();
        if (ref != null) {
            Organization refObject = this.unmarshal(ref, Organization.class);
            object.setOrganization(refObject);
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
        if (ParentOrganization.class.isInstance(target) && MzQuantMLElement.ParentOrganization.isAutoRefResolving()) {
            updateObject((ParentOrganization) target);
        } // else, not business of this resolver
    }

}
