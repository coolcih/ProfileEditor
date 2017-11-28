import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProfileEditor extends JFrame implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProfileEditor();

	}
	
	JFrame frame = new JFrame("Profile Editor");
	
	JPanel headerPanel = new JPanel();
	//JScrollPane headerScrollPane=new JScrollPane(headerPanel);
	
	JPanel techMaskPanel=new JPanel();
	JLabel techMaskLabel=new JLabel("Tech Mask");
	JTextField techMaskTextField=new JTextField("N/A");
	static JPanel profileNumberPanel=new JPanel();
	static JLabel profileNumberLabel=new JLabel("Profile Number");
	JTextField profileNumberTextField=new JTextField("N/A");
	static JPanel profileSizePanel=new JPanel();
	static JLabel profileSizeLabel=new JLabel("Profile Size");
	JLabel profileSizeValueLabel=new JLabel("N/A");
	static JPanel numTlvsPanel=new JPanel();
	static JLabel numTlvsLabel=new JLabel("Total TLVs");
	JLabel numTlvs=new JLabel("N/A");
	static JPanel magicNumberPanel=new JPanel();
	static JLabel magicNumberLabel=new JLabel("Magic Number");
	JLabel magicNumber=new JLabel("N/A");
	static JPanel timeCreatedPanel=new JPanel();
	static JLabel timeCreatedLabel=new JLabel("Time Created");
	JLabel timeCreated=new JLabel("N/A");
	static JPanel lastModifiedTimePanel=new JPanel();
	static JLabel lastModifiedTimeLabel=new JLabel("Last Modified Time");
	JLabel lastModifiedTime=new JLabel("N/A");
	static JPanel lastReadTimePanel=new JPanel();
	static JLabel lastReadTimeLabel=new JLabel("Last Read Time");
	JLabel lastReadTime=new JLabel("N/A");
	static JPanel versionPanel=new JPanel();
	static JLabel versionLabel=new JLabel("Version");
	JTextField versionTextField=new JTextField("N/A");
	static JPanel reservedPanel=new JPanel();
	static JLabel reservedLabel=new JLabel("Reserved Bits");
	JLabel reservedBits=new JLabel("N/A");
	
	static JPanel param3gppPane=new JPanel();
	//static JScrollPane param3gppScrollPane=new JScrollPane(param3gppPane);
	static JPanel param3gppItemPane[] = new JPanel[100];
	static JLabel param3gppLabel[] = new JLabel[100];
	static JTextField param3gppTextField[] = new JTextField[100];
	static int param3gppItemCount = 0;
	
	static JPanel param3gpp2Pane=new JPanel();
	static JPanel param3gpp2ItemPane[] = new JPanel[100];
	static JLabel param3gpp2Label[] = new JLabel[100];
	static JTextField param3gpp2TextField[] = new JTextField[100];
	static int param3gpp2ItemCount = 0;
	
	static JPanel paramCommTechPane=new JPanel();
	static JPanel paramCommTechItemPane[] = new JPanel[50];
	static JLabel paramCommTechLabel[] = new JLabel[50];
	static JTextField paramCommTechTextField[] = new JTextField[50];
	static int paramCommTechItemCount = 0;
	
	static JPanel paramGeneralPane=new JPanel();
	static JPanel paramGeneralItemPane[] = new JPanel[50];
	static JLabel paramGeneralLabel[] = new JLabel[50];
	static JTextField paramGeneralTextField[] = new JTextField[50];
	static int paramGeneralItemCount = 0;
	
	JPanel jButtonPane=new JPanel();
	JButton jReadButton = new JButton("Open Profile");
	JButton jWriteButton = new JButton("Write");
	String comboItem[]={"Profile Header","3GPP Parameters","3GPP2 Parameters","Common Tech Parameters","General Parameters"};
	String lastComboItem = "Profile Header";
	JComboBox<String> comboBox=new JComboBox<String>(comboItem);
	
	JTextArea jta=new JTextArea(5,100);
	JScrollPane jsp=new JScrollPane(jta);

	FileReader fr = null;
	List<ProfileTLV> tlvList;
	LinkedHashMap<Integer, JTextField> textFieldList=new LinkedHashMap<Integer, JTextField>();
	
	private File slectedFile=null;
	DataOutputStream out;
	
	public ProfileEditor() {
		JOptionPane.showMessageDialog(ProfileEditor.this, "1. Value display as HEX value.\n"
                + "2. N/A mean no this item in profile or remove item from profile.\n");
		
		this.setTitle("Profile Editor");
		this.setSize(800,800);
		this.setLocation(100,260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jReadButton.setBounds(500,10,150,30);
		jWriteButton.setBounds(700,10,150,30);
		comboBox.setBounds(270,10,180,30);
		
		jButtonPane.setLayout(null);
		jButtonPane.setPreferredSize(new Dimension(0, 50));
		jButtonPane.add(jReadButton);
		jButtonPane.add(jWriteButton);
		jButtonPane.add(comboBox);
		comboBox.addItemListener(this);
		this.getContentPane().add(jButtonPane, BorderLayout.NORTH);

		this.getContentPane().add(jsp, BorderLayout.SOUTH);
		
		//Profile Header
		headerPanel.setBorder(new EmptyBorder(5,5,5,5));
		headerPanel.setLayout(new GridLayout(10,2,1,1));

		techMaskTextField.setColumns(10);
		techMaskPanel.add(techMaskLabel);
		techMaskPanel.add(techMaskTextField);
		headerPanel.add(techMaskPanel);
		
		profileNumberTextField.setColumns(10);
		profileNumberPanel.add(profileNumberLabel);
		profileNumberPanel.add(profileNumberTextField);
		headerPanel.add(profileNumberPanel);
		
		profileSizePanel.add(profileSizeLabel);
		profileSizePanel.add(profileSizeValueLabel);
		headerPanel.add(profileSizePanel);
		
		numTlvsPanel.add(numTlvsLabel);
		numTlvsPanel.add(numTlvs);
		headerPanel.add(numTlvsPanel);
		
		magicNumberPanel.add(magicNumberLabel);
		magicNumberPanel.add(magicNumber);
		headerPanel.add(magicNumberPanel);
		
		timeCreatedPanel.add(timeCreatedLabel);
		timeCreatedPanel.add(timeCreated);
		headerPanel.add(timeCreatedPanel);
		
		lastModifiedTimePanel.add(lastModifiedTimeLabel);
		lastModifiedTimePanel.add(lastModifiedTime);
		headerPanel.add(lastModifiedTimePanel);
		
		lastReadTimePanel.add(lastReadTimeLabel);
		lastReadTimePanel.add(lastReadTime);
		headerPanel.add(lastReadTimePanel);
		
		versionTextField.setColumns(10);
		versionPanel.add(versionLabel);
		versionPanel.add(versionTextField);
		headerPanel.add(versionPanel);
		
		reservedPanel.add(reservedLabel);
		reservedPanel.add(reservedBits);
		headerPanel.add(reservedPanel);
				
		//Profile Content
		param3gppPane.setBorder(new EmptyBorder(5,5,5,5));	
		param3gppPane.setLayout(new GridLayout(20,2,1,1));

		param3gpp2Pane.setBorder(new EmptyBorder(5,5,5,5));	
		param3gpp2Pane.setLayout(new GridLayout(20,1,1,1));
		
		paramCommTechPane.setBorder(new EmptyBorder(5,5,5,5));	
		paramCommTechPane.setLayout(new GridLayout(20,1,1,1));
		
		paramGeneralPane.setBorder(new EmptyBorder(5,5,5,5));	
		paramGeneralPane.setLayout(new GridLayout(20,1,1,1));

        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
    	for( ProfileType type : ProfileType.values()){
    		if(type.is3GPPKey()) {
    			param3gppItemPane[i] = new JPanel();
	   			String labelString = null;
      			labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
    			param3gppLabel[i] = new JLabel(labelString); 
      			param3gppTextField[i]=new JTextField("N/A");
    			param3gppTextField[i].setColumns(10);
    			//param3gppItemPane[i] = new JPanel();
    			param3gppItemPane[i].add(param3gppLabel[i]);
    			param3gppItemPane[i].add(param3gppTextField[i]); 
    			param3gppPane.add(param3gppItemPane[i]);
    			textFieldList.put(type.getTypeKey(), param3gppTextField[i]);
    			i++;
    		} else if(type.is3GPP2Key()) {
    			param3gpp2ItemPane[j] = new JPanel();
	   			String labelString = null;
      			labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
      			param3gpp2Label[j] = new JLabel(labelString); 
      			param3gpp2TextField[j]=new JTextField("N/A");
    			param3gpp2TextField[j].setColumns(10);
    			param3gpp2ItemPane[j].add(param3gpp2Label[j]);
    			param3gpp2ItemPane[j].add(param3gpp2TextField[j]); 
    			param3gpp2Pane.add(param3gpp2ItemPane[j]);
    			textFieldList.put(type.getTypeKey(), param3gpp2TextField[j]);
    			j++;
    		} else if(type.isCommonTechKey()) {
    			paramCommTechItemPane[k] = new JPanel();
	   			String labelString = null;
      			labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
      			paramCommTechLabel[k] = new JLabel(labelString); 
      			paramCommTechTextField[k]=new JTextField("N/A");
      			paramCommTechTextField[k].setColumns(10);
      			paramCommTechItemPane[k].add(paramCommTechLabel[k]);
      			paramCommTechItemPane[k].add(paramCommTechTextField[k]); 
      			paramCommTechPane.add(paramCommTechItemPane[k]);
      			textFieldList.put(type.getTypeKey(), paramCommTechTextField[k]);
    			k++;
    		} else if(type.isGeneralKey()) {
    			paramGeneralItemPane[l] = new JPanel();
	   			String labelString = null;
      			labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
      			paramGeneralLabel[l] = new JLabel(labelString); 
      			paramGeneralTextField[l]=new JTextField("N/A");
      			paramGeneralTextField[l].setColumns(10);
      			paramGeneralItemPane[l].add(paramGeneralLabel[l]);
      			paramGeneralItemPane[l].add(paramGeneralTextField[l]); 
      			paramGeneralPane.add(paramGeneralItemPane[l]);
      			textFieldList.put(type.getTypeKey(), paramGeneralTextField[l]);
    			l++;
    		}
    		
    		param3gppItemCount = i;
    		param3gpp2ItemCount = j;
    		paramCommTechItemCount = k;
    		paramGeneralItemCount = l;
    	}
	
    	this.getContentPane().add(headerPanel, BorderLayout.CENTER);

		// 为一般按钮添加动作监听器
		jReadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        jfc.showDialog(new JLabel(), "选择");  
		        slectedFile=jfc.getSelectedFile();  
		        if(slectedFile.isDirectory()){  
		            System.out.println("文件夹:"+slectedFile.getAbsolutePath());  
		        }else if(slectedFile.isFile()){  
		            System.out.println("文件:"+slectedFile.getAbsolutePath());  
		        }  
		        System.out.println(jfc.getSelectedFile().getName());
		        
		        byte[] buff = readFile(slectedFile.getAbsolutePath());
		        
		        ProfileHeader prfHeader = new ProfileHeader(buff);
		        jta.append("======== Profile Header ========\n");
		        String temp = null;
		        temp = String.format("0x%x", prfHeader.getProfileHeaderTechMask());
		        jta.append("techMask: " + temp + "\n");
		        techMaskTextField.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderProfileNumber());
		        jta.append("profileNumber: " + temp + "\n");
		        profileNumberTextField.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderProfileSize());
		        jta.append("ProfileSize: " + temp + "\n");
		        profileSizeValueLabel.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderNumTlvs());
		        jta.append("NumTlvs: " + temp + "\n");
		        numTlvs.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderMagicNumber());
		        jta.append("MagicNumber: " + temp + "\n");
		        magicNumber.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderTimerCreated());
		        jta.append("TimerCreated: " + temp + "\n");
		        timeCreated.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderLastModifiedTime());
		        jta.append("LastModifiedTime: " + temp + "\n");
		        lastModifiedTime.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderLastReadTime());
		        jta.append("LastReadTime: " + temp + "\n");
		        lastReadTime.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderVersion());
		        jta.append("Version: " + temp + "\n");
		        versionTextField.setText(temp);
		        temp = String.format("0x%x", prfHeader.getProfileHeaderReservedBytes());
		        jta.append("ReservedBytes: " + temp + "\n");
		        reservedBits.setText(temp);
		        
		        jta.append("\n======== Profile Content ========\n");
		        ProfileAnalyze profileAnalyze = new ProfileAnalyze();
		        tlvList = profileAnalyze.unpack(buff, prfHeader.getProfileHeaderLen());
		        
		        for (int i = 0; i < tlvList.size(); i++) {
		        	String tlvString = null;
		        	ProfileTLV Item = tlvList.get(i);
		        	System.out.print("TLV " + i + "\n");
		        	System.out.println("T: " + Integer.toHexString(Item.getTag()) + " - L: " + Item.getLen() + " - V:" + Item.getValueString());
		        	tlvString = String.format("T: 0x%x - L: %d - V: %s\n", Item.getTag(), Item.getLen(), Item.getValueString());
		        	jta.append(tlvString);
		        	textFieldList.get(Item.getTag()).setText("0x" + Item.getValueString());
		        }
			}
		});
		
		jWriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser fileChooser=new JFileChooser();
				byte[] buff;
				ProfileHeader prfHeader;
				int profileSize;
				
				/*
				//Check input validate
		        Set<Map.Entry<Integer, JTextField>> set;
		        Iterator<Map.Entry<Integer, JTextField>> iterator;
		        
		        set = textFieldList.entrySet();
		        iterator = set.iterator();
		        while (iterator.hasNext()) {
		        	Entry<Integer, JTextField> entry= iterator.next();
		        	String regex = "([A-F]|[a-f]|[0-9]){0,}";
		            //System.out.print(entry.getKey() + "=" + entry.getValue().getText() + "\n");
		        	String input = entry.getValue().getText();
		        	input = input.trim().replace(" ", "").toLowerCase(Locale.US);
		        	input = input.trim().replace("0x", "");

		        	if(!input.equalsIgnoreCase("N/A") && (input.length()%2) != 0) {
		            	String temp;
		            	temp = String.format("Key 0x%x:\nInput value should be byte align e.g. 0x1 must input 0x01.", entry.getKey());
		        		JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		        	}
		        	
		            if(!input.equalsIgnoreCase("N/A") && !input.matches(regex)) {
		            	String temp;
		            	temp = String.format("Key 0x%x:\nInvalid charactor! Only 0-9 A-F a-f allowed", entry.getKey());
		            	JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		            }
		        }
				*/
				
				System.out.print("=============== Check 3gpp param " + param3gppItemCount + " ===============\n");
				//Check input validate
				String regex = "([A-F]|[a-f]|[0-9]){0,}";
				for(int i = 0; i < param3gppItemCount; i++) {
					
					String input = param3gppTextField[i].getText();
		        	input = input.trim().replace(" ", "").toLowerCase(Locale.US);
		        	input = input.trim().replace("0x", "");
		        	System.out.println(i + input);
		        	if(!input.equalsIgnoreCase("N/A") && (input.length()%2) != 0) {
		            	String temp;
		            	temp = String.format("3GPP param - %s:\nInput value should be byte align e.g. 0x1 must input 0x01.", param3gppLabel[i].getText());
		        		JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		        	}
		        	
		            if(!input.equalsIgnoreCase("N/A") && !input.matches(regex)) {
		            	String temp;
		            	temp = String.format("3GPP param - %s:\nInvalid charactor! Only 0-9 A-F a-f allowed", param3gppLabel[i].getText());
		            	JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		            }
				}
				
				System.out.print("=============== Check 3gpp2 param " + param3gpp2ItemCount + " ===============\n");
				for(int j = 0; j < param3gpp2ItemCount; j++) {
					String input = param3gpp2TextField[j].getText();
		        	input = input.trim().replace(" ", "").toLowerCase(Locale.US);
		        	input = input.trim().replace("0x", "");

		        	if(!input.equalsIgnoreCase("N/A") && (input.length()%2) != 0) {
		            	String temp;
		            	temp = String.format("3GPP2 param - %s:\nInput value should be byte align e.g. 0x1 must input 0x01.", param3gpp2Label[j].getText());
		        		JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		        	}
		        	
		            if(!input.equalsIgnoreCase("N/A") && !input.matches(regex)) {
		            	String temp;
		            	temp = String.format("3GPP2 param - %s:\nInvalid charactor! Only 0-9 A-F a-f allowed", param3gpp2Label[j].getText());
		            	JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		            }
				}
				
				System.out.print("=============== Check common tech param " + paramCommTechItemCount + " ===============\n");
				for(int i = 0; i < paramCommTechItemCount; i++) {
					String input = paramCommTechTextField[i].getText();
		        	input = input.trim().replace(" ", "").toLowerCase(Locale.US);
		        	input = input.trim().replace("0x", "");

		        	if(!input.equalsIgnoreCase("N/A") && (input.length()%2) != 0) {
		            	String temp;
		            	temp = String.format("Common tech param - %s:\nInput value should be byte align e.g. 0x1 must input 0x01.", paramCommTechLabel[i].getText());
		        		JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		        	}
		        	
		            if(!input.equalsIgnoreCase("N/A") && !input.matches(regex)) {
		            	String temp;
		            	temp = String.format("Common tech param - %s:\nInvalid charactor! Only 0-9 A-F a-f allowed", paramCommTechLabel[i].getText());
		            	JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		            }
				}
				
				System.out.print("=============== Check general param " + paramGeneralItemCount + " ===============\n");
				for(int i = 0; i < paramGeneralItemCount; i++) {
					String input = paramGeneralTextField[i].getText();
		        	input = input.trim().replace(" ", "").toLowerCase(Locale.US);
		        	input = input.trim().replace("0x", "");

		        	if(!input.equalsIgnoreCase("N/A") && (input.length()%2) != 0) {
		            	String temp;
		            	temp = String.format("General tech param - %s:\nInput value should be byte align e.g. 0x1 must input 0x01.", paramGeneralLabel[i].getText());
		        		JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		        	}
		        	
		            if(!input.equalsIgnoreCase("N/A") && !input.matches(regex)) {
		            	String temp;
		            	temp = String.format("General tech param - %s:\nInvalid charactor! Only 0-9 A-F a-f allowed", paramGeneralLabel[i].getText());
		            	JOptionPane.showMessageDialog(ProfileEditor.this, temp);
		            	return;
		            }
				}
				
				System.out.print("=============== Write button ===============\n");
				
				if(slectedFile != null) {
					buff = readFile(slectedFile.getAbsolutePath());
					prfHeader = new ProfileHeader(buff);
			        ProfileAnalyze profileAnalyze = new ProfileAnalyze();
			        tlvList = profileAnalyze.unpack(buff, prfHeader.getProfileHeaderLen());
			        
			        Set<Map.Entry<Integer, JTextField>> set = textFieldList.entrySet();
			        Iterator<Map.Entry<Integer, JTextField>> iterator = set.iterator();
			        set = textFieldList.entrySet();
			        iterator = set.iterator();
			        
			        while (iterator.hasNext())
			        {
			        	Entry<Integer, JTextField> entry= iterator.next();
			        	boolean found = false;
			            System.out.print(entry.getKey() + "=" + entry.getValue().getText() + "\n");
			            if(!entry.getValue().getText().equalsIgnoreCase("N/A")) {
			            	for(int i = 0; i < tlvList.size(); i++) {
			            		ProfileTLV entryTLV = tlvList.get(i);
			            		if(entryTLV.getTag() == entry.getKey()) {
			            			entryTLV.setValue(entry.getValue().getText());
			            			tlvList.set(i, entryTLV);
			            			found = true;
			            			System.out.print("Found " + entry.getKey() + "=" + entryTLV.getValueString() + "\n");
			            			break;
			            		}
			            	}
			            	
			            	if(!found) {
			            		ProfileTLV entryTLV = new ProfileTLV(entry.getKey(), entry.getValue().getText());
			            		tlvList.add(entryTLV);			            		
			            	}
			            } else {
			            	for(int i = 0; i < tlvList.size(); i++) {
			            		ProfileTLV entryTLV = tlvList.get(i);
			            		if(entryTLV.getTag() == entry.getKey()) {
			            			tlvList.remove(i);
			            			break;
			            		}
			            	}
			            }
			        }
				} else {
					buff = new byte[32];
					prfHeader = new ProfileHeader();
				}
				
		        //Calculate profile size
		        profileSize = 0; //Without header
		        for(int i = 0; i < tlvList.size(); i++) {
		        	profileSize += 4; //T and L
		        	profileSize += tlvList.get(i).getLen();
            	}
		        System.out.print("New profile size:" + profileSize + "\n");
		        
		        byte[] newBuff = new byte[profileSize + prfHeader.getProfileHeaderLen()];
		        int offset = 32;
		     		        
		        for(int i = 0; i < tlvList.size(); i++) {
		        	ProfileTLV entryTLV = tlvList.get(i);
		        	short len;
		        	System.out.print("TLV " + i + "\n");
		        	//Fill T
		        	newBuff[offset++] = (byte)(entryTLV.getTag() & 0xFF);
		        	System.out.print("T newBuff[" + (offset-1) + "]" + newBuff[offset-1] + "\n");
		        	newBuff[offset++] = (byte)(entryTLV.getTag() >> 8 & 0xFF);
		        	System.out.print("T newBuff[" + (offset-1) + "]" + newBuff[offset-1] + "\n");
		        	//Fill L
		        	len = (short)entryTLV.getLen();
		        	newBuff[offset++] = (byte)(len & 0xFF);
		        	System.out.print("L newBuff[" + (offset-1) + "]" + newBuff[offset-1] + "\n");
		        	newBuff[offset++] = (byte)(len >> 8 & 0xFF);
		        	System.out.print("L newBuff[" + (offset-1) + "]" + newBuff[offset-1] + "\n");
		        	//Fill V
		        	//System.arraycopy(entryTLV.getValue(), 0, newBuff, offset, len);
		        	byte[] temp = entryTLV.getValue();
		        	for(int j = 0; j < len; j++) {
		        		//newBuff[offset + j] = temp[len -1 - j];
		        		newBuff[offset + j] = temp[j];
		        	}
		        	offset += len;
		        }
		        
		        //Update profile header		        
				String techMask = techMaskTextField.getText().trim();
				System.out.println("New techMask: " + techMask);
				prfHeader.putProfileHeaderTechMask(newBuff, techMask); 
				
				String profileNumber =  profileNumberTextField.getText().trim();
				System.out.println("New profileNumber: " + profileNumber);
				prfHeader.putProfileHeaderProfileNumber(newBuff, profileNumber);
				
				System.out.println("New profileSize: " + profileSize);
				prfHeader.putProfileHeaderProfileSize(newBuff, profileSize);
				profileSizeValueLabel.setText(String.format("0x%x", profileSize));
				
				int numTlvs = tlvList.size();
				System.out.println("New numTlvs: " + numTlvs);
				prfHeader.putProfileHeaderNumTlvs(newBuff, numTlvs);
				
				int magicNumber = 0xa5a5a5a5;
				System.out.println("New magicNumber: " + magicNumber);
				prfHeader.putProfileHeaderMagicNumber(newBuff, magicNumber);
				
				int timeCreated = prfHeader.getProfileHeaderTimerCreated(); //TODO
				System.out.println("New timeCreated: " + timeCreated);
				prfHeader.putProfileHeaderTimeCreated(newBuff, timeCreated);
				
				int lastModifiedTime = prfHeader.getProfileHeaderLastModifiedTime(); //TODO
				System.out.println("New lastModifiedTime: " + lastModifiedTime);
				prfHeader.putProfileHeaderLastModifiedTime(newBuff, lastModifiedTime);
				
				int lastReadTime = prfHeader.getProfileHeaderLastReadTime(); //TODO
				System.out.println("New lastReadTime: " + lastReadTime);
				prfHeader.putProfileHeaderLastReadTime(newBuff, lastReadTime);

				String version = versionTextField.getText().trim(); //TODO
				System.out.println("New version: " + version);
				if(version.equals("N/A")) version = "0x0000";
				prfHeader.putProfileHeaderVersion(newBuff, version);
				
				int select = fileChooser.showSaveDialog(ProfileEditor.this);
				
				File file = null;

				String fileName = null;
				if(select==JFileChooser.APPROVE_OPTION){
					file =fileChooser.getSelectedFile(); //如果这里并没有选取中任何的文件，下面的fileChooser.getName(file)将会返回手输入的文件名 
				}
				fileName = fileChooser.getName(file);
				if(fileName==null|| fileName.trim().length()==0){
					JOptionPane.showMessageDialog(ProfileEditor.this, "文件名为空！");
				}

				if(file.isFile()){
					fileName = file.getName();
				}
				
				//否则是个文件夹
				file = fileChooser.getCurrentDirectory();//获得当前目录

				String path = file.getPath()+java.io.File.separator+fileName;
				file =new File(path);

				if(file.exists()) { //若选择已有文件----询问是否要覆盖
					int i = JOptionPane.showConfirmDialog(ProfileEditor.this, "该文件已经存在，确定要覆盖吗？");
					if(i == JOptionPane.YES_OPTION);
					else return;
				}

				try {
					out=new DataOutputStream(new FileOutputStream(path));
					out.write(newBuff);
					out.close();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(ProfileEditor.this, "文件保存出错"+e1.getMessage());
				} catch (IOException e1) {
					e1.printStackTrace();
				}finally{
					try {
						if(out!=null) out.close();
					} catch (IOException e1) {
					}
				}
			}
		});
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			this.getContentPane().remove(headerPanel);
			this.getContentPane().remove(param3gppPane);
			this.getContentPane().remove(param3gpp2Pane);
			this.getContentPane().remove(paramCommTechPane);
			this.getContentPane().remove(paramGeneralPane);

			if(comboBox.getSelectedItem()=="Profile Header") {
				System.out.println("选择了Profile Header");
				
				if(slectedFile != null) {
					
				} else {

				}

				this.getContentPane().add(headerPanel, BorderLayout.CENTER);
				this.getContentPane().repaint();
				this.setVisible(true);
				return;
			}
			
			if(comboBox.getSelectedItem()=="3GPP Parameters") {
				System.out.println("选择了3GPP Parameters");
		    	this.getContentPane().add(param3gppPane, BorderLayout.CENTER);
		    	this.getContentPane().repaint();
		    	this.setVisible(true);
		    	return;
			}
			
			if(comboBox.getSelectedItem()=="3GPP2 Parameters") {
				System.out.println("选择了3GPP2 Parameters");
		    	this.getContentPane().add(param3gpp2Pane, BorderLayout.CENTER);
		    	this.getContentPane().repaint();
		    	this.setVisible(true);
		    	return;
			}
			
			if(comboBox.getSelectedItem()=="Common Tech Parameters") {
				System.out.println("选择了Common Tech Parameters");
		    	this.getContentPane().add(paramCommTechPane, BorderLayout.CENTER);
		    	this.getContentPane().repaint();
		    	this.setVisible(true);
		    	return;
			}
			
			if(comboBox.getSelectedItem()=="General Parameters") {
				System.out.println("选择了General Parameters");
		    	this.getContentPane().add(paramGeneralPane, BorderLayout.CENTER);
		    	this.getContentPane().repaint();
		    	this.setVisible(true);
		    	return;
			}
		}
	}
	
	public byte[] readFile(String filename2){
		byte[] buffer = null;

		try {
			File file = new File(filename2);
			long fileSize = file.length();
			FileInputStream fi = new FileInputStream(file);
			buffer = new byte[(int) fileSize];
			int offset = 0;
			int numRead = 0;
			while (offset < buffer.length
					&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
				offset += numRead;
			}
			
			// 确保所有数据均被读取
			if (offset != buffer.length) {
				fi.close();
				throw new IOException("Could not completely read file " + file.getName());
			}
			
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{

		}
		return buffer;
	}
}


