# Stylish

### *Wanna get latest & popular fashion trends?*
### *Sick of trying all the clothes to find best color match?*
### - *Try 'Stylish'.*
<img src="https://github.com/world2222/Stylish/assets/52661837/cf9e499b-d0c5-4931-9f76-8c1f1631a948)" width="250px">

<br>
<br>
<br>
<br>

# Fashion Magazine
![ezgif com-video-to-gif (2)](https://github.com/world2222/Stylish/assets/52661837/8a179a72-0fd5-478b-9f34-c6383d5805b3)

### Not just like a shopping app, but more like a fashion magazine.
* Focusing on the look, not the price.
* Update the fashion items following the latest and popular trends.

<br>

# Explore deeper
![item detail](https://github.com/world2222/Stylish/assets/52661837/4de4cf97-9f35-4533-a27d-9400c7c90333)

### Check details, search deeper and wider.
By clicking each fashion item, users can check...
* Brand name
* Additional images
* Item name
* Price (current & original)
* Product details
* About the Brand
* Model's size & fit
* Precautions
* Textures

<br>

# The unique feature of *Stylish*
![createscreen](https://github.com/world2222/Stylish/assets/52661837/6c49f0c8-55b6-48bf-a901-e0a4ecfef95f)

### Don't need to try the clothes on to check the color match.
#### It's easy to imagine the look of the clothes but not the color.
Even if the clothes look awesome, if the color doesn't match, it just becomes an iffy fashion item.  
But to check whether the color matches well trying all the clothes on, it's hard.  
#### So, here's the solution. Try *Stylish*.

<br>

# Powerful search function
![search by category](https://github.com/world2222/Stylish/assets/52661837/6dea6d17-aa77-4790-907c-f0970c92f2f9)
![search by term](https://github.com/world2222/Stylish/assets/52661837/d813207c-f3de-4fed-85e5-7f54593991ac)

### Searh by Category & Search by Keyword
*Stylish* offers the users to search the fashion items in a various ways.  
You can search it following the categories or just search it with keywords.  
Also, you can put some options when searching with keywords.  
You can choose whether to sort it in ascending order or descending order or choose to show the recommended or fresh ones first.

<br>

# Your own wish list
![wish list](https://github.com/world2222/Stylish/assets/52661837/4346c4c0-2871-404c-afc2-af9aa9fe41c3)

### Explore around, and fill your wish list
We offer the wish list function to help the users with choosing fashion items.  
By clicking on the bookmark icon of the items from home screen, search screen, and detailed screen, users can save their favorites into their wish list.  
Also, if the users click on this icon once again, the bookmark icon will be changed from the filled one to the outlined one, and the corresponding fashion item will be removed from your wish list.

<br>

# API info
### Asos api from rapidapi.com -> https://rapidapi.com/DataCrawler/api/asos10/
*Stylish* uses the api from the rapidapi's api hub. To try this app, please get your own API_KEY and put it in AppModule file.
```kotlin
fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(DefaultRequest) {
                header("X-RapidAPI-Key", "PUT YOUR API KEY HERE")
                header("X-RapidAPI-Host", "asos10.p.rapidapi.com")
            }
        }
    }
```

<br>

# Try *Stylish*, search and create your own fashion.
### Thank you for your visit, have a great day!
