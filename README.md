<h1>springboot-cv</h1>



App to be consumed easily. It's a free dormant service, so it might need a wake up using base url

<h5>Base URL:<h5>

https://spring-cv.herokuapp.com



<h5>Currrent services:<h5>

GET https://spring-cv.herokuapp.com/cv

POST https://spring-cv.herokuapp.com/login



<h5>Login:<h5>

https://spring-cv.herokuapp.com/login

consumes:

```
{
"username": admin,
"password": password
}
```

returns:

```
Authorization
```



<h5>CV:<h5>

https://spring-cv.herokuapp.com/cv

consumes:

```
{}
```

returns:

```
CV object
```

