package com.slimesapphire.proxy.domain

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    USER {
        override fun getAuthority(): String {
            return this.name
        }
    },
    ADMINISTRATOR {
        @Override
        override fun getAuthority(): String {
            return this.name
        }
    }
}