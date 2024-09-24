Task Management System

A simple web application designed to help users create, track, and manage tasks efficiently. The system allows users to set deadlines for tasks and sort them based on their due dates, ensuring better organization and time management.

Features :-
	• Create, update, and delete tasks
	• Set deadlines for tasks
	• View all tasks
	• Sort tasks by:
		○ Due date (ascending/descending)
		○ Task status (completed, pending)
	• Filter tasks by status (e.g., Completed, Pending)
	• RESTful API for task management
	
Tech Stack:-
	• Backend: Spring Boot (Java)
	• Frontend: ReactJS (Optional if you have a frontend)
	• Database: MySQL (or any other relational database)
	• Build Tool: Maven
	• Version Control: Git
	
Installation
Prerequisites
	• Java 21 or higher
	• Maven
	• MySQL (or your preferred relational database)
	• Git

API Endpoints:-
The Task Management System provides REST API endpoints for managing tasks:
Method	     Endpoint	                                 Description
GET	         /api/tasks	                            Retrieve all tasks
GET	         /api/tasks/{id}	                      Retrieve a task by ID
GET	         /api/tasks/status/{status}	            Retrieve tasks by status
POST	       /api/tasks	                            Create a new task
PUT	         /api/tasks/{id}	                      Update an existing task
DELETE	     /api/tasks/{id}	                      Delete a task by ID

Future Enhancements
	• User authentication and authorization (e.g., register, login)
	• Prioritize tasks based on importance or urgency
	• Add task reminders/notifications
	• Integration with external calendars (e.g., Google Calendar)


