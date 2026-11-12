Customer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
	javac -g Customer.java

User.class: User.java HasMenu.class
	javac -g User.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
	javac -g SavingsAccount.java

Admin.class: Admin.java User.class HasMenu.class
	javac -g Admin.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

Bank.class: Bank.java Admin.class Customer.class HasMenu.class
	javac -g Bank.java

testAdmin: Admin.class
	java Admin

testCustomer: Customer.class
	java Customer

testChecking: CheckingAccount.class
	java CheckingAccount

testSavings: SavingsAccount.class
	java SavingsAccount

run: Bank.class
	java Bank

clean:
	rm *.class
