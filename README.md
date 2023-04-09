[![Java CI with Maven](https://github.com/crisywini/bank-management/actions/workflows/maven.yml/badge.svg?branch=develop&event=push)](https://github.com/crisywini/bank-management/actions/workflows/maven.yml)

# Bank Management

This project allows you to manage information about clients and accounts. 

Here are some functionalities for client management:

- Save information about clients
- Delete information about clients
- Find all the clients
- Find a client by its id

Here are some functionalities for account management:

- Saves account
- Find an account by its id
- Update an account
- Invest in an account
- Withdraw money from an account
- Close the investment of an account
- Simulate different behaviours giving months for a savings account

## Usage

Installed Maven and Java 17.

Download the repo and run the next command in the root folder:

    mvn spring-boot:run 


Then you can use the localhost:8080/ the exposed services at this moment are:

| Service | Method | Description |
|--|--|--|
| */clients* | POST | Saves the client's information |
| */clients/{clientId}* | DELETE | Deletes the client's information |
| */clients* | GET | Finds all the clients |
| */clients/{clientId}* | GET | Finds a specific client by its id |
| */accounts* | POST | Saves the account's information |
| */accounts?accountId={accountID}&type={accountType}* | GET | Finds a specific account by its id and type (type is optional) |
| */accounts/{accountId}* | PUT | Updates the account's info |
| */accounts/investment?accountId={accountID}&amount={amountToWithdraw}* | POST | Invest money in a specific account|
| */accounts/withdraw?accountId={accountID}&amount={amountToWithdraw}* | POST | Withdraw money from a specific account|
| */accounts/investment/close?accountId={accountID}&checkingAccountId={checkingAccountID}* | POST | Closes the investment of an account getting all the money of that account to the checking account |
| */accounts/simulate/{clientId}?months={months}* | POST | Simulate the savings of a saving account for a specific client|

