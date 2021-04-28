INSERT INTO ACCOUNTS (id, account_number, account_name, account_type,balance_date,currency, opening_available_balance)
 VALUES  (1,'123456', 'AUDCurrent', 'Current',now(),'AUD',100),
  (2,'112233', 'INRSavings', 'Savings',now(),'INR',200),
  (3,'111222', 'USDSavings', 'Savings',now(),'USD',300);

INSERT INTO ACCOUNT_TRANSACTIONS (id, account_number, account_name, value_date,currency, debit_amount, credit_amount, transaction_type)
 VALUES
  (1,'123456', 'AUDCurrent', now(),'AUD',0,1000, 'CREDIT'),
  (2,'112233', 'INRSavings', now(),'INR',0,1000, 'CREDIT'),
  (3,'111222', 'USDSavings', now(),'USD',0,1000, 'CREDIT'),
  (4,'123456', 'AUDCurrent', now(),'AUD',0,1000, 'CREDIT'),
  (5,'123456', 'INRSavings', now(),'AUD',1000,0, 'DEBIT'),
  (6,'123456', 'USDSavings', now(),'AUD',50,0, 'DEBIT');