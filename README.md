# Grammati application

## Docs
[http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

[GET /quiz/a](http://localhost:8080/quiz/a)

## Steps to achieve MVC

1) Generate application stat boots up
2) Email Subscription
    2.1) Send Email with confirmation of email
    2.2) When user clicks on confirmation email is added to database
    
## Views
1. Subscribe for email
2. Question view
3. Error
4. Login page
5. Registering

## Use Cases

1. Each day app sends email to all users with link to a new daily question set, generated specifically for user
2. User receives email with his daily question set - then it clicks and question set shows.

### Use case 1
App loads all users, for each user it picks 5 questions, stores the set id, and sends it via email.

### Use case 2
User clicks on the link provided in email.
User is redirected to daily question page
User is printed all questions on one page
User answers all question
Clicks on Ok or Submit
Result page is printed
