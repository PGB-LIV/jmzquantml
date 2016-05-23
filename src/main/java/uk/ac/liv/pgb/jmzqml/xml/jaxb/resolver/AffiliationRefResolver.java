
package uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Organization;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 */
public class AffiliationRefResolver extends AbstractReferenceResolver<Affiliation> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public AffiliationRefResolver(final MzQuantMLIndexer index,
                                  final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object Affiliation
     */
    @Override
    public final void updateObject(final Affiliation object) {
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
     * @param parent object referencing the target. Null if target is root
     *               element.
     */
    @Override
    public final void afterUnmarshal(final Object target, final Object parent) {
        if (Affiliation.class.isInstance(target)
                && MzQuantMLElement.Affiliation.
                isAutoRefResolving()) {
            updateObject((Affiliation) target);
        } // else, not business of this resolver
    }

}
