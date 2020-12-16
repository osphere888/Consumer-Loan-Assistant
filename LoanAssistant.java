package loanassistant;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoanAssistant extends JFrame{
	private JTextField balanceTextField;
	private JTextField interestTextField;
	private JTextField paymentTextField;
	private JTextField monthsTextField;
	boolean computePayment;
	
	
	public LoanAssistant() {
		setTitle("Loan Assistant");
		setSize(680,310);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loan Balance");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 23, 93, 23);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInterestRate.setBounds(25, 62, 93, 23);
		getContentPane().add(lblInterestRate);
		
		JLabel lblNumberOfPayments = new JLabel("Number of Payments");
		lblNumberOfPayments.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfPayments.setBounds(25, 101, 141, 23);
		getContentPane().add(lblNumberOfPayments);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment");
		lblMonthlyPayment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonthlyPayment.setBounds(26, 141, 121, 23);
		getContentPane().add(lblMonthlyPayment);
		
		balanceTextField = new JTextField();
		balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		balanceTextField.setBounds(171, 22, 111, 29);
		getContentPane().add(balanceTextField);
		balanceTextField.setColumns(10);
		balanceTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				balanceTextFieldActionPerformed(arg0);
				
			}
			
		});
		
		interestTextField = new JTextField();
		interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		interestTextField.setColumns(10);
		interestTextField.setBounds(171, 60, 111, 29);
		getContentPane().add(interestTextField);
		interestTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				interestTextFieldActionPerformed(e);
				
			}
			
		});
		
		paymentTextField = new JTextField();
		paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		paymentTextField.setColumns(10);
		paymentTextField.setBounds(171, 140, 111, 29);
		getContentPane().add(paymentTextField);
		paymentTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paymentTextFieldActionPerformed(e);
				
			}
			
		});
		
		monthsTextField = new JTextField();
		monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		monthsTextField.setBackground(Color.YELLOW);
		monthsTextField.setColumns(10);
		monthsTextField.setBounds(171, 100, 111, 29);
		getContentPane().add(monthsTextField);
		monthsTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monthsTextFieldActionPerformed(e);
				
			}
			
		});
		
		
		
		JButton computeButton = new JButton("Compute Monthly Payment");
		computeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		computeButton.setBounds(44, 192, 248, 29);
		getContentPane().add(computeButton);
		
		JButton newLoanButton = new JButton("New Loan Analysis");
		newLoanButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		newLoanButton.setBounds(71, 232, 162, 25);
		getContentPane().add(newLoanButton);
		
		JLabel lblLoanAnalysis = new JLabel("Loan Analysis:");
		lblLoanAnalysis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoanAnalysis.setBounds(359, 23, 121, 23);
		getContentPane().add(lblLoanAnalysis);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(456, 233, 62, 23);
		getContentPane().add(btnNewButton_3);
		
		JTextArea analysisTextArea = new JTextArea();
		analysisTextArea.setBounds(359, 46, 275, 175);
		analysisTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(analysisTextArea);
		
		JButton paymentButton = new JButton("X");
		paymentButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		paymentButton.setBounds(292, 139, 48, 28);
		getContentPane().add(paymentButton);
		
		
		JButton monthPayment = new JButton("X");
		monthPayment.setFont(new Font("Tahoma", Font.BOLD, 13));
		monthPayment.setBounds(292, 99, 48, 28);
		getContentPane().add(monthPayment);
		
		
		
		paymentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				computePayment = true;
				paymentButton.setVisible(false);
				monthPayment.setVisible(true);
				monthsTextField.setEditable(true);
				monthsTextField.setBackground(Color.WHITE);
				monthsTextField.setFocusable(true);
				paymentTextField.setText("");
				paymentTextField.setEditable(false);
				paymentTextField.setBackground(Color.YELLOW);
				paymentTextField.setFocusable(false);
				computeButton.setText("Compute Number of Payments");
				balanceTextField.requestFocus();
			}
			
		});
		
		monthPayment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				computePayment = false;
				paymentButton.setVisible(true);
				monthPayment.setVisible(false);
				monthsTextField.setText("");
				monthsTextField.setEditable(false);
				monthsTextField.setBackground(Color.YELLOW);
				monthsTextField.setFocusable(false);
				paymentTextField.setEditable(true);
				paymentTextField.setBackground(Color.WHITE);
				paymentTextField.setFocusable(true);

				computeButton.setText("Compute Monthly Payment");
				balanceTextField.requestFocus();
				
			}
			
		});
		
		computeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double balance, interest, payment;
				int months;
				double monthlyInterest, multiplier;
				double loanBalance, finalPayment;
				if (validateDecimalNumber(balanceTextField))
				{
				balance =
				Double.valueOf(balanceTextField.getText()).doubleValue();
				}
				else
				{
				JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPleasecorrect.", "Balance Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
				return;
				}
				if (validateDecimalNumber(interestTextField))
				{
				interest =
				Double.valueOf(interestTextField.getText()).doubleValue();

				}
				else
				{
				JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPleasecorrect.", "Interest Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
				return;
				}
				monthlyInterest = interest / 1200;
				if (computePayment)
				{
				// Compute loan payment
				if (validateDecimalNumber(monthsTextField))
				{
				months =
				Integer.valueOf(monthsTextField.getText()).intValue();
				}
				else
				{
				JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
				}
				if (interest == 0)
				{
				payment = balance / months;
				}
				else
				{
				multiplier = Math.pow(1 + monthlyInterest, months);
				payment = balance * monthlyInterest * multiplier / (multiplier - 1);
				}
				paymentTextField.setText(new DecimalFormat("0.00").format(payment));
				}
				else

				{
				// Compute number of payments
				if (validateDecimalNumber(paymentTextField))
				{
				payment =
				Double.valueOf(paymentTextField.getText()).doubleValue();
				if (payment <= (balance * monthlyInterest + 1.0))
				{
				if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" +new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
				{ 
				paymentTextField.setText(new DecimalFormat("0").format((int)(balance *monthlyInterest + 1.0)));
				payment =
				Double.valueOf(paymentTextField.getText()).doubleValue();
				}
				else
				{
				paymentTextField.requestFocus();
				return;
				}
				}
				}
				else
				{
				JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
				return;
				}
				if (interest == 0)
				{
				months = (int)(balance / payment);
				}
				else

				{
				months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) /Math.log(1 + monthlyInterest));
				}
				monthsTextField.setText(String.valueOf(months));
				}
				// reset payment prior to analysis to fix at two decimals
				payment =
				Double.valueOf(paymentTextField.getText()).doubleValue();
				// show analysis
				analysisTextArea.setText("Loan Balance: $" + new
				DecimalFormat("0.00").format(balance));
				analysisTextArea.append("\n" + "Interest Rate: " + new
				DecimalFormat("0.00").format(interest) + "%");
				// process all but last payment
				loanBalance = balance;
				for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
				{
				loanBalance += loanBalance * monthlyInterest - payment;
				}
				// find final payment
				finalPayment = loanBalance;
				if (finalPayment > payment)
				{
				// apply one more payment
				loanBalance += loanBalance * monthlyInterest - payment;
				finalPayment = loanBalance;
				months++;
				monthsTextField.setText(String.valueOf(months));
				}
				analysisTextArea.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new DecimalFormat("0.00").format(payment));
				analysisTextArea.append("\n" + "Final Payment of: $" + new
				DecimalFormat("0.00").format(finalPayment));
				analysisTextArea.append("\n" + "Total Payments: $" + new
				DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
				analysisTextArea.append("\n" + "Interest Paid $" + new

				DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
				computeButton.setEnabled(false);
				newLoanButton.setEnabled(true);
				newLoanButton.requestFocus();
				
			}
			
		});
		
		newLoanButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (computePayment)
				{
				paymentTextField.setText("");
				}
				else
				{
				monthsTextField.setText("");
				}
				analysisTextArea.setText("");
				computeButton.setEnabled(true);
				newLoanButton.setEnabled(false);
				balanceTextField.requestFocus();
				
			}
			
		});
		
		monthPayment.setVisible(false);
		setVisible(true);
		
	}
	
	

	
	public static void main(String args[]) {
		new LoanAssistant();
	}
	private boolean validateDecimalNumber(JTextField tf)
	{
	// checks to see if text field contains
	// valid decimal number with only digits and a single decimal point
	String s = tf.getText().trim();
	boolean hasDecimal = false;
	boolean valid = true;
	if (s.length() == 0)
	{
	valid = false;
	}
	else
	{
	for (int i = 0; i < s.length(); i++)
	{
	char c = s.charAt(i);
	if (c >= '0' && c <= '9')
	{
	continue;
	}
	else if (c == '.' && !hasDecimal)
	{
	hasDecimal = true;
	}
	else
	{
	// invalid character found

	valid = false;
	}
	}
	}
	tf.setText(s);
	if (!valid)
	{
	tf.requestFocus();
	}
	return (valid);
	}
	
	private void balanceTextFieldActionPerformed(ActionEvent e)
	{
	balanceTextField.transferFocus();
	}
	private void interestTextFieldActionPerformed(ActionEvent e)
	{
	interestTextField.transferFocus();
	}
	private void monthsTextFieldActionPerformed(ActionEvent e)

	{
	monthsTextField.transferFocus();
	}
	private void paymentTextFieldActionPerformed(ActionEvent e)
	{
	paymentTextField.transferFocus();
	}
	
}
