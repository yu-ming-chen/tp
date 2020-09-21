
# User Guide
NUSave is a **desktop app for managing expenditures, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, NUSave can help you manage and track expenses faster than traditional GUI apps.  
  
## Table of Contents  
- [Quick Start](#quick-start)   
- [Features](#features)  
    * [Creating a budget book: `create`](#creating-a-budget-book-create)
    * [Opening a budget book: `open`](#opening-a-budget-book-open)
    * [Closing a budget book: `close`](#closing-a-budget-book-close)
    * [Listing all budget books or expenditures: `list`](#listing-all-budget-books-or-expenditures-list)
    * [Locating expenditures by name: `find`](#locating-expenditures-by-name-find)
    * [Deleting a budget book or expenditure: `del`](#deleting-a-budget-book-or-expenditure-del)
    * [Listing available commands: `help`](#listing-available-commands-help)
    * [Exiting the program: `exit`](#exiting-the-program-exit)
- [Command Summary](#command-summary)  
  
  
## Quick Start  
  
1. Ensure you have Java `11` or above installed in your Computer.  
      
2. Download the latest `NUSave.jar` from [here](https://github.com/AY2021S1-CS2103T-T11-4/tp/releases).  
      
3. Copy the file to the folder you want to use as the *home folder* for your NUSave.  
      
4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds.  
      
5. Type the command in the command box and press enter to execute it. Some example commands you can try:  
    - `list`: Lists all budget books.  
      
   - `create Temasek Hall`: Adds a budget book named Temasek Hall to NUSave.  
      
   - `open 1`: Opens the 3rd budget book (Temasek Hall) shown in the current list.  
      
   - `add  Hall Fees 2600`: Adds an expenditure named `Hall Fees` of price $2600 to the budget book (Temasek Hall) that is open.  
      
   - `del 1`: Deletes the 1st expenditure (Hall Fees) in the list of expenditures.  
      
   - `close`: Closes the budget book (Temasek Hall) that is open.  
      
   - `del 1`: Deletes the 1st budget book (Temasek Hall) in the list of budget books.  
      
   - `help`: Shows the list of commands available for NUSave.  
      
   - `exit` : Exits the app.  
     
6. Refer to the [features](#features) below for details of each command.  
  
---  
## Features  
  
### Creating a budget book: `create`
  
Creates a budget book in NUSave.  
  
Format: `create NAME`  
  
- This command is only available when no budget book is open.  
- Creates a budget book with the given `NAME`.  
     
Examples:  
- `create Tembusu College`  
- `create Temasek Hall`  
    
    
### Opening a budget book: `open`
  
Opens a budget book in NUSave.  
  
Format: `open INDEX`  
- This command is only available when no budget book is open.  
- Opens the budget book at the specific `INDEX`.      
- `INDEX` refers to the index number shown in the displayed budget book list.  
- The index must be a positive integer e.g. 1, 2, 3, ...  
  
Examples:  
- `open 1`  
  
### Closing a budget book: `close`

Closes the budget book that is open in NUSave.  
  
Format: `close`  
- This command is only available when a budget book is open.  
   
### Listing all budget books or expenditures: `list`

Shows a list of budget books or expenditures in NUSave.  
  
Format:  `list`  
- If a budget book is open, shows a list of all expenditures within the budget book.  
- Otherwise, shows a list of all budget books in NUSave.    
  
### Locating expenditures by name: `find`
  
Finds expenditures whose names contain any of the given keywords.  
  
Format:  `find KEYWORD`  
- This command is only available when a budget book is open.  
- Searches expenditures within the budget book that is open.  
      
Examples:  
- `find Breakfast`  
- `find Grab`  
  
### Deleting a budget book or expenditure: `del`  
  
Deletes the specific budget book or expenditure from NUSave.  
  
Format: `del INDEX`  
- If a budget book is open, deletes the expenditure at the specific `INDEX`.  
- Otherwise, deletes the budget book at the specific `INDEX`.  
- `INDEX` refers to the index number shown in the displayed expenditure/budget book list.  
- The index must be a positive integer e.g. 1, 2, 3, ...  
  
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
|Create (Budget Book)|`create NAME` <br>e.g. `create Temasek Hall`|  
|Open (Budget Book)  |`open INDEX`<br>e.g. `open 1`|  
|Close (Budget Book) |`close`|  
|Add (Expenditure)   |`add NAME PRICE`<br>e.g. `add Breakfast 100`|  
|Delete              |`del INDEX`<br>e.g. `del 1`|  
|List                |`list`|  
|Find                |`find KEYWORD`<br>e.g. `find Temasek Hall`<br>     `find Grab`|  
|Help                |`help`|  
|Exit                |`exit`|
