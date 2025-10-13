#POE-Part-2-Programming 
A Java messaging application with user authentication and message management. Users can send, store, and view messages with validation and security features.

#Features
User Login - Secure authentication required
Send Messages - With recipient validation plus 27 format
Message Actions - Send, Store, or Disregard options
View History - See all sent messages with details
Message Validation - 250 character limit and phone number validation

#Tech Stack
Java Swing - GUI interface
JUnit - Testing framework
GitHub Actions - CI CD pipeline

#Requirements Met
Login protected messaging
Message creation with validation
Message hash generation
Recent messages display
Comprehensive unit tests

#Usage
Register with username must contain underscore
Login with credentials
Choose number of messages to send
Enter recipient plus 27 format and message
Select action Send, Store, or Disregard
View sent messages in history


# POE-Part-1-Programming
This is a project about a Chat App, where the first part we create the phase of registration and login phase of the chatapp.


# ChatAppPOE – Registration & Login System  

Java application that allows a user to (register) with a (username, password, and South African phone number), then {log in} with their credentials.  

This project was developed for a Practical Object-Oriented Programming (POE) task and follows OOP principles with validation and JUnit tests.  
 Features
- Registration Form
  - Username must contain `_` and be at least 5 characters long.
  - Password must be at least 8 characters and include:
    - Uppercase letter  
    - Lowercase letter  
    - Number  
    - Special character  
  - Phone number must follow **South African format (`+27XXXXXXXXX`).  

- Login Form
  - Validates entered username and password against registered credentials.
  - Shows success or error messages via dialogs.  

- Validation Logic
  - Centralized in reusable methods:  
    - `checkUsername(String username)`  
    - `checkPasswordComplexity(String password)`  
    - `checkPhoneNumber(String phone)`  
    - `validateInput(String username, String password, String phone)`  

- JUnit Tests
  - Full test coverage for validation methods.  
  - Tests both valid and invalid cases.  

