package com.example.xiaoyihaung.wish.data

data class DBInfo(
        var version: Int,
        var create_time: Long,
        var update_time: Long = 0
)