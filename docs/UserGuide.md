
# User Guide
NUSave is a **desktop app for managing expenditures, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, NUSave can help you manage and track expenses faster than traditional GUI apps.  
  
## Table of Contents  
- [Quick Start](#quick-start)   
- [Features](#features)  
    * [Creating a budget: `create`](#creating-a-budget-create)
    * [Opening a budget: `open`](#opening-a-budget-open)
    * [Closing a budget: `close`](#closing-a-budget-close)
    * [Adding an expenditure: `add`](#adding-an-expenditure-add)
    * [Listing all budgets or expenditures: `list`](#listing-all-budgets-or-expenditures-list)
    * [Locating expenditures by name: `find`](#locating-expenditures-by-name-find)
    * [Deleting a budget or expenditure: `del`](#deleting-a-budget-or-expenditure-del)
    * [Listing available commands: `help`](#listing-available-commands-help)
    * [Exiting the program: `exit`](#exiting-the-program-exit)
- [Command Summary](#command-summary)  
  
  
## Quick Start  
  
1. Ensure you have Java `11` or above installed in your Computer.  
      
2. Download the latest `NUSave.jar` from [here](https://github.com/AY2021S1-CS2103T-T11-4/tp/releases).  
      
3. Copy the file to the folder you want to use as the *home folder* for your NUSave.  
      
4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds.  
      
5. Type the command in the command box and press enter to execute it. Some example commands you can try:  
    - `list`: Lists all budgets.  
      
   - `create School Related Expenses`: Adds a budget named School Related Expenses to NUSave.  
      
   - `open 1`: Opens the 1st budget (School Related Expenses) shown in the current list.  
      
   - `add  Hall Fees 2600`: Adds an expenditure named `Hall Fees` of price $2600 to the budget (School Related Expenses) that is open.  
      
   - `del 1`: Deletes the 1st expenditure (Hall Fees) in the list of expenditures.  
      
   - `close`: Closes the budget (School Related Expenses) that is open.  
      
   - `del 1`: Deletes the 1st budget (School Related Expenses) in the list of budgets.  
      
   - `help`: Shows the list of commands available for NUSave.  
      
   - `exit` : Exits the app.  
     
6. Refer to the [features](#features) below for details of each command.  
  
---  
## Features  
  
### Creating a budget: `create`
  
Creates a budget in NUSave.  
  
Format: `create NAME`  
  
- This command is only available when no budget is open.  
- Creates a budget with the given `NAME`.  
     
Examples:  
- `create Daily Expenses`  
- `create School Related Expenses`  
    
    
### Opening a budget: `open`
  
Opens a budget in NUSave.  
  
Format: `open INDEX`  
- This command is only available when no budget is open.  
- Opens the budget at the specific `INDEX`.      
- `INDEX` refers to the index number shown in the displayed budgets list.  
- The index **must be a positive integer** e.g. 1, 2, 3, ...  
  
Examples:  
- `open 1`  
  
### Closing a budget: `close`

Closes the budget currently open in NUSave.  
  
Format: `close`  
- This command is only available when a budget is open.  
   
### Adding an expenditure: `add`
Adds an expenditure to the budget that is open.

Format: `add NAME PRICE`
- This command is only available when a budget is open.
- Adds an expenditure with the given NAME and PRICE to the budget that is open.
- The price **must be a positive integer or double with a maximum of 2 decimal places** e.g. 8, 2.55, 3.4, ...

Example:
- add School Fees 5000
- add Lunch at Food Court 4 

### Listing all budgets or expenditures: `list`

Shows a list of budgets or expenditures in NUSave.  
  
Format:  `list`  
- If a budget is open, shows a list of all expenditures within the budget.  
- Otherwise, shows a list of all budgets in NUSave.    
  
### Locating expenditures by name: `find`
  
Finds expenditures whose names contain any of the given keywords.  
  
Format:  `find KEYWORD`  
- This command is only available when a budget is open.  
- Searches expenditures within the budget that is open.  
      
Examples:  
- `find Breakfast`  
- `find Grab`  
  
### Deleting a budget or expenditure: `del`  
  
Deletes the specific budget or expenditure from NUSave.  
  
Format: `del INDEX`  
- If a budget is open, deletes the expenditure at the specific `INDEX`.  
- Otherwise, deletes the budget at the specific `INDEX`.  
- `INDEX` refers to the index number shown in the displayed expenditure/budget list.  
- The index **must be a positive integer** e.g. 1, 2, 3, ...  
  
Examples:  
- `del 1`  
  
### Listing available commands: `help`  
  
Shows a list of available commands with descriptions in NUSave.  
  
Format:  `help`  

### Exiting the program: `exit`

Exits the program.  
  
Format:  `exit`  

---  
## Command Summary  
  
| **Action** | **Format, Examples** |  
|--------|------------------|  
|Create (Budget)|`create NAME` <br>e.g. `create Daily Expenses`|  
|Open (Budget)  |`open INDEX`<br>e.g. `open 1`|  
|Close (Budget) |`close`|  
|Add (Expenditure)   |`add NAME PRICE`<br>e.g. `add Breakfast 10`|  
|Delete              |`del INDEX`<br>e.g. `del 1`|  
|List                |`list`|  
|Find                |`find KEYWORD`<br>e.g. `find Breakfast`|  
|Help                |`help`|  
|Exit                |`exit`|
