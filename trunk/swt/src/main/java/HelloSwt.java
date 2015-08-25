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
		//得到Application后台进程Display和窗口Shell
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		
		//主视图
		final Composite mainView = new Composite(shell, SWT.BORDER);
		mainView.setLocation(0, 0);
		mainView.setSize(800, 600);
		
		
		
		//添加菜单
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		
		
		//资源管理下拉菜单
		MenuItem resourceMenuItem = new MenuItem(menu, SWT.CASCADE);
		resourceMenuItem.setText("资源管理");
		Menu resourceMenu = new Menu(shell, SWT.DROP_DOWN);
		resourceMenuItem.setMenu(resourceMenu);
		MenuItem profileMenuItem = new MenuItem(resourceMenu, SWT.NO);
		profileMenuItem.setText("账号管理");
		MenuItem questionMenuItem = new MenuItem(resourceMenu, SWT.NO);
		questionMenuItem.setText("问题链接管理");
		MenuItem answerMenuItem = new MenuItem(resourceMenu, SWT.NO);
		answerMenuItem.setText("回答内容管理");
		MenuItem pinglunMenuItem = new MenuItem(resourceMenu, SWT.NO);
		pinglunMenuItem.setText("评论内容管理");
		
		
		
		//给菜单添加事件
		profileMenuItem.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent event) {
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		
		//给问题链接添加事件
		questionMenuItem.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				for(Control c : mainView.getChildren()){
					c.dispose();
				}
				
				//绘制问题链接视图
				//构造按钮
				Button button = new Button(mainView, SWT.PUSH);
				button.setText("添加问题链接");
				button.setLocation(0, 0);
				button.setSize(100, 30);
				button.addMouseListener(new MouseListener() {
					
					public void mouseUp(MouseEvent e) {
						Shell formWin = new Shell(display);
						formWin.setText("添加账号");
						formWin.setSize(350, 100);
						
						//绘制账号表单窗口
						Label loginNameLabel = new Label(formWin, SWT.NO);
						loginNameLabel.setText("问题链接");
						loginNameLabel.setLocation(10, 10);
						loginNameLabel.setSize(50, 20);
						Text loginName = new Text(formWin, SWT.BORDER);
						loginName.setLocation(70, 6);
						loginName.setSize(250, 20);
						
						
						Button button = new Button(formWin, SWT.PUSH);
						button.setText("保存");
						button.setLocation(150, 40);
						button.setSize(50, 20);
						
						formWin.open();
					}
					
					public void mouseDown(MouseEvent e) {
					}
					
					public void mouseDoubleClick(MouseEvent e) {
					}
				});
				
				//构造Table
				final Table table = new Table(mainView, SWT.NO | SWT.FULL_SELECTION);
				table.setHeaderVisible(true);
				table.setLocation(0, 30);
				table.setSize(200, 200);
				TableColumn columnA = new TableColumn(table, SWT.NO);
				columnA.setText("问题链接");
				columnA.setWidth(200);
				TableItem itemA = new TableItem(table, SWT.NO);
				itemA.setText(new String[]{"ABC"});
				TableItem itemB = new TableItem(table, SWT.NO);
				itemB.setText(new String[]{"XYZ"});
				
				//给table增加右键菜单
				table.addMouseListener(new MouseListener() {
					
					public void mouseUp(MouseEvent e) {
						Menu menu = new Menu(table);
						table.setMenu(menu);
						MenuItem delMenu = new MenuItem(menu, SWT.PUSH);
						delMenu.setText("删除");
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
		//绘制主视图
		//构造按钮
		Button button = new Button(mainView, SWT.PUSH);
		button.setText("添加账号");
		button.setLocation(0, 0);
		button.setSize(70, 30);
		button.addMouseListener(new MouseListener() {
			
			public void mouseUp(MouseEvent e) {
				Shell formWin = new Shell(display);
				formWin.setText("添加账号");
				formWin.setSize(350, 120);
				
				//绘制账号表单窗口
				Label loginNameLabel = new Label(formWin, SWT.NO);
				loginNameLabel.setText("登录账号");
				loginNameLabel.setLocation(10, 10);
				loginNameLabel.setSize(50, 20);
				Text loginName = new Text(formWin, SWT.BORDER);
				loginName.setLocation(70, 6);
				loginName.setSize(250, 20);
				
				Label loginPwdLabel = new Label(formWin, SWT.NO);
				loginPwdLabel.setText("登录密码");
				loginPwdLabel.setLocation(10, 40);
				loginPwdLabel.setSize(50, 20);
				Text loginPwd = new Text(formWin, SWT.BORDER);
				loginPwd.setLocation(70, 30);
				loginPwd.setSize(250, 20);
				
				Button button = new Button(formWin, SWT.PUSH);
				button.setText("保存");
				button.setLocation(150, 60);
				button.setSize(50, 20);
				
				formWin.open();
			}
			
			public void mouseDown(MouseEvent e) {
			}
			
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		
		//构造Table
		final Table table = new Table(mainView, SWT.NO | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLocation(0, 30);
		table.setSize(200, 200);
		TableColumn columnA = new TableColumn(table, SWT.NO);
		columnA.setText("账号");
		columnA.setWidth(100);
		TableColumn columnB = new TableColumn(table, SWT.NO);
		columnB.setText("密码");
		columnB.setWidth(100);
		TableItem itemA = new TableItem(table, SWT.NO);
		itemA.setText(new String[]{"ABC", "123"});
		TableItem itemB = new TableItem(table, SWT.NO);
		itemB.setText(new String[]{"XYZ", "789"});
		
		//给table增加右键菜单
		table.addMouseListener(new MouseListener() {
			
			public void mouseUp(MouseEvent e) {
				Menu menu = new Menu(table);
				table.setMenu(menu);
				MenuItem delMenu = new MenuItem(menu, SWT.PUSH);
				delMenu.setText("删除");
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
		//显示窗口，进入消息循环
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}

}
