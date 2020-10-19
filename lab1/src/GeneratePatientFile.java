import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GeneratePatientFile {
	static File file = TestPatient.file;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generatePatients();
	}
	
	public static void generatePatients() {
		ArrayList<Patient> alist = new ArrayList<>();
		
		Patient p1 = new Patient(1,"patient1", "doctor", "illness1", "symptom1");
		Patient p2 = new Patient(2,"patient2", "doctor", "illness2", "symptom2");
		Patient p3 = new Patient(3,"patient3", "doctor", "illness3", "symptom3");
		Patient p4 = new Patient(4,"patient4", "doctor", "illness4", "symptom4");
		
		alist.add(p1);
		alist.add(p2);
		alist.add(p3);
		alist.add(p4);
		
//		writePatients(alist);
		writePatientsCustom(alist);
	}

	
	public static void writePatients(List<Patient> list) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Patient x:list) {
				oos.writeObject(x);
			}
			oos.close();
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writePatientsCustom(List<Patient> list) {
		try {
			FileWriter fw = new FileWriter(file);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			for(Patient p: list ) {
				fw.write((p.toString() + "\n"));
			}
			
			fw.close();
		} catch(Exception e) {
			
		}
	}
}
