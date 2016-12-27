import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Back implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame sendback=new JFrame("已借列表：");
		sendback.setLayout(null);
		sendback.setBounds(400,100,550,550);
		
		String filepath1="C:\\Users\\msi\\Desktop\\JAVA\\DVD_out.txt";
		String tempString = null;
		String save[] =new String[100];
		BufferedReader reader = null;
		File information=new File(filepath1);
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
	    scrollpane.setBounds(0,0,550,300);
	    sendback.getContentPane().add(scrollpane);
	    
	    JButton return_dvds=new JButton("归还已借DVD");
	    return_dvds.setFont(new Font("",Font.BOLD,25));
	    return_dvds.setBounds(30,370,200,70);
	    sendback.getContentPane().add(return_dvds);
		return_dvds.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//将DVD_out.txt的内容清空并退出程序
				File f = new File("C:\\Users\\msi\\Desktop\\JAVA\\DVD_out.txt");
				FileWriter fw = null;
				try {
					fw = new FileWriter(f);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					fw.write("");
					fw.write("名称                     ID号码                       价格");
					fw.write("\r\n");
					fw.write("-----------------------------------------------------------------");
					fw.write("\r\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JFrame last = new JFrame("结束");
				last.setLayout(null);
				last.setBounds(400,100,500,300);
				
				JButton exits=new JButton("归还成功，退出");
				exits.setFont(new Font("",Font.BOLD,25));
				exits.setBounds(100,100,300,70);
				last.getContentPane().add(exits);
				exits.addActionListener(new ActionListener(){
			    	public void actionPerformed(ActionEvent e) {
							System.exit(0);
						} 
					});
				last.setVisible(true);
				
			} 
		});
		
		JButton exits=new JButton("退出系统");
		exits.setFont(new Font("",Font.BOLD,25));
		exits.setBounds(290,370,200,70);
		sendback.getContentPane().add(exits);
		exits.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
					System.exit(0);
				} 
			});
		
		
		sendback.setVisible(true);

	}

}
