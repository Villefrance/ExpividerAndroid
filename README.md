# ExpividerAndroid
This project contains the project developed by Kennet Vangsgaard (kevan14) and Emil Villefrance (emvil15) for the course **Android Programming** during the Spring semester 2018 at SDU.

## Background
The Android app is using an API we developed ourselves. The basic idea is, that Employers can make posts where they search for students to either have an internship or apprenticeship in their company. Students can then make applications to these posts.
This API is hosted on a free tier at [Heroku](https://www.heroku.com), which means that *the first request to it within a 30-minute window, might take 30-60 seconds*. Subsequent requests should be handled at normal speeds.

## How to Run the App
1. Git clone the repository to your computer.
2. Open the project in Android Studio.
3. Run the app in a phone-sized virtual device (like the Nexus X5).
4. When the app loads in the emulator, press the Login-button (the credentials should already be filled out for you).
5. **IMPORTANT! Wait for up to 60 seconds, since the API being contacted by the app may be sleeping as described above!**
6. You are now logged in as an Employer and the app should show current posts on the API in a list. You now have 2 options:
   - Create a new post by clicking the "Create Post"-button at the bottom and fill in the name of the post, a description and whether you are creating a post for an internship or an apprentice. Confirm by clicking "Create Post" again.
   - Click any of the posts in the list, which will take you to another screen showing the applications currently made to that post (if any).
