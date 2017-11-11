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

public class ProfileEditor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProfileEditor();

	}
	
	JFrame frame = new JFrame("Profile Editor");
	
	JPanel jButtonPane=new JPanel();
	JButton jReadButton = new JButton("Open Profile");
	JButton jWriteButton = new JButton("Write");
	
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
		
		//Profile Header
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new EmptyBorder(5,5,5,5));
		headerPanel.setLayout(new GridLayout(20,1,1,1));
		JLabel profileHeaderLabel=new JLabel("Profile Header:");
		JLabel profileHeaderLabel2=new JLabel("        ");
		headerPanel.add(profileHeaderLabel);
		headerPanel.add(profileHeaderLabel2);
		JLabel techMaskLabel=new JLabel("Tech Mask");
		JTextField techMaskTextField=new JTextField("N/A");
		techMaskTextField.setColumns(10);
		headerPanel.add(techMaskLabel);
		headerPanel.add(techMaskTextField);
		JLabel profileNumberLabel=new JLabel("Profile Number");
		JTextField profileNumberTextField=new JTextField("N/A");
		profileNumberTextField.setColumns(10);
		headerPanel.add(profileNumberLabel);
		headerPanel.add(profileNumberTextField);
		JLabel profileSizeLabel=new JLabel("Profile Size");
		JLabel profileSize=new JLabel("N/A");
		headerPanel.add(profileSizeLabel);
		headerPanel.add(profileSize);
		JLabel numTlvsLabel=new JLabel("Total TLVs");
		JLabel numTlvs=new JLabel("N/A");
		headerPanel.add(numTlvsLabel);
		headerPanel.add(numTlvs);
		JLabel magicNumberLabel=new JLabel("Magic Number");
		JLabel magicNumber=new JLabel("N/A");
		headerPanel.add(magicNumberLabel);
		headerPanel.add(magicNumber);
		JLabel timeCreatedLabel=new JLabel("Time Created");
		JLabel timeCreated=new JLabel("N/A");
		headerPanel.add(timeCreatedLabel);
		headerPanel.add(timeCreated);
		JLabel lastModifiedTimeLabel=new JLabel("Last Modified Time");
		JLabel lastModifiedTime=new JLabel("N/A");
		headerPanel.add(lastModifiedTimeLabel);
		headerPanel.add(lastModifiedTime);
		JLabel lastReadTimeLabel=new JLabel("Last Read Time");
		JLabel lastReadTime=new JLabel("N/A");
		headerPanel.add(lastReadTimeLabel);
		headerPanel.add(lastReadTime);
		JLabel versionLabel=new JLabel("Version");
		JTextField versionTextField=new JTextField("N/A");
		versionTextField.setColumns(10);
		headerPanel.add(versionLabel);
		headerPanel.add(versionTextField);
		JLabel reservedLabel=new JLabel("Reserved Bits");
		JLabel reservedBits=new JLabel("N/A");
		headerPanel.add(reservedLabel);
		headerPanel.add(reservedBits);
		//JScrollPane headerScrollPane=new JScrollPane(headerPanel);
		
		//Profile Content
		JPanel param3gppPane=new JPanel();
		param3gppPane.setBorder(new EmptyBorder(5,5,5,5));	
		param3gppPane.setLayout(new GridLayout(20,1,1,1));
		JPanel title3gppPane=new JPanel();
		title3gppPane.add(new JLabel("3GPP Parameters:"));
		param3gppPane.add(title3gppPane);

		JPanel param3gpp2Pane=new JPanel();
		param3gpp2Pane.setBorder(new EmptyBorder(5,5,5,5));	
		param3gpp2Pane.setLayout(new GridLayout(20,1,1,1));
		JPanel title3gpp2Pane=new JPanel();
		title3gpp2Pane.add(new JLabel("3GPP2 Parameters:"));
		param3gpp2Pane.add(title3gpp2Pane);
		
		JPanel paramCommTechPane=new JPanel();
		paramCommTechPane.setBorder(new EmptyBorder(5,5,5,5));	
		paramCommTechPane.setLayout(new GridLayout(20,1,1,1));
		JPanel titleCommTechPane=new JPanel();
		titleCommTechPane.add(new JLabel("Common Tech Parameters:"));
		paramCommTechPane.add(titleCommTechPane);
		
		JPanel paramGeneralPane=new JPanel();
		paramGeneralPane.setBorder(new EmptyBorder(5,5,5,5));	
		paramGeneralPane.setLayout(new GridLayout(20,1,1,1));
		JPanel titleGeneralPane=new JPanel();
		titleGeneralPane.add(new JLabel("General Parameters:"));
		paramGeneralPane.add(titleGeneralPane);

    	for( ProfileType type : ProfileType.values()){
    		if(type.is3GPPKey()) {
    			String labelString = null;
	    		JPanel panel=new JPanel();
	    		param3gppPane.add(panel);
	    		//JLabel label1=new JLabel(type.getLabel() + "(0x" + type.getValue() + ")");
	    		labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
	    		JLabel label1=new JLabel(labelString);
	    		JTextField textField=new JTextField("N/A");
	    		textField.setColumns(10);
	    		panel.add(label1);
	    		panel.add(textField);
	    		textFieldList.put(type.getTypeKey(), textField);
    		} else if(type.is3GPP2Key()) {
    			String labelString = null;
	    		JPanel panel=new JPanel();
	    		param3gpp2Pane.add(panel);
	    		//JLabel label1=new JLabel(type.getLabel() + "(0x" + type.getValue() + ")");
	    		labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
	    		JLabel label1=new JLabel(labelString);
	    		JTextField textField=new JTextField("N/A");
	    		textField.setColumns(10);
	    		panel.add(label1);
	    		panel.add(textField);
	    		textFieldList.put(type.getTypeKey(), textField);    			
    		} else if(type.isCommonTechKey()) {
    			String labelString = null;
	    		JPanel panel=new JPanel();
	    		paramCommTechPane.add(panel);
	    		//JLabel label1=new JLabel(type.getLabel() + "(0x" + type.getValue() + ")");
	    		labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
	    		JLabel label1=new JLabel(labelString);
	    		JTextField textField=new JTextField("N/A");
	    		textField.setColumns(10);
	    		panel.add(label1);
	    		panel.add(textField);
	    		textFieldList.put(type.getTypeKey(), textField);     			
    		} else if(type.isGeneralKey()) {
    			String labelString = null;
	    		JPanel panel=new JPanel();
	    		paramGeneralPane.add(panel);
	    		//JLabel label1=new JLabel(type.getLabel() + "(0x" + type.getValue() + ")");
	    		labelString = String.format("%s(0x%x)", type.getLabel(), type.getTypeKey());
	    		JLabel label1=new JLabel(labelString);
	    		JTextField textField=new JTextField("N/A");
	    		textField.setColumns(10);
	    		panel.add(label1);
	    		panel.add(textField);
	    		textFieldList.put(type.getTypeKey(), textField);    			
    		}
    	}
	
    	JScrollPane param3gppScrollPane=new JScrollPane(param3gppPane);
    	JScrollPane param3gpp2ScrollPane=new JScrollPane(param3gpp2Pane);
    	JScrollPane paramCommTechPaneScrollPane=new JScrollPane(paramCommTechPane);
    	JScrollPane paramGeneralPaneScrollPane=new JScrollPane(paramGeneralPane);
    	
		JSplitPane hSplitPane = new JSplitPane();
		hSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//���÷ָ��߷���
		hSplitPane.setDividerLocation(40);
		hSplitPane.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
		hSplitPane.setContinuousLayout(true);//������ͷ���ػ�ͼ��
		hSplitPane.setLeftComponent(headerPanel);
    	//hSplitPane.setRightComponent(param3gppScrollPane);
		this.getContentPane().add(hSplitPane, BorderLayout.CENTER);
		
		JSplitPane hSplitPane2 = new JSplitPane();
		hSplitPane2.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//���÷ָ��߷���
		hSplitPane2.setDividerLocation(40);
		hSplitPane2.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
		hSplitPane2.setContinuousLayout(true);//������ͷ���ػ�ͼ��
		hSplitPane2.setLeftComponent(param3gppScrollPane);
		hSplitPane.setRightComponent(hSplitPane2);
				
		JSplitPane hSplitPane3 = new JSplitPane();
		hSplitPane3.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//���÷ָ��߷���
		hSplitPane3.setDividerLocation(40);
		hSplitPane3.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
		hSplitPane3.setContinuousLayout(true);//������ͷ���ػ�ͼ��
		hSplitPane3.setLeftComponent(param3gpp2ScrollPane);
		hSplitPane2.setRightComponent(hSplitPane3);
		
		JSplitPane hSplitPane4 = new JSplitPane();
		hSplitPane4.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//���÷ָ��߷���
		hSplitPane4.setDividerLocation(40);
		hSplitPane4.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
		hSplitPane4.setContinuousLayout(true);//������ͷ���ػ�ͼ��
		hSplitPane3.setRightComponent(hSplitPane4);
		hSplitPane4.setLeftComponent(paramCommTechPaneScrollPane);
		hSplitPane4.setRightComponent(paramGeneralPaneScrollPane);
    	
		// Ϊһ�㰴ť��Ӷ���������
		jReadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        jfc.showDialog(new JLabel(), "ѡ��");  
		        slectedFile=jfc.getSelectedFile();  
		        if(slectedFile.isDirectory()){  
		            System.out.println("�ļ���:"+slectedFile.getAbsolutePath());  
		        }else if(slectedFile.isFile()){  
		            System.out.println("�ļ�:"+slectedFile.getAbsolutePath());  
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
		        profileSize.setText(temp);
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
				
				System.out.print("=============== Write button ===============\n");
				
				if(slectedFile != null) {
					buff = readFile(slectedFile.getAbsolutePath());
					prfHeader = new ProfileHeader(buff);
			        ProfileAnalyze profileAnalyze = new ProfileAnalyze();
			        tlvList = profileAnalyze.unpack(buff, prfHeader.getProfileHeaderLen());
			        
			        //Set<Map.Entry<Integer, JTextField>> set = textFieldList.entrySet();
			        //Iterator<Map.Entry<Integer, JTextField>> iterator = set.iterator();
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
				
		        //Caculate profile size
		        profileSize = prfHeader.getProfileHeaderLen(); //
		        for(int i = 0; i < tlvList.size(); i++) {
		        	profileSize += 4; //T and L
		        	profileSize += tlvList.get(i).getLen();
            	}
		        System.out.print("New profile size:" + profileSize + "\n");
		        
		        byte[] newBuff = new byte[profileSize];
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
				
				int numTlvs = tlvList.size();
				System.out.println("New numTlvs: " + numTlvs);
				prfHeader.putProfileHeaderNumTlvs(newBuff, numTlvs);
				
				int magicNumber = 0xa5a5a5a5;
				System.out.println("New magicNumber: " + magicNumber);
				prfHeader.putProfileHeaderMagicNumber(newBuff, magicNumber);
				
				int timeCreated = 0; //TODO
				System.out.println("New timeCreated: " + timeCreated);
				prfHeader.putProfileHeaderTimeCreated(newBuff, timeCreated);
				
				int lastModifiedTime = 0; //TODO
				System.out.println("New lastModifiedTime: " + lastModifiedTime);
				prfHeader.putProfileHeaderLastModifiedTime(newBuff, lastModifiedTime);
				
				int lastReadTime = 0; //TODO
				System.out.println("New lastReadTime: " + lastReadTime);
				prfHeader.putProfileHeaderLastReadTime(newBuff, lastReadTime);

				String version = versionTextField.getText().trim(); //TODO
				System.out.println("New version: " + version);
				if(version.equals("N/A")) version = "0x0000";
				prfHeader.putProfileHeaderVersion(newBuff, version);
				
				//fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				//fileChooser.showDialog(new JLabel(), "ѡ��"); 
				int select = fileChooser.showSaveDialog(ProfileEditor.this);
				
				//fileChooser.setSelectedFile(new File("�½�.txt")); 
				File file = null;

				String fileName = null;
				if(select==JFileChooser.APPROVE_OPTION){
					file =fileChooser.getSelectedFile(); //������ﲢû��ѡȡ���κε��ļ��������fileChooser.getName(file)���᷵����������ļ��� 
				}
				fileName = fileChooser.getName(file);
				if(fileName==null|| fileName.trim().length()==0){
					JOptionPane.showMessageDialog(ProfileEditor.this, "�ļ���Ϊ�գ�");
				}

				if(file.isFile()){
					fileName = file.getName();
				}
				
				//�����Ǹ��ļ���
				file = fileChooser.getCurrentDirectory();//��õ�ǰĿ¼

				String path = file.getPath()+java.io.File.separator+fileName;
				file =new File(path);

				if(file.exists()) { //��ѡ�������ļ�----ѯ���Ƿ�Ҫ����
					int i = JOptionPane.showConfirmDialog(ProfileEditor.this, "���ļ��Ѿ����ڣ�ȷ��Ҫ������");
					if(i == JOptionPane.YES_OPTION);
					else return;
				}

				try {
					out=new DataOutputStream(new FileOutputStream(path));
					out.write(newBuff);
					out.close();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(ProfileEditor.this, "�ļ��������"+e1.getMessage());
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
		
		jButtonPane.setLayout(null);
		jButtonPane.setPreferredSize(new Dimension(0, 50));
		jButtonPane.add(jReadButton);
		jButtonPane.add(jWriteButton);
		this.getContentPane().add(jButtonPane, BorderLayout.NORTH);

		this.getContentPane().add(jsp, BorderLayout.SOUTH);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	public byte[] readFile(String filename2){
		//FileReader fr = null;
		//BufferedReader br = null;
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
			
			// ȷ���������ݾ�����ȡ
			if (offset != buffer.length) {
				fi.close();
				throw new IOException("Could not completely read file " + file.getName());
			}
			//fr= new FileReader(filename2);
			//br=new BufferedReader(fr);
			//String str;
			//while((str=br.readLine())!=null){
			//	jta.append(str+"\n");
			//	System.out.println(str);
			//}
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


