hla-fom-wrapper
===============

A java wrapper to load and inspect HLA RTI FOM files. Have all classes from IEEE1516-DIF-2010.xsd specification and a wrapper to simplify inspect your fom.

Very simple to use!
===================

  ```java
  ObjectModelType omt = new FOMObjectCreator().generate( "RestaurantProcesses.xml" ); 
  FomWrapper fw = new FomWrapper( omt );

  FomDataTypes dataTypes = fw.getDataTypes();
  for ( FomArrayData fad : fdt.getArrayData() ) {
    System.out.println( fad.getName() + " " + fad.getType() );
    System.out.println(" > " + fad.getSemantics() );
  }
  ```
		
HLA Evolved namespace
=====================

Work only with HLA Evolved XML files.
Namespace http://standards.ieee.org/IEEE1516-2010


		
