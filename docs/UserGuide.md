# User Guide
## Table of Contents
1. [Introduction](#1-introduction)
    - [1.1 Welcome](#11-welcome)
    - [1.2 Purpose of document](#12-purpose-of-document)
    - [1.3 Target audience](#13-target-audience)
2. [About the user guide](#2-about-the-user-guide)
    - [2.1 Symbols](#21-symbols)
    - [2.2 Format](#22-format)
    - [2.3 Parameters](#23-parameters)
3. [Quick start](#3-quick-start)
4. [Layout](#4-layout)
    - [4.1 Main page view](#41-main-page-view)
    - [4.2 Budget page view](#42-budget-page-view)
5. [Tips](#5-tips)
    - [5.1 Syntax highlighting](#51-syntax-highlighting)
6. [Commands](#6-commands)
    - [6.1 Navigation](#61-navigation)
        * [6.1.1 Opening a budget: `open`](#611-opening-a-budget-open)
        * [6.1.2 Closing a budget:`close`](#612-closing-a-budget-close)
        * [6.1.3 Exit NUSave: `exit`](#613-exit-nusave-exit)
        * [6.1.4 View help: `help`](#614-view-help-help)   
    - [6.2 Main page commands](#62-main-page-commands)
        * [6.2.1 Creating a budget: `create`](#621-creating-a-budget-create)
        * [6.2.2 Deleting a budget: `delete`](#622-deleting-a-budget-delete)
        * [6.2.3 Editing a budget: `edit`](#623-editing-a-budget-edit)
        * [6.2.4 Finding budgets: `find`](#624-finding-budgets-find)
        * [6.2.5 Listing budgets: `list`](#625-listing-budgets-list)
        * [6.2.6 Sorting budgets: `sort`](#626-sorting-budgets-sort)
        * [6.2.7 Clear expenditure: `clear`](#627-clear-budgets-clear)
    - [6.3 Budget page commands](#63-budget-page-commands)
        * [6.3.1 Adding an expenditure: `add`](#631-adding-an-expenditure-add)
        * [6.3.2 Deleting an expenditure: `delete`](#632-deleting-an-expenditure-delete)
        * [6.3.3 Editing an expenditure: `edit`](#633-editing-an-expenditure-edit)
        * [6.3.4 Finding expenditures: `find`](#634-finding-expenditures-find)
        * [6.3.5 Listing expenditures: `list`](#635-listing-expenditures-list)
        * [6.3.6 Sorting expenditures: `sort`](#636-sorting-expenditures-sort)
        * [6.3.7 Clear expenditures: `clear`](#637-clear-expenditures-clear)
7. [Command summary](#7-command-summary)
    - [7.1 Navigation](#71-navigation)
    - [7.2 Main page commands](#72-main-page-commands)
    - [7.3 Budget page commands](#73-budget-page-commands)
8. [Glossary](#8-glossary)
9. [FAQ](#9-faq) 

## 1 Introduction

### 1.1 Welcome
Hello, welcome to NUSave! 

NUSave is a **productivity desktop application for tracking and managing expenditures** across different 
**budget categories**. NUSave is built using a text-based user interface, also known as a Command Line Interface (CLI), 
accompanied by a Graphical User Interface (GUI). 
If you are fast at typing, prefer using your keyboard, and enjoy appealing visuals,
NUSave is here to help.

### 1.2 Purpose of document
The purpose of this document is to aid users with their experience in using NUSave.
By providing detailed information regarding the different commands and how to use them, it will allow users to smoothly 
use NUSave to the fullest extent.

### 1.3 Target audience
Are you a **University student staying on campus** and having difficulties managing your budgets?

If so, NUSave is built just for you. Made by 5 university student residents, we understand the difficulty of 
having multiple budgets to keep track of in your busy schedule. NUSave aims to alleviate the hassle that comes with 
tracking and managing your finances. 

## 2 About the user guide
### 2.1 Symbols
(Contributed by Yu Ming)

Symbols | Meaning 
-------| ------------ 
⚠️ | This sybmol indicates that there is something important for you to take note of.
📕 | This symbol indicates that there is additional information you may find useful.
 ✏️ | This symbol indicates that an example is provided.
 ❗| This symbol indicates that the parameter is required.
 ❕| This symbol indicates that the parameter is optional.

### 2.2 Format
(Contributed by Yu Ming)

This section shows the format of all the commands in the user guide.

Format | Meaning | Exmaple 
-------| ------------ | ----
`lower_case/` | **Prefixes** | `n/` `p/` `t/` <br/> ⚠️ Prefixes **cannot have spaces**: `n /` will be an invalid prefix| 
`UPPER_CASE` | **Parameters** | `NAME` `THRESHOLD` `PRICE`
`[UPPER_CASE]` | **Optional parameters** | `[p/THRESHOLD]` in create budget command

📕 Note: Parameters can be in **any order** if they have **prefixes**.

For example, a create budget command can have `n/NAME` and `p/THRESHOLD`, you can specify them in any order:
 - `create n/Temasek Hall Student Council p/1200`, or
 - `create p/1200 n/Temasek Hall Student Council`
 
 However, if a given command has any parameter **without prefix**, that given parameter **must** be the **first parameter**.

For example, a edit budget command have an `INDEX`, a `n/NAME` and a `p/THRESHOLD`. In this case, `INDEX` **must** be
the **first parameter**:
 - `edit 1 n/NUS Computing Club p/1000` is a valid command, however
 - `edit n/NUS Computing Club p/1000 1` is an invalid command
### 2.3 Parameters
(Contributed by Yu Ming)

Parameter | Meaning 
-------| ------------
`INDEX` | Index to be executed on for any given command 
`NAME` | This can be either **name of budget** or **name of expenditure** or **name to find** 
`PRICE` | This is the price of the expenditure 
`THRESHOLD` | This is the maximum capacity of the budget 
`TAG` | This is the tag for the expenditure 
`SORTTYPE` | This is the sorting types 
## 3 Quick start
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

6. Refer to the [commands](#6-commands) below for details of each command.
## 4 Layout
### 4.1 Main page view

### 4.2 Budget page view

## 5 Tips
### 5.1 Syntax highlighting

## 6 Commands
### 6.1 Navigation
#### 6.1.1 Opening a budget: `open`

#### 6.1.2 Closing a budget: `close`

#### 6.1.3 Exit NUSave: `exit`
(Contributed by David)

You can use this command to **exit from the application**.

When exiting NUSave, all changes made to the application will be saved.

```📕 You can use this command at any point of time.```

Format: `exit`

✏️ Example
`exit`

This will exit the application. When the application is launched again, the change you made will remain.

![Example of exit command](images/CommandScreenShots/6_1_3_1_exit.png)

Figure 6.2.1.1: Example of using the exit command on both the main page and budget page.

#### 6.1.4 View help: `help`
(Contributed by Yu Ming)

You can use this command to **view a list of available commands**.

The help will be displayed in the results window, and it will contain a list of all available commands and their
required syntax.

```📕 You can use this command at any point of time.```

✏️ Example:

`help`

This will display the help instructions in the results window.

![Example of help command](images/CommandScreenShots/6_1_4_1_help.png)

Figure 6.1.4.1: Example of help command

### 6.2 Main page commands
#### 6.2.1 Creating a budget: `create`
(Contributed by Yu Ming)

You can use this command to **create a new budget**.

When a new budget is created it will be stored inside NUSave, and it will be reflected immediately in the list of budget
on the main page of NUSave. This command is only available when no budget is open.

 > ⚠️ Upon first launch, **you may notice NUSave main page is empty**. This is because there are no budgets created yet. Go
 > ahead and create a budget to see NUSave get populated with your entries!

Format: `create n/NAME [p/THRESHOLD]`

Prefix | Parameters | Requirement | Comments
-------| ------------ | ------------- | ------
 n/ | NAME | ❗Required | Name of the budget
 p/ | THRESHOLD | ❕Optional | Target maximum capacity of the budget

✏️ Example:

`create n/Temasek Hall Student Council p/1200`

This will create a new budget called "Temasek Hall Student Council" with a threshold value of $1200.

![Example of create budget command](images/CommandScreenShots/6_2_1_1_createBudget.png)

Figure 6.2.1.1: Example of create budget command

#### 6.2.2 Deleting a budget: `delete`
(Contributed by David)

You can use this command to **delete an existing budget**.

When a budget is deleted it will be removed from NUSave, and the 
deletion will be reflected immediately in the list of budget on the main page of NUSave.

 > ⚠️ **You cannot use this command if main page is empty**. This is because there are no budgets created yet. 
 > You can only delete a budget if there are already existing budgets!

Format: `delete INDEX`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
Index | ❗Required | Index of the budget

✏️ Example:

`delete 1`
This will delete the budget with the index "1".

![Example of delete budget command](images/CommandScreenShots/6_2_2_1_deleteBudget.png)

Figure 6.2.1.1: Example of delete budget command
#### 6.2.3 Editing a budget: `edit`
(Contributed by Yu Ming)

You can use this command to **edit an existing budget**.

When a budget is edited the changes will be saved on NUSave, and  will be 
reflected immediately on the list of budgets.

>⚠️ You can only use this command on existing budgets.  

Format: edit INDEX n/NAME p/THRESHOLD

Prefix | Parameters | Requirement | Comments
-------| ------------ | ------------- | ------
 \- | INDEX | ❗Required | Index of the budget displayed on NUSave
 n/ | NAME | ❕Optional | Name of the budget to be edited to
 p/ | THRESHOLD | ❕Optional | Threshold of the budget to be edited to
 
 >⚠️ Although both NAME and THRESHOLD fields are optional You must have at least one of the Prefix and 
 > corresponding Parameters present. 

✏️ Example:

Format: `edit 2 n/NUS Computing club`

This will edit a budget at **index 2** to be **renamed "NUS Computing Club"**.

![Example of edit budget command](images/CommandScreenShots/6_2_3_1_editBudget.png)

Figure 6.2.3.1: Example of edit budget command

#### 6.2.4 Finding budgets: `find`

#### 6.2.5 Listing budgets: `list`

#### 6.2.6 Sorting budgets: `sort`
(Contributed by Yu Ming)

You can use this command to **sort your budgets**.

You can sort your budgets based on two different type of sorts:
1. Sort by created date (the latest budget created will be at the top of the main page of NUSave)

   
   ```📕 Note: If budgets are created on the same date. They will be sorted by name within themselves.```
   
2. Sort by name of the budget (budgets will be ordered in alphabetical order from a-z, case-insensitive)

>⚠️ If there are **no budgets** or there is **only one budget** in NUSave, the sort command may not show any effect.
> This is because there needs to be more than one budget for sorting to work. Go ahead and add in more budgets 
> to see your budgets in NUSave get sorted!

Format: `sort SORTTYPE`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
 SORTYPE | ❗Required | Two different type of sorts available: `time` `name`

✏️ Example:

`sort name`

This will sort all the budgets in NUSave by their name in alphabetic order.

![Example of sort budgets command](images/CommandScreenShots/6_2_6_1_sortBudget.png)

Figure 6.2.6.1: Example of sort budgets command
#### 6.2.7 Clear budgets: `clear`
### 6.3 Budget page commands
#### 6.3.1 Adding an expenditure: `add`

#### 6.3.2 Deleting an expenditure: `delete`
(Contributed by David)

You can use this command to **delete an existing expenditure**.

When an expenditure is deleted it will be removed from NUSave, and the 
deletion will be reflected immediately in the list of expenditures on the budget page of NUSave.

 > ⚠️ **You cannot use this command if budget page is empty**. This is because there are no expenditures created yet. 
 > You can only delete an expenditure if there are already existing budgets!

Format: `delete INDEX`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
Index | ❗Required | Index of the expenditure

✏️ Example:

`delete 2`

This will delete the expenditure with the index "2".

![Example of delete expenditure command](images/CommandScreenShots/6_3_2_1_deleteExpenditure.png)

Figure 6.3.2.1: Example of delete expenditure command

#### 6.3.3 Editing an expenditure: `edit`
(Contributed by David)

You can use this command to **edit an existing expenditure**.

When an expenditure is edited the changes will be saved on NUSave, and  will be 
reflected immediately on the list of expenditures.

 > ⚠️ **You can only use this command on existing expenditures**.  

Format: `edit INDEX n/NAME p/PRICE`

Prefix | Parameters | Requirement | Comments
-------| ------------ | ------------- | ------
- | INDEX | ❗Required | Index of the expenditure displayed on NUSave
 n/ | NAME | ❕Optional | Name of the expenditure to be edited to
 p/ | PRICE | ❕Optional | Price of the expenditure to be edited to
 
 > ⚠️ Although both NAME and PRICE fields are optional **You must have at least one of the Prefix and 
 >  corresponding Parameters present**. 

✏️ Example:

Format: `edit 1 n/Long-Sleeve p/20`

This will edit an expenditure at **index 1** to be **renamed** "Long-Sleeve" with an edited **price** of $20.

![Example of edit expenditure command](images/CommandScreenShots/6_3_3_1_editExpenditure.png)

Figure 6.3.3.1: Example of edit expenditure command
#### 6.3.4 Finding expenditures: `find`

#### 6.3.5 Listing expenditures: `list`

#### 6.3.6 Sorting expenditures: `sort`
(Contributed by Yu Ming)

You can use this command to **sort your expenditures** within a budget.

You can sort your expenditures within a budget based on two different type of sorts:
1. Sort by added date (the latest expenditure added will be at the top of that budget page in NUSave)

   
   ```📕 Note: If expenditures are created on the same date. They will be sorted by name within themselves.```
   
2. Sort by name of the expenditure (expenditures will be ordered in alphabetical order from a-z, case-insensitive)

>⚠️ If there are **no expenditures** or there is **only one expenditure** in that budget, the sort command may not 
> show any effect. This is because there needs to be more than one expenditure for sorting to work. 
> Go ahead and add in more expenditures to see your expenditures in that budget get sorted!

Format: `sort SORTTYPE`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
 SORTYPE | ❗Required | Two different type of sorts available: `time` `name`

✏️ Example:

`sort time`

This will sort all the expenditures in that budget by their added date with the latest expenditure added at the top.

![Example of sort expenditures command](images/CommandScreenShots/6_3_6_1_sortExpenditure.png)

Figure 6.3.6.1: Example of sort expenditures command

#### 6.3.7 Clear expenditures: `clear`

## 7 Command summary
### 7.1 Navigation
| **Action** | **Format, Examples** |
|--------|--------------------------|
|Open (Budget)       |`open INDEX`<br>e.g. `open 1`|
|Close (Budget)      |`close`|
|Help                |`help`|
|Exit                |`exit`|
### 7.2 Main page commands
| **Action** | **Format, Examples** |
|--------|--------------------------|
|Create (Budget)     |`create n/NAME`, `create n/NAME p/THRESHOLD` <br>e.g. `create n/Daily Expenses`, `create n/Project Work p/100`|
|Delete (Budget)     |`delete INDEX`<br>e.g. `delete 1`|
|List                |`list`|
|Find                |`find KEYWORD`<br>e.g. `find Breakfast`|


### 7.3 Budget page commands
| **Action** | **Format, Examples** |
|--------|--------------------------|
|Add (Expenditure)   |`add n/NAME p/PRICE` <br>e.g. `add n/Breakfast p/10`|
|Delete (Expenditure)|`delete INDEX`<br>e.g. `delete 1`|
|List                |`list`|
|Find                |`find KEYWORD`<br>e.g. `find Breakfast`|

## 8 Glossary

## 9 FAQ







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


