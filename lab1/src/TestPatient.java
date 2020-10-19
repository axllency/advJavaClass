import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPatient {

	//file with the patient data
	static File file = new File("patientFile.txt");
	
	public static void main(String[] args) {
//		Uncomment below to generate new patients file from data in GeneratePatientFile class
		GeneratePatientFile.generatePatients();
		
		ArrayList<Patient> alist = new ArrayList<>();
		alist = getPatientsFromTxt();
		
		PatientGUI pg = new PatientGUI(alist);
	}
	
	public static ArrayList<Patient> getPatientsFromTxt(){
	    ArrayList<Patient> patients= new ArrayList<Patient>(); 
	    BufferedReader br;
	    try {
	    	br = new BufferedReader(new FileReader(file));
	    	String line = br.readLine();
	    	while(line != null) {
	    		String[] tokens = line.split(",");
	    		if(tokens.length>=5) {
	    			patients.add(new Patient(
	    					Integer.parseInt(tokens[0]),
	    					tokens[1],
	    					tokens[2],
	    					tokens[3],
	    					tokens[4]
	    					));
	    		}
	    		line = br.readLine();
	    	}
	    } catch (Exception e) {
			e.printStackTrace();
		} 
	    return patients;
	}

	public static ArrayList<Patient> getPatients(){

	    ArrayList<Patient> patients= new ArrayList<Patient>(); 
	    FileInputStream fis;
	    ObjectInputStream ois;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Patient patientIn = null;
		    boolean isExist = true;
	
		    while(isExist){
		        if(fis.available() != 0){
					patientIn = (Patient) ois.readObject();
					patients.add(patientIn);
		        }
		        else{
		        isExist =false;
		        ois.close();
		        fis.close();
		        }
		    }
	    } catch (Exception e) {
			e.printStackTrace();
		} 


	    return patients;     
	}
	
}
