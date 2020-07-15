package executionEngine;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;

import config.ActionKeywords;
import config.Constants;

import utility.ExcelUtils;
import utility.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class main_run_gui extends JFrame {
//	private JFrame frame;

	public static Properties OR;
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[];

	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;
	public static String sLoop;
	public static String sData;
	public static boolean bResult;

	public static String duongdanfile;

	private JPanel contentPane;

	String linkfileExcelTestcase = null;
	String linkfileOR = null;

	private final JLabel lblDiwms = new JLabel("DiWMS");
	private JTextField txtExcelFile;
	private JTextField txtORFile;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					main_run_gui frame = new main_run_gui();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void execute_TestCase() throws Exception {
		int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
		for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
			bResult = true;
			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
			sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode, Constants.Sheet_TestCases);
			
			sLoop = ExcelUtils.getCellData(iTestcase, Constants.Col_Loop_TestCase, Constants.Sheet_TestCases);						
			int loop = Integer.parseInt(sLoop.trim());
			
			for (int i=1; i<=loop; i++) {

				if (sRunMode.trim().toLowerCase().equals("yes") && loop>0 ) {
															
					Log.startTestCase(sTestCaseID);
					iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID,
							Constants.Sheet_TestSteps);
					iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
					bResult = true;
					for (; iTestStep < iTestLastStep; iTestStep++) {
						sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,
								Constants.Sheet_TestSteps);
						sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject,
								Constants.Sheet_TestSteps);
						sData = ExcelUtils.getCellData(iTestStep, Constants.Col_DataSet, Constants.Sheet_TestSteps);
						execute_Actions();
						if (bResult == false) {
							ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestcase, Constants.Col_Result,
									Constants.Sheet_TestCases, duongdanfile, "red");
							
							ExcelUtils.setCellData(currentDate(), iTestcase, Constants.Col_Date_TestCase, Constants.Sheet_TestCases, duongdanfile, "red");
							
							Log.endTestCase(sTestCaseID);
							break;
						}
					}
					if (bResult == true) {
						ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestcase, Constants.Col_Result,
								Constants.Sheet_TestCases, duongdanfile, "blue");
						
						ExcelUtils.setCellData(currentDate(), iTestcase, Constants.Col_Date_TestCase, Constants.Sheet_TestCases, duongdanfile, "blue");
						
						Log.endTestCase(sTestCaseID);
					}
				}				
			}
		}
	}

	private static void execute_Actions() throws Exception {

		for (int i = 0; i < method.length; i++) {

			if (method[i].getName().equals(sActionKeyword)) {
				method[i].invoke(actionKeywords, sPageObject, sData);
				if (bResult == true) {
					ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult,
							Constants.Sheet_TestSteps, duongdanfile, "blue");
					break;
				} else {
					ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult,
							Constants.Sheet_TestSteps, duongdanfile, "red");
//					ActionKeywords.closeBrowser("", "");
					break;
				}
			}
		}
	}
	
	private String currentDate(){
	 	DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
     	
     	Date currentDate = new Date(System.currentTimeMillis());
 		
     	String formattedDate= dateFormat.format(currentDate);
     	
     	return formattedDate;
    	 
     }

	/**
	 * Create the frame.
	 */
	public main_run_gui() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();

		final JFileChooser chooser = new JFileChooser();
		final JFileChooser chooser2 = new JFileChooser();
		JButton btnNewButton = new JButton("Run");
		btnNewButton.setBounds(365, 41, 123, 23);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					duongdanfile = chooser.getSelectedFile() + " ";
					ExcelUtils.setExcelFile(duongdanfile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				DOMConfigurator.configure("log4j.xml");

				try {
					FileInputStream fs = new FileInputStream(chooser2.getSelectedFile() + " ");
					OR = new Properties(System.getProperties());
					OR.load(fs);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				main_run_gui startEngine = new main_run_gui();

				try {
					startEngine.execute_TestCase();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("TESTCASES IS COMPLETED!!!");
				Log.info("TESTCASES IS COMPLETED!!!");

			}

			private By autoOptions() {
				// TODO Auto-generated method stub
				return null;
			}
		});

		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JButton btnSelectFileAccount = new JButton("Select Excel Testcase File");
		btnSelectFileAccount.setBounds(10, 90, 184, 23);
		btnSelectFileAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setAcceptAllFileFilterUsed(true);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//					System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
					String linkfileexcel = chooser.getSelectedFile().getPath();
//					linkfileExcelTestcase = linkfileexcel;
					System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
					txtExcelFile.setText(linkfileexcel);

				} else {
					System.out.println("No Selection ");

				}
			}
		});
		contentPane.add(btnSelectFileAccount);

		JButton btnNewButton_1 = new JButton("Select OR File");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser2.setCurrentDirectory(new java.io.File("."));
				chooser2.setDialogTitle("choosertitle2");
				chooser2.setAcceptAllFileFilterUsed(true);
				if (chooser2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//					System.out.println("getCurrentDirectory(): " + chooser2.getCurrentDirectory());
					String linkfilOR = chooser2.getSelectedFile().getPath();
					System.out.println("getSelectedFile() : " + chooser2.getSelectedFile());
					txtORFile.setText(linkfilOR);
				} else {
					System.out.println("No Selection ");

				}
			}
		});
		btnNewButton_1.setBounds(10, 144, 184, 23);
		contentPane.add(btnNewButton_1);

		lblDiwms.setBounds(0, 3, 109, 31);
		contentPane.add(lblDiwms);

		txtExcelFile = new JTextField();
		txtExcelFile.setEnabled(false);
		txtExcelFile.setBounds(204, 91, 658, 20);
		contentPane.add(txtExcelFile);
		txtExcelFile.setColumns(10);

		txtORFile = new JTextField();
		txtORFile.setEnabled(false);
		txtORFile.setColumns(10);
		txtORFile.setBounds(204, 145, 658, 20);
		contentPane.add(txtORFile);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 178, 852, 337);
		contentPane.add(textArea);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 180, 852, 335);
		contentPane.add(scrollPane);
		scrollPane.add(textArea);

	}
}
