package test;

import ieee1516e.ObjectModelType;
import parser.FOMObjectCreator;
import wrapper.FomArrayData;
import wrapper.FomAttribute;
import wrapper.FomBasicData;
import wrapper.FomDataTypes;
import wrapper.FomEnumeratedData;
import wrapper.FomEnumerator;
import wrapper.FomObject;
import wrapper.FomWrapper;

public class Test {

	private static void printObject( FomObject obj ) {
		if ( obj == null ) {
			return;
		}
		System.out.println( obj.getFullyQualifiedName() + " : " + obj.getChildren().size() + " filho(s)." );
		System.out.println( obj.getSharing() + " " + obj.getSemantics() );
		for ( FomAttribute attr : obj.getAttributes() ) {
			System.out.println(" Attribute: " + attr.getName() + " " + attr.getDataType() + " " + attr.getOwnerShip() + " " +
					attr.getOrder() + " " + attr.getSharing() + " " + attr.getTransportation() );
			System.out.println("   > " + attr.getSemantics() );
			System.out.println("   > " + attr.getUpdateType() + " " + attr.getUpdateCondition() );
			for ( String dimension : attr.getDimensions() ) {
				System.out.println("    Dimension: " + dimension );
			}
		}
		
	}

	private static void printDataTypes( FomDataTypes fdt ) {
		if ( fdt == null ) { return; }
		System.out.println("ARRAY DATA TYPES: ");
		for ( FomArrayData fad : fdt.getArrayData() ) {
			System.out.println( fad.getName() + " " + fad.getType() + " " + fad.getCardinality() + " " + fad.getEncoding() );
			System.out.println(" > " + fad.getSemantics() );
		}
		
		System.out.println("BASIC DATA REPRESENTATION: ");
		for ( FomBasicData fbd : fdt.getBasicData() ) {
			System.out.println( fbd.getName() + " " + fbd.getEncoding() + " " + fbd.getEndian() + " " + fbd.getSize() );
			System.out.println(" > " + fbd.getInterpretation() );
		}

		System.out.println("ENUMERATED DATA: ");
		for ( FomEnumeratedData fed : fdt.getEnumeratedData() ) {
			System.out.println( fed.getName() + " " + fed.getRepresentation() );
			for ( FomEnumerator fen : fed.getEnumerators() ) {
				System.out.println( " > " + fen.getValue() + " " + fen.getName() );
			}
			System.out.println(" > " + fed.getSemantics() );
		}

	}
	
	
	
	private static void testFom(FOMObjectCreator foc, String fomFileName )  throws Exception {
		System.out.println(" >>>>> TESTING FOM FILE : " + fomFileName + " <<<<< " );
		
		ObjectModelType omt = foc.generate( fomFileName ); 
		FomWrapper fw = new FomWrapper( omt );
		
		System.out.println("");
		System.out.println("----------- OBJECTS -------------");
		
		for ( FomObject child : fw.getAllObjects()  ) {
			printObject( child );
		}

		System.out.println("");
		System.out.println("----------- DATA TYPES ----------");
		printDataTypes(  fw.getDataTypes() );
		System.out.println("");
		System.out.println("");
	}
	
	public static void main(String[] args) throws Exception {
		FOMObjectCreator foc = new FOMObjectCreator();
		//testFom(foc, "d:/test/RestaurantFood.xml");
		testFom(foc, "d:/test/RestaurantProcesses.xml");
		//testFom(foc, "d:/test/HLAstandardMIM.xml");
		//testFom(foc, "d:/test/RestaurantSoup.xml");
		//testFom(foc, "d:/test/RestaurantDrinks.xml");
		//testFom(foc, "d:/test/SushiRestaurant.xml");
		//testFom(foc, "d:/test/FuelEconomyBase.xml");
		//testFom(foc, "d:/test/federation.xml");
		
	}
	
	
	
}
