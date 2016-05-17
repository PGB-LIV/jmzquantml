
package uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Cv;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 *
 */
public class AbstractParamUnitCvRefResolver extends AbstractReferenceResolver<AbstractParam> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    protected AbstractParamUnitCvRefResolver(final MzQuantMLIndexer index,
                                             final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object AbstractParam
     */
    @Override
    public final void updateObject(final AbstractParam object) {
        // add objects for the refID
        String ref = object.getUnitCvRef();
        if (ref != null) {
            Cv refObject = this.unmarshal(ref, Cv.class);
            object.setUnitCv(refObject);
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
        if (AbstractParam.class.isInstance(target) && MzQuantMLElement.AbstractParam.isAutoRefResolving()) {
            updateObject((AbstractParam) target);
        } // else, not business of this resolver
    }

}
