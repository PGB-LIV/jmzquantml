=======================================================================
=                                                                     =
=                                                                     =
=                jmzquantmL - Java API for mzQuantML                  =
=                                                                     =
=                                                                     =
=                                           jmzquantml  1.0.0-1.1.0   =
=                                 (c) University of Liverpool  2014   =
=                              http://pgb-liv.github.io/jmzquantml/   =
=                                                                     =
=                                                                     =
=======================================================================


Description

  jmzquantml is a JAVA API for reading and writing mzQuantML file 
  which is designed for recording quantitative proteomic data and 
  meta-data. For more information please visit http://pgb-liv.github.io/jmzquantml/.

How to use in maven
  
  jmzquantml artifact is currently hosted in the Maven Central Repository (http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22jmzquantml%22):
  
  Simply add jmzquantml dependency (check for the latest version) to your pom.xml:
  
  <dependency>
     <groupId>uk.ac.liv.pgb</groupId>
     <artifactId>jmzquantml</artifactId>
     <version>1.0.0-1.1.0</version>
  </dependency>


Changelog

  - Current version 1.0.0-1.1.0
  - Previous version 1.0.0-1.0.5


jmzquantml version 1.0.0-1.1.0 -- (24, January 2016)
  - changed GroupId to "uk.ac.liv.pgb"
  - moved souce code from GoogleCode to GitHub
  - moved artifact to Maven Central Repositroy
  
jmzquantml version 1.0.0-1.0.5 -- (7, July 2014)
  - implemented all the *RefResolver classes
  - adjusted to Java 1.7

jmzquantml version 1.0.0-1.0.4-alpha -- (2, May 2014)
  - fixed the bug that xmlExtractor.detectFileEncoding returns null on files that don't have XML header
  - added missing setIdRefs methods in EvidenceRef
  
jmzquantml version 1.0.0-1.0.3 -- (31, October 2013)
  - added java documentations
  - resolved assay_refs in EvidenceRef
  - fixed potential bug of duplicating Assay_refs in StudyVariableRefResolver, ProteinRefResolver and AssayRefResolver
  
jmzquantml version 1.0.0-1.0.2 -- (9, May 2013)
  - fixed the bugs of getting null list from some element classes
  
jmzquantml version 1.0.0-1.0.1 -- (7, May 2013)
  - added various unmarshallng and marshalling functions 
  - added reference resolvers


jmzquantml version 1.0.0-1.0.0 -- (15, February 2013)
  - adapted to mzQuantML version 1.0

jmzquantml version 1.0.0-rc3-1.0.5 -- (30, November 2012)
  - adapted to latest schema changes:
    - added a new <RatioQuantLayer> with the DataType element
    - added a new optional rawFile_ref to <Feature>  
  
jmzquantml version 1.0.0-rc3-1.0.4.1 -- (29, November 2012)
  - fixed the bug of wrong <ProteinGroup> class
  
jmzquantml version 1.0.0-rc3-1.0.4 -- (28, November 2012)
  - adapted to latest schema change which introduces <ProteinRef> element under <ProteinGroup>

jmzquantml version 1.0.0-rc3-1.0.3 -- (22, November 2012)
  - adapted to latest schema changes:
    - the root mzQuantML element now has a mandatory id and an optional name
    - pre order Person before Organization in AuditCollection
    - add complete definitions to elements

jmzquantml version 1.0.0-rc3-1.0.2 -- (8, November 2012)
  - be able to unmarshal ParamList and ParamGroup   
   
jmzquantml version 1.0.0-rc3-1.0.1 -- (2, November 2012)
  - fixed the bug of wrong namespace in marshall function

jmzquantml version 1.0.0-rc3-1.0.0 -- (1, November 2012)
  - update this (README.txt) document
  - this version comply to mzQuantML_1_0_0-rc3.xsd (31, October 2012)

jmzquantml version 1.0.0-rc2-1.0.1 -- (23, October 2012)

  - update this (README.txt) document
  - change the model according to schema change
  - more info about schema change can be found in following links    
    - http://code.google.com/p/mzquantml/issues/detail?id=43&can=1
    - http://code.google.com/p/mzquantml/issues/detail?id=44&can=1
    - http://code.google.com/p/mzquantml/source/detail?r=243

jmzquantml version 1.0.0-rc2-1.0.0 -- (4, July 2012) 

  - move to Maven 3.0.4
  - add README.txt, LICENCE.txt
  - add bindings.xjb and mzQuantML_1_0_0-rc2.xsd (11, June 2012) for 
    customization to JAXB bindings
  - change package name to "uk.ac.liv.jmzqml.model.mzqml"
  - change element classes name by removing 'Type' suffixes

jmzquantml version 1.0.0-rc2 -- (7, June 2012)

  - comply to mzQuantML_1_0_0-rc2.xsd (7, June 2012)
  - provide basic marshaller and unmarshaller classes
