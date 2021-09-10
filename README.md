# Android-Projects


+-------------------------------------------------------------------------------------------------------------+
Day Friday : 27-Aug-2021

	--> Project : Zero Cross Game
			--> Added project here
			--> In this project i have created a zero cross game which we all are playing since childhood
			--> Used Design protion : Relative Layour [ Grid Layout [3,3] - for game area ,
					 Linear vertical Layout - for showing winning or draw message and play again button ]
			-->Activity - MainActivity - dropIn() method - to add animation on every touch in play area and
											full functioning of game.
									   - playAgain() method - to reset everything .	

git commit -m "Zero Cross game is created the first game of my Android Learning"
+-------------------------------------------------------------------------------------------------------------+
Day Wednesday : 1-Sep-2021

	--> Project : Zero Cross Game
		--> Added sound to win ,tie and on zero and cross
		--> but it is not working properly for now need to check

	--> Project : Tables app
		--> In this app i have created a seek bar ( progress bar ) , its on change listener , 
			having max and min value of 20 and 1  for the table between 1 to 20
		--> Also created a list view to show the tables in the list
		--> on changing progress bar the value of the seekbar passed to table function to find
			specific value table and show it in the list view.

git commit -m "Zero cross : Sound added but not working properly | Tables : App for creating tables with the 
progress bar and list view to show them "

+-----------------------------------------------------------------------------------------------------------------------+
Day Wednesday : 3-Sep-2021

	--> Project : Timer App
		--> Created timer app which sets timer with seek bar having start and stop button
		--> when timer finished a boom sound played and image changed.
		--> in between we can stop timer then again reset the timer to a specific time

git commit -m "Created timer app with sound and image change function when it reaches zero"
+-----------------------------------------------------------------------------------------------------------------------+
Day Friday : 10-Sep-2021

	--> Project : Download Image
		--> In this project i have used Async task
		--> create a image class in the main activity which extends Async tasks
		--> And Async task < String , Void , Bitmap > accepts three generic types 
		--> in which first is the parameter which we supply on time of executing and second is handler function
			third is return type from doInBackground function of AsyncTask.
		--> For calling this tasks we need to create object of image class then execute them by 
			obj.execute().get() - it gets the return element.
		--> In this project we supplied url of the image and return the bitmap from async task
		--> and in image view we will set the bitmap.

git commit -m "Download image project added which download image from url and show it in image view";

+-----------------------------------------------------------------------------------------------------------------------+