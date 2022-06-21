package com.oracle.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.oracle.model.adminuser;
import com.oracle.service.adminuserService;
import com.oracle.service.impl.adminuserServiceimpl;
import com.oracle.utils.StringUtils;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ShowWorkersInernalFrame extends JInternalFrame {
	private JTable table;
	private JTextField idText;
	private JTextField nameText;
	private JTextField sexText;
	private JTextField profText;
	private JTextField usernameText;
	private JTextField ageText;
	private JTextField passwordText;
	private JTextField rootText;
	private JTextField keyword;
	adminuserService as = new adminuserServiceimpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowWorkersInernalFrame frame = new ShowWorkersInernalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowWorkersInernalFrame() {
		getContentPane().setBackground(Color.GRAY);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), " \u804C \u5DE5 \u7BA1 \u7406 \u5176 \u4ED6 \u64CD \u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u59D3\u540D\u5173\u952E\u5B57\uFF1A");

		keyword = new JTextField();
		keyword.setColumns(10);

		JButton button_2 = new JButton("\u641C\u7D22");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//ʵ����������
				String key=keyword.getText();
				if (StringUtils.isEmpty(key)) {
					JOptionPane.showMessageDialog(null, "������ְ���ؼ��֣�");
					resetData();
					fillTable(new adminuser());
				}else {
					adminuser adminuser=new adminuser();
					adminuser.setName(key);
					resetData();
					fillTable(adminuser);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(keyword, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_2))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(keyword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2))
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");

		idText = new JTextField();
		idText.setEditable(false);
		idText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");

		nameText = new JTextField();
		nameText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");

		sexText = new JTextField();
		sexText.setColumns(10);

		JLabel label = new JLabel("\u5C97\u4F4D\uFF1A");

		profText = new JTextField();
		profText.setColumns(10);

		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");

		usernameText = new JTextField();
		usernameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");

		JLabel label_2 = new JLabel("\u5E74\u9F84\uFF1A");

		ageText = new JTextField();
		ageText.setColumns(10);

		passwordText = new JTextField();
		passwordText.setColumns(10);

		JLabel label_3 = new JLabel("\u6743\u9650\uFF1A");

		rootText = new JTextField();
		rootText.setColumns(10);

		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// ɾ�����ܵ�ʵ��
				String id = idText.getText();
				if (StringUtils.isEmpty(id)) {
					// ���û��ѡȡ��һ�м�¼
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ����ְ����");
					return;
				}
				int i = as.deleteWorkers(id);
				if (i>0) {
					//ɾ���ɹ�
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					//���ˢ�±�����
					resetData();
					//���ˢ�±��
					fillTable(new adminuser());
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
				}
			}
		});

		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//�޸Ĺ��ܵ�ʵ�֣����ж��޸��Ƿ�Ϊ��
				String id=idText.getText();
				if (StringUtils.isEmpty(id)) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ�ְ����");
					return;
				}
				String name=nameText.getText();
				if (StringUtils.isEmpty(name)) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�");
					return;
				}
				String sex=sexText.getText();
				if (StringUtils.isEmpty(sex)) {
					JOptionPane.showMessageDialog(null, "�Ա���Ϊ�գ�");
					return;
				}
				String age=ageText.getText();
				if (StringUtils.isEmpty(age)) {
					JOptionPane.showMessageDialog(null, "���䲻��Ϊ�գ�");
					return;
				}
				String prof=profText.getText();
				if (StringUtils.isEmpty(prof)) {
					JOptionPane.showMessageDialog(null, "��λ����Ϊ�գ�");
					return;
				}
				String username=usernameText.getText();
				if (StringUtils.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�");
					return;
				}
				String password=passwordText.getText();
				if (StringUtils.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
					return;
				}
				String root=rootText.getText();
				if (StringUtils.isEmpty(root)) {
					JOptionPane.showMessageDialog(null, "Ȩ�޲���Ϊ�գ�");
					return;
				}
				if (!StringUtils.isInteger(password) || password.length()!=6) {
					JOptionPane.showMessageDialog(null, "��������λ�������룡");
					return;
					
				}
				//�޸Ĺ���ʵ��
				adminuser adminuser=new adminuser(Integer.parseInt(id), name, sex, age, prof, username, password, root);
				int i=as.updataWorkers(adminuser);
				if (i>0) {
					//ɾ���ɹ�
					JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
					//���ˢ�±�����
					resetData();
					//���ˢ�±��
					fillTable(new adminuser());
				}else {
					
					JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�");
				}
			}
			});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED).addComponent(idText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(profText,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(58)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(button, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING,
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(nameText,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addComponent(label_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(usernameText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGap(58)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sexText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(passwordText,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(44)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(ageText,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addComponent(label_3)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(rootText,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
						.addComponent(button_1))
				.addContainerGap(30, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel)
												.addComponent(idText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1)
												.addComponent(nameText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_2)
												.addComponent(sexText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_2).addComponent(ageText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label)
												.addComponent(profText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_1)
												.addComponent(usernameText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_3)
												.addComponent(passwordText, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_3).addComponent(rootText,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(button)
												.addComponent(button_1))
										.addContainerGap()));
		panel.setLayout(gl_panel);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				// ��ȡ��ǰ�е����ݣ���ʾ������
				int row = table.getSelectedRow(); // ���ѡ���к�
				Integer id = (Integer) table.getValueAt(row, 0);
				String name = (String) table.getValueAt(row, 1);
				String sex = (String) table.getValueAt(row, 2);
				Integer age = (Integer) table.getValueAt(row, 3);
				String prof = (String) table.getValueAt(row, 4);
				String username = (String) table.getValueAt(row, 5);
				String password = (String) table.getValueAt(row, 6);
				Integer root = (Integer) table.getValueAt(row, 7);
				// ����һ��������ʾ�ڱ���
				idText.setText(id.toString());
				nameText.setText(name);
				sexText.setText(sex);
				ageText.setText(age.toString());
				profText.setText(prof);
				usernameText.setText(username);
				passwordText.setText(password);
				rootText.setText(root.toString());

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u804C\u5DE5\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u5C97\u4F4D", "\u8D26\u53F7", "\u5BC6\u7801", "\u6743\u9650"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setTitle("\u67E5\u770B\u6240\u6709\u804C\u5DE5");
		setFrameIcon(new ImageIcon(ShowWorkersInernalFrame.class.getResource("/image/add2.png")));
		setIconifiable(true);
		setClosable(true);
		setBounds(450, 150, 1007, 616);
		// ���ҳ�ְ����Ϣ������ʾ��JTable��
		fillTable(new adminuser());
	}

	// fillTable()�����ķ���
	private void fillTable(adminuser admin) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// ��������ձ��
		model.setRowCount(0);
		List<Vector> list = as.selectAlladminuser(admin);
		for (Vector v : list) {
			model.addRow(v);
		}

	}
	/**
	 * ��ձ�����
	 */
	private void resetData() {
		idText.setText("");
		nameText.setText("");
		sexText.setText("");
		ageText.setText("");
		profText.setText("");
		usernameText.setText("");
		passwordText.setText("");
		rootText.setText("");
		}
}	
