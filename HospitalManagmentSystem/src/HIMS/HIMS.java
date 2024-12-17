package HIMS;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Dimension;


public class HIMS {
    static List<String> name = new ArrayList<String>();
    static List<String> ids = new ArrayList<String>(); 
    static List<String> roomNo = new ArrayList<String>(); 
    static List<String> admitDate = new ArrayList<String>();

    static List<String> did=new ArrayList<String>();
    static List<String> pid=new ArrayList<String>();
    static List<String> date=new ArrayList<String>();

    static JPanel panel = new JPanel();
    static JFrame jf = new JFrame("Hospital Information Management System");
    static JScrollPane scrollPane = new JScrollPane(panel); 

    static JLabel label = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
    static final JButton go=new JButton("Add paitent information");
    static final JButton dc=new JButton("See doctors name");
    static final JButton ap=new JButton("Add appintments for doctors");
    static JButton disp=new JButton("Display Paitent");
    public static void main(String args[]) {

    jf.setSize(800, 500);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
    panel.add(label);
    
	panel.add(go);
	go.addActionListener( a->
	{
	   paitent();
	});
	
	panel.add(dc);
	dc.addActionListener(a->
	{
		doctor();
	});
	
	panel.add(ap);
	ap.addActionListener(a->
	{
		addApintment();		
	});
	jf.add(scrollPane);
	jf.setVisible(true);
    }

    public static void paitent()
    {
	JTextField[] inputFields = addData(panel);

    JButton submitButton = new JButton("Submit");

     submitButton.addActionListener(e ->
	 {   
        ids.add(inputFields[0].getText());
        name.add(inputFields[1].getText());
        roomNo.add(inputFields[2].getText());
        admitDate.add(inputFields[3].getText());

	 });

    panel.add(submitButton);
    panel.revalidate(); 
    panel.repaint(); 
   
	panel.add(disp);
	disp.addActionListener( d->
	{
	StringBuilder patientDetails = new StringBuilder();
	
	for(int i=0;i<ids.size();i++)
	{
		patientDetails.append("Paitent id : ").append(ids.get(i)).append(" Name : ").append(name.get(i)).append(" Room number : ").append(roomNo.get(i))
						.append(" Admit Date : ").append(admitDate.get(i)).append("<br><br>");
	}
	JLabel j=new JLabel("<html>"+patientDetails+"</html>");
	panel.add(j);
	panel.revalidate(); 
    panel.repaint(); 
	});
    
	panel.add(dc);
	panel.add(go);
	panel.add(ap);
    }

    public static JTextField[] addData(JPanel panel) {
	JLabel label = new JLabel("<html><br></html>");
	panel.add(label);
        JLabel idLabel = new JLabel("Enter Patient ID:");
        JTextField idField = new JTextField(15);
        idField.setPreferredSize(new Dimension(200, 30));
        panel.add(idLabel);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Enter Patient Name:");
        JTextField nameField = new JTextField(15);
        nameField.setPreferredSize(new Dimension(200,30));
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel roomLabel = new JLabel("Enter Patient Room Number:");
        JTextField roomField = new JTextField(15);
        roomField.setPreferredSize(new Dimension(200,30));
        panel.add(roomLabel);
        panel.add(roomField);

        JLabel dateLabel = new JLabel("Enter Patient Admit Date:");
        JTextField dateField = new JTextField(15);
        dateField.setPreferredSize(new Dimension(200,30));
        panel.add(dateLabel);
        panel.add(dateField);

        return new JTextField[]{idField, nameField, roomField, dateField};
    }

   public static void doctor()
   {
	List<String> did=new ArrayList<String>();
	List<String> dname=new ArrayList<String>();
	List<String> dspecialisation=new ArrayList<String>();
	did.add("01");
	dname.add("AAA");
	dspecialisation.add("DHMS");
	did.add("02");
	dname.add("BBB");
	dspecialisation.add("MS");
	did.add("03");
	dname.add("CCC");
	dspecialisation.add("MD");
	did.add("04");
	dname.add("DDD");
	dspecialisation.add("MBBS");
	did.add("05");
	dname.add("EEE");
	dspecialisation.add("Neuro");
	doctorDisp(did,dname,dspecialisation);
   }

   public static void doctorDisp(List<String> did,List<String> dname,List<String> dspecialisation)
   {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < did.size(); i++) 
	{
      sb.append("Doctor's ID: ").append(did.get(i))
      .append("      Doctor's Name: ").append(dname.get(i))
      .append("      Doctor's Specialisation: ").append(dspecialisation.get(i)).append("<br><br>");
	}

	JLabel label = new JLabel("<html>" + sb + "</html>");


	panel.add(label);

	panel.revalidate();
	panel.repaint();


	panel.add(go);
	panel.add(ap);
   }
   
   public static void addApintment() {
	    JLabel didLabel = new JLabel("Enter Doctor's ID: ");
	    JTextField didField = new JTextField(10);
	    panel.add(didLabel);
	    panel.add(didField);

	    JLabel pidLabel = new JLabel("Enter Patient's ID: ");
	    JTextField pidField = new JTextField(10);
	    panel.add(pidLabel);
	    panel.add(pidField);

	    JLabel dateLabel = new JLabel("Enter Appointment Date: ");
	    JTextField dateField = new JTextField(10);
	    panel.add(dateLabel);
	    panel.add(dateField);

	    JButton submitAppointmentButton = new JButton("Submit Appointment");
	    panel.add(submitAppointmentButton);

	    submitAppointmentButton.addActionListener(e -> {
	        did.add(didField.getText());
	        pid.add(pidField.getText());
	        date.add(dateField.getText());

	        JButton displayAppointmentButton = new JButton("Display Appointments");
	        panel.add(displayAppointmentButton);
	        panel.revalidate();
	        panel.repaint();

	        displayAppointmentButton.addActionListener(d -> dispAppointments());
	    });

	    panel.revalidate();
	    panel.repaint();
	}

	public static void dispAppointments() {
	    StringBuilder appointmentDetails = new StringBuilder();
	    for (int i = 0; i < did.size(); i++) {
	        appointmentDetails.append("<br><br>Doctor's ID: ").append(did.get(i))
	                .append(", Patient's ID: ").append(pid.get(i))
	                .append(", Appointment Date: ").append(date.get(i));
	    }

	    JLabel appointmentsLabel = new JLabel("<html>" + appointmentDetails + "</html>");
	    panel.add(appointmentsLabel);

	    panel.revalidate();
	    panel.repaint();
	    panel.add(dc);
	    panel.add(go);
		panel.add(ap);
	}

}