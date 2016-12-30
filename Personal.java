import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import org.omg.CORBA.portable.InputStream;

public class Personal implements ActionListener {
	@SuppressWarnings("null")
	public int sum=0;
	public void actionPerformed(ActionEvent e){
		
		JFrame DVD_show=new JFrame("DVD列表");
		DVD_show.setLayout(null);
		DVD_show.setBounds(400, 100, 800, 600);
		
		String filepath="C:\\Users\\msi\\Desktop\\JAVA\\DVD.txt";
		String tempString = null;
		String save[] =new String[100];
		BufferedReader reader = null;
		File information=new File(filepath);
		try {
			reader=new BufferedReader(new FileReader(information));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		int line=1;
				try {
					while ((tempString = reader.readLine()) != null) {
						line++;
						save[line-1]=tempString;
						}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				JList list=new JList(save);
				list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			    list.setFixedCellHeight(25);
			    list.setVisibleRowCount(3);
			    list.setFont(new Font("",Font.BOLD,20));
			    JScrollPane scrollpane=new JScrollPane();
			    scrollpane.setViewportView(list);
			    scrollpane.setBounds(0,0,600,600);
			    DVD_show.getContentPane().add(scrollpane);
			    DVD_show.setVisible(true);
			    //定义name字符串数组储存DVD名称
			    String name[]=new String[30];
			    for(int i=3;i<=21;i++){
			    	name[i-3]=save[i].substring(0, 10);
			    }
			    //定义ID字符串数组储存ID号，通过ID号进行操作
			    String ID[]=new String[30];
			    for(int i=3;i<=21;i++){
			    	ID[i-3]=save[i].substring(save[i].indexOf('G'),save[i].indexOf('G')+5);
			    }
			    
			    //定义price，计算价格
			    String price[]=new String[30];
			    for(int i=3;i<=21;i++){
			    	price[i-3]=save[i].substring(save[i].length()-1,save[i].length());
			    }
			    
			    JLabel lb4=new JLabel("输入借阅序号");
			    lb4.setBounds(618,10,200,80);
            	lb4.setFont(new Font("",Font.BOLD,22));
            	DVD_show.getContentPane().add(lb4);
            	
            	JTextField tx3=new JTextField("");
            	tx3.setHorizontalAlignment(JTextField.CENTER);
            	tx3.setBounds(609,80,160,50);
            	tx3.setFont(new Font("",Font.BOLD,25));
        		DVD_show.getContentPane().add(tx3);
        		
        		DefaultListModel listModel1 = new DefaultListModel();
        		listModel1.addElement("已借阅：");        		
        		JList list2=new JList(listModel1);
        		list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        		list2.setFixedCellHeight(25);
        		list2.setVisibleRowCount(3);
        		list2.setFont(new Font("",Font.BOLD,20));
			    JScrollPane scrollpane1=new JScrollPane();
			    scrollpane1.setViewportView(list2);
			    scrollpane1.setBounds(610,220,160,160);
			    DVD_show.getContentPane().add(scrollpane1);
        		
        		JButton b4=new JButton("我要借阅");
        		b4.setFont(new Font("",Font.BOLD,25));
        		b4.setBounds(611,145,140,60);
        		DVD_show.getContentPane().add(b4);
        		b4.addActionListener(new ActionListener(){
        			int number=0;
        			public void actionPerformed(ActionEvent e) {
        				String input=new String();
        				input=tx3.getText();
        				//在库中寻找ID为input的DVD,将其状态改为out，价格累加
        				boolean result;
        				FileWriter fileWriter = null;
						try {
							fileWriter = new FileWriter("C:\\Users\\msi\\Desktop\\JAVA\\DVD_out.txt", true);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
        				for(int n=0;n<=21;n++){
        					result=input.equals(ID[n]);
        					if(result){
        						sum+=Integer.parseInt(price[n]);
        						number++;
        						listModel1.addElement(input);
        						System.out.println(save[n+3]);
        						try {
									fileWriter.write(save[n+3]+"\r\n");
									fileWriter.flush();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
        							}
        				}
        				try {
							fileWriter.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
        			}
        		});
        		
        		JButton b5=new JButton("结算");
        		b5.setFont(new Font("",Font.BOLD,25));
        		b5.setBounds(611,405,140,60);
        		DVD_show.getContentPane().add(b5); 
        		b5.addActionListener(new ActionListener(){
        			//结算以及归还界面
					public void actionPerformed(ActionEvent e) {
						DVD_show.setVisible(false);
						
						JFrame DVD_back=new JFrame();
						DVD_back.setLayout(null);
						DVD_back.setBounds(400, 100, 800, 600);
						
						JLabel lb5=new JLabel("共需支付"+sum+"元，请扫码支付");
						lb5.setBounds(50,20,400,80);
						lb5.setFont(new Font("",Font.BOLD,30));
		            	DVD_back.getContentPane().add(lb5);
		            	
		            	JLabel picture = new JLabel(new ImageIcon("C:\\Users\\msi\\Desktop\\JAVA\\pay.jpg"));
		            	picture.setBounds(45,100,400,400);
		            	DVD_back.getContentPane().add(picture,BorderLayout.CENTER);
		            	
		            	JButton bt6=new JButton("next-->");
		            	bt6.setFont(new Font("",Font.BOLD,20));
		            	bt6.setBounds(550,470,180,40);
		        		DVD_back.getContentPane().add(bt6);
		        		Back btnHandler =new Back();
	    				bt6.addActionListener(btnHandler);
						
						DVD_back.setVisible(true);
					}
        			
        		});
			}
    }


	
