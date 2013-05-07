package uk.ac.liv.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.Organization;
import uk.ac.liv.jmzqml.model.mzqml.ParentOrganization;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 * @author rwang
 * @author florian
 */
public class ParentOrganizationRefResolver extends AbstractReferenceResolver<ParentOrganization> {

    public ParentOrganizationRefResolver(MzQuantMLIndexer index, MzQuantMLObjectCache cache) {
        super(index, cache);
    }

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
