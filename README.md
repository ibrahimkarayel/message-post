# Message Posts API

##Use cases
User loggedIn with Gmail
User can see all posts 
User can add posts 
User can edit/delete his/her post
User can add comment any post
User can see his/her personal details and a char about posts


### Running the Project

1. With spring boot: 
    `mvn spring-boot:run`
  
2.  Run jar file 
    ` mvn clean package`   cd target  `java -jar message-posts`

3. or run directly  `com.jowl.jowl.MsgApplication`

### Rest API end Points

* Sample API end points: 
Check : `com.jowl.jowl.controllers.PostController for all calls`
base uri `http://localhost:8080/api/posts` 

##### After running AP Go to UI application and follow the README.md


## Improvements

1. Api calls are not secure: 
    can be configured with firebase token and more secured
2. Getting all post: 
    Pagination can be used and imroved 
3. Comments:
    coments cannot be edited or deleted this fature can be added 
3. Chart:
    a simple chart emebeded this can me modified on altas db more information can be added 
4.  UI:
   Ui also can be more user friendly 


#### Watch Courses
[![course video](https://img.youtube.com/vi/8FBsvpHUsxA)](https://youtu.be/8FBsvpHUsxA)


[ibrahim karayel](https://www.linkedin.com/in/ibrahimkarayel/)



