# User Guide
## Table of Contents
1. [Overview](#1-overview)
    - [1.1. Introduction](#11-introduction)
    - [1.2. Purpose](#12-purpose)
2. [About the user guide](#2-about-the-user-guide)
    - [2.1. Symbols](#21-symbols)
    - [2.2. Format](#22-format)
    - [2.3. Syntax highlighting](#23-syntax-highlighting)
3. [GUI Layout](#3-gui-layout)
    - [3.1. Main page view](#31-main-page-view)
    - [3.2. Budget page view](#32-budget-page-view)
4. [Quick start](#4-quick-start)
5. [Commands](#5-commands)
    - [5.1. Universal commands](#51-universal-commands)
        * [5.1.1. View help: `help`](#511-view-help-help)   
        * [5.1.2. Exit NUSave: `exit`](#512-exit-nusave-exit)
    - [5.2. Main page commands](#52-main-page-commands)
        * [5.2.1. Creating a budget: `create`](#521-creating-a-budget-create)
        * [5.2.2. Deleting a budget: `delete`](#522-deleting-a-budget-delete)
        * [5.2.3. Editing a budget: `edit`](#523-editing-a-budget-edit)
        * [5.2.4. Finding budgets: `find`](#524-finding-budgets-find)
        * [5.2.5. Listing budgets: `list`](#525-listing-budgets-list)
        * [5.2.6. Sorting budgets: `sort`](#526-sorting-budgets-sort)
        * [5.2.7. Clearing budgets: `clear`](#527-clearing-budgets-clear)
        * [5.2.8. Opening a budget: `open`](#528-opening-a-budget-open)
    - [5.3. Budget page commands](#53-budget-page-commands)
        * [5.3.1. Adding an expenditure: `add`](#531-adding-an-expenditure-add)
        * [5.3.2. Deleting an expenditure: `delete`](#532-deleting-an-expenditure-delete)
        * [5.3.3. Editing an expenditure: `edit`](#533-editing-an-expenditure-edit)
        * [5.3.4. Finding expenditures: `find`](#534-finding-expenditures-find)
        * [5.3.5. Listing expenditures: `list`](#535-listing-expenditures-list)
        * [5.3.6. Sorting expenditures: `sort`](#536-sorting-expenditures-sort)
        * [5.3.7. Closing a budget:`close`](#537-closing-a-budget-close)
6. [Command summary](#6-command-summary)
    - [6.1. Universal commands](#61-universal-commands)
    - [6.2. Main page commands](#62-main-page-commands)
    - [6.3. Budget page commands](#63-budget-page-commands)
7. [Glossary](#7-glossary)
8. [FAQ](#8-faq) 

## 1. Overview
(Contributed by Wen Hao)

Welcome to the NUSave User Guide! In this section, you will be given an overview of what NUSave is about
and what you can get out of reading this document.

### 1.1. Introduction
(Contributed by Wen Hao)

Are you a **university student who stays on campus** and has difficulty managing your expenses?
Are you tired of having to look through countless spreadsheets and memos just to figure out how much you have spent this month?
Do you wish there exists a desktop application that can help you organise, track and manage all of your expenses?

Look no further, NUSave is just the tool for you!

Built by 5 university students staying on campus, we understand **the difficulties of having to manage multiple budgets**,
be it for your daily expenses, school projects or club activities, amidst your busy schedule. NUSave aims to help alleviate
the hassle that comes along with managing multiple budgets by providing a **one-stop solution** to all your problems.

With NUSave, you can **create, edit and delete budgets and expenditures**, as well as **generate statistics
based on the items you have entered** to gain useful insights regarding your spending habits.

What's more, NUSave has:
- a **Command Line Interface (CLI)** catered to those who can type fast and prefer to use a keyboard. In other words, you
navigate the application and execute instructions by keying in text-based commands into the [command box](#3-gui-layout) provided.
- a **Graphical User Interface (GUI)** to provide you with a visually appealing and aesthetic user experience. Essentially,
the current status of the application is reflected live on-screen so what you see is what you get!

### 1.2. Purpose
(Contributed by Wen Hao)

The purpose of this document is to serve as a guide for new users on how to get started with using NUSave as well as
to provide a detailed reference for veteren users on how to use the different commands that are available within NUSave.

## 2. About the user guide
### 2.1. Symbols
(Contributed by Yu Ming)

Symbols | Meaning 
-------| ------------ 
⚠️ | This symbol indicates that there is something important for you to take note of.
📕 | This symbol indicates that there is additional information you may find useful.
✏️ | This symbol indicates that an example is provided.
❗| This symbol indicates that the parameter is required.
❕| This symbol indicates that the parameter is optional.

### 2.2. Format
(Contributed by Yu Ming)

This section shows the format of all the commands in the user guide.

Format | Meaning | Example 
-------| ------------ | ----
`lower_case/` | **Prefixes** | `n/` `p/` `t/`
`UPPER_CASE` | **Parameters** | `NAME` `THRESHOLD` `PRICE`
`[UPPER_CASE]` | **Optional parameters** | `[p/THRESHOLD]` in create budget command

> ⚠️ Prefixes **cannot have spaces**: `n /` will be an invalid prefix.
>
> 📕 Parameters can be in **any order** if they have **prefixes**.

For example, a create budget command can have `n/NAME` and `p/THRESHOLD`, you can specify them in any order:
 - `create n/Temasek Hall Student Council p/1200`, or
 - `create p/1200 n/Temasek Hall Student Council`
 
However, if a given command has any parameter **without prefix**, that given parameter **must** be the **first parameter**.

For example, a edit budget command have an `INDEX`, a `n/NAME` and a `p/THRESHOLD`. In this case, `INDEX` **must** be
the **first parameter**:
 - `edit 1 n/NUS Computing Club p/1000` is a valid command, however
 - `edit n/NUS Computing Club p/1000 1` is an invalid command

### 2.3. Syntax Highlighting
(Contributed by Song Yu)

When you type an invalid command into the `command box`, your input will be highlighted.

Color | Description | Examples
------------ | ------------- | ------
Red | Invalid input | <ul><li>An unknown command <br/> e.g. test, hello </li>  <li>Invalid command parameter(s) <br/> e.g. pt/test m/hello</li></ul>
Grey |  The default font color, or when the command is valid |

## 3. GUI Layout
(Contributed by Wen Hao)

In this section, you will be given an introduction to the layout of NUSave's Graphical User Interface (GUI)
which will help you better understand what each component that you observe on-screen represents.

There are a total of two pages that you can navigate to when using NUSave:
- Main page
- Budget page

### 3.1. Main page view
(Contributed by Wen Hao)

You will be greeted by the main page upon launching NUSave. On this page, you can see a list of
budgets that are currently stored in NUSave. Here is how the main page should look like:

![Example of main page view](images/GUILayoutScreenShots/3_1_1_mainPage.png)

Figure 3.1.1. Example of the main page view.

Below is a table containing all the components that can be found on the main page accompanied by their respective purposes:

Component | Purpose
--------- | -------
Command Box | A text field for you to enter your desired commands.
Result Display | A **scrollable** panel that displays the response messages of a command after it has been executed.
Info Box | A panel that displays the current date and time.
Title | A text field that displays the name of the application.
Budget Card | A card that represents a budget stored in NUSave. It contains the name of the budget as well as the total number of expenditures the budget contains.
List View | A **scrollable** panel that can hold multiple budget cards.

### 3.2. Budget page view
(Contributed by Wen Hao)

You will be directed to a budget page when you use the [open budget command](#611-opening-a-budget-open).
On this page, you can see a list of expenditures that are currently stored in the budget you have opened.
Here is how a budget page should look like:

![Example of budget page view](images/GUILayoutScreenShots/3_1_2_budgetPage.png)

Figure 3.1.2. Example of a budget page view.

Below is a table containing all the components that can be found on a budget page accompanied by their respective purposes:

Component | Purpose
--------- | -------
Command Box | A text field for you to enter your desired commands.
Result Display | A **scrollable** panel that displays the response messages of a command after it has been executed.
Info Box | A panel that displays the total amount you have spent so far based on the expenditures added to the budget. It will also display the threshold of the budget if it has one.
Title | A text field that displays the name of budget that is open.
Expenditure Card | A card that represents an expenditure stored in a budget. It contains the name, tags as well as cost of the expenditure.
List View | A **scrollable** panel that can hold multiple expenditure cards.

## 4. Quick start
(Contributed by Wen Hao)

If this is your first time using NUSave, follow these simple steps to jump straight into the action:

1. Ensure that you have Java `11` or above installed in your Computer.

2. Download the latest `NUSave.jar` from [here](https://github.com/AY2021S1-CS2103T-T11-4/tp/releases).

3. Copy the file to the folder you want to use as the *home folder* for NUSave.

4. Double-click the file to start the application. A GUI similar to [Figure 3.1.1](#31-main-page-view) should appear in a few seconds.

> 📕 If the application does not start after double-clicking the file, you can troubleshoot by doing the following:
>
> For Windows OS users:
> 1. Launch command prompt and navigate to the path of the home folder for NUSave.
> 2. Enter the following command: `java -jar nusave.java` as seeen in Figure 4.1 below.
>
> ![Example of launching NUSave using command prompt](images/QuickStartScreenShots/4_1_commandPrompt.png)
>
> Figure 4.1. Example of launching NUSave using command prompt.
>
> For Mac OS users:
> 1. Launch terminal and navigate to the path of the home folder for NUSave.
> 2. Enter the following command: `java -jar nusave.java` as seen in Figure 4.2 below.
>
> ![Example of launching NUSave using terminal](images/QuickStartScreenShots/4_2_terminal.png)
>
> Figure 4.2. Example of launching NUSave using terminal.

5. Congratulations, you have successfully launched NUSave!
> 📕 If you are launching the application for the first time, a set of sample data will be created for you.
> Use the [clear command](#527-clearing-budgets-clear) to purge any existing sample data.

6. Type your desired command into the command box and press the enter button to execute it. Below is a series of commands that you can try:
    - `create n/Daily Expenses`: Creates a budget with the name "Daily Expenses".
    - `open 1`: Opens the budget located at index 1.
    - `close`: Closes the budget that is open and return to the main page.
    - `help`: Shows the list of commands currently available.
    - `exit`: Exits the app.

7. Refer to the [commands section](#5-commands) below for details of each command.

## 5. Commands

### 5.1. Universal commands

#### 5.1.1. View help: `help`
(Contributed by Yu Ming)

You can use this command to **view a list of available commands**.

The help will be displayed in the results window, and it will contain a list of all available commands and their
required syntax.

>📕 You can use this command at any point of time.

Format: `help`

✏️ Example:

`help`

This will display the help instructions in the results window.

![Example of help command](images/CommandScreenShots/5_1_1_1_help.png)

Figure 5.1.1.1. Example of help command

#### 5.1.2. Exit NUSave: `exit`
(Contributed by David)

You can use this command to **exit from the application**.

When exiting NUSave, all changes made to the application will be saved.

>📕 You can use this command at any point of time.

Format: `exit`

✏️ Example
`exit`

This will exit the application. When the application is launched again, the change you made will remain.

![Example of exit command](images/CommandScreenShots/5_1_2_1_exit.png)

Figure 5.1.2.1. Example of using the exit command on both the main page and budget page.

### 5.2. Main page commands
In this section, you will find the commands that are available on the main page.

#### 5.2.1. Creating a budget: `create`
(Contributed by Yu Ming)

You can use this command to **create a new budget**.

When a new budget is created it will be stored inside NUSave, and it will be reflected immediately in the list of budgets
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

![Example of create budget command](images/CommandScreenShots/5_2_1_1_createBudget.png)

Figure 5.2.1.1. Example of create budget command

#### 5.2.2. Deleting a budget: `delete`
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

![Example of delete budget command](images/CommandScreenShots/5_2_2_1_deleteBudget.png)

Figure 5.2.1.1. Example of delete budget command
#### 5.2.3. Editing a budget: `edit`
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

![Example of edit budget command](images/CommandScreenShots/5_2_3_1_editBudget.png)

Figure 5.2.3.1. Example of edit budget command

#### 5.2.4. Finding budgets: `find`
(Contributed by Chin Hui)

You can use this command to **quickly find your budgets**.

Use this command to filter through your budgets by using keywords. NUSave will display all budgets whose title matches 
the entered keyword/key phrase. 

 > ⚠ You should not use this command if main page is empty. This is because there are no budgets created yet. 
 > You can only find a budget if there are already existing budgets!

Format: `find WORD`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
Word | ❗Required | Keyword / Keyphrase to be searched

✏️ Example:

`find Temasek Hall`
This will find all budgets with the keyphrase 'Temasek Hall' in the title of the budget.

![Example of delete budget command](images/CommandScreenShots/5_2_4_findBudget.png)
![Example of delete budget command](images/CommandScreenShots/5_2_4_findBudget2.png)

#### 5.2.5. Listing budgets: `list`
(Contributed by Chin Hui)

You can use this command to **list all budgets** in NUSave.

This command is usually used to display all budgets after searching for specific budgets using the `find` command.

>⚠️ If the `find` command has not been used, the `list` command may not have any visible effect. This is because all budgets have already been displayed.

Format: `list`

✏️ Example:

`list`

This will display all existing budgets in NUSave.

![Example of list budgets command](images/CommandScreenShots/6_2_5_1_listBudget.png)

Figure 5.2.5.1. Example of list budgets command

#### 5.2.6. Sorting budgets: `sort`
(Contributed by Yu Ming)

You can use this command to **sort your budgets**.

You can sort your budgets based on two different type of sorts:
1. Sort by created date (the latest budget created will be at the top of the main page of NUSave)

   
   ```📕 Note: If budgets are created on the same date. They will be sorted by name within themselves.```
   
2. Sort by name of the budget (budgets will be ordered in alphabetical order from a-z, case-insensitive)

>⚠️ If there are **no budgets** or there is **only one budget** in NUSave, the sort command may not have any visible effect.
> This is because there needs to be more than one budget for sorting to work. Go ahead and add in more budgets 
> to see your budgets in NUSave get sorted!

Format: `sort TYPE`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
 TYPE | ❗Required | Two different type of sorts available: `time` `name`

✏️ Example:

`sort name`

This will sort all the budgets in NUSave by their name in alphabetic order.

![Example of sort budgets command](images/CommandScreenShots/5_2_6_1_sortBudget.png)

Figure 5.2.6.1. Example of sort budgets command
#### 5.2.7. Clearing budgets: `clear`
(Contributed by Wen Hao)

You can use this command to **delete all existing budgets** in NUSave.

This command is usually used to purge the sample data that is created when you launch the application for the first time.

> ⚠️ Exercise caution when using the clear command as it is **irreversible**! <br>
> ⚠️ If there are **no budgets** in NUSave, the clear command will not have any visible effect.

Format: `clear`

✏️ Example:

`clear`

This will delete all existing budgets in NUSave.

![Example of clear budgets command](images/CommandScreenShots/5_2_7_1_clearBudget.png)
Figure 5.2.7.1. Example of clear budgets command

#### 5.2.8. Opening a budget: `open`
(Contributed by Song Yu)

You can use this command to **open a budget.**

By opening a budget, the application will display the list of expenditures belonging to that budget.

Once a budget is open, the commands that are applicable to adding, deleting or editing an expenditure will now be 
recognised as a command.

Format: `open INDEX`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
Index | ❗Required | Index of the budget to be opened

✏️ Example:

`open 1`

This will open the budget with the index "1", based on the index as shown beside the name of the budget.

![Example of open budget command](images/CommandScreenShots/5_2_8_openBudget.png)
![Example of open budget command](images/CommandScreenShots/5_2_8_openBudget2.png)

### 5.3. Budget page commands
#### 5.3.1. Adding an expenditure: `add`

#### 5.3.2. Deleting an expenditure: `delete`
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

![Example of delete expenditure command](images/CommandScreenShots/5_3_2_1_deleteExpenditure.png)

Figure 5.3.2.1. Example of delete expenditure command

#### 5.3.3. Editing an expenditure: `edit`
(Contributed by David)

You can use this command to **edit an existing expenditure**.

When an expenditure is edited the changes will be saved on NUSave, and  will be 
reflected immediately on the list of expenditures.

 > ⚠️ **You can only use this command on existing expenditures**.  

Format: `edit INDEX n/NAME p/PRICE`

Prefix | Parameters | Requirement | Comments
-------| ------------ | ------------- | ------
\- | INDEX | ❗Required | Index of the expenditure displayed on NUSave
 n/ | NAME | ❕Optional | Name of the expenditure to be edited to
 p/ | PRICE | ❕Optional | Price of the expenditure to be edited to
 
 > ⚠️ Although both NAME and PRICE fields are optional **You must have at least one of the Prefix and 
 >  corresponding Parameters present**. 

✏️ Example:

Format: `edit 1 n/Long-Sleeve p/20`

This will edit an expenditure at **index 1** to be **renamed** "Long-Sleeve" with an edited **price** of $20.

![Example of edit expenditure command](images/CommandScreenShots/5_3_3_1_editExpenditure.png)

Figure 5.3.3.1. Example of edit expenditure command
#### 5.3.4. Finding expenditures: `find`
(Contributed by Chin Hui)

You can use this command to **quickly find your expenditures**.

Use this command to filter through your expenditures by keywords.
NUSave will display all expenditures whose title contains the entered keyword/key phrase.

   ```📕 Note: Expenditures will be filtered as long as they contain the search term. The filter is case-insensitive, using upper-case or lower-case will not make a difference in the search result.```

> ⚠️ You should not use this command if budget page is empty. 
>This is because there are no expenditures created yet.

> ⚠️ If no expenditures are displayed, it means that none of the expenditures matched your search term. 
>You can use the `list` command to display all expenditures again.

Format: `find WORD`

Prefix | Parameters | Requirement | Comments
-------| ------------ | ------------- | ------
\- | Word | ❗Required | Keyword / Keyphrase to be searched

✏️ Example:

`find sock`

This will find all expenditures containing the keyword 'sock' in the current budget.

![Example of find expenditures command](images/CommandScreenShots/5_3_4_1_findExpenditure.png)

Figure 5.3.5.1. Example of find expenditures command

#### 5.3.5. Listing expenditures: `list`
(Contributed by Chin Hui)

You can use this command to **list all expenditures** in the current budget.

This command is usually used to display all expenditures after searching for specific expenditures using the `find` command.

>⚠️ If the `find` command has not been used, the `list` command may not have any visible effect. This is because all expenditures have already been displayed.

Format: list

✏️ Example:

list

This will display all existing expenditures in the current budget.

![Example of list expenditures command](images/CommandScreenShots/5_3_5_1_listExpenditure.png)

Figure 5.3.5.1. Example of list expenditures command

#### 5.3.6. Sorting expenditures: `sort`
(Contributed by Yu Ming)

You can use this command to **sort your expenditures** within a budget.

You can sort your expenditures within a budget based on two different type of sorts:
1. Sort by added date (the latest expenditure added will be at the top of that budget page in NUSave)

   
   ```📕 Note: If expenditures are created on the same date. They will be sorted by name within themselves.```
   
2. Sort by name of the expenditure (expenditures will be ordered in alphabetical order from a-z, case-insensitive)

>⚠️ If there are **no expenditures** or there is **only one expenditure** in that budget, the sort command may not 
> show any effect. This is because there needs to be more than one expenditure for sorting to work. 
> Go ahead and add in more expenditures to see your expenditures in that budget get sorted!

Format: `sort TYPE`

 Parameters | Requirement | Comments
 ------------ | ------------- | ------
 TYPE | ❗Required | Two different type of sorts available: `time` `name`

✏️ Example:

`sort time`

This will sort all the expenditures in that budget by their added date with the latest expenditure added at the top.

![Example of sort expenditures command](images/CommandScreenShots/5_3_6_1_sortExpenditure.png)

Figure 5.3.6.1. Example of sort expenditures command

#### 5.3.7. Closing a budget: `close`
(Contributed by Song Yu)

You can use this command to **close a budget.**

By closing a budget, the application switches from displaying expenditures to displaying all budgets in NUSave.

Once a budget is closed, the commands that are applicable to adding, deleting or editing a budget will now be 
recognised as a command.

Format: `close`

✏️ Example:

`close`

This will close the current budget. The list of budgets in NUSave will now be displayed.

![Example of close budget command](images/CommandScreenShots/5_3_7_closeBudget.png)
![Example of close budget command](images/CommandScreenShots/5_3_7_closeBudget2.png)

## 6. Command summary
### 6.1. Universal commands
| **Action** | **Format** | **Examples** |
|------------|------------|--------------|
Help              |`help`|\-|
Exit NUSave       |`exit`|\-|
### 6.2. Main page commands
| **Action** | **Format** | **Examples** |
|------------|------------|--------------|
Create a budget     |`create n/NAME [p/THRESHOLD]` |`create n/Daily Expenses`, <br>`create n/Project Work p/100`|
Delete a budget     |`delete INDEX`|`delete 1`|
Edit a budget     |`edit INDEX [n/NAME] [p/THRESHOLD]`|`edit 1 n/Hall Council`, <br>`edit 2 n/NUS Computing Club p/1000`|
Find budgets     |`find KEYWORD`|`find Temasek`|
List all budgets  |`list`|\-|
Sort all budgets  |`sort SORTTYPE`|`sort time`, <br>`sort name`|
Clear all budgets |`clear`|\-|
Open a budget       |`open INDEX`| `open 1`|


### 6.3. Budget page commands
| **Action** | **Format** | **Examples** |
|------------|------------|--------------|
Add an expenditure   |`add n/NAME p/PRICE [t/TAG]`|`add n/TShirt p/20`, <br>`add n/Breakfast p/10 t/food`|
Delete an expenditure|`delete INDEX`|`delete 1`|
Edit an expenditure|`edit INDEX [n/NAME] [p/PRICE]`|`edit 2 n/NikeShirt`, <br> `edit 2 p/28`|
Find expenditures|`find KEYWORD`|`find shirt`|
List all expenditures |`list`|\-|
Sort all expenditures|`sort SORTTYPE`|`sort time`, <br>`sort name`|
Close a budget      |`close`|\-|

## 7. Glossary  
(Contributed by Song Yu)

You can find the meanings of some special keywords applicable to NUSave over here.

| Term | Explanation |
|---|---|
| CLI | Short for **Command Line Interface**. CLI-based Applications (i.e. NUSave) focuses on processing commands in the form of text entered from the keyboard. |
| GUI | Short for **Graphical User Interface**. GUIs work as the communication channel between the program and the user. Users interact with NUSave through the GUI, on their devices. |
| OS | The underlying computer program that allows users to interact with a computer. It manages the hardware components and software resources of a computer for the user.|
| Command Prompt (Windows OS) | A CLI application proprietary to Windows OS devices, where users can run commands on a Windows device by entering typed commands. |
| Terminal (Mac OS) | A CLI application proprietary to Mac OS devices, where users can run commands on a Mac device by entering typed commands. |
| Expenditure | Refers to a single item to be recorded in NUSave.|
| Budget | Refers to how NUSave stores related expenditures under one group. A budget can also hold additional information about this list of expenditures, such as the target limit of what is to be spent (i.e. threshold).  |
| Main Page | Refers to the page that displays the list of budgets that is stored in NUSave.|
| Budget Page | Refers to the page that displays the list of expenditures belonging in a specific budget that is stored in NUSave.|
| Threshold | Refers to the target limit that can be spent in that budget. |

## 8. FAQ
**Q**: How do I transfer my data to another computer?

**A**: Install the application on another computer and overwrite the empty data file it creates with the .json file that contains the data of your previous NUSave folder.

**Q**: Where is my save data stored?

**A**: They are stored in the `data` folder where the NUSave application is found.

**Q**: How do I make backups of my data in NUSave?

**A**: You can copy and paste the `data` folder located in the NUSave home folder to somewhere safe and easy to remember. To restore the backup, copy the entire folder back into the same home folder and overwrite the existing folder.

**Q**: How do I delete all my data in NUSave?

**A**: You can delete the `data` folder in the NUSave home folder.

**Q**: Will my data be compromised?

**A**: Don't worry! All data in NUSave is stored on your local device and will not be transferred over the web.

**Q**: Does this application require an internet connection to run?

**A**: NUSave does not access any web services and can be run completely offline.

