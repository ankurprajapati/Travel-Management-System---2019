## project-teamobject
project-teamobject created by GitHub Classroom

# Travel Management System
This project will help travel agencies especially to those who are having a lot of information and they want to store it & extract it from the database. 

## Objective
The objective is to create a model that can be used for travel management. The objective of this project is to provide range of services to both travel agents and customers. Customers can get information regarding packages and book the flights. Also, agents can create and manage package information.With better GUI , this will provide ease of management. 

### Targeted audience:
1. Travel Agents 
2. Customers

### Technical considerations:
JRE, JDK, JavaFX, Database: MYSQL and SQLyog

### Deliverables:
JavaApplication with GUI Form

### Timeline (Task and schedule):
a) Week1: Database Design
b) Week2: 1st Feature from all members
c) Week3: 2nd Feature from all members
d) Week4: 3rd Feature from all members
e) Week5: Testing of Application
f) Week6: Documentation
g) Week7: PPT and Final Deliverables

## List of Features: 
1. Registration (With Verification):
* Input: User Details
* Output: Pop-Up message
* Logic/Description: Verify the details, and insert in database.

2. Login/Logout:
* Input: User Name and Password
* Output: Direct User to next page (either home or new page)
* Logic/Description: Verify user name and password for login and logout

3. Package Creation:
* Input: Package details
* Output: Show Package to User
* Logic/Description: Store details to Database (Insert details to package table)

4. Booking Process:
* Input: User and Package details
* Output: Pop-Up message for booking successful /unsuccessful
* Logic/Description: Store input in booking process table and reduce available package by one. 

5. Cancellation Process:
* Input: User and Package details
* Output: Pop-Up message for successful/unsuccessful cancellation 
* Logic/Description: Remove booking details from booking table and increase that available package by one.

6. Add Payment Method:
* Input: User details for payment Method
* Output: Show added payment method to user
* Logic/Description: Validate payment information of user and add payment method.

7. Invoice:
* Input: Get selected package details from MyList/Cart
* Output: Invoice Generation and show it to user
* Logic/Description: Generate invoice for user.

8. Survey:
* Input: User choice
* Output: Show survey details to admin
* Logic/Description: Store user choice to survey table.

9. Promo Code:
* Input: String of Characters
* Output: Give discount associated with used promo code and display final Price
* Logic/Description: Check if user input for promoCode matches with the existing Promo code, if Yes Apply Discount.

10. World Travel News:
* Logic/Description: Get latest news related to travelling for User such that they can get latest news. We have used rssfeed for that.

11. About US:
* Show details of Team members.

##Important Files:
1. GenericDAO.java:
   * add(Class cls, Object t): To Insert new data
   * update(Class cls, Object t): To update available data 
   * save(): Updates if data exists otherwise it will insert new data
   * Delete(Class cls, Object t): To delete data from databse table
   * objects(): Gives result of SELECT query with three diffrent WHERE conditions: AND, OR and SIMPLE query
   * first(Class clazz, LIST &lt;Condition&gt; conditions): Gives first object of SELECT query 
   
### Authors
1. Alex Christian
2. Ankur Prajapati
3. Falak Pandya
4. Gargi Patel

See also the list of contributors who participated in this project.

### Inspiration
Hibernate
