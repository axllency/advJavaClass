import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable{

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	String name;
	int id;
	String doctor;
	String illness;
	String symptom;
	
	public Patient() {
		this.id = -1;
		this.name= null;
		this.doctor = null;
		this.illness = null;
		this.symptom = null;
	}
	
	public Patient(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name=name;
		this.doctor = "";
		this.illness = "";
		this.symptom = "";
		
	}

	public Patient(int id, String name, String doctor, String illness, String symptom) {
		this.id = id;
		this.name=name;
		this.doctor = doctor;
		this.illness = illness;
		this.symptom = symptom;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException 
    {       
        this.id = aInputStream.readInt();
        this.name = aInputStream.readUTF();
        this.doctor = aInputStream.readUTF();
        this.illness= aInputStream.readUTF();
        this.symptom = aInputStream.readUTF();
    }
 
    private void writeObject(ObjectOutputStream aOutputStream) throws IOException 
    {
    	aOutputStream.writeInt(id);
        aOutputStream.writeUTF(name);
        aOutputStream.writeUTF(doctor);
        aOutputStream.writeUTF(illness);
        aOutputStream.writeUTF(symptom);

    }

    @Override
    public String toString() {
    	return "" + this.id + "," + this.name + "," + this.doctor + "," + this.illness + "," + this.symptom;
    }
	

}
