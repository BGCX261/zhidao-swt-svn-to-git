import java.awt.Event;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;


public class HelloSwt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		///////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
		//�õ�Application��̨����Display�ʹ���Shell
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		
		//����ͼ
		final Composite mainView = new Composite(shell, SWT.BORDER);
		mainView.setLocation(0, 0);
		mainView.setSize(800, 600);
		
		
		
		//��Ӳ˵�
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		
		
		//��Դ���������˵�
		MenuItem resourceMenuItem = new MenuItem(menu, SWT.CASCADE);
		resourceMenuItem.setText("��Դ����");
		Menu resourceMenu = new Menu(shell, SWT.DROP_DOWN);
		resourceMenuItem.setMenu(resourceMenu);
		MenuItem profileMenuItem = new MenuItem(resourceMenu, SWT.NO);
		profileMenuItem.setText("�˺Ź���");
		MenuItem questionMenuItem = new MenuItem(resourceMenu, SWT.NO);
		questionMenuItem.setText("�������ӹ���");
		MenuItem answerMenuItem = new MenuItem(resourceMenu, SWT.NO);
		answerMenuItem.setText("�ش����ݹ���");
		MenuItem pinglunMenuItem = new MenuItem(resourceMenu, SWT.NO);
		pinglunMenuItem.setText("�������ݹ���");
		
		
		
		//���˵�����¼�
		profileMenuItem.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent event) {
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		
		//��������������¼�
		questionMenuItem.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				for(Control c : mainView.getChildren()){
					c.dispose();
				}
				
				//��������������ͼ
				//���찴ť
				Button button = new Button(mainView, SWT.PUSH);
				button.setText("�����������");
				button.setLocation(0, 0);
				button.setSize(100, 30);
				button.addMouseListener(new MouseListener() {
					
					public void mouseUp(MouseEvent e) {
						Shell formWin = new Shell(display);
						formWin.setText("����˺�");
						formWin.setSize(350, 100);
						
						//�����˺ű�����
						Label loginNameLabel = new Label(formWin, SWT.NO);
						loginNameLabel.setText("��������");
						loginNameLabel.setLocation(10, 10);
						loginNameLabel.setSize(50, 20);
						Text loginName = new Text(formWin, SWT.BORDER);
						loginName.setLocation(70, 6);
						loginName.setSize(250, 20);
						
						
						Button button = new Button(formWin, SWT.PUSH);
						button.setText("����");
						button.setLocation(150, 40);
						button.setSize(50, 20);
						
						formWin.open();
					}
					
					public void mouseDown(MouseEvent e) {
					}
					
					public void mouseDoubleClick(MouseEvent e) {
					}
				});
				
				//����Table
				final Table table = new Table(mainView, SWT.NO | SWT.FULL_SELECTION);
				table.setHeaderVisible(true);
				table.setLocation(0, 30);
				table.setSize(200, 200);
				TableColumn columnA = new TableColumn(table, SWT.NO);
				columnA.setText("��������");
				columnA.setWidth(200);
				TableItem itemA = new TableItem(table, SWT.NO);
				itemA.setText(new String[]{"ABC"});
				TableItem itemB = new TableItem(table, SWT.NO);
				itemB.setText(new String[]{"XYZ"});
				
				//��table�����Ҽ��˵�
				table.addMouseListener(new MouseListener() {
					
					public void mouseUp(MouseEvent e) {
						Menu menu = new Menu(table);
						table.setMenu(menu);
						MenuItem delMenu = new MenuItem(menu, SWT.PUSH);
						delMenu.setText("ɾ��");
						delMenu.addListener(SWT.Selection, new Listener() {
							
							public void handleEvent(org.eclipse.swt.widgets.Event e) {
								System.out.println(table.getSelection()[0].getText(0));
								
							}
						});
					}
					
					public void mouseDown(MouseEvent e) {
						
					}
					
					public void mouseDoubleClick(MouseEvent e) {
						
					}
				});
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		//��������ͼ
		//���찴ť
		Button button = new Button(mainView, SWT.PUSH);
		button.setText("����˺�");
		button.setLocation(0, 0);
		button.setSize(70, 30);
		button.addMouseListener(new MouseListener() {
			
			public void mouseUp(MouseEvent e) {
				Shell formWin = new Shell(display);
				formWin.setText("����˺�");
				formWin.setSize(350, 120);
				
				//�����˺ű�����
				Label loginNameLabel = new Label(formWin, SWT.NO);
				loginNameLabel.setText("��¼�˺�");
				loginNameLabel.setLocation(10, 10);
				loginNameLabel.setSize(50, 20);
				Text loginName = new Text(formWin, SWT.BORDER);
				loginName.setLocation(70, 6);
				loginName.setSize(250, 20);
				
				Label loginPwdLabel = new Label(formWin, SWT.NO);
				loginPwdLabel.setText("��¼����");
				loginPwdLabel.setLocation(10, 40);
				loginPwdLabel.setSize(50, 20);
				Text loginPwd = new Text(formWin, SWT.BORDER);
				loginPwd.setLocation(70, 30);
				loginPwd.setSize(250, 20);
				
				Button button = new Button(formWin, SWT.PUSH);
				button.setText("����");
				button.setLocation(150, 60);
				button.setSize(50, 20);
				
				formWin.open();
			}
			
			public void mouseDown(MouseEvent e) {
			}
			
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		
		//����Table
		final Table table = new Table(mainView, SWT.NO | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLocation(0, 30);
		table.setSize(200, 200);
		TableColumn columnA = new TableColumn(table, SWT.NO);
		columnA.setText("�˺�");
		columnA.setWidth(100);
		TableColumn columnB = new TableColumn(table, SWT.NO);
		columnB.setText("����");
		columnB.setWidth(100);
		TableItem itemA = new TableItem(table, SWT.NO);
		itemA.setText(new String[]{"ABC", "123"});
		TableItem itemB = new TableItem(table, SWT.NO);
		itemB.setText(new String[]{"XYZ", "789"});
		
		//��table�����Ҽ��˵�
		table.addMouseListener(new MouseListener() {
			
			public void mouseUp(MouseEvent e) {
				Menu menu = new Menu(table);
				table.setMenu(menu);
				MenuItem delMenu = new MenuItem(menu, SWT.PUSH);
				delMenu.setText("ɾ��");
				delMenu.addListener(SWT.Selection, new Listener() {
					
					public void handleEvent(org.eclipse.swt.widgets.Event e) {
						System.out.println(table.getSelection()[0].getText(0));
						
					}
				});
			}
			
			public void mouseDown(MouseEvent e) {
				
			}
			
			public void mouseDoubleClick(MouseEvent e) {
				
			}
		});
		
		
		////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////
		//��ʾ���ڣ�������Ϣѭ��
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}

}
