QuickChat Part 3: Data Management & Reporting
Hey there! I just finished Part 3 of our QuickChat app, and I'm really excited about how it turned out. Let me walk you through what we built.

## What We Actually Built
Remember how in Parts 1 and 2 we had the basic messaging system working? Well, Part 3 is all about making that data actually useful and manageable.
The big idea was: "Okay, we can send messages, but what if we want to actually DO something with all those messages we're sending?"

## The Cool New Stuff We Added
 1. We Organized Everything into Arrays,Instead of just having messages floating around, we now have them properly organized in different "buckets":
- Sent Messages** - All the messages that actually went through
- Stored Messages** - Ones you saved for later  
- Disregarded Messages** - Ones you decided not to send
- Message Hashes** - Those unique codes we generate for each message
- Message IDs** - The tracking numbers for each message
It's like having proper filing cabinets instead of just throwing papers on a desk.

 2. We Made Searching Actually Useful
    You know how annoying it is when you can't find that one message you sent last week? We fixed that. Now you can:
- Search by phone number** to see EVERY message you've ever sent to someone
- Search by message ID** to find one specific message instantly
- Find your longest message** (because sometimes you just want to know)
- Delete messages** using their hash code when you need to clean things up

3. We Added Proper Reporting
   Instead of just showing messages one by one, we can now generate full reports that show:
- Who sent what to whom
- All the message details in one place
- The complete history of your messaging activity

## How It Actually Works
When you log in now, you'll see a new "Data Management" option in the menu. Click that, and you get a whole new set of tools:

1. See all your message relationships** - who you're talking to most
2. Find that super long message** you wrote last Tuesday
3. Track down a specific message** by its ID
4. See every message to your friend** (even across different days)
5. Clean up old messages** you don't need anymore
6. Get a full report** of everything you've sent

## The Test Data We're Using
To make sure everything works, I loaded in 5 sample messages:
1. A simple "Did you get the cake?" message that was sent
2. A frustrated "Where are you? You're late!" message that got stored for later
3. A cheerful "Yohoooo, I'm at your gate" that got disregarded
4. A "It's dinner time!" that was sent
5. An "I'm leaving without you" that got stored
This lets us test all the different scenarios without having to type everything out each time.
## What Took the Most Work
The tricky part was making sure all these new features worked smoothly with the existing Parts 1 and 2. We didn't break anything that was already working - the registration, login, and basic messaging all still work exactly like before.The arrays were probably the most important addition. They're like the backbone that makes all the new search and reporting features possible.
## Why This Actually Matters
Before Part 3, our app could send messages, but it was like having a phone that could only make calls but couldn't show you your call history or contacts. Now we have the full package - you can not only communicate but also manage and understand your communication patterns.It's the difference between just throwing data around and actually being able to work with that data meaningfully.
## Try It Out!
The coolest part is seeing it all come together. When you use the search features and they actually find what you're looking for, or when you generate a report and see your entire messaging history laid out clearly - that's when you realize how much more useful the app has become.We went from a simple "send message" tool to a proper communication management system. Pretty neat, right?

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

