package com.slimesapphire.proxy.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*


@Entity
@Table(name = "users")
class User : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0
    private lateinit var username: String
    private lateinit var password: String
    private var active: Boolean = false

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
    @Enumerated(EnumType.STRING)
    private lateinit var roles: MutableSet<Role>

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return getRoles()
    }

    override fun isEnabled(): Boolean {
        return isActive()
    }

    override fun getUsername(): String {
        return this.username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    fun getId(): Long {
        return this.id
    }

    fun isActive(): Boolean {
        return this.active
    }

    fun getRoles(): MutableSet<Role> {
        return this.roles
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun setActive(active: Boolean) {
        this.active = active
    }

    fun setRoles(roles: MutableSet<Role>) {
        this.roles = roles
    }
}