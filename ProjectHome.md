# jmzquantml -- A Java API for mzQuantML #


---

![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/label_new%20green.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/label_new%20green.png)

### ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/newspaper.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/newspaper.png) **7, July 2014 -- jmzquantml 1.0.0-1.0.5 has been released.** Full Java documentation can be found in http://jmzquantml.googlecode.com/svn/trunk/src/docs/api/1.0.0-1.0.5/index.html. ###


---


## General ##

> jmzquantml is a JAVA API for reading and writing mzQuantML file
> which is designed for reording quantitative proteomic data and
> meta-data.


---


## ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/download.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/download.png) Download JAR file ##

As Googlecode has terminated the download service on January 2014, new release after version 1.0.0-1.0.3 cannot be found in download section from left column. The latest jar file can be downloaded from http://code.google.com/p/jmzquantml/source/browse/#svn%2Fmaven%2Frepo%2Fuk%2Fac%2Fliv%2Fjmzquantml. Before download, refer to "[release notes](jmzquantmlReleaseNotes.md)" for latest news.


---


## ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/Product-documentation.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/Product-documentation.png) Documentations ##

Here are the API documentation links to all API versions.
http://jmzquantml.googlecode.com/svn/trunk/src/docs/api/index.htm


## ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/How-to.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/How-to.png) How to use jmzquantml artifact in maven ##


> jmzquantml artifact is currently using Googlecode host as its maven
> repository. To use it, add the following to your POM:

> First, add jmzquantml dependency (check the latest version):
```
  <dependency>
     <groupId>uk.ac.liv</groupId>
     <artifactId>jmzquantml</artifactId>
     <version>1.0.0-1.0.5</version>
  </dependency>
```
> Second, add wagon-svn extension (current version 1.12) in `<build>` tag:
```
  <extensions>
     <extension>
        <groupId>org.jvnet.wagon-svn</groupId>
        <artifactId>wagon-svn</artifactId>
        <version>1.12</version>
     </extension>
  </extensions>
```
> Finally, add plugin repository and jmzquantml repository:
```
  <pluginRepositories>
     <pluginRepository>
        <id>maven2-repository.dev.java.net</id>
        <name>Java.net Repository for Maven</name>
        <url>http://download.java.net/maven/2/</url>
     </pluginRepository>
  </pluginRepositories>
  <repositories>
     <repository>
        <id>jmzquantml-maven-repo</id>
        <name>Maven Repository for jmzquantml release</name>
        <url>http://jmzquantml.googlecode.com/svn/maven/repo</url>
     </repository>
  </repositories>
```


---


## ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/examples.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/examples.png) Examples ##
To help users to familiarise with the API, we have generated some example classes to illustrate the most important features. They can be found from [here](http://code.google.com/p/jmzquantml/w/list).

---


## ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/reference.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/reference.png) Citation ##

The paper of jmzquantml API has been published in _[Proteomics](http://dx.doi.org/10.1002%2Fpmic.201300281)_. If you would like to cite jmzquantml in your paper, please use the following citation:

#### **Plain** ####

_Qi, D., Krishna, R. and Jones, A. R. (2014), The jmzQuantML programming interface and validator for the mzQuantML data standard. Proteomics, 14: 685–688. doi: 10.1002/pmic.201300281_

#### ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/bibtex.gif](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/bibtex.gif) **Bibtex** ####
```
@article {QI14:PROTEOMICS,
author = {Qi, Da and Krishna, Ritesh and Jones, Andrew R},
title = {The jmzQuantML programming interface and validator for the mzQuantML data standard},
journal = {PROTEOMICS},
volume = {14},
number = {6},
issn = {1615-9861},
url = {http://dx.doi.org/10.1002/pmic.201300281},
doi = {10.1002/pmic.201300281},
pages = {685--688},
keywords = {Bioinformatics, Java API, mzQuantML, Proteomics Standards Initiative, XML},
year = {2014},
}
```

## ![http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/contact.png](http://jmzquantml.googlecode.com/svn/trunk/src/main/resources/images/contact.png) Contact ##

Dr Da Qi (**D.Qi at liverpool.ac.uk , replace at with @**)

Dr Andy Jones (**Andrew.Jones at liverpool.ac.uk, replace at with @**)

last update: 22/08/2014