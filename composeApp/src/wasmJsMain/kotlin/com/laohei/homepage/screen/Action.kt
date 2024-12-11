package com.laohei.homepage.screen

enum class SocialType(val url: String) {
    BLOG(url = "https://github.io/OldBlack/starter.html"),
    GITHUB(url = "https://github.com/laohei7"),
    BILI(url = ""),
    QQ(url = ""),
    WECHAT(url = ""),
    EMAIL(url = "laohei7@outlook.com")
}

sealed class Action {
    data class SocialAction(val socialType: SocialType) : Action()
}