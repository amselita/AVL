package avl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.dom.MatchingIterator;

import java.io.IOException;

public final class Shell {
    /**
     * utlilty class
     */
    private Shell() {
    }
    
    

    private static void execute (BufferedReader stdin)
	throws IOException {
		try {
			boolean quit = false;
			MyComparator comparator = new MyComparator();
			SortedMap<Body, String> bodies= new AvlTreeMap<String,Body>(comparator);
			while (!quit) {
				System.out.print("PROMPT> ");
				String input = stdin.readLine();
				if (input == null) {
					break;
				}
				//split input on white spaces
				String [] tokens = input.trim().split("\\s+");
				String command = tokens[0].toUpperCase();
				String key = "";
				//String body =tokens[2].toUpperCase();;
				if(tokens.length >= 2) {
					key = tokens[1];
					if(tokens.length == 3) {
					    System.out.println("Error! Invalid input");
					} else if (tokens.length >= 3){
					}   
				}
				if ("CLEAR".startsWith(command) ) {
				    if (bodies.isEmpty()){
				        System.out.println("Map is already clear.");
				    } else {
				        bodies.clear();
				    }    
				} else if("PUT".startsWith(command)){
				    Body formerValue = bodies.get(key);
				    String bodyTypeParameter=tokens[2].toUpperCase();
				    // check if bodyType argument was distinct
				    List<String> matchingBodyTypes = new ArrayList<>();
				    final List<String> bodyTypes = Arrays.asList("CUBOID", "CYLINDER", "SPHERE", "PYRAMID");
				    for(String bodyType:bodyTypes) {
				        if (bodyType.startsWith(bodyTypeParameter)){
				            matchingBodyTypes.add(bodyType);
				        }
				    }
				    if (matchingBodyTypes.size() == 0) {
                        System.out.println("Error: Invalid body type " + bodyTypeParameter);   
                    } else if(matchingBodyTypes.size() > 1) {
                        System.out.println("Error: Body type is not distinct " + bodyTypeParameter);
                    } else {
                        if ("CUBOID".startsWith(bodyTypeParameter)){
                            Double xCoordinate=Double.parseDouble(tokens[3]);
                            Double yCoordinate=Double.parseDouble(tokens[4]);
                            Double zCoordinate=Double.parseDouble(tokens[5]);
                            Double lengthCuboid=Double.parseDouble(tokens[6]);
                            Double widthCuboid=Double.parseDouble(tokens[7]);
                            Double heightCuboid=Double.parseDouble(tokens[8]);
                            Vector3D location= new Vector3D(xCoordinate,yCoordinate,zCoordinate);
                            Cuboid cuboid = new Cuboid(location,lengthCuboid, widthCuboid,heightCuboid);
                            bodies.put(key, cuboid);
                        } else if("CYLINDER".startsWith(bodyTypeParameter)){
                            Double xCoordinate=Double.parseDouble(tokens[3]);
                            Double yCoordinate=Double.parseDouble(tokens[4]);
                            Double zCoordinate=Double.parseDouble(tokens[5]);
                            Double radiusCylinder=Double.parseDouble(tokens[6]);
                            Double heightCylinder=Double.parseDouble(tokens[7]);
                            Vector3D location= new Vector3D(xCoordinate,yCoordinate,zCoordinate);
                            Cylinder cylinder = new Cylinder(location, radiusCylinder, heightCylinder);
                            bodies.put(key, cylinder);
                        } else if("PYRAMID".startsWith(bodyTypeParameter)){
                            Double xCoordinate=Double.parseDouble(tokens[3]);
                            Double yCoordinate=Double.parseDouble(tokens[4]);
                            Double zCoordinate=Double.parseDouble(tokens[5]);
                            Double baselengthPyramid=Double.parseDouble(tokens[6]);
                            Double basewidthPyramid=Double.parseDouble(tokens[7]);
                            Double heightPyramid=Double.parseDouble(tokens[8]);
                            Vector3D location= new Vector3D(xCoordinate,yCoordinate,zCoordinate);
                            Pyramid pyramid = new Pyramid(location, baselengthPyramid, basewidthPyramid, heightPyramid);
                            bodies.put(key, pyramid);
                        } else if("SPHERE".startsWith(bodyTypeParameter)){
                            Double xCoordinate=Double.parseDouble(tokens[3]);
                            Double yCoordinate=Double.parseDouble(tokens[4]);
                            Double zCoordinate=Double.parseDouble(tokens[5]);
                            Double radiusSphere=Double.parseDouble(tokens[6]);
                            Vector3D location= new Vector3D(xCoordinate,yCoordinate,zCoordinate);
                            Sphere sphere = new Sphere(location, radiusSphere);
                            bodies.put(key, sphere);
                        }
                        if(formerValue!=null){
                            System.out.println("Error! Key already exists, old value"+formerValue+"has been replaced");
                        }
                    }
				} else if("REMOVE".startsWith(command)) {
				    if(bodies.containsKey(key) && key != null){
				        bodies.remove(key);
				    } else {
				        System.out.println("Error! Key does not exist.");
				    }
				} else if("FIND".startsWith(command)) {
                    Body body=bodies.get(key); 
				    if (bodies.containsKey(key) && key!=null){
				            System.out.println(body.toString());				   
					} else {
						System.out.println("Error! Key does not exist.");
					}
				} else if("SURFACE".startsWith(command)) {
                    Body body=bodies.get(key);
                    if(bodies.containsKey(key) && key!=null){
                        System.out.println(body.getSurface());
                    } else {
                        System.out.println("Error! "+key+" does not exist");
                    }
				} else if(command.startsWith("VOLUME") && command.length()<=6) {
				    Body body=bodies.get(key);
				    if(bodies.containsKey(key) && key!=null){
				        System.out.println(body.getVolume());
				    } else {
				        System.out.println("Error! "+key+" does not exist");
				    }
				} else if("DEBUG".startsWith(command)) {
                    System.out.println(bodies.toString());
				} else if(command.startsWith("OBJECTS")) {
				   Iterator<Body> objectsIterator=bodies.iterator();
				   String string="[";
				   while (objectsIterator.hasNext()){
				       string+=objectsIterator.next().toString();
				       if(objectsIterator.hasNext()) {
				           string+=", ";				           
				       } 
				   }
				   string+="]";
				   System.out.println(string);			
				} else if(command.equals("HELP") || command.equals("H")) {
					System.out.println ("The following commands are supported:");
					System.out.println ("CLEAR      Clears Map");
					System.out.println ("PUT s b    Adds new key s with body b");
	                System.out.println ("FIND s     Prints s");
					System.out.println ("REMOVE s   Deletes key s");
					System.out.println ("SURFACE s  Prints the surface of s");
					System.out.println ("VOLUME s   Prints volume of s");
	                System.out.println ("DEBUG      Prints the whole tree in preorder");
					System.out.println ("OBJECTS    Prints all key-nody-maps as [v1, v2, v3...]");
					System.out.println ("QUIT       Stops the program");
			
				} else if(command.equals("QUIT") || command.equals("Q")) {
					quit = true;
				} else {
					System.out.println("Error! Invalid command.");
				}
			}
		} catch (IOException e) {
			System.out.println("Error! Execution not possible.");
		}
	}

    public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		execute(stdin);
    }
}		