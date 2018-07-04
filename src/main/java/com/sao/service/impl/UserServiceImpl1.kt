package com.sao.service.impl

import com.sao.domain.User
import com.sao.domain.UserRepository
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    internal var repository: UserRepository? = null

    @Autowired
    constructor(repository: UserRepository){
        this.repository = repository
    }
    override fun findByUsername(userName: String): User {
        val iterable = repository!!.findAll()
        var userResult = User()
        for(user in iterable){
            if(user.username.equals(userName)){
                userResult = user
                break
            }
        }
        return userResult

    }

    override fun findByUid(uid: Long) :User{
        return    repository!!.findById(uid).get()
    }

    override fun findAllUsers():Iterable<User> {
        return repository!!.findAll()
    }

    override fun insert(user: User) {
        repository!!.save(user)
    }
}
