package uk.ac.liv.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.Cv;
import uk.ac.liv.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 * @author Florian Reisinger
 *         Date: 16-Nov-2010
 * @since 1.0
 */
public class CvParamRefResolver extends AbstractReferenceResolver<CvParam> {

    public CvParamRefResolver(MzQuantMLIndexer index, MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(CvParam object) {
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
    public void afterUnmarshal(Object target, Object parent) {
        if (CvParam.class.isInstance(target) && MzQuantMLElement.CvParam.isAutoRefResolving()) {
            updateObject((CvParam) target);
        } // else, not business of this resolver
    }

}
