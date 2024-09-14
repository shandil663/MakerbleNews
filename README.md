Makerble News App:
The Makerble News App is an Android application that allows users to browse top news headlines and bookmark articles for later reading.
The app fetches news from a public API and stores bookmarks locally using Room Database.

Features:
Fetch top news headlines
Bookmark favorite articles
View bookmarked articles offline
View article details with full description
Delete articles from bookmarks

Tech Stack:
Language: Kotlin
Network: Retrofit
Database: Room
UI: JXML, Jetpack ViewBinding, RecyclerView, LiveData
Concurrency: Coroutines


Libraries Used:
Retrofit - For making network requests to fetch news articles from the API.
Room - For local storage of bookmarked articles.
Coroutines - For managing background tasks like network calls and database operations.
Glide - For efficient image loading and caching.
Gson - For parsing JSON responses from the API.
Jetpack ViewBinding - For easier view handling in Fragments and Activities.
Lifecycle Components (LiveData, ViewModel) - For reactive UI and data management.

API:
The app uses the NewsAPI to fetch the latest top headlines. You can find more about the API documentation and how to get your own API key here.

Screenshots:

![Screenshot_2024-09-14-17-49-48-541_sahil healers data makerblenews](https://github.com/user-attachments/assets/1755a0f1-b729-49b9-a667-ebfdae5f0644)

![Screenshot_2024-09-14-17-49-56-450_sahil healers data makerblenews](https://github.com/user-attachments/assets/db415381-5b13-4c7d-b404-72be13ec5bf2)

![Screenshot_2024-09-14-17-50-06-971_sahil healers data makerblenews](https://github.com/user-attachments/assets/ad1da51f-eea0-4af4-8677-ee34d5666178)

![Screenshot_2024-09-14-17-50-21-156_sahil healers data makerblenews](https://github.com/user-attachments/assets/f1aae76e-22f6-4125-a3d8-6250ec883db6)

![Screenshot_2024-09-14-17-50-28-575_sahil healers data makerblenews](https://github.com/user-attachments/assets/268656c0-54f5-4a41-ab6c-27228d11234c)

![Screenshot_2024-09-14-17-50-36-475_sahil healers data makerblenews](https://github.com/user-attachments/assets/632584bb-0d72-4486-a814-d81e1f3a4a64)

![Screenshot_2024-09-14-17-50-48-813_sahil healers data makerblenews](https://github.com/user-attachments/assets/6b891693-d357-4b94-a1fe-531bc53db946)

![Screenshot_2024-09-14-17-50-56-419_sahil healers data makerblenews](https://github.com/user-attachments/assets/0cc5ce73-5112-41b2-b092-0f66ae5655b2)

![Screenshot_2024-09-14-17-51-01-798_sahil healers data makerblenews](https://github.com/user-attachments/assets/7d775a6c-e544-415f-9f80-9c93234d6a03)

