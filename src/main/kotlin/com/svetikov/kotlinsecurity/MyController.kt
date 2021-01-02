package com.svetikov.kotlinsecurity

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:3000","http://192.168.0.103:3000"])

class MyController {

    @GetMapping("/greeting")
    fun myTest():String = "Hello my first message from kotlin spring and react"

    @GetMapping("/greeting2")
    fun mySecondMessage():String = "This is second message from server"

    @GetMapping("/file/{text}")
    fun myData(@PathVariable text:String):String
    = "Hi , $text"

    @PostMapping("/add")
    fun myUser(@RequestBody user:User):User
    {println(user)
    return user
    }
}