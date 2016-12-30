import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Menu {

	String username,password;
	JFrame menu;
	JLabel lb1,lb2,lb3;
	JButton bt1,bt2;
	JTextField tx1;
	JPasswordField tx2;
	protected int DISPOSE_ON_CLOSE;
	public Menu(){
		menu =new JFrame("登录界面");
		menu.setLayout(null);
		menu.setBounds(400, 100, 800, 600);
		addlb1();
		addlb2();
		addlb3();
		addbt1();
		addbt2();
		addtx1();
		addtx2();
		menu.setVisible(true);
	}
	private void addtx2() {
		tx2=new JPasswordField();
		tx2.setText("");
		tx2.setHorizontalAlignment(JTextField.CENTER);
		tx2.setBounds(260,270,300,50);
		tx2.setFont(new Font("",Font.BOLD,25));
		menu.getContentPane().add(tx2,"North");
	}
	private void addtx1() {          //邮箱格式
		tx1=new JTextField();
		tx1.setText("");
		tx1.setHorizontalAlignment(JTextField.CENTER);
		tx1.setBounds(260,155,300,50);
		tx1.setFont(new Font("",Font.BOLD,25));
		menu.getContentPane().add(tx1,"North");
	}
	private void addbt2() {
		bt2=new JButton("取消");
		bt2.setFont(new Font("",Font.BOLD,25));
		bt2.setBounds(430,390,200,70);
		menu.getContentPane().add(bt2);
		bt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			} 
		});}
	private void addbt1() {
		bt1=new JButton("登录");
		bt1.setFont(new Font("",Font.BOLD,25));
		bt1.setBounds(120,390,200,70);
		menu.getContentPane().add(bt1);
		bt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				username=tx1.getText().toString();
        		password=tx2.getText().toString();
        		//利用正则表达式判断用户名是否为邮箱格式，密码是否为数字和字母格式
        		String regex_1="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        		String regex_2="^[a-zA-Z0-9_]+$";
        		boolean result_1 = username.matches(regex_1);
                boolean result_2 = password.matches(regex_2);
                if((result_1)&&(result_2)){             
                	//登录成功
                	Personal btnHandler =new Personal();
    				bt1.addActionListener(btnHandler);
                }else{
                	Wrong btnHandler =new Wrong();
    				bt1.addActionListener(btnHandler);
                }
			} 
		});
	}
	private void addlb3() {
		lb3=new JLabel("欢迎来到DVD租赁系统");
		lb3.setBounds(140,10,500,100);
		lb3.setFont(new Font("",Font.BOLD,30));
		lb3.setHorizontalAlignment(JLabel.CENTER);
		menu.getContentPane().add(lb3,"North");
	}
	private void addlb2() {
		lb2=new JLabel("  密码：");
		lb2.setBounds(120,250,300,100);
		lb2.setFont(new Font("",Font.BOLD,28));
		lb2.setHorizontalAlignment(JLabel.LEFT);
		menu.getContentPane().add(lb2,"North");		
	}
	private void addlb1(){
		lb1=new JLabel("用户名：");
		lb1.setBounds(120,130,300,100);
		lb1.setFont(new Font("",Font.BOLD,28));
		lb1.setHorizontalAlignment(JLabel.LEFT);
		menu.getContentPane().add(lb1,"North");
	}
	public static void main(String[] args){	
		Menu main=new Menu();
	}
}
