import java.util.Scanner;

class BankAccount{
	
	String name, userName, password, accountNo;
	float balance = 60000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		this.name = sc.nextLine();
		System.out.println("\nEnter your Username: ");
		this.userName = sc.nextLine();
		System.out.println("\nEnter your Password: ");
		this.password = sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration Successful. Please Log in to your Bank Account");
	}
	public boolean login() {
		boolean isLogin = false;
		Scanner sc=new Scanner(System.in);
		while( !isLogin) {
			System.out.println("\nEnter your username: ");
			String Username = sc.nextLine();
			if (Username.equals(userName)) {
				while(!isLogin) {
					System.out.println("\nEnter your password: ");
					String Password = sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("\nLogin Successful");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	
	public void withdraw() {
		System.out.println("\nEnter Amount to Withdraw: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			if(balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdral Successful.");
				String str = amount + "/- Rs Withdrawn\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("\nInsufficient Balance.");
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void deposit() {
		System.out.println("\nEnter Amount to Deposit: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			if(amount <= 20000f) {
				transactions++;
				balance += amount;
				System.out.println("\nDeposit Successful.");
				String str = amount + "/- Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("\nSorry! The limit is 20,000/- Rs");
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void transfer() {
	    Scanner sc=new Scanner(System.in); 
		System.out.println("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.println("\nEnter Amount to transfer: ");
		float amount = sc.nextFloat();
		try {
			if(balance>= amount) {
			if(amount <= 40000f) {
				transactions++;
				balance -= amount;
				System.out.println("\nSuccesfully Transferred to "+ receipent);
				String str = amount + "/- Rs transferred to " + receipent+"\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("\nSorry! The limit is 40,000/- Rs");
			}
		}else{
			System.out.println("\nInsufficient Balance!");
		}}catch(Exception e) {
		}
			
		}
		
	public void checkBalance() {
		System.out.printf("\n%,.1f/- Rs\n",balance);
	}
	
	
	
	
	public void transHistory() {
		if(transactions ==0) {
			System.out.println("No Transactions happened!");
		}else {
			System.out.print("\n"+transactionHistory);
		}
	}
}

public class ATMInterface {
	
	public static int takenIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && input>limit || input<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value.");
				flag=false;
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		System.out.println("\n<-------------ANUBHAV'S ATM INTERFACE------------->");
		System.out.println("\nI. REGISTRATION \nII. EXIT");
		System.out.println("Choose one option: ");
		int choose = takenIntegerInput(2);
		
		if(choose == 1) {
			BankAccount b= new BankAccount();
			b.register();
			while(true) {
				System.out.println("\nI. LOGIN \nII. EXIT");
				System.out.println("Enter your choice: ");
				int ch = takenIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("\n<--------WELCOME BACK! "+b.name.toUpperCase() +"-------->");
						boolean isFinished = false;
						while(!isFinished) {
							System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check balance \n5. Transaction History \n6. Exit");
							System.out.println("Enter your choice: ");
							int c = takenIntegerInput(6);
							switch(c) {
							  case 1 -> b.withdraw();
							  case 2 -> b.deposit();
							  case 3 -> b.transfer();
							  case 4 -> b.checkBalance();
							  case 5 -> b.transHistory();
							  case 6 -> isFinished = true;
							}
						}
					}
				}else {
					System.exit(0);
				}
				
			}
		}else {
			System.exit(0);
		}
	}

}



