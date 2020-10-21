# User Guide
NUSave is a **desktop app for managing expenditures, optimized for use via a Command Line Interface** (CLI) while still
having the benefits of a Graphical User Interface (GUI). If you can type fast, NUSave can help you manage and track
expenses faster than traditional GUI apps.

## Table of Contents  
- [Quick Start](#quick-start)
- [Features](#features)
    * [Creating a budget: `create`](#creating-a-budget-create)
    * [Opening a budget: `open`](#opening-a-budget-open)
    * [Closing a budget: `close`](#closing-a-budget-close)
    * [Adding an expenditure: `add`](#adding-an-expenditure-add)
    * [Listing all budgets or expenditures: `list`](#listing-all-budgets-or-expenditures-list)
    * [Locating expenditures by name: `find`](#locating-expenditures-by-name-find)
    * [Deleting a budget or expenditure: `del`](#deleting-a-budget-or-expenditure-delete)
    * [Listing available commands: `help`](#listing-available-commands-help)
    * [Exiting the program: `exit`](#exiting-the-program-exit)
- [Command Summary](#command-summary)

## Quick Start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `NUSave.jar` from [here](https://github.com/AY2021S1-CS2103T-T11-4/tp/releases).

3. Copy the file to the folder you want to use as the *home folder* for NUSave.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds.

5. Type the command in the command box and press enter to execute it. Below is a series of commands that you can try:
    - `create n/Test`: Creates a new budget with the name "Test".
    - `find test`: Finds budgets whose names match the keyword "test". The GUI should reflect a list that contains only
    the "test" budget that has just been created.
    - `open 1`: Opens the budget at index 1. The GUI should reflect an empty list as you have yet to add any expenditure
    to the "test" budget.
    - `add n/Bread p/2.5`: Adds an expenditure with the name "Bread" that has a price of $2.50 to the "test" budget.
    - `help`: Shows the list of commands available for NUSave.
    - `exit`: Exits the app.

6. Refer to the [features](#features) below for details of each command.

## Features

### Creating a budget: `create`

Creates a budget in NUSave.

Format: `create n/NAME`, `create n/NAME p/THRESHOLD`

- This command is only available when no budget is open.
- Creates a budget with the given `NAME` and `THRESHOLD`.
- The `THRESHOLD` parameter optional.

Examples:
- `create n/Daily Expenses`
- `create n/School Related Expenses p/100`

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

Format: `add n/NAME p/PRICE`
- This command is only available when a budget is open.
- Adds an expenditure with the given NAME and PRICE to the budget that is open.
- The price **must be a positive integer or double with a maximum of 2 decimal places** e.g. 8, 2.55, 3.4, ...

Example:
- add n/School Fees p/5000
- add n/Lunch at Food Court p/4.5

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

### Deleting a budget or expenditure: `delete`

Deletes the specific budget or expenditure from NUSave.

Format: `delete INDEX`
- If a budget is open, deletes the expenditure at the specific `INDEX`.
- Otherwise, deletes the budget at the specific `INDEX`.
- `INDEX` refers to the index number shown in the displayed expenditure/budget list.
- The index **must be a positive integer** e.g. 1, 2, 3, ...

Examples:
- `delete 1`

### Listing available commands: `help`

Shows a list of available commands with descriptions in NUSave. 

Format:  `help`

### Exiting the program: `exit`

Exits the program.  

Format:  `exit`

## Command Summary
Commands available on the main page:

| **Action** | **Format, Examples** |
|--------|--------------------------|
|Create (Budget)     |`create n/NAME`, `create n/NAME p/THRESHOLD` <br>e.g. `create n/Daily Expenses`, `create n/Project Work p/100`|
|Open (Budget)       |`open INDEX`<br>e.g. `open 1`|
|Delete (Budget)     |`delete INDEX`<br>e.g. `delete 1`|
|List                |`list`|
|Find                |`find KEYWORD`<br>e.g. `find Breakfast`|
|Help                |`help`|
|Exit                |`exit`|

Commands available on a budget page:

| **Action** | **Format, Examples** |
|--------|--------------------------|
|Add (Expenditure)   |`add n/NAME p/PRICE` <br>e.g. `add n/Breakfast p/10`|
|Close (Budget)      |`close`|
|Delete (Expenditure)|`delete INDEX`<br>e.g. `delete 1`|
|List                |`list`|
|Find                |`find KEYWORD`<br>e.g. `find Breakfast`|
|Help                |`help`|
|Exit                |`exit`|