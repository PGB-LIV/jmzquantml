
package uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Cv;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 */
public class CvParamRefResolver extends AbstractReferenceResolver<CvParam> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public CvParamRefResolver(final MzQuantMLIndexer index,
                              final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object CvParam
     */
    @Override
    public final void updateObject(final CvParam object) {
        // add objects for the refID
        String ref = object.getCvRef();
        if (ref != null) {
            Cv refObject = this.unmarshal(ref, Cv.class);
            object.setCv(refObject);
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
    public final void afterUnmarshal(final Object target, final Object parent) {
        if (CvParam.class.isInstance(target) && MzQuantMLElement.CvParam.isAutoRefResolving()) {
            updateObject((CvParam) target);
        } // else, not business of this resolver
    }

}
