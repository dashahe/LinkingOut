package com.sao.service

interface FollowSerice {

    /**
     * check if both users exist
     */
    fun ifUserExist(fid:Long , bfid: Long) : Boolean
    fun createFollower(fid:Long, bfid:Long);
}