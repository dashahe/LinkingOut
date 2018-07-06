package com.sao.service.impl

import com.sao.domain.model.User
import com.sao.domain.model.UserDetail
import com.sao.domain.repository.UserDetailRepository
import com.sao.domain.repository.UserRepository
import com.sao.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    internal var userRepository: UserRepository? = null
    internal var userDetailRepository : UserDetailRepository? = null



    @Autowired
    constructor(repository: UserRepository, userDetailRepository: UserDetailRepository){
        this.userRepository = repository
        this.userDetailRepository = userDetailRepository
    }
    override fun findByUsername(userName: String): User {
        val iterable = userRepository!!.findAll()
        var userResult = User()
        for(user in iterable){
            if(user.username.equals(userName)){
                userResult = user
                break
            }
        }
        return userResult

    }

    override fun findByUid(uid: Long) : User {
        return    userRepository!!.findById(uid).get()
    }

    override fun findAllUsers():Iterable<User> {
        return userRepository!!.findAll()
    }

    //todo test if the uid are same
    override fun insert(user: User) {
        userRepository!!.save(user)
        var userDetail = UserDetail()
        userDetail.uid = user.uid

        userDetail.init()
        userDetailRepository!!.save(userDetail)
    }

    fun UserDetail.init(){

        this.cid = null
        this.email = null
        this.image = "https://static.zhihu.com/heifetz/guide-cover-2.4c5018526e42872a056b.jpg"
        this.hobby = null
        this.major = null
    }

    override fun findByTel(tel: String): User {
        var iterable = userRepository!!.findAll()
        var userR = User()
        for(user in iterable){
            if(user.tel.equals(tel)){
                userR = user
            }
        }
        return userR
    }

    override fun existByTel(tel: String): Boolean {
        var flag = false
        val iterable = userRepository!!.findAll()
        for(user in iterable){
            if(user.tel.equals(tel)){
                flag = true
            }
        }
        return flag
    }
}
