package uk.ac.liv.jmzquantmlexample;

import java.io.File;
import uk.ac.liv.jmzqml.model.mzqml.MzQuantML;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

public class MzQuantMLModifier 
{
    public static void main( String[] args )
    {
        File mzqFile = new File("CPTAC-Progenesis-small-example.mzq");
        MzQuantMLUnmarshaller unmarshaller = new MzQuantMLUnmarshaller(mzqFile);
        
        MzQuantML mzq = new MzQuantML();
        
        String mzqId = unmarshaller.getMzQuantMLId();
        String mzqName = unmarshaller.getMzQuantMLName();
        String mzqVersion = unmarshaller.getMzQuantMLVersion();
        
        
    }
}
