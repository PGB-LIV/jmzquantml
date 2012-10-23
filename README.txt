=======================================================================
=                                                                     =
=                                                                     =
=                jmzquantmL - Java API for MzQuantML                  =
=                                                                     =
=                                                                     =
=                                       jmzquantml  1.0.0-rc2-1.0.0   =
=                                 (c) University of Liverpool  2012   =
=                              http://code.google.com/p/jmzquantml/   =
=                                                                     =
=                                                                     =
=======================================================================


Description

  jmzquantml is a JAVA API for reading and writing mzQuantML file 
  which is designed for recording quantitative proteomic data and 
  meta-data.

How to use in maven
  
  jmzquantml artifact is currently using Googlecode host as its maven
  repository. To use it, add the following to your POM:
  
  First, add jmzquantml dependency:
  
  <dependency>
     <groupId>uk.ac.liv</groupId>
     <artifactId>jmzquantml</artifactId>
     <version>1.0.0-rc2-1.0.0</version>
  </dependency>

  Second, add wagon-svn extension (current version 1.12):
  
  <extensions>
     <extension>
        <groupId>org.jvnet.wagon-svn</groupId>
        <artifactId>wagon-svn</artifactId>
        <version>1.12</version>
     </extension>
  </extensions>

  Last, add plugin repository and jmzquantml repository:
  
  <pluginRepositories>
     <pluginRepository>
        <id>maven2-repository.dev.java.net</id>
        <name>Java.net Repository for Maven</name>
        <url>http://download.java.net/maven/2/</url>
     </pluginRepository>
  </pluginRepositories>
  <repositories>
     <repository>
        <id>ddq-maven-repo</id>
        <name>Maven Repository for jmzquantml release</name>
        <url>http://jmzquantml.googlecode.com/svn/maven/repo</url>
     </repository>
  </repositories>


Changelog

  - Current version 1.0.0-rc2-1.0.1
  - Previous version 1.0.0-rc2-1.0.0

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
