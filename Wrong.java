import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Wrong implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		class Wrong_1 extends JFrame{
			public Wrong_1(){
				this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				this.setBounds(410,250,500,200);
				this.setLayout(null);
				addLabel();
				this.setVisible(true);
			}

			private void addLabel() {
				JLabel wrong_warning_1 =new JLabel("用户名或密码格式错误，请重新输入");
		    	wrong_warning_1.setBounds(30,50,450,50);
		    	wrong_warning_1.setFont(new Font("",Font.BOLD,25));
		    	wrong_warning_1.setHorizontalAlignment(JLabel.LEFT);
		    	this.getContentPane().add(wrong_warning_1);
			}
		}
		new Wrong_1();
	}
	
}
