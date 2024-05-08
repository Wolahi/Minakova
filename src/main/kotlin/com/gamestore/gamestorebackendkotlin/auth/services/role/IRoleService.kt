package com.gamestore.gamestorebackendkotlin.auth.services.role
import com.gamestore.gamestorebackendkotlin.auth.models.roles.RoleEntity
import com.gamestore.gamestorebackendkotlin.auth.models.roles.table.RolesEnum
import com.gamestore.gamestorebackendkotlin.extensions.Result

interface IRoleService {
    fun generateRoles(): Result<String>

    fun findByRole(role: RolesEnum): Result<RoleEntity?>
}