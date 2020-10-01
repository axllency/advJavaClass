import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

public class PatientGUI extends JFrame {

	ArrayList<Patient> plist;

	public PatientGUI(ArrayList<Patient> list) {

		plist = list;

		createPatientUI(plist);

	}

	private void createPatientUI(ArrayList<Patient> list) {
		{
			JFrame jframe = new JFrame("Patient GUI");

			jframe.setLayout(null);

			JLabel pld = new JLabel("Patient's ID");

			pld.setBounds(10, 50, 150, 20);

			//populate the contents of pldtxt
			Integer[] idArray = new Integer[list.size()];
			int i = 0;
			for(Patient patient : list) {
				idArray[i] = patient.getId();
				i++;
			}
			
			JComboBox<Integer> pldtxt = new JComboBox(idArray);

			pldtxt.setBounds(200, 50, 150, 20);

			JLabel pName = new JLabel("Name ");

			pName.setBounds(10, 80, 150, 20);

			JTextField pNametxt = new JTextField("");

			pNametxt.setBounds(200, 80, 150, 20);
			
			//extra labels
			JLabel pDoctor = new JLabel("Doctor");
			pDoctor.setBounds(10, 110, 150, 20);
			
			JTextField pDoctorText = new JTextField("");
			pDoctorText.setBounds(200, 110, 150, 20);
			
			JLabel pIllness = new JLabel("Illness");
			pIllness.setBounds(10, 140, 150, 20);
			
			JTextField pIllnessText = new JTextField("");
			pIllnessText.setBounds(200, 140, 150, 20);
			
			JLabel pSymptom = new JLabel("Symptom");
			pSymptom.setBounds(10, 170, 150, 20);
			
			JTextField pSymptomText = new JTextField("");
			pSymptomText.setBounds(200, 170, 150, 20);
			
			;

			JButton printToFileButton = new JButton("PrintToFile");
			printToFileButton.setBounds(10, 220, 70, 20);

			JButton populateButton = new JButton("Populate Patient's Details");
			populateButton.setBounds(100, 220, 150, 20);
			
			JButton exitButton = new JButton("Exit");
			exitButton.setBounds(270, 220, 60, 20);;

			printToFileButton.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					// Get selected name from combox as shown below

					int id = (int) pldtxt.getSelectedItem();

					// go through the Player array list,

					// print the details of the selected Player to a file.
					for (Patient p : plist) {

						if (id == p.id) {

							try {
								PrintWriter fw = new PrintWriter("patient.txt");
								fw.write(p.toString());

								fw.close();
							} catch (Exception ec) {

								System.out.println(" " + ec);

							}

						}

					}
				}

			}

			);

			populateButton.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					// Get selected name from combox, go through the Player array list,

					int id = (int) pldtxt.getSelectedItem();
					for (Patient p : plist) {

						if (id == p.id) {

							pNametxt.setText(p.name);
							pDoctorText.setText(p.getDoctor());
							pIllnessText.setText(p.getIllness());
							pSymptomText.setText(p.getSymptom());

						}

					}

					// and populate the GUI with proper details

				}

			});
			
			pldtxt.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

					// Get selected name from combox, go through the Player array list,

					int id = (int) pldtxt.getSelectedItem();
					for (Patient p : plist) {

						if (id == p.id) {

							pNametxt.setText(p.name);
							pDoctorText.setText(p.getDoctor());
							pIllnessText.setText(p.getIllness());
							pSymptomText.setText(p.getSymptom());

						}

					}

					// and populate the GUI with proper details

				}

			});
			
			exitButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jframe.dispatchEvent(new WindowEvent(jframe, WindowEvent.WINDOW_CLOSING));
					//alternatively:
					//jframe.dispose();
				}
			});

			jframe.add(pld);

			jframe.add(pldtxt);

			jframe.add(pName);

			jframe.add(pNametxt);

			jframe.add(populateButton);

			jframe.add(printToFileButton);
			
			jframe.add(exitButton);
			
			jframe.add(pDoctor);
			jframe.add(pDoctorText);
			
			jframe.add(pIllness);
			jframe.add(pIllnessText);
			
			jframe.add(pSymptom);
			jframe.add(pSymptomText);
			
			jframe.setSize(400, 300);

			jframe.setVisible(true);

			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	
	}
	
//	public void populateIdBox(ArrayList<Patient> list) {
//		int[] idArray = new int[list.size()];
//		int i = 0;
//		for(Patient patient : list) {
//			idArray[i] = patient.getId();
//			i++;
//		}
//		
//		for(int index : idArray) {
//			
//		}
//	}
}
