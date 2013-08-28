business-app-leak
=================

Simple business app to reproduce a memory leak on JBoss EAP 6.1.0.Final with Arquillian

## Prerequisites

 * Install [JBoss EAP 6.1.0.Final](http://www.jboss.org/jbossas/downloads/) in `/var/opt/jbossas7`.
 * Create a deployment directory in `/var/opt/memory-leak`
 * Copy the configuration file `src/main/resources/standalone.xml` into `/var/opt/memory-leak/configuration/standalone.xml`

## Usage

    mvn clean install

Wait until you see this line...

    java.lang.OutOfMemoryError: PermGen space
    Dumping heap to java_pid9370.hprof ...


